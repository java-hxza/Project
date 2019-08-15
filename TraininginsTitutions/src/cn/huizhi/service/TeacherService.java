package cn.huizhi.service;

/**
 * 教师分类
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Teacher;

public interface TeacherService {

	
	/**
	 * 查询所有教师
	 * @return
	 */
	public List<Teacher> selectTeacher();
	
	/**
	 * 教师登录
	 * @param loginName
	 * @param loginPassword
	 * @param schoolId
	 * @return
	 */
	public Teacher findTeacherByLogin(String loginName,String loginPassword,Integer schoolId);
	/**
	 * 添加教师
	 * @param teacher
	 * @return
	 */
	public int	addTeacher(Teacher teacher);
}
