<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }" var="Path" />
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
		<%@include file="/WEB-INF/jsp/admin/bar/leftSidebar.jsp" %>		
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
								<h4 class="page-title">学校信息</h4>
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
												<button type="button" class="btn btn-success btn-sm mt-2"
													onclick="createSchool()">创建学校</button>
											</div>
											<div class="col-sm-8">
												<div class="text-sm-right">
													<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
														onclick="createUser()">创建账号</button>
													<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
														onclick="createTeacher()">创建教师账号</button>
												</div>
											</div>
											<!-- end col-->
										</div>

					<!-- end row -->
                                <!-- Question/Answer -->
                                	<div class="table-responsive">
										<table
											class="table table-centered table-striped dt-responsive nowrap w-100"
											id="products-datatable">
											<thead>
												<tr>
													<th style="width: 20px;">
														<div class="custom-control custom-checkbox">
															<input type="checkbox" class="custom-control-input"
																id="customCheck1"> <label
																class="custom-control-label" for="customCheck1">&nbsp;</label>
														</div>
													</th>
													<th>学校编号</th>
													<th>学校名称</th>
													<th>学校所属城市</th>
													<th>学校备注</th>
													<th>学校所属省份</th>
													<th>学校所属级别</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${schoolListAll }" var="school">
													<tr class="schoolId" >
														<td>
															<div class="custom-control custom-checkbox">
																<input type="checkbox" class="custom-control-input"
																	id="customCheck2"> <label class="custom-control-label" for="customCheck2">&nbsp;</label>
															</div>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${school.schoolId }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${school.schoolName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${school.city.cityName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${school.schoolRemarks }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${school.province.provinceName }</a>
														</td>
														<c:choose>
															<c:when test="${school.schoolType == 1 }">
																<td class="table-user"><a href="javascript:void(0);"
																	class="text-body font-weight-semibold" name = "${school.schoolType}" >少儿</a>
																</td>
															</c:when>
															<c:when test="${school.schoolType == 2 }">
																<td class="table-user"><a href="javascript:void(0);"
																	class="text-body font-weight-semibold" name = "${school.schoolType}" >高中</a>
																</td>
															</c:when>
															<c:otherwise>
																<td class="table-user"><a href="javascript:void(0);"
																	class="text-body font-weight-semibold" name = "${school.schoolType}">艺考</a>
																</td>
															</c:otherwise>
														</c:choose>
													</tr>
												</c:forEach>	
											</tbody>
										</table>
									</div>

							

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->


        </div>
				<!-- App js -->
				<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp" %>
				<script type="text/javascript" src="${Path }/static/js/admin/leftSidebar.js"></script>
				<script src="${Path }/static/js/admin/expen/selectSchoolExpenInfo.js"></script>
</body>
</html>
