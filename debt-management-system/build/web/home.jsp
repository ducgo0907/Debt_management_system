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
<html>
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
                        <li><a class="ai-icon" href="home" aria-expanded="false">
                                <i class="flaticon-381-home"></i>
                                <span class="nav-text">Trang chủ</span>
                            </a>
                        </li>
                        <li><a class=" ai-icon" href="#" aria-expanded="true">
                                <i class="flaticon-381-notepad-1"></i>
                                <span class="nav-text">Sổ ghi nợ</span>
                            </a>

                        </li>
                        <li><a href="#" class="ai-icon" aria-expanded="false">
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
            <!-- Modal -->
            <div class="modal fade" id="AddDebtorMenu">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">THÊM NGƯỜI NỢ</h5>
                            <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="add-debtor" method="post" id="modalAdd">
                                <div class="form-group">
                                    <label for="validationCustom01" class="form-label">Tên <span style="color: red">*</span></label>
                                    <input 
                                        type="text" 
                                        id="fName" 
                                        class="form-control" 
                                        placeholder="Tên..." 
                                        name="fullName" 
                                        maxlength="100"
                                        minlength="2"
                                        required>                                   
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ  <span style="color: red">*</span></label>
                                    <input 
                                        type="text" 
                                        class="form-control" 
                                        placeholder="Địa chỉ..." 
                                        name="address"
                                        maxlength="255"
                                        minlength="3"
                                        required>
                                </div>
                                <div class="form-group">
                                    <label>SÐT  <span style="color: red">*</span></label>
                                    <input 
                                        type="tel" 
                                        class="form-control" 
                                        placeholder="SÐT..." 
                                        name="phone" 
                                        pattern="[0-9]{9,15}" 
                                        maxlength="15"
                                        required />
                                </div>
                                <div class="form-group">
                                    <label>Email  <span style="color: red">*</span></label>
                                    <input 
                                        type="email" 
                                        class="form-control" 
                                        placeholder="Email..." 
                                        pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"
                                        name="email"
                                        maxlength="255"
                                        required>
                                </div>
                                <div class="form-group d-flex">
                                    <label class="font-weight-bold">Giới tính  <span style="color: red">*</span></label>
                                    <label class="ml-1 mr-1">Nam</label>
                                    <input type="radio" class="form-check" name="gender" value="1" required="">
                                    <label class="ml-1 mr-1">Nữ</label>
                                    <input type="radio" class="form-check" name="gender" value="2">
                                    <label class="ml-1 mr-1">Giới tính khác</label>
                                    <input type="radio" class="form-check" name="gender" value="3">
                                </div>
                                <div hidden="" class="form-group">
                                    <label>Tổng nợ</label>
                                    <input type="text" class="form-control" placeholder="0" name="totalDebt" readonly>
                                </div>
                                <input type="submit" class="btn btn-primary" value="THÊM MỚI">
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <!-- Modal -->
            <div class="modal fade" id="CreateDebtMenus" style="z-index: 9999999">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Tạo phiếu vay/nợ</h5>
                            <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="create-debt" method="post" id="formCreateDebt">
                                <div class="form-group">
                                    <textarea class="debtor-id" id="debtor-id" name="debtor-id" hidden></textarea>
                                </div>

                                <div class="form-group">
                                    <label>Số tiền</label>
                                    <input type="text" class="form-control" min="0" placeholder="0" name="money" id="moneyDebt" required>
                                </div>
                                <div class="form-group">
                                    <span id="moneyToWord"></span>
                                </div>
                                <div class="form-group d-flex">
                                    <label class="font-weight-bold">Thể loại nợ</label>
                                    <label class="ml-1 mr-1">Cho Vay</label>
                                    <input type="radio" class="form-check" name="isDebt" value="1" checked="">
                                    <label class="ml-1 mr-1">Nợ</label>
                                    <input type="radio" class="form-check" name="isDebt" value="0">                               
                                </div>

                                <div class="form-group">
                                    <label>Ghi chú</label>
                                    <textarea rows="7" class="form-control" name="note" maxlength="1000"> </textarea>
                                </div>
                                <div class="form-group">
                                    <label>Ngày tạo phiếu</label>
                                    <input type="Date" name="startDate" class="form-control" placeholder="hr" required>
                                </div>
                                <input type="submit" class="btn btn-primary" value="Thêm phiếu nợ">
                            </form>
                        </div>
                    </div>
                </div>
            </div>    
            <!--**********************************
        Content body start
    ***********************************-->
            <div class="content-body">
                <!-- row -->
                <jsp:include page="errors.jsp"/>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xl-12 col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Danh sách người nợ</h4>
                                    <a href="javascript:void(0);" style="float: right" data-toggle="modal" data-target="#AddDebtorMenu" class="btn text-white rounded bg-primary">
                                        <i class="las la-plus"></i>THÊM NGƯỜI NỢ
                                    </a>
                                </div>
                                <div class="card-body">
                                    <div class="basic-form">
                                        <form>
                                            <div class="form-row">
                                                <div class="form-group col-md-2 mb-0">
                                                    <label class="text-black">Tên</label>
                                                    <input 
                                                        type="text" 
                                                        placeholder="&#xF002; Tên" 
                                                        style="font-family:Arial, FontAwesome"
                                                        name="searchName" 
                                                        id="searchName" 
                                                        class="form-control" 
                                                        oninput="delaySearch()">

                                                </div>
                                                <div class="form-group col-md-2 mb-0">
                                                    <label class="text-black">Địa chỉ</label>
                                                    <input 
                                                        type="text" 
                                                        placeholder="&#xF002; Địa chỉ" 
                                                        style="font-family:Arial, FontAwesome"
                                                        class="form-control" 
                                                        id="searchAddress"
                                                        oninput="delaySearch()">
                                                </div>
                                                <div class="form-group col-md-2 mb-0">
                                                    <label class="text-black">SÐT</label>
                                                    <input 
                                                        type="text" 
                                                        placeholder="&#xF002; SÐT" 
                                                        style="font-family:Arial, FontAwesome"
                                                        class="form-control a" 
                                                        id="searchPhone"
                                                        oninput="delaySearch()">
                                                </div>
                                                <div class="form-group col-md-2 mb-0">
                                                    <label class="text-black">Email</label>
                                                    <input 
                                                        type="text" 
                                                        placeholder="&#xF002; Email" 
                                                        style="font-family:Arial, FontAwesome"
                                                        class="form-control" 
                                                        id="searchEmail"
                                                        oninput="delaySearch()">
                                                </div>
                                                <div class="form-group col-md-2 mb-0">
                                                    <label class="text-black">Giới tính</label>
                                                    <select class="form-control" aria-label="Default select example" id="searchGender" onchange="search()">
                                                        <option value="-1">-</option>
                                                        <option value="2">Nữ</option>
                                                        <option value="1">Nam</option>
                                                        <option value="3">Giới tính khác</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-2 mb-0">
                                                    <label class="text-black">Tổng nợ</label>
                                                    <input type="text" placeholder="&#xF002; Từ" class="form-control" id="debtFrom" oninput="delaySearch()" style="font-family:Arial, FontAwesome">
                                                    <input type="text" placeholder="&#xF002; Đến" class="form-control" id="debtTo" oninput="delaySearch()" style="font-family:Arial, FontAwesome">
                                                </div>  
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 col-xl-12">
                            <div class="card">
                                <div class="card-header d-block pb-0 border-0">



                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-responsive-md table-hover">
                                            <thead class="thead-info">
                                                <tr>
                                                    <th>Tên</th>
                                                    <th>Địa chỉ</th>
                                                    <th>SÐT</th>
                                                    <th>Email</th>
                                                    <th>Giới tính</th>
                                                    <th>Tổng nợ</th>
                                                    <th>Hành động</th>
                                                </tr>
                                            </thead>
                                            <tbody id="listDebtor">

                                            </tbody>
                                        </table>
                                    </div>

                                    <div class="card-footer">
                                        <ul class="pagination justify-content-center" id="pagination-container">

                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--**********************************
                        Content body end
                    ***********************************-->

                    <!--**********************************
                        Footer start
                    ***********************************-->
                </div>
                <div class="footer">
                    <div class="copyright">
                        <p>Copyright © Designed &amp; Developed by <a href="http://dexignzone.com/" target="_blank">DexignZone</a> 2020</p>
                    </div>

                </div>
                <!--**********************************
                    Footer end
                ***********************************-->
                <!-- Modal -->
                <div class="modal fade bd-example-modal-lg"   id="detailsdebtor" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-lg " style="max-width:1200px ">
                        <div class="modal-content" style="width: 1200px">
                            <div class="modal-header">
                                <h5 class="modal-title">Chi tiết người vay/nợ</h5>
                                <input id="idDebtor" name="idDebtor"></input>
                                <!--<h1 id="idDebtor1" name="idDebtor1">  Gía trị của người ấy là:  </h1>-->
                                <button onclick="handleClear()" type="button" class="close" data-dismiss="modal"><span>&times;</span>

                                </button>
                            </div>
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-header">
                                        <button data-toggle="modal"  data-target="#CreateDebtMenus"  type="button" class="btn btn-primary ">Tạo phiếu nợ</button>

                                    </div>
                                    <div class="row">
                                        <div class="card">
                                            <table class="table table-bordered">
                                                <tbody>
                                                    <tr>
                                                        <th scope="col" style="width: 80px" >
                                                            <label class="text-black">ID</label>
                                                            <input type="text" placeholder="ID" name="iddebt" id="searchName" class="form-control">

                                                        </th>
                                                        <th scope="col">
                                                            <label class="text-black">Ghi chú</label>
                                                            <input type="text" placeholder="Ghi chú" class="form-control" id="searchAddress">
                                                        </th>
                                                        <th scope="col" style="width: 200px">
                                                            <label class="text-black">Loại nợ</label>
                                                            <select  class="form-control " aria-label="Default select example" id="searchGender">
                                                                <option selected="">Chọn loại nợ</option>
                                                                <option value="0">Vay</option>
                                                                <option value="1">Nợ</option>
                                                            </select>
                                                        </th>
                                                        <th scope="col" class="text-black">
                                                            <label >Số tiền</label>
                                                            <input type="text" placeholder="From" class="form-control" id="debtFrom">
                                                            <input type="text" placeholder="To" class="form-control" id="debtTo">
                                                        </th>
                                                        <th scope="col">
                                                            <label class="text-black">Ngày lập phiếu</label>
                                                            <input type="date" placeholder="From" class="form-control" id="debtFrom">
                                                            <input type="date" placeholder="To" class="form-control" id="debtTo">
                                                        </th>
                                                        <th scope="col">
                                                            <label class="text-black">Thời gian tạo</label>
                                                            <input type="date" placeholder="From" class="form-control" id="debtFrom">
                                                            <input type="date" placeholder="To" class="form-control" id="debtTo">
                                                        </th>

                                                        <th scope="col">
                                                            <label class="text-black">Hành động</label>
                                                            <button type="submit" class="btn btn-success">Tìm kiếm</button>
                                                            <button class="btn btn-danger">Hủy</button>
                                                        </th>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div id="tabledebt">

                                            <div class="table-responsive">

                                                <table class="table table-hover  table-responsive-md">
                                                    <thead>
                                                        <tr>

                                                            <th class="width50">ID.</th>
                                                            <th>Ghi chú</th>
                                                            <th>Loại</th>
                                                            <th>Số tiền</th>
                                                            <th>Ngày lập phiếu</th>
                                                            <th>Thời gian tạo</th>                                                    
                                                            <th>Hành động</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="listDebt" items="${requestScope.listAllDebt}">
                                                            <tr>

                                                                <td><strong>${listDebt.getId()}</strong></td>
                                                                <td>
                                                                    <span class="w-space-no">${listDebt.getNote()}</span></td>
                                                                <td>
                                                                    Vay

                                                                </td>
                                                                <c:set var = "balance" value = "${listDebt.getMoney()}" />
                                                                <td>
                                                                    <fmt:formatNumber type = "number" 
                                                                                      maxFractionDigits = "3" value = "${balance}" />
                                                                    VNĐ
                                                                </td>
                                                                <td><span class="badge light badge-success">
                                                                        <c:set var = "start" value = "${listDebt.getStartDate()}" />
                                                                        <fmt:formatDate  pattern = " dd/MM/yyyy" type = "time" value = "${start}" />
                                                                    </span></td>
                                                                <td>
                                                                    <span class="badge light badge-danger">
                                                                        <i class="fa fa-circle text-danger mr-1"></i>
                                                                        <c:set var = "create" value = "${listDebt.getCreatedAt()}" />
                                                                        <fmt:formatDate  pattern = " HH:mm dd/MM/yyyy" type = "time" value = "${create}" />
                                                                    </span>
                                                                </td>
                                                                <td>
                                                                    <div class="d-flex">
                                                                        <a href="#" class="btn btn-danger shadow btn-xs sharp mr-1"><i class="fa fa-info"></i></a>
                                                                        <a href="#" class="btn btn-primary shadow btn-xs sharp mr-1"><i class="fa fa-pencil"></i></a>
                                                                        <a href="#" class="btn btn-danger shadow btn-xs sharp mr-1"><i class="fa fa-trash"></i></a>

                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="modal-footer">
                                    <button onclick="handleClear()" type="button" class="btn btn-danger light" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade bd-example-modal-lg"   id="UpdateDebtorMenus" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Thông tin người nợ</h5>
                        <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <form action="updateDebtor" method="post">
                            <input hidden id="debtorIdUpdate" name="debtor-id"/>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 font-weight-bold">Họ và tên</label>
                                <input type="text" class="form-control text-black" name="fullName" id="nameUpdate" maxlength="100" minlength="2" required>
                            </div>

                            <div class="form-group d-flex">
                                <label class="col-sm-3 font-weight-bold">Địa chỉ</label>
                                <input type="text" class="form-control text-black" id="addressUpdate" name="address" maxlength="255" minlength="3" required>                              
                            </div>

                            <div class="form-group d-flex">
                                <label class="col-sm-3 font-weight-bold">SÐT</label>
                                <input type="number" class="form-control text-black" id="phoneUpdate" name="phone" maxlength="15" pattern="[0-9]{9,15}" required>
                            </div>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 font-weight-bold">Email</label>
                                <input type="email" name="email" class="form-control text-black" id="emailUpdate" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" maxlength="255" required>
                            </div>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 font-weight-bold">Tổng nợ</label>
                                <input type="text" id="debtUpdate" class="form-control text-black" style="background-color: #d1d1d1" readonly >
                            </div>
                            <input type="submit" class="btn btn-success" value="Update">
                        </form>
                    </div>
                </div>
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

<script type="text/javascript">
                                        $('#CreateDebtMenus').on('show.bs.modal', function (e) {
                                            $(this).find('.debtor-id').html(e.relatedTarget.id);
                                        });

                                        var inputField = document.getElementById("moneyDebt");
                                        var oldValue = inputField.value;
                                        var oldSelectionStart = inputField.selectionStart;
                                        var form = document.getElementById("formCreateDebt");
                                        var moneyToWord = document.getElementById("moneyToWord");

                                        inputField.addEventListener("keydown", function (e) {
                                            var key = e.keyCode;

                                            if (key >= 65 && key <= 90) {
                                                e.preventDefault();
                                            }
                                        });

                                        form.addEventListener("submit", function (e) {
                                            var value = inputField.value;
                                            var newValue = value.replace(/[^\d]/g, "");

                                            inputField.value = newValue;
                                        });

                                        inputField.addEventListener("input", function (e) {
                                            var value = e.target.value;
                                            var newValue = value.replace(/[^\d]/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                            var number = parseInt(value.replace(/[^\d]/g, ""));
                                            moneyToWord.innerHTML = numberToWords(number) + " VNÐ";

                                            if (newValue !== oldValue) {
                                                var lengthDiff = newValue.length - oldValue.length;
                                                e.target.value = newValue;
                                                e.target.setSelectionRange(oldSelectionStart + lengthDiff, oldSelectionStart + lengthDiff);
                                            }

                                            oldValue = newValue;
                                            oldSelectionStart = e.target.selectionStart;
                                        });

</script>
</body>
</html>
