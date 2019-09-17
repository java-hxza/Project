package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.StudentLeave;

public interface StudentLeaveService {

	/**
	 * 学生请假插入
	 * @param studentLeave
	 * @return
	 */
	public Integer insertStudentLeave(StudentLeave studentLeave);
	
	/**
	 * 根据班级主键查询请假学生
	 * @param classId
	 * @return
	 */
	public List<StudentLeave> findStudentLeavesByClassId(Integer classId);
}
