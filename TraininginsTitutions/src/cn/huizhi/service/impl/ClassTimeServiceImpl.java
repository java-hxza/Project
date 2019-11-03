package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ClassTimeMapper;
import cn.huizhi.pojo.ClassTime;
import cn.huizhi.service.ClassTimeService;

@Service
public class ClassTimeServiceImpl implements ClassTimeService {

	@Resource
	private ClassTimeMapper classTimeMapper;

	@Override
	public List<ClassTime> selectClassTime(Integer schoolId) {
		return classTimeMapper.selectClassTime(schoolId);
	}

	@Override
	public Integer delClassTime(Integer classTimeId) {
		return classTimeMapper.delClassTime(classTimeId);
	}

	@Override
	public Integer addClassTime(ClassTime classTime) {
		return classTimeMapper.addClassTime(classTime);
	}

}
