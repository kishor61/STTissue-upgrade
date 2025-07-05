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
<spring:url value="/qulitycheck_pm5/qaulitychecklist/delete" var="deletewinderDataURL" />
<spring:url value="/qulitycheck_pm5/qualitychecklist/data/edit" var="editIdDataURL" />
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
<body class="hold-transition sidebar-mini layout-fixed">
<jsp:include page="../header.jsp"></jsp:include>
    <div class="wrapper">	
<div id="printDiv">	
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div class="content-header" style=" padding-top: 10px !important; padding-bottom: 0px !important; line-height: 0px !important;">
			<h5 class="report-title" style="text-align: center; width: 100%; margin: 15px 0;">Qaulity Check List Report PM5</h5>
		</div>

		<div class="block3" style="overflow: auto;">
			<div >
				<div class="table-selector" style="margin: 15px auto; padding: 10px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 5px rgba(0,0,0,0.1);">
				<spring:url value="/qulitycheck_pm5/qualitychecklist/report/show" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get" class="form-inline">		
					<table style="margin: auto; border-spacing: 10px; border-collapse: separate;">
						<tr>
							<td><strong>Start Date:</strong></td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}" class="form-control">							
							</td>
							<td><strong>End Date:</strong></td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}" class="form-control">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View" class="btn btn-primary">
							</td>
							<!-- <td><input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export"></td> -->
							<!-- <td><input type="button" value="Send Mail" id="sendMailBtn"></td>
							<td><button id="deleterowbutton">Delete</button></td> -->
							<td><button id="editrowbutton" type="button" class="btn btn-info">Edit</button></td>
						</tr>
					</table>
					</form>
				</div>
<form id="exportFrom" action='<spring:url value="/qulitycheck_pm5/productspecificationsignoffsheet/report/show/export"/>' method="get" style="display:none; " target="_blank">
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
									<td>Grade Code</td>
									<td>Customer</td>
									<td>setNumber</td>
									<td>Position</td>
									<td>Wigth of Roll</td>
									<td>Diameter of Roll</td>
									<td>Core</td>
									<td>Corrugation</td>
									<td>Holes</td>
									<td>EdgeQulity</td>
									<td>R1/R2 <br>Initial
									</td>
									<td>Auditer<br>Initial
									</td>


								</tr>

							</thead>
							<tbody>
		<c:forEach items="${data}" var="datas">
		  <c:if test="${datas.machinedown=='yes' }">
		  <tr>
									<td>
										<input type="radio" name="id" value="${datas.id}">
										<fmt:formatDate value="${datas.date}" var="dateS" pattern="MM-dd-yyyy" /> 
										<input style="width: 75px;"type="hidden" name="sdate" value="${dateS}" autocomplete="off" id="Date">
									</td>
									<td>${dateS}</td>
									<td  colspan="14" style="background-color: red;text-align: center;font-size: 15px">
													Machine Down &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<fmt:formatDate  value="${datas.stime}" var="dateS" pattern="HH:mm" />  Start Time : ${dateS} 
													<fmt:formatDate  value="${datas.etime}" var="dateE" pattern="HH:mm" />  End Time : ${dateE}  
									</td>
								</tr>
		  </c:if>
		    <c:if test="${datas.machinedown=='No' }">
		    
		    <tr>
									<td>
										<input type="radio" name="id" value="${datas.id}">
										<fmt:formatDate value="${datas.date}" var="dateS" pattern="MM-dd-yyyy" /> 
										<input style="width: 75px;"type="hidden" name="sdate" value="${dateS}" autocomplete="off" id="Date">
									</td>
									
									<td>${dateS}</td>
									<td>${datas.time}</td>
									<td>${datas.gradecode}</td>
									<td>${datas.customer}</td>
									<td>${datas.setnumber}</td>
									<td>${datas.position}</td>
									<td>${datas.widthofroll}</td>
									<td>${datas.diameterofroll}</td>
									<td>${datas.core}</td>
									<td>${datas.corrugation}</td>
									<td>${datas.holes}</td>
									<td>${datas.edgequlity}</td>
									<td>${datas.r1r2initial}</td>
									<td>${datas.auditerinitial}</td>
								
								</tr>
		  </c:if>
						
								
								

		</c:forEach>
		<thead style="text-align: center;">
			<tr>
			<td>Percenatge</td>
			<td>${percentage}%</td>
				
				
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
