$(function(){
	
	var Time = new Date();
	$(".date").val(Time.getFullYear() + "年" + (Time.getMonth() + 1) + "月" + Time.getDate() + "日");
});