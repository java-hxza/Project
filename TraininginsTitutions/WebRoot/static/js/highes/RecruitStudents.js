$(function() {
	Hour = function() {
		$(".YC").hide();
		var studentName = $.trim($(".studentName").val());
		var classes = $(".classes option:selected").val();
		var teacherId = $(".teacher option:selected").val();
		var startTime = $(".Times").val();
		if(teacherId == undefined) {
			alert("暂无招生老师！");
			return false;
		}
		if(studentName == "") {
			studentName = null;
		}else if(classes == 0) {
			classes = null;
		}else if(startTime == "") {
			startTime = null;
		}
		$.ajax({
			type : "POST",
			url : "RecruitStudents2.html",
			data : {
				startTime : startTime,
				classes : classes,
				teacherId : teacherId,
				studentName : studentName
				
			},
			dataType : "json",
			success : function(data) {
				data = JSON.parse(data);
				$(".delSt").remove();
				var times;
				var Hours2;
				var Minutes2;
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
					$(".adds").append("<tr class='delSt'><td>" + data.order[i].orderId + "</td><td>" + data.order[i].school.schoolName + "</td><td>" + data.order[i].classes.className + "</td><td>" + data.order[i].student.studentName + "</td><td>" + (times.getFullYear() + "-" + (times.getMonth() + 1) + "-" + times.getDate() + "&nbsp;" + Hours2 + ":" + Minutes2) + "</td><td>" + data.order[i].orderNumber + "</td><td>" + data.order[i].teacher.teacherName + "</td></tr>");
				}
				$(".delSt").eq(data.order.length - 1).after("<tr class='delSt'> <td colspan='4' style='text-align:center;'>招生老师/" + $(".teacher option:selected").text() + "</td><td colspan='3' style='text-align:center;'>招生人数/" + data.order.length + "</td></tr>");

			},
			error : function(data) {
				alert("系统出错！");
				location.href = "RecruitStudents.html";
			}
		});
	};
	Printing = function() {
		if ($(".delSt").val() == undefined) {
			alert("没有可以打印的数据！")
			return false;
		}
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