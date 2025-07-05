<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

</head>
<body>
<div class="fixed-message">
	<span class="tmessage" id="tmessage"></span>
</div>

	<div class="container">

		
		<table class="table">
			<thead>
				<tr>
					<th>WrapperNumber</th>
					<th>RollID</th>
					<th>DateEntered</th>
					<th>DateTimeEntered</th>
					<th>RollNumber</th>
					<th>SetPosition</th>
					<th>Shift</th>
					<th>GradeCode</th>
					<th>CustomerGradeCode</th>
					<th>RedWeight</th>
					<th>RejectWeight</th>
					<th>Initials</th>
					<th>Diameter</th>
					<th>RollWidth</th>
					<th>Ply</th>
					<th>CoreSize</th>
					<th>Barcode</th>
					<th>Comment</th>
					<th>DateShipped</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productions}" var="prod">
					<c:set value="${''}" var="colorTr"/>
					<c:if test="${prod.newRed}">
						<c:set value="${'red'}" var="colorTr"/>
					</c:if>
					
					<tr style="color:${colorTr};">
						<td>${prod.wrapperNumber}</td>
						<td>${prod.rollID}</td>
						<td><fmt:formatDate value="${prod.dateEntered}" pattern="MM/dd/yyyy"/> </td>
						<td><fmt:formatDate value="${prod.dateTimeEntered}" pattern="MM/dd/yyyy hh:mm a"/> </td>
						<td>${prod.rollNumber}</td>
						<td>${prod.setPosition}</td>
						<td>${prod.shift}</td>
						<td>${prod.gradeCode}</td>
						<td>${prod.customerGradeCode}</td>
						<td>${prod.redWeight}</td>
						<td>${prod.rejectWeight}</td>
						<td>${prod.initials}</td>
						<td>${prod.diameter}</td>
						<td>${prod.rollWidth}</td>
						<td>${prod.ply}</td>
						<td>${prod.coreSize}</td>
						<td>${prod.barcode}</td>
						<td>${prod.comment}</td>
						<td><fmt:formatDate value="${prod.dateShipped}" pattern="MM/dd/yyyy"/> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>
