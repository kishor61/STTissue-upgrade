<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Reel Report</title>
<jsp:include page="common.jsp"></jsp:include>
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
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Quality Report-Reel Testing</span>
				</div>
				<br><br>
				<fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateFrom"/>
				<fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateTo"/>
				<div style="padding: 4px;">
					
					
					<form id="reelReportForm" action="#">
					
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
									<tr>
										<td>Grade Code<td>
										<td>
											<select style="width: 202px; padding: 2px;" name="grade">
												<option value="">All</option>
												<c:forEach items="${grades}" var="grade">
													<option value="${grade.gradeCode}">${grade.gradeCode}</option>
												</c:forEach>
											</select>
										<td>
									</tr>
									<tr>
										<td>Customer Code<td>
										<td>
											<select style="width: 202px; padding: 2px;" name="customer">
												<option value="">All</option>
												<c:forEach items="${customers}" var="customer">
													<option value="${customer}">${customer}</option>
												</c:forEach>
											</select>
										<td>
									</tr>
									<tr>
										<td>Reel No<td>
										<td>
										<input type="text"  name="reel" style="width: 200px">
										<%-- 	<select style="width: 202px; padding: 2px;" name="reel">
												<option value="">All</option>
												<c:forEach items="${reels}" var="reel">
													<option value="${reel}">${reel}</option>
												</c:forEach>
											</select>
											--%>
										<td>
									</tr>
									<tr>
										<td>Grade Type<td>
										<td>
										
											<select style="width: 202px; padding: 2px;" name="type">
												<option value="">All</option>
												<option value="1">Napkin</option>
												<option value="2">Bath Tissue</option>
												<option value="3">Towel</option>
												
											</select>
											
										<td>
									</tr>
								</table>

						

								</td>
								
							</tr>
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="center">
									<button id="viewBtn">View</button>
									&nbsp;&nbsp;
									<button id="exportBtn">Excel</button>
									&nbsp;&nbsp;
									<button id="exportPdfBtn">PDF</button>
									
									<security:authorize access="hasAnyRole('ADMIN,OPERATOR')">
										&nbsp;&nbsp;
										<button id="editBtn">Edit</button>
									</security:authorize>
									
									&nbsp;
									<input type="button" value="Send Mail" id="sendMailBtn">
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
<spring:url value="/reelreport/view" var="viewReportDateWise"/>	
<spring:url value="/reelreport/export" var="exportReportDateWise"/>	
<spring:url value="/reelreport/export" var="exportReportDateWise"/>	
<spring:url value="/reelreport/update" var="updateReportDateWise"/>	

<spring:url value="/reelreport/email" var="emailURL"/>	


<spring:url value="/reelreport/view/report" var="reelReportView"/>
<spring:url value="/reelreport/view/update" var="reelReportEdit"/>
<spring:url value="/reelreport/view/export" var="reelReportExport"/>
<spring:url value="/reelreport/view/exportpdf" var="reelReportExportPdf"/>

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
