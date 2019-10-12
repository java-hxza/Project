package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.ClassType;

public interface ClassTypeService {

	public List<ClassType> selectClassTypes(Integer schoolId);
}
