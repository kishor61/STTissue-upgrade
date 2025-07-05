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
	.demo {
		border:1px solid #C0C0C0;
		border-collapse:collapse;
		padding:5px;
	}
	.demo th {
		border:1px solid #C0C0C0;
		padding:5px;
		background:#F0F0F0;
	}
	.demo td {
		border:1px solid #C0C0C0;
		padding:5px;
	}
</style>
<spring:url value="/wetlapinventory/view/report/sendmail" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send Wet Lat Report - Summary for '+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate :edate
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
					<span class="label">Wet Lap Inventory Report</span>
				</div>
				<div class="table-selector">
				<spring:url value="/wetlapinventory/view/report" var="viewURL"/>	
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
							<c:if test="${show}">
								<td>
										<input type="button" id="mailBtn" onclick="$('#mailFrom').submit();" value="Send Mail">
								</td>
							</c:if>	
						</tr>
					</table>
				</form>

				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${show}">
<center>
<table class="demo">
	<caption><b style="font-size: 19px;color: #0064FF;">Total Wet Lap Inventory Available - Summary</b></caption>
	<br>
	<thead>
	<tr>
		<th>Header 1</th>
		<th>Bale Count</th>
		<th>Gross Wt.(LBS)</th>
		<th>Net Wt.(LBS)</th>
		<th>Gross Wt.(TONS)</th>
		<th>Net Wt.(TONS)</th>
	</tr>
	</thead>
	<tbody>
<c:forEach items="${details}" var="wd">
	<tr>
		<td>FRP:</td>
		<td><center>${wd.totalbalesfrp}</center></td>
		<td><center><fmt:formatNumber value="${wd.frpgrosswtlbs}" maxFractionDigits="2" var="frpgrosswtlbs"/>${frpgrosswtlbs}</center></td>
		<td><center><fmt:formatNumber value="${wd.frpnetwtlbs}" maxFractionDigits="2" var="frpnetwtlbs"/>${frpnetwtlbs}</center></td>
		<td><center>${wd.frpgrosswtton}</center></td>
		<td><center>${wd.frpnetwtton}</center></td>
	</tr>

	<tr>
		<td>YARD:</td>
		<td><center>${wd.totalbalesyard}</center></td>
		<td><center><fmt:formatNumber value="${wd.yardgrosswtlbs}" maxFractionDigits="2" var="yardgrosswtlbs"/>${yardgrosswtlbs}</center></td>
		<td><center><fmt:formatNumber value="${wd.yardnetwtlbs}" maxFractionDigits="2" var="yardnetwtlbs"/>${yardnetwtlbs}</center></td>
		<td><center>${wd.yardgrosswtton}</center></td>
		<td><center>${wd.yardnetwtton}</center></td>
	</tr>
	<c:set value="${totalfrpgrosswtlbs+wd.frpgrosswtlbs}" var="totalfrpgrosswtlbs"/>
	<c:set value="${totalyardgrosswtlbs+wd.yardgrosswtlbs}" var="totalyardgrosswtlbs"/>		
	
	<c:set value="${totalfrpnetwtlbs+wd.frpnetwtlbs}" var="totalfrpnetwtlbs"/>
	<c:set value="${totalyardnetwtlbs+wd.yardnetwtlbs}" var="totalyardnetwtlbs"/>
	
	<c:set value="${totalfrpgrosswtton+wd.frpgrosswtton}" var="totalfrpgrosswtton"/>
	<c:set value="${totalyardgrosswtton+wd.yardgrosswtton}" var="totalyardgrosswtton"/>	
	
	<c:set value="${totalfrpnetwtton+wd.frpnetwtton}" var="totalfrpnetwtton"/>
	<c:set value="${totalyardnetwtton+wd.yardnetwtton}" var="totalyardnetwtton"/>
	
	<c:set value="${totalbalesinfrp+wd.totalbalesfrp}" var="totalbalesinfrp"/>
	<c:set value="${totalbalesinyard+wd.totalbalesyard}" var="totalbalesinyard"/>			
	
</c:forEach>	
<c:forEach items="${millDetails}" var="mill">	
	<tr>
		<td>MILL:</td>
		<td><center>${mill.totalbalesmill}</center></td>
		<td><center><fmt:formatNumber value="${mill.grosslbsmill}" maxFractionDigits="2" var="grosslbsmill"/>${grosslbsmill}</center></td>
		<td><center><fmt:formatNumber value="${mill.netlbsmill}" maxFractionDigits="2" var="netlbsmill"/>${netlbsmill}</center></td>
		<td><center>${mill.grosstonmill}</center></td>
		<td><center>${mill.nettonmill}</center></td>
	</tr>
	<c:set value="${totalgrosslbsmill+mill.grosslbsmill}" var="totalgrosslbsmill"/>	
	<c:set value="${totalnetlbsmill+mill.netlbsmill}" var="totalnetlbsmill"/>	
	
	<c:set value="${totalgrosstonmill+mill.grosstonmill}" var="totalgrosstonmill"/>
	<c:set value="${totalnettonmill+mill.nettonmill}" var="totalnettonmill"/>	
	
	<c:set value="${totalbalesinmill+mill.totalbalesmill}" var="totalbalesinmill"/>		
</c:forEach>
	<tr>
		<td>WetLap Total:</td>
		<td><center><b><fmt:formatNumber value="${totalbalesinfrp+totalbalesinyard+totalbalesinmill}" maxFractionDigits="2" var="totalbales"/>${totalbales}</b></center></td>
		<td><center><b><fmt:formatNumber value="${totalfrpgrosswtlbs+totalyardgrosswtlbs+totalgrosslbsmill}" maxFractionDigits="2" var="totalgrosslbs"/>${totalgrosslbs}</b></center></td>
		<td><center><b><fmt:formatNumber value="${totalfrpnetwtlbs+totalyardnetwtlbs+totalnetlbsmill}" maxFractionDigits="2" var="totalnetlbs"/>${totalnetlbs}</b></center></td>
		<td><center><b><fmt:formatNumber value="${totalfrpgrosswtton+totalyardgrosswtton+totalgrosstonmill}" maxFractionDigits="2" var="totalgrosston"/>${totalgrosston}</b></center></td>
		<td><center><b><fmt:formatNumber value="${totalfrpnetwtton+totalyardnetwtton+totalnettonmill}" maxFractionDigits="2" var="totalnetton"/>${totalnetton}</b></center></td>
	</tr>
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
