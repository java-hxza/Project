package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.TeacherMapper;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Resource
	private TeacherMapper teacherMapper;//注入容器

	/**
	 * 查询所有教师
	 */
	@Override
	public List<Teacher> selectTeacher() {
		return teacherMapper.selectTeacher();
	}
	
	
}
