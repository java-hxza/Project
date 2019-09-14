package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.ChildStuReistration;

public interface ChildStuReistrationService {
	/**
	 * 根据班级查询学生课时统计
	 * @param classId
	 * @return
	 */
	public List<ChildStuReistration> findchildStuReistrationListByClass(Integer classId);
	
	
	/**
	 * 查询教师上课明细
	 * @param classId
	 * @return
	 */
	public List<ChildStuReistration> selectTeacherDetailed(Integer classId);
	
	/**
	 * 批量登记学生上课
	 * @param list
	 * @return
	 */
	public Integer insertChilStuRistration(List<ChildStuReistration> list);
}
