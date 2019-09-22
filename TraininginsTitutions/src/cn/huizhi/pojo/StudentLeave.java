package cn.huizhi.pojo;

import java.util.Date;

public class StudentLeave {
	private Integer slId;
	private Integer studentId;
	private String studentName;
	private Integer classId;
	private String remarks;
	private Date startTime;
	private Date endTime;
	private Integer schoolId;
	private Integer thId;
	private TeacherHour teacherHour;

	public StudentLeave() {
		super();
	}

	public StudentLeave(Integer slId, Integer studentId, String studentName, Integer classId, String remarks,
			Date startTime, Date endTime, Integer schoolId, Integer thId, TeacherHour teacherHour) {
		super();
		this.slId = slId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.remarks = remarks;
		this.startTime = startTime;
		this.endTime = endTime;
		this.schoolId = schoolId;
		this.thId = thId;
		this.teacherHour = teacherHour;
	}

	public Integer getThId() {
		return thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	public TeacherHour getTeacherHour() {
		return teacherHour;
	}

	public void setTeacherHour(TeacherHour teacherHour) {
		this.teacherHour = teacherHour;
	}

	public Integer getSlId() {
		return slId;
	}

	public void setSlId(Integer slId) {
		this.slId = slId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
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

}
