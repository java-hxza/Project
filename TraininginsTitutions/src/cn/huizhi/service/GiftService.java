package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.Gift;

public interface GiftService {

	/**
	 * 根据学校查找赠品
	 * @param schoolId
	 * @return
	 */
	public List<Gift> selectGift(Integer schoolId);
	
	/*
	 * 更新赠品数量
	 */
	public Integer updateGift(Integer giftNumber,Integer giftId);
	
	/**
	 * 添加赠品
	 * @param gift
	 * @return
	 */
	public Integer addGift(Gift gift);
	
	/**
	 * 删除赠品
	 * @param giftId
	 * @return
	 */
	public Integer delGift(Integer giftId);
}
