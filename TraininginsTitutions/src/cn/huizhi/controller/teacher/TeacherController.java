package cn.huizhi.controller.teacher;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.service.ClassService;
/**
 * 教师
 * @author wye
 *
 */
@Controller
public class TeacherController {

	@Resource
	ClassService classService;
	
	/**
	 * 返回教师主页
	 * @param session
	 * @return
	 */
	@RequestMapping("teacherIndex.html")
	public String teacherIndex(HttpSession session) {
		
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		
		List<Class> teacherClassList = classService.selectClassListByTeacherId(teacher.getTeacherId());
		
		session.setAttribute("teacherClassList", teacherClassList);
		
		return "teacher/teacherIndex";
	}
	
}
