$(function() {
	/*	$(".schoolId").unbind("click").click(function() {
			var schoolId = $(this).children().next().children().html();
			var schoolName = $(this).children().next().next().children().html();
			location.href = "highStudentFooInfo.html?schoolId=" + schoolId + "&schoolName=" + schoolName;
		});
	*/
	var num = "";
	for (var i = 0; i < $(".userId").length; i++) {
		for (var j = 0; j < $(".userId").eq(i).find("td").eq(8).attr("name").split(",").length; j++) {
			for (var k = 0; k < $(".feecategorys").length; k++) {
				if ($(".userId").eq(i).find("td").eq(8).attr("name").split(",")[j] == $(".feecategorys").eq(k).attr("name")) {
					num = num + "," + (k + 1);
				} 
				if((k + 1) == $(".feecategorys").length && (j + 1) == $(".userId").eq(i).find("td").eq(8).attr("name").split(",").length) {
					num = num + "-";
				}
			}
		}
	}
	num = num.substring(1, num.length - 1);
	var number = 0;
	for (var i = 0; i < $(".userId").length; i++) {
		for (var j = 0; j < $(".feecategorys").length; j++) {
			if((j + 1) == num.split("-")[number].split(",")[j]) {
				$(".userId").eq(i).find("td").eq(8 + j).after("<td>0</td>");
			}else {
				if($(".userId").eq(i).find("td").eq(8).attr("Money").split(",")[j] == undefined) {
					$(".userId").eq(i).find("td").eq(8 + j).after("<td>0</td>");
				}else {
					$(".userId").eq(i).find("td").eq(8 + j).after("<td>" + $(".userId").eq(i).find("td").eq(8).attr("Money").split(",")[j] + "</td>");
				}
			}
		}
		if((j + 1) == $(".feecategorys").length) {
			number = number + 1;
		}
	}
	
	queryArtStudentFee = function() {
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();

		var classId = $("#classId").val();

		var paymentmethodId = $("#paymentmethodId").val();

		var feecateId = $("#feecateId").val();

		var state = $("#state").val();

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

		location.href = "queryRootHighStudentFee.html?map=" + JSON.stringify({
			state : state,
			feecateId : feecateId,
			paymentmethodId : paymentmethodId,
			classId : classId,
			startTime : startTime,
			endTime : endTime
		});
	}
});