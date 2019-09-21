$(function() {

	/**
		 * 查询教师课时
		 */
	queryTeacherInfo = function() {
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
		var dpId = $("#dpId").val();
		var teacherId = $("#teacherId").val();
		var classId = $("#classId").val();

		location.href = "queryChildrenRootTeacherInfo.html?map=" + JSON.stringify({
			endTime : endTime,
			startTime : startTime,
			dpId : dpId,
			teacherId : teacherId,
			classId : classId
		});
	}
});