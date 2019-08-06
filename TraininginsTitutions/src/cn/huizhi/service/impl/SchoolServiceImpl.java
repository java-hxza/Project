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

	public List<School> sfindSchoolByCityId(Integer cityId) {
		return schoolMapper.selectSchoolByCityId(cityId);
	}

}
