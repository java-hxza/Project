package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ClassMapper;
import cn.huizhi.pojo.Class;
import cn.huizhi.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{
	@Resource
	ClassMapper ClassMapper;
	
	
	public List<Class> findChildrenescClasses(String schoolId) {
		return ClassMapper.selectChildrenescClasses(schoolId);
	}

	public int addChildrenescClass(Class childrenescClass) {
		return ClassMapper.insertChildrenescClass(childrenescClass);
	}

	public int modifyChildrenescClass(Class childrenescClass) {
		return 0;
	}

	public int delChildrenescClass(Integer childrenesClassId) {
		return 0;
	}



}
