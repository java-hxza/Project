package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.DepartMentMapper;
import cn.huizhi.pojo.DepartMent;
import cn.huizhi.service.DepartMentService;
@Service
public class DepartMentServiceImpl implements DepartMentService{
	
	@Resource
	DepartMentMapper departMentMapper;
	@Override
	public List<DepartMent> selectDepartMentListAll() {
		// TODO Auto-generated method stub
		return departMentMapper.selectDepartMentListAll();
	}

}
