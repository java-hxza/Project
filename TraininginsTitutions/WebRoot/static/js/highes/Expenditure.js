$(function(){
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	}else {
		month = Time.getMonth()+1;
	}
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".TiJiao").click(function() {
		var stuId = $.trim($(".stuId").val());
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var personliable = $.trim($(".personliable").val());
		var feecategoryMoney = $.trim($(".feecategoryMoney").val());
		var expenditureitemsId = $.trim($(".expenditureitemsId").val());
		var startTime = $.trim($(".date").val());
		var date = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
		if(feecategoryMoney == "") {
			alert("请填写金额！");
			return false;
		}
		$.ajax({
			type : "POST",
			url : "AddOrderExpenditure.html",
			data : {
				feecategoryMoney : feecategoryMoney,
				personliable : personliable,
				stuId : stuId,
				startTime : startTime,
				paymentmethodId : paymentmethodId,
				remarks : remarks,
				expenditureitemsId : expenditureitemsId,
				date : date
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "OrderExpenditure.html";
				} else {
					alert("添加失败！");
					location.href = "OrderExpenditure.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "OrderExpenditure.html";
			}
		});
	});
	
});