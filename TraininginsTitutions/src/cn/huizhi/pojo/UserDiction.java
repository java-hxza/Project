package cn.huizhi.pojo;

public class UserDiction {
	private Integer userDictionId;
	private Integer schoolId;
	private Integer userId;

	private User user;
	private School school;

	public UserDiction() {
		super();
	}



	public UserDiction(Integer userDictionId, Integer schoolId, Integer userId, User user, School school) {
		super();
		this.userDictionId = userDictionId;
		this.schoolId = schoolId;
		this.userId = userId;
		this.user = user;
		this.school = school;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Integer getUserDictionId() {
		return userDictionId;
	}

	public void setUserDictionId(Integer userDictionId) {
		this.userDictionId = userDictionId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
