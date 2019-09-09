package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.Activity;

public interface ActivityService {

	/**
	 * 查找学校活动
	 * @param schoolId
	 * @return
	 */
	public List<Activity> selectActivitySchool(Integer schoolId);
	
	/**
	 * 添加学校活动
	 * 
	 * @param activity
	 * @return
	 */
	public Integer addActivitySchool(Activity activity);

	/**
	 * 删除学校活动
	 * 
	 * @param activityId
	 * @return
	 */
	public Integer delActivitySchool(Integer activityId);
}
