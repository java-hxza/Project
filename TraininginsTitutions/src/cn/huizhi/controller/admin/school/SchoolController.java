package cn.huizhi.controller.admin.school;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.huizhi.pojo.SchoolAccount;
import cn.huizhi.service.SchoolAccountService;

@Controller
public class SchoolController {
	/**
	 * 学校账户信息
	 */
	@Resource
	SchoolAccountService schoolAccountService;
	
	@RequestMapping("expenditureOrder.html")
	@ResponseBody
	public String expenditureOrder(Integer schoolId) {
		List<SchoolAccount> expenditureOrderList = schoolAccountService.findSchoolAccountsBySchoolId(schoolId);
		if(expenditureOrderList.size()>0) {
			return JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		}
		return "";
	}
	
}
