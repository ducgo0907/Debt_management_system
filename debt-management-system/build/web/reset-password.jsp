<%-- 
    Document   : register
    Created on : Feb 7, 2023, 10:08:32 PM
    Author     : bang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" class="h-100">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Debt Management System</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
        <link href="./css/style.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    </head>

    <body class="h-100">
        <div class="authincation h-100">
            <div class="container h-100">
                <div class="row justify-content-center h-100 align-items-center">
                    <div class="col-md-6">

                        <div class="authincation-content">
                            <div class="row no-gutters">
                                <div class="col-xl-12">
                                    <div class="auth-form">
                                        <div class="text-center mb-3">
                                            <a href="home"><img src="images/logo-full.png" alt=""></a>
                                        </div>
                                        <h4 class="text-center mb-4 text-white">Reset mật khẩu</h4>
                                        <c:if test="${not empty message}">
                                            <div class="alert alert-danger" role="alert">
                                                ${message}
                                            </div>
                                        </c:if>   
                                        <form class="form-valide-with-icon" action="reset-password" method="POST">
                                            <div class="form-group">
                                                <label class="mb-1 text-white">Mật khẩu mới</label>
                                                <div class="input-group transparent-append">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                                                    </div>
                                                    <input type="password" class="form-control text-black" id="password" name="password" placeholder="Input here...">
                                                    <div class="input-group-append show-pass ">
                                                        <span class="input-group-text "> 
                                                            <i class="fa fa-eye-slash"></i>
                                                            <i class="fa fa-eye"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="mb-1 text-white">Nhập lại mật khẩu</label>
                                                <div class="input-group transparent-append">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                                                    </div>
                                                    <input type="password" class="form-control text-black" id="rePassword" name="rePassword" placeholder="Input here...">
                                                    <div class="input-group-append show-pass ">
                                                        <span class="input-group-text "> 
                                                            <i class="fa fa-eye-slash"></i>
                                                            <i class="fa fa-eye"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <input type="hidden" name="token" value="<%=request.getParameter("token")%>">
                                            </div>
                                            <div class="text-center mt-4">
                                                <button type="submit" class="btn bg-white text-primary btn-block">Chấp nhận</button>
                                            </div>
                                        </form>
                                        </br>
                                        <div class="new-account mt-3">
                                            <p class="text-white" style="text-align: center"><a class="text-white" href="login.jsp"><b>Quay lại trang đăng nhập</b></a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--**********************************
                Scripts
        ***********************************-->
        <!-- Required vendors -->
        <script src="./vendor/global/global.min.js"></script>
        <script src="./vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
        <script src="./js/custom.min.js"></script>
        <script src="./js/deznav-init.js"></script>
        <!-- Jquery Validation -->
        <script src="./vendor/jquery-validation/jquery.validate.min.js"></script>
        <!-- Form validate init -->
        <script src="./js/plugins-init/jquery.validate-init.js"></script>

        <script>
            jQuery(document).ready(function () {
                jQuery('.show-pass').on('click', function () {
                    jQuery(this).toggleClass('active');
                    if (jQuery('#password').attr('type') == 'password') {
                        jQuery('#password').attr('type', 'text');
                    } else if (jQuery('#password').attr('type') == 'text') {
                        jQuery('#password').attr('type', 'password');
                    }
                    if (jQuery('#rePassword').attr('type') == 'password') {
                        jQuery('#rePassword').attr('type', 'text');
                    } else if (jQuery('#rePassword').attr('type') == 'text') {
                        jQuery('#rePassword').attr('type', 'password');
                    }
                });
            });
        </script>
    </body>
</html>
