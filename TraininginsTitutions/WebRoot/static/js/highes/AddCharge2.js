$(function() {
	if($(".Type").attr("name") == 2) {
		$(".giftNameDiv").remove();
		$(".giftNumberDiv").remove();
		$(".feecateId4Div").remove();
		$(".integralDiv").remove();
		$(".departmentofpediatricsIds").val($(".classes option:selected").attr("departmentOfPediatrics"));
		var Time = new Date();
		var month = null;
		var dpMoneyFeecateIds = 0;
		$(".school").val($(".classes option:selected").attr("schoolIds2"));
//		for (var i = 0; i < $(".feecateIds").length; i++) {
//			dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds").eq(i).val()));
//		}
//		$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
		if ((Time.getMonth() + 1) < 10) {
			month = 0 + (Time.getMonth() + 1).toString();
		} else {
			month = Time.getMonth() + 1;
		}
		$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
		$(".classes").click(function() {
			$(".departmentofpediatricsIds").val($(".classes option:selected").attr("departmentOfPediatrics"));
		});
		$(".dpMoney").blur(function() {
			if($(".dpMoney").val() == "" || $(".dpMoney").val() == 0) {
				alert("请输入正确的金额");
				$(".dpMoney").val("");
			}
		});
		$(".feecateIds").blur(function() {
			dpMoneyFeecateIds = 0;
			for (var i = 0; i < $(".feecateIds").length; i++) {
				if ($.trim($(".feecateIds").eq(i).val()) != "") {
					dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds").eq(i).val()));
				}
			}
			$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
			$(".dpMoneyActivity4").val(dpMoneyFeecateIds.toFixed(1));
				
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
			var dpMoney = $.trim($(".dpMoneyActivity4").val());
			var firstdate = $.trim($(".firstdate").val());
			var lastdate = $.trim($(".lastdate").val());
			var stuId = $.trim($(".stuId").val());
			var classId = $.trim($(".classes option:selected").val());
			var personliable = $.trim($(".personliable").val());
			var remarks = $.trim($(".remarks").val());
			var paymentmethodId = $.trim($(".paymentmethodId").val());
			var date2 = Time.getFullYear().toString() + month.toString();
			var feecateId = "";
			var number = 0;
			var feecateMoney = "";
			var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
			for (var i = 0; i < $(".feecateIds").length; i++) {
				if($.trim($(".feecateIds").eq(i).val()) != "" && $.trim($(".feecateIds").eq(i).val()) != 0) {
					number++;
					feecateId = $.trim(feecateId + "," +  $(".feecateIds").eq(i).attr("chargeTypeId").toString());
				}
			}
			feecateId = feecateId.substring(1);
			for (var i = 0; i < $(".feecateIds").length; i++) {
				if ($(".feecateIds").eq(i).val() != "") {
					feecateMoney = feecateMoney + "," + $(".feecateIds").eq(i).val();
				} 
			}
			if(dpMoney == "" || dpMoney < 1) {
				dpMoney = $.trim($(".dpMoney").val());
			}
			feecateMoney = feecateMoney.substr(1);
			if($(".dpMoneyActivity4").val() != "" && $(".dpMoneyActivity4").val() != 0) {
				dpMoney = parseFloat($.trim($(".dpMoneyActivity4").val())).toFixed(1);
			}
			var discount = null;
			if($.trim($(".dpMoneyActivity4").val()) != "" && $.trim($(".dpMoneyActivity4").val()) != 0) {
				discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - parseFloat($.trim($(".dpMoneyActivity4").val()))).toFixed(1);
			}
			if(stuId == "") {
				alert("请选择学生！");
				return flase;
			}
			if(number == 0) {
				alert("请填写至少一个收费项目！");
				return false;
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
			var serviceCharge = parseFloat($.trim($(".serviceCharge").val()));
			if ($(".serviceCharge").val() == "") {
				serviceCharge = 0;
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
					giftId : 0,
					giftNumber : 0,
					integral : 0,
					personliable : personliable,
					hour : time,
					date : date2,
					discount : discount,
					activityId : null,
					startTimes : startTimes,
					feecateMoney : feecateMoney,
					serviceCharge : serviceCharge
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
					} else {
						alert("添加失败！");
						location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
				}
			});
		});
	}else {
		$(".departmentofpediatricsIds").val($(".classes option:selected").attr("departmentOfPediatrics"));
		var Time = new Date();
		var month = null;
		var dpMoneyFeecateIds = 0;
		$(".school").val($(".classes option:selected").attr("schoolIds2"));
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
		$(".classes").click(function() {
			$(".departmentofpediatricsIds").val($(".classes option:selected").attr("departmentOfPediatrics"));
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
					$(".dpMoneyActivity").val($(".dpMoney").val());
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
				if ($.trim($(".feecateIds").eq(i).val()) != "") {
					dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds").eq(i).val()));
				}
			}
			$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
			if ($(".feecateId4").val() == 0) {
				$(".integral").val($(".dpMoney").val());
				$(".dpMoneyActivity4").val($(".dpMoney").val());
			} else {
				if ($(".feecateId4 option:selected").attr("discount") == "") {
					$(".integral").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId4 option:selected").attr("activityMoney")));
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId4 option:selected").attr("activityMoney"))).toFixed(1);
				} else {
					$(".integral").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)));
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
				}
				
			}
		});
		$(".feecateId4").blur(function() {
			if ($(".feecateId4").val() != 0) {
				if ($(".feecateId4 option:selected").attr("discount") == "") {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
					$(".integral").val($(".dpMoneyActivity4").val());
				} else {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
					$(".integral").val($(".dpMoneyActivity4").val());
				}
			} else {
				$(".dpMoneyActivity4").val($(".dpMoney").val());
				$(".integral").val($(".dpMoney").val());
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
					alert("系统出错！");
					location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
				}
			});
			$.ajax({
				type : "POST",
				url : "ChargeHoursClass.html",
				data : {
					studentId : stuId,
					classTypeTime : 0
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
					alert("系统出错！");
					location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
				}
			});
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
			var date =  $.trim($(".date").val());
			var dpMoney = $.trim($(".dpMoneyActivity4").val());
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
			var date2 = Time.getFullYear().toString() + month.toString();
			var feecateId = "";
			var number = 0;
			var feecateMoney = "";
			var activityId = $(".feecateId4 option:selected").val();
			var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
			for (var i = 0; i < $(".feecateIds").length; i++) {
				if($.trim($(".feecateIds").eq(i).val()) != "" && $.trim($(".feecateIds").eq(i).val()) != 0) {
					number++;
					feecateId = $.trim(feecateId + "," +  $(".feecateIds").eq(i).attr("chargeTypeId").toString());
				}
			}
			feecateId = feecateId.substring(1);
			for (var i = 0; i < $(".feecateIds").length; i++) {
				if ($(".feecateIds").eq(i).val() != "") {
					feecateMoney = feecateMoney + "," + $(".feecateIds").eq(i).val();
				} 
			}
			feecateMoney = feecateMoney.substr(1);
			if($(".dpMoneyActivity4").val() != "" && $(".dpMoneyActivity4").val() != 0) {
				dpMoney = parseFloat($.trim($(".dpMoneyActivity4").val())).toFixed(1);
			}
			var discount = null;
			if($.trim($(".dpMoneyActivity4").val()) != "" && $.trim($(".dpMoneyActivity4").val()) != 0) {
				discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - parseFloat($.trim($(".dpMoneyActivity4").val()))).toFixed(1);
			}
			if(stuId == "") {
				alert("请选择学生！");
				return flase;
			}
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
				alert("请填写实收金额！");
				return false;
			} else if (dpMoney < 1) {
				alert("请填写正确的实收金额！");
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
					discount : discount,
					activityId : activityId,
					startTimes : startTimes,
					feecateMoney : feecateMoney
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
					} else {
						alert("添加失败！");
						location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111";
				}
			});
		});
	}
});