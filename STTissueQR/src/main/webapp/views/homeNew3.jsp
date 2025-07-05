<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="app.name" /> - Home</title>
<link rel="icon" type="image/x-icon" href='<spring:url value="/dist/img/favicon.ico"/>' />


<link rel="stylesheet" type="text/css" href='<spring:url value="/dist/css/old/style.css"/>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/dist/css/old/custom-theme/jquery-ui-1.10.4.custom.min.css"/>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/dist/css/old/jquery.qtip.min.css"/>'>

<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery-ui-1.10.4.custom.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.PrintArea.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.qtip.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/common.js"/>'></script>
<style type="text/css">
ol{
	list-style: upper-roman;
}
ol li h3{
	text-transform: uppercase;
	color: rgb(105, 88, 88);
}
ol li a {
	font-family: Verdana;
	text-transform: capitalize;
	font-size: 12px;
	text-decoration: none;
	line-height: 19px;
	color: rgb(31, 121, 176);
}
ol li a:HOVER {
	color: rgb(31, 121, 0);
}
</style>
</head>
<body>

	<div class="container ">
	
		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		
	
		<div class="block3 ui-widget" style="overflow: auto;">
			<div class="pageContent">
				<div style="padding: 2px; overflow: auto; position: fixed; bottom: 0; left: 5px; right: 5px; top: 50px;">
					<br>					
					<table class="table">
						<thead>
							<tr class="ui-state-highlight">
									<th colspan="2"><blink><span style="font-size: 18px;margin-left: 30px;">Yield :-  ${yield }</span></blink></th>
							</tr>
							<tr class="ui-state-highlight">
									<th colspan="2"><span style="font-size: 18px;">MAIN	MENU</span></th>
							</tr>
						</thead>
						<tbody>			
							
							<tr>
								<td width="50%" align="center"><b>Data Entry</b></td>
								<td width="50%" align="center"><b>Reports</b></td>
							</tr>
							
							
							
							
							
								<td width="50%" style="height: 200px; vertical-align: top;">
									
									
								
										<h3 style="text-decoration: underline; font-size: 14px;">CR6</h3>
									
									<ol>
										
										
										
										<li><h3><strong>Safety</strong></h3>
											<ul>
												<li><a href='<spring:url value="/911Emergency/view"/>'>911	Entry</a></li>
											</ul>
										</li>
										<li>
											<h3>GRADE - (ST TISSUE INTERNAL SPECIFICATION)</h3>
											<ul>
												<li><a href='<spring:url value="/grade/main"/>'>Create / View / Edit</a></li>
											</ul>
										</li>
										
										
										
										<li>
											<h3>Quality Data</h3>
											<ul>
												<li>
													<c:choose>
														<c:when test="${empty reelentryurl}">
															<a href='<spring:url value="/reel/add"/>'>Reel</a>
														</c:when>
														<c:otherwise>
															<a href='${reelentryurl}'>Reel </a>
														</c:otherwise>
													</c:choose>
												</li>
												<li>
													<c:choose>
														<c:when test="${empty rewindentryurl}">
															<a href='<spring:url value="/rewind/add"/>'>Rewinder </a>
														</c:when>
														<c:otherwise>
															<a href='${rewindentryurl}'>Rewinder </a>
														</c:otherwise>
													</c:choose>
												</li>
												<li><a href='<spring:url value="/operatorCareCheckList/view"/>'>OBCC</a></li>
												<li><a href='<spring:url value="/qulitycheck_pm6/main"/>'>Quality Check List R1-R2</a></li>
												
												<li><a href='<spring:url value="/winderbreakmonitoring/view"/>'>Winder Break Monitoring</a></li>
												<li><a href='<spring:url value="/winderbreakmonitoring/managebreakreason"/>'>Winder Break Monitoring - Manage Primary Code</a></li> 
												<li><a href='<spring:url value="/winderbreakmonitoring/managesecondarybreakreason"/>'>Winder Break Monitoring - Manage Secondary Code</a></li>   
												<li><a href='<spring:url value="/customercomplaintreport/view"/>'>Customer Complaint</a></li>
												<li><a href='<spring:url value="/efficiencyreport/byDcs"/>'>Reel Ton - DCS</a></li>
											</ul>
										</li>
										<li>
											<h3>CENTERLINE</h3>
											<ul>
												<li><a href='<spring:url value="/centerline/new"/>'>Data Entry</a></li>
												
													<li><a href='<spring:url value="/centerlinegrade/main"/>'>Grade</a></li>
												
											</ul>
										</li>
										<li>
											<h3>EFFICIENCY</h3>
											<ul>
												
													<li><a href='<spring:url value="/effprimarycode/main"/>'>Manage Primary Code</a></li>
													<li><a href='<spring:url value="/effsecondarycode/main"/>'>Manage Secondary Code</a></li>
												
												<li><a href='<spring:url value="/efficiency/new"/>'>Data Entry </a></li>
											</ul>
										</li>
										<li>
											<h3>PULP AND UTILITY CONSUMPTION</h3>
											<ul>
												<li><a href='<spring:url value="/utilitykpimaster/new"/>'>Data Entry </a></li>
											</ul>
										</li>
										<li>
											<h3>Chemical</h3>
											<ul>
												<li><a href='<spring:url value="/chemicalinv/primary/manage"/>'>Primary Chemical Code</a></li>
												<li><a href='<spring:url value="/chemicalinv/secondary/manage"/>'>Secondary Chemical Code</a></li>
												<li><a href='<spring:url value="/chemicalinv/chemical/manage"/>'>Chemical Code</a></li>
												<li><a href='<spring:url value="/chemicalinv/chemicaldata/new"/>'>Data Entry</a></li>
											</ul>
										</li>
										
										<li>
											<h3>Daily Logs</h3>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>Add Master/ Area</a></li>
											</ul>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/page"/>'>Daily Shift Logs Data Entry</a></li>
											</ul>
										</li>
										
									</ol>
									<br>
								
									
									
									<!-- PM5 Module Starts From Here Done By Roshan Tailor Date:- 21/12/2017 -->
									
										
									
										<h3 style="text-decoration: underline; font-size: 14px;">CR5</h3>
									
									<ol>
										
										
										
										<li>
											<h3>GRADE - (ST TISSUE INTERNAL SPECIFICATION)</h3>
											<ul>
												<li><a href='<spring:url value="/pm5grade/main"/>'>Create / View / Edit</a></li>
											</ul>
										</li>
										
										
										
										<li>
											<h3>Quality Data</h3>
											<ul>
												<li>
													<c:choose>
														<c:when test="${empty reelentryurlpm5}">
															<a href='<spring:url value="/pm5reel/add"/>'>Reel</a>
														</c:when>
														<c:otherwise>
															<a href='${reelentryurlpm5}'>Reel </a>
														</c:otherwise>
													</c:choose>
												</li>
												<li>
													<c:choose>
														<c:when test="${empty rewindentryurlpm5}">
															<a href='<spring:url value="/pm5rewind/add"/>'>Rewinder </a>
														</c:when>
														<c:otherwise>
															<a href='${rewindentryurlpm5}'>Rewinder </a>
														</c:otherwise>
													</c:choose>
												</li>
												<li><a href='<spring:url value="/pm5efficiencyreport/byDcs"/>'>Reel Ton - DCS</a></li>
												<li><a href='<spring:url value="/operatorCareCheckListPM5/view"/>'>OBCC</a></li>
												<li><a href='<spring:url value="/qulitycheck_pm5/main"/>'>Quality Check List R1-R2</a></li>
												<%--<li><a href='<spring:url value="/pm5winderbreakmonitoring/view"/>'>Winder Break Monitoring</a></li>
												<li><a href='<spring:url value="/pm5winderbreakmonitoring/managebreakreason"/>'>Winder Break Monitoring - Manage Primary Code</a></li> 
												<li><a href='<spring:url value="/pm5winderbreakmonitoring/managesecondarybreakreason"/>'>Winder Break Monitoring - Manage Secondary Code</a></li>   
												<li><a href='<spring:url value="/pm5customercomplaintreport/view"/>'>Customer Complaint</a></li>
												<li><a href='<spring:url value="/pm5efficiencyreport/byDcs"/>'>Reel Ton - DCS</a></li> --%>
											</ul>
										</li>
										
												
										 <li>
											<h3>CENTERLINE</h3>
											<ul>
												<li><a href='<spring:url value="/pm5centerline/new"/>'>Data Entry</a></li>
												<li><a href='<spring:url value="/pm5centerlinegrade/main"/>'>Grade</a></li>
											</ul>
										</li>
										
										<li>
											<h3>EFFICIENCY</h3>
											<ul>
											
													<li><a href='<spring:url value="/pm5effprimarycode/main"/>'>Manage Primary Code</a></li>
													<li><a href='<spring:url value="/pm5effsecondarycode/main"/>'>Manage Secondary Code</a></li>
												
												<li><a href='<spring:url value="/pm5efficiency/new"/>'>Data Entry </a></li>
											</ul>
										</li>
										<li>
											<h3>PULP AND UTILITY CONSUMPTION</h3>
											<ul>
												<li><a href='<spring:url value="/pm5utilitykpimaster/new"/>'>Data Entry </a></li>
											</ul>
										</li>
										
										<li>
											<h3>Daily Logs</h3>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>Add Master/ Area</a></li>
											</ul>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/page"/>'>Daily Shift Logs Data Entry</a></li>
											</ul>
										</li>
										
									</ol>
									<br>
									
								
									<!-- PM5 Module Ends Here Done By Roshan Tailor Date :- 21/12/2017 -->
									
									<!-- Operator2 -->
									
									
								
									<h3 style="text-decoration: underline; font-size: 14px;">FRP</h3>
									
									<ol>
										<li>
											<h3>PRODUCTION</h3>
											<!--Code Starts From Here Done By Roshan Tailor -->
											<ul>
												<li><a href='<spring:url value="/frpproductionopdataentry/new"/>'>Operator Data Entry</a></li>
											</ul>
											
											<!--Code Ends Here Done By Roshan Tailor -->
											<%-- <ul>
												<li><a href='<spring:url value="/frpproduction/new"/>'>Data Entry </a></li>
											</ul> --%>
										</li>
										<li>
											<h3>EFFICIENCY</h3>
											<ul>
												
													<li><a href='<spring:url value="/frpeffprimarycode/main"/>'>Manage Primary Code</a></li>
													<li><a href='<spring:url value="/frpeffsecondarycode/main"/>'>Manage Secondary Code</a></li>
												
												<li><a href='<spring:url value="/frpefficiency/new"/>'>Data Entry </a></li>
											</ul>
										</li>
										<li>
											<h3>Press Quality Data</h3>
											<ul>
												<li><a href='<spring:url value="/frppressquality/new"/>'>Data Entry </a></li>
											</ul>
										</li>
<!-- 									Code Starts From Here Done By Roshan Tailor Date :- 04/20/2015 NIght Shift -->
										<li>
											<h3>FRP YIELD DATA</h3>
											<ul>
												<li><a href='<spring:url value="/frpyield/new"/>'>Data Entry </a></li>
											</ul>
										</li>
<!-- 									Code Ends Here Done By Roshan Tailor Date :- 04/20/2015 -->
										<li>
											<h3>FRP Cost Optimization</h3>
											<ul>
												<li><a href='<spring:url value="/frpcostoptimization/view"/>'>Data Entry </a></li>
											</ul>
										</li>
										
										<li>
											<h3>Daily Logs</h3>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>Add Master/ Area</a></li>
											</ul>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/page"/>'>Daily Shift Logs Data Entry</a></li>
											</ul>
										</li>
										
										<li>
											<h3>OBCC</h3>
											
											<ul>
												<li><a href='<spring:url value="/frpobccCommon/view"/>'>OBCC</a></li>
											</ul>
										</li>
									</ol>
									<br>
							
								 
								
								<!-- Operator -->
									
									
								
									<h3 style="text-decoration: underline; font-size: 14px;">PM</h3>
									
									<ol>
										<li>
											<h3>Mill Calendar</h3>
											<ul>
												<li><a href='<spring:url value="/staticdata/view"/>'>Upload </a></li>
											</ul>
										</li>
										<li>
											<h3>Safety Log</h3>
											<ul>
												<li><a href='<spring:url value="/safetylogreport/view"/>'>Data Entry </a></li>
											</ul>
										</li>
										<li>
											<h3>SAFETY AND HOUSEKEEPING</h3>
											<ul>
												<li><a href='<spring:url value="/safetyhousekeeping/main"/>'>Safety Housekeeping</a></li>
												<li><a href='<spring:url value="/safetyhousekeeping/view/standard"/>'>Safety Housekeeping-Standard</a></li>
												<li><a href='<spring:url value="/safetyhousekeeping/positiveObservations"/>'>Positive Observations</a></li>
												<c:choose>
													<c:when test="${empty housekeepingscheduleurl}">
														<li><a href='<spring:url value="/safetyhousekeeping/schedule"/>'>Safety Housekeeping-Schedule</a></li>
													</c:when>
													<c:otherwise>
														<li><a href='${housekeepingscheduleurl}'>Safety Housekeeping-Schedule</a></li>
														
													</c:otherwise>
												</c:choose>
												
													<li><a href='<spring:url value="/auditor/manage"/>'>Manage-Auditor</a></li>
													<li><a href='<spring:url value="/area/manage"/>'>Manage-Area</a></li>
													
													<li><a href='<spring:url value="/incidentaluser/manage"/>'>Manage-Incidental Auditor</a></li>
													<li><a href='<spring:url value="/incidentaluser/upload/documents"/>'>Upload-Incidental Document(s)</a></li>
													
													
												 <%-- <li><a href='<spring:url value="/area/auditdoneornot"/>'>Audit Done Or Not</a></li> --%>
												
											</ul>
										</li>
										<li>
											<h3>Process Improvement Notes</h3>
											<ul>
												<li><a href='<spring:url value="/oimnotes/main"/>'>Data Entry </a></li>
												<li><a href='<spring:url value="/oimnotes/category"/>'>Category </a></li>
												<li><a href='<spring:url value="/pmsummarydata/main"/>'>Daily Summary-Data Entry </a></li>
											</ul>
											
										</li>
										
										<%-- <security:authorize access="hasAnyRole('OPERATOR4')">
										<li>
											<h3>Daily Logs</h3>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>Add Master/ Area</a></li>
											</ul>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/page"/>'>Daily Shift Logs Data Entry</a></li>
											</ul>
										</li>
										</security:authorize> --%>
										
									</ol>
								
								
								
								
								
								<!--
								<h3 style="text-decoration: underline; font-size: 14px;">Converting Line 171</h3>
								<ol>
									<li>
											<h3>Customer Projections</h3>
											<ul>
												<li><a href='<spring:url value="/skuspecification/view"/>'>Create Customer / Product Code</a></li>
												<li><a href='<spring:url value="/convertingline/skuspecificationdataentry/view"/>'>Data Entry</a></li>
											</ul>
										</li>
										<li>
											<h3>QUALITY DATA</h3>
											<ul>
												<li><a href='<spring:url value="/convertinglinecustomerrolltesting/view"/>'>Customer Roll Testing</a></li>
												<%-- <li><a href='<spring:url value="/convertinglinefinishproducttesting/add"/>'>Finish Product Testing</a></li> --%>
												<li><a href='<spring:url value="/clrewinder/view"/>'>Converting Line Efficiency</a></li>
												<li><a href='<spring:url value="/clrewinder/managebreakreason"/>'>Converting Line Efficiency - Manage Primary Code</a></li> 
												<li><a href='<spring:url value="/clrewinder/managesecondarybreakreason"/>'>Converting Line Efficiency - Manage Secondary Code</a></li>
												<li><a href='<spring:url value="/convertinglinecustomerrolltesting/productspecificationsignoffsheet"/>'>Converting Line - Product Specification Sign Off Sheet</a></li>
												
											</ul>
										</li>
										<li>
											<h3>Maintenance Log </h3>
											<ul>
												<li><a href='<spring:url value="/manintenanceMonitoringArea/view"/>'>Area Master</a></li>
												<li><a href='<spring:url value="/manintenanceMonitoring/view"/>'>Create / View / Edit</a></li>
												
											</ul>
									 </li>
									 
										<li>
											<h3>Daily Logs</h3>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/addmasterorarea"/>'>Add Master/ Area</a></li>
											</ul>
											<ul>
												<li><a href='<spring:url value="/manintenancelog/page"/>'>Daily Shift Logs Data Entry</a></li>
											</ul>
										</li>
										
										<li>
											<h3>OBcc</h3>
											<ul>
												<li><a href='<spring:url value="/convertinglineOBCC/convertingObccView"/>'>OBCC</a></li>
											</ul>
											
										</li>
										-->	
								</ol>
								
								  
								</td>
								
								
						
								   
								<td width="50%" style="height: 200px; vertical-align: top;">
								
							
									<ol>
									<li><h3><strong>Safety</strong></h3>
										<ul>
											<li><a href='<spring:url value="/911EmergencyReport/view"/>'>911 Report Review</a></li>
										</ul>
									</li>
										<li><h3>PM6 Production</h3>
											<ul>
												<li><a href='<spring:url value="/reelreport/"/>'>Reel Testing </a></li>
												<li><a href='<spring:url value="/rewindreport/"/>'>Rewinder Testing </a></li>
												<li><a href='<spring:url value="/reelreport/scacoating/"/>'>SCA Coating Report </a></li>
												<li><a href='<spring:url value="/qulitycheck_pm6/qualityChecklist/report"/>'>Quality Checklist R1-R2</a></li>
												
												<li><a href='<spring:url value="/OBCCReport/view"/>'>OBCC Report </a></li>
												<li><a href='<spring:url value="/OBCCReport/viewDownload"/>'>OBCC Report Downloaded Percenatge </a></li>
												<li><a href='<spring:url value="/winderbreakmonitoring/report"/>'>Winder Break Monitoring - Report</a></li>
												<li><a href='<spring:url value="/customercomplaintreport/reportview"/>'>Customer Complaint Report</a></li>
												<li><a href='<spring:url value="/qualitygraph/main"/>'>Quality Graph(Reel/Rewinder Testing) </a></li>
												
												<li><a href='<spring:url value="/centerlinereport/view"/>'>Centerline Data</a></li>
												<li><a href='<spring:url value="/centerlinereport/view2"/>'>Centerline Data 2</a></li>
												<li><a href='<spring:url value="/efficiencyreport/main"/>'>Efficiency </a></li>
												<li><a href='<spring:url value="/efficiencyreport/summary"/>'>Efficiency Summary</a></li>
												<!--Code Starts From Here Done By Roshan Tailor Date:- 09-01-2015 MM-DD-YYYY  -->
												<li><a href='<spring:url value="/efficiencyreport/byShift"/>'>Efficiency Summary By Shift</a></li>
												<li><a href='<spring:url value="/efficiencyreport/byDcs/report"/>'>Efficiency Summary By Shift - DCS</a></li>
												<!--Code Ends Here Done By Roshan Tailor Date:- 09-01-2015  -->
												<li><a href='<spring:url value="/utilitykpimasterreport/view"/>'>KPI, Master and  Utility</a></li>
												<li><a href='<spring:url value="/wrapperredcodereport/view"/>'>Wrapper Red/Reject Tons Summary</a></li>
												<li><a href='<spring:url value="/certificateanalysis/main"/>'>Certificate</a></li>
												<li><a href='<spring:url value="/certificateanalysis/mainNew"/>'>Certificate With Roll</a></li>
												<%-- <li><a href='<spring:url value="/chemicalinvreport/main"/>'>Chemical</a></li> --%>
												<li><a href='<spring:url value="/chemicalinvreport/view/detail"/>'>Chemical-Report</a></li>
												
												<li><a href='<spring:url value="/manintenancelog/reportpage"/>'>Daily Shift Log Report</a></li>
												<li><a href='<spring:url value="/dailydashboard/view"/>'>STT DAILY DASHBOARD</a></li>
											</ul>
										</li>
										<li><h3>PM5 Production</h3>
											<ul>
												<li><a href='<spring:url value="/pm5reelreport/"/>'>Reel Testing </a></li>
												<li><a href='<spring:url value="/pm5rewindreport/"/>'>Rewinder Testing </a></li>
												<li><a href='<spring:url value="/pm5centerlinereport/view"/>'>Centerline Data</a></li>
												<li><a href='<spring:url value="/pm5centerlinereport/view2"/>'>Centerline Data 2</a></li>
												<li><a href='<spring:url value="/qulitycheck_pm5/qualityChecklist/report"/>'>Quality Checklist R1-R2</a></li>
												<li><a href='<spring:url value="/OBCCPM5Report/view"/>'>OBCC Report </a></li>
												<li><a href='<spring:url value="/OBCCPM5Report/viewDownload"/>'>OBCC Report Downloaded Percenatge </a></li>
												<li><a href='<spring:url value="/pm5efficiencyreport/main"/>'>Efficiency </a></li>
												<li><a href='<spring:url value="/pm5efficiencyreport/summary"/>'>Efficiency Summary</a></li>
												<li><a href='<spring:url value="/pm5efficiencyreport/byShift"/>'>Efficiency Summary By Shift</a></li>
												<li><a href='<spring:url value="/pm5efficiencyreport/byDcs/report"/>'>Efficiency Summary By Shift - DCS</a></li>
												<li><a href='<spring:url value="/pm5utilitykpimasterreport/view"/>'>KPI, Master and  Utility</a></li>
												<li><a href='<spring:url value="/manintenancelog/reportpage"/>'>Daily Shift Log Report</a></li>
												<li><a href='<spring:url value="/certificateanalysis/mainNewPm5"/>'>Certificate With Roll</a></li>
											</ul>
										</li>
										<li>
											<h3>FRP Production</h3>
											<ul>
												<li><a href='<spring:url value="/frpproductionreport/view"/>'>Production Data </a></li>
												<!-- Code Starts From Here Done By Roshan Tailor -->
												<li><a href='<spring:url value="/frpproductionopdataentry/view/report"/>'>Operator Data Entry Report</a></li>
												<li><a href='<spring:url value="/wetlapinventory/view"/>'>Wetlap Inventory Available Summary</a></li>
												<!-- Code Ends Here Done By Roshan Tailor -->
												<li><a href='<spring:url value="/frpefficiencyreport/main"/>'>Efficiency </a></li>
												<li><a href='<spring:url value="/frpefficiencyreport/summary"/>'>Efficiency Summary</a></li>
												<li><a href='<spring:url value="/frppressqualityreport/view"/>'>Press Quality Data</a></li>
												<li>	
													<c:choose>
														<c:when test="${empty fprprojectionurl}">
															<a href='<spring:url value="/frpprojectionreport/view"/>'>Projection </a>
														</c:when>
														<c:otherwise>
															<a href="${fprprojectionurl}">FRP Projection </a>
														</c:otherwise>
													</c:choose>
												 </li>
												
													 <li>	
														<c:choose>
															<c:when test="${empty fprprojectionjonurl}">
																<a href='<spring:url value="/frpprojectionreportjon/view/john"/>'>Projection_Joan </a>
															</c:when>
															<c:otherwise>
																<a href="${fprprojectionjonurl}">FRP Projection_Joan </a>
															</c:otherwise>
														</c:choose>
													 </li>
												
												 <!-- Code For Fiber Purchsing Brown -->
												 <li>
													<c:choose>
															<c:when test="${empty fiberpurchasingurl}">
																<a href='<spring:url value="/fiberpurchasingreport/view"/>'>Fiber Purchasing-Brown </a>
															</c:when>
															<c:otherwise>
																<a href="${fiberpurchasingurl}">Fiber Purchasing-Brown</a>
															</c:otherwise>
													</c:choose>
												</li>
												<!-- Code For Fiber Purchsing White -->
												<li>
													<c:choose>
															<c:when test="${empty fiberpurchasingurl_white}">
																<a href='<spring:url value="/fiberpurchasingreport/view/white"/>'>Fiber Purchasing-White</a>
															</c:when>
															<c:otherwise>
																<a href="${fiberpurchasingurl_white}">Fiber Purchasing-White</a>
															</c:otherwise>
													</c:choose>
												</li>
												
												 <li><a href='<spring:url value="/frpprojectionmix/view"/>'>Mix Graph</a></li>
												 <li><a href='<spring:url value="/frpdailyreport/view"/>'>FRP Daily Report</a></li>
												 <li><a href='<spring:url value="/frpmonthlyreport/view"/>'>FRP IP Monthly Report</a></li>
												 <li><a href='<spring:url value="/fiberbalancereport/view"/>'>Fiber Balance Report</a></li>
												 <!--Code Starts From Here Done By Roshan Tailor Date:- 04/23/2015 Night Shift-->
												 <li><a href='<spring:url value="/frpdailyyieldreport/view"/>'>FRP Daily Yield Report</a></li>
												 <li><a href='<spring:url value="/frpdailyyieldsummary/view"/>'>FRP Daily Yield Summary</a></li>
												 <li><a href='<spring:url value="/frpcostoptimization/report"/>'>FRP Cost Optimization Report</a></li>
												 <li><a href='<spring:url value="/downtimeandlosttime/report"/>'>Down Time & Lost Time Report</a></li>
												 <li><a href='<spring:url value="/manintenancelog/reportpage"/>'>Daily Shift Log Report</a></li>
												 <!--Code Ends Here Done By Roshan Tailor date :-04/23/2015 Night Shift -->
												  <!--Code Start From Here By Sohan  -->
												 <li><a href='<spring:url value="/frpobccReport/view"/>'>OBCC_Report</a></li>
												 <li><a href='<spring:url value="/frpobccReport/ViewDownload"/>'>OBCC_Report Downloaded Percenatge</a></li>
												 
												  <!--Code End Here By Sohan  -->
											</ul>
										</li>
										<li>
											<h3>PM6 Production</h3>
											<ul>
												<li><a href='<spring:url value="/productionreport/view"/>'>Daily Report</a></li>
												<!-- Code Starts From Here Done By Roshan TAilor Date :- 2017-01-03 -->
												<li><a href='<spring:url value="/productionreport/view/non-controlablehours"/>'>Daily Report With Non Controlable Hours</a></li>
												<!-- Code Ends Here Done By Roshan Tailor Date ;- 2017-01-03 -->
												<li><a href='<spring:url value="/productionwarpreport/view"/>'>PM6 Tissue Wrapped Tons</a></li>
												<li><a href='<spring:url value="/productionreport/viewsummary"/>'>PM6 Production Summary </a></li>
												<!-- Code Starts From Here Done By Roshan Tailor For Break Free % Date:- 08/29/2016 -->
												<li><a href='<spring:url value="/productionreport/breakfreeproducation"/>'>Break Free Production Report</a></li>
												<!-- Code Ends Here Done By Roshan Tailor For Break Free % Date:- 08/29/2016 -->
												<li><a href='<spring:url value="/productionwarpreport/gradenhours"/>'>Grade And Hours Report </a></li>
												<li><a href='<spring:url value="/productionwarpreport/gradenhoursWithSummary"/>'>Grade And Hours Summary Report </a></li>
												
												<li><a href='<spring:url value="/productionreport/gradenhours"/>'>Grade And Hours Report (Machine)</a></li>
												<li><a href='<spring:url value="/productionwarpreport/inventorysummary"/>'>Inventory Daily Summary </a></li>
												<%-- <li><a href='<spring:url value="/inventoryfloorreport/main"/>'>Current Inventory</a></li> --%>
												
												<li><a href='<spring:url value="/productionwarpreport/wrapperAverage"/>'>Wrapper Average Report</a></li>
												<li><a href='<spring:url value="/wrapperVsMachineReport/view"/>'>Machine Vs Wrapper Report</a></li>
												<!--Code Starts From Here Done By Roshan Tailor Dane:-05-23-2016 -->
												<li><a href='<spring:url value="/wrapperVsMachineSummaryReport/view"/>'>Machine Vs Wrapper Summary Report</a></li>
												<!--Code Ends Here Done By Roshan Tailor Date :- 05-23-2016-->
												<li><a href='<spring:url value="/productionwarpreport/dataByDate"/>'>Wrapper Data By Date</a></li>
											</ul>
										</li>
										
										<li>
											<h3>PM5 Production</h3>
											<ul>
												<li><a href='<spring:url value="/pm5productionreport/view"/>'>Daily Report</a></li>
												<li><a href='<spring:url value="/pm5productionwarpreport/view"/>'>PM5 Tissue Wrapped Tons</a></li>
												<li><a href='<spring:url value="/pm5productionreport/viewsummary"/>'>PM5 Production Summary </a></li>
												<li><a href='<spring:url value="/pm5productionwarpreport/gradenhours"/>'>Grade And Hours Report </a></li>
												<li><a href='<spring:url value="/pm5productionwarpreport/gradenhoursWithSummary"/>'>Grade And Hours Summary Report </a></li>
											</ul>
										</li>
										
										<li>
											<h3>PM Reports</h3>
											<ul>
												<li><a href='<spring:url value="/safetylogreport/view"/>'>Safety Log - View </a></li>
												<li><a href='<spring:url value="/safetylogreport/view2"/>'>Safety Log - Reviews </a></li>
												<li><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Safety Housekeeping </a></li>
												<li><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Safety Housekeeping - Open Actions </a></li>
												<li><a href='<spring:url value="/safetyhousekeepingreport/closeditems"/>'>Safety Housekeeping - Closed Actions </a></li>
												<li><a href='<spring:url value="/oimnotesreport/main"/>'>Process Improvement Notes </a></li>
												<li><a href='<spring:url value="/oimnotesreport/load/openfollowups"/>'>Process Improvement Notes - Open Follow-up </a></li>
												<li><a href='<spring:url value="/pmsummarydatareport/main"/>'>Daily Summary - Report</a></li>
												<li><a href='<spring:url value="/incidentaluser/report/show"/>'>Review-Incidental Document(s)</a></li>
												<li><a href='<spring:url value="/incidentaluser/report/reviewedactions"/>'>Incidental Document(s) Reviewed Actions</a></li>
											</ul>
										</li>
										<!-- Code Starts From Here Done By Roshan Tailor Date :-07/07/2015 MM/DD/YYYY Night Shift-->
										<li>
											<h3>Bale Inventory and Waste Paper</h3>
											<ul>
												<li><a href='<spring:url value="/baleinventoryunload/unloadbales"/>'>Barcode - Unload Bales</a></li>
												<li><a href='<spring:url value="/baleinventoryconsumed/consumedbales"/>'>Barcode - Consumed Bales</a></li>
												<li><a href='<spring:url value="/baleinventoryreportdetail/detail"/>'>Barcode - Inventory Report Detail</a></li>
												<li><a href='<spring:url value="/baleinventoryreport/report"/>'>Barcode - Inventory Report</a></li>
												<li><a href='<spring:url value="/wastepaperreport/view"/>'>Wastepaper - Detail Report</a></li>
												<li><a href='<spring:url value="/wastepaperreportbyvandor/view"/>'>Wastepaper - By Vendor</li>
												<li><a href='<spring:url value="/wastepaperreportbygrade/view"/>'>Wastepaper - By Grade</li>
												<li><a href='<spring:url value="/wastepaperreportbyvendorandgrade/view"/>'>Wastepaper - By Grade And Vendor</li>
												<li><a href='<spring:url value="/wastepaperreceivingreport/view"/>'>Wastepaper - Receiving Report</li>
												<li><a href='<spring:url value="/wastepaperreceivingreportbyprice/view"/>'>Wastepaper - Receiving Report By Price</li>
												<li><a href='<spring:url value="/wastepaperunloadbyshiftreport/view"/>'>Wastepaper - Unload By Shift</a></li>
												<li><a href='<spring:url value="/wastepaperinboundbydelivery/view"/>'>Wastepaper - Inbound By Delivery Data</a></li>
												<li><a href='<spring:url value="/wastepapertrucksunload/view"/>'>Waste Paper - Trucks Unload Details</a></li>
												<li><a href='<spring:url value="/transferpricepertondata/view"/>'>Wastepaper - Transfer Price Per Ton Data</a></li>
												<li><a href='<spring:url value="/despatch/view"/>'>Wastepaper - Despatch Report</a></li>
												<li><a href='<spring:url value="/wastepapermillyieldreport/entermilldata"/>'>Wastepaper - Enter Mill Yield Data</a></li>
												<li><a href='<spring:url value="/wastepapermillyieldreport/view"/>'>Wastepaper - Mill Yield Report</a></li>
												<li><a href='<spring:url value="/dailyinventryreport/view"/>'>Daily Inventory Report</a></li>
											</ul>
										</li>
										<!-- Code Ends Here Done By Roshan Tailor Date :- 07/07/2015 MM/DD/YYYY Night Shift -->
									
							
							
									<ol>
								<!---
										<li><h3>Converting Line 171 Reporting</h3>
											<ul>
												<li><a href='<spring:url value="/convertinglinecustomerrolltesting/"/>'>Customer Roll Testing</a></li>
												<%-- <li><a href='<spring:url value="/convertinglinefinishproducttesting/"/>'>Finish Product Testing</a></li> --%>
												<li><a href='<spring:url value="/convertinglinereport/customerwise/view"/>'>Converting Line 171 Reporting - Projection By Customer Wise</a></li>
												<li><a href='<spring:url value="/convertinglinereport/skucodewise/view"/>'>Converting Line 171 Reporting - Projection By SKU Code</a></li>
												<%-- <li><a href='<spring:url value="/convertinglinereport/shiptodatereportbyskucodewise/view"/>'>Converting Line 171 Reporting - Ship To Date Report By SKU Code</a></li> --%>
												<li><a href='<spring:url value="/convertinglinereport/monthlyreport/view"/>'>Converting Line 171 Reporting - Monthly Report</a></li>
												<li><a href='<spring:url value="/convertinglinereport/viewsummary/"/>'>Converting Line 171 - Production Summary Report</a></li>
												<li><a href='<spring:url value="/convertinglinereport/viewsummary/withtime"/>'>Converting Line 171 - Production Summary Report With Time</a></li>
												<li><a href='<spring:url value="/convertinglinereport/viewdetailed/report/"/>'>Converting Line 171 - Production Detailed Report</a></li>
												<li><a href='<spring:url value="/convertinglinereport/dailyefficiencyreport/"/>'>Converting Line 171 - Daily Efficiency Detailed Report</a></li>
												<li><a href='<spring:url value="/convertinglinereport/dailyefficiencyreport/summary/"/>'>Converting Line 171 - Daily Efficiency Summary Report</a></li>
												<li><a href='<spring:url value="/convertinglinereport/productspecificationsignoffsheet/report/"/>'>Converting Line 171 - Product Specification Sign Off Sheet Report</a></li>
												<li><a href='<spring:url value="/convertinglinereport/efficiencysummary/report/"/>'>Converting Line 171 - Efficiency Summary Report</a></li>
												<li><a href='<spring:url value="/manintenanceMonitoring/MaintenanceMonitoring/report/view/"/>'>Converting Line 171 - Maintenance Log Report</a></li>
												
												<li><a href='<spring:url value="/manintenancelog/reportpage"/>'>Daily Shift Log Report</a></li>
												<li><a href='<spring:url value="/convertinglineOBCC/convertingObccReportView"/>'>OBCCReport</a></li>
												 <li><a href='<spring:url value="/convertinglineOBCC/convertingObccDownloadReportView"/>'>OBCC_Report Downloaded Percenatge</a></li>
												
											</ul>
										</li>
										--->
									</ol>
							
											
								</td>
							</tr>
						</tbody>
					</table>

					<br>


				</div>

			</div>

		</div>


	</div>

</body>
</html>
