
package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Order;

public interface OrderMapper {

	/**
	 * 查询课时订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderHour(Integer schoolId);

	/**
	 * 查询时间段订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderPeriod(Integer schoolId);

	/**
	 * 查询艺考时间段订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderPeriods(Integer schoolId);

	/**
	 * 查询其他订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderOther(Integer schoolId);

	/**
	 * 查询费用支出订单
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectOrderExpenditure(Integer schoolId);

	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	public Integer updateOrderAll(Order order);

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public Integer addOrder(Order order);

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 * @return
	 */
	public Integer delOrder(Integer orderId);

	/**
	 * 根据学校主键查询你订单信息
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectOrderListBySchool(Order order);

	/**
	 * 根据条件查询支出项目
	 * 
	 * @param order
	 * @return
	 */
	public List<Order> selectExpenOrderList(Order order);

	/**
	 * <<<<<<< HEAD 查询学生 赠品 税分
	 * 
	 * @param student
	 * @return
	 */
	public List<Order> selectUsedIntegral(@Param("stuId") String stuId);

	/*
	 * 查询少儿学生收费情况
	 * 
	 * @param classId
	 * 
	 * @return
	 */
	public List<Order> selectChildrenFeeSituation(@Param("classId") Integer classId,
			@Param("studentId") Integer studentId);

	/**
	 * 查询高中学生收费情况
	 * 
	 * @param classId
	 * @return
	 */
	public List<Order> selectHighsFeeSituation(@Param("classId") Integer classId);

	/**
	 * 查询高中学生收费情况
	 * 
	 * @param classId
	 * @return
	 */
	public List<Order> selectArtFeeSituation(@Param("classId") Integer classId);

	/**
	 * 查询学生收费
	 * 
	 * @param studentId
	 * @return
	 */
	public List<Order> selectOrderListByStudentId(@Param("studentId") Integer studentId);

	/*
	 * 课时提醒
	 * @param time
	 * 
	 * @return
	 */
	public List<Order> selectStduentHour(@Param("time") Integer time, @Param("schoolId") Integer schoolId,@Param("studentName") String studentName,@Param("number") Integer number);

	/**
	 * 时间段提醒
	 * 
	 * @param time
	 * @return
	 */
	public List<Order> selectStduentDay(@Param("time") Integer time, @Param("schoolId") Integer schoolId,@Param("studentName") String studentName,@Param("number") Integer number);

	/**
	 * 查找参与活动订单
	 * @param startTime
	 * @param activityId
	 * @return
	 */
	public List<Order> selectActivityOrders(@Param("startTime")String startTime,@Param("activityId")Integer activityId,@Param("schoolId")Integer schoolId);

	/**
	 * 查找获得赠品订单
	 * @param startTime
	 * @param giftId
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectGiftes(@Param("startTime")String startTime,@Param("giftId")Integer giftId,@Param("schoolId")Integer schoolId);

}
