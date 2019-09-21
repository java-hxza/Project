$(function(){

/*	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href="classSchoolInfo.html?schoolId="+schoolId+"&schoolName="+schoolName;
	});
	*/
/*	
	$(".classId").unbind("click").click(function(){
		var classId = $(this).children().next().children().attr("name");
			location.href="studentHourInfo.html?classId="+classId;
	});*/

	/**
	 * 异步加载少儿学生收费情况
	 */
	$(".jiaofei").unbind("click").click(function() {
		var studentId = $(this).attr("name");
		var sumMoney = $(this).parent().parent().children("td:eq(7)").html();
		var studentName = $(this).parent().parent().children("td:eq(2)").html();
		$.ajax({
			url : 'studentBill.html',
			data : {
				studentId : studentId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				$("#products-datatable").empty();
				$("#tables").empty();
				$("#tables").html("学生缴费记录");
				$("#products-datatable").append(studentBillHtml());
				$("#products-datatable").append(studentBillForEach(data, sumMoney, studentName));
			},
			error : function() {}
		});
	});
	/**
	 * 少儿收费情况表页面
	 */
	studentBillHtml = function() {
		var $html = "<thead>" +
			"<tr> " +
			"<th>学员名称</th>" +
			"<th>收款日期</th>" +
			"<th>方式</th>" +
			"<th>收款方式</th>" +
			"<th>收款金额</th>" +
			"<th>新增课时</th>" +
			"<th>赠送课时</th>" +
			"<th>剩余课时</th>" +
			"<th>备注</th>" +
			"<th>单号</th>" +
			"<th>操作员</th>" +
			"<th>操作日期</th>" +
			"</tr>" +
			"</thead>";
		return $html;
	}

	studentBillForEach = function(data, sumMoney, studentName) {
		var studentOrders = eval(data.studentOrders);
		var paymentName = eval(data.paymentName);
		var $html = "";
		for (var i = 0; i < studentOrders.length; i++) {
			$html += "<tr>" +
				"<td class='table-user'>" +
				"" + studentName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].startTime + "" +
				"</td>" +
				"<td class='table-user'>上课 </td>" +
				"<td class='table-user'>" +
				"" + paymentName[i] + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].dpMoney + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].addhour + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].givehour + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + sumMoney + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].remarks + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].orderNumber + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].personliable + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + studentOrders[i].startTime + "" +
				"</td>" +
				"";
		}
		return $html;
	}
	
	/**
	 * 按照日期查询学生课时
	 */
	queryStudentHour = function(){
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();
		var classId = $("#classId").val();
		location.href = "queryChildrenStudentHour.html?startTime="+startTime+"&endTime="+endTime+"&classId="+classId;
	}
})
