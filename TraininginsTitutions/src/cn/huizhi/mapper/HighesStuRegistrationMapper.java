package cn.huizhi.mapper;

import java.util.List;

import cn.huizhi.pojo.HighesStuRegistration;

public interface HighesStuRegistrationMapper {

	/**
	 * 根据班级查询学生课时
	 * @param classId
	 * @return
	 */
	public List<HighesStuRegistration> selectHighesStuRegistrationListByClassId(Integer classId);
	
}
