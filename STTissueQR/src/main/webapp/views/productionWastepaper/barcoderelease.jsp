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
.table td{
text-align: center;
}
</style>
</head>
<body>
<jsp:include page="../_loader.jsp"/>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">ST Tissue - BARCODE RELEASE REPORT</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/barcoderelease/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
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
								<c:if test="${viewFlag}">
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
								</c:if>
							</td>
						</tr>
					</table>
				</form>
				</form>
				</div>
				
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${viewFlag}">
<form id="exportFrom" action='<spring:url value="/barcoderelease/export"/>' method="get" style="display:none; " target="_blank">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate}">
</form>


<table class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td>Receipt No</td>
			<td>MasterPO</td>
			<td>Release No</td>
			<td><div style="width: 150px;">Vandor Name</div></td>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
