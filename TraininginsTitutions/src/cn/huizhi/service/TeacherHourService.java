package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.TeacherHour;

public interface TeacherHourService {
	
	/**
	 * 根据学校查询教师课时
	 * @param schoolId
	 * @return
	 */
	public List<TeacherHour> findTeacherHourListBySchoolId(Integer schoolId);
}
