package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Class;
/**
 * 少儿学生班级
 * @author wye
 *
 */
public interface ClassService {
	/**
	 * 根据学校查询所有学校下的少儿班级
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<Class> findChildrenescClasses(String schoolId);

	/**
	 * 添加少儿班级
	 * 
	 * @param childrenescClass
	 * @return
	 */
	public int addChildrenescClass(Class childrenescClass);

	/**
	 * 修改班级信息
	 * 
	 * @param childrenescClass
	 * @return
	 */
	public int modifyChildrenescClass(Class childrenescClass);

	/**
	 * 根据主键删除班级
	 * 
	 * @param childrenesClassId
	 * @return
	 */
	public int delChildrenescClass(Integer childrenesClassId);
	
	/**
	 * 根据教师主键查询班级
	 * @param teacherId
	 * @return
	 */
	public List<Class> selectClassListByTeacherId(Integer teacherId);
	
	/*
	 * 查询班级
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectClass(Integer schoolId,Integer classType);
	
	/**
	 * 查询普通班和vip班
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectClassAll(Integer schoolId);
	
	/**
	 * 特定条件查询班级
	 * @return
	 */
	public List<Class> selectVIPClass(Integer classTypeId,Integer classType,Integer schoolId);
	
	
	/**
	 * 根据班级主键查询班级信息
	 * @param classId
	 * @return
	 */
	public Class findClassByClassId(Integer classId);
	
	/**
	 * 少儿高中艺考班级
	 * @param schoolId
	 * @param classType
	 * @return
	 */
	public List<Class> selectClass2(Integer schoolId,Integer classType);
	
	/**
	 * 查询本校的班级
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectMyClass(Integer schoolId);
}
