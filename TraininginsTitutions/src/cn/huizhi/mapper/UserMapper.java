package cn.huizhi.mapper;

import java.util.List;

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
	public User selectUserByLogin(@Param("loginName")String loginName,@Param("loginPassword")String loginPassword,@Param("schoolId")String schoolId);
	/**
	 * 添加用户方法
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * 根据登录名校验账户是否存在 
	 * @param loginName
	 * @return
	 */
	public User selectUserByUserName(@Param("loginName")String loginName);
	
	/**
	 * 查询所有教师
	 * @param schoolId
	 * @return
	 */
	public List<User> selectUserByAll(String schoolId);
	
	/**
	 * 删除教师
	 * @param uId
	 * @return
	 */
	public Integer delTeacher(Integer uId);
	
	/**
	 * 修改教师
	 * @param user
	 * @return
	 */
	public Integer updateTeacher(User user);
	
}
