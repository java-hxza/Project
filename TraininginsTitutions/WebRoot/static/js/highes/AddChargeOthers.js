$(function() {
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	} else {
		month = Time.getMonth() + 1;
	}
	$(".school").val($(".classes option:selected").attr("schoolIds2"));
	$(".dpMoney").val($(".feecateId option").attr("name"));
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	$(".feecateId").click(function() {
		$(".dpMoney").val($(".feecateId option:selected").attr("name"));
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
				location.href = "selectOrderOthers.html";
			}
		});
	});
	
	$(".TiJiao").click(function() {
		var date = $.trim($(".date").val());
		var dpMoney = parseFloat($.trim($(".dpMoney").val()));
		var stuId = $.trim($(".stuId").val());
		var classId = $.trim($(".classes option:selected").val());
		var feecateId = $.trim($(".feecateId").val());
		var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
		var remarks = $.trim($(".remarks").val());
		var paymentmethodId = $.trim($(".paymentmethodId").val());
		var personliable = $.trim($(".personliable").val());
		if (dpMoney == "") {
			alert("请填写收费金额！");
			return false;
		} else if (dpMoney < 1) {
			alert("请填写正确的收费金额！");
			return false;
		}
		if(personliable == "") {
			alert("请填写责任人！");
			return false;
		}
		$.ajax({
			type : "POST",
			url : "addChargeOthers.html",
			data : {
				stuId : stuId,
				feecateId : feecateId,
				dpMoney : dpMoney,
				startTime : date,
				remarks : remarks,
				paymentmethodId : paymentmethodId,
				date : date2,
				classId : classId,
				personliable : personliable
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				if (data.add == "1") {
					alert("添加成功！");
					location.href = "selectOrderOthers.html";
				} else {
					alert("添加失败！");
					location.href = "selectOrderOthers.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectOrderOthers.html";
			}
		});
		
	});
});