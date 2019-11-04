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
		location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
	}
	ChargePeriod = function() {
		location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
	}
	ChargeOthers = function() {
		location.href = "selectOrderOthers.html?orderCounts=0&classId=0&studentName=000111";
	}
	Expenditure = function() {
		location.href = "selectOrderExpenditure.html?orderCounts=0&classId=0&studentName=000111";
	}
	selectRefund = function() {
		location.href = "selectRefund.html?orderCounts=0&classId=0&studentName=000111";
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
	RecruitStudents = function() {
		location.href = "RecruitStudents.html";
	};
	
	classTypes = function() {
		location.href = "selectClassTypes.html";
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
	$(".customCheck").unbind("click").click(function() {
		if ($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		} else {
			$(this).prev().prop("checked", true);
		}
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
	
	/**
	 * 高中收费情况报表
	 */
	highFeeSituation = function(){
		location.href = "highFeeSituation.html";
	}
	
	/**
	 *艺考收费报表 
	 */
	artFeeSituation = function(){
		location.href = "rootArtStudentFooInfo.html";
	}
	
	/**
	 * 学院退学
	 */
	studentLeave = function(){
		location.href = "studentLeave.html";
	}
	
	/**
	 * 学员结业
	 */
	studentGraduation = function(){
		location.href = "studentGraduation.html";
	}
	
	$('input[type="date"]').change(function(){
	 	var myDate = new Date();  //获取当前时间对象，精确到当前的时、分、秒
	 	
	 	var this_time=$('input[name="time"]').val();//获取用户选择后的时间值
	 
	 	var this_datetime=new Date(this_time);//获取用户选择的时间，生成时间对象  具体时间为时间8:00:00
	 	var year = myDate.getFullYear();	//获取当前时间的年份 格式xxxx 如：2016
	 	var month =myDate.getMonth()+1;		//获取当前时间的月份 格式1-9月为x， 10-12月为xx 如：11
	 	var date = myDate.getDate();		//获取当前时间的日期 格式同月份 如11
	 	 myDate=new Date(year+'-'+month+'-'+date);	//获取根据上述时间生成的时间对象 具体时间为0:00:00 	
	 	var now=new Date(year+'-'+month+'-'+date+' 8:00:00'); 
	 	myDate.setDate(now.getDate()-7); //设置now对象相应日期的七天前日期 具体时间为0:00:00
	 	if(this_datetime<myDate||this_datetime>now){	//时间对象可以直接比较大小
	 		alert('拜访时间需选择今天及以前7天内的时间');
	 		$('input[name="time"]').val('');	
	 	};
	 });
});