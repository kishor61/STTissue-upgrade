<link rel="stylesheet" href="/BTSQR/plugins/fontawesome-free/css/all.min.css">
	<link rel="stylesheet"href="/BTSQR/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
	<!-- iCheck -->
	<link rel="stylesheet" href="/BTSQR/plugins/icheck/icheck-bootstrap.min.css">
	<!-- Theme style -->
	 <link rel="stylesheet" href="/BTSQR/dist/css/layout.css">
	 <link href="/BTSQR/dist/css/stylesheet.css" rel="stylesheet">
	                    <!-- overlayScrollbars -->
	                    <!--<link rel="stylesheet"
	    href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">-->
	 <link  href="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/2.10.1/styles/overlayscrollbars.min.css">

	 <link rel="stylesheet" href="/BTSQR/plugins/daterangepicker/daterangepicker.css">
	                    <!-- Google Font: Source Sans Pro -->
	 <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	                        rel="stylesheet">
	<!-- New Header and sidebar css file path-->
	<link href="/BTSQR/dist/css/HeaderNew.css" rel="stylesheet">
	
<link rel="icon" type="image/x-icon" href='<spring:url value="dist/img/favicon.ico"/>' />

<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-white navbar-light"
                            style="height:71px; background-color:#2189b9;">
<!-- Left navbar links 
<ul class="navbar-nav">
<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
                    href="#" role="button"><i class="fas fa-bars"></i></a></li>
</ul>-->
<!-- Right navbar links -->
 
                            <ul class="navbar-nav ml-auto">
<!-- Notifications Dropdown Menu 
<li class="nav-item d-inline-block d-md-none"><a
                    href="index3.html" class="brand-link"> <img
                        src="dist/img/logo.png" alt="Nigeria Police Logo"
                        width="60" class="brand-image img-circle elevation-3"> <span
                        class="brand-text 	d-none">ST PaperOne Duluth</span>
</a></li>-->
 
                                <li class="nav-item mx-3">
<span
                                        class="nav-link font-weight-bold text-white text-uppercase small blinking-bg px-2 py-1 rounded">
<i class="fas fa-exclamation-triangle"></i> REPORT EMERGENCY
<br> CALL 9-569-4777 OR 9-911
</span>
</li>
<li class="nav-item mx-3">
<span
                                        class="nav-link font-weight-bold text-white text-uppercase small blinking-bg px-2 py-1 rounded">
<i class="fas fa-exclamation-triangle"></i> LOCATE EMERGENCY
<br> CALL 9-757-569-4711
</span>
</li>
<!-- Stop Mail & Mail Monitoring Buttons -->
<li class="nav-item mx-3 mt-2">
<button class="btn btn-danger btn-sm py-2 px-3 rounded-pill shadow">
<i class="fas fa-stop-circle"></i> Stop Mail
</button>
</li>
<li class="nav-item mx-3 mt-2">
<button class="btn btn-success btn-sm py-2 px-3 rounded-pill shadow"
                                        style="background: linear-gradient(45deg, #28a745, #218838);">
<i class="fas fa-envelope"></i> Mail Monitoring
</button>
</li>
<!-- Logout Button (Only Icon) -->
<li class="nav-item mx-3 mt-2">
<a href='<spring:url value="/signout"></spring:url>' title="Logout">
<button class="btn btn-dark btn-sm py-2 px-3 rounded-pill shadow">
<i class="fa fa-power-off"></i>
</button>
</a>
</li>
</ul>
</nav>
<!-- /.navbar -->
<!-- Main Sidebar Container -->
<!-- Sidebar -->
<aside class="main-sidebar sidebar-light-primary elevation-4">
<a href="index3.html" class="brand-link">
<img src="/BTSQR/dist/images/STlogo.png" alt="Nigeria Police Logo" width="60"
                                    class="brand-image img-circle elevation-3">
<span class="brand-text d-none">St Tissue & Paper</span>
</a>
 
                            <security:authorize access="isAuthenticated()">
<div class="sidebar">
<div class="user-panel mt-3 pb-1 mb-2 d-flex align-items-center">
<div class="image">
<img src="/BTSQR/dist/img/avtar.svg" class="img-circle elevation-2"
                                                alt="User Image">
</div>
<div class="info">
<a href="#" class="d-block">
<small class="d-block">Logged In As</small>
<security:authentication property="principal.username" />
</a>
</div>
</div>
 
                                    <nav class="mt-0">
<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview"
                                            role="menu" data-accordion="false">
<li class="nav-item"><a href="#" class="nav-link active">
<p>Home</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>QMS</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>MILL CALENDAR</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>ST TISSUE BLOG</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>ST SPARES</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>MSDS</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>REEL</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>REWINDER</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>PM6 CENTERLINE</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>PM6 EFFICIENCY</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>PM6 UTILITY KPI</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>CHEMICAL</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>CERTIFICATEY</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>FRP</p>
</a></li>
<li class="nav-item"><a href="#" class="nav-link active">
<p>PM</p>
</a></li>
</ul>
</nav>
</div>
</security:authorize>
</aside>