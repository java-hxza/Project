$(function(){
	$(".feecategoryMoney").val($(".expenditureitemsId option:selected").attr("name"));
	var Time = new Date();
	var month = null;
	if ((Time.getMonth() + 1) < 10) {
		month = 0 + (Time.getMonth() + 1).toString();
	}else {
		month = Time.getMonth()+1;
	}
	$(".expenditureitemsId").click(function() {
		$(".feecategoryMoney").val($(".expenditureitemsId option:selected").attr("name"));
	});
	$(".date").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
	
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
						location.href = "selectOrderExpenditure.html";
					} else {
						alert("删除失败！");
						location.href = "selectOrderExpenditure.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderExpenditure.html";
				}
			});
		} else {
			return false;
		}
	};
	
	addOrders = function() {
		$(".showOrder").remove();
		$(".addOrder").show();
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
					location.href = "selectOrderExpenditure.html";
				}
			});
		});
		$(".TiJiao").click(function() {
			var personliable = $.trim($(".personliable").val());
			var feecategoryMoney = $.trim($(".feecategoryMoney").val());
			var stuId = $(".stuId option:selected").val();
			var paymentmethodId = $(".paymentmethodId").val();
			var remarks = $.trim($(".remarks").val());
			var classId = $(".classes option:selected").val();
			var expenditureitemsId = $(".expenditureitemsId option:selected").val();
			var startTime = $.trim($(".date").val());
			var date = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
			if(feecategoryMoney == "" || parseFloat(feecategoryMoney) < 1) {
				alert("请输入正确的金额！");
				return false;
			}else if(personliable == "") {
				alert("请输入责任人！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "AddOrderExpenditure.html",
				data : {
					stuId : stuId,
					expenditureitemsId : expenditureitemsId,
					feecategoryMoney : feecategoryMoney,
					startTime : startTime,
					remarks : remarks,
					paymentmethodId : paymentmethodId,
					date : date,
					classId : classId,
					personliable : personliable
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectOrderExpenditure.html";
					} else {
						alert("添加失败！");
						location.href = "selectOrderExpenditure.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderExpenditure.html";
				}
			});
		});
	};
	
});