package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.DepartmentOfPediatricsMapper;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.service.DepartmentOfPediatricsService;
/**
 * 班级科别
 * @author wye
 *
 */
@Service
public class DepartmentOfPediatricsServiceImpl implements DepartmentOfPediatricsService{
	@Resource
	DepartmentOfPediatricsMapper departmentOfPediatricsMapper;
	
	/**
	 * 获取全部科别
	 */
	public List<DepartmentOfPediatrics> findDepartmentOfPediatrics(Integer schoolId) {
		return departmentOfPediatricsMapper.selectDepartmentOfPediatrics(schoolId);
	}
	/**
	 * 新增班级科别
	 */
	public int addDepartmentOfPediatrics(DepartmentOfPediatrics departmentOfPediatrics) {
		return departmentOfPediatricsMapper.insertDepartmentOfPediatrics(departmentOfPediatrics);
	}
	/**
	 * 删除班级科别
	 */
	public int delDepartmentOfPediatrics(Integer dpId) {
		return departmentOfPediatricsMapper.deleteDepartmentOfPediatrics(dpId);
	}
	@Override
	public DepartmentOfPediatrics findDepartmentOfByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return departmentOfPediatricsMapper.findDepartmentOfByClassId(classId);
	}
	
	
	
	
}
