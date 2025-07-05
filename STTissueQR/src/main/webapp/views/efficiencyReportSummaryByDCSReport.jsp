<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
		changeDate:false,
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
					<span class="label">Efficiency Summary By Shift - DCS</span>
				</div>
				<div class="table-selector">
				<form action='<spring:url value="/efficiencyreport/byDcs/report/view"></spring:url>' method="get">
					<c:set value="${fn:split('ALL,DAY,NIGHT',',')}" var="shifts"> </c:set>
					<table>
						<tr>
							<td>From Date <input type="text" name="sdate"	value="${sdate}" style="width: 80px;" readonly="readonly"></td>
							<td>To Date <input type="text" name="edate" value="${edate}" style="width: 80px;" readonly="readonly"></td>
							<%-- <td> Shift
								<select name="shift">
									<c:forEach items="${shifts}" var="sft">
										<c:choose>
											<c:when test="${sft eq shift}">
												<option value="${sft}" selected="selected">${sft}</option>
											</c:when>
											<c:otherwise>
												<option value="${sft}">${sft}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td> --%>
							<td>
								<input type="submit" value="VIEW">
								&nbsp;
								<c:if test="${showFlag}">
									<input type="button" value="EXPORT" onclick="$('#exportForm').submit();">
									
								&nbsp;	
								</c:if>
								
								<!-- <input type="button" value="EMAIL" id="sendMailBtn"> -->
									
							</td>
						</tr>
					</table>
					</form>

			</div>
<c:if test="${showFlag}">
<div style="display: none;">
<form id="exportForm" action='<spring:url value="/efficiencyreport/byDcs/report/export"></spring:url>' method="post">
	<input type="hidden" name="sdate" value="${sdate}" >
	<input type="hidden" name="edate" value="${edate}" >
	<input type="hidden" name="sht" value="${shift}" >

</form>

</div>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
	<table class="table" style="text-align: center;">
		<thead>
			<tr>
				<th rowspan="2"><div style="width: 60px;">DATE</div></th>
			<!-- 	<th rowspan="2">SHIFT</th> -->
				<th rowspan="2">TEAM</th>
				<th colspan="2">Machine Production</th>	
				<th colspan="4">Wrapper Production</th>	
				<th rowspan="2">Variance</th>
				<th rowspan="2">Variance<br>%</th>
				<th colspan="4">Efficiency</th>	
			
			</tr>
			<tr>
				<th>Actual<br>T/day By DCS</th>
				<th>Shift</th>
				<th>White<br>T/day </th>
				<th>Red<br>T/day </th>
				<th>Reject<br>T/day </th>
				<th>Total<br>T/day </th>
				<th>Uptime<br>%</th>
				<th>Quality<br>% </th>
				<th>Yield<br>%</th>
				<th>Eff Total<br>% </th>

			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${datas}" var="data">
				<tr>
					<td><fmt:formatDate value="${data.date}" pattern="MM/dd/yyyy" var="date1"/>${date1}</td>
					<%-- <td>${data.shift}</td> --%>
					<td>${data.crew}</td>
					<c:forEach items="${datas1}" var="data1" varStatus="status">
						<fmt:formatDate value="${data1.date}" pattern="MM/dd/yyyy" var="date2"/></td>
						<c:if test="${not (date1 eq date2)}">
							
							<c:if test="${data.shift ne data1.shift}">
											
							</c:if>		
						</c:if>
						<c:if test="${date1 eq date2}">
							<c:if test="${data.shift eq data1.shift}">
										<td>${data1.actualWt}</td>
										<td>${data1.shift}</td>
							</c:if>
						</c:if>
						
					</c:forEach>
					<td>${data.wrapWhite}</td>
					<td>${data.wrapRed}</td>
					<td>${data.wrapRej}</td>
					<td>${data.wrapTotal}</td>
					<td>${data.variance}</td>
					<td>${data.variancePer}</td>
					<td>${data.uptime}</td>
					<td>${data.quality}</td>
					<td>${data.yield}</td>
					<td>${data.effTotal}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
				<tr>
					<td>TOTAL</td>
					<td></td>
					<td></td>
					<td></td>
					<%-- <td>${totalData.actualWt}</td> --%>
<%-- 					<td>${totalData.slabOff}</td> --%>
					<td>${totalData.wrapWhite}</td>
					<td>${totalData.wrapRed}</td>
					<td>${totalData.wrapRej}</td>
					<td>${totalData.wrapTotal}</td>
					<td>${totalData.variance}</td>
					<td>${totalData.variancePer}</td>
					<td>${totalData.uptime}</td>
					<td>${totalData.quality}</td>
					<td>${totalData.yield}</td>
					<td>${totalData.effTotal}</td>
				</tr>
<!-- 				Code Starts From Here Done By Roshan Tailor -->

				<tr>
					<td>&nbsp;</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><b>Summary</b></td>
					<td><b></b></td>
					<td><b></b></td>
					<td></td>
<!-- 					<td><b>Ton</b></td> -->
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

<%-- <c:forEach items="${datas1}" var="data1">
				<tr>
					<td></td>
					<td><b><fmt:formatDate value="${data1.date}" pattern="MM/dd/yyyy"/></b></td>
					<td>${data1.shift}</td>
					<td>${data1.actualWt}</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
</c:forEach> --%>
				<tr>
					<td ></td>
					<td><b>A</b></td>
					<td></td>
					<td></td>
					<%-- <td>${aData.slabOff}</td> --%>
					<td>${aData.wrapWhite}</td>
					<td>${aData.wrapRed}</td>
					<td>${aData.wrapRej}</td>
					<td>${aData.wrapTotal}</td>
					<td>${aData.variance}</td>
					<td>${aData.variancePer}</td>
					<td>${aData.uptime}</td>
					<td>${aData.quality}</td>
					<td>${aData.yield}</td>
					<td>${aData.effTotal}</td>
				</tr>
				 <tr>
					<td ></td>
					<td><b>B</b></td>
					<td></td>
					<td></td>
					<%-- <td>${bData.slabOff}</td> --%>
					<td>${bData.wrapWhite}</td>
					<td>${bData.wrapRed}</td>
					<td>${bData.wrapRej}</td>
					<td>${bData.wrapTotal}</td>
					<td>${bData.variance}</td>
					<td>${bData.variancePer}</td>
					<td>${bData.uptime}</td>
					<td>${bData.quality}</td>
					<td>${bData.yield}</td>
					<td>${bData.effTotal}</td>
				</tr>
				<tr>
					<td ></td>
					<td><b>C</b></td>
					<td></td>
					<td></td>
					<%-- <td>${cData.slabOff}</td> --%>
					<td>${cData.wrapWhite}</td>
					<td>${cData.wrapRed}</td>
					<td>${cData.wrapRej}</td>
					<td>${cData.wrapTotal}</td>
					<td>${cData.variance}</td>
					<td>${cData.variancePer}</td>
					<td>${cData.uptime}</td>
					<td>${cData.quality}</td>
					<td>${cData.yield}</td>
					<td>${cData.effTotal}</td>
				</tr>
				<tr>
					<td ></td>
					<td><b>D</b></td>
					<td></td>
					<td></td>
					<%-- <td>${dData.slabOff}</td> --%>
					<td>${dData.wrapWhite}</td>
					<td>${dData.wrapRed}</td>
					<td>${dData.wrapRej}</td>
					<td>${dData.wrapTotal}</td>
					<td>${dData.variance}</td>
					<td>${dData.variancePer}</td>
					<td>${dData.uptime}</td>
					<td>${dData.quality}</td>
					<td>${dData.yield}</td>
					<td>${dData.effTotal}</td>
				</tr>
<!-- 			Code Ends HEre Done By Roshan Tailor  -->
				
			
		</tfoot>
	
	</table>

</div>

</c:if>
		</div>


	</div>

</body>
</html>
