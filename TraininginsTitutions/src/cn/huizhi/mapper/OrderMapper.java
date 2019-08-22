package cn.huizhi.mapper;
/**
 * 订单信息
 * @author wye
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Order;

public interface OrderMapper {
	/**
	 * 根据学校主键查询你订单信息
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectOrderListBySchool(Order order);
	
}
