package cn.huizhi.pojo;

import java.util.Date;
import cn.huizhi.pojo.Class;

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
	private Integer classId;
	private Integer teacherId;
	/**
	 * 学生订单
	 */
	private Order order;
	/**
	 * 班级
	 */
	private Class class1;
	/**
	 * 少儿班级学生
	 */
	private ChildrenesClassStudnet childrenesClassStudnet;
	
	
	
	public ChildStuReistration() {
		super();
	}


	public ChildStuReistration(Integer rOCCId, String studentName, Date classHours, Integer chargeTypeId,
			String contentOfCourses, double classHour, String teacherInClass, Integer childStuId, Integer state,
			String remarks, Integer classId, Integer teacherId, Order order, Class class1,
			ChildrenesClassStudnet childrenesClassStudnet) {
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
		this.classId = classId;
		this.teacherId = teacherId;
		this.order = order;
		this.class1 = class1;
		this.childrenesClassStudnet = childrenesClassStudnet;
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



	public ChildrenesClassStudnet getChildrenesClassStudnet() {
		return childrenesClassStudnet;
	}



	public void setChildrenesClassStudnet(ChildrenesClassStudnet childrenesClassStudnet) {
		this.childrenesClassStudnet = childrenesClassStudnet;
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
	

}
