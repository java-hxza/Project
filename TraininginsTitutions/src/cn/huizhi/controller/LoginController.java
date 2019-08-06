package cn.huizhi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.huizhi.pojo.City;
import cn.huizhi.service.CityService;

@Controller
public class LoginController {
	
	@Resource
	CityService CityService;
	
	@RequestMapping("login.html")
	@ResponseBody
	public String provinceChange(Integer provinceId) {
		List<City> cityList = CityService.findCitysByProvinceId(provinceId);
		if(cityList.size()>0) {
			return JSON.toJSONString(cityList);
		}
		
		return null;
	}
}
