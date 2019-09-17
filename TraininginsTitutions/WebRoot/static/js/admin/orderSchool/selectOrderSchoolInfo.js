$(function(){
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href="schoolOrderInfo.html?schoolId="+schoolId+"&schoolName="+schoolName;
	});
	
	
	/**
	 * 收入ajax
	 */
	query = function(){
		$("#btn1").addClass("spinner-border spinner-border-sm");
		$("#btn2").addClass("spinner-border spinner-border-sm");
		var startTime = $("#startTime").val();
		var endTime =$("#endTime").val();
		var paymentmethodId = $("#paymentmethodId").val();
		var feecateId = $("#feecateId").val();
		var departmentofpediatricsId = $("#departmentofpediatricsId").val();
		var schoolId = $("#schoolId").attr("name");
		var schoolName = $("#schoolId").attr("id_schoolName");
		var classId = $("#classId").val();
		//判断时间是都空值
		if(startTime != null && startTime !=''){
			startTime = new Date(startTime);
		}
		if(startTime == '' || startTime == null){
			startTime = new Date();
		}
		if(endTime != null && endTime !=''){
			endTime = new Date(endTime);
		}
		if(endTime == '' || endTime == null){
			endTime = new Date();
		}
		
		$.ajax({
			url :'schoolFeecateOrderInfo.html',
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
			type: 'post',
			success : function(data){
				//先清空
				$("#info").empty();
				//在添加
				queryIndex(data);
				/*$(".text-center").append("<button type='button' id='btn1' class='btn btn-success btn-sm mt-2' onclick='expen()'>支出查询</button>" +
					"<button type='button'	id='btn2' class='btn btn-success btn-sm mt-2' onclick='query()'>收入查询</button>");
				*/
				$("#btn1").removeClass("spinner-border spinner-border-sm");
				$("#btn2").removeClass("spinner-border spinner-border-sm");
				
			},
			error : function(data){
				alert("系统出错！");
				location.href = "adminIndex.html";
			}
			
		});
	}
	
	/**
	 * 收入查询结果
	 */
	queryIndex = function(data){
		var $html = "";
		
		order = eval("("+data.orderListBySchool+")");
		
		for (var i = 0; i < order.length; i++) {
		
			$html +="<tr class='userId' >" +
						"<td>" +
							"<div class='custom-control custom-checkbox'>" +
								"<input type='checkbox' class='customChecks custom-control-input'>" +
								"<label class='custom-control-label  customCheck'for='customCheck2'>&nbsp;</label>" +
							"</div>" +
						"</td>" +
						"<td class='table-user'><a href='javascript:void(0);' class='text-body font-weight-semibold'>"+order[i].orderNumber +"</a> </td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].student.studentName +"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].startTime +"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].feeCategory.chargeTypeName  +"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].dpMoney  +"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].paymentMethod.paymentmethodName+"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].personliable+"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].departmentOfPediatrics.dpTypeName+"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].addhour+"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].givehour+"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].firstdate+"</a></td>" +
						"<td class='table-user'><a href='javascript:void(0);'" +
						"class='text-body font-weight-semibold' >"+order[i].lastdate+"</a></td>" +
				"</tr>" ;
						
		}
		
		$("#info").append($html);

	}
	
	
	/**
	 * 支出查询
	 */
	expen = function(){
		var schoolId = $("#schoolId").attr("name");
		var expenditureitemsId = $("#expenditureitemsId").val();
		var startTime = $("#startTime").val();
		var endTime =$("#endTime").val();
		
		//判断时间是都空值
		if(startTime != null && startTime !=''){
			startTime = new Date(startTime);
		}
		if(startTime == '' || startTime == null){
			startTime = new Date();
		}
		if(endTime != null && endTime !=''){
			endTime = new Date(endTime);
		}
		if(endTime == '' || endTime == null){
			endTime = new Date();
		}
		$.ajax({
			url	: 'expenditureOrder.html',
			data : {
				schoolId : schoolId,
				expenditureitemsId : expenditureitemsId,
				startTime : startTime,
				endTime : endTime
			},
			dataType: "JSON",
			type:'post',
			success:  function(data){
				$("#products-datatable").empty();
				$("#products-datatable").append(expenditureOrderHtml());
				data = eval(data);
				if(data != null){
					$("#products-datatable").append(expenditureOrderforeach(data));
					/*$(".text-center").append("<button type='button' id='btn1' class='btn btn-success btn-sm mt-2' onclick='expen()'>支出查询</button>" +
							"<button type='button'	id='btn2' class='btn btn-success btn-sm mt-2' onclick='query()'>收入查询</button>);**/
                    
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
									""+data[i].expenditureitems.expenditureitemsName +"</a>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
								""+data[i].paymentMethod.paymentmethodName +"</a>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
									""+data[i].feecategoryMoney+"</a>" +
							"</td>" +
							"<td class='table-user'>" +
								"<a href='javascript:void(0);'class='text-body font-weight-semibold'>" +
								""+data[i].startTime+"</a>" +
							"</td>";
			}
					$html += "</tbody>";
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