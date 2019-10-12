package cn.huizhi.pojo;

public class SchoolFeeCategorySumMoney {

	private Double sumMoney = 0.0;

	private String schoolId;

	private String feeId;

	private String feeName;

	public Double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getFeeId() {
		return feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public SchoolFeeCategorySumMoney(Double sumMoney, String schoolId, String feeId, String feeName) {
		super();
		this.sumMoney = sumMoney;
		this.schoolId = schoolId;
		this.feeId = feeId;
		this.feeName = feeName;
	}

	public SchoolFeeCategorySumMoney() {
		super();
	}

}
