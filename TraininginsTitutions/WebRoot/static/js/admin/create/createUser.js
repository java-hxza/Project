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
				
			},
			 error: function (XMLHttpRequest, textStatus, errorThrown) { 
		 　　             alert(XMLHttpRequest.status); 
		　　               alert(XMLHttpRequest.readyState); 
		　　               alert(textStatus); 
 　　			} 
		});
	}
});