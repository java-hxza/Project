package cn.huizhi.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huizhi.pojo.School;
import cn.huizhi.pojo.User;
import cn.huizhi.service.SchoolService;
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
	 * 创建学校并以json数组形式返回
	 * @param provinceId
	 * @param cityId
	 * @param schoolName
	 * @param schoolRemarks
	 * @return
	 */
	@RequestMapping("regitSchool.html")
	@ResponseBody
	public HashMap<String, String> createSchool(Integer provinceId ,Integer cityId,String schoolName,String schoolRemarks) {
		School school = new School();
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		school.setCityProperId(provinceId);
		school.setCityId(cityId);
		school.setSchoolName(schoolName);
		school.setSchoolRemarks(schoolRemarks);
		if(schoolService.addSchool(school)>0) {
			jsonMap.put("state", "1");
		}else { 
			jsonMap.put("state", "0");
		}
		 
		return jsonMap;
	}
	
	@RequestMapping("createUser.html")
	@ResponseBody
	public HashMap<String, String> createUser(String userName,String loginName,String loginPassword,Integer schoolId){
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPassword(loginPassword);
		user.setUserName(userName);
		user.setSchoolId(schoolId);
		if(userservice.addtUser(user)>0) {
			jsonMap.put("state", "1");
		}else {
			jsonMap.put("state", "0");
		}
		
		
		return jsonMap; 
	}
}
