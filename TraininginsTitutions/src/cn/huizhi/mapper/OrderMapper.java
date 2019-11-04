
package cn.huizhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Order;

public interface OrderMapper {

	/**
	 * 查询课时订单总数
	 * @param schoolId
	 * @return
	 */
	public Integer selectCountHour(Integer schoolId);
	
	/**
	 * 查询时间段订单总数
	 * @param schoolId
	 * @return
	 */
	public Integer selectCount(Integer schoolId);
	
	/**
	 * 查询其他订单总数
	 * @param schoolId
	 * @return
	 */
	public Integer selectCountOther(Integer schoolId);
	
	/**
	 * 查询支出订单总数
	 * @param schoolId
	 * @return
	 */
	public Integer selectCountExpenditure(Integer schoolId);
	
	/**
	 * 查询退费订单总数
	 * @param schoolId
	 * @return
	 */
	public Integer selectCountRefund(Integer schoolId);
	
	/**
	 * 查询课时订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderHour(@Param("schoolId")Integer schoolId,@Param("page")Integer page,@Param("studentName")String studentName,@Param("classId")Integer classId);

	/**
	 * 查询时间段订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderPeriod(@Param("schoolId")Integer schoolId,@Param("page")Integer page,@Param("studentName")String studentName,@Param("classId")Integer classId);

	/**
	 * 查询艺考时间段订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderPeriods(@Param("schoolId")Integer schoolId,@Param("page")Integer page,@Param("studentName")String studentName,@Param("classId")Integer classId);

	/**
	 * 查询其他订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderOther(@Param("schoolId")Integer schoolId,@Param("page")Integer page,@Param("studentName")String studentName,@Param("classId")Integer classId);

	/**
	 * 查询费用支出订单
	 * 
	 * @param schoolId
	 * @return
	 */
	public List<Order> selectOrderExpenditure(@Param("schoolId")Integer schoolId,@Param("page")Integer page,@Param("studentName")String studentName,@Param("classId")Integer classId);

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
			@Param("studentId") Integer studentId,@Param("startTime")String startTime,@Param("endTime")String endTime);

	/**
	 * 查询高中学生收费情况
	 * 
	 * @param classId
	 * @return
	 */
	public List<Order> selectHighsFeeSituation(@Param("classId") Integer classId,@Param("startTime")String startTime,@Param("endTime")String endTime);

	/**
	 * 查询高中学生收费情况
	 * 
	 * @param classId
	 * @return
	 */
	public List<Order> selectArtFeeSituation(@Param("classId") Integer classId,@Param("startTime")String startTime,@Param("endTime")String endTime);

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
	public List<Order> selectStduentDay(@Param("time") String time, @Param("schoolId") Integer schoolId,@Param("studentName") String studentName,@Param("number") Integer number);

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

	/*
	 * 删除表数据
	 * @return
	 */
	public Integer delOrderTable();
	
	/**
	 * 招生报表
	 * @param schoolId
	 * @return
	 */
	public List<Order> RecruitStudentes(@Param("studentName")String studentName,@Param("startTime")String startTime,@Param("classes")Integer classes,@Param("teacherId")Integer teacherId,@Param("schoolId")Integer schoolId);

	/**
	 * 批量添加时间段订单
	 * @param order
	 * @return
	 */
	public Integer BulkChargingInsert(@Param("order") List<Order> order);
	
	/**
	 * 查询退费订单
	 * 
	 * @return
	 */
	public List<Order> selectOrderRefund(@Param("schoolId")Integer schoolId,@Param("page")Integer page,@Param("studentName")String studentName,@Param("classId")Integer classId);

	/**
	 * 根据退费学生查找最后一次订单
	 * @param studentId
	 * @return
	 */
	public Order selectOrderTF(Integer studentId);
}
