package cn.huizhi.mapper;
/**
 * 学校mapper
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.School;
import cn.huizhi.pojo.Teacher;

public interface SchoolMapper {
	/**
	 * 查询所有学校
	 * @return
	 */
	public List<School> selectSchools();
	/**
	 * 根据城市查询学校
	 * @param cityId
	 * @return
	 */
	public List<School> selectSchoolByCityId(@Param("cityId")Integer cityId,@Param("cityProperId")Integer cityProperId);
	
	/**
	 * 添加学校
	 * @param school
	 * @return
	 */
	public int insertSchool(School school);
	
	/**
	 * 根据学校主键查询学校信息
	 * @return
	 */
	public School selectSchoolById(@Param("schoolId")Integer schoolId);
	

}
