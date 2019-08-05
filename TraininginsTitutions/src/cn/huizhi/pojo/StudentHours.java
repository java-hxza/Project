package cn.huizhi.pojo;

public class StudentHours {
	private Integer studentHoursId;
	private Integer hours;
	private Double hoursPrice;
	private Integer chargeTypeId;
	private Integer dpId;

	public StudentHours() {
		super();
	}

	public StudentHours(Integer studentHoursId, Integer hours, Double hoursPrice, Integer chargeTypeId, Integer dpId) {
		super();
		this.studentHoursId = studentHoursId;
		this.hours = hours;
		this.hoursPrice = hoursPrice;
		this.chargeTypeId = chargeTypeId;
		this.dpId = dpId;
	}

	public Integer getStudentHoursId() {
		return studentHoursId;
	}

	public void setStudentHoursId(Integer studentHoursId) {
		this.studentHoursId = studentHoursId;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getHoursPrice() {
		return hoursPrice;
	}

	public void setHoursPrice(Double hoursPrice) {
		this.hoursPrice = hoursPrice;
	}

	public Integer getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

}
