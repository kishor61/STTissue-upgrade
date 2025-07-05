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
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<style type="text/css">
.hkmain {
    background-color: rgb(219, 195, 163);
    font-weight: bold;
    text-align: center;
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
					<span class="label">Uploaded-Incidental Document Action(s)</span>
				</div>
				<div class="table-selector">
					
					<spring:url value="/incidentaluser/report/reviewedactions/show" var="viewURL"/>
					<form action="${viewURL}" method="get">	
						<table style="margin: auto;">
							<tr>
								<td>Start Date:</td>
								<td>
									<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
								</td>
								<td>End Date:</td>
								<td>
									<input readonly="readonly" type="text" name="edate" value="${edate}">							
								</td>
								<td>
									<input id="viewDataBtn" type="submit" value="View">
								</td>
								<c:if test="${pdf}">
								<td>
									&nbsp;&nbsp;&nbsp;
									<a href='<spring:url value="/incidentaluser/report/reviewedactions/show/pdf?sdate=${sdate}&edate=${edate}"/>' target="_blank">PDF</a>	
								</td>
								</c:if>
							</tr>
						</table>
					</form>

				</div>
				<div
					style="padding: 2px; overflow: auto; position: fixed; bottom: 0; left: 5px; right: 5px; top: 150px;">

					<c:if test="${show}">

						<table class="table" style="width: 900px; margin: auto;">

							<c:forEach items="${details}" var="data">
									<tr>
										<!-- <td class="hkmain" colspan="5" style="font-weight: bold; text-align: center;">Description</td>
										<td class="hkmain" colspan="3" style="font-weight: bold; text-align: center;">Action</td> -->
										<td class="hkmain" colspan="8" style="font-weight: bold; text-align: center;">Description</td>
										<!-- <td class="hkmain" colspan="3" style="font-weight: bold; text-align: center;">Action</td> -->
									</tr>
									<tr>

										<td colspan="8">${data.description }</td>
										<!-- <td colspan="1"></td> -->
									</tr>
									<tr style="background-color: #bdbdbd80;">
										<td class="hkhead" style="text-align: center;"><div style="width: 100px;"><b>Upload Date</b></div></td>
										<td class="hkhead" style="text-align: center;"><div style="width: 100px;"><b>Subject</b></div></td>
										<td class="hkhead" style="text-align: center;"><b>Reviewed By</b></td>
										<td class="hkhead" style="text-align: center;"><b>Review Date</b></td>
										<td class="hkhead" style="text-align: center;"><div style="width: 100px;"><b>Comment</b></div></td>
										<!-- <td class="hkhead" style="text-align: center;"><div style="width: 80px;">Download Attachment</div></td> -->

									</tr>
										<c:forEach items="${details1}" var="data1">
									<c:if test="${data1.id eq data.id}"> 
									<tr>
										<td>${data.date }</td>
										<td>${data.subject }</td>
										<td>${data1.name }</td>
										<td>${data1.reviewdate}</td>
										<td>${data1.comment }</td>
										<%-- <td><center><b><a href='<spring:url value="/incidentaluser/view/data/downloadfile/${data.id}"/>' target="_blank">Download</a></b></center></td> --%>
									</tr>
									
									</c:if>
									</c:forEach>
									
									<tr>
										<td colspan="8"><b>Document No Reviewed By:</b>
											<div style="height: 70px;">
														${data.notrevieduser}
											</div>
										</td>
									</tr>
									<tr style="background-color: #eaec5b54;">
										<td colspan="8">&nbsp;
											<div style="height: 20px;"></div>
										</td>
									</tr>


							



							</c:forEach>

						</table>
					</c:if>

				</div>
			</div>

		</div>


	</div>

</body>
</html>
