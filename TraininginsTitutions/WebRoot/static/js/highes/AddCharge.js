$(function() {
	var Time = new Date();
	var month = null;
	var dpMoneyFeecateIds = 0;
	for (var i = 0; i < $(".feecateIds").length; i++) {
		dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds").eq(i).val()));
	}
	$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
	$(".integral").val($(".dpMoney").val());
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	} else {
		month = Time.getMonth() + 1;
	}
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".giftName").click(function() {
		if ($(".giftName option:selected").val() == 0) {
			$('.giftNumber').attr("disabled", true);
			$(".giftNumber").val("");
		} else {
			$('.giftNumber').removeAttr("disabled");
			$(".giftNumber").val(1);
		}
	});
	$(".feecateId").click(function() {
		if ($(".feecateId option:selected").val() == 0) {
			$('.dpMoneyActivity').attr("disabled", true);
			$(".dpMoneyActivity").val("");
		} else {
			$('.dpMoneyActivity').removeAttr("disabled");
			$(".dpMoneyActivity").val($(".dpMoney").val());
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
		if($(".dpMoney").val() == "") {
			alert("请输入正确的金额");
			$(".dpMoney").val("");
			if($(".feecateId").val() == 0) {
				$(".integral").val("");
			}else {
				$(".dpMoneyActivity").val("");
				$(".integral").val("");
			}
		}else {
			if($(".feecateId").val() == 0) {
				$(".integral").val($(".dpMoney").val());
			}else {
				if($(".feecateId option:selected").attr("discount") == "") {
					$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId option:selected").attr("activityMoneylast")).toFixed(1));
				}else {
					$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId option:selected").attr("activityMoneylast")/100)).toFixed(1));
				}
				$(".integral").val($(".dpMoneyActivity").val());
			}
		}
	});
	$(".feecateIds").blur(function() {
		dpMoneyFeecateIds = 0;
		for (var i = 0; i < $(".feecateIds").length; i++) {
			if($.trim($(".feecateIds").eq(i).val()) != "") {
				dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds").eq(i).val()));
			}
		}
		$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
		if($(".feecateId").val() == 0) {
			$(".integral").val($(".dpMoney").val());
		}else {
			if($(".feecateId option:selected").attr("discount") == "") {
				$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId option:selected").attr("activityMoneylast"))).toFixed(1);
			}else {
				$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId option:selected").attr("activityMoneylast")/100)).toFixed(1));
			}
			$(".integral").val($(".dpMoneyActivity").val());
		}
	});
	$(".feecateId").blur(function() {
		if($(".feecateId").val() != 0) {
			if($(".feecateId option:selected").attr("discount") == "") {
				$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId option:selected").attr("activityMoneylast")).toFixed(1));
				$(".integral").val($(".dpMoneyActivity").val());
			}else {
				$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId option:selected").attr("discount")/100)).toFixed(1));
				$(".integral").val($(".dpMoneyActivity").val());
			}
		}else {
			$(".dpMoneyActivity").val("");
			$(".integral").val($(".dpMoney").val());
		}
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
		var personliable = $.trim($(".personliable").val());
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var integral = $.trim($(".integral").val());
		var giftNumber = $.trim($(".giftNumber").val());
		var giftId = $.trim($(".giftName option:selected").val());
		var teacherId =  $.trim($(".teacherId option:selected").val());
		var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
		var feecateId = "";
		var number = 0;
		for (var i = 0; i < $(".feecateIds").length; i++) {
			if($.trim($(".feecateIds").eq(i).val()) != "" && $.trim($(".feecateIds").eq(i).val()) != 0) {
				number++;
				feecateId = $.trim(feecateId + "," +  $(".feecateIds").eq(i).attr("chargeTypeId").toString());
			}
		}
		feecateId = feecateId.substring(1);
		if(number == 0) {
			alert("请填写至少一个收费项目！");
			return false;
		}
		if($(".feecateId").val() != 0) {
			if($(".dpMoneyActivity").val() == "" || $(".dpMoneyActivity").val() == 0) {
				alert("请填写打折后金额！");
				return false;
			}
		}
		if (dpMoney == "") {
			alert("请填写收费金额！");
			return false;
		} else if (dpMoney < 1) {
			alert("请填写正确的收费金额！");
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
		if(integral == "") {
			alert("请填写积分！");
			return false;
		}
		if(teacherId == 0) {
			alert("请选择招生老师！");
			return false;
		}
		if($(".dpMoneyActivity").val() != "" && $(".dpMoneyActivity").val() != 0) {
			dpMoney = parseFloat($.trim($(".dpMoneyActivity").val())).toFixed(1);
		}
		var discount = null;
		if($.trim($(".dpMoneyActivity").val()) != "" && $.trim($(".dpMoneyActivity").val()) != 0) {
			discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - dpMoney).toFixed(1);
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
				hour : time,
				date : date2,
				teacherId : teacherId,
				discount : discount
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