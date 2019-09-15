package cn.huizhi.pojo;

public class Teacher {

	private Integer teacherId;
	private String teacherName;
	private String loginPassword;
	private Integer teacherTypeId;
	private Integer feeCategory;
	private String remarks;
	private String telephone;
	private Integer departmentId;
	private String loginName;

	/**
	 * 教师权限
	 */
	private TeacherDiction teacherDiction;
	/**
	 * 学校
	 */
	private School school;
	/**
	 * 教师类型
	 */
	private TeacherType teacherType;
	/**
	 * 部门
	 */
	private DepartMent deparMent;

	public Teacher() {
		super();
	}

	public Teacher(Integer teacherId, String teacherName, String loginPassword, Integer teacherTypeId,
			Integer feeCategory, String remarks, String telephone, Integer departmentId, String loginName,
			TeacherDiction teacherDiction, School school, TeacherType teacherType, DepartMent deparMent) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.loginPassword = loginPassword;
		this.teacherTypeId = teacherTypeId;
		this.feeCategory = feeCategory;
		this.remarks = remarks;
		this.telephone = telephone;
		this.departmentId = departmentId;
		this.loginName = loginName;
		this.teacherDiction = teacherDiction;
		this.school = school;
		this.teacherType = teacherType;
		this.deparMent = deparMent;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public DepartMent getDeparMent() {
		return deparMent;
	}

	public void setDeparMent(DepartMent deparMent) {
		this.deparMent = deparMent;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public TeacherType getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(TeacherType teacherType) {
		this.teacherType = teacherType;
	}

}
