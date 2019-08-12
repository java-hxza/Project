package cn.huizhi.pojo;

public class PaymentMethod {

	private Integer paymentmethodId;
	private String paymentmethodName;
	public Integer getPaymentmethodId() {
		return paymentmethodId;
	}
	public void setPaymentmethodId(Integer paymentmethodId) {
		this.paymentmethodId = paymentmethodId;
	}
	public String getPaymentmethodName() {
		return paymentmethodName;
	}
	public void setPaymentmethodName(String paymentmethodName) {
		this.paymentmethodName = paymentmethodName;
	}
	public PaymentMethod(Integer paymentmethodId, String paymentmethodName) {
		super();
		this.paymentmethodId = paymentmethodId;
		this.paymentmethodName = paymentmethodName;
	}
	public PaymentMethod() {
		super();
	}
	
	
}
