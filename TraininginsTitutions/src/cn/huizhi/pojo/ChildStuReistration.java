package cn.huizhi.pojo;

import java.util.Date;

public class ChildStuReistration {
	private Integer rOCCId;
	private String studentName;
	private Date classHours;
	private Integer chargeTypeId;
	private String contentOfCourses;
	private double classHour;
	private String teacherInClass;
	private Integer childStuId;
	private Integer state;
	private String remarks;

	public ChildStuReistration() {
		super();
	}

	public ChildStuReistration(Integer rOCCId, String studentName, Date classHours, Integer chargeTypeId,
			String contentOfCourses, double classHour, String teacherInClass, Integer childStuId, Integer state,
			String remarks) {
		super();
		this.rOCCId = rOCCId;
		this.studentName = studentName;
		this.classHours = classHours;
		this.chargeTypeId = chargeTypeId;
		this.contentOfCourses = contentOfCourses;
		this.classHour = classHour;
		this.teacherInClass = teacherInClass;
		this.childStuId = childStuId;
		this.state = state;
		this.remarks = remarks;
	}

	public Integer getrOCCId() {
		return rOCCId;
	}

	public void setrOCCId(Integer rOCCId) {
		this.rOCCId = rOCCId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getClassHours() {
		return classHours;
	}

	public void setClassHours(Date classHours) {
		this.classHours = classHours;
	}

	public Integer getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public String getContentOfCourses() {
		return contentOfCourses;
	}

	public void setContentOfCourses(String contentOfCourses) {
		this.contentOfCourses = contentOfCourses;
	}

	public double getClassHour() {
		return classHour;
	}

	public void setClassHour(double classHour) {
		this.classHour = classHour;
	}

	public String getTeacherInClass() {
		return teacherInClass;
	}

	public void setTeacherInClass(String teacherInClass) {
		this.teacherInClass = teacherInClass;
	}

	public Integer getChildStuId() {
		return childStuId;
	}

	public void setChildStuId(Integer childStuId) {
		this.childStuId = childStuId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
