package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.ChildrenescClass;
/**
 * 少儿学生班级
 * @author wye
 *
 */
public interface ChildrenescClassService {
	/**
	 * 根据学校查询所有学校下的少儿班级
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<ChildrenescClass> findChildrenescClasses(Integer schoolId);

	/**
	 * 添加少儿班级
	 * 
	 * @param childrenescClass
	 * @return
	 */
	public int addChildrenescClass(ChildrenescClass childrenescClass);

	/**
	 * 修改班级信息
	 * 
	 * @param childrenescClass
	 * @return
	 */
	public int modifyChildrenescClass(ChildrenescClass childrenescClass);

	/**
	 * 根据主键删除班级
	 * 
	 * @param childrenesClassId
	 * @return
	 */
	public int delChildrenescClass(Integer childrenesClassId);
}
