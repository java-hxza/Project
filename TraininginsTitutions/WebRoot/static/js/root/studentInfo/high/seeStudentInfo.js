$(function(){
	
	/**
	 * 修改学生信息
	 */
	updateStudnet = function(){
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
		
		var studentId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("id_classId");
		$.ajax({
			url : 'updateStudnet.html',
			data : {
				studentId : studentId
			},
			dataType: 'JSON',
			type : 'post',
			success : function(data){
				$(".table-responsive").empty();
				data = JSON.parse(data);
				$(".table-responsive").append(updateInfo(data));
				$("#update").unbind("click").click(function() {
					var studentName = $("#studentName").val(); //学员姓名
					var studentId = $("#studentName").attr("name"); //学员主键
					var studentSex = $("#studentSex").val(); //学员性别
					var studentBirth = $("#studentBirth").val(); //学员生日
					var school = $("#school").val(); //学院在读学校
					var feeCategory = $("#school").attr("name"); //学院在读学校
					var telephone = $("#telephone").val(); //学员家长手机号
					var familyAddress = $("#familyAddress").val(); //学员家庭住址
					var registrationChannels = $("#registrationChannels").val(); //报名渠道
					var registrationConsultant = $("#registrationConsultant").val(); //报名老师
					var startTime = $("#startTime").val(); //开始时间
					var studentClassId = $("#studentClassId").val(); //学员班级
					var headmaster = $(".dp").attr("headmaster");
					var remarks = $("#remarks").val(); //备注\
					var integral = $("#integral").val();
					var reg = /\d+(\.\d+)?/;
					if (!reg.test(integral)) {
						alert("请输入正确的积分");
						return false;
					}
					if (studentName, studentSex, studentBirth, school, registrationConsultant, registrationChannels,integral == null) {
						$.NotificationApp.send("错误!", "你必须输入学员信息。", "top-right", "rgba(0,0,0,0.2)", "error")
						return false;
					}
					if (startTime == null || startTime == '') {
						startTime = new Date();
					}
					if (studentBirth == null || studentBirth == '') {
						studentBirth = new Date();
					}

					$.ajax({
						type : "POST",
						url : "updateStudentInfo.html",
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
							studentId : studentId,
							integral : integral,
							feeCategory : feeCategory
						},
						dataType : "json",
						success : function(data) {
							if (data.update == "1") {
								alert("修改成功！");
								location.href = "seeStudentInfo.html?classId=" + classId;
							} else {
								alert("修改失败！");
								location.href = "seeStudentInfo.html?classId=" + classId;
							}
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							alert(XMLHttpRequest.status);
							aert(XMLHttpRequest.readyState);
							alert(textStatus);;
							location.href = "seeStudentInfo.html?classId=" + classId;
						}
					});
				});
			},
			error : function(){
				
			}
			
		});
	}
	
	
	
	/**
	 * 更新页面
	 */
	updateInfo = function(data){
		var $html = "<div class='tab-pane show active' id='billing-informatio'>" +
				"<div class='row'>" +
				"<div class='col-lg-8'>" +
				"<h4 class='mt-2'>少儿学员信息录入</h4>" +
				"<p class='text-muted mb-4'></p>" +
				"<form>" +
				"<div class='row'>" +
				"<div class='col-md-6'>" +
				"<div class='form-group'>" +
				"<label for='billing-first-name'>名字</label>" +
				"<input class='form-control' type='text' name='"+data.studentId+"' value='"+data.studentName+"' id='studentName' />" +
				"</div>" +
				"</div>" +
				"<div class='col-md-6'>" +
				"<div class='form-group'>" +
				"<label for='billing-last-name'>性别</label>" +
				"<select id='studentSex' class='form-control' selected='"+data.studentSex+"'><option value='0'>女</option><option value='1'>男</option></select>" +
				"</div>" +
				"</div>" +
				"</div>" +
				"<!-- end row -->" +
				"<div class='row'>" +
				"<div class='col-md-6'>" +
				"<div class='form-group'>" +
				"<label for='billing-email-address'>家长姓名<span class='text-danger'>*</span></label>" +
				"<input class='form-control' type='email' value='"+data.parentName+"' id='parentName' />" +
				"</div>" +
				"</div>" +
				"<div class='col-md-6'>" +
				"<div class='form-group'>" +
				"<label for='billing-phone'>手机号<span class='text-danger'>*</span></label>" +
				"<input class='form-control' type='text' value='"+data.telephone+"' id='telephone'/>" +
				"</div>" +
				"</div>" +
				"</div>" +
				"<div class='row'>" +
				"<div class='col-12'>" +
				"<div class='form-group'>" +
				"<label for='billing-address'>学员出生日期</label>" +
				"<input class='form-control' type='date' value='"+data.studentBirth+"' id='studentBirth'>" +
				"</div>" +
				"</div>" +
				"</div><!-- end row -->" +
				"<div class='row'>" +
				"<div class='col-12'>" +
				"<div class='form-group'>" +
				"<label for='billing-address'>家庭住址</label>" +
				"<input class='form-control' type='text' value='"+data.familyAddress+"' id='familyAddress'>" +
				"</div>" +
				"</div>" +
				"</div><!-- end row -->" +
				"<div class='row'>" +
				"<div class='col-md-4'>" +
				"<div class='form-group'>" +
				"<label for='billing-town-city'>学校</label>" +
				"<input class='form-control' type='text' name='"+data.feeCategory+"' value='"+data.school+"' id='school'/>" +
				"</div>" +
				"</div>" +
				"<div class='col-md-4'>" +
				"<div class='form-group'>" +
				"<label for='billing-state'>报名渠道</label>" +
				"<input class='form-control' type='text' value='"+data.registrationChannels+"' id='registrationChannels'/>" +
				"</div>" +
				"</div>" +
				"<div class='col-md-4'>" +
				"<div class='form-group'>" +
				"<label for='billing-zip-postal'>报名老师</label>" +
				"<input class='form-control' type='text' value='"+data.registrationConsultant+"' id='registrationConsultant' />" +
				"</div>" +
				"</div>" +
				"<div class='col-md-4'>" +
				"<div class='form-group'>" +
				"<label for='billing-zip-postal'>报名时间</label>" +
				"<input class='form-control' type='date' value='"+data.startTime+"' id='startTime'/>" +
				"</div>" +
				"</div>" +
				"<div class='col-md-4'>" +
				"<div class='form-group'>" +
				"<label for='billing-zip-postal'>积分</label>" +
				"<input class='form-control' type='text' value='"+data.integral+"' id='integral'/>" +
				"</div>" +
				"</div>" +
				"<div class='col-md-4'>" +
				"<div class='form-group'>" +
				"<label for='billing-zip-postal'>备注</label>" +
				"<textarea class='form-control' id='remarks' rows='1' value='"+data.remarks+"'></textarea>" +
				"</div>" +
				"</div>" +
				"</div><!-- end row -->" +
				"<div class='row mt-4'>" +
				"<div class='col-sm-6'>" +
				"<a href='apps-ecommerce-shopping-cart.html'class='btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold'>" +
				"<i class='mdi mdi-arrow-left'></i>Back to Shopping Cart</a>" +
				"</div><!-- end col -->" +
				"<div class='col-sm-6'>" +
				"<div class='text-sm-right'>" +
				"<a href='javascript:void(0)' class='btn btn-danger' id='update'>" +
				"<i class='mdi mdi-truck-fast mr-1'></i> 保存 </a>" +
				"</div>" +
				"</div><!-- end col -->" +
				"</div><!-- end row -->" +
				"</form>" +
				"</div>" +
				"</div><!-- End Billing Information Content-->" +
				"</div>";
						
		return $html;
	}

	
	/**
	 * 学生转班
	 */
	shiftWork = function(){
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
		
		var studentId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("id_classId");
		
		
		location.href ="studentShiftWork.html?studentId="+studentId+"&classId="+classId;
			
	}
	
	/**
	 * 下拉框事件
	 */
	classIdChange = function(){
		var classId = $("#classIdes").val();
		var classType = $("#classIdes").children().next().val();
		var classesId = $("#classId").val();
		var studentId = $("#studentId").attr("name");
		var classese = classesId.split("_");
		
		classesId = classese[0];
		var classesType = classese[1];
		
		$.ajax({
			url : 'classIdChange.html',
			data : {
				classId : classId,
				studentId : studentId,
				classesId : classesId,
				classType : classType,
				classesType : classesType
			},
			dataType: 'JSON',
			type : 'post',
			success : function(data){
				
				$("#money").val(data.money);
			}
		});
		
		
	}
	
	/**
	 * 保存转班
	 */
	updateStudentShiftWork = function(){
		var classId = $("#classIdes").val();
		
		var studentId = $("#studentId").attr("name");
		
		var remarks = $("#remarks").val();
		var money = $("#money").val();
		
		var reg = /\d+(\.\d+)?/;
		if (!reg.test(money)) {
			alert("请输入正确的金额");
			return false;
		}
		$.ajax({
			url : 'updateStudentShiftWork.html',
			data : {
				classId : classId,
				studentId : studentId,
				remarks : remarks,
				money : money
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data){
				if(data.state ==1){
					alert("转班成功！");
					location.href = "seeStudentInfo.html?classId=" + classId;
				}else{
					location.href = "seeStudentInfo.html?classId=" + classId;
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				aert(XMLHttpRequest.readyState);
				alert(textStatus);;
				location.href = "seeStudentInfo.html?classId=" + classId;
			} 
		});
	}
	
	/**
	 * 全选
	 */
	allElection = function(){
		$(".customCheckes").prop("checked",true);
	}
	
	/**
	 * 反选
	 */
	reverseElection = function(){
		$(".customCheckes").prop("checked", false);
	}
	/**
	 * 上课登记
	 */
	classBatchRegistration = function(){
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
		var classId = [];
		/**
		 * 读取学生信息
		 */
		for (var i = 0; i < $(".customCheckes:checked").length; i++) {
			studentName.push($(".customCheckes:checked").eq(i).parent().parent().next().next().next().children().html());
			classId.push($(".customCheckes:checked").eq(i).parent().parent().next().next().next().children().attr("name"));
			studentId.push($(".customCheckes:checked").eq(i).parent().parent().parent().children("td:eq(1)").children().attr("name"));
		}

		/**
		 * 读取课程信息
		 */
			var classHour = $(".checkes:checked").parent().parent().parent().children("td:last-child").children().html();
			var dpId = $(".checkes:checked").parent().parent().parent().children("td:eq(2)").children().attr("name");
			var classHours = $(".checkes:checked").parent().parent().parent().children("td:eq(3)").children().html();
			var teacherId = $(".checkes:checked").parent().parent().parent().children("td:eq(1)").children().attr("name");
			var teacherInClass = $(".checkes:checked").parent().parent().parent().children("td:eq(1)").children().html();
			var thId = $(".checkes:checked").parent().parent().parent().children("td:eq(1)").children().attr("th_id");
			var contentOfCourses = $("#contentOfCourses").val();
		

		$.ajax({
			url : 'highClassBatchRegistration.html',
			data : {map : JSON.stringify({
				classId : classId,
				studentId : studentId,
				studentName : studentName,
				classHours : classHours,
				dpId : dpId,
				teacherId : teacherId,
				classHour : classHour,
				teacherInClass : teacherInClass,
				thId : thId,
				contentOfCourses : contentOfCourses
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
	 * 学生退学
	 */
	exitSchool = function(){
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
		
		var studentId = $(".customCheckes:checked").parent().parent().parent().children("td:eq(1)").children().attr("name")
		var studentName= $(".customCheckes:checked").parent().parent().next().next().next().children().html();
		var classId = $(".customCheckes:checked").parent().parent().next().next().next().children().attr("name");
		location.href = "exitSchool.html?studentId="+studentId+"&studentName="+studentName+"&classId="+classId;
	}
	
	
	
	/**
	 * 复选框单击选中取消事件
	 */
	$(".check").click(function() {
		if($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		}else {
			$(this).prev().prop("checked", true);
		}
	});

});