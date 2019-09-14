$(function() {

	changeTeacherName = function() {
		var teacherName = $(".teacherName").val();

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
					$("#teacherName").focus();
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
	addTeacher = function() {
		var schoolName = $(".schoolIds:eq(0)").text();
		$(".schoolName").val(schoolName);
		$(".Teachers").remove();
		$(".addTeacher").show();
		$(".del").remove();
		$(".update").remove();
		$(".adds").remove();
		$(".add").click(function() {
			var teacherName = $.trim($(".teacherName").val());
			var telephone = $.trim($(".telephone").val());
			var remarks = $.trim($(".remarks").val());
			var teacherTypeId = $.trim($(".teacherTypeName").val());
			var loginPassword = $.trim($(".loginPassword").val());
			var loginPasswords = $.trim($(".loginPasswords").val());
			var departmentId = $(".departmentId").val();
			if (teacherName == "") {
				alert("请填写姓名！");
				return false;
			}
			if (loginPassword == "") {
				alert("请填写密码！");
				return false;
			}
			if (loginPassword.length < 6) {
				alert("密码最少为6位！");
				return false;
			}
			if (loginPasswords == "") {
				alert("请填写第二次密码！");
				return false;
			}
			if (loginPasswords.length < 6) {
				alert("密码最少为6位！");
				return false;
			}
			if (loginPassword != loginPasswords) {
				alert("两次密码输入不一致！");
				return false;
			}
			if (telephone == "") {
				alert("请填写电话！");
				return false;
			}
			if (telephone.length != 11) {
				alert("请输入11位的数字！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addTeacher.html",
				data : {
					teacherName : teacherName,
					telephone : telephone,
					remarks : remarks,
					teacherTypeId : teacherTypeId,
					loginPassword : loginPassword,
					departmentId : departmentId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！！！");
						location.href = "Teacher.html";
					} else {
						alert("添加失败！！！");
						location.href = "Teacher.html";
					}
				},
				error : function(data) {
					alert("系统出错！！！");
					location.href = "Teacher.html";
				}
			});
		});
	};

	delTeacher = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		if (confirm("确认删除吗？")) {
			var teacherId = $(".customCheckes:checked").parent().parent().next().attr("id_teacherId");
			$.ajax({
				type : "POST",
				url : "delTeacher.html",
				data : {
					teacherId : teacherId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "Teacher.html";
					} else {
						alert("删除失败！");
						location.href = "Teacher.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "Teacher.html";
				}
			});
		} else {
			return false;
		}
	}

	updateUser = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		$(".addTeacher").show();
		var uId = $(".customCheckes:checked").parent().parent().next().attr("id_teacherId");
		$(".schoolName").val($(".schoolIds:eq(0)").text());
		$(".teacherName").val($(".customCheckes:checked").parent().parent().next().next().text());
		$(".telephone").val($(".customCheckes:checked").parent().parent().next().next().next().next().text());
		$(".remarks").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().text());
		$(".loginPassword").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().attr("id_password"));
		$(".loginPasswords").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().attr("id_password"));
		var teacherId = $(".customCheckes:checked").parent().parent().next().attr("id_teacherId");
		var departmentId = $(".customCheckes:checked").parent().parent().parent().children("td:last-child").attr("name");
		$(".Teachers").remove();
		$(".adds").remove();
		$(".update").remove();
		$(".del").remove();
		$(".add").click(function() {
			var teacherName = $.trim($(".teacherName").val());
			var telephone = $.trim($(".telephone").val());
			var remarks = $.trim($(".remarks").val());
			var loginPassword = $.trim($(".loginPassword").val());
			var loginPasswords = $.trim($(".loginPasswords").val());
			var teacherTypeId = $.trim($("#teacherTypeName").val());
			if (teacherName == "") {
				alert("请填写姓名！");
				return false;
			}
			if (loginPassword == "") {
				alert("请填写密码！");
				return false;
			}
			if (loginPassword.length < 6) {
				alert("密码最少为6位！");
				return false;
			}
			if (loginPasswords == "") {
				alert("请填写第二次密码！");
				return false;
			}
			if (loginPasswords.length < 6) {
				alert("密码最少为6位！");
				return false;
			}
			if (loginPassword != loginPasswords) {
				alert("两次密码输入不一致！");
				return false;
			}
			if (telephone == "") {
				alert("请填写电话！");
				return false;
			}
			if (telephone.length != 11) {
				alert("请输入11位的数字！");
				return false;
			}
			$.ajax({
				url : "updateTeacher.html",
				type : "POST",
				data : {
					teacherName : teacherName,
					telephone : telephone,
					remarks : remarks,
					loginPassword : loginPassword,
					teacherTypeId : teacherTypeId,
					teacherId : teacherId,
					departmentId : departmentId
				},
				dataType : 'JSON',
				success : function(data) {
					data = JSON.parse(data);
					if (data.update == "1") {
						alert("修改成功！");
						location.href = "Teacher.html";
					} else {
						alert("修改失败！");
						location.href = "Teacher.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					alert(data.statusText);
					alert(data.status);
					location.href = "Teacher.html";
				}
			});
		});
	};
	teacherAuthorization = function(){
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		
		var teacherId = $(".customCheckes:checked").parent().parent().next().attr("id_teacherId");
		
		location.href ="rootOperatorAuthorization.html?teacherId="+teacherId;
	}
});