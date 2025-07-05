<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
	
	<style type="text/css">
		body,div,table,thead,tbody,tfoot,tr,th,td,p { font-family:"Calibri"; font-size:medium }
		a.comment-indicator:hover + comment { background:#ffd; position:absolute; display:block; border:1px solid black; padding:0.5em;  } 
		a.comment-indicator { background:red; display:inline-block; border:1px solid black; width:0.5em; height:0.5em;  } 
		comment { display:none;  } 
	.tableFixHead          { overflow: auto; height: auto; }
.tableFixHead thead th { position: sticky; top: 0; z-index: 1; }

/* Just common table stuff. Really. */
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; }
th     { background:#eee; }
	</style>
	
	
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>

<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea({
				retainAttr:['class','style']
			});
		});
		setInterval(function() {
			window.location.reload(true);
		  }, 300000);
	});
</script>

<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>

<spring:url value="/deshboard/mail" var="mail"/>
<script type="text/javascript"> 
	function errorCode(value)
	 {
	     alert(value);
	 }
	function sendMail(value) {
		var senderName = confirm("Do you Really Want to send ?");
		if(senderName)
		{
			$('#loadPage').show();
			window.location.href='${mail}/'+encodeURIComponent(value);
		}
	}
</script>
</head>
<body>
	<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
	</div>
	<div class="container">
		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
	</div>	
	<div class="page-title" style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 100px;">
		<c:if test="${not empty message }">
			<h3 style="font-size: 28px;color:#07f533;text-align: center;"><span class="message">${message}</span></h3>
		</c:if>		
		<h5 style="font-size: 28px;color:red;text-align: center;">*Check Your inbox before you trigger to resend</h5>
		<h1 style="text-align: center;font-size: 18px;">Daily Report Dash Board</h1>			
	</div>
<div id="printDiv" class="tableFixHead"  style="position: fixed;bottom: 0px;left: 5px;right: 5px;top: 200px;">	
			<table style="width: 60%;background-color: #d6d0a382; text-align: center;margin-left: auto; margin-top: auto;margin-bottom: 10px; margin-right: auto;" border="1" >
				<thead >
					<tr style="background-color: #d6d0a382;">
						<th style="width: 2%; text-align: center;">ID</th>
						<th style="width: 10%; text-align: center;">DATE</th>
						<th style="width: 5%; text-align: center;">Triggered Time</th>
						<th style="width: 30%; text-align: center;">Report Name </th>
						<th style="width: 6%; text-align: center;">Frequency of Mail  </th>						
						<th style="width: 5%; text-align: center;">Status</th>
						<th style="width: 4.7%; text-align: center;">ErrorCode</th>
						<th style="width: 5%; text-align: center;">Send</th>
						<!-- <td style="width: 5%; text-align: center;">Sender Name</td>		 -->					
					</tr>
				</thead>										
				<tbody>
					<c:if test="${fn:length(datas) > 0 }">									
							<c:forEach items="${datas}" var="data">
								<tr>
									
									<td style="width: 2%; text-align: center;">${data.id}</td>
									<td style="width: 10%; text-align: center;"><fmt:formatDate  type="date" value="${data.date}" /></td>
									<td style="width: 5%; text-align: center;"><fmt:formatDate   type="time" value="${data.time}" /></td>
									<td style="width: 30%; text-align: left;">${data.reportName} </td>
									<td style="width: 6%; text-align: center;">${data.frquencyOfMail} </td>
									
									<c:if test="${data.status eq '1'}">
										<td style="width: 5%; text-align: center;background-color:green;">SUCCESS</td>
									</c:if>
									<c:if test="${data.status eq '0'}">
										<td style="width: 5%; text-align: center;background-color:#FF0000;">FAIL</td>
									</c:if>
									<c:if test="${data.status eq 'Pending'}">
										<td style="width: 5%; text-align: center;background-color:yellow;">Pending</td>
									</c:if>
									<c:if test="${data.status eq '1'}">
										<td style="width: 5%; text-align: center;">${data.erroCode}</td>
									</c:if>
									<c:if test="${data.status eq 'Pending'}">
										<td style="width: 5%; text-align: center;">${data.erroCode}</td>
									</c:if>
									<c:if test="${data.status eq '0'}">
										<td style="width: 5%; text-align: center;">
											<button style="width: 100%;background-color:#FF0000;" value="${data.erroCode}" onClick="errorCode(this.value)">ERROR</button>
										</td>
									</c:if>
									
									<c:if test="${data.status eq '1'}">
										<td style="width: 5%; text-align: center;">
											
										</td>										
									</c:if>
									<c:if test="${data.status eq 'Pending'}">
										<td style="width: 5%; text-align: center;">
											<button value="${data.reportId}" onClick="sendMail(this.value)">Send</button>
										</td>
									</c:if>
									<c:if test="${data.status eq '0'}">
										<td style="width: 5%; text-align: center;">
											<button value="${data.reportId}" onClick="sendMail(this.value)">Send</button>
										</td>
									</c:if>
									<%-- <c:if test="${data.status eq '1'}">
										<td style="width: 4%; text-align: center;">${data.senderName}</td>										
									</c:if>
									<c:if test="${data.status eq 'Pending'}">
										<td style="width: 4%; text-align: center;">									
									</c:if>
									<c:if test="${data.status eq '0'}">
										<td style="width: 4%; text-align: center;">${data.senderName}</td>	
									</c:if> --%>
								</tr>	
							</c:forEach>						
					</c:if>
				</tbody>
		</table>
	</div>
</div>
</body>
</html>
