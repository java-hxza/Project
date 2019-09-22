$(function() {

	/**
	 * 按条件查询
	 */
	queryStudentLeave = function() {
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		var classId = $("#classId").val();
		if (startTime != null && startTime != '') {
			startTime = new Date(startTime);
		}
		if (startTime == '' || startTime == null) {
			startTime = new Date();
		}
		if (endTime != null && endTime != '') {
			endTime = new Date(endTime);
		}
		if (endTime == '' || endTime == null) {
			endTime = new Date();
		}
		location.href = "queryStudentLeave.html?map=" + JSON.stringify({
			startTime : startTime,
			endTime : endTime,
			classId : classId
		});
	}

	/**
	 * 学院请假
	 */
	insertStudentLevea = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}


		var studentId = $(".customCheckes:checked").parent().parent().next().attr("name");
		var schoolId = $(".customCheckes:checked").parent().parent().next().attr("id_schoolId");
		var classId = $(".customCheckes:checked").parent().parent().next().attr("id_classId");
		var studentName = $(".customCheckes:checked").parent().parent().next().html();
		$.ajax({
			url : 'insertStudentLevea.html',
			data : {
				schoolId : schoolId,
				classId : classId,
				studentId : studentId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				$(".table-responsive").empty();
				$(".table-responsive").append(insertStudentLeaveInfo(data));

				$("#update").unbind("click").click(function() {
					var startTime = $(".startTime").val();
					var endTime = $(".endTime").val();
					var remarks = $(".remarks").val();
					var thId = $("#thId").val();
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
					$.ajax({
						url : 'addStudentLevea.html',
						data : {
							startTime : startTime,
							endTime : endTime,
							remarks : remarks,
							thId : thId,
							studentId : studentId,
							classId : classId,
							schoolId : schoolId,
							studentName : studentName
						},
						dataType : 'JSON',
						type : 'post',
						success : function(data) {
							if (data.state == "1") {
								location.href = "studentLeave.html";
							} else {
								location.href = "studentLeave.html";
							}
						},
						error : function(data) {}
					});
				});
			}
		});
	}


	insertStudentLeaveInfo = function(data) {
		var student = eval(data.student);
		var class1 = eval(data.class1);
		var school = eval(data.school);
		var teacherHourList = data.teacherHourList;
		var $html = "<div class='card'>" +
			" <div class='card-body'>" +
			"<form class='needs-validation' novalidate>" +
			"<div class='form-group position-relative mb-3 studentId' name='" + student.studentId + "' >" +
			"<label for='validationTooltip01'>校区</label>" +
			"<input type='text' class='form-control teacherId' value='" + school.schoolName + "' id='validationTooltip01' disabled required>" +
			"<label for='validationTooltip01'>姓名</label>" +
			"<input type='text' class='form-control studentName'  value='" + student.studentName + "' placeholder='姓名'  required>";
		$html += "<label for='validationTooltip01'>开始时间</label>" +
			" <input type='date' class='form-control startTime' placeholder='开始时间'  >" +
			"<label for='validationTooltip01'>结束时间</label>" +
			" <input type='date' class='form-control endTime'   >" +
			"<label for='validationTooltip01'>备注</label>" +
			"<input type='text' class='form-control remarks'  placeholder='请填写备注'   required>";


		if (class1.classTypeId == 1) {
			$html += "<label for='validationTooltip01'>请假课程</label><select id='thId'>";
			for (var i = 0; i < teacherHourList.length; i++) {
				$html += "<option value='" + teacherHourList[i].teacherHourId + "'>" +
					"" + teacherHourList[i].dpName-- > teacherHourList[i].teacherName-- > teacherHourList[i].startTime + "</option>";
			}
			$html += "</select>";
		}
		$html += "</div>" +
			"<button class='btn btn-primary' id='update' type='button'>保存</button>" +
			"<form>" +
			"</div>" +
			"</div>";
		return $html;
	}

});