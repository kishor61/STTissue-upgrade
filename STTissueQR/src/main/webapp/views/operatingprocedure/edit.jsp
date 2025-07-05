<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
</head>
<body style="overflow: auto;background: white;">

<c:if test="${not empty error}">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

<spring:url value="/operatingprocedure/update" var="updateURL"/>
<form action="${updateURL}" method="post">
<table>
	<tr>
		<td>File Name</td>
		<td><input name="name" value="${procedure.name}" maxlength="100"> </td>
	</tr>
	<tr>
		<td>Area</td>
		<td>
				<select name="area" style="width: 150px; padding: 3px;"
					required="required">
						<option value="-1">Select</option>
						<c:forEach items="${areas}" var="are">
							<c:choose>
								<c:when test="${procedure.area eq are.area}">
									<option value="${are.area}" selected="selected">${are.area}</option>
								</c:when>
								<c:otherwise>
									<option value="${are.area}">${are.area}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
		</td>
	</tr>
	<tr>
		<td>Category</td>
		<td><input name="type" value="${procedure.type}" maxlength="100"> </td>
	</tr>
	<tr>
		<td>Sub Category</td>
		<td><input name="subType" value="${procedure.subType}" maxlength="100"> </td>
	</tr>
	<tr>
		<td><input type="hidden" name="id" value="${procedure.id}"> </td>
		<td><input type="submit" value="SAVE"></td>
	</tr>
</table>
</form>
<spring:url value="/operatingprocedure/category/types" var="cattypeURL"/>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:'${cattypeURL}',
			success:function(data){
				
				 $("input[name=type]").autocomplete({
				      source: data.types
				 });
				 $("input[name=subType]").autocomplete({
				      source: data.subTypes
				 });
			}
		});
	});
</script>

</body>
</html>
