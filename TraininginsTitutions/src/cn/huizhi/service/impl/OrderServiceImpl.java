package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.huizhi.mapper.OrderMapper;
import cn.huizhi.pojo.Order;
import cn.huizhi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderMapper orderMapper;// 注入容器

	@Override
	public Integer selectCountHour(Integer schoolId) {
		return orderMapper.selectCountHour(schoolId);
	}

	@Override
	public Integer selectCount(Integer schoolId) {
		return orderMapper.selectCount(schoolId);
	}

	@Override
	public Integer selectCountOther(Integer schoolId) {
		return orderMapper.selectCountOther(schoolId);
	}

	@Override
	public Integer selectCountExpenditure(Integer schoolId) {
		return orderMapper.selectCountExpenditure(schoolId);
	}

	/**
	 * 查询课时订单
	 */
	@Override
	public List<Order> selectOrderHour(Integer schoolId,Integer page,String studentName,Integer classId) {
		return orderMapper.selectOrderHour(schoolId,page,studentName,classId);
	}

	/**
	 * 查询时间段订单
	 */
	@Override
	public List<Order> selectOrderPeriod(Integer schoolId,Integer page,String studentName,Integer classId) {
		return orderMapper.selectOrderPeriod(schoolId,page,studentName,classId);
	}

	/**
	 * 查询其他订单
	 */
	@Override
	public List<Order> selectOrderOther(Integer schoolId,Integer page,String studentName,Integer classId) {
		return orderMapper.selectOrderOther(schoolId,page,studentName,classId);
	}

	/**
	 * 查询费用支出订单
	 */
	@Override
	public List<Order> selectOrderExpenditure(Integer schoolId,Integer page,String studentName,Integer classId) {
		return orderMapper.selectOrderExpenditure(schoolId,page,studentName,classId);
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

	public List<Order> selectChildrenFeeSituation(Integer classId, Integer studentId, String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		return orderMapper.selectChildrenFeeSituation(classId, studentId, startTime, endTime);
	}

	@Override
	public List<Order> selectHighsFeeSituation(Integer classId, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return orderMapper.selectHighsFeeSituation(classId, startTime, endTime);
	}

	@Override
	public List<Order> selectOrderListByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return orderMapper.selectOrderListByStudentId(studentId);
	}

	public List<Order> selectStduentHour(Integer time, Integer schoolId, String studentName, Integer number) {
		return orderMapper.selectStduentHour(time, schoolId, studentName, number);
	}

	@Override
	public List<Order> selectStduentDay(String time, Integer schoolId, String studentName, Integer number) {
		return orderMapper.selectStduentDay(time, schoolId, studentName, number);
	}

	@Override
	public List<Order> selectOrderPeriods(Integer schoolId,Integer page,String studentName,Integer classId) {
		return orderMapper.selectOrderPeriods(schoolId,page,studentName,classId);
	}

	@Override
	public List<Order> selectArtFeeSituation(Integer classId, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return orderMapper.selectArtFeeSituation(classId, startTime, endTime);
	}

	@Override
	public Integer delOrderTable() {
		// TODO Auto-generated method stub
		return orderMapper.delOrderTable();
	}

	@Override
	public List<Order> selectActivityOrders(String startTime, Integer activityId, Integer schoolId) {
		return orderMapper.selectActivityOrders(startTime, activityId, schoolId);
	}

	@Override
	public List<Order> selectGiftes(String startTime, Integer giftId, Integer schoolId) {
		return orderMapper.selectGiftes(startTime, giftId, schoolId);
	}

	@Override
	public List<Order> selectArtFeeSituation(Integer classId) {
		return null;
	}

	@Override
	public List<Order> RecruitStudentes(String studentName, String startTime, Integer classes, Integer teacherId,
			Integer schoolId) {
		return orderMapper.RecruitStudentes(studentName, startTime, classes, teacherId, schoolId);
	}

	@Override
	public Integer BulkChargingInsert(List<Order> order) {
		return orderMapper.BulkChargingInsert(order);
	}

	@Override
	public Integer selectCountRefund(Integer schoolId) {
		return orderMapper.selectCountRefund(schoolId);
	}

	@Override
	public List<Order> selectOrderRefund(Integer schoolId, Integer page, String studentName, Integer classId) {
		return orderMapper.selectOrderRefund(schoolId, page, studentName, classId);
	}

	@Override
	public Order selectOrderTF(Integer studentId) {
		return orderMapper.selectOrderTF(studentId);
	}

	@Override
	public List<Order> queryOrderByRenew(Integer schoolId, Integer classId) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderByRenew(schoolId, classId);
	}

	
}