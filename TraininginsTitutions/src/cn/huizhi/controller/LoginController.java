package cn.huizhi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.huizhi.pojo.City;
import cn.huizhi.pojo.School;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.TeacherDiction;
import cn.huizhi.pojo.User;
import cn.huizhi.pojo.UserDiction;
import cn.huizhi.service.CityService;
import cn.huizhi.service.SchoolService;
import cn.huizhi.service.TeacherDictionService;
import cn.huizhi.service.TeacherService;
import cn.huizhi.service.UserDictionService;
import cn.huizhi.service.UserService;

@Controller
public class LoginController {
	/**
	 * 城市
	 */
	@Resource
	CityService CityService;
	
	/**
	 * 用户数据层
	 */
	@Resource
	UserService userService;
	
	/**
	 * 学校
	 */
	@Resource
	SchoolService schoolService;
	/**
	 * 教师
	 */
	@Resource
	TeacherService teacherService;
	
	@Resource
	UserDictionService userDictionService;
	@Resource
	TeacherDictionService teacherDictionService;
	/**
	 * 根据省份查询城市并返回数据
	 * @param provinceId
	 * @return
	 */
	@RequestMapping("login.html")
	@ResponseBody
	public String provinceChange(Integer provinceId) {
		
		List<City> cityList = CityService.findCitysByProvinceId(provinceId);
		if(cityList.size()>0) {
			return JSON.toJSONString(cityList);
		}
		
		return "";
	}
	/**
	 * 根据城市查询所有该城市下的学校
	 * @param cityId
	 * @return
	 */
	@RequestMapping("city.html")
	@ResponseBody
	public String cityChange(Integer cityId) {
		List<School> schoolList = schoolService.findSchoolByCityId(cityId,null);
		
		if(schoolList.size()>0) {
			return JSON.toJSONString(schoolList);
		}
		
		return "";
	}
	
	/**
	 * 根据条件验证登录并返回状态
	 * @param userName
	 * @param password
	 * @param schoolId
	 * @return
	 */
	@RequestMapping("userLogin.html")
	@ResponseBody
	public HashMap<String, String> validateLogin(String loginName,String loginPassword,HttpSession session) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		
		User user = userService.findUserByLogin(loginName, loginPassword,schoolType);
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		if (user != null) {
			List<UserDiction> schoolListByUId = userDictionService.findDictionListByUserId(user.getuId());
			session.setAttribute("schoolListByUId", schoolListByUId);
			session.setAttribute("user", user);
			session.setAttribute("loginType", 1);
			jsonMap.put("state", "1");
			jsonMap.put("UsertypeId", user.getUserTypeId());
			
		} 
		if(user == null) {
			Teacher teacher = teacherService.findTeacherByLogin(loginName, loginPassword, schoolType);
			if(teacher !=null) {
				teacher.setLoginName(teacher.getTeacherName());
				List<TeacherDiction> schoolListByUId = teacherDictionService.findTeacherDictionListByTeacherId(teacher.getTeacherId());
				session.setAttribute("loginType", 2);
				session.setAttribute("schoolListByUId", schoolListByUId);
				session.setAttribute("user", teacher);
				jsonMap.put("state", "1");
			}else {
				jsonMap.put("state", "0");
			}
		}
 
		return jsonMap;
	}
	
	/**
	 * 超管登录
	 * @param loginName
	 * @param loginPassword
	 * @param schoolId
	 * @param session
	 * @return
	 *//*
	@RequestMapping("adminLogin.html")
	@ResponseBody
	public HashMap<String, String> validateAdminLogin(String loginName,String loginPassword,String schoolId,HttpSession session) {
		User user = userService.findUserByLogin(loginName, loginPassword,);
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		if(user!=null) {
			session.setAttribute("user", user);
			jsonMap.put("state", "1");
			jsonMap.put("UsertypeId",user.getUserTypeId());
		}else {
			jsonMap.put("state", "0");
		}
		return jsonMap;
	}*/
	
	/**
	 * 返回主页面
	 * @return
	 */
	@RequestMapping("selectionModule.html")
	public String toIndex() {
		return"selectionModule";
	}

/*	@RequestMapping("teacherLogin.html")
	@ResponseBody
	public Map<String, String> teacherLogin(String loginName,String loginPassword,Integer schoolId,Integer departmentId,HttpSession session){
		Map< String, String> jsonMap = new HashMap<String, String>();
		
		if(teacher!=null) {
			session.setAttribute("teacher", teacher);
			jsonMap.put("state","1");
		}else {
			jsonMap.put("state","0");
		}
		return jsonMap;
	}*/
}
