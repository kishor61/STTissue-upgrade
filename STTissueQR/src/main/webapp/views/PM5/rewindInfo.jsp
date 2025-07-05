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
	<div class="container">
	<spring:url value="/pm5rewind/rwindinfo/data" var="searchURL" />
	<form action="${searchURL}" method="get">
	<table>
		<tr>
			<td>Reel #</td>
			<td><input type="text" name="reel" value="${reel}"></td>
			<td>Set #</td>
			<td><input type="text" name="set" value="${set}"></td>
			<td><input type="submit" value="Search"> </td>
		</tr>
	</table>		
	</form>
	<hr>
	
	
	
	<c:if test="${showFlag}">
		<table class="table" style="margin: auto; font-size: 12px;">
			<thead>
				<tr>
					<th>Date</th>
					<th>Grade</th>
					<th>Reel #</th>
					<th>Set #</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(rewinds)>0 }">
					<c:forEach items="${rewinds}" var="rewind">
						<tr>
							<td><fmt:formatDate value="${rewind.date}" pattern="MM-dd-yyyy"/></td>
							<td>${rewind.gradeCode}</td>
							<td>${rewind.reel}</td>
							<td>${rewind.setNo}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${fn:length(rewinds) eq 0 }">
					<tr>
						<td colspan="4"> Data not available for this selection.</td>
					</tr>
				</c:if>
			
			</tbody>
		
		</table>
	
	
	</c:if>
	
	
	</div>

</body>
</html>
