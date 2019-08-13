package cn.huizhi.controller.children;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.huizhi.pojo.ChildrenescClass;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ChildrenescClassService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.UserService;

@Controller
public class ChildrenClassesController {
	/**
	 * 少儿班级业务逻辑
	 */
	@Resource
	ChildrenescClassService childrenescClassService;
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
	 * 返回到少儿首页
	 * @return
	 */
	@RequestMapping("childrenIndex.html")
	public String childrenIndex(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<ChildrenescClass> childrenClassList = childrenescClassService.findChildrenescClasses(user.getSchoolId());
		if(childrenClassList !=null) {
			session.setAttribute("childrenClassList", childrenClassList);
		}
		return "children/childrenIndex";
	}
	/**
	 * 返回创建少儿学生页面
	 * @return
	 */
	@RequestMapping("regitChildrenStudent.html")
	public String createChildrenStudent() {
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
	
	@RequestMapping("regitChildrenClass.html")
	public String createChildrenClass(HttpSession session) {
		
		List<DepartmentOfPediatrics> dpList = departmentOfPediatricsService.findDepartmentOfPediatrics();
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
		List<User> teacherUserList = userService.findtUserByDpId(dpId,schoolId);
		if(teacherUserList.size()>0) {
			return JSON.toJSONString(teacherUserList);
		}
		return "";
	}
	
	
	
}
