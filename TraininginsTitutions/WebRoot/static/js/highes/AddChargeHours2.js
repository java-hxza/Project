$(function() {

	if ($(".giftName option:selected").val() == 0) {
		$('.giftNumber').attr("disabled", true);
	}
	$(".school").val($(".classes option:selected").attr("schoolIds2"));
//	if ($(".classes option:selected").attr("classTypeId") == 1) {
//		$(".money").val($(".classes option:selected").attr("dpMoney"));
//	} else {
//		$(".money").val($(".classes option:selected").attr("dpMoneyVip"));
//	}
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
//	$(".hour").blur(function() {
//		if ($(".hour").val() != 0) {
//			if ($(".classes option:selected").attr("classTypeId") == 1) {
//				$(".money").val((parseFloat($(".classes option:selected").attr("dpMoney")) * $(".hour").val()).toFixed(1));
//				$(".integral").val($(".money").val());
//			} else {
//				$(".money").val((parseFloat($(".classes option:selected").attr("dpMoneyVip")) * $(".hour").val()).toFixed(1));
//				$(".integral").val($(".money").val());
//			}
//
//		}
//	});
	$(".classes").click(function() {
		$(".departmentofpediatricsId").val($(".classes option:selected").attr("dpTypeName"));
		if ($(".classes option:selected").attr("classTypeId") == 1) {
//			if ($(".hour").val() == 0) {
//				$(".money").val($(".classes option:selected").attr("dpMoney"));
//				$(".integral").val($(".money").val());
//			} else {
//				$(".money").val((parseFloat($(".classes option:selected").attr("dpMoney")) * $(".hour").val()).toFixed(1));
//				$(".integral").val($(".money").val());
//			}
//		} else {
//			if ($(".hour").val() == 0) {
//				$(".money").val($(".classes option:selected").attr("dpMoneyVip"));
//				$(".integral").val($(".money").val());
//			} else {
//				$(".money").val(parseFloat($(".classes option:selected").attr("dpMoneyVip")) * $(".hour").val().toFixed(1));
//				$(".integral").val($(".money").val());
//			}
		}
	});
	$(".stuId").change(function() {
		var stuId = $.trim($(".stuId").val());
		if(stuId == "") {
			return false;
		}
		$.ajax({
			type : "POST",
			url : "StudentInformation.html",
			data : {
				studentId : stuId
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".header-title").html(data.studentInformation);

			},
			error : function(data) {
				alert("系统出错2！");
				location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
			}
		});
		$.ajax({
			type : "POST",
			url : "ChargeHoursClass.html",
			data : {
				studentId : stuId,
				classTypeTime : 1
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".classes").empty();
					if(data.classes == "0") {
						alert("该学生已参与所有班级！");
					}else {
						for (var i = 0; i < data.classes.length; i++) {
							$(".classes").append("<option value='" + data.classes[i].classId + "' name='" + data.classes[i].departmentOfPediatrics.dpId + "' dpTypeName='" + data.classes[i].departmentOfPediatrics.dpTypeName + "' classTypeId='" + data.classes[i].classTypeId + "' schoolIds2='" + data.classes[i].school.schoolName + "'> " + data.classes[i].className + "</option>");
						}
					}

			},
			error : function(data) {
				alert("系统出错22！");
				location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
			}
		});
	});
	$(".money").blur(function() {
		if ($(".money").val() == "" || $(".money").val() < 1) {
			alert("请输入正确的金额");
			$(".money").val("");
			$(".dpMoneyActivity4").val("");
			$(".integral").val("");
			if ($(".feecateId4").val() == 0) {
				$(".integral").val("");
			} else {
				$(".dpMoneyActivity4").val("");
				$(".integral").val($(".dpMoneyActivity4").val());
			}
		} else {
			if ($(".feecateId4").val() == 0) {
				$(".integral").val($(".money").val());
				$(".dpMoneyActivity4").val($(".money").val());
			} else {
				if ($(".feecateId4 option:selected").attr("discount") == "") {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
				} else {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
				}
				$(".integral").val($(".dpMoneyActivity4").val());
			}
		}
	});
	$(".feecateId4").blur(function() {
		if ($(".feecateId4").val() != 0) {
			if ($(".feecateId4 option:selected").attr("discount") == "") {
				$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
				$(".integral").val($(".dpMoneyActivity4").val());
			} else {
				$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
				$(".integral").val($(".dpMoneyActivity4").val());
			}
		} else {
			$(".dpMoneyActivity4").val($(".money").val());
			$(".integral").val($(".money").val());
		}
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
		var dpMoney = $.trim($(".dpMoneyActivity4").val());
		var hour = $.trim($(".hour").val());
		var hours = $.trim($(".hours").val());
		var stuId = $.trim($(".stuId").val());
		var classId = $.trim($(".classes option:selected").val());
		var feecateId = $.trim($(".feecateId").val());
		var date2 = Time.getFullYear().toString() + month.toString();
		var departmentofpediatricsId = $.trim($(".classes option:selected").attr("name"));
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var integral = $.trim($(".integral").val());
		var giftNumber = $.trim($(".giftNumber").val());
		var giftId = $.trim($(".giftName option:selected").val());
		var feecateId4 = $(".feecateId4 option:selected").val();
		var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
		var discount = 0;
		if($(".dpMoneyActivity4").val() != "" && $(".dpMoneyActivity4").val() != 0) {
			discount = $.trim($(".money").val()) - dpMoney; 
		}
		if(stuId == "") {
			alert("请选择学生！");
			return flase;
		}
		if ($(".money").val() == "") {
			alert("请填写应收金额！");
			return false;
		} else if (parseFloat($(".money").val()) < 1) {
			alert("请填写正确的应收金额！");
			return false;
		}
		if (dpMoney == "") {
			alert("请填写实收金额！");
			return false;
		} else if (dpMoney < 1) {
			alert("请填写正确的实收金额！");
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
		var serviceCharge = parseFloat($.trim($(".serviceCharge").val()));
		if ($(".serviceCharge").val() == "") {
			serviceCharge = 0;
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
				integral : integral,
				activityId : feecateId4,
				discount : discount,
				startTimes : startTimes,
				serviceCharge : serviceCharge
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
				} else {
					alert("添加失败！");
					location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
			}
		});
	});

});