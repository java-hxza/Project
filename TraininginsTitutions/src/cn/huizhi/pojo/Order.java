package cn.huizhi.pojo;

import java.util.Date;

public class Order {

	private Integer orderId;
	private Integer feecateId;
	private double dpMoney;
	private Integer stuId;
	private Date startTime;
	private Integer schoolId;
	private Integer identification;
	private double feecategoryMoney;
	private Integer paymentmethodId;
	private String personliable;
	private Integer departmentofpediatricsId;
	private double addhour;
	private double givehour;
	private Date firstdate;
	private Date lastdate;
	private String remarks;
	private String orderNumber;
	private Integer expenditureitemsId;

	public Order(Integer orderId, Integer feecateId, double dpMoney, Integer stuId, Date startTime, Integer schoolId,
			Integer identification, double feecategoryMoney, Integer paymentmethodId, String personliable,
			Integer departmentofpediatricsId, double addhour, double givehour, Date firstdate, Date lastdate,
			String remarks, String orderNumber, Integer expenditureitemsId) {
		super();
		this.orderId = orderId;
		this.feecateId = feecateId;
		this.dpMoney = dpMoney;
		this.stuId = stuId;
		this.startTime = startTime;
		this.schoolId = schoolId;
		this.identification = identification;
		this.feecategoryMoney = feecategoryMoney;
		this.paymentmethodId = paymentmethodId;
		this.personliable = personliable;
		this.departmentofpediatricsId = departmentofpediatricsId;
		this.addhour = addhour;
		this.givehour = givehour;
		this.firstdate = firstdate;
		this.lastdate = lastdate;
		this.remarks = remarks;
		this.orderNumber = orderNumber;
		this.expenditureitemsId = expenditureitemsId;
	}

	public Order() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFeecateId() {
		return feecateId;
	}

	public void setFeecateId(Integer feecateId) {
		this.feecateId = feecateId;
	}

	public double getDpMoney() {
		return dpMoney;
	}

	public void setDpMoney(double dpMoney) {
		this.dpMoney = dpMoney;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public double getFeecategoryMoney() {
		return feecategoryMoney;
	}

	public void setFeecategoryMoney(double feecategoryMoney) {
		this.feecategoryMoney = feecategoryMoney;
	}

	public Integer getPaymentmethodId() {
		return paymentmethodId;
	}

	public void setPaymentmethodId(Integer paymentmethodId) {
		this.paymentmethodId = paymentmethodId;
	}

	public String getPersonliable() {
		return personliable;
	}

	public void setPersonliable(String personliable) {
		this.personliable = personliable;
	}

	public Integer getDepartmentofpediatricsId() {
		return departmentofpediatricsId;
	}

	public void setDepartmentofpediatricsId(Integer departmentofpediatricsId) {
		this.departmentofpediatricsId = departmentofpediatricsId;
	}

	public double getAddhour() {
		return addhour;
	}

	public void setAddhour(double addhour) {
		this.addhour = addhour;
	}

	public double getGivehour() {
		return givehour;
	}

	public void setGivehour(double givehour) {
		this.givehour = givehour;
	}

	public Date getFirstdate() {
		return firstdate;
	}

	public void setFirstdate(Date firstdate) {
		this.firstdate = firstdate;
	}

	public Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getExpenditureitemsId() {
		return expenditureitemsId;
	}

	public void setExpenditureitemsId(Integer expenditureitemsId) {
		this.expenditureitemsId = expenditureitemsId;
	}

}
