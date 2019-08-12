package cn.huizhi.controller.children;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huizhi.pojo.Children;
import cn.huizhi.pojo.ChildrenesClassStudnet;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ChildrenService;
import cn.huizhi.service.ChildrenesClassStudnetService;

/**
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
	ChildrenService childrenService;
	/**
	 * 少儿学生班级
	 */
	@Resource
	ChildrenesClassStudnetService childrenesClassStudnetService;
	
	@RequestMapping("redgitChildrenStudent.html")
	@ResponseBody
	public Map<String, String> createChildrenStudent(Children children,Integer studentClassId,String headmaster) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		/**
		 * 获取少儿班级的信息
		 */	
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
		
		childrenesClassStudnet.setClassesStudentId(children.getChildrenId());
		childrenesClassStudnet.setStudentName(children.getStudentName());
		childrenesClassStudnet.setEnrollmentTime(new Date());
		childrenesClassStudnet.setHeadmaster(headmaster);
		childrenesClassStudnet.setClassId(studentClassId);
		childrenesClassStudnet.setState("1");
		
		if(childrenService.addChildren(children) >0 ) {
			/**
			 * 查询刚刚添加的少儿信息
			 */
			Children child = childrenService.findChildrenInfoByChildren(children); 
			if(child!=null) {
				childrenesClassStudnet.setStudentId(child.getChildrenId());
				
				/**
				 * 把数据加到新的班级中
				 */
				if(childrenesClassStudnetService.addChildrenesClassStudnet(childrenesClassStudnet)>0)
					jsonMap.put("state","1");
			}
		}else {
			jsonMap.put("state", "0");
		}
		
		return jsonMap;
	}
	
}
