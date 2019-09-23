package cn.huizhi.pojo;

public class StudentDpMoney {

	private Integer studentId;

	private FeeCategory feeCategory;

	private String[] feeMoney;
	
	private String[] feeId;

	public StudentDpMoney() {
		super();
	}


	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public FeeCategory getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(FeeCategory feeCategory) {
		this.feeCategory = feeCategory;
	}

	public String[] getFeeMoney() {
		return feeMoney;
	}

	public void setFeeMoney(String[] feeMoney) {
		this.feeMoney = feeMoney;
	}

	public StudentDpMoney(Integer studentId, FeeCategory feeCategory, String[] feeMoney, String[] feeId) {
		super();
		this.studentId = studentId;
		this.feeCategory = feeCategory;
		this.feeMoney = feeMoney;
		this.feeId = feeId;
	}

	public String[] getFeeId() {
		return feeId;
	}

	public void setFeeId(String[] feeId) {
		this.feeId = feeId;
	}
	

}
