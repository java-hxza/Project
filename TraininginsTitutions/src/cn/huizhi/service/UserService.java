package cn.huizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.User;

public interface UserService {

	/**
	 * 添加用户方法
	 * 
	 * @param user
	 * @return
	 */
	public Integer addtUser(User user);

	/**
	 * 根据登录名校验账户是否存在
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByUserName(String loginName);
	/**
	 * 管理员登录
	 * @param loginName
	 * @param loginPassword
	 * @param schoolId
	 * @return
	 */
	public User findUserByLogin(String loginName, String loginPassword );
	

	/**
	 * 查询全部管理员
	 * @return
	 */
	public List<User> findListAll(String uId);
	
	/**
	 * 修改操作员信息
	 * @param user
	 * @return
	 */
	public Integer modifyUser(User user);
	/**
	 * 删除教师
	 * @param uId
	 * @return
	 */
	public Integer delUser(Integer uId);
}
