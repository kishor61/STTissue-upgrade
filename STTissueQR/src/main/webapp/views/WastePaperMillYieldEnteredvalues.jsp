<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepapermillyieldreport/entermilldata/detailedreport/view" var="viewreport"></spring:url>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Waste Paper Mill Yield Report Data</span>
				</div>
				<div class="table-selector" style="background-color: rgba(142, 131, 24, 0.47);">
				<spring:url value="/wastepapermillyieldreport/view/data" var="viewURL"/>
				<form action="${viewreport}" method="get">
					<table style="margin: auto;">
						<tr>
							<td><b>Start Date:</b></td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td><b>End Date:</b></td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							<td>
									&nbsp;&nbsp;<button id="showbutton" type="submit">Show</button>
							</td>
						</tr>
					</table>
			</form>
				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<center>
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 80px;background-color: rgb(142, 131, 24);"><b>Date</b></td>
			<td style="width: 80px;background-color: #6BB900;"><b>Pulper 3 Input</b></td>
			<td colspan="5"style="width: 80px;background-color: rgb(0, 162, 185);"><b>Pulper 4 Input</b></td>
			<td style="width: 80px;background-color: rgba(0, 17, 197, 0.69);"><b>Mill Yield</b></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Broke</b></td>
			<td><b>ST Bales WetLap</b></td>
			<td><b>CGWD</b></td>
			<td><b>CGWD Section</b></td>
			<td><b>SW</b></td>
			<td><b>White Bland</b></td>
			<td><b>White Blend</b></td>
		</tr>
		<c:forEach items="${data}" var="set">
		<tr>
			<td>${set.date}</td>
			<td>${set.yieldbroke}</td>
			<td>${set.yieldstbaleswetLap}</td>
			<td>${set.yieldcgwd}</td>
			<td>${set.yieldcgwdsection}</td>
			<td>${set.yieldsw}</td>
			<td>${set.yieldwhitebland}</td>
			<td>${set.yieldwhiteblend}</td>
		</tr>
	</c:forEach>
	</thead>
	<tbody>
		
	</tbody>
</table>
</center>
</div>
			</div>

		</div>


	</div>

</body>
</html>
