<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="left-side-menu" style="background: #344451;">

	<div class="slimscroll-menu" id="left-side-menu-container">

		<!-- LOGO -->
		<a href="adminIndex.html" class="logo text-center"> <span
			class="logo-lg"> <img src="${Path }/static/images/logo.gif"
				alt="" width="50%" height="30px">
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
					<li><a href="javascript:void(0)"
						onclick="AdminSchoolListInfo()">学校账户信息</a></li>
					<li><a href="javascript:void(0)" onclick="AdminIncomeitems()">学校收入项目</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminExpenditureitemses()">学校支出项目</a></li>
					<li><a href="javascript:void(0)" onclick="AdminTeacherInto()">教师信息</a></li>
				</ul></li>
			<li class="side-nav-item"><a href="javascript: void(0);"
				class="side-nav-link"> <i class="mdi mdi-yelp"></i> <span>
						报表统计</span> <span class="menu-arrow"></span>
			</a>
				<ul class="side-nav-second-level" aria-expanded="false">
					<li><a href="javascript:void(0)"
						onclick="AdminSchoolListInfo()">资金账余额</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminSelectOrderSchoolInfo()">收支明细报表</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminSchoolListInfo()">收支汇总报表</a></li>
					<li><a href="javascript:void(0)" onclick="AdminTeacherHour()">教师课时总表(少儿)</a></li>
					<li><a href="javascript:void(0)" onclick="AdminStudentHour()">学员课时总表(少儿)</a></li>
					<li><a href="javascript:void(0)" onclick="AdminAddStudent()">新增学员报表</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminTeacherClassHour()">教师上课明细(少儿)</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminStudentFeeInfo()">学员收费情况表</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminHighStudentFeeInfo()">高中收费情况表</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminArtStudentFeeInfo()">艺考收费情况表</a></li>
				</ul></li>

			<li class="side-nav-item"><a href="javascript: void(0);"
				class="side-nav-link"> <i class="mdi mdi-windows"></i> <span>
						系统维护</span> <span class="menu-arrow"></span>
			</a>
				<ul class="side-nav-second-level" aria-expanded="false">
					<li><a href="javascript:void(0)"
						onclick="AdminOperatorChilk()">操作员</a></li>
					<li><a href="javascript:void(0)" onclick="AdminTeacherInto()">教师授权</a></li>
					<li><a href="javascript:void(0)"
						onclick="AdminOperatorChilk()">修改密码</a></li>
					<li><a href="javascript:void(0)" onclick="dbbackup()">数据备份</a></li>
					<li><a href="javascript:void(0)" data-toggle="modal"
						data-target="#top-modal">数据清除</a></li>
				</ul></li>
		</ul>

		<!-- End Sidebar -->

		<div class="clearfix"></div>

	</div>

	<!-- Sidebar -left -->

</div>
<!-- Top modal content -->
<div id="top-modal" class="modal fade" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog modal-top">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="topModalLabel">请选择要清除的数据</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
			</div>
			<div class="modal-body">
				<p style="color: red; font-size: 12px;">数据清除后切不可恢复，请备份好数据，谨慎操作</p>
				<table
					class="table table-centered table-striped dt-responsive nowrap w-100" >
					<thead>
						<tr>
							<th style="width: 20px;">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input order"
										id="customCheck1"> <label class="custom-control-label"
										for="customCheck1">&nbsp;</label>
								</div>
							</th>
							<th>只删除记账数据，保留基础数据</th>
						</tr>
					</thead>
					<span hidden="hidden" id="adminState">${user.state }</span>
					<tbody>
						<tr>
							<td>
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input student">
									<label class="custom-control-label delEliminatings"
										for="customCheck2">&nbsp;</label>
								</div>
							</td>
							<td class="table-user">删除学员信息</td>
						</tr>
						<tr>
							<td>
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input teacher">
									<label class="custom-control-label delEliminatings"
										for="customCheck2">&nbsp;</label>
								</div>
							</td>
							<td class="table-user">删除教师信息</td>
						</tr>
						<tr>
							<td>
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input class">
									<label class="custom-control-label delEliminatings"
										for="customCheck2">&nbsp;</label>
								</div>
							</td>
							<td class="table-user">删除课程和班级信息</td>
						</tr>
						<tr>
							<td>
								<div class="custom-control custom-checkbox">
									<input type="checkbox"
										class="custom-control-input paymentmethod"> <label
										class="custom-control-label delEliminatings"
										for="customCheck2">&nbsp;</label>
								</div>
							</td>
							<td class="table-user">删除收费方式</td>
						</tr>
						<tr>
							<td>
								<div class="custom-control custom-checkbox">
									<input type="checkbox"
										class="custom-control-input expenAndIncome"> <label
										class="custom-control-label delEliminatings"
										for="customCheck2">&nbsp;</label>
								</div>
							</td>
							<td class="table-user">删除收入和支出信息</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<tr>
					<td>
						<div id="checkCode" class="code" onclick="createCode(4)"></div>
					</td>
					<td><span onclick="createCode(4)">看不清换一张</span></td>
				</tr>
				<tr>
					<td>验证码：</td>
					<td><input type="text" id="yanzheng" class="form-control" /></td>
				</tr>
				<button type="button" class="btn btn-light" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary"
					onclick="dataEliminating()">确认清除</button>
			</div>
		</div>
	</div>
</div>


<!-- ============================================================== -->
<!-- End Page content -->
<!-- ============================================================== -->