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
.table td{
text-align: center;
}
</style>
</head>
<body>
<jsp:include page="../_loader.jsp"/>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Wrapper Average- Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/productionwarpreport/wrapperAverage/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
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
								&nbsp;
								&nbsp;
								<c:if test="${viewFlag}">
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
								</c:if>
							</td>
						</tr>
					</table>
				</form>
				</form>
				</div>
				
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${viewFlag}">
<form id="exportFrom" action='<spring:url value="/productionwarpreport/wrapperAverage/export"/>' method="get" style="display:none; " target="_blank">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate}">
</form>


<table class="table" style="width: 100%;">
	<thead style="text-align: center;">
		<tr>
			<td>Grade</td>
			<td>Diameter</td>
			<td>Roll Width</td>
			<td>White Weight (avg)</td>
			<td>White Weight (max)</td>
			<td>White Weight (min)</td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productions}" var="prod">
			<tr>
				
				<td>${prod.gradeCode}</td>
				<td>${prod.diameter}</td>
				<td>${prod.rollWidth}</td>
				<td>
					<!--Code Starts From Here Done By Roshan Tailor Date:- 05-14-2015 -->
					<fmt:formatNumber value="${prod.whiteWeight}" maxFractionDigits="0" var="whiteWeight"/>
					<!--Code Ends Here Done By Roshan Tailor Date:- 05-14-2015 -->
					${whiteWeight}
				</td>
				<td>
					<!--Code Starts From Here Done By Roshan Tailor Date:- 05-14-2015 -->
					<fmt:formatNumber value="${prod.whiteWeightMax}" maxFractionDigits="0" var="whiteWeightMax"/>
					<!--Code Ends Here Done By Roshan Tailor Date:- 05-14-2015 -->
				${whiteWeightMax}
				</td>
				<td>
					<!--Code Starts From Here Done By Roshan Tailor Date:- 05-14-2015 -->
					<fmt:formatNumber value="${prod.whiteWeightMin}" maxFractionDigits="0" var="whiteWeightMin"/>
					<!--Code Ends Here Done By Roshan Tailor Date:- 05-14-2015 -->
				${whiteWeightMin}
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
