<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
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
		<!-- Left Sidebar End -->

		<!-- ============================================================== -->
		<!-- Start Page Content here -->
		<!-- ============================================================== -->

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
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">

									<!-- Checkout Steps -->
									<ul class="nav nav-pills bg-nav-pills nav-justified mb-3">
										<li class="nav-item"><a href="#billing-information"
											data-toggle="tab" aria-expanded="false"
											class="nav-link rounded-0 active"> <i
												class="mdi mdi-account-circle font-18"></i> <span
												class="d-none d-lg-block">请核对学员信息</span>
										</a></li>

									</ul>

									<!-- Steps Information -->
									<div class="tab-content">

										<!-- Billing Content-->
										<div class="tab-pane show active" id="billing-information">
											<div class="row">
												<div class="col-lg-8">
													<h4 class="mt-2">学员退费</h4>

													<p class="text-muted mb-4"></p>

													<form>
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-first-name">名字</label> <input
																		class="form-control" type="text" value="${studentName}" name="${studentId }" id="studentId" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">退费日期</label>
																		<input type="date" class="form-control" value="" id="startTime">
																</div>
															</div>
														</div>
														<!-- end row -->
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-email-address">退费项目<span
																		class="text-danger">*</span></label> 
																		<input class="form-control" type="text" name="${feeIds }" value="${feeIdName }"
																		id="feeIds" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-phone">退费方式<span
																		class="text-danger">*</span></label> 
																		<select id="paymentmethodId" class="form-control">
																			<c:forEach items="${paymentMethods }" var="p">
																				<option value="${p.paymentmethodId }">${p.paymentmethodName }</option>
																			</c:forEach>
																		</select>
																</div>
															</div>

														</div>
														<div class="row">
															<div class="col-6">
																<div class="form-group">
																	<label for="billing-address">收款总额</label> <input
																		class="form-control" type="text" value="${sumMoney }" id="sumMoney">
																</div>
															</div>
															<div class="col-6">													<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-phone">退费方式<span
																		class="text-danger">*</span></label> 
																		<select id="expenditureitemsId" class="form-control">
																			<c:forEach items="${expenditureitems }" var="e">
																				<option value="${e.expenditureitemsId}">${e.expenditureitemsName }</option>
																			</c:forEach>
																		</select>
																</div>
															</div>
														</div>
														<!-- end row -->
														<div class="row">
															<div class="col-6">
																<div class="form-group">
																	<label for="billing-address">退款总额</label> <input
																		class="form-control" type="text"  value="${nowPrice }" id="nowPrice">
																</div>
															</div>
															
															<div class="col-6">
																<div class="form-group">
																	<label for="example-textarea">备注</label>
																	<textarea class="form-control" id="remarks" name="${classId}" rows="1"
																		placeholder="Write some note.."></textarea>
																</div>
															</div>
														</div>
													</div>

														<!-- end row -->

														<div class="row mt-4">
															<div class="col-sm-6">
																<a href="apps-ecommerce-shopping-cart.html"
																	class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
																	<i class="mdi mdi-arrow-left"></i> Back to Shopping
																	Cart
																</a>
															</div>
															<!-- end col -->
															<div class="col-sm-6">
																<div class="text-sm-right">
																	<a href="javascript:void(0)" class="btn btn-danger"
																		onclick="save()"> <i
																		class="mdi mdi-truck-fast mr-1"></i> 保存
																	</a>
																</div>
															</div>
															<!-- end col -->
														</div>
														<!-- end row -->
													</form>
												</div>
											</div>
											<!-- End Billing Information Content-->
										</div>
										<!-- end tab content-->

									</div>
									<!-- end card-body-->
								</div>
								<!-- end card-->
							</div>
							<!-- end col -->
						</div>
						<!-- end row-->

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


		<div class="rightbar-overlay"></div>
		<!-- /Right-bar -->


		<!-- App js -->
		<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
		<script type="text/javascript" src="${Path }/static/js/root/studentInfo/high/highExitSchool.js"></script>
		
		<script type="text/javascript">
		
			$(function(){
				//设置日期默认值为当天
	            var nowDate=new Date();     
	            var nowMonth=nowDate.getMonth()+1;   //月份和日期若为小于10的数要做处理
	            var nowDay=nowDate.getDate(); 
	            if((nowDate.getMonth()+1)<10){    
	                nowMonth="0"+nowMonth; 
	            }
	            if(nowDate.getDate()<10){
	                nowDay='0'+nowDay;
	            }
	            var dateVal=nowDate.getFullYear()+"-"+nowMonth+"-"+nowDay; 
				
				$("#startTime").val(dateVal);
			});
		</script>
</body>

</html>