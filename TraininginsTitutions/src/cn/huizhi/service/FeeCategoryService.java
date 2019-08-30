package cn.huizhi.service;
/**
  * 收入项目
 * @author 86175
 *
 */
import java.util.List;

import cn.huizhi.pojo.FeeCategory;

public interface FeeCategoryService {

	/**
	 * 查询所有收入项目
	 * @return
	 */
	public List<FeeCategory> selectFeeCategory(Integer schoolId);
	
	/**
	 * 删除收入项目
	 * @return
	 */
	public boolean delFeeCategory( Integer chargeTypeId);
	
	/**
	 * 添加收入项目
	 * @return
	 */
	public Integer addFeeCategory(String chargeTypeName,String category,Integer schoolId);
}
