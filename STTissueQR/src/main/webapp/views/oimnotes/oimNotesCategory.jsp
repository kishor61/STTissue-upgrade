<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
					<span class="label">Process Improvement Meeting Notes - Category</span>
				</div>
				<br>
				<spring:url value="/oimnotes/category/save" var="saveURL"/>
				<form:form action="${saveURL}" modelAttribute="category">
					<table>
						<tr>
							<td>Category</td>
							<td><form:input path="category" maxlength="50"/><td>
							<td>
								<input type="submit" value="Save" id="saveBtn">
								<form:hidden path="id"/>
							<td>
						</tr>
					</table>
				</form:form>
				
				<br>
				<script type="text/javascript">
			$(function(){
				$('#saveBtn').click(function(){
					var cat=$('input[name=category]').val();
					if(!cat){
						alert('Please enter category!');
						return false;
					}
				});
			});
		</script>
		
		<c:if test="${not empty error }">
			<span class="error">${error}</span>
		</c:if>
		<c:if test="${not empty message }">
			<span class="message">${message}</span>
		</c:if>
		<br>
		
		
		<table class="table" style="width: 98%;">
			<thead>
				<tr>
					<th>Category</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="ctg">
					<tr>
						
						<td><div style="width: 150; display: block;" >${ctg.category}</div></td>
						<td><div style="display: block;width: auto;text-align: center;">
							<a href='<spring:url value="/oimnotes/category/edit/${ctg.id}"/>'>Edit</a>
						 </div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

			</div>

		</div>


	</div>

</body>
</html>
