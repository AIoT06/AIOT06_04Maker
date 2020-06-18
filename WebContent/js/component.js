/*
 * render sideBar, topBar, other components.
 * need jquery. 
 */

function render_sidebar() {
    $(".my-sidebar").append(`
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
            <form id="dashboardPage" class="nav-link" method="post" action="ServerMain">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoDashboard()">Dashboard</span>
            </form>
        </li>
        <li class="nav-item active">
            <form id="carPage" class="nav-link" method="post" action="Car">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoCarPage()">Car</span>
            </form>
        </li>
        <li class="nav-item active">
            <form id="orderPage" class="nav-link" method="post" action="Order">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoOrderPage()">Order</span>
            </form>
        </li>
        <li class="nav-item active">
            <form id="customerPage" class="nav-link" method="post" action="Customer">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoCustomerPage()">Customer</span>
            </form>
        </li>
        <li class="nav-item active">
            <form id="carcontrolPage" class="nav-link" method="post" action="CarControl">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span onclick="gotoCarcontrolPage()">Car Control</span>
            </form>
        </li>
    </ul>
`);
}

function render_topbar() {
    $(".my-topbar").append(`
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
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">`+
                            $('.my-topbar').attr("username")+`
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
`);
}

function render_admin_logout() {
    $(".admin-logout").append(`
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
                <a class="btn btn-primary" href="admin_login.html">Logout</a>
            </div>
        </div>
    </div>
</div>
    `);
}

$(function(){
    render_sidebar();
    render_topbar();
    render_admin_logout();
});
