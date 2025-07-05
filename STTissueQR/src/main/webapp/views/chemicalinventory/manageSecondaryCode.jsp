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
					<span class="label">Secondary Chemical Code</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/chemicalinv/secondary/save" var="saveURL"/>
					<form action="${saveURL}" method="post">
						<table>
							<tr>
								<td>Name</td>
								<td>
									<input type="text" name="name" value="${chemicalSecondaryCode.name}">
								</td>
								<td>Primary Code</td>
								<td>
									<select name="pid" style="width: 150px; padding: 3px;">
										<option value="">Select</option>
										<c:forEach items="${chemicalPrimaryCodes}" var="pcode">
										
											<c:choose>
												<c:when test="${pcode.id eq chemicalSecondaryCode.pid}">
													<option value="${pcode.id}" selected="selected">${pcode.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${pcode.id}">${pcode.name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<td>
									<button type="submit" id="saveBtn">Save</button>
									<input type="hidden" name="id" value="${chemicalSecondaryCode.id}">
									<spring:url value="/chemicalinv/secondary/manage" var="newURL" />
									
									<c:if test="${chemicalSecondaryCode.id gt 0}">
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
			<th>Primary Chemical</th>
			<th style="width: 150px;"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${chemicalSecondaryCodes}" var="sc" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${sc.name}</td>
				<td>${sc.primaryCode}</td>
				<td style="text-align: center;">
					<a href='<spring:url value="/chemicalinv/secondary/edit/${sc.id}"></spring:url>'>Edit</a>
					&nbsp;&nbsp;
					<a href='<spring:url value="/chemicalinv/secondary/delete/${sc.id}"></spring:url>'>Delete</a>
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
			alert('Enter code name.');
			return false;
		}
		
		var pid=$('select[name=pid]').val();
		if($.trim(pid)==''){
			alert('Select primary code.');
			return false;
		}
		return true;
	});
});
</script>
</body>
</html>
