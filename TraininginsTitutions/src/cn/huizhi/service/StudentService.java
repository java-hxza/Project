package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.Student;

public interface StudentService {

	/**
	 * 查询所有高中学生
	 * @return
	 */
	public List<Student> selectHigh(Integer schoolId);
	
	/**
	 * 查询所有少儿学生
	 * @param feeCategory
	 * @return
	 */
	public List<Student> selectChildren(Integer schoolId);
	
	/**
	 * 查询所有艺考学生
	 * @param feeCategory
	 * @return
	 */
	public List<Student> selectYiKao(Integer schoolId);
}
