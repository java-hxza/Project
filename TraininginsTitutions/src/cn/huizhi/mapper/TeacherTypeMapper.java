package cn.huizhi.mapper;

import java.util.List;

import cn.huizhi.pojo.TeacherType;

public interface TeacherTypeMapper {

	/**
	 * 查询所有教师分类
	 * @return
	 */
	public List<TeacherType> selectTeacherType();
}
