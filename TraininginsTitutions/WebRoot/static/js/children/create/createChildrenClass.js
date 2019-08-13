$(function() {

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
				alert(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});
	}

});