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
</style>
</head>

<body>

	<!-- Begin page -->
	<div class="wrapper">

		<!-- ========== Left Sidebar Start ========== -->
		<%@include file="/WEB-INF/jsp/leftSidebar/leftSidebar.jsp" %>		
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
										<a href="javascript:void(0);" onclick="queryArtStudentFee()"
											class="btn btn-danger mb-2"><i
											class="mdi mdi-plus-circle mr-2"></i> 查询</a>
									</div>
									<div class="col-sm-8">
										<div class="text-sm-right">

											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="print()">打印</button>
											<button type="button" id="btn2"
												class="btn btn-success btn-sm mt-2" onclick="exportExsal()">导出</button>
										</div>
									</div>
									<!-- end col-->
								</div>


								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="billing-first-name">开始日期</label> <input
												class="form-control" type="date" id="startTime" />
										</div>
									</div>
									<div class="col-md-6">
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
												id="paymentmethodId" class="form-control col-sm-8">
												<option value="">请选择</option>
												<c:forEach items="${paymentMethods}" var="pay">
													<option value="${pay.paymentmethodId }">${pay.paymentmethodName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">收入类型:</label> <select
												id="feecateId" class="form-control col-sm-8">
												<option value="">请选择</option>
												<c:forEach items="${feeCategories }" var="fee">
													<option value="${fee.chargeTypeId}">${fee.chargeTypeName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">班级:</label> <select
												id="classId" class="form-control col-sm-8">
												<option value="">请选择</option>
												<c:forEach items="${classBySchooList}" var="c">
													<option value="${c.classId}">${c.className}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="billing-first-name">分班情况:</label> <select
												id="state" class="form-control col-sm-8">
													<option value="">请选择</option>
													<option value="0">未分班</option>
													<option value="1">已分班</option>
											</select>
										</div>
									</div>
								</div>

							</div>
							<!-- end col -->
							<!-- Question/Answer -->

							<div class="table-responsive" id="dayin">
								<!--startprint-->
								<h3 style="text-align: center;" id="tables">艺考明细报表</h3>
								<table
									class="table table-centered table-striped dt-responsive nowrap w-100"
									id="products-datatable" border="1px solid" width="100%">
									<tbody>
										<tr>
											<td>订单编号</td>
											<td>入学日期</td>
											<td>学生姓名</td>
											<td>身份证号</td>
											<td>联系电话</td>
											<td>家长姓名</td>
											<td>接待人员</td>
											<td>高中学校</td>
											<td>预定校区</td>
											<td>预定班型</td>
											<td>宿舍号</td>
											<td>几人间</td>
											<td>备注</td>
											<%
												int num = 0;
												int index = 0;
											%>

											<c:forEach items="${feeCategories }" var="fee">
												<%
													num = num + 1;
												%>
												<td>${fee.chargeTypeName}</td>
											</c:forEach>
											<td>实付金额</td>
											<td>应收金额</td>
											<td>分班情况</td>
										</tr>
									</tbody>

									<tbody id="info">
										<c:forEach items="${artStudentInfoList}" var="art"
											varStatus="status">
											<tr class="userId">
												<td class="table-user">${art.order.orderNumber }</td>
												<td class="table-user"><fmt:formatDate
														value="${art.order.startTime }" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate>
												</td>
												<td class="table-user">${art.studentName }</td>
												<td class="table-user">${art.studentIDCard }</td>
												<td class="table-user">${art.telephone }</td>
												<td class="table-user">${art.parentName}</td>
												<td class="table-user">${art.registrationConsultant }</td>
												<td class="table-user">${art.school}</td>
												<td class="table-user">${schoolName }</td>
												<c:forEach items="${feecateMoneyYiKaoList }" var="yikao">
													<c:forEach items="${yikao }" var="yi">
														<td class="table-user">${yi}</td>
													</c:forEach>
												</c:forEach>
												<td class="table-user">${art.remarks }</td>
												<c:forEach items="${feeCategories }" var="fee" begin="<%=index %>"
															end="<%=index %>">
													<c:forEach items="${feeIdArray }"  var="feeId">
														<c:forEach items="${feeId }" var="fId" >
															<c:if test="${fee.chargeTypeId == fId}">
																<c:forEach items="${feeMoneyArray }" var="moneyArray">
																	<c:forEach items="${moneyArray }" var="m">
																		<td class="table-user">${m }</td>
																	</c:forEach>
																</c:forEach>
															</c:if>
														</c:forEach>
													</c:forEach>
												</c:forEach>
												<td class="table-user">${art.order.dpMoney }</td>
												<c:set var="dpMoneySum"
													value="${art.order.dpMoney + dpMoneySum}" />
												<c:set var="sumMoney"
													value="${art.order.dpMoney+art.order.discount + sumMoney}" />
												<td class="table-user">${art.order.dpMoney+art.order.discount }</td>
												<c:if test="${art.reserveschool.state == 1 }">
													<td class="table-user">分班</td>
												</c:if>
												<c:if test="${art.reserveschool.state == 0 }">
													<td class="table-user">未分班</td>
												</c:if>
											</tr>
											<%
												index = index + 1;
											%>
										</c:forEach>

									</tbody>
									<tbody id="expen" style='text-align: center;'>
										<tr>
											<td colspan='<%=num / 2 + 8%>'>实收总额</td>
											<td colspan='<%=num / 2 + 9%>'>应收总额</td>
										</tr>
										<tr>
											<td colspan='<%=num / 2 + 8%>'>${ dpMoneySum}</td>
											<td colspan='<%=num / 2 + 9%>'>${sumMoney }</td>
										</tr>
									</tbody>
								</table>
								<!--endprint-->
							</div>
							<iframe id="iframe1" style="display: none"></iframe>
							<!-- ============================================================== -->
							<!-- End Page content -->
							<!-- ============================================================== -->

						</div>
						<!-- App js -->
						<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
						<script type="text/javascript"
							src="${Path }/static/js/admin/adminIndex.js"></script>
						<script src="${Path }/static/js/admin/leftSidebar.js"></script>
						<script
							src="${Path }/static/js/root/ArtStudentFee/adminArtStudentFeeInfo.js"></script>
</html>
