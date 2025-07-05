<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
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

<spring:url value="/utilitykpimaster/new" var="newURL" />
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
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">PULP AND UTILITY CONSUMPTION REPORT</span>
				</div>
				<br>
				<div class="table-selector">

					<table style="margin: auto;">
						<tr>
							<td><b>Edit:- ${pages[page]}</b></td>
							<td>&nbsp;

								<spring:url value="/utilitykpimasterreport/view/data" var="backPath"/>
								
								<button onclick="window.location.href='${backPath}?${backParam}'">Back to Report</button>
							</td>

						</tr>
					</table>

				</div>
				<br>
				<div>

<!-- Utility Page -->
<c:if test="${page eq 'U'}">
	<jsp:include page="utilityKpiMasterEditUtility.jsp" />
</c:if>

<!-- Master Page -->
<c:if test="${page eq 'M'}">
	<jsp:include page="utilityKpiMasterEditMaster.jsp" />
</c:if>

<!-- KPI -->

				</div>


			</div>

		</div>


	</div>

</body>
</html>
