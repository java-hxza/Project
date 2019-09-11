package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.HighesStuRegistration;

public interface HighesStuRegistrationService {
	

	/**
	 * 根据班级查询学生课时
	 * @param classId
	 * @return
	 */
	public List<HighesStuRegistration> selectHighesStuRegistrationListByClassId(Integer classId);
	
	
	/**
	 * 查询教师上课明细
	 * @param classId
	 * @return
	 */
	public List<HighesStuRegistration> selectStudentHourDetailed(Integer classId);
	
	/**
	 * 批量登记
	 * @param list
	 * @return
	 */
	public Integer insertHighesStuRegistration(List<HighesStuRegistration> list);
}
