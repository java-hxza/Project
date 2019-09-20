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
		<%@include file="/WEB-INF/jsp/leftSidebar/leftSidebar.jsp"%>
		<div class="content-page">
			<div class="content">

				<!-- Start Content-->
				<div class="container-fluid">

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
								<button type="button" class="btn btn-success btn-sm mt-2"
									onclick="print()">打印订单</button>
								<button type="button" class="btn btn-info btn-sm mt-2 ml-1"
									onclick="exportExsal()">导出exsal</button>
							</div>
						</div>
						<!-- end col -->
					</div>
					<!-- end row -->
					<!-- Question/Answer -->
					<div class="table-responsive">
						<!--startprint-->
						<h3 style="display: none;text-align: center;" id="tables">教师课时总报表</h3>
						<table
							class="table table-centered table-striped dt-responsive nowrap w-100"
							id="products-datatable" border="1px solid" width="100%">
							<tbody>
								<tr>
									<td>序</td>
									<td>校区</td>
									<td>教师名称</td>
									<td>课时名称</td>
									<td>教师总课时</td>
								</tr>
							</tbody>
							<tbody>
								<c:forEach items="${teacherHourList }" var="th"
									varStatus="status">
									<tr>
										<td class="table-user">${status.index }</td>
										<td class="table-user">${schoolName}</td>
										<td class="table-user">${th.teacherName}</td>
										<td class="table-user">${th.dpName }</td>
										<td class="table-user">${th.sumHours }</td>
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
				<script src="${Path }/static/js/admin/info/schoolInfo.js"></script>
				<script src="${Path }/static/js/admin/leftSidebar.js"></script>
</body>
</html>
