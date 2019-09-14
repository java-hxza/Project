package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.huizhi.pojo.ArtStuRegistration;

public interface ArtStuRegistrationMapper {
	
	/**
	 * 根据班级主键查询学生课时
	 * @param classId
	 * @return
	 */
	public List<ArtStuRegistration> findArtStuRegistrationByClassId(@Param("classId")Integer classId);
	
	/**
	 * 批量登记
	 * @param list
	 * @return
	 */
	public Integer insertArtStuRegistration(List<ArtStuRegistration> list);
}
