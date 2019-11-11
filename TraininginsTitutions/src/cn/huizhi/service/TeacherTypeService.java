package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.TeacherType;

public interface TeacherTypeService {

	
	/**
	 * 查询所有教师分类
	 * @return
	 */
	public List<TeacherType> selectTeacherType();
	
	/**
	 * 添加教师职业
	 * @param teacherTypeName
	 * @return
	 */
	public Integer insertTeacherType( String teacherTypeName);
	
	/**
	 * 删除教师职业
	 * @param teacherTypeId
	 * @return
	 */
	public Integer delTeacherType(String teacherTypeId);
}
