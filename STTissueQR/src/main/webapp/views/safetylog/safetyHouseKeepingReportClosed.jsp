<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate], input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>

<style type="text/css">
.hkmain{
	background-color: rgb(219, 195, 163);
}
.hkhead{
	background-color: #F0F0F0;
}
.avgrow{
	background-color: #FFF7EA;
}
.avgrow td{
	text-align: center;
	font-weight: bold;
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
					<span class="label">Safety Housekeeping - Closed Actions</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/safetyhousekeepingreport/closeditems/data" var="loadDataURL" />
					<form action="${loadDataURL}" method="get">
					<table>
						<tr>
							<td>
								From
							</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" readonly="readonly" style="width: 70px;">
							</td>
							<td>
								To
							</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 70px;">
							</td>
							
							
							<td>
								<button type="submit" id="loadBtn">Load</button>
								&nbsp;
								&nbsp;
								|
								&nbsp;
								&nbsp;
								<c:if test="${flagShow}">
									<spring:url value="/safetyhousekeepingreport/export/closedtems/pdf?sdate=${sdate}&edate=${edate}" var="pdfURL"/>
									<a href="${pdfURL}" target="_blank">PDF</a>
								</c:if>
							</td>
						</tr>
					</table>
					</form>
				</div>


<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
	
<c:if test="${flagShow}">


<c:set value="${0}" var="pmType"/>
<c:set value="${0}" var="frpType"/>
<c:set value="${0}" var="shippingType"/>
<c:set value="${0}" var="OfficeType"/>
<c:set value="${0}" var="OtherType"/>

<c:set value="${0}" var="pmTypeCount"/>
<c:set value="${0}" var="frpTypeCount"/>
<c:set value="${0}" var="shippingTypeCount"/>
<c:set value="${0}" var="OfficeTypeCount"/>
<c:set value="${0}" var="OtherTypeCount"/>


<table class="table" style="width: 900px; margin: auto;">
		
		<c:forEach items="${housekeepings}" var="h">
			<c:if test="${fn:length(h.actions) gt 0}">
			<tr>
				<td class="hkmain" colspan="5" style="font-weight: bold;text-align: center;">Description</td>
				<td class="hkmain" colspan="3" style="font-weight: bold;text-align: center;">Standard Type</td>
			</tr>
			<tr>
				
				<td colspan="5">${h.description }</td>
				<td colspan="3">${h.type }</td>
			</tr>
			<%-- 
			 --%>
			<tr>
				<td class="hkhead" style="text-align: center;"><div style="width: 100px;">Auditor</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 100px;">Area</div></td>
				<td  class="hkhead" style="text-align: center;">Description Of Finding</td>
				<td  class="hkhead" style="text-align: center;">Corrective Action</td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 100px;">By Whom</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 80px;">Date</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 80px;">Closed On</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 40px;">Days</div></td>
				
			</tr>
			<c:forEach items="${areas}" var="area">
				<c:set value="${0}" var="avg"/>
				<c:set value="${0}" var="countRow"/>
				<c:forEach items="${h.actions}" var="ac">
					<c:if test="${area.id eq ac.area }">
					
						<tr>
							<td style="text-align: center;">${ac.auditorName }</td>
							<td style="text-align: center;">${ac.areaName}</td>
							<td >${ac.descOfFinding }</td>
							<td>${ac.correctiveAction }</td>
							<td style="text-align: center;">${ac.byWhom}</td>
							<td style="text-align: center;"><fmt:formatDate value="${ac.date }" pattern="MM-dd-yyyy"/> </td>
							<td style="text-align: center;"><fmt:formatDate value="${ac.closed }" pattern="MM-dd-yyyy"/> </td>
							<td style="text-align: center;">${ac.days }</td>
							<c:set value="${avg+ac.days}" var="avg"/>
							<c:set value="${countRow+1}" var="countRow"/>
							
							<c:choose>
								<c:when test="${ac.areaType eq 1}">
									<c:set value="${pmType+ac.days}" var="pmType"/>
									<c:set value="${pmTypeCount+1}" var="pmTypeCount"/>
								</c:when>
								<c:when test="${ac.areaType eq 2}">
									<c:set value="${frpType+ac.days}" var="frpType"/>
									<c:set value="${frpTypeCount+1}" var="frpTypeCount"/>
								</c:when>
								<c:when test="${ac.areaType eq 3}">
									<c:set value="${OfficeType+ac.days}" var="OfficeType"/>
									<c:set value="${OfficeTypeCount+1}" var="OfficeTypeCount"/>
								</c:when>
								<c:when test="${ac.areaType eq 4}">
									<c:set value="${shippingType+ac.days}" var="shippingType"/>
									<c:set value="${shippingTypeCount+1}" var="shippingTypeCount"/>
								</c:when>
								<c:when test="${ac.areaType eq 5}">
									<c:set value="${OtherType+ac.days}" var="OtherType"/>
									<c:set value="${OtherTypeCount+1}" var="OtherTypeCount"/>
								</c:when>
								
							</c:choose>
							
						</tr>
						
					</c:if>
				</c:forEach>
				
				<c:if test="${countRow gt 0}">
						<tr class="avgrow">
							<td colspan="6"></td>
							<td>Avg</td>
							<td><fmt:formatNumber minFractionDigits="2" value="${avg/countRow}"/> </td>
						</tr>
				</c:if>
				
			</c:forEach>
			
				
				<tr>
					<td colspan="8">&nbsp;<div style="height: 20px;"></div> </td>
				</tr>
				
			
			</c:if>
			
			
			
		</c:forEach>
	
</table>

<table class="table" style="width: 900px; margin: auto;">
	<tr>
		<th>Area</th>
		<th>Average Days To Close</th>
	</tr>
	<tr>
		<td>PM</td>
		<td>
			<c:if test="${ pmType gt 0}">
				<fmt:formatNumber value="${pmType/pmTypeCount}" maxFractionDigits="2"/>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>FRP</td>
		<td>
			<c:if test="${ frpType gt 0}">
				<fmt:formatNumber value="${frpType/frpTypeCount}" maxFractionDigits="2"/>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>Office</td>
		<td>
			<c:if test="${ OfficeType gt 0}">
				<fmt:formatNumber value="${OfficeType/OfficeTypeCount}" maxFractionDigits="2"/>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>Shipping</td>
		<td>
			<c:if test="${ shippingType gt 0}">
				<fmt:formatNumber value="${shippingType/shippingTypeCount}" maxFractionDigits="2"/>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>Other</td>
		<td>
			<c:if test="${ OtherTypeCount gt 0}">
				<fmt:formatNumber value="${OtherTypeCount/OtherTypeCountCount}" maxFractionDigits="2"/>
			</c:if>
		</td>
	</tr>
	
</table>

</c:if>
	
	
	
	

</div>



			</div>

		</div>


	</div>



	
</body>
</html>
