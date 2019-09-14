package cn.huizhi.pojo;

public class Activity {

	private Integer activityId;
	private Integer activityMoneyfirst;
	private Integer activityMoneylast;
	private Integer discount;
	private Integer schoolId;

	public Activity() {
		super();
	}

	public Activity(Integer activityId, Integer activityMoneyfirst, Integer activityMoneylast, Integer discount,
			Integer schoolId) {
		super();
		this.activityId = activityId;
		this.activityMoneyfirst = activityMoneyfirst;
		this.activityMoneylast = activityMoneylast;
		this.discount = discount;
		this.schoolId = schoolId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getActivityMoneyfirst() {
		return activityMoneyfirst;
	}

	public void setActivityMoneyfirst(Integer activityMoneyfirst) {
		this.activityMoneyfirst = activityMoneyfirst;
	}

	public Integer getActivityMoneylast() {
		return activityMoneylast;
	}

	public void setActivityMoneylast(Integer activityMoneylast) {
		this.activityMoneylast = activityMoneylast;
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
