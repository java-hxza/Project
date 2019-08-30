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
								<p class="text-muted mt-3">教师信息</p>
								<div class="row mb-2">
									<div class="col-sm-8">
										<a href="javascript:void(0);" class="btn btn-danger mb-2 adds"
											onclick="createTeacher()"><i
											class="mdi mdi-plus-circle mr-2"></i>添加教师</a> <a
											href="javascript:void(0);" class="btn btn-danger mb-2 update"
											onclick="updateTeacher()"><i
											class="mdi mdi-plus-circle mr-2"></i>修改教师密码</a> <a
											href="javascript:void(0);" class="btn btn-danger mb-2 del"
											onclick="delTeacher()"><i
											class="mdi mdi-plus-circle mr-2"></i>删除教师</a> <a
											href="javascript:void(0);" class="btn btn-danger mb-2 del"
											onclick="teacherAuthorization()"> <i
											class="mdi mdi-plus-circle mr-2"></i>教师授权
										</a>
									</div>
									<!-- end col-->
								</div>
							</div>
						</div>
						<!-- end col -->
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
															<input type="checkbox" class="custom-control-input" disabled
																id="customCheck1"> <label
																class="custom-control-label" for="customCheck1">&nbsp;</label>
														</div>
													</th>
													<th>教师编号</th>
													<th>教师名称</th>
													<th>教学名称</th>
													<th>教师所属分类</th>
													<th>教师电话</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
											
												<c:forEach items="${teacherListBYSchoolId }" var="teacher">
													<tr class="teacherId" >
														<td>
															<div class="custom-control custom-checkbox">
																<input type="checkbox" class="custom-control-input customCheckes" />
																<label class="custom-control-label  customCheck" for="customCheck">&nbsp;</label>
															</div>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${teacher.teacherId }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${teacher.teacherName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${teacher.teacherType.teacherTypeName }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >
																<c:choose>
																	<c:when test="${teacher.feeCategory ==1} ">少儿</c:when>
																	<c:when test="${teacher.feeCategory ==1} ">高中</c:when>
																	<c:otherwise>艺考</c:otherwise>
																</c:choose>
															</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold">${teacher.telephone }</a>
														</td>
														<td class="table-user"><a href="javascript:void(0);"
															class="text-body font-weight-semibold" >${teacher.remarks }</a>
														</td>
													</tr>
												</c:forEach>	
											</tbody>
										</table>
									</div>
       				 </div>	
       				 	
                          
					<!-- App js -->
				<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp" %>
				<script type="text/javascript" src="${Path }/static/js/admin/leftSidebar.js"></script>
				<script type="text/javascript" src="${Path }/static/js/admin/adminIndex.js"></script>
				<script type="text/javascript" src="${Path }/static/js/admin/info/schoolTeacherInfo.js"></script>
				<script src="${Path }/static/js/highes/leftSidebar.js"></script>
</body>
</html>
