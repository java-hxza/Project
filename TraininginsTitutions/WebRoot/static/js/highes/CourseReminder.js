$(function() {
	Hour = function() {
		var time = $(".Hours").val();
		var studentName = $.trim($(".studentName").val());
		var departmentOfPediatrics = $(".departmentOfPediatrics").val();
		if (time == "" || time == 0) {
			alert("请输入正确的课时！");
			return false;
		} else if (studentName == "") {
			studentName = null;
		}
		$(".Times").val("");
		$(".feecateId").val(0);
		var Choice = 1;
		$.ajax({
			type : "POST",
			url : "selectHour.html",
			data : {
				time : time,
				Choice : Choice,
				studentName : studentName,
				number : departmentOfPediatrics
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				$(".appends").after("<div class='dayin'><!--startprint--><table class='table table-bordered table-centered mb-0 delSt' border='1px' cellspacing='0'><thead class='thead-light'><tr><th>校区信息</th><th>学员名称</th><th>课程名称</th><th>总课时</th><th>已用课时</th><th>剩余课时</th><th>交费总额</th><th>手机</th><th>就读学校</th><th>单号</th></tr></thead><tbody class='adds'></tbody></table><!--endprint--><iframe id='iframe1' style='display: none'></iframe></div>");
				for (var i = 0; i < data.order.length; i++) {
					$(".adds").append("<tr><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].student.studentName + "</td><td>" + data.order[i].departmentOfPediatrics.dpTypeName + "</td><td>" + data.order[i].addhour + "</td><td>" + (data.order[i].addhour - data.order[i].student.studentHour) + "</td><td>" + data.order[i].student.studentHour + "</td><td>" + data.order[i].dpMoney + "</td><td>" + data.order[i].student.telephone + "</td><td>" + data.order[i].student.school + "</td><td>" + data.order[i].orderNumber + "</td></tr>");
				}

			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectStudentDepartmentofpediatrics.html";
			}
		});
	};

	Time = function() {
		var time = $(".Times").val();
		var studentName = $.trim($(".studentName").val());
		var feecateId = $(".feecateId").val();
		if (time == "" || time == 0) {
			alert("请输入正确的时间段！");
			return false;
		} else if (studentName == "") {
			studentName = null;
		}
		$(".Hours").val("");
		$(".departmentOfPediatrics").val(0);
		var Choice = 2;
		$.ajax({
			type : "POST",
			url : "selectHour.html",
			data : {
				time : time,
				Choice : Choice,
				studentName : studentName,
				number : feecateId
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				$(".appends").after("<div class='dayin'><!--startprint--><table class='table table-bordered table-centered mb-0 delSt' id='delSts' border='1px' cellspacing='0'><thead class='thead-light'><tr><th>校区信息</th><th>学员名称</th><th>付款方式</th><th>收款项目</th><th>最后一次金额</th><th>费用时间起</th><th>费用时间止</th><th>收款日期</th><th>剩余天数</th><th>已过期天数</th><th>手机</th><th>就读学校</th><th>单号</th></tr></thead><tbody class='adds'></tbody></table><!--endprint--><iframe id='iframe1' style='display: none'></iframe></div>");
				for (var i = 0; i < data.order.length; i++) {
					$(".adds").append("<tr><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].student.studentName + "</td><td>" + data.order[i].paymentMethod.paymentmethodName + "</td><td class='feecateIds' name='" + data.order[i].feecateId + "'></td><td>" + data.order[i].dpMoney + "</td><td>" + new Date(data.order[i].firstdate).toLocaleDateString() + "</td><td>" + new Date(data.order[i].lastdate).toLocaleDateString() + "</td><td>" + new Date(data.order[i].startTime).toLocaleDateString() + "</td><td class='hours'>" + data.order[i].student.studentHour + "</td><td>0</td><td>" + data.order[i].student.telephone + "</td><td>" + data.order[i].student.school + "</td><td>" + data.order[i].orderNumber + "</td></tr>");
				}
				for (var i = 0; i < $(".hours").length; i++) {
					if ($(".hours").eq(i).text() < 0) {
						$(".hours").eq(i).next().text($(".hours").eq(i).text().toString().substring(1));
						$(".hours").eq(i).text("0");
					}
				}
				for (var i = 0; i < $(".feecateIds").length; i++) {
					for (var j = 0; j < $(".feecateIds").eq(i).attr("name").split(",").length; j++) {
						$(".feecateId option").each(function() {
							if ($(".feecateIds").eq(i).attr("name").split(",")[j] == $(this).val()) {
								$(".feecateIds").eq(i).text($(".feecateIds").eq(i).text().toString() + "/" + $(this).text().toString());
							}
						});
					}
				}
				var a = "";
				for (var i = 0; i < $(".feecateIds").length; i++) {
					a = $(".feecateIds").eq(i).text().toString();
					$(".feecateIds").eq(i).text(a.substr(1));
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "selectStudentDepartmentofpediatrics.html";
			}
		});
	}
	Printing = function() {
		if ($(".adds td").val() != "") {
			alert("没有可以打印的数据！")
			return false;
		}
//		if($(".Hours").val() == "") {
//			$(".delSt").css("font-size","12px");
//		}
		$(".delSt").css("font-size", "12px");
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