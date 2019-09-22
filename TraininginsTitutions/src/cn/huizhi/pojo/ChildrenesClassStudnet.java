package cn.huizhi.pojo;

import java.util.Date;

public class ChildrenesClassStudnet {
	private Integer classesStudentId;
	private String studentName;
	private String headmaster;
	private Date enrollmentTime;
	private Integer classId;
	private Integer studentId;
	private String state;
	// 请假时间
	private Date startTime;
	private Date endTime;
	private String teacherName;
	private Integer thId;
	private String remarks;
	
	private Student student;
	

	public ChildrenesClassStudnet() {
		super();
	}

	public ChildrenesClassStudnet(Integer classesStudentId, String studentName, String headmaster, Date enrollmentTime,
			Integer classId, Integer studentId, String state, Student student) {
		super();
		this.classesStudentId = classesStudentId;
		this.studentName = studentName;
		this.headmaster = headmaster;
		this.enrollmentTime = enrollmentTime;
		this.classId = classId;
		this.studentId = studentId;
		this.state = state;
		this.student = student;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getThId() {
		return thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getClassesStudentId() {
		return classesStudentId;
	}

	public void setClassesStudentId(Integer classesStudentId) {
		this.classesStudentId = classesStudentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getHeadmaster() {
		return headmaster;
	}

	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}

	public Date getEnrollmentTime() {
		return enrollmentTime;
	}

	public void setEnrollmentTime(Date enrollmentTime) {
		this.enrollmentTime = enrollmentTime;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
