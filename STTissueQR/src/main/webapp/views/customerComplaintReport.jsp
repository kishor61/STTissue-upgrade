<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/customercomplaintreport/reportview/load" var="showReportURL" />
<spring:url value="/customercomplaintreport/reportview/export" var="exportReportURL"/>
<spring:url value="/customercomplaintreport/reportview/delete" var="deletefrprfDataURL" />
<spring:url value="/customercomplaintreport/reportview/edit" var="editDataURL" />
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>
<script type="text/javascript">

$(function(){
	$('#deleterowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#barcodedatatable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#barcodedatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deletefrprfDataURL}',
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
		$('#editbutton').click(function(){			
			var id=$('#barcodedatatable tbody input[name=id]:checked').val();
			if(id=='' || typeof id ==='undefined'){
				alert("Select The Row.");
				return false;
			}
			if(id!='0'){
				location.href='${editDataURL}/'+encodeURIComponent(id);
			}
			else if(typeof gradeDate ==='undefined'){
				alert('Select grade code.');
				return false;
			}	
		});
});
</script>
<spring:url value="/customercomplaintreport/reportview/load/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send Customer Complaint Report for '+sdate)){
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
							$('#tmessage').text('Failure to send email. Please contact to Roshan.');
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
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Customer Complaint Report</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<form action="${showReportURL}" method="get">
							<td>Start Date</td>
							<td><input readonly="readonly" type="text" name="sdate" value="${sdate}" style="width: 80px;"></td>
							<td></td>
							<td>End Date</td>
							<td><input readonly="readonly" type="text" name="edate" value="${edate}"  style="width: 80px;"></td>
							<td><input type="submit" id="viewbutton" name="viewbutton" value="View"></td>
							</form>
							<c:if test="${view}">
								<form action="${exportReportURL}" method="POST">
										<td><input type="hidden" name="sdate" value="${sdate}" ></td>
										<td><input type="hidden" name="edate" value="${edate}"></td>
										<td><button id="exportbutton">Export</button></td>
								</form>
								<td><button id="deleterowbutton">Delete</button></td>	
								<td><button id="editbutton">Edit</button></td>	
								<td><button id="sendMailBtn">Send Mail</button></td>	
							</c:if>
						</tr>
					</table>
				</div>
				<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
				<c:if test="${fn:length(reportData) > 0 }">		
<center>
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 20px;"></td>
			<td style="width: 80px;">Date</td>
			<td style="width: 80px;">Complaint / Issue</td>
			<td style="width: 80px;">Description</td>
			<td style="width: 80px;">Grade</td>
			<td style="width: 80px;">Customer</td>
			<td style="width: 80px;">Type</td>
			<td style="width: 80px;">Prod. date</td>
			<td style="width: 80px;">Corrective Action</td>
			<td style="width: 80px;">Follow up/Remarks</td>
			<td style="width: 80px;">Resp.</td>
			<td style="width: 80px;">Target date</td>
			<td style="width: 80px;">Status</td>
			
			<td style="width: 80px;">Attachments </td>
			<td style="width: 80px;">Attached Kaizen</td>
			
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reportData}" var="rd">
			<tr>
				<td><input type="radio" name="id" value="${rd.id}"></td>	
				<td><fmt:formatDate value="${rd.date}" pattern="MM/dd/yyyy"/></td>
				<td>${rd.complaintissue}</td>
				<td>${rd.description}</td>
				<td>${rd.grade}</td>
				<td>${rd.customer}</td>
				<td>${rd.type}</td>
				<td><fmt:formatDate value="${rd.proddate}" pattern="MM/dd/yyyy"/></td>
				<td>${rd.correctiveaction}</td>
				<td>${rd.remarks}</td>
				<td>${rd.resp}</td>
				<td><fmt:formatDate value="${rd.targetdate}" pattern="MM/dd/yyyy"/></td>
				<td>${rd.status}</td>	
				<c:if test="${not empty rd.attachment}">
					<td><a href="<spring:url value="/assets/Customer_Complaint_Report_Documents/${rd.attachment}"/>">Download</a></td>
				</c:if>
				<c:if test="${empty rd.attachment}">
					<td><a href="#">Not Available</a></td>
				</c:if>
				<c:if test="${not empty rd.kaizen}">
					<td><a href="<spring:url value="/assets/Customer_Complaint_Report_Documents/${rd.kaizen}"/>">Download</a></td>
				</c:if>
				<c:if test="${empty rd.kaizen}">
					<td><a href="#">Not Available</a></td>
				</c:if>
				</tr>
		</c:forEach>
	</tbody>
</table>
</center>
				</c:if>
				</div>

			</div>

		</div>


	</div>

</body>
</html>
