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

		$.ajax({
			url : 'queryTeacherInfo.html',
			data : {
				endTime : endTime,
				startTime : startTime,
				dpId : dpId,
				teacherId : teacherId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				$("#products-datatable").empty();
				$("#products-datatable").append(queryTeacherInfoHtml());
				$("#products-datatable").append(queryTeacherInfoForeach(data));
			},
			error : function() {}
		})
	}

	queryTeacherInfoHtml = function() {
		var $html = "<thead>" +
			"<tr> " +
			"<th>序</th>" +
			"<th>校区</th>" +
			"<th>教师名称</th>" +
			"<th>课时名称</th>" +
			"<th>教师总课时</th>" +
			"</tr>" +
			"</thead>";
		return $html;
	}

	queryTeacherInfoForeach = function(data) {
		var teacherHourList = eval(data.teacherHourList);
		var $html = "<tbody>";
		for (var i = 0; i < teacherHourList.length; i++) {
			$html += "<tr>" +
				"<td class='table-user'>" +
				"" + i + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + data.schoolName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + teacherHourList[i].teacherName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + teacherHourList[i].dpName + "" +
				"</td>" +
				"<td class='table-user'>" +
				"" + teacherHourList[i].sumHours + "" +
				"</td>";
		}
		$html += "</tbody>";
		return $html;
	}
});