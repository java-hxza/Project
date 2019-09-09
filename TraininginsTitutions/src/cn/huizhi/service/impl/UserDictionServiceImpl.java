package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.UserDictionMapper;
import cn.huizhi.pojo.UserDiction;
import cn.huizhi.service.UserDictionService;

@Service
public class UserDictionServiceImpl implements UserDictionService{
	@Resource
	UserDictionMapper userDictionMapper;
	
	@Override
	public List<UserDiction> findDictionListByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userDictionMapper.findDictionListByUserId(userId);
	}

}
