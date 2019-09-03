package cn.huizhi.controller.root;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ChildStuReistrationService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
import cn.huizhi.service.UserService;

@Controller
public class RootSchoolController {
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
	ChildStuReistrationService childStuReistrationService;
	
	
	/**
	 * 学校账户余额
	 * @param session
	 * @return
	 */
	@RequestMapping("rootSchoolInfo.html")
	public String schoolInfo(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		Order orders = new Order();
		orders.setSchoolId(Integer.valueOf(user.getSchoolId()));
		List<Order> schoolOrderList = orderService.findOrderListBySchool(orders);
		/**
		 * 共支出
		 */
		Double schoolExPenSum =0.0;
		/**
		 * 共收入
		 */
		Double schoolFeeceat = 0.0;
		if(schoolOrderList.size()>0) {
			for (Order order : schoolOrderList) {
				if(order.getIdentification()==0) {
					schoolFeeceat += order.getDpMoney();
				}else if(order.getIdentification() == 1) {
					schoolExPenSum +=order.getFeecategoryMoney();
				}
			}
		}
		session.setAttribute("schoolExPenSum", schoolExPenSum);
		session.setAttribute("schoolFeeceat", schoolFeeceat);
		session.setAttribute("schoolId", orders.getSchoolId());
		session.setAttribute("schoolOrderList", schoolOrderList);
		return "root/school/schoolInfo";
	}
	
	
	@RequestMapping("schoolExpen.html")
	@ResponseBody
	public String expenditureOrder(Order order) {
		
		List<Order> expenditureOrderList = orderService.findOrderListBySchool(order);
		if(expenditureOrderList.size()>0) {
			return JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		}
		return "";
	}
	
	
	/**
	 * 学校收入总会报表
	 * @param session
	 * @return
	 */
	@RequestMapping("orderInfo.html")
	public String schoolOrderInfo(HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		Order order = new Order();
		order.setSchoolId(Integer.valueOf(user.getSchoolId()));
		
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
		
		
		return "root/schoolOrder/schoolOrderInfo";
	}
	
	
	@RequestMapping("feecateOrderInfo.html")
	@ResponseBody
	public Map<String, String> feecateOrderInfo(Order order,String schoolName,HttpSession session) {
		
		
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
	
	
	/**
	 * 返回班级学校页面
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("classInfo.html")
	public String classInfo(Integer schoolId,String schoolName,HttpSession session) {
		
		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));
		
		session.setAttribute("classList", classList);
		
		return "root/classStudent/classSchoolInfo";
	}
	
	@RequestMapping("schoolStudentHour.html")
	public String schoolTeacherHour(Integer classId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		
		if(schoolType == 1) {
			List stuReistrationList = childStuReistrationService.findchildStuReistrationListByClass(classId);
			session.setAttribute("stuReistrationList", stuReistrationList);
			return "admin/classStudent/studentHourInfo";
		}
		if(schoolType == 2) {
			
		}
		if(schoolType == 3) {
			
		}
		
		return "studentHourInfo";
	}
	
	
	/**
	 * 返回操作员信息
	 * @param session
	 * @return
	 */
	@RequestMapping("schoolOperatorChilk.html")
	public String schoolOperatorChilk(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<User> findUserAllByAdmin = userService.findListAll(user.getSchoolId());
		session.setAttribute("findUserAllByAdmin", findUserAllByAdmin);
		return "root/basicSettings/operator";
	}
	
	
	
}
