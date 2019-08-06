package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.Province;
/**
 * 业务层
 * @author wye
 *
 */
public interface ProvinceService {
	/**
	 * 查询省份列表
	 * @return
	 */
	public List<Province> findProvinces();
	
	
}
