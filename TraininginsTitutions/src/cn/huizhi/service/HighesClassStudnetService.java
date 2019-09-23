package cn.huizhi.service;

import java.util.List;
import java.util.Map;


import cn.huizhi.pojo.HighesClassStudnet;

public interface HighesClassStudnetService {
	
	/**
	 * 根据班级主键查询班级学生
	 * @param classId
	 * @return
	 */
	public List<HighesClassStudnet> findHighesClassStudnetListByClassId(Integer classId);
	
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
	public Integer updateHighStudentGradution(List list);
}
