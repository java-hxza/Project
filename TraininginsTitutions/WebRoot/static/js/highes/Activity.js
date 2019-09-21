$(function() {
	delActivitySchooles = function() {
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
			var activityId = $(".customCheckes:checked").parent().parent().next().text();
			$.ajax({
				type : "POST",
				url : "delActivitySchools.html",
				data : {
					activityId : activityId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.del == "1") {
						alert("删除成功！");
						location.href = "selectActivitySchools.html";
					} else {
						alert("删除失败！");
						location.href = "selectActivitySchools.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectActivitySchools.html";
				}
			});
		} else {
			return false;
		}
	};

	addActivitySchooles = function() {
		$(".showActivitySchooles").remove();
		$(".addActivitySchooles").show();
		$(".TiJiao").click(function() {
			var content = $.trim($(".contents").val());
			var ActivityName = $.trim($(".ActivityName").val());
			var discount = $.trim($(".discount").val());
			var activityMoney = $.trim($(".activityMoney").val());
			if (ActivityName == "") {
				alert("活动名称不能为空！");
				return false;
			} else if (((discount == "" || discount == 0) && (activityMoney == "" || activityMoney == 0)) || ((discount != "" || discount != 0) && (activityMoney != "" || activityMoney != 0))) {
				alert("至(少/多)填入一项优惠！");
				return false;
			} else if (discount != "" || discount != 0) {
				if (discount > 100 || discount < 10) {
					alert("请填入1~10折！");
					return false;
				}
			}
			$.ajax({
				type : "POST",
				url : "addActivitySchools.html",
				data : {
					ActivityName : ActivityName,
					activityMoney : activityMoney,
					discount : discount,
					content : content
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "selectActivitySchools.html";
					} else {
						alert("添加失败！");
						location.href = "selectActivitySchools.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectActivitySchools.html";
				}
			});
		});
	};

	selectActivityBB = function() {
		$(".showActivitySchooles").remove();
		$(".shows").show();
		$(".appends").show();
		Hour = function() {
			var startTime = $(".Times").val();
			var activityIdName = $(".activityIdName option:selected").val();
			if (activityIdName == 0) {
				activityIdName = null;
			}
			$.ajax({
				type : "POST",
				url : "selectActivityOrderes.html",
				data : {
					startTime : startTime,
					activityId : activityIdName
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".delSt").remove();
					var Name = "";
					var times;
					var Hours2;
					var Minutes2;
					$(".shows").after("<div class='dayin'><!--startprint--><table class='table dt-responsive nowrap delSt' id='basic-datatable' width='100%' border='1px' cellspacing='0'><thead class='thead-light'><tr><th>序号</th><th>校区信息</th><th>学员名称</th><th>订单时间</th><th>活动名称</th><th>优惠金额</th><th>订单编号</th></tr></thead><tbody class='adds'></tbody></table><!--endprint--><iframe id='iframe1' style='display: none'></iframe></div>");
					for (var i = 0; i < data.order.length; i++) {
						for (var j = 0; j < $(".activityIdName option").length; j++) {
							if (data.order[i].activityId == $(".activityIdName option").eq(j).val()) {
								Name = $(".activityIdName option").eq(j).text();
							}
							if (data.order[i].activityId == null) {
								Name = "无";
							}
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
							if (data.order[i].discount == null || data.order[i].discount == 0) {
								data.order[i].discount = "无";
							}
						}
						$(".adds").append("<tr><td>" + data.order[i].orderId + "</td><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].student.studentName + "</td><td>" + (times.getFullYear() + "-" + (times.getMonth() + 1) + "-" + times.getDate() + "&nbsp;" + Hours2 + ":" + Minutes2) + "</td><td>" + Name + "</td><td>" + data.order[i].discount + "</td><td>" + data.order[i].orderNumber + "</td></tr>");
					}

				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectActivitySchools.html";
				}
			});
		};
		Time = function() {
			var startTime = $(".Times").val();
			var activityIdName = $(".activityIdName option:selected").val();
			if (activityIdName == 0) {
				activityIdName = null;
			}
			$.ajax({
				type : "POST",
				url : "selectActivityOrderes.html",
				data : {
					startTime : startTime,
					activityId : activityIdName
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".delSt").remove();
					var Name = "";
					var times;
					var Hours2;
					var Minutes2;
					$(".shows").after("<div class='dayin'><!--startprint--><table class='table dt-responsive nowrap delSt' id='basic-datatable' width='100%' border='1px' cellspacing='0'><thead class='thead-light'><tr><th>序号</th><th>校区信息</th><th>学员名称</th><th>订单时间</th><th>活动名称</th><th>优惠金额</th><th>订单编号</th></tr></thead><tbody class='adds'></tbody></table><!--endprint--><iframe id='iframe1' style='display: none'></iframe></div>");
					for (var i = 0; i < data.order.length; i++) {
						for (var j = 0; j < $(".activityIdName option").length; j++) {
							if (data.order[i].activityId == $(".activityIdName option").eq(j).val()) {
								Name = $(".activityIdName option").eq(j).text();
							}
							if (data.order[i].activityId == null) {
								Name = "无";
							}
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
							if (data.order[i].discount == null || data.order[i].discount == 0) {
								data.order[i].discount = "无";
							}
						}
						$(".adds").append("<tr><td>" + data.order[i].orderId + "</td><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].student.studentName + "</td><td>" + (times.getFullYear() + "-" + (times.getMonth() + 1) + "-" + times.getDate() + "&nbsp;" + Hours2 + ":" + Minutes2) + "</td><td>" + Name + "</td><td>" + data.order[i].discount + "</td><td>" + data.order[i].orderNumber + "</td></tr>");
					}

				},
				error : function(data) {
					alert("系统出错！");
					location.href = "selectActivitySchools.html";
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