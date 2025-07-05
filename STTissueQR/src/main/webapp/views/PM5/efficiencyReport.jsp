<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

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

<style type="text/css">
.search-form-container {
    background-color: #fff;
    border: 1px solid #e0e0e0;
    border-radius: 12px;
    padding: 24px 32px;
    margin-bottom: 24px;
    box-shadow: 0 2px 8px rgba(33, 150, 191, 0.08);
    max-width: 1200px;
    margin-left: 212px;
    margin-right: auto;
}

.page-header {
    text-align: center;
    margin: 20px auto 30px;
    color: #2196bf;
    font-size: 26px;
    font-weight: 600;
    width: 100%;
    padding: 10px 0;
    text-transform: uppercase;
    letter-spacing: 0.5px;
	margin-left: 500px;
}

.message {
    display: block;
    text-align: center;
    margin: 10px 0 20px;
    color: #f44336;
    font-weight: 500;
}

.search-form-container .form-group {
    margin-bottom: 15px;
    text-align: center;
}

.search-form-container label {
    color: #2196bf;
    font-weight: 600;
    margin-bottom: 6px;
    display: block;
    text-align: center;
}

.search-form-container .form-control {
    border: 1.5px solid #bcdff1;
    border-radius: 6px;
    padding: 8px 12px;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
    text-align: center;
    background-color: #f4fbfd;
    color: #222;
    font-size: 1rem;
}

.search-form-container .form-control:focus {
    border-color: #2196bf;
    box-shadow: 0 0 0 2px rgba(33,150,191,0.12);
    background-color: #ffffff;
}

.search-form-container .btn {
    padding: 10px 16px;
    font-weight: 600;
    margin: 5px;
    min-width: 110px;
    border: none;
    border-radius: 6px;
    font-size: 1rem;
}

.search-form-container .btn-primary {
    background-color: #2196bf;
    color: #fff;
}

.search-form-container .btn-primary:hover {
    background-color: #176d8c;
}

.search-form-container .btn-info {
    background-color: #00bcd4;
    color: #fff;
}

.search-form-container .btn-info:hover {
    background-color: #0097a7;
}

.search-form-container .btn-warning {
    background-color: #ffc107;
    color: #333;
}

.search-form-container .btn-warning:hover {
    background-color: #ff9800;
    color: #fff;
}

.search-form-container .btn-danger {
    background-color: #f44336;
    color: #fff;
}

.search-form-container .btn-danger:hover {
    background-color: #c62828;
}

.search-form-container .btn-success {
    background-color: #4caf50;
    color: #fff;
}

.search-form-container .btn-success:hover {
    background-color: #357a38;
}

.search-form-container .row {
    justify-content: center;
}

.search-form-container .col-md-2,
.search-form-container .col-md-3 {
    display: flex;
    flex-direction: column;
    align-items: center;
}

/* Add table styling to match header */
table.table {
    border-collapse: collapse;
    width: 80%;
    margin-bottom: 20px;
    margin-left: 212px;  /* Match the search-form-container margin */
    margin-right: auto;
    box-shadow: 0 2px 8px rgba(33, 150, 191, 0.08);
}

table.table thead th {
    background-color: #2196bf;
    color: white;
    font-weight: 600;
    padding: 10px 8px;
    border: 1px solid #1a7fa3;
}

table.table tbody td {
    padding: 8px;
    border: 1px solid #e0e0e0;
}

table.table tbody tr:nth-child(odd) {
    background-color: #f8f8f8;
}

table.table tbody tr:hover {
    background-color: #e8f4f8;
}

@media (max-width: 768px) {
    .search-form-container .col-md-2,
    .search-form-container .col-md-3 {
        margin-bottom: 15px;
    }
    
    .search-form-container .btn {
        width: 100%;
        margin-bottom: 10px;
    }
}

.form-button-group {
    text-align: center;
    margin-top: 15px;
    padding-top: 15px;
    border-top: 1px solid #e0e0e0;
}

.form-button-group .btn {
    margin: 5px 10px;
    min-width: 120px;
}
</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
			
		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
					<span class="page-header">Efficiency- Report For PM5</span>
				
				<br> <span class="message">${message}</span>

				

				<div class="search-form-container">
					<spring:url value="/pm5efficiencyreport/view" var="viewURL" />
					<form action="${viewURL}" method="get" class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="sdate">Start Date:</label>
								<input type="text" id="sdate" name="sdate" value="${sdate}" class="form-control">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="edate">End Date:</label>
								<input type="text" id="edate" name="edate" value="${edate}" class="form-control">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="pcode">Down Time Primary Code:</label>
								<select id="pcode" name="pcode" class="form-control">
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
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="scode">Down Time Secondary Code:</label>
								<select id="scode" name="scode" class="form-control">
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
								</select>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group form-button-group">
								<button type="submit" class="btn btn-primary">Search</button>
								<c:if test="${fn:length(datas)>0}">
									<button type="button" id="printBtn" class="btn btn-info">Print</button>
									<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">
										<button type="button" id="editBtn" class="btn btn-warning">Edit</button>
										<button type="button" id="deleteBtn" class="btn btn-danger">Delete</button>
									</security:authorize>
									<button type="button" id="exportBtn" class="btn btn-success">Export</button>
								</c:if>
							</div>
						</div>
					</form>
				</div>

				<c:if test="${showTable}">
					<span class="error">${error}</span>
					<br>

					<div id="printDiv">
						<table class="table">
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
									value="/pm5efficiencyreport/export" var="exportURL" />
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
				<spring:url value="/pm5efficiency/edit" var="editURL" />
				<spring:url value="/pm5efficiency/delete" var="deleteURL" />
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
