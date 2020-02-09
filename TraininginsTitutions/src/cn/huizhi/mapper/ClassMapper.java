package cn.huizhi.mapper;
/**
 * 班级mapper
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;
import cn.huizhi.pojo.Class;;
public interface ClassMapper {
	/**
	 * 根据学校查询所有学校下的少儿班级
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectChildrenescClasses(@Param("schoolId")String schoolId);

	/**
	 * 添加少儿班级
	 * 
	 * @param childrenescClass
	 * @return
	 */
	public int insertChildrenescClass(Class childrenescClass);

	/**
	 * 修改班级信息
	 * 
	 * @param childrenescClass
	 * @return
	 */
	public int updateChildrenescClass(Class childrenescClass);

	/**
	 * 根据主键删除班级
	 * 
	 * @param childrenesClassId
	 * @return
	 */
	public int deleteChildrenescClass(Integer childrenesClassId);
	
	/**
	 * 查询班级
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectClass(Integer schoolId,Integer classTypeTime);
	
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
	public List<Class> selectVIPClass(Integer classTypeId,Integer schoolId);
	/*
	 * 根据教师主键查询班级
	 * @param teacherId
	 * @return
	 */
	public List<Class> selectClassListByTeacherId(@Param("teacherId")Integer teacherId);
	
	/**
	 * 根据班级主键查询班级信息
	 * @param classId
	 * @return
	 */
	public Class selectClassByClassId(@Param("classId")Integer classId);
	
	/**
	 * 少儿高中艺考班级
	 * @param schoolId
	 * @param classType
	 * @return
	 */
	public List<Class> selectClass2(Integer schoolId,Integer classTypeTime);
	
	/**
	 * 查询本校的班级
	 * @param schoolId
	 * @return
	 */
	public List<Class> selectMyClass(Integer schoolId);
	
	/**
	 * 删除班级
	 * @param classId
	 * @return
	 */
	public Integer delClass(@Param("classId")String classId);
	/*
	 * 删除表数据
	 * @return
	 */
	public Integer delClassTable();
	
	/**
	 * 查询学生所参与班级主键
	 */
	public List<Class> selectUnopenedClass(Integer studentId);
	
	/**
	 * 查询学生未参与班级
	 */
	public List<Class> selectNotUnopenedClass(@Param("classId")String classId,@Param("schoolId")Integer schoolId);
}
