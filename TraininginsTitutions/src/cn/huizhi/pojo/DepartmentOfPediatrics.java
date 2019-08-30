package cn.huizhi.pojo;

public class DepartmentOfPediatrics {
	private Integer dpId;
	private String dpTypeName;
	private Integer chargeTypeId;
	private Integer schoolId;
	private Double dpMoney;

	public DepartmentOfPediatrics() {
		super();
	}

	public DepartmentOfPediatrics(Integer dpId, String dpTypeName, Integer chargeTypeId, Integer schoolId,
			Double dpMoney) {
		super();
		this.dpId = dpId;
		this.dpTypeName = dpTypeName;
		this.chargeTypeId = chargeTypeId;
		this.schoolId = schoolId;
		this.dpMoney = dpMoney;
	}

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public String getDpTypeName() {
		return dpTypeName;
	}

	public void setDpTypeName(String dpTypeName) {
		this.dpTypeName = dpTypeName;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Double getDpMoney() {
		return dpMoney;
	}

	public void setDpMoney(Double dpMoney) {
		this.dpMoney = dpMoney;
	}

	public Integer getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

}
