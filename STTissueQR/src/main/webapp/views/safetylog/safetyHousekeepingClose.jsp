<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=closed]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
	
		
		$('#saveBtn').click(function(){
			
			var closedBy=$('input[name=closedBy]').val();
			if($.trim(closedBy)==''){
				alert('Please enter user name!');
				return false;
			}
			return true;
		});
		
		
	});

</script>
</head>
<body>
<div class="page-title">
	<span class="label">Safety Housekeeping - Close Action</span>
</div>

<c:if test="${not empty error}">
<span class="error">${error }</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message }</span>
	<!-- <script>
	$(function(){
		var myvar = ${flag};
		alert("calling");
		if (myvar == 1)
		{
			alert("calling");
			$(".ui-dialog").hide();
		}
		
		
	});
	</script> -->
	<script>
	    $(document).ready(function () {
	    	  	parent.location.reload(); 
	    });
	</script>
	
</c:if>
<br>

<spring:url value="/safetyhousekeeping/close/action/save" var="saveURL"/>
<form:form action="${saveURL}" modelAttribute="housekeepingAction" method="post">
<table>
	<tr>
		<td>Date:</td>
		<td><input type="text" readonly="readonly" name="closed" value='<fmt:formatDate value="${housekeepingAction.closed}" pattern="MM-dd-yyyy"/>'> </td>
	</tr>
	<tr>
		<td>Your Name:</td>
		<td><input type="text" name="closedBy" value="${housekeepingAction.closedBy}" maxlength="50"> </td>
	</tr>
	<tr>
		<td></td>
		<td>
			<button id="saveBtn" type="submit">Save</button>
			<input type="hidden" name="id" value="${housekeepingAction.id}">
		</td>
	</tr>
</table>
	
</form:form>	


</body>
</html>
