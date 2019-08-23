package cn.huizhi.pojo;

public class Student {

	private Integer highId;
	private String studentName;
	private Integer studentSex;
	private String studentIDCard;
	private String studentBirth;
	private String school;
	private String parentName;
	private String telephone;
	private String familyAddress;
	private String registrationChannels;
	private String registrationConsultant;
	private String startTime;
	private String endTime;
	private String theSurrogate;
	private String remarks;
	private Integer feeCategory;

	public Student(Integer highId, String studentName, Integer studentSex, String studentIDCard, String studentBirth,
			String school, String parentName, String telephone, String familyAddress, String registrationChannels,
			String registrationConsultant, String startTime, String endTime, String theSurrogate, String remarks,
			Integer feeCategory) {
		super();
		this.highId = highId;
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

	public Student() {
		super();
	}

	public Integer getHighId() {
		return highId;
	}

	public void setHighId(Integer highId) {
		this.highId = highId;
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

	public Integer getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Integer feeCategory) {
		this.feeCategory = feeCategory;
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

	public String getStudentBirth() {
		return studentBirth;
	}

	public void setStudentBirth(String studentBirth) {
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
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

}
