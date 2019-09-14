<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<!-- App css -->
<link href="${Path }/static/css/icons.min.css" rel="stylesheet"
	type="text/css" />
<link href="${Path }/static/css/app.min.css" rel="stylesheet"
	type="text/css" />
	<link href="${Path }/static/css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>

	<!-- Begin page -->
	<div class="wrapper">

		<!-- ========== Left Sidebar Start ========== -->
		<%@include file="/WEB-INF/jsp/leftSidebar/leftSidebar.jsp"%>
		<!-- Left Sidebar End -->

		<!-- ============================================================== -->
		<!-- Start Page Content here -->
		<!-- ============================================================== -->

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
								<a href="javascript:void(0);" class="dropdown-item notify-item">
									<i class="mdi mdi-account-circle mr-1"></i> <span>我的账户</span>
								</a>

								<!-- item-->
								<a href="javascript:void(0);" class="dropdown-item notify-item" onclick="switchingAccounts()">
									<i class="mdi mdi-account-edit mr-1"></i> <span>切换账号
									</span> 
								</a>

								<!-- item-->
								<a href="javascript:void(0);" class="dropdown-item notify-item">
									<i class="mdi mdi-lifebuoy mr-1"></i> <span>设置
									</span>
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
								<h4 class="page-title">管理员</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">

									<!-- Checkout Steps -->
									<ul class="nav nav-pills bg-nav-pills nav-justified mb-3">
										<li class="nav-item"><a href="#billing-information"
											data-toggle="tab" aria-expanded="false"
											class="nav-link rounded-0 active"> <i
												class="mdi mdi-account-circle font-18"></i> <span
												class="d-none d-lg-block">请录入课程信息</span>
										</a></li>

									</ul>

									<!-- Steps Information -->
									<div class="tab-content">

										<!-- Billing Content-->
										<div class="tab-pane show active" id="billing-information">
											<div class="row">
												<div class="col-lg-8">
													<h4 class="mt-2">课程添加</h4>

													<p class="text-muted mb-4"></p>

													<form>
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-first-name">班级名称</label> <input
																		class="form-control" type="text" value="${classInfo.className }" 
																		id="classId" name="${classInfo.classId }" disabled="disabled"/>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">代课教师</label>
																		<input type="text"  class="form-control"value="${classInfo.headmaster}"  id="teacherId" name="${classInfo.teacherId}" disabled="disabled">
																</div>
															</div>
														</div>
														<!-- end row -->
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-email-address">课程类型<span
																		class="text-danger">*</span></label> <input
																		class="form-control" type="text" 
																		id="dpId" value="${classInfo.departmentOfPediatrics.dpTypeName }" name = "${classInfo.dpId }" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-email-address">本次课时<span
																		class="text-danger">*</span></label> <input
																		class="form-control" type="text" id="hours"/>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-6">
																<div class="form-group">
																	<label for="billing-address">开始日期</label> <input
																		class="form-control" type="datetime-local" id="startTime">
																</div>
															</div>
															<div class="col-6">
																<div class="form-group">
																	<label for="billing-address">课程备注</label> <input
																		class="form-control" type="datetime" 
																		placeholder="课程备注" id="remarks">
																</div>
															</div>
														</div>
															<!-- end col -->
															<div class="col-sm-6">
																<div class="text-sm-right">
																	<a href="javascript:void(0)" class="btn btn-danger"
																		onclick="saveCurriculum()"> <i class="mdi mdi-truck-fast mr-1"></i> 保存
																	</a>
																</div>
															</div>
															<!-- end col -->
														</div>
														<!-- end row -->
													</form>
												</div>
											</div>
											<!-- End Billing Information Content-->
										</div>
										<!-- end tab content-->

									</div>
									<!-- end card-body-->
								</div>
								<!-- end card-->
							</div>
							<!-- end col -->
						</div>
						<!-- end row-->

					</div>
					<!-- container -->

				</div>
				<!-- content -->

				<!-- Footer Start -->
				<footer class="footer">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-6">2018 - 2019 Â© Hyper -
								Coderthemes.com</div>
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


		<div class="rightbar-overlay"></div>
		<!-- /Right-bar -->


		<!-- App js -->
		<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
		<script type="text/javascript"
			src="${Path }/static/js/root/curriculum/classInfo.js"></script>
</body>

</html>