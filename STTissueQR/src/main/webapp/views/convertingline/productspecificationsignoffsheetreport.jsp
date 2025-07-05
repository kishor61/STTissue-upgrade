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
<style>
td 
{
    height: 20px; 
    width:60px;
        text-align: center;
}
</style>
<spring:url value="/convertinglinecustomerrolltesting/productspecificationsignoffsheet/delete" var="deletewinderDataURL" />
<spring:url value="/convertinglinecustomerrolltesting/productspecificationsignoffsheet/data/edit" var="editIdDataURL" />
<script type="text/javascript">
$(function(){
	$('#deleterowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#yielddatatable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				alert("First Row Can't Delete.");
				//$('#yielddatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deletewinderDataURL}',
					type:'POST',
					data:{id:val},
					success:function(data){
						if(data.status){
							alert('Data removed from database.');
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}
		}
	});
	
	
});

</script>
 
<script type="text/javascript">  
$(function(){
$('#editrowbutton').click(function(){
			
			var id=$('#yielddatatable tbody input[name=id]:checked').val();
			if(id=='' || typeof id ==='undefined'){
				alert("Select The Row.");
				return false;
			}
			if(id!='0'){
				window.location.href='${editIdDataURL}/'+encodeURIComponent(id);
			}
			else if(typeof gradeDate ==='undefined'){
				alert('Select grade code.');
				return false;
			}	
		});
});
</script>
<spring:url value="/convertinglinereport/productspecificationsignoffsheet/report/show/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send Product Specification Sign Off Sheet Report for '+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate
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
					<span class="label">Converting Line - PRODUCT SPECIFICATION SIGN OFF SHEET REPORT</span>
				</div>
				<div class="table-selector">
				<spring:url value="/convertinglinereport/productspecificationsignoffsheet/report/show" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get">		
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
							</td>
							<td><input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export"></td>
							<td><input type="button" value="Send Mail" id="sendMailBtn"></td>
							<td><button id="deleterowbutton">Delete</button></td>
							<td><button id="editrowbutton" type="button">Edit</button></td>
						</tr>
					</table>
					</form>
				</div>
<form id="exportFrom" action='<spring:url value="/convertinglinereport/productspecificationsignoffsheet/report/show/export"/>' method="get" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<c:if test="${fn:length(data) > 0 }">
<br /><br />
<center>
<table id="yielddatatable" class="table" style="width: auto;">
							<thead style="text-align: center;">
								<tr>
									<td></td>
									<td>Date</td>
									<td>Time</td>
									<td>Rewinder Speed</td>
									<td>SKU Code</td>
									<td>Roll Diameter</td>
									<td>Tail Seal</td>
									<td>Core</td>
									<td>Roll Width</td>
									<td>Embossing</td>
									<td>Over all<br /> Appereiance</td>
									<td>Appereiance <br />After Palletized</td>
									<td>Date Code <br />Printed</td>
									<td>Rejected<br >KDF</td>
									<td>Box Apperance</td>
									<td>Tape</td>
									<td>Enough Handle</td>
									<td>Comments</td>
									<td>Initials</td>
								</tr>

							</thead>
							<tbody>
		<c:forEach items="${data}" var="datas">
						
								<tr>
									<td>
										<input type="radio" name="id" value="${datas.id}">
										<fmt:formatDate value="${datas.date}" var="dateS" pattern="MM-dd-yyyy" /> 
										<input style="width: 75px;"type="hidden" name="sdate" value="${dateS}" autocomplete="off" id="Date">
									</td>
									<td>${dateS}</td>
									<td>${datas.time}</td>
									<td>${datas.rewinderspeed}</td>
									<td>${datas.skucode}</td>
									<td>${datas.rolldiameter}</td>
									<td>${datas.tailseal}</td>
									<td>${datas.core}</td>
									<td>${datas.rollwidth}</td>
									<td>${datas.embossing}</td>
									<td>${datas.appereiance}</td>
									<td>${datas.appereianceapllet}</td>
									<td>${datas.datecodeprinted}</td>
									<td>${datas.rejectedkdf}</td>
									
									<td>${datas.boxappr}</td>
									<td>${datas.tape}</td>
									<td>${datas.enoghdle}</td>
									
									<td>${datas.comment}</td>
									<td>${datas.initials}</td>
								</tr>
								
								<c:set value="${total+datas.rejectedkdf}" var="total"/>

		</c:forEach>
		<thead style="text-align: center;">
			<tr>
				<td colspan="11"></td>
				<td></td>
				<td><b>Total:</b></td>
				<td ><b>${total}</b></td>
				<td colspan="2"></td>
				
			</tr>
		</thead>
		</tbody>
						</table>
						</center>
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
