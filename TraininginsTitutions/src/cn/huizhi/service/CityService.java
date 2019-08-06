package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.City;

/**
 * 城市service
 * 
 * @author wye
 *
 */
public interface CityService {
	/**
	 * 查询所有城市列表
	 * 
	 * @return
	 */
	public List<City> findCitys();
	
	/**
	 * 根据省分查询城市
	 * @param provinceId
	 * @return
	 */
	public List<City> findCitysByProvinceId(Integer provinceId);
}
