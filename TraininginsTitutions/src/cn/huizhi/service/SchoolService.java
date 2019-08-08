package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.School;

public interface SchoolService {
	/**
	 * 查询所有学校
	 * @return
	 */
	public List<School> findSchools();
	/**
	 * 根据城市查询学校
	 * @param cityId
	 * @return
	 */
	public List<School> findSchoolByCityId(Integer cityId);
	
	/**
	 * 添加学校
	 * @param school
	 * @return
	 */
	public int addSchool(School school);
}
