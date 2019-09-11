package cn.huizhi.mapper;
/**
 * 收入项目
 * @author 86175
 *
 */

import java.util.List;

import cn.huizhi.pojo.FeeCategory;

public interface FeeCategoryMapper {

	/**
	 * 查询所有收入项目
	 * @return
	 */
	public List<FeeCategory> selectFeeCategory(Integer schoolId);
	
	/**
	 * 删除收入项目
	 * @return
	 */
	public Integer delFeeCategory( Integer chargeTypeId);
	
	/**
	 * 添加收入项目
	 * @return
	 */
	public Integer addFeeCategory( FeeCategory feeCategory);
}
