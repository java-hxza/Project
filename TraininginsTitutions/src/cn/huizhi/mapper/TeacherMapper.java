package cn.huizhi.mapper;

/**
 * 教师分类
 */
import java.util.List;

import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;

public interface TeacherMapper {

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
	public Integer addTeacher(Teacher teacher );
}
