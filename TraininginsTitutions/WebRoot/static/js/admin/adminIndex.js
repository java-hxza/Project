$(function(){
	/**
	 * 创建学校账号跳转控制层
	 */
	createUser = function(){
		location.href="createUser.html";
	}
	/**
	 * 创建学校跳转控制层
	 */
	createSchool = function(){
		location.href="createSchool.html";
	}
	
	clickSchool = function(){
		var schoolId = $("#schoolId").children().next().children().html();
		location.href="schoolInfo.html?schoolId="+schoolId;
	}
	/**
	 * 创建教师
	 */
	createTeacher = function(){
		location.href="creageTeacher.html";
	}
});