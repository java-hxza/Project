<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login</title>
<link rel="stylesheet" type="text/css" href="${Path }/static/css/login/normalize.css" />
<link rel="stylesheet" type="text/css" href="${Path }/static/css/login/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${Path }/static/css/login/component.css" />

<style type="text/css">
.demo-1 .large-header {
	background-image: url('${Path}/static/images/back.jpg');
}

#logo{
	position: relative;
	top: 60px;
	left: 90px;
	
}
#d1{
	position: relative;
	top: -100px;
}
</style>
<!--[if IE]>
	<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<div id="d1">
						<img alt="" id="logo" src="${Path }/static/images/LOGO(1).jpg" width="50%" height="50%">
						<h3>同心同慧教育集团</h3>
					</div>
					<form action="#" name="f" method="post">
						<div class="input_outer">
							<span class="u_user"></span> <input name="logname"  id="logname" class="text"
								style="color: #FFFFFF !important" type="text"
								placeholder="请输入账户">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span> <input name="password"  id="password"class="text"
								style="color: #FFFFFF !important; position:absolute; z-index:100;"
								value="" type="password" placeholder="请输入密码">
						</div>
						<div class="mb2">
							<a class="act-but submit" href="javascript:;"
								style="color: #FFFFFF" onclick="UserLogin()">登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script src="${Path }/static/js/jquery.min.js"></script>
	<script src="${Path }/static/js/login/TweenLite.min.js"></script>
	<script src="${Path }/static/js/login/EasePack.min.js"></script>
	<script src="${Path }/static/js/login/rAF.js"></script>
	<script src="${Path }/static/js/login/demo-1.js"></script>
	<script src="${Path }/static/js/app.min.js"></script>
	<script src="${Path }/static/js/login.js"></script>
	
	<div style="text-align:center;"></div>
</body>
</html>
