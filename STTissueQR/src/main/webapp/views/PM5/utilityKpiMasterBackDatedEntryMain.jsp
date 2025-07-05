<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
.table td {
	padding: 0px !important;
}

.table td input {
	text-align: center;
	width: inherit !important;
}

.ucell {
	color: green;
	font-weight: bold;
}

.subtr th {
	font-size: 11px !important;
	font-weight: normal;
}
</style>

<spring:url value="/pm5utilitykpimaster/new" var="newURL" />
<script type="text/javascript">
	$(function() {
		$('select[name=type]').change(function() {
			var val = $(this).val();
			if (val != '') {
				location.href = '${newURL}/' + val;
			} else {
				location.href = '${newURL}';
			}
		});
	});
</script>
<spring:url value="/pm5utilitykpimaster/masterbackdatedentry/report" var="oldDataURL" />
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
	

	$('#loadDataBtn').click(function(){
		var odate=$('input[name=sdate]').val();
		var edate=$('input[name=edate]').val();
		location.href='${oldDataURL}/'+odate+'/'+edate;
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
					<span class="label">PM5 PULP AND UTILITY CONSUMPTION REPORT- Back Dated Entry</span>
				</div>
				<br>
				<div class="table-selector">
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
								<button id="loadDataBtn">Edit</button>
							</td>
							<c:if test="${page eq 'M'}">
								<td><button id="addRowBtn">Add Row</button></td>
							</c:if>
							<c:if test="${page eq 'M'}">
								<td><button id="deleteRowBtn">Delete</button></td>
							</c:if>
						</tr>
					</table>
	
				</div>
				<br>
				<div>

					<!-- Utility Page -->
					<c:if test="${page eq 'U'}">
						<jsp:include page="../PM5/utilityKpiMasterNewUtility.jsp" />
					</c:if>

					<!-- Master Page -->
					<c:if test="${page eq 'M'}">
						<jsp:include page="../PM5/utilityKpiMasterNewMaster_backDateData.jsp" />
					</c:if>
					
					<!-- KPI -->
					<c:if test="${page eq 'K'}">
							<jsp:include page="../PM5/utilityKpiMasterNewKpiRDate.jsp" />
					</c:if>


				</div>


			</div>

		</div>


	</div>

</body>
</html>
