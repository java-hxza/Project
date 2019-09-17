package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.huizhi.mapper.StudentLeaveMapper;
import cn.huizhi.pojo.StudentLeave;
import cn.huizhi.service.StudentLeaveService;

public class StudentLeaveServiceImpl implements StudentLeaveService {
	@Resource
	StudentLeaveMapper studentLeaveMapper;
	
	@Override
	public Integer insertStudentLeave(StudentLeave studentLeave) {
		// TODO Auto-generated method stub
		return studentLeaveMapper.insertStudentLeave(studentLeave);
	}

	@Override
	public List<StudentLeave> findStudentLeavesByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return studentLeaveMapper.findStudentLeavesByClassId(classId);
	}

}
