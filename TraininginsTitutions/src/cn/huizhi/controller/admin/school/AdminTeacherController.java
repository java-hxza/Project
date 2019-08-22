package cn.huizhi.controller.admin.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.TeacherDiction;
import cn.huizhi.pojo.TeacherType;
import cn.huizhi.pojo.User;
import cn.huizhi.service.TeacherDictionService;
import cn.huizhi.service.TeacherService;

@Controller
public class AdminTeacherController {
	@Resource
	TeacherService teacherService;
	
	@Resource
	TeacherDictionService teacherDictionService;
	@RequestMapping("schoolTeacherInfo.html")
	public String schoolTeacherInfo(Integer schoolId,String schoolName,HttpSession session) {
		session.setAttribute("schoolName", schoolName);
		User user = new User();
		user.setSchoolId(String.valueOf(schoolId));
		session.setAttribute("user", user);
		List<Teacher> teacherListBYSchoolId =  teacherService.findTeacherListBySchoolId(schoolId);
		if(teacherListBYSchoolId.size()>0) {
			session.setAttribute("teacherListBYSchoolId", teacherListBYSchoolId);
		}else {
			session.setAttribute("teacherListBYSchoolId", teacherListBYSchoolId);
		}
		
		return "admin/schoolTeacherInfo";
	}
	
	/**
	 * 根据教师主键查询教师信息
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("selectTeacher.html")
	@ResponseBody
	public String selectTeacher(Integer teacherId) {
		Teacher teacher = teacherService.findTeacherByTeacherId(teacherId);
		if(teacher!=null) {
			return JSON.toJSONString(teacher);
		}
 		return "";
	}
	
	/**
	 * 校验登录名
	 * @param teacherName
	 * @return
	 */
	@RequestMapping("teacherNameCheck.html")
	@ResponseBody
	public Map<String, String> teacherNameCheck(String teacherName) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		if(teacherService.findTeacherByTeacherName(teacherName)!=null) {
			jsonMap.put("state","0");
		}else {
			jsonMap.put("state","1");
		}
		return jsonMap;
	}
	/**
	 * 添加教师
	 * @param teacher
	 * @param schoolId
	 * @return
	 */
	@RequestMapping("createTeacher.html")
	@ResponseBody
	public Map<String, String> createTeacher(Teacher teacher,Integer schoolId){
		Map<String, String> jsonMap = new HashMap<String, String>();
		//如果添加成功返回1不成功返回0
		if(teacherService.addTeacher(teacher)>0) {
			Teacher teachers = teacherService.selectTeachers(teacher);
			if(teacherDictionService.addTeacherDiction(schoolId, teachers.getTeacherId())>0) {
				jsonMap.put("state","1");
			}else {
				jsonMap.put("state","0");
			}
		}else {
			jsonMap.put("state","0");
		}
		return jsonMap;
	}
	/**
	 * 根据教师主键查询教书所存在的学校
	 * @param teacherId
	 * @param session
	 * @return
	 */
	@RequestMapping("teacherAuthorization.html")
	public String teacherAuthorization(Integer teacherId,HttpSession session) {
		//调用方法
		List<TeacherDiction> teacherDictionListByTeacherId = teacherDictionService.findTeacherDictionListByTeacherId(teacherId);
		session.setAttribute("teacherDictionListByTeacherId",teacherDictionListByTeacherId);
		return "admin/school/authorization/teacherAuthorization";
	}
	
	@RequestMapping("authorization.html")
	@ResponseBody
	public Map<String, String> authorization(Integer teacherId,Integer schoolId) {
 		Map<String, String> jsonMap = new HashMap<String, String>();
 		TeacherDiction teacherDiction = teacherDictionService.findTeacherDictionBySchoolIdAndTeacherId(schoolId, teacherId);
 		if(teacherDiction!=null) {
 			jsonMap.put("state","2");
 			return jsonMap;
 		}
		if(teacherDictionService.addTeacherDiction(schoolId, teacherId)>0) {
			jsonMap.put("state","1");
		}else {
			jsonMap.put("state","0");
		}
		return jsonMap;
	}
	
}
