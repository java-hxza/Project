

package cn.huizhi.mapper;
import java.util.List;
import cn.huizhi.pojo.Order;

public interface OrderMapper {

	/**
	 * 查询课时订单
	 * @return
	 */
	public List<Order> selectOrderHour(Integer schoolId);
	
	/**
	 * 查询时间段订单
	 * @return
	 */
	public List<Order> selectOrderPeriod(Integer schoolId);
	
	/**
	 * 查询其他订单
	 * @return
	 */
	public List<Order> selectOrderOther(Integer schoolId);
	
	/**
	 * 查询费用支出订单
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectOrderExpenditure(Integer schoolId);
	
	/**
	 * 修改订单
	 * @param order
	 * @return
	 */
	public Integer updateOrderAll(Order order);
	
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	public Integer addOrder(Order order);
	
	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 */
	public Integer delOrder(Integer orderId);

	/**
	 * 根据学校主键查询你订单信息
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectOrderListBySchool(Order order);


}
