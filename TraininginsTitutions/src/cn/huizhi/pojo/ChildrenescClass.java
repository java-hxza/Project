package cn.huizhi.pojo;

/**
 * 少儿班级
 * 
 * @author wye
 *
 */
public class ChildrenescClass {
	/**
	 * 少儿班级主键
	 */
	private Integer childrenesClassId;
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
	private Integer dpId;
	/**
	 * 班主任
	 */
	private String headmaster;
	/**
	 * 班主任主键
	 */
	private Integer uId;

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

	public ChildrenescClass() {
		super();
	}

	public ChildrenescClass(Integer childrenesClassId, Integer classNumber, String className, Integer dpId,
			String headmaster, Integer uId, Integer schoolId, School school,
			DepartmentOfPediatrics departmentOfPediatrics) {
		super();
		this.childrenesClassId = childrenesClassId;
		this.classNumber = classNumber;
		this.className = className;
		this.dpId = dpId;
		this.headmaster = headmaster;
		this.uId = uId;
		this.schoolId = schoolId;
		this.school = school;
		this.departmentOfPediatrics = departmentOfPediatrics;
	}

	public ChildrenescClass(Integer childrenesClassId, Integer classNumber, String className, Integer dpId,
			Integer schoolId, School school, DepartmentOfPediatrics departmentOfPediatrics) {
		super();
		this.childrenesClassId = childrenesClassId;
		this.classNumber = classNumber;
		this.className = className;
		this.dpId = dpId;
		this.schoolId = schoolId;
		this.school = school;
		this.departmentOfPediatrics = departmentOfPediatrics;
	}

	public Integer getChildrenesClassId() {
		return childrenesClassId;
	}

	public void setChildrenesClassId(Integer childrenesClassId) {
		this.childrenesClassId = childrenesClassId;
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

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
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
