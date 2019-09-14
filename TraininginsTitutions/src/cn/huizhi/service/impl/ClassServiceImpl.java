package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ClassMapper;
import cn.huizhi.pojo.Class;
import cn.huizhi.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Resource
	ClassMapper classMapper;

	public List<Class> findChildrenescClasses(String schoolId) {
		return classMapper.selectChildrenescClasses(schoolId);
	}

	public int addChildrenescClass(Class childrenescClass) {
		return classMapper.insertChildrenescClass(childrenescClass);
	}

	public int modifyChildrenescClass(Class childrenescClass) {
		return 0;
	}

	public int delChildrenescClass(Integer childrenesClassId) {
		return 0;
	}

	@Override
	public List<Class> selectClassListByTeacherId(Integer teacherId) {
		// TODO Auto-generated method stub
		return classMapper.selectClassListByTeacherId(teacherId);
	}


	/**
	 * 查询班级
	 */
	@Override
	public List<Class> selectClass(Integer schoolId,Integer classType) {
		return classMapper.selectClass(schoolId,classType);
	}

	@Override
	public List<Class> selectClassAll(Integer schoolId) {
		return classMapper.selectClassAll(schoolId);
	}

	@Override
	public List<Class> selectVIPClass(Integer classTypeId, Integer classType, Integer schoolId) {
		return classMapper.selectVIPClass(classTypeId, classType, schoolId);
	}
	
	
	public Class findClassByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return classMapper.selectClassByClassId(classId);
	}

}
