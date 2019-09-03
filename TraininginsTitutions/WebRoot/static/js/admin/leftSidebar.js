$(function(){
	/**
	 * 学校账户信息
	 */
	AdminSchoolListInfo = function(){
		location.href ="adminIndex.html";
	}
	/**
	 * 教师信息页面跳转
	 */
	AdminTeacherInto = function(){
		location.href="selectSchoolTeacherInfo.html";
	}
	
	/**
	 * 操作员页面跳转
	 */
	AdminOperatorChilk = function(){
		location.href="operator.html";
	}
	
	AdminSelectOrderSchoolInfo = function(){
		location.href="selectOrderSchoolInfo.html";
	}
	
	/**
	 * 教师课时页面跳转
	 */
	AdminTeacherHour = function(){
		location.href="selectOrderTeacherInfo.html";
	}
	
	/**
	 * 学员课时页面跳转
	 */
	AdminStudentHour = function(){
		location.href = "selectClassSchoolInfo.html";
	}
	/**
	 * 新增学员报表
	 */
	AdminAddStudent = function(){
		location.href = "selectAddStuInfo.html";
	} 
	/**
	 * 返回教师上课明细
	 */
	AdminTeacherClassHour = function(){
		location.href ="selectSchoolTeacherClassHourInfo.html";
	}
	
	/**
	 * 返回学生收费情况表
	 */
	AdminStudentFeeInfo = function(){
		location.href ="selectStudentFeeInfo.html";
	}
	
});