<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/clrewinder/breakreason1/save" var="saveBreakReasonURL" />
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
							<td>Primary Reason</td>
							<td>
								<select name="primaryreason">
									<option value="">Select </option>
									<c:forEach items="${moniterbreakreason}" var="mbrare">
												<option value="${mbrare.reasonforbreak}">${mbrare.reasonforbreak}</option>
									</c:forEach>
								</select>
							</td>
							<td>Secondary Reason</td>
							<td><input type="text" name="secondaryreason" value="" style="width: 200px;"></td>
							<td></td>
							<td><input type="submit" id="viewbutton" name="viewbutton" value="Add" onclick="return formSubmit(); return false"></td>
							</form>
						</tr>
						</c:if>
						<c:if test="${editpage}">
							<c:forEach items="${editBreakReason}" var="ebr">
							<form action="${saveBreakReasonURL}" method="POST" name="add_form">
								<td>Primary Code:</td>
								<td>
									<select name="primaryreason">
										<option value="">Select</option>
										<c:forEach items="${moniterdatas}" var="mbrare">
											<c:choose>
												<c:when test="${ mbrare.reasonforbreak eq primaryCode}">
													<option value="${mbrare.reasonforbreak}" selected="selected">${mbrare.reasonforbreak}</option>
												</c:when>
												<c:otherwise>
													<option value="${mbrare.reasonforbreak}">${mbrare.reasonforbreak}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<td>Secondary Code:</td>
								<td><input type="hidden" name="id" value="${ebr.id}" style="width: 200px;"></td>
								<td><input type="text" name="secondaryreason" value="${ebr.secondarycode}" style="width: 200px;"></td>
								<td></td>
								<td><input type="submit" id="viewbutton" name="viewbutton" value="Edit" onclick="return formSubmit(); return false"></td>
							</form>
							</c:forEach>
						</c:if>
					</table>
				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${view}">
<c:if test="${fn:length(secondaryReason) > 0 }">
<center>	
<div><b style="color:green; ">${message}</b></div>	
<table border="1" style="border-collapse:collapse;border:2px solid #000000;color:#000000;width:50%" cellpadding="3" cellspacing="3">
	<tr>
		<td style="background-color:#DEB887;"><center><b>Primary Code</b></center></td>
		<td style="background-color:#DEB887;"><center><b>Secondary Code</b></center></td>
		<td style="background-color:#DEB887;"><center><b>Edit Secondary Code</b></center></td>
		<td style="background-color:#DEB887;"><center><b>Delete Secondary Code</b></center></td>
	</tr>
	<c:forEach items="${secondaryReason}" var="mbr">
	<tr>
		<td style="background-color: #FFF8DC;"><b>${mbr.primarycode}</b></td>
		<td style="background-color:#FFF8DC;"><center><b>${mbr.secondarycode}</b></center></td>
		<td style="background-color: #FFF8DC;"><center><a href='<spring:url value="/clrewinder/breakreasonsecondary/edit/${mbr.id}"/>'><b style="color: green;">Edit</b></a></center></td>
		<td style="background-color: #FFF8DC;"><center><a href='<spring:url value="/clrewinder/breakreasonsecondary/delete/${mbr.id}"/>'><b style="color: red;">Delete</b></a></center></td>
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
