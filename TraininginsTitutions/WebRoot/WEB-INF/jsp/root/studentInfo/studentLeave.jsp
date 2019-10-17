<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<!-- App favicon -->
<link rel="shortcut icon" href="assets/images/favicon.ico">

<!-- third party css -->
<link href="${Path }/static/css/vendor/dataTables.bootstrap4.css"
	rel="stylesheet" type="text/css" />
<link href="${Path }/static/css/vendor/responsive.bootstrap4.css"
	rel="stylesheet" type="text/css" />
<!-- third party css end -->

<!-- App css -->
<link href="${Path }/static/css/icons.min.css" rel="stylesheet"
	type="text/css" />
<link href="${Path }/static/css/app.min.css" rel="stylesheet"
	type="text/css" />

</head>

<body>

	<!-- Begin page -->
	<div class="wrapper">

		<!-- ========== Left Sidebar Start ========== -->
		<%@include file="/WEB-INF/jsp/leftSidebar/leftSidebar.jsp"%>
		<div class="content-page">
			<div class="content">
				<!-- Start Content-->
				<div class="container-fluid">
					<div class="navbar-custom">
						<ul class="list-unstyled topbar-right-menu float-right mb-0">
							<li class="dropdown notification-list"><a
								class="nav-link dropdown-toggle nav-user arrow-none mr-0"
								data-toggle="dropdown" href="#" role="button"
								aria-haspopup="false" aria-expanded="false"> <span
									class="account-user-avatar"> <img
										src="${Path }/static/images/avatar-1.jpg" alt="user-image"
										class="rounded-circle">
								</span> <span> <span class="account-user-name">${user.loginName }
									</span> <span class="account-position">管理员</span>
								</span>
							</a>
								<div
									class="dropdown-menu dropdown-menu-right dropdown-menu-animated topbar-dropdown-menu profile-dropdown">
									<!-- item-->
									<div class=" dropdown-header noti-title">
										<h6 class="text-overflow m-0">欢迎 !</h6>
									</div>


									<!-- item-->
									<a href="javascript:void(0);" class="dropdown-item notify-item"
										onclick="switchingAccounts()"> <i
										class="mdi mdi-account-edit mr-1"></i> <span>切换账号 </span>
									</a>

									<!-- item-->
									<a href="welCome.html" class="dropdown-item notify-item" >
										<i class="mdi mdi-lifebuoy mr-1"></i> <span>退出 </span>
									</a>


								</div></li>

						</ul>
						<button class="button-menu-mobile open-left disable-btn">
							<i class="mdi mdi-menu"></i>
						</button>
						<div class="app-search">
							<form>
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search...">
									<span class="mdi mdi-magnify"></span>
									<div class="input-group-append">
										<button class="btn btn-primary" type="submit">Search</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- end Topbar -->
					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<div class="page-title-right">
									<ol class="breadcrumb m-0">
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">Hyper</a></li>
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">Pages</a></li>
										<li class="breadcrumb-item active">FAQ</li>
									</ol>
								</div>
								<h4 class="page-title">学生请假详情</h4>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<div class="text-center">
								<h3 class="">管理学校及城市</h3>
								<p class="text-muted mt-3" id="schoolId"
									id_schoolName="${schoolName}" name=${schoolId }>请按规则查询</p>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row mb-2">
									<div class="col-sm-4">
										<a href="javascript:void(0);" onclick="insertStudentLevea()"
											class="btn btn-danger mb-2"><i
											class="mdi mdi-plus-circle mr-2"></i>学生请假</a>
									</div>
									<div class="col-sm-8">
										<div class="text-sm-right">

											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="print()">打印</button>
											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="exportExsal()">导出</button>
											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2"
												onclick="queryStudentLeave()">查询</button>
										</div>
									</div>
									<!-- end col-->
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="billing-first-name">开始日期</label> <input
												class="form-control" type="date" id="startTime" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="billing-first-name">班级:</label> <select
												id="classId" class="form-control">
												<option value="">请选择</option>
												<c:forEach items="${classBySchooList}" var="c">
													<option value="${c.classId}">${c.className}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="billing-first-name">结束日期</label> <input
												class="form-control" type="date" id="endTime" />
										</div>
									</div>
								</div>

								<div class="table-responsive">
									<!--startprint-->
									<h3 style="text-align: center;" id="tables">学生请假详情</h3>
									<table
										class="table table-centered table-striped dt-responsive nowrap w-100"
										id="products-datatable" border="1px solid" width="100%">
										<tbody>
											<tr>
												<td><div class="custom-control custom-checkbox">
														<input type="checkbox" class="custom-control-input"
															disabled="disabled"> <label
															class="custom-control-label" for="customCheck2">&nbsp;</label>
													</div></td>
												<td>学生名称</td>
												<td>入学时间</td>
												<td>开始时间</td>
												<td>结束时间</td>
												<td>请假备注</td>
												<c:if test="${schoolType == 1 }">
													<td>本次上课老师</td>
												</c:if>
											</tr>
										</tbody>
										<tbody>
											<c:forEach items="${studentList}" var="stu">
												<tr class="classId">
													<td>
														<div class="custom-control custom-checkbox">
															<input type="checkbox"
																class="custom-control-input customCheckes"> <label
																class="custom-control-label customCheck"
																for="customCheck2">&nbsp;</label>
														</div>
													</td>
													<td class="table-user" name="${stu.studentId }"
														id_classId=${stu.classId } id_schoolId=${schoolId }>${stu.studentName }</td>
													<td class="table-user"><fmt:formatDate
															value="${stu.enrollmentTime}" pattern="yyyy-MM-dd HH:mm" /></td>
													<td class="table-user"><c:if
															test="${stu.startTime eq null}">
															无
													</c:if> <fmt:formatDate value="${stu.startTime}"
															pattern="yyyy-MM-dd HH:mm" /></td>
													<td class="table-user"><c:if
															test="${stu.endTime eq null}">
															无
													</c:if> <fmt:formatDate value="${stu.endTime}"
															pattern="yyyy-MM-dd HH:mm" /></td>
													<td class="table-user"><c:if
															test="${stu.remarks eq null}">
															无
													</c:if> ${stu.remarks}</td>
													<c:if test="${schoolType == 1}">
														<td class="table-user">
														<c:if test="${stu.teacherName eq null}">
															无
													</c:if>${stu.teacherName}</td>
													</c:if>

												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!--endprint-->
								</div>
							</div>
							<!-- end card-body-->
						</div>
						<!-- end card-->
					</div>
					<!-- end col -->
				</div>
				<!-- end row -->

			</div>
			<!-- container -->

		</div>
		<!-- content -->
		<iframe id="iframe1" style="display: none"></iframe>
		<!-- Footer Start -->
		<footer class="footer">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6">2018 - 2019 Â© Hyper - Coderthemes.com</div>
					<div class="col-md-6">
						<div class="text-md-right footer-links d-none d-md-block">
							<a href="javascript: void(0);">About</a> <a
								href="javascript: void(0);">Support</a> <a
								href="javascript: void(0);">Contact Us</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
		<!-- end Footer -->

	</div>

	<!-- ============================================================== -->
	<!-- End Page content -->
	<!-- ============================================================== -->


	</div>
	<!-- END wrapper -->


	<!-- Right Sidebar -->
	<div class="right-bar">

		<div class="rightbar-title">
			<a href="javascript:void(0);" class="right-bar-toggle float-right">
				<i class="dripicons-cross noti-icon"></i>
			</a>
			<h5 class="m-0">Settings</h5>
		</div>

		<div class="slimscroll-menu rightbar-content">

			<!-- Settings -->
			<hr class="mt-0" />
			<h5 class="pl-3">Basic Settings</h5>
			<hr class="mb-0" />

			<div class="p-3">
				<div class="custom-control custom-checkbox mb-2">
					<input type="checkbox" class="custom-control-input"
						id="notifications-check" checked> <label
						class="custom-control-label" for="notifications-check">Notifications</label>
				</div>

				<div class="custom-control custom-checkbox mb-2">
					<input type="checkbox" class="custom-control-input"
						id="api-access-check"> <label class="custom-control-label"
						for="api-access-check">API Access</label>
				</div>

				<div class="custom-control custom-checkbox mb-2">
					<input type="checkbox" class="custom-control-input"
						id="auto-updates-check" checked> <label
						class="custom-control-label" for="auto-updates-check">Auto
						Updates</label>
				</div>

				<div class="custom-control custom-checkbox mb-2">
					<input type="checkbox" class="custom-control-input"
						id="online-status-check" checked> <label
						class="custom-control-label" for="online-status-check">Online
						Status</label>
				</div>

				<div class="custom-control custom-checkbox mb-2">
					<input type="checkbox" class="custom-control-input"
						id="auto-payout-check"> <label
						class="custom-control-label" for="auto-payout-check">Auto
						Payout</label>
				</div>

			</div>

			<!-- Timeline -->
			<hr class="mt-0" />
			<h5 class="pl-3">Recent Activity</h5>
			<hr class="mb-0" />
			<div class="pl-2 pr-2">
				<div class="timeline-alt">
					<div class="timeline-item">
						<i class="mdi mdi-upload bg-info-lighten text-info timeline-icon"></i>
						<div class="timeline-item-info">
							<a href="#" class="text-info font-weight-bold mb-1 d-block">You
								sold an item</a> <small>Paul Burgess just purchased âHyper
								- Admin Dashboardâ!</small>
							<p class="mb-0 pb-2">
								<small class="text-muted">5 minutes ago</small>
							</p>
						</div>
					</div>

					<div class="timeline-item">
						<i
							class="mdi mdi-airplane bg-primary-lighten text-primary timeline-icon"></i>
						<div class="timeline-item-info">
							<a href="#" class="text-primary font-weight-bold mb-1 d-block">Product
								on the Bootstrap Market</a> <small>Dave Gamache added <span
								class="font-weight-bold">Admin Dashboard</span>
							</small>
							<p class="mb-0 pb-2">
								<small class="text-muted">30 minutes ago</small>
							</p>
						</div>
					</div>

					<div class="timeline-item">
						<i
							class="mdi mdi-microphone bg-info-lighten text-info timeline-icon"></i>
						<div class="timeline-item-info">
							<a href="#" class="text-info font-weight-bold mb-1 d-block">Robert
								Delaney</a> <small>Send you message <span
								class="font-weight-bold">"Are you there?"</span>
							</small>
							<p class="mb-0 pb-2">
								<small class="text-muted">2 hours ago</small>
							</p>
						</div>
					</div>

					<div class="timeline-item">
						<i
							class="mdi mdi-upload bg-primary-lighten text-primary timeline-icon"></i>
						<div class="timeline-item-info">
							<a href="#" class="text-primary font-weight-bold mb-1 d-block">Audrey
								Tobey</a> <small>Uploaded a photo <span
								class="font-weight-bold">"Error.jpg"</span>
							</small>
							<p class="mb-0 pb-2">
								<small class="text-muted">14 hours ago</small>
							</p>
						</div>
					</div>

					<div class="timeline-item">
						<i class="mdi mdi-upload bg-info-lighten text-info timeline-icon"></i>
						<div class="timeline-item-info">
							<a href="#" class="text-info font-weight-bold mb-1 d-block">You
								sold an item</a> <small>Paul Burgess just purchased âHyper
								- Admin Dashboardâ!</small>
							<p class="mb-0 pb-2">
								<small class="text-muted">1 day ago</small>
							</p>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<div class="rightbar-overlay"></div>
	<!-- /Right-bar -->

	<!-- App js -->
	<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
	<script src="${Path }/static/js/root/studentInfo/studentLeave.js"></script>

	<!-- third party js ends -->

	<!-- demo app -->
	<!-- end demo js-->

</body>
</html>
