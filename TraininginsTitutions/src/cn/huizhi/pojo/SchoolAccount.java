package cn.huizhi.pojo;

import java.util.Date;

public class SchoolAccount {
	private Integer accountId;
	private Integer expenId;
	private Double expenMoney;
	private Integer feecateId;
	private Double feectaeMoney;
	private Integer schoolId;
	private Date startTime;

	public SchoolAccount() {
		super();
	}

	public SchoolAccount(Integer accountId, Integer expenId, Double expenMoney, Integer feecateId, Double feectaeMoney,
			Integer schoolId, Date startTime) {
		super();
		this.accountId = accountId;
		this.expenId = expenId;
		this.expenMoney = expenMoney;
		this.feecateId = feecateId;
		this.feectaeMoney = feectaeMoney;
		this.schoolId = schoolId;
		this.startTime = startTime;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getExpenId() {
		return expenId;
	}

	public void setExpenId(Integer expenId) {
		this.expenId = expenId;
	}

	public Double getExpenMoney() {
		return expenMoney;
	}

	public void setExpenMoney(Double expenMoney) {
		this.expenMoney = expenMoney;
	}

	public Integer getFeecateId() {
		return feecateId;
	}

	public void setFeecateId(Integer feecateId) {
		this.feecateId = feecateId;
	}

	public Double getFeectaeMoney() {
		return feectaeMoney;
	}

	public void setFeectaeMoney(Double feectaeMoney) {
		this.feectaeMoney = feectaeMoney;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
