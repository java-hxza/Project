package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.SchoolMapper;
import cn.huizhi.pojo.School;
import cn.huizhi.service.SchoolService;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Resource
	SchoolMapper schoolMapper;//注入到容器
	
	
	public List<School> findSchools() {
		return schoolMapper.selectSchools();
	}

	public List<School> findSchoolByCityId(Integer cityId,Integer cityProperId) {
		return schoolMapper.selectSchoolByCityId(cityId,cityProperId);
	}



	@Override
	public int addSchool(School school) {
		return schoolMapper.insertSchool(school);
	}

	@Override
	public School selectSchoolById(Integer schoolId) {
		// TODO Auto-generated method stub
		return schoolMapper.selectSchoolById(schoolId);
	}

	@Override
	public Integer updateSchoolNumber(Integer schoolId, Integer schoolNumber) {
		return schoolMapper.updateSchoolNumber(schoolId, schoolNumber);
	}

	
}
