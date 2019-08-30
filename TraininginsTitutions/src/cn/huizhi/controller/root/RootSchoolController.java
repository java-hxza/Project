package cn.huizhi.controller.root;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.Order;
import cn.huizhi.service.OrderService;

@Controller
public class RootSchoolController {

	@Resource
	OrderService orderService;
	
	@RequestMapping("rootSchoolInfo.html")
	public String schoolInfo(Integer schoolId,HttpSession session) {
		Order orders = new Order();
		orders.setSchoolId(schoolId);
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
		session.setAttribute("schoolId", schoolId);
		session.setAttribute("schoolOrderList", schoolOrderList);
		return "root/school/schoolInfo";
	}
}
