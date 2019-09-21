package cn.huizhi.service.impl;

import java.util.List;
import java.util.Map;

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
	public List<TeacherHour> findTeacherHourListBySchoolId(TeacherHour teacherHour ) {
		// TODO Auto-generated method stub
		return teacherHourMapper.selecTeacherHourListBySchoolId( teacherHour );
	}

	@Override
	public List<TeacherHour> selectCurriculumInfo(Integer classId,Integer teacherHourId,Integer schoolId) {
		// TODO Auto-generated method stub
		return teacherHourMapper.selectCurriculumInfo(classId,teacherHourId,schoolId);
	}

	@Override
	public Integer insertTeacherHour(TeacherHour teacherHour) {
		// TODO Auto-generated method stub
		return teacherHourMapper.insertTeacherHour(teacherHour);
	}

	@Override
	public Integer updateTeacherHour(TeacherHour teacherHour) {
		// TODO Auto-generated method stub
		return teacherHourMapper.updateTeacherHour(teacherHour);
	}

	@Override
	public Integer delTeacherHour(Integer teacherHourId) {
		// TODO Auto-generated method stub
		return teacherHourMapper.delTeacherHour(teacherHourId);
	}

	@Override
	public List<TeacherHour> findCurriculumInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return teacherHourMapper.findCurriculumInfo(map);
	}

}
