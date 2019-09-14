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
	
	/**
	 * 新增学员表
	 */
	addStudent = function() {
		var startTime = formatTime(new Date(), 'Y-M-D h:m:s');
		var endTime = formatTime(new Date(), 'Y-M-D h:m:s');
		location.href = "schoolAddStudentInfo.html?startTime="+startTime+"&endTime="+endTime;
		
		
	}
	/**
	 * 教师上课明细
	 */
	teacherClassHour = function(){
		location.href = "teacherClassInfo.html";
	}
	
	feeSituation = function(){
		location.href = "feeSituation.html";
	}
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


	rootTeacherInto = function() {
		location.href = "rootOperatorAuthorize.html";
	}

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
	
	// 格式化日期，如月、日、时、分、秒保证为2位数
	function formatNumber (n) {
	    n = n.toString()
	    return n[1] ? n : '0' + n;
	}
	// 参数number为毫秒时间戳，format为需要转换成的日期格式
	function formatTime (number, format) {
	    let time = new Date(number)
	    let newArr = []
	    let formatArr = ['Y', 'M', 'D', 'h', 'm', 's']
	    newArr.push(time.getFullYear())
	    newArr.push(formatNumber(time.getMonth() + 1))
	    newArr.push(formatNumber(time.getDate()))

	    newArr.push(formatNumber(time.getHours()))
	    newArr.push(formatNumber(time.getMinutes()))
	    newArr.push(formatNumber(time.getSeconds()))

	    for (let i in newArr) {
	        format = format.replace(formatArr[i], newArr[i])
	    }
	    return format;
	}
	
});