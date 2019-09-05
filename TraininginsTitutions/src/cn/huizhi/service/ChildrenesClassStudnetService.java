package cn.huizhi.service;

import java.util.List;

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
}
