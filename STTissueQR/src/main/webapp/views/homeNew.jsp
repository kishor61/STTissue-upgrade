<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
            <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="utf-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <title>Home | Barnwell Tissue Solutions </title>
                    <!-- Tell the browser to be responsive to screen width -->
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <!-- Font Awesome -->
                    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
                    <!-- Ionicons -->
                    <!-- <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
                    <!-- Tempusdominus Bbootstrap 4 -->
                    <link rel="stylesheet"
                        href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
                    <!-- iCheck -->
                    <link rel="stylesheet" href="plugins/icheck/icheck-bootstrap.min.css">
                    <!-- Theme style -->
                    <link rel="stylesheet" href="dist/css/layout.css">
                    <link href="dist/css/stylesheet.css" rel="stylesheet">
                    <!-- overlayScrollbars -->
                    <!--<link rel="stylesheet"
    							href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">-->
                    <link
                        href="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/2.10.1/styles/overlayscrollbars.min.css">

                    <!-- Daterange picker -->
                    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
                    <!-- Google Font: Source Sans Pro -->
                    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
                        rel="stylesheet">
					<!-- New Header and sidebar css file path-->
					<link href="dist/css/HeaderNew.css" rel="stylesheet">
                    <style>
                        /* Enhanced toggle styles */
                        .toggleSection {
                            position: relative;
                            transition: all 0.3s ease;
                            padding-right: 30px !important;
                        }
                        .toggleSection::after {
                            content: '\f107';
                            font-family: 'Font Awesome 5 Free';
                            font-weight: 900;
                            position: absolute;
                            right: 15px;
                            top: 50%;
                            transform: translateY(-50%);
                            transition: transform 0.3s ease;
                        }
                        .toggleSection.active::after {
                            transform: translateY(-50%) rotate(180deg);
                        }
                        .toggleContent {
                            max-height: 0;
                            overflow: hidden;
                            transition: max-height 0.3s ease-out, opacity 0.3s ease;
                            opacity: 0;
                        }
                        .toggleContent.show {
                            max-height: 2000px;
                            opacity: 1;
                        }
                        .toggleSection:hover {
                            background-color: #f8f9fc;
                        }
                        .toggleSubmodule {
                            position: relative;
                            transition: all 0.3s ease;
                            padding-right: 30px !important;
                        }
                        .toggleSubmodule::after {
                            content: '\f107';
                            font-family: 'Font Awesome 5 Free';
                            font-weight: 900;
                            position: absolute;
                            right: 15px;
                            top: 50%;
                            transform: translateY(-50%);
                            transition: transform 0.3s ease;
                        }
                        .toggleSubmodule.active::after {
                            transform: translateY(-50%) rotate(180deg);
                        }
                        .toggleSection, .toggleSubmodule {
                            cursor: pointer;
                            user-select: none;
                        }
                        .toggleSection:hover, .toggleSubmodule:hover {
                            background-color: #f1f5f9;
                        }
                        .toggleContent a {
                            transition: all 0.2s ease;
                            display: block;
                            padding: 8px 15px;
                            border-radius: 4px;
                        }
                        .toggleContent a:hover {
                            background-color: #e3f2fd;
                            transform: translateX(5px);
                        }
                    </style>
                </head>

                <body class="hold-transition sidebar-mini layout-fixed">
                    <div class="wrapper">
                        <!-- Include Header -->
                        <jsp:include page="header.jsp" />
                        
                        <!-- main container code here-->
                        <div class="content-wrapper" style="padding-top:20px !important;background-color:#f8f9fc !important;">
                            <div class="content-header" style="padding:0 20px !important;">
                                <h1 style="text-align:center; font-weight:bold;color:#2c3e50;text-shadow: 1px 1px 2px rgba(0,0,0,0.1);padding:15px 0;margin-bottom:20px;">Main Menu</h1>

                                <div class="container-fluid" style="display:flex; gap:20px; padding:0; position:sticky; top:0;">
                                    <!-- Left container (Data Entry) -->
                                    <div style="flex:1; background-color:#fff; border-radius:8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); position:sticky; top:0; height:fit-content;">
                                        <!-- Header div (Data Entry) -->
                                        <div style="background: linear-gradient(90deg, #2980b9 0%, #3498db 100%); padding:12px; border-radius:8px 8px 0 0;">
                                            <h5 style="text-align:center; font-weight:bold; color:white; margin:0; text-shadow: 1px 1px 2px rgba(0,0,0,0.2);">Data Entry</h5>
                                        </div>
                                        <!-- Content below the header -->
                                        <div style="padding:15px;">
                                            <div style="background: linear-gradient(135deg, #f8f9fc 0%, #e9ecef 100%); border-radius:4px; box-shadow: 0 2px 4px rgba(0,0,0,0.05);">
											<!-- SAFETY Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">SAFETY</h6>
                                                <div id="safetySection" class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                        <a href='<spring:url value="/911Emergency/view"/>' style="color:#3498db; text-decoration:none;">911 Entry</a>
                                                    </h6>
                                                    </div>

                                                <!-- CR6 Section -->
                                                <%-- <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">CR6</h6>
                                                <div id="cr6Section" class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <!-- GRADE Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        II) GRADE-(ST TISSUE INTERNAL SPECIFICATION)
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/grade/main"/>'>- Create / View / Edit</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Quality Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        III) QUALITY DATA
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <c:choose>
                                                            <c:when test="${empty reelentryurl}">
                                                                <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='<spring:url value="/reel/add"/>'>Reel</a>
                                                                </h6>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='${reelentryurl}'>Reel</a>
                                                                </h6>
                                                            </c:otherwise>
                                                        </c:choose>
                                                            <c:choose>
                                                                <c:when test="${empty rewindentryurl}">
                                                                <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='<spring:url value="/rewind/add"/>'>Rewinder</a>
                                                                </h6>
                                                                </c:when>
                                                                <c:otherwise>
                                                                <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='${rewindentryurl}'>Rewinder</a>
                                                                </h6>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/operatorCareCheckList/view"/>'>- OBCC</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/qulitycheck_pm6/main"/>'>- Quality Check List R1-R2</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/winderbreakmonitoring/view"/>'>- Winder Break Monitoring</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/winderbreakmonitoring/managebreakreason"/>'>- Winder Break Monitoring - Manage Primary Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/winderbreakmonitoring/managesecondarybreakreason"/>'>- Winder Break Monitoring - Manage Secondary Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/customercomplaintreport/view"/>'>- Customer Complaint</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/efficiencyreport/byDcs"/>'>- Reel Ton - DCS</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Centerline Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        IV) CENTERLINE
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/centerline/new"/>'>- Data Entry</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/centerlinegrade/main"/>'>- Grade</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Efficiency Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        V) EFFICIENCY
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/effprimarycode/main"/>'>- Manage Primary Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/effsecondarycode/main"/>'>- Manage Secondary Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/efficiency/new"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Pulp and Utility Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        VI) PULP AND UTILITY CONSUMPTION
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/utilitykpimaster/new"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Chemical Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        VII) CHEMICAL
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/chemicalinv/primary/manage"/>'>- Primary Chemical Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/chemicalinv/secondary/manage"/>'>- Secondary Chemical Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/chemicalinv/chemical/manage"/>'>- Chemical Code</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/chemicalinv/chemicaldata/new"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>
                                                   
                                                    <!-- Daily Logs Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        VIII) DAILY LOGS
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>- Add Master/ Area</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/manintenancelog/page"/>'>- Daily Shift Logs Data Entry</a>
                                                        </h6>
                                                    </div>
                                                </div> --%>

                                                <!-- CR5 Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">PM5 PRODUCTION</h6>
                                                <div id="cr5Section" class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <!-- GRADE Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        II) GRADE-(ST TISSUE INTERNAL SPECIFICATION)
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5grade/main"/>'>- Create / View / Edit</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Quality Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        III) QUALITY DATA
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <c:choose>
                                                            <c:when test="${empty reelentryurlpm5}">
                                                                <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='<spring:url value="/pm5reel/add"/>'>Reel</a>
                                                                </h6>
												</c:when>
												<c:otherwise>
                                                                <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                   <a href='${reelentryurlpm5}'>Reel </a>
                                                                </h6>
												</c:otherwise>
											</c:choose>
                                                        <c:choose>
                                                            <c:when test="${empty rewindentryurl}">
                                                                <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                  <a href='<spring:url value="/pm5rewind/add"/>'>Rewinder </a>
                                                                </h6>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <h6 style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='${rewindentryurlpm5}'>Rewinder </a>
                                                                </h6>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/operatorCareCheckListPM5/view"/>'>- OBCC</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/qulitycheck_pm5/main"/>'>- Quality Check List R1-R2</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Centerline Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        IV) CENTERLINE
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5centerline/new"/>'>- Data Entry</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5centerlinegrade/main"/>'>- Grade</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Efficiency Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        V) EFFICIENCY
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5effprimarycode/main"/>'>- Manage Primary Code</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5effsecondarycode/main"/>'>- Manage Secondary Code</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5efficiency/new"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Pulp and Utility Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        VI) PULP AND UTILITY CONSUMPTION
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5utilitykpimaster/new"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>
                                                   
                                                    <!-- Chemical Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        VII) CHEMICAL
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5chemicalinv/primary/manage"/>'>- Primary Chemical Code</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5chemicalinv/secondary/manage"/>'>- Secondary Chemical Code</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5chemicalinv/chemical/manage"/>'>- Chemical Code</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/pm5chemicalinv/chemicaldata/new"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Daily Logs Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        VIII) DAILY LOGS
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>- Add Master/ Area</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/manintenancelog/page"/>'>- Daily Shift Logs Data Entry</a>
                                                        </h6>
                                                </div>
                                            </div>

                                                 <!-- FRP Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">FRP</h6>
                                                <div id="frpSection" class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <!-- Production Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        I) PRODUCTION
                                                    </h6>
                                                    <div id="safetySection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/frpproductionopdataentry/new"/>'>- Operator Data Entry</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Efficiency Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        II) EFFICIENCY
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/frpeffprimarycode/main"/>'>- Manage Primary Code</a>
                                                        </h6>
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/frpeffsecondarycode/main"/>'>- Manage Secondary Code</a>
                                                        </h6>
                                                    </div>
													
                                                    <!-- OBCC Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;"class="toggleSubmodule" >
                                                        III) OBCC
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6  style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/frpobccCommon/view"/>'>- OBCC</a>
                                                        </h6>
                                                    </div>
                                                    </div> 
													<%--
                                                <!-- PM Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">PM</h6>
                                                <div id="pmSection" class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <!-- Mill Calendar Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        I) MILL CALENDAR
                                                    </h6>
                                                    <div id="safetySection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/staticdata/view"/>'>- Upload</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Safety Log Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        II) SAFETY LOG
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/safetylogreport/view"/>'>- Data Entry</a>
                                                        </h6>
                                                    </div>

                                                    <!-- Safety and Housekeeping Section -->
                                                    <h6 style="cursor:pointer; margin-bottom:5px; margin-left:15px; font-weight:bold;" class="toggleSubmodule">
                                                        III) SAFETY AND HOUSEKEEPING
                                                    </h6>
                                                    <div id="gradeSection" class="toggleContent" style="display:none; padding:5px; margin-left:35px; background-color:#9def912e; font-weight:bold;">
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/safetyhousekeeping/main"/>'>- Safety Housekeeping</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/safetyhousekeeping/view/standard"/>'>- Safety Housekeeping-Standard</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/safetyhousekeeping/positiveObservations"/>'>- Positive Observations</a>
                                                        </h6>
                                                            <c:choose>
											<c:when test="${empty housekeepingscheduleurl}">
                                                                <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='${housekeepingscheduleurl}'>- Safety Housekeeping-Schedule</a>
                                                                </h6>
                                                        </c:when>
                                                        <c:otherwise>
                                                                <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                                    <a href='${housekeepingscheduleurl}'>Safety Housekeeping-Schedule</a>
                                                                </h6>
                                                        </c:otherwise>
                                                    </c:choose>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/auditor/manage"/>'>- Manage-Auditor</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/area/manage"/>'>- Manage-Area</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/incidentaluser/manage"/>'>- Manage-Incidental Auditor</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/incidentaluser/upload/documents"/>'>- Upload-Incidental Document(s)</a>
                                                        </h6>
                                                        <h6 class="toggleSubmodule" style="cursor:pointer; margin-bottom:5px; font-weight:bold;">
                                                            <a href='<spring:url value="/area/auditdoneornot"/>'>- Audit Done Or Not</a>
                                                        </h6>
                                                    </div>
                                                    </div>--%>
                                                    </div>
                                                </div>
                                            </div>

                                    <!-- Right container (Report) -->
                                    <div style="flex:1; background-color:#fff; border-radius:8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); position:sticky; top:0; height:fit-content;">
                                        <!-- Header div (Report) -->
                                        <div style="background: linear-gradient(90deg, #2980b9 0%, #3498db 100%); padding:12px; border-radius:8px 8px 0 0;">
                                            <h5 style="text-align:center; font-weight:bold; color:white; margin:0; text-shadow: 1px 1px 2px rgba(0,0,0,0.2);">Report</h5>
                                        </div>
                                        <!-- Content below the header -->
                                        <div style="padding:15px;">
                                            <div style="background: linear-gradient(135deg, #f8f9fc 0%, #e9ecef 100%); border-radius:4px; box-shadow: 0 2px 4px rgba(0,0,0,0.05);">
                                                <!-- SAFETY Report Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">SAFETY</h6>
                                                <div id="safetyReportSection" class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/911EmergencyReport/view"/>' style="color:#3498db; text-decoration:none;">- 911 Report Review</a>
                                                    </h6>
                                    </div>

                                                <%-- <!-- PM6 PRODUCTION Report Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">PM6 PRODUCTION</h6>
                                                <div class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/reelreport/"/>' style="color:#3498db; text-decoration:none;">- Reel Testing</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/rewindreport/"/>' style="color:#3498db; text-decoration:none;">- Rewinder Testing</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/reelreport/scacoating/"/>' style="color:#3498db; text-decoration:none;">- SCA Coating Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/qulitycheck_pm6/qualityChecklist/report"/>' style="color:#3498db; text-decoration:none;">- Quality Checklist R1-R2</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/OBCCReport/view"/>' style="color:#3498db; text-decoration:none;">- OBCC Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/OBCCReport/viewDownload"/>' style="color:#3498db; text-decoration:none;">- OBCC Report Downloaded Percentage</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/centerlinereport/view"/>' style="color:#3498db; text-decoration:none;">- Centerline Data</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/centerlinereport/view2"/>' style="color:#3498db; text-decoration:none;">- Centerline Data 2</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/efficiencyreport/main"/>' style="color:#3498db; text-decoration:none;">- Efficiency</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/efficiencyreport/summary"/>' style="color:#3498db; text-decoration:none;">- Efficiency Summary</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/utilitykpimasterreport/view"/>' style="color:#3498db; text-decoration:none;">- KPI, Master and Utility</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/wrapperredcodereport/view"/>' style="color:#3498db; text-decoration:none;">- Wrapper Red/Reject Tons Summary</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/certificateanalysis/main"/>' style="color:#3498db; text-decoration:none;">- Certificate</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/certificateanalysis/mainNew"/>' style="color:#3498db; text-decoration:none;">- Certificate With Roll</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/manintenancelog/reportpage"/>' style="color:#3498db; text-decoration:none;">- Daily Shift Log Report</a>
                                                    </h6>
                                        </div> --%>

                                                <!-- PM5 PRODUCTION Report Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">PM5 PRODUCTION</h6>
                                                <div class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/pm5reelreport/"/>' style="color:#3498db; text-decoration:none;">- Reel Testing</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/pm5rewindreport/"/>' style="color:#3498db; text-decoration:none;">- Rewinder Testing</a>
                                                    </h6>
                                                    <%-- <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/pm5centerlinereport/view"/>' style="color:#3498db; text-decoration:none;">- Centerline Data</a>
                                                    </h6> --%>
                                                    <%-- <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/pm5centerlinereport/view2"/>' style="color:#3498db; text-decoration:none;">- Centerline Data 2</a>
                                                    </h6> --%>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/qulitycheck_pm5/qualityChecklist/report"/>' style="color:#3498db; text-decoration:none;">- Quality Checklist R1-R2</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/OBCCPM5Report/view"/>' style="color:#3498db; text-decoration:none;">- OBCC Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/OBCCPM5Report/viewDownload"/>' style="color:#3498db; text-decoration:none;">- OBCC Report Downloaded Percentage</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/pm5efficiencyreport/main"/>' style="color:#3498db; text-decoration:none;">- Efficiency</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/pm5efficiencyreport/summary"/>' style="color:#3498db; text-decoration:none;">- Efficiency Summary</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/manintenancelog/reportpage"/>' style="color:#3498db; text-decoration:none;">- Daily Shift Log Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/certificateanalysis/mainNewPm5"/>' style="color:#3498db; text-decoration:none;">- Certificate With Roll</a>
                                                    </h6>
                                                </div>

                                                 <!-- FRP PRODUCTION Report Section -->
                                                <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">FRP PRODUCTION</h6>
                                                <div class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/frpproductionreport/view"/>' style="color:#3498db; text-decoration:none;">- Production Data</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/frpefficiencyreport/main"/>' style="color:#3498db; text-decoration:none;">- Efficiency</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/frpefficiencyreport/summary"/>' style="color:#3498db; text-decoration:none;">- Efficiency Summary</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/frpobccReport/view"/>' style="color:#3498db; text-decoration:none;">- OBCC Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/frpobccReport/ViewDownload"/>' style="color:#3498db; text-decoration:none;">- OBCC Report Downloaded Percentage</a>
                                                    </h6>
                                                </div> 

                                                <!-- BALE INVENTORY Report Section -->
                                                <%-- <h6 style="cursor:pointer; margin:0; padding:10px 15px; font-weight:bold; color:#2c3e50;" class="toggleSection">BALE INVENTORY & WASTE PAPER</h6>
                                                <div class="toggleContent" style="display:none; padding:5px 15px 5px 35px; background-color:#f1f5f9;">
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/barcodereport/view"/>' style="color:#3498db; text-decoration:none;">- Barcode Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/barcodereport/view2"/>' style="color:#3498db; text-decoration:none;">- Barcode Report 2</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/wastepaperreport/view"/>' style="color:#3498db; text-decoration:none;">- Wastepaper Report</a>
                                                    </h6>
                                                    <h6 style="cursor:pointer; margin-bottom:5px;">
                                                        <a href='<spring:url value="/wastepaperreport/view2"/>' style="color:#3498db; text-decoration:none;">- Wastepaper Report 2</a>
                                                    </h6>
                                                </div> --%>
                                            </div>
                                                </div>
                                            </div>
                                                </div>
                                            </div>
                                                </div>
                                            </div>

                    <!-- /.content-wrapper -->
                    <footer class="main-footer" style="text-align:center;color:black; height:20px;">
                        <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
                    </footer>

                    </div>

                    <!--script for the cr6 toggle-->
                    <script>
                        document.addEventListener("DOMContentLoaded", function() {
                            // Toggle section visibility
                            document.querySelectorAll('.toggleSection').forEach(section => {
                                section.addEventListener('click', function() {
                                    const content = this.nextElementSibling;
                            if (content && content.classList.contains('toggleContent')) {
                                        this.classList.toggle('active');
                                        if (content.style.display === 'none') {
                                            content.style.display = 'block';
                                            content.style.maxHeight = '2000px';
                                            content.style.opacity = '1';
                                        } else {
                                            content.style.display = 'none';
                                            content.style.maxHeight = '0';
                                            content.style.opacity = '0';
                                        }
                                    }
                                });
                            });

                            // Toggle submodule visibility
                            document.querySelectorAll('.toggleSubmodule').forEach(submodule => {
                                submodule.addEventListener('click', function(e) {
                                    if (!e.target.closest('a')) {
                                        const content = this.nextElementSibling;
                                        if (content && content.classList.contains('toggleContent')) {
                                            this.classList.toggle('active');
                                            if (content.style.display === 'none') {
                                                content.style.display = 'block';
                                                content.style.maxHeight = '2000px';
                                                content.style.opacity = '1';
                                            } else {
                                                content.style.display = 'none';
                                                content.style.maxHeight = '0';
                                                content.style.opacity = '0';
                                            }
                                        }
                                    }
                                });
                            });
                        });
                    </script>

                    <!-- ./wrapper -->
                    <!-- jQuery -->
                    <script src="plugins/jquery/jquery.min.js"></script>
                    <!-- jQuery UI 1.11.4 -->
                    <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
                    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
                    <script>
                        $.widget.bridge('uibutton', $.ui.button)
                    </script>
                    <!-- Bootstrap 4 -->
                    <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
                    <!-- Sparkline -->
                    <script src="plugins/sparkline/jquery.sparkline.js"></script>
                    <!-- daterangepicker -->
                    <script src="plugins/moment/moment.min.js"></script>
                    <script src="plugins/daterangepicker/daterangepicker.js"></script>
                    <!-- Tempusdominus Bootstrap 4 -->
                    <script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
                    <!-- overlayScrollbars -->
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/2.10.1/browser/overlayscrollbars.browser.es6.min.js"></script>
                                <!-- AdminLTE App -->
                    <script src="dist/js/adminlte.js"></script>
                    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
                    <script src="dist/js/dashboard.js"></script>
                </body>

                </html>