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
				if (data != null) {
					$("#headmaster").append("<option value=''>请选择班主任</option>");
					for (var i = 0; i < data.length; i++) {
						$("#headmaster").append("<option value=" + data[i].uId + ">" + data[i].userName + "</option>");
					}
				} else {
					$("#headmaster").append("<option value=''>该科别还没有教师</option>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				setTimeout(function() {
					location.href = "erro.html";
				}, 2000);
			}
		});
	}


	/**
	 * 添加少儿班级
	 */
	createChildrenClass = function() {
		var classNumber = $("#classNumber").val();
		var className = $("#className").val();
		var dpId = $("#dpId").val();
		var headmaster = $("#headmaster option:selected");
		headmaster = headmaster.text();
		alert(headmaster);
		var uId = $("#headmaster").val();

		if (classNumber, className == null || $.trim(classNumber), $.trim(className) == '') {
			$.NotificationApp.send("错误!", "请认真填写不能为空，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error");
			return false;
		}

		$.ajax({
			url : 'createChildrenClass.html',
			data : {
				classNumber : classNumber,
				className : className,
				dpId : dpId,
				headmaster : headmaster,
				uId : uId
			},
			dataType : 'JSON',
			type : 'post',
			success : function(data) {
				if(data.state == "1"){
					$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "success");
					setTimeout(function () { 
						location.href="childrenIndex.html";
					}, 2000);
				}else{
					location.href="error.html";
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				$.NotificationApp.send("错误!", "账号密码错误，请检查重试。", "top-right", "rgba(0,0,0,0.2)", "error")
				setTimeout(function() {
					location.href = "erro.html";
				}, 2000);
			}
		});


	}


});