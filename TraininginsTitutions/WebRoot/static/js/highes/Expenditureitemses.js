$(function(){
	
	/**
	 * 添加支出项目
	 */
	Expenditureitemses2 = function() {
		$(".Expenditureitemses").remove();
		$(".addExpenditureitemses").show();
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
	
	/**
	 * 删除支出项目
	 */
	delExpenditureitemses = function() {
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
			var expenditureitemsId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delExpenditureitemses.html",
				data :{expenditureitemsId : expenditureitemsId},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.del == "1") {
									alert("删除成功！");
										location.href = "Expenditureitemses.html";
								}else {
										alert("删除失败！");
										location.href = "Expenditureitemses.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Expenditureitemses.html";
			}
			});
		}else {
			return false;
		}
	};
});