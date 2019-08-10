package cn.huizhi.controller.children;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.ChildrenescClass;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ChildrenescClassService;

@Controller
public class ChildrenClassesController {
	/**
	 * 少儿班级业务逻辑
	 */
	@Resource
	ChildrenescClassService childrenescClassService;
	
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
	
	
	
}
