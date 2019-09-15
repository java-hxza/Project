package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.ChildrenesClassStudnet;

/**
 * 班级学生
 * @author wye
 *
 */
public interface ChildrenesClassStudnetMapper {
	
	/**
	 * 新增班级学生
	 * @param childrenesClassStudnet
	 * @return
	 */
	public int insertChildrenesClassStudnet(ChildrenesClassStudnet childrenesClassStudnet);
	
	
	/**
	 * 根据班级查询班级学生
	 * @param classId
	 * @return
	 */
	public List<ChildrenesClassStudnet> findChildrenesClassStudnetByClassId(@Param("classId")Integer classId);
	
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
	
}
