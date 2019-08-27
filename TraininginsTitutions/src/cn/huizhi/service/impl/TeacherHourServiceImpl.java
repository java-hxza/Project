package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.TeacherHourMapper;
import cn.huizhi.pojo.TeacherHour;
import cn.huizhi.service.TeacherHourService;
@Service
public class TeacherHourServiceImpl implements TeacherHourService {
	
	@Resource
	TeacherHourMapper teacherHourMapper;
	
	@Override
	public List<TeacherHour> findTeacherHourListBySchoolId(Integer schoolId) {
		// TODO Auto-generated method stub
		return teacherHourMapper.selecTeacherHourListBySchoolId(schoolId);
	}

}
