$(function() {

	updategiftes = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}
		var giftId = $(".customCheckes:checked").parent().parent().next().text();
		$(".giftName").val($(".customCheckes:checked").parent().parent().next().next().text());
		$(".giftNumber").val($(".customCheckes:checked").parent().parent().next().next().next().text());
		var giftNumbers = parseInt($.trim($(".giftNumber").val()));
		$(".showgiftes").remove();
		$(".addgiftes").show();
		$(".TiJiao").click(function() {
			var giftName = $.trim($(".giftName").val());
			var giftNumber = parseInt($.trim($(".giftNumber").val()));
			if (giftName == "") {
				alert("赠品名称不能为空！");
				return false;
			} else if (giftNumber == "" || giftNumber < 0) {
				alert("赠品数量不能为空！");
				return false;
			}
			if (giftNumber > giftNumbers) {
				giftNumber = giftNumber - giftNumbers;
			} else if (giftNumber < giftNumbers) {
				giftNumber = -(giftNumbers - giftNumber);
			}
			$.ajax({
				type : "POST",
				url : "updategifts.html",
				data : {
					giftName : giftName,
					giftNumber : giftNumber,
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.update == "1") {
						alert("修改成功！");
						location.href = "selectgifts.html";
					} else {
						alert("修改失败！");
						location.href = "selectgifts.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectgifts.html";
				}
			});
		});
	};

	delgiftes = function() {
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
			var giftId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delgifts.html",
				data : {
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectgifts.html";
					} else {
						alert("删除失败！");
						location.href = "selectgifts.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectgifts.html";
				}
			});
		} else {
			return false;
		}
	};

	addgiftes = function() {
		$(".showgiftes").remove();
		$(".addgiftes").show();
		$(".TiJiao").click(function() {
			var giftName = $.trim($(".giftName").val());
			var giftNumber = parseInt($.trim($(".giftNumber").val()));
			if (giftName == "") {
				alert("赠品名称不能为空！");
				return false;
			} else if (giftNumber == "" || giftNumber < 0) {
				alert("赠品数量不能为空！");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "addgifts.html",
				data : {
					giftName : giftName,
					giftNumber : giftNumber
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectgifts.html";
					} else {
						alert("添加失败！");
						location.href = "selectgifts.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectgifts.html";
				}
			});
		});
	};
	
	GiftBB = function() {
		$(".showgiftes").remove();
		$(".shows").show();
		Hour = function() {
			var startTime = $(".Times").val();
			var giftId = $(".gifts option:selected").val();
			if (giftId == 0) {
				giftId = null;
			}
			$.ajax({
				type : "POST",
				url : "selectGiftes.html",
				data : {
					startTime : startTime,
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".delSt").remove();
					var Name = "";
					var times;
					var Hours2;
					var Minutes2;
					$(".shows").after("<div class='dayin'><!--startprint--><table class='table dt-responsive nowrap delSt' id='basic-datatable' border='1px' cellspacing='0' width='100%'><thead class='thead-light'><tr><th>序号</th><th>校区信息</th><th>学员名称</th><th>订单时间</th><th>赠品名称</th><th>赠品数量</th><th>订单编号</th></tr></thead><tbody class='adds'></tbody></table><!--endprint--><iframe id='iframe1' style='display: none'></iframe></div>");
					for (var i = 0; i < data.order.length; i++) {
							times = new Date(data.order[i].startTime);
							if (times.getHours() < 10) {
								Hours2 = "0" + times.getHours();
							} else {
								Hours2 = times.getHours();
							}
							if (times.getMinutes() < 10) {
								Minutes2 = "0" + times.getMinutes();
							} else {
								Minutes2 = times.getMinutes();
							}
						$(".adds").append("<tr><td>" + data.order[i].orderId + "</td><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].student.studentName + "</td><td>" + (times.getFullYear() + "-" + (times.getMonth() + 1) + "-" + times.getDate() + "&nbsp;" + Hours2 + ":" + Minutes2) + "</td><td>" + data.order[i].gift.giftName + "</td><td>" + data.order[i].giftNumber + "</td><td>" + data.order[i].orderNumber + "</td></tr>");
					}

				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectGiftes.html";
				}
			});
		};
		Time = function() {
			var startTime = $(".Times").val();
			var giftId = $(".gifts option:selected").val();
			if (giftId == 0) {
				giftId = null;
			}
			$.ajax({
				type : "POST",
				url : "selectGiftes.html",
				data : {
					startTime : startTime,
					giftId : giftId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".delSt").remove();
					var Name = "";
					var times;
					var Hours2;
					var Minutes2;
					$(".shows").after("<div class='dayin'><!--startprint--><table class='table dt-responsive nowrap delSt' id='basic-datatable' border='1px' cellspacing='0' width='100%'><thead class='thead-light'><tr><th>序号</th><th>校区信息</th><th>学员名称</th><th>订单时间</th><th>赠品名称</th><th>赠品数量</th><th>订单编号</th></tr></thead><tbody class='adds'></tbody></table><!--endprint--><iframe id='iframe1' style='display: none'></iframe></div>");
					for (var i = 0; i < data.order.length; i++) {
							times = new Date(data.order[i].startTime);
							if (times.getHours() < 10) {
								Hours2 = "0" + times.getHours();
							} else {
								Hours2 = times.getHours();
							}
							if (times.getMinutes() < 10) {
								Minutes2 = "0" + times.getMinutes();
							} else {
								Minutes2 = times.getMinutes();
							}
						$(".adds").append("<tr><td>" + data.order[i].orderId + "</td><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].student.studentName + "</td><td>" + (times.getFullYear() + "-" + (times.getMonth() + 1) + "-" + times.getDate() + "&nbsp;" + Hours2 + ":" + Minutes2) + "</td><td>" + data.order[i].gift.giftName + "</td><td>" + data.order[i].giftNumber + "</td><td>" + data.order[i].orderNumber + "</td></tr>");
					}

				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectGiftes.html";
				}
			});
		};
	};
	DaYin = function() {
		if ($(".adds td").val() != "") {
			alert("没有可以打印的数据！")
			return false;
		}
//		if($(".Hours").val() == "") {
//			$(".delSt").css("font-size","12px");
//		}
		bdhtml = $(".dayin").html();
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
		
	};
});