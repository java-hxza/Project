<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>学生转班</title>
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

<body class="authentication-bg">

	<div class="account-pages mt-5 mb-5">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-5">
					<div class="card">
						<!-- Logo-->
						<div class="card-header pt-4 pb-4 text-center bg-primary">
							<a href="index.html"> <span><img
									src="${Path }/static/images/logo.png" alt="" height="18"></span>
							</a>
						</div>

						<div class="card-body p-4">

							<div class="text-center w-75 m-auto">
								<h4 class="text-dark-50 text-center mt-0 font-weight-bold">学生转班</h4>
								<p class="text-muted mb-4"></p>
							</div>

							<form>
								
								<div class="form-group">
									<label for="emailaddress">学生姓名</label> <input
										class="form-control" type="text"  id="studentId" name="${childrenesClassStudnet.studentId }" value="${childrenesClassStudnet.studentName }"  disabled="disabled">
								</div>
								<div class="form-group">
									<label for="emailaddress">学生现所在班级</label>
										<select class="form-control"   id="classId" disabled="disabled">
										<c:forEach items="${classListAll }" var="cc">
											<c:choose>
												<c:when test="${childrenesClassStudnet.classId  == cc.classId}">
													<option value="${cc.classId }_${cc.classTypeId }">${cc.className }</option>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="emailaddress">要转入的班级</label> 
									<select class="form-control"  onchange="classIdChange()" id="classIdes" >
										<option>请选择转入的班级</option>
										<c:forEach items="${classListAll }" var="c">
											<option value="${c.classId }">${c.className }</option>
											<span hidden="hidden">${c.classTypeId }</span>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="emailaddress">差额</label> 
									<input type="text" class="form-control" id="money">
								</div>
								<div class="form-group">
									<label for="emailaddress">转班原因</label> 
									<input type="text" class="form-control" id="remarks">
								</div>
								<div class="form-group mb-0 text-center">
									<button class="btn btn-primary" type="button" onclick="updateStudentShiftWork()" >保存</button>
								</div>
							</form>
						</div>
						<!-- end card-body -->
					</div>
					<!-- end card -->
					
					<div class="row mt-3">
						<div class="col-12 text-center">
						</div>
						<!-- end col-->
					</div>
					<!-- end row -->

				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- end container -->
	</div>
	<!-- end page -->

	<footer class="footer footer-alt"> 2018 - 2019 Â© Hyper -
		Coderthemes.com </footer>

	<!-- App js -->
	<script src="${Path }/static/js/jquery.min.js"></script>
	<script src="${Path }/static/js/app.min.js"></script>
	<script src="${Path }/static/js/root/studentInfo/art/seeStudentInfo.js"></script>
</body>
</html>
