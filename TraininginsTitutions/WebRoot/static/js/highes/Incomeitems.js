$(function(){
	
	/**
	 * 添加收入项目
	 */
	addIncomeitems = function() {
		$(".Incomeitems").remove();
		$(".addIncomeitemses").show();
		$(".add").click(function() {
			var chargeTypeName = $(".chargeTypeName").val();
			var category = $(".category").val();
			$.ajax({
				type : "POST",
				url : "addIncomeitems.html",
				data :{chargeTypeName : chargeTypeName,category : category},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.add == "1") {
									alert("添加成功！");
										location.href = "Incomeitems.html";
								}else {
										alert("添加失败！");
										location.href = "Incomeitems.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Incomeitems.html";
			}
			});
		});
	};
	
	/**
	 * 删除收入项目
	 */
	delIncomeitems = function() {
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
			var chargeTypeId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delIncomeitems.html",
				data :{chargeTypeId : chargeTypeId},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.del == "1") {
									alert("删除成功！");
										location.href = "Incomeitems.html";
								}else {
										alert("删除失败！");
										location.href = "Incomeitems.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Incomeitems.html";
			}
			});
		}else {
			return false;
		}
	};
});