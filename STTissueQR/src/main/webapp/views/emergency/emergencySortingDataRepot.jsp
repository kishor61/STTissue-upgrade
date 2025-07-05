<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
    .download-btn {
        display: inline-flex;
        align-items: center;
        padding: 8px 16px;
        background-color: #28a745;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        transition: all 0.3s ease;
        font-weight: 500;
    }
    
    .download-btn:hover {
        background-color: #218838;
        color: white;
        text-decoration: none;
        transform: translateY(-1px);
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
    
    .download-btn i {
        margin-right: 8px;
        font-size: 16px;
    }
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body style="overflow: auto;">
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Incident Type</th>
                <th>Status</th>
                <th>Team</th>
                <th>Date Of Incident</th>
                <th>Date Of Reported</th>
                <th>Mill Area Where Incident Occured</th>
                <th>Mill Area System</th>            
                <th>View</th>
                <th>Download</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${fn:length(datas) gt 0 }">
                <c:forEach items="${datas}" var="data">
                    <tr>
                        <td hidden><input type="radio" name="id" id="id" value="${data.id}"></td>
                        <td style="text-align: center;">${data.incidentType}</td>
                        <td style="text-align: center;">${data.status}</td>
                        <td style="text-align: center;">${data.crew}</td>
                        <td style="text-align: center;">${data.dateOfIncident}</td>
                        <td style="text-align: center;">${data.dateReported}</td>
                        <td style="text-align: center;">${data.starIncidentLocation}</td>
                        <td style="text-align: center;">${data.locationIncidentOccured}</td>
                        <td style="text-align: center;">
                            <c:if test="${not data.edited}">
                                <a href='<spring:url value="/911EmergencyReport/detailsreportview?id=${data.id}"/>'>VIEW</a>
                            </c:if>
                            <c:if test="${data.edited}">
                                <a href='<spring:url value="/911EmergencyReport/detailsreportview?id=${data.id}"/>'>VIEWED</a>
                            </c:if>
                        </td>
                        <td style="text-align: center;">
                            <a class="download-btn" href='<spring:url value="/911EmergencyReport/detailsreportdownload?id=${data.id}"/>'>
                                <i class="fas fa-file-excel"></i> EXCEL
                            </a>
                        </td>
                    </tr>    
                </c:forEach>
            </c:if>
            
            <c:if test="${fn:length(datas) eq 0 }">
                <tr>
                    <td colspan="9" style="text-align: center;">Data not available for this selection.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>
</body>
</html>
