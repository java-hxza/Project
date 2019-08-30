package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.FeeCategoryMapper;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.service.FeeCategoryService;

@Service
public class FeeCategoryServiceImpl implements FeeCategoryService {

	@Resource
	private FeeCategoryMapper feecategoryMapper;// 注入容器

	/**
	 * 查询所有收入项目
	 */
	@Override
	public List<FeeCategory> selectFeeCategory(Integer schoolId) {
		return feecategoryMapper.selectFeeCategory(schoolId);
	}

	/**
	 * 删除收入项目
	 */
	@Override
	public boolean delFeeCategory(Integer chargeTypeId) {
		if (feecategoryMapper.delFeeCategory(chargeTypeId) == 1) {
			return true;
		}
		return false;
	}
	/**
	 * 添加收入项目
	 */
	@Override
	public Integer addFeeCategory(String chargeTypeName,String category,Integer schoolId) {
		return feecategoryMapper.addFeeCategory(chargeTypeName, category,schoolId);
	}

}
