package cn.huizhi.service;

public interface TeacherDictionService {

	
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
}
