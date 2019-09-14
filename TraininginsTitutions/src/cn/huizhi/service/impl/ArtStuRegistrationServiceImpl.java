package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ArtStuRegistrationMapper;
import cn.huizhi.pojo.ArtStuRegistration;
import cn.huizhi.service.ArtStuRegistrationService;
@Service
public class ArtStuRegistrationServiceImpl implements ArtStuRegistrationService{
	
	@Resource
	ArtStuRegistrationMapper artStuRegistrationMapper;
	
	@Override
	public List<ArtStuRegistration> findArtStuRegistrationByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return artStuRegistrationMapper.findArtStuRegistrationByClassId(classId);
	}

	@Override
	public Integer insertArtStuRegistration(List<ArtStuRegistration> list) {
		// TODO Auto-generated method stub
		return artStuRegistrationMapper.insertArtStuRegistration(list);
	}

}
