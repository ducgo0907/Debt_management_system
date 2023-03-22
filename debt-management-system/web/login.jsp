<%-- 
    Document   : login
    Created on : Jan 25, 2023, 3:30:46 PM
    Author     : bang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%>
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
                                        <h4 class="text-center mb-4 text-white">Đăng nhập tài khoản của bạn</h4>
                                        <%
                                            Cookie[] list = request.getCookies();
                                            String email = "";
                                            String password = "";
                                            String remember = "";
                                            if (list.length != 0) {
                                                for (int i = 0; i < list.length; i++) {
                                                    if (list[i].getName().equals("email")) {
                                                        email = list[i].getValue();
                                                    }
                                                    if (list[i].getName().equals("password")) {
                                                        password = list[i].getValue();
                                                    }
                                                    if (list[i].getName().equals("remember")) {
                                                        remember = list[i].getValue();
                                                    }
                                                }
                                            }
                                        %>
                                        <c:if test="${not empty errorMessage}">
                                            <div class="alert alert-danger" role="alert">
                                                ${errorMessage}
                                            </div>
                                        </c:if> 
                                        <c:if test="${not empty successMessage}">
                                            <div class="alert alert-success" role="alert">
                                                ${successMessage}
                                            </div>
                                        </c:if> 
                                        <form class="form-valide-with-icon" action="login" method="POST">
                                            <div class="form-group">
                                                <label class="mb-1 text-white">Email</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                                                    </div>
                                                    <input type="email" class="form-control text-black" id="email" name="email" placeholder="hello@example.com" value="<%= email%>" required>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="mb-1 text-white">Mật khẩu</label>
                                                <div class="input-group transparent-append">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                                                    </div>
                                                    <input type="password" class="form-control text-black" id="password" name="password" value="<%= password%>" placeholder="Input here..." required>
                                                    <div class="input-group-append show-pass ">
                                                        <span class="input-group-text "> 
                                                            <i class="fa fa-eye-slash"></i>
                                                            <i class="fa fa-eye"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <%
                                                if (request.getSession().getAttribute("isCaptchaSolved") == null) {
                                            %>
                                            <label for="captchaCode" style="color: white" class="prompt">Captcha Code:</label>

                                            <!-- Adding BotDetect Captcha to the page -->
                                            <botDetect:captcha id="loginCaptcha" 
                                                               userInputID="captchaCode"
                                                               codeLength="4"
                                                               imageWidth="200"
                                                               codeStyle="ALPHA" />
                                            <div class="validationDiv">
                                                <input id="captchaCode" type="text" name="captchaCode" placeholder="captcha"/>
                                            </div>
                                            <%
                                                }
                                            %>
                                            <div class="form-row d-flex justify-content-between mt-4 mb-2">
                                                <div class="form-group">
                                                    <div class="custom-control custom-checkbox ml-1 text-white">
                                                        <input type="checkbox" name="remember" <%= "ON".equals(remember.trim()) ? "checked" : ""%> value="ON" class="custom-control-input" id="basic_checkbox_1">
                                                        <label class="custom-control-label" for="basic_checkbox_1">Ghi nhớ đăng nhập</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <a class="text-white" href="forgot-password.jsp">Quên mật khẩu?</a>
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="submit" class="btn bg-white text-primary btn-block">Đăng nhập</button>
                                            </div>
                                        </form>
                                        <div class="new-account mt-3">
                                            <p class="text-white">Bạn chưa có tài khoản? <a class="text-white" href="register.jsp">Đăng ký ngay</a></p>
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
                });
            });
        </script>
    </body>

</html>
