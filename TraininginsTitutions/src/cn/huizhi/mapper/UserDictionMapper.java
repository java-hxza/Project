package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.UserDiction;

public interface UserDictionMapper {
	
	/**
	 * 根据用户主键查询学校权限
	 * @param userId
	 * @return
	 */
	public List<UserDiction> findDictionListByUserId(@Param("userId")Integer userId);
	
}
