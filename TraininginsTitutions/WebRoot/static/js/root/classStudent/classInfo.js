$(function(){

	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href="classSchoolInfo.html?schoolId="+schoolId+"&schoolName="+schoolName;
	});
	
	
	$(".classId").unbind("click").click(function(){
		var classId = $(this).children().next().children().attr("name");
			location.href="schoolStudentHour.html?classId="+classId;
	});
	
})