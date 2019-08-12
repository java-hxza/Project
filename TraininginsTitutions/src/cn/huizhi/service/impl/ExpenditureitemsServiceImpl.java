package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ExpenditureitemsMapper;
import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.service.ExpenditureitemsService;

@Service
public class ExpenditureitemsServiceImpl implements ExpenditureitemsService{

	@Resource
	private ExpenditureitemsMapper expenditureitemsMapper;//注入容器

	/**
	 * 查询所有支出项目
	 */
	@Override
	public List<Expenditureitems> selectExpenditureitems(String schoolId) {
		return expenditureitemsMapper.selectExpenditureitems(schoolId);
	}

	/**
	 * 删除支出项目
	 */
	@Override
	public Integer delExpenditureitems(Integer expenditureitemsId) {
		return expenditureitemsMapper.delExpenditureitems(expenditureitemsId);
	}

	/**
	 * 添加支出项目
	 */
	@Override
	public Integer addExpenditureitems(String expenditureitemsName, String category,String schoolId) {
		return expenditureitemsMapper.addExpenditureitems(expenditureitemsName, category,schoolId);
	}
	
	
}
