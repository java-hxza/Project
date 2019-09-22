package cn.huizhi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.StudentLeaveMapper;
import cn.huizhi.pojo.StudentLeave;
import cn.huizhi.service.StudentLeaveService;
@Service
public class StudentLeaveServiceImpl implements StudentLeaveService {
	@Resource
	StudentLeaveMapper studentLeaveMapper;
	
	@Override
	public Integer insertStudentLeave(StudentLeave studentLeave) {
		// TODO Auto-generated method stub
		return studentLeaveMapper.insertStudentLeave(studentLeave);
	}


	@Override
	public List<StudentLeave> findStudentLeavesByClassId(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return studentLeaveMapper.findStudentLeavesByClassId(map);
	}


	@Override
	public List<StudentLeave> findStudentLeavesByHighClassId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return studentLeaveMapper.findStudentLeavesByHighClassId(map);
	}

}
