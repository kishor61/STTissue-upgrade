<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('button[type=submit]').click(function(){
			var val=$('select[name=type]').val();
			if(val==''){
				alert('Please select type!')
				return false;
			}
			return true;
		});
	});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Manage Area</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/area/save" var="saveURL"/>
					<form action="${saveURL}" method="post">
						<table>
							<tr>
								<td>Name</td>
								<td>
									<input type="text" name="name" value="${area.name}">
								</td>
								<td>Type</td>
								<td>
									<select name="type">
										<option value="">Select</option>
										<c:forEach items="${types}" var="type">
											<c:choose>
												<c:when test="${area.type eq type.key}">
													<option value="${type.key}" selected="selected">${type.value}</option>
												</c:when>
												<c:otherwise>
													<option value="${type.key}">${type.value}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<td>
									<button type="submit">Save</button>
									<input type="hidden" name="id" value="${area.id}">
									<spring:url value="/area/manage" var="newURL" />
									
									<c:if test="${area.id gt 0}">
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
			<th>Area Name</th>
			<th>Area Type</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${areas}" var="ar" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${ar.name}</td>
				<td>${types[ar.type]}</td>
				<td>
					<a href='<spring:url value="/area/edit/${ar.id}"></spring:url>'>Edit</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

			</div>

		</div>


	</div>

</body>
</html>
