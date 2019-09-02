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
	 * 查询班级
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectClass(Integer schoolId);
}
