package cn.huizhi.pojo;

public class FeeCategory {
	private Integer chargeTypeId;
	private String chargeTypeName;
	private String category;
	private Integer schoolId;
	/**
	 * 
	 */
	public FeeCategory() {
		super();
	}

	public FeeCategory(Integer chargeTypeId, String chargeTypeName, String category,
			Integer schoolId) {
		super();
		this.chargeTypeId = chargeTypeId;
		this.chargeTypeName = chargeTypeName;
		this.category = category;
		this.schoolId = schoolId;
	}


	public Integer getChargeTypeId() {
		return chargeTypeId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public void setChargeTypeId(Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public String getChargeTypeName() {
		return chargeTypeName;
	}

	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
