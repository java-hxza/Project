$(function() {
	$(".schoolId").unbind("click").click(function() {
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href = "artStudentFooInfo.html?schoolId=" + schoolId + "&schoolName=" + schoolName;
	});
	
	run = function(){
		var num = "";
		for (var i = 0; i < $(".userId").length; i++) {
			for (var j = 0; j < $(".userId").eq(i).find("td").eq(8).attr("name").split(",").length; j++) {
				for (var k = 0; k < $(".feecategorys").length; k++) {
					if ($(".userId").eq(i).find("td").eq(8).attr("name").split(",")[j] == $(".feecategorys").eq(k).attr("name")) {
						num = num + "," + (k + 1);
					}
					if ((k + 1) == $(".feecategorys").length && (j + 1) == $(".userId").eq(i).find("td").eq(8).attr("name").split(",").length) {
						num = num + "-";
					}
				}
			}
		}
		num = num.substring(1, num.length - 1);
		var number = 0;
		var numbers = 0;
		var numbers2 = 0;
		for (var i = 0; i < $(".userId").length; i++) {
			numbers = 0;
			numbers2 = 0;
			for (var j = 0; j < $(".feecategorys").length; j++) {
				if (num.split("-")[number].split(",")[numbers] == "") {
					numbers = numbers + 1;
				}
				if ((j + 1) == num.split("-")[number].split(",")[numbers]) {
					if ($(".userId").eq(i).find("td").eq(8).attr("Money").split(",")[numbers2] == undefined) {
						$(".userId").eq(i).find("td").eq(8 + j).after("<td>0</td>");
					} else {
						$(".userId").eq(i).find("td").eq(8 + j).after("<td>" + $(".userId").eq(i).find("td").eq(8).attr("Money").split(",")[numbers2] + "</td>");
						var a = $(".userId").eq(i).find("td").eq(8).attr("Money").split(",")[numbers2];
						numbers2++;
					}
				} else {
					$(".userId").eq(i).find("td").eq(8 + j).after("<td>0</td>");
				}
				//alert((j + 1) + "," + num.split("-")[number].split(",")[numbers]);
				if ((j + 1) == num.split("-")[number].split(",")[numbers]) {
					numbers = numbers + 1;
				}

			}
			number = number + 1;
		}
	}
	run();
	queryArtStudentFee = function() {
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();

		var classId = $("#classId").val();

		var paymentmethodId = $("#paymentmethodId").val();

		var feecateId = $("#feecateId").val();
		
		var studentName = $("#studentName").val();

		var state = $("#state").val();

		if (startTime != '' || startTime != null) {
			startTime = new Date(startTime);
		}
		if (endTime != '' || endTime != null) {
			endTime = new Date(endTime);
		}

		location.href = "queryArtStudentFee.html?map=" + JSON.stringify({
			state : state,
			feecateId : feecateId,
			paymentmethodId : paymentmethodId,
			classId : classId,
			startTime : startTime,
			endTime : endTime,
			studentName : studentName
		});
	}
});