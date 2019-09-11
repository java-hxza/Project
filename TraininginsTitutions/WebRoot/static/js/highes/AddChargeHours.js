$(function() {
	if ($(".giftName option:selected").val() == 0) {
		$('.giftNumber').attr("disabled", true);
	}
	if ($(".classes option:selected").attr("classTypeId") == 1) {
		$(".money").val($(".classes option:selected").attr("dpMoney"));
	} else {
		$(".money").val($(".classes option:selected").attr("dpMoneyVip"));
	}
	$(".departmentofpediatricsId").val($(".classes option:selected").attr("dpTypeName"));
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	} else {
		month = Time.getMonth() + 1;
	}
	$(".integral").val($(".money").val());
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".hour").blur(function() {
		if ($(".hour").val() != 0) {
			if ($(".classes option:selected").attr("classTypeId") == 1) {
				$(".money").val((parseFloat($(".classes option:selected").attr("dpMoney")) * $(".hour").val()).toFixed(1));
				$(".integral").val($(".money").val());
			} else {
				$(".money").val((parseFloat($(".classes option:selected").attr("dpMoneyVip")) * $(".hour").val()).toFixed(1));
				$(".integral").val($(".money").val());
			}

		}
	});
	$(".classes").click(function() {
		if ($(".classes option:selected").attr("classTypeId") == 1) {
			if ($(".hour").val() == 0) {
				$(".money").val($(".classes option:selected").attr("dpMoney"));
				$(".integral").val($(".money").val());
			} else {
				$(".money").val((parseFloat($(".classes option:selected").attr("dpMoney")) * $(".hour").val()).toFixed(1));
				$(".integral").val($(".money").val());
			}
		} else {
			if ($(".hour").val() == 0) {
				$(".money").val($(".classes option:selected").attr("dpMoneyVip"));
				$(".integral").val($(".money").val());
			} else {
				$(".money").val(parseFloat($(".classes option:selected").attr("dpMoneyVip")) * $(".hour").val().toFixed(1));
				$(".integral").val($(".money").val());
			}
		}
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
	$(".money").blur(function() {
		if($(".money").val() == "") {
			alert("请输入正确的金额");
			$(".money").val("");
		}
		$(".integral").val($(".money").val());
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
	$(".giftNumber").blur(function() {
		if (parseInt($.trim($(".giftNumber").val())) > parseInt($.trim($(".giftName option:selected").attr("name")))) {
			alert("赠品数量不足！");
			$(".giftNumber").val(1);
		}
	});
	$(".TiJiao").click(function() {
		var date = $.trim($(".date").val());
		var dpMoney = $.trim($(".money").val());
		var hour = $.trim($(".hour").val());
		var hours = $.trim($(".hours").val());
		var stuId = $.trim($(".stuId").val());
		var classId = $.trim($(".classes option:selected").val());
		var feecateId = $.trim($(".feecateId").val());
		var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
		var departmentofpediatricsId = $.trim($(".classes option:selected").attr("name"));
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var integral = $.trim($(".integral").val());
		var giftNumber = $.trim($(".giftNumber").val());
		var giftId = $.trim($(".giftName option:selected").val());
		if (dpMoney == "") {
			alert("请填写收费金额！");
			return false;
		} else if (dpMoney < 1) {
			alert("请填写正确的收费金额！");
			return false;
		}
		if (hour == "") {
			alert("请填写本次新增课时！");
			return false;
		} else if (hour < 1) {
			alert("请填写正确的新增课时！");
			return false;
		}
		if (hours == "") {
			hours = 0;
		}
		$.ajax({
			type : "POST",
			url : "addChargeHours.html",
			data : {
				stuId : stuId,
				feecateId : feecateId,
				dpMoney : dpMoney,
				startTime : date,
				departmentofpediatricsId : departmentofpediatricsId,
				addhour : hour,
				givehour : hours,
				remarks : remarks,
				paymentmethodId : paymentmethodId,
				date : date2,
				classId : classId,
				giftId : giftId,
				giftNumber : giftNumber,
				integral : integral
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "selectOrderHour.html";
				} else {
					alert("添加失败！");
					location.href = "selectOrderHour.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectOrderHour.html";
			}
		});
	});

});