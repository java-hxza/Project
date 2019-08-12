package cn.huizhi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.huizhi.mapper.UserMapper;
import cn.huizhi.pojo.City;
import cn.huizhi.pojo.School;
import cn.huizhi.pojo.User;
import cn.huizhi.service.CityService;
import cn.huizhi.service.SchoolService;
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
		List<School> schoolList = schoolService.findSchoolByCityId(cityId);
		
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
	@RequestMapping("user.html")
	@ResponseBody
	public HashMap<String, String> validateLogin(String loginName,String loginPassword,String schoolId,HttpSession session) {
		
		User user = userService.findUserByLogin(loginName, loginPassword, schoolId);
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		if(user!=null) {
			session.setAttribute("user", user);
			jsonMap.put("state", "1");
			jsonMap.put("UsertypeId",user.getUserTypeId());
		}else {
			jsonMap.put("state", "0");
		}
		return jsonMap;
	}
	
	@RequestMapping("selectionModule.html")
	public String toIndex() {
		return"selectionModule";
	}
}
