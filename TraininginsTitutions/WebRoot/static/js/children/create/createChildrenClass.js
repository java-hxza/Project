$(function() {
	/**
	 * 班级类别点击事件
	 */
	dpChange = function() {
		var dpId = $("#dpId").val();
		$.ajax({
			url : 'dpChange.html',
			data : {
				dpId : dpId
			},
			dataType : 'JSON',
			type : "post",
			success : function(data) {
				data = eval(data);
				$("#headmaster").empty();
				if(data!=null){
					$("#headmaster").append("<option value=''>请选择班主任</option>");
					for (var i =0; i<data.length; i++) {
						$("#headmaster").append("<option value="+data[i].uId+">"+data[i].userName+"</option>");
					}
				}else{
					$("#headmaster").append("<option value=''>该科别还没有教师</option>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				setTimeout(function () { 
					location.href = "erro.html";
				}, 2000);
			}
		});
	}
	
	
	
});