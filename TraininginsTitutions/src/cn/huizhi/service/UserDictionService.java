package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.UserDiction;

public interface UserDictionService {
	/**
	 * 根据用户主键查询学校权限
	 * @param userId
	 * @return
	 */
	public List<UserDiction> findDictionListByUserId(Integer userId);
	

	/**
	 * 操作员授权
	 * @param userDiction
	 * @return
	 */
	public Integer insertUserDiction(UserDiction userDiction);
}
