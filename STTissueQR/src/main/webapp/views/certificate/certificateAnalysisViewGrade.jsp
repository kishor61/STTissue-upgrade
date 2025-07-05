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
<body style="overflow: auto;">
<%-- <h4 align="center">Displaying search result from ${sdate} to ${edate} for customer ${customer}</h4> --%>
<br>
<table class="table" style="width: 300px;margin: auto;">
	<thead>
		<tr>
			<th>Grade</th>
			<th style="width: 100px;"></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(grades) gt 0 }">
			<c:forEach items="${grades}" var="grade">
				<tr>
					<td style="text-align: center;">${grade}</td>
					<td style="text-align: center;"><a href='<spring:url value="/certificateanalysis/load/data?sdate=${sdate}&edate=${edate}&customer=${customer}&grade=${grade}"/>'>VIEW</a> </td>
				</tr>	
			</c:forEach>
		</c:if>
		
		<c:if test="${fn:length(grades) eq 0 }">
			<tr>
				<td colspan="8">Data not available for this selection.</td>
			</tr>
		</c:if>
	</tbody>
</table>


</body>
</html>
