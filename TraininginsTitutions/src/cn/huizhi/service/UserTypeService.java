package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.UserType;
/**
 * 用户类型service
 * @author wye
 *
 */
public interface UserTypeService {
	/**
	 * 查询所有用户类型
	 * @return
	 */
	public List<UserType> findUserTypes();
}
