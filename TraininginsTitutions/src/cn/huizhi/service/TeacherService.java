package cn.huizhi.service;

/**
 * 教师分类
 */
import java.util.List;


import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;

public interface TeacherService {

	
	/**
	 * 查询所有教师
	 * @return
	 */
	public List<Teacher> selectTeacher(Integer schoolId);
	
	/**
	 * 删除教师
	 * @param uId
	 * @return
	 */
	public Integer delTeacher(Integer uId);
	
	/**
	 * 修改教师
	 * @param user
	 * @return
	 */
	public Integer updateTeacher(Teacher teacher);
	
	/**
	 * 添加教师
	 * @param user
	 * @return
	 */
	
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
	public Integer	addTeacher(Teacher teacher);
	
	
	/**
	 * 根据学校主键和教师类别主键查询老师
	 * @param teacherTypeId
	 * @param schoolId
	 * @return
	 */
	public List<Teacher> findTeachersByTeacherTypeId(Integer teacherTypeId,Integer schoolId);
	
}
