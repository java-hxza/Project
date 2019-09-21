$(function() {
	$(".school").text($(".order option:selected").attr("school"));
	for (var i = 0; i < $(".order option").length; i++) {
		//alert($(".order option").eq(i).val());
		for (var j = 0; j < $(".studentId").length; j++) {
			//alert($(".studentId").eq(j).attr("name"));
			if ($(".order option").eq(i).val() == $(".studentId").eq(j).attr("name")) {
				$(".studentId").eq(j).text($(".studentId").eq(j).text() + "/" + $(".order option").eq(i).text());
				$(".studentId").eq(j).next().text($(".studentId").eq(j).next().text() + "/" + $(".order option").eq(i).attr("class"));
			}
		}
	}
	var a = "";
	for (var i = 0; i < $(".studentId").length; i++) {
		if ($(".studentId").eq(i).text() == "") {
			$(".studentId").eq(i).text("无");
			$(".studentId").eq(i).next().text("无");
		} else if ($(".studentId").eq(i).text() != "") {
			a = $(".studentId").eq(i).text().toString();
			$(".studentId").eq(i).text(a.substr(1));
			a = $(".studentId").eq(i).next().text().toString();
			$(".studentId").eq(i).next().text(a.substr(1));
		}
	}
	$(".Hour").unbind("click").click(function() {
		$(".GiftActivity").hide();
		var classes = $(".classes option:selected").text();
		var studentName = $.trim($(".studentName").val());
		if (classes != "---请选择---" && studentName != "") {
			for (var i = 0; i < $(".GiftActivity").children(".selectClasses").length; i++) {
				if (classes == $(".GiftActivity").children(".selectClasses").eq(i).text() && studentName == $(".GiftActivity").children(".selectStudentName").eq(i).text()) {
					$(".GiftActivity").children(".selectClasses").eq(i).parent().show();
				}
			}
		} else if (classes == "---请选择---" && studentName != "") {
			for (var i = 0; i < $(".GiftActivity").children(".selectClasses").length; i++) {
				if (studentName == $(".GiftActivity").children(".selectStudentName").eq(i).text()) {
					$(".GiftActivity").children(".selectClasses").eq(i).parent().show();
				}
			}
		} else if (classes != "---请选择---" && studentName == "") {
			for (var i = 0; i < $(".GiftActivity").children(".selectClasses").length; i++) {
				if (classes == $(".GiftActivity").children(".selectClasses").eq(i).text()) {
					$(".GiftActivity").children(".selectClasses").eq(i).parent().show();
				}
			}
		} else if (classes == "---请选择---" && studentName == "") {
			$(".GiftActivity").show();
		}
	});
	$(".Time").unbind("click").click(function() {
		$(".GiftActivity").hide();
		var classes = $(".classes option:selected").text();
		var studentName = $.trim($(".studentName").val());
		if (classes != "---请选择---" && studentName != "") {
			for (var i = 0; i < $(".GiftActivity").children(".selectClasses").length; i++) {
				if (classes == $(".GiftActivity").children(".selectClasses").eq(i).text() && studentName == $(".GiftActivity").children(".selectStudentName").eq(i).text()) {
					$(".GiftActivity").children(".selectClasses").eq(i).parent().show();
				}
			}
		} else if (classes == "---请选择---" && studentName != "") {
			for (var i = 0; i < $(".GiftActivity").children(".selectClasses").length; i++) {
				if (studentName == $(".GiftActivity").children(".selectStudentName").eq(i).text()) {
					$(".GiftActivity").children(".selectClasses").eq(i).parent().show();
				}
			}
		} else if (classes != "---请选择---" && studentName == "") {
			for (var i = 0; i < $(".GiftActivity").children(".selectClasses").length; i++) {
				if (classes == $(".GiftActivity").children(".selectClasses").eq(i).text()) {
					$(".GiftActivity").children(".selectClasses").eq(i).parent().show();
				}
			}
		} else if (classes == "---请选择---" && studentName == "") {
			$(".GiftActivity").show();
		}
	});
	DaYin = function() {
		var num = 0;
		for (var i = 0; i < $(".GiftActivity").length; i++) {
			if ($(".GiftActivity").eq(i).css('display') == "none") {
				num = num + 1;
			}
		}
		if (num == $(".GiftActivity").length) {
			alert("没有可以打印的数据！")
			return false;
		}
		for (var i = 0; i < $(".GiftActivity").length; i++) {
			if ($(".GiftActivity").eq(i).css('display') == "none") {
				$(".GiftActivity").eq(i).remove();
				i = i - 1;
			}
		}
		bdhtml = $(".dayin").html();
		//alert(bdhtml);
		sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
		eprnstr = "<!--endprint-->"; //结束打印标识字符串
		prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容
		prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
		var iframe = null;
		iframe = document.getElementById("iframe1")

		var iwindow = null;
		var iwindow = iframe.contentWindow; //获取iframe的window对象
		iwindow.document.close();
		iwindow.document.write(prnhtml);
		iwindow.print(); //调用浏览器的打印功能打印指定区域

	};
});