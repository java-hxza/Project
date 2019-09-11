package cn.huizhi.mapper;
/**
 * 班级科别
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.DepartmentOfPediatrics;

public interface DepartmentOfPediatricsMapper {
	
	/**
	 * 查询所有班级科别
	 * @return
	 */
	public List<DepartmentOfPediatrics> selectDepartmentOfPediatrics(Integer schoolId);
	
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
	
	/**
	 * 根据班级主键查询班级可是单价
	 * @param classId
	 * @return
	 */
	public DepartmentOfPediatrics findDepartmentOfByClassId(@Param("classId")Integer classId); 
}
