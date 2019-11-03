package cn.huizhi.pojo;

public class ClassTime {

	private Integer classTimeId;
	private String classTimeName;
	private Integer schoolId;

	public ClassTime() {
		super();
	}

	public ClassTime(Integer classTimeId, String classTimeName, Integer schoolId) {
		super();
		this.classTimeId = classTimeId;
		this.classTimeName = classTimeName;
		this.schoolId = schoolId;
	}

	public Integer getClassTimeId() {
		return classTimeId;
	}

	public void setClassTimeId(Integer classTimeId) {
		this.classTimeId = classTimeId;
	}

	public String getClassTimeName() {
		return classTimeName;
	}

	public void setClassTimeName(String classTimeName) {
		this.classTimeName = classTimeName;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
