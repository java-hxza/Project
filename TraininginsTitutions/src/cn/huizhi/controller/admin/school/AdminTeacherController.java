package cn.huizhi.controller.admin.school;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.Teacher;
import cn.huizhi.service.TeacherService;

@Controller
public class AdminTeacherController {
	@Resource
	TeacherService teacherService;
	
	/**
	 * 选择学校查看教师信息
	 * @return
	 */
	@RequestMapping("selectSchoolTeacherInfo.html")
	public String selectSchoolTeacherInfo() {
		return "admin/scoolInfo/selectSchoolTeacherInfo";
	}
	
	@RequestMapping("schoolTeacherInfo.html")
	public String schoolTeacherInfo(Integer schoolId,String schoolName,HttpSession session) {
		session.setAttribute("schoolName", schoolName);
		List<Teacher> teacherListBYSchoolId =  teacherService.selectTeacherListBySchoolId(schoolId);
		if(teacherListBYSchoolId.size()>0) {
			session.setAttribute("teacherListBYSchoolId", teacherListBYSchoolId);
		}else {
			session.setAttribute("teacherListBYSchoolId", teacherListBYSchoolId);
		}
		
		return "admin/scoolInfo/schoolTeacherInfo";
	}
}
