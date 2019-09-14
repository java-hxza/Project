$(function() {

	$(".classType").click(function() {
		var classType = 0;
		var classTypeId = 0;
		if ($(".classType").val() == 1 || $(".classType").val() == 2) {
			if ($(".classType").val() == 1) {
				classType = 0;
				classTypeId = 1;
			} else {
				classType = 0;
				classTypeId = 2;
			}
			$(".classType").attr("disabled", true);
			$(".charge").hide();
			$(".hour").show();
			$.ajax({
				type : "POST",
				url : "RegisterClassStudent.html",
				data : {
					classType : classType,
					classTypeId : classTypeId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".classes option").remove();
					for (var i = 0; i < data.classes.length; i++) {
						$(".classes").append("<option class='" + data.classes[i].headmaster + "' value='" + data.classes[i].classId + "' name='" + data.classes[i].departmentOfPediatrics.dpId + "' dpTypeName='" + data.classes[i].departmentOfPediatrics.dpTypeName + "' dpMoney='" + data.classes[i].departmentOfPediatrics.dpMoney + "' dpMoneyVip='" + data.classes[i].departmentOfPediatrics.dpMoneyVip + "' classTypeId='" + data.classes[i].departmentOfPediatrics.classTypeId + "'>" + data.classes[i].className + "</option>");
					}

				},
				error : function(data) {
					alert("系统出错！");
					location.href = "StduentRegister.html";
				}
			});
			var Time = new Date();
			var month = null;
			if ((Time.getMonth() + 1) < 10) {
				month = 0 + (Time.getMonth() + 1).toString();
			} else {
				month = Time.getMonth() + 1;
			}
			$(".studentNames").val($(".studentName").val());
			$(".studentName").blur(function() {
				$(".studentNames").val($(".studentName").val());
			});
			if ($(".giftNames option:selected").val() == 0) {
				$('.giftNumbers').attr("disabled", true);
			}
			if ($(".classes option:selected").attr("classTypeId") == 1) {
				$(".moneys").val($(".classes option:selected").attr("dpMoney"));
			} else {
				$(".moneys").val($(".classes option:selected").attr("dpMoneyVip"));
			}
			$(".departmentofpediatricsIds").val($(".classes option:selected").attr("dpTypeName"));
			$(".integrals").val($(".moneys").val());
			$(".dates").val(Time.getFullYear() + "-" + month + "-" + Time.getDate());
			$(".hours").blur(function() {
				if ($(".hours").val() != 0) {
					if ($(".classes option:selected").attr("classTypeId") == 1) {
						$(".moneys").val((parseFloat($(".classes option:selected").attr("dpMoney")) * $(".hours").val()).toFixed(1));
						$(".integrals").val($(".moneys").val());
					} else {
						$(".moneys").val((parseFloat($(".classes option:selected").attr("dpMoneyVip")) * $(".hours").val()).toFixed(1));
						$(".integrals").val($(".moneys").val());
					}

				}
			});
			$(".moneys").blur(function() {
				if ($(".moneys").val() == "") {
					alert("请输入正确的金额");
					$(".moneys").val("");
				}
				$(".integrals").val($(".moneys").val());
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

				var date = $.trim($(".dates").val());
				var dpMoney = $.trim($(".moneys").val());
				var hour = $.trim($(".hours").val());
				var hours = $.trim($(".hourses").val());
				var feecateId = $.trim($(".feecateIds").val());
				var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
				var departmentofpediatricsId = $.trim($(".classes option:selected").attr("name"));
				var remarks2 = $.trim($(".remarks2").val());
				var paymentmethodId = $.trim($(".paymentmethodIds").val());
				var integral = $.trim($(".integrals").val());
				var giftNumber = $.trim($(".giftNumbers").val());
				var giftId = $.trim($(".giftNames option:selected").val());
				var teacherId = $.trim($(".teacherIds option:selected").val());

				if (studentName == "" || parentName == "" || telephone == "" || studentBirth == "" || familyAddress == "" ||
					registrationConsultant == "" || registrationConsultant == "" || startTime == "" || studentIDCard == "") {
					alert("请填写 姓名- 父/母姓名-手机号-出生日期-家庭住址-报名老师-报名时间-身份证号！");
					return false;
				}

				if (dpMoney == "") {
					alert("请填写收费金额！");
					return false;
				} else if (dpMoney < 1) {
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
					alert("请选择招生老师！");
					return false;
				}

				telephone = telephone.toString().replace(/-/g, "");
				$.ajax({
					type : "POST",
					url : "RegisterStudentsHour.html",
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
						headmaster : headmaster,
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
						studentIDCard : studentIDCard
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
		} else if ($(".classType").val() == 3 || $(".classType").val() == 4) {
			if ($(".classType").val() == 3) {
				classType = 1;
				classTypeId = 1;
			} else {
				classType = 1;
				classTypeId = 2;
			}
			$(".classType").attr("disabled", true);
			$(".charge").show();
			$(".hour").hide();
			$.ajax({
				type : "POST",
				url : "RegisterClassStudent.html",
				data : {
					classType : classType,
					classTypeId : classTypeId
				},
				dataType : "json",
				success : function(data) {
					data = JSON.parse(data);
					$(".classes option").remove();
					for (var i = 0; i < data.classes.length; i++) {
						$(".classes").append("<option class='" + data.classes[i].headmaster + "' value='" + data.classes[i].classId + "' name='" + data.classes[i].departmentOfPediatrics.dpId + "' dpTypeName='" + data.classes[i].departmentOfPediatrics.dpTypeName + "' dpMoney='" + data.classes[i].departmentOfPediatrics.dpMoney + "' dpMoneyVip='" + data.classes[i].departmentOfPediatrics.dpMoneyVip + "' classTypeId='" + data.classes[i].departmentOfPediatrics.classTypeId + "'>" + data.classes[i].className + "</option>");
					}

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
				if($(".dpMoney").val() == "") {
					alert("请输入正确的金额");
					$(".dpMoney").val("");
					if($(".feecateId3").val() == 0) {
						$(".integral2").val("");
					}else {
						$(".dpMoneyActivity").val("");
						$(".integral2").val("");
					}
				}else {
					if($(".feecateId3").val() == 0) {
						$(".integral2").val($(".dpMoney").val());
					}else {
						if($(".feecateId3 option:selected").attr("discount") == "") {
							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoneylast")).toFixed(1));
						}else {
							$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("activityMoneylast")/100)).toFixed(1));
						}
						$(".integral2").val($(".dpMoneyActivity").val());
					}
				}
			});
			$(".feecateIds2").blur(function() {
				dpMoneyFeecateIds = 0;
				for (var i = 0; i < $(".feecateIds2").length; i++) {
					if($.trim($(".feecateIds2").eq(i).val()) != "") {
						dpMoneyFeecateIds = dpMoneyFeecateIds + parseFloat($.trim($(".feecateIds2").eq(i).val()));
					}
				}
				$(".dpMoney").val(dpMoneyFeecateIds.toFixed(1));
				if($(".feecateId3").val() == 0) {
					$(".integral2").val($(".dpMoney").val());
				}else {
					if($(".feecateId3 option:selected").attr("discount") == "") {
						$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoneylast"))).toFixed(1);
					}else {
						$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("activityMoneylast")/100)).toFixed(1));
					}
					$(".integral2").val($(".dpMoneyActivity").val());
				}
			});
			$(".feecateId3").blur(function() {
				if($(".feecateId3").val() != 0) {
					if($(".feecateId3 option:selected").attr("discount") == "") {
						$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) - $(".feecateId3 option:selected").attr("activityMoneylast")).toFixed(1));
						$(".integral2").val($(".dpMoneyActivity").val());
					}else {
						$(".dpMoneyActivity").val((parseFloat($.trim($(".dpMoney").val())) * ($(".feecateId3 option:selected").attr("discount")/100)).toFixed(1));
						$(".integral2").val($(".dpMoneyActivity").val());
					}
				}else {
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
					}else {
						start = start.replace(/-/g, "/");
						var startdate = new Date(start);
						end = end.replace(/-/g, "/");
						var enddate = new Date(end);
						time = parseInt((enddate.getTime() - startdate.getTime())/(1000 * 60 * 60 * 24));
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
					}else {
						start = start.replace(/-/g, "/");
						var startdate = new Date(start);
						end = end.replace(/-/g, "/");
						var enddate = new Date(end);
						time = parseInt((enddate.getTime() - startdate.getTime())/(1000 * 60 * 60 * 24));
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
				var integral = $.trim($(".integral2").val());
				var giftNumber = $.trim($(".giftNumber2").val());
				var giftId = $.trim($(".giftName2 option:selected").val());
				var date2 = Time.getFullYear().toString() + month.toString() + Time.getDate().toString();
				var feecateId = "";
				var number = 0;
				var teacherId = $.trim($(".teacherId2 option:selected").val());

				if (studentName == "" || parentName == "" || telephone == "" || studentBirth == "" || familyAddress == "" ||
					registrationConsultant == "" || registrationConsultant == "" || startTime == "" || studentIDCard == "") {
					alert("请填写 姓名- 父/母姓名-手机号-出生日期-家庭住址-报名老师-报名时间-身份证号！");
					return false;
				}
				for (var i = 0; i < $(".feecateIds2").length; i++) {
					if($.trim($(".feecateIds2").eq(i).val()) != "" && $.trim($(".feecateIds2").eq(i).val()) != 0) {
						number++;
						feecateId = $.trim(feecateId + "," +  $(".feecateIds2").eq(i).attr("chargeTypeId").toString());
					}
				}
				feecateId = feecateId.substring(1);
				if(number == 0) {
					alert("请填写至少一个收费项目！");
					return false;
				}
				if($(".feecateId3").val() != 0) {
					if($(".dpMoneyActivity").val() == "" || $(".dpMoneyActivity").val() == 0) {
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
				if(lastdate == "") {
					alert("请填写截止日期！");
					return false;
				}
				if (personliable == "") {
					alert("请填写责任人！");
					return false;
				}
				if(giftNumber == "") {
					giftNumber = 0;
				}
				if(integral == "") {
					alert("请填写积分！");
					return false;
				}
				if($(".dpMoneyActivity").val() != "" && $(".dpMoneyActivity").val() != 0) {
					dpMoney = parseFloat($.trim($(".dpMoneyActivity").val())).toFixed(1);
				}
				var discount = null;
				if($.trim($(".dpMoneyActivity").val()) != "" && $.trim($(".dpMoneyActivity").val()) != 0) {
					discount = (parseFloat($.trim($(".dpMoney").val())).toFixed(1) - dpMoney).toFixed(1);
				}
				if (teacherId == 0) {
					alert("请选择招生老师！");
					return false;
				}

				telephone = telephone.toString().replace(/-/g, "");
				$.ajax({
					type : "POST",
					url : "RegisterStudentsCharge.html",
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
						headmaster : headmaster,
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
						studentIDCard : studentIDCard
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
		}else if($(".classType").val() == 0) {
			$(".charge").hide();
			$(".hour").hide();
		}

	});

});