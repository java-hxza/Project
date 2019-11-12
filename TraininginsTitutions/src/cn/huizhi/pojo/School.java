package cn.huizhi.pojo;

import java.math.BigDecimal;

public class School {
	private Integer schoolId;
	private String schoolName;
	private Integer cityId;
	private Integer cityProperId;
	private String schoolRemarks;
	private Integer schoolType;
	private FeeCategory feeCategory;
	private String schoolNameSx;
	private Integer schoolNumber;
	private Double serviceCharge;
	/**
	 * 共支出
	 */
	private Double schoolExPenSum = 0.0;
	/**
	 * 共收入
	 */
	private Double schoolFeeceat = 0.0;

	private City city;

	private Province province;

	public School() {
		super();
	}

	public School(Integer schoolId, String schoolName, Integer cityId, Integer cityProperId, String schoolRemarks,
			Integer schoolType, FeeCategory feeCategory, String schoolNameSx, Integer schoolNumber,
			Double serviceCharge, Double schoolExPenSum, Double schoolFeeceat, City city, Province province) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.cityId = cityId;
		this.cityProperId = cityProperId;
		this.schoolRemarks = schoolRemarks;
		this.schoolType = schoolType;
		this.feeCategory = feeCategory;
		this.schoolNameSx = schoolNameSx;
		this.schoolNumber = schoolNumber;
		this.serviceCharge = serviceCharge;
		this.schoolExPenSum = schoolExPenSum;
		this.schoolFeeceat = schoolFeeceat;
		this.city = city;
		this.province = province;
	}

	public Double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Double getSchoolExPenSum() {
		return schoolExPenSum;
	}

	public void setSchoolExPenSum(Double schoolExPenSum) {

		BigDecimal bd = new BigDecimal(schoolExPenSum);

		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);

		this.schoolExPenSum = Double.parseDouble(bd.toString());
	}

	public FeeCategory getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(FeeCategory feeCategory) {
		this.feeCategory = feeCategory;
	}

	public Double getSchoolFeeceat() {
		return schoolFeeceat;
	}

	public void setSchoolFeeceat(Double schoolFeeceat) {
		BigDecimal bd = new BigDecimal(schoolFeeceat);

		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.schoolFeeceat = Double.valueOf(bd.toString());
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

	public String getSchoolNameSx() {
		return schoolNameSx;
	}

	public void setSchoolNameSx(String schoolNameSx) {
		this.schoolNameSx = schoolNameSx;
	}

	public Integer getSchoolNumber() {
		return schoolNumber;
	}

	public void setSchoolNumber(Integer schoolNumber) {
		this.schoolNumber = schoolNumber;
	}

}
