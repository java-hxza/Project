<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>创建学校</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<!-- App favicon -->
<link rel="shortcut icon" href="${Path }/static/images/logo.jpg">

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
							<a href="adminIndex.html"> <span><img src="${Paht }/static/images/logo.jpg"></span>
							</a>
						</div>

						<div class="card-body p-4">

							<div class="text-center w-75 m-auto">
								<h4 class="text-dark-50 text-center mt-0 font-weight-bold">教师授权</h4>
								<p class="text-muted mb-4">授权请选择学校</p>
							</div>

							<form action="javascript:void(0)">
								
								<div class="form-group">
									<label for="emailaddress">省份：</label> 
									<select id="provinceId" name="provinceId" onchange="provinceChange()">
										<c:forEach items="${provinceList }" var="pro">
											<option value="${pro.provinceId }">${pro.provinceName}</option>
										</c:forEach>
									</select>
									<label for="emailaddress">城市：</label> 
									<select id="cityId" name="cityId" onchange="cityChange()">
										<option value="0">请选择城市</option>
										<c:forEach items="${cityList }" var="city">
											<option value="${city.cityId}">${city.cityName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="emailaddress">学校：</label>
									<select id="schoolId" name="schoolId">
										<option value="0">请选择要添加权限的学校</option>
										<c:forEach items="${schoolList }" var="school">
											<option value="${school.schoolId }">${school.schoolName}</option>
										</c:forEach>
									</select>
								</div>
								
								<div class="form-group">
									<label for="emailaddress">教师名</label> 
									<c:forEach items="${dictionListByUId }" begin="0" end="0" var="u">
										<input class="form-control" type="text" id="uId" name="${u.teacherId }" value="${u.teacher.teacherName }" disabled>
									</c:forEach>
								</div>
								
								<div class="form-group">
									<label for="emailaddress">已授权的学校</label> 
									<select id="ss">
										<c:forEach items="${dictionListByUId }" var="ta">
											<option value="${ta.school.schoolId }">${ta.school.schoolName }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input"
											id="checkbox-signup"> <label
											class="custom-control-label" for="checkbox-signup">我接受
											<a href="#" class="text-muted">条款和条件</a>
										</label>
									</div>
								</div>

								<div class="form-group mb-0 text-center">
									<button class="btn btn-primary" type="button" onclick="operatorAuthor()">授权</button>
								</div>

							</form>
						</div>
						<!-- end card-body -->
					</div>
					<!-- end card -->

					<div class="row mt-3">
						<div class="col-12 text-center">
							<p class="text-muted">
								已有账户 <a href="welCome.html" class="text-muted ml-1"><b>登录</b></a>
							</p>
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
	<script src="${Path }/static/js/login.js"></script>
	<script src="${Path }/static/js/admin/info/schoolTeacherInfo.js"></script>
	<script src="${Path }/static/js/app.min.js"></script>
</body>
<script type="text/javascript">
	$(function() {
		operatorAuthor = function() {
			var userId = $("#uId").attr("name");
			var schoolId = $("#schoolId").val();
			
			if (uId, schoolId == null) {
				alert("请选择数据");
				return false;
			}
			
			$.ajax({
				url : 'rootOperatorAuthor.html',
				data : {
					userId : userId,
					schoolId : schoolId
				},
				dataType : 'JSON',
				type : 'post',
				success : function(data) {
					if (data.state == "1") {
						alert("授权成功！");
						location.href = "highIndex.html";
					} else if (data.state == "2") {
						alert("教师已授权");
						location.href = "highIndex.html";
					} else {
						alert("教师授权失败，请重试！");
						location.href = "highIndex.html";
					}
				},
				error : function(){
					alert("请刷新重试！");
					location.href = "highIndex.html";
				} 
			})

		}
	});
</script>
</html>
