<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../../common.jsp"></jsp:include>


<spring:url value="/pm5productionwarpreport/email/gradenhours" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		
		
		$('#sdate,#edate').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		
		
		$('#sendMailBtn').click(function(){
			
			var btn=$(this);
			if(confirm('Do you want to send Grade and Hours Report? ')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}?sdate='+$('#sdate').val()+'&edate='+$('#edate').val(),
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
	});

</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">ST Tissue - Grade And Hours Report For PM5</span>
				</div>
				<br>
				<div class="table-selector">
				
					<table>
						<tr>
							<td>
								From Date
							</td>
							<td>
								<input id="sdate" value="${sdate}" readonly="readonly">
							</td>
							<td>
								To Date
							</td>
							<td>
								<input id="edate" value="${edate}" readonly="readonly">
							</td>
							<td>
								<button id="exportBtn">EXPORT</button>
							</td>
							<td>&nbsp;&nbsp;|&nbsp;&nbsp; </td>
							<td>
								<button id="sendMailBtn">SEND MAIL</button>
							</td>
						</tr>
					</table>
				</form>
				</div>
				
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<script type="text/javascript">
	$(function(){
		$('#exportBtn').click(function(e){
			$('#exportForm input[name=sdate]').val($('#sdate').val());
			$('#exportForm input[name=edate]').val($('#edate').val());
			$('#exportForm').submit();
		});
	});
</script>

<spring:url value="/pm5productionwarpreport/export/gradenhours" var="exportURL"/>
<form action="${exportURL}" target="_blank" id="exportForm" method="post">
	<input type="hidden" name="sdate" value="">
	<input type="hidden" name="edate" value="">
</form>
</div>
			</div>

		</div>


	</div>

</body>
</html>
