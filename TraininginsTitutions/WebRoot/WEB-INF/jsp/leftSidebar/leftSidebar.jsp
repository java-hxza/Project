<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="left-side-menu" style="background: #344451;">

	<!-- LOGO -->
	<a href="index.html" class="logo text-center"> <span
		class="logo-lg"> <c:choose>
				<c:when test="${schoolType == 1 }">
					<img src="${Path }/static/images/logo.gif" alt="" width="50%"
						height="30px">
				</c:when>
				<c:otherwise>
					<img src="${Path }/static/images/LOGO(1).jpg"  alt="" width="50%"
						height="20%">
				</c:otherwise>
			</c:choose>
	</span>  
	</a>
	
	
	<!--- Sidemenu -->
	<ul class="metismenu side-nav">
	<c:choose>
		<c:when test="${schoolType != 1 }">
			<p id="logo" style="position: relative; top: -40px; left: 60px">同心同慧教育集团</p>
		</c:when>
		</c:choose>
		<li class="side-nav-title side-nav-item">导航</li>

		<li class="side-nav-item"><a href="javascript: void(0);"
			class="side-nav-link"> <i class="mdi mdi-zip-box"></i> <span
				class="badge badge-success float-right">8</span> <span>校区信息 </span>
		</a>
			<ul class="side-nav-second-level" aria-expanded="false">
				<li><a href="javascript:void(0)" onclick="Accountinformation()">账户信息</a></li>
				<li><a href="javascript:void(0)" onclick="Incomeitems()">收入项目</a></li>
				<li><a href="javascript:void(0)" onclick="Expenditureitemses()">支出项目</a></li>
				<li><a href="javascript:void(0)" onclick="Teacher()">教师信息</a></li>
				<c:if test="${schoolType == 1 }">
					<li><a href="javascript:void(0)"
						onclick="curriculumClassInfo()">课程信息</a></li>
				</c:if>
				<li><a href="javascript:void(0)" onclick="classInfo()">班级信息</a></li>
				<li><a href="javascript:void(0)" onclick="classInfo()">学生信息</a></li>
			</ul></li>
		<li class="side-nav-item"><a href="javascript: void(0);"
			class="side-nav-link"> <i class="mdi mdi-xing-box"></i> <span>
					班级管理</span> <span class="menu-arrow"></span>
		</a>
			<ul class="side-nav-second-level" aria-expanded="false">
				<li><a href="javascript:void(0)" onclick="classTypes()">班级类型管理
				</a></li>
				<li><a href="javascript:void(0)" onclick="classInfo()">学生信息管理
				</a></li>
				<li><a href="javascript:void(0)" onclick="classTypeInfo()">学生科别管理
				</a></li>
				<c:if test="${schoolType == 3 }">
					<li><a href="javascript:void(0)" onclick="assignment()">学生班级管理
							-->分班</a></li>
				</c:if>
				<c:if test="${schoolType == 1 }">
					<li><a href="javascript:void(0)" onclick="classInfo()">上课登记</a></li>
					<li><a href="javascript:void(0)" onclick="classInfo()">上课批量登记</a></li>
				</c:if>
				<li><a href="javascript:void(0)" onclick="classInfo()">学生退学
				</a></li>
				<li><a href="javascript:void(0)" onclick="studentLeave()">学生请假
				</a></li>
				<li><a href="javascript:void(0)" onclick="studentGraduation()">学生结业
				</a></li>
			</ul></li>


		<li class="side-nav-item"><a href="javascript: void(0);"
			class="side-nav-link"> <i class=" mdi mdi-yahoo"></i> <span>
					培训收款 </span> <span class="menu-arrow"></span>
		</a>
			<ul class="side-nav-second-level" aria-expanded="false">
				<c:choose>
					<c:when test="${schoolType == 1 }">
						<li><a href="#" onclick="StduentRegister()">学生注册</a></li>
						<li><a href="#" onclick="ChargeHours()">收费--按课时</a></li>
						<li><a href="#" onclick="ChargePeriod()">收费--按时间段</a></li>
						<li><a href="#" onclick="ChargeOthers()">收费其他</a></li>
						<li><a href="#" onclick="Expenditure()">费用支出</a></li>
						<li><a href="#" onclick="Activitys()">优惠活动管理</a></li>
						<li><a href="#" onclick="selectgifts()">赠送礼品管理</a></li>
						<li><a href="#" onclick="selectUsedIntegrals()">赠品税分统计</a></li>
						<li><a href="#" onclick="StudentDepartmentofpediatrics()">课程提醒</a></li>
						<li><a href="#" onclick="RecruitStudents()">招生报表</a></li>
					</c:when>
					<c:when test="${schoolType == 2 }">
						<li><a href="#" onclick="StduentRegister()">学生注册</a></li>
						<li><a href="#" onclick="ChargePeriod()">收费</a></li>
						<li><a href="#" onclick="ChargeOthers()">收费其他</a></li>
						<li><a href="#" onclick="Expenditure()">费用支出</a></li>
						<li><a href="#" onclick="RecruitStudents()">招生报表</a></li>
					</c:when>
					<c:when test="${schoolType == 3 }">
						<li><a href="#" onclick="StduentRegister()">学生注册</a></li>
						<li><a href="#" onclick="ChargePeriod()">收费--按时间段</a></li>
						<li><a href="#" onclick="ChargeOthers()">收费其他</a></li>
						<li><a href="#" onclick="Expenditure()">费用支出</a></li>
						<li><a href="#" onclick="Activitys()">优惠活动管理</a></li>
						<li><a href="#" onclick="selectgifts()">赠送礼品管理</a></li>
						<li><a href="#" onclick="selectUsedIntegrals()">赠品税分统计</a></li>
						<li><a href="#" onclick="StudentDepartmentofpediatrics()">课程提醒</a></li>
						<li><a href="#" onclick="RecruitStudents()">招生报表</a></li>
					</c:when>
				</c:choose>
			</ul></li>
		<li class="side-nav-item"><a href="javascript: void(0);"
			class="side-nav-link"> <i class="mdi mdi-yelp"></i> <span>
					报表统计</span> <span class="menu-arrow"></span>
		</a>
			<ul class="side-nav-second-level" aria-expanded="false">
				<li><a href="javascript:void(0)" onclick="rootSchoolInfo()">资金账余额</a></li>
				<li><a href="javascript:void(0)"
					onclick="selectOrderSchoolInfo()">收支明细报表</a></li>
				<li><a href="javascript:void(0)" onclick="schoolListInfo()">收支汇总报表</a></li>

				<c:if test="${schoolType == 1 }">
					<li><a href="javascript:void(0)" onclick="teacherHourSum()">教师课时总表</a></li>
					<li><a href="javascript:void(0)" onclick="studentHourInfo()">学生课时总表</a></li>
					<li><a href="javascript:void(0)" onclick="teacherClassHour()">教师上课明细</a></li>
				</c:if>
				<li><a href="javascript:void(0)" onclick="addStudent()">新增学生报表</a></li>
				<c:if test="${schoolType ==1 }">
					<li><a href="javascript:void(0)" onclick="feeSituation()">收费情况报表</a></li>
				</c:if>
				<c:if test="${schoolType ==2 }">
					<li><a href="javascript:void(0)" onclick="highFeeSituation()">高中收费情况报表</a></li>
				</c:if>
				<c:if test="${schoolType ==3 }">
					<li><a href="javascript:void(0)" onclick="artFeeSituation()">艺考收费情况报表</a></li>
				</c:if>
			</ul></li>
		<li class="side-nav-item"><a href="javascript: void(0);"
			class="side-nav-link"> <i class="mdi mdi-windows"></i> <span>
					系统维护</span> <span class="menu-arrow"></span>
		</a>
			<ul class="side-nav-second-level" aria-expanded="false">
				<li><a href="javascript:void(0)" onclick="operatorChilk()">操作员</a></li>
				<li><a href="javascript:void(0)" onclick="rootTeacherInto()">操作员授权</a></li>
				<li><a href="javascript:void(0)" onclick="operatorChilk()">修改密码</a></li>
			</ul></li>
	</ul>
	<!-- End Sidebar -->

	<div class="clearfix"></div>

</div>

</div>
