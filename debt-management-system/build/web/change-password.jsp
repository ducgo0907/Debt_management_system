<%-- 
    Document   : listDebtor
    Created on : Feb 7, 2023, 9:40:32 PM
    Author     : ngoqu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:useBean id="a" class="dao.impl.DebtDAOImpl" scope="request"></jsp:useBean>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width,initial-scale=1">
            <title>Debt Management System</title>
            <!-- Favicon icon -->
            <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
            <link rel="stylesheet" href="./vendor/chartist/css/chartist.min.css">
            <link href="./css/style.css" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
            <style>
                /* General styles */
                * {
                    box-sizing: border-box;
                    margin: 0;
                    padding: 0;
                }

                body {
                    font-family: 'Roboto', sans-serif;
                    background-color: #eee8e8;
                }

                .content-body {
                    min-height: none;
                }

                .container {
                    display: flex;
                }

                /* Header styles */
                header {
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    background-color: #999190;
                    padding: 10px 20px;
                    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
                }

                .logo img {
                    height: 50px;
                }

                .logout button {
                    background-color: #FF4136;
                    color: #fff;
                    border: none;
                    padding: 10px 20px;
                    border-radius: 4px;
                    font-size: 14px;
                    cursor: pointer;
                }

                .logout button:hover {
                    background-color: #d40000;
                }

                /* Sidebar styles */
                .sidebar {
                    background-color: #999190;
                    height: calc(100vh - 70px);
                    width: 200px;
                    padding: 20px;
                    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
                }

                .sidebar ul {
                    list-style-type: none;
                }

                .sidebar ul li {
                    margin-bottom: 10px;
                }

                .sidebar ul li a {
                    display: flex;
                    align-items: center;
                    color: #333;
                    text-decoration: none;
                    font-size: 16px;
                }

                .sidebar ul li a img {
                    height: 20px;
                    margin-right: 10px;
                }

                .sidebar ul li a:hover {
                    color: #FF4136;
                }

                /* Content styles */
                .content {
                    padding: 20px;
                    flex: 1;
                }

                h1 {
                    font-size: 28px;
                    margin-bottom: 20px;
                }

                form {
                    max-width: 400px;
                    margin: 0 auto;
                }

                .form-group {
                    margin-bottom: 20px;
                }

                label {
                    display: block;
                    margin-bottom: 5px;
                }

                input[type="password"] {
                    width: 100%;
                    border: none;
                    border-bottom: 2px solid #333;
                    padding: 5px;
                    font-size: 16px;
                    margin-bottom: 10px;
                }

                button[type="submit"] {
                    background-color: #FF4136;
                    color: #fff;
                    border: none;
                    padding: 10px 20px;
                    border-radius: 4px;
                    font-size: 14px;
                    cursor: pointer;
                }

                button[type="submit"]:hover {
                    background-color: #d40000;
                }
            </style>
        </head>
        <body>

            <!--*******************
                Preloader start
            ********************-->
            <div id="preloader">
                <div class="sk-three-bounce">
                    <div class="sk-child sk-bounce1"></div>
                    <div class="sk-child sk-bounce2"></div>
                    <div class="sk-child sk-bounce3"></div>
                </div>
            </div>
            <!--*******************
                Preloader end
            ********************-->

            <!--**********************************
                Main wrapper start
            ***********************************-->
            <div id="main-wrapper">

                <!--**********************************
                    Nav header start
                ***********************************-->
                <div class="nav-header">
                    <a href="home" class="brand-logo">
                        <img class="logo-abbr" src="./images/logo.png" alt="">
                        <img class="logo-compact" src="./images/logo-text.png" alt="">
                        <img class="brand-title" src="./images/logo-text.png" alt="">
                    </a>

                    <div class="nav-control">
                        <div class="hamburger">
                            <span class="line"></span><span class="line"></span><span class="line"></span>
                        </div>
                    </div>
                </div>
                <!--**********************************
                    Nav header end
                ***********************************-->

                <!--**********************************
        
    
                <!--**********************************
            Header start
        ***********************************-->
                <div class="header">
                    <div class="header-content">
                        <nav class="navbar navbar-expand">
                            <div class="collapse navbar-collapse justify-content-between">
                                <div class="header-left">
                                    <div class="dashboard_bar">
                                        Sổ ghi nợ
                                    </div>
                                </div>

                                <ul class="navbar-nav header-right">    
                                    <li class="nav-item dropdown header-profile">
                                        <a class="nav-link" href="javascript:void(0)" role="button" data-toggle="dropdown">
                                            <img src="images/logo.png" width="20" alt=""/>
                                            <div class="header-info">
                                                <span class="text-black"><strong>
                                                    ${infor.getFullName()}
                                                </strong></span>
                                            <p class="fs-12 mb-0">Người dùng</p>
                                        </div>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a href="viewprofile" class="dropdown-item ai-icon">
                                            <svg id="icon-user1" xmlns="http://www.w3.org/2000/svg" class="text-primary" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg>
                                            <span class="ml-2">Tài khoản </span>
                                        </a>
                                        <a href="changePassword" class="dropdown-item ai-icon">
                                            <svg xmlns="http://www.w3.org/2000/svg"; width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                            <rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect>
                                            <path d="M7 11V7a5 5 0 0 1 10 0v4"></path>
                                            </svg>
                                            <span class="ml-2">Đổi mật khẩu</span>
                                           </a>

                                        <a href="logout" class="dropdown-item ai-icon">
                                            <svg id="icon-logout" xmlns="http://www.w3.org/2000/svg" class="text-danger" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
                                            <span class="ml-2">Đăng xuất </span>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <!--**********************************
                Header end ti-comment-alt
            ***********************************-->

            <!--**********************************
                Sidebar start
            ***********************************-->
            <div class="deznav">
                <div class="deznav-scroll">
                    <ul class="metismenu" id="menu">
                        <li><a class=" ai-icon" href="home" aria-expanded="false">
                                <i class="flaticon-381-home"></i>
                                <span class="nav-text">Trang chủ</span>
                            </a>
                        </li>
                        <li ><a class=" ai-icon" href="home" aria-expanded="false">
                                <i class="flaticon-381-notepad-1"></i>
                                <span class="nav-text">Sổ ghi nợ</span>
                            </a>

                        </li>
                        <li class="mm-active"><a href="#" class="ai-icon" aria-expanded="true">
                                <i class="flaticon-381-settings-2"></i>
                                <span class="nav-text">Cài đặt</span>
                            </a>
                        </li>

                    </ul>

                    <div class="add-menu-sidebar">
                        <img src="images/calendar.png" alt="" class="mr-3">
                        <p class="	font-w500 mb-0">Quản lý nợ nần của bạn</p>
                    </div>
                    <div class="copyright">
                        <p><strong>FourTeam Dashboard</strong> © 2023 SWP391</p>
                        <p>Made with <span class="heart"></span> by FourTeam</p>
                    </div>
                </div>
            </div>
            <!--**********************************
                Sidebar end
            ***********************************-->

            <!--**********************************
        Content body start
    ***********************************-->
            <div class="content-body">


                <div class="container">
                    <div class="content">
                        <h1>Đổi mật khẩu</h1>
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
                        <form action="changePassword" method="post">
                            <div class="form-group">
                                <label for="old-password">Mật khẩu hiện tại:</label>
                                <input type="password" id="old-password" name="oldPassword" required>
                            </div>
                            <div class="form-group">
                                <label for="new-password">Mật khẩu mới:</label>
                                <input type="password" id="new-password" name="newPassword" required>
                            </div>
                            <div class="form-group">
                                <label for="confirm-password">Xác nhận mật khẩu:</label>
                                <input type="password" id="confirm-password" name="confirmPassword" required>
                            </div>
                            <button type="submit">Save</button>
                        </form>
                    </div>
                </div>


                <!--**********************************
                    Footer end
                ***********************************-->
            </div>
        </div>
        <!--**********************************
        Content body start
        ***********************************
        
        <!--**********************************
        Support ticket button start
        ***********************************-->

        <!--**********************************
           Support ticket button end
        ***********************************-->


        <!--**********************************
            Main wrapper end
        ***********************************-->

        <!--**********************************
            Scripts
        ***********************************-->
        <!-- Required vendors -->
        <script src='https://cdn.jsdelivr.net/npm/bignumber.js@9.1.0/bignumber.min.js'></script>
        <script src="./vendor/global/global.min.js"></script>
        <script src="./vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
        <script src="./js/custom.min.js"></script>
        <script src="./js/deznav-init.js"></script>
        <script src="./view-debtor.js"></script>
        <script src="./helper.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/big-integer/1.6.51/BigInteger.min.js" integrity="sha512-gHNUM5lAKXJFwUX0qjNGL5tJSoa8TTz2xUTw5COytE/p3MHy2Mivey3Gb76Blf6JfvNglTskVo5YsxDix6XIcg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/big-integer/1.6.51/BigInteger.js" integrity="sha512-gJKs+bNHfx193X/dsoR3XTBnkYWnqXrb63fmhY7S5WSFRPn1dpwZF7zOTvWgaVHhvHCBaR5oniBfHz8xKlfnwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    </body>
</html>
