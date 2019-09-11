$(function(){
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		var schoolType =  $(this).children("td:last-child").children().attr("name");
		location.href="switchHighIndex.html?schoolId="+schoolId+"&schoolName="+schoolName+"&schoolType="+schoolType;
	});
});