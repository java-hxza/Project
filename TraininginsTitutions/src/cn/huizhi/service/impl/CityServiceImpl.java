package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.CityMapper;
import cn.huizhi.pojo.City;
import cn.huizhi.service.CityService;
@Service
public class CityServiceImpl implements CityService{
	@Resource
	CityMapper cityMapper;//注入到容器中
	
	/**
	 * 查询所有城市并返回
	 */
	public List<City> findCitys() {
		return cityMapper.selectCitys();
	}
	/**
	 * 根据省分查询城市
	 * @param provinceId
	 * @return
	 */
	public List<City> findCitysByProvinceId(Integer provinceId) {
		return cityMapper.selectCitysByProvinceId(provinceId);
	}

}
