package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ActivityMapper;
import cn.huizhi.pojo.Activity;
import cn.huizhi.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityMapper activityMapper;

	/**
	 * 查找学校活动
	 */
	@Override
	public List<Activity> selectActivitySchool(Integer schoolId) {
		return activityMapper.selectActivitySchool(schoolId);
	}

	/**
	 * 添加学校活动
	 */
	@Override
	public Integer addActivitySchool(Activity activity) {
		return activityMapper.addActivitySchool(activity);
	}

	/**
	 * 删除学校活动
	 */
	@Override
	public Integer delActivitySchool(Integer activityId) {
		return activityMapper.delActivitySchool(activityId);
	}

}
