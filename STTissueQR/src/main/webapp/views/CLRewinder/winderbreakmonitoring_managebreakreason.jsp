<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/clrewinder/breakreason/save" var="saveBreakReasonURL" />
<script>
function formSubmit()
{
    var breakreason=document.forms["add_form"]["breakreason"].value;
    if (breakreason=="")
    {
    	alert("Please Enter The Reason Of Break.");
         return false;
    }
    return true;
}
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
					<span class="label">Winder Break Monitoring - Manage Reason For Breaks</span>
				</div>
				<div class="table-selector">
						<table>
						<c:if test="${viewpage}">
						<tr>
							<form action="${saveBreakReasonURL}" method="POST" name="add_form">
							<td>Reason Of Breaks:</td>
							<td><input type="text" name="breakreason" value="" style="width: 200px;"></td>
							<td></td>
							<td><input type="submit" id="viewbutton" name="viewbutton" value="Add" onclick="return formSubmit(); return false"></td>
							</form>
						</tr>
						</c:if>
						<c:if test="${editpage}">
							<c:forEach items="${editBreakReason}" var="ebr">
							<form action="${saveBreakReasonURL}" method="POST" name="add_form">
								<td>Reason Of Breaks:</td>
								<td><input type="hidden" name="id" value="${ebr.id}" style="width: 200px;"></td>
								<td><input type="text" name="breakreason" value="${ebr.reasonforbreak}" style="width: 200px;"></td>
								<td></td>
								<td><input type="submit" id="viewbutton" name="viewbutton" value="Edit" onclick="return formSubmit(); return false"></td>
							</form>
							</c:forEach>
						</c:if>
					</table>
				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${view}">
<c:if test="${fn:length(moniterbreakreason) > 0 }">
<center>	
<div><b style="color:green; ">${message}</b></div>	
<table border="1" style="border-collapse:collapse;border:2px solid #000000;color:#000000;width:50%" cellpadding="3" cellspacing="3">
	<tr>
		<td style="background-color:#DEB887;"><center><b>Reason Of Breaks</b></center></td>
		<td style="background-color:#DEB887;"><center><b>Edit Primary Code</b></center></td>
		<td style="background-color:#DEB887;"><center><b>Delete Primary Code</b></center></td>
	</tr>
	<c:forEach items="${moniterbreakreason}" var="mbr">
	<tr>
		<td style="background-color: #FFF8DC;"><b>${mbr.reasonforbreak}</b></td>
		<td style="background-color: #FFF8DC;"><center><a href='<spring:url value="/clrewinder/breakreason/edit/${mbr.id}"/>'><b style="color: green;">Edit</b></a></center></td>
		<td style="background-color: #FFF8DC;"><center><a href='<spring:url value="/clrewinder/breakreason/delete/${mbr.id}"/>'><b style="color: red;">Delete</b></a></center></td>
	</tr>
	</c:forEach>
</table>
</center>
</c:if>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
