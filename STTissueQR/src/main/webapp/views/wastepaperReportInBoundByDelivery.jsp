<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<%-- <spring:url value="/wastepaperinboundbydelivery/export" var="exportURL"/> --%>
<spring:url value="/wastepaperinboundbydelivery/view/data" var="viewURL"/>
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


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Waste Paper Report In Bound By Delivery</span>
				</div>
					<div class="table-selector" id="table-selector">
				<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
							</td>
							<c:if test="${view}">
								<td>
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
								</td>
							</c:if>
						</tr>
					</table>
				</form>
							
<form id="exportFrom" action='<spring:url value="/wastepaperinboundbydelivery/export"/>' method="POST" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
				</div>
				<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
				
				
<c:if test="${view}">			
				<center><table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 150px;"><b>Unload Date</b></td>
			<td style="width: 150px;"><b>Total</b></td>
			<td style="width: 150px;"><b>Unload</b></td>
			<td style="width: 150px;"><b>Enroute</b></td>
			<td style="width: 150px;"><b>Reject</b></td>
			<!--<td style="width: 150px;"><b>Deleted</b></td> -->
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${details}" var="wd">
			<tr>
				<td><center><b><fmt:formatDate value="${wd.unloadedDate}" pattern="MM/dd/yyyy"/></b></center></td>
				<td><center>${wd.totalbales}</center></td>
				<td><center>${wd.bales}</center></td>
				<td><center>${wd.enroute}</center></td>
				<td><center>${wd.balesondaterejected}</center></td>
				<%--<td><center>${wd.balesondatedeleted}</center></td> --%>
			</tr>
		</c:forEach>
	</tbody>
</table>
</center>
</c:if>


				</div>

			</div>

		</div>


	</div>

</body>
</html>
