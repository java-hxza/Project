package cn.huizhi.pojo;

public class School {
	private Integer schoolId;
	private String schoolName;
	private Integer cityId;
	private Integer cityProperId;
	private String schoolRemarks;
	private Integer schoolType;

	private City city;

	private Province province;

	public School() {
		super();
	}

	public School(Integer schoolId, String schoolName, Integer cityId, Integer cityProperId, String schoolRemarks,
			Integer schoolType, City city, Province province) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.cityId = cityId;
		this.cityProperId = cityProperId;
		this.schoolRemarks = schoolRemarks;
		this.schoolType = schoolType;
		this.city = city;
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Integer getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(Integer schoolType) {
		this.schoolType = schoolType;
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
