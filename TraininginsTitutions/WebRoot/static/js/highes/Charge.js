$(function() {
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	}else {
		month = Time.getMonth()+1;
	}
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".TiJiao").click(function() {
		var dpMoney = $.trim($(".dpMoney").val());
		var firstdate = $.trim($(".firstdate").val());
		var lastdate = $.trim($(".lastdate").val());
		var personliable = $.trim($(".personliable").val());
		var stuId = $.trim($(".stuId").val());
		var startTime = $.trim($(".date").val());
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var feecateId = $.trim($(".feecateId").val());
		var date = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
		if (dpMoney == "") {
			alert("请填写金额！");
			return false;
		}
		if (firstdate == "") {
			alert("请选择起始日期！");
			return false;
		}
		if (lastdate == "") {
			alert("请选择截止日期！");
			return false;
		}
		$.ajax({
			type : "POST",
			url : "addChargePeriod.html",
			data : {
				dpMoney : dpMoney,
				firstdate : firstdate,
				lastdate : lastdate,
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
					location.href = "ChargePeriod.html";
				} else {
					alert("添加失败！");
					location.href = "ChargePeriod.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "ChargePeriod.html";
			}
		});
	});
//	$("#studentNames").change(function() {
//		if($("#studentNames").val() != 0) {
//			//$("#studentName").text($("#studentNames option:selected").text());
//			var gender = new Date($("#studentNames").val());
//			var year = Time.getFullYear() - gender.getFullYear();
//			var month = Time.getMonth() - gender.getMonth();
//			if(month < 0 || (month === 0 && Time.getDate() < gender.getDate())) {
//				$("#gender").text(year-1);
//			}
//		}
//	});
});