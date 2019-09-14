$(function(){

	
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		var schoolType = $(this).children("td:last-child").children().attr("name");
		location.href="teacherClassSchoolInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&schoolType="+schoolType;
	});
	
	
	$(".classId").unbind("click").click(function(){
		var classId = $(this).children().next().children().attr("name");
		var classLevel = $(this).children("td:last-child").children().attr("name");
		var schoolName = $(this).children().next().next().next().next().next().children().html();
		location.href="teacherHourInfo.html?classId="+classId;
	
	});
	
})


