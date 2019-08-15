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
	public List<Teacher> selectTeacher(Integer schoolId) {
		return teacherMapper.selectTeacher(schoolId);
	}

	
	/**
	 * 删除教师
	 */
	@Override
	public Integer delTeacher(Integer uId) {
		return teacherMapper.delTeacher(uId);
	}

	@Override
	public Teacher findTeacherByLogin(String loginName, String loginPassword, Integer schoolId) {
		return teacherMapper.selectTeacherByLogin(loginName, loginPassword, schoolId);
	}

	@Override
	public int addTeacher(Teacher teacher) {
		return teacherMapper.insertTeacher(teacher);
	}

	public List<Teacher> findTeachersByTeacherTypeId(Integer teacherTypeId, Integer schoolId) {
		return teacherMapper.selecTeachersByTeacherTypeId(teacherTypeId, schoolId);
	}
	
	/**
	 * 修改教师
	 */
	@Override
	public Integer updateTeacher(Teacher teacher) {
		return updateTeacher(teacher);
	}
	
	/**
	 * 添加教师
	 */
	@Override
	public Integer addTeacher(Teacher teacher) {
		return addTeacher(teacher);
	}
	
}
