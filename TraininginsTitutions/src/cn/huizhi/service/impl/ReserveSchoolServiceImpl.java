package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ReserveSchoolMapper;
import cn.huizhi.pojo.ReserveSchool;
import cn.huizhi.service.ReserveSchoolService;
@Service
public class ReserveSchoolServiceImpl implements ReserveSchoolService{
	@Resource
	ReserveSchoolMapper reserveSchoolMapper;
	
	@Override
	public List<ReserveSchool> findReserveSchoolBySchoolId(Integer schoolId) {
		// TODO Auto-generated method stub
		return reserveSchoolMapper.findReserveSchoolBySchoolId(schoolId);
	}

	@Override
	public Integer updateReserveState(List<ReserveSchool> list) {
		// TODO Auto-generated method stub
		return reserveSchoolMapper.updateReserveState(list);
	}

}
