$(function() {
	
	
	save = function() {

		var stuId = $("#studentId").attr("name");
		var startTime = $("#startTime").val();
		var feecateId = $("#feeIds").attr("name");
		var paymentmethodId = $("#paymentmethodId").val();
		var feecategoryMoney = $("#nowPrice").val();
		var remarks = $("#remarks").val();
		var classId = $("#remarks").attr("name");
		var expenditureitemsId = $("#expenditureitemsId").val();
		alert(stuId)
		startTime = new Date(startTime);
		
		$.ajax({
			url : 'highExitSchoolSave.html',
			data : {
				stuId : stuId,
				startTime : startTime,
				feecateId : feecateId,
				paymentmethodId : paymentmethodId,
				feecategoryMoney : feecategoryMoney,
				remarks : remarks,
				expenditureitemsId : expenditureitemsId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data){
				if(data.state == "1"){
					alert("退学成功！");
					location.href ="seeStudentInfo.html?classId="+classId;
				} else {
					alert("请稍后重试！");
					location.href = "seeStudentInfo.html?classId=" + classId;
				}
			}
		});
	}
});