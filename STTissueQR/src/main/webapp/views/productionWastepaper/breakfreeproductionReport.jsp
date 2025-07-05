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
<spring:url value="/productionreport/breakfreeproducation/showdata/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var shift=$('select[name=shift]').val();
			
			var btn=$(this);
			
			if(confirm('Do You Want To Send Machine Break Free Production Mail')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate,
						shift : shift 
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
					<span class="label">Break Free Percentage Production Report</span>
				</div>
				<div class="table-selector">
					<spring:url value="/productionreport/breakfreeproducation/showdata" var="viewURL"/>
					<form name="dataForm" action="${viewURL}" method="get">	
						<table>
							<tr>
								<td>Start Date:</td>
								<td><input type="text" value="${sdate}" name="sdate"></td>
								<td>End Date:</td>
								<td><input type="text" value="${edate}" name="edate"></td>
								<td>
									<select name="shift" required="required">
										<option value="">Select</option>
										<c:if test ="${shift eq 'Day'}">
											<option value="Day" selected="selected">Day</option>
											<option value="Night">Night</option>
											<option value="">All</option>
										</c:if>	
										<c:if test ="${shift eq 'Night'}">
											<option value="Day">Day</option>
											<option value="Night" selected="selected">Night</option>
											<option value="">All</option>
										</c:if>	
										<c:if test ="${shift eq 'All'}">
											<option value="Day">Day</option>
											<option value="Night">Night</option>
											<option value="" selected="selected">All</option>
										</c:if>	
										<c:if test ="${shift eq ''}">
											<option value="Day">Day</option>
											<option value="Night">Night</option>
											<option value="">All</option>
										</c:if>
										
									</select>
								</td>
								<td><input type="submit" value="Show" name="Roshan"></td>
								<td>
									<c:if test="${export}">
										<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
										<input type="button" id="mailBtn" value="Send Mail">
									</c:if>
								</td>	
							</tr>
						</table>
					</form>

				</div>
<c:if test="${export}">
<form id="exportFrom" action='<spring:url value="/productionreport/breakfreeproducation/showdata/export"/>' method="get" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
	<input type="hidden" name="shift" value="${shift}">
</form>
<form id="mailFrom" action='<spring:url value="/productionreport/breakfreeproducation/showdata/mail"/>' method="get" style="display:none;">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
	<input type="hidden" name="shift" value="${shift}">
</form>
<br>
</br>
	<center>
<c:if test="${fn:length(data) gt 0}">	
	<table  border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:50%">
			<tr>
				<td style="background-color: #00B8FF;"><center><b>Date</b></center></td>
				<td style="background-color: #00B8FF;"><center><b>Shift</b></center></td>
				<td style="background-color: #00B8FF;"><center><b>Roll Id</b></center></td>
				<td style="background-color: #00B8FF;"><center><b>Grade Code</b></center></td>
				<td style="background-color: #00B8FF;"><center><b>Total Rolls<br> Produce</b></center></td>
				<td style="background-color: #00B8FF;"><center><b>Breaks</b></center></td>
				<td style="background-color: #00B8FF;"><center><b>Breaks Free<br>%</b></center></td>
			</tr>
		<c:forEach items="${data}" var="data">
			<tr>
				<td style="background-color: #6EA23E;" ><center><b><fmt:formatDate value="${data.dateEntered}" pattern="MM/dd/yyyy"/></b></center></td>
				<td><center>${data.shift}</center></td>
				<td><center>${data.rollID}</center></td>
				<td><center>${data.gradeCode}</center></td>
				<td><center>${data.totalrollsproduce}</center></td>
				<td><center>${data.numberofrollswithbreaks}</center></td>
				<td><center>${data.percentageofrollswithbreaks}</center></td>
			</tr>
		</c:forEach>	
	</table>
</c:if>
<c:if test="${fn:length(data) eq 0}">
		<div>
			<ul>
				<li style="display: block;color: red;font-size: 20px;">No Data Available For The Selected Date. </li>
			</ul>
		</div>
</c:if>	
	</center>
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
