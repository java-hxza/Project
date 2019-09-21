package cn.huizhi.service;

import java.util.List;
import java.util.Map;


import cn.huizhi.pojo.TeacherHour;

public interface TeacherHourService {
	
	/**
	 * 根据学校查询教师课时
	 * @param schoolId
	 * @return
	 */
	public List<TeacherHour> findTeacherHourListBySchoolId(TeacherHour teacherHour );
	
	/**
	 * 查询班级课程信息
	 * @param classId
	 * @return
	 */
	public List<TeacherHour> selectCurriculumInfo(Integer classId,Integer teacherHourId,Integer schoolId);
	
	/**
	 *添加课程信息 
	 * @param teacherHour
	 * @return
	 */
	public Integer insertTeacherHour(TeacherHour teacherHour);
	
	
	/**
	 * 修改课程信息
	 * @param teacherHour
	 * @return
	 */
	public Integer updateTeacherHour(TeacherHour teacherHour);
	
	/**
	 * 删除课程信息
	 * @param teacherHourId
	 * @return
	 */
	public Integer delTeacherHour(Integer teacherHourId);
	
	/**
	 * 根据条件查询教师课程
	 * @param map
	 * @return
	 */
	public List<TeacherHour> findCurriculumInfo(Map<String, Object> map);
}
