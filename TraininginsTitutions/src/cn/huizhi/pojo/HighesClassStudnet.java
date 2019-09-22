package cn.huizhi.pojo;

import java.util.Date;

public class HighesClassStudnet {
	private Integer classesStudentId;
	private String studentName;
	private String headmaster;
	private Date enrollmentTime;
	private Integer classId;
	private Integer studentId;
	private Integer state;
	// 请假时间
	private Date startTime;
	private Date endTime;
	private String remarks;

	private Student student;

	public HighesClassStudnet() {
		super();
	}

	public HighesClassStudnet(Integer classesStudentId, String studentName, String headmaster, Date enrollmentTime,
			Integer classId, Integer studentId, Integer state, Student student) {
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
