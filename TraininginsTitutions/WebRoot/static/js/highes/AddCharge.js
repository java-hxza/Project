$(function() {
	$(".money").val($(".departmentofpediatricsId option:selected").attr("name"));
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	} else {
		month = Time.getMonth() + 1;
	}
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".departmentofpediatricsId").click(function() {
		$(".money").val($(".departmentofpediatricsId option:selected").attr("name"));
	});
	$(".giftName").click(function() {
		if ($(".giftName option:selected").val() == 0) {
			$('.giftNumber').attr("disabled", true);
			$(".giftNumber").val("");
		} else {
			$('.giftNumber').removeAttr("disabled");
			$(".giftNumber").val(1);
		}
	});
	$(".classes").click(function() {
		var classIds = $(".classes option:selected").val();
		$.ajax({
			type : "POST",
			url : "selectClassStudent.html",
			data : {
				classId : classIds
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				for (var i = 0; i < data.children.length; i++) {
					$(".stuId").append("<option class='delSt' value='" + data.children[i].studentId + "'> " + data.children[i].studentName + "</option>");
				}

			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectOrderHour.html";
			}
		});
	});
	$(".giftNumber").blur(function() {
		if (parseInt($.trim($(".giftNumber").val())) > parseInt($.trim($(".giftName option:selected").attr("name")))) {
			alert("赠品数量不足！");
			$(".giftNumber").val(1);
		}
	});
	$(".dpMoney").blur(function() {
		$(".integral").val($(".dpMoney").val());
	});
	var time = null;
	$(".firstdate").blur(function() {
		if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
			var start = $(".firstdate").val();
			var end = $(".lastdate").val();
			if (start > end) {
				alert("结束时间不能在开始时间之前！");
				$(".firstdate").val("");
			}else {
				start = start.replace(/-/g, "/");
				var startdate = new Date(start);
				end = end.replace(/-/g, "/");
				var enddate = new Date(end);
				time = parseInt((enddate.getTime() - startdate.getTime())/(1000 * 60 * 60 * 24));
				alert(time);
			}
		}
	});
	$(".lastdate").blur(function() {
		if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
			var start = $(".firstdate").val();
			var end = $(".lastdate").val();
			if (start > end) {
				alert("结束时间不能在开始时间之前！");
				$(".lastdate").val("");
			}else {
				start = start.replace(/-/g, "/");
				var startdate = new Date(start);
				end = end.replace(/-/g, "/");
				var enddate = new Date(end);
				time = parseInt((enddate.getTime() - startdate.getTime())/(1000 * 60 * 60 * 24));
				alert(time + "天");
			}
		}
	});
	$(".TiJiao").click(function() {
		var date = $.trim($(".date").val());
		var dpMoney = $.trim($(".dpMoney").val());
		var firstdate = $.trim($(".firstdate").val());
		var lastdate = $.trim($(".lastdate").val());
		var stuId = $.trim($(".stuId").val());
		var classId = $.trim($(".classes option:selected").val());
		var feecateId = $.trim($(".feecateId").val());
		var personliable = $.trim($(".personliable").val());
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var integral = $.trim($(".integral").val());
		var giftNumber = $.trim($(".giftNumber").val());
		var giftId = $.trim($(".giftName option:selected").val());
		if (dpMoney == "") {
			alert("请填写收费金额！");
			return false;
		}
		if (firstdate == "") {
			alert("请填写起始日期！");
			return false;
		}
		if(lastdate == "") {
			alert("请填写截止日期！");
			return false;
		}
		if (personliable == "") {
			alert("请填写责任人！");
			return false;
		}
		if(giftNumber == "") {
			giftNumber = 0;
		}
		$.ajax({
			type : "POST",
			url : "addChargePeriod.html",
			data : {
				stuId : stuId,
				feecateId : feecateId,
				dpMoney : dpMoney,
				startTime : date,
				firstdate : firstdate,
				lastdate : lastdate,
				remarks : remarks,
				paymentmethodId : paymentmethodId,
				classId : classId,
				giftId : giftId,
				giftNumber : giftNumber,
				integral : integral,
				personliable : personliable,
				hour : time
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "selectOrderPeriod.html";
				} else {
					alert("添加失败！");
					location.href = "selectOrderPeriod.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectOrderPeriod.html";
			}
		});
	});

});