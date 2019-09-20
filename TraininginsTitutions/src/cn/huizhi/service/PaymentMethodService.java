package cn.huizhi.service;

import java.util.List;

import cn.huizhi.pojo.PaymentMethod;

public interface PaymentMethodService {

	/**
	 * 查询所有账户信息
	 * @return
	 */
	public List<PaymentMethod> selectPaymentMethod();
	
	/**
	 * 删除账户信息
	 * @param PaymentmethodId
	 * @return
	 */
	public Integer delPaymentMethod(Integer paymentmethodId);
	
	/**
	 * 添加账户信息
	 * @param PaymentmethodName
	 * @return
	 */
	public Integer addPaymentMethod(String paymentmethodName);
	
	/**
	 * 清空表数据
	 * @return
	 */
	public Integer delPaymentMethodTable();
}
