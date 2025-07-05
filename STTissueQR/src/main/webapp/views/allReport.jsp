<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<style type="text/css">
.reporttable{
	margin: 20px  auto auto; 
	border-collapse: collapse;
}
.reporttable fieldset {
	border: 1px solid #996633;
	min-height: 200px;
}
.reporttable fieldset legend {
	text-transform: uppercase;
	color: #996633;
	font-weight: bold;
}
.reporttable fieldset div {
	width: 300px;
	display: block;
}
.reporttable fieldset div ol li{
	color: #996633;
}
.reporttable fieldset div ol li a{
	
	font-family: sans-serif;
	text-decoration: none;
	line-height: 20px;
}
.reporttable fieldset div ol li a:HOVER{
	text-decoration: underline;
}
</style>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3 ui-widget" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Reports</span>
				</div>
				
<table class="reporttable">
	<tr>
		<td>
			<fieldset>
				<legend>PM6 Production</legend>
				<div>
					<ol>
						<li><a href='<spring:url value="/reelreport/"/>'>Reel Testing </a></li>
						<li><a href='<spring:url value="/rewindreport/"/>'>Rewinder Testing </a></li>
						<li><a href='<spring:url value="/centerlinereport/view"/>'>Centerline Data</a></li>
						<li><a href='<spring:url value="/efficiencyreport/main"/>'>Efficiency </a></li>
						<li><a href='<spring:url value="/efficiencyreport/summary"/>'>Efficiency Summary</a></li>
						<li><a href='<spring:url value="/utilitykpimasterreport/view"/>'>KPI, Master and  Utility</a></li>
						<li><a href='<spring:url value="/wrapperredcodereport/view"/>'>Wrapper Red/Reject Tons Summary</a></li>
					</ol>
				</div>
				
			</fieldset>

		</td>
		<td>
			<fieldset>
				<legend>FRP Production</legend>
				<div>
					<ol>
						<li><a href='<spring:url value="/frpproduction/view"/>'>Production Data </a></li>
						<li><a href='<spring:url value="/frpefficiencyreport/main"/>'>Efficiency </a></li>
						<li><a href='<spring:url value="/frpefficiencyreport/summary"/>'>Efficiency Summary</a></li>
						<li><a href='<spring:url value="/frppressqualityreport/view"/>'>Press Quality Data</a></li>
						
					</ol>
				</div>
			</fieldset>
		</td>
	
	</tr>		
</table>

			</div>

		</div>


	</div>

</body>
</html>
