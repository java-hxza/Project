<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<style type="text/css">

</style>
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
								<h3 class="">管理学校及城市</h3>
								<p class="text-muted mt-3" id="schoolId" id_schoolName="${schoolName}" name=${schoolId }>请按规则查询</p>
									
                                    <button type="button" class="btn btn-success btn-sm mt-2" onclick="query()">查询</button>
                             </div>
                          </div>
                     </div>      
                                 
                        <div class="row">
                         	<div  class="col-md-6">
								<div class="form-group">
									<label for="billing-first-name">开始日期</label> <input
										class="form-control" type="date" id="startTime" />
								</div>
							</div>		
							<div class="col-md-6">
								<div class="form-group">
									<label for="billing-first-name">结束日期</label> <input class="form-control" type="date" id="endTime" />
								</div>
							</div>
						</div>
								
                        <div class="row">
                       		<div  class="col-md-4">
								<div class="form-group">
									<label for="billing-first-name">账户</label> 
									<select id="paymentmethodId" class="form-control col-sm-4">
                            			<option value="0">请选择</option>
                            			<c:forEach items="${payMentList}" var="pay">
                            				<option value="${pay.paymentmethodId }">${pay.paymentmethodName }</option>
                            			</c:forEach>
                           			</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="billing-first-name">收入类型:</label> 
									<select id="feecateId" class="form-control col-sm-4" >
                            			<option value="0">请选择</option>
                            			<c:forEach items="${feeCategoryList}" var="fee">
                            				<option value="${fee.chargeTypeId}">${fee.chargeTypeName }</option>
                            			</c:forEach>
                      				</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="billing-first-name">课程:</label> 
                            		<select id="departmentofpediatricsId" class="form-control col-sm-4">
                            			<option value="0">请选择</option>
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
										<table
											class="table table-centered table-striped dt-responsive nowrap w-100"
											id="products-datatable">
											<thead>
												<tr>
													<th style="width: 20px;">
														<div class="custom-control custom-checkbox">
															<input type="checkbox" class="custom-control-input"
																id="customCheck1" disabled> <label
																class="custom-control-label" for="customCheck1">&nbsp;</label>
														</div>
													</th>
													<th>订单编号</th>
													<th>收款人</th>
													<th>日期</th>
													<th>项目名称</th>
													<th>收款金额</th>
													<th>收款方式</th>
													<th>责任人</th>
													<th>课程</th>
													<th>新增课时</th>
													<th>赠送课时</th>
													<th>费用起始日</th>
													<th>费用截至日</th>
												</tr>
											</thead>
											<tbody id="info">
												<c:forEach items="${orderListBySchool }" var="order">
													<tr class="userId" >
														<td>
															<div class="custom-control custom-checkbox">
																<input type="checkbox" class="customChecks custom-control-input">
																 <label class="custom-control-label  customCheck" for="customCheck2">&nbsp;</label>
															</div>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.orderNumber }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.student.studentName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold"><fmt:formatDate value="${order.startTime }" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold"> ${order.feeCategory.chargeTypeName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.dpMoney }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.paymentMethod.paymentmethodName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.personliable }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.departmentOfPediatrics.dpTypeName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.addhour }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${order.givehour }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" ><fmt:formatDate value="${order.firstdate }" pattern="yyyy-MM-dd HH:mm:ss"/> </a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" ><fmt:formatDate value="${order.lastdate }" pattern="yyyy-MM-dd HH:mm:ss"/></a>
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
		
					<!-- App js -->
				<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp" %>
				<script type="text/javascript" src="${Path }/static/js/admin/adminIndex.js"></script>
				<script src="${Path }/static/js/admin/leftSidebar.js"></script>
				<script src="${Path }/static/js/admin/orderSchool/selectOrderSchoolInfo.js"></script>
				<script src="${Path }/static/js/admin/operator.js"></script>
				<script src="${Path }/static/js/highes/leftSidebar.js"></script></body>
</html>
