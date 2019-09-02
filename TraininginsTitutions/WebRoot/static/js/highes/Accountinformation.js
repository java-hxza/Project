$(function(){
/**
 * 删除账户信息事件
 */
delAccountinformation = function() {
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
				alert("只能选中一条数据！");
				return false;
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
	};
	
	/**
	 * 添加账户信息事件
	 */
	addAccountinformation = function() {
		$(".Accountinformation").remove();
		$(".addAccountinformations").show();
		$(".del").remove();
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
	};
});