<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('button[type=submit]').click(function(){
		var val=$('input[name=ngrade]').val();
		
		if(!/^[a-z0-9]+[a-z0-9-]+[a-z0-9]+$/i.test(val)) {
			   alert('Grade code can only be alpha numeric with hypen(-).');
			   return false;
		}
		
		return true;
	});
	
});
</script>
</head>
<body>
<div class="page-title">
	<span class="label">Copy Grade Code</span>
</div>
<spring:url value="/grade/copysave" var="saveURL"/>


<form action="${saveURL}" method="get">
<table>
	<tr>
		<td><b>Source Code:</b></td>
		<td>${grade}<input type="hidden" value="${grade}" name="grade"> </td>
	</tr>
	<tr>
		<td><b>Target Code:</b></td>
		<td><input style="width: 150px;" name="ngrade" value="${ngrade}"></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Save</button> </td>
	</tr>
	
</table>
</form>

<br><br>

<c:if test="${saveFlag}">
	<c:if test="${not empty error }">
			<span class="error">${error}</span>
	</c:if>
	<c:if test="${not empty message}">
			<span class="message">${message}</span>
	</c:if>	
</c:if>

</body>
</html>
