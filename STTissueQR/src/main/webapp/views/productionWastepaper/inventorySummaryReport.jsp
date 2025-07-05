<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>


<spring:url value="/productionwarpreport/email/inventorysummary" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#sendMailBtn').click(function(){
			
			var btn=$(this);
			if(confirm('Do you want to send Inventory Daily Summary Report? ')){
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
					<span class="label">ST Tissue - Inventory Daily Summary</span>
				</div>
				<br>
				<div class="table-selector">
				
					<table>
						<tr>
							<td>
								<button onclick="$('#exportForm').submit();">EXPORT</button>
								<button id="sendMailBtn">SEND MAIL</button>
							</td>
						</tr>
					</table>
				</form>
				</div>
				
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<spring:url value="/productionwarpreport/export/inventorysummary" var="exportURL"/>
<form action="${exportURL}" target="_blank" id="exportForm"></form>

</div>
			</div>

		</div>


	</div>

</body>
</html>
