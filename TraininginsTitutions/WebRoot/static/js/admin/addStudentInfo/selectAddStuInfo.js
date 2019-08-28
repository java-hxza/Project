$(function(){
	
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		var schoolType = $(this).children("td:last-child").children().attr("name");
		var startTime = new Date().setMonth((new Date().getMonth()-1));
		var endTime = new Date().setMonth(new Date().getDay());
		
		startTime = new Date(startTime);
		endTime = new Date(endTime);
		
		if(schoolType == 1){
			location.href="childrenAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		if(schoolType == 2){
			location.href="highAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		
	});
	
	query = function(){
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		var schoolId = $("#schoolId").attr("name");
		var schoolType = $("#schoolId").attr("id_type");
		var schoolName = $("#schoolName").val();
		//判断时间是都空值
		if(startTime != null && startTime !=''){
			startTime = new Date(startTime);
		}
		if(startTime == '' || startTime == null){
			startTime = new Date();
		}
		if(endTime != null && endTime !=''){
			endTime = new Date(endTime);
		}
		if(endTime == '' || endTime == null){
			endTime = new Date();
		}
		if(schoolType == 1){
			location.href="childrenAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		if(schoolType == 2){
			location.href="highAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		
		
	}
});