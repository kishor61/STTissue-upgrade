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

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Primary Chemical Code</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/chemicalinv/primary/save" var="saveURL"/>
					<form action="${saveURL}" method="post">
						<table>
							<tr>
								<td>Name</td>
								<td>
									<input type="text" name="name" value="${chemicalPrimaryCode.name}">
								</td>
								
								<td>
									<button type="submit" id="saveBtn">Save</button>
									<input type="hidden" name="id" value="${chemicalPrimaryCode.id}">
									<spring:url value="/chemicalinv/primary/manage" var="newURL" />
									
									<c:if test="${chemicalPrimaryCode.id gt 0}">
										<button type="button" onclick="location.href='${newURL}'">New</button>
									</c:if>
								</td>
							</tr>
						</table>
					</form>
				</div>


<br>

<c:if test="${not empty error }">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message }">
	<span class="message">${message}</span>
</c:if>

<table class="table" style="width: 500px; margin: auto;">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Name</th>
			<th style="width: 150px;"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${chemicalPrimaryCodes}" var="ch" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${ch.name}</td>
				<td style="text-align: center;">
					<a href='<spring:url value="/chemicalinv/primary/edit/${ch.id}"></spring:url>'>Edit</a>
					&nbsp;&nbsp;
					<a href='<spring:url value="/chemicalinv/primary/delete/${ch.id}"></spring:url>'>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

			</div>

		</div>


	</div>
<script type="text/javascript">
$(function(){
	$('#saveBtn').click(function(){
		var name=$('input[name=name]').val();
		if($.trim(name)==''){
			alert('Enter primary code name.');
			return false;
		}
		return true;
	});
});
</script>
</body>
</html>
