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
				<div class="page-title">
					<span class="label">Centerline Data</span>
				</div>
				<br>
				<div class="table-selector">

					<table>
						<tr>
							<td>
								<spring:url value="/centerline/new" var="newURL"/>
								<spring:url value="/centerline/view" var="viewURL"/>
								<spring:url value="/centerline/edit" var="editURL"/>
								
								<button onclick="window.location='${newURL}'">New</button> &nbsp;&nbsp;
								<button onclick="window.location='${viewURL}'">View</button> &nbsp;&nbsp;
								<button onclick="window.location='${editURL}'">Edit</button> &nbsp;&nbsp;
								
							</td>
						</tr>
					</table>

				</div>


			</div>
		</div>


	</div>
</body>
</html>
