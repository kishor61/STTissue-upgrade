<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<spring:url value="/despatch/view/report/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		
		
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send Despatch - REPORT for :'+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate
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
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Despatch Report</span>
				</div>
				<div class="table-selector">
					
				<spring:url value="/despatch/view/report" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<!-- <td>Start Date:</td> -->
							<td>
								<input readonly="readonly" type="hidden" name="sdate" value="${sdate}">							
							</td>
							
							<td>
								<input id="viewDataBtn" type="submit" value="Show Report">
							</td>
							<td>
								<input type="button" value="Send Mail" id="sendMailBtn">
							</td>
						</tr>
					</table>
				</form>

				</div>
<center>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">


<table id="yielddatatable" class="table" style="width: 80%;">
	<thead style="text-align: center;">
		<tr>
			<td><b>Pick Up Date</b></td>
			<td><b>Pick Up Point</b></td>
			<td><b>Pick Up City</b></td>
			<td><b>Pick Up State</b></td>
			<td><b>Pick Up Phone </b></td>
			<td><b>Grade</b></td>
			<td><b>Release Number</b></td>
			<td><b>Carrier ID</b></td>
			<td><b>Unload Comment(s)</b></td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${datas}" var="data">
			<tr style=" text-align:  center;">
				<td style="background-color: #c3d8b5;">
					<b><fmt:formatDate value="${data.pickupdate}" pattern="MM/dd/yyyy"/></b>
				</td>
				<td>${data.pickuppoint}</td>
				<td>${data.pickupcity}</td>
				<td>${data.pickupstate}</td>
				<td>${data.cellnumber}</td>
				<td>${data.grade}</td>
				<td>${data.releasenumber}</td>
				<td>${data.careeririd}</td>
				<td>${data.unloadcomments}</td>
				
			</tr>
			
		</c:forEach>
	</tbody>
</table>
			</div>
</center>

		</div>


	</div>

</body>
</html>
