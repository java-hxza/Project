$(function() {
	$(".schoolId").unbind("click").click(function() {
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href = "schoolOrderInfo.html?schoolId=" + schoolId + "&schoolName=" + schoolName;
	});


	/**
	 * 收入ajax
	 */
	query = function() {
		/*	$("#btn1").addClass("spinner-border spinner-border-sm");
			$("#btn2").addClass("spinner-border spinner-border-sm");*/
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		var paymentmethodId = $("#paymentmethodId").val();
		var feecateId = $("#feecateId").val();
		var departmentofpediatricsId = $("#departmentofpediatricsId").val();
		var schoolId = $("#schoolId").attr("name");
		var schoolName = $("#schoolId").attr("id_schoolName");
		var classId = $("#classId").val();
		//判断时间是都空值
		if (startTime != null && startTime != '') {
			startTime = new Date(startTime);
		}
		if (startTime == '' || startTime == null) {
			startTime = new Date();
		}
		if (endTime != null && endTime != '') {
			endTime = new Date(endTime);
		}
		if (endTime == '' || endTime == null) {
			endTime = new Date();
		}

		$.ajax({
			url : 'schoolFeecateOrderInfo.html',
			data : {
				startTime : startTime,
				endTime : endTime,
				paymentmethodId : paymentmethodId,
				feecateId : feecateId,
				departmentofpediatricsId : departmentofpediatricsId,
				schoolId : schoolId,
				schoolName : schoolName,
				classId : classId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				//先清空
				$("#products-datatable").empty();
				//在添加
				$("#products-datatable").append(feeOrderHtml());
				queryIndex(data);
				/*$(".text-center").append("<button type='button' id='btn1' class='btn btn-success btn-sm mt-2' onclick='expen()'>支出查询</button>" +
					"<button type='button'	id='btn2' class='btn btn-success btn-sm mt-2' onclick='query()'>收入查询</button>");
				*/
				/*	$("#btn1").removeClass("spinner-border spinner-border-sm");
					$("#btn2").removeClass("spinner-border spinner-border-sm");*/

			},
			error : function(data) {
				alert("请重试！");
				location.href = "adminIndex.html";
			}
		});
	}

	feeOrderHtml = function() {
		var $html = "<thead>" +
			"<tr> " +
			"<td>订单编号</td>" +
			"<td>收款人</td>" +
			"<td>日期</td>" +
			"<td>项目名称</td>" +
			"<td>收款金额</td>" +
			"<td>收款方式</td>" +
			"<td>责任人</td>" +
			"<td>课程</td>" +
			"<td>新增课时</td>" +
			"<td>赠送课时</td>" +
			"<td>费用起始日</td>" +
			"<td>费用截至日</td>" +
			"</tr>" +
			"</thead>";

		return $html;
	}
	/**
	 * 收入查询结果
	 */
	queryIndex = function(data) {
		var $html = "<tbody>";

		order = eval("(" + data.orderListBySchool + ")");
		var sumMoney = 0.0;
		for (var i = 0; i < order.length; i++) {
			$html += "<tr class='userId' >" +
				"<td class='table-user'>" + order[i].orderNumber + " </td>" +
				"<td class='table-user'>" +
				"" + order[i].student.studentName + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].startTime + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].feeCategory.chargeTypeName + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].dpMoney + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].paymentMethod.paymentmethodName + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].personliable + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].departmentOfPediatrics.dpTypeName + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].addhour + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].givehour + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].firstdate + "</td>" +
				"<td class='table-user'>" +
				"" + order[i].lastdate + "</td>" +
				"</tr>";
			if (order[i].dpMoney != null && order[i].dpMoney != '' && order.dpMoney != "undefined") {
				sumMoney += order[i].dpMoney;
			}
		}
		$html += "<tbody>";
		$("#products-datatable").append($html);
		$html = "<tbody style='text-align: center;'>" +
			"<tr><td colspan='12'>收入总额</td></tr>" +
			"<tr><td colspan='12'>" + sumMoney + "</td></tr>" +
			"</tbody>";
		$("#products-datatable").append($html);
	}


	/**
	 * 支出查询
	 */
	expen = function() {
		var schoolId = $("#schoolId").attr("name");
		var expenditureitemsId = $("#expenditureitemsId").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();

		//判断时间是都空值
		if (startTime != null && startTime != '') {
			startTime = new Date(startTime);
		}
		if (startTime == '' || startTime == null) {
			startTime = new Date();
		}
		if (endTime != null && endTime != '') {
			endTime = new Date(endTime);
		}
		if (endTime == '' || endTime == null) {
			endTime = new Date();
		}

		$.ajax({
			url : 'expenditureOrder.html',
			data : {
				schoolId : schoolId,
				expenditureitemsId : expenditureitemsId,
				startTime : startTime,
				endTime : endTime
			},
			dataType : "JSON",
			type : 'post',
			success : function(data) {
				$("#products-datatable").empty();
				$("#products-datatable").append(expenditureOrderHtml());
				data = eval(data);
				if (data != null) {
					$("#products-datatable").append(expenditureOrderforeach(data));
					/*$(".text-center").append("<button type='button' id='btn1' class='btn btn-success btn-sm mt-2' onclick='expen()'>支出查询</button>" +
							"<button type='button'	id='btn2' class='btn btn-success btn-sm mt-2' onclick='query()'>收入查询</button>);**/

				}

			},
			error : function() {
				$.NotificationApp.send("错误!", "请刷新重试。", "top-right", "rgba(0,0,0,0.2)", "error");
				setTimeout(function() {
					location.href = "erro.html";
				}, 2000);
			}
		})

	}
	/**
	 * 支出项目
	 */
	expenditureOrderHtml = function() {
		var $html = "<thead>" +
			"<tr> " +
			"<th>账户</th>" +
			"<th>支出类型</th>" +
			"<th>支出</th>" +
			"<th>支出时间</th>" +
			"</tr>" +
			"</thead>";
		return $html;
	}

	expenditureOrderforeach = function(data) {
		var $html = "<tbody>";
		var sumMoney = 0.0;
		for (var i = 0; i < data.length; i++) {
			if (data[i].identification == 0) {
				continue;
			}
			$html += "<tr>" +
				"<td class='table-user'>" +
				"" + data[i].expenditureitems.expenditureitemsName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + data[i].paymentMethod.paymentmethodName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + data[i].feecategoryMoney + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + data[i].startTime + "" +
				"</td>";
			sumMoney += data[i].feecategoryMoney;
		}
		$html += "</tbody>" +
			"<tbody style='text-align: center;'>" +
			"<tr><td colspan='12'>支出总额</td></tr>" +
			"<tr><td colspan='12'>" + sumMoney + "</td></tr>";
		return $html;
	}



	/*print = function(){
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
	}*/

});