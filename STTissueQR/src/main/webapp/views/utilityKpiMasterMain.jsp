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
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">PULP AND UTILITY CONSUMPTION REPORT</h5></div>
		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
				<div class="table-selector"style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">

					<table style="margin: auto;">
						<tr>
							<td>Select Data Entry Page</td>
							<td><select name="type" style="width: 150px; padding: 2px;">
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
							<td>&nbsp; <c:if test="${page eq 'U'}">
									<button id="addRowBtn">Add Row</button>
									&nbsp;&nbsp;
									<button id="deleteRowBtn">Delete</button>
								</c:if> <c:if test="${page eq 'M'}">
									<button id="addRowBtn">Add Row</button>
									<button onclick="location.href='<spring:url value="/utilitykpimaster/masterbackdatedentry"/>'">Back Dated Entry</button>
							</td> 
							<td>
									<button id="deleteRowBtn">Delete</button>
							</td>
								</c:if>
							

						</tr>
					</table>

				</div>
				<br>
				<div>

					<!-- Utility Page -->
					<c:if test="${page eq 'U'}">
						<jsp:include page="utilityKpiMasterNewUtility.jsp" />
					</c:if>

					<!-- Master Page -->
					<c:if test="${page eq 'M'}">
						<jsp:include page="utilityKpiMasterNewMaster.jsp" />
					</c:if>
					
					<!-- KPI -->
					<c:if test="${page eq 'K'}">
							<jsp:include page="utilityKpiMasterNewKpiRDate.jsp" />
					</c:if>


				</div>


			</div>

		</div>


	</div>

</body>
</html>
