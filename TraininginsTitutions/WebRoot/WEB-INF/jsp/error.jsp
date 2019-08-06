<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }" var="Path" />
<!DOCTYPE html
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
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
                                <a href="index.jsp">
                                    <span><img src="${Path }/static/images/logo.png" alt="" height="18"></span>
                                </a>
                            </div>

                            <div class="card-body p-4">
                                <div class="text-center">
                                    <h1 class="text-error">4<i class="mdi mdi-emoticon-sad"></i>4</h1>
                                    <h4 class="text-uppercase text-danger mt-3">网页未找到</h4>
                                    <p class="text-muted mt-3">看起来你可能走错了路。别担心......它发生在我们最好的人身上。这里有一个小小的提示可能会帮助您重回正轨</p>

                                    <a class="btn btn-info mt-3" href="#"onClick="javascript :history.back(-1);"><i class="mdi mdi-reply"></i>返回</a>
                                </div>
                            </div> <!-- end card-body-->
                        </div>
                        <!-- end card -->
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
    </body>
</html>
