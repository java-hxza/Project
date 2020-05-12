package cn.huizhi.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.ChildrenesClassStudnet;
/**
 * 少儿班级学生
 * @author wye
 *
 */
public interface ChildrenesClassStudnetService {
	/**
	 * 新增班级学生
	 * @param childrenesClassStudnet
	 * @return
	 */
	public int addChildrenesClassStudnet(ChildrenesClassStudnet childrenesClassStudnet);
	
	
	/**
	 * 根据班级查询班级学生
	 * @param classId
	 * @return
	 */
	public List<ChildrenesClassStudnet> findChildrenesClassStudnetByClassId(Integer classId);
	
	/**
	 * 转班
	 * @param cStudnet
	 * @return
	 */
	public Integer updateChildrenesClassStudnet(ChildrenesClassStudnet cStudnet);
	
	/**
	 * 新增高中班级学生
	 * @param childrenesClassStudnet
	 * @return
	 */
	public int insertChildrenesClassStudnets(ChildrenesClassStudnet childrenesClassStudnet);
	
	/**
	 * 少儿退学
	 * @param childrenesClassStudnet
	 * @return
	 */
	public Integer updateChildrenStudentState(ChildrenesClassStudnet childrenesClassStudnet);
	
	/**
	 * 批量结业
	 * 
	 * @param map
	 * @return
	 */
	public Integer updateChildrenStudentGradution(List list);
	/**
	 * 按着时间查询学生
	 * @param classId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<ChildrenesClassStudnet> findChildrenesClassStudnetByClassIdAndTime(String classId,String startTime,String endTime,String studentName,String teacherName,String schoolTime);


 

}
