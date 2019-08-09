package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.UserTypeMapper;
import cn.huizhi.pojo.UserType;
import cn.huizhi.service.UserTypeService;
@Service
public class UserTypeServiceImpl implements UserTypeService{
	/**
	 * 开启注解装配
	 */
	@Resource
	UserTypeMapper userTypeMapper;
	
	public List<UserType> findUserTypes() {
		return userTypeMapper.selectUserTypes();
	}

}
