<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/frpproductionopdataentry/view/report/data" var="viewReportURL" />
<spring:url value="/frpproductionopdataentry/view/report/data/sendmail" var="emailURL"/>
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
	$('#printBtn').click(function(){
		$('#printDiv').printArea();
	});
});
</script> 
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send summary report for '+sdate)){
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
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="../header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
				<div class="page-title">
					<span class="label">FRP Production Operator Data Entry Report</span>
				</div>
				<div class="table-selector">
					
					<form name="dataForm" action="${viewReportURL}" method="get">	
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
								&nbsp;
								&nbsp;
							</td>
							<c:if test="${showreport}">
								<td>
									<button type="button" id="printBtn">Print</button>
								</td>
								<td>
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Detailed Report">
								</td>
								<td>
									<input type="button" id="mailBtn" onclick="$('#mailFrom').submit();" value="Send Mail">
								</td>
							</c:if>
						</tr>
					</table>
				</form>

				</div>
<form id="exportFrom" action='<spring:url value="/frpproductionopdataentry/view/report/data/detailedreport"/>' method="get">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<%-- <form id="mailFrom" action='<spring:url value="/frpproductionopdataentry/view/report/data/detailedreport/sendmail"/>' method="get">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form> --%>
<c:if test="${showreport}">
		<c:if test="${fn:length(details) eq 0 }">	
			<div>
				<p><b style="color: red;">No Data Found For Related Search.</b></p>
			</div>	
		</c:if>	
		<!-- --------------------------------------------------------------------------- -->
<br>		
<c:if test="${fn:length(details) > 0 }">	
<div id="printDiv">
<center>
<center><b style="color: green;">Waste Paper Report From <b style="color: red;">${sdate}</b> To <b style="color: red;">${edate}</b></b></center>	
<br>		
<c:forEach items="${details}" var="data">
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		
		<tr>
			<td style="width: 242px;"></center></td>
			<td style="width: 242px;"><center><b>Day Shift</b></center></td>
			<td style="width: 242px;"><center><b>Night Shift</b></center></td>
			<td style="width: 242px;"><center><b>Daily Total / Average</b></center></td>
<%-- 			<td style="width: 242px;"><center><b>Previous Day</b></center></td> --%>
			
		</tr>
		<tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center><fmt:formatNumber value="${data.col1forday}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.col1fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol1}" maxFractionDigits="2"/></center></td>
<!-- 			<td></td> -->
			
		</tr>
		<%-- <tr>
			<td><center><b>60 # STEAM TO<BR>BACKUP HEATER<BR>430-FT-6946</b></center></td>
			<td><center><fmt:formatNumber value="${data.col2forday}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.col2fornight}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.totalcol2}" maxFractionDigits="2"/></center></td>
<!-- 			<td></td> -->
			
		</tr> --%>
		<tr>
			<td><center><b>WATER TO FIRE/<BR>MILL WATER TANK<BR>430-FT-6956<br># 1008</b></center></td>
			<td><center><fmt:formatNumber value="${data.col3forday}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.col4fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol3}" maxFractionDigits="2"/></center></td>
<!-- 			<td></td> -->
			
		</tr>
		<tr>
			<td><center><b>FIRE SYSTEM WATER<BR>430-FT-6959<br># 1009</b></center></td>
			<td><center><fmt:formatNumber value="${data.col4forday}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.col4fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol4}" maxFractionDigits="2"/></center></td>
<!-- 			<td></td> -->
			
		</tr>
		<tr>
			<td><center><b>DEINKING PLANT<BR>EFFLUENT<BR>431-FT-6083</b></center></td>
			<td><center><fmt:formatNumber value="${data.col5forday}" maxFractionDigits="2"/></center>/td>
			<td><center><fmt:formatNumber value="${data.col5fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol5}" maxFractionDigits="2"/></center></td>

			
		</tr>
		<tr>
			<td><center><b>SEWER FLOW</b></center></td>
			<td><center><fmt:formatNumber value="${data.col12forday}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.col12fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol12}" maxFractionDigits="2"/></center></td>

			
		</tr>
		<%-- <tr>
			<td><center><b>HD LEVEL AS OF<BR>7 AM TO 7PM</b></center></td>
			<td><center><fmt:formatNumber value="${data.col11forday}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.col11fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol11}" maxFractionDigits="2"/></center></td>	
		</tr> --%>
	</table>
	<br>	
		<center><p ><b>ALL MEASUREMENTS ABOVE IN GALLONS</b></p></center>
	<br>
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 112px;"><center><b><p style="color: green;">Line-A</p>HD LEVEL AS OF<BR>7 AM / 7PM</b></center></td>
			<td style="width: 90px;"><center><fmt:formatNumber value="${data.col11forday}" maxFractionDigits="2"/></center</td>
			<td style="width: 105px;"><center><fmt:formatNumber value="${data.col11fornight}" maxFractionDigits="2"/></center></td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${data.totalcol11/2}" maxFractionDigits="2"/></center</td>		
		</tr>
		<tr>
			<td style="width: 112px;"><center><b><p style="color: green;">Line-A</p>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td style="width: 90px;"><center><fmt:formatNumber value="${data.col6forday}" maxFractionDigits="2"/></center</td>
			<td style="width: 105px;"><center><fmt:formatNumber value="${data.col6fornight}" maxFractionDigits="2"/></center></td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${data.totalcol6}" maxFractionDigits="2"/></center</td>		
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p>WETLAP TONS<BR>PRODUCED</b></center></td>
			<td><center><fmt:formatNumber value="${data.col7forday}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.col7fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol7}" maxFractionDigits="2"/></center</td>
		</tr>
		<tr>
			<c:set value="${totalcol6+data.col6forday+data.col7forday}" var="col6forday"/>	
			<c:set value="${totalcol6+data.col6fornight+data.col7fornight}" var="col6fornight"/>	
			<c:set value="${totalcol6+data.totalcol6+data.totalcol7}" var="totalcol6"/>		
			
			<td style="width: 112px;"><center><b><p style="color: green;">Line-A</p>YIELD</b></center></td>
			<%-- <td style="width: 90px;"><center>${data.col8forday}</center</td>
			<td style="width: 105px;"><center>${data.col8fornight}</center></td> --%>
			<td style="width: 100px;"><center><fmt:formatNumber value="${col6forday/data.col9forday*100}" maxFractionDigits="2"/></center</td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${col6fornight/data.col9fornight*100}" maxFractionDigits="2"/></center</td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${totalcol6/data.totalcol9*100}" maxFractionDigits="2"/></center</td>
		</tr>
		<tr>
			<td style="width: 99x;width: 112px !important;"><center><b><p style="color: green;">Line-A</p>WASTE PAPER FED<BR(TONS)</b></center></td>
			<td style="width: 90px;"> <center><fmt:formatNumber value="${data.col9forday}" maxFractionDigits="2"/></center</td>
			<td style="width: 105px;"><center><fmt:formatNumber value="${data.col9fornight}" maxFractionDigits="2"/></center></td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${data.totalcol9}" maxFractionDigits="1"/></center</td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center><fmt:formatNumber value="${data.col10forday}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.col10fornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol10}" maxFractionDigits="1"/></center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p># Current Run Rate </b><br></center></td>
			<td><center><fmt:formatNumber value="${data.col10aforday}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.col10afornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol10a}" maxFractionDigits="1"/></center></td>
		</tr>
		
	</table>
	
	<!-- Code Starts From Here For Line B -->
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 112px;"><center><b><p style="color: green;">Line-B</p>PCC Tank LEVEL AS OF<BR>7 AM / 7PM</b></center></td>
			<td style="width: 90px;"><center><fmt:formatNumber value="${data.col11bforday}" maxFractionDigits="2"/></center</td>
			<td style="width: 105px;"><center><fmt:formatNumber value="${data.col11bfornight}" maxFractionDigits="2"/></center></td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${data.totalcol11b/2}" maxFractionDigits="2"/></center</td>		
		</tr>
		<tr>
			<td style="width: 112px;"><center><b><p style="color: green;">Line-B</p>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td style="width: 90px;"><center><fmt:formatNumber value="${data.col6bforday}" maxFractionDigits="2"/></center</td>
			<td style="width: 105px;"><center><fmt:formatNumber value="${data.col6bfornight}" maxFractionDigits="2"/></center></td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${data.totalcol6b}" maxFractionDigits="2"/></center</td>		
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p>WETLAP TONS<BR>PRODUCED</b></center></td>
			<td><center><fmt:formatNumber value="${data.col7bforday}" maxFractionDigits="2"/></center</td>
			<td><center><fmt:formatNumber value="${data.col7bfornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol7b}" maxFractionDigits="2"/></center</td>
		</tr>
		<tr>
			<c:set value="${totalcol6b+data.col6bforday+data.col7bforday}" var="col6bforday"/>	
			<c:set value="${totalcol6b+data.col6bfornight+data.col7bfornight}" var="col6bfornight"/>	
			<c:set value="${totalcol6b+data.totalcol6b+data.totalcol7b}" var="totalcol6b"/>		
			
			<td style="width: 112px;"><center><b><p style="color: green;">Line-B</p>YIELD</b></center></td>
			<%-- <td style="width: 90px;"><center>${data.col8forday}</center</td>
			<td style="width: 105px;"><center>${data.col8fornight}</center></td> --%>
			<td style="width: 100px;"><center><fmt:formatNumber value="${col6bforday/data.col9bforday*100}" maxFractionDigits="2"/></center</td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${col6bfornight/data.col9bfornight*100}" maxFractionDigits="2"/></center</td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${totalcol6b/data.totalcol9b*100}" maxFractionDigits="2"/></center></td>
		</tr>
		<tr>
			<td style="width: 99x;width: 112px !important;"><center><b><p style="color: green;">Line-B</p>WASTE PAPER FED<BR(TONS)</b></center></td>
			<td style="width: 90px;"> <center><fmt:formatNumber value="${data.col9bforday}" maxFractionDigits="2"/></center></td>
			<td style="width: 105px;"><center><fmt:formatNumber value="${data.col9bfornight}" maxFractionDigits="2"/></center></td>
			<td style="width: 100px;"><center><fmt:formatNumber value="${data.totalcol9b}" maxFractionDigits="1"/></center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center><fmt:formatNumber value="${data.col10bforday}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.col10bfornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol10b}" maxFractionDigits="1"/></center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p># Current Run Rate </b><br></center></td>
			<td><center><fmt:formatNumber value="${data.col12bforday}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.col12bfornight}" maxFractionDigits="2"/></center></td>
			<td><center><fmt:formatNumber value="${data.totalcol12b}" maxFractionDigits="1"/></center></td>
		</tr>
	</table>
	<!-- Code Ends Here For Line B -->
</c:forEach>
</center>
</div>
		</c:if>
		<!-- --------------------------------------------------------------------------- -->
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
