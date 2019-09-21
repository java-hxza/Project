$(function(){

/*	
	$(".classId").unbind("click").click(function(){
		var classId = $(this).children().next().children().attr("name");
		var classLevel = $(this).children("td:last-child").children().attr("name");
		var schoolName = $(this).children().next().next().next().next().next().children().html();
		location.href="studentSituation.html?classId="+classId;
	
	});*/
	/**
	 * 学生收费情况报表
	 */
	queryStudent = function() {
		var endTime = $("#endTime").val();
		var startTime = $("#startTime").val();
		var classId = $("#classId").val();
		
		location.href = "queryStudentFee.html?startTime=" + startTime + "&endTime=" + endTime+"&classId="+classId;
	}
});