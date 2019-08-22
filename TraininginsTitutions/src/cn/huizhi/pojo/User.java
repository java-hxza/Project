package cn.huizhi.pojo;

import java.util.List;

public class User {
	private Integer uId;
	private String loginName;
	private String loginPassword;
	private String schoolId;
	private String userTypeId;
	private String telephone;
	private String remarks;
	
	private School school;
	
	private UserType userType;
	
	public User() {
		super();
	}

	



	public User(Integer uId, String loginName, String loginPassword, String schoolId, String userTypeId,
			String telephone, String remarks, School school, UserType userType) {
		super();
		this.uId = uId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.schoolId = schoolId;
		this.userTypeId = userTypeId;
		this.telephone = telephone;
		this.remarks = remarks;
		this.school = school;
		this.userType = userType;
	}





	public User(Integer uId, String loginName, String loginPassword, String schoolId, String userTypeId,
			String telephone, String remarks) {
		super();
		this.uId = uId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.schoolId = schoolId;
		this.userTypeId = userTypeId;
		this.telephone = telephone;
		this.remarks = remarks;
	}





	public String getLoginName() {
		return loginName;
	}





	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}





	public School getSchool() {
		return school;
	}





	public void setSchool(School school) {
		this.school = school;
	}





	public UserType getUserType() {
		return userType;
	}





	public void setUserType(UserType userType) {
		this.userType = userType;
	}





	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}


	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
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






}
