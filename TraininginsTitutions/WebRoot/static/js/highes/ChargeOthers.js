$(function() {
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
			$.ajax({
				type : "POST",
				url : "delChargeOtheres.html",
				data : {
					orderId : orderId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectOrderOthers.html";
					} else {
						alert("删除失败！");
						location.href = "selectOrderOthers.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderOthers.html";
				}
			});
		} else {
			return false;
		}
	};

//	updateOrder = function() {
//		if ($(".customCheckes:checked").length < 1) {
//			if (!$(".customCheckes").prop("checked")) {
//				alert("请选中一条数据！");
//				return false;
//			}
//		} else if ($(".customCheckes:checked").length > 1) {
//			alert("只能选中一条数据！");
//			return false;
//		}
//		$(".date").val($(".customCheckes:checked").parent().parent().next().next().next().text());
//		$(".school").val($(".customCheckes:checked").parent().parent().next().next().text());
//		$(".stuId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
//		$(".dpMoney").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().text());
//		$(".remarks").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text());
//		$(".personliable").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text());
//		$(".feecateId").val($(".customCheckes:checked").parent().parent().next().next().next().next().attr("class"));
//		$(".paymentmethodId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().attr("class"));
//		var stuId = $(".customCheckes:checked").parent().parent().next().attr("class");
//		var orderId = $(".customCheckes:checked").parent().parent().next().text();
//		$(".showOrder").remove();
//		$(".addOrder").show();
//		$(".TiJiao").click(function() {
//			var paymentmethodId = $(".paymentmethodId option:selected").val();
//			var feecateId = $(".feecateId option:selected").val();
//			var personliable = $.trim($(".personliable").val());
//			var remarks = $.trim($(".remarks").val());
//			var dpMoney = $.trim($(".dpMoney").val());
//			var startTime = $.trim($(".date").val());
//			if (dpMoney == "" || dpMoney < 1) {
//				alert("请填写金额！");
//				return false;
//			} else if (personliable == "") {
//				alert("请填写责任人！");
//				return false;
//			}
//			$.ajax({
//				type : "POST",
//				url : "updateChargeOther.html",
//				data : {
//					stuId : stuId,
//					feecateId : feecateId,
//					dpMoney : dpMoney,
//					startTime : startTime,
//					remarks : remarks,
//					paymentmethodId : paymentmethodId,
//					personliable : personliable,
//					orderId : orderId
//				},
//				dataType : "json",
//				success : function(data) {
//					data = JSON.parse(data);
//					if (data.update == "1") {
//						alert("修改成功！");
//						location.href = "selectOrderOthers.html";
//					} else {
//						alert("修改失败！");
//						location.href = "selectOrderOthers.html";
//					}
//				},
//				error : function(data) {
//					alert("系统出错！");
//					location.href = "selectOrderOthers.html";
//				}
//			});
//		});
//	};

});