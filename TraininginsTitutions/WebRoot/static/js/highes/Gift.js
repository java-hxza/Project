$(function() {

	updategiftes = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		var giftId = $(".customCheckes:checked").parent().parent().next().text();
		$(".giftName").val($(".customCheckes:checked").parent().parent().next().next().text());
		$(".giftNumber").val($(".customCheckes:checked").parent().parent().next().next().next().text());
		var giftNumbers = parseInt($.trim($(".giftNumber").val()));
		$(".showgiftes").remove();
		$(".addgiftes").show();
		$(".TiJiao").click(function() {
			var giftName = $.trim($(".giftName").val());
			var giftNumber = parseInt($.trim($(".giftNumber").val()));
			if (giftName == "") {
				alert("赠品名称不能为空！");
				return false;
			} else if (giftNumber == "" || giftNumber < 0) {
				alert("赠品数量不能为空！");
				return false;
			}
			if (giftNumber > giftNumbers) {
				giftNumber = giftNumber - giftNumbers;
			} else if (giftNumber < giftNumbers) {
				giftNumber = -(giftNumbers - giftNumber);
			}
			$.ajax({
				type : "POST",
				url : "updategifts.html",
				data : {
					giftName : giftName,
					giftNumber : giftNumber,
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.update == "1") {
						alert("修改成功！");
						location.href = "selectgifts.html";
					} else {
						alert("修改失败！");
						location.href = "selectgifts.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectgifts.html";
				}
			});
		});
	};

	delgiftes = function() {
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
			var giftId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delgifts.html",
				data : {
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectgifts.html";
					} else {
						alert("删除失败！");
						location.href = "selectgifts.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectgifts.html";
				}
			});
		} else {
			return false;
		}
	};

	addgiftes = function() {
		$(".showgiftes").remove();
		$(".addgiftes").show();
		$(".TiJiao").click(function() {
			var giftName = $.trim($(".giftName").val());
			var giftNumber = parseInt($.trim($(".giftNumber").val()));
			if (giftName == "") {
				alert("赠品名称不能为空！");
				return false;
			} else if (giftNumber == "" || giftNumber < 0) {
				alert("赠品数量不能为空！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addgifts.html",
				data : {
					giftName : giftName,
					giftNumber : giftNumber
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectgifts.html";
					} else {
						alert("添加失败！");
						location.href = "selectgifts.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectgifts.html";
				}
			});
		});
	};
});