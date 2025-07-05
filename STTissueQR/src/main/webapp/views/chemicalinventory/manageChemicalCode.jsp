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


				<div class="page-title">
					<span class="label">Chemical</span>
				</div>
				
					<spring:url value="/chemicalinv/chemicalcode/save" var="saveURL"/>
					<form action="${saveURL}" method="post">
						<table>
							<tr>
								<td>Code</td>
								<td>
									<input type="text" name="code" value="${chemicalCode.code}">
								</td>
								<td>Min</td>
								<td>
									<input type="text" name="min" value="${chemicalCode.min}" style="width: 60px;">
								</td>
								<td>Target</td>
								<td>
									<input type="text" name="target" value="${chemicalCode.target}" style="width: 60px;">
								</td>
								<td>Max</td>
								<td>
									<input type="text" name="max" value="${chemicalCode.max}" style="width: 60px;">
								</td>
								
								<td>Unit</td>
								<td>
									<input type="text" name="unit" value="${chemicalCode.unit}" style="width: 60px;">
								</td>
								
								<td>
									<button type="submit" id="saveBtn">Save</button>
									<input type="hidden" name="id" value="${chemicalCode.id}">
									<spring:url value="/chemicalinv/chemicalcode/manage" var="newURL" />
									
									<c:if test="${chemicalCode.id gt 0}">
										<button type="button" onclick="location.href='${newURL}'">New</button>
									</c:if>
								</td>
							</tr>
						</table>
					</form>
				




<c:if test="${not empty error }">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message }">
	<span class="message">${message}</span>
</c:if>
<br>
<table class="table" style="width: 500px; margin: auto;">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Chemical Code</th>
			<th>Min</th>
			<th>Target</th>
			<th>Max</th>
			<th>Unit</th>
			<th style="width: 150px;"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${chemicalCodes}" var="ch" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${ch.code}</td>
				<td>${ch.min}</td>
				<td>${ch.target}</td>
				<td>${ch.max}</td>
				<td>${ch.unit}</td>
				<td style="text-align: center;">
					<a href='<spring:url value="/chemicalinv/chemicalcode/edit/${ch.id}"></spring:url>'>Edit</a>
					&nbsp;&nbsp;
					<a href='<spring:url value="/chemicalinv/chemicalcode/delete/${ch.id}"></spring:url>'>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<script type="text/javascript">
$(function(){
	$('#saveBtn').click(function(){
		
		var code=$('input[name=code]').val();
		if($.trim(code)==''){
			alert('Please enter chemical name.');
			return false;
		}
		
		var min=$('input[name=min]').val();
		if(!$.isNumeric(min)){
			alert('Please enter numeric value for Min.');
			return false;
		}
		
		var target=$('input[name=target]').val();
		if(!$.isNumeric(target)){
			alert('Please enter numeric value for Target.');
			return false;
		}
		
		var max=$('input[name=max]').val();
		if(!$.isNumeric(max)){
			alert('Please enter numeric value for Max.');
			return false;
		}
		
		
		return true;
	});
});
</script>
</body>
</html>
