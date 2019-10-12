package cn.huizhi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.City;
import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.DepartMent;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.Province;
import cn.huizhi.pojo.School;
import cn.huizhi.pojo.SchoolFeeCategorySumMoney;
import cn.huizhi.pojo.TeacherDiction;
import cn.huizhi.pojo.TeacherType;
import cn.huizhi.pojo.UserDiction;
import cn.huizhi.pojo.UserType;
import cn.huizhi.service.CityService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartMentService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.ProvinceService;
import cn.huizhi.service.SchoolService;
import cn.huizhi.service.TeacherTypeService;
/**
 * 默认进入页面并控制视图跳转Controller
 * @author wye
 *
 */
import cn.huizhi.service.UserTypeService;

@Controller
public class WelcomeController {
	/**
	 * 省份业务层注入容器
	 */
	@Resource
	ProvinceService provinceService;
	/**
	 * 城市业务层注入容器
	 */
	@Resource
	CityService CityService;
	/**
	 * 学校业务逻辑层
	 */
	@Resource
	SchoolService schoolService;

	/**
	 * 用户类型
	 */
	@Resource
	UserTypeService userTypeService;
	/**
	 * 教师类型
	 */
	@Resource
	TeacherTypeService teacherTypeService;

	@Resource
	DepartMentService deparMentService;

	@Resource
	ClassService classService;

	@Resource
	OrderService orderService;
	
	@Resource
	DepartmentOfPediatricsService deparmentOfPediatricsService;
	
	@Resource
	FeeCategoryService feeCategoryService;

	/**
	 * 默认进入登陆页面并把查询结果封装到session域
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping({ "/", "welCome.html" })
	public String welcome(HttpSession session) {
		/**
		 * 第一次进入查询城市及省份
		 */
		List<Province> provinceList = provinceService.findProvinces();
		List<City> cityList = CityService.findCitysByProvinceId(provinceList.get(0).getProvinceId());
		List<School> schoolList = schoolService.findSchoolByCityId(cityList.get(0).getCityId(),null);
		List<DepartMent> departMentListAllList = deparMentService.selectDepartMentListAll();
		session.setAttribute("departMentListAllList", departMentListAllList);
		session.setAttribute("provinceList", provinceList);
		session.setAttribute("cityList", cityList);
		session.setAttribute("schoolList", schoolList);
		return "selectionModule";
	}

	/**
	 * 错误页面返回
	 * 
	 * @return
	 */
	@RequestMapping("erro.html")
	public String errorView() {
		return "error";
	}

	/**
	 * 注册账户页面
	 * 
	 * @return
	 */
	@RequestMapping("Register.html")
	public String userRegit() {
		return "UserRegister";
	}

	/**
	 * 返回管理员页面
	 * 
	 * @return
	 */
	@RequestMapping("adminIndex.html")
	public String adminIndex(HttpSession session) {
		List<School> schoolListAll = schoolService.findSchools();
		List<SchoolFeeCategorySumMoney> smList = new ArrayList<SchoolFeeCategorySumMoney>();
		SchoolFeeCategorySumMoney sm = null;
		Order order;
		for (School school : schoolListAll) {
			order = new Order();
			order.setSchoolId(school.getSchoolId());
			
			//学校收费项目
			List<FeeCategory> schoolFeeCategories = feeCategoryService.selectFeeCategory(school.getSchoolId());
			//统计学校收费项目
			for (int i = 0; i < schoolFeeCategories.size(); i++) {
				sm = new SchoolFeeCategorySumMoney();
				sm.setFeeId(String.valueOf(schoolFeeCategories.get(i).getChargeTypeId()));
				sm.setFeeName(schoolFeeCategories.get(i).getChargeTypeName());
				sm.setSchoolId(String.valueOf(schoolFeeCategories.get(i).getSchoolId()));
				smList.add(sm);
			}
			// 学校收入订单
			List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
			
		
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
			
			// 学校shou订单
			List<Order> schoolExpenList = orderService.findExpenOrderList(order);
			for (Order order2 : orderListBySchool) {
				if (order2.getIdentification() == 0) {
					school.setSchoolFeeceat(school.getSchoolFeeceat() + order2.getDpMoney()); 
				}
			}
			
			//学校支出订单
			for (Order order3 : schoolExpenList) {
				if (order3.getIdentification() == 1) {
					school.setSchoolExPenSum(school.getSchoolExPenSum() + order3.getFeecategoryMoney());
				}
			}
		}
		session.setAttribute("smList", smList);
		session.setAttribute("schoolListAll", schoolListAll);
		return "admin/adminIndex";
	}

	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("querySchoolOrderByTime.html")
	public String querySchoolOrderByTime(String endTime, String startTime,String provinceId,String cityId,HttpSession session) {
		List<School> schoolListAll = null;
		if(cityId !=null && cityId !="") {
			schoolListAll = schoolService.findSchoolByCityId(Integer.valueOf(cityId),null);
		}
		if(provinceId !=null && provinceId !="") {
			schoolListAll = schoolService.findSchoolByCityId(null,Integer.valueOf(provinceId));
		}
		Order order;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<SchoolFeeCategorySumMoney> smList = new ArrayList<SchoolFeeCategorySumMoney>();
		SchoolFeeCategorySumMoney sm = null;
		for (School school : schoolListAll) {
			order = new Order();
			//判断非空
			if(("").equals(startTime) || startTime == null) {
				order.setStartTime(null);
			}
			if(("").equals(endTime) || endTime == null) {
					order.setEndTime(null);
			}
			order.setSchoolId(school.getSchoolId());
			
			try {
				if(order.getEndTime() != null || !("").equals(order.getEndTime())) {
					order.setEndTime(formatter.parse(endTime));
				}
				if(order.getStartTime() != null || !("").equals(order.getStartTime())) {
					order.setStartTime(formatter.parse(startTime));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			order.setCityId(cityId);
			order.setCityProperId(provinceId);
			
			// 学校收入订单
			List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
			//学校收费项目
			List<FeeCategory> schoolFeeCategories = feeCategoryService.selectFeeCategory(school.getSchoolId());
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

			// 学校支出订单
			List<Order> schoolExpenList = orderService.findExpenOrderList(order);
			for (Order order2 : orderListBySchool) {
				if (order2.getIdentification() == 0) {
					school.setSchoolFeeceat(school.getSchoolFeeceat() + order2.getDpMoney()); 
				}
			}

			for (Order order3 : schoolExpenList) {
				if (order3.getIdentification() == 1) {
					school.setSchoolExPenSum( school.getSchoolExPenSum() + order3.getFeecategoryMoney());
				}
			}
		}
		session.setAttribute("smList", smList);
		session.setAttribute("schoolListAll", schoolListAll);
		return "admin/adminIndex";
	}

	/**
	 * 返回创建学校视图
	 * 
	 * @return
	 */
	@RequestMapping("createSchool.html")
	public String createSchool() {
		return "admin/create/createSchool";
	}

	/**
	 * 返回创建学校用户视图
	 * 
	 * @return
	 */
	@RequestMapping("createUser.html")
	public String createUser(HttpSession session) {
		List<UserType> userTypeList = userTypeService.findUserTypes();
		session.setAttribute("userTypeList", userTypeList);
		return "admin/create/createUser";
	}

	/**
	 * 返回创建教师视图
	 * 
	 * @return
	 */
	@RequestMapping("creageTeacher.html")
	public String createTeacher(HttpSession session) {
		List<TeacherType> teacherTypeListAl = teacherTypeService.selectTeacherType();
		session.setAttribute("teacherTypeListAl", teacherTypeListAl);
		return "admin/create/createTeacher";
	}

	@RequestMapping("highSchoolLogin.html")
	public String highSchoolLogin(HttpSession session) {
		session.setAttribute("schoolType", 2);

		return "/login";
	}

	@RequestMapping("artSchoolLogin.html")
	public String artSchoolLogin(HttpSession session) {
		session.setAttribute("schoolType", 3);

		return "/login";
	}

	@RequestMapping("highIndex.html")
	public String highIndex(HttpSession session) {
		Integer loginType = (Integer) session.getAttribute("loginType");
		if (loginType == 1) {

			List<UserDiction> userListDiction = (List<UserDiction>) session.getAttribute("schoolListByUId");
			Integer schoolId = userListDiction.get(0).getSchoolId();
			session.setAttribute("schoolId", schoolId);

			List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));

			session.setAttribute("classList", classList);
		}
		if (loginType == 2) {

			List<TeacherDiction> userListDiction = (List<TeacherDiction>) session.getAttribute("schoolListByUId");
			Integer schoolId = userListDiction.get(0).getSchoolId();
			session.setAttribute("schoolId", schoolId);

			List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));

			session.setAttribute("classList", classList);
		}

		return "redirect:/Accountinformation.html";
	}

	/**
	 * 切换账号
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param schoolType
	 * @param session
	 * @return
	 */
	@RequestMapping("switchHighIndex.html")
	public String switchHighIndex(Integer schoolId, String schoolName, Integer schoolType, HttpSession session) {

		session.setAttribute("schoolId", schoolId);
		session.setAttribute("schoolType", schoolType);

		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classList", classList);

		return "redirect:/Accountinformation.html";
	}

}
