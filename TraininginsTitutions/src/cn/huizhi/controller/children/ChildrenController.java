package cn.huizhi.controller.children;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.huizhi.pojo.Children;
import cn.huizhi.pojo.User;

/**
 * 少儿学员信息Controller
 * @author wye
 *
 */
@Controller
public class ChildrenController {
	
	@RequestMapping("redgitChildrenStudent.html")
	@ResponseBody
	public Map<String, String> createChildrenStudent(Children childrenm,@RequestParam("studentClassId")Integer studentClassId,@RequestParam("dpId")Integer dpId,@RequestParam("schoolId")Integer schoolId,HttpSession session) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		/**
		 * 获取登录用户的信息
		 */	
		
		
		return jsonMap;
	}
	
}
