<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <div class="left-side-menu" style="background: #344451;">

			<div class="slimscroll-menu" id="left-side-menu-container">

				<!-- LOGO -->
				<a href="index.html" class="logo text-center"> <span
					class="logo-lg"> <img src="${Path }/static/images/logo.png"
						alt=""width="50%" height="30px">
				</span> <span class="logo-sm"> <img
						src="${Path }/static/images/logo_sm.png" alt="" height="16">
				</span>
				</a>

				<!--- Sidemenu -->
				<ul class="metismenu side-nav">

					<li class="side-nav-title side-nav-item">基础设置</li>

					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="mdi mdi-zip-box"></i> <span
							class="badge badge-success float-right">8</span> <span>校区信息
						</span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="javascript:void(0)" onclick="AdminSchoolListInfo()">学校账户信息</a></li>
							<li><a href="javascript:void(0)" onclick="AdminIncomeitems()">学校收入项目</a></li>
							<li><a href="javascript:void(0)" onclick="AdminExpenditureitemses()">学校支出项目</a></li>
							<li><a href="javascript:void(0)" onclick="AdminTeacherInto()">教师信息</a></li>
						</ul></li>
					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="mdi mdi-yelp"></i> <span>
								报表统计</span> <span class="menu-arrow"></span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="javascript:void(0)" onclick="AdminSchoolListInfo()">资金账余额</a></li>
							<li><a href="javascript:void(0)" onclick="AdminSelectOrderSchoolInfo()">收支明细报表</a></li>
							<li><a href="javascript:void(0)" onclick="AdminSchoolListInfo()">收支汇总报表</a></li>
							<li><a href="javascript:void(0)" onclick="AdminTeacherHour()">教师课时总表</a></li>
							<li><a href="javascript:void(0)" onclick="AdminStudentHour()">学员课时总表</a></li>
							<li><a href="javascript:void(0)" onclick="AdminAddStudent()">新增学员报表</a></li>
							<li><a href="javascript:void(0)" onclick="AdminTeacherClassHour()">教师上课明细</a></li>
							<li><a href="javascript:void(0)" onclick="AdminStudentFeeInfo()">学员收费情况表</a></li>
						</ul></li>

					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="mdi mdi-windows"></i> <span>
								系统维护</span> <span class="menu-arrow"></span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="javascript:void(0)" onclick="AdminOperatorChilk()">操作员</a></li>
							<li><a href="javascript:void(0)" onclick="AdminTeacherInto()">教师授权</a></li>
							<li><a href="javascript:void(0)" onclick="AdminOperatorChilk()">修改密码</a></li>
						</ul></li>
				</ul>

				<!-- End Sidebar -->
				
				<div class="clearfix"></div>

			</div>

            <!-- Sidebar -left -->

        </div>
