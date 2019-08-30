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
<link href="${Path }/static/css/icons.min.css" rel="stylesheet" type="text/css" />
<link href="${Path }/static/css/app.min.css" rel="stylesheet" type="text/css" />

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
								<h3 class="schoolId" name="${schoolId }">${schoolName }</h3>
								<div class="app-search">
                            		<form>
                             		  	<div class="input-group">
                                 		   <input type="text" class="form-control" placeholder="Search...">
                                   		   <span class="mdi mdi-magnify"></span>
                                   	 	   <div class="input-group-append">
                                       		 <button class="btn btn-primary" type="button">搜索</button>
                                    	   </div>
                              		  	</div>
                           			 </form>	
                        		</div>
								<p class="text-muted mt-3"></p>
                                     <button type="button" class="btn btn-success btn-sm mt-2" onclick="printOrders()"> 打印订单</button>
                                    <button type="button" class="btn btn-info btn-sm mt-2 ml-1" onclick="exportExsal()">导出exsal</button>
                                    <button type="button" class="btn btn-info btn-sm mt-2 ml-1" onclick="query()">查询</button>
                                </div>
                            </div>
						<!-- end col -->
                        </div>
					<!-- end row -->
					
							<div class="row">
								<div  class="col-md-4">
									<div class="form-group">
										<label for="billing-first-name">开始日期</label> <input
											class="form-control" type="date" id="startTime" />
									</div>
								</div>
								<div  class="col-md-4">
									<div class="form-group">
										<label for="billing-first-name">截至日期</label> <input
											class="form-control" type="date" id="endTime" />
									</div>
								</div>
							</div>
                                <!-- Question/Answer -->
                                	<div class="table-responsive">
										<table
											class="table table-centered table-striped dt-responsive nowrap w-100"
											id="products-datatable">
											<thead>
												<tr>
													<th style="width: 20px;">
														<div class="custom-control custom-checkbox">
															
														</div>
													</th>
													<th id="schoolId" name = "${schoolId }" id_type="${schoolType }">校区</th>
													<th>学员分类</th>
													<th>新增学员</th>
												</tr>
											</thead>
											<tbody>
													<tr>
														<td>
															<div class="custom-control custom-checkbox">
																<input type="checkbox" class="custom-control-input"
																	id="customCheck2"> <label class="custom-control-label" for="customCheck2">&nbsp;</label>
															</div>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" id="schoolName">${schoolName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${stuClassification}</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${stuCount }</a>
														</td>
													</tr>
											</tbody>
										</table>
									</div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->

        </div>
				<!-- END wrapper -->

				<!-- App js -->
				<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp" %>
				<script src="${Path }/static/js/admin/addStudentInfo/selectAddStuInfo.js"></script>
				<script src="${Path }/static/js/admin/leftSidebar.js"></script>
				<script src="${Path }/static/js/highes/leftSidebar.js"></script>
</body>
</html>
