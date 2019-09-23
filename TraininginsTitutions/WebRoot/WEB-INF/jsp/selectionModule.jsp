<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>同心同慧</title>
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
body {
	background-color: #0093E9;
	background-image: linear-gradient(160deg, #0093E9 0%, #80D0C7 100%);
}

.top1 {
	border-radius: 50%;
	height: "400px";
	width: " 400px";
	margin-bottom: 5%;
	background-color: #f9fa61;
	background-image: linear-gradient(90deg, #f9fa61 0%, #f9fa61 100%);
	background-color: #f9fa61;
}

.top1:hover {
	background-color: #FAACA8;
	background-image: linear-gradient(19deg, #FAACA8 0%, #DDD6F3 100%);
}
</style>
</head>

<body>

	<div class="mt-5 mb-5">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12">

					<div class="text-center">
						<img src="${Path }/static/images/maintenance.jpg"
							style="border-radius:50%" " width="200" height="200"
							alt="File not found Image">
						<h1 class="mt-4">请选择进入的管理系统</h1>

						<div class="row mt-5">

							<!-- end row-->
						</div>
						<!-- end /.text-center-->

					</div>
					<!-- end col -->
				</div>
				<!-- end row -->
			</div>
			<!-- end container -->

		</div>
		<div class="top1">
			<div class="text-center" onclick="childrenJump()">
				<h1 onclick="childrenJump()">少儿版</h1>
			</div>
		</div>
		<!-- end col-->
		<div class="top1">
			<div class="text-center" onclick="highJump()">
				<h1 onclick="highJump()">高中版</h1>
			</div>
		</div>
		<!-- end col-->
		<div class="top1">
			<div class="text-center" onclick="artJump()">
				<h1 onclick="artJump()">艺考版</h1>
			</div>
		</div>
		<!-- end col-->
	</div>
	<!-- end page -->

	<footer class="footer footer-alt"> 2018 - 2019 Â© Hyper -
		Coderthemes.com </footer>
	<!-- App js -->
	<script src="${Path }/static/js/app.min.js"></script>
	<script src="${Path }/static/js/selectionModule.js"></script>
</body>
</html>
