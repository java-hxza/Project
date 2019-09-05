package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.GiftMapper;
import cn.huizhi.pojo.Gift;
import cn.huizhi.service.GiftService;

@Service
public class GiftServiceImpl implements GiftService {

	@Resource
	private GiftMapper giftMapper;// 注入容器

	/**
	 * 根据班级查找赠品
	 */
	@Override
	public List<Gift> selectGift(Integer schoolId) {
		return giftMapper.selectGift(schoolId);
	}

	/**
	 * 更新赠品数量
	 */
	@Override
	public Integer updateGift(Integer giftNumber, Integer giftId) {
		return giftMapper.updateGift(giftNumber, giftId);
	}

	
}
