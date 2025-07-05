<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">
			
			
				<div class="page-title">
					<span class="label">Shift Schedules - Upload</span>
				</div>
				
			
				
				
				<div class="table-selector">
				<spring:url value="/staticdata/upload" var="uploadURL"/>
					<form action="${uploadURL}"  method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>Select Excel File:-</td>
							<td>
								<input type="file" name="file">
							
							</td>
							<td>
								<input type="submit" value="Upload">
							</td>
							<td>
									<c:if test="${not empty  error}">
										<span class="error">${error}</span>
									</c:if>
									
									<c:if test="${not empty  message}">
										<span class="message">${message}</span>
									</c:if>
							</td>
						</tr>
					</table>

					</form>
				</div>

			</div>

		</div>


	</div>

</body>
</html>
