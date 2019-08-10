package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ChildrenescClassMapper;
import cn.huizhi.pojo.ChildrenescClass;
import cn.huizhi.service.ChildrenescClassService;

@Service
public class ChildrenescClassServiceImpl implements ChildrenescClassService{
	@Resource
	ChildrenescClassMapper childrenescClassMapper;
	
	
	public List<ChildrenescClass> findChildrenescClasses(Integer schoolId) {
		return childrenescClassMapper.selectChildrenescClasses(schoolId);
	}

	public int addChildrenescClass(ChildrenescClass childrenescClass) {
		return 0;
	}

	public int modifyChildrenescClass(ChildrenescClass childrenescClass) {
		return 0;
	}

	public int delChildrenescClass(Integer childrenesClassId) {
		return 0;
	}

}
