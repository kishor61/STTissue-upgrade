<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - CUSTOMER ROLL TESTING Report</title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function() {
    $( "input[name=fromDate]" ).datepicker({
      dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
    });
    $( "input[name=toDate]" ).datepicker({
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


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Quality Report-CUSTOMER ROLL TESTING</span>
				</div>
				
				<fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateFrom"/>
				<fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateTo"/>
				
				<br><br>
				<div style="padding: 4px;">
				
				<form id="rewindReportForm" action="#">
				
					<table class="table" style="width: 400px; margin: auto;">

						<tbody>
							<tr height="10">
								<td style="width: 200px" rowspan="2">

								<table style="border: none;margin: auto;">
									<tr>
										<td>From date:<td>
										<td><input readonly="readonly" name="fromDate" type="text" style="width: 200px;" value="${dateFrom}"> <td>
									</tr>
									<tr>
										<td>To date:<td>
										<td><input readonly="readonly" name="toDate"  type="text" style="width: 200px;" value="${dateTo}"> <td>
									</tr>
									<%-- <tr>
										<td>Grade Code<td>
										<td>
											<select style="width: 202px; padding: 2px;" name="grade">
												<option value="">All</option>
												<c:forEach items="${grades}" var="grade">
													<option value="${grade.gradeCode}">${grade.gradeCode}</option>
												</c:forEach>
											</select>
										<td>
									</tr> --%>
									<%-- <tr>
										<td>Customer<td>
										<td>
											<select style="width: 202px; padding: 2px;" name="customer">
												<option value="">All</option>
												<c:forEach items="${customers}" var="customer">
													<option value="${customer}">${customer}</option>
												</c:forEach>
											</select>
										<td>
									</tr>
									
									<tr> --%>
										<td>Reel No<td>
										<td>
										<input type="text"  name="reel" style="width: 200px">
											
										<td>
									</tr>
									<!-- <tr>
										<td>Grade Type<td>
										<td>
										
											<select style="width: 202px; padding: 2px;" name="type">
												<option value="">All</option>
												<option value="1">Napkin</option>
												<option value="2">Bath Tissue</option>
												<option value="3">Towel</option>
												
											</select>
											
										<td>
									</tr> -->
								</table>



								</td>
	
							</tr>
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="center">
									<!-- <button id="viewBtn">View</button> -->
									&nbsp;&nbsp;
									<!-- <button id="exportBtn">Excel</button> -->
									&nbsp;&nbsp;
									<!-- <button id="exportPdfBtn">PDF</button> -->
									
										&nbsp;&nbsp;
										<button id="editBtn">Edit</button>
									
									&nbsp;
									<!-- <input type="button" value="Send Mail" id="sendMailBtn"> -->
								</td>
							</tr>
						</tfoot>
					</table>
					
					</form>
				</div>


			</div>

		</div>


	</div>
<spring:url value="/rewindreport/view" var="viewReportDateWise"/>	
<spring:url value="/rewindreport/export" var="exportReportDateWise"/>	
<spring:url value="/rewindreport/export" var="exportReportDateWise"/>	
<spring:url value="/rewindreport/update" var="updateReportDateWise"/>	

<spring:url value="/reelreport/email" var="emailURL"/>


<spring:url value="/rewindreport/view/report" var="rewindReportView"/>
<spring:url value="/convertinglinecustomerrolltesting/view/update" var="rewindReportEdit"/>
<spring:url value="/rewindreport/view/export" var="rewindReportExport"/>
<spring:url value="/rewindreport/view/exportpdf" var="rewindReportExportPdf"/>

<script type="text/javascript">
$(function(){
	
	
	$('#viewBtn').click(function(){
		$('#rewindReportForm').attr('action','${rewindReportView}');
		$('#rewindReportForm').attr('target','_blank');
		$('#rewindReportForm').submit();
		return false;
	});
	
	
	
	$('#editBtn').click(function(){
		$('#rewindReportForm').attr('action','${rewindReportEdit}');
		$('#rewindReportForm').attr('target','');
		$('#rewindReportForm').submit();
		return false;
	});
	
	$('#exportBtn').click(function(){
		$('#rewindReportForm').attr('action','${rewindReportExport}');
		$('#rewindReportForm').attr('target','_blank');
		$('#rewindReportForm').submit();
		return false;
	});
	
	$('#exportPdfBtn').click(function(){
		$('#rewindReportForm').attr('action','${rewindReportExportPdf}');
		$('#rewindReportForm').attr('target','_blank');
		$('#rewindReportForm').submit();
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
	
	

});
</script>

</body>
</html>
