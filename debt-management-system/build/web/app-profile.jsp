<%-- 
    Document   : app-profile
    Created on : Feb 9, 2023, 9:22:09 AM
    Author     : kaiok
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Debt Management System</title>
        <!-- Toastr -->
        <link rel="stylesheet" href="./vendor/toastr/css/toastr.min.css" />
        <!-- Favicon icon -->
        <link href="./vendor/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet">
        <link href="./css/style.css" rel="stylesheet">
        <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
        <link href="./vendor/lightgallery/css/lightgallery.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    </head>

    <body>
        <!--        <div id="preloader">
                    <div class="sk-three-bounce">
                        <div class="sk-child sk-bounce1"></div>
                        <div class="sk-child sk-bounce2"></div>
                        <div class="sk-child sk-bounce3"></div>
                    </div>
                </div>-->

        <div id="">

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
                                            <span class="text-black"><strong>${infor.getFullName()}</strong></span>
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

            <div class="deznav">
                <div class="deznav-scroll">
                    <ul class="metismenu" id="menu">
                        <li><a class=" ai-icon" href="home" aria-expanded="false">
                                <i class="flaticon-381-home"></i>
                                <span class="nav-text">Trang chủ</span>
                            </a>
                        </li>
                        <li ><a class=" ai-icon" href="home" aria-expanded="true">
                                <i class="flaticon-381-notepad-1"></i>
                                <span class="nav-text">Sổ ghi nợ</span>
                            </a>

                        </li>
                        <li class="mm-active"><a href="#" class="ai-icon" aria-expanded="false">
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

            <div class="content-body">
                <div class="container-fluid">
                    <div class="page-titles">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Sổ ghi nợ</a></li>
                            <li class="breadcrumb-item active"><a href="javascript:void(0)">Tài khoản</a></li>
                        </ol>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="profile card card-body px-3 pt-3 pb-0">
                                <div class="profile-head">

                                    <div class="profile-info">
                                        <div class="profile-photo">
                                            <img src="images/profile/profile2.png" class="img-fluid rounded-circle" alt="">
                                        </div>
                                        <div class="profile-details">
                                            <div class="profile-name px-3 pt-2">
                                                <h4 class="text-primary mb-0"> ${infor.fullName}
                                                </h4>
                                                <p>
                                                    <c:set var = "now" value = "${infor.birthDate}" />
                                                    <c:if test="${empty now}">
                                                        Chưa thêm ngày sinh
                                                    </c:if>
                                                    <c:if test="${not empty now}">
                                                        <fmt:formatDate  pattern = "dd/MM/yyyy" type = "time" value = "${now}" />
                                                    </c:if>
                                                </p>
                                            </div>
                                            <div class="profile-email px-2 pt-2">
                                                <h4 class="text-muted mb-0">${infor.email}</h4>
                                                <c:if test="${empty infor.getPhoneNumber()}">
                                                    <p>Chưa thêm số điện thoại</p>
                                                </c:if>
                                                <c:if test="${not empty infor.getPhoneNumber()}">
                                                    <p>   ${infor.getPhoneNumber()} </p>
                                                </c:if>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-xl-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="profile-tab">
                                        <div class="custom-tab-1">
                                            <ul class="nav nav-tabs">

                                                <li class="nav-item"><a href="#about-me" data-toggle="tab" class="nav-link active show">Thông tin cơ bản</a>
                                                </li>
                                                <li class="nav-item"><a href="#profile-settings" data-toggle="tab" class="nav-link">Cập nhật thông tin</a>
                                                </li>
                                            </ul>
                                            <div class="tab-content">

                                                <div id="about-me" class="tab-pane fade active show">
                                                    <div class="pt-3">


                                                        <div class="profile-personal-info">

                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Họ và tên <span class="pull-right">:</span>
                                                                    </h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7"><span>${infor.getFullName()}</span>
                                                                </div>
                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Địa chỉ Email <span class="pull-right">:</span>
                                                                    </h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7"><span>${infor.getEmail()}</span>
                                                                </div>
                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Ngày Sinh <span class="pull-right">:</span></h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7">
                                                                    <c:set var = "now" value = "${infor.birthDate}" />
                                                                    <c:if test="${empty now}">
                                                                        Chưa thêm ngày sinh
                                                                    </c:if>
                                                                    <c:if test="${not empty now}">
                                                                        <fmt:formatDate  pattern = "dd/MM/yyyy" type = "time" value = "${now}" />
                                                                    </c:if>


                                                                </div>



                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Giới tính <span class="pull-right">:</span>
                                                                    </h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7">
                                                                    <c:if test="${infor.getGenderId() == 1}">
                                                                        <span>Nam</span>
                                                                    </c:if>
                                                                    <c:if test="${infor.getGenderId() == 2}">
                                                                        <span>Nữ</span>  
                                                                    </c:if>
                                                                    <c:if test="${infor.getGenderId() == 3}">
                                                                        <span>Giới tính khác</span>  
                                                                    </c:if>
                                                                    <c:if test="${infor.getGenderId() == NULL || infor.getGenderId() == ''}">
                                                                        <span>Chưa thêm thông tin</span>  
                                                                    </c:if>
                                                                </div>
                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Địa chỉ <span class="pull-right">:</span></h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7">
                                                                    <c:if test="${empty infor.getAddress()}">
                                                                        Chưa thêm địa chỉ
                                                                    </c:if>
                                                                    <c:if test="${not empty infor.getAddress()}">
                                                                        ${infor.getAddress()}
                                                                    </c:if>

                                                                </div>
                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Số điện thoại <span class="pull-right">:</span></h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7">
                                                                    <c:if test="${empty infor.getPhoneNumber()}">
                                                                        Chưa thêm số điện thoại
                                                                    </c:if>
                                                                    <c:if test="${not empty infor.getPhoneNumber()}">
                                                                        ${infor.getPhoneNumber()}
                                                                    </c:if>
                                                                </div>
                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Ngày tạo tài khoản <span class="pull-right">:</span></h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7">

                                                                    <c:set var = "create" value = "${infor.getCreatedAt()}" />
                                                                    <fmt:formatDate  pattern = "HH:mm dd/MM/yyyy" type = "time" value = "${create}" />


                                                                </div>
                                                            </div>
                                                            <div class="row mb-2">
                                                                <div class="col-sm-3 col-5">
                                                                    <h5 class="f-w-500">Lần cập nhật cuối <span class="pull-right">:</span></h5>
                                                                </div>
                                                                <div class="col-sm-9 col-7">

                                                                    <c:set var = "update" value = "${infor.getUpdatedAt()}" />
                                                                    <fmt:formatDate  pattern = "HH:mm dd/MM/yyyy" type = "time" value = "${update}" />


                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div id="profile-settings" class="tab-pane fade">
                                                    <div class="pt-3">
                                                        <div class="settings-form">

                                                            <form class="form-valide"  action="update-profile" method="POST"  >
                                                                <div class="form-row">
                                                                    <div class="form-group col-md-6">
                                                                        <label>Họ và tên</label>
                                                                        <c:if test="${empty infor.getFullName()}">
                                                                            <div>
                                                                                <input id="fullname" name="fullname" type="text" placeholder="Thêm họ và tên" class="form-control text-black font-w500">
                                                                            </div>
                                                                        </c:if>
                                                                        <c:if test="${not empty infor.getFullName()}">
                                                                            <div>
                                                                                <input id="fullname" name="fullname" type="text" value="${infor.getFullName()}" required class="form-control text-black font-w500">
                                                                            </div>
                                                                        </c:if>


                                                                    </div>

                                                                    <div class="form-group col-md-6 ">
                                                                        <label>Giới tính</label>
                                                                        <c:if test="${infor.getGenderId() == 3}">
                                                                            <select name="gender" class="form-control default-select text-black font-w500 " id="inputState"  >
                                                                                <option value="${infor.getGenderId()}" >Chọn giới tính...</option>
                                                                                <option value="1">Nam</option>
                                                                                <option value="2">Nữ</option>
                                                                                <option value="3"  selected="">Khác</option>
                                                                            </select>
                                                                        </c:if>
                                                                        <c:if test="${infor.getGenderId() ==1}">
                                                                            <select name="gender" class="form-control default-select text-black font-w500 " id="inputState"  >
                                                                                <option value="${infor.getGenderId()}"  >Chọn giới tính...</option>
                                                                                <option selected="" value="1">Nam</option>
                                                                                <option value="2">Nữ</option>
                                                                                <option value="3">Khác</option>
                                                                            </select>
                                                                        </c:if>
                                                                        <c:if test="${infor.getGenderId() == 2}">
                                                                            <select  name="gender" class="form-control default-select text-black font-w500 " id="inputState"  >
                                                                                <option  value="${infor.getGenderId()}">Chọn giới tính...</option>
                                                                                <option class="text-black" value="1">Nam</option>
                                                                                <option class="text-black" selected="" value="2">Nữ</option>
                                                                                <option class="text-black" value="3">Khác</option>
                                                                            </select>
                                                                        </c:if>

                                                                    </div>
                                                                </div>
                                                                <div class="form-row">
                                                                    <div class="form-group col-md-6">
                                                                        <label>Ngày sinh</label>
                                                                        <c:if test="${empty infor.getBirthDate()}">
                                                                            <div>
                                                                                <input name="birthday" type="date" placeholder="Thêm ngày sinh" class="form-control text-black font-w500">
                                                                            </div>
                                                                        </c:if>
                                                                        <c:if test="${not empty infor.getBirthDate()}">
                                                                            <div>
                                                                                <input name="birthday" type="date" value="${infor.getBirthDate()}" class="form-control text-black font-w500">
                                                                            </div>
                                                                        </c:if>

                                                                    </div>

                                                                    <div class="form-group col-md-6">
                                                                        <label>Số điện thoại</label>
                                                                        <c:if test="${empty infor.getPhoneNumber()}">
                                                                            <div>
                                                                                <input name="phonenumber" type="number" placeholder="Thêm số điện thoại" class="form-control text-black font-w500">
                                                                            </div>

                                                                        </c:if>
                                                                        <c:if test="${not empty infor.getPhoneNumber()}">
                                                                            <div>
                                                                                <input  name="phonenumber" type="number" value="${infor.getPhoneNumber()}" class="form-control text-black font-w500">
                                                                            </div>
                                                                        </c:if>
                                                                    </div>

                                                                </div>


                                                                <div class="form-group">
                                                                    <label>Địa chỉ</label>
                                                                    <c:if test="${empty infor.getAddress()}">
                                                                        <div>
                                                                            <input  name="address" type="text" placeholder="Thêm địa chỉ" class="form-control text-black font-w500">
                                                                        </div>
                                                                    </c:if>
                                                                    <c:if test="${not empty infor.getAddress()}">
                                                                        <div>
                                                                            <input name="address" type="text" value="${infor.getAddress()}" class="form-control text-black font-w500">
                                                                        </div>
                                                                    </c:if>

                                                                </div>



                                                                <button    class="btn btn-primary"  type="submit">Cập nhật</button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="footer">
                <div class="copyright">
                    <p>Copyright © Designed &amp; Developed by <a href="http://dexignzone.com/" target="_blank">FourTeam</a> 2023</p>
                </div>
            </div>



        </div>

        <script src="./vendor/global/global.min.js"></script>
        <script src="./vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
        <script src="./js/custom.min.js"></script>
        <script src="./js/deznav-init.js"></script>
        <script src="./vendor/lightgallery/js/lightgallery-all.min.js"></script>
        <script>
            $('#lightgallery').lightGallery({
                thumbnail: true,
            });
        </script>

        <!-- Toastr -->
        <script src="./vendor/toastr/js/toastr.min.js"></script>
         <!-- Jquery Validation -->
        <script src="./vendor/jquery-validation/jquery.validate.min.js"></script>
        <!-- Form validate init -->
        <script src="./js/plugins-init/jquery.validate-init.js"></script>
        <!-- All init script -->
        <script src="./js/plugins-init/toastr-init.js"></script>


        <c:if test="${not empty response}">
            <div id="toast-container" class="toast-top-center">
                <div class="toast toast-info" aria-live="polite" style="">
                    <div class="toast-progress" style="width: 100%;"></div>
                    <button type="button" class="toast-close-button" role="button">×</button>
                    <div class="toast-title">Thành công</div>
                    <div class="toast-message">${response}</div>
                </div>

            </div>

        </c:if>
        <c:if test="${not empty msg}">
            <div id="toast-container" class="toast-top-center">
                <div class="toast toast-error" aria-live="polite" style="">
                    <div class="toast-progress" style="width: 100%;"></div>
                    <button type="button" class="toast-close-button" role="button">×</button>
                    <div class="toast-title">Thất bại</div>
                    <div class="toast-message">${msg}</div>
                </div>

            </div>

        </c:if>



    </body>

</html>