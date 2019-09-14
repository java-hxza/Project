package cn.huizhi.controller.admin.school;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.SchoolAccount;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;
import cn.huizhi.pojo.Class;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
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
	

	
	@RequestMapping("expenditureOrder.html")
	@ResponseBody
	public String expenditureOrder(Order order) {
		
		List<Order> expenditureOrderList = orderService.findExpenOrderList(order);
		if(expenditureOrderList.size()>0) {
			return JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		}
		return "";
	}
	
	/**
	 * 支出项目
	 * @return
	 */
	@RequestMapping("AdminIncomeitems.html")
	public String AdminIncomeitems() {
		return "admin/income/selectSchoolIncomeInfo";
	}
	/**
	 * 收入项目
	 * @return
	 */
	@RequestMapping("AdminExpenditureitemses.html")
	public String AdminExpenditureitemses() {
		return "admin/expen/selectSchoolExpenInfo";
	}
	
	@RequestMapping("selectSchoolIncomeInfo.html")
	public String selectSchoolIncomeInfo(Integer schoolId,String schoolName,HttpSession session) {
		
		List<FeeCategory> feeCategorieList = feeCategoryService.selectFeeCategory(schoolId);
		
		session.setAttribute("feeCategorieList", feeCategorieList);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		
		return "admin/income/Incomeitems";
	}
	
	@RequestMapping("selectSchoolExpenInfo.html")
	public String selectSchoolExpenInfo(String schoolId,String schoolName,HttpSession session) {
		
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		List<Expenditureitems> expenditureitemList = expenditureitemsService.selectExpenditureitems(schoolId);
		session.setAttribute("expenditureitemList", expenditureitemList);
		
		return "admin/expen/Expenditureitemses";
	}
	
	/**
	 * 选择学校查看教师信息
	 * @return
	 */
	@RequestMapping("selectSchoolTeacherInfo.html")
	public String selectSchoolTeacherInfo() {
		return "admin/school/selectSchoolTeacherInfo";
	}
	
	
	/**
	 * 返回操作员页面
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
	 * @param uId
	 * @return
	 */
	@RequestMapping("selectUser.html")
	@ResponseBody
	public String selectUser(String uId) {
		List<User> operatorUser = userService.findListAll(uId);
		if(operatorUser.size()>0) {
			return JSON.toJSONString(operatorUser.get(0));
		}
		return "";
	}
	
	/**
	 * 修改操作员信息
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser.html")
	@ResponseBody
	public Map<String, String> updateUser(User user) {
		Map< String, String> jsonMap = new HashMap<String, String>();
		if(userService.modifyUser(user)>0) {
			jsonMap.put("update","1");
		}else {
			jsonMap.put("update","0");
			
		}
		return jsonMap;
	}
	
	/**
	 * 删除操作员
	 * @param uId
	 * @return
	 */
	@RequestMapping("delUser.html")
	@ResponseBody
	public Map<String,String> delUser(Integer uId){
		Map<String, String> jsonMap = new HashMap<String, String>();
		if(userService.delUser(uId)>0) {
			jsonMap.put("del","1");
		}else {
			jsonMap.put("del","0");
		}
		return jsonMap;
	}
	/**
	 * 修改教师
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
	 *学校订单 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("schoolOrderInfo.html")
	public String schoolOrderInfo(Order order,String schoolName,HttpSession session) {
		/**
		 * 查询数据
		 */
		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
		
		//课程类型
		List<DepartmentOfPediatrics> departmentOfPediatricsList = departmentOfPediatricsService.findDepartmentOfPediatrics(order.getSchoolId());
		
		List<Expenditureitems> expenditureitemList = expenditureitemsService.selectExpenditureitems(String.valueOf(order.getSchoolId()));
		
		//账户类型信息
		List<PaymentMethod> payMentList = paymentMethodService.selectPaymentMethod();
		//收入项目类型
		List<FeeCategory> feeCategoryList = feeCategoryService.selectFeeCategory(order.getSchoolId());
		
		List<Class> classBySchooList =  classService.findChildrenescClasses(String.valueOf(order.getSchoolId()));
		/**
		 * 共支出
		 */
		Double schoolExPenSum =0.0;
		/**
		 * 共收入
		 */
		Double schoolFeeceat = 0.0;
		if(orderListBySchool.size()>0) {
			for (Order order2 : orderListBySchool) {
				if(order2.getIdentification()==0) {
					schoolFeeceat += order2.getDpMoney();
				}else if(order2.getIdentification() == 1) {
					schoolExPenSum +=order2.getFeecategoryMoney();
				}
			}
		}
		//总收入，总支出
		session.setAttribute("schoolExPenSum", schoolExPenSum);
		session.setAttribute("schoolFeeceat", schoolFeeceat);
		session.setAttribute("schoolId", order.getSchoolId());
		
		//查询添加
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
	public Map<String, String> schoolFeecateOrderInfo(Order order,String schoolName,HttpSession session) {
		
		
		Map<String, String> jsonMap = new HashMap<String, String>();
		/**
		 * 查询数据
		 */
		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
		
		/**
		 * 共支出
		 */
		Double schoolExPenSum =0.0;
		/**
		 * 共收入
		 */
		Double schoolFeeceat = 0.0;
		if(orderListBySchool.size()>0) {
			for (Order order2 : orderListBySchool) {
				if(order2.getIdentification()==0) {
					schoolFeeceat += order2.getDpMoney();
				}else if(order2.getIdentification() == 1) {
					schoolExPenSum +=order2.getFeecategoryMoney();
				}
			}
		}
		
		jsonMap.put("orderListBySchool",JSON.toJSONStringWithDateFormat(orderListBySchool, "yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat));
		jsonMap.put("schoolFeeceat", schoolFeeceat.toString());
		return jsonMap;
		
	}
	
	
	
}
