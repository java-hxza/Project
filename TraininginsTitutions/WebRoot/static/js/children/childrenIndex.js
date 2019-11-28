$(function() {

	var addState = $("#addState").html();
	var state = $("#state").html();
	var loginType = $("#loginType").html();

	/**
	 * 跳转到创建学生的页面
	 */
	createStudent = function() {
		if (loginType == 2) {
			if (addState == 0) {
				alert("您没有添加权限");
				return false;
			}

		}
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if ($(".customCheckes:checked").length > 1) {
			alert("只能选中一条数据！");
			return false;
		}

		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		location.href = "regitStudent.html?classId=" + classId;
	}

	/**
	 * 少儿学员信息管理页面填跳转
	 */
	studentInfo = function() {
		location.href = "studentInfo.html";
	}

	/**
	 * 查询学生信息
	 */
	seeStudentInfo = function() {
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

		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		location.href = "seeStudentInfo.html?classId=" + classId;
	}

	updateClass = function() {
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
		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("name");

		$.ajax({
			url : "queryClassByClassId.html",
			data : {
				classId : classId
			},
			dataType : 'JSON',
			type : 'POST',
			success : function(data) {
				$(".table-responsive").empty();
				updateClass(data);
				$("#update").unbind("click").click(function(){
					
				});
				
			}
		});

		location.href = "updateClass.html?classId=" + classId;

	}

	updateClass = function(data) {
		class1 = JSON.parse(data.class);
		var $html = "<div class='card'>" +
			" <div class='card-body'>" +
			"<form class='needs-validation' novalidate>" +
			"<div class='form-group position-relative mb-3 classId' name='" + class1.classId + "' >" +
			"<label for='validationTooltip01'>班级名称</label>" +
			"<input type='text' class='form-control className' value='" + class1.className + "' id='validationTooltip01' disabled required>" +
			"<label for='validationTooltip01'>班级班号</label>" +
			"<input type='text' class='form-control classNumber' id='validationTooltip01' value='" + class1.classNumber + "' placeholder='班级班号'  required>" +
			"</div>" +
			"<button class='btn btn-primary' id='update' type='button'>保存</button>" +
			"<form>" +
			"</div>" +
			"</div>";
	}

	delClass = function() {
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
		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		$.ajax({
			url : "delClass.html",
			data : {
				classId : classId
			},
			dataType : 'JSON',
			type : 'POST',
			success : function(data) {
				if (data.state == "1") {
					alert("删除成功！");
					location.href = "classIndex.html";
				} else {
					alert("删除失败！");
				}
			}
		});
	}

	/**
	 * 创建班级
	 */
	createClass = function() {
		if (loginType == 2) {
			if (addState == 0) {
				alert("您没有添加权限");
				return false;
			}
		}
		location.href = "regitClass.html";
	}

});