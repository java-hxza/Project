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
	
	
}
