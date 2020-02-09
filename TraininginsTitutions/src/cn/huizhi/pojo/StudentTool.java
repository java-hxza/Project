package cn.huizhi.pojo;

public class StudentTool {

	private Integer studenttool;
	private Integer studentId;
	private Integer teacherId;
	private String teacherName;
	private Integer classId;
	private String className;

	public StudentTool() {
		super();
	}

	public StudentTool(Integer studenttool, Integer studentId, Integer teacherId, String teacherName, Integer classId,
			String className) {
		super();
		this.studenttool = studenttool;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.classId = classId;
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getStudenttool() {
		return studenttool;
	}

	public void setStudenttool(Integer studenttool) {
		this.studenttool = studenttool;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

}
