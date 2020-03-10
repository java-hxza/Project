$(function() {
	connect = function() {
		clearForm();

		var CertCtl = document.getElementById("CertCtl");
		try {
			var result = CertCtl.connect();
			document.getElementById("result").value = result;
		} catch (e) {}
	}

	readCert = function() {
		clearForm();

		var CertCtl = document.getElementById("CertCtl");

		try {
			var startDt = new Date();
			var result = CertCtl.readCert();
			var endDt = new Date();
			document.getElementById("result").value = result;

			var resultObj = toJson(result);
			if (resultObj.resultFlag == 0) {
				$(".studentName").val(resultObj.resultContent.partyName);
				if (resultObj.resultContent.gender == 0) {
					$(".studentSex").val(0);
				} else {
					$(".studentSex").val(1);
				}
				$(".studentBirth").val(resultObj.resultContent.bornDay);
				$(".familyAddress").val(value = resultObj.resultContent.certAddress);
				$(".studentIDCard").val(resultObj.resultContent.certNumber);
			}
		} catch (e) {
			alert(e);
		}
	}

	disconnect = function() {
		clearForm();

		var CertCtl = document.getElementById("CertCtl");
		try {
			var result = CertCtl.disconnect();
			document.getElementById("result").value = result;
		} catch (e) {}
	}
	getVerSion = function() {
		clearForm();

		var CertCtl = document.getElementById("CertCtl");
		try {
			var result = CertCtl.getVersion();
			document.getElementById("result").value = result;
		} catch (e) {}
	}
	getSamId = function() {
		clearForm();

		var CertCtl = document.getElementById("CertCtl");
		try {
			var result = CertCtl.getSAMID();
			document.getElementById("result").value = result;
		} catch (e) {}
	}
	toJson = function(str) {
		//var obj = JSON.parse(str);
		//return obj;
		return eval('(' + str + ')');
	}
	clearForm = function() {
		$(".studentName").val("");
		$(".studentSex").val(1);
		$(".studentBirth").val("");
		$(".familyAddress").val("");
		$(".studentIDCard").val("");
	}
	getStatus = function() {
		clearForm();

		var CertCtl = document.getElementById("CertCtl");
		try {
			var result = CertCtl.getStatus();
			document.getElementById("result").value = result;
		} catch (e) {}
	}
	conv2base64 = function() {
		var CertCtl = document.getElementById("CertCtl");
		try {
			var jpgPath = document.getElementById("inputJpgPath").value;
			var result;
			result = CertCtl.ConvJpgToBase64File(jpgPath);
			document.getElementById("outputBase64File").value = result;
		} catch (e) {}
	}

	convBase64ToJpg = function() {
		var CertCtl = document.getElementById("CertCtl");
		try {
			var jpgPath = document.getElementById("decodeJpgPath").value;
			var base64Data = document.getElementById("base64Input").value;
			var result;
			result = CertCtl.ConvBase64ToJpg(base64Data, jpgPath);
			alert(result);
		} catch (e) {}
	}
	if ($("#LX").attr("class") == 3) {
		$(".departmentofpediatricsIds2Div").remove();
		$(".classType1").remove();
		$(".classes1").remove();
		$(".charge").show();
		$(".numbers").remove();
		$(".numbers4").remove();
		var Time = new Date();
		var month = null;
		var dpMoneyFeecateIds = 0;
		for (var i = 0; i < $(".feecateIds2").length; i++) {
			dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
		}
		$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
		$(".integral2").val($(".dpMoney").val());
		if ((Time.getMonth() + 1) < 10) {
			month = 0 + (Time.getMonth() + 1).toString();
		} else {
			month = Time.getMonth() + 1;
		}
		$(".date2").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
		$(".startTime").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
		$(".giftName2").click(function() {
			if ($(".giftName2 option:selected").val() == 0) {
				$('.giftNumber2').attr("disabled", true);
				$(".giftNumber2").val("");
			} else {
				$('.giftNumber2').removeAttr("disabled");
				$(".giftNumber2").val(1);
			}
		});
		$(".feecateId3").click(function() {
			if ($(".feecateId3 option:selected").val() == 0) {
				$(".dpMoneyActivity").val("");
			} else {
				$(".dpMoneyActivity").val($(".dpMoney").val());
			}
		});
		$(".studentName2").val($(".studentName").val());
		$(".studentName").blur(function() {
			$(".studentName2").val($(".studentName").val());
		});
		$(".giftNumber2").blur(function() {
			if (parseInt($.trim($(".giftNumber2").val())) > parseInt($.trim($(".giftName2 option:selected").attr("name")))) {
				alert("赠品数量不足！");
				$(".giftNumber2").val(1);
			}
		});
		$(".feecateIds2").blur(function() {
			dpMoneyFeecateIds = 0;
			for (var i = 0; i < $(".feecateIds2").length; i++) {
				if ($.trim($(".feecateIds2").eq(i).val()) != "") {
					dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
				}
			}
			$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
			if ($(".feecateId3").val() == 0) {
				$(".integral2").val($(".dpMoney").val());
				$(".dpMoneyActivity").val(dpMoneyFeecateIds.toFixed(1));
			} else {
				if ($(".feecateId3 option:selected").attr("discount") == "") {
					$(".integral2").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney")));
					$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney"))).toFixed(1);
				} else {
					$(".integral2").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)));
					$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)).toFixed(1));
				}
			}

		});
		$(".feecateId3").blur(function() {
			if ($(".feecateId3").val() != 0) {
				if ($(".feecateId3 option:selected").attr("discount") == "") {
					$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney")).toFixed(1));
					$(".integral2").val($(".dpMoneyActivity").val());
				} else {
					$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)).toFixed(1));
					$(".integral2").val($(".dpMoneyActivity").val());
				}
			} else {
				$(".dpMoneyActivity").val("");
				$(".integral2").val($(".dpMoney").val());
			}
		});
		var time = null;
		$(".firstdate").blur(function() {
			if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
				var start = $(".firstdate").val();
				var end = $(".lastdate").val();
				if (start > end) {
					alert("结束时间不能在开始时间之前！");
					$(".firstdate").val("");
				} else {
					start = start.replace(/-/g, "/");
					var startdate = new Date(start);
					end = end.replace(/-/g, "/");
					var enddate = new Date(end);
					time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
					alert(time);
				}
			}
		});
		$(".lastdate").blur(function() {
			if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
				var start = $(".firstdate").val();
				var end = $(".lastdate").val();
				if (start > end) {
					alert("结束时间不能在开始时间之前！");
					$(".lastdate").val("");
				} else {
					start = start.replace(/-/g, "/");
					var startdate = new Date(start);
					end = end.replace(/-/g, "/");
					var enddate = new Date(end);
					time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
					alert(time + "天");
				}
			}
		});
		$(".TiJiao").click(function() {
			var studentName = $.trim($(".studentName").val()).toString();
			var parentName = $.trim($(".parentName").val()).toString();
			var telephone = $.trim($(".telephone").val()).toString();
			var studentBirth = $.trim($(".studentBirth").val()).toString();
			var familyAddress = $.trim($(".familyAddress").val()).toString();
			var registrationConsultant = $.trim($(".registrationConsultant").val()).toString();
			var startTime = $.trim($(".startTime").val()).toString();
			var studentSex = parseInt($.trim($(".studentSex").val()));
			var school = $.trim($(".school").val()).toString();
			var registrationChannels = $.trim($(".registrationChannels").val()).toString();
			var theSurrogate = $.trim($(".theSurrogate").val()).toString();
			var remarks = $.trim($(".remarks").val()).toString();
			var headmaster = $(".classes option:selected").attr("class");
			var studentIDCard = $.trim($(".studentIDCard").val()).toString();

			var date = $.trim($(".date2").val());
			var dpMoney = $.trim($(".dpMoneyActivity").val());
			var firstdate = $.trim($(".firstdate").val());
			var lastdate = $.trim($(".lastdate").val());
			var personliable = $.trim($(".personliable2").val());
			var remarks3 = $.trim($(".remarks3").val());
			var paymentmethodId = $.trim($(".paymentmethodId2").val());
			var integral = $.trim($(".integral2").val());
			var giftNumber = $.trim($(".giftNumber2").val());
			var giftId = $.trim($(".giftName2 option:selected").val());
			var date2 = Time.getFullYear().toString() + month.toString();
			var feecateId = "";
			var number = 0;
			var feecateMoney = "";
			var activityId = $(".feecateId3 option:selected").val();
			var teacherId = $.trim($(".teacherId2 option:selected").val());
			var EntertainTeacher = $(".EntertainTeacher").val();
			var ConsultationTeacher = $(".ConsultationTeacher").val();
			var professionalTeacher = $(".professionalTeacher").val();
			var Headmaster = $(".Headmaster").val();
			var feecateMoneyYiKao = "";
			if ($.trim($(".YDBX").val()).toString() != "") {
				feecateMoneyYiKao = feecateMoneyYiKao + ($.trim($(".YDBX").val()).toString()) + ",";
			} else {
				feecateMoneyYiKao = feecateMoneyYiKao + "0,";
			}
			if ($.trim($(".SSH").val()).toString() != "") {
				feecateMoneyYiKao = feecateMoneyYiKao + $.trim($(".SSH").val()).toString() + ",";
			} else {
				feecateMoneyYiKao = feecateMoneyYiKao + "0,";
			}
			if ($.trim($(".JRJ").val()).toString() != "") {
				feecateMoneyYiKao = feecateMoneyYiKao + $.trim($(".JRJ").val()).toString();
			} else {
				feecateMoneyYiKao = feecateMoneyYiKao + "0";
			}
			for (var i = 0; i < $(".feecateIds2").length; i++) {
				if ($(".feecateIds2").eq(i).val() != "") {
					feecateMoney = feecateMoney + "," + $(".feecateIds2").eq(i).val();
				}
			}
			var discount = null;
			if ($.trim($(".dpMoneyActivity").val()) != "" && $.trim($(".dpMoneyActivity").val()) != 0) {
				discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - $.trim($(".dpMoneyActivity").val())).toFixed(1);
			}
			feecateMoney = feecateMoney.substr(1);
			var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
			if (studentName == "" || studentBirth == "" || startTime == "" || studentIDCard == "") {
				alert("请填写 姓名- 出生日期-报名时间-身份证号！");
				return false;
			}
			for (var i = 0; i < $(".feecateIds2").length; i++) {
				if ($.trim($(".feecateIds2").eq(i).val()) != "" && $.trim($(".feecateIds2").eq(i).val()) != 0) {
					number++;
					feecateId = $.trim(feecateId + "," + $(".feecateIds2").eq(i).attr("chargeTypeId"));
				}
			}
			feecateId = feecateId.substring(1);
			if (number == 0) {
				alert("请填写至少一个收费项目！");
				return false;
			}
			if ($(".feecateId3").val() != 0) {
				if ($(".dpMoneyActivity").val() == "" || $(".dpMoneyActivity").val() == 0) {
					alert("请填写打折后金额！");
					return false;
				}
			}
			if (dpMoney == "") {
				alert("请填写收费金额！");
				return false;
			} else if (dpMoney < 1) {
				alert("请填写正确的收费金额！");
				return false;
			}
			if (firstdate == "") {
				alert("请填写起始日期！");
				return false;
			}
			if (lastdate == "") {
				alert("请填写截止日期！");
				return false;
			}
			if (personliable == "") {
				alert("请填写责任人！");
				return false;
			}
			if (giftNumber == "") {
				giftNumber = 0;
			}
			if (integral == "") {
				alert("请填写积分！");
				return false;
			}

			if (teacherId == 0) {
				teacherId = null;
			}
			if ($.trim($(".serviceCharge").val()) != "") {
				dpMoney = dpMoney + parseFloat($.trim($(".serviceCharge").val()));
			}
			telephone = telephone.toString().replace(/-/g, "");
			var serviceCharge = parseFloat($.trim($(".serviceCharge").val()));
			if ($(".serviceCharge").val() == "") {
				serviceCharge = 0;
			}
			$.ajax({
				type : "POST",
				url : "RegisterStudentsYiKao.html",
				data : {
					studentName : studentName,
					parentName : parentName,
					telephone : telephone,
					studentBirth : studentBirth,
					remarks : remarks,
					familyAddress : familyAddress,
					registrationConsultant : registrationConsultant,
					startTime : startTime,
					studentSex : studentSex,
					school : school,
					registrationChannels : registrationChannels,
					theSurrogate : theSurrogate,
					feecateId : feecateId,
					dpMoney : dpMoney,
					startTime : date,
					firstdate : firstdate,
					lastdate : lastdate,
					remarks3 : remarks3,
					paymentmethodId : paymentmethodId,
					giftId : giftId,
					giftNumber : giftNumber,
					integral : integral,
					personliable : personliable,
					hour : time,
					date : date2,
					discount : discount,
					teacherId : teacherId,
					studentIDCard : studentIDCard,
					feecateMoneyYiKao : feecateMoneyYiKao,
					feecateMoney : feecateMoney,
					startTimes : startTimes,
					activityId : activityId,
					serviceCharge : serviceCharge,
					consultationTeacher : ConsultationTeacher,
					entertainTeacher : EntertainTeacher,
					professionalTeacher : professionalTeacher,
					headmaster : Headmaster
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					if (data.add == "1") {
						alert("添加成功！");
						location.href = "StduentRegister.html";
					} else {
						alert("添加失败！");
						location.href = "StduentRegister.html";
					}
				},
				error : function(data) {
					alert("系统出错！");
					location.href = "StduentRegister.html";
				}
			});
		});
	}else {
		$(".teachers2").show();
		$(".Headmasters").remove();
		$(".professionalTeachers").remove();
	}
	$(".TiJiao").click(function() {
		if ($(".classType").val() == 0) {
			alert("请选择班级类型！");
			return false;
		}
	});
	$(".classType").click(function() {
		var classTypeId = $(".classType option:selected").val();
		if ($(".classType option:selected").attr("name") == 1) {
			$(".classType").attr("disabled", true);
			$(".charge").hide();
			$(".hour").show();
			$.ajax({
				type : "POST",
				url : "RegisterClassStudent.html",
				data : {
					classTypeId : classTypeId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".classes option").remove();
					for (var i = 0; i < data.classes.length; i++) {
						$(".classes").append("<option class='" + data.classes[i].headmaster + "' value='" + data.classes[i].classId + "' name='" + data.classes[i].departmentOfPediatrics.dpId + "' dpTypeName='" + data.classes[i].departmentOfPediatrics.dpTypeName + "' classTypeId='" + data.classes[i].departmentOfPediatrics.classTypeId + "' teacherId='" + data.classes[i].teacherId + "'>" + data.classes[i].className + "</option>");
					}
					$(".departmentofpediatricsIds").val(data.classes[0].departmentOfPediatrics.dpTypeName);

				},
				error : function(data) {
					alert("系统出错！");
					location.href = "StduentRegister.html";
				}
			});
			$(".moneys").attr("disabled", false);
			var Time = new Date();
			var month = null;
			if ((Time.getMonth() + 1) < 10) {
				month = 0 + (Time.getMonth() + 1).toString();
			} else {
				month = Time.getMonth() + 1;
			}
			$(".startTime").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
			$(".studentNames").val($(".studentName").val());
			$(".studentName").blur(function() {
				$(".studentNames").val($(".studentName").val());
			});
			if ($(".giftNames option:selected").val() == 0) {
				$('.giftNumbers').attr("disabled", true);
			}
			//			if ($(".classes option:selected").attr("classTypeId") == 1) {
			//				$(".moneys").val($(".classes option:selected").attr("dpMoney"));
			//			} else {
			//				$(".moneys").val($(".classes option:selected").attr("dpMoneyVip"));
			//			}
			$(".departmentofpediatricsIds").val($(".classes option:selected").attr("dpTypeName"));
			$(".integrals").val($(".moneys").val());
			$(".dates").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
			//			$(".hours").blur(function() {
			//								if ($(".hours").val() != 0) {
			//									if ($(".classes option:selected").attr("classTypeId") == 1) {
			//										$(".moneys").val((parseFloat($(".classes option:selected").attr("dpMoney")) * $(".hours").val()).toFixed(1));
			//										$(".integrals").val($(".moneys").val());
			//									} else {
			//										$(".moneys").val((parseFloat($(".classes option:selected").attr("dpMoneyVip")) * $(".hours").val()).toFixed(1));
			//										$(".integrals").val($(".moneys").val());
			//									}
			//				
			//								}
			//			});
			$(".numbers2").blur(function() {
				$(".schoolTimes2").remove();
				if ($(".numbers2").val() != "") {
					for (var i = 0; i < parseInt($(".numbers2").val()); i++) {
						$(".numbers").after("<div class='col-md-3 schoolTimes2'><div class='form-group mb-3'><label for='example-select'>上课时间段</label> <select class='form-control schoolTimes3' id='example-select'></select></div></div>");
					}
					for (var i = 0; i < $(".schoolTimes3").length; i++) {
						for (var j = 0; j < $(".classTimes option").length; j++) {
							$(".schoolTimes3").eq(i).append("<option value=" + $(".classTimes option").eq(j).val() + ">" + $(".classTimes option").eq(j).text() + "</option>");
						}
					}
				}
			});
			$(".giftNames").click(function() {
				if ($(".giftNames option:selected").val() == 0) {
					$('.giftNumbers').attr("disabled", true);
					$(".giftNumbers").val("");
				} else {
					$('.giftNumbers').removeAttr("disabled");
					$(".giftNumbers").val(1);
				}
			});
			$(".giftNumbers").blur(function() {
				if (parseInt($.trim($(".giftNumbers").val())) > parseInt($.trim($(".giftNames option:selected").attr("name")))) {
					alert("赠品数量不足！");
					$(".giftNumbers").val(1);
				}
			});
			$(".feecateId4").click(function() {
				if ($(".feecateId4 option:selected").val() == 0) {
					$(".dpMoneyActivity4").val("");
				} else {
					$(".dpMoneyActivity4").val($(".moneys").val());
				}
			});
			$(".moneys").blur(function() {
				if ($(".moneys").val() == "" || $(".moneys").val() < -1) {
					alert("请输入正确的金额");
					$(".moneys").val("");
					$(".dpMoneyActivity4").val("");
					if ($(".feecateId4").val() == 0) {
						$(".integrals").val("");
					} else {
						$(".dpMoneyActivity4").val("");
						$(".integrals").val($(".dpMoneyActivity4").val());
					}
				} else {
					if ($(".feecateId4").val() == 0) {
						$(".integrals").val($(".moneys").val());
						$(".dpMoneyActivity4").val($(".moneys").val());
					} else {
						if ($(".feecateId4 option:selected").attr("discount") == "") {
							$(".dpMoneyActivity4").val((parseFloat($.trim($(".moneys").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
						} else {
							$(".dpMoneyActivity4").val((parseFloat($.trim($(".moneys").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
						}
						$(".integrals").val($(".dpMoneyActivity4").val());
					}
				}
			});
			$(".feecateId4").blur(function() {
				if ($(".feecateId4").val() != 0) {
					if ($(".feecateId4 option:selected").attr("discount") == "") {
						$(".dpMoneyActivity4").val((parseFloat($.trim($(".moneys").val())) - $(".feecateId4 option:selected").attr("activityMoney")).toFixed(1));
						$(".integrals").val($(".dpMoneyActivity4").val());
					} else {
						$(".dpMoneyActivity4").val((parseFloat($.trim($(".moneys").val())) * ($(".feecateId4 option:selected").attr("discount") / 100)).toFixed(1));
						$(".integrals").val($(".dpMoneyActivity4").val());
					}
				} else {
					$(".dpMoneyActivity4").val($(".moneys").val());
					$(".integrals").val($(".moneys").val());
				}
			});
			$(".TiJiao").click(function() {
				var studentName = $.trim($(".studentName").val()).toString();
				var parentName = $.trim($(".parentName").val()).toString();
				var telephone = $.trim($(".telephone").val()).toString();
				var studentBirth = $.trim($(".studentBirth").val()).toString();
				var familyAddress = $.trim($(".familyAddress").val()).toString();
				var registrationConsultant = $.trim($(".registrationConsultant").val()).toString();
				var startTime = $.trim($(".startTime").val()).toString();
				var studentSex = parseInt($.trim($(".studentSex").val()));
				var school = $.trim($(".school").val()).toString();
				var registrationChannels = $.trim($(".registrationChannels").val()).toString();
				var theSurrogate = $.trim($(".theSurrogate").val()).toString();
				var remarks = $.trim($(".remarks").val()).toString();
				var classId = parseInt($.trim($(".classes option:selected").val()));
				var headmaster = $(".classes option:selected").attr("class");
				var studentIDCard = $.trim($(".studentIDCard").val()).toString();

				var date = $.trim($(".dates").val());
				var numbers2 = $.trim($(".numbers2").val());
				var dpMoney = $.trim($(".moneys").val());
				var hour = $.trim($(".hours").val());
				var hours = $.trim($(".hourses").val());
				var feecateId = $.trim($(".feecateIds").val());
				var date2 = Time.getFullYear().toString() + month.toString();
				var departmentofpediatricsId = $.trim($(".classes option:selected").attr("name"));
				var remarks2 = $.trim($(".remarks2").val());
				var paymentmethodId = $.trim($(".paymentmethodIds").val());
				var integral = $.trim($(".integrals").val());
				var giftNumber = $.trim($(".giftNumbers").val());
				var giftId = $.trim($(".giftNames option:selected").val());
				var teacherId = $.trim($(".teacherIds option:selected").val());
				var activityId = $.trim($(".feecateId4 option:selected").val());
				var discount = $.trim($(".dpMoneyActivity4").val());
				var EntertainTeacher = $(".EntertainTeacher").val();
				var ConsultationTeacher = $(".ConsultationTeacher").val();
				var schoolTime = "";
				var className = $(".classes option:selected").text();
				var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
				var teachers = $(".teachers option:selected").val();
				if (discount != "" && discount != 0) {
					dpMoney = (parseFloat($.trim($(".moneys").val())).toFixed(1) - discount).toFixed(1);
				}
				if($(".classes option").val() == undefined) {
					alert("暂时没有该类型班级！");
					return false;
				}
				if(teachers == undefined) {
					alert("请选择班级老师！");
					return false;
				}
				if (numbers2 == "" || numbers2 == 0) {
					alert("请填写上课次数!");
					return false;
				} else if (numbers2 > 14) {
					alert("请填写正确的上课次数！");
					return false;
				}
				for (var i = 0; i < $(".schoolTimes2").length; i++) {
					schoolTime = schoolTime + $(".schoolTimes2 option:selected").eq(i).val() + ",";
				}
				schoolTime = schoolTime.substring(0, schoolTime.length - 1);
				if (studentName == "" || studentBirth == "" || startTime == "") {
					alert("请填写 姓名-出生日期-报名时间！");
					return false;
				}
				if (discount == "") {
					alert("请填写收费金额！");
					return false;
				} else if (discount < 1) {
					alert("请填写正确的收费金额！");
					return false;
				}
				if (hour == "") {
					alert("请填写本次新增课时！");
					return false;
				} else if (hour < 1) {
					alert("请填写正确的新增课时！");
					return false;
				}
				if (hours == "") {
					hours = 0;
				}
				if (teacherId == 0) {
					teacherId = null;
				}
				if ($(".dpMoneyActivity4").val() < 0) {
					alert("请输入正确的实收金额！");
					return false;
				}

				telephone = telephone.toString().replace(/-/g, "");
				startTime = startTime + " " + Time.getHours() + ":" + Time.getMinutes();
				var serviceCharge = parseFloat($.trim($(".serviceCharges").val()));
				if ($(".serviceCharge").val() == "") {
					serviceCharge = 0;
				}
				$.ajax({
					type : "POST",
					url : "RegisterStudentsHour.html",
					data : {
						studentName : studentName,
						parentName : parentName,
						className : className,
						telephone : telephone,
						studentBirth : studentBirth,
						remarks : remarks,
						teachers : teachers,
						familyAddress : familyAddress,
						registrationConsultant : registrationConsultant,
						startTime : startTime,
						studentSex : studentSex,
						school : school,
						registrationChannels : registrationChannels,
						theSurrogate : theSurrogate,
						classId : classId,
						feecateId : feecateId,
						dpMoney : dpMoney,
						departmentofpediatricsId : departmentofpediatricsId,
						addhour : hour,
						givehour : hours,
						remarks2 : remarks2,
						paymentmethodId : paymentmethodId,
						date : date2,
						giftId : giftId,
						giftNumber : giftNumber,
						integral : integral,
						teacherId : teacherId,
						studentIDCard : studentIDCard,
						discount : discount,
						activityId : activityId,
						schoolTime : schoolTime,
						serviceCharge : serviceCharge,
						consultationTeacher : ConsultationTeacher,
						entertainTeacher : EntertainTeacher,
						headmasters : headmaster
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						if (data.add == "1") {
							alert("添加成功！");
							location.href = "StduentRegister.html";
						} else {
							alert("添加失败！");
							location.href = "StduentRegister.html";
						}
					},
					error : function(data) {
						alert("系统出错！");
						location.href = "StduentRegister.html";
					}
				});
			});
		} else if ($(".classType option:selected").attr("name") == 0) {
			if ($("#LX").attr("class") == 2) {
				var classTypeId = $(".classType option:selected").val();
				$(".integral2Div").remove();$(".JRJDiv").remove();$(".SSHDiv").remove();$(".YDBXDiv").remove();$(".giftName2Div").remove();$(".giftNumber2Div").remove();$(".feecateId3Div").remove();
				$(".classType").attr("disabled", true);
				$(".hour").hide();
				$(".charge").show();
				$(".numbers").remove();
				$.ajax({
					type : "POST",
					url : "RegisterClassStudent.html",
					data : {
						classTypeId : classTypeId
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						$(".classes option").remove();
						for (var i = 0; i < data.classes.length; i++) {
							$(".classes").append("<option class='" + data.classes[i].headmaster + "' value='" + data.classes[i].classId + "' name='" + data.classes[i].departmentOfPediatrics.dpId + "' dpTypeName='" + data.classes[i].departmentOfPediatrics.dpTypeName + "' classTypeId='" + data.classes[i].departmentOfPediatrics.classTypeId + "' teacherId='" + data.classes[i].teacherId + "'>" + data.classes[i].className + "</option>");
						}
						$(".departmentofpediatricsIds2").val(data.classes[0].departmentOfPediatrics.dpTypeName);

					},
					error : function(data) {
						alert("系统出错！");
						location.href = "StduentRegister.html";
					}
				});
				var Time = new Date();
				var month = null;
				var dpMoneyFeecateIds = 0;
				if ((Time.getMonth() + 1) < 10) {
					month = 0 + (Time.getMonth() + 1).toString();
				} else {
					month = Time.getMonth() + 1;
				}
				$(".date2").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
				$(".startTime").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
				$(".studentName2").val($(".studentName").val());
				$(".studentName").blur(function() {
					$(".studentName2").val($(".studentName").val());
				});
				var num = 0;
				$(".feecateIds2").blur(function() {
					dpMoneyFeecateIds = 0;
					for (var i = 0; i < $(".feecateIds2").length; i++) {
						if ($.trim($(".feecateIds2").eq(i).val()) != "") {
							dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
						} else {
							num = num + 1;
						}
					}
					$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
					$(".dpMoneyActivity").val(dpMoneyFeecateIds.toFixed(1));
				});
				var time = null;
				$(".firstdate").blur(function() {
					if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
						var start = $(".firstdate").val();
						var end = $(".lastdate").val();
						if (start > end) {
							alert("结束时间不能在开始时间之前！");
							$(".firstdate").val("");
						} else {
							start = start.replace(/-/g, "/");
							var startdate = new Date(start);
							end = end.replace(/-/g, "/");
							var enddate = new Date(end);
							time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
							alert(time);
						}
					}
				});
				$(".lastdate").blur(function() {
					if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
						var start = $(".firstdate").val();
						var end = $(".lastdate").val();
						if (start > end) {
							alert("结束时间不能在开始时间之前！");
							$(".lastdate").val("");
						} else {
							start = start.replace(/-/g, "/");
							var startdate = new Date(start);
							end = end.replace(/-/g, "/");
							var enddate = new Date(end);
							time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
							alert(time + "天");
						}
					}
				});
				$(".TiJiao").click(function() {
					var studentName = $.trim($(".studentName").val()).toString();
					var parentName = $.trim($(".parentName").val()).toString();
					var telephone = $.trim($(".telephone").val()).toString();
					var studentBirth = $.trim($(".studentBirth").val()).toString();
					var familyAddress = $.trim($(".familyAddress").val()).toString();
					var registrationConsultant = $.trim($(".registrationConsultant").val()).toString();
					var startTime = $.trim($(".startTime").val()).toString();
					var studentSex = parseInt($.trim($(".studentSex").val()));
					var school = $.trim($(".school").val()).toString();
					var registrationChannels = $.trim($(".registrationChannels").val()).toString();
					var theSurrogate = $.trim($(".theSurrogate").val()).toString();
					var classId = parseInt($.trim($(".classes option:selected").val()));
					var remarks = $.trim($(".remarks").val()).toString();
					var headmaster = $(".classes option:selected").attr("class");
					var studentIDCard = $.trim($(".studentIDCard").val()).toString();

					var date = $.trim($(".date2").val());
					var dpMoney = $.trim($(".dpMoney").val());
					var firstdate = $.trim($(".firstdate").val());
					var lastdate = $.trim($(".lastdate").val());
					var personliable = $.trim($(".personliable2").val());
					var remarks3 = $.trim($(".remarks3").val());
					var paymentmethodId = $.trim($(".paymentmethodId2").val());
					var date2 = Time.getFullYear().toString() + month.toString();
					var feecateId = "";
					var number = 0;
					var teacherId = $.trim($(".teacherId2 option:selected").val());
					var dpMoneyActivity4 = $.trim($(".dpMoneyActivity").val());
					var EntertainTeacher = $(".EntertainTeacher").val();
					var ConsultationTeacher = $(".ConsultationTeacher").val();
					dpMoney = dpMoney - dpMoneyActivity4;
					if($(".classes option").val() == undefined) {
						alert("暂时没有该类型班级！");
						return false;
					}
					if (studentName == "" || studentBirth == "" || startTime == "" || studentIDCard == "") {
						alert("请填写 姓名- 出生日期-报名时间-身份证号！");
						return false;
					}
					for (var i = 0; i < $(".feecateIds2").length; i++) {
						if ($.trim($(".feecateIds2").eq(i).val()) != "" && $.trim($(".feecateIds2").eq(i).val()) != 0) {
							number++;
							feecateId = $.trim(feecateId + "," + $(".feecateIds2").eq(i).attr("chargeTypeId").toString());
						}
					}
					feecateId = feecateId.substring(1);
					if (number == 0) {
						alert("请填写至少一个收费项目！");
						return false;
					}
					if (dpMoneyActivity4 == "") {
						alert("请填写收费金额！");
						return false;
					} else if (dpMoneyActivity4 < 1) {
						alert("请填写正确的收费金额！");
						return false;
					}
					if (firstdate == "") {
						alert("请填写起始日期！");
						return false;
					}
					if (lastdate == "") {
						alert("请填写截止日期！");
						return false;
					}
					if (personliable == "") {
						alert("请填写责任人！");
						return false;
					}
					if (teacherId == 0) {
						teacherId = null;
					}
					var feecateMoney = "";
					for (var i = 0; i < $(".feecateIds2").length; i++) {
						if ($(".feecateIds2").eq(i).val() != "") {
							feecateMoney = feecateMoney + "," + $(".feecateIds2").eq(i).val();
						}
					}
					feecateMoney = feecateMoney.substr(1);
					var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
					telephone = telephone.toString().replace(/-/g, "");
					startTime = startTime + " " + Time.getHours() + ":" + Time.getMinutes();
					var urls = null;
					if ($("#LX").attr("class") == 1) {
						urls = "RegisterStudentsCharge.html";
					} else if ($("#LX").attr("class") == 2) {
						urls = "RegisterStudentsCharges.html";
					}
					var serviceCharge = parseFloat($.trim($(".serviceCharge").val()));
					if ($(".serviceCharge").val() == "") {
						serviceCharge = 0;
					}
					$.ajax({
						type : "POST",
						url : urls,
						data : {
							studentName : studentName,
							parentName : parentName,
							telephone : telephone,
							studentBirth : studentBirth,
							remarks : remarks,
							familyAddress : familyAddress,
							registrationConsultant : registrationConsultant,
							startTime : startTime,
							studentSex : studentSex,
							school : school,
							registrationChannels : registrationChannels,
							theSurrogate : theSurrogate,
							classId : classId,
							feecateId : feecateId,
							dpMoney : dpMoney,
							startTime : date,
							firstdate : firstdate,
							lastdate : lastdate,
							remarks3 : remarks3,
							paymentmethodId : paymentmethodId,
							feecateMoney : feecateMoney,
							personliable : personliable,
							hour : time,
							date : date2,
							teacherId : teacherId,
							studentIDCard : studentIDCard,
							discount : dpMoneyActivity4,
							startTimes : startTimes,
							serviceCharge : serviceCharge,
							consultationTeacher : ConsultationTeacher,
							entertainTeacher : EntertainTeacher,
							headmasters : headmaster
						},
						dataType : "json",
						success : function(data) {
							data = JSON.parse(data);
							if (data.add == "1") {
								alert("添加成功！");
								location.href = "StduentRegister.html";
							} else {
								alert("添加失败！");
								location.href = "StduentRegister.html";
							}
						},
						error : function(data) {
							alert("系统出错！");
							location.href = "StduentRegister.html";
						}
					});
				});
			} else {
				var classTypeId = $(".classType option:selected").val();
				$(".JRJDiv").remove();$(".SSHDiv").remove();$(".YDBXDiv").remove();
				$(".classType").attr("disabled", true);
				$(".hour").hide();
				$(".charge").show();
				$.ajax({
					type : "POST",
					url : "RegisterClassStudent.html",
					data : {
						classTypeId : classTypeId
					},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data);
						$(".classes option").remove();
						for (var i = 0; i < data.classes.length; i++) {
							$(".classes").append("<option class='" + data.classes[i].headmaster + "' value='" + data.classes[i].classId + "' name='" + data.classes[i].departmentOfPediatrics.dpId + "' dpTypeName='" + data.classes[i].departmentOfPediatrics.dpTypeName + "' classTypeId='" + data.classes[i].departmentOfPediatrics.classTypeId + "' teacherId='" + data.classes[i].teacherId + "'>" + data.classes[i].className + "</option>");
						}
						$(".departmentofpediatricsIds2").val(data.classes[0].departmentOfPediatrics.dpTypeName);

					},
					error : function(data) {
						alert("系统出错！");
						location.href = "StduentRegister.html";
					}
				});
				var Time = new Date();
				var month = null;
				var dpMoneyFeecateIds = 0;
				for (var i = 0; i < $(".feecateIds2").length; i++) {
					dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
				}
				$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
				$(".integral2").val($(".dpMoney").val());
				if ((Time.getMonth() + 1) < 10) {
					month = 0 + (Time.getMonth() + 1).toString();
				} else {
					month = Time.getMonth() + 1;
				}
				$(".date2").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
				$(".startTime").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
				$(".giftName2").click(function() {
					if ($(".giftName2 option:selected").val() == 0) {
						$('.giftNumber2').attr("disabled", true);
						$(".giftNumber2").val("");
					} else {
						$('.giftNumber2').removeAttr("disabled");
						$(".giftNumber2").val(1);
					}
				});
				$(".feecateId3").click(function() {
					if ($(".feecateId3 option:selected").val() == 0) {
						$('.dpMoneyActivity').attr("disabled", true);
						$(".dpMoneyActivity").val("");
					} else {
						$('.dpMoneyActivity').removeAttr("disabled");
						$(".dpMoneyActivity").val($(".dpMoney").val());
					}
				});
				$(".numbers3").blur(function() {
					$(".schoolTimes2").remove();
					if ($(".numbers3").val() != "") {
						for (var i = 0; i < parseInt($(".numbers3").val()); i++) {
							$(".numbers4").after("<div class='col-md-3 schoolTimes2'><div class='form-group mb-3'><label for='example-select'>上课时间段</label> <select class='form-control schoolTimes3' id='example-select'></select></div></div>");
						}
						for (var i = 0; i < $(".schoolTimes3").length; i++) {
							for (var j = 0; j < $(".classTimes option").length; j++) {
								$(".schoolTimes3").eq(i).append("<option value=" + $(".classTimes option").eq(j).val() + ">" + $(".classTimes option").eq(j).text() + "</option>");
							}
						}
					}
				});
				$(".studentName2").val($(".studentName").val());
				$(".studentName").blur(function() {
					$(".studentName2").val($(".studentName").val());
				});
				$(".giftNumber2").blur(function() {
					if (parseInt($.trim($(".giftNumber2").val())) > parseInt($.trim($(".giftName2 option:selected").attr("name")))) {
						alert("赠品数量不足！");
						$(".giftNumber2").val(1);
					}
				});

				$(".dpMoney").blur(function() {
					if ($(".dpMoney").val() == "") {
						alert("请输入正确的金额");
						$(".dpMoney").val("");
						if ($(".feecateId3").val() == 0) {
							$(".integral2").val("");
						} else {
							$(".dpMoneyActivity").val("");
							$(".integral2").val("");
						}
					} else {
						if ($(".feecateId3").val() == 0) {
							$(".integral2").val($(".dpMoney").val());
						} else {
							if ($(".feecateId3 option:selected").attr("discount") == "") {
								$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney")).toFixed(1));
							} else {
								$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)).toFixed(1));
							}
							$(".integral2").val($(".dpMoneyActivity").val());
						}
					}
				});
				$(".feecateIds2").blur(function() {
					dpMoneyFeecateIds = 0;
					for (var i = 0; i < $(".feecateIds2").length; i++) {
						if ($.trim($(".feecateIds2").eq(i).val()) != "") {
							dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
						}
					}
					$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
					if ($(".feecateId3").val() == 0) {
						$(".integral2").val($(".dpMoney").val());
						$(".dpMoneyActivity").val(dpMoneyFeecateIds.toFixed(1));
					} else {
						if ($(".feecateId3 option:selected").attr("discount") == "") {
							$(".integral2").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney")));
							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney"))).toFixed(1);
						} else {
							$(".integral2").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)));
							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)).toFixed(1));
						}

					}
				});
				$(".feecateId3").blur(function() {
					if ($(".feecateId3").val() != 0) {
						if ($(".feecateId3 option:selected").attr("discount") == "") {
							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoney")).toFixed(1));
							$(".integral2").val($(".dpMoneyActivity").val());
						} else {
							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)).toFixed(1));
							$(".integral2").val($(".dpMoneyActivity").val());
						}
					} else {
						$(".dpMoneyActivity").val($(".dpMoney").val());
						$(".integral2").val($(".dpMoney").val());
					}
				});
				var time = null;
				$(".firstdate").blur(function() {
					if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
						var start = $(".firstdate").val();
						var end = $(".lastdate").val();
						if (start > end) {
							alert("结束时间不能在开始时间之前！");
							$(".firstdate").val("");
						} else {
							start = start.replace(/-/g, "/");
							var startdate = new Date(start);
							end = end.replace(/-/g, "/");
							var enddate = new Date(end);
							time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
							alert(time);
						}
					}
				});
				$(".lastdate").blur(function() {
					if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
						var start = $(".firstdate").val();
						var end = $(".lastdate").val();
						if (start > end) {
							alert("结束时间不能在开始时间之前！");
							$(".lastdate").val("");
						} else {
							start = start.replace(/-/g, "/");
							var startdate = new Date(start);
							end = end.replace(/-/g, "/");
							var enddate = new Date(end);
							time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
							alert(time + "天");
						}
					}
				});
				$(".TiJiao").click(function() {
					var studentName = $.trim($(".studentName").val()).toString();
					var parentName = $.trim($(".parentName").val()).toString();
					var telephone = $.trim($(".telephone").val()).toString();
					var studentBirth = $.trim($(".studentBirth").val()).toString();
					var familyAddress = $.trim($(".familyAddress").val()).toString();
					var registrationConsultant = $.trim($(".registrationConsultant").val()).toString();
					var startTime = $.trim($(".startTime").val()).toString();
					var studentSex = parseInt($.trim($(".studentSex").val()));
					var school = $.trim($(".school").val()).toString();
					var registrationChannels = $.trim($(".registrationChannels").val()).toString();
					var theSurrogate = $.trim($(".theSurrogate").val()).toString();
					var remarks = $.trim($(".remarks").val()).toString();
					var studentIDCard = $.trim($(".studentIDCard").val()).toString();

					var date = $.trim($(".date2").val());
					var dpMoney = $.trim($(".dpMoneyActivity").val());
					var firstdate = $.trim($(".firstdate").val());
					var lastdate = $.trim($(".lastdate").val());
					var personliable = $.trim($(".personliable2").val());
					var remarks3 = $.trim($(".remarks3").val());
					var paymentmethodId = $.trim($(".paymentmethodId2").val());
					var integral = $.trim($(".integral2").val());
					var giftNumber = $.trim($(".giftNumber2").val());
					var giftId = $.trim($(".giftName2 option:selected").val());
					var date2 = Time.getFullYear().toString() + month.toString();
					var feecateId = "";
					var number = 0;
					var feecateMoney = "";
					var activityId = $(".feecateId3 option:selected").val();
					var teacherId = $.trim($(".teacherId2 option:selected").val());
					var classId = parseInt($.trim($(".classes option:selected").val()));
					var headmaster = $(".classes option:selected").attr("class");
					var numbers3 = $(".numbers3").val();
					var EntertainTeacher = $(".EntertainTeacher").val();
					var ConsultationTeacher = $(".ConsultationTeacher").val();
					var schoolTime = "";
					var className = $(".classes option:selected").text();
					var teacherIds = $(".teachers option:selected").val();
					for (var i = 0; i < $(".feecateIds2").length; i++) {
						if ($(".feecateIds2").eq(i).val() != "") {
							feecateMoney = feecateMoney + "," + $(".feecateIds2").eq(i).val();
						}
					}
					var discount = null;
					if ($.trim($(".dpMoneyActivity").val()) != "" && $.trim($(".dpMoneyActivity").val()) != 0) {
						discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - $.trim($(".dpMoneyActivity").val())).toFixed(1);
					}
					feecateMoney = feecateMoney.substr(1);
					var startTimes = " " + Time.getHours() + ":" + Time.getMinutes().toString();
					if(teacherIds == undefined) {
						alert("请选择班级老师!");
						return false;
					}
					if (numbers3 == "" || numbers3 == 0) {
						alert("请填写上课次数!");
						return false;
					} else if (numbers3 > 14) {
						alert("请填写正确的上课次数！");
						return false;
					}
					for (var i = 0; i < $(".schoolTimes3").length; i++) {
						schoolTime = schoolTime + $(".schoolTimes3 option:selected").eq(i).val() + ",";
					}
					schoolTime = schoolTime.substring(0, schoolTime.length - 1);
					if($(".classes option").val() == undefined) {
						alert("暂时没有该类型班级！");
						return false;
					}
					if (studentName == "" || studentBirth == "" || startTime == "") {
						alert("请填写 姓名-出生日期-报名时间！");
						return false;
					}
					for (var i = 0; i < $(".feecateIds2").length; i++) {
						if ($.trim($(".feecateIds2").eq(i).val()) != "" && $.trim($(".feecateIds2").eq(i).val()) != 0) {
							number++;
							feecateId = $.trim(feecateId + "," + $(".feecateIds2").eq(i).attr("chargeTypeId").toString());
						}
					}
					feecateId = feecateId.substring(1);
					if (number == 0) {
						alert("请填写至少一个收费项目！");
						return false;
					}
					if ($(".feecateId3").val() != 0) {
						if ($(".dpMoneyActivity").val() == "" || $(".dpMoneyActivity").val() == 0) {
							alert("请填写打折后金额！");
							return false;
						}
					}
					if (dpMoney == "") {
						alert("请填写收费金额！");
						return false;
					} else if (dpMoney < 1) {
						alert("请填写正确的收费金额！");
						return false;
					}
					if (firstdate == "") {
						alert("请填写起始日期！");
						return false;
					}
					if (lastdate == "") {
						alert("请填写截止日期！");
						return false;
					}
					if (personliable == "") {
						alert("请填写责任人！");
						return false;
					}
					if (giftNumber == "") {
						giftNumber = 0;
					}
					if (integral == "") {
						alert("请填写积分！");
						return false;
					}

					if (teacherId == 0) {
						teacherId = null;
					}
					telephone = telephone.toString().replace(/-/g, "");
					var serviceCharge = parseFloat($.trim($(".serviceCharge").val()));
					if ($(".serviceCharge").val() == "") {
						serviceCharge = 0;
					}
					$.ajax({
						type : "POST",
						url : "RegisterStudentsCharge.html",
						data : {
							studentName : studentName,
							parentName : parentName,
							telephone : telephone,
							className : className,
							studentBirth : studentBirth,
							remarks : remarks,
							familyAddress : familyAddress,
							registrationConsultant : registrationConsultant,
							startTime : startTime,
							studentSex : studentSex,
							school : school,
							registrationChannels : registrationChannels,
							theSurrogate : theSurrogate,
							feecateId : feecateId,
							dpMoney : dpMoney,
							firstdate : firstdate,
							lastdate : lastdate,
							remarks3 : remarks3,
							paymentmethodId : paymentmethodId,
							giftId : giftId,
							giftNumber : giftNumber,
							integral : integral,
							personliable : personliable,
							hour : time,
							date : date2,
							discount : discount,
							teacherId : teacherId,
							teacherIds : teacherIds,
							studentIDCard : studentIDCard,
							feecateMoney : feecateMoney,
							startTimes : startTimes,
							activityId : activityId,
							classId : classId,
							schoolTime : schoolTime,
							serviceCharge : serviceCharge,
							consultationTeacher : ConsultationTeacher,
							entertainTeacher : EntertainTeacher,
							headmasters : headmaster
						},
						dataType : "json",
						success : function(data) {
							data = JSON.parse(data);
							if (data.add == "1") {
								alert("添加成功！");
								location.href = "StduentRegister.html";
							} else {
								alert("添加失败！");
								location.href = "StduentRegister.html";
							}
						},
						error : function(data) {
							alert("系统出错！");
							location.href = "StduentRegister.html";
						}
					});
				});
			//				var Time = new Date();
			//				var month = null;
			//				var dpMoneyFeecateIds = 0;
			//				for (var i = 0; i < $(".feecateIds2").length; i++) {
			//					dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
			//				}
			//				$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
			//				$(".integral2").val($(".dpMoney").val());
			//				if ((Time.getMonth() + 1) < 10) {
			//					month = 0 + (Time.getMonth() + 1).toString();
			//				} else {
			//					month = Time.getMonth() + 1;
			//				}
			//				$(".date2").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
			//				$(".giftName2").click(function() {
			//					if ($(".giftName2 option:selected").val() == 0) {
			//						$('.giftNumber2').attr("disabled", true);
			//						$(".giftNumber2").val("");
			//					} else {
			//						$('.giftNumber2').removeAttr("disabled");
			//						$(".giftNumber2").val(1);
			//					}
			//				});
			//				$(".feecateId3").click(function() {
			//					if ($(".feecateId3 option:selected").val() == 0) {
			//						$('.dpMoneyActivity').attr("disabled", true);
			//						$(".dpMoneyActivity").val("");
			//					} else {
			//						$('.dpMoneyActivity').removeAttr("disabled");
			//						$(".dpMoneyActivity").val($(".dpMoney").val());
			//					}
			//				});
			//				$(".studentName2").val($(".studentName").val());
			//				$(".studentName").blur(function() {
			//					$(".studentName2").val($(".studentName").val());
			//				});
			//				$(".giftNumber2").blur(function() {
			//					if (parseInt($.trim($(".giftNumber2").val())) > parseInt($.trim($(".giftName2 option:selected").attr("name")))) {
			//						alert("赠品数量不足！");
			//						$(".giftNumber2").val(1);
			//					}
			//				});
			//				$(".dpMoney").blur(function() {
			//					if ($(".dpMoney").val() == "") {
			//						alert("请输入正确的金额");
			//						$(".dpMoney").val("");
			//						if ($(".feecateId3").val() == 0) {
			//							$(".integral2").val("");
			//						} else {
			//							$(".dpMoneyActivity").val("");
			//							$(".integral2").val("");
			//						}
			//					} else {
			//						if ($(".feecateId3").val() == 0) {
			//							$(".integral2").val($(".dpMoney").val());
			//						} else {
			//							if ($(".feecateId3 option:selected").attr("discount") == "") {
			//								$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoneylast")).toFixed(1));
			//							} else {
			//								$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("activityMoneylast") / 100)).toFixed(1));
			//							}
			//							$(".integral2").val($(".dpMoneyActivity").val());
			//						}
			//					}
			//				});
			//				$(".feecateIds2").blur(function() {
			//					dpMoneyFeecateIds = 0;
			//					for (var i = 0; i < $(".feecateIds2").length; i++) {
			//						if ($.trim($(".feecateIds2").eq(i).val()) != "") {
			//							dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
			//						}
			//					}
			//					$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
			//					if ($(".feecateId3").val() == 0) {
			//						$(".integral2").val($(".dpMoney").val());
			//					} else {
			//						if ($(".feecateId3 option:selected").attr("discount") == "") {
			//							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoneylast"))).toFixed(1);
			//						} else {
			//							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("activityMoneylast") / 100)).toFixed(1));
			//						}
			//						$(".integral2").val($(".dpMoneyActivity").val());
			//					}
			//				});
			//				$(".feecateId3").blur(function() {
			//					if ($(".feecateId3").val() != 0) {
			//						if ($(".feecateId3 option:selected").attr("discount") == "") {
			//							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoneylast")).toFixed(1));
			//							$(".integral2").val($(".dpMoneyActivity").val());
			//						} else {
			//							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount") / 100)).toFixed(1));
			//							$(".integral2").val($(".dpMoneyActivity").val());
			//						}
			//					} else {
			//						$(".dpMoneyActivity").val("");
			//						$(".integral2").val($(".dpMoney").val());
			//					}
			//				});
			//				var time = null;
			//				$(".firstdate").blur(function() {
			//					if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
			//						var start = $(".firstdate").val();
			//						var end = $(".lastdate").val();
			//						if (start > end) {
			//							alert("结束时间不能在开始时间之前！");
			//							$(".firstdate").val("");
			//						} else {
			//							start = start.replace(/-/g, "/");
			//							var startdate = new Date(start);
			//							end = end.replace(/-/g, "/");
			//							var enddate = new Date(end);
			//							time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
			//							alert(time);
			//						}
			//					}
			//				});
			//				$(".lastdate").blur(function() {
			//					if ($(".firstdate").val() != "" && $(".lastdate").val() != "") {
			//						var start = $(".firstdate").val();
			//						var end = $(".lastdate").val();
			//						if (start > end) {
			//							alert("结束时间不能在开始时间之前！");
			//							$(".lastdate").val("");
			//						} else {
			//							start = start.replace(/-/g, "/");
			//							var startdate = new Date(start);
			//							end = end.replace(/-/g, "/");
			//							var enddate = new Date(end);
			//							time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
			//							alert(time + "天");
			//						}
			//					}
			//				});
			//				$(".TiJiao").click(function() {
			//					var studentName = $.trim($(".studentName").val()).toString();
			//					var parentName = $.trim($(".parentName").val()).toString();
			//					var telephone = $.trim($(".telephone").val()).toString();
			//					var studentBirth = $.trim($(".studentBirth").val()).toString();
			//					var familyAddress = $.trim($(".familyAddress").val()).toString();
			//					var registrationConsultant = $.trim($(".registrationConsultant").val()).toString();
			//					var startTime = $.trim($(".startTime").val()).toString();
			//					var studentSex = parseInt($.trim($(".studentSex").val()));
			//					var school = $.trim($(".school").val()).toString();
			//					var registrationChannels = $.trim($(".registrationChannels").val()).toString();
			//					var theSurrogate = $.trim($(".theSurrogate").val()).toString();
			//					var classId = parseInt($.trim($(".classes option:selected").val()));
			//					var remarks = $.trim($(".remarks").val()).toString();
			//					var headmaster = $(".classes option:selected").attr("class");
			//					var studentIDCard = $.trim($(".studentIDCard").val()).toString();
			//
			//					var date = $.trim($(".date2").val());
			//					var dpMoney = $.trim($(".dpMoney").val());
			//					var firstdate = $.trim($(".firstdate").val());
			//					var lastdate = $.trim($(".lastdate").val());
			//					var personliable = $.trim($(".personliable2").val());
			//					var remarks3 = $.trim($(".remarks3").val());
			//					var paymentmethodId = $.trim($(".paymentmethodId2").val());
			//					var integral = $.trim($(".integral2").val());
			//					var giftNumber = $.trim($(".giftNumber2").val());
			//					var giftId = $.trim($(".giftName2 option:selected").val());
			//					var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
			//					var feecateId = "";
			//					var number = 0;
			//					var teacherId = $.trim($(".teacherId2 option:selected").val());
			//
			//					if (studentName == "" || parentName == "" || telephone == "" || studentBirth == "" || familyAddress == "" ||
			//						registrationConsultant == "" || registrationConsultant == "" || startTime == "" || studentIDCard == "") {
			//						alert("请填写 姓名- 父/母姓名-手机号-出生日期-家庭住址-报名老师-报名时间-身份证号！");
			//						return false;
			//					}
			//					for (var i = 0; i < $(".feecateIds2").length; i++) {
			//						if ($.trim($(".feecateIds2").eq(i).val()) != "" && $.trim($(".feecateIds2").eq(i).val()) != 0) {
			//							number++;
			//							feecateId = $.trim(feecateId + "," + $(".feecateIds2").eq(i).attr("chargeTypeId").toString());
			//						}
			//					}
			//					feecateId = feecateId.substring(1);
			//					if (number == 0) {
			//						alert("请填写至少一个收费项目！");
			//						return false;
			//					}
			//					if ($(".feecateId3").val() != 0) {
			//						if ($(".dpMoneyActivity").val() == "" || $(".dpMoneyActivity").val() == 0) {
			//							alert("请填写打折后金额！");
			//							return false;
			//						}
			//					}
			//					if (dpMoney == "") {
			//						alert("请填写收费金额！");
			//						return false;
			//					} else if (dpMoney < 1) {
			//						alert("请填写正确的收费金额！");
			//						return false;
			//					}
			//					if (firstdate == "") {
			//						alert("请填写起始日期！");
			//						return false;
			//					}
			//					if (lastdate == "") {
			//						alert("请填写截止日期！");
			//						return false;
			//					}
			//					if (personliable == "") {
			//						alert("请填写责任人！");
			//						return false;
			//					}
			//					if (giftNumber == "") {
			//						giftNumber = 0;
			//					}
			//					if (integral == "") {
			//						alert("请填写积分！");
			//						return false;
			//					}
			//					if ($(".dpMoneyActivity").val() != "" && $(".dpMoneyActivity").val() != 0) {
			//						dpMoney = parseFloat($.trim($(".dpMoneyActivity").val())).toFixed(1);
			//					}
			//					var discount = null;
			//					if ($.trim($(".dpMoneyActivity").val()) != "" && $.trim($(".dpMoneyActivity").val()) != 0) {
			//						discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - dpMoney).toFixed(1);
			//					}
			//					if (teacherId == 0) {
			//						teacherId = null;
			//					}
			//
			//					telephone = telephone.toString().replace(/-/g, "");
			//					startTime = startTime + " " + Time.getHours() + ":" + Time.getMinutes();
			//					var urls = null;
			//					if ($("#LX").attr("class") == 1) {
			//						urls = "RegisterStudentsCharge.html";
			//					} else if ($("#LX").attr("class") == 2) {
			//						urls = "RegisterStudentsCharges.html";
			//					}
			//					$.ajax({
			//						type : "POST",
			//						url : urls,
			//						data : {
			//							studentName : studentName,
			//							parentName : parentName,
			//							telephone : telephone,
			//							studentBirth : studentBirth,
			//							remarks : remarks,
			//							familyAddress : familyAddress,
			//							registrationConsultant : registrationConsultant,
			//							startTime : startTime,
			//							studentSex : studentSex,
			//							school : school,
			//							registrationChannels : registrationChannels,
			//							theSurrogate : theSurrogate,
			//							classId : classId,
			//							headmaster : headmaster,
			//							feecateId : feecateId,
			//							dpMoney : dpMoney,
			//							startTime : date,
			//							firstdate : firstdate,
			//							lastdate : lastdate,
			//							remarks3 : remarks3,
			//							paymentmethodId : paymentmethodId,
			//							giftId : giftId,
			//							giftNumber : giftNumber,
			//							integral : integral,
			//							personliable : personliable,
			//							hour : time,
			//							date : date2,
			//							discount : discount,
			//							teacherId : teacherId,
			//							studentIDCard : studentIDCard
			//						},
			//						dataType : "json",
			//						success : function(data) {
			//							data = JSON.parse(data);
			//							if (data.add == "1") {
			//								alert("添加成功！");
			//								location.href = "StduentRegister.html";
			//							} else {
			//								alert("添加失败！");
			//								location.href = "StduentRegister.html";
			//							}
			//						},
			//						error : function(data) {
			//							alert("系统出错！");
			//							location.href = "StduentRegister.html";
			//						}
			//					});
			//				});
			}

		} else if ($(".classType").val() == 0) {
			$(".charge").hide();
			$(".hour").hide();
		}

	});

});