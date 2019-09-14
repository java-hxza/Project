$(function() {
	Hour = function() {
		var time = $(".Hours").val();
		if(time == "" || time == 0) {
			alert("请输入正确的课时！");
			return false;
		}
		$(".Times").val("");
		var Choice = 1;
		$.ajax({
			type : "POST",
			url : "selectHour.html",
			data : {
				time : time,
				Choice : Choice
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				$(".appends").after("<table class='table table-bordered table-centered mb-0 delSt'><thead class='thead-light'><tr><th>校区信息</th><th>学员名称</th><th>课程名称</th><th>总课时</th><th>已用课时</th><th>剩余课时</th><th>交费总额</th><th>手机</th><th>就读学校</th><th>单号</th></tr></thead><tbody class='adds'></tbody></table>");
				for (var i = 0; i < data.order.length; i++) {
					$(".adds").append("<tr><td>"+data.order[i].school.schoolName+"</td><td>"+data.order[i].student.studentName+"</td><td>"+data.order[i].departmentOfPediatrics.dpTypeName+"</td><td>"+data.order[i].addhour+"</td><td>"+(data.order[i].addhour - data.order[i].student.studentHour)+"</td><td>"+data.order[i].student.studentHour+"</td><td>"+data.order[i].dpMoney+"</td><td>"+data.order[i].student.telephone+"</td><td>"+data.order[i].student.school+"</td><td>"+data.order[i].orderNumber+"</td></tr>");
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
		if(time == "" || time == 0) {
			alert("请输入正确的时间段！");
			return false;
		}
		 $(".Hours").val("");
		var Choice = 2;
		$.ajax({
			type : "POST",
			url : "selectHour.html",
			data : {
				time : time,
				Choice : Choice
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				$(".appends").after("<table class='table table-bordered table-centered mb-0 delSt'><thead class='thead-light'><tr><th>校区信息</th><th>学员名称</th><th>付款方式</th><th>收款项目</th><th>最后一次金额</th><th>费用时间起</th><th>费用时间止</th><th>收款日期</th><th>剩余天数</th><th>已过期天数</th><th>手机</th><th>就读学校</th><th>单号</th></tr></thead><tbody class='adds'></tbody></table>");
				for (var i = 0; i < data.order.length; i++) {
					$(".adds").append("<tr><td>"+data.order[i].school.schoolName+"</td><td>"+data.order[i].student.studentName+"</td><td>"+data.order[i].paymentMethod.paymentmethodName+"</td><td class='feecateIds' name='"+data.order[i].feecateId+"'></td><td>"+data.order[i].dpMoney+"</td><td>"+new Date(data.order[i].firstdate).toLocaleDateString()+"</td><td>"+new Date(data.order[i].lastdate).toLocaleDateString()+"</td><td>"+new Date(data.order[i].startTime).toLocaleDateString()+"</td><td class='hours'>"+data.order[i].student.studentHour+"</td><td>0</td><td>"+data.order[i].student.telephone+"</td><td>"+data.order[i].student.school+"</td><td>"+data.order[i].orderNumber+"</td></tr>");
				}
				for (var i = 0; i < $(".hours").length; i++) {
					if($(".hours").eq(i).text() < 0) {
						$(".hours").eq(i).next().text($(".hours").eq(i).text().toString().substring(1));
						$(".hours").eq(i).text("0");
					}
				}
				for (var i = 0; i < $(".feecateIds").length; i++) {
					for (var j = 0; j < $(".feecateIds").eq(i).attr("name").split(",").length; j++) {
						$(".feecateId option").each(function() {
							if($(".feecateIds").eq(i).attr("name").split(",")[j] == $(this).val()) {
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
});