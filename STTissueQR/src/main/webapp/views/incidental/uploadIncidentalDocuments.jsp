<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<style type="text/css">
.button {
   border: 1px solid #0a3c59;
   background: #3e779d;
   background: -webkit-gradient(linear, left top, left bottom, from(#65a9d7), to(#3e779d));
   background: -webkit-linear-gradient(top, #65a9d7, #3e779d);
   background: -moz-linear-gradient(top, #65a9d7, #3e779d);
   background: -ms-linear-gradient(top, #65a9d7, #3e779d);
   background: -o-linear-gradient(top, #65a9d7, #3e779d);
   background-image: -ms-linear-gradient(top, #65a9d7 0%, #3e779d 100%);
   padding: 9.5px 19px;
   -webkit-border-radius: 0px;
   -moz-border-radius: 0px;
   border-radius: 0px;
   -webkit-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   -moz-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   text-shadow: #7ea4bd 0 1px 0;
   color: white;
   font-size: 15px;
   font-family: helvetica, serif;
   text-decoration: none;
   vertical-align: middle;
   }
.button:hover {
   border: 1px solid #0a3c59;
   text-shadow: #1e4158 0 1px 0;
   background: #3e779d;
   background: -webkit-gradient(linear, left top, left bottom, from(#65a9d7), to(#3e779d));
   background: -webkit-linear-gradient(top, #65a9d7, #3e779d);
   background: -moz-linear-gradient(top, #65a9d7, #3e779d);
   background: -ms-linear-gradient(top, #65a9d7, #3e779d);
   background: -o-linear-gradient(top, #65a9d7, #3e779d);
   background-image: -ms-linear-gradient(top, #65a9d7 0%, #3e779d 100%);
   color: #fff;
   }
.button:active {
   text-shadow: #1e4158 0 1px 0;
   border: 1px solid #0a3c59;
   background: #65a9d7;
   background: -webkit-gradient(linear, left top, left bottom, from(#3e779d), to(#3e779d));
   background: -webkit-linear-gradient(top, #3e779d, #65a9d7);
   background: -moz-linear-gradient(top, #3e779d, #65a9d7);
   background: -ms-linear-gradient(top, #3e779d, #65a9d7);
   background: -o-linear-gradient(top, #3e779d, #65a9d7);
   background-image: -ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%);
   color: #fff;
   }
</style>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">
			
			
				<div class="page-title">
					<span class="label">Upload-Incidental Documents</span>
				</div>
				
			
				
				
				<div class="table-selector"><b>UPLOAD-INCIDENTAL DOCUMENTS</b>
				<%-- <spring:url value="/incidentaluser/save/action" var="uploadURL"/>
					<form action="${uploadURL}"  method="post" enctype="multipart/form-data"> --%>
					<%-- <form action='<spring:url value="/incidentaluser/save/action"/>' method="post" enctype="multipart/form-data"> --%>
					<%-- <spring:url value="/incidentaluser/save/action" var="uploadURL"/>
					<form action="${uploadURL}"  method="post" enctype="multipart/form-data">
					<table>
						<tr>
							
							<td>Subject Of Document:</td>
							<td>
								<input type="text" name="comment" value="${auditor.comment}">
							
							</td>
							
							<td>Select File:-</td>
							<td>
								<input type="file" name="file" value="${auditor.file}">
							
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

					</form> --%>
				</div>

			</div>
			</br> </br> </br> </br> </br>
			<center>
				<spring:url value="/incidentaluser/save/action" var="uploadURL"/>
				<form action="${uploadURL}"  method="post" enctype="multipart/form-data">
				<table style="width: 50%;" border="2" cellpadding="4">
					<tbody>
						<tr>
							<td><b>Subject Of Document:</b></td>
							<td><input type="text" name="comment" value="${auditor.comment}" style="margin: 0px;width: 642px;height: 35px;" required="required"></td>
						</tr>
						<tr>
							<td><b>Select File:</b></td>
							<td><input type="file" name="file" value="${auditor.file}" required="required"></td>
						</tr>
						<tr>
							<td><b>Description:</b></td>
							<td><textarea name="description" style="margin: 0px; width: 642px; height: 128px;" required="required"></textarea></td>
						</tr>
						<tr>
							<td>
									<c:if test="${not empty  error}">
										<span class="error">${error}</span>
									</c:if>
									
									<c:if test="${not empty  message}">
										<span class="message">${message}</span>
									</c:if>
							</td>
							<td><center><input type="submit" value="Send Mail" class="button"></center></td>
						</tr>
					</tbody>
				</table>
				</form>
				<!-- DivTable.com -->
			</center>
			<!-- DivTable.com -->
		</div>


	</div>

</body>
</html>
