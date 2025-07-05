<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>


<style type="text/css">
.table-selector table input[type=text] {
	width: 100px;
	text-align: center;
}
.table th{
	text-align: center;
}
.table td div,.table td {
	width: inherit !important;
	text-align: center;
}
.table tfoot td{
	text-align: center;
}
.boldTr{
	font-weight: bold;
	background-color: rgb(226, 226, 226);
}
.ui-datepicker-calendar {
    display: none;
}
</style>

<script type="text/javascript">
$(function(){
	
	$('input[name=sdate]').datepicker({
		changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        minDate:  new Date(2013, 09, 01, 0, 0, 0, 0),
        dateFormat: 'MM yy',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }
	});
	
	$('input[name=edate]').datepicker({
		changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        dateFormat: 'MM yy',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
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
					<span class="label">PM6 Tissue Wrapper Red/Reject Tons Summary - Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/wrapperredcodereport/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Month:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}" style="width: 200px;">							
							</td>
							<td>End Month:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}" style="width: 200px;">							
							</td>
							<td>
								<input type="submit" value="View">
								&nbsp;
								&nbsp;
								<c:if test="${viewFlag}">
									<input type="button" id="exportBtn" value="Export">
									&nbsp;
									<input type="button" id="printBtn" value="Print">
								</c:if>
							</td>
						</tr>
					</table>
				</form>
				
				</div>
				
				
				<br>
				<br>

<div style="position: absolute;bottom: 0;width: 98%;top: 103px;overflow: auto;">
<c:if test="${viewFlag}">

<script type="text/javascript">
	$(function(){
		$('#exportBtn').click(function(){
			$('#exportForm').submit();
			return false;
		});
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
		
	});
</script>

<spring:url value="/wrapperredcodereport/export" var="exportURL"/>
<form id="exportForm" action="${exportURL}" method="post" target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>

<div id="printDiv">
<table class="table" style="margin: auto; font-size: 12px; width: auto;">
	
	<thead>
		<tr class="trobjrow">
			<th colspan="${8 + (fn:length(data['months'])*4)}">PM6 Tissue Wrapper Report - Red/Reject Tons</th>
		</tr>
		<tr>
			<th colspan="2" style="width: 300px;">Red Code</th>
			<c:forEach items="${data['months']}" var="month">
				<th colspan="4">${month}</th>
			</c:forEach>
			<c:if test="${sdate ne edate }">
				<th colspan="6">Total</th>		
			</c:if>
			<c:if test="${sdate eq edate }">
				<th colspan="2">Total</th>		
			</c:if>
			
		</tr>
		<tr style="font-size: 10px;">
			<th style="width: 80px" rowspan="2">Code</th>
			<th rowspan="2"><div style="width: 219px; display: block;">Description</div></th>
			<c:forEach begin="1" end="${fn:length(data['months'])}">
				<th colspan="2"><div style="width: 100px;">Red</div></th>
				<th colspan="2"><div style="width: 100px;">Rejected</div></th>
			</c:forEach>
			
			<c:if test="${sdate ne edate }">
				<th colspan="2"><div style="width: 100px;">Red</div></th>
				<th colspan="2"><div style="width: 100px;">Rejected</div></th>
				<th rowspan="2"><div style="width: 50px;">Red Total</div></th>
				<th rowspan="2"><div style="width: 50px;">Rejected Total</div></th>		
			</c:if>
			<c:if test="${sdate eq edate }">
				<th rowspan="2"><div style="width: 100px;">Red</div></th>
				<th rowspan="2"><div style="width: 100px;">Rejected</div></th>		
			</c:if>
			
		</tr>
		
		<tr style="font-size: 10px;">
			<c:forEach begin="1" end="${fn:length(data['months'])}">
				<th><div style="width: 50px;">White</div></th>
				<th><div style="width: 50px;">Brown</div></th>
				<th><div style="width: 50px;">White</div></th>
				<th><div style="width: 50px;">Brown</div></th>
			</c:forEach>
			<c:if test="${sdate ne edate }">
				<th><div style="width: 50px;">White</div></th>
				<th><div style="width: 50px;">Brown</div></th>
				<th><div style="width: 50px;">White</div></th>
				<th><div style="width: 50px;">Brown</div></th>
			</c:if>
		</tr>
		
		
	</thead>
	<tbody id="tableBody">
		<c:if test="${fn:length(data['redData']) eq 0}">
			<tr>
				<td colspan="${4 + (fn:length(data['months'])*2)}">Data not available for this selection.</td>
			</tr>
		</c:if>
		<c:if test="${fn:length(data['redData']) gt 0}">
			<c:forEach items="${data['redData']}" var="wrdata">
				<tr>
					<td>${wrdata.redCode}</td>
					<td>${wrdata.redCodeDesc}</td>
					<c:forEach items="${wrdata.wrapperData}" var="wd">
						<td><fmt:formatNumber value="${wd.redWeightWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wd.redWeightBrown}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wd.rejectedWeightWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wd.rejectedWeightBrown}" maxFractionDigits="2"/> </td>
					</c:forEach>
					
					<c:if test="${sdate ne edate }">
						<td><fmt:formatNumber value="${wrdata.totalRedWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wrdata.totalRedBrown}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wrdata.totalRejectWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wrdata.totalRejectBrown}" maxFractionDigits="2"/> </td>
					</c:if>
					<td><fmt:formatNumber value="${wrdata.totalRed}" maxFractionDigits="2"/> </td>
					<td><fmt:formatNumber value="${wrdata.totalReject}" maxFractionDigits="2"/> </td>
				</tr>
			</c:forEach>
		</c:if>
		
		
		<%-- <c:forEach items="${data['totalRedData']}" var="wrdataTotal"> --%>
				<c:set value="${data['totalRedData']}" var="wrdataTotal"/>
				<tr>
					<td colspan="2"><b>TOTAL</b></td>
					<c:forEach items="${wrdataTotal.wrapperData}" var="wdt">
						<td><fmt:formatNumber value="${wdt.redWeightWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wdt.redWeightBrown}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wdt.rejectedWeightWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wdt.rejectedWeightBrown}" maxFractionDigits="2"/> </td>
					</c:forEach>
					<c:if test="${sdate ne edate }">
						<td><fmt:formatNumber value="${wrdataTotal.totalRedWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wrdataTotal.totalRedBrown}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wrdataTotal.totalRejectWhite}" maxFractionDigits="2"/> </td>
						<td><fmt:formatNumber value="${wrdataTotal.totalRejectBrown}" maxFractionDigits="2"/> </td>
					</c:if>
					<td><fmt:formatNumber value="${wrdataTotal.totalRed}" maxFractionDigits="2"/> </td>
					<td><fmt:formatNumber value="${wrdataTotal.totalReject}" maxFractionDigits="2"/> </td>
				</tr>
		<%-- </c:forEach> --%>
				
	</tbody>
	
</table>
<script type="text/javascript">

</script>
	

</div>
<br><br>


</c:if>					
				</div>

			</div>

		</div>


	</div>

</body>
</html>
