$(function(){
	
	/**
	 * 注册用户
	 */
	regitUser = function(){
		/**
		 * 获取用户录入的值
		 */
		var loginName = $("#loginName").val();
		var loginPassword = $("#loginPassword").val();
		var schoolId = $("#schoolId").val();
		var userTypeId = $("#userTypeId").val();
		var remarks = $("#remarks").val();
		if((loginName,loginPassword,schoolId== null) || (userTypeId =="0")){
			$.NotificationApp.send("错误!", "你必须输入账户名及密码。", "top-right", "rgba(0,0,0,0.2)", "error")
			$("#loginBtn span").removeClass("spinner-border spinner-border-sm");
			$("#loginBtn span").text("立即登录");
			$("#loginBtn").attr("disabled", false);
			return false;
		}
		/**
		 * 异步提交
		 */
		$.ajax({
			url	: 'regitUser.html',
			data : {
				loginName : loginName,
				loginPassword : loginPassword,
				remarks : remarks,
				userTypeId : userTypeId,
				schoolId : schoolId
			},
			dataType: "JSON",
			success: function(data){
				data = eval(data);
				if(data.state == "1"){
					$.NotificationApp.send("成功！", "创建账户成功！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "adminIndex.html";
					}, 2000);
				}else{
					$.NotificationApp.send("失败！", "创建学校失败请重新创建！。", "top-right", "rgba(0,0,0,0.2)", "error");
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);
				}
			},
			 error: function (XMLHttpRequest, textStatus, errorThrown) { 
		 　　             alert(XMLHttpRequest.status); 
		　　               alert(XMLHttpRequest.readyState); 
		　　               alert(textStatus); 
		　　               $.NotificationApp.send("失败！", "创建学校失败请重新创建！。", "top-right", "rgba(0,0,0,0.2)", "error");
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);
 　　				} 
		});
	}
	
	
	loginNameVerification = function(){
		var loginName = $("#loginName").val();
		if(loginName == null){
			return false;
		}
		
		$.ajax({
			url : 'loginNameVerification.html',
			data : {
				loginName : loginName
			},
			dataType : 'JSON',
			type : 'post',
			success: function(data){
				data = eval(data);
				if(data.state == "1"){
					$.NotificationApp.send("提醒！", "该账户可以使用！。", "top-right", "rgba(0,0,0,0.2)", "success");
				}else{
					$.NotificationApp.send("提醒！", "该账户已有，请更改账号！。", "top-right", "rgba(0,0,0,0.2)", "error");
					$("#loginName").focus();
				}
			},error: function (XMLHttpRequest, textStatus, errorThrown) { 
		 　　          alert(XMLHttpRequest.status); 
		　               alert(XMLHttpRequest.readyState); 
		　               alert(textStatus); 
		　               $.NotificationApp.send("失败！", "创建学校失败请重新创建！。", "top-right", "rgba(0,0,0,0.2)", "error");
		　               setTimeout(function() {
		　            	   location.href = "erro.html";
		　               }, 2000);
			} 
			
		});
		
	}
});