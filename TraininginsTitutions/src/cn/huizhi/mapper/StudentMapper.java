package cn.huizhi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.metadata.Table;

import cn.huizhi.pojo.Student;

public interface StudentMapper {

	/**
	 * 查询所有高中学生
	 * @return
	 */
	public List<Student> selectHigh(Integer schoolId,@Param("map")Map<Object, Object> map);
	
	/**
	 * 查询所有少儿学生
	 * @param feeCategory
	 * @return
	 */
	public List<Student> selectChildren(Integer schoolId,@Param("map")Map<Object, Object> map);
	
	/**
	 * 查询所有艺考学生
	 * @param feeCategory
	 * @return
	 */
	public List<Student> selectYiKao(Integer schoolId,@Param("map")Map<Object, Object> map);
	
	/**
	 * 添加学生班级查询学生主键
	 * @param stu
	 * @return
	 */
	public Student selectChildrenInfoByStudnet(Student stu);
	
	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	public int insertStudnetInfo(Student stu);
	
	/**
	 * 更新总课时
	 * @param studentHour
	 * @return
	 */
	public Integer updateStudentOrderHour(Integer studentHour,Integer studentId,Double integral);
	
	/**
	 * 根据班级查找学生
	 * @param classId
	 * @return
	 */
	public List<Student> selectStudentClass(@Param("table") String table ,@Param("classId")Integer classId);
	
	/**
	 * 查询本校全部学生
	 * @param schoolId
	 * @return
	 */
	public List<Student> selectStudentUsedIntegral(@Param("table")String table,@Param("schoolId")Integer schoolId);

	/**
	 * 查询插入学生的id
	 * @param studentName
	 * @param parentName
	 * @param studentSex
	 * @return
	 */
	public Student selectStudentId(String studentName,String parentName,Integer studentSex);
	
	/**
	 * 根据主键查询学生
	 * @param studentId
	 * @return
	 */
	public Student findStudentById(@Param("studentId")Integer studentId);
	
	/**
	 * 更改学生信息
	 * @param studentId
	 * @return
	 */
	public Integer updateStudent(Student student);
	
<<<<<<< HEAD
	/**
	 * 批量修改学生课时
	 * @param list
	 * @return
	 */
	public Integer updateStuHour(List<Student> list);
=======

	
>>>>>>> branch 'master' of https://github.com/tianmabdqn/TraininginsTitutions.git
}
