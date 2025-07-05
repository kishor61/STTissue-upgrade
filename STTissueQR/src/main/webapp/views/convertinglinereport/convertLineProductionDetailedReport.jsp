<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
<style type="text/css">
table td{
    text-align: center;
}
</style>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Converting Line 171 - Production Detailed Report</span>
				</div>
				<div class="table-selector">
					
					<spring:url value="/convertinglinereport/viewdetailed/report/show" var="viewURL"/>
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
							<td>Shift</td>
							<td>
								<c:set value="${fn:split('Day,Night',',')}" var="shifts"/>	
								<select name="shift" style="width: 80px;">
									<option value="All">All</option>
									<c:forEach items="${shifts}" var="sh">
										<c:choose>
											<c:when test="${sh eq shift }">
												<option value="${sh}" selected="selected">${sh}</option>
											</c:when>
											<c:otherwise>
												<option value="${sh}">${sh}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>						
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
							</td>
						</tr>
					</table>
				</form>

				</div>

<div style="position: absolute;bottom: 0;width: 98%;top: 103px;overflow: auto;">
<c:if test="${viewFlag}">
	
	<div id="printDiv">
<table id="reportTable1" class="table" style="width: 50%; margin: auto; font-size: 12px;">
	<thead>
		<tr class="trobjrow">
			<th colspan="6">Converting Line - Production Detailed Report</th>
		</tr>
		<tr>
			<!-- <th>Date</th>
			<th>Shift</th> -->
			<th colspan="1">Date</th>
			<th colspan="1">Grade Code</th>
			<th colspan="1">Reel Number</th>
			<th colspan="1">SKU Code</th>
			<th colspan="1">Cases Produced<br /> 1st Grade</th>
			<th colspan="1">Cases Produced<br /> 2nd Grade</th>
			<!-- <th>Total Weight</th>
			<th>Diameter</th>
			<th>Roll Width</th>
			<th>Parent Core</th> -->
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${parentData}" var="pd">
			<tr>
				<%-- <td  style="width: 70px;"><div><fmt:formatDate value="${pd.date}" pattern="MM/dd/yyyy"/></div></td>
				<td style="width: 50px;"><div>${pd.shift}</div></td> --%>
				<td colspan="1" style="width: 100px;"><fmt:formatDate value="${pd.date}" pattern="MM-dd-yyyy"/></td>
				<td colspan="1" style="width: 100px;">${pd.parentrollid}</td>
				<td colspan="1" style="width: 100px;">${pd.parentgradecode}</td>
				<td colspan="1" style="width: 100px;">${pd.skucode}</td>
				<td colspan="1" style="width: 100px;">${pd.firstcaseandskutotal}</td>
				<td colspan="1" style="width: 100px;">${pd.secondcaseandskutotal}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${caseData}" var="cd">
				<c:set value="${firstcasetotal+cd.firstcasetotal}" var="firstcasetotal" />
				<c:set value="${secondcasetotal+cd.secondcasetotal}" var="secondcasetotal" />
		</c:forEach>
		<tr style="background-color: rgba(24, 23, 39, 0.28);">
				<td colspan="1" style="width: 50px;"><b></b></td>
				<td colspan="1" style="width: 50px;"><b></b></td>
				<td colspan="1" style="width: 50px;"><b></b></td>
				<td colspan="1" style="width: 50px;"><b>Total</b></td>
				<td style="width: 100px;"><b>${firstcasetotal}</b></td>
				<td style="width: 100px;"><b>${secondcasetotal}</b></td>
			</tr>
	</tbody>
	
	<tr>
					<td colspan="8"><div>&nbsp;<br></div></td>
	</tr>
</table>
</div>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
