package cn.huizhi.service;

import java.util.List;


import cn.huizhi.pojo.Order;
/**
 * 订单
 * @author wye
 *
 */
public interface OrderService {
	/**
	 * 根据学校主键查询你订单信息
	 * @param schoolId
	 * @return
	 */
	public List<Order> findOrderListBySchool(Order order);
}
