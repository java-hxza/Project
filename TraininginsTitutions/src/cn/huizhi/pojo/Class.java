package cn.huizhi.pojo;

/**
 * 少儿班级
 * 
 * @author wye
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
	private Integer classNumber;
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

	public Class(Integer classId, Integer classNumber, String className, Integer classTypeId, Integer dpId,
			String headmaster, Integer teacherId, Integer classLevel, Integer schoolId, School school,
			DepartmentOfPediatrics departmentOfPediatrics) {
		super();
		this.classId = classId;
		this.classNumber = classNumber;
		this.className = className;
		this.classTypeId = classTypeId;
		this.dpId = dpId;
		this.headmaster = headmaster;
		this.teacherId = teacherId;
		this.classLevel = classLevel;
		this.schoolId = schoolId;
		this.school = school;
		this.departmentOfPediatrics = departmentOfPediatrics;
	}

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public Integer getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Integer classNumber) {
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
