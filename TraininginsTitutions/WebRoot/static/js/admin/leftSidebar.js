$(function(){
	/**
	 * 学校账户信息
	 */
	schoolListInfo = function(){
		location.href ="adminIndex.html";
	}
	/**
	 * 教师信息页面跳转
	 */
	teacherInto = function(){
		location.href="selectSchoolTeacherInfo.html";
	}
	
	/**
	 * 操作员页面跳转
	 */
	operatorChilk = function(){
		location.href="operator.html";
	}
	
	selectOrderSchoolInfo = function(){
		location.href="selectOrderSchoolInfo.html";
	}
	
	/**
	 * 教师课时页面跳转
	 */
	teacherHour = function(){
		location.href="selectOrderTeacherInfo.html";
	}
	
	/**
	 * 学员课时页面跳转
	 */
	studentHour = function(){
		location.href = "selectClassSchoolInfo.html";
	}
	/**
	 * 新增学员报表
	 */
	addStudent = function(){
		location.href = "selectAddStuInfo.html";
	} 
	/**
	 * 返回教师上课明细
	 */
	teacherClassHour = function(){
		location.href ="selectSchoolTeacherClassHourInfo.html";
	}
	
	/**
	 * 返回学生收费情况表
	 */
	studentFeeInfo = function(){
		location.href ="selectStudentFeeInfo.html";
	}
	
});