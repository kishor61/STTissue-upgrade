<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

</head>
<body>

	<div class="container">

		<div class="block1">
			<security:authorize access="hasAnyRole('ADMIN,OPERATOR,OPERATOR2')">
				<jsp:include page="../header.jsp"></jsp:include>
			</security:authorize>
			<security:authorize access="hasAnyRole('OPERATOR3')">
				<jsp:include page="../productionWastepaper/prod_header.jsp"></jsp:include>
			</security:authorize>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Tracker database is under maintenance. Please try after 2 minutes.</span>
				</div>
				<br>
				Requested URL= ${url}<br><br>
	 			
	 			<span class="error">
				Error message= ${exception.message}<br>
				<br>
				<%-- <c:if test="${not empty url}">
				<a style="color: green;" href="${url}?${query}">Back</a>
				</c:if> --%>
				<br>
				<br>
				 </span>
				<strong>Exception Stack Trace</strong><br>
				<c:forEach items="${exception.stackTrace}" var="ste">
				    ${ste}<br>
				</c:forEach>
				</div>

		</div>


	</div>

</body>
</html>
