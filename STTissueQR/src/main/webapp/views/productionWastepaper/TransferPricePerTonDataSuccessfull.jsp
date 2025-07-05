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
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
						<span class="label">Transfer Price Per Ton Data Successfully</span>
				</div>
				<div class="table-selector">
					
					<spring:url value="/transferpricepertondata/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get">	
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
								&nbsp;
								&nbsp;	
							</td>
						</tr>
					</table>
				</form>

				</div>

<c:if test="${transferdone}">
<br><br>
<center>
<table>
	<tr>
		<td>
			<p><center><b style="font-size: 40px;color: green;">Price Per Ton</b></center></p>
		</td>
	</tr>
	<tr>
		<td>
			<p><b style="font-size: 40px;color: green;"> From </b> <b style="font-size: 40px;color: red;"> ${sdate} </b> <b style="font-size: 40px;color: green;">To</b><b style="font-size: 40px;color: red;"> ${edate}</b></p>
		</td>
	</tr>
	<tr>
		<td>
			<p><b style="font-size: 40px;color: green;">Has Been Transfered Successfully.</b></p>
		</td>
	</tr>
</table>
</center>
</c:if>

			</div>

		</div>


	</div>

</body>
</html>
