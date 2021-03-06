<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.aiotdelivery.bean.ViewOrderListBean" %>
<%@ page import="com.aiotdelivery.bean.CustomerBean" %>
<jsp:useBean id="user" class="com.aiotdelivery.bean.CustomerBean" scope="session" />
<%-- List<ViewOrderListBean> ords = (ArrayList<ViewOrderListBean>) request.getAttribute("ords"); --%>
<%-- CustomerBean user = (CustomerBean) session.getAttribute("user"); --%>

<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Order</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet">

    <!-- DataTable -->
    <link href="css/jquery.dataTables.css" rel="stylesheet" type="text/css">
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <li>
	        <div class="sidebar-brand d-flex align-items-center justify-content-center" onclick="gotoDashboard()">
	            <div class="sidebar-brand-icon rotate-n-15">
	                <i class="fas fa-laugh-wink"></i>
	            </div>
	            <div class="sidebar-brand-text mx-3">NexRover</div>
	        </div>
        </li>

        <!-- Divider -->
        <li>
	        <hr class="sidebar-divider my-0">
        </li>

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <form id="dashboardPage" class="nav-link" method="post" action="UserMain">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoDashboard()">All Orders</span>
            </form>
        </li>
        <li class="nav-item active">
            <form id="insertForm" class="nav-link" method="post" action="AddNewOrder">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="insertForm()">Create New Orders</span>
            </form>
        </li>
        <li class="nav-item active">
            <form id="aboutusPage" class="nav-link" method="post" action="AboutUs">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoAboutUs()">About NexRover</span>
            </form>
        </li>
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter">3+</span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Alerts Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="mr-3">
                                    <span class="icon-circle bg-primary">
                                        <i class="fas fa-file-alt text-white"></i>
                                    </span>
                                </span>
                                <span>
                                    <span class="small text-gray-500">December 12, 2019</span>
                                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                </span>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="mr-3">
                                    <span class="icon-circle bg-success">
                                        <i class="fas fa-donate text-white"></i>
                                    </span>
                                </span>
                                <span>
                                    <span class="small text-gray-500">December 7, 2019</span>
                                    $290.29 has been deposited into your account!
                                </span>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="mr-3">
                                    <span class="icon-circle bg-warning">
                                        <i class="fas fa-exclamation-triangle text-white"></i>
                                    </span>
                                </span>
                                <span>
                                    <span class="small text-gray-500">December 2, 2019</span>
                                    Spending Alert: We've noticed unusually high spending for your account.
                                </span>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-envelope fa-fw"></i>
                            <!-- Counter - Messages -->
                            <span class="badge badge-danger badge-counter">7</span>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">
                                Message Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60"
                                         alt="">
                                    <span class="status-indicator bg-success"></span>
                                </span>
                                <span class="font-weight-bold">
                                    <span class="text-truncate">Hi there! I am wondering if you can help me with a
                                        problem I've been having.
                                    </span>
                                    <span class="small text-gray-500">Emily Fowler · 58m</span>
                                </span>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60"
                                         alt="">
                                    <span class="status-indicator"></span>
                                </span>
                                <span>
                                    <span class="text-truncate">I have the photos that you ordered last month, how would
                                        you like them sent to you?
                                    </span>
                                    <span class="small text-gray-500">Jae Chun · 1d</span>
                                </span>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60"
                                         alt="">
                                    <span class="status-indicator bg-warning"></span>
                                </span>
                                <span>
                                    <span class="text-truncate">Last month's report looks great, I am very happy with the
                                        progress so far, keep up the good work!
                                    </span>
                                    <span class="small text-gray-500">Morgan Alvarez · 2d</span>
                                </span>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <span class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                         alt="">
                                    <span class="status-indicator bg-success"></span>
                                </span>
                                <span>
                                    <span class="text-truncate">Am I a good boy? The reason I ask is because someone told
                                        me that people say this to all dogs, even if they aren't good...
                                    </span>
                                    <span class="small text-gray-500">Chicken the Dog · 2w</span>
                                </span>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                        </div>
                    </li>

                    <li>
                        <div class="topbar-divider d-none d-sm-block"></div>
                    </li>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                <%--=user.getName()--%>
                                <jsp:getProperty name="user" property="name"/>
                            </span>
                            <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60"
                                 alt="img-profile rounded-circle">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>
                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">All Orders</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        <i class="fas fa-download fa-sm text-white-50"></i> Generate Report
                    </a>
                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Car List</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="myDataTable" class="display">
                                <thead>
                                <tr>
                                    <th>訂單編號</th>
                                    <th>姓名</th>
                                    <th>預定時間</th>
                                    <th>出車編號</th>
                                    <th>目的地</th>
                                    <th>訂單狀態</th>
                                    <th>編輯資料</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ords}" var="ord" varStatus="c">
                                        <c:choose>
                                            <c:when test="${ord.orderId == orderId}">
                                    <tr>
                                        <td>${ord.orderId}
                                            <label for="orderId">
                                                <input type="text" name="orderId" id="orderId" style="display: none"
                                                       size="8" maxlength="10" value="${ord.orderId}">
                                            </label>
                                        </td>
                                        <td>${ord.customerName}</td>
                                        <td>
                                            <label for="arriveTime">
                                                <input type="text" name="arriveTime" id="arriveTime" class="datetimepicker"
                                                       size="20" maxlength="20" value="${ord.arriveTime}">
                                            </label>
                                        </td>
                                        <td>${ord.carId}</td>
                                        <td>
                                            <label for="destAddr">
                                                <input type="text" name="destAddr" id="destAddr"
                                                       size="40" maxlength="40" value="${ord.destAddr}">
                                            </label>
                                        </td>
                                        <td>${ord.description}</td>
                                        <td><input type="button" value="修改" onclick="updateOrderUser()"/>
                                            <input type="button" value="取消" onclick="gotoDashboard()"/></td>
                                    </tr>
                                        </c:when>
                                        <c:otherwise>                                        
                                        <tr>
                                            <td>${ord.orderId}</td>
                                            <td>${ord.customerName}</td>
                                            <td>${ord.arriveTime}</td>
                                            <td>${ord.carId}</td>
                                            <td>${ord.destAddr}</td>
                                            <td>${ord.description}</td>
                                            <td></td>
                                        </tr>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                </tbody>
                            </table>
                            <h3>共${ords.size()}筆訂單資料</h3>
                            <input type="button" value="新增訂單" onclick="insertForm()"/>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <form id="updateOrder" method="post" action="UpdateToUserMain"></form>

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2019</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="user_login.html">Logout</a>
            </div>
        </div>
    </div>
</div>


<!-- link to jQuery -->
<script src="js/jquery-3.4.1.min.js"></script>

<!-- Bootstrap core JavaScript-->
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!--引用dataTables.js-->
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('#table_id').DataTable();
        $("#myDataTable").DataTable({
            searching: true, //關閉filter功能
            // columnDefs: [{
            //     targets: [3],
            //     orderable: false,
            // }]
        });
    });
</script>

<script src="js/jquery.datetimepicker.full.min.js"></script>
<script src="js/jquery-ui.js"></script>

<script>
    $(function () {
        $(".datetimepicker").datetimepicker();
    });
</script>

<!-- sidebar control (need jQuery)-->
<script src="js/sidebar-control.js"></script>
<script src="js/crud.js"></script>

</body>

</html>