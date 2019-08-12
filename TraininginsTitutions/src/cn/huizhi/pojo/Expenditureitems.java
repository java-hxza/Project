package cn.huizhi.pojo;

/**
 * @author 86175
 *
 */
public class Expenditureitems {

	private Integer expenditureitemsId;
	private String expenditureitemsName;
	private String category;
	private Integer feeCategory;

	public Integer getExpenditureitemsId() {
		return expenditureitemsId;
	}

	public void setExpenditureitemsId(Integer expenditureitemsId) {
		this.expenditureitemsId = expenditureitemsId;
	}

	public String getExpenditureitemsName() {
		return expenditureitemsName;
	}

	public void setExpenditureitemsName(String expenditureitemsName) {
		this.expenditureitemsName = expenditureitemsName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Expenditureitems() {
		super();
	}

	public Expenditureitems(Integer expenditureitemsId, String expenditureitemsName, String category,
			Integer feeCategory) {
		super();
		this.expenditureitemsId = expenditureitemsId;
		this.expenditureitemsName = expenditureitemsName;
		this.category = category;
		this.feeCategory = feeCategory;
	}

	public Integer getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Integer feeCategory) {
		this.feeCategory = feeCategory;
	}
	

}
