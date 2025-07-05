<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>



<style type="text/css">
.table-selector td {
	vertical-align: middle;
	text-align: left;
}

.table thead th {
	font-size: 10px;
}

.table tbody td {
	text-align: center;
}

@MEDIA print {
	.no-print,.no-print * {
		display: none !important;
	}
}
</style>

<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		$('select[name=pcode]').change(function() {
			$('select[name=scode]').val('');
		});
		$('select[name=scode]').change(function() {
			var element = $(this).find('option:selected'); 
			if(element.attr('data-pid')){
				$('select[name=pcode]').val(element.attr('data-pid'));
			}else{
				$('select[name=pcode]').val('');
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
					<span class="label">Efficiency- Report</span>
				</div>
				<br> <span class="message">${message}</span>

				<div style="padding: 2px;"></div>

				<div class="table-selector">
					<spring:url value="/efficiencyreport/view" var="viewURL" />
					<form action="${viewURL}" method="get">
						<table>
							<tr>
								<td>Start Date: <input type="text" name="sdate"
									value="${sdate}" style="width: 80px;"></td>

								<td>End Date: <input type="text" name="edate"
									value="${edate}" style="width: 80px;"></td>

								<td>Down Time Primary Code <select name="pcode"
									style="width: 170px;">
										<option value="">All</option>
										<c:forEach items="${pcodes}" var="pc">
											<c:choose>
												<c:when test="${pc.id eq pcode}">
													<option value="${pc.id}" selected="selected">${pc.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${pc.id}">${pc.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select>
								</td>

								<td>Down Time Secodary Code <select name="scode"
									style="width: 180px;">
										<option value="">All</option>
										<c:forEach items="${scodes}" var="sc">
											<c:choose>
												<c:when test="${sc.id eq scode }">
													<option value="${sc.id}" selected="selected" data-pid="${sc.primaryCode.id}">${sc.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${sc.id}" data-pid="${sc.primaryCode.id}">${sc.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select></td>

								<td>
								
								<input type="submit" value="Search">
								<c:if test="${fn:length(datas)>0}">
									<input id="printBtn" value="Print" type="button"> &nbsp;
									<input id="editBtn" value="Edit" type="button"> &nbsp;
									<input id="deleteBtn" value="Delete" type="button">  &nbsp;
									<input id="exportBtn" type="button" value="Export">
								</c:if>
								</td>
								<td></td>

							</tr>
						</table>
					</form>
				</div>

				<c:if test="${showTable}">
					<span class="error">${error}</span>
					<br>

					<div id="printDiv">



						<table class="table" style="width: 80%; margin: auto;">
							<thead style="font-size: 10px;">
								<tr>
									<th rowspan="2" class="no-print"></th>
									<th rowspan="2">Date</th>
									<th rowspan="2">Shift</th>
									<th rowspan="2">Crew</th>
									<th rowspan="2">Start<br> Time</th>
									<th rowspan="2">End<br> Time</th>
									<th colspan="2">Duration</th>
									<th rowspan="2">Reel#</th>
									<th rowspan="2">Grade code</th>
									<th rowspan="2">Down Time Secondary Code</th>
									<th rowspan="2">Down Time Primary Code</th>
									<th rowspan="2">Comments</th>
								</tr>
								<tr>
									<th>HH</th>
									<th>MM</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${fn:length(datas)eq 0}">
									<tr>
										<td colspan="11">Record not found for this selection.</td>
									</tr>
								</c:if>

								<c:if test="${fn:length(datas)>0}">
									<c:forEach items="${datas}" var="map">
										<tr>
											<td class="no-print"><input type="radio" name="id"
												value="${map['1']}"></td>
											<td>${map['2']}</td>
											<td>${map['3']}</td>
											<td>${map['4']}</td>
											<td>${map['5']}</td>
											<td>${map['6']}</td>
											<td>${map['12']}</td>
											<td>${map['13']}</td>
											<td>${map['7']}</td>
											<td>${map['8']}</td>
											<td>${map['10']}</td>
											<td>${map['11']}</td>
											<td>${map['9']}</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="3"></td>
									<td colspan="3" align="right"><b>Total Duration</b> </td>
									<td style="text-align: center;">${totalhh}</td>
									<td style="text-align: center;">${totalmm}</td>
									<td colspan="5"></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</c:if>
			</div>
			<br>
			<c:if test="${fn:length(datas)>0}">
				<div class="table-selector" style="display: none;">
					<table style="width: 100%;">
						<tr>
							<td style="text-align: center;"><spring:url
									value="/efficiencyreport/export" var="exportURL" />
								<form id="exportForm" style="display: inline;" action="${exportURL}"
									method="post">
									<input type="hidden" name="sdate" value="${sdate}"> <input
										type="hidden" name="edate" value="${edate}"> <input
										type="hidden" name="pcode" value="${pcode}"> <input
										type="hidden" name="scode" value="${scode}"> 
								</form> &nbsp;
								
						</tr>
					</table>
				</div>
				<spring:url value="/efficiency/edit" var="editURL" />
				<spring:url value="/efficiency/delete" var="deleteURL" />
				<script type="text/javascript">
					$(function() {
						$('#editBtn')
								.click(
										function() {
											var val = $(
													'input[name=id]:checked')
													.val();
											if (val) {
												location.href = '${editURL}/'
														+ val + location.search;
											} else {
												alert('Select row.');
											}
										});

						$('#deleteBtn')
								.click(
										function() {
											var val = $(
													'input[name=id]:checked')
													.val();
											if (val) {
												$
														.ajax({
															url : '${deleteURL}',
															type : 'POST',
															data : {
																id : val
															},
															success : function(
																	data) {
																if (data.status) {
																	alert('Data removed successfully.');
																	location
																			.reload(true);
																} else {
																	alert('Fail to delete data from database.');
																	location
																			.reload(true);
																}
															}
														});
											} else {
												alert('Select row.');
											}
										});

						$('#printBtn').click(function() {

							$('#printDiv').printArea({
								retainAttr : [ 'class', 'style' ]
							});
						});
						
						$('#exportBtn').click(function(){
							$('#exportForm').submit();
						});

					});
				</script>

			</c:if>
		</div>
	</div>

</body>
</html>
