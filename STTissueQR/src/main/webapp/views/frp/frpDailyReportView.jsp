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
					<span class="label">FRP Daily Report</span>
				</div>
				
				<div class="table-selector" style="padding: 0px;margin: 1px 0 1px 0;">
				<spring:url value="/frpdailyreport/view/data" var="dataURL"/>
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
<spring:url value="/frpdailyreport/export" var="exportURL"/>
<form id="exportFrom" action="${exportURL }" method="post" target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>



<div style="position: fixed;overflow: auto;top: 120px;bottom: 0px;width: 98%;left: 11px;right: 5px;">	

<table class="table" style="width: auto;">
<thead>
	<tr>
		<th>..Date...</th>
		<th>Shift</th>
		<th>Crew</th>
		<th>Production Type</th>
		<th>DEINK W.W. PUMP 4 3 1 - FT -6875</th>
		<th>WATER TO FIRE/MILL WATER TANK 430-FT-6956</th>
		<th>FIRE SYSTEM WATER 430-FT-6959</th>
		<th>DEINKING PLANT EFFLUENT 431-FT-6083</th>
		
		<th>LINE A-HD LEVEL AS OF 7 AM / 7 PM</th>
		<th>LINE A-TONS PRODUCED TO  THE TUBE CONVEYOR</th>
		<th>LINE A-WETLAP TONS PRODUCED</th>
		<th>LINE A-YIELD</th>
		<th>LINE A-WASTE PAPER FED</th>
		<th>LINE A-# OF BATCHES FED Shift Goal 16</th>
		
		<th>LINE B-PCC Tank LEVEL AS OF 7 AM / 7 PM</th>
		<th>LINE B-TONS PRODUCED TO  THE TUBE CONVEYOR</th>
		<th>LINE B-WETLAP TONS PRODUCED</th>
		<th>LINE B-YIELD</th>
		<th>LINE B-WASTE PAPER FED</th>
		<th>LINE B-# OF BATCHES FED Shift Goal 16</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${dailyDatas}" var="data">
		<tr>
			<td> <fmt:formatDate pattern = "MM-dd-yyyy" value = "${data.date}" /></td>
			<td> ${data.shift}</td>
			<td> ${data.crew}</td>
			<td> ${data.productiontype}</td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col1}"/></td>
			<%-- <td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col2}"/></td> --%>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col3}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col4}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col5}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col11}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col6}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col7}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${((data.col6+data.col7)/data.col9)*100}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col9}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col10}"/></td>
			
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col11b}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col6b}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col7b}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${((data.col6b+data.col7b)/data.col9b)*100}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col9b}"/></td>
			<td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${data.col10b}"/></td>
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
