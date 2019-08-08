package cn.huizhi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.UserMapper;
import cn.huizhi.pojo.User;
import cn.huizhi.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;//注入容器
	
	/**
	 * 登录业务处理
	 */
	public User findUserByLogin(String loginName, String loginPassword, Integer schoolId) {
		return   userMapper.selectUserByLogin(loginName, loginPassword, schoolId);
	}

	public int addtUser(User user) {
		return userMapper.insertUser(user);
	}

}
