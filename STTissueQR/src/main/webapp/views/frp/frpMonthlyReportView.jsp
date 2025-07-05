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
					<span class="label">FRP Monthly Report</span>
				</div>
				
				<div class="table-selector" style="padding: 0px;margin: 1px 0 1px 0;">
				<spring:url value="/frpmonthlyreport/view/data" var="dataURL"/>
				<form action="${dataURL}" method="get">
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
<spring:url value="/frpmonthlyreport/export" var="exportURL"/>
<form id="exportFrom" action="${exportURL }" method="post" target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>



<div style="position: fixed;overflow: auto;top: 120px;bottom: 0px;width: 98%;left: 11px;right: 5px;">	

<table class="table" style="width: auto;">
<%-- 	<tr>
		<td>
			<div style="width: 300px;">Grade</div>
		</td>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.grade}</td>
		</c:forEach>
		<td></td>
	</tr> --%>
	<tr>
		<td>
			<div style="width: 300px;">Date</div>
		</td>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.date}</td>
		</c:forEach>
		<td></td>
	</tr>
	<tr>
		<td>
			Wastepaper Fed (ADT, Off DCS)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.wastepaperFed}</td>
			<c:set value="${total+data.wastepaperFed}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Wastepaper Fed (BDST)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.wastepaperFedBDST}</td>
			<c:set value="${total+data.wastepaperFedBDST}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Total Production (ADT, off DCS)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.totalProduction}</td>
			<c:set value="${total+data.totalProduction}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Total Production (BDST)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.totalProductionBDST}</td>
			<c:set value="${total+data.totalProductionBDST}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	<tr>
		<td>
			Sludge Hauled (lbs)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.sludgeHauled}</td>
			<c:set value="${total+data.sludgeHauled}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Sludge Consistency
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.sludgeConsistency}</td>
			<c:set value="${total+data.sludgeConsistency}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
		
	</tr>
	
	<tr>
		<td>
			Sludge Hauled (Lbs Solids)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.sludgeHauledLBS}</td>
			<c:set value="${total+data.sludgeHauledLBS}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Sludge Hauled (BDST)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.sludgeHauledBDST}</td>
			<c:set value="${total+data.sludgeHauledBDST}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	<tr>
		<td>
			Rejects Bunker Waste Hauled (Lbs)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.rejectsBwHauled}</td>
			<c:set value="${total+data.rejectsBwHauled}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Rejects Bunker Waste Consistency
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.rejectsBwConsistency}</td>
			<c:set value="${total+data.rejectsBwConsistency}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Rejects Bunker Waste Hauled (Lbs Solids)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.rejectsBwHauledLBS}</td>
			<c:set value="${total+data.rejectsBwHauledLBS}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			Rejects Bunker Waste Hauled (BDST)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.rejectsBwHauledBDST}</td>
			<c:set value="${total+data.rejectsBwHauledBDST}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	<tr>
		<td colspan="${fn:length(dailyDatas)+2}">&nbsp;</td>
	</tr>
	<tr>
		<td>
			Total Solids Sent to IP Clarifier (BDST)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.totalSolidsSentToIP}</td>
			<c:set value="${total+data.totalSolidsSentToIP}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td colspan="${fn:length(dailyDatas)+2}">&nbsp;</td>
	</tr>
	<tr>
		<td>
			IP Sludge Consistency Results (%)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.stIpSludgeConsistency}</td>
			<c:set value="${total+data.stIpSludgeConsistency}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	
	<tr>
		<td>
			ST Consistency Results (%)
		</td>
		<c:set value="${0}" var="total"/>
		<c:forEach items="${dailyDatas}" var="data">
			<td>${data.stSludgeConsistency}</td>
			<c:set value="${total+data.stSludgeConsistency}" var="total"/>
		</c:forEach>
		<td><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></td>
	</tr>
	


</table>
	
	
</div>	
</c:if>
			</div>

		</div>


	</div>






</body>
</html>
