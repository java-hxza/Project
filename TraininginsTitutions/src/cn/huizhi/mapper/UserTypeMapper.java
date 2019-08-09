package cn.huizhi.mapper;
/**
 * 用户类型
 * @author wye
 *
 */

import java.util.List;

import cn.huizhi.pojo.UserType;

public interface UserTypeMapper {
	/**
	 * 查询所有用户类型
	 * @return
	 */
	public List<UserType> selectUserTypes();
}
