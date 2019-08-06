package cn.huizhi.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.City;
import cn.huizhi.pojo.Province;
import cn.huizhi.service.CityService;
import cn.huizhi.service.ProvinceService;

@Controller
public class WelcomeController {
	@Resource
	ProvinceService provinceService;//省份业务层注入容器
	@Resource
	CityService CityService;//城市业务层注入容器
	/**
	 * 默认进入登陆页面
	 * @return
	 */
	@RequestMapping({"/","/index.jsp"})
	public String welcome(HttpSession session) {
		
		List<Province> provinceList = provinceService.findProvinces();
		List<City> cityList = CityService.findCitysByProvinceId(provinceList.get(0).getProvinceId());
		session.setAttribute("provinceList", provinceList);
		session.setAttribute("cityList", cityList);
		return "login";
	}
	
}
