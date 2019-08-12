package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.DepartmentOfPediatrics;

public interface DepartmentOfPediatricsService {

	/**
	 * 查询所有班级科别
	 * @return
	 */
	public List<DepartmentOfPediatrics> findDepartmentOfPediatrics();
	
	/**
	 * 添加班级科别
	 */
	public int addDepartmentOfPediatrics(DepartmentOfPediatrics departmentOfPediatrics);
	
	/**
	 * 删除班级科别
	 * @param dpId
	 * @return
	 */
	public int delDepartmentOfPediatrics(Integer dpId);
}
