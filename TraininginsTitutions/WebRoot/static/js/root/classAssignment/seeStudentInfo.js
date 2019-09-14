$(function() {

	/**
	 * 学生分班
	 */
	fenBanSave = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		}
		if ($(".checkes:checked").length < 1) {
			if (!$(".checkes").prop("checked")) {
				alert("请选中一条课程数据！");
				return false;
			}
		}
		var studentName = [];
		var studentId = [];
		var startTime = [];
		/**
		 * 读取学生信息
		 */
		for (var i = 0; i < $(".customCheckes:checked").length; i++) {
			studentName.push($(".customCheckes:checked").eq(i).parent().parent().next().next().next().children().html());
			startTime.push($(".customCheckes:checked").eq(i).parent().parent().next().next().next().children().attr("name"));
			studentId.push($(".customCheckes:checked").eq(i).parent().parent().parent().children("td:eq(1)").children().attr("name"));
		}

		/**
		 * 获取班级信息
		 */
		var classId = $(".checkes:checked").parent().parent().parent().children("td:eq(1)").children().attr("name");
		var teacherName = $(".checkes:checked").parent().parent().parent().children("td:eq(2)").children().html();
		var teacherId = $(".checkes:checked").parent().parent().parent().children("td:eq(2)").children().attr("name");
		
		$.ajax({
			url : 'fenBanSave.html',
			data : {map : JSON.stringify({
				studentId : studentId,
				studentName : studentName,
				startTime : startTime,
				classId : classId,
				teacherId : teacherId,
				teacherName : teacherName
			}
			)} ,
			dataType : 'JSON',
			type : 'post',
			success : function(data){
				if(data.state == "1"){
					alert("登记成功！");
					location.href ="seeStudentInfo.html?classId="+classId[0];
				}
			}
		});
		
	}

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

	/**
	 * 复选框单击选中取消事件
	 */
	$(".check").click(function() {
		if ($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		} else {
			$(this).prev().prop("checked", true);
		}
	});
});