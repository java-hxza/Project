package cn.huizhi.controller.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.School;
import cn.huizhi.pojo.SchoolFeeCategorySumMoney;
import cn.huizhi.pojo.User;
import cn.huizhi.pojo.UserDiction;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.SchoolService;
import cn.huizhi.service.UserDictionService;
/**
 * 管理员创建管理controller
 * @author wye
 *
 */
import cn.huizhi.service.UserService;

@Controller
public class AdminCreateController {
	/**
	 * 学校service
	 */
	@Resource
	SchoolService schoolService;
	/**
	 * 用户service
	 */
	@Resource
	UserService userservice;
	/**
	 * 学校账户主键
	 */
	@Resource
	OrderService orderService;
	
	@Resource
	UserDictionService userDictionService;
	
	@Resource
	FeeCategoryService feeCategoryService;
	/**
	 * 创建学校并以json数组形式返回
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping("regitSchool.html")
	@ResponseBody
	public HashMap<String, String> createSchool(School school) {
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		
		if (schoolService.addSchool(school) > 0) {
			jsonMap.put("state", "1");
		} else {
			jsonMap.put("state", "0");
		}

		return jsonMap;
	}

	@RequestMapping("regitUser.html")
	@ResponseBody
	public HashMap<String, String> createUser(String loginName, String loginPassword, String remarks,
			Integer userTypeId,Integer schoolId) {
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		User user = new User();
		user.setLoginPassword(loginPassword);
		user.setLoginName(loginName);
		user.setUserTypeId(Integer.toString(userTypeId));
		UserDiction userDiction = new UserDiction();
		
		
		if (userservice.addtUser(user) > 0) {
			userDiction.setSchoolId(schoolId);
			userDiction.setUserId(user.getuId());
			
			if(userDictionService.insertUserDiction(userDiction)>0) {
				jsonMap.put("state", "1");
			}
		} else {
			jsonMap.put("state", "0");
		}

		return jsonMap;
	}

	/**
	 * 登录名验证
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping("loginNameVerification.html")
	@ResponseBody
	public Map<String, String> loginNameVerification(String loginName) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		User user = userservice.findUserByUserName(loginName);
		if (user != null) {
			jsonMap.put("state", "0");
		} else {
			jsonMap.put("state", "1");
		}
		return jsonMap;
	}
	
	/**
	 * 查询学校信息并返回视图
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("schoolInfo.html")
	public String schoolInfo(Integer schoolId,String schoolName,HttpSession session) {
		Order orders = new Order();
		orders.setSchoolId(schoolId);
		List<Order> schoolOrderList = orderService.findOrderListBySchool(orders);
		List<SchoolFeeCategorySumMoney> smList = new ArrayList<SchoolFeeCategorySumMoney>();
		SchoolFeeCategorySumMoney sm = null;
		//学校支出订单
		List<Order> schoolExpenList = orderService.findExpenOrderList(orders);
		
		
		List<Order> orderListBySchool = orderService.findOrderListBySchool(orders);
		//学校收费项目
		List<FeeCategory> schoolFeeCategories = feeCategoryService.selectFeeCategory(schoolId);
		//统计学校收费项目
		for (int i = 0; i < schoolFeeCategories.size(); i++) {
			sm = new SchoolFeeCategorySumMoney();
			sm.setFeeId(String.valueOf(schoolFeeCategories.get(i).getChargeTypeId()));
			sm.setFeeName(schoolFeeCategories.get(i).getChargeTypeName());
			sm.setSchoolId(String.valueOf(schoolFeeCategories.get(i).getSchoolId()));
			smList.add(sm);
		}
		
	
		//计算收费项目金额
		for (int i = 0; i < orderListBySchool.size(); i++) {
			
			String feeId [] = orderListBySchool.get(i).getFeecateId().split(",");
			if( orderListBySchool.get(i).getFeecateMoney() == null) {
				orderListBySchool.get(i).setFeecateMoney("0");
			}
			String feeMoney [] = orderListBySchool.get(i).getFeecateMoney().split(",");
			//循环收费项目订单
			for (int j = 0; j < feeId.length; j++) {
				//计算收费项目总金额
				for (int k = 0; k < schoolFeeCategories.size(); k++) {
					if(feeId[j].equals(String.valueOf(schoolFeeCategories.get(k).getChargeTypeId()))) {
						for (int l = 0; l < smList.size(); l++) {
							//比较收费项目主键添加
							if(smList.get(l).getFeeId().equals(feeId[j])) {
								smList.get(l).setSumMoney(Double.valueOf(feeMoney[j])+smList.get(l).getSumMoney());
							}
						}
					}
				}
				
				
			}
		}
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
				}
			}
		}
		
		/**
		 * 共支出
		 */
		for (Order order : schoolExpenList) {
			if(order.getIdentification() == 1) {
				schoolExPenSum +=order.getFeecategoryMoney();
			}
		}
		BigDecimal bd = new BigDecimal(schoolExPenSum);

		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal bc = new BigDecimal(schoolFeeceat);
		bc = bc.setScale(2, BigDecimal.ROUND_HALF_UP);

		session.setAttribute("schoolExPenSum", bd);
		session.setAttribute("schoolFeeceat", bc);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		session.setAttribute("schoolOrderList", schoolOrderList);
		session.setAttribute("smList", smList);
		session.setAttribute("schoolFeeCategories", schoolFeeCategories);
		return "admin/school/schoolInfo";
	}
	
}
