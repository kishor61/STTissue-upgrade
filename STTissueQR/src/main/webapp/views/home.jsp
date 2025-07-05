<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Home</title>
<jsp:include page="common.jsp"></jsp:include>
<style type="text/css">
.home-menu .label {
	font-size: 12px;
	font-weight: bold;
}

.home-menu ol {
	text-transform: uppercase;
}

.home-menu ol .outer-li {
	margin-bottom: 20px;
	color: #996633;
}

.home-menu ol .outer-li div {
	margin-bottom: 5px;
}

.home-menu ul a {
	text-decoration: none;
	color: #B37B06;
	text-transform: capitalize;
	font-size: 14px;
}

.home-menu ul a:HOVER {
	text-decoration: underline;
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

				<div class="page-title">
					<span class="label">Main Menu</span>
				</div>
				<br>
				
					<a href='<spring:url value="/home/new"></spring:url>' style="color: rgb(67, 150, 50);font-weight: bold;text-transform: uppercase;">New Home</a>
				<br>
				<br>
				<div class="home-menu">
					<ol>
						<security:authorize access="hasRole('ADMIN')">
							<li class="outer-li">
								<div>
									<span class="label">Grade - (ST Tissue Internal
										Specification)</span>
								</div>
								<ul>
									<li><a href='<spring:url value="/grade/main"/>'>Create / View / Edit</a></li>
								</ul>
							</li>
						</security:authorize>
						
				<!-- Operator 1 -->		
						
				<security:authorize access="hasAnyRole('ADMIN,OPERATOR')">
						
						<li class="outer-li">
							<div>
								<span class="label">Quality Data Entry</span>
							</div>
							<ul>
								<li>
									<c:choose>
										<c:when test="${empty reelentryurl}">
											<a href='<spring:url value="/reel/add"/>'>Reel Testing</a>
										</c:when>
										<c:otherwise>
											<a href='${reelentryurl}'>Reel Testing</a>
										</c:otherwise>
									</c:choose>
								</li>

								<li>
								<c:choose>
										<c:when test="${empty rewindentryurl}">
											<a href='<spring:url value="/rewind/add"/>'>Rewinder
												Testing</a>
										</c:when>
										<c:otherwise>
											<a href='${rewindentryurl}'>Rewinder Testing</a>
										</c:otherwise>
								</c:choose>
								</li>
							</ul>
						</li>
						<li class="outer-li">
							<div>
								<span class="label">Quality Report</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/reelreport/"/>'>Reel Testing</a></li>
								<li><a href='<spring:url value="/rewindreport/"/>'>Rewinder	Testing</a></li>
							</ul>
						</li>
						
						<li class="outer-li">
							<div>
								<span class="label">Centerline Data</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/centerline/new"/>'>Centerline 	Data Entry</a></li>
								<li><a href='<spring:url value="/centerlinereport/view"/>'>Centerline Data-Report</a></li>
										
										<security:authorize access="hasRole('ADMIN')">
										<li><a href='<spring:url value="/centerlinegrade/main"/>'>Centerline Grade</a></li>
										</security:authorize>
							</ul>
						</li>
						<li class="outer-li">
							<div>
								<span class="label">Efficiency</span>
							</div>
							<ul>
								<security:authorize access="hasRole('ADMIN')">
									<li><a href='<spring:url value="/effprimarycode/main"/>'>Manage Primary Code</a></li>
									<li><a href='<spring:url value="/effsecondarycode/main"/>'>Manage Secondary Code</a></li>
								</security:authorize>
								
								<li><a href='<spring:url value="/efficiency/new"/>'>Efficiency-Data Entry </a></li>
								<li><a href='<spring:url value="/efficiencyreport/main"/>'>Efficiency-Report </a></li>
								
							</ul>
						</li>
						
						<li class="outer-li">
							<div>
								<span class="label">PULP AND UTILITY CONSUMPTION REPORT</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/utilitykpimaster/new"/>'>Data Entry </a></li>
								<li><a href='<spring:url value="/utilitykpimasterreport/view"/>'>Report</a></li>
								
							</ul>
						</li>
					</security:authorize>
					
					
			<!-- Operator 2 -->	
					<security:authorize access="hasAnyRole('ADMIN,OPERATOR2')">
						<li class="outer-li">
							<div>
								<span class="label">FRP Production</span>
							</div>
							<ul>
								<li>
									<a href='<spring:url value="/frpproduction/new"/>'>Data Entry </a>
								</li>
								<li><a href='<spring:url value="/frpproduction/view"/>'>Report </a></li>
								
							</ul>
						</li>	
						<li class="outer-li">
							<div>
								<span class="label">FRP-Efficiency</span>
							</div>
							<ul>
								<security:authorize access="hasRole('ADMIN')">
									<li><a href='<spring:url value="/frpeffprimarycode/main"/>'>Manage Primary Code</a></li>
									<li><a href='<spring:url value="/frpeffsecondarycode/main"/>'>Manage Secondary Code</a></li>
								</security:authorize>
								
								<li><a href='<spring:url value="/frpefficiency/new"/>'>Data Entry </a></li>
								<li><a href='<spring:url value="/frpefficiencyreport/main"/>'>Report </a></li>
								
							</ul>
						</li>
						<li class="outer-li">
							<div>
								<span class="label">FRP-Press Quality Data</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/frppressquality/new"/>'>Data Entry </a></li>
								<li><a href='<spring:url value="/frppressqualityreport/view"/>'>Report </a></li>
								
							</ul>
						</li>
						<security:authorize access="hasRole('OPERATOR2')">
							<li class="outer-li">
								<div>
									<span class="label">PM6 Quality Report</span>
								</div>
								<ul>
									<li><a href='<spring:url value="/reelreport/"/>'>Reel
											Testing Report</a></li>
									<li><a href='<spring:url value="/rewindreport/"/>'>Rewinder
											Testing Report</a></li>
								</ul>
							</li>
						</security:authorize>
						
					</security:authorize>	
					
					<security:authorize access="hasAnyRole('ADMIN,OPERATOR3')">
						<li class="outer-li">
							<div>
								<span class="label">PM6 Production and Waste Paper</span>
							</div>
							<ul>
								<security:authorize access="hasRole('ADMIN')">
									<li><a href='<spring:url value="/prodmain"/>'> View Reports</a></li>
								</security:authorize>
								<security:authorize access="hasRole('OPERATOR3')">
									<spring:url value="home/new" var="prodMainURL"/>
									<c:redirect url="${prodMainURL}"/>
								</security:authorize>
								<%-- <li><a href='<spring:url value="/productionreport/view"/>'>Report</a></li> --%>
							</ul>
						</li>
					</security:authorize>
					
					
					<security:authorize access="hasAnyRole('OPERATOR4')">
						<li class="outer-li">
							<div>
								<span class="label">Safety Log</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/safetylogreport/view"/>'>Safety Log - View </a></li>
								<li><a href='<spring:url value="/safetylogreport/view2"/>'>Safety Log - Reviews </a></li>
							
								
							</ul>
						</li>
						<li class="outer-li">
							<div>
								<span class="label">Safety Housekeeping</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/safetyhousekeeping/main"/>'>Safety Housekeeping</a></li>
								<li><a href='<spring:url value="/safetyhousekeeping/view/standard"/>'>Safety Housekeeping-Standard</a></li>
								
								
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
								<li><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Reports </a></li>
								<li><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Reports - Open Actions </a></li>
							</ul>
						</li>
						<li class="outer-li">
							<div>
								<span class="label">Process Improvement Notes</span>
							</div>
							<ul>
								<li><a href='<spring:url value="/oimnotes/main"/>'>Data Entry </a></li>
								<li><a href='<spring:url value="/oimnotes/category"/>'>Category </a></li>
								<li><a href='<spring:url value="/oimnotesreport/main"/>'>Reports </a></li>
								<li><a href='<spring:url value="/oimnotesreport/load/openfollowups"/>'>Reports - Open Follow-up </a></li>
								
							</ul>
						</li>
						
					</security:authorize>
					
					</ol>

				</div>

			</div>

		</div>


	</div>

</body>
</html>
