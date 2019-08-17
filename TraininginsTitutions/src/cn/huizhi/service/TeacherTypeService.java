package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.TeacherType;

public interface TeacherTypeService {

	
	/**
	 * 查询所有教师分类
	 * @return
	 */
	public List<TeacherType> selectTeacherType();
}
