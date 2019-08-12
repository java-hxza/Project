$(function() {

	/**
	 * 新增少儿学员信息
	 */
	insertChildrenStudent = function() {
		var studentName = $("#studentName").val(); //学员姓名
		var studentSex = $("input:radio[id='studentSex']:checked").val(); //学员性别
		var studentBirth = new Date($("#studentBirth").val()); //学员生日
		var school = $("#school").val(); //学院在读学校
		var telephone = $("#telephone").val(); //学员家长手机号
		var familyAddress = $("#familyAddress").val(); //学员家庭住址
		var registrationChannels = $("#registrationChannels").val(); //报名渠道
		var registrationConsultant = $("#registrationConsultant").val(); //报名老师
		var startTime = new Date($("#startTime").val()); //开始时间
		var studentClassId = $("#studentClassId").val(); //学员班级
		var headmaster = $(".dp").attr("headmaster");
		var remarks = $("#remarks").val(); //备注
		if (studentName, studentSex, studentBirth, school, registrationConsultant, registrationChannels, studentClassId == null) {
			$.NotificationApp.send("错误!", "你必须输入学员信息。", "top-right", "rgba(0,0,0,0.2)", "error")
			return false;
		}


		$.ajax({
			url : 'redgitChildrenStudent.html',
			data : {
				studentName : studentName,
				studentSex : studentSex,
				studentBirth : studentBirth,
				school : school,
				telephone : telephone,
				familyAddress : familyAddress,
				registrationChannels : registrationChannels,
				registrationConsultant : registrationConsultant,
				startTime : startTime,
				remarks : remarks,
				studentClassId : studentClassId,
				headmaster : headmaster,
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "添加学生成功并加入到班级！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "childrenIndex.html";
					}, 2000);
				} else {
					$.NotificationApp.send("失败！", "添加学生失败！。", "top-right", "rgba(0,0,0,0.2)", "error");
					setTimeout(function() {
						location.href = "error.html";
					}, 2000);
				}

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				aert(XMLHttpRequest.readyState);
				alert(textStatus);
				$.NotificationApp.send("失败！", "添加学生失败！。", "top-right", "rgba(0,0,0,0.2)", "error");
				setTimeout(function() {
					location.href = "error.html";
				}, 2000);
			}
		});




	}


});