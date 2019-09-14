package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.ReserveSchool;

public interface ReserveSchoolMapper {
	
	/**
	 * 查询未分班的艺考学生
	 * @param schoolId
	 * @return
	 */
	public List<ReserveSchool> findReserveSchoolBySchoolId(@Param("schoolId")Integer schoolId);
	
	/**
	 * 批量分班
	 * @param list
	 * @return
	 */
	public Integer updateReserveState(List<ReserveSchool> list);
}
