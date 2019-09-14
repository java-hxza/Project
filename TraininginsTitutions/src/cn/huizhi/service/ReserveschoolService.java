package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Reserveschool;

public interface ReserveschoolService {

	/**
	 * 添加未分学校学生
	 * @param reserveschool
	 * @return
	 */
	public Integer addReserve(Reserveschool reserveschool);
	/**
	 * 查询未分班的艺考学生
	 * @param schoolId
	 * @return
	 */
	public List<Reserveschool> findReserveSchoolBySchoolId(@Param("schoolId")Integer schoolId);
	
	/**
	 * 批量分班
	 * @param list
	 * @return
	 */
	public Integer updateReserveState(List<Reserveschool> list);
}
