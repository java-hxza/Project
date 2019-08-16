package cn.huizhi.pojo;

public class TeacherType {
	private Integer teacherTypeId;
	private String teacherTypeName;

	public TeacherType() {
		super();
	}

	public TeacherType(Integer teacherTypeId, String teacherTypeName) {
		super();
		this.teacherTypeId = teacherTypeId;
		this.teacherTypeName = teacherTypeName;
	}

	public Integer getTeacherTypeId() {
		return teacherTypeId;
	}

	public void setTeacherTypeId(Integer teacherTypeId) {
		this.teacherTypeId = teacherTypeId;
	}

	public String getTeacherTypeName() {
		return teacherTypeName;
	}

	public void setTeacherTypeName(String teacherTypeName) {
		this.teacherTypeName = teacherTypeName;
	}

}
