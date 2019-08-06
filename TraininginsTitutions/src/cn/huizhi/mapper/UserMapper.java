package cn.huizhi.mapper;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.User;
/**
 * 登录Mapper
 * @author wye
 *
 */
public interface UserMapper {
		
	/**
	 * 登录方法根据登录名密码学校进行查询
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */
	public User selectUserByLogin(@Param("loginName")String loginName,@Param("loginPassword")String loginPassword,@Param("schoolId")Integer schoolId);
	
	
	
}
