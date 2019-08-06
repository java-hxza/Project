/**
 * Login JavaScript
 */
$(function() {
	
	provinceChange = function(){
		var provinceId = $("#provinceId").val();
		alert(provinceId);
		$.ajax({
			url:'login.html',
			data: {
				provinceId:provinceId
			},
			dataType:"JSON",
			type: "post",
			success:function(data){
			alert(data);
			for (var i = 0; i < data.length; i++) {
					alert(data.cityId);
					$("#provinceId").attr("value",data.cityId);
					$("#provinceId").attr("text",data.cityName);
			}
			}, error: function (XMLHttpRequest, textStatus, errorThrown) { 
	 　　           	   alert(XMLHttpRequest.status); 
		　               alert(XMLHttpRequest.readyState); 
		　               alert(textStatus); 
		　　} 
			
		})
			
		
	}
	
	
	UserLogin = function() {

		$("#loginBtn span").addClass("spinner-border spinner-border-sm");
		$("#loginBtn span").text("");
		$("#loginBtn").attr("disabled", "disabled");

		var username = $("#username").val();
		var password = $("#password").val();

		if (username, password == "") {
			$.NotificationApp.send("错误!", "你必须输入账户名及密码。", "top-right", "rgba(0,0,0,0.2)", "error")
			$("#loginBtn span").removeClass("spinner-border spinner-border-sm");
			$("#loginBtn span").text("立即登录");
			$("#loginBtn").attr("disabled", false);
			return false;
		}

		// Login Ajax
		$.ajax({
			url : 'user.html',
			data : {
				opr:"login",
				username : username,
				password : password
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "账户密码校验正确！。", "top-right", "rgba(0,0,0,0.2)", "success")
					location.href = "jsp/index.jsp";
				} else {
					$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
					location.href = "erro.html";
				}
			}
			, error: function (XMLHttpRequest, textStatus, errorThrown) { 
				 　　             alert(XMLHttpRequest.status); 
				　　               alert(XMLHttpRequest.readyState); 
				　　               alert(textStatus); 
				 　　} 
		})

	}

})