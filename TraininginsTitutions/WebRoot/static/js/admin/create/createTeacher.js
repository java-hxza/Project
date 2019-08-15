$(function(){
	teacherPasswordBlue = function(){
		var pwd = $("#loginPassword").val();
		var pwds = $("#loginPasswords").val();
		if(pwd != pwds){
			alert("两次密码输入不一致 请重新输入！");
			return false;
		}
		
	}
	
	
});