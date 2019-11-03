/**
 * Login JavaScript
 */
$(function() {

	provinceChange = function() {
		var provinceId = $("#provinceId").val();
		$.ajax({
			url : 'login.html',
			data : {
				provinceId : provinceId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = JSON.parse(data);
				$("#cityId").empty();
				$("#schoolId").empty();
				$("#cityId").append("<option value=''>请选择城市</option>");
				$("#schoolId").append("<option value=''>请选择学校</option>");
				for (var i = 0; i < data.length; i++) {
					$("#cityId").append("<option value='" + data[i].cityId + "'> " + data[i].cityName + "</option>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		})

	}

	cityChange = function() {

		var cityId = $("#cityId").val();
		$.ajax({
			url : 'city.html',
			data : {
				cityId : cityId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = eval(data);
				$("#schoolId").empty();
				if (data == '' || data == null) {
					$("#schoolId").append("<option value=''>该城市还没有学校</option>");
				} else {
					$("#schoolId").append("<option value=''>请选择学校</option>");
				}
				for (var i = 0; i < data.length; i++) {
					$("#schoolId").append("<option value='" + data[i].schoolId + "'>" + data[i].schoolName + "</option>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {}
		});
	}
	/**
	 * 管理员登录
	 */
	UserLogin = function() {


		var loginName = $("#logname").val();
		var loginPassword = $("#password").val();

		if (loginName, loginPassword == "") {
			$.NotificationApp.send("错误!", "你必须输入账户名及密码。", "top-right", "rgba(0,0,0,0.2)", "error")
			return false;
		}

		// Login Ajax
		$.ajax({
			url : 'userLogin.html',
			data : {
				loginName : loginName,
				loginPassword : loginPassword,
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = eval(data);
				if (data.state == "1") {
					if (data.UsertypeId == "1") {
							location.href = "adminIndex.html";
					} else {
							location.href = "selectionModule.html";
					}
				} else {
					alert("账号密码错误，请检查重试!");
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);

				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("账号密码错误，请检查重试!");
					location.href = "erro.html";
			}
		})

	}
	/**
	 * 超管登录
	 */
	adminLogin = function() {
		$("#loginBtn span").addClass("spinner-border spinner-border-sm");
		$("#loginBtn span").text("");
		$("#loginBtn").attr("disabled", "disabled");

		var loginName = $("#username").val();
		var loginPassword = $("#password").val();
		var schoolId = $("#schoolId").val();

		if (loginName, loginPassword == "") {
			$.NotificationApp.send("错误!", "你必须输入账户名及密码。", "top-right", "rgba(0,0,0,0.2)", "error")
			$("#loginBtn span").removeClass("spinner-border spinner-border-sm");
			$("#loginBtn span").text("立即登录");
			$("#loginBtn").attr("disabled", false);
			return false;
		}

		// Login Ajax
		$.ajax({
			url : 'adminLogin.html',
			data : {
				loginName : loginName,
				loginPassword : loginPassword,
				schoolId : schoolId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = eval(data);
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "账户密码校验正确！。", "top-right", "rgba(0,0,0,0.2)", "success")
					setTimeout(function() {
						location.href = "adminIndex.html";
					}, 2000);
				} else {
					$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);

				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
				setTimeout(function() {
					location.href = "erro.html";
				}, 2000);
			}
		})
	}
	/**
	 *教师登录 
	 */
	TeacherLogin = function() {
		$("#loginBtn span").addClass("spinner-border spinner-border-sm");
		$("#loginBtn span").text("");
		$("#loginBtn").attr("disabled", "disabled");

		var loginName = $("#username").val();
		var loginPassword = $("#password").val();
		var schoolId = $("#schoolId").val();
		var departmentId = $("#departmentId").val();
		if ((loginName, loginPassword, departmentId == "") || (loginName, loginPassword, departmentId == null)) {
			$.NotificationApp.send("错误!", "你必须输入账户名及密码。", "top-right", "rgba(0,0,0,0.2)", "error")
			$("#loginBtn span").removeClass("spinner-border spinner-border-sm");
			$("#loginBtn span").text("立即登录");
			$("#loginBtn").attr("disabled", false);
			return false;
		}

		// Login Ajax
		$.ajax({
			url : 'teacherLogin.html',
			data : {
				loginName : loginName,
				loginPassword : loginPassword,
				schoolId : schoolId,
				departmentId : departmentId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = eval(data);
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "账户密码校验正确！。", "top-right", "rgba(0,0,0,0.2)", "success")
					setTimeout(function() {
						location.href = "teacherIndex.html";
					}, 2000);

				} else {
					$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);

				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
				setTimeout(function() {
					location.href = "erro.html";
				}, 2000);
			}
		})

	}

})