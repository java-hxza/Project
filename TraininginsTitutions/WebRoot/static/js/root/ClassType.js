$(function() {
	if ($(".LX").attr("name") != 1) {
		$(".YN").hide();
		$(".YN2").hide();
	}
	
	
	addClassTypes = function() {

		$(".addClassTypes2").show();
		$(".classTypes").hide();
		$(".AN").hide();
		$(".add").click(function() {
			var teacherTypeName = $(".teacherTypeName").val();
			if (teacherTypeName == "") {
				alert("请填写班级类型名称！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addTeacherTypes.html",
				data : {
					teacherTypeName : teacherTypeName
				},
				dataType : "json",
				success : function(data) {
					if (data.state == "1") {
						alert("添加成功！");
						location.href = "profession.html";
					} else {
						alert("添加失败！");
						location.href = "profession.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "profession.html";
				}
			});
		});

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
			var teacherTypeId = $(".customCheckes:checked").parent().parent().next().text();
			if(teacherTypeId =="" || teacherTypeId == null){
				alert("请选中一条数据");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "delTeacherTypes.html",
				data : {
					teacherTypeId : teacherTypeId
				},
				dataType : "json",
				success : function(data) {
					if (data.state == "1") {
						alert("删除成功！");
						location.href = "profession.html";
					} else {
						alert("删除失败！");
						location.href = "profession.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "profession.html";
				}
			});
		} else {
			return false;
		}
	};
});