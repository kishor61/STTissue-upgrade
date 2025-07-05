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
.dtable {
	border-collapse: collapse;
}

.dtable td, .dtable th {
	border: 1px solid gray;
	text-align: center;
}

.hbg {
	background-color: #EEE;
}

.dtable textarea {
	width: 535px;
	height: 50px;
	resize: none;
	margin-bottom: -4px;
}
</style>
<spring:url value="/pmsummarydatareport/mail/pdf" var="mailURL"/>
<script type="text/javascript">
$(function(){
	$('#sendMailBtn').click(function(){
		var btn=$(this);	
		btn.prop("disabled",true);
			
			
			$('#tmessage').text('Sending mail.....');
			$.ajax({
				url:'${mailURL}',
				type:'POST',
				data: {id:'${summaryData.id}'},
				success:function(data){
					if(data.flag){
						
						$('#tmessage').text('Mail sent successfully.');
						
						mailTimer=setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
						
					}else{
						alert(data.error);
					}
					
					
					btn.prop("disabled",false);
				}
					
			});
		
	});
	
	
	$('#tableData').find('td').each(function(){
		var val=$(this).text();
		if(val=='0' | val=='0.0'){
			$(this).text('');
		}
	});
	
	
		$('#backBtn').button({
			icons : {
				primary : "ui-icon-circle-arrow-w"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-pencil"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-mail-closed"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-trash"
			}
		}).next().button({
			icons : {
				primary : " ui-icon-document"
			}
		});
		
		
		$('#deleteBtn').click(function(){
			if(confirm("Are you sure you want to delete this?")){
				return true;
			}else{
				return false;
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
					<span class="label">Daily Summary - Report</span>
				</div>
				<br>
				<div class="table-selector">
					<table>
						<tr>
							<td>
								<a id="backBtn" href='<spring:url value="/pmsummarydatareport/load/date?sdate=${sdate}&edate=${edate}"/>'>BACK</a>
								<a href='<spring:url value="/pmsummarydata/edit?id=${summaryData.id}&sdate=${sdate}&edate=${edate}"/>'>EDIT</a>
								<button id="sendMailBtn">SEND MAIL</button>
								<a href='<spring:url value="/pmsummarydata/delete?id=${summaryData.id}&sdate=${sdate}&edate=${edate}"/>' id="deleteBtn">DELETE</a>
								<a href='<spring:url value="/pmsummarydatareport/export/pdf/${summaryData.id}"/>' target="_blank">PDF</a>
							</td>
							
							
						</tr>
					</table>
	
				</div>

				<br>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table class="dtable" style="width: auto;; margin: auto;" id="tableData">
	<tr>
		<td><b>Date: &nbsp;&nbsp; </b>
			<fmt:formatDate value="${summaryData.date}" pattern="MM-dd-yyyy"/>
		</td>
		<td></td>
		<td colspan="3"><b>Production Date :&nbsp;&nbsp;</b> 
			<fmt:formatDate value="${summaryData.productionDate}" pattern="MM-dd-yyyy"/>
		</td>

	</tr>
	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	<tr class="hbg">
		<td></td>
		<td><div style="width: 250px;"></div></td>
		<td style="width: 100px;"><b>Yesterday</b></td>
		<td style="width: 100px;"><b>Month To Date</b></td>
		<td style="width: 100px;"><b>Goal</b></td>
	</tr>

	<tr>
		<td rowspan="5" valign="top"><b>Safety</b></td>
		<td style="text-align: left;">Days Without Recordable Injury</td>
		<td>${summaryData.safety_Y01 }</td>
		<td></td>
		<td>${summaryData.safety_G01 }</td>
	</tr>
	<tr>
		<td style="text-align: left;">Days Without Lost Time Injury</td>
		<td>${summaryData.safety_Y02 }</td>
		<td></td>
		<td>${summaryData.safety_G02 }</td>
	</tr>
	<tr>
		<td style="text-align: left;">First Aid Cases</td>
		<td>${summaryData.safety_Y03 }</td>
		<td>${summaryData.safety_MTD03 }</td>
		<td></td>
	</tr>

	<tr>
		<td style="text-align: left;">Incident/Near Miss Reports</td>
		<td>${summaryData.safety_Y04 }</td>
		<td>${summaryData.safety_MTD04 }</td>
		<td></td>
	</tr>

	<tr>
		<td style="text-align: left;">Safety Meeting Topic</td>
		<td colspan="2" style="text-align: left;">${summaryData.safetyMeetingTopic}</td>
		<td></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4" style="text-align: left;">${summaryData.safetyComment}</td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>



	<tr>
		<td rowspan="1" valign="top"><b>Housekeeping</b></td>
		<td style="text-align: left;">Fire Incidents</td>
		<td>${summaryData.housekeeping_Y01 }</td>
		<td>${summaryData.housekeeping_MTD01 }</td>
		<td>${summaryData.housekeeping_G01 }</td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"  style="text-align: left;">${summaryData.housekeepingCommnet }</td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td rowspan="4" valign="top"><b>Quality</b></td>
		<td style="text-align: left;">First Quality Percentage</td>
		<td>${summaryData.quality_Y01 }</td>
		<td>${summaryData.quality_MTD01 }</td>
		<td>${summaryData.quality_G01 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Red Tons</td>
		<td>${summaryData.quality_Y02 }</td>
		<td>${summaryData.quality_MTD02 }</td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Cull Tons (Slaboff)</td>
		<td>${summaryData.quality_Y03 }</td>
		<td>${summaryData.quality_MTD03 }</td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Reject</td>
		<td>${summaryData.quality_Y04 }</td>
		<td>${summaryData.quality_MTD04 }</td>
		<td></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4" style="text-align: left;">${summaryData.qualityComment }</td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td rowspan="9" valign="top"><b>Fiber Production</b></td>
		<td style="text-align: left;">Input Tons</td>
		<td>${summaryData.fiberProd_Y01 }</td>
		<td>${summaryData.fiberProd_MTD01 }</td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Output Tons</td>
		<td>${summaryData.fiberProd_Y02 }</td>
		<td>${summaryData.fiberProd_MTD02 }</td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">White Yield</td>
		<td>${summaryData.fiberProd_Y03 }</td>
		<td>${summaryData.fiberProd_MTD03 }</td>
		<td>${summaryData.fiberProd_G03 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Last 24 hrs. Brightness</td>
		<td>${summaryData.fiberProd_Y04 }</td>
		<td>${summaryData.fiberProd_MTD04 }</td>
		<td>${summaryData.fiberProd_G04 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Current Brightness</td>
		<td>${summaryData.fiberProd_Y05 }</td>
		<td>${summaryData.fiberProd_MTD05 }</td>
		<td>${summaryData.fiberProd_G05 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">White % SOW & CBS</td>
		<td>${summaryData.fiberProd_Y06 }</td>
		<td>${summaryData.fiberProd_MTD06 }</td>
		<td>${summaryData.fiberProd_G06 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Kraft Yield</td>
		<td>${summaryData.fiberProd_Y07 }</td>
		<td>${summaryData.fiberProd_MTD07 }</td>
		<td>${summaryData.fiberProd_G07 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Kraft % Gwd/Mixed Paper</td>
		<td>${summaryData.fiberProd_Y08 }</td>
		<td>${summaryData.fiberProd_MTD08 }</td>
		<td>${summaryData.fiberProd_G08 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Sludge % Solids</td>
		<td>${summaryData.fiberProd_Y09 }</td>
		<td>${summaryData.fiberProd_MTD09 }</td>
		<td>${summaryData.fiberProd_G09 } %</td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4" style="text-align: left;">${summaryData.fiberProdComment }</td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	<tr>
		<td rowspan="7" valign="top"><b>Paper Production</b></td>
		<td style="text-align: left;">Reel Tons (Machine Production Actual)</td>
		<td>${summaryData.paperProd_Y01 }</td>
		<td>${summaryData.paperProd_MTD01 }</td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">White Tons</td>
		<td>${summaryData.paperProd_Y02 }</td>
		<td>${summaryData.paperProd_MTD02 }</td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Machine Efficiency</td>
		<td>${summaryData.paperProd_Y03 }</td>
		<td>${summaryData.paperProd_MTD03 }</td>
		<td>${summaryData.paperProd_G03 } %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Rewinder Sets (D/N)</td>
		<td>${summaryData.paperProd_Y04 }</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Rewinder Speed</td>
		<td>${summaryData.paperProd_Y05}</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Paper Yield</td>
		<td>${summaryData.paperProd_Y06}</td>
		<td>${summaryData.paperProd_MTD06}</td>
		<td>${summaryData.paperProd_G06} %</td>
	</tr>
	<tr>
		<td style="text-align: left;">Machine Sets</td>
		<td>${summaryData.paperProd_Y07}</td>
		<td>${summaryData.paperProd_MTD07}</td>
		<td>${summaryData.paperProd_G07}</td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4" style="text-align: left;">${summaryData.paperProdComment}</td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	<tr>
		<td rowspan="4" valign="top"><b>Shipping</b></td>
		<td style="text-align: left;">Trucks Loaded</td>
		<td>${summaryData.shipping_Y01}</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Warehouse White Inventory</td>
		<td>${summaryData.shipping_Y02}</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Warehouse Red Inventory</td>
		<td>${summaryData.shipping_Y03 }</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td style="text-align: left;">Warehouse Cull / Broke Inventory</td>
		<td>${summaryData.shipping_Y04}</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4" style="text-align: left;">${summaryData.shippingComment}</td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td rowspan="2" valign="top"><b>Costs</b></td>
		<td style="text-align: left;">Fresh water flow (gal/ton)</td>
		<td>${summaryData.costs_Y01}</td>
		<td>${summaryData.costs_MTD01}</td>
		<td>${summaryData.costs_G01}</td>
	</tr>
	<tr>
		<td style="text-align: left;">KW Hrs/Ton</td>
		<td>${summaryData.costs_Y02}</td>
		<td>${summaryData.costs_MTD02}</td>
		<td>${summaryData.costs_G02}</td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4" style="text-align: left;">${summaryData.costsComment}</td>
	</tr>

	<tr>
		
		<td colspan="5">
			<table style="width: 100%;border-collapse: collapse;">
				<tr>
					<td><b>Meeting Today</b></td>
					<td><b>Attendee</b></td>
					<td><b>Visitor Scheduled Today</b></td>
				</tr>
				<tr>
					<td style="width: 250px;">${summaryData.meetingToday}</td>
					<td style="width: 200px;">${summaryData.attendee}</td>
					<td style="width: 200px;">${summaryData.visitor}</td>
					
				</tr>
			</table>
		
		</td>
	</tr>

	<tr>
		<td colspan="5" style="height: 20px;text-align: left;"><b>Special Notes</b></td>
	</tr>
	<tr>
		<td colspan="5" style="height: 20px;text-align: left;">${summaryData.notes}</td>
	</tr>
	
						
	</table>

<br>
<br>


</div>



			</div>

		</div>


	</div>


</body>
</html>
