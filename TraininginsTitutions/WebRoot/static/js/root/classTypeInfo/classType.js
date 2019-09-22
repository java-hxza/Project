$(function() {

	/**
	 * 删除账户信息事件
	 */
	delAccountinformation = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		if (!confirm("确认删除吗？")) {
			return false;
		}
		var dpId = $(".customCheckes:checked").parent().parent().next().text();
		$.ajax({
			type : "POST",
			url : "deleteDepartmentOfPediatrics.html",
			data : {
				dpId : dpId
			},
			dataType : "json",
			success : function(data) {
				if (data.state == "1") {
					alert("删除成功！");
					location.href = "classTypeInfo.html";
				} else {
					alert("删除失败！");
					location.href = "classTypeInfo.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "Accountinformation.html";
			}
		});
	};


	/**
	 * 添加账户信息事件
	 */
	addAccountinformation = function() {
		$(".Accountinformation").remove();
		$(".addAccountinformations").show();
		$(".del").remove();
		$(".add").click(function() {
			var dpTypeName = $("#validationTooltip01").val();
			var chargeTypeId = $("#chargeTypeId").val();
			$.ajax({
				type : "POST",
				url : "addDepartmentOfPediatrics.html",
				data : {
					dpTypeName : dpTypeName,
					chargeTypeId : chargeTypeId,
				},
				dataType : "json",
				success : function(data) {
					if (data.state == "1") {
						alert("添加成功！");
						location.href = "classTypeInfo.html";
					} else {
						alert("添加失败！");
						location.href = "classTypeInfo.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "Accountinformation.html";
				}
			});
		});
	};



});