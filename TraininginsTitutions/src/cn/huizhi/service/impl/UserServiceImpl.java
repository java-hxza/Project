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
	public User findUserByLogin(String loginName, String loginPassword, String schoolId) {
		return   userMapper.selectUserByLogin(loginName, loginPassword, schoolId);
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
	
	
<<<<<<< HEAD
=======
	/**
	 * 删除教师
	 */
	@Override
	public Integer delTeacher(Integer uId) {
		return userMapper.delTeacher(uId);
	}
	
	/**
	 * 修改教师
	 */
	@Override
	public Integer updateTeacher(User user) {
		return userMapper.updateTeacher(user);
	}

	
	/**
	 * 添加教师
	 */
	@Override
	public Integer addTeacher(User user) {
		return userMapper.addTeacher(user);
	}
>>>>>>> branch 'master' of https://github.com/tianmabdqn/Project.git
	
	
	
}
