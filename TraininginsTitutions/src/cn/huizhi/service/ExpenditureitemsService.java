package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.Expenditureitems;

public interface ExpenditureitemsService {

	/**
	 * 查询所有支出项目
	 * @return
	 */
	public List<Expenditureitems> selectExpenditureitems(Integer feeCategory);
	
	/**
	 * 删除支出项目
	 * @param expenditureitemsId
	 * @return
	 */
	public Integer delExpenditureitems(Integer expenditureitemsId);
	
	/**
	 * 添加支出项目
	 * @return
	 */
	public Integer addExpenditureitems(String expenditureitemsName,String category,Integer feeCategory);
}
