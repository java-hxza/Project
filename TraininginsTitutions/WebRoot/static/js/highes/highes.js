$(function(){
	/**
	 * 跳转到创建学生的页面
	 */
	Accountinformation = function(){
		location.href="Accountinformation.html";
	}
	Incomeitems = function(){
		location.href="Incomeitems.html";
	}
	Expenditureitemses = function(){
		location.href="Expenditureitemses.html";
	}
	Teacher = function(){
		location.href="Teacher.html";
	}
	$(".customCheck").click(function() {
		if($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		}else {
			$(this).prev().prop("checked", true);
		}
	});
	
	$(".delAccountinformation").click(function() {
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
			var paymentmethodId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delAccountinformation.html",
				data :{paymentmethodId : paymentmethodId},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.del == "1") {
									alert("删除成功！");
										location.href = "Accountinformation.html";
								}else {
										alert("删除失败！");
										location.href = "Accountinformation.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Accountinformation.html";
			}
			});
		}else {
			return false;
		}
	});
	
	
	$(".delIncomeitems").click(function() {
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
	});
	
	$(".addAccountinformation").click(function() {
		$(".Accountinformation").remove();
		$(".addAccountinformations").show();
		$(".add").click(function() {
			var paymentmethodName = $("#validationTooltip01").val();
			$.ajax({
				type : "POST",
				url : "addAccountinformation.html",
				data :{paymentmethodName : paymentmethodName},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
							if(data.add == "1") {
									alert("添加成功！");
										location.href = "Accountinformation.html";
								}else {
										alert("添加失败！");
										location.href = "Accountinformation.html";
									}
					},
						error : function(data) {
								alert("系统出错！");
								location.href = "Accountinformation.html";
			}
			});
		});
	});
	
	$(".addIncomeitems").click(function() {
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
	});
	
	$(".delExpenditureitemses").click(function() {
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
	});
	
	$(".Expenditureitemses2").click(function() {
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
	});
});