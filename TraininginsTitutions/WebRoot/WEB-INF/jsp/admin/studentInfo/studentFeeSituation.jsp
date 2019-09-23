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
				<!-- Start Content-->
				<div class="container-fluid">

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
											<a href="javascript:void(0);"
												class="dropdown-item notify-item"
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
											<input type="text" class="form-control"
												placeholder="Search..."> <span
												class="mdi mdi-magnify"></span>
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
										<h4 class="page-title">学校信息</h4>
									</div>
								</div>
							</div>
							<!-- end page title -->
							<!-- Start Content-->
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="billing-first-name">开始日期</label> <input
											class="form-control" type="date" id="startTime" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="billing-first-name">截至日期</label> <input
											class="form-control" type="date" id="endTime" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="billing-first-name">班级</label> 
										<select id="classId" class="form-control">
											<option value="">请选择班级</option>
											<c:forEach items="${classList }" var="cc">
												<option value="${cc.classId }">${cc.className }</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="container-fluid">
								<!-- end page title -->

								<div class="row">
									<div class="col-12">
										<div class="card">
											<div class="card-body">
												<div class="row mb-2">
													<div class="col-sm-4">
														<button type="button"
															class="btn btn-info btn-sm mt-2 ml-1 "
															onclick="queryStudent()">查询</button>
													</div>
													<div class="col-sm-8">
														<div class="text-sm-right">
															<button type="button" class="btn btn-success btn-sm mt-2"
																onclick="print()">打印订单</button>

															<button type="button"
																class="btn btn-info btn-sm mt-2 ml-1"
																onclick="exportExsal()">导出exsal</button>
															</button>
														</div>
													</div>
													<!-- end col-->
												</div>
												<!-- end row -->
												<!-- Question/Answer -->
												<div class="table-responsive">
													<!--startprint-->
													<h3 style="text-align: center;" id="tables">学生收费情况报表</h3>
													<table
														class="table table-centered table-striped dt-responsive nowrap w-100"
														id="products-datatable" border="1px solid" width="100%">
														<tbody>
															<tr>
																<td>序</td>
																<td>校区</td>
																<td>单号</td>
																<td>学员名称</td>
																<td>收费日期</td>
																<td>课程</td>
																<td>应收费用</td>
																<td>实收金额</td>
																<td>未收金额</td>
															</tr>
														</tbody>
														<tbody>
															<c:forEach items="${studentFeeSituationList }" var="ts"
																varStatus="status">
																<tr>
																	<td class="table-user">${status.index }</td>
																	<td class="table-user">${schoolName}</td>
																	<td class="table-user">${ts.orderNumber}</td>
																	<td class="table-user">${ts.student.studentName }</td>
																	<td class="table-user"><fmt:formatDate value="${ts.startTime}" pattern="yyyy-MM-dd HH:mm"/></td>
																	<td class="table-user">${ts.departmentOfPediatrics.dpTypeName }
																	</td>
																	<td class="table-user">${ts.discount+ts.dpMoney }
																	</td>
																	<td class="table-user">${ts.dpMoney }</td>
																	<td class="table-user">${(ts.discount+ts.dpMoney)-ts.dpMoney }
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
													<!--endprint-->
												</div>
												<iframe id="iframe1" style="display: none"></iframe>
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
