package cn.huizhi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ReserveschoolMapper;
import cn.huizhi.pojo.Reserveschool;
import cn.huizhi.service.ReserveschoolService;

@Service
public class ReserveschoolServiceImpl implements ReserveschoolService{

	@Resource
	private ReserveschoolMapper reserveschoolMapper;

	@Override
	public Integer addReserve(Reserveschool reserveschool) {
		return reserveschoolMapper.addReserve(reserveschool);
	}
	
	
}
