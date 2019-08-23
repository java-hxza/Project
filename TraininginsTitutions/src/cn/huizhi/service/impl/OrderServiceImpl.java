package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.OrderMapper;
import cn.huizhi.pojo.Order;
import cn.huizhi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderMapper orderMapper;// 注入容器

	/**
	 * 查询课时订单
	 */
	@Override
	public List<Order> selectOrderHour() {
		return orderMapper.selectOrderHour();
	}

	/**
	 * 查询时间段订单
	 */
	@Override
	public List<Order> selectOrderPeriod() {
		return orderMapper.selectOrderPeriod();
	}

	/**
	 * 查询其他订单
	 */
	@Override
	public List<Order> selectOrderOther() {
		return selectOrderOther();
	}

	/**
	 * 修改订单信息
	 */
	@Override
	public Integer updateOrderAll(Order order) {
		return orderMapper.updateOrderAll(order);
	}

	/**
	 * 添加订单
	 */
	@Override
	public Integer addOrder(Order order) {
		return orderMapper.addOrder(order);
	}

	/**
	 * 删除订单
	 */
	@Override
	public Integer delOrder(Integer orderId) {
		return orderMapper.delOrder(orderId);
	}

	@Override
	public List<Order> findOrderListBySchool(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.selectOrderListBySchool(order);
	}
}