$(function(){
	
	/**
	 * 新增少儿学员信息
	 */
	insertChildrenStudent = function(){
		var studentName = $("#studentName").val();//学员姓名
		var studentSex = $("input:radio[id='studentSex']:checked").val();//学员性别
		var studentBirth = $("#studentBirth").val();//学员生日
		var school = $("#school").val();//学院在读学校
		var telephone = $("#telephone").val();//学员家长手机号
		var familyAddress = $("#familyAddress").val();//学员家庭住址
		var registrationChannels = $("#registrationChannels").val();//报名渠道
		var registrationConsultant = $("#registrationConsultant").val();//报名老师
		var startTime = $("#startTime").val();//开始时间
		var studentClassId = $("#studentClassId").val();//学员班级
		var dpId = $(".dp").attr("data_dpId");
		var schoolId = $(".dp").attr("data_schoolId");
		var remarks = $("#remarks").val();//备注
		if(studentName,studentSex,studentBirth,school,registrationConsultant,registrationChannels,studentClassId == null){
			$.NotificationApp.send("错误!", "你必须输入学员信息。", "top-right", "rgba(0,0,0,0.2)", "error")
			return false;
		}
		
		
		$.ajax({
			url	: 'redgitChildrenStudent.html',
			data : {
				studentName : studentName,
				studentSex : studentSex,
				studentBirth : studentBirth,
				school : school,
				telephone : telephone,
				familyAddress : familyAddress,
				registrationChannels : registrationChannels,
				registrationConsultant : registrationConsultant,
				startTime : startTime,
				remarks : remarks,
				studentClassId : studentClassId,
				dpId : dpId,
				schoolId : schoolId
			},
			dataType: 'JSON',
			type :'post',
			success: function(data){
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown) { 
           	   alert(XMLHttpRequest.status); 
　          		   aert(XMLHttpRequest.readyState); 
	           alert(textStatus);
			}
		});
		
		
		
		
	}
	
	
});