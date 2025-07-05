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
		
		$('textarea').keypress(function(e) {
		    var tval = $('textarea').val(),
		        tlength = tval.length,
		        set = 200,
		        remain = parseInt(set - tlength);
		  // $('#charCount').text('Char. Remain ('+remain+')');
		    if (remain <= 0 && e.which !== 0 && e.charCode !== 0) {
		        $('textarea').val((tval).substring(0, tlength - 1))
		    }
		});
		
		$('#saveBtn').click(function(){
			
			/* var description=$('textarea[name=description]').val();
			if($.trim(description)==''){
				alert('Please enter description!');
				return false;
			} */
			
			var type=$('input[name=name]').val();
			if($.trim(type)==''){
				alert('Please enter standard type!');
				return false;
			}
			
			if(!/^[A-Za-z\d\s]+$/.test(type)){
				alert('Only alphanumeric characters allowed!');
				return false;
			}
			
			return true;
		});
		
	});
	
</script>
</head>
<body style="overflow: auto;">

<div class="container">
	<div class="page-title">
		<span class="label">Safety Housekeeping - New Standard</span>
	</div>
<br>

<c:if test="${not empty error}">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

<spring:url value="/safetyhousekeeping/save/stdtype" var="saveURL"/>
<form:form id="safetyForm" action="${saveURL}" method="post" modelAttribute="housekeepingStdType">


<table>
	
	
	<tr>
		<td valign="top">Standard Type:</td>
		<td>
			<input type="text" name="name" value="${housekeepingStdType.name}" maxlength="50" style="width: 200px;">
		</td>
		<td>
			<button type="submit" id="saveBtn">Save</button>
			<input type="hidden" name="id" value="${housekeepingStdType.id}">
		 </td>
</table>
</form:form>
<hr>

<table class="table" style="margin: auto; width: 500px;">
	<thead>
		<tr>
			<th style="width: 20px;">S.No.</th>
			<th>Standard Type</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${types}" var="type" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${type.name }</td>
				<td style="width: 100px;text-align: center;">
					<a href='<spring:url value="/safetyhousekeeping/edit/stdtype/${type.id}"/>'>Edit</a>
					&nbsp;
					<a href='<spring:url value="/safetyhousekeeping/delete/stdtype/${type.id}"/>'>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>

</body>
</html>
