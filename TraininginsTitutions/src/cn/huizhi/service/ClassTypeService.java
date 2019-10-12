package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.ClassType;

public interface ClassTypeService {

	/**
	 * 查看本校班级类型
	 * @param schoolId
	 * @return
	 */
	public List<ClassType> selectClassTypes(Integer schoolId);
	
	/**
	 * 添加班级类型
	 * @param classType
	 * @return
	 */
	public Integer addClassTypes(ClassType classType);
	
	/**
	 * 删除班级类型
	 * @param classTypeId
	 * @return
	 */
	public Integer delClassTypes(Integer classTypeId);
	
	/**
	 * 修改班级类型
	 * @param classType
	 * @return
	 */
	public Integer updateClassTypes(ClassType classType);
}
