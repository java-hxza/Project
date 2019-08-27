<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }" var="Path" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>同心同慧</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <!-- App favicon -->
        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <!-- App css -->
        <link href="${Path }/static/css/icons.min.css" rel="stylesheet" type="text/css" />
        <link href="${Path }/static/css/app.min.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		body{
			background-image:url(${Path}/static/images/back.png);
			 background-repeat:no-repeat; 
			 background-size:100% 100%;
			 -moz-background-size:100% 100%;}
		}
	</style>
    </head>
	
    <body>

        <div class="mt-5 mb-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">

                        <div class="text-center">
                            <img src="${Path }/static/images/maintenance.jpg" height="200" alt="File not found Image">
                            <h3 class="mt-4">请选择进入的管理系统</h3>
                            <p class="text-muted">该选项只有学校管理员可见.</p>

                            <div class="row mt-5">
                                <div class="col-md-4">
                                    <div class="text-center mt-3 pl-1 pr-1"  onclick="childrenJump()">
                                        <img alt="" style="border-radius:50%" src="${Path }/static/images/logo.jpg" width="180" height="200">
                                        <h5 class="text-uppercase" onclick="childrenJump()">少儿版</h5>
                                    </div>
                                </div> <!-- end col-->
                                <div class="col-md-4">
                                    <div class="text-center mt-3 pl-1 pr-1" onclick="highJump()">
                                   	 <img alt="" style="border-radius:50%" src="${Path }/static/images/maintenance.jpg" width="180" height="200">
                                        <h5 class="text-uppercase" onclick="highJump()">高中版</h5>
                                    </div>
                                </div> <!-- end col-->
                                <div class="col-md-4">
                                    <div class="text-center mt-3 pl-1 pr-1">
                                  	  <img alt="" style="border-radius:50%" src="${Path }/static/images/maintenance.jpg" width="180" height="200">
                                       <h5 class="text-uppercase">艺考版</h5>
                                    </div>
                                </div> <!-- end col-->
                            </div> <!-- end row-->
                        </div> <!-- end /.text-center-->

                    </div> <!-- end col -->
                </div>
                <!-- end row -->
            </div>
            <!-- end container -->
        </div>
        <!-- end page -->

        <footer class="footer footer-alt">
            2018 - 2019 Â© Hyper - Coderthemes.com
        </footer>
        <!-- App js -->
        <script src="${Path }/static/js/app.min.js"></script>
        <script src="${Path }/static/js/selectionModule.js"></script>
    </body>
</html>
