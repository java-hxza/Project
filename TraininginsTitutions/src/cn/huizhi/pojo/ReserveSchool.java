package cn.huizhi.pojo;

public class ReserveSchool {

	private Integer reserveSchoolId;
	private Integer schoolId;
	private Integer studentId;
	private Integer state;
	
	private Student student;
	
	public ReserveSchool() {
		super();
	}

	public ReserveSchool(Integer reserveSchoolId, Integer schoolId, Integer studentId, Integer state, Student student) {
		super();
		this.reserveSchoolId = reserveSchoolId;
		this.schoolId = schoolId;
		this.studentId = studentId;
		this.state = state;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getReserveSchoolId() {
		return reserveSchoolId;
	}
	public void setReserveSchoolId(Integer reserveSchoolId) {
		this.reserveSchoolId = reserveSchoolId;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
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
