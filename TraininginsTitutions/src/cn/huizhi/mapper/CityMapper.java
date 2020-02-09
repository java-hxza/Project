package cn.huizhi.mapper;
/**
 * 城市Mapper
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.City;

public interface CityMapper {
		/**
		 * 查询所有城市列表
		 * @return
		 */
	public List<City> selectCitys();
	/**
	 * 根据省分查询城市
	 * @param provinceId
	 * @return
	 */
	public List<City> selectCitysByProvinceId(@Param("provinceId")Integer provinceId);
	
	
	
}
