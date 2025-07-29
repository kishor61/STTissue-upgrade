<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <link rel="stylesheet" href="/STTissueQR/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="/STTissueQR/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/STTissueQR/plugins/icheck/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/STTissueQR/dist/css/layout.css">
    <link href="/STTissueQR/dist/css/stylesheet.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/2.10.1/styles/overlayscrollbars.min.css">
    <link rel="stylesheet" href="/STTissueQR/plugins/daterangepicker/daterangepicker.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <!-- New Header and sidebar css file path-->
    <link href="/STTissueQR/dist/css/HeaderNew.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href='<spring:url value="dist/img/favicon.ico"/>' />
    <style>
        .main-header {
            background-color: #2189b9 !important;
            border-bottom: none !important;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .navbar-nav {
            align-items: center;
        }
        .emergency-banner {
            background-color: rgba(255, 255, 255, 0.1);
            border-radius: 4px;
            padding: 8px 12px;
            margin-right: 15px;
        }
        .emergency-banner i {
            margin-right: 5px;
        }
        .btn-logout {
            background-color: #343a40;
            border: none;
            transition: all 0.3s ease;
            padding: 8px 16px;
            font-size: 14px;
            border-radius: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            display: flex;
            align-items: center;
            justify-content: center;
            min-width: 40px;
            height: 40px;
        }
        .btn-logout:hover {
            background-color: #23272b;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }
        .btn-logout i {
            font-size: 16px;
            color: #fff;
        }
        .brand-link {
            background-color: #2189b9;
            padding: 20px 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            border-bottom: 1px solid rgba(255,255,255,0.1);
        }
        .brand-image {
            width: 45px;
            height: 45px;
            object-fit: contain;
            border-radius: 50%;
            background-color: #fff;
            padding: 2px;
            margin-top: 20px;
        }
        .brand-image.img-circle {
            border: 2px solid rgba(255,255,255,0.2);
        }
    </style>
</head>
<!--
<script type="text/javascript">
	$(function(){
		timeoutCheck();
		
		$('li.divider').click(function(){
			$('.'+$(this).attr('value')).toggle();
		});
		
	});
	function timeoutCheck(){
		
		$.ajax({
			url:'${timeouturl}',
			type:'GET',
			data:{
				reel:'${defaultReelURL}',
				rewind:'${defaultRewindURL}'
			},
			success:function(data){
				
				if(data.newDay){
					var url=location.href;
					if(url.indexOf("home")>=0){
					 	location.reload(true);
					}else if(url.indexOf("reel/add")>=0){
						timeCheckReelLoop();
					}else if(url.indexOf("rewind/add")>=0){
						timeCheckRewindLoop();
						
					}
				}
				
				//Code By Roshan For Height And Weight
				if(data.showAlarm){
					//alert("Roshan::"+data.showAlarm)
					if(data.emergencyAlramFlag=='Y'){
						//alert(data.emergencyAlramFlag);
						$('#warningDailogAlert').dialog({
							height: 300,
						    width: 800,
							modal: true,
						});
					}	
					
				}

				setTimeout(timeoutCheck, 10000);
			},
			error: function(xhr, status, error) {
				 $( "#warningDailog" ).dialog({
					 height: 200,
				     width: 350,
				     modal: true,
				     close: function() {
				     	 location.href='${singInURL}';
				     }
				 });
			}
		});
	}

	function timeCheckReelLoop(){
		if(!confirm('Your shift is over. Do you want to leave this page?')){
			setTimeout(timeCheckReelLoop, 10000);
		}else{
			location.href='${defaultReelURL}';
		}
		
	}
	function timeCheckRewindLoop(){
		if(!confirm('Your shift is over. Do you want to leave this page?')){
			setTimeout(timeCheckRewindLoop, 10000);
		}else{
			location.href='${defaultRewindURL}';
		}
		
	}
</script>
 -->
<body>
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <%-- <li class="nav-item">
                <span class="nav-link font-weight-bold text-white text-uppercase small emergency-banner">
                    <i class="fas fa-exclamation-triangle"></i> REPORT EMERGENCY
                    <br> CALL 9-569-4777 OR 9-911
                </span>
            </li> --%>
          
          <!--   Stop Mail & Mail Monitoring Buttons 
            <security:authorize access="isAuthenticated()">
            <li class="nav-item mx-3 mt-2">
                <button class="btn btn-danger btn-sm py-2 px-3 rounded-pill shadow">
                    <i class="fas fa-stop-circle"></i> Stop Mail
                </button>
            </li>
            <li class="nav-item mx-3 mt-2">
                <button class="btn btn-success btn-sm py-2 px-3 rounded-pill shadow" style="background: linear-gradient(45deg, #28a745, #218838);">
                    <i class="fas fa-envelope"></i> Mail Monitoring
                </button>
            </li>
            </security:authorize>-->
            <!-- Logout Button -->
            <li class="nav-item">
                <a href='<spring:url value="/signout"></spring:url>' title="Logout">
                    <button class="btn btn-logout">
                        <i class="fa fa-power-off"></i>
                    </button>
                </a>
            </li>
        </ul>
    </nav>

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-light-primary elevation-4">
        <a href="index3.html" class="brand-link">
            <img src="/STTissueQR/dist/images/STTissue.JPG" alt="ST Logo" class="brand-image img-circle elevation-3">
        </a>

        <security:authorize access="isAuthenticated()">
            <div class="sidebar">
                <div class="user-panel mt-3 pb-1 mb-2 d-flex align-items-center">
                    <div class="image">
                        <img src="/STTissueQR/dist/img/avtar.svg" class="img-circle elevation-2" alt="User Image">
                    </div>
                    <div class="info">
                        <a href="#" class="d-block">
                            <small class="d-block">Logged In As</small>
                            <security:authentication property="principal.username" />
                        </a>
                    </div>
                </div>

                <nav class="mt-0">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                        <li class="nav-item">
                            <a href="/STTissueQR/home" class="nav-link active">
                                <p>Home</p>
                            </a>
                        </li> 
                        <li class="nav-item">
                        <a href='<spring:url value="/operatingprocedure/managenew"/>'  class="nav-link active" >QMS </a>
                            
                        </li>
                        <%-- <li class="nav-item">
                            <a href="#" class="nav-link active">
                                <p>MILL CALENDAR</p>
                            </a>
                        </li> --%>
                        <li class="nav-item">
                       
                            <a href='<spring:url value="/pm5reel/add"/>' class="nav-link active">
                                <p>REEL</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href='<spring:url value="/pm5rewind/add"/>'class="nav-link active">
                                <p>REWINDER</p>
                            </a>
                        </li>
                        <%-- <li class="nav-item">
                            <a href="#" class="nav-link active">
                                <p>FRP</p>
                            </a>
                        </li> --%>
                    </ul>
                </nav>
            </div>
        </security:authorize>
    </aside>
</body>
</html>