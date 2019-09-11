$(function() {
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
});