package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.TeacherTypeMapper;
import cn.huizhi.pojo.TeacherType;
import cn.huizhi.service.TeacherTypeService;

@Service
public class TeacherTypeServiceImpl implements TeacherTypeService{

	@Resource
	private TeacherTypeMapper teacherTypeMapper;//注入容器
	
	/**
	 * 查询所有教师分类
	 */
	@Override
	public List<TeacherType> selectTeacherType() {
		return teacherTypeMapper.selectTeacherType();
	}

	
}
