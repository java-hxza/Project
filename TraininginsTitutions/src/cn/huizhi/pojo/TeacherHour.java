package cn.huizhi.pojo;

import java.util.Date;

public class TeacherHour {
	private Integer teacherHourId; // int(11) 教师课时主键
	private String teacherName; // varchar(30)教师名称
	private Integer teacherId; // int(11)教师主键
	private Double hours; // double课时
	private String dpName; // varchar(50)课时名称
	private Integer dpId; // int(11)可是类别主键
	private Date startTime; // date上课时间
	private Integer schoolId; // int(11)校区主键
	private String remarks; // varchar(200)备注
	private Integer classId;
	private Double sumHours;

	private Date endTime;

	public TeacherHour() {
		super();
	}

	public TeacherHour(Integer teacherHourId, String teacherName, Integer teacherId, Double hours, String dpName,
			Integer dpId, Date startTime, Integer schoolId, String remarks, Integer classId, Double sumHours,
			Date endTime) {
		super();
		this.teacherHourId = teacherHourId;
		this.teacherName = teacherName;
		this.teacherId = teacherId;
		this.hours = hours;
		this.dpName = dpName;
		this.dpId = dpId;
		this.startTime = startTime;
		this.schoolId = schoolId;
		this.remarks = remarks;
		this.classId = classId;
		this.sumHours = sumHours;
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTeacherHourId() {
		return teacherHourId;
	}

	public void setTeacherHourId(Integer teacherHourId) {
		this.teacherHourId = teacherHourId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getSumHours() {
		return sumHours;
	}

	public void setSumHours(Double sumHours) {
		this.sumHours = sumHours;
	}

}
