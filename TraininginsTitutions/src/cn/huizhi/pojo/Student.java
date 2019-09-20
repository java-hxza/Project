
package cn.huizhi.pojo;

public class Student {

	private Integer studentId;
	private String studentName;
	private Integer studentSex;
	private String studentIDCard;
	private String studentBirth;
	private String school;
	private String parentName;
	private String telephone;
	private String familyAddress;
	private String registrationChannels;
	private String registrationConsultant;
	private String startTime;
	private String endTime;
	private String theSurrogate;
	private String remarks;
	private Integer feeCategory;
	private Double studentHour;
	private Double integral;
	private Double usedIntegral;
	private ChildrenesClassStudnet childrenesClassStudnet;
	private Class classes;
	private School schools;
	private DepartmentOfPediatrics departmentOfPediatrics;
	private Order order;
	private PaymentMethod paymentMethod;
	private FeeCategory feeCategorys;
	
	private Reserveschool reserveschool;
	
	public Student(Integer studentId, String studentName, Integer studentSex, String studentIDCard, String studentBirth,
			String school, String parentName, String telephone, String familyAddress, String registrationChannels,
			String registrationConsultant, String startTime, String endTime, String theSurrogate, String remarks,
			Integer feeCategory, Double studentHour, Double integral, Double usedIntegral,
			ChildrenesClassStudnet childrenesClassStudnet, Class classes, School schools,
			DepartmentOfPediatrics departmentOfPediatrics, Order order, PaymentMethod paymentMethod,
			FeeCategory feeCategorys, Reserveschool reserveschool) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentIDCard = studentIDCard;
		this.studentBirth = studentBirth;
		this.school = school;
		this.parentName = parentName;
		this.telephone = telephone;
		this.familyAddress = familyAddress;
		this.registrationChannels = registrationChannels;
		this.registrationConsultant = registrationConsultant;
		this.startTime = startTime;
		this.endTime = endTime;
		this.theSurrogate = theSurrogate;
		this.remarks = remarks;
		this.feeCategory = feeCategory;
		this.studentHour = studentHour;
		this.integral = integral;
		this.usedIntegral = usedIntegral;
		this.childrenesClassStudnet = childrenesClassStudnet;
		this.classes = classes;
		this.schools = schools;
		this.departmentOfPediatrics = departmentOfPediatrics;
		this.order = order;
		this.paymentMethod = paymentMethod;
		this.feeCategorys = feeCategorys;
		this.reserveschool = reserveschool;
	}

	public Reserveschool getReserveschool() {
		return reserveschool;
	}

	public void setReserveschool(Reserveschool reserveschool) {
		this.reserveschool = reserveschool;
	}

	public Student() {
		super();
	}

	public ChildrenesClassStudnet getChildrenesClassStudnet() {
		return childrenesClassStudnet;
	}

	public void setChildrenesClassStudnet(ChildrenesClassStudnet childrenesClassStudnet) {
		this.childrenesClassStudnet = childrenesClassStudnet;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public Double getIntegral() {
		return integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Double getStudentHour() {
		return studentHour;
	}

	public void setStudentHour(Double studentHour) {
		this.studentHour = studentHour;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentSex() {
		return studentSex;
	}

	public Integer getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Integer feeCategory) {
		this.feeCategory = feeCategory;
	}

	public void setStudentSex(Integer studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentIDCard() {
		return studentIDCard;
	}

	public void setStudentIDCard(String studentIDCard) {
		this.studentIDCard = studentIDCard;
	}

	public String getStudentBirth() {
		return studentBirth;
	}

	public void setStudentBirth(String studentBirth) {
		this.studentBirth = studentBirth;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getRegistrationChannels() {
		return registrationChannels;
	}

	public void setRegistrationChannels(String registrationChannels) {
		this.registrationChannels = registrationChannels;
	}

	public String getRegistrationConsultant() {
		return registrationConsultant;
	}

	public void setRegistrationConsultant(String registrationConsultant) {
		this.registrationConsultant = registrationConsultant;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTheSurrogate() {
		return theSurrogate;
	}

	public void setTheSurrogate(String theSurrogate) {
		this.theSurrogate = theSurrogate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;

	}

	public Double getUsedIntegral() {
		return usedIntegral;
	}

	public void setUsedIntegral(Double usedIntegral) {
		this.usedIntegral = usedIntegral;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public School getSchools() {
		return schools;
	}

	public void setSchools(School schools) {
		this.schools = schools;
	}

	public DepartmentOfPediatrics getDepartmentOfPediatrics() {
		return departmentOfPediatrics;
	}

	public void setDepartmentOfPediatrics(DepartmentOfPediatrics departmentOfPediatrics) {
		this.departmentOfPediatrics = departmentOfPediatrics;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public FeeCategory getFeeCategorys() {
		return feeCategorys;
	}

	public void setFeeCategorys(FeeCategory feeCategorys) {
		this.feeCategorys = feeCategorys;
	}

}
