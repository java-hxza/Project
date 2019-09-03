$(function() {
	regitSchool = function() {

		$("#loginBtn span").addClass("spinner-border spinner-border-sm");
		$("#loginBtn span").text("");
		$("#loginBtn").attr("disabled", "disabled");
		/**
		 * 获取用户录入的值
		 */
		var cityProperId = $("#provinceId").val();
		var cityId = $("#cityId").val();
		var schoolName = $("#schoolName").val();
		var schoolType = $("#schoolType").val();
		var schoolRemarks = $("#schoolRemarks").val();
		if (schoolName == '' || schoolName == null) {
			$.NotificationApp.send("错误!", "你必须城市名及学校名。", "top-right", "rgba(0,0,0,0.2)", "error")
			$("#loginBtn span").removeClass("spinner-border spinner-border-sm");
			$("#loginBtn span").text("注册");
			$("#loginBtn").attr("disabled", false);
			return false;
		}
		$.ajax({
			url : 'regitSchool.html',
			data : {
				cityProperId : cityProperId,
				cityId : cityId,
				schoolName : schoolName,
				schoolRemarks : schoolRemarks,
				schoolType : schoolType
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				data = eval(data);
				if (data.state == "1") {
					$.NotificationApp.send("成功！", "创建学校成功！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "adminIndex.html";
					}, 2000);
				} else {
					$.NotificationApp.send("失败！", "创建学校失败请重新创建！。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function() {
						location.href = "erro.html";
					}, 2000);
				}
			},
			error (XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});


	}

});