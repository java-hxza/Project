package cn.huizhi.service.impl;

import java.util.List;

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
	public User findUserByLogin(String loginName, String loginPassword ,Integer schoolType) {
		return   userMapper.selectUserByLogin(loginName, loginPassword ,schoolType);
	}
	/**
	 * 创建用户
	 */
	public Integer addtUser(User user) {
		return userMapper.insertUser(user);
	}
	/**
	 * 根据的登录名校验账号是否存在
	 */
	public User findUserByUserName(String loginName) {
		return userMapper.selectUserByUserName(loginName);
	}
	@Override
	public List<User> findListAll(String uId) {
		return userMapper.selectListAll(uId);
	}
	@Override
	public Integer modifyUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}
	@Override
	public Integer delUser(Integer uId) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(uId);
	}
	

	
	
	
	
}
