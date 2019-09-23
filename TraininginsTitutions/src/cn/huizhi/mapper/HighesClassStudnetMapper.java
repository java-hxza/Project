package cn.huizhi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.HighesClassStudnet;

public interface HighesClassStudnetMapper {
	
	/**
	 * 根据班级主键查询班级学生
	 * @param classId
	 * @return
	 */
	public List<HighesClassStudnet> findHighesClassStudnetListByClassId(@Param("classId")Integer classId);
	
	/**
	 * 修改学生状态
	 * @param state
	 * @param studentId
	 * @return
	 */
	public Integer updateHighStudentState(HighesClassStudnet cStudnet);
	
	/**
	 * 高中学生转班
	 * @param cStudnet
	 * @return
	 */
	public Integer updateHighStudentClass(HighesClassStudnet cStudnet);
	
	/**
	 * 批量结业
	 * 
	 * @param map
	 * @return
	 */
	public Integer updateHighStudentGradution(@Param("list") List list);
}
