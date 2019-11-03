$(function() {
	for (var i = 0; i < $(".discounts").length; i++) {
		if ($(".discounts").eq(i).text() == "0.0") {
			$(".discounts").eq(i).text("无");
		}
	}
	for (var i = 0; i < $(".giftIdes").length; i++) {
		if (($.trim($(".giftIdes").eq(i).text())) != "无") {
			for (var is = 0; is < $(".giftName option").length; is++) {
				if (parseInt($.trim($(".giftIdes").eq(i).attr("name"))) == ($.trim($(".giftName option").eq(is).val()))) {
					$(".giftIdes").eq(i).text($.trim($(".giftName option").eq(is).text()));
				}
			}
		}
	}

	$(".departmentofpediatricsId").click(function() {
		$(".money").val($(".departmentofpediatricsId option:selected").attr("name"));
	});

	Hour = function() {
		var classId = $(".classesId").val();
		var studentName = $(".studentName").val();
		if (classId == 0 && studentName == "") {
			alert("请至少选择一项！");
			return false;
		}
		location.href = "selectOrderHour.html?orderCounts=0&classId=" + classId + "&studentName=" + studentName;
	};

	updateOrder = function() {
		if ($(".giftName option:selected").val() == 0) {
			$('.giftNumber').attr("disabled", true);
			$(".giftNumber").val("");
		}
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		$(".date").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().text());
		$(".money").val(parseFloat($.trim($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text())) + parseFloat($.trim($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text())));
		$(".hour").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text());
		$(".hours").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text());
		$(".stuId").val($(".customCheckes:checked").parent().parent().next().next().next().text());
		$(".departmentofpediatricsId").val($(".customCheckes:checked").parent().parent().next().next().next().next().attr("class"));
		$(".remarks").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().text());
		$(".paymentmethodId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().attr("class"));
		$(".feecateId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().attr("class"));
		$(".integral").val($(".customCheckes:checked").parent().parent().next().next().attr("class"));
		$(".giftName").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().attr("class"));
		$(".departmentofpediatricsId").val($(".customCheckes:checked").parent().parent().next().next().next().next().text());
		$(".giftNumber").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().attr("class"));
		$(".teacherId").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().attr("class"));
		$(".feecateId4").val($.trim($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text()));
		$(".dpMoneyActivity4").val($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
		var orderIds = $(".customCheckes:checked").parent().parent().next().text();
		var hour2 = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text();
		var hours2 = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text();
		var hour3 = null;
		var integrals = parseInt($(".integral").val());
		var dpMoney2 = parseInt($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
		var stuId = $(".customCheckes:checked").parent().parent().next().attr("class");
		var giftNumber3 = parseInt($(".giftNumber").val());
		var giftNumber2 = parseInt($(".giftNumber").val());
		var giftId2 = parseInt($(".giftName").val());
		$(".showOrderChildren").remove();
		$(".addOrderChildren").show();
		var dpMoneys = parseFloat($(".money").val()) / parseInt($(".hour").val());
		$(".hour").blur(function() {
			if ($(".hour").val() != 0) {
				$(".money").val((parseFloat(dpMoneys) * $(".hour").val()).toFixed(1));
				$(".integral").val($(".money").val());
			}
		});
		$(".money").blur(function() {
			if ($(".feecateId4").val() == 0) {
				$(".integral").val($(".money").val());
				$(".dpMoneyActivity4").val($(".money").val());
			} else {
				if ($(".feecateId4 option:selected").attr("discount") == "") {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
					$(".integral").val($(".dpMoneyActivity4").val());
				} else {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
					$(".integral").val($(".dpMoneyActivity4").val());
				}
			}
		});
		$(".feecateId4").blur(function() {
			if ($(".feecateId4").val() != 0) {
				if ($(".feecateId4 option:selected").attr("discount") == "") {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
					$(".integral").val($(".dpMoneyActivity4").val());
				} else {
					$(".dpMoneyActivity4").val((parseFloat($.trim($(".money").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
					$(".integral").val($(".dpMoneyActivity4").val());
				}
			} else {
				$(".dpMoneyActivity4").val($(".money").val());
				$(".integral").val($(".money").val());
			}
		});
		$(".giftName").click(function() {
			if ($(".giftName option:selected").val() == 0) {
				$('.giftNumber').attr("disabled", true);
				$(".giftNumber").val("");
			} else {
				$('.giftNumber').removeAttr("disabled");
				$(".giftNumber").val(1);
			}
		});
		$(".giftNumber").blur(function() {
			if (parseInt($.trim($(".giftNumber").val())) > parseInt($.trim($(".giftName option:selected").attr("name")))) {
				alert("赠品数量不足！");
				$(".giftNumber").val(1);
			}
		});
		$(".TiJiao").click(function() {
			var date = $.trim($(".date").val());
			var dpMoney = parseFloat($.trim($(".dpMoneyActivity4").val()));
			var hour = parseInt($.trim($(".hour").val()));
			var hours = parseInt($.trim($(".hours").val()));
			var remarks = $.trim($(".remarks").val());
			var paymentmethodId = $.trim($(".paymentmethodId").val());
			var feecateId = $.trim($(".feecateId").val());
			var giftNumber = parseInt($.trim($(".giftNumber").val()));
			var giftId = parseInt($.trim($(".giftName option:selected").val()));
			var integral = parseInt($.trim($(".integral").val()));
			var discount = parseFloat($.trim($(".money").val())) - parseFloat($.trim($(".dpMoneyActivity4").val()));
			var activityId = $(".feecateId4").val();
			if ($.trim($(".money").val()) == "") {
				alert("请填写应收金额！");
				return false;
			} else if (parseFloat($.trim($(".money").val())) < 1) {
				alert("请填写正确的应收金额！");
				return false;
			}
			if (dpMoney == "") {
				alert("请填写实收金额！");
				return false;
			} else if (dpMoney < 1) {
				alert("请填写正确的实收金额！");
				return false;
			}
			if (hour == "") {
				alert("请填写本次新增课时！");
				return false;
			} else if (hour < 1) {
				alert("请填写正确的新增课时！");
				return false;
			}
			if (hours == "") {
				hours = 0;
			}
			if (hour > hour2) {
				dpMoney = (dpMoneys * hour) - (dpMoneys * hour2);
			} else if (hour2 > hour) {
				dpMoney = -(((dpMoneys * hour2) - (dpMoney * hour)));
			}
			if (hour2 - hour == 1) {
				dpMoney = -dpMoneys;
			}
			if (giftId == giftId2 && giftNumber2 == giftNumber) {
				giftId = -1;
			} else if (giftId == giftId2 && giftNumber2 != giftNumber) {
				giftId = -2;
				if (giftNumber > giftNumber2) {
					giftNumber2 = -(parseInt(giftNumber) - parseInt(giftNumber2));
				} else {
					giftNumber2 = (parseInt(giftNumber2) - parseInt(giftNumber));
				}
			}
			if ((hour2 + hours2) > (hour + hours)) {
				hour3 = -((parseInt(hour2) + parseInt(hours2)) - (parseInt(hour) + parseInt(hours)));
			} else if ((hour2 + hours2) < (hour + hours)) {
				hour3 = ((parseInt(hour) + parseInt(hours)) - (parseInt(hour2) + parseInt(hours2)));
			} else {
				hour3 = 0;
			}
			if (dpMoney2 == dpMoney && integral == integrals && hour3 == 0) {
				dpMoney = 0;
			}
			if ($(".giftNumber").val() == "") {
				giftNumber = 0;
				giftId = -2;
			}
			if (integral > integrals) {
				integrals = integral - integrals;
			} else if (integral < integrals) {
				integrals = -(integrals - integral);
			}
			$.ajax({
				type : "POST",
				url : "updateChargeHour.html",
				data : {
					stuId : stuId,
					feecateId : feecateId,
					dpMoney : dpMoney,
					addhour : hour,
					givehour : hours,
					remarks : remarks,
					paymentmethodId : paymentmethodId,
					orderId : orderIds,
					hour : hour3,
					giftNumber : giftNumber,
					giftId : giftId,
					giftNumber2 : giftNumber2,
					giftId2 : giftId2,
					integral : integral,
					integrals : integrals,
					discount : discount,
					activityId : activityId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.update == "1") {
						alert("修改成功！");
						location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
					} else {
						alert("修改失败！");
						location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
				}
			});
		});
	};

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
		if ($(".QX").val() == 0) {
			alert("对不起，您没有权限删除！");
			return false;
		}
		if (confirm("确认删除吗？")) {
			var orderId = $(".customCheckes:checked").parent().parent().next().text();
			var stuId = $(".customCheckes:checked").parent().parent().next().attr("class");
			var addhour = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text();
			var givehour = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text();
			var hour = -(parseInt(addhour) + parseInt(givehour));
			var giftNumber = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().attr("class");
			var giftId = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().attr("class");
			var integral = -parseInt($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
			$.ajax({
				type : "POST",
				url : "delCharge.html",
				data : {
					orderId : orderId,
					hour : hour,
					stuId : stuId,
					integral : integral,
					giftNumber : giftNumber,
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
					} else {
						alert("删除失败！");
						location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectOrderHour.html?orderCounts=0&classId=0&studentName=000111";
				}
			});
		} else {
			return false;
		}
	};

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
		var gender = new Date($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text());
		var year = Time.getTime() - gender.getTime();
		var month = Math.ceil(year / 1000 / 60 / 60 / 24 / 365);
		$(".NL").text("年龄： " + (month).toString());
		$(".RiQi").text("日期：" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().text() + "                   ");
		$(".DJBH").text("单据编号：" + "(" + $(".customCheckes:checked").parent().parent().next().next().text() + ")" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().text());
		$(".BDKC").text("报读课程：" + $(".customCheckes:checked").parent().parent().next().next().next().next().text());
		$(".XSXM").text("学生姓名: " + $(".customCheckes:checked").parent().parent().next().next().next().text());
		$(".JDXX").text("缴费方式：" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().text());
		$(".Moneys").text($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().text());
		$(".KS").text("课时：" + (parseInt($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text()) + parseInt($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text())) + "时");
		$(".YXQ").text("课程有效期：");
		if ($.trim($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text()) != "无") {
			$(".MONEY").text("应收￥" + (parseFloat($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text()) + parseFloat($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text())) + "/实收￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
		} else {
			$(".MONEY").text("应收￥" + (+parseFloat($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text())) + "/实收￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
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
		$("#ChargePeriod").css("width", "1550px");
		$(".WBK").remove();
		bdhtml = $("#dayin").html();
		//alert(bdhtml);
		sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
		eprnstr = "<!--endprint-->"; //结束打印标识字符串
		prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容
		prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
		var iframe = null;
		iframe = document.getElementById("iframe1")

		var iwindow = null;
		var iwindow = iframe.contentWindow; //获取iframe的window对象
		iwindow.document.close();
		iwindow.document.write(prnhtml);
		iwindow.print(); //调用浏览器的打印功能打印指定区域
		$("#ChargePeriod").css("width", "100%");
	});
});