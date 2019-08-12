$(function(){
	addTeacher = function() {
		$(".Teachers").remove();
		$(".addTeacher").show();
		$(".del").remove();
		$(".add").click(function() {
			var category = $(".category").val();
			var expenditureitemsName = $(".expenditureitemsName").val();
			$.ajax({
				type : "POST",
				url : "addExpenditureitemses.html",
				data :{expenditureitemsName : expenditureitemsName,category : category},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.add == "1") {
									alert("添加成功！");
										location.href = "Expenditureitemses.html";
								}else {
										alert("添加失败！");
										location.href = "Expenditureitemses.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Expenditureitemses.html";
			}
			});
		});
	};
	
	delTeacher = function() {
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		if(confirm("确认删除吗？")) {
			var uId = $(".customCheckes:checked").parent().parent().next().attr("id");
			$.ajax({
				type : "POST",
				url : "delTeacher.html",
				data :{uId : uId},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.del == "1") {
									alert("删除成功！");
										location.href = "Teacher.html";
								}else {
										alert("删除失败！");
										location.href = "Teacher.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Teacher.html";
			}
			});
		}else {
			return false;
		}
	}
});