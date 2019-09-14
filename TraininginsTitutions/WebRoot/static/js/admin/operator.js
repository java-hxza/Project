/**
	 * 修改教师方法
	 */
	updateUser = function(){
		if($(".customChecks:checked").length <1) {
			if(!$(".customChecks").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customChecks:checked").length >1) {
			if(!$(".customChecks").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		
		var uId = $(".customChecks:checked").parent().parent().next().children().html();
		$.ajax({
			url  : 'selectUser.html',
			data :{
				uId : uId
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
					var loginName = $.trim($(".loginName").val());
					var telephone = $.trim($(".telephone").val());
					var remarks = $.trim($(".remarks").val());
					var loginPassword = $.trim($(".loginPassword").val());
					var loginPasswords = $.trim($(".loginPasswords").val());
					var userTypeId = $.trim($(".userTypeId").attr("name"));
					var uId = $(".uId").attr("name");
					if(loginName == "") {
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
						url : "updateUser.html",
						data :{
							loginName : loginName,
							telephone : telephone,
							remarks : remarks,
							loginPassword : loginPassword,
							userTypeId : userTypeId,
							uId:uId
						},
						dataType : "json",
						success : function(data) {
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
		var $html = "<div class='card'>" +
					" <div class='card-body'>" +
						"<form class='needs-validation' novalidate>" +
							"<div class='form-group position-relative mb-3 uId' name='"+data.uId+"' >" +
								"<label for='validationTooltip01'>校区</label>" +
								"<input type='text' class='form-control schoolId' name='"+data.school.schoolId+"' value='"+data.school.schoolName+"' id='validationTooltip01' disabled required>" +
								"<label for='validationTooltip01'>操作员类型</label>" +
								"<input type='text' class='form-control userTypeId' name='"+data.userType.userTypeId+"' value='"+data.userType.userTypeName+"' id='validationTooltip01' disabled required>" +
								"<label for='validationTooltip01'>姓名</label>" +
								"<input type='text' class='form-control loginName' id='validationTooltip01' value='"+data.loginName+"' placeholder='姓名'  required>" +
								"<label for='validationTooltip01'>密码</label>" +
								" <input type='text' class='form-control loginPassword' id='validationTooltip01' value='"+data.loginPassword+"' placeholder='请填写密码'  required>" +
								"<label for='validationTooltip01'>请再次密码</label>" +
								" <input type='text' class='form-control loginPasswords' id='validationTooltip01' value='"+data.loginPassword+"' placeholder='请再次填写密码'  required>" +
								" <label for='validationTooltip01'>电话</label>" +
								"<input type='text' class='form-control telephone' id='validationTooltip01' value='"+data.telephone+"' placeholder='XXX-XXXX-XXXX'  required>" +
								"<label for='validationTooltip01'>备注</label>" +
								"<input type='text' class='form-control remarks' id='validationTooltip01' placeholder='请填写备注' value='"+data.remarks+"'  required>" +
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
	delUser = function(){
		if($(".customChecks:checked").length <1) {
			if(!$(".customChecks").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customChecks:checked").length >1) {
			if(!$(".customChecks").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		
		var uId = $(".customChecks:checked").parent().parent().next().children().html();
		if(confirm("确认删除吗？")){
			
		}else{
			return false;
		}

		$.ajax({
			url : 'delUser.html',
			data : {
				uId : uId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
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
	
	operatorAuthorization = function(){
		if($(".customChecks:checked").length <1) {
			if(!$(".customChecks").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customChecks:checked").length >1) {
			if(!$(".customChecks").prop("checked")) {
				alert("只能选中一条数据！");
				return false;
			}
		}
		
		var uId = $(".customChecks:checked").parent().parent().next().children().html();
		
		location.href ="operatorAuthorization.html?uId="+uId;
	}