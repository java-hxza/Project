package cn.huizhi.pojo;

public class Gift {

	private Integer giftId;
	private String giftName;
	private Integer schoolId;
	private Integer giftNumber;

	public Gift() {
		super();
	}

	public Gift(Integer giftId, String giftName, Integer schoolId, Integer giftNumber) {
		super();
		this.giftId = giftId;
		this.giftName = giftName;
		this.schoolId = schoolId;
		this.giftNumber = giftNumber;
	}

	public Integer getGiftId() {
		return giftId;
	}

	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getGiftNumber() {
		return giftNumber;
	}

	public void setGiftNumber(Integer giftNumber) {
		this.giftNumber = giftNumber;
	}

}
