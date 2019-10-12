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

	@Override
	public Integer addClassTypes(ClassType classType) {
		return classTypeMapper.addClassTypes(classType);
	}

	@Override
	public Integer delClassTypes(Integer classTypeId) {
		return classTypeMapper.delClassTypes(classTypeId);
	}

	@Override
	public Integer updateClassTypes(ClassType classType) {
		return classTypeMapper.updateClassTypes(classType);
	}

}
