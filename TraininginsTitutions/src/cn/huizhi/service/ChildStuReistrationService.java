package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.ChildStuReistration;

public interface ChildStuReistrationService {
	/**
	 * 根据班级查询学生课时统计
	 * @param classId
	 * @return
	 */
	public List<ChildStuReistration> findchildStuReistrationListByClass(Integer classId);
}
