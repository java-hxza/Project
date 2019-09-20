package cn.huizhi.pojo;

public class Activity {

	private Integer activityId;
	private Integer activityMoney;
	private Integer discount;
	private Integer schoolId;
	private String content;
	private String activityName;

	public Activity() {
		super();
	}

	public Activity(Integer activityId, Integer activityMoney, Integer discount, Integer schoolId, String content,
			String activityName) {
		super();
		this.activityId = activityId;
		this.activityMoney = activityMoney;
		this.discount = discount;
		this.schoolId = schoolId;
		this.content = content;
		this.activityName = activityName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getActivityMoney() {
		return activityMoney;
	}

	public void setActivityMoney(Integer activityMoney) {
		this.activityMoney = activityMoney;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
