package cn.huizhi.service;

/**
 * 教师分类
 */
import java.util.List;

import cn.huizhi.pojo.Teacher;

public interface TeacherService {

	
	/**
	 * 查询所有教师
	 * @return
	 */
	public List<Teacher> selectTeacher();
}
