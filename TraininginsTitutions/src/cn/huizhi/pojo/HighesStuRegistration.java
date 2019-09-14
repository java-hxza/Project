package cn.huizhi.pojo;

import java.util.Date;

public class HighesStuRegistration {
	private Integer highesHourId;
	private String studentName;
	private Date classHours;
	private Integer dpId;
	private String contentOfCourses;
	private Double classHour;
	private String teacherInClass;
	private Integer highesStuId;
	private Integer state;
	private Integer remarks;
	private Integer classId;
	private Integer teacherId;

	private Integer thId;

	private Double sumHour;
	/**
	 * 学生订单
	 */
	private Order order;
	/**
	 * 班级
	 */
	private Class class1;

	/**
	 * 高中学生
	 */
	private HighesClassStudnet highesClassStudnet;

	public HighesStuRegistration() {
		super();
	}

	public HighesStuRegistration(Integer highesHourId, String studentName, Date classHours, Integer dpId,
			String contentOfCourses, Double classHour, String teacherInClass, Integer highesStuId, Integer state,
			Integer remarks, Integer classId, Integer teacherId, Integer thId, Double sumHour, Order order,
			Class class1, HighesClassStudnet highesClassStudnet) {
		super();
		this.highesHourId = highesHourId;
		this.studentName = studentName;
		this.classHours = classHours;
		this.dpId = dpId;
		this.contentOfCourses = contentOfCourses;
		this.classHour = classHour;
		this.teacherInClass = teacherInClass;
		this.highesStuId = highesStuId;
		this.state = state;
		this.remarks = remarks;
		this.classId = classId;
		this.teacherId = teacherId;
		this.thId = thId;
		this.sumHour = sumHour;
		this.order = order;
		this.class1 = class1;
		this.highesClassStudnet = highesClassStudnet;
	}

	public Integer getThId() {
		return thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	public Integer getHighesHourId() {
		return highesHourId;
	}

	public void setHighesHourId(Integer highesHourId) {
		this.highesHourId = highesHourId;
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

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public String getContentOfCourses() {
		return contentOfCourses;
	}

	public void setContentOfCourses(String contentOfCourses) {
		this.contentOfCourses = contentOfCourses;
	}

	public Double getClassHour() {
		return classHour;
	}

	public void setClassHour(Double classHour) {
		this.classHour = classHour;
	}

	public String getTeacherInClass() {
		return teacherInClass;
	}

	public void setTeacherInClass(String teacherInClass) {
		this.teacherInClass = teacherInClass;
	}

	public Integer getHighesStuId() {
		return highesStuId;
	}

	public void setHighesStuId(Integer highesStuId) {
		this.highesStuId = highesStuId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getRemarks() {
		return remarks;
	}

	public void setRemarks(Integer remarks) {
		this.remarks = remarks;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public HighesClassStudnet getHighesClassStudnet() {
		return highesClassStudnet;
	}

	public void setHighesClassStudnet(HighesClassStudnet highesClassStudnet) {
		this.highesClassStudnet = highesClassStudnet;
	}

	public Double getSumHour() {
		return sumHour;
	}

	public void setSumHour(Double sumHour) {
		this.sumHour = sumHour;
	}

}
