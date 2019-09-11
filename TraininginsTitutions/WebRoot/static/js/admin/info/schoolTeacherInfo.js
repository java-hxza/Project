$(function(){
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href="selectSchoolTeacherInfo.html?schoolId="+schoolId+"&schoolName="+schoolName;
	});
	

	/**
	 * 修改教师方法
	 */
	updateTeacher = function(){
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
			if($(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		
		var teacherId = $(".customCheckes:checked").parent().parent().next().children().html();
		
		$.ajax({
			url  : 'selectTeacher.html',
			data :{
				teacherId : teacherId
			},
			dataType: 'JSON',
			post :	'post',
			success: function(data){
				$(".table-responsive").empty();
				data = JSON.parse(data);
				$(".table-responsive").append(updateInfo(data));
				
				
				/**
				 * 修改
				 */
				$("#update").unbind("click").click(function(){
					var teacherName = $.trim($(".teacherName").val());
					var telephone = $.trim($(".telephone").val());
					var remarks = $.trim($(".remarks").val());
					var loginPassword = $.trim($(".loginPassword").val());
					var loginPasswords = $.trim($(".loginPasswords").val());
					var teacherTypeId = $.trim($(".teacherTypeId").attr("name"));
					var teacherId = $(".teacherId").val();
					var departmentId = $(".departmentId").val();
					alert(departmentId);
					if(teacherName == "") {
						alert("请填写姓名！");
						return false;
					}
					if(loginPassword == "") {
						alert("请填写密码！");
						return false;
					}
					if(loginPassword.length < 6) {
						alert("密码最少为6位！");
						return false;
					}
					if(loginPasswords == "") {
						alert("请填写第二次密码！");
						return false;
					}
					if(loginPasswords.length < 6) {
						alert("密码最少为6位！");
						return false;
					}
					if(loginPassword != loginPasswords) {
						alert("两次密码输入不一致！");
						return false;
					}
					if(telephone == "") {
						alert("请填写电话！");
						return false;
					}
					if(telephone.length != 11) {
						alert("请输入11位的数字！");
						return false;
					}
					$.ajax({
						type : "POST",
						url : "updateTeacher.html",
						data :{
							teacherName : teacherName,
							telephone : telephone,
							remarks : remarks,
							teacherTypeId : teacherTypeId,
							loginPassword : loginPassword,
							teacherId:teacherId,
							departmentId : departmentId
						},
						dataType : "json",
						success : function(data) {
							data = JSON.parse(data);
							if (data.update == "1") {
								alert("修改成功！");
								location.href = "adminIndex.html";
							} else {
								alert("修改失败！");
								location.href = "adminIndex.html";
							}
						},
						error : function(data) {
							alert("系统出错！");
							location.href = "adminIndex.html";
						}
					});
				});
				
				
			},error:function(){
				return false;
			}
			
		});
	}
	/**
	 * 修改页面
	 */
	updateInfo = function(data){
		teacher = JSON.parse(data.teacher);
		departMents = JSON.parse(data.departMents);
		var $html = "<div class='card'>" +
		" <div class='card-body'>" +
			"<form class='needs-validation' novalidate>" +
				"<div class='form-group position-relative mb-3 teacherTypeId' name='"+teacher.teacherTypeId+"' >" +
					"<label for='validationTooltip01'>校区</label>" +
					"<input type='text' class='form-control teacherId' value='"+teacher.teacherId+"' id='validationTooltip01' disabled required>" +
					"<label for='validationTooltip01'>姓名</label>" +
					"<input type='text' class='form-control teacherName' id='validationTooltip01' value='"+teacher.teacherName+"' placeholder='姓名'  required>" +
					"<label for='validationTooltip01'>部门</label>" +
					"<select  class='form-control departmentId' id='validationTooltip01'>  selected = '"+teacher.departmentId+"'";
				
						for (var i  = 0;  i< departMents.length; i++) {
							$html += "<option value='"+departMents[i].departmentId+"'>" +
									""+departMents[i].departmentName+"</option>";
						}
					
						$html += "<select/><label for='validationTooltip01'>密码</label>" +
						" <input type='text' class='form-control loginPassword' id='validationTooltip01' value='"+teacher.loginPassword+"' placeholder='请填写密码'  required>" +
						"<label for='validationTooltip01'>请再次密码</label>" +
						" <input type='text' class='form-control loginPasswords' id='validationTooltip01' value='"+teacher.loginPassword+"' placeholder='请再次填写密码'  required>" +
						" <label for='validationTooltip01'>电话</label>" +
						"<input type='text' class='form-control telephone' id='validationTooltip01' value='"+teacher.telephone+"' placeholder='XXX-XXXX-XXXX'  required>" +
						"<label for='validationTooltip01'>备注</label>" +
						"<input type='text' class='form-control remarks' id='validationTooltip01' placeholder='请填写备注' value='"+teacher.remarks+"'  required>" +
					"</div>" +
					"<button class='btn btn-primary' id='update' type='button'>保存</button>" +
						"<form>" +
					"</div>" +
				"</div>";
		return $html;
	}
	
	
	/**
	 * 删除教师
	 */
	delTeacher = function(){
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		
		var teacherId = $(".customCheckes:checked").parent().parent().next().children().html();
		
		if(confirm("确认删除吗？")){
			
		}else{
			return false;
		}

		$.ajax({
			url : 'delTeacher.html',
			data : {
				teacherId : teacherId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = JSON.parse(data);
				if (data.del == "1") {
					alert("删除成功！");
					location.href = "adminIndex.html";
				} else {
					alert("删除成功！");
					location.href = "adminIndex.html";
				}
			},
			error : function(data) {
				alert("系统出错！");
				location.href = "adminIndex.html";
			}
		})
	}
	
	
	/**
	 * 教师授权
	 */
	teacherAuthorization = function(){
		
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		var teacherId = $(".customCheckes:checked").parent().parent().next().children().html();
		
		location.href="teacherAuthorization.html?teacherId="+teacherId;
	}
	
	/**
	 * 授权
	 */
	authorization = function(){
		var teacherId = $("#teacherId").attr("name");
		var schoolId = $("#schoolId").val();
		
		if(teacherId,schoolId == null){
			alert("请选择数据");
			return false;
		}
		
		
		$.ajax({
			url : 'authorization.html',
			data : {
				teacherId : teacherId,
				schoolId : schoolId
			},
			dataType: 'JSON',
			type : 'post',
			success : function(data){
				if (data.state == "1") {
					alert("授权成功！");
					location.href = "adminIndex.html";
				} else if(data.state == "2"){
					alert("教师已授权");
					location.href = "adminIndex.html";
				}else{
					alert("教师授权失败，请重试！");
					location.href = "adminIndex.html";
				}
			},
			error : function(){
				alert("请刷新重试！");
				location.href = "adminIndex.html";
			}
			
		})
	}
	
});