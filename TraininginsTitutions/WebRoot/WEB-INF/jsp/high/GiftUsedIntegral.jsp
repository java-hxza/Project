<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge chrome=1">
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
		<!-- Left Sidebar End -->
		<div class="content-page">
			<div class="content">
				<!-- Topbar Start -->
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
								<a href="welCome.html" class="dropdown-item notify-item"> <i
									class="mdi mdi-lifebuoy mr-1"></i> <span>退出 </span>
								</a>


							</div></li>

					</ul>
					<button class="button-menu-mobile open-left disable-btn">
						<i class="mdi mdi-menu"></i>
					</button>
				</div>
				<!-- end Topbar -->

				<!-- Start Content-->
				<div class="container-fluid">
					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<div class="page-title-right">
									<ol class="breadcrumb m-0">
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">培训收费</a></li>
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">赠品积分统计</a></li>
									</ol>
								</div>
								<h4 class="page-title">赠品积分统计</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="row dayin">
						<div class="col-12">
							<div class="row">
								<div class="col-md-12">
									<h3 style="text-align:center">赠品税分统计</h3>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label>班级名称</label>
									<div class="input-group">
										<button class="btn btn-dark  " type="button" onclick="DaYin()">打印</button>
										&nbsp; <select class="form-control classes"
											id="example-select">
											<option value="0">---请选择---</option>
											<c:forEach items="${classes }" var="c">
												<option value="${c.classId }">${c.className }</option>
											</c:forEach>
										</select>
										<button class="btn btn-dark  Hour" type="button">查找</button>
									</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="example-select">学生姓名</label>
									<div class="input-group">
										<input class="form-control studentName" type="text"
											id="billing-first-name" placeholder="学生姓名" />
										<button class="btn btn-dark  Time" type="button">查找</button>
										&nbsp;
										<button class="btn btn-dark  " type="button"
											onclick="Excels()" style="margin-bottom: 0px">导出Excel</button>
									</div>
								</div>
								<!--startprint-->
								<table class="table dt-responsive nowrap" id="basic-datatable"
									width="100%" border="1px" cellspacing="0">
									<thead class="thead-light">
										<tr>
											<th>校区信息</th>
											<th>班级名称</th>
											<th>学员姓名</th>
											<th>赠品名称</th>
											<th>赠品数量</th>
											<th>总积分</th>
											<th>已使用积分</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${ student}" var="s">
											<tr class="GiftActivity">
												<td class="school"></td>
												<td class="selectClasses">${s.classes.className }</td>
												<td class="selectStudentName">${s.studentName }</td>
												<td class="studentId" name="${s.studentId }"></td>
												<td></td>
												<td>${s.integral }</td>
												<td>${s.usedIntegral }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<!--endprint-->
								<iframe id='iframe1' style='display: none'></iframe>
								<div class="col-md-6" style="display: none;">
									<div class="form-group mb-3">
										<label for="example-select">赠品</label> <select
											class="form-control order" id="example-select">
											<c:forEach items="${order }" var="o">
												<option value="${o.stuId }" class="${o.giftNumber }"
													school="${o.school.schoolName }">${o.gift.giftName}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<!-- end card-body-->
								<!-- end card-->
							</div>
						</div>
						<!-- end col -->
					</div>
					<!-- end row -->

				</div>
				<!-- container -->

			</div>
			<!-- content -->

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

	<!-- third party js -->
	<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
	<script type="text/javascript"
		src="${Path }/static/js/highes/leftSidebar.js"></script>
	<script type="text/javascript"
		src="${Path }/static/js/highes/GiftUsedIntegral.js"></script>
	<!-- third party js ends -->
	<script type="text/javascript">
		$(document).ready(function() {
			Excels = function() {
				var num = 0;
				for (var i = 0; i < $(".GiftActivity").length; i++) {
					if ($(".GiftActivity").eq(i).css('display') == "none") {
						num = num + 1;
					}
				}
				if (num == $(".GiftActivity").length) {
					alert("没有可以导出的数据！")
					return false;
				}
				for (var i = 0; i < $(".GiftActivity").length; i++) {
					if ($(".GiftActivity").eq(i).css('display') == "none") {
						$(".GiftActivity").eq(i).remove();
						i = i - 1;
					}
				}
				excel = new ExcelGen({
					"src_id" : "basic-datatable",
					"show_header" : true
				});
				excel.generate("赠品税分统计表");
			};
		});
	</script>
</body>
</html>
