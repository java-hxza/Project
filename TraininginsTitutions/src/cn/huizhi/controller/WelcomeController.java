package cn.huizhi.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.City;
import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.DepartMent;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.Province;
import cn.huizhi.pojo.School;
import cn.huizhi.pojo.TeacherDiction;
import cn.huizhi.pojo.TeacherType;
import cn.huizhi.pojo.UserDiction;
import cn.huizhi.pojo.UserType;
import cn.huizhi.service.CityService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartMentService;
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
	 *  省份业务层注入容器
	 */
	@Resource
	ProvinceService provinceService;
	/**
	 *  城市业务层注入容器
	 */
	@Resource
	CityService CityService;
	/**
	 *  学校业务逻辑层
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
	
	/**
	 * 默认进入登陆页面并把查询结果封装到session域
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
		List<School> schoolList = schoolService.findSchoolByCityId(cityList.get(0).getCityId());
		List<DepartMent> departMentListAllList = deparMentService.selectDepartMentListAll();
		session.setAttribute("departMentListAllList", departMentListAllList);
		session.setAttribute("provinceList", provinceList);
		session.setAttribute("cityList", cityList);
		session.setAttribute("schoolList", schoolList);
		return "selectionModule";
	}
	/**
	 * 错误页面返回
	 * @return
	 */
	@RequestMapping("erro.html")
	public String errorView() {
		return "error";
	}
	/**
	 * 注册账户页面
	 * @return
	 */
	@RequestMapping("Register.html")
	public String userRegit() {
		return "UserRegister";
	}
	/**
	 * 返回管理员页面
	 * @return
	 */
	@RequestMapping("adminIndex.html")
	public String adminIndex(HttpSession session) {
		List<School> schoolListAll = schoolService.findSchools();
		Order order;
		for (School school : schoolListAll) {
			order = new Order();
			order.setSchoolId(school.getSchoolId());
			
			//学校收入订单
			List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
			
			//学校支出订单
			List<Order> schoolExpenList = orderService.findExpenOrderList(order);
			for (Order order2 : orderListBySchool) {
				if(order2.getIdentification()==0) {
					school.schoolFeeceat += order2.getDpMoney();
				}
			}
			for (Order order3 : schoolExpenList) {
				if(order3.getIdentification() == 1) {
					school.schoolExPenSum +=order3.getFeecategoryMoney();
				}
			}
		}
		
		session.setAttribute("schoolListAll", schoolListAll);
		return	"admin/adminIndex";
	}

	
	/**
	 * 返回创建学校视图
	 * @return
	 */
	@RequestMapping("createSchool.html")
	public String createSchool() {
		return"admin/create/createSchool";
	}
	/**
	 * 返回创建学校用户视图
	 * @return
	 */
	@RequestMapping("createUser.html")
	public String createUser(HttpSession session) {
		List<UserType> userTypeList = userTypeService.findUserTypes();
		session.setAttribute("userTypeList", userTypeList);
		return"admin/create/createUser";
	}
	
	
	/**
	 * 返回创建教师视图
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
		if(loginType == 1) {
			
			List<UserDiction> userListDiction = (List<UserDiction>) session.getAttribute("schoolListByUId");
			Integer schoolId = userListDiction.get(0).getSchoolId();
			session.setAttribute("schoolId", schoolId);
			
			List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));
			
			session.setAttribute("classList", classList);
		}
		if(loginType == 2) {
			
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
	 * @param schoolId
	 * @param schoolName
	 * @param schoolType
	 * @param session
	 * @return
	 */
	@RequestMapping("switchHighIndex.html")
	public String switchHighIndex(Integer schoolId,String schoolName,Integer schoolType,HttpSession session) {
		
		
		session.setAttribute("schoolId", schoolId);
		session.setAttribute("schoolType", schoolType);
		
		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));
		
		session.setAttribute("classList", classList);
		
		return "redirect:/Accountinformation.html";
	}
	
}
