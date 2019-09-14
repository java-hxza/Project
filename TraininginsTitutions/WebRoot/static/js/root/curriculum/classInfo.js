$(function() {


	$(".classId").unbind("click").click(function() {
		var classId = $(this).children().next().children().attr("name");
		location.href = "curriculumInfo.html?classId=" + classId;
	});


	createCurriclum = function(classId) {

		location.href = "createCurriclum.html?classId=" + classId;
	}
	function formatNumber (n) {
	    n = n.toString()
	    return n[1] ? n : '0' + n;
	}
	// 参数number为毫秒时间戳，format为需要转换成的日期格式
	function formatTime (number, format) {
	    let time = new Date(number)
	    let newArr = []
	    let formatArr = ['Y', 'M', 'D', 'h', 'm', 's']
	    newArr.push(time.getFullYear())
	    newArr.push(formatNumber(time.getMonth() + 1))
	    newArr.push(formatNumber(time.getDate()))

	    newArr.push(formatNumber(time.getHours()))
	    newArr.push(formatNumber(time.getMinutes()))
	    newArr.push(formatNumber(time.getSeconds()))

	    for (let i in newArr) {
	        format = format.replace(formatArr[i], newArr[i])
	    }
	    return format;
	}
	
	/**
	 * 添加课程
	 */
	saveCurriculum = function() {
		var classId = $("#classId").attr("name");
		var teacherId = $("#teacherId").attr("name");
		var dpId = $("#dpId").attr("name");
		var dpName = $("#dpId").val();
		var teacherName = $("#teacherId").val();
		var startTime = $("#startTime").val();
		var remarks = $("#remarks").val();
		var hours = $("#hours").val();
		var reg = /\d+(\.\d+)?/;
		if (!reg.test(hours)) {
			alert("请输入正确的课时");
			return false;
		}
		if (startTime != null && startTime != '') {
			startTime = new Date(startTime);
		}
		if (startTime == null || startTime == '') {
			startTime = new Date();
		}
		$.ajax({
			url : 'insertCurriculum.html',
			data : {
				classId : classId,
				teacherId : teacherId,
				dpId : dpId,
				startTime : startTime,
				remarks : remarks,
				teacherName : teacherName,
				dpName : dpName,
				hours : hours
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "添加课程成功！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "curriculumInfo.html?classId=" + classId;
					}, 2000);
				} else {
					$.NotificationApp.send("失败！", "请刷新重试！。", "top-right", "rgba(0,0,0,0.2)", "error");
					setTimeout(function() {
						location.href = "curriculumInfo.html?classId=" + classId;
					}, 2000);
				}
			},
			error : function() {}
		});


	}


	/**
	 * 修改课程信息
	 */
	updateCurriclum = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			if ($(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}

		var teacherHourId = $(".customCheckes:checked").parent().parent().next().children().attr("name");

		$.ajax({
			url : 'queryCurriculumInfo.html',
			data : {
				teacherHourId : teacherHourId
			},
			dataType : 'JSON',
			post : 'post',
			success : function(data) {
				$(".table-responsive").empty();
				data = JSON.parse(data);
				$(".table-responsive").append(updateInfo(data));


				/**
				 * 修改
				 */
				$("#update").unbind("click").click(function() {
					var classId = $("#classId").attr("id_classId");
					var teacherId = $("#teacherId").attr("name");
					var dpId = $("#dpId").attr("name");
					var dpName = $("#dpId").val();
					var teacherName = $("#teacherId").val();
					var startTime = $("#startTime").val();
					var remarks = $("#remarks").val();
					var hours = $("#hours").val();
					var teacherHourId = $("#classId").attr("name");
					var reg = /\d+(\.\d+)?/;
					if (!reg.test(hours)) {
						alert("请输入正确的课时");
						return false;
					}
					if (startTime != null && startTime != '') {
						startTime = new Date(startTime);
					}
					if (startTime == null || startTime == '') {
						startTime = new Date();
					}

					$.ajax({
						type : "POST",
						url : "updateCurriculumInfo.html",
						data : {
							teacherHourId : teacherHourId,
							classId : classId,
							teacherId : teacherId,
							dpId : dpId,
							startTime : startTime,
							remarks : remarks,
							teacherName : teacherName,
							dpName : dpName,
							hours : hours
						},
						dataType : "json",
						success : function(data) {
							if (data.update == "1") {
								alert("修改成功！");
								location.href = "curriculumInfo.html?classId=" + classId;
							} else {
								alert("修改失败！");
								location.href = "curriculumInfo.html?classId=" + classId;
							}
						},
						error : function(data) {
							alert("系统出错！");
							location.href = "curriculumInfo.html?classId=" + classId;
						}
					});
				});


			},
			error : function() {
				return false;
			}
		});
	}

	updateInfo = function(data) {
		$html = "<div class='tab-pane show active' id='billing-information'>" +
			"<div class='row'>" +
			"<div class='col-lg-8'>" +
			"<h4 class='mt-2' id='classId' name='"+data[0].teacherHourId+"' id_classId ='"+data[0].classId+"'>课程添加</h4>" +
			"<form>" +
			"<div class='row'>" +
			"<div class='col-md-12'>" +
			"<div class='form-group'>" +
			"<label for='billing-last-name'>代课教师</label>" +
			"<input type='text'  class='form-control' value='" + data[0].teacherName + "'  id='teacherId' name='" + data[0].teacherId + "' disabled='disabled'>" +
			"</div>" +
			"</div>" +
			"</div><!-- end row -->" +
			"<div class='row'>" +
			"<div class='col-md-6'>" +
			"<div class='form-group'>" +
			"<label for='billing-email-address'>课程类型<span" +
			"class='text-danger'>*</span></label> <input class='form-control' type='text' id='dpId' value='" + data[0].dpName + "' name = '" + data[0].dpId + "'/>" +
			"</div>" +
			"</div>" +
			"<div class='col-md-6'>" +
			"<div class='form-group'>" +
			"<label for='billing-email-address'>本次课时<span" +
			"class='text-danger'>*</span></label> <input class='form-control' type='text' value='"+data[0].hours+"' id='hours'/>" +
			"</div>" +
			"</div>" +
			"</div>" +
			"<div class='row'>" +
			"<div class='col-6'>" +
			"<div class='form-group'>" +
			"<label for='billing-address'>开始日期</label> <input class='form-control' type='datetime' value='"+data[0].startTime+"' id='startTime'>" +
			"</div>" +
			"</div>" +
			"<div class='col-6'>" +
			"<div class='form-group'>" +
			"<label for='billing-address'>课程备注</label> <input class='form-control' type='text value='"+data[0].remarks+"' id='remarks'>" +
			"</div>" +
			"</div>" +
			"</div><!-- end col -->" +
			"<div class='col-sm-6'>" +
			"<div class='text-sm-right'>" +
			"<a href='javascript:void(0)' class='btn btn-danger' id = 'update'> <i class='mdi mdi-truck-fast mr-1'></i> 保存" +
			"</a>" +
			"</div>" +
			"</div> <!-- end col -->" +
			"</div><!-- end row -->" +
			"</form>" +
			"</div>" +
			"</div>";
		return $html;
	}

	
	/**
	 * 删除课程信息
	 */
	delCurriclum = function(classId){
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			if ($(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}

		var teacherHourId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		if(!confirm("确认删除吗？")){
			return false;
		}
		
		$.ajax({
			url : 'delCurriculumInfo.html',
			data : {
				teacherHourId : teacherHourId
			},
			dataType : 'JSON',
			post : 'post',
			success : function(data) {
				if (data.state == "1") {
					alert("删除成功！");
					location.href = "curriculumInfo.html?classId=" + classId;
				} else {
					alert("删除失败！");
					location.href = "curriculumInfo.html?classId=" + classId;
				}
			}
			
		})
		
	}
})