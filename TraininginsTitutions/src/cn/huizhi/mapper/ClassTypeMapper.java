package cn.huizhi.mapper;

import java.util.List;

import cn.huizhi.pojo.ClassType;

public interface ClassTypeMapper {

	public List<ClassType> selectClassTypes(Integer schoolId);
}
