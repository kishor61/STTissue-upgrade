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
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.tg .tg-yw4l{vertical-align:top}
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
					<span class="label">Converting Line 171 Reporting - Monthly Report</span>
				</div>
				<div class="table-selector" id="table-selector">
				
				<spring:url value="/convertinglinereport/monthlyreport/view/show/report" var="viewURL"/>
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
							<c:if test="${export}">
							<td>
								<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
							</td>	
							</c:if>
						</tr>
					</table>
				</form>
				</div>
<c:if test="${export}">				
<form id="exportFrom" action='<spring:url value="/convertinglinereport/monthlyreport/view/show/report/export"/>' method="get" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
</c:if>
			</div>
<br /><br />
<c:if test="${show}">
<center>
			<table id="reportTable1" class="table" style="margin: auto;font-size: 12px;width: 70% !important;">
				<thead>
				<tr class="trobjrow">
					<th colspan="17">CONVERTING LINE 171 REPORTING - MONTHLY REPORT</th>
				</tr>
				<tr>
					<th class="tg-yw4l">Date</th>
					<th class="tg-yw4l">Customer Name</th>
					<th class="tg-yw4l">SKU Code</th>
					<th class="tg-yw4l">Order Quantity</th>
					<th class="tg-yw4l">Ship Quantity</th>
					<th class="tg-yw4l">$ Amount</th>
					<th class="tg-yw4l">Status</th>
					<!-- <th class="tg-yw4l">Acknowledgement<br />During PO Creation</th> -->
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${monthlyReportData}" var="data">
				<c:if test ="${data.rowview eq 'Not Total'}">
				<tr style="text-align: center;">
					<td class="tg-yw4l"><fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy"/></td>
					<td class="tg-yw4l">${data.customer}</td>
					<td class="tg-yw4l">${data.skucode}</td>
					<td class="tg-yw4l">${data.orderQty}</td>
					<td class="tg-yw4l">${data.shipQty}</td>
					<td class="tg-yw4l">$ ${data.priceperunit}</td>
					<td class="tg-yw4l">${data.status}</td>
					<%-- <td class="tg-yw4l">${data.ackpocreation}</td> --%>
				</tr>
				</c:if>
				<c:if test ="${data.rowview eq 'Total'}">
				<tr style="font-weight: 700;text-align: center;background-color: rgb(232, 221, 221);">
					<td class="tg-yw4l">Total</td>
					<td class="tg-yw4l"></td>
					<td class="tg-yw4l"></td>
					<td class="tg-yw4l">${data.totalshipqty}</td>
					<td class="tg-yw4l">${data.totalorderqty}</td>
					<td class="tg-yw4l">$ <fmt:formatNumber value="${data.priceperunit}" maxFractionDigits="2"/></td>
					<td class="tg-yw4l">Shipped: ${data.totalshiped}</td>
					<!-- <td class="tg-yw4l"></td> -->
					
					<c:set value="${Totalshipqty+data.totalshipqty}" var="Totalshipqty"/>
					<c:set value="${Totalorderqty+data.totalorderqty}" var="Totalorderqty"/>
					<c:set value="${Priceperunit+data.priceperunit}" var="Priceperunit"/>
					<c:set value="${Totalshiped+data.totalshiped}" var="Totalshiped"/>
				</tr>
				</c:if>
				</c:forEach>
				<tr style="font-weight: 700;text-align: center;background-color: rgb(228, 199, 199);">
					<td class="tg-yw4l" colspan="3">Grand Total</td>
					<td class="tg-yw4l">${Totalorderqty}</td>
					<td class="tg-yw4l">${Totalshipqty}</td>
					<td class="tg-yw4l">$ <fmt:formatNumber value="${Priceperunit}" maxFractionDigits="2"/></td>
					<td class="tg-yw4l">Shipped: ${Totalshiped}</td>
					<!-- <td class="tg-yw4l"></td> -->
				</tr>
				</tbody>
			</table>
</center>
</c:if>
		</div>


	</div>

</body>
</html>
