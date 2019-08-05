package cn.huizhi.pojo;

public class DepartmentOfPediatrics {
	private Integer dpId;
	private String dpTypeName;
	private Integer chargeTypeId;

	public DepartmentOfPediatrics() {
		super();
	}

	public DepartmentOfPediatrics(Integer dpId, String dpTypeName, Integer chargeTypeId) {
		super();
		this.dpId = dpId;
		this.dpTypeName = dpTypeName;
		this.chargeTypeId = chargeTypeId;
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

	public Integer getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

}
