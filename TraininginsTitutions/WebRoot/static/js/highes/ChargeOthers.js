$(function(){
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	}else {
		month = Time.getMonth()+1;
	}
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".TiJiao").click(function() {
	var stuId = $.trim($(".stuId").val());
	var startTime = $.trim($(".date").val());
	var feecateId = $.trim($(".feecateId").val());
	var dpMoney = $.trim($(".dpMoney").val());
	var remarks = $.trim($(".remarks").val());
	var paymentmethodId = $.trim($(".paymentmethodId").val());
	var personliable = $.trim($(".personliable").val());
	var date = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
	if(dpMoney == "") {
		alert("请填写金额！");
		return false;
	}
	$.ajax({
		type : "POST",
		url : "addChargeOthers.html",
		data : {
			dpMoney : dpMoney,
			personliable : personliable,
			stuId : stuId,
			startTime : startTime,
			paymentmethodId : paymentmethodId,
			remarks : remarks,
			feecateId : feecateId,
			date : date
		},
		dataType : "json",
		success : function(data) {
			data = JSON.parse(data);
			if (data.add == "1") {
				alert("添加成功！");
				location.href = "ChargeOthers.html";
			} else {
				alert("添加失败！");
				location.href = "ChargeOthers.html";
			}
		},
		error : function(data) {
			alert("系统出错！");
			location.href = "ChargeOthers.html";
		}
	});
	});
});