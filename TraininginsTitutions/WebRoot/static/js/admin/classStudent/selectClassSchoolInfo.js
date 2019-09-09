$(function(){

	
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href="classSchoolInfo.html?schoolId="+schoolId+"&schoolName="+schoolName;
	});
	
	
	$(".classId").unbind("click").click(function(){
		var classId = $(this).children().next().children().attr("name");
		var classLevel = $(this).children("td:last-child").children().attr("name");
		if(classLevel == 1){
			location.href="highStudentHourInfo.html?classId="+classId;
		}
		if(classLevel == 2){
			location.href="childrenStudentHourInfo.html?classId="+classId;
		}
		
	});
	
})
