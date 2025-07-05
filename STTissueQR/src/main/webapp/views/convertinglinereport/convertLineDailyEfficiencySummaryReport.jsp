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
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
<spring:url value="/convertinglinereport/dailyefficiencyreport/summary/show/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send CL 171-Daily Efficiency Report Summary Report for '+sdate)){
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
	<jsp:include page="../_loader.jsp"/>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Converting Line 171 - Daily Efficiency Summary Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/convertinglinereport/dailyefficiencyreport/summary/show" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
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
								<input type="submit" value="View">
								&nbsp;
								&nbsp;
								<c:if test="${viewFlag}">
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
									&nbsp;
									&nbsp;
									<input type="button" value="Send Mail" id="sendMailBtn">
								</c:if>
								&nbsp;
							</td>
						</tr>
					</table>
				</form>
				<form id="exportFrom" action='<spring:url value="/convertinglinereport/dailyefficiencyreport/summary/show/export"/>'  method="GET" style="display:none; " target="_blank">
						<input type="hidden" name="sdate" value="${sdate}">
						<input type="hidden" name="edate" value="${edate}">
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
<table id="reportTable1" class="table" style="margin: auto;font-size: 12px;width: 70% !important;">
	<%-- <thead>
		<tr class="trobjrow">
			<th colspan="17">Converting Line - Production - ${date}</th>
		</tr>
		<tr>
			<th>Date</th>
			<th>Operating<br /> Start Time</th>
			<th>Operating<br /> End Time</th>
			<th>Operating Minute(s)</th>
			
			<!-- <th>Downtime<br /> Start Time</th>
			<th>Downtime<br /> End Time</th> -->
			
			<!-- <th>Operating Hour(s)</th> -->
			<th>Downtime Minute(s)</th>
			<th>Uptime (mins)</th>
			<th>Product SKU</th>
			<th>Cases Produced 1st Grade</th>
			<th>Cases Produced 2nd Grade</th>
			<th>Total Cases Produced</th>
			<th>Earned Hours</th>
			<!-- <th>1st Grade Ratio</th>
			<th>2st Grade Ratio</th> -->
			
			<!-- <th>Efficiency 1st Grade</th>
			<th>Efficiency 2st Grade</th> -->
			
			<!-- <th>Efficiency Target</th> -->
			<th>TSNS Cases</th>
			<th>Efficiency Total</th>
			<!-- <th>Ratio 1</th>
			<th>Ratio 2</th>		 -->
		</tr>
	</thead> --%>
	<tbody>
		<%-- <c:forEach items="${caseData}" var="cd">
			<tr>
				<td style="width: 50px;"><fmt:formatDate value="${cd.date}" pattern="MM/dd/yyyy"/></td>
				<td style="width: 100px;"><fmt:formatDate type = "time"  value = "${cd.startTime}" /></td>
				<td style="width: 100px;"><fmt:formatDate type = "time"  value = "${cd.endTime}" /></td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${cd.hourworked}" /></td>
				<!-- <td style="width: 100px;">DT Start Time</td>
				<td style="width: 100px;">DT End Time</td> -->
				
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2" value="${cd.hourworked/60}" /></td>
				<td style="width: 100px;">0</td>
				<td style="width: 100px;">${cd.uptime}</td>
				<td style="width: 100px;">${cd.skucode}</td>
				<td style="width: 100px;">${cd.firstcase}</td>
				<td style="width: 100px;">${cd.secodcase}</td>
				<td style="width: 100px;">${cd.totalcases}</td>
					<c:set value="${firstcase+cd.firstcase}" var="firstcase" />
					<c:set value="${secodcase+cd.secodcase}" var="secodcase" />
				<td style="width: 100px;"><fmt:formatNumber maxFractionDigits="2" value="${(firstcase/(firstcase+secodcase))*100}" /></td>
				<td style="width: 100px;"><fmt:formatNumber maxFractionDigits="2" value="${(secodcase/(firstcase+secodcase))*100}" /></td>
				<td style="width: 100px;">${cd.totalcases}</td>
				<td style="width: 100px;">${cd.totalcases}</td>
				<td style="width: 100px;">${cd.earnedhours}</td>
				<td style="width: 100px;">${cd.tsnscases}</td>
				<td style="width: 100px;">${cd.actualefficency} %</td>
			</tr>
		</c:forEach> --%>
			<tr><td colspan="17"><div>&nbsp;<br></div></td></tr>
			<tr><td colspan="17"><div style="
						font-size: 18px;
						color: rgb(255, 255, 255);
						background-color: rgb(203, 132, 46);">Converting Line 171 - Daily Efficiency Summary Report<br></div></td></tr>
			<tr>
				<td colspan="2"  style="width: 100px;"><b>Date</b></td>
				<td style="width: 100px;"><b>Day</b></td>
				<th>Staffed Time<!-- Uptime (mins )--></th>
				<th>Operating Minute(s)</th>
				<th>Downtime Minute(s)</th>
				<th>Rewinder Speed</th>
				<th>Product SKU</th>
				<th>Cases Produced 1st Grade</th>
				<th>Cases Produced 2nd Grade</th>
				<th>Total Cases Produced</th>
				<th>Earned Hours</th>
				<td style="width: 100px;"><b>Total Efficiency</b></td>
			</tr>
	<% int i=0; %>	
			
<c:forEach items="${details}" var="detail">
			<c:if test ="${detail.dontshow eq'YES'}">
			</c:if>
			
			<c:if test ="${detail.dontshow ne'YES'}">
			
			<tr>
				<td colspan="2" style="width: 100px;"><fmt:formatDate value="${detail.date}" pattern="MM/dd/yyyy"/></td>
				<td style="width: 100px;">${detail.day}</td>
				<td style="width: 100px;">${detail.uptime}</td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${detail.hourworked}" /></td>
				<td style="width: 100px;">${detail.downtime}</td>
				<td style="width: 100px;">${detail.speed}</td>
				<td style="width: 100px;">${detail.skucode}</td>
				<td style="width: 100px;">${detail.firstcase}</td>
				<td style="width: 100px;">${detail.secodcase}</td>
				<td style="width: 100px;">${detail.totalcases}</td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${detail.earnedhours}" /></td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${detail.totalEfficiency}" /> %</td>
			</tr>
			<c:set value="${grandTotalHourWorked+detail.hourworked}" var="grandTotalHourWorked"/>
			<c:set value="${grandTotalUpTime+detail.uptime}" var="grandTotalUpTime"/>
			<c:set value="${grandTotalFistCases+detail.firstcase}" var="grandTotalFistCases"/>
			<c:set value="${grandTotalSecondCases+detail.secodcase}" var="grandTotalSecondCases"/>
			<c:set value="${grandTotalCases+detail.totalcases}" var="grandTotalCases"/>
			<c:set value="${grandTotalEarnedHours+detail.earnedhours}" var="grandTotalEarnedHours"/>
			
			<c:set value="${totalspeed+detail.speed}" var="totalspeed"/>
			
			<c:set value="${totaldowntime+detail.downtime}" var="totaldowntime"/>
			
			<c:set value="${totalEffi+detail.totalEfficiency}" var="totalEffi"/>
			
			<% i++;%>
			 
			</c:if>
			<c:set var="test" value="<%=i%>"/>
			
		</c:forEach>
		
	</tbody>
	<tr style="background-color: rgba(203, 132, 46, 0.68);font-style: oblique;font-weight: 700;">
				<td colspan="2" style="width: 100px;"></td>
				<td style="width: 100px;">Total</td>
				<td style="width: 100px;">${grandTotalUpTime}</td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${grandTotalHourWorked}" /></td>
				<td style="width: 100px;">${totaldowntime}</td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="0"  value="${totalspeed/test}" /></td>
				<td style="width: 100px;"></td>
				<td style="width: 100px;">${grandTotalFistCases}</td>
				<td style="width: 100px;">${grandTotalSecondCases}</td>
				<td style="width: 100px;">${grandTotalCases}</td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${grandTotalEarnedHours}" /></td>
				<td style="width: 100px;"><fmt:formatNumber minIntegerDigits="2"  value="${totalEffi/test}" /> %</td>
	</tr>
	<tr>
				<td colspan="17"><div>&nbsp;<br></div></td>
	</tr>
	<tr>
		<td colspan="17"><div style="
						font-size: 18px;
						color: rgb(255, 255, 255);
						background-color: rgb(203, 132, 46);">Converting Line 171 - Monthly Efficiency Summary Report<br></div>
		</td>
	</tr>
<c:forEach items="${fullCaseData}" var="data">
	<tr>
				<td colspan="2" style="width: 100px;font-style: oblique;font-weight: 700;">${data.month}-${data.year}</td>
				<td colspan="1" style="width: 100px;font-style: oblique;font-weight: 700;"></td>
				<td>${data.staffedtime}</td>
				<td>${data.operatingminute}</td>
				<td>${data.downtimeminute}</td>
				<td>${data.rewinderspeed}</td>
				<td></td>
				<td>${data.casesproduced1stgrade}</td>
				<td>${data.casesproduced2ndgrade}</td>
				<td>${data.totalcasesproduced}</td>
				<td>${data.earnedhours}</td>
				<td>${data.totalEfficiency} %</td>
				
	</tr>
</c:forEach>
<tr>
				<td colspan="17"><div>&nbsp;<br></div></td>
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
