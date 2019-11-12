package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.TeacherType;

public interface TeacherTypeMapper {

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
	public Integer insertTeacherType(@Param("teacherTypeName")String teacherTypeName);
	
	/**
	 * 删除教师职业
	 * @param teacherTypeId
	 * @return
	 */
	public Integer delTeacherType(@Param("teacherTypeId")String teacherTypeId);
}
