package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.PaymentMethodMapper;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

	@Resource
	private PaymentMethodMapper paymentMethodMapper;//注入容器

	/**
	 * 查询所有账户信息
	 */
	@Override
	public List<PaymentMethod> selectPaymentMethod() {
		return paymentMethodMapper.selectPaymentMethod();
	}

	/**
	 * 删除账户信息
	 */
	@Override
	public Integer delPaymentMethod(Integer paymentmethodId) {
		return paymentMethodMapper.delPaymentMethod(paymentmethodId);
	}

	/**
	 * 添加账户信息
	 */
	@Override
	public Integer addPaymentMethod(String paymentmethodName) {
		return paymentMethodMapper.addPaymentMethod(paymentmethodName);
	}

	@Override
	public Integer delPaymentMethodTable() {
		// TODO Auto-generated method stub
		return paymentMethodMapper.delPaymentMethodTable();
	}
	
	
}
