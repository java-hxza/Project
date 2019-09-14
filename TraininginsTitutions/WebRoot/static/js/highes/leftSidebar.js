$(function() {
	/**
	 * 跳转学校账户余额
	 */
	rootSchoolInfo = function() {
		location.href = "rootSchoolInfo.html";
	}

	/**
	 * 学校订单跳转
	 */
	selectOrderSchoolInfo = function() {
		location.href = "orderInfo.html";
	}

	/**
	 * 跳转学校账户余额
	 */
	schoolListInfo = function() {
		location.href = "rootSchoolInfo.html";
	}
	/**
	 * 跳转学生课时
	 */
	studentHour = function() {
		location.href = "classSchoolInfo.html";
	}

	addStudent = function() {}
	/**
	 * 跳转班级课程页面
	 */
	curriculumClassInfo = function() {
		location.href = "curriculumClassInfo.html";
	}
	/**
	 * 跳转到班级信息
	 */
	classInfo = function() {
		location.href = "classIndex.html";
	}

	/**
	 * 跳转班级科别管理
	 */
	classTypeInfo = function() {
		location.href = "classTypeInfo.html";
	}

	/**
	 * 返回操作员信息
	 */
	operatorChilk = function() {
		location.href = "schoolOperatorChilk.html";
	}


	teacherInto = function() {}

	/**
	 * 跳转到账户信息的页面
	 */
	Accountinformation = function() {
		location.href = "Accountinformation.html";
	}
	/**
	 * 跳转到收入的页面
	 */
	Incomeitems = function() {
		location.href = "Incomeitems.html";
	}
	/**
	 * 跳转到支出的页面
	 */
	Expenditureitemses = function() {
		location.href = "Expenditureitemses.html";
	}

	/**
	 * 艺考学生分班
	 */
	assignment = function() {
		location.href = "assignment.html";
	}

	/**
	 * 教师课时总表
	 */
	teacherHourSum = function() {
		location.href = "teacherHourSum.html";
	}
	
	/**
	 * 跳转学生课时页面
	 */
	studentHourInfo = function() {
		location.href = "classStudentHourInfo.html";
	}
	/**
	 * 跳转到教师信息的页面
	 */
	Teacher = function() {
		location.href = "Teacher.html";
	}
	ChargeHours = function() {
		location.href = "selectOrderHour.html";
	}
	ChargePeriod = function() {
		location.href = "selectOrderPeriod.html";
	}
	ChargeOthers = function() {
		location.href = "selectOrderOthers.html";
	}
	Expenditure = function() {
		location.href = "selectOrderExpenditure.html";
	}
	Activitys = function() {
		location.href = "selectActivitySchools.html";
	}
	selectgifts = function() {
		location.href = "selectgifts.html";
	}
	selectUsedIntegrals = function() {
		location.href = "selectUsedIntegral.html";
	};
	StudentDepartmentofpediatrics = function() {
		location.href = "selectStudentDepartmentofpediatrics.html";
	};
	StduentRegister = function() {
		location.href = "StduentRegister.html";
	};

	/**
	 * 切换账户
	 */
	switchingAccounts = function() {
		location.href = "switchingAccounts.html";
	}
	/**
	 * 复选框单击选中取消事件
	 */
	$(".customCheck").click(function() {
		if ($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		} else {
			$(this).prev().prop("checked", true);
		}
		e.stopPropagation();
	});
});