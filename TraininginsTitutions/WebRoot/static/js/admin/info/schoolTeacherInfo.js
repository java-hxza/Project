$(function(){
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		location.href="selectSchoolTeacherInfo.html?schoolId="+schoolId+"&schoolName="+schoolName;
	});
});