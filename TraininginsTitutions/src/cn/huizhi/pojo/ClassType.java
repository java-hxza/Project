package cn.huizhi.pojo;

public class ClassType {

	private Integer classTypeId;
	private String classTypeName;
	private Integer schoolId;
	private Integer classTypeTime;

	public ClassType() {
		super();
	}

	public ClassType(Integer classTypeId, String classTypeName, Integer schoolId) {
		super();
		this.classTypeId = classTypeId;
		this.classTypeName = classTypeName;
		this.schoolId = schoolId;
	}

	public Integer getClassTypeId() {
		return classTypeId;
	}

	public void setClassTypeId(Integer classTypeId) {
		this.classTypeId = classTypeId;
	}

	public String getClassTypeName() {
		return classTypeName;
	}

	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getClassTypeTime() {
		return classTypeTime;
	}

	public void setClassTypeTime(Integer classTypeTime) {
		this.classTypeTime = classTypeTime;
	}

}
