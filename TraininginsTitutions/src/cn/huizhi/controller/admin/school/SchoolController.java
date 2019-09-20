package cn.huizhi.controller.admin.school;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.ReuseExecutor;
import org.aspectj.weaver.ast.And;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.Reserveschool;
import cn.huizhi.pojo.SchoolAccount;
import cn.huizhi.pojo.Student;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;
import cn.huizhi.pojo.Class;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
import cn.huizhi.service.ReserveschoolService;
import cn.huizhi.service.StudentService;
import cn.huizhi.service.TeacherService;
import cn.huizhi.service.UserService;

@Controller
public class SchoolController {
	/**
	 * 学校账户信息
	 */
	@Resource
	OrderService orderService;

	@Resource
	UserService userService;

	@Resource
	DepartmentOfPediatricsService departmentOfPediatricsService;

	@Resource
	FeeCategoryService feeCategoryService;

	@Resource
	PaymentMethodService paymentMethodService;

	@Resource
	ClassService classService;

	@Resource
	ExpenditureitemsService expenditureitemsService;

	@Resource
	StudentService studentService;

	@Resource
	TeacherService teacherService;

	ReserveschoolService reserveschoolService;

	@RequestMapping("expenditureOrder.html")
	@ResponseBody
	public String expenditureOrder(Order order) {
		List<Order> expenditureOrderList = orderService.findExpenOrderList(order);
		if (expenditureOrderList.size() > 0) {
			return JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm",
					SerializerFeature.WriteDateUseDateFormat);
		}
		return "";
	}

	@RequestMapping("incomeOrder.html")
	@ResponseBody
	public Map<String, Object> incomeOrder(Order order) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<Order> expenditureOrderList = orderService.findOrderListBySchool(order);
		// 收费项目主键列
		List<String[]> feeIdArray = new ArrayList<String[]>();

		List<String> feeNameArray = new ArrayList<String>();
		// 学校收费项目
		List<FeeCategory> feeCategories = feeCategoryService.selectFeeCategory(order.getSchoolId());

		for (Order order2 : expenditureOrderList) {
			String feeName = "";
			// 截取收费项目主键
			if (order2.getFeecateId() == null || order2.getFeecateId() == "") {
				continue;
			}
			String[] arr = order2.getFeecateId().split(",");
			// 循环收费项目获取名称
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < feeCategories.size(); j++) {
					if (feeCategories.get(j).getChargeTypeId() == Integer.valueOf(arr[i])) {
						feeName += feeCategories.get(j).getChargeTypeName();
						if (arr.length > i + 1) {
							feeName += "/";
						}
						break;
					} else {
						continue;
					}
				}
			}
			feeNameArray.add(feeName);
		}

		jsonMap.put("expenditureOrderList", JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm:ss",
				SerializerFeature.WriteDateUseDateFormat));
		jsonMap.put("feeNameArray", feeNameArray);
		return jsonMap;

	}

	/**
	 * 支出项目
	 * 
	 * @return
	 */
	@RequestMapping("AdminIncomeitems.html")
	public String AdminIncomeitems() {
		return "admin/income/selectSchoolIncomeInfo";
	}

	/**
	 * 收入项目
	 * 
	 * @return
	 */
	@RequestMapping("AdminExpenditureitemses.html")
	public String AdminExpenditureitemses() {
		return "admin/expen/selectSchoolExpenInfo";
	}

	@RequestMapping("selectSchoolIncomeInfo.html")
	public String selectSchoolIncomeInfo(Integer schoolId, String schoolName, HttpSession session) {

		List<FeeCategory> feeCategorieList = feeCategoryService.selectFeeCategory(schoolId);

		session.setAttribute("feeCategorieList", feeCategorieList);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);

		return "admin/income/Incomeitems";
	}

	@RequestMapping("selectSchoolExpenInfo.html")
	public String selectSchoolExpenInfo(String schoolId, String schoolName, HttpSession session) {

		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		List<Expenditureitems> expenditureitemList = expenditureitemsService.selectExpenditureitems(schoolId);
		session.setAttribute("expenditureitemList", expenditureitemList);

		return "admin/expen/Expenditureitemses";
	}

	/**
	 * 选择学校查看教师信息
	 * 
	 * @return
	 */
	@RequestMapping("selectSchoolTeacherInfo.html")
	public String selectSchoolTeacherInfo() {
		return "admin/school/selectSchoolTeacherInfo";
	}

	/**
	 * 返回操作员页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("operator.html")
	public String operator(HttpSession session) {
		List<User> findUserAllByAdmin = userService.findListAll("");
		session.setAttribute("findUserAllByAdmin", findUserAllByAdmin);
		return "admin/basicSettings/operator";
	}

	/**
	 * 查询选择的操作员信息
	 * 
	 * @param uId
	 * @return
	 */
	@RequestMapping("selectUser.html")
	@ResponseBody
	public String selectUser(String uId) {
		List<User> operatorUser = userService.findListAll(uId);
		if (operatorUser.size() > 0) {
			return JSON.toJSONString(operatorUser.get(0));
		}
		return "";
	}

	/**
	 * 修改操作员信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser.html")
	@ResponseBody
	public Map<String, String> updateUser(User user) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		if (userService.modifyUser(user) > 0) {
			jsonMap.put("update", "1");
		} else {
			jsonMap.put("update", "0");

		}
		return jsonMap;
	}

	/**
	 * 删除操作员
	 * 
	 * @param uId
	 * @return
	 */
	@RequestMapping("delUser.html")
	@ResponseBody
	public Map<String, String> delUser(Integer uId) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		if (userService.delUser(uId) > 0) {
			jsonMap.put("del", "1");
		} else {
			jsonMap.put("del", "0");
		}
		return jsonMap;
	}

	/**
	 * 修改教师
	 * 
	 * @return
	 */
	@RequestMapping("selectSchoolTeacherUpdate.html")
	public String selectSchoolTeacherUpdate() {
		return "admin/school/selectSchoolTeacherUpdate";
	}

	@RequestMapping("selectOrderSchoolInfo.html")
	public String selectOrderSchoolInfo() {
		return "admin/orderSchool/selectOrderSchoolInfo";
	}

	/**
	 * 学校订单
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("schoolOrderInfo.html")
	public String schoolOrderInfo(Order order, String schoolName, HttpSession session) {
		/**
		 * 查询数据
		 */
		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);

		// 课程类型
		List<DepartmentOfPediatrics> departmentOfPediatricsList = departmentOfPediatricsService
				.findDepartmentOfPediatrics(order.getSchoolId());

		List<Expenditureitems> expenditureitemList = expenditureitemsService
				.selectExpenditureitems(String.valueOf(order.getSchoolId()));

		// 账户类型信息
		List<PaymentMethod> payMentList = paymentMethodService.selectPaymentMethod();
		// 收入项目类型
		List<FeeCategory> feeCategoryList = feeCategoryService.selectFeeCategory(order.getSchoolId());

		List<Class> classBySchooList = classService.findChildrenescClasses(String.valueOf(order.getSchoolId()));
		/**
		 * 共支出
		 */
		Double schoolExPenSum = 0.0;
		/**
		 * 共收入
		 */
		Double schoolFeeceat = 0.0;
		if (orderListBySchool.size() > 0) {
			for (Order order2 : orderListBySchool) {
				if (order2.getIdentification() == 0) {
					schoolFeeceat += order2.getDpMoney();
				} else if (order2.getIdentification() == 1) {
					schoolExPenSum += order2.getFeecategoryMoney();
				}
			}
		}
		// 总收入，总支出
		session.setAttribute("schoolExPenSum", schoolExPenSum);
		session.setAttribute("schoolFeeceat", schoolFeeceat);
		session.setAttribute("schoolId", order.getSchoolId());

		// 查询添加
		session.setAttribute("departmentOfPediatricsList", departmentOfPediatricsList);
		session.setAttribute("classBySchooList", classBySchooList);
		session.setAttribute("payMentList", payMentList);
		session.setAttribute("feeCategoryList", feeCategoryList);
		session.setAttribute("orderListBySchool", orderListBySchool);
		session.setAttribute("expenditureitemList", expenditureitemList);

		return "admin/orderSchool/schoolOrderInfo";
	}

	@RequestMapping("schoolFeecateOrderInfo.html")
	@ResponseBody
	public Map<String, String> schoolFeecateOrderInfo(Order order, String schoolName, HttpSession session) {

		Map<String, String> jsonMap = new HashMap<String, String>();
		/**
		 * 查询数据
		 */
		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);

		/**
		 * 共支出
		 */
		Double schoolExPenSum = 0.0;
		/**
		 * 共收入
		 */
		Double schoolFeeceat = 0.0;
		if (orderListBySchool.size() > 0) {
			for (Order order2 : orderListBySchool) {
				if (order2.getIdentification() == 0) {
					schoolFeeceat += order2.getDpMoney();
				} else if (order2.getIdentification() == 1) {
					schoolExPenSum += order2.getFeecategoryMoney();
				}
			}
		}

		jsonMap.put("orderListBySchool", JSON.toJSONStringWithDateFormat(orderListBySchool, "yyyy-MM-dd hh:mm:ss",
				SerializerFeature.WriteDateUseDateFormat));
		jsonMap.put("schoolFeeceat", schoolFeeceat.toString());
		return jsonMap;

	}

	/**
	 * 清除数据
	 * 
	 * @param class1
	 * @param order
	 * @param student
	 * @param teacher
	 * @param paymentmethod
	 * @param expenAndIncome
	 * @return
	 */
	@RequestMapping("dataEliminating.html")
	@ResponseBody
	public Map<String, String> dataEliminating(String class1, String order, String student, String teacher,
			String paymentmethod, String expenAndIncome) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		if (("true").equals(class1)) {
			classService.delClassTable();
			jsonMap.put("state", "1");
		}
		if (("true").equals(order)) {
			orderService.delOrderTable();
			jsonMap.put("state", "1");

		}
		if (("true").equals(student)) {
			studentService.delStudentTable();
			jsonMap.put("state", "1");

		}
		if (("true").equals(teacher)) {
			teacherService.delTeacherTable();
			jsonMap.put("state", "1");
		}
		if (("true").equals(paymentmethod)) {
			paymentMethodService.delPaymentMethodTable();
			jsonMap.put("state", "1");
		}
		if (("true").equals(expenAndIncome)) {
			expenditureitemsService.delExpenditureitemsTable();
			feeCategoryService.delFeeCategoryTable();
			jsonMap.put("state", "1");
		}

		return jsonMap;
	}

	/**
	 * 艺考收费情况报表
	 * 
	 * @return
	 */
	@RequestMapping("adminArtStudentFeeInfo.html")
	public String adminArtStudentFeeInfo() {
		return "admin/ArtStudentFee/adminArtStudentFeeInfo";
	}

	/**
	 * 艺考页面
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("artStudentFooInfo.html")
	public String artStudentFooInfo(Integer schoolId, String schoolName, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * map.put("state",""); map.put("startTime",""); map.put("endTime","");
		 */
		map.put("schoolId", schoolId);
		List<FeeCategory> feeCategories = feeCategoryService.selectFeeCategory(schoolId);
		/**
		 * 活动项目主键
		 */
		List<String[]> feeIdArray = new ArrayList<String[]>();

		List<String[]> feeMoneyArray = new ArrayList<String[]>();
		/**
		 * 查询艺考学生信息
		 */
		List<Student> artStudentInfoList = studentService.findArtStudentResverSchoolInfo(map);
		/**
		 * 依靠预定班型
		 */
		List<String[]> feecateMoneyYiKaoList = new ArrayList<String[]>();
		/**
		 * 循环读取活动项目主键
		 */
		for (Student student : artStudentInfoList) {
			String[] feearr = null;
			String[] feeMoney = null;
			String[] feeYiKao = null;
			if (student.getOrder().getFeecateId() != null && student.getOrder().getFeecateId() != "") {
				feearr = student.getOrder().getFeecateId().split(",");
				feeIdArray.add(feearr);
			}

			if (student.getOrder().getFeecateMoney() != null && student.getOrder().getFeecateMoney() != "") {
				feeMoney = student.getOrder().getFeecateMoney().split(",");
				feeMoneyArray.add(feeMoney);
			}
			if (student.getOrder().getFeecateMoneyYiKao() != null && student.getOrder().getFeecateMoneyYiKao() != "") {
				feeYiKao = student.getOrder().getFeecateMoneyYiKao().split(",");
				feecateMoneyYiKaoList.add(feeYiKao);
			}

		}
		/**
		 * 查询账户信息
		 */
		List<PaymentMethod> paymentMethods = paymentMethodService.selectPaymentMethod();

		/**
		 * 查询班级信息
		 */
		List<Class> classBySchooList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classBySchooList", classBySchooList);
		session.setAttribute("feeCategories", feeCategories);
		session.setAttribute("feeMoneyArray", feeMoneyArray);
		session.setAttribute("artStudentInfoList", artStudentInfoList);
		session.setAttribute("feeIdArray", feeIdArray);
		session.setAttribute("paymentMethods", paymentMethods);
		session.setAttribute("feecateMoneyYiKaoList", feecateMoneyYiKaoList);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);

		return "admin/ArtStudentFee/artStudentInfo";
	}

	/**
	 * 艺考收费条件查询
	 * 
	 * @return
	 */
	@RequestMapping("queryArtStudentFee.html")
	public String queryArtStudentFee(String map, HttpSession session) {
		Integer schoolId = (Integer) session.getAttribute("schoolId");
		Map<String, Object> map2 = (Map<String, Object>) JSONObject.parse(map);

		map2.put("schoolId", schoolId);
		List<FeeCategory> feeCategories = feeCategoryService.selectFeeCategory(schoolId);
		/**
		 * 活动项目主键
		 */
		List<String[]> feeIdArray = new ArrayList<String[]>();

		List<String[]> feeMoneyArray = new ArrayList<String[]>();
		/**
		 * 查询艺考学生信息
		 */
		List<Student> artStudentInfoList = studentService.findArtStudentResverSchoolInfo(map2);
		/**
		 * 依靠预定班型
		 */
		List<String[]> feecateMoneyYiKaoList = new ArrayList<String[]>();
		/**
		 * 循环读取活动项目主键
		 */
		for (Student student : artStudentInfoList) {
			String[] feearr = null;
			String[] feeMoney = null;
			String[] feeYiKao = null;
			if (student.getOrder().getFeecateId() != null && student.getOrder().getFeecateId() != "") {
				feearr = student.getOrder().getFeecateId().split(",");
				feeIdArray.add(feearr);
			}

			if (student.getOrder().getFeecateMoney() != null && student.getOrder().getFeecateMoney() != "") {
				feeMoney = student.getOrder().getFeecateMoney().split(",");
				feeMoneyArray.add(feeMoney);
			}
			if (student.getOrder().getFeecateMoneyYiKao() != null && student.getOrder().getFeecateMoneyYiKao() != "") {
				feeYiKao = student.getOrder().getFeecateMoneyYiKao().split(",");
				feecateMoneyYiKaoList.add(feeYiKao);
			}

		}
		/**
		 * 查询账户信息
		 */
		List<PaymentMethod> paymentMethods = paymentMethodService.selectPaymentMethod();

		/**
		 * 查询班级信息
		 */
		List<Class> classBySchooList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classBySchooList", classBySchooList);
		session.setAttribute("feeCategories", feeCategories);
		session.setAttribute("feeMoneyArray", feeMoneyArray);
		session.setAttribute("artStudentInfoList", artStudentInfoList);
		session.setAttribute("feeIdArray", feeIdArray);
		session.setAttribute("paymentMethods", paymentMethods);
		session.setAttribute("feecateMoneyYiKaoList", feecateMoneyYiKaoList);
		session.setAttribute("schoolId", schoolId);

		return "admin/ArtStudentFee/artStudentInfo";
	}
	
	/**
	 * 高中收费情况
	 * @return
	 */
	@RequestMapping("adminHighStudentFeeInfo.html")
	public String adminHighStudentFeeInfo() {
		return "admin/highStudentFee/adminHighStudentFeeInfo";
	}

	/**
	 * 高中页面
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("highStudentFooInfo.html")
	public String highStudentFooInfo(Integer schoolId, String schoolName, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * map.put("state",""); map.put("startTime",""); map.put("endTime","");
		 */
		map.put("schoolId", schoolId);
		List<FeeCategory> feeCategories = feeCategoryService.selectFeeCategory(schoolId);
		/**
		 * 活动项目主键
		 */
		List<String[]> feeIdArray = new ArrayList<String[]>();

		List<String[]> feeMoneyArray = new ArrayList<String[]>();
		/**
		 * 查询艺考学生信息
		 */
		List<Student> artStudentInfoList = studentService.findArtStudentResverSchoolInfo(map);
		/**
		 * 依靠预定班型
		 */
		//List<String[]> feecateMoneyYiKaoList = new ArrayList<String[]>();
		/**
		 * 循环读取活动项目主键
		 */
		for (Student student : artStudentInfoList) {
			String[] feearr = null;
			String[] feeMoney = null;
			//String[] feeYiKao = null;
			if (student.getOrder().getFeecateId() != null && student.getOrder().getFeecateId() != "") {
				feearr = student.getOrder().getFeecateId().split(",");
				feeIdArray.add(feearr);
			}

			if (student.getOrder().getFeecateMoney() != null && student.getOrder().getFeecateMoney() != "") {
				feeMoney = student.getOrder().getFeecateMoney().split(",");
				feeMoneyArray.add(feeMoney);
			}

			/*
			 * if (student.getOrder().getFeecateMoneyYiKao() != null &&
			 * student.getOrder().getFeecateMoneyYiKao() != "") { feeYiKao =
			 * student.getOrder().getFeecateMoneyYiKao().split(",");
			 * feecateMoneyYiKaoList.add(feeYiKao); }
			 */

		}
		/**
		 * 查询账户信息
		 */
		List<PaymentMethod> paymentMethods = paymentMethodService.selectPaymentMethod();

		/**
		 * 查询班级信息
		 */
		List<Class> classBySchooList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classBySchooList", classBySchooList);
		session.setAttribute("feeCategories", feeCategories);
		session.setAttribute("feeMoneyArray", feeMoneyArray);
		session.setAttribute("paymentMethods", paymentMethods);
		session.setAttribute("artStudentInfoList", artStudentInfoList);
		session.setAttribute("feeIdArray", feeIdArray);
		//session.setAttribute("feecateMoneyYiKaoList", feecateMoneyYiKaoList);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);

		return "admin/highStudentFee/highStudentInfo";
	}

	/**
	 * 高中收费条件查询
	 * 
	 * @return
	 */
	@RequestMapping("queryHighStudentFee.html")
	public String queryHighStudentFee(String map, HttpSession session) {
		Integer schoolId = (Integer) session.getAttribute("schoolId");
		Map<String, Object> map2 = (Map<String, Object>) JSONObject.parse(map);

		map2.put("schoolId", schoolId);
		List<FeeCategory> feeCategories = feeCategoryService.selectFeeCategory(schoolId);
		/**
		 * 活动项目主键
		 */
		List<String[]> feeIdArray = new ArrayList<String[]>();

		List<String[]> feeMoneyArray = new ArrayList<String[]>();
		/**
		 * 查询艺考学生信息
		 */
		List<Student> artStudentInfoList = studentService.findArtStudentResverSchoolInfo(map2);
		/**
		 * 依靠预定班型
		 */
		//List<String[]> feecateMoneyYiKaoList = new ArrayList<String[]>();
		/**
		 * 循环读取活动项目主键
		 */
		for (Student student : artStudentInfoList) {
			String[] feearr = null;
			String[] feeMoney = null;
			//String[] feeYiKao = null;
			if (student.getOrder().getFeecateId() != null && student.getOrder().getFeecateId() != "") {
				feearr = student.getOrder().getFeecateId().split(",");
				feeIdArray.add(feearr);
			}

			if (student.getOrder().getFeecateMoney() != null && student.getOrder().getFeecateMoney() != "") {
				feeMoney = student.getOrder().getFeecateMoney().split(",");
				feeMoneyArray.add(feeMoney);
			}
		/*	if (student.getOrder().getFeecateMoneyYiKao() != null && student.getOrder().getFeecateMoneyYiKao() != "") {
				feeYiKao = student.getOrder().getFeecateMoneyYiKao().split(",");
				feecateMoneyYiKaoList.add(feeYiKao);
			}*/

		}
		/**
		 * 查询账户信息
		 */
		List<PaymentMethod> paymentMethods = paymentMethodService.selectPaymentMethod();

		/**
		 * 查询班级信息
		 */
		List<Class> classBySchooList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classBySchooList", classBySchooList);
		session.setAttribute("feeCategories", feeCategories);
		session.setAttribute("feeMoneyArray", feeMoneyArray);
		session.setAttribute("paymentMethods", paymentMethods);
		session.setAttribute("artStudentInfoList", artStudentInfoList);
		session.setAttribute("feeIdArray", feeIdArray);
		//session.setAttribute("feecateMoneyYiKaoList", feecateMoneyYiKaoList);
		session.setAttribute("schoolId", schoolId);

		return "admin/highStudentFee/highStudentInfo";
	}
}
