$(function() {
//	$(".dpMoney").val($(".feecateId option:selected").attr("name"));
//	var Time = new Date();
//	var month = null;
//	if ((Time.getMonth() + 1) < 10) {
//		month = 0 + (Time.getMonth() + 1).toString();
//	}else {
//		month = Time.getMonth()+1;
//	}
//	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
//	$(".feecateId").click(function() {
//		$(".dpMoney").val($(".feecateId option:selected").attr("name"));
//	});
	
	delOrder = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
				alert("只能选中一条数据！");
				return false;
		}
		if (confirm("确认删除吗？")) {
			var orderId = $(".customCheckes:checked").parent().parent().next().text();
			var firstdate = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text();
			var lastdate = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text();
			var stuId = $(".customCheckes:checked").parent().parent().next().attr("class");
			var a = "2018-08-30";
			a = new Date(a.replace(/-/g, "/"));
			s1 = new Date();
			var s = s1.getTime() - a.getTime();
			alert(s);
			var time = parseInt(s / (1000 * 60 * 60 * 24));
			alert(time);
			alert(stuId);
			alert(orderId);
			alert(firstdate);
			alert(lastdate);
			return false;
			$.ajax({
				type : "POST",
				url : "delCharge.html",
				data : {
					orderId : orderId,
					hour : hour,
					stuId : stuId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectOrderHour.html";
					} else {
						alert("删除失败！");
						location.href = "selectOrderHour.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderHour.html";
				}
			});
		} else {
			return false;
		}
	};
	
	$(".TiJiao").click(function() {
		var dpMoney = $.trim($(".dpMoney").val());
		var firstdate = $.trim($(".firstdate").val());
		var lastdate = $.trim($(".lastdate").val());
		var personliable = $.trim($(".personliable").val());
		var stuId = $.trim($(".stuId").val());
		var classId = $.trim($(".stuId option:selected").attr("name"));
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
				date : date,
				classId:classId
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