package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.OrderMapper;
import cn.huizhi.pojo.Order;
import cn.huizhi.service.OrderService;
/**
 * 订单
 * @author wye
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	
	@Resource
	OrderMapper orderMapper;
	
	@Override
	public List<Order> findOrderListBySchool(Order order) {
		return orderMapper.selectOrderListBySchool(order);
	}

}
