<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<style>
    .title-center {
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        margin: 15px 0;
        width: 100%;
        color: #2189b9;
        text-transform: uppercase;
    }
    
    .efficiency-table {
        margin: auto;
        width: 90%;
        max-width: 800px;
        border-collapse: collapse;
        border-spacing: 0px;
        font-family: sans-serif;
    }
    
    .efficiency-table thead {
        background: #2189b9;
        color: white;
    }
    
    .efficiency-table th {
        border: 1px solid gray;
        padding: 8px;
        font-weight: bold;
        font-size: 13px;
    }
    
    .efficiency-table td {
        font-size: 12px;
        padding: 6px;
        border: 1px solid #ddd;
    }
    
    .efficiency-table .trrowgray {
        background-color: #f2f2f2;
        font-weight: bold;
    }
    
    .efficiency-table .trrowgray2 {
        background-color: #e0e0e0;
        font-weight: bold;
    }
    
    .filter-section {
        background: #f8f9fa;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        margin: 20px auto;
        width: 95%;
        max-width: 450px;
        text-align: center;
    }
    
    .filter-grid {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 20px;
    }
    
    .filter-item {
        width: 100%;
        max-width: 400px;
    }
    
    .filter-item label {
        display: block;
        font-weight: 600;
        margin-bottom: 8px;
        color: #444;
        font-size: 14px;
        text-align: left;
    }
    
    .input-container {
        width: 100%;
    }
    
    .input-container input[type="text"] {
        width: 100%;
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        background-color: white;
        transition: border-color 0.2s;
        font-size: 14px;
        height: 42px;
        box-sizing: border-box;
    }
    
    .input-container select {
        width: 100%;
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        background-color: white;
        transition: border-color 0.2s;
        appearance: auto;
        font-size: 14px;
        height: 42px;
        box-sizing: border-box;
    }
    
    .input-container input[type="text"]:focus,
    .input-container select:focus {
        border-color: #2189b9;
        outline: none;
        box-shadow: 0 0 0 2px rgba(33, 137, 185, 0.2);
    }
    
    .filter-actions {
        display: flex;
        justify-content: center;
        margin-top: 10px;
        width: 100%;
    }
    
    .action-buttons {
        display: flex;
        justify-content: center;
        gap: 10px;
        width: 100%;
    }
    
    .btn-primary {
        background-color: #3f51b5;
        color: white;
        border: none;
        padding: 12px 30px;
        border-radius: 4px;
        cursor: pointer;
        font-weight: 600;
        transition: background-color 0.2s;
        font-size: 16px;
        min-width: 120px;
    }
    
    .btn-secondary {
        background-color: #6c757d;
        color: white;
        border: none;
        padding: 12px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-weight: 600;
        transition: background-color 0.2s;
    }
    
    .btn-primary:hover {
        background-color: #303f9f;
    }
    
    .btn-secondary:hover {
        background-color: #5a6268;
    }
    
    @media (max-width: 768px) {
        .filter-grid {
            grid-template-columns: 1fr;
        }
        
        .filter-actions {
            justify-content: flex-start;
            margin-top: 10px;
        }
    }
    
    /* Result Table Styling */
    .table-container {
        width: 95%;
        max-width: 800px;
        margin: 30px auto;
        background: white;
        border-radius: 8px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        padding: 20px;
    }
    
    .efficiency-table {
        margin: 0 auto;
        width: 100%;
        border-collapse: collapse;
        font-family: Arial, sans-serif;
        box-shadow: 0 1px 3px rgba(0,0,0,0.1);
    }
    
    .efficiency-table thead {
        background: #3f51b5;
        color: white;
    }
    
    .efficiency-table th {
        text-align: center;
        padding: 12px 8px;
        font-weight: 600;
        font-size: 14px;
        border: 1px solid #ddd;
        text-transform: uppercase;
    }
    
    .efficiency-table th:first-child {
        text-align: left;
    }
    
    .efficiency-table td {
        padding: 10px 8px;
        border: 1px solid #ddd;
        font-size: 13px;
        vertical-align: middle;
    }
    
    .efficiency-table tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    
    .efficiency-table .primary-code-row {
        background-color: #f2f7fb;
        font-weight: bold;
    }
    
    .efficiency-table .secondary-code {
        padding-left: 25px;
    }
    
    .efficiency-table .trrowgray {
        background-color: #f2f2f2;
        font-weight: bold;
        border-top: 2px solid #ddd;
    }
    
    .efficiency-table .trrowgray2 {
        background-color: #e0e0e0;
        font-weight: bold;
        border-top: 2px solid #bbb;
        font-size: 14px;
    }
    
    .error {
        color: #dc3545;
        margin-bottom: 15px;
        display: block;
        text-align: center;
    }
    
    /* Print Area Styling */
    #printDiv {
        padding: 15px;
    }
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<jsp:include page="../header.jsp"></jsp:include>
    <div class="wrapper">
		
		<div class="page-header">
			<div style="text-align: center;">
				<span class="label title-center">Efficiency Summary- Report For PM5</span>
			</div>
			<span class="message">${message}</span>
		</div>

		<div class="filter-section">
			<spring:url value="/pm5efficiencyreport/viewsummary" var="viewviewsummaryURL" />
			<form action="${viewviewsummaryURL}" method="get">
				<div class="filter-grid">
					<div class="filter-item">
						<label for="sdate">Start Date:</label>
						<div class="input-container">
							<input type="text" id="sdate" name="sdate" value="${sdate}">
						</div>
					</div>
					<div class="filter-item">
						<label for="edate">End Date:</label>
						<div class="input-container">
							<input type="text" id="edate" name="edate" value="${edate}">
						</div>
					</div>
					<div class="filter-item">
						<label for="pcode">Down Time Primary Code:</label>
						<div class="input-container">
							<select id="pcode" name="pcode">
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
					<div class="filter-item">
						<label for="scode">Down Time Secondary Code:</label>
						<div class="input-container">
							<select id="scode" name="scode">
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
					<div class="filter-actions">
						<input type="submit" value="Search" class="btn-primary">
					</div>
					<c:if test="${showTable}">
						<div class="action-buttons">
							<input id="printBtn" type="button" value="Print" class="btn-secondary">
							<input id="exportBtn" type="button" value="Export" class="btn-secondary">
						</div>
					</c:if>
				</div>
			</form>
		</div>

		<c:if test="${fn:length(datas)>0}">
		<spring:url value="/pm5efficiencyreport/exportsummary" var="exportURL" />
		<form id="exportForm" style="display: none;" action="${exportURL}" method="post">
			<input type="hidden" name="sdate" value="${sdate}"> 
			<input type="hidden" name="edate" value="${edate}"> 
			<input type="hidden" name="pcode" value="${pcode}"> 
			<input type="hidden" name="scode" value="${scode}"> 
		</form>

		<script type="text/javascript">
			$(function() {
				

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

		<c:if test="${showTable}">
			<div class="table-container">
				<span class="error">${error}</span>
				
				<div id="printDiv">
					<c:set value="${fn:length(datas['summaryPrimaries'])}" var="len"/>
					
					<c:if test="${len >0 }">
						<table class="table efficiency-table">
							<thead>
								<tr>
									<th>Code</th>
									<th>HH</th>
									<th>MM</th>
									<th>OCCURRENCE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${datas['summaryPrimaries']}" var="pSum">
									<tr class="primary-code-row">
										<td>${pSum.code}</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									<c:set value="${fn:length(pSum.summarySecondaries)}" var="len2"/>
									<c:if test="${len2 > 0}">
										<c:forEach items="${pSum.summarySecondaries}" var="sSum">
											<tr>
												<td class="secondary-code">${sSum.code}</td>
												<td style="text-align: center;">${sSum.hh}</td>
												<td style="text-align: center;">${sSum.mm}</td>
												<td style="text-align: center;">${sSum.counter}</td>
											</tr>
										</c:forEach>
										<tr>
											<td class="trrowgray" style="text-align: right;"><b>TOTAL</b></td>
											<td class="trrowgray" style="text-align: center;">${pSum.hh}</td>
											<td class="trrowgray" style="text-align: center;">${pSum.mm}</td>
											<td class="trrowgray"></td>
										</tr>	
									</c:if>
								</c:forEach>
								
								<tr>
									<td class="trrowgray2" style="text-align: right;"><b>GRAND TOTAL</b></td>
									<td class="trrowgray2" style="text-align: center;">${datas['hh']}</td>
									<td class="trrowgray2" style="text-align: center;">${datas['mm']}</td>
									<td class="trrowgray2"></td>
								</tr>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</c:if>
	</div>

</body>
</html>
