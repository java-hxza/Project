$(function() {
	teacherPasswordBlue = function() {
		var pwd = $("#loginPassword").val();
		var pwds = $("#loginPasswords").val();
		if (pwd != pwds) {
			alert("两次密码输入不一致 请重新输入！");
			return false;
		}

	}
	/**
	 * 校验登录名
	 */
	teacherNameCheck = function() {
		var teacherName = $("#teacherName").val();

		if (teacherName == null) {
			$.NotificationApp.send("错误！", "登录名不能为空！。", "top-right", "rgba(0,0,0,0.2)", "error");
			return false;
		}


		$.ajax({
			url : 'teacherNameCheck.html',
			data : {
				teacherName : teacherName
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "0") {
					$.NotificationApp.send("提醒！", "该账户已有，请更改账号！。", "top-right", "rgba(0,0,0,0.2)", "error");
					$("#loginName").focus();
				} else {
					$.NotificationApp.send("提醒！", "该账户可以使用！。", "top-right", "rgba(0,0,0,0.2)", "success");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		})
	}


	regitTeacher = function() {
		
		var remarks = $("#remarks").val();
		var teacherTypeId = $("#teacherTypeId").val();
		var telephone = $("#telephone").val();
		var loginPassword = $("#loginPassword").val();
		var teacherName = $("#teacherName").val();
		var feeCategory = $("#feeCategory").val();
		var teacherTypeId = $("#departmentId").val();
		var schoolId = $("#schoolId").val();
		
		if (telephone, loginPassword == null) {
			$.NotificationApp.send("错误！", "信息不能为空！。", "top-right", "rgba(0,0,0,0.2)", "error");
			return false;
		}

		$.ajax({
			url : 'regitTeacher.html',
			data : {
				remarks : remarks,
				teacherTypeId : teacherTypeId,
				telephone : telephone,
				loginPassword : loginPassword,
				teacherName : teacherName,
				feeCategory : feeCategory,
				teacherTypeId : teacherTypeId,
				schoolId : schoolId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "创建教师成功！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "adminIndex.html";
					}, 2000);
				} else {
					$.NotificationApp.send("失败！", "创建教师失败请重新创建！。", "top-right", "rgba(0,0,0,0.2)", "error");
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});

	}

});