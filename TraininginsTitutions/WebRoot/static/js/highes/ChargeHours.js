$(function(){
	var Time = new Date();
	$(".date").val(Time.getFullYear() + "年" + (Time.getMonth() + 1) + "月" + Time.getDate() + "日");
	$(".TiJiao").click(function() {
		var date = $.trim($(".date").val());
		var money = $.trim($(".money").val());
		var hour = $.trim($(".hour").val());
		var hours = $.trim($(".hours").val());
		if(money == "") {
			alert("请填写收费金额！");
			return false;
		}
		if(hour == "") {
			alert("请填写本次新增课时！");
			return false;
		}
		$.ajax({
			type : "POST",
			url : "addChargeHours.html",
			data :{paymentmethodId : paymentmethodId},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
						if(data.add == "1") {
								alert("添加成功！");
									location.href = "ChargeHours.html";
							}else {
									alert("添加失败！");
									location.href = "ChargeHours.html";
								}
				},
					error : function(data) {
							alert("系统出错！");
							location.href = "ChargeHours.html";
		}
		});
	});
	
});