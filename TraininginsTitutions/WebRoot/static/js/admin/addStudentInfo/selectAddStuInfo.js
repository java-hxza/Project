$(function(){
	
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolType = $(this).children("td:last-child").children().attr("name");
		var startTime = new Date().setMonth((new Date().getMonth()-1));
		var endTime = new Date().setMonth(new Date().getDay());
		
		startTime = new Date(startTime);
		endTime = new Date(endTime);
		
		if(schoolType == 1){
			location.href="childrenAddStudentInfo.html?schoolId="+schoolId+"&startTime="+startTime+"&endTime="+endTime;
		}
		if(schoolType == 2){
			location.href="highAddStudentInfo.html?schoolId="+schoolId+"&startTime="+startTime+"&endTime="+endTime;
		}
		
		
	});
	
	query = function(){
		
	}
});