package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.ClassTime;

public interface ClassTimeService {

	/**
	 * 查看本校上课时间
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<ClassTime> selectClassTime(Integer schoolId);

	/**
	 * 删除本校上课时间
	 * 
	 * @param classTimeId
	 * @return
	 */
	public Integer delClassTime(Integer classTimeId);

	/**
	 * 添加本校上课时间
	 * 
	 * @param classTime
	 * @return
	 */
	public Integer addClassTime(ClassTime classTime);
	/**
	 * 添加本校上课时间
	 * 
	 * @param classTime
	 * @return
	 */
	public Integer updateClassTime(ClassTime classTime);
}
