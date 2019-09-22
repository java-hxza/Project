<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<style type="text/css">
.text-body {
	text-decoration: none;
	color: black;
}
<style type="text/css">
</style>
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
								<h4 class="page-title">收入明细报表</h4>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<div class="text-center">
								<h3 class="">管理学校及城市</h3>
								<p class="text-muted mt-3" id="schoolId"
									id_schoolName="${schoolName}" name=${schoolId }>请按规则查询</p>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row mb-2">
									<div class="col-sm-4">
										<a href="javascript:void(0);" onclick="expen()"
											class="btn btn-danger mb-2"><i
											class="mdi mdi-plus-circle mr-2"></i> 支出查询</a>
									</div>
									<div class="col-sm-8">
										<div class="text-sm-right">

											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="print()">打印</button>
											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="exportExsal()">导出</button>
											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="query()">收入查询</button>
										</div>
									</div>
									<!-- end col-->
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="billing-first-name">开始日期</label> <input
												class="form-control" type="date" id="startTime" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="billing-first-name">支出项目</label> <select
												id="expenditureitemsId" class="form-control">
												<option value="">请选择</option>
												<c:forEach items="${expenditureitemList}" var="expen">
													<option value="${expen.expenditureitemsId }">${expen.expenditureitemsName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="billing-first-name">结束日期</label> <input
												class="form-control" type="date" id="endTime" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">账户</label> <select
												id="paymentmethodId" class="form-control">
												<option value="">请选择</option>
												<c:forEach items="${payMentList}" var="pay">
													<option value="${pay.paymentmethodId }">${pay.paymentmethodName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">收入类型:</label> <select
												id="feecateId" class="form-control">
												<option value="">请选择</option>
												<c:forEach items="${feeCategoryList}" var="fee">
													<option value="${fee.chargeTypeId}">${fee.chargeTypeName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">班级:</label> <select
												id="classId" class="form-control">
												<option value="">请选择</option>
												<c:forEach items="${classBySchooList}" var="c">
													<option value="${c.classId}">${c.className}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">课程:</label> <select
												id="departmentofpediatricsId" class="form-control">
												<option value="">请选择</option>
												<c:forEach items="${departmentOfPediatricsList}" var="dp">
													<option value="${dp.dpId}">${dp.dpTypeName }</option>
												</c:forEach>
											</select>
										</div>
									</div>

								</div>
							</div>
							<!-- end col -->
							<!-- Question/Answer -->
							<div class="table-responsive">
								<!--startprint-->
								<h3 style="text-align: center;" id="tables">收支明细报表</h3>
								<table
									class="table table-centered table-striped dt-responsive nowrap w-100"
									id="products-datatable" border="1px solid" width="100%">
									<tbody>
										<tr>
											<td>订单编号</td>
											<td>收款人</td>
											<td>日期</td>
											<td>项目名称</td>
											<td>收款金额</td>
											<td>收款方式</td>
											<td>责任人</td>
											<td>课程</td>
											<td>新增课时</td>
											<td>赠送课时</td>
											<td>费用起始日</td>
											<td>费用截至日</td>
										</tr>
									</tbody>
									<tbody id="info">
										<c:forEach items="${orderListBySchool}" var="order">
											<tr class="userId">
												<td class="table-user">${order.orderNumber }</td>
												<td class="table-user">${order.student.studentName }</td>
												<td class="table-user"><fmt:formatDate
														value="${order.startTime }" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate>
												</td>
												<td class="table-user">
													${order.feeCategory.chargeTypeName }</td>
												<td class="table-user">${order.dpMoney }</td>
												<td class="table-user">${order.paymentMethod.paymentmethodName }
												</td>
												<td class="table-user">${order.personliable }</td>
												<td class="table-user">${order.departmentOfPediatrics.dpTypeName }
												</td>
												<td class="table-user">${order.addhour }</td>
												<td class="table-user">${order.givehour }</td>
												<td class="table-user"><fmt:formatDate
														value="${order.firstdate }" pattern="yyyy-MM-dd" /></td>
												<td class="table-user"><fmt:formatDate
														value="${order.lastdate }" pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:forEach>
									</tbody>
									<tbody id = "expen" style='text-align: center;'>
										<tr>
											<td colspan='6' >支出总额</td>
											<td colspan='6' >收入总额</td>
										</tr>
										<tr>
											<td colspan='6' >${schoolExPenSum }</td>
											<td colspan='6' >${schoolFeeceat }</td>
										</tr>
									</tbody>
								</table>
								<!--endprint-->
							</div>
							<iframe id="iframe1" style="display: none;">
								
							 </iframe>
							<!-- ============================================================== -->
							<!-- End Page content -->
							<!-- ============================================================== -->

						</div>

						<!-- App js -->
						<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
						<script type="text/javascript"
						<script src="${Path }/static/js/root/orderSchool/selectOrderSchoolInfo.js"></script>
						<script src="${Path }/static/js/admin/operator.js"></script>
</html>
