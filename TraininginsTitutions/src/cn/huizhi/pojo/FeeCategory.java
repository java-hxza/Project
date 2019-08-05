package cn.huizhi.pojo;

public class FeeCategory {
	private Integer chargeTypeId;
	private String chargeTypeName;
	private Integer feeCategory;

	public FeeCategory() {
		super();
	}

	public FeeCategory(Integer chargeTypeId, String chargeTypeName, Integer feeCategory) {
		super();
		this.chargeTypeId = chargeTypeId;
		this.chargeTypeName = chargeTypeName;
		this.feeCategory = feeCategory;
	}

	public Integer getChargeTypeId() {
		return chargeTypeId;
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

	public Integer getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Integer feeCategory) {
		this.feeCategory = feeCategory;
	}

}
