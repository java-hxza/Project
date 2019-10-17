package cn.huizhi.pojo;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 少儿班级
 * 
 * @author wye
 *
 */
/**
 * @author 86175
 *
 */
public class Class {
	/**
	 * 少儿班级主键
	 */
	private Integer classId;
	/**
	 * 少儿班级班号
	 */
	private String classNumber;
	/**
	 * 少儿班级名称
	 */
	private String className;
	/**
	 * 少儿班级类型主键
	 */
	private Integer classTypeId;

	private Integer dpId;
	/**
	 * 班主任
	 */
	private String headmaster;
	/**
	 * 班主任主键
	 */
	private Integer teacherId;

	private Integer classLevel;
	
	private Integer classType;
	
	private ClassType classType2;
	
	/**
	 * 少儿班级所属学校主键
	 */
	private Integer schoolId;
	/**
	 * 学校对象
	 */
	private School school;
	/**
	 * 班级类型对象
	 */
	private DepartmentOfPediatrics departmentOfPediatrics;

	public Class() {
		super();
	}
	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}


	public Class(Integer classId, String classNumber, String className, Integer classTypeId, Integer dpId,
			String headmaster, Integer teacherId, Integer classLevel, Integer classType, ClassType classType2,
			Integer schoolId, School school, DepartmentOfPediatrics departmentOfPediatrics) {
		super();
		this.classId = classId;
		this.classNumber = classNumber;
		this.className = className;
		this.classTypeId = classTypeId;
		this.dpId = dpId;
		this.headmaster = headmaster;
		this.teacherId = teacherId;
		this.classLevel = classLevel;
		this.classType = classType;
		this.classType2 = classType2;
		this.schoolId = schoolId;
		this.school = school;
		this.departmentOfPediatrics = departmentOfPediatrics;
	}
	public ClassType getClassType2() {
		return classType2;
	}
	public void setClassType2(ClassType classType2) {
		this.classType2 = classType2;
	}
	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getClassName() {
		return className;
	}

	public String getHeadmaster() {
		return headmaster;
	}

	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
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

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassTypeId() {
		return classTypeId;
	}

	public void setClassTypeId(Integer classTypeId) {
		this.classTypeId = classTypeId;
	}

	public Integer getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public DepartmentOfPediatrics getDepartmentOfPediatrics() {
		return departmentOfPediatrics;
	}

	public void setDepartmentOfPediatrics(DepartmentOfPediatrics departmentOfPediatrics) {
		this.departmentOfPediatrics = departmentOfPediatrics;
	}

}
