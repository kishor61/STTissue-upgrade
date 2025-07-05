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
	</style>
	
	
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>



<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea({
				retainAttr:['class','style']
			});
		});
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
<spring:url value="/dailydashboard/view/data/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			
			var btn=$(this);
			
			if(confirm('Do You Want To Send STT Daily Dash Board Report Mail')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate
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
					<span class="label">Daily Dash Board Report</span>
				</div>
				
				<div class="table-selector" id="table-selector">
				
				<spring:url value="/dailydashboard/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<%-- <td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td> --%>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
								
							</td>
							<td>
								<button id="printBtn">Print</button>
							</td>
							<c:if test="${show}">
								 <td><input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export"></td>
								 <td><input type="button" id="mailBtn" value="Send Mail"></td>
								 
							</c:if>
						</tr>
					</table>
				</form>
				
<form id="exportFrom" action='<spring:url value="/dailydashboard/view/data/export"/>'  method="GET" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
</form>
				</div>
				
				
				<div id="printDiv"  style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${show}">
<center>
							<table style="width: 50%; text-align: center;" border="1"
								cellpadding="1">
								<tbody>
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">SAFETY</td>
									</tr>
									<tr>
										<td colspan="2">&nbsp;</td>
										<td>Last Incident on</td>
										<td>Remarks</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="1">YTD OIR</td>
										<td>7.4</td>
										<td></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Safe workdays w/o Recordable</td>
										<td>${lrdays}</td>
										<td>${lrdate}</td>
										<td>Injury at FRP</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Completed fire training. Have one more training
											scheduled for next Tuesday 5/29.</td>
										<td colspan="4">Will change fore training to February in
											2019. Scott Storch follow up</td>
									</tr>
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">Quality</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="2">Daily Tons</td>
										<td colspan="2">Monthly Avg</td>

									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>Reject</td>
										<td>Red</td>
										<td>Reject</td>
										<td>Red</td>

									</tr>
									<tr>
										<td>F5</td>
										<td>
											<c:forEach items="${datas1}" var="data">
												${data['24']}
											</c:forEach>
										</td>
										<td>
											<c:forEach items="${datas1}" var="data">
												${data['4']}
											</c:forEach>
										</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>F6</td>
										<td><c:forEach items="${datas2}" var="data">
		${data['24']}
	</c:forEach></td>
										<td>
											<c:forEach items="${datas2}" var="data">
												${data['4']}
											</c:forEach>
										</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Days since last complaint</td>
										<td>13</td>
										<td>${sdate}</td>
										<td colspan="2">SCA Napkin issues</td>

									</tr>
									<tr>
										<td>Comments: Basis wt. paper needs to be cut into red
											tag. Mike Yoder to follow up.</td>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">PRODUCTIVITY</td>
									</tr>
									<tr>
										<td colspan="5" style="background-color: #dac66482;">FRP</td>
									</tr>
									<tr>

										<td style="background-color: #dac66482;">A - line</td>
										<td>Daily</td>
										<td>MTD/Average</td>
										<td>Remarks</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Batches</td>
										<td>
												<c:forEach items="${datas3}" var="data">
												<fmt:formatNumber value="${data.totalcol10}" maxFractionDigits="1"/>
											</c:forEach>
										</td>
										<td>&nbsp;</td>
										<td colspan=2 rowspan=4><!-- A line had a good day. No major upsets. --></td>

									</tr>
									<tr>
										<td>Tons Made</td>
										<td>
												<c:forEach items="${datas3}" var="data">
												<fmt:formatNumber value="${data.totalcol6}" maxFractionDigits="1"/>
											</c:forEach>
										</td>
										<td>&nbsp;</td>

									</tr>
									<tr>
										<td>Current Run rate</td>
										<td></td>
										<td>&nbsp;</td>

									</tr>
									<tr>
										<td>HD Level</td>
										<td>
												<c:forEach items="${datas3}" var="data">
												<fmt:formatNumber value="${data.totalcol11/2}" maxFractionDigits="2"/> %
											</c:forEach>
										</td>
										
										<td>&nbsp;</td>

									</tr>
									<tr>
										<td>Comments</td>
										<td colspan=4>&nbsp;</td>

									</tr>

									<tr>
										<td style="background-color: #dac66482;">B - Line</td>
										<td>Daily</td>
										<td>MTD/Average</td>
										<td>Remarks</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Batches</td>
										<td>
												<c:forEach items="${datas3}" var="data">
												<fmt:formatNumber value="${data.totalcol10b}" maxFractionDigits="1"/>
											</c:forEach>
										</td>
										<td>&nbsp;</td>
										<td colspan=2 rowspan=4>&nbsp;</td>

									</tr>
									<tr>
										<td>Tons Made</td>
										<td>
												<c:forEach items="${datas3}" var="data">
												<fmt:formatNumber value="${data.totalcol6b}" maxFractionDigits="1"/>
											</c:forEach>
										</td>
										<td>&nbsp;</td>


									</tr>
									<tr>
										<td>Current Run rate</td>
										<td></td>
										<td>&nbsp;</td>


									</tr>
									<tr>
										<td>PCC/RX Level</td>
										<td>
												<c:forEach items="${datas3}" var="data">
												<fmt:formatNumber value="${data.totalcol11b/2}" maxFractionDigits="2"/> %
											</c:forEach>
										</td>
										<td>&nbsp;</td>

									</tr>
									<!-- <tr>
										<td>Comments: B line down for Detrasher shaft
											replacement.</td>
										<td colspan=4>Chris will check and make sure we got
											measurements and dimensions of replacement shaft for future.</td>

									</tr> -->
									
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">PRODUCTIVITY</td>
									</tr>
									<tr>
										<td  style="background-color: #dac66482;">F5</td>
										<td>Daily</td>
										<td>MTD/Avg</td>
										<td colspan="2">Remark</td>
									</tr>
									<tr>
										<td colspan="1">Reel</td>
										<td><c:forEach items="${datas1}" var="data">
											${data['2']}
										</c:forEach></td>
										<td></td>
										<td rowspan="7" ></td>
									</tr>
									<tr>
										<td colspan="1">Wrapped</td>
										<td><c:forEach items="${datas1}" var="data">
											${data['3']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">TLT</td>
										<td><c:forEach items="${datas1}" var="data">
											${data['12']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Uptime</td>
										<td><c:forEach items="${datas1}" var="data">
											${data['16']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Efficiency</td>
										<td><c:forEach items="${datas1}" var="data">
											${data['17']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Fresh water Usage</td>
										<td></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Sewer Loss</td>
										<td></td>
										<td></td>
										
										
									</tr>
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">PRODUCTIVITY</td>
									</tr>
									<tr>
										<td  style="background-color: #dac66482;">F6</td>
										<td>Daily</td>
										<td>MTD/Avg</td>
										<td colspan="2">Remark</td>
									</tr>
									<tr>
										<td colspan="1">Reel</td>
										<td><c:forEach items="${datas2}" var="data">
											${data['2']}
										</c:forEach></td>
										<td></td>
										<td rowspan="7" ></td>
									</tr>
									<tr>
										<td colspan="1">Wrapped</td>
										<td><c:forEach items="${datas2}" var="data">
											${data['3']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">TLT</td>
										<td><c:forEach items="${datas2}" var="data">
											${data['12']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Uptime</td>
										<td><c:forEach items="${datas2}" var="data">
											${data['16']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Efficiency</td>
										<td><c:forEach items="${datas2}" var="data">
											${data['17']}
										</c:forEach></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Fresh water Usage</td>
										<td></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">River Water</td>
										<td></td>
										<td></td>
										
										
									</tr>
									<tr>
										<td colspan="1">Sewer Loss</td>
										<td></td>
										<td></td>
										
										
									</tr>
									
									
									
									
									
									
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">Converting</td>
									</tr>
									<tr>
										<td  style="background-color: #dac66482;">Converting</td>
										<td>Daily</td>
										<td>Inventory</td>
										<td colspan="2">Remark</td>
									</tr>
									
									<c:forEach items="${datas4}" var="cd">
										<c:set value="${firstcase+cd.firstcase}" var="firstcase" />
										<c:set value="${secodcase+cd.secodcase}" var="secodcase" />
									</c:forEach>
				
									<tr>
										<td colspan="1">Total Cases</td>
										<td>${firstcase+secodcase}</td>
										<td></td>
										<td ></td>
									</tr>
									<tr>
										<td colspan="1">TLT</td>
										<td></td>
										<td></td>
										<td ></td>
									</tr>
									
									
									
									
									<tr style="background-color: #d6d0a382;">
										<td colspan="5">Shiping</td>
									</tr>
									<tr>
										<td  style="background-color: #dac66482;">Shiping</td>
										<td>Daily</td>
										<td>Inventory</td>
										<td colspan="2">Remark</td>
									</tr>
									
									<c:forEach items="${datas4}" var="cd">
										<c:set value="${firstcase+cd.firstcase}" var="firstcase" />
										<c:set value="${secodcase+cd.secodcase}" var="secodcase" />
									</c:forEach>
				
									<tr>
										<td colspan="1">White Inventory</td>
										<td></td>
										<td></td>
										<td ></td>
									</tr>
									<tr>
										<td colspan="1">Red Inventory</td>
										<td></td>
										<td></td>
										<td ></td>
									</tr>
									
									<tr>
										<td colspan="1">Shipped Yesterday/Today</td>
										<td></td>
										<td></td>
										<td ></td>
									</tr>
									
									<tr>
										<td colspan="1">Received Yesterday/Today</td>
										<td></td>
										<td></td>
										<td ></td>
									</tr>
									
	
								</tbody>
							</table>
							<!-- DivTable.com -->
			
			</center>	
			
			</c:if>
			
</div>
				

			</div>

		</div>


	</div>

</body>
</html>
