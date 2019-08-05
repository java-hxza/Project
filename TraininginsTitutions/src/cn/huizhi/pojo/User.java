package cn.huizhi.pojo;

public class User {
	private Integer uId;
	private String userName;
	private String loginName;
	private String loginPassword;
	private Integer schoolId;
	private Integer userTypeId;

	public User() {
		super();
	}

	public User(Integer uId, String userName, String loginName, String loginPassword, Integer schoolId,
			Integer userTypeId) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.schoolId = schoolId;
		this.userTypeId = userTypeId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

}
