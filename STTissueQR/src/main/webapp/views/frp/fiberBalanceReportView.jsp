<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">

.table td{
text-align: center;
}
.table tr td:FIRST-CHILD {
	font-weight: bold;
	font-size: 12px;
	text-align: left !important;	
	
}
</style>

<script type="text/javascript">
	$(function(){
		$('input[name=sdate]').datepicker({
			dateFormat:'mm-dd-yy',
			defaultDate: "+1w",
			changeMonth: true,
		    changeYear: true,
		    onClose: function( selectedDate ) {
		        $( "input[name=edate]" ).datepicker( "option", "minDate", selectedDate );
		     }
		});
		$('input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			defaultDate: "+1w",
			changeMonth: true,
		    changeYear: true,
		    onClose: function( selectedDate ) {
		        $( "input[name=sdate]" ).datepicker( "option", "maxDate", selectedDate );
		     }
		});
	});

</script>

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
					<span class="label">Fiber Balance Report</span>
				</div>
				
				<div class="table-selector" style="padding: 0px;margin: 1px 0 1px 0;">
				<spring:url value="/fiberbalancereport/view/data" var="dataURL"/>
				<form name="dataForm" action="${dataURL}" method="get">
					<table style="margin: auto;">
						<tr>
							<td>
								Start Date
							 </td>
							 <td>
							 	<input type="text" name="sdate" value="${sdate}" style="width: 100px;" readonly="readonly">
							 </td>
							 <td>
								End Date
							 </td>
							 <td>
							 	<input type="text" name="edate" value="${edate}" style="width: 100px;" readonly="readonly">
							 </td>
							<td>
								Production Type
							</td>
							<td>
								<select name="grade" style="padding: 2px;">
									<option value="">All</option>
									<c:forEach items="${grades}" var="g">
										<c:choose>
											<c:when test="${g.key eq grade}">
												<option value="${g.key}" selected="selected">${g.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${g.key}">${g.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<button type="submit" id="viewBtn">VIEW</button>
								<c:if test="${showFlag }">
									<button type="button" onclick="$('#exportFrom').submit();">EXPORT</button>
								</c:if>
							</td>
							 
							 
						</tr>
					</table>
					
				</form>

					
				</div>
<br>

<c:if test="${showFlag }">
<spring:url value="/fiberbalancereport/export" var="exportURL"/>
<form id="exportFrom" action="${exportURL }" method="post" target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
	<input type="hidden" name="grade" value="${grade}">
</form>



<div style="position: fixed;overflow: auto;top: 120px;bottom: 0px;width: 98%;left: 11px;right: 5px;">	

<table class="table" style="">

	<thead>
		<tr>
			<th rowspan="2"><div style="width: 70px;text-align: center;">Date</div></th>
			<th colspan="3">FRP Waste Paper Feed</th>
			<th colspan="3">Machine Production</th>
			<th>Reel Slab/ wetlap</th>
			<th>Wet Lap Produced</th>
			<th>M/c Sewer Loss</th>
			<th>M/c Fiber To FRP</th>
			<th>FRP Drain solids to IP</th>
			<th>Total drain solids</th>
			<th>Reject Bunker Sludge</th>
			<th>Sludge Hauled</th>
			<th>Total Sludge</th>
		</tr>
		<tr>
			<th>ADST</th>
			<th>%</th>
			<th>BDST</th>
			<th>ADST</th>
			<th>%</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
			<th>BDST</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${dailyDatas}" var="data">
			<tr>
				<td>${data.date }</td>
				<td>${data.wastepaperFed}</td>
				<td>90</td>
				<td>${data.wastepaperFedBDST}</td>
				<td>${data.wrapperTon}</td>
				<td>96</td>
				<td>${data.wrapperTonBDST}</td>
				<td>${data.prodSlabOff}</td>
				<td>${data.wetLapProd}</td>
				<td>${data.sewerLoss}</td>
				<td>${data.fiberToFrp}</td>
				<td>${data.totalSolidsSentToIP}</td>
				<td><fmt:formatNumber value="${data.totalSolidsSentToIP+data.fiberToFrp+data.sewerLoss}" maxFractionDigits="2"/> </td>
				<td>${data.rejectsBwHauledBDST}</td>
				<td>${data.sludgeHauledBDST}</td>
				<td><fmt:formatNumber value="${data.rejectsBwHauledBDST+data.sludgeHauledBDST}"/> </td>
			</tr>
		</c:forEach>
	</tbody>

</table>
	
	
</div>	
</c:if>
			</div>

		</div>


	</div>






</body>
</html>
