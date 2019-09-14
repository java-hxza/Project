$(function() {
	delActivitySchooles = function() {
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
			var activityId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delActivitySchools.html",
				data : {
					activityId : activityId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectActivitySchools.html";
					} else {
						alert("删除失败！");
						location.href = "selectActivitySchools.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectActivitySchools.html";
				}
			});
		} else {
			return false;
		}
	};

	addActivitySchooles = function() {
		$(".showActivitySchooles").remove();
		$(".addActivitySchooles").show();
		$(".TiJiao").click(function() {
			var activityMoneyfirst = $.trim($(".activityMoneyfirst").val());
			var activityMoneylast = $.trim($(".activityMoneylast").val());
			var discount = $.trim($(".discount").val());
			if (activityMoneyfirst == "" && activityMoneylast == "" && discount == "") {
				alert("请填写至少一项：1.满减 2.折扣！");
				return false;
			}else if(activityMoneyfirst != "" && activityMoneylast != "" && discount != "") {
				alert("请填写至多一项：1.满减 2.折扣！");
				return false;
			}else if(activityMoneyfirst != "" && activityMoneylast == "" && discount == "") {
				alert("请填写至少一项：1.满减 2.折扣！");
				return false;
			}else if(activityMoneyfirst == "" && activityMoneylast != "" && discount == "") {
				alert("请填写至少一项：1.满减 2.折扣！");
				return false;
			}else if(activityMoneyfirst != "" && activityMoneylast == "" && discount != "") {
				alert("请填写至少一项：1.满减 2.折扣！");
				return false;
			}else if(activityMoneyfirst == "" && activityMoneylast != "" && discount != "") {
				alert("请填写至少一项：1.满减 2.折扣！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addActivitySchools.html",
				data : {
					activityMoneyfirst : activityMoneyfirst,
					activityMoneylast : activityMoneylast,
					discount : discount
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectActivitySchools.html";
					} else {
						alert("添加失败！");
						location.href = "selectActivitySchools.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectActivitySchools.html";
				}
			});
		});
	};
});