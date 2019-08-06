package cn.huizhi.mapper;
/**
 * 省份Mapper
 * @author wye
 *
 */

import java.util.List;

import cn.huizhi.pojo.Province;
/**
 * 省份Mapper
 * @author wye
 *
 */
public interface ProvinceMapper {
	/**
	 * 查询省份列表
	 * @return
	 */
	public List<Province> selectProvinces();
	
	
}
