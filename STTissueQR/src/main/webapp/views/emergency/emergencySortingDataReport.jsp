<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>911</title>
<jsp:include page="../common.jsp"></jsp:include>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<br>
<div style="margin-left: 160px; width: calc(100% - 120px); overflow-x: auto;">
<table class="table" style="min-width: 1000px;">
	<thead>
		<tr>
			<th style="width: 10%;">Incident Type</th>
			<th style="width: 8%;">Status</th>
			<th style="width: 8%;">Team</th>
			<th style="width: 10%;">Date Of Incident</th>
			<th style="width: 10%;">Date Of Reported</th>
			<th style="width: 15%;">Mill Area Where Incident Occured</th>
			<th style="width: 15%;">Mill Area System</th>			
			<th style="width: 8%;">Click To View</th>
			<th style="width: 8%;">Download</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(datas) gt 0 }">
			<c:forEach items="${datas}" var="data">
				<tr>
					<td hidden ><input type="radio" name="id" id="id" value="${data.id}"></td>
					<td style="text-align: center;">${data.incidentType}</td>
					<td style="text-align: center;">${data.status}</td>
					<td style="text-align: center;">${data.crew}</td>
					<td style="text-align: center;">${data.dateOfIncident}</td>
					<td style="text-align: center;">${data.dateReported}</td>
					<td style="text-align: center;">${data.starIncidentLocation}</td>
					<td style="text-align: center;">${data.locationIncidentOccured}</td>
					<c:if test="${not data.edited}"><td style="text-align: center;"><a href='<spring:url value="/911EmergencyReport/detailsreportview?id=${data.id}"/>'>VIEW</a> </td></c:if>
					<c:if test="${data.edited}"><td style="text-align: center;"><a href='<spring:url value="/911EmergencyReport/detailsreportview?id=${data.id}"/>'>VIEWED</a> </td></c:if>
				 <td style="text-align: center;"><a href='<spring:url value="/911EmergencyReport/detailsreportdownload?id=${data.id}"/>' class="btn btn-sm btn-success" title="Download Excel"><i class="fas fa-download"></i></a></td> 
				</tr>	
			</c:forEach>
		</c:if>
		
		<c:if test="${fn:length(datas) eq 0 }">
			<tr>
				<td colspan="8" style="text-align: center; font-size: 32;font-weight: bold;color: red;background-color: yellow">Data not available for this selection.</td>
			</tr>
		</c:if>
	</tbody>
</table>
</div>


</body>
</html>
