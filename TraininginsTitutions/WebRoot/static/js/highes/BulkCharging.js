$(function() {
	for (var i = 0; i < $(".students").length; i++) {
		if (i == 0) {
			$("tbody").append("<tr>");
		}
		if (i % 5 == 0) {
			$("tbody").append("</tr><tr>");
			$("tbody").append("<td><div class='custom-control custom-checkbox'><input type='checkbox' class='custom-control-input customCheckes'> <label class='custom-control-label customCheck' for='customCheck2'>&nbsp;</label></div></td><th>" + $(".students").eq(i).text() + "</th><td class='gender'>" + $(".students").eq(i).attr("studentBirth") + "</td><td>" + $(".students").eq(i).attr("className") + "</td>");
		} else {
			$("tbody").append("<td><div class='custom-control custom-checkbox'><input type='checkbox' class='custom-control-input customCheckes'> <label class='custom-control-label customCheck' for='customCheck2'>&nbsp;</label></div></td><th>" + $(".students").eq(i).text() + "</th><td class='gender'>" + $(".students").eq(i).attr("studentBirth") + "</td><td>" + $(".students").eq(i).attr("className") + "</td>");

		}
	}
	$("tbody").append("</tr>");
	$(".students").remove();
	var Time = new Date();
	var gender;
	var year;
	var month = Math.ceil(year / 1000 / 60 / 60 / 24 / 365);
	for (var i = 0; i < $(".gender").length; i++) {
		gender = new Date($(".gender").eq(i).text());
		year = Time.getTime() - gender.getTime();
		$(".gender").eq(i).text(Math.ceil(year / 1000 / 60 / 60 / 24 / 365).toString() + "岁");
	}
	AllElection = function() {
		$(".customCheck").prev().prop("checked", true);
	};

	TotallyUnselected = function() {
		$(".customCheck").prev().prop("checked", false);
	};

	Charge = function() {
		if ($(".customCheckes:checked").length < 1) {
			if (!$(".customCheckes").prop("checked")) {
				alert("请选中一条数据！");
				return false;
			}
		}
	};
});