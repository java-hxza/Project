package cn.huizhi.service.impl;

import java.util.List;

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

	@Override
	public List<Reserveschool> findReserveSchoolBySchoolId(Integer schoolId) {
		// TODO Auto-generated method stub
		return reserveschoolMapper.findReserveSchoolBySchoolId(schoolId);
	}

	@Override
	public Integer updateReserveState(List<Reserveschool> list) {
		// TODO Auto-generated method stub
		return reserveschoolMapper.updateReserveState(list);
	}
	
	
}
