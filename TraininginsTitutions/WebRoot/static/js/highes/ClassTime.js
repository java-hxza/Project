$(function() {

	addClassTimes = function() {
		$(".addClassTimes2").show();
		$(".classTimes").hide();
		$(".AN").hide();
		$(".add").click(function() {
			var classTimeName = $(".classTimeName").val();
			if (classTimeName == "") {
				alert("请填写上课时间段！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addClassTime.html",
				data : {
					classTimeName : classTimeName
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectClassTime.html";
					} else {
						alert("添加失败！");
						location.href = "selectClassTime.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectClassTime.html";
				}
			});
		});
	};

	delClassTimes = function() {
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
			var classTimeId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delClassTime.html",
				data : {
					classTimeId : classTimeId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectClassTime.html";
					} else {
						alert("删除失败！");
						location.href = "selectClassTime.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectClassTime.html";
				}
			});
		} else {
			return false;
		}
	};
	
	updateClassTimes = function (){
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		var classTimeId = $(".customCheckes:checked").parent().parent().next().text();
		$(".addClassTimes2").show();
		$(".classTimes").hide();
		$(".AN").hide();
		$(".add").click(function() {
			var classTimeName = $(".classTimeName").val();
			
			if (classTimeName == "") {
				alert("请填写上课时间段！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "updateClassTime.html",
				data : {
					classTimeName : classTimeName,
					classTimeId : classTimeId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("修改成功！");
						location.href = "selectClassTime.html";
					} else {
						alert("修改成功！");
						location.href = "selectClassTime.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectClassTime.html";
				}
			});
		});
	}
});