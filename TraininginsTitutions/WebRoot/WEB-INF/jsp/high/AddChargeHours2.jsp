<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				</div>
				<!-- end Topbar -->

				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h4 style="text-align:center">另开项目</h4>
								<div class="row mb-2 addOrderChildren">
									<div class="col-md-12">
										<form novalidate>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label for="billing-first-name">校区信息</label> <input
															class="form-control school" type="text"
															id="billing-first-name" disabled />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">学员名称</label> <select
															class="form-control stuId" id="example-select">
															<c:forEach items="${student }" var="s">
																<option value="${s.studentId }" class="delSt">${s.studentName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label for="billing-last-name">收费日期</label> <input
															class="form-control date" type="text"
															id="billing-last-name" disabled />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">班级选择</label> <select
															class="form-control classes" id="example-select">
															<c:forEach items="${classes }" var="c">
																<option value="${c.classId }"
																	name="${c.departmentOfPediatrics.dpId }"
																	dpTypeName="${c.departmentOfPediatrics.dpTypeName }"
																	classTypeId="${c.classTypeId }"
																	schoolIds2="${c.school.schoolName }">${c.className}
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-number">应收金额</label> <input
															class="form-control money" id="example-number"
															type="number" name="number">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-number">本次新增课时</label> <input
															type="text" class="form-control hour"
															data-toggle="input-mask"
															data-mask-format="00000000000000000" data-reverse="true"
															value="0">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">交费方式</label> <select
															class="form-control paymentmethodId" id="example-select">
															<c:forEach items="${paymentMethod }" var="p">
																<option value="${p.paymentmethodId }">${p.paymentmethodName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-number">本次赠送课时</label> <input
															type="text" class="form-control hours"
															data-toggle="input-mask"
															data-mask-format="00000000000000000" data-reverse="true"
															value="0">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">核算项目</label> <select
															class="form-control feecateId" id="example-select">
															<c:forEach items="${feeCategory }" var="f">
																<option value="${f.chargeTypeId }">${f.chargeTypeName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">课程名称</label> <input
															class="form-control departmentofpediatricsId" type="text"
															id="billing-last-name" disabled />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">赠品名称</label> <select
															class="form-control giftName" id="example-select">
															<option value="0">---请选择---</option>
															<c:forEach items="${gift }" var="g">
																<option value="${g.giftId }" name="${g.giftNumber }">${g.giftName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label for="billing-last-name">赠品数量</label> <input
															type="text" class="form-control giftNumber"
															data-toggle="input-mask"
															data-mask-format="00000000000000000" data-reverse="true">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">活动名称</label> <select
															class="form-control feecateId4 " id="example-select">
															<option value="0">---请选择---</option>
															<c:forEach items="${activity }" var="a">
																<option value="${a.activityId }"
																	activityMoney="${a.activityMoney }"
																	discount="${a.discount }">${a.activityName }</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-number">实收金额</label> <input
															class="form-control dpMoneyActivity4" id="example-number"
															type="number" name="number">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-number">手续费</label> <input
															class="form-control serviceCharge" id="example-number"
															type="number" name="number">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group mb-3">
														<label for="example-select">积分</label> <input
															class="form-control integral" id="example-number"
															type="number" name="number">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label for="billing-last-name">备注信息</label> <input
															class="form-control remarks" type="text"
															id="billing-last-name" />
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<button type="button"
															class="btn btn-block btn-primary TiJiao">提交</button>
													</div>
												</div>
											</div>
										</form>
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
							id="api-access-check"> <label
							class="custom-control-label" for="api-access-check">API
							Access</label>
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
									sold an item</a> <small>Paul Burgess just purchased
									âHyper - Admin Dashboardâ!</small>
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
									sold an item</a> <small>Paul Burgess just purchased
									âHyper - Admin Dashboardâ!</small>
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
			src="${Path }/static/js/highes/AddChargeHours2.js"></script>
		<!-- third party js ends -->
</body>
</html>
