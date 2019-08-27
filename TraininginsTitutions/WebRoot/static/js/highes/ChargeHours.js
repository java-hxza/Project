$(function() {
	var Time = new Date();
	var month = null;
	if((Time.getMonth() + 1) <10) {
		month = 0 + (Time.getMonth() + 1).toString();
	}else {
		month = Time.getMonth()+1;
	}S
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".TiJiao").click(function() {
		var date = $.trim($(".date").val());
		var dpMoney = $.trim($(".money").val());
		var hour = $.trim($(".hour").val());
		var hours = $.trim($(".hours").val());
		var stuId = $.trim($(".stuId").val());
		var feecateId = $.trim($(".feecateId").val());
		var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
		var departmentofpediatricsId = $.trim($(".departmentofpediatricsId").val());
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		if (dpMoney == "") {
			alert("请填写收费金额！");
			return false;
		}
		if (hour == "") {
			alert("请填写本次新增课时！");
			return false;
		}
		$.ajax({
			type : "POST",
			url : "addChargeHours.html",
			data : {
				stuId : stuId,
				feecateId : feecateId,
				dpMoney:dpMoney,
				startTime: date,
				departmentofpediatricsId:departmentofpediatricsId,
				addhour:hour,
				givehour:hours,
				remarks:remarks,
				paymentmethodId:paymentmethodId,
				date:date2
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "ChargeHours.html";
				} else {
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