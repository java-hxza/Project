$(function() {
	if ($(".LX").attr("name") != 1) {
		$(".YN").hide();
		$(".YN2").hide();
	}
	addClassTypes = function() {
		if ($(".LX").attr("name") == 1) {
			$(".addClassTypes2").show();
			$(".classTypes").hide();
			$(".AN").hide();
			$(".add").click(function() {
				var classTypeName = $(".classTypeName").val();
				var classTypeTime = $(".classTypeTime option:selected").val();
				if (classTypeName == "") {
					alert("请填写班级类型名称！");
					return false;
				}
				$.ajax({
					type : "POST",
					url : "addClassTypes.html",
					data : {
						classTypeName : classTypeName,
						classTypeTime : classTypeTime
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						if (data.add == "1") {
							alert("添加成功！");
							location.href = "selectClassTypes.html";
						} else {
							alert("添加失败！");
							location.href = "selectClassTypes.html";
						}
					},
					error : function(data) {
						alert("系统出错！");
						location.href = "selectClassTypes.html";
					}
				});
			});
		} else {
			$(".addClassTypes2").show();
			$(".classTypes").hide();
			$(".AN").hide();
			$(".classTypeTime").prev().hide();
			$(".classTypeTime").hide();
			$(".add").click(function() {
				var classTypeName = $(".classTypeName").val();
				if (classTypeName == "") {
					alert("请填写班级类型名称！");
					return false;
				}
				$.ajax({
					type : "POST",
					url : "addClassTypes.html",
					data : {
						classTypeName : classTypeName,
						classTypeTime : 0
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						if (data.add == "1") {
							alert("添加成功！");
							location.href = "selectClassTypes.html";
						} else {
							alert("添加失败！");
							location.href = "selectClassTypes.html";
						}
					},
					error : function(data) {
						alert("系统出错！");
						location.href = "selectClassTypes.html";
					}
				});
			});
		}
	};

	updateClassTypes = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		if ($(".LX").attr("name") == 1) {
			$(".classTypeName").val($(".customCheckes:checked").parent().parent().next().next().text());
			if ($.trim($(".customCheckes:checked").parent().parent().next().next().next().text()) == "是") {
				$(".classTypeTime").val("1");
			} else {
				$(".classTypeTime").val("0");
			}
			var classTypeId = $(".customCheckes:checked").parent().parent().next().text();
			$(".addClassTypes2").show();
			$(".classTypes").hide();
			$(".AN").hide();
			$(".add").click(function() {
				var classTypeName = $(".classTypeName").val();
				var classTypeTime = $(".classTypeTime option:selected").val();
				if (classTypeName == "") {
					alert("请填写班级类型名称！");
					return false;
				}
				$.ajax({
					type : "POST",
					url : "updateClassTypes.html",
					data : {
						classTypeName : classTypeName,
						classTypeTime : classTypeTime,
						classTypeId : classTypeId
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						if (data.update == "1") {
							alert("修改成功！");
							location.href = "selectClassTypes.html";
						} else {
							alert("修改失败！");
							location.href = "selectClassTypes.html";
						}
					},
					error : function(data) {
						alert("系统出错！");
						location.href = "selectClassTypes.html";
					}
				});
			});
		} else {
			$(".classTypeName").val($(".customCheckes:checked").parent().parent().next().next().text());
			$(".classTypeTime").prev().hide();
			$(".classTypeTime").hide();
			var classTypeId = $(".customCheckes:checked").parent().parent().next().text();
			$(".addClassTypes2").show();
			$(".classTypes").hide();
			$(".AN").hide();
			$(".add").click(function() {
				var classTypeName = $(".classTypeName").val();
				if (classTypeName == "") {
					alert("请填写班级类型名称！");
					return false;
				}
				$.ajax({
					type : "POST",
					url : "updateClassTypes.html",
					data : {
						classTypeName : classTypeName,
						classTypeId : classTypeId
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						if (data.update == "1") {
							alert("修改成功！");
							location.href = "selectClassTypes.html";
						} else {
							alert("修改失败！");
							location.href = "selectClassTypes.html";
						}
					},
					error : function(data) {
						alert("系统出错！");
						location.href = "selectClassTypes.html";
					}
				});
			});
		}

	};

	delClassTypes = function() {
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
			var classTypeId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delClassTypes.html",
				data : {
					classTypeId : classTypeId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectClassTypes.html";
					} else {
						alert("删除失败！");
						location.href = "selectClassTypes.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectClassTypes.html";
				}
			});
		} else {
			return false;
		}
	};
});