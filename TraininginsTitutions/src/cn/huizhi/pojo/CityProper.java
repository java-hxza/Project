package cn.huizhi.pojo;

public class CityProper {
	private Integer cityProperId;
	private String cityProperName;
	private Integer cityId;

	public CityProper() {
		super();
	}

	public CityProper(Integer cityProperId, String cityProperName, Integer cityId) {
		super();
		this.cityProperId = cityProperId;
		this.cityProperName = cityProperName;
		this.cityId = cityId;
	}

	public Integer getCityProperId() {
		return cityProperId;
	}

	public void setCityProperId(Integer cityProperId) {
		this.cityProperId = cityProperId;
	}

	public String getCityProperName() {
		return cityProperName;
	}

	public void setCityProperName(String cityProperName) {
		this.cityProperName = cityProperName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}
