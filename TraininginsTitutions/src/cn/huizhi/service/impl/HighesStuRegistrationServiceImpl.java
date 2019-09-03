package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.HighesStuRegistrationMapper;
import cn.huizhi.pojo.HighesStuRegistration;
import cn.huizhi.service.HighesStuRegistrationService;
@Service
public class HighesStuRegistrationServiceImpl implements HighesStuRegistrationService{
	@Resource
	HighesStuRegistrationMapper highesStuRegistrationMapper;
	
	@Override
	public List<HighesStuRegistration> selectHighesStuRegistrationListByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return highesStuRegistrationMapper.selectHighesStuRegistrationListByClassId(classId);
	}

	@Override
	public List<HighesStuRegistration> selectStudentHourDetailed(Integer classId) {
		// TODO Auto-generated method stub
		return highesStuRegistrationMapper.selectStudentHourDetailed(classId);
	}

}
