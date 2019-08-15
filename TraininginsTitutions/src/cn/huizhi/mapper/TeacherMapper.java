package cn.huizhi.mapper;

/**
 * 教师
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Teacher;

public interface TeacherMapper {

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
	public Teacher selectTeacherByLogin(@Param("teacherName")String loginName,@Param("loginPassword")String loginPassword,@Param("schoolId")Integer schoolId);
	/**
	 * 添加教师
	 * @param teacher
	 * @return
	 */
	public int	insertTeacher(Teacher teacher);
}
