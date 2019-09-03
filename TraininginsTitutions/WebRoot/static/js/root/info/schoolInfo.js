$(function(){
	
	/**\
	 * 查询该学校支出项目信息
	 */
	expenditureOrder = function(){
		var schoolId = $(".schoolId").attr("name");
		$.ajax({
			url	: 'schoolExpen.html',
			data : {
				schoolId : schoolId
			},
			dataType: "JSON",
			type:'post',
			success:  function(data){
				$("#products-datatable").empty();
				$("#products-datatable").append(expenditureOrderHtml());
				data = eval(data);
				if(data != null){
					$("#products-datatable").append(expenditureOrderforeach(data));
				}
				
			},error: function(){
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
	expenditureOrderHtml = function(){
		var $html = "<thead>" +
				"<tr> " +
					"<th style='width: 20px;'> " +
						"<div class='custom-control custom-checkbox'>" +
						"<input type='checkbox' class='custom-control-input' id='customCheck1'/>" +
						"<label class='custom-control-label' for='customCheck1'>&nbsp;</label>" +
						"</div>" +
					"</th>" +
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
	expenditureOrderforeach=  function(data) {
		var $html = "<tbody>";
		for (var i = 0; i < data.length; i++) {
			if(data[i].identification == 0){
				continue;
			}
				$html +="<tr>" +
							"<td>" +
								"<div class='custom-control custom-checkbox'>" +
									"<input type='checkbox' class='custom-control-input' id='customCheck2'/>" +
									"<label class='custom-control-label' for='customCheck2'>&nbsp;</label>" +
								"</div>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
									""+data[i].paymentMethod.paymentmethodName +"</a>" +
							"</td>" +
							"<td class='table-user'>" +
							"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
							""+data[i].expenditureitems.expenditureitemsName  +"</a>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
									""+data[i].feecategoryMoney+"</a>" +
							"</td>" ;
			}
					$html += "</tbody>";
					return $html;
	}

	/**
	 * 收入
	 */
	incomeOrderHtml = function(){
		var $html = "<thead>" +
		"<tr> " +
			"<th style='width: 20px;'> " +
				"<div class='custom-control custom-checkbox'>" +
				"<input type='checkbox' class='custom-control-input' id='customCheck1'/>" +
				"<label class='custom-control-label' for='customCheck1'>&nbsp;</label>" +
				"</div>" +
			"</th>" +
			"<th>账户</th>" +
			"<th>收入类型</th>" +
			"<th>收入金额</th>" +
			"<th>收入时间</th>" +
			"</tr>" +
			"</thead>";
		return $html;
	}
	
	
	incomeOrderForeachHtml = function(data){
		var $html = "<tbody>";
		for (var i = 0; i < data.length; i++) {
			if(data[i].identification == 1){
				continue;
			}
				$html +="<tr>" +
							"<td>" +
								"<div class='custom-control custom-checkbox'>" +
									"<input type='checkbox' class='custom-control-input' id='customCheck2'/>" +
									"<label class='custom-control-label' for='customCheck2'>&nbsp;</label>" +
								"</div>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
									""+data[i].paymentMethod.paymentmethodName +"</a>" +
							"</td>" +
							"<td class='table-user'>" +
							"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
							""+data[i].feeCategory.chargeTypeName +"</a>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
									""+data[i].dpMoney+"</a>" +
							"</td>、" +
							"<td class='table-user'>" +
									"<span class='text-body font-weight-semibold'> "+data[i].startTime+" </span>" +
							"</td>";
			}
		
					$html += "</tbody>";
					return $html;
	}

	/**
	 * 查询该学校收入项目
	 */
	incomeOrder = function(){
		var schoolId = $(".schoolId").attr("name");
		$.ajax({
			url	: 'schoolExpen.html',
			data : {
				schoolId : schoolId
			},
			dataType: "JSON",
			type:'post',
			success:  function(data){
				$("#products-datatable").empty();
				$("#products-datatable").append(incomeOrderHtml());
				data = eval(data);
				if(data != null){
					$("#products-datatable").append(incomeOrderForeachHtml(data));
				}
				
			},error: function(){
				$.NotificationApp.send("错误!", "请刷新重试。", "top-right", "rgba(0,0,0,0.2)", "error");
				setTimeout(function() {
					location.href = "erro.html";
				}, 2000);
			}
			
		})
	}
	
});