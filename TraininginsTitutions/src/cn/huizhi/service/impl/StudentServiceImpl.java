package cn.huizhi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.StudentMapper;
import cn.huizhi.pojo.Student;
import cn.huizhi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;// 注入容器

	/**
	 * 查询所有高中学生
	 */
	@Override
	public Integer selectHigh(Integer schoolId, Map<Object, Object> map) {
		return studentMapper.selectHigh(schoolId, map);
	}

	/**
	 * 查询所有少儿学生
	 */
	@Override
	public Integer selectChildren(Integer schoolId, Map<Object, Object> map) {
		return studentMapper.selectChildren(schoolId, map);
	}

	/**
	 * 查询所有艺考学生
	 */
	@Override
	public Integer selectYiKao(Integer schoolId, Map<Object, Object> map) {
		return studentMapper.selectYiKao(schoolId, map);
	}

	@Override
	public Student findChildrenInfoByStudnet(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.selectChildrenInfoByStudnet(stu);
	}

	@Override
	public int addStudnetInfo(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.insertStudnetInfo(stu);
	}

	/**
	 * 更新总课时
	 */
	@Override
	public Integer updateStudentOrderHour(Integer studentHour, Integer studentId, Double integral) {
		return studentMapper.updateStudentOrderHour(studentHour, studentId, integral);
	}

	/**
	 * 根据班级查找学生
	 */
	@Override
	public List<Student> selectStudentClass(String table,Integer classId,Integer state) {
		return studentMapper.selectStudentClass(table,classId,state);
	}

	@Override
	public List<Student> selectStudentUsedIntegral(String table, Integer schoolId) {
		return studentMapper.selectStudentUsedIntegral(table, schoolId);
	}

	@Override
	public Student selectStudentId(String studentName, String parentName, Integer studentSex) {
		return studentMapper.selectStudentId(studentName, parentName, studentSex);
	}

	public Student findStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentMapper.findStudentById(studentId);
	}

	@Override
	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent(student);
	}

	@Override
	public Integer updateStuHour(List<Student> list) {
		// TODO Auto-generated method stub
		return studentMapper.updateStuHour(list);
	}

	@Override
	public Integer delStudentTable() {
		// TODO Auto-generated method stub
		return studentMapper.delStudentTable();
	}

	@Override
	public List<Student> findArtStudentResverSchoolInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return studentMapper.findArtStudentResverSchoolInfo(map);
	}

	@Override
	public List<Student> findHighStudentResverSchoolInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return studentMapper.findHighStudentResverSchoolInfo(map);
	}

	@Override
	public List<Student> selectAllStudent(Integer schoolId) {
		return studentMapper.selectAllStudent(schoolId);
	}

	@Override
	public List<Student> selectByClassIdStudent(Integer schoolId, Integer classId, String studentName) {
		return studentMapper.selectByClassIdStudent(schoolId, classId, studentName);
	}

}
