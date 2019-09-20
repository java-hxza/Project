$(function(){

	
	
	$(".classId").unbind("click").click(function(){
		var classId = $(this).children().next().children().attr("name");
		var classLevel = $(this).children("td:last-child").children().attr("name");
		var schoolName = $(this).children().next().next().next().next().next().children().html();
		location.href="teacherHourInfo.html?classId="+classId;
	
	});
	
})


