package cn.huizhi.service;


import cn.huizhi.pojo.User;

public interface UserService {
	/**
	 * 登录方法根据登录名密码学校进行查询
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */
	public User findUserByLogin(String loginName,String loginPassword,Integer schoolId);
	
	
}
