package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.User;

public interface UserService {

	/**
	 * 添加用户方法
	 * 
	 * @param user
	 * @return
	 */
	public Integer addtUser(User user);

	/**
	 * 根据登录名校验账户是否存在
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByUserName(String loginName);

	public User findUserByLogin(String loginName, String loginPassword, String schoolId);

}
