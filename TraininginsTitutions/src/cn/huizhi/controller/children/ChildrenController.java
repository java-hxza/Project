package cn.huizhi.controller.children;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huizhi.pojo.ChildrenesClassStudnet;
import cn.huizhi.pojo.Student;
import cn.huizhi.service.ChildrenesClassStudnetService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.StudentService;

/*
* 少儿学员信息Controller
 * @author wye
 *
 */
@Controller
public class ChildrenController {
	/**
	 * 少儿学生信息
	 */
	@Resource
	StudentService studentService;
	/**
	 * 少儿学生班级
	 */
	@Resource
	ChildrenesClassStudnetService childrenesClassStudnetService;

	@RequestMapping("redgitStudent.html")
	@ResponseBody
	public Map<String, String> createChildrenStudent(Student student, Integer studentClassId, String headmaster) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		/**
		 * 获取少儿班级的信息
		 */
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();

		childrenesClassStudnet.setStudentName(student.getStudentName());
		childrenesClassStudnet.setEnrollmentTime(new Date());
		childrenesClassStudnet.setHeadmaster(headmaster);
		childrenesClassStudnet.setClassId(studentClassId);
		childrenesClassStudnet.setState("1");

		if (studentService.addStudnetInfo(student) > 0) {
			/**
			 * 查询刚刚添加的少儿信息
			 */
			childrenesClassStudnet.setStudentId(student.getStudentId());
			/**
			 * 把数据加到新的班级中
			 */
			if (childrenesClassStudnetService.addChildrenesClassStudnet(childrenesClassStudnet) > 0)
				jsonMap.put("state", "1");
			else
				jsonMap.put("state", "0");

		}
		return jsonMap;
	}
}
