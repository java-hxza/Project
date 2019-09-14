package cn.huizhi.pojo;

import java.util.Date;

public class ArtStuRegistration {
	private Integer artHourId;
	private String studentName;
	private Integer classId;
	private Date classHours;
	private Integer dpId;
	private String contentOfCourses;
	private Double classHour;
	private Integer teacherId;
	private String teacherInClass;
	private Integer highesStuId;
	private Integer state;
	private Double remarks;
	private Integer thId;

	private Double sumHour;

	private Order order;

	private Class class1;

	private ArtClassStudnet artClassStudnet;

	public ArtStuRegistration() {
		super();
	}

	public ArtStuRegistration(Integer artHourId, String studentName, Integer classId, Date classHours, Integer dpId,
			String contentOfCourses, Double classHour, Integer teacherId, String teacherInClass, Integer highesStuId,
			Integer state, Double remarks, Integer thId, Double sumHour, Order order, Class class1,
			ArtClassStudnet artClassStudnet) {
		super();
		this.artHourId = artHourId;
		this.studentName = studentName;
		this.classId = classId;
		this.classHours = classHours;
		this.dpId = dpId;
		this.contentOfCourses = contentOfCourses;
		this.classHour = classHour;
		this.teacherId = teacherId;
		this.teacherInClass = teacherInClass;
		this.highesStuId = highesStuId;
		this.state = state;
		this.remarks = remarks;
		this.thId = thId;
		this.sumHour = sumHour;
		this.order = order;
		this.class1 = class1;
		this.artClassStudnet = artClassStudnet;
	}

	public Integer getThId() {
		return thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	public Integer getArtHourId() {
		return artHourId;
	}

	public void setArtHourId(Integer artHourId) {
		this.artHourId = artHourId;
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

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
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

	public Double getRemarks() {
		return remarks;
	}

	public void setRemarks(Double remarks) {
		this.remarks = remarks;
	}

	public Double getSumHour() {
		return sumHour;
	}

	public void setSumHour(Double sumHour) {
		this.sumHour = sumHour;
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

	public ArtClassStudnet getArtClassStudnet() {
		return artClassStudnet;
	}

	public void setArtClassStudnet(ArtClassStudnet artClassStudnet) {
		this.artClassStudnet = artClassStudnet;
	}

}
