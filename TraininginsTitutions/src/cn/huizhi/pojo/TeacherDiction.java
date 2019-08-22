package cn.huizhi.pojo;
/**
 * 教师权限类
 * @author wye
 *
 */
public class TeacherDiction {
	private Integer teacherDictionId;
	private Integer schoolId;
	private Integer teacherId;
	
	private School school;
	
	private Teacher teacher;
	
	public TeacherDiction() {
		super();
	}


	public TeacherDiction(Integer teacherDictionId, Integer schoolId, Integer teacherId, School school,
			Teacher teacher) {
		super();
		this.teacherDictionId = teacherDictionId;
		this.schoolId = schoolId;
		this.teacherId = teacherId;
		this.school = school;
		this.teacher = teacher;
	}


	public Integer getTeacherDictionId() {
		return teacherDictionId;
	}

	public void setTeacherDictionId(Integer teacherDictionId) {
		this.teacherDictionId = teacherDictionId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}
	

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

}
