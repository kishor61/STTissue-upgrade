<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=dayToCompletion]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		
	});
	
</script>
</head>
<body style="overflow: auto;">

<div class="container">
	<div class="page-title">
		<span class="label">Safety Log-New</span>
	</div>
<br>

<c:if test="${not empty error}">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

<spring:url value="/safetylog/save/review" var="saveURL"/>
<form id="safetyForm" action="${saveURL}" method="post">


<table>
	<tr>
		<td style="width: 150px;"><b>Date</b></td>
		<td style="width: 150px;"><fmt:formatDate value="${safetyLog.date}" pattern="MM-dd-yyyy"/></td>
		<td style="width: 150px;" align="center"><b>Employee</b></td>
		<td style="width: 150px;">${safetyLog.employee}</td>
		<td align="center"><b>Area</b></td>
		<td style="width: 150px;">${safetyLog.area}</td>
	</tr>
	<tr>
		<td colspan="6"><br><hr><br></td>
	</tr>
	<tr>
		<td valign="top"><b>Description</b></td>
		<td colspan="5">
			${safetyLog.description}
		</td>
	</tr>
	<tr>
		<td colspan="6"><br><hr><br></td>
	</tr>
	<tr>
		<td>Day To Completion</td>
		<td colspan="5"><input type="text" readonly="readonly" name="dayToCompletion" value="<fmt:formatDate value="${safetyLog.dayToCompletion}" pattern="MM-dd-yyyy"/>">
		
	</tr>
	<tr>
		<td>Number of Days</td>
		<td colspan="5">${safetyLog.numOfdays}</td>
	</tr>
	
	<tr>
		<td colspan="6"><br><hr>
		<input type="hidden" name="id" value="${safetyLog.id}">
		<button type="submit" id="saveBtn">Save</button>
		</td>
		
	</tr>
</table>
</form>

</div>

</body>
</html>
