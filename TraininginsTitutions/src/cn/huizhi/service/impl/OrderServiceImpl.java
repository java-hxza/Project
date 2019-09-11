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
	public List<Order> selectOrderHour(Integer schoolId) {
		return orderMapper.selectOrderHour(schoolId);
	}

	/**
	 * 查询时间段订单
	 */
	@Override
	public List<Order> selectOrderPeriod(Integer schoolId) {
		return orderMapper.selectOrderPeriod(schoolId);
	}

	/**
	 * 查询其他订单
	 */
	@Override
	public List<Order> selectOrderOther(Integer schoolId) {
		return orderMapper.selectOrderOther(schoolId);
	}

	/**
	 * 查询费用支出订单
	 */
	@Override
	public List<Order> selectOrderExpenditure(Integer schoolId) {
		return orderMapper.selectOrderExpenditure(schoolId);
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

	@Override
	public List<Order> findExpenOrderList(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.selectExpenOrderList(order);
	}

	@Override
	public List<Order> selectUsedIntegral(String student) {
		return orderMapper.selectUsedIntegral(student);
	}
	
	
	public List<Order> selectChildrenFeeSituation(Integer classId) {
		// TODO Auto-generated method stub
		return orderMapper.selectChildrenFeeSituation(classId);
	}

	@Override
	public List<Order> selectHighsFeeSituation(Integer classId) {
		// TODO Auto-generated method stub
		return orderMapper.selectHighsFeeSituation(classId);
	}
}