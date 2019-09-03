package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;

import cn.huizhi.pojo.HighesStuRegistration;

public interface HighesStuRegistrationMapper {

	/**
	 * 根据班级查询学生课时
	 * @param classId
	 * @return
	 */
	public List<HighesStuRegistration> selectHighesStuRegistrationListByClassId(@Param("classId")Integer classId);
	/**
	 * 查询教室上课明细
	 * @param classId
	 * @return
	 */
	public List<HighesStuRegistration> selectStudentHourDetailed(@Param("classId")Integer classId);
}
