package cn.huizhi.pojo;

public class School {
	private Integer schoolId;
	private String schoolName;
	private Integer cityId;
	private Integer cityProperId;
	private String schoolRemarks;

	public School() {
		super();
	}

	public School(Integer schoolId, String schoolName, Integer cityId, Integer cityProperId, String schoolRemarks) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.cityId = cityId;
		this.cityProperId = cityProperId;
		this.schoolRemarks = schoolRemarks;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCityProperId() {
		return cityProperId;
	}

	public void setCityProperId(Integer cityProperId) {
		this.cityProperId = cityProperId;
	}

	public String getSchoolRemarks() {
		return schoolRemarks;
	}

	public void setSchoolRemarks(String schoolRemarks) {
		this.schoolRemarks = schoolRemarks;
	}

}
