<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Error</span>
				</div>
				
				<div>
					<span style="font-size: 16px;" class="error"> ${error}</span>
					<br>
					<button onclick="window.history.back()" >Back</button>
				</div>

			</div>

		</div>


	</div>

</body>
</html>
