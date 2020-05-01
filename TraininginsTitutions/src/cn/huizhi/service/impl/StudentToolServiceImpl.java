package cn.huizhi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.StudentToolMapper;
import cn.huizhi.pojo.StudentTool;
import cn.huizhi.service.StudentToolService;

@Service
public class StudentToolServiceImpl implements StudentToolService{

	@Resource
	private StudentToolMapper studentToolMapper;
	
	@Override
	public Integer addStudentTool(StudentTool studentTool) {
		return studentToolMapper.addStudentTool(studentTool);
	}

	@Override
	public Integer updateStudentTool(StudentTool studentTool) {
		// TODO Auto-generated method stub
		return studentToolMapper.updateStudentTool(studentTool);
	}

	
}
