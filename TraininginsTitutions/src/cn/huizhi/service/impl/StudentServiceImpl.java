package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.StudentMapper;
import cn.huizhi.pojo.Student;
import cn.huizhi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentMapper studentMapper;//注入容器

	/**
	 * 查询所有高中学生
	 */
	@Override
	public List<Student> selectHigh(Integer schoolId) {
		return studentMapper.selectHigh(schoolId);
	}

	/**
	 * 查询所有少儿学生
	 */
	@Override
	public List<Student> selectChildren(Integer schoolId) {
		return studentMapper.selectChildren(schoolId);
	}

	/**
	 * 查询所有艺考学生
	 */
	@Override
	public List<Student> selectYiKao(Integer schoolId) {
		return studentMapper.selectYiKao(schoolId);
	}
	
	
}
