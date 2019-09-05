package cn.huizhi.controller.children;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.huizhi.pojo.ChildrenesClassStudnet;
import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.HighesClassStudnet;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ChildrenesClassStudnetService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.HighesClassStudnetService;
import cn.huizhi.service.TeacherService;
import cn.huizhi.service.UserService;

@Controller
public class ChildrenClassesController {
	/**
	 * 少儿班级业务逻辑
	 */
	@Resource
	ClassService classService;
	/**
	 * 少儿班级科别
	 */
	@Resource
	DepartmentOfPediatricsService departmentOfPediatricsService;
	/**
	 * 用户
	 */
	@Resource
	UserService userService;
	/**
	 * 教师
	 */
	@Resource
	TeacherService teacherService;
	
	@Resource
	ChildrenesClassStudnetService childrenesClassStudnetService;
	
	@Resource
	HighesClassStudnetService highesClassStudnetService;
	
	@RequestMapping("childrenSchoolLogin.html")
	public String childrenSchoolLogin(HttpSession session) {
		session.setAttribute("schoolType", 1);
		
		return "login";
	}
	
	/**
	 * 返回到少儿首页
	 * @return
	 */
	@RequestMapping("classIndex.html")
	public String childrenIndex(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Class> childrenClassList = classService.findChildrenescClasses(user.getSchoolId());
		if(childrenClassList !=null) {
			session.setAttribute("childrenClassList", childrenClassList);
		}
		return "children/childrenIndex";
	}
	
	/**
	 * 返回创建少儿学生页面
	 * @return
	 */
	@RequestMapping("regitStudent.html")
	public String createChildrenStudent(Integer classId) {
		return "children/create/createChildrenStudent";
	}
	/**
	 * 跳转到学生信息管理页面
	 * @return
	 */
	@RequestMapping("studentInfo.html")
	public String studentInfo() {
		return "children/studentInfo";
	}
	
	/**
	 * 返回注册班级页面
	 * @param session
	 * @return
	 */
	@RequestMapping("regitClass.html")
	public String createChildrenClass(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<DepartmentOfPediatrics> dpList = departmentOfPediatricsService.findDepartmentOfPediatrics(Integer.parseInt(user.getSchoolId()));
		session.setAttribute("dpList", dpList);
		return "children/create/createChildrenClass";
	}
	
	/**
	 * 根据教师科别，学校主键查询所有老师并异步返回数据
	 * @param dpId
	 * @param session
	 * @return
	 */
	@RequestMapping("dpChange.html")
	@ResponseBody
	public String dpChange(Integer dpId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer schoolId = Integer.valueOf(user.getSchoolId());
		List<Teacher> teacherUserList = teacherService.findTeachersByTeacherTypeId(dpId,schoolId);
		if(teacherUserList.size()>0) {
			return JSON.toJSONString(teacherUserList);
		}
		return "";
	}
	/**
	 * 创建学生班级
	 * @param childrenescClass
	 * @return
	 */
	@RequestMapping("createClass.html")
	@ResponseBody
	public Map<String, String> createChildrenClass(Class classes,HttpSession session) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		classes.setSchoolId(Integer.valueOf(user.getSchoolId()));
		if(classService.addChildrenescClass(classes)>0) {
			jsonMap.put("state", "1");
		}else {
			jsonMap.put("state", "0");
		}
		return jsonMap;
	}
	
	@RequestMapping("seeStudentInfo.html")
	public String seeStudentInfo(Integer classId,HttpSession session) {
		
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		if(schoolType == 1 ) {
			List<ChildrenesClassStudnet> childrenesClassStudnets = childrenesClassStudnetService.findChildrenesClassStudnetByClassId(classId);
			session.setAttribute("childrenesClassStudnets", childrenesClassStudnets);
			return "root/studentInfo/children/seeStudentInfo";
		}
		if(schoolType == 2) {
			List<HighesClassStudnet> highesClassStudnets = highesClassStudnetService.findHighesClassStudnetListByClassId(classId);
			session.setAttribute("highesClassStudnets", highesClassStudnets);
			return "root/studentInfo/high/seeStudentInfo";
		}
		if(schoolType ==3) {
			
		}
		
		return "seeStudentInfo";
	}
	
	
}
