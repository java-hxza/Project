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
			var content = $.trim($(".contents").val());
			var ActivityName = $.trim($(".ActivityName").val());
			var discount = $.trim($(".discount").val());
			var activityMoney = $.trim($(".activityMoney").val());
			if(ActivityName == "") {
				alert("活动名称不能为空！");
				return false;
			}else if(((discount == "" || discount == 0) && (activityMoney == "" || activityMoney == 0)) || ((discount != "" || discount != 0) && (activityMoney != "" || activityMoney != 0))) {
				alert("至(少/多)填入一项优惠！");
				return false;
			}else if(discount != "" || discount != 0) {
				if(discount > 100 || discount < 10) {
					alert("请填入1~10折！");
					return false;
				}
			}
			$.ajax({
				type : "POST",
				url : "addActivitySchools.html",
				data : {
					ActivityName : ActivityName,
					activityMoney : activityMoney,
					discount : discount,
					content : content
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