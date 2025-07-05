<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepaperunloadbyshiftreport/report" var="viewdataURL" />
<spring:url value="/wastepaperunloadbyshiftreport/export" var="exportdataURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=startdate],input[name=enddate]').datepicker({
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


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
				<span class="label">Waste Paper - Unload By Shift</span>
				</div>
				<div class="table-selector" style="width: 2431px;">
					<table>
						<tr>
							<form action="${viewdataURL}" method="get">
							<td>Start Date</td>
							<td><input readonly="readonly" type="text" name="startdate" value="${startdate}" style="width: 80px;"></td>
							<td></td>
							<td>End Date</td>
							<td><input readonly="readonly" type="text" name="enddate" value="${enddate}"  style="width: 80px;"></td>
							<td><input type="submit" id="viewbutton" name="viewbutton" value="View"></td>
							</form>
							<c:if test="${viewpage}">
								<form action="${exportdataURL}" method="POST">
										<td><input type="hidden" name="startdate" value="${startdate}" ></td>
										<td><input type="hidden" name="enddate" value="${enddate}"></td>
										<td><button id="exportbutton">Export</button></td>
								</form>
							</c:if>
						</tr>
					</table>
				</div>
	<br>
<c:if test="${fn:length(unloadByShift) > 0 }">
	<table id="barcodedatatable" class="table" style="width: auto;margin: 0px 0px 0px 500px;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 80px;">Unload Date</td>
			<td style="width: 80px;">Day</td>
			<td style="width: 80px;">Day Shift</td>
			<td style="width: 80px;">Night Shift</td>
			<td style="width: 80px;">Grand Total</td>
		</tr>
	</thead>
	<tbody>
 		<c:forEach items="${unloadByShift}" var="ubs"> 
			<tr>
				<td><fmt:formatDate value="${ubs.unloaddate}" pattern="MM/dd/yyyy"/></td>
				<td>${ubs.day}</td>
				<td>${ubs.dayshift}</td>
				<td>${ubs.nightshift}</td>
				<td>${ubs.grandtotal}</td>
			</tr>
 		</c:forEach>
	</tbody>
	<%-- <tr>
				<td><b style="color: Brown;">Grand Total</b></td>
				<td></td>
				<td><b style="color: brown;">${ubs.dayshifttotal}</b></td>
				<td><b style="color: brown;">${ubs.nightshifttotal}</b></td>
				<td><b style="color: brown;">${ubs.finalgrandtotal}</b></td>
	</tr> --%>
</table>
</c:if>
	</div>
		</div>
	</div>

</body>
</html>
