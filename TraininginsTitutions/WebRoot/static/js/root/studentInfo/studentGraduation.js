$(function() {


	/**
	 * 全选
	 */
	allElection = function() {
		$(".customCheckes").prop("checked", true);
	}

	/**
	 * 反选
	 */
	reverseElection = function() {
		$(".customCheckes").prop("checked", false);
	}

	insertStudentGraduation = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		}
		var studentId = [];
		/**
		 * 读取学生信息
		 */
		for (var i = 0; i < $(".customCheckes:checked").length; i++) {
			studentId.push($(".customCheckes:checked").eq(i).parent().parent().next().attr("name"));

		}

		$.ajax({
			url : 'insertStudentGraduation.html',
			data : {
				map : JSON.stringify({
					studentId : studentId
				})
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data == "1") {
					location.href = "studentGraduation.html";
				} else {
					location.href = "studentGraduation.html";
				}
			},
			error : function() {}
		});

	}

	queryStudentGraduation = function() {
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();
		var classId = $("#classId").val();
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
		
		location.href = "queryStudentGraduation.html?classId="+classId;
		
	}
});