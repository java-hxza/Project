package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.TeacherDictionMapper;
import cn.huizhi.pojo.TeacherDiction;
import cn.huizhi.service.TeacherDictionService;

@Service
public class TeacherDictionServiceImpl implements TeacherDictionService{

	@Resource
	private TeacherDictionMapper teacherDictionMapper;//注入容器

	
	/**
	 * 删除教师
	 */
	@Override
	public Integer delTeacherDiction(Integer schoolId, Integer teacherId) {
		return teacherDictionMapper.delTeacherDiction(schoolId, teacherId);
	}

	/**
	 * 添加教师
	 */
	@Override
	public Integer addTeacherDiction(Integer schoolId, Integer teacherId) {
		return teacherDictionMapper.addTeacherDiction(schoolId, teacherId);
	}

	@Override
	public List<TeacherDiction> findTeacherDictionListByTeacherId(Integer teacherId) {
		// TODO Auto-generated method stub
		return teacherDictionMapper.selecTeacherDictionListByTeacherId(teacherId);
	}

	@Override
	public TeacherDiction findTeacherDictionBySchoolIdAndTeacherId(Integer schoolId, Integer teacherId) {
		// TODO Auto-generated method stub
		return teacherDictionMapper.selectTeacherDictionBySchoolIdAndTeacherId(schoolId, teacherId);
	}
	
	
}
