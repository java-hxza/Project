package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.HighesClassStudnet;

public interface HighesClassStudnetMapper {
	
	/**
	 * 根据班级主键查询班级学生
	 * @param classId
	 * @return
	 */
	public List<HighesClassStudnet> findHighesClassStudnetListByClassId(@Param("classId")Integer classId);
}
