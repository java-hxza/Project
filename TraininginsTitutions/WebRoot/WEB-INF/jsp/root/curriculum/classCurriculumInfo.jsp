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
<link href="${Path }/static/css/style.css" rel="stylesheet"
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
									<a href="welCome.html" class="dropdown-item notify-item">
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
								<h4 class="page-title">创建课程</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->
					<div class="row">
						<div class="col-sm-12">
							<div class="text-center">
								<h3 class="schoolId" name="${schoolId }">${schoolName }</h3>
								<div class="app-search">
									<form>
										<div class="input-group">
											<input type="text" class="form-control"
												placeholder="Search..."> <span
												class="mdi mdi-magnify"></span>
											<div class="input-group-append">
												<button class="btn btn-primary" type="button">搜索</button>
											</div>
										</div>
									</form>
								</div>
								<p class="text-muted mt-3"></p>
							</div>
						</div>
						<!-- end col -->
					</div>
					<!-- end row -->
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row mb-2">
									<div class="col-sm-4">
										<a href="javascript:void(0);" onclick="updateCurriclum()"
											class="btn btn-danger mb-2"><i
											class="mdi mdi-plus-circle mr-2"></i> 修改课程</a>
									</div>
									<div class="col-sm-8">
										<div class="text-sm-right">
											<button type="button" class="btn btn-success mb-2 mr-1"
												onclick="createCurriclum(${classId})">
												<i class="mdi mdi-plus-circle mr-2"></i> 添加课程
											</button>
											<button type="button" class="btn btn-light mb-2 mr-1"
												onclick="delCurriclum(${classId})">删除课程</button>
										</div>
									</div>
									<!-- end col-->
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
												<th>课程名称</th>
												<th>教师名称</th>
												<th>课程开始时间</th>
												<th>课程时间</th>
												<th>备注</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${curriculumInfoList}" var="cur"
												varStatus="status">
												<tr>
													<td>
														<div class="custom-control custom-checkbox">
															<input type="checkbox"
																class="custom-control-input customCheckes"> <label
																class="custom-control-label customCheck"
																for="customCheck2">&nbsp;</label>
														</div>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold"
														name="${cur.teacherHourId}">${status.index }</a></td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${cur.dpName}</a></td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${cur.teacherName }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold"> <fmt:formatDate
																value="${cur.startTime }" pattern="yyyy-MM-dd MM:ss" />
													</a></td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${cur.hours }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${cur.remarks }</a>
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
							<script src="${Path }/static/js/admin/info/schoolInfo.js"></script>
							<script src="${Path }/static/js/root/curriculum/classInfo.js"></script>
</body>
</html>
