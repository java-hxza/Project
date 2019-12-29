$(function() {
	var adminState = $("#adminState").html();
	/**
	 * 学校账户信息
	 */
	AdminSchoolListInfo = function() {
		location.href = "adminIndex.html";
	}

	AdminIncomeitems = function() {

		location.href = "AdminIncomeitems.html";
	}

	AdminExpenditureitemses = function() {
		location.href = "AdminExpenditureitemses.html";
	}

	/**
	 * 教师信息页面跳转
	 */
	AdminTeacherInto = function() {
		location.href = "selectSchoolTeacherInfo.html";
	}

	/**
	 * 操作员页面跳转
	 */
	AdminOperatorChilk = function() {
		location.href = "operator.html";
	}

	AdminSelectOrderSchoolInfo = function() {
		location.href = "selectOrderSchoolInfo.html";
	}

	/**
	 * 教师课时页面跳转
	 */
	AdminTeacherHour = function() {
		location.href = "selectOrderTeacherInfo.html";
	}

	/**
	 * 学员课时页面跳转
	 */
	AdminStudentHour = function() {
		location.href = "selectClassSchoolInfo.html";
	}
	/**
	 * 新增学员报表
	 */
	AdminAddStudent = function() {
		location.href = "selectAddStuInfo.html";
	}
	/**
	 * 返回教师上课明细
	 */
	AdminTeacherClassHour = function() {
		location.href = "selectSchoolTeacherClassHourInfo.html";
	}

	/**
	 * 返回学生收费情况表
	 */
	AdminStudentFeeInfo = function() {
		location.href = "selectStudentFeeInfo.html";
	}
	/**
	 * 数据备份
	 */
	dbbackup = function() {
		
		$.ajax({
			url : 'dbbackup.html',
			data : "",
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "1") {
					alert("备份成功！");
				} else {
					alert("备份失败！");
				}
			},
			error : function() {}
		});
	}

	/**
	 * 数据清除
	 */
	dataEliminating = function() {
		if(adminState == 0){
			alert("您没有权限！");
			return false;
		}
		//获取显示区生成的验证码
		var checkCode = $("#checkCode").html();
		//获取输入的验证码
		var inputCode = $("#yanzheng").val();
		//console.log(checkCode);
		//console.log(inputCode);
		if (inputCode.length <= 0) {
			alert("请输入验证码！");
			return false;
		} else if (inputCode.toUpperCase() != checkCode.toUpperCase()) {
			alert("验证码输入有误！");
			createCode(4);
			return false;
		} else {
			alert("验证码正确！");
		}
		
		var class1 = $(".class").prop("checked");
		var order = $(".order").prop("checked");
		var student = $(".student").prop("checked");
		var teacher = $(".teacher").prop("checked");
		var paymentmethod = $(".paymentmethod").prop("checked");
		var expenAndIncome = $(".expenAndIncome").prop("checked");

		$.ajax({
			url : 'dataEliminating.html',
			data : {
				class1 : class1,
				order : order,
				student : student,
				teacher : teacher,
				paymentmethod : paymentmethod,
				expenAndIncome : expenAndIncome
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "1") {
					alert("清除成功！");
					location.href = "adminIndex.html";
				}

			},
			error : function() {
				alert("清除成功！");
				location.href = "adminIndex.html";
			}
		})
	}

	$(".delEliminatings").unbind("click").click(function() {
		if ($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		} else {
			$(this).prev().prop("checked", true);
		}
	});

	

	//生成验证码的方法
	createCode = function(length) {
		var code = "";
		var codeLength = parseInt(length); //验证码的长度
		var checkCode = document.getElementById("checkCode");
		////所有候选组成验证码的字符，当然也可以用中文的
		var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		//循环组成验证码的字符串
		for (var i = 0; i < codeLength; i++) {
			//获取随机验证码下标
			var charNum = Math.floor(Math.random() * 62);
			//组合成指定字符验证码
			code += codeChars[charNum];
		}
		if (checkCode) {
			//为验证码区域添加样式名
			checkCode.className = "code";
			//将生成验证码赋值到显示区
			checkCode.innerHTML = code;
		}
	}
	createCode(4);
	
	/**
	 * 艺考收费情况报表
	 */
	AdminArtStudentFeeInfo = function(){
		location.href = "adminArtStudentFeeInfo.html";
	}
	
	AdminHighStudentFeeInfo = function(){
		location.href = "adminHighStudentFeeInfo.html";
	}
	
});