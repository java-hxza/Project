package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ClassTypeMapper;
import cn.huizhi.pojo.ClassType;
import cn.huizhi.service.ClassTypeService;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {

	@Resource
	private ClassTypeMapper classTypeMapper;

	@Override
	public List<ClassType> selectClassTypes(Integer schoolId) {
		return classTypeMapper.selectClassTypes(schoolId);
	}

}
