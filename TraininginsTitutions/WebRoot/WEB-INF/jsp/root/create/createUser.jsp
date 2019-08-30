<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }" var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Login</title>
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

<body class="authentication-bg">

	<div class="account-pages mt-5 mb-5">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-5">
					<div class="card">

						<!-- Logo -->
						<div class="card-header pt-4 pb-4 text-center bg-primary">
							<a href="index.html"> <span>
						<!-- 	<img src="assets/images/logo.png" alt="" height="18"> --></span>
							</a>
						</div>

						<div class="card-body p-4">

							<div class="text-center w-75 m-auto">
								<h4 class="text-dark-50 text-center mt-0 font-weight-bold">Sign
									In</h4>
								<p class="text-muted mb-4">请选择您的校区并输入您的账户密码：</p>
							</div>
								
								<div class="form-group">
									<label for="emailaddress">省份：</label> 
									<select id="provinceId" name="provinceId" onchange="provinceChange()">
										<c:forEach items="${provinceList }" var="pro">
											<option value="${pro.provinceId }">${pro.provinceName}</option>
										</c:forEach>
									</select>
									<label for="emailaddress">城市：</label> 
									<select id="cityId" name="cityId" onchange="cityChange()">
										<option value=''>请选择城市</option>
										<c:forEach items="${cityList }" var="city">
											<option value="${city.cityId }">${city.cityName}</option>
										</c:forEach>
									</select>
									
								</div>
								<div class="form-group">
									<label for="emailaddress">学校：</label>
									<select id="schoolId" name="schoolId">
										<option value="0">请选择学校</option>
										<c:forEach items="${schoolList }" var="school">
											<option value="${school.schoolId }">${school.schoolName}</option>
										</c:forEach>
									</select>
									<select id="userTypeId" name="userTypeId">
										<option value="0">请选择用户身份</option>
										<c:forEach items="${userTypeList }" var="userType">
											<option value="${userType.userTypeId }">${userType.userTypeName}</option>
										</c:forEach>
									</select>
									
								</div>
								
								<div class="form-group">
									<label for="emailaddress">登录名：</label> <input
										class="form-control" type="text" id="loginName" name="loginName"
										required placeholder="警告 登录名只可创建一次并且不可修改" onblur="loginNameVerification()">
								</div>
								
								<div class="form-group">
									<a href="#" class="text-muted float-right"><small>忘记密码?</small></a> <label for="password">Password</label> <input
										class="form-control" type="password" required id="loginPassword" name="loginPassword"
										placeholder="Enter your password">
								</div>

								<div class="form-group mb-3">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input"
											id="checkbox-signin" checked> <label
											class="custom-control-label" for="checkbox-signin">我同意阅读条款信息</label>
									</div>
								</div>

								<div class="form-group mb-0 text-center">
									<button class="btn btn-primary" id="loginBtn" type="button" onclick="regitUser()">
									<span class="" role="status" aria-hidden="true">立即注册</span>
									</button>
								</div>
						</div>
						<!-- end card-body -->
					</div>
					<!-- end card -->

					<div class="row mt-3">
						<div class="col-12 text-center">
							<p class="text-muted">
								还没有账户? <a href="#"
									class="text-muted ml-1"><b>请登录管理员账号创建账户</b></a>
							</p>
						</div>
						<!-- end col -->
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

	<footer class="footer footer-alt">
	 2018 - 2019 ©  - Order.com 
	 </footer>

	<!-- App js -->
	<script src="${Path }/static/js/jquery.min.js"></script>
	<script src="${Path }/static/js/login.js"></script>
	<script src="${Path }/static/js/admin/create/createUser.js"></script>
	<script src="${Path }/static/js/app.min.js"></script>
</body>
</html>
