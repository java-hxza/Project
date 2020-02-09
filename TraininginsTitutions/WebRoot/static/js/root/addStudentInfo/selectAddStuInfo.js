$(function(){
	
	// 格式化日期，如月、日、时、分、秒保证为2位数
	function formatNumber (n) {
	    n = n.toString()
	    return n[1] ? n : '0' + n;
	}
	// 参数number为毫秒时间戳，format为需要转换成的日期格式
	function formatTime (number, format) {
	    let time = new Date(number)
	    let newArr = []
	    let formatArr = ['Y', 'M', 'D', 'h', 'm', 's']
	    newArr.push(time.getFullYear())
	    newArr.push(formatNumber(time.getMonth() + 1))
	    newArr.push(formatNumber(time.getDate()))

	    newArr.push(formatNumber(time.getHours()))
	    newArr.push(formatNumber(time.getMinutes()))
	    newArr.push(formatNumber(time.getSeconds()))

	    for (let i in newArr) {
	        format = format.replace(formatArr[i], newArr[i])
	    }
	    return format;
	}
	
	
	$(".schoolId").unbind("click").click(function(){
		var schoolId = $(this).children().next().children().html();
		var schoolName = $(this).children().next().next().children().html();
		var schoolType = $(this).children("td:last-child").children().attr("name");
		var startTime = formatTime(new Date(), 'Y-M-D h:m:s');
		var endTime = formatTime(new Date(), 'Y-M-D h:m:s');
		if(schoolType == 1){
			location.href="childrenAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		if(schoolType == 2){
			location.href="highAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		if(schoolType == 3){
			location.href="yiKaoAddStudentInfo.html?schoolId="+schoolId+"&schoolName="+schoolName+"&startTime="+startTime+"&endTime="+endTime+"&schoolType="+schoolType;
		}
		
	});
	
	query = function(){
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		//判断时间是都空值
		if(startTime == '' || startTime == null){
			startTime = new Date();
		}
		if(endTime == '' || endTime == null){
			endTime = new Date();
		}
		if(startTime != '' || startTime != null){
			startTime = formatTime(startTime, 'Y-M-D h:m:s');
		}
		if(endTime != '' || endTime != null){
			endTime = formatTime(endTime, 'Y-M-D h:m:s');
		}
		
		location.href = "schoolAddStudentInfo.html?startTime="+startTime+"&endTime="+endTime;
	
	}
});