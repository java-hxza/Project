/**
 * Login JavaScript
 */
$(function() {
	
	provinceChange = function(){
		var provinceId = $("#provinceId").val();
		$.ajax({
			url:'login.html',
			data: {
				provinceId:provinceId
			},
			dataType:'JSON',
			type: 'post',
			success:function(data){
			data = JSON.parse(data);
			$("#cityId").empty();
			$("#cityId").append("<option value=''>请选择城市</option>");
			for (var i = 0; i < data.length; i++) {
					$("#cityId").append("<option value='"+data[i].cityId+"'> "+data[i].cityName+"</option>");
			}
			}, error: function (XMLHttpRequest, textStatus, errorThrown) { 
	 　　           	   alert(XMLHttpRequest.status); 
		　               alert(XMLHttpRequest.readyState); 
		　               alert(textStatus); 
		　　} 
			
		})
		
	}
	
	cityChange = function(){
		
		var cityId = $("#cityId").val();
		$.ajax({
			url : 'city.html',
			data :{
				cityId : cityId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data){
				data = eval(data);
				$("#schoolId").empty();
				$("#schoolId").append("<option value=''>请选择学校</option>");
				for (var i = 0; i < data.length; i++) {
					$("#schoolId").append("<option value='"+data[i].schoolId+"'>"+data[i].schoolName+"</option>");
				}
			}, 
			error: function (XMLHttpRequest, textStatus, errorThrown) { 
           	   alert(XMLHttpRequest.status); 
		　               alert(XMLHttpRequest.readyState); 
　   	           alert(textStatus); 
	　　		} 
		
			
		});
	}
	
	UserLogin = function() {

		$("#loginBtn span").addClass("spinner-border spinner-border-sm");
		$("#loginBtn span").text("");
		$("#loginBtn").attr("disabled", "disabled");

		var loginName = $("#username").val();
		var loginPassword = $("#password").val();
		var schoolId = $("#schoolId").val();
		
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
					setTimeout(function () { 
						location.href = "index.html";
					}, 2000);
					
				} else {
					$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
					setTimeout(function () { 
						location.href = "erro.html";
					}, 2000);
					
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