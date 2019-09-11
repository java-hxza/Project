package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.ArtStuRegistration;

public interface ArtStuRegistrationService {
	/**
	 * 根据班级主键查询学生课时
	 * @param classId
	 * @return
	 */
	public List<ArtStuRegistration> findArtStuRegistrationByClassId(Integer classId);
	
	
	/**
	 * 批量登记
	 * @param list
	 * @return
	 */
	public Integer insertArtStuRegistration(List<ArtStuRegistration> list);
}
