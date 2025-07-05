<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepapertrucksunload/viewreport" var="viewreport"></spring:url>
<spring:url value="/wastepapertrucksunload/export" var="exportreport"></spring:url>
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
					<span class="label">Waste Paper - Trucks Unload Detail Report</span>
					<div class="table-selector" id="table-selector">
					<table style="margin: auto;">
						<tr>
							<form action="${viewreport}" method="get">
								<td>Start Date: <input type="text" name="sdate" value="${sdate}" style="width: 80px;"></td>
								<td>End Date: <input type="text" name="edate" value="${edate}" style="width: 80px;"></td>
								<td><button id="showbutton" type="submit">Show</button></td>
							</form>
							<c:if test="${viewpage}">
								<form action="${exportreport}" method="POST">
									<td><input type="hidden" value="${sdate}" name="sdate"></td>
									<td><input type="hidden" value="${edate}" name="edate"></td>
									<td><button id="exportbutton">Export</button></td>
								</form>
							</c:if>
						</tr>
					</table>
				</div>
				</div>
	<c:if test="${viewpage}">
			<c:if test="${fn:length(unloadtrucksdata) eq 0}">
  			 	<p>Sorry No Data Found</p>
			</c:if>
	
<c:if test="${fn:length(unloadtrucksdata) gt 0}">
<center>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<%-- <table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 40px;">Unload Date</td>
			<td style="width: 40px;">Total Unload Truck(s)</td>
			<td style="width: 40px;">Unload Time</td>
			<td style="width: 40px;">Release Number</td>
			<td style="width: 40px;">Trailer Number</td>
			<td style="width: 40px;">Grade Code</td>
			<td style="width: 40px;">Bales</td>
			<td style="width: 40px;">Weight<br>(LBS)</td>
			<td style="width: 40px;">Weight<br>(TON)</td>
			<td style="width: 40px;">Vendor</td>
			<td style="width: 40px;">Vendor Number</td>
			<td style="width: 50px;">Unload Comment</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${unloadtrucksdata}" var="utd">
			<tr>
					<td><center><fmt:formatDate value="${utd.unloaddate}" pattern="MM/dd/yyyy"/></center></td>
					<td><center>${utd.truckcount}</center></td>
					<c:set var="now" value="${utd.unloaddatetime}" />
					<td><center><fmt:formatDate  type="time" value="${now}"/></center></td>
					<td><center>${utd.release}</center></td>
					<td><center>${utd.trailer}</center></td>
					<td><center>${utd.grade}</center></td>
					<td><center>${utd.bales}</center></td>
					<td><center>${utd.weight}</center></td>
					<td><center><fmt:formatNumber value="${utd.weight/2000}" var="ton"/>${ton}</center></td>
					<td><center>${utd.vandor}</center></td>
					<td><center>${utd.vandornumber}</center></td>
					<td><center>${utd.unloadcomment}</center></td>
					<c:set value="${totalbales+utd.bales}" var="totalbales"/>
					<c:set value="${totalbalesweight+utd.weight}" var="totalbalesweight"/>	
					<c:set value="${totaltruck+utd.truckcount}" var="totaltruck"/>	
					<c:set value="${totalton+utd.weight/2000}" var="totalton"/>	
			</tr>
		</c:forEach>
	</tbody>
			<tr>
					<td><center><b>Total:</b></center></td>
					<td><center><b>${totaltruck}</b></center></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><center><b>${totalbales}</b></center></td>
					<td><center><b>${totalbalesweight}</b></center></td>
					<td><center><b><fmt:formatNumber value="${totalton}" var="totaltonR"/>${totaltonR}</center></b></center></td>
					<td></td>
					<td></td>
					<td></td>
			</tr>
</table> --%>
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 40px;">Unload Date</td>
			<td style="width: 40px;">Day Shift</td>
			<td style="width: 40px;">Night Shift</td>
			<td style="width: 40px;">Total Trucks</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${unloadtrucksdata}" var="utd">
			<tr>
					<td><center><fmt:formatDate value="${utd.unloaddate}" pattern="MM/dd/yyyy"/></center></td>
					<td><center>${utd.dayshifttrucks}</center></td>
					<td><center>${utd.nightshifttrucks}</center></td>
					<td><center>${utd.truckcount}</center></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>
</center>
			</c:if>
	</c:if>
			</div>

		</div>


	</div>

</body>
</html>
