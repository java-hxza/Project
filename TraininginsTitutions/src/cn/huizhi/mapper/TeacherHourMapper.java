package cn.huizhi.mapper;
/**
 * 教师课时
 * @author wye
 *
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.TeacherHour;

public interface TeacherHourMapper {
	
	/**
	 * 根据学校查询教师课时
	 * @param schoolId
	 * @return
	 */
	public List<TeacherHour> selecTeacherHourListBySchoolId(TeacherHour teacherHour );
	/**
	 * 查询班级课程信息
	 * @param classId
	 * @return
	 */
	public List<TeacherHour> selectCurriculumInfo(@Param("classId")Integer classId,@Param("teacherHourId")Integer teacherHourId,@Param("schoolId")Integer schoolId);
	
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
	public Integer delTeacherHour(@Param("teacherHourId")Integer teacherHourId);
	
	/**
	 * 根据条件查询教师课程
	 * @param map
	 * @return
	 */
	public List<TeacherHour> findCurriculumInfo(@Param("map")Map<String, Object> map);
}
