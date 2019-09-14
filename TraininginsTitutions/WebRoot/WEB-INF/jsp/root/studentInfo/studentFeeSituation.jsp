<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>管理员页面</title>
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

</head>

<body>

	<!-- Begin page -->
	<div class="wrapper">

		<!-- ========== Left Sidebar Start ========== -->
		<%@include file="/WEB-INF/jsp/admin/bar/leftSidebar.jsp"%>
		<div class="content-page">
			<div class="content">


				<!-- ============================================================== -->
				<!-- Start Page Content here -->
				<!-- ============================================================== -->
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
									<a href="javascript:void(0);" class="dropdown-item notify-item"
										onclick="switchingAccounts()"> <i
										class="mdi mdi-account-edit mr-1"></i> <span>切换账号 </span>
									</a>

									<!-- item-->
									<a href="javascript:void(0);" class="dropdown-item notify-item">
										<i class="mdi mdi-lifebuoy mr-1"></i> <span>设置 </span>
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
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<div class="row mb-2">
										<div class="col-sm-4">
											<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
												onclick="exportExsal()">导出exsal</button>
										</div>
										<div class="col-sm-8">
											<div class="text-sm-right">
												<button type="button" class="btn btn-success btn-sm mt-2"
													onclick="printOrders()">打印订单</button>

												</button>
											</div>
										</div>
										<!-- end col-->
									</div>
								</div>
							</div>


							<!-- Question/Answer -->
							<div class="table-responsive">
								<table
									class="table table-centered table-striped dt-responsive nowrap w-100"
									id="products-datatable">
									<thead>
										<tr>
											<th style="width: 20px;">
												<div class="custom-control custom-checkbox"></div>
											</th>
											<th>序</th>
											<th>校区</th>
											<th>单号</th>
											<th>学员名称</th>
											<th>课程</th>
											<th>应收费用</th>
											<th>实收金额</th>
											<th>未收金额</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${studentFeeSituationList }" var="ts"
											varStatus="status">
											<tr>
												<td>
													<div class="custom-control custom-checkbox">
														<input type="checkbox" class="custom-control-input"
															id="customCheck2"> <label
															class="custom-control-label" for="customCheck2">&nbsp;</label>
													</div>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${status.index }</a>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${schoolName}</a></td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${ts.orderNumber}</a>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${ts.student.studentName }</a>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${ts.departmentOfPediatrics.dpTypeName }</a>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${ts.departmentOfPediatrics.dpMoney }</a>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${ts.sumDpMoney }</a>
												</td>
												<td class="table-user"><a href="javascript:void(0);"
													class="text-body font-weight-semibold">${ts.departmentOfPediatrics.dpMoney-ts.sumDpMoney }</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

							<!-- ============================================================== -->
							<!-- End Page content -->
							<!-- ============================================================== -->

						</div>
						<!-- END wrapper -->

						<!-- App js -->
						<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
						<script
							src="${Path }/static/js/admin/studentInfo/selectStudentFeeInfo.js"></script>
						<script src="${Path }/static/js/admin/leftSidebar.js"></script>
</body>
</html>
