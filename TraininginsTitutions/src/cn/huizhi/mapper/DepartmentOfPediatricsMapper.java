package cn.huizhi.mapper;
/**
 * 班级科别
 * @author wye
 *
 */

import java.util.List;

import cn.huizhi.pojo.DepartmentOfPediatrics;

public interface DepartmentOfPediatricsMapper {
	
	/**
	 * 查询所有班级科别
	 * @return
	 */
	public List<DepartmentOfPediatrics> selectDepartmentOfPediatrics();
	
	/**
	 * 添加班级科别
	 */
	public int insertDepartmentOfPediatrics(DepartmentOfPediatrics departmentOfPediatrics);
	
	/**
	 * 删除班级科别
	 * @param dpId
	 * @return
	 */
	public int deleteDepartmentOfPediatrics(Integer dpId);
}
