$(function() {
	var adminState = $("#adminState").html();
	/**
	 * 创建学校账号跳转控制层
	 */
	createUser = function() {
		if(adminState == 0){
			alert("您没有权限！");
			return false;
		}
		location.href = "createUser.html";
	}
	/**
	 * 创建学校跳转控制层
	 */
	createSchool = function() {
		if(adminState == 0){
			alert("您没有权限！");
			return false;
		}
		location.href = "createSchool.html";
	}
	/**
	 * 删除学校
	 */
	delSchool = function(){
		if(adminState == 0){
			alert("您没有权限！");
			return false;
		}
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
		if(confirm("确认删除吗？删除后该学校的学生信息以及账户信息都会清空！！")){
			
			var schoolId = $(".customCheckes:checked").parent().parent().next().children().html();
			
			$.ajax({
				url :"delSchoolInfo.html",
				data : {
					schoolId : schoolId
				},
				dataType : "JSON",
				post : "post",
				success: function(data){
					if(data.state == "1"){
						alert("删除成功！");
						location.href="adminIndex.html";
					}else{
						alert("删除失败！");
					}
				}
			});
			
			
		}

	}
	/**
	 * 查询学校详情
	 */
	querySchool = function() {
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

		var schoolId = $(".customCheckes:checked").parent().parent().next().children().html();
		var schoolName =  $(".customCheckes:checked").parent().parent().next().next().children().html();
		location.href = "schoolInfo.html?schoolId=" + schoolId + "&schoolName=" + schoolName;

	}


	/**
	 * 创建教师
	 */
	createTeacher = function() {
		if(adminState == 0){
			alert("您没有权限！");
			return false;
		}
		location.href = "creageTeacher.html";
	}

	/**
	 * 查询
	 */
	query = function() {
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();

		var provinceId = $("#provinceId").val();
		var cityId = $("#cityId").val();

		location.href = "querySchoolOrderByTime.html?endTime=" + endTime + "&startTime=" + startTime + "&provinceId=" + provinceId + "&cityId=" + cityId;

	}




});