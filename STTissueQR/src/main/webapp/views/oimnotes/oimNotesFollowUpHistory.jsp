<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
body {
	margin: 0;
	padding: 3px;
	overflow: auto !important;
	font-size: 14px;
	
}
table {
	border-collapse: collapse;
	margin: auto;
	width: 800px;
}
table td{
	border: 1px solid gray;
	padding: 2px;
	vertical-align: top;
	
}
table td *{
	font-size: 14px;
}
.bg1{
	background-color: #CEE3F6;
}
@media print
{    
    button
    {
        display: none !important;
    }
}
</style>
</head>
<body>
<div class="page-title">
	<span class="label" style="font-size: 12px;">Follow Up- Change History</span>
</div>
<button onclick="window.print()">Print</button>
<button onclick="window.close()">Close</button>
<c:if test="${not empty message}">
	<br>
	<span class="message">${message}</span>
	
</c:if>
<br><br>
<table>
	<tr>
		<td class="bg1" style="width: 150px;text-align: center;"><b>Follow Up</b></td>
		<td class="bg1" colspan="2">${followUp.followUp}</td>
	</tr>
	<tr>
		<td colspan="3" style="height: 30px;vertical-align: bottom;;"><div style="font-size: 16px;text-transform: uppercase;font-weight: bold;">Change History</div> </td>
	</tr>
	
	<c:if test="${fn:length(histories) gt 0}">
		<tr>
			<td style="text-align: center;"><b>Last Updated</b></td>
			<td c style="text-align: center;width: 300px;"><b>Changes or Actions</b></td>
			<td style="text-align: center;width: 200px;"><b>Notes</b></td>
		</tr>
		
		<c:forEach items="${histories}" var="his">
			<tr>
				<td style="text-align: center;vertical-align: middle;"><fmt:formatDate value="${his.lastUpdated}" pattern="dd-MMM-yyyy h:mm a"/> </td>
				<td>${his.followUp}</td>
				<td>${his.notes}</td>
			</tr>
		</c:forEach>
	</c:if>
	
	<c:if test="${fn:length(histories) eq 0}">
		<tr>
			<td colspan="3"> Change history data is not available.</td>
		</tr>
	</c:if>
	<tr>
		<td colspan="3">Notes</td>
	</tr>
	<tr>
		<td colspan="3">
			<spring:url value="/oimnotes/followup/addhistory" var="saveURL"/>
			<form action="${saveURL}" method="post">
				<textarea name="notes" style="width: 790px;height: 80px;resize: none;"></textarea><br>
				<input type="hidden" name="id" value="${followUp.id}">
				<input type="submit" value="Save">
			</form>
		 </td>
	</tr>
	
</table>

</body>
</html>
