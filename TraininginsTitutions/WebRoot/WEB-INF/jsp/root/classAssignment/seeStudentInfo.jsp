<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
<link href="${Path }/static/css/style.css" rel="stylesheet" type="text/css" />
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
								<a href="javascript:void(0);" class="dropdown-item notify-item" onclick="switchingAccounts()">
									<i class="mdi mdi-account-edit mr-1"></i> <span>切换账号
									</span> 
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
								<h4 class="page-title">学生分班</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<!-- end row -->

					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row mb-2">
									<div class="col-sm-4">
										<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
											data-toggle="modal" data-target="#top-modal">学员分班</button>
									</div>
									<div class="col-sm-8">
										<div class="text-sm-right">
											<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
												data-toggle="modal" data-target="#top-modal">学员批量分班</button>
										</div>
									</div>
									<!-- end col-->
								</div>
								<!-- Question/Answer -->
								<div class="table-responsive">
									<table
										class="table table-centered table-striped dt-responsive nowrap w-100"
										id="products-datatable" style="border: 1px  solid #E3EAEF">
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
															<a href="javascript:void(0);" class="dropdown-item"
																onclick="allElection()">全选</a>
															<!-- item-->
															<a href="javascript:void(0);" class="dropdown-item"
																onclick="reverseElection()">反选</a>
														</div>
													</div>
												</th>
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
											<c:forEach items="${reserveSchoolList }" var="high">
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
														name="${high.student.studentId}">${schoolName}</a></td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.school }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold"
														name="${high.student.startTime }">${high.student.studentName}</a>
													</td>
													<c:choose>
														<c:when test="${high.student.studentSex == 0 }">
															<td class="table-user"><a href="javascript:void(0);"
																class="text-body font-weight-semibold">女</a></td>
														</c:when>
														<c:otherwise>
															<td class="table-user"><a href="javascript:void(0);"
																class="text-body font-weight-semibold">男</a></td>
														</c:otherwise>
													</c:choose>

													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.studentBirth }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.parentName }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.telephone }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.familyAddress }</a>
													</td>

													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.registrationChannels }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.registrationConsultant }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.registrationConsultant }</a>
													</td>
													<td class="table-user"><a href="javascript:void(0);"
														class="text-body font-weight-semibold">${high.student.remarks }</a>
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
												<h4 class="modal-title" id="topModalLabel">请选择班级</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
											</div>
											<div class="modal-body">
												<table
													class="table table-centered table-striped dt-responsive nowrap w-100"
													id="products-datatable">
													<thead>
														<tr>
															<th style="width: 20px;">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox" class="custom-control-input"
																		id="customCheck1" disabled="disabled"> <label
																		class="custom-control-label" for="customCheck1">&nbsp;</label>
																</div>
															</th>
															<th>班级名称</th>
															<th>教师名称</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${classList }" var="th">
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
																	name="${th.classId }">${th.className }</a></td>
																<td class="table-user"><a
																	href="javascript:void(0);"
																	class="text-body font-weight-semibold"
																	name="${th.teacherId }">${th.headmaster }</a></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-light"
													data-dismiss="modal">关闭</button>
												<button type="button" class="btn btn-primary"
													onclick="fenBanSave()">保存</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->

								<!-- ============================================================== -->
								<!-- End Page content -->
								<!-- ============================================================== -->


							</div>
							<!-- App js -->
							<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
							<script type="text/javascript"
								src="${Path }/static/js/admin/leftSidebar.js"></script>
							<script type="text/javascript"
								src="${Path }/static/js/root/classAssignment/seeStudentInfo.js"></script></body>
</html>
