<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<style type="text/css">
	.thhead{
	background-color: rgb(223, 223, 223);
	}

</style>


</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Process Improvement Meeting Notes - Open Follow Up </span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
					
						<tr>
							<td>
								<input type="button" value="Send Mail" id="sendMailBtn">
								&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td><a href='<spring:url value="/oimnotesreport/export/openfollowups"/>' target="_blank">PDF</a> </td>
							
						</tr>
					</table>

				</div>


<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<table class="table" style="width: 900px; margin: auto;">
	<c:forEach items="${summaries}" var="sum">
		<c:if test="${fn:length(sum.followUps) gt 0}">
			<tr>
				<th class="thhead" style="width: 80px;">Category</th>
				<th class="thhead" colspan="6">Summary</th>
				<th class="thhead" ><div style="width: 60px;">Date</div> </th>
				<th class="thhead" >Days</th>
			</tr>
			<tr>
				<td style="text-align: center;">${sum.category }</td>
				<td colspan="6">${sum.summary}</td>
				<td style="text-align: center;"><fmt:formatDate value="${sum.entryDate}" pattern="MM-dd-yyyy"/> </td>
				<td style="text-align: center;">${sum.days}</td>
			</tr>
			
			<tr>
				<th></th>
				<th colspan="2"><div style="width: 400px;">Follow Up</div></th>
				<th>Responsibility</th>
				<th>Timeline</th>
				<th>Recurrence</th>
				<th>Action</th>
				<th></th>
				<th></th>
				
			</tr>
			
			<c:forEach items="${sum.followUps}" var="follow">
				<tr>
					<td style="background-color: ${follow.tagColor}"></td>
					<td colspan="2">${follow.followUp }</td>
					<td style="text-align: center;">${follow.responsibility}</td>
					<td style="text-align: center;"><fmt:formatDate value="${follow.timeline}" pattern="MM-dd-yyyy"/> </td>
					<td style="text-align: center;">${recurrences[follow.recurrence]}</td>
					<td style="text-align: center;">
					<a class="abtn" href="javascript:void(0)" id="close_${follow.id}" data-id="${follow.id}">Close</a>
					</td>
					<td style="text-align: center;"><fmt:formatDate value="${follow.entryDate}" pattern="MM-dd-yyyy"/></td>
					<td style="text-align: center;">${follow.days }</td>
				
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="9"><div style="height: 30px;"></div> </td>
			</tr>
		</c:if>
	</c:forEach>
</table>

</div>



			</div>

		</div>


	</div>
<spring:url value="/oimnotes/followup/close" var="closeURL"/>	


<div id="dialog" title="PROCESS IMPROVEMENT MEETING NOTES" style="display: none;">
	<iframe id="dialogPage" name="dialogPage" style="width: 98%; height: inherit;border: none;"></iframe>
</div>

<spring:url value="/oimnotesreport/email/openfollowups" var="emailURL"/>

<script type="text/javascript">
$(function(){
	$('#sendMailBtn').click(function(){
		
		var btn=$(this);
		if(confirm("Do you want to send 'Process Improvement Meeting Notes - Open Follow Up' report ? ")){
			btn=btn.prop('disabled',true);
			
			$('#tmessage').text('Sending mail.....Please wait.');
			$.ajax({
				url:'${emailURL}',
				type: 'GET',
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
	
	$('*[id^=close_]').click(function(){
		var id=$(this).attr('data-id');
		if(id){
			$("#dialog #dialogPage").attr('src', '${closeURL}/'+id);
			$("#dialog").dialog({
				width: 400,
			    height: 400,
		        modal: true,
		        close: function () {
		        	$("#dialog #dialogPage").attr('src', "about:blank");
		        	location.reload(true);
		        }
		    
		    });
			
		}
		  
		
		//location.reload(true);//Code Done By Roshan Tailor Date:- 2017-01-13 This Code Is To Reload The Page Twise And To Remove The Pop Up Box.
	});
});
/* 
$('document').ready(function() {
	alert("hi..");
	$('#dialogPage').hide();
	//$('#dialog').hide();
	//$('#dialogPage').remove();
	alert("Done..");
}); */
</script>
</body>
</html>
