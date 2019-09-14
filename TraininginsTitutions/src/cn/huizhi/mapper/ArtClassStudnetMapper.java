package cn.huizhi.mapper;

import java.util.List;

import cn.huizhi.pojo.ArtClassStudnet;

public interface ArtClassStudnetMapper {
	
	/**
	 * 根据班级主键查询班级学生
	 * @param classId
	 * @return
	 */
	public List<ArtClassStudnet> findArtClassStudnetListByClassId(Integer classId);
	
	/**
	 * 批量插入学生
	 * @param list
	 * @return
	 */
	public Integer insertArtClassStudnetList(List<ArtClassStudnet> list);
	
	/**
	 * 艺考学生转班
	 * @param art
	 * @return
	 */
	public Integer updateArtClassStudentByClass(ArtClassStudnet art);
	
	/**
	 * 艺考学生退学
	 * @param art
	 * @return
	 */
	public Integer updateHighStudentState(ArtClassStudnet art);
}
