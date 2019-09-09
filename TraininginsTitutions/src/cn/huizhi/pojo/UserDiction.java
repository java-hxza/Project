package cn.huizhi.pojo;

public class UserDiction {
	private Integer userDictionId;
	private Integer schoolId;
	private Integer userId;

	private School school;

	public UserDiction() {
		super();
	}

	public UserDiction(Integer userDictionId, Integer schoolId, Integer userId, School school) {
		super();
		this.userDictionId = userDictionId;
		this.schoolId = schoolId;
		this.userId = userId;
		this.school = school;
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
