package cn.huizhi.pojo;

import java.util.Date;

public class Student {
	private Integer studentId;
	private String studentName;
	private Integer studentSex;
	private String studentIDCard;
	private Date studentBirth;
	private String school;
	private String parentName;
	private String telephone;
	private String familyAddress;
	private String registrationChannels;
	private String registrationConsultant;
	private Date startTime;
	private Date endTime;
	private String theSurrogate;
	private String remarks;
	private Integer feeCategory;

	public Student() {
		super();
	}

	public Student(Integer studentId, String studentName, Integer studentSex, String studentIDCard, Date studentBirth,
			String school, String parentName, String telephone, String familyAddress, String registrationChannels,
			String registrationConsultant, Date startTime, Date endTime, String theSurrogate, String remarks,
			Integer feeCategory) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentIDCard = studentIDCard;
		this.studentBirth = studentBirth;
		this.school = school;
		this.parentName = parentName;
		this.telephone = telephone;
		this.familyAddress = familyAddress;
		this.registrationChannels = registrationChannels;
		this.registrationConsultant = registrationConsultant;
		this.startTime = startTime;
		this.endTime = endTime;
		this.theSurrogate = theSurrogate;
		this.remarks = remarks;
		this.feeCategory = feeCategory;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(Integer studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentIDCard() {
		return studentIDCard;
	}

	public void setStudentIDCard(String studentIDCard) {
		this.studentIDCard = studentIDCard;
	}

	public Date getStudentBirth() {
		return studentBirth;
	}

	public void setStudentBirth(Date studentBirth) {
		this.studentBirth = studentBirth;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getRegistrationChannels() {
		return registrationChannels;
	}

	public void setRegistrationChannels(String registrationChannels) {
		this.registrationChannels = registrationChannels;
	}

	public String getRegistrationConsultant() {
		return registrationConsultant;
	}

	public void setRegistrationConsultant(String registrationConsultant) {
		this.registrationConsultant = registrationConsultant;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTheSurrogate() {
		return theSurrogate;
	}

	public void setTheSurrogate(String theSurrogate) {
		this.theSurrogate = theSurrogate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Integer feeCategory) {
		this.feeCategory = feeCategory;
	}

}
