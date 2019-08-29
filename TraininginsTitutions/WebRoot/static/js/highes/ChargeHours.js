$(function() {
	$(".feecateId").click(function() {
		$(".money").val($(".feecateId option:selected").attr("name"));
	});
	updateOrder = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		$(".date").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().text());
		$(".money").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
		$(".hour").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text());
		$(".hours").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text());
		$(".stuId").val($(".customCheckes:checked").parent().parent().next().attr("class"));
		$(".departmentofpediatricsId").val($(".customCheckes:checked").parent().parent().next().next().next().next().attr("class"));
		$(".remarks").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().text());
		$(".paymentmethodId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().attr("class"));
		$(".feecateId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().attr("class"));
		$(".customCheckes:checked").parent().parent().next().text();
		var orderIds = $(".customCheckes:checked").parent().parent().next().text();
		$(".showOrderChildren").remove();
		$(".addOrderChildren").show();
		$(".TiJiao").click(function() {
			var date = $.trim($(".date").val());
			var dpMoney = $.trim($(".money").val());
			var hour = $.trim($(".hour").val());
			var hours = $.trim($(".hours").val());
			var stuId = $.trim($(".stuId").val());
			var departmentofpediatricsId = $.trim($(".departmentofpediatricsId").val());
			var remarks = $.trim($(".remarks").val());
			var paymentmethodId = $.trim($(".paymentmethodId").val());
			var feecateId = $.trim($(".feecateId").val());
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
				url : "updateChargeHour.html",
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
					orderId:orderIds
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.update == "1") {
						alert("修改成功！");
						location.href = "selectOrderHour.html";
					} else {
						alert("修改失败！");
						location.href = "selectOrderHour.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderHour.html";
				}
			});
		});
	};
	
	delOrder = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		if (confirm("确认删除吗？")) {
			var orderId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delCharge.html",
				data : {
					orderId : orderId
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
});