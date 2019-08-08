$(function(){
	regitUser = function(){
		var userName = $("#userName").val();
		var loginName = $("#loginName").val();
		var loginPassword = $("#loginPassword").val();
		var schoolId = $("#schoolId").val();
		if(userName,loginName,loginPassword,schoolId == null){
			$.NotificationApp.send("错误!", "你必须输入账户名及密码。", "top-right", "rgba(0,0,0,0.2)", "error")
			$("#loginBtn span").removeClass("spinner-border spinner-border-sm");
			$("#loginBtn span").text("立即登录");
			$("#loginBtn").attr("disabled", false);
			return false;
		}
		
		$.ajax({
			url	: 'regitUser.html',
			data : {
				userName : userName,
				loginName : loginName,
				loginPassword : loginPassword,
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
					$.NotificationApp.send("失败！", "创建学校失败请重新创建！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);
				}
			},
			 error: function (XMLHttpRequest, textStatus, errorThrown) { 
		 　　             alert(XMLHttpRequest.status); 
		　　               alert(XMLHttpRequest.readyState); 
		　　               alert(textStatus); 
 　　			} 
		});
	}
});