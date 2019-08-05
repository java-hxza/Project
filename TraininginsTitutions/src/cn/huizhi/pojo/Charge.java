package cn.huizhi.pojo;

public class Charge {
	private Integer chargeId;
	private Integer gradeId;
	private String gradeName;
	private String studentName;
	
	
	public Charge() {
		super();
	}

	public Charge(Integer chargeId, Integer gradeId, String gradeName, String studentName) {
		super();
		this.chargeId = chargeId;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.studentName = studentName;
	}

	public Integer getChargeId() {
		return chargeId;
	}

	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
