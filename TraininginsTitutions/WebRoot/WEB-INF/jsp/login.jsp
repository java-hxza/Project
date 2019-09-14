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
							<img src="${Path }/static/images/login.png" alt=""width="50%" height="30px"> </span>
							</a>
						</div>

						<div class="card-body p-4">

							<div class="text-center w-75 m-auto">
								<h4 class="text-dark-50 text-center mt-0 font-weight-bold">登录</h4>
								<p class="text-muted mb-4">请输入您的账户密码登录：</p>
							</div>
								
								<div class="form-group">
									<label for="emailaddress">账户名：</label> <input
										class="form-control" type="text" id="username" name="username"
										required placeholder="Enter your username">
								</div>
								<div class="form-group">
									<a href="pages-recoverpw.html" class="text-muted float-right"><small>忘记密码?</small></a> <label for="password">Password</label> <input
										class="form-control" type="password" required id="password" name="password"
										placeholder="Enter your password">
								</div>
								<div class="form-group mb-0 text-center">
									<button class="btn btn-primary" id="loginBtn" type="submit" onclick="UserLogin()">
										<span class="" role="status" aria-hidden="true">登录</span>
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
	<script src="${Path }/static/js/app.min.js"></script>
</body>
</html>
