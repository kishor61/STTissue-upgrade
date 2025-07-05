<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


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
<spring:url value="/productionreport/report/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		
		
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send PM6 PRODUCTION - REPORT for :'+sdate)){
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
					<span class="label">PM6 Production - Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/productionreport/view/data" var="viewURL"/>
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
									<input type="button" id="exportBtn" value="Export">
								</c:if>
								<c:if test="${viewFlag}">
							<td>
								<input type="button" value="Send Mail" id="sendMailBtn">
							</td>
							</c:if>
							</td>
						</tr>
					</table>
				</form>
				
				</div>
				
				
				<br>
				<br>

<div style="position: absolute;bottom: 0;width: 98%;top: 103px;overflow: auto;">
<c:if test="${viewFlag}">

<script type="text/javascript">
	$(function(){
		$('#exportBtn').click(function(){
			$('#exportForm').submit();
			return false;
		});
	});
</script>

<spring:url value="/productionreport/export" var="exportURL"/>
<form target="_blank" id="exportForm" action="${exportURL}" method="post">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>


<table id="reportTable" class="table" style="margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th>Date</th>
			<th>Reel<br>Tons<br>Gross</th>
			<th>Reel<br>Tons<br>Reject</th>
			<th>Net White<br>Reel Tons</th>
			<th>Wrapper White<br>Tons</th>
			<th>Wrapper Red<br>Tons</th>
			<th>Wrapper Reject<br>Tons</th>
			<th>Total Wrapped<br>Tons</th>
			<th>MTD Avg. Prod.       Tons</th>
			<th>Trim</th>
			<th>Process<br>Loss<br>Tons</th>
			<th>Machine<br>Speed<br>(Yankee)</th>
			<th>Total<br> Days<br> Process<br>Downtime<br>Minutes</th>
			<th>Total<br> Night<br> Process<br>Downtime<br>Minutes</th>
			<th>Total<br> Process<br>Downtime<br>Minutes</th>
			<th>Total<br> TM Down<br>Time<br> Minutes</th>
			<!-- Code Starts From Here Done By Roshan Tailor -->
			<th>Actual<br> Calendar<br> Minutes</th>
			<th>Un-Controllable<br>Down Time<br> Minutes</th>
			<!-- Code Ends Here Done By Roshan Tailor -->
			<th>Paper<br>Yield (%)</th>
			<th>First<br>Quality (%)</th>
			<th>UpTime<br>(%)</th>
			<th>Efficiency<br>(%)</th>
			<th>Product<br>Code</th>
			<th>Customer</th>
			<th>Comment</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(datas)>0}">
		<c:forEach items="${datas}" var="data">
			<tr>
				<td style="width: 80px;"><div>${data['1']}</div></td>
				<td style="width: 60px;"><div>${data['2']}</div></td>
				<td style="width: 60px;"><div>${data['24']}</div></td>
				<td style="width: 60px;"><div>${data['25']}</div></td>
				<td style="width: 60px;"><div>${data['3']}</div></td>
				<td style="width: 60px;"><div>${data['4']}</div></td>
				<td style="width: 60px;"><div>${data['23']}</div></td>
				<td style="width: 60px;"><div>${data['5']}</div></td>
				<td style="width: 60px;"><div>${data['6']}</div></td>
				<td style="width: 60px;"><div>${data['7']}</div></td>
				<td style="width: 60px;"><div>${data['8']}</div></td>
				<td style="width: 60px;"><div>${data['9']}</div></td>
				<td style="width: 60px;"><div>${data['10']}</div></td>
				<td style="width: 60px;"><div>${data['11']}</div></td>
				<td style="width: 60px;"><div>${data['12']}</div></td>
				<td style="width: 60px;"><div>${data['13']}</div></td>
				<!--Code Starts From Here Done By Roshan Tailor-->
				<td style="width: 60px;"><div>${data['22']}</div></td>
				<td style="width: 60px;"><div>${data['21']}</div></td>
				<!--Code Ends Here Done By Roshan Tailor-->
				<td style="width: 60px;"><div>${data['14']}</div></td>
				<td style="width: 60px;"><div>${data['15']}</div></td>
				<td style="width: 60px;"><div>${data['16']}</div></td>
				<td style="width: 60px;"><div>${data['17']}</div></td>
				<td style="width: 80px;"><div>${data['18']}</div></td>
				<td style="width: 200px;"><div>${data['19']}</div></td>
				<td style="width: 200px;"><div>${data['20']}</div></td>
				
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${fn:length(datas) eq 0}">
			<tr>
				<td colspan="1"><div>Data not available for this selection.</div><td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td>Total</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
<!-- Code Starts From Here Done By Roshan Tailor -->
			<td></td>
			<td></td>
<!-- Code Ends Here Done By Roshan Tailor -->
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
	</tfoot>

</table>

<script type="text/javascript">
	$(function(){
		var row=$('#reportTable tbody tr').length;
		var col=$('#reportTable tbody tr:nth-child(1) td').length;
		
		
		var totalAvg=0;
		var machineSpeed=0;
		var reelTon=0;
		var totalTon=0;
		var whiteTon=0;
		var rejectTon=0;
		var processDowntime=parseFloat($('#reportTable tfoot tr:eq(0)').find('td:eq(11)').text()) || 0;
		var machineDowntime=parseFloat($('#reportTable tfoot tr:eq(0)').find('td:eq(12)').text()) || 0;
		
		//Code Starts From Here Done By Roshan Tailor Date :- 10/06/2016
			var restDownTime=parseFloat($('#reportTable tfoot tr:eq(0)').find('td:eq(14)').text()) || 0; //Un-Controllable Down Time Minutes
		//Code Ends Here Done By Roshan Tailor
		
		if(row){
			for(var c=0;c<col;c++){
				var total=0;
				for(var r=0;r<row;r++){
					var txt=$('#reportTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					if($.isNumeric( txt )){
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0 | c==5 | c==13  | c==15 | c==16){
						//No Query
					}else if(c==1){
						reelTon=total;
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));
					}else if(c==2){
						whiteTon=total;
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));
					}else if(c==11){
						processDowntime=total;
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));
					}else if(c==12){
						machineDowntime=total;
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));
					}else if(c==4){
						totalTon=total;
						totalAvg=total/row;
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));
					}else if(c==8){
						machineSpeed=total/row;
					}else{
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));	
					}
				}
			}
		}
		
		
		
		
		var yieldTotal=0;
		if(reelTon!=0){
			yieldTotal=(totalTon/reelTon);
		}
		var qualityTotal=0;
		if(totalTon!=0){
			qualityTotal=(whiteTon/totalTon);
		}
		//Old Formula
		//var uptimeTotal=((1440*row-(processDowntime+machineDowntime))/(1440*row));
		
		//New Formula
		var uptimeTotal=((100-(processDowntime+machineDowntime)/(1440-restDownTime)))/100;
		
		
		var effiTotal=(yieldTotal*qualityTotal*uptimeTotal);
		
		$('#reportTable tfoot tr:eq(0)').find('td:eq(8)').text(machineSpeed.toFixed(2));
		$('#reportTable tfoot tr:eq(0)').find('td:eq(5)').text(totalAvg.toFixed(2));
		$('#reportTable tfoot tr:eq(0)').find('td:eq(15)').text((yieldTotal*100).toFixed(2));
		$('#reportTable tfoot tr:eq(0)').find('td:eq(16)').text((qualityTotal*100).toFixed(2));
		$('#reportTable tfoot tr:eq(0)').find('td:eq(17)').text((uptimeTotal*100).toFixed(2));
		$('#reportTable tfoot tr:eq(0)').find('td:eq(18)').text((effiTotal*100).toFixed(2));
			
	});

</script>

</c:if>					
				</div>

			</div>

		</div>


	</div>

</body>
</html>
