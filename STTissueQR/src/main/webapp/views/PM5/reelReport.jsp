<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Reel Report</title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
.report-header {
    background: linear-gradient(135deg, #007bff, #0056b3);
    color: white;
    padding: 20px;
    text-align: center;
    border-radius: 8px;
    margin: 20px auto;
    max-width: 500px;
    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
}

.report-title {
    font-size: 24px;
    font-weight: 600;
    margin: 0;
    text-transform: uppercase;
    letter-spacing: 1px;
}

.filter-container {
    background: #f8f9fa;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    margin: 20px auto;
    max-width: 500px;
}

.filter-label {
    font-weight: 600;
    color: #333;
    width: 120px;
    display: inline-block;
}

.filter-input {
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    width: 200px;
    margin-bottom: 10px;
    transition: border-color 0.3s;
}

.filter-input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 0 2px rgba(0,123,255,0.25);
}

.filter-select {
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    width: 200px;
    margin-bottom: 10px;
    background-color: white;
}

.filter-button {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 8px 20px;
    border-radius: 4px;
    cursor: pointer;
    margin: 5px;
    transition: background-color 0.3s;
}

.filter-button:hover {
    background-color: #0056b3;
}

.filter-button:disabled {
    background-color: #6c757d;
    cursor: not-allowed;
}

.filter-section-title {
    color: #333;
    font-size: 18px;
    margin-bottom: 15px;
    padding-bottom: 10px;
    border-bottom: 2px solid #007bff;
}

/* Date Picker Custom Styling */
.ui-datepicker {
    padding: 10px;
    width: auto !important;
}

.ui-datepicker .ui-datepicker-header {
    padding: 5px 0;
    position: relative;
    background: #f8f9fa;
    border: none;
}

.ui-datepicker .ui-datepicker-prev,
.ui-datepicker .ui-datepicker-next {
    position: absolute;
    top: 5px;
    width: 30px;
    height: 30px;
    cursor: pointer;
    text-indent: -9999px;
    background: none;
    border: none;
}

.ui-datepicker .ui-datepicker-prev {
    left: 5px;
    background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M15 18l-6-6 6-6"/></svg>') no-repeat center;
}

.ui-datepicker .ui-datepicker-next {
    right: 5px;
    background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M9 18l6-6-6-6"/></svg>') no-repeat center;
}

.ui-datepicker .ui-datepicker-title {
    margin: 0 40px;
    line-height: 30px;
    text-align: center;
    font-weight: bold;
}

.ui-datepicker table {
    width: 100%;
    margin: 0;
    border-collapse: collapse;
}

.ui-datepicker th {
    padding: 5px;
    text-align: center;
    font-weight: bold;
    border: none;
}

.ui-datepicker td {
    padding: 0;
    border: none;
}

.ui-datepicker td span,
.ui-datepicker td a {
    display: block;
    padding: 5px;
    text-align: center;
    text-decoration: none;
    border: none;
}

.ui-datepicker .ui-state-default {
    border: 1px solid #ddd;
    background: #fff;
}

.ui-datepicker .ui-state-hover {
    background: #f0f0f0;
}

.ui-datepicker .ui-state-active {
    background: #007bff;
    color: #fff;
}

.ui-datepicker .ui-datepicker-buttonpane {
    margin: 0;
    padding: 5px;
    background: #f8f9fa;
    border: none;
}

.ui-datepicker .ui-datepicker-buttonpane button {
    margin: 0;
    padding: 5px 10px;
    cursor: pointer;
    background: #007bff;
    color: #fff;
    border: none;
    border-radius: 3px;
}

.ui-datepicker .ui-datepicker-buttonpane button:hover {
    background: #0056b3;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
    // Check if jQuery UI is loaded
    if (typeof $.datepicker === 'undefined') {
        console.error('jQuery UI datepicker is not loaded. Please check if jQuery UI is properly included.');
        return;
    }

    // Initialize date pickers
    try {
        $("input[name=fromDate]").datepicker({
            dateFormat: 'mm-dd-yy',
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            beforeShow: function(input, inst) {
                setTimeout(function() {
                    inst.dpDiv.css({
                        'z-index': 9999,
                        'position': 'relative'
                    });
                }, 0);
            },
            onSelect: function(dateText, inst) {
                console.log('From date selected:', dateText);
            }
        });
        
        $("input[name=toDate]").datepicker({
            dateFormat: 'mm-dd-yy',
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            beforeShow: function(input, inst) {
                setTimeout(function() {
                    inst.dpDiv.css({
                        'z-index': 9999,
                        'position': 'relative'
                    });
                }, 0);
            },
            onSelect: function(dateText, inst) {
                console.log('To date selected:', dateText);
            }
        });
    } catch (e) {
        console.error('Error initializing date pickers:', e);
    }
});
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
			<jsp:include page="../header.jsp"></jsp:include>
		<div class="block3">
			<div class="pageContent">
				<div class="report-header">
					<h1 class="report-title">Quality Report - Reel Testing</h1>
				</div>
				<fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateFrom"/>
				<fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateTo"/>
				<div class="filter-container">
					<div class="filter-section-title">Filter Options</div>
					<form id="reelReportForm" action="#">
						<table class="table" style="width: 100%; margin: auto;">
							<tbody>
								<tr>
									<td>
										<table style="border: none; margin: auto; width: 100%;">
											<tr>
												<td class="filter-label">From date:</td>
												<td><input readonly="readonly" name="fromDate" type="text" class="filter-input" value="${dateFrom}"></td>
											</tr>
											<tr>
												<td class="filter-label">To date:</td>
												<td><input readonly="readonly" name="toDate" type="text" class="filter-input" value="${dateTo}"></td>
											</tr>
											<tr>
												<td class="filter-label">Grade Code:</td>
												<td>
													<select class="filter-select" name="grade">
														<option value="">All</option>
														<c:forEach items="${grades}" var="grade">
															<option value="${grade.gradeCode}">${grade.gradeCode}</option>
														</c:forEach>
													</select>
												</td>
											</tr>
											<tr>
												<td class="filter-label">Customer Code:</td>
												<td>
													<select class="filter-select" name="customer">
														<option value="">All</option>
														<c:forEach items="${customers}" var="customer">
															<option value="${customer}">${customer}</option>
														</c:forEach>
													</select>
												</td>
											</tr>
											<tr>
												<td class="filter-label">Reel No:</td>
												<td><input type="text" name="reel" class="filter-input"></td>
											</tr>
											<tr>
												<td class="filter-label">Grade Type:</td>
												<td>
													<select class="filter-select" name="type">
														<option value="">All</option>
														<option value="1">Napkin</option>
														<option value="2">Bath Tissue</option>
														<option value="3">Towel</option>
													</select>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2" align="center" style="padding-top: 20px;">
										<button id="viewBtn" class="filter-button">View</button>
										<button id="exportBtn" class="filter-button">Excel</button>
										<button id="exportPdfBtn" class="filter-button">PDF</button>
										<security:authorize access="hasAnyRole('ADMIN,OPERATOR,OPERATOR6')">
											<button id="editBtn" class="filter-button">Edit</button>
										</security:authorize>
										<input type="button" value="Send Mail" id="sendMailBtn" class="filter-button">
									</td>
								</tr>
							</tfoot>
						</table>
						<input type="hidden" name="reqType" value="">
					</form>
				</div>


			</div>

		</div>


	</div>
<!-- Include Footer -->
<jsp:include page="../footer.jsp" />
<spring:url value="/pm5reelreport/view" var="viewReportDateWise"/>	
<spring:url value="/pm5reelreport/export" var="exportReportDateWise"/>	
<spring:url value="/pm5reelreport/export" var="exportReportDateWise"/>	
<spring:url value="/pm5reelreport/update" var="updateReportDateWise"/>	

<spring:url value="/pm5reelreport/email" var="emailURL"/>	


<spring:url value="/pm5reelreport/view/report" var="reelReportView"/>
<spring:url value="/pm5reelreport/view/update" var="reelReportEdit"/>
<spring:url value="/pm5reelreport/view/export" var="reelReportExport"/>
<spring:url value="/pm5reelreport/view/exportpdf" var="reelReportExportPdf"/>

<!-- View and Export Report -->
<script type="text/javascript">
$(function(){
	
	$('#viewBtn').click(function(){
		$('#reelReportForm').attr('action','${reelReportView}');
		$('#reelReportForm').attr('target','_blank');
		$('#reelReportForm').submit();
		return false;
	});
	
	
	
	$('#editBtn').click(function(){
		$('#reelReportForm').attr('action','${reelReportEdit}');
		$('#reelReportForm').attr('target','');
		$('#reelReportForm').submit();
		return false;
	});
	
	$('#exportBtn').click(function(){
		$('#reelReportForm').attr('action','${reelReportExport}');
		$('#reelReportForm').attr('target','_blank');
		$('#reelReportForm').submit();
		return false;
	});
	
	$('#exportPdfBtn').click(function(){
		$('#reelReportForm').attr('action','${reelReportExportPdf}');
		$('#reelReportForm').attr('target','_blank');
		$('#reelReportForm').submit();
		return false;
	});
	
	$('#sendMailBtn').click(function(){
		
		var date=$('input[name=fromDate]').val();
		var btn=$(this);
		if(confirm('Do you want to send quality report for '+date)){
			btn=btn.prop('disabled',true);
			
			$('#tmessage').text('Sending mail.....Please wait.');
			$.ajax({
				url:'${emailURL}',
				type: 'GET',
				data : {
					date : date
				},
				success : function(data){
					if(data){
						$('#tmessage').text('Mail sent successfully.');
					}else{
						$('#tmessage').text('Failure to send email. Please contact to administrator.');
					}
					btn=btn.prop('disabled',false);
					setTimeout(function(){
						$('#tmessage').text('');
					}, 5000);
				}
			});
		}
		
	});
	
	/* 
	
	$('#viewBtn').click(function(){
		var fromDate=$('input[name=fromDate]').val();
		if(fromDate==''){
			alert('Select from date.');
			return false;
		}
		var toDate=$('input[name=toDate]').val();
		if(toDate==''){
			alert('Select to date.');
			return false;
		}
		var grade=$('select[name=grade]').val();
		var customer= $('select[name=customer]').val();
		var reel=$('input[name=reel]').val();
		customer=customer.replace('/','-');
		
		if(customer=='' & grade=='' & reel==''){
			window.open("${viewReportDateWise}/"+fromDate+"/"+toDate);
		}else if(customer!='' & grade=='' & reel==''){
			window.open("${viewReportDateWise}/customer/"+fromDate+"/"+toDate+"/"+customer);
		}else if(customer=='' & grade!='' & reel==''){
			window.open("${viewReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade);
		}else if(customer=='' & grade=='' & reel!=''){
			window.open("${viewReportDateWise}/reel/"+fromDate+"/"+toDate+"/"+reel);
		}else if(customer!='' & grade!='' & reel==''){
			window.open("${viewReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade+"/"+customer);
		}else if(customer=='' & grade!='' & reel!=''){
			window.open("${viewReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade+"/r/"+reel);
		}else if(customer!='' & grade=='' & reel!=''){
			window.open("${viewReportDateWise}/customer/"+fromDate+"/"+toDate+"/"+customer+"/c/"+reel);
		}else if(customer!='' & grade!='' & reel!=''){
			window.open("${viewReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade+"/"+customer+"/"+reel);
		}    
	});
	
	$('#exportBtn').click(function(){
		var fromDate=$('input[name=fromDate]').val();
		if(fromDate==''){
			alert('Select from date.');
			return false;
		}
		var toDate=$('input[name=toDate]').val();
		if(toDate==''){
			alert('Select to date.');
			return false;
		}
		var grade=$('select[name=grade]').val();
		var customer= $('select[name=customer]').val();
		var reel=$('input[name=reel]').val();
		customer=customer.replace('/','-');
		
		if(customer=='' & grade=='' & reel==''){
			window.location="${exportReportDateWise}/"+fromDate+"/"+toDate;
		}else if(customer!='' & grade=='' & reel==''){
			window.open("${exportReportDateWise}/customer/"+fromDate+"/"+toDate+"/"+customer);
		}else if(customer=='' & grade!='' & reel==''){
			window.open("${exportReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade);
		}else if(customer=='' & grade=='' & reel!=''){
			window.open("${exportReportDateWise}/reel/"+fromDate+"/"+toDate+"/"+reel);
		}else if(customer!='' & grade!='' & reel==''){
			window.open("${exportReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade+"/"+customer);
		}else if(customer=='' & grade!='' & reel!=''){
			window.open("${exportReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade+"/r/"+reel);
		}else if(customer!='' & grade=='' & reel!=''){
			window.open("${exportReportDateWise}/customer/"+fromDate+"/"+toDate+"/"+customer+"/c/"+reel);
		}else if(customer!='' & grade!='' & reel!=''){
			window.open("${exportReportDateWise}/gradewise/"+fromDate+"/"+toDate+"/"+grade+"/"+customer+"/"+reel);
		}    
	}); */
});

</script>



</body>
</html>
