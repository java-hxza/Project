package cn.huizhi.mapper;
/**
 * 教师课时
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.TeacherHour;

public interface TeacherHourMapper {
	
	/**
	 * 根据学校查询教师课时
	 * @param schoolId
	 * @return
	 */
	public List<TeacherHour> selecTeacherHourListBySchoolId(@Param("schoolId")Integer schoolId);
	
	
}
