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
.table-selector table input[type=text] {
	width: 100px;
	text-align: center;
}
.table td div{
	width: inherit !important;
	text-align: center;
}
.table tfoot td{
	text-align: center;
}
.trrowgray{
	background-color: rgb(235, 235, 235);
}
.table td {
    font-size: 11px;
    padding: 2px;
    text-align: center;
    font-size: 13px;
    
}
</style>

<script type="text/javascript">
$(function(){
	$('input[name=date]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
<spring:url value="/convertinglinereport/reportconvertinglineproduction/export/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		/* $('#exportBtn').click(function(){
			$('#exportForm').submit();
			return false;
		});
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		}); */
		
		$('#sendMailBtn').click(function(){
			var shift=$('select[name=shift]').val();
			var date=$('input[name=date]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send summary report for '+date)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						date : date,
						shift :shift
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
	<jsp:include page="../_loader.jsp"/>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Converting Line Production - Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/convertinglinereport/viewsummary/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="date" value="${date}">							
							</td>
							<td>Shift</td>
							<td>
								<c:set value="${fn:split('1,2,3',',')}" var="shifts"/>	
								<select name="shift" style="width: 80px;">
									<option value="All">All</option>
									<c:forEach items="${shifts}" var="sh">
										<c:choose>
											<c:when test="${sh eq shift }">
												<option value="${sh}" selected="selected">${sh}</option>
											</c:when>
											<c:otherwise>
												<option value="${sh}">${sh}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>						
							</td>
							<td>
								<input type="submit" value="View">
								&nbsp;
								&nbsp;
								<c:if test="${viewFlag}">
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
									&nbsp;
									<!-- <input type="button" id="printBtn" value="Print"> -->
									&nbsp;
									<input type="button" value="Send Mail" id="sendMailBtn">
								</c:if>
								&nbsp;
								
							</td>
						</tr>
					</table>
				</form>
				<form id="exportFrom" action='<spring:url value="/convertinglinereport/reportconvertinglineproduction/export"/>'  method="GET" style="display:none; " target="_blank">
						<input type="hidden" name="sdate" value="${date}">
						<input type="hidden" name="shift" value="${shift}">
				</form>
				</div>
				
				
				<br>
				<br>

<div style="position: absolute;bottom: 0;width: 98%;top: 103px;overflow: auto;">
<c:if test="${viewFlag}">
<br>
<br>
<div id="printDiv">
<table id="reportTable1" class="table" style="width: 600px; margin: auto; font-size: 12px;">
	<thead>
		<tr class="trobjrow">
			<th colspan="6">Converting Line - Production - ${date}</th>
		</tr>
		<tr class="trobjrow">
			<th colspan="3">Date : ${date}</th>
			<th colspan="3">Shift : ${shift}</th>
		</tr>
		<tr>
			<!-- <th>Date</th>
			<th>Shift</th> -->
			<th colspan="2">Reel Number</th>
			<th colspan="2">Grade Code</th>
			<!-- <th>Total Weight</th>
			<th>Diameter</th>
			<th>Roll Width</th>
			<th>Parent Core</th> -->
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${parentData}" var="pd">
			<tr>
				<%-- <td  style="width: 70px;"><div><fmt:formatDate value="${pd.date}" pattern="MM/dd/yyyy"/></div></td>
				<td style="width: 50px;"><div>${pd.shift}</div></td> --%>
				<td colspan="2" style="width: 100px;">${pd.parentrollid}</td>
				<td colspan="2" style="width: 100px;">${pd.parentgradecode}</td>
				
			</tr>
		</c:forEach>
		<tr class="trobjrow">
			<th colspan="8">Converting Item</th>
		</tr>
		<tr>
			<th colspan="2">SKU<br />Code</th>
			<th>Cases Produced<br />1st Grade</th>
			<th>Cases Produced<br />2nd Grade</th>
		</tr>
		<c:forEach items="${caseData}" var="cd">
			<tr>
				<td colspan="2" style="width: 50px;">${cd.skucode}</td>
				<td style="width: 100px;">${cd.firstcase}</td>
				<td style="width: 100px;">${cd.secodcase}</td>
			</tr>
		</c:forEach>
				<c:forEach items="${caseData}" var="cd">
					<c:set value="${firstcase+cd.firstcase}" var="firstcase" />
					<c:set value="${secodcase+cd.secodcase}" var="secodcase" />
				</c:forEach>
			<tr>
				<td colspan="8"><div>&nbsp;<br></div></td>
			</tr>	
			<tr style="background-color: rgba(24, 23, 39, 0.28);">
				<td colspan="2" style="width: 50px;"><b>Total</b></td>
				<td style="width: 100px;"><b>${firstcase}</b></td>
				<td style="width: 100px;"><b>${secodcase}</b></td>
			</tr>
			<tr style="background-color: rgba(24, 23, 39, 0.28);">
				<td colspan="2" style="width: 50px;"><b>Ratio</b></td>
				<td style="width: 100px;"><b><fmt:formatNumber value="${(firstcase/(firstcase+secodcase))*100}" maxFractionDigits="2"/>%</b></td>
				<td style="width: 100px;"><b><fmt:formatNumber value="${(secodcase/(firstcase+secodcase))*100}" maxFractionDigits="2"/>%</b></td>
			</tr>
	</tbody>
	
	<tr>
					<td colspan="8"><div>&nbsp;<br></div></td>
	</tr>
</table>
</div>
</c:if>					
				</div>

			</div>

		</div>


	</div>

</body>
</html>
