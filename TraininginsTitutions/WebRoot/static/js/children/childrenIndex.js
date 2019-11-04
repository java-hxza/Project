$(function(){
	
	var addState = $("#addState").html();
	var state = $("#state").html();
	var loginType = $("#loginType").html();
	
	/**
	 * 跳转到创建学生的页面
	 */
	createStudent = function(){
		if(loginType == 2){
			if(addState == 0){
				alert("您没有添加权限");
				return false;
			}
			
		}
		if($(".customCheckes:checked").length <1) {
			if(!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		} else if($(".customCheckes:checked").length >1) {
				alert("只能选中一条数据！");
				return false;
		}
		
		var classId = $(".customCheckes:checked").parent().parent().next().children().attr("name");
		location.href="regitStudent.html?classId="+classId;
	}
	/**
	 * 少儿学员信息管理页面填跳转
	 */
	studentInfo = function(){
		location.href="studentInfo.html";
	}
	
	/**
	 * 查询学生信息
	 */
	seeStudentInfo = function(){
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
		location.href="seeStudentInfo.html?classId="+classId;
	}
	
	/**
	 * 创建班级
	 */
	createClass = function(){
		if(loginType == 2){
			if(addState == 0){
				alert("您没有添加权限");
				return false;
			}
		}
		location.href="regitClass.html";
	}
	
	
	
	
	
});