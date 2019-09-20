$(function(){
	
	/**\
	 * 查询该学校支出项目信息
	 */
	expenditureOrder = function() {
		var schoolId = $(".schoolId").attr("name");
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();
		//判断时间是都空值
		if (startTime == '' || startTime == null) {
			startTime = new Date();
		}
		if (endTime == '' || endTime == null) {
			endTime = new Date();
		}
		if (startTime != '' || startTime != null) {
			startTime = new Date(startTime);
		}
		if (endTime != '' || endTime != null) {
			endTime = new Date(endTime);
		}
		$.ajax({
			url : 'expenditureOrder.html',
			data : {
				schoolId : schoolId,
				endTime : endTime,
				startTime : startTime
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				$("#products-datatable").empty();
				$("#products-datatable").append(expenditureOrderHtml());
				data = eval(data);
				if (data != null) {
					$("#products-datatable").append(expenditureOrderforeach(data));
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
	/**
	 * 支出项目循环添加
	 */
	expenditureOrderforeach = function(data) {
		var $html = "<tbody>";
		 var sumMoney = 0.0;
		for (var i = 0; i < data.length; i++) {
			if (data[i].identification == 0) {
				continue;
			}
			$html += "<tr>" +

				"<td class='table-user'>" +

				"" + data[i].paymentMethod.paymentmethodName + "" +
				"</td>" +
				"<td class='table-user'>" +

				"" + data[i].expenditureitems.expenditureitemsName + "" +
				"</td>" +
				"<td class='table-user'>" +

				"" + data[i].feecategoryMoney + "" +
				"</td>" +
				"<td class='table-user'>" +

				"" + data[i].startTime + "" +
				"</td>";
			sumMoney +=  data[i].feecategoryMoney;
		}
		$html += "</tbody>" +
		"<tbody style='text-align: center;'>" +
		"<tr><td colspan='4'>支出总额</td></tr>" +
		"<tr><td colspan='4'>"+sumMoney+"</td></tr>";
		return $html;
	}

	/**
	 * 收入
	 */
	incomeOrderHtml = function() {
		var $html = "<thead>" +
			"<tr> " +
			"<th>账户</th>" +
			"<th>收入类型</th>" +
			"<th>收入金额</th>" +
			"<th>收入时间</th>" +
			"</tr>" +
			"</thead>";
		return $html;
	}


	incomeOrderForeachHtml = function(data) {
		var sumMoney = 0.0;
		var expenditureOrderList = eval(data.expenditureOrderList);
		var feeNameArray = eval(data.feeNameArray);
		var $html = "<tbody>";
		for (var i = 0; i < expenditureOrderList.length; i++) {
			if (expenditureOrderList[i].identification == 1) {
				continue;
			}
			$html += "<tr>" +
				"<td class='table-user'>" +
				"" +
				"" + expenditureOrderList[i].paymentMethod.paymentmethodName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" +
				"";
			$html += "" + feeNameArray[i] + "";
			$html += "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + expenditureOrderList[i].dpMoney + "" +
				"</td>、" +
				"<td class='table-user'>" +
				"<span class='text-body font-weight-semibold'> " + expenditureOrderList[i].startTime + " </span>" +
				"</td>";

			sumMoney += parseFloat($.trim(expenditureOrderList[i].dpMoney)) ;

		}
		
		
		
		$html += "</tbody>" +
				"<tbody style='text-align: center;'>" +
				"<tr><td colspan='4'>收入总额</td></tr>" +
				"<tr><td colspan='4'>"+sumMoney+"</td></tr>";
		return $html;
	}

	/**
	 * 查询该学校收入项目
	 */
	incomeOrder = function() {
		var schoolId = $(".schoolId").attr("name");
		var schoolId = $(".schoolId").attr("name");
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();
		//判断时间是都空值
		if (startTime == '' || startTime == null) {
			startTime = new Date();
		}
		if (endTime == '' || endTime == null) {
			endTime = new Date();
		}
		if (startTime != '' || startTime != null) {
			startTime = new Date(startTime);
		}
		if (endTime != '' || endTime != null) {
			endTime = new Date(endTime);
		}
		$.ajax({
			url : 'incomeOrder.html',
			data : {
				schoolId : schoolId,
				endTime : endTime,
				startTime : startTime
			},
			dataType : "JSON",
			type : 'post',
			success : function(data) {
				$("#products-datatable").empty();
				$("#products-datatable").append(incomeOrderHtml());

				if (data != null) {
					$("#products-datatable").append(incomeOrderForeachHtml(data));
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

});