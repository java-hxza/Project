package cn.huizhi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.StudentLeave;

public interface StudentLeaveMapper {
	
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
	public List<StudentLeave> findStudentLeavesByClassId(@Param("map")Map<String,Object> map);
	
	/**
	 * 查询高中及艺考学生请假列表
	 * @param map
	 * @return
	 */
	public List<StudentLeave> findStudentLeavesByHighClassId(@Param("map")Map<String, Object> map);
	
	
}
