$(function() {
	$(".schoolId").unbind("click").click(function() {
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href = "artStudentFooInfo.html?schoolId=" + schoolId + "&schoolName=" + schoolName;
	});


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

		location.href = "queryArtStudentFee.html?map=" + JSON.stringify({
			state : state,
			feecateId : feecateId,
			paymentmethodId : paymentmethodId,
			classId : classId,
			startTime : startTime,
			endTime : endTime
		});
	}
});