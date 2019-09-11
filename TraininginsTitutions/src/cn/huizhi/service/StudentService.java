package cn.huizhi.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Student;

public interface StudentService {

	/**
	 * 查询所有高中学生
	 * @return
	 */
	public List<Student> selectHigh(Integer schoolId,Map<Object,Object> map);
	
	/**
	 * 查询所有少儿学生
	 * @param feeCategory
	 * @return
	 */
	public List<Student> selectChildren(Integer schoolId,Map<Object,Object> map);
	
	/**
	 * 查询所有艺考学生
	 * @param feeCategory
	 * @return
	 */
	public List<Student> selectYiKao(Integer schoolId,Map<Object,Object> map);
	
	/**
	 * 添加学生班级查询学生主键
	 * @param stu
	 * @return
	 */
	public Student findChildrenInfoByStudnet(Student stu);
	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	public int addStudnetInfo(Student stu);
	
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
	public List<Student> selectStudentClass(Integer classId);
	
	/**
	 * 查询本校全部学生
	 * @param schoolId
	 * @return
	 */
	public List<Student> selectStudentUsedIntegral(String table,Integer schoolId);
	
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
	public Student findStudentById(Integer studentId);
	
	/**
	 * 更改学生信息
	 * @param studentId
	 * @return
	 */
	public Integer updateStudent(Student student);
}
