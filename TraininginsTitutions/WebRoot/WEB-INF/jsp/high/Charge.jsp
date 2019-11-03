<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>全国统一收费单</title>
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

				<!-- Start Content-->
				<div class="container-fluid">
					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<div class="page-title-right">
									<ol class="breadcrumb m-0">
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">培训收费</a></li>
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">按时间段收费单</a></li>
									</ol>
								</div>
								<h4 class="page-title">按时间段收费单</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<c:choose>
										<c:when test="${schoolType == 2}">
											<h4 style="text-align:center" class="Type"
												name="${schoolType }">收费单</h4>
										</c:when>
										<c:otherwise>
											<h4 style="text-align:center" class="Type"
												name="${schoolType }">按时间段收费单</h4>
										</c:otherwise>
									</c:choose>
									<span style="display: none;" class="QX">${state }</span>
									<div class="showOrder">
										<div class="col-12">
											<div class="card">
												<div class="card-body">
													<div class="row mb-2">
														<div class="col-sm-4">
															<a href="${Path }/ChargePeriod.html"
																class="btn btn-danger mb-2"><i
																class="mdi mdi-plus-circle mr-2"></i> 添加</a> <a
																href="javascript:void(0);"
																class="btn btn-danger mb-2 del" onclick="updateOrder()"><i
																class="mdi mdi-plus-circle mr-2"></i> 修改</a> <a
																href="javascript:void(0);"
																class="btn btn-danger mb-2 del" onclick="delOrder()"><i
																class="mdi mdi-plus-circle mr-2"></i> 删除</a>
															<button type="button" id="btn2"
																class="btn btn-danger mb-2" onclick="Printing()">打印</button>
															<button type="button" id="btn2"
																class="btn btn-danger mb-2 Exports">导出Excel</button>
																<a href="${pageContext.request.contextPath }/BulkCharging.html"><input type="button" class="btn btn-danger mb-2" value="批量收费"></a>
														</div>
														<div class="row col-sm-12">
															<div class="col-md-2">
																<div class="input-group">
																	<select class="form-control classesId"
																		id="example-select">
																		<option value="0">---请选择---</option>
																		<c:forEach items="${classes }" var="c">
																			<option value="${c.classId }">${c.className}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-2">
																<div class="input-group">
																	<input class="form-control studentName" type="text"
																		id="billing-first-name" placeholder="学生姓名" />
																	<button class="btn btn-dark  " type="button"
																		onclick=Hour()>查找</button>
																</div>
															</div>
														</div>
														<!-- end col-->
													</div>

													<div class="row" id="dayin" style="display: none;">
														<!--startprint-->
														<div class="col-12">
															<div class="card">
																<div class="card-body">
																	<h4 style="text-align:center">全国统一收款收据</h4>
																	<div class="row mb-2">
																		<table id="ChargePeriods" border="1" width="100%">
																			<tr>
																				<th width="400" height="20px" class="RiQi"
																					style="text-align: left;"></th>
																				<th width="400" colspan="2" height="20px"></th>
																				<th width="100" height="20px"></th>
																				<th width="300" height="20px" class="BDKC"></th>
																				<th width="400" height="20px" class="DJBH"></th>
																			</tr>
																			<tr>
																				<td width="400" height="40px" class="XSXM"></td>
																				<td width="100" height="40px"></td>
																				<td width="300" height="40px" class="NL"></td>
																				<td width="400" height="40px" colspan="2"></td>
																				<td width="400" height="40px" class="JDXX"></td>
																			</tr>
																			<tr>
																				<td width="400" height="40px" class="KS"></td>
																				<td width="100" height="40px"></td>
																				<td width="300" height="40px" class="YXQ"></td>
																				<td width="800" colspan="4"
																					style="text-align:center;" height="40px"
																					class="FLYQX"></td>
																			</tr>
																			<tr class="apps">
																				<td width="800" colspan="3"
																					style="text-align:center" height="40px">货物或劳务、服务名称：</td>
																				<td width="800" colspan="3"
																					style="text-align:center" height="40px">金额</td>
																			</tr>


																			<tr>
																				<td width="800" colspan="3" height="40px"></td>
																				<td width="800" colspan="3"
																					style="text-align:center" height="40px"></td>
																			</tr>
																			<tr>
																				<td width="800" colspan="3" height="40px"></td>
																				<td width="800" colspan="3"
																					style="text-align:center" height="40px"></td>
																			</tr>
																			<tr>
																				<td width="400" height="40px"
																					style="text-align:center;border-right: 0px;">人民币大写：</td>
																				<td width="800" height="40px" colspan="4"
																					style="border-left: 0px;"></td>
																				<td width="400" height="40px" class="MONEY"></td>
																			</tr>
																			<tr>
																				<td width="500" height="80px" colspan="2">收款单位盖章：</td>
																				<td width="400" height="80px" colspan="2">收款人：</td>
																				<td width="700" height="80px" colspan="2" readonly>备注：</td>
																			</tr>
																		</table>
																	</div>

																	<!-- end card-body-->
																</div>
																<!-- end card-->
															</div>
															<!-- end col -->
															<!--endprint-->
															<iframe id="iframe1" style="display: none"></iframe>
															<div class="col-md-12">
																<div class="form-group">
																	<button type="button"
																		class="btn btn-block btn-primary DaYins"
																		onclick="DaYins()">打印</button>
																</div>
															</div>
															<div class="col-md-12" style="display: none;">
																<div class="form-group">
																	<button type="button"
																		class="btn btn-block btn-primary DaYins2">导出</button>
																</div>
															</div>
														</div>
														<!-- end row -->

													</div>

													<div class="table-responsive mt-4 Expenditureitemses">
														<table class="table table-bordered table-centered mb-0">
															<thead class="thead-light">
																<tr>
																	<th style="width: 20px;">
																		<div class="custom-control custom-checkbox">
																			<input type="checkbox" class="custom-control-input"
																				id="customCheck1" disabled> <label
																				class="custom-control-label" for="customCheck1">&nbsp;</label>
																		</div>
																	</th>
																	<th class="LX" name="${schoolType }">序</th>
																	<th>校区信息</th>
																	<th>收款日期</th>
																	<th>收款项目</th>
																	<th>学员</th>
																	<th>资金账户</th>
																	<th>实收金额</th>
																	<th>费用时间起</th>
																	<th>费用时间止</th>
																	<th>责任人</th>
																	<th>备注</th>
																	<th>单号</th>
																	<th>积分</th>
																	<th>赠品名称</th>
																	<th>赠品数量</th>
																	<th>打折金额</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${order}" var="o">
																	<tr>
																		<td>
																			<div class="custom-control custom-checkbox">
																				<input type="checkbox"
																					class="custom-control-input customCheckes">
																				<label class="custom-control-label customCheck"
																					for="customCheck2">&nbsp;</label>
																			</div>
																		</td>
																		<td class="${o.stuId }">${o.orderId }</td>
																		<td>${o.school.schoolName }</td>
																		<td><fmt:formatDate value="${o.startTime }"
																				pattern="yyyy-MM-dd HH:mm" /></td>
																		<td class="feecateIds2" name="${o.feecateId }"></td>
																		<td>${o.student.studentName }</td>
																		<td class="${o.paymentmethodId }">${o.paymentMethod.paymentmethodName }</td>
																		<td>${o.dpMoney }</td>
																		<td><fmt:formatDate value="${o.firstdate }"
																				pattern="yyyy-MM-dd" /></td>
																		<td class="${o.giftId }"><fmt:formatDate
																				value="${o.lastdate }" pattern="yyyy-MM-dd" /></td>
																		<td class="${o.giftNumber }">${o.personliable }</td>
																		<td class="${o.integral }">${o.remarks }</td>
																		<td class="${o.teacherId }">${o.orderNumber }</td>
																		<td>${o.integral }</td>
																		<td class="giftIdes" name="${o.giftId}"><c:if
																				test="${o.giftId == 0 }">无</c:if> <c:if
																				test="${o.giftId != 0 }"></c:if></td>
																		<td><c:if test="${o.giftNumber == 0 }">无</c:if> <c:if
																				test="${o.giftNumber != 0 }">${o.giftNumber }</c:if>
																		</td>
																		<td><c:if test="${o.discount != null }">${o.discount }</c:if>
																			<c:if test="${o.discount == null }">0.0</c:if></td>
																		<!--  -->
																		<td style="display: none;">${o.student.studentBirth }</td>
																		<td class="ids" style="display: none;">${o.classId }</td>
																		<td class="feecateMoneysx" style="display: none;">${o.feecateMoney }</td>
																		<td style="display: none;">${o.activityId }</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
														<c:if test="${JY == 1 }">
															<div class="float-right">
															<a
																href="${pageContext.request.contextPath }/selectOrderPeriod.html?orderCounts=0&classId=0&studentName=000111"><input
																type='button' class='btn btn-info button-next'
																name='next' value="首页" /></a> <a
																href="${pageContext.request.contextPath }/selectOrderPeriod.html?classId=0&studentName=000111&orderCounts= ${orderCounts - 2 }"><input
																type='button' class='btn btn-info button-last'
																name='last' value="上一页" /></a> <input type='button'
																class='btn btn-info button-last' name='last'
																value="${orderCounts }/${orderCount }" /> <a
																href="${pageContext.request.contextPath }/selectOrderPeriod.html?classId=0&studentName=000111&orderCounts= ${orderCounts}"><input
																type='button' class='btn btn-info button-next'
																name='next' value="下一页" /></a> <a
																href="${pageContext.request.contextPath }/selectOrderPeriod.html?classId=0&studentName=000111&orderCounts= ${orderCount }"><input
																type='button' class='btn btn-info button-last'
																name='last' value="末页" /></a>
														</div>
														</c:if>
													</div>
													<!-- end card-body-->
												</div>
												<!-- end card-->
											</div>
											<!-- end col -->
										</div>
										<!-- end row -->
									</div>

									<div class="form-group mb-3" style="display: none;">
										<label for="example-select">课程类型</label> <select
											class="form-control departmentOfPediatrics"
											id="example-select">
											<c:forEach items="${departmentOfPediatrics }" var="d">
												<option value="${d.dpId }">${d.dpTypeName}</option>
											</c:forEach>
										</select>
									</div>

									<div class="row mb-2 addOrder" style="display: none;">
										<div class="col-md-12">
											<form class="needs-validation" novalidate>
												<div class="row">
													<div class="col-md-6" style="display: none;">
														<div class="form-group mb-3">
															<label for="example-select">核算项目</label> <select
																class="form-control feecateIds" id="example-select">
																<c:forEach items="${feeCategory }" var="f">
																	<option value="${f.chargeTypeId }">${f.chargeTypeName}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group mb-3">
															<label for="example-select">学员</label> <input
																class="form-control stuId" type="text"
																id="billing-last-name" disabled />
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="billing-last-name">收款日期</label> <input
																class="form-control date" type="text"
																id="billing-last-name" disabled />
														</div>
													</div>
													<c:forEach items="${feeCategory }" var="f">
														<div class="col-md-6">
															<div class="form-group mb-3">
																<label for="example-select" class="feecateName">${f.chargeTypeName}</label>
																<input class="form-control feecateIds3"
																	id="example-number" type="number" name="number"
																	chargeTypeId="${f.chargeTypeId }">

															</div>
														</div>
													</c:forEach>
													<div class="col-md-6">
														<div class="form-group mb-3">
															<label for="example-select">收款方式</label> <select
																class="form-control paymentmethodId" id="example-select">
																<c:forEach items="${paymentMethod }" var="p">
																	<option value="${p.paymentmethodId }">${p.paymentmethodName}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group mb-3">
															<label for="example-number">应收金额</label> <input
																class="form-control dpMoney" id="example-number"
																type="number" name="number" disabled="disabled">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group mb-3">
															<label for="example-date">起始日期</label> <input
																class="form-control firstdate" id="example-date"
																type="date" name="date">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group mb-3">
															<label for="example-date">截止日期</label> <input
																class="form-control lastdate" id="example-date"
																type="date" name="date">
														</div>
													</div>

													<div class="col-md-6 giftNames">
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
													<div class="col-md-6 giftNumbers">
														<div class="form-group">
															<label for="billing-last-name">赠品数量</label> <input
																type="text" class="form-control giftNumber"
																data-toggle="input-mask"
																data-mask-format="00000000000000000" data-reverse="true">
														</div>
													</div>
													<div class="col-md-6 feecateId4s">
														<div class="form-group mb-3">
															<label for="example-select">活动名称</label> <select
																class="form-control feecateId4 " id="example-select">
																<option value="0">---请选择---</option>
																<c:forEach items="${activity }" var="a">
																	<option value="${a.activityId }"
																		activityMoney="${a.activityMoney }"
																		discount="${a.discount }">${a.activityName }
																	</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group mb-3">
															<label for="example-number">实收金额</label> <input
																class="form-control dpMoneyActivity4"
																id="example-number" type="number" name="number">
														</div>
													</div>
													<div class="col-md-6 integrals">
														<div class="form-group mb-3">
															<label for="example-select">积分</label> <input
																class="form-control integral" id="example-number"
																type="number" name="number">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="billing-first-name">责任人</label> <input
																class="form-control personliable" type="text"
																id="billing-first-name" />
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="billing-last-name">备注</label> <input
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
													<div class="col-md-12">
														<div class="form-group">
															<button type="button"
																class="btn btn-block btn-primary DaYins">打印</button>
														</div>
													</div>
													<div class="col-md-12" style="display: none;">
														<div class="form-group">
															<button type="button"
																class="btn btn-block btn-primary DaYins2">导出</button>
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
								<i
									class="mdi mdi-upload bg-info-lighten text-info timeline-icon"></i>
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
								<i
									class="mdi mdi-upload bg-info-lighten text-info timeline-icon"></i>
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
				src="${Path }/static/js/highes/Charge.js"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$(".Exports").click(function() {
						$(".dels").remove();
						$(".dels").next().remove();
						$("#dayin").hide();
						if ($(".customCheckes:checked").length < 1) {
							if (!$(".customCheckes").prop("checked")) {
								alert("请选中一条数据！");
								return false;
							}
						} else if ($(".customCheckes:checked").length > 1) {
							alert("只能选中一条数据！");
							return false;
						}
						$("#dayin").show();
						$(".DaYins").hide();
						$(".DaYins2").parent().parent().show();
						var Time = new Date();
						var gender = new Date($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text());
						var year = Time.getTime() - gender.getTime();
						var month = Math.ceil(year / 1000 / 60 / 60 / 24 / 365);
						$(".NL").text("年龄： " + (month).toString());
						$(".RiQi").text("日期：" + $(".customCheckes:checked").parent().parent().next().next().next().text() + "                   ");
						$(".DJBH").text("单据编号：" + "(" + $(".customCheckes:checked").parent().parent().next().next().text() + ")" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().text());
						$(".BDKC").text("报读课程：" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text());
						$(".XSXM").text("学生姓名: " + $(".customCheckes:checked").parent().parent().next().next().next().next().next().text());
						$(".JDXX").text("就读学校：" + $(".customCheckes:checked").parent().parent().next().next().text());
						var start = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text();
						var end = $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text();
						start = start.replace(/-/g, "/");
						var startdate = new Date(start);
						end = end.replace(/-/g, "/");
						var enddate = new Date(end);
						time = parseInt((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
						$(".KS").text("课时：" + time + "天");
						$(".YXQ").text("课程有效期：" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text());
						$(".FLYQX").text($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().text() + "   至   " + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().text());
						if ($.trim($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text()) != "无") {
							$(".MONEY").text("应收￥" + (parseFloat($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text()) + parseFloat($(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text())) + "/实收￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
						} else {
							$(".MONEY").text("应收￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text() + "/实收￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().text());
						}
						for (var i = 0; i < $(".customCheckes:checked").parent().parent().next().next().next().next().text().split("/").length; i++) {
							var RMB = 0;
							for (var j = 0; j < $(".feecateIds option").length; j++) {
								if ($(".customCheckes:checked").parent().parent().next().next().next().next().text().split("/")[i] == $(".feecateIds option").eq(j).text()) {
									RMB = $(".feecateIds option").eq(j).attr("name");
								}
							}
							$(".apps").after("<tr class='dels'><td width='800' colspan='3' height='40px'>" + $(".customCheckes:checked").parent().parent().next().next().next().next().text().split("/")[i] + "</td><td width='800' colspan='3' style='text-align:center'height='40px'>￥" + $(".customCheckes:checked").parent().parent().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().next().text().split(",")[i] + "</td></tr>");
						}
						$("#ChargePeriods td").click(function() {
							if ($(".WBK").val() == ".") {
								$(".WBK").parent().remove();
							} else {
								$(".WBK").parent().text($(".WBK").val());
							}
							$(".WBK").remove();
							$(this).append("<input type='text' class='WBK'/>");
							$(".WBK").focus();
							$(".WBK").val($(this).text());
			
						});
					});
					$(".DaYins2").click(function() {
						$(".WBK").remove();
						excel = new ExcelGen({
							"src_id" : "ChargePeriods",
							"show_header" : true
						});
						excel.generate("时间段收费单", $(".customCheckes:checked").parent().parent().next().next().next().next().next().text());
					});
				});
			</script>

			<!-- third party js ends -->
</body>
</html>
<!-- <div class="form-group">
                                                        <label>São Paulo Celphones</label>
                                                        <input type="text" class="form-control" data-toggle="input-mask" data-mask-format="(00) 00000-0000">
                                                        <span class="font-13 text-muted">e.g "(xx) xxxxx-xxxx"</span>
                                                    </div> -->