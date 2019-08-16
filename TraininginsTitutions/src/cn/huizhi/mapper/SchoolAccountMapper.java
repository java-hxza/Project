package cn.huizhi.mapper;
/**
 * 学校账户
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.SchoolAccount;

public interface SchoolAccountMapper {
	/**
	 * 根据学校主键查询学校账户信息
	 * @param schoolId
	 * @return
	 */
	public List<SchoolAccount> selectSchoolAccountsBySchoolId(@Param("schoolId")Integer schoolId);
	
	
	
}
