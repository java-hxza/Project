package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.SchoolAccount;

public interface SchoolAccountService {
	/**
	 * 根据学校主键查询学校账户信息
	 * @param schoolId
	 * @return
	 */
	public List<SchoolAccount> findSchoolAccountsBySchoolId(Integer schoolId);
}
