package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.TeacherDiction;

public interface TeacherDictionMapper {

	/**
	 * 删除教师
	 * @param schoolId
	 * @param teacherId
	 * @return
	 */
	public Integer delTeacherDiction(Integer schoolId,Integer teacherId);
	
	/**
	 * 添加教师
	 * @param schoolId
	 * @param teacherId
	 * @return
	 */
	public Integer addTeacherDiction(Integer schoolId,Integer teacherId);
	
	
	/**
	 * 根据教师主键查询教师学校信息
	 * @param teacherId
	 * @return
	 */
	public List<TeacherDiction> selecTeacherDictionListByTeacherId(@Param("teacherId")Integer teacherId);
	
	/**
	 * 添加时查询权限是否存在
	 * @param schoolId
	 * @param teacherId
	 * @return
	 */
	public TeacherDiction selectTeacherDictionBySchoolIdAndTeacherId(@Param("schoolId")Integer schoolId,@Param("teacherId")Integer teacherId);
}
