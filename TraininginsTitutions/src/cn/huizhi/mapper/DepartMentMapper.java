package cn.huizhi.mapper;
/**
 * 部门
 * @author wye
 *
 */

import java.util.List;

import cn.huizhi.pojo.DepartMent;

public interface DepartMentMapper {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<DepartMent> selectDepartMentListAll();
	
}
