$(function(){
	var Time = new Date();
	$(".date").val(Time.getFullYear() + "年" + (Time.getMonth() + 1) + "月" + Time.getDate() + "日");
	$(".TiJiao").click(function() {
		var money = $.trim($(".money").val());
		if(money == "") {
			alert("请填写金额！");
			return false;
		}
	});
	
});