<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
								<h4 class="page-title">学生信息管理</h4>
							</div>
						</div>
					</div>

					<!-- end row -->
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<div class="row mb-2">
										<div class="col-sm-4">
											<a href="javascript:void(0);" onclick="updateStudnet()"
												class="btn btn-danger mb-2"><i
												class="mdi mdi-plus-circle mr-2"></i> 修改学生信息</a>
										</div>
										<div class="col-sm-8">
											<div class="text-sm-right">
												<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
													onclick="shiftWork()">学员转班</button>
												<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
													onclick="exitSchool()">学员退学</button>
												<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
													data-toggle="modal" data-target="#top-modal">学员上课登记</button>
												<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
													data-toggle="modal" data-target="#top-modal">学员批量登记</button>
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
														<div class="dropdown float-right">
															<a href="#" class="dropdown-toggle arrow-none card-drop"
																data-toggle="dropdown" aria-expanded="false"> <i
																class="mdi mdi-dots-vertical"></i>
															</a>
															<div class="dropdown-menu dropdown-menu-right">
																<!-- item-->
																<a href="javascript:void(0);" class="dropdown-item">Today</a>
																<!-- item-->
																<a href="javascript:void(0);" class="dropdown-item">Yesterday</a>
																<!-- item-->
																<a href="javascript:void(0);" class="dropdown-item">Last
																	Week</a>
																<!-- item-->
																<a href="javascript:void(0);" class="dropdown-item">Last
																	Month</a>
															</div>
														</div>
													<th>所属校区</th>
													<th>就读学校</th>
													<th>学生姓名</th>
													<th>学生性别</th>
													<th>出生日期</th>
													<th>家长姓名</th>
													<th>联系电话</th>
													<th>家庭住址</th>
													<th>报名渠道</th>
													<th>招生老师</th>
													<th>接送人</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${artClassStudnets }"
													var="children">
													<tr class="schoolId">
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
															name="${children.student.studentId }"
															id_classId="${children.classId }">${schoolName }</a></td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.school }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.studentName}</a>
														</td>
														<c:choose>
															<c:when test="${children.student.studentSex == 0 }">
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold">女</a></td>
															</c:when>
															<c:otherwise>
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold">男</a></td>
															</c:otherwise>
														</c:choose>

														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.studentBirth }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.parentName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.telephone }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.familyAddress }</a>
														</td>


														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.registrationChannels }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.registrationConsultant }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.registrationConsultant }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${children.student.remarks }</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- Top modal content -->
									<div id="top-modal" class="modal fade" tabindex="-1"
										role="dialog" aria-hidden="true">
										<div class="modal-dialog modal-top">
											<div class="modal-content">
												<div class="modal-header">
													<h4 class="modal-title" id="topModalLabel">请选择课程</h4>
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">×</button>
												</div>
												<div class="modal-body">
													<tbody>
														<c:forEach items="${teacherHourList }" var="th">
															<tr class="thId">
																<td>
																	<div class="custom-control custom-checkbox">
																		<input type="checkbox"
																			class="custom-control-input checkes"> <label
																			class="custom-control-label check" for="customCheck2">&nbsp;</label>
																	</div>
																</td>
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold"
																	name="${th.teacherId }" th_id="${th.teacherHourId }">${th.teacherName }</a></td>
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold"
																	name="${th.dpId }">${th.dpName }</a></td>
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold"><fmt:formatDate value="${th.startTime }" pattern="yyyy-MM-dd hh:mm:ss" /></a></td>
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold">${th.hours }</a></td>
															</tr>
														</c:forEach>
													</tbody>
													</table>
												</div>
												<div class="modal-footer">
													<label for="billing-address">教学内容</label> <input
														type="text" class="form-control" id="contentOfCourses">
													<button type="button" class="btn btn-light"
														data-dismiss="modal">关闭</button>
													<button type="button" class="btn btn-primary"
														onclick="classBatchRegistration()">保存</button>
												</div>
											</div>

											<!-- /.modal-content -->

											<!-- ============================================================== -->
											<!-- End Page content -->
											<!-- ============================================================== -->


										</div>
										<!-- App js -->
										<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
										<script type="text/javascript"
											src="${Path }/static/js/admin/leftSidebar.js"></script>
										<script type="text/javascript"
											src="${Path }/static/js/root/studentInfo/art/seeStudentInfo.js"></script>
</body>
</html>
