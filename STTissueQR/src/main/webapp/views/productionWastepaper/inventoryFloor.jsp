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
		$('input[name=date]').datepicker({
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
					<span class="label">ST Tissue Current Inventory</span>
				</div>
				<br>
				<div class="table-selector">
				<spring:url value="/inventoryfloorreport/view" var="viewURL"/>
				<form action="${viewURL}" method="get">	
					<table>
						<tr>
							<td>Date:</td>
							<td>
								<input type="text" name="date" value="${date}" readonly="readonly" style="width: 80px;">
							</td>
							<td>Customer:</td>
							<td>
								<select name="customer" style="padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${customers}" var="cust">
										<c:choose>
											<c:when test="${customer eq cust}">
												<option value="${cust}" selected="selected">${cust}</option>
											</c:when>
											<c:otherwise>
												<option value="${cust}">${cust}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<button type="submit">VIEW</button>
								&nbsp;
								&nbsp;
								<c:if test="${showFlag}">
									<a href='<spring:url value="/inventoryfloorreport/export/excel?date=${date}&customer=${customer}"/>' target="_blank">EXCEL</a>
								</c:if>
							</td>
						</tr>
					</table>
				</form>
				</div>
				
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${showFlag}">
<table class="table" style="margin: auto;">
	<thead>
		<tr>
			<th>Cust</th>
			<th>Type Sort</th>
			<th>Color</th>
			<th><div style="width: 80px;">GradeCode</div></th>
			<th>Customer Code</th>
			<th>Roll Count</th>
			<th>Core Size</th>
			<th>Roll Width</th>
			<th>Diameter</th>
			<th>Ply</th>
			<th>Tons</th>
			<th>Grade</th>
			<th>PO#</th>
			<th>P/U #'s</th>
			<!-- <th>Additional comments</th> -->
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productions}" var="prod"> 
			<tr>
				<td>${prod.customer}</td>
				<td>${prod.shortType}</td>
				<td>${prod.color}</td>
				<td>${prod.gradeCode}</td>
				<td>${prod.customerGradeCode}</td>
				<td>${prod.rollCount}</td>
				<td>${prod.coreSize}</td>
				<td>${prod.rollWidth}</td>
				<td>${prod.diameter}</td>
				<td>${prod.ply}</td>
				<td><fmt:formatNumber value="${prod.whiteWeight}" maxFractionDigits="2"/> </td>
				<td>${prod.grade}</td>
				<td>${prod.poNumber}</td>
				<td>${prod.shippingNo}</td>
				<%-- <td>${prod.comment}</td> --%>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
<br><br>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
