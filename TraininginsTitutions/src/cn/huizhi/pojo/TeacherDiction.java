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

	public TeacherDiction() {
		super();
	}

	public TeacherDiction(Integer teacherDictionId, Integer schoolId, Integer teacherId) {
		super();
		this.teacherDictionId = teacherDictionId;
		this.schoolId = schoolId;
		this.teacherId = teacherId;
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
