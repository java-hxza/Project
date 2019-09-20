package cn.huizhi.pojo;

public class DepartmentOfPediatrics {
	private Integer dpId;
	private String dpTypeName;
	private Integer chargeTypeId;
	private Integer schoolId;

	public DepartmentOfPediatrics() {
		super();
	}

	public DepartmentOfPediatrics(Integer dpId, String dpTypeName, Integer chargeTypeId, Integer schoolId) {
		super();
		this.dpId = dpId;
		this.dpTypeName = dpTypeName;
		this.chargeTypeId = chargeTypeId;
		this.schoolId = schoolId;
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


	public Integer getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}


}
