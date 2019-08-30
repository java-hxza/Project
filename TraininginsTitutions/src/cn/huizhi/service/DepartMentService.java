package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.DepartMent;

public interface DepartMentService {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<DepartMent> selectDepartMentListAll();
}
