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
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Search Forecast Customer And SKU Code Wise</span>
				</div>
				<div class="table-selector">
					
					<spring:url value="/convertinglinereport/searchforecastcustomerandskucodewise/view/data" var="viewURL"/>
					<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td><input readonly="readonly" type="text" name="sdate" value="${sdate}"></td>
							<td>End Date:</td>
							<td><input readonly="readonly" type="text" name="edate" value="${edate}"></td>
							<td>Customer: 
								 <select name="custname" id="custname" style="width: 200px; padding: 2px;" required="required">
									<option value="">Select</option>
									<option value="All" selected="selected">All</option>
									<c:forEach items="${custname}" var="cust">
										<c:choose>
											<c:when test="${cust.customer eq searchedcust }">
												<option value="${cust.customer}" selected="selected">${cust.customer}</option>
											</c:when>
											<c:otherwise>
												<option value="${cust.customer}">${cust.customer}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>SKU Code: 
								<select name="skucode" id="skucode" style="width: 200px; padding: 2px;" required="required">
									<option value="-1">Select</option>
									<option value="All" selected="selected">All</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq searchedskucode }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
											</c:when>
											<c:otherwise>
												<option value="${skucode.productcode}">${skucode.productcode}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
							</td>
						</tr>
					</table>
					</form>

				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${show}">
<table class="table" id="yielddatatable">
						<thead style="font-size: 12px;">
						<tr>
								<th class="trobjrow" colspan="4" style="width:80px;">Information Selection</th>
								<th class="trobjrow" colspan="13" style="width:80px;">Projections</th>
							</tr>
						<tr>
								<!-- <th style="width:10px;" rowspan="2">
									
								</th> -->
								<th style="width:200px;">Date</th>
								<th style="width:200px;">Customer Name</th>
								<th style="width:80px;">SKU Code</th>
								<th style="width:80px;">January</th>
								<th style="width:80px;">February</th>
								<th style="width:80px;">March</th>
								<th style="width:80px;">April</th>
								<th style="width:80px;">May</th>
								<th style="width:80px;">June</th>
								<th style="width:80px;">July</th>
								<th style="width:80px;">August</th>
								<th style="width:80px;">September</th>
								<th style="width:80px;">October</th>
								<th style="width:80px;">November</th>
								<th style="width:80px;">December</th>
							</tr>
						</thead>
						<tbody id="yielddatainput">
							<c:if test="${fn:length(currentData) eq 0 }">
									<tr>
										<td colspan="15" style="font-size: 21px;color: #cb842e;">You Have Not Entered Data (Forecast Value) For Particular Search And Date Range.</td>
									</tr>
									</c:if>
									<c:if test="${fn:length(currentData)>0}">
									<c:forEach items="${currentData}" var="data">
										<tr style="text-align: center;">
											<%-- <td>
														<input type="radio" name="rowCheckbox" value="${data.id}"> 
													</td> --%>
											<td><fmt:formatDate value="${data.date}"
													pattern="MM-dd-yyyy" var="dateH" /> ${dateH}</td>
											<td>${data.customer}</td>
											<td>${data.skucode}</td>
											<td>${data.january}</td>
											<td>${data.february}</td>
											<td>${data.march}</td>
											<td>${data.april}</td>
											<td>${data.may}</td>
											<td>${data.june}</td>
											<td>${data.july}</td>
											<td>${data.august}</td>
											<td>${data.september}</td>
											<td>${data.october}</td>
											<td>${data.november}</td>
											<td>${data.december}</td>
											
														 <c:set value="${totaljanuary+data.january}" var="totaljanuary"/>
														 <c:set value="${totalfebruary+data.february}" var="totalfebruary"/>
														 <c:set value="${totalmarch+data.march}" var="totalmarch"/>
														 <c:set value="${totalapril+data.april}" var="totalapril"/>
														 <c:set value="${totalmay+data.may}" var="totalmay"/>
														 <c:set value="${totaljune+data.june}" var="totaljune"/>
														 <c:set value="${totaljuly+data.july}" var="totaljuly"/>
														 <c:set value="${totalaugust+data.august}" var="totalaugust"/>
														 <c:set value="${totalseptember+data.september}" var="totalseptember"/>
														 <c:set value="${totaloctober+data.october}" var="totaloctober"/>
														 <c:set value="${totalnovember+data.november}" var="totalnovember"/>
														 <c:set value="${totaldecember+data.december}" var="totaldecember"/>
														 
														 
										</tr>
									</c:forEach>
									<tr style="text-align: center; background-color: #9789c14d;font-weight: 700;">
											<td colspan="3">Total</td>
											<td>${totaljanuary}</td>
											<td>${totalfebruary}</td>
											<td>${totalmarch}</td>
											<td>${totalapril}</td>
											<td>${totalmay}</td>
											<td>${totaljune}</td>
											<td>${totaljuly}</td>
											<td>${totalaugust}</td>
											<td>${totalseptember}</td>
											<td>${totaloctober}</td>
											<td>${totalnovember}</td>
											<td>${totaldecember}</td>
										</tr>			
									</c:if>
						
								</tbody>
								
								
							
						
					</table>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
