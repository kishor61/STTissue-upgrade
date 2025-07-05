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
	padding: 2px !important;
}

.table td div {
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

.table tfoot td {
	font-weight: bold;
	color: #505050;
	text-align: center;
}
</style>

<spring:url value="/pm5utilitykpimaster/new" var="newURL" />
<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});

		$('#viewBtn').click(function() {
			var type = $('select[name=type]').val();
			if (type == '') {
				alert('Select report type.');
				return false;
			} else {
				return true;
			}
		});

	});
</script>
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
					<span class="label">PULP AND UTILITY CONSUMPTION REPORT For PM5</span>
				</div>
				<br>
				<div class="table-selector">

					<spring:url value="/pm5utilitykpimasterreport/view/data"
						var="viweDataURL" />
					<form name="dataForm" action="${viweDataURL}" method="get">
						<table style="margin: auto;">
							<tr>
								<td>Start Date</td>
								<td><input type="text" name="sdate" value="${sdate}"
									readonly="readonly" style="width: 80px;"></td>
								<td>End Date</td>
								<td><input type="text" name="edate" value="${edate}"
									readonly="readonly" style="width: 80px;"></td>
								<td>Select Report Type</td>
								<td><select name="type" style="width: 90px; padding: 2px;">
										<option value="">Select</option>
										<c:forEach items="${pages}" var="p">
											<c:choose>
												<c:when test="${p.key eq page}">
													<option value="${p.key}" selected="selected">${p.value }</option>
												</c:when>
												<c:otherwise>
													<option value="${p.key}">${p.value}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select></td>
								<td><input type="submit" id="viewBtn" value="View">
									&nbsp; <c:if test="${page eq 'U'}">

										<input type="button" id="editBtn" value="Edit">
									
									&nbsp;&nbsp;
									<input type="button" id="deleteRowBtn" value="Delete">
									
									&nbsp;
									<input type="button" id="exportRowBtn" value="Export">

									</c:if>
									 <c:if test="${page eq 'M'}">

										<input type="button" id="editBtn" value="Edit">
									
									&nbsp;&nbsp;
									<input type="button" id="deleteRowBtn" value="Delete">
									
									&nbsp;
									<input type="button" id="exportRowBtn" value="Export">
									
									</c:if>
 									
 									<c:if test="${page eq 'K'}">
										&nbsp;
										<input type="button" id="exportRowBtn" value="Export">
										&nbsp;
										<input type="button" value="Send Mail" id="sendMailBtn">
										&nbsp;|&nbsp;
										
										<a href='<spring:url value="/pm5utilitykpimasterreport/exportkpi/pdf?type=${page}&sdate=${sdate}&edate=${edate}"/>' target="_blank">PDF</a>
										
									</c:if>

									
									</td>

							</tr>
						</table>
					</form>
				</div>
				<br>
				<div>

					<!-- Utility Page -->
					<c:if test="${page eq 'U'}">
						<jsp:include page="../PM5/utilityKpiMasterViewUtility.jsp" />
					</c:if>

					<!-- Master Page -->
					<c:if test="${page eq 'M'}">
						<jsp:include page="../PM5/utilityKpiMasterViewMaster.jsp" />
					</c:if>

					<!-- KPI -->
					<c:if test="${page eq 'K'}">
						<jsp:include page="../PM5/utilityKpiMasterViewKPI.jsp" />
					</c:if>

				</div>


			</div>

		</div>


	</div>

</body>
</html>
