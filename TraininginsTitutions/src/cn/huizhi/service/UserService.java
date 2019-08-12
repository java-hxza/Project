package cn.huizhi.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.User;

public interface UserService {
	/**
	 * 登录方法根据登录名密码学校进行查询
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */
	public User findUserByLogin(String loginName,String loginPassword,String schoolId);
	
	/**
	 * 添加用户方法
	 * @param user
	 * @return
	 */
	public int addtUser(User user);
	
	/**
	 * 根据登录名校验账户是否存在 
	 * @param loginName
	 * @return
	 */
	public User findUserByUserName(String loginName);
	
	/**
	 * 查询所有教师
	 * @param schoolId
	 * @return
	 */
	public List<User> selectUserByAll();
}
