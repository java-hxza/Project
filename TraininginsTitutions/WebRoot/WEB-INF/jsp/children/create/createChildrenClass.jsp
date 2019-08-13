<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>添加少儿班级</title>
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

<body class="auth-fluid-pages pb-0">

	<div class="auth-fluid">
		<!--Auth fluid left content -->
		<div class="auth-fluid-form-box">
			<div class="align-items-center d-flex h-100">
				<div class="card-body">

					<!-- Logo -->
					<div class="auth-brand text-center text-lg-left">
						<a href="index.html"> <span><img
								src="assets/images/logo-light.png" alt="" height="18"></span>
						</a>
					</div>

					<!-- title-->
					<h4 class="mt-0">添加少儿班级</h4>
					<p class="text-muted mb-4">请填写班级信息</p>
					<!-- form -->
					<form action="#">
					
						<div class="form-group">
							<label for="fullname">班级标号</label> <input class="form-control"
								type="text" id="classNumber" placeholder="Enter your name"
								required>
						</div>
		
						<div class="form-group">
							<label for="fullname">班级名称</label> <input class="form-control"
								type="text" id="className" placeholder="Enter your name"
								required>
						</div>
						<div class="form-group">
							<label for="fullname">班级类型</label> <select id="dpId"
									onchange="dpChange()" class="form-control">
								<option value="0">请选择班级类型</option>
								<c:forEach items="${dpList}" var="dp">
									<option value="${dp.dpId }">${dp.dpTypeName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							
							<label for="emailaddress">班主任</label> <select id="headmaster"
								class="form-control">
								<option value="">请选择班主任</option>
							</select>
						</div>
						<div class="form-group">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input"
									id="checkbox-signup"> <label
									class="custom-control-label" for="checkbox-signup">I
									accept <a href="javascript: void(0);" class="text-muted">Terms
										and Conditions</a>
								</label>
							</div>
						</div>
						<div class="form-group mb-0 text-center">
							<button class="btn btn-primary btn-block" type="submit">
								<i class="mdi mdi-account-circle"></i> Sign Up
							</button>
						</div>
						<!-- social-->
						<div class="text-center mt-4">
							<p class="text-muted font-16">Sign up using</p>
							<ul class="social-list list-inline mt-3">
								<li class="list-inline-item"><a href="javascript: void(0);"
									class="social-list-item border-primary text-primary"><i
										class="mdi mdi-facebook"></i></a></li>
								<li class="list-inline-item"><a href="javascript: void(0);"
									class="social-list-item border-danger text-danger"><i
										class="mdi mdi-google"></i></a></li>
								<li class="list-inline-item"><a href="javascript: void(0);"
									class="social-list-item border-info text-info"><i
										class="mdi mdi-twitter"></i></a></li>
								<li class="list-inline-item"><a href="javascript: void(0);"
									class="social-list-item border-secondary text-secondary"><i
										class="mdi mdi-github-circle"></i></a></li>
							</ul>
						</div>
					</form>
					<!-- end form-->

					<!-- Footer-->
					<footer class="footer footer-alt">
						<p class="text-muted">
							Already have account? <a href="pages-login-2.html"
								class="text-muted ml-1"><b>Log In</b></a>
						</p>
					</footer>

				</div>
				<!-- end .card-body -->
			</div>
			<!-- end .align-items-center.d-flex.h-100-->
		</div>
		<!-- end auth-fluid-form-box-->

		<!-- Auth fluid right content -->
		<div class="auth-fluid-right text-center"
			style="background-image: url('${Path}/static/images/timg.jpg'); background-repeat:no-repeat; background-size:100% 100%;
                -moz-background-size:100% 100%;">
			<div class="auth-user-testimonial">
				<h2 class="mb-3">I love the color!</h2>
				<p class="lead">
					<i class="mdi mdi-format-quote-open"></i> It's a elegent templete.
					I love it very much! . <i class="mdi mdi-format-quote-close"></i>
				</p>
				<p>- Hyper Admin User</p>
			</div>
			<!-- end auth-user-testimonial-->
		</div>
		<!-- end Auth fluid right content -->
	</div>
	<!-- end auth-fluid-->

	<!-- App js -->
	<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
	<script src="${Path }/static/js/children/create/createChildrenClass.js"></script>
</body>

</html>