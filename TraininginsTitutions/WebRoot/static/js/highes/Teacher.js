$(function(){
	addTeacher = function() {
		var schoolId = $(".schoolIds:eq(0)").text();
		$(".schoolId").val(schoolId);
		$(".Teachers").remove();
		$(".addTeacher").show();
		$(".del").remove();
		$(".add").click(function() {
			var userName = $.trim($(".userName").val());
			var telephone = $.trim($(".telephone").val());
			var remarks = $.trim($(".remarks").val());
			var teacherId = $.trim($(".teacherName").val());
			var loginName = $.trim($(".loginName").val());
			var loginPassword = $.trim($(".loginPassword").val());
			var loginPasswords = $.trim($(".loginPasswords").val());
			if(userName == "") {
				alert("请填写姓名！");
				return false;
			}
			if(loginName == "") {
				alert("请填写用户名！");
				return false;
			}
			if(loginPassword == "") {
				alert("请填写密码！");
				return false;
			}
			if(loginPasswords == "") {
				alert("请填写第二次密码！");
				return false;
			}
			if(loginPassword != loginPasswords) {
				alert("两次密码输入不一致！");
				return false;
			}
			if(telephone == "") {
				alert("请填写电话！");
				return false;
			}
			if(telephone.length != 11) {
				alert("请输入11位的数字！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addUser.html",
				data :{userName : userName,telephone : telephone,remarks : remarks,teacherId : teacherId,loginName : loginName,loginPassword : loginPassword},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.add == "1") {
									alert("添加成功！");
										location.href = "User.html";
								}else {
										alert("添加失败！");
										location.href = "User.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "User.html";
			}
			});
		});
	};
	
	delTeacher = function() {
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		if(confirm("确认删除吗？")) {
			var uId = $(".customCheckes:checked").parent().parent().next().attr("id");
			$.ajax({
				type : "POST",
				url : "delUser.html",
				data :{uId : uId},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.del == "1") {
									alert("删除成功！");
										location.href = "User.html";
								}else {
										alert("删除失败！");
										location.href = "User.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "User.html";
			}
			});
		}else {
			return false;
		}
	}
	
	updateUser = function() {
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		$(".addTeacher").show();
		var uId = $(".customCheckes:checked").parent().parent().next().attr("id");
		$(".schoolId").val($(".schoolIds:eq(0)").text());
		$(".userName").val($(".customCheckes:checked").parent().parent().next().next().text());
		$(".telephone").val($(".customCheckes:checked").parent().parent().next().next().next().next().text());
		$(".remarks").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().text());
		$(".teacherName").val(4);
		$(".loginName").val($(".customCheckes:checked").parent().parent().next().next().next().next().attr("id"));
		$(".loginPassword").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().attr("id"));
		$(".loginPasswords").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().attr("id"));
		$(".Teachers").remove();
		$(".adds").remove();
		$(".update").remove();
		$(".del").remove();
		$(".add").click(function() {
			var userName = $.trim($(".userName").val());
			var telephone = $.trim($(".telephone").val());
			var remarks = $.trim($(".remarks").val());
			var teacherId = $.trim($(".teacherName").val());
			var loginName = $.trim($(".loginName").val());
			var loginPassword = $.trim($(".loginPassword").val());
			var loginPasswords = $.trim($(".loginPasswords").val());
			if(userName == "") {
				alert("请填写姓名！");
				return false;
			}
			if(loginName == "") {
				alert("请填写用户名！");
				return false;
			}
			if(loginPassword == "") {
				alert("请填写密码！");
				return false;
			}
			if(loginPasswords == "") {
				alert("请填写第二次密码！");
				return false;
			}
			if(loginPassword != loginPasswords) {
				alert("两次密码输入不一致！");
				return false;
			}
			if(telephone == "") {
				alert("请填写电话！");
				return false;
			}
			if(telephone.length != 11) {
				alert("请输入11位的数字！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "updateUser.html",
				data :{userName : userName,telephone : telephone,remarks : remarks,teacherId : teacherId,loginName : loginName,loginPassword : loginPassword,uId:uId},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.update == "1") {
									alert("修改成功！");
										location.href = "User.html";
								}else {
										alert("修改失败！");
										location.href = "User.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "User.html";
			}
			});
		});
	};
});