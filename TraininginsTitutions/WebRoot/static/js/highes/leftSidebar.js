$(function(){
	/**
	 * 跳转到账户信息的页面
	 */
	Accountinformation = function(){
		location.href="Accountinformation.html";
	}
	/**
	 * 跳转到收入的页面
	 */
	Incomeitems = function(){
		location.href="Incomeitems.html";
	}
	/**
	 * 跳转到支出的页面
	 */
	Expenditureitemses = function(){
		location.href="Expenditureitemses.html";
	}
	/**
	 * 跳转到教师信息的页面
	 */
	Teacher = function(){
		location.href="Teacher.html";
	}
	ChargeHours = function(){
		location.href="selectOrderHour.html";
	}
	ChargePeriod = function(){
		location.href="selectOrderPeriod.html";
	}
	ChargeOthers = function(){
		location.href="selectOrderOthers.html";
	}
	Expenditure = function(){
		location.href="selectOrderExpenditure.html";
	}
	/**
	 * 复选框单击选中取消事件
	 */
	$(".customCheck").click(function() {
		if($(this).prev().prop("checked")) {
			$(this).prev().prop("checked", false);
		}else {
			$(this).prev().prop("checked", true);
		}
	});
});