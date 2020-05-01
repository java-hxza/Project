package cn.huizhi.service;

import cn.huizhi.pojo.StudentTool;

public interface StudentToolService {

	/**
	 * 插入学生新增班主任
	 */
	public Integer addStudentTool(StudentTool studentTool);
	
	/**
	 * 修改学生信息
	 * @param studentTool
	 * @return
	 */
	Integer updateStudentTool(StudentTool studentTool);
}
