$(function() {
	for (var i = 0; i < $(".ids").text().length; i++) {
		for (var j = 0; j < $(".departmentOfPediatrics option").length; j++) {
			if ($(".ids").eq(i).text() == $(".departmentOfPediatrics option").eq(j).val()) {
				$(".ids").eq(i).text($(".departmentOfPediatrics option").eq(j).text());
			}
		}
	}
	delOrder = function() {
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
			var orderId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delChargeOtheres.html",
				data : {
					orderId : orderId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectOrderOthers.html";
					} else {
						alert("删除失败！");
						location.href = "selectOrderOthers.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderOthers.html";
				}
			});
		} else {
			return false;
		}
	};

	//	updateOrder = function() {
	//		if ($(".customCheckes:checked").length < 1) {
	//			if (!$(".customCheckes").prop("checked")) {
	//				alert("请选中一条数据！");
	//				return false;
	//			}
	//		} else if ($(".customCheckes:checked").length > 1) {
	//			alert("只能选中一条数据！");
	//			return false;
	//		}
	//		$(".date").val($(".customCheckes:checked").parent().parent().next().next().next().text());
	//		$(".school").val($(".customCheckes:checked").parent().parent().next().next().text());
	//		$(".stuId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
	//		$(".dpMoney").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().text());
	//		$(".remarks").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text());
	//		$(".personliable").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text());
	//		$(".feecateId").val($(".customCheckes:checked").parent().parent().next().next().next().next().attr("class"));
	//		$(".paymentmethodId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().attr("class"));
	//		var stuId = $(".customCheckes:checked").parent().parent().next().attr("class");
	//		var orderId = $(".customCheckes:checked").parent().parent().next().text();
	//		$(".showOrder").remove();
	//		$(".addOrder").show();
	//		$(".TiJiao").click(function() {
	//			var paymentmethodId = $(".paymentmethodId option:selected").val();
	//			var feecateId = $(".feecateId option:selected").val();
	//			var personliable = $.trim($(".personliable").val());
	//			var remarks = $.trim($(".remarks").val());
	//			var dpMoney = $.trim($(".dpMoney").val());
	//			var startTime = $.trim($(".date").val());
	//			if (dpMoney == "" || dpMoney < 1) {
	//				alert("请填写金额！");
	//				return false;
	//			} else if (personliable == "") {
	//				alert("请填写责任人！");
	//				return false;
	//			}
	//			$.ajax({
	//				type : "POST",
	//				url : "updateChargeOther.html",
	//				data : {
	//					stuId : stuId,
	//					feecateId : feecateId,
	//					dpMoney : dpMoney,
	//					startTime : startTime,
	//					remarks : remarks,
	//					paymentmethodId : paymentmethodId,
	//					personliable : personliable,
	//					orderId : orderId
	//				},
	//				dataType : "json",
	//				success : function(data) {
	//					data = JSON.parse(data);
	//					if (data.update == "1") {
	//						alert("修改成功！");
	//						location.href = "selectOrderOthers.html";
	//					} else {
	//						alert("修改失败！");
	//						location.href = "selectOrderOthers.html";
	//					}
	//				},
	//				error : function(data) {
	//					alert("系统出错！");
	//					location.href = "selectOrderOthers.html";
	//				}
	//			});
	//		});
	//	};

	Printing = function() {
		$(".dels").remove();
		$(".dels").next().remove();
		$("#dayin").hide();
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		$("#dayin").show();
		$(".DaYins").show();
		$(".DaYins2").parent().parent().hide();
		var Time = new Date();
		var gender = new Date($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().text());
		var year = Time.getTime() - gender.getTime();
		var month = Math.ceil(year / 1000 / 60 / 60 / 24 / 365);
		$(".NL").text("年龄： " + (month).toString());
		$(".RiQi").text("日期：" + $(".customCheckes:checked").parent().parent().next().next().next().text() + "                   ");
		$(".DJBH").text("单据编号：" + "(" + $(".customCheckes:checked").parent().parent().next().next().text() + ")" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().text());
		$(".BDKC").text("报读课程：" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().text());
		$(".XSXM").text("学生姓名: " + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
		$(".JDXX").text("就读学校：" + $(".customCheckes:checked").parent().parent().next().next().text());
		$(".KS").text("课时：");
		$(".YXQ").text("课程有效期：");
		$(".MONEY").text("￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().text());
		for (var i = 0; i < $(".customCheckes:checked").parent().parent().next().next().next().next().text().split("/").length; i++) {
			for (var j = 0; j < $(".feecateIds option").length; j++) {
				if ($(".customCheckes:checked").parent().parent().next().next().next().next().text().split("/")[i] == $(".feecateIds option").eq(j).text()) {
					RMB = $(".feecateIds option").eq(j).attr("name");
				}
			}
			$(".apps").after("<tr class='dels'><td width='800' colspan='3' height='40px'>" + $(".customCheckes:checked").parent().parent().next().next().next().next().text().split("/")[i] + "</td><td width='800' colspan='3' style='text-align:center'height='40px'>￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().text() + "</td></tr>");
		}
		$("#ChargePeriod td").click(function() {
			$(".WBK").parent().text($(".WBK").val());
			$(".WBK").remove();
			$(this).append("<input type='text' class='WBK'/>");
			$(".WBK").focus();
			$(".WBK").val($(this).text());
			if (!$(".WBK").is(":focus")) {
				alert();
				$(".WBK").focus();
			}
		});
	}
	$(".DaYins").click(function() {
		$(".WBK").remove();
		bdhtml=$("#dayin").html();
		//alert(bdhtml);
		sprnstr="<!--startprint-->";   //开始打印标识字符串有17个字符
		eprnstr="<!--endprint-->";        //结束打印标识字符串
		prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); //从开始打印标识之后的内容
		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//截取开始标识和结束标识之间的内容
		var iframe = null;
		iframe = document.getElementById("iframe1")
		
		var iwindow = null;
		var iwindow = iframe.contentWindow;//获取iframe的window对象
		iwindow.document.close();
		iwindow.document.write(prnhtml);
		iwindow.print(); //调用浏览器的打印功能打印指定区域
	});
});