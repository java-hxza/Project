package cn.huizhi.pojo;

public class Teacher {

	private Integer teacherId;
	private String teacherName;
	private String loginPassword;
	private Integer teacherTypeId;
	private Integer feeCategory;
	private String telephone;
	private String remarks;

	private TeacherDiction teacherDiction;

	public Teacher() {
		super();
	}

	public Teacher(Integer teacherId, String teacherName, String loginPassword, Integer teacherTypeId,
			Integer feeCategory, String telephone, String remarks, TeacherDiction teacherDiction) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.loginPassword = loginPassword;
		this.teacherTypeId = teacherTypeId;
		this.feeCategory = feeCategory;
		this.telephone = telephone;
		this.remarks = remarks;
		this.teacherDiction = teacherDiction;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public TeacherDiction getTeacherDiction() {
		return teacherDiction;
	}

	public void setTeacherDiction(TeacherDiction teacherDiction) {
		this.teacherDiction = teacherDiction;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getTeacherTypeId() {
		return teacherTypeId;
	}

	public void setTeacherTypeId(Integer teacherTypeId) {
		this.teacherTypeId = teacherTypeId;
	}

	public Integer getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Integer feeCategory) {
		this.feeCategory = feeCategory;
	}

}
