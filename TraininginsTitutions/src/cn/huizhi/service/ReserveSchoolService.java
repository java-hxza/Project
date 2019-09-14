package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.ReserveSchool;

public interface ReserveSchoolService {
	/**
	 * 查询未分班的艺考学生
	 * @param schoolId
	 * @return
	 */
	public List<ReserveSchool> findReserveSchoolBySchoolId(Integer schoolId);
	
	/**
	 * 批量分班
	 * @param list
	 * @return
	 */
	public Integer updateReserveState(List<ReserveSchool> list);
}
