package cn.huizhi.controller.admin.school;

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

import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.SchoolAccount;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;
import cn.huizhi.service.OrderService;
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
	
	@RequestMapping("expenditureOrder.html")
	@ResponseBody
	public String expenditureOrder(Integer schoolId) {
		Order order = new Order();
		order.setSchoolId(schoolId);
		List<Order> expenditureOrderList = orderService.findOrderListBySchool(order);
		if(expenditureOrderList.size()>0) {
			return JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		}
		return "";
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
	public String schoolOrderInfo(Integer schoolId,String schoolName,HttpSession session) {
		Order order = new Order();
		order.setSchoolId(schoolId);
		/**
		 * 查询数据
		 */
		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
		
		session.setAttribute("orderListBySchool", orderListBySchool);
		
		return "admin/orderSchool/schoolOrderInfo";
	}
	
	
	
	
}
