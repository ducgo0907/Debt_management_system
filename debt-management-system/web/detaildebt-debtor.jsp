<%-- 
    Document   : detaildebt-debtor
    Created on : Feb 17, 2023, 5:17:29 PM
    Author     : kaiok
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Debt Management System</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
        <!-- Custom Stylesheet -->
        <link href="./vendor/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet">
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
                        <li class="mm-active"><a class=" ai-icon" href="home" aria-expanded="true">
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

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">
                <div class="container-fluid">
                    <div class="page-titles">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Sổ ghi nợ</a></li>
                            <li class="breadcrumb-item active"><a href="javascript:void(0)">Chi tiết các khoản vay nợ</a></li>
                        </ol>
                    </div>

                    <!--                    <div class="row">
                                            <div class="col-xl-12 col-lg-12">
                                                                            <div class="card">
                                                
                                                                                <div class="card-body">
                                                                                    <div class="basic-form">
                                                                                        <form>
                                                                                            <div class="form-row">
                                                                                                <div class="form-group col-md-2 mb-0">
                                                                                                    <label>STT</label>
                                                                                                    <input oninput="delaySearch()" id="searchStt" name="searchStt"  type="text" class="form-control" placeholder="Nhập số">
                                                                                                </div>
                                                                                                <div class="form-group col-md-2 mb-2">
                                                                                                    <label>Ghi chú</label>
                                                                                                    <input oninput="delaySearch()" id="searchNote" name="searchNote" type="text" class="form-control" placeholder="Nhập ghi chú">
                                                                                                </div>
                                                                                                <div class="form-group col-md-2 mb-0 ">
                                                                                                    <label>Loại phiếu</label>
                                                                                                    <select id="searchType" class="form-control "  style=" color:#7e7e7e !important" tabindex="-98">
                                                                                                        <option selected="">Chọn loại phiếu</option>
                                                                                                        <option  value="0">Vay</option>
                                                                                                        <option value="1">Nợ</option>
                                                                                                    </select>
                                                
                                                                                                </div>
                                                                                                <div class="form-group col-md-2 mb-0" >
                                                                                                    <label>Số tiền</label>
                                                                                                    <input oninput="delaySearch()" type="text" placeholder="Từ" class="form-control" id="debtFrom">
                                                                                                    <input oninput="delaySearch()" type="text" placeholder="Đến" class="form-control" id="debtTo">
                                                                                                </div>
                                                                                                <div class="form-group col-md-2 mb-0">
                                                                                                    <label >Ngày lập phiếu</label>
                                                                                                    <input oninput="delaySearch()" type="date" placeholder="From" class="form-control" id="createFrom">
                                                                                                    <input oninput="delaySearch()" type="date" placeholder="To" class="form-control" id="createTo">
                                                
                                                                                                </div>
                                                                                                <div class="form-group col-md-2 mb-0" >
                                                                                                    <label >Thời gian tạo</label>
                                                                                                    <input oninput="delaySearch()" type="date" placeholder="From" class="form-control" id="startFrom">
                                                                                                    <input oninput="delaySearch()" type="date" placeholder="To" class="form-control" id="startTo">
                                                                                                </div>
                                                                                                <div  class="form-group col-md-2 mb-2">
                                                                                                                              
                                                                                                    <button  type="button" class="  btn btn-danger ">Hủy</button>
                                                
                                                                                                </div>
                                                
                                                
                                                
                                                
                                                                                            </div>
                                                                                        </form>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                            </div>
                                        </div>-->
                    <div class="row">

                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Các phiếu vay nợ của  <span class="text-primary"> ${debtor.getFullName()}</span></h4>
                                    <a href="javascript:void(0);" id="${debtor.id}"
                                       style="float: right"  
                                       data-target="#CreateDebtMenus"  
                                       class="btn text-white rounded bg-primary"
                                       data-toggle="modal" 
                                       >
                                        <i class="las la-plus"></i>Tạo phiếu nợ
                                    </a>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="example3"  aria-describedby="example3_info" role="grid" class="table table-responsive-md table-hover">
                                            <thead class="thead-info">
                                                <tr>
                                                    <th class="width80">#</th>
                                                    <th class="width400">Ghi chú</th>
                                                    <th>Loại phiếu</th>
                                                    <th>Số tiền</th>
                                                    <th>Ngày lập phiếu</th>
                                                    <th>Thời gian tạo</th>
                                                    <th>Hành động</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listAllDebt}" var="o">
                                                    <tr>
                                                        <td><strong>${o.getId()}</strong></td>
                                                        <td>${o.getNote()}</td>

                                                        <td>
                                                            <c:if test="${o.isIsDebt() == true}">
                                                                <span class="badge light badge-success" >  Cho Vay </span>
                                                            </c:if>
                                                            <c:if test="${o.isIsDebt() == false}">
                                                                <span class="badge light badge-danger" >  Nợ </span>
                                                            </c:if>
                                                        </td>

                                                        <td>
                                                            <c:set var = "balance" value ="${o.getMoney()}" />
                                                            <c:if test="${o.isIsDebt() == true}">
                                                                <span class="badge light badge-success" > <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${balance}" />
                                                                    ₫ </span>
                                                                </c:if>
                                                                <c:if test="${o.isIsDebt() == false}">
                                                                <span class="badge light badge-danger" > <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${balance}" />
                                                                    ₫ </span>
                                                                </c:if>

                                                        </td>
                                                        <td><span class="badge light badge-info">
                                                                <c:set var = "start" value = "${o.getStartDate()}" />
                                                                <fmt:formatDate  pattern = " dd/MM/yyyy" type = "time" value = "${start}" />
                                                            </span></td>
                                                        <td>
                                                            <span class="badge light badge-info">
                                                                <i class="fa fa-circle text-warning mr-1"></i>
                                                                <c:set var = "create" value = "${o.getCreatedAt()}" />
                                                                <fmt:formatDate  pattern = " HH:mm dd/MM/yyyy" type = "time" value = "${create}" />
                                                            </span>
                                                        </td>
                                                        <td>
                                                            <div class="d-flex">

                                                                <a 
                                                                    id="${o.getId()}"
                                                                    href="javascript:void(0);" 
                                                                    data-toggle="modal" 
                                                                    data-target="#ViewDetailsDebt" 
                                                                    class="btn btn-info shadow btn-xs sharp mr-1"
                                                                    onclick="viewDebt(${o.getId()})">
                                                                    <i class="fa fa-info"></i>
                                                                </a>

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
                </div>
            </div>
            <!--**********************************
                Content body end
            ***********************************-->
            <div class="modal fade bd-example-modal-lg"   id="ViewDetailsDebt" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Thông tin phiếu nợ của <strong>${debtor.getFullName()}</strong></h5>
                            <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">

                            <div class="card">

                                <div class="card-body">
                                    <div class="basic-form">
                                        <form action="#">
                                            <div class="input-group mb-3 input-info">
                                                <div class="input-group-prepend">
                                                    <span  class="input-group-text">Loại phiếu</span>

                                                </div>
                                                <input id="isDebtDetails" readonly="" type="text" style="color:black" class="form-control strong" placeholder="">


                                            </div>


                                            <div class="input-group mb-3  input-info">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Ngày lập phiếu</span>
                                                </div>
                                                <input readonly="" style="color:black" id="startDate" type="text" class="form-control">
                                            </div>
                                            <div class="input-group mb-3  input-info">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Thời gian tạo</span>
                                                </div>
                                                <input readonly="" style="color:black" id="createdAt" type="text" class="form-control">
                                            </div>

                                            <div class="input-group mb-3  input-success">
                                                <div class="input-group-prepend">
                                                    <span  class="input-group-text">Số tiền</span>
                                                </div>
                                                <input readonly="" style="color:black" name="dmoney" id="dmoney" type="text" class="form-control">
                                                <div class="input-group-append">
                                                    <span class="input-group-text">₫</span>
                                                </div>
                                            </div>

                                            <div class="input-group   input-warning">
                                                <div class="input-group-prepend">
                                                    <span  class="input-group-text">Ghi chú</span>
                                                </div>
                                                <textarea  readonly="" style="color:black; height:150px" id="noteDetail" class="form-control"></textarea>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>


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
                                    <textarea hidden class="debtor-id" id="debtor-id" name="debtor-id" ></textarea>
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
                                    <label class="ml-1 mr-1">Vay</label>
                                    <input type="radio" class="form-check" name="isDebt" value="1" checked="">
                                    <label class="ml-1 mr-1">Nợ</label>
                                    <input type="radio" class="form-check" name="isDebt" value="0">                               
                                </div>

                                <div class="form-group">
                                    <label>Ghi chú</label>
                                    <textarea rows="7" class="form-control" name="note"> </textarea>
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
                Footer start
            ***********************************-->
            <div class="footer">
                <div class="copyright">
                    <p>Copyright © Designed &amp; Developed by <a href="http://dexignzone.com/" target="_blank">FourTeam</a> 2023</p>
                </div>
            </div>
            <!--**********************************
                Footer end
            ***********************************-->

            <!--**********************************
               Support ticket button start
            ***********************************-->

            <!--**********************************
               Support ticket button end
            ***********************************-->


        </div>
        <!--**********************************
            Main wrapper end
        ***********************************-->

        <!--**********************************
            Scripts
        ***********************************-->
        <!-- Required vendors -->
        <script src="./vendor/global/global.min.js"></script>
        <script src="./vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
        <script src="./js/custom.min.js"></script>
        <script src="./js/deznav-init.js"></script>
        <script src="./vendor/datatables/js/jquery.dataTables.min.js"></script>
        <script src="./js/plugins-init/datatables.init.js"></script>
        <script type="text/javascript">
                                                                        $('#CreateDebtMenus').on('show.bs.modal', function (e) {
                                                                            $(this).find('.debtor-id').html(e.relatedTarget.id);
                                                                        });
        </script>
        <script src="./view-debt.js"></script>
        <script src="./helper.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/big-integer/1.6.51/BigInteger.min.js" integrity="sha512-gHNUM5lAKXJFwUX0qjNGL5tJSoa8TTz2xUTw5COytE/p3MHy2Mivey3Gb76Blf6JfvNglTskVo5YsxDix6XIcg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/big-integer/1.6.51/BigInteger.js" integrity="sha512-gJKs+bNHfx193X/dsoR3XTBnkYWnqXrb63fmhY7S5WSFRPn1dpwZF7zOTvWgaVHhvHCBaR5oniBfHz8xKlfnwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <script type="text/javascript">

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
