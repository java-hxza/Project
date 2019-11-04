$(function() {
	$(".departmentofpediatricsIds").val($(".classes option:selected").attr("departmentOfPediatrics"));
	$(".feecateId").append("<option value=" + $(".SK").attr("feecateId") + ">" + $(".SK").attr("chargeTypeName") + "</option>");
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	} else {
		month = Time.getMonth() + 1;
	}
	$(".school").val($(".classes option:selected").attr("schoolIds2"));
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".classes").click(function() {
		$(".departmentofpediatricsIds").val($(".classes option:selected").attr("departmentOfPediatrics"));
		var classIds = $(".classes option:selected").val();
		$.ajax({
			type : "POST",
			url : "selectClassStudent2.html",
			data : {
				classId : classIds
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				for (var i = 0; i < data.children.length; i++) {
					$(".stuId").append("<option class='delSt' value='" + data.children[i].studentId + "' feecateId='" + data.order.feecateId + "' chargeTypeName='" + data.order.feeCategory.chargeTypeName + "'>" + data.children[i].studentName + "</option>");
					$("")
				}
				$(".feecateId option").remove();
				if ($(".delSt").attr("feecateId") != undefined) {
					$(".feecateId").append("<option value=" + $(".delSt").attr("feecateId") + ">" + $(".delSt").attr("chargeTypeName") + "</option>");
				}

			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectRefund.html?orderCounts=0&classId=0&studentName=000111";
			}
		});
	});

	$(".stuId").click(function() {
		var studentId = $(".stuId option:selected").val();
		if (studentId == undefined) {
			alert("没有学生可选择！");
			return false;
		}
		$.ajax({
			type : "POST",
			url : "selectClassStudentOrder.html",
			data : {
				studentId : studentId
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".feecateId option").remove();
				$(".addhours").val("");
				$(".givehours").val("");
				$(".hours").val("");
				$(".feecateMoney").val("");
				$(".feecateId").append("<option value=" + data.order.feecateId + ">" + data.order.feeCategory.chargeTypeName + "</option>");
				$(".addhours").val(data.order.addhour);
				$(".givehours").val(data.order.givehour);
				$(".hours").val(data.order.student.studentHour);
				$(".feecateMoney").val(data.order.feecateMoney);
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectRefund.html?orderCounts=0&classId=0&studentName=000111";
			}
		});
	});

	$(".TiJiao").click(function() {
		var date = $.trim($(".date").val());
		var feecateMoneys = $.trim($(".feecateMoneys").val());
		var stuId = $.trim($(".stuId").val());
		var classId = $.trim($(".classes option:selected").val());
		var feecateId = $.trim($(".feecateId").val());
		var date2 = Time.getFullYear().toString() + month.toString();
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var personliable = $.trim($(".personliable").val());
		var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
		if (stuId == "") {
			alert("请选择学生！");
			return flase;
		}
		if (feecateMoneys == "") {
			alert("请填写退款金额！");
			return false;
		} else if (feecateMoneys < 1) {
			alert("请填写正确的退款金额！");
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
			url : "addRefund.html",
			data : {
				stuId : stuId,
				feecateId : feecateId,
				feecateMoney : feecateMoneys,
				startTime : date,
				remarks : remarks,
				paymentmethodId : paymentmethodId,
				date : date2,
				classId : classId,
				personliable : personliable,
				startTimes : startTimes,
				serviceCharge : serviceCharge
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "selectRefund.html?orderCounts=0&classId=0&studentName=000111";
				} else {
					alert("添加失败！");
					location.href = "selectRefund.html?orderCounts=0&classId=0&studentName=000111";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectRefund.html?orderCounts=0&classId=0&studentName=000111";
			}
		});

	});


});