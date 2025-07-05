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
				
				<spring:url value="/productionreport/viewsummary/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="date" value="${date}">							
							</td>
							<td>Shift</td>
							<td>
								<c:set value="${fn:split('Day,Night',',')}" var="shifts"/>	
								<select name="shift" style="width: 80px;">
									<option value="">All</option>
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
									<input type="button" id="exportBtn" value="Export">
									&nbsp;
									<input type="button" id="printBtn" value="Print">
									&nbsp;
									<input type="button" value="Send Mail" id="sendMailBtn">
								</c:if>
								&nbsp;
								
							</td>
						</tr>
					</table>
				</form>
				
				</div>
				
				
				<br>
				<br>

<div style="position: absolute;bottom: 0;width: 98%;top: 103px;overflow: auto;">
<c:if test="${viewFlag}">

<spring:url value="/productionreport/exportsummary/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#exportBtn').click(function(){
			$('#exportForm').submit();
			return false;
		});
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
		
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


<spring:url value="/productionreport/exportsummary" var="exportURL"/>
<form id="exportForm" action="${exportURL}" method="post">
<input type="hidden" name="date" value="${date}">
<input type="hidden" name="shift" value="${shift}">
</form>

<br>
<br>
<div id="printDiv">
<table id="reportTable1" class="table" style="width: 600px; margin: auto; font-size: 12px;">
	<thead>
		<tr class="trobjrow">
			<th colspan="7">PM6 Machine Production - ${date}</th>
		</tr>
		<tr>
			<th>Date</th>
			<th>Grade</th>
			<th>Day</th>
			<th>Night</th>
			<th>Total</th>
			<th>Reject</th>
			<th>Remarks for Reject</th>
		</tr>
	</thead>
	<tbody>
	
	<c:set value="0" var="dayTotal"/>
	<c:set value="0" var="nightTotal"/>
	<c:set value="0" var="rejectTotal"/>
	
		<c:forEach items="${datas['production']}" var="pdata" varStatus="ind">
			<tr>
				<c:if test="${ind.index eq 0}">
					<td style="width: 70px;"><div>${date}</div></td>
				</c:if>
				<c:if test="${ind.index ne 0}">
					<td><div></div></td>
				</c:if>
				
				<td style="width: 80px;"><div>${pdata.gradeCode}</div></td>
				<td style="width: 50px;"><div><fmt:formatNumber value="${pdata.dayWeight}" pattern="0.00"/> </div></td>
				<td style="width: 50px;"><div><fmt:formatNumber value="${pdata.nightWeight}" pattern="0.00"/> </div></td>
				<td style="width: 50px;"><div><fmt:formatNumber value="${pdata.nightWeight+pdata.dayWeight}" pattern="0.00"/> </div></td>
				<td style="width: 50px;"><div><fmt:formatNumber value="${pdata.rejected}" pattern="0.00"/> </div></td>
				<td><div>${pdata.comments}</div></td>
			</tr>
			<c:set value="${dayTotal+pdata.dayWeight}"  var="dayTotal"/>
			<c:set value="${nightTotal + pdata.nightWeight}"  var="nightTotal"/>
			<c:set value="${rejectTotal + pdata.rejected}"  var="rejectTotal"/>
		</c:forEach>
	
		<tr class="trrowgray">
			<td></td>
			<td><div><b>Total</b></div></td>
			<td><div><b><fmt:formatNumber value="${dayTotal}" pattern="0.00"/> </b></div></td>
			<td><div><b><fmt:formatNumber value="${nightTotal}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${dayTotal+nightTotal}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${rejectTotal}" pattern="0.00"/></b></div></td>
			<td></td>
		</tr>
		<tr class="trrowgray">
		<c:set value="${datas['mpMTD']}" var="mpMTD"/>
			<td></td>
			<td><div><b>MTD</b></div></td>
			<td><div><b><fmt:formatNumber value="${mpMTD.dayWeight}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${mpMTD.nightWeight}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${mpMTD.dayWeight+mpMTD.nightWeight}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${mpMTD.rejected}" pattern="0.00"/></b></div></td>
			<td></td>
		</tr>
	
		<tr>
			<td colspan="7"><div>&nbsp;<br></div></td>
		</tr>
	</tbody>
	
<!-- 	Code Starts From Here Done By Roshan Tailor For Machine Producation -->
<thead>
		<tr class="trobjrow">
			<th colspan="7">PM6 Machine Sheet Break Summary - ${date}</th>
		</tr>
		<tr>
			<th></th>
			<th>Shift</th>
			<th colspan="2">Number of Rolls With Breaks</th>
			<th colspan="2">Number of Rolls Produse</th>
			<th>Break Free %</th>
		</tr>
	</thead>
	<tbody>
		<%-- <c:if test="${datas['machinerollbreakinfo'].size() > 0}">
			<c:forEach items="${datas['machinerollbreakinfo']}" var="machinerbinfo">
				<tr>
					<td><center><div></div></center></td>
					
					<td><center><div>${machinerbinfo.shift}</div></center></td>
					<th colspan="4">${machinerbinfo.numberofrollswithbreaks}</th>
					<td><center><div>${machinerbinfo.percentageofrollswithbreaks}</div></center></td>
					<c:set value="${totalRoll1+machinerbinfo.numberofrollswithbreaks}" var="totalRoll1"/>
					<c:set value="${(totalper1+machinerbinfo.percentageofrollswithbreaks)}" var="totalper1"/>
				</tr>
			</c:forEach>
	
			<tr class="trrowgray">
				<td style="width: 35px;"><center></center></td>
				<td style="width: 45px;"><center>Total</center></td>
				<th colspan="4"><center><div><b>${totalRoll1}</b></div></center></th>
				<td><div><center><b><fmt:formatNumber value="${100-totalRoll1}" pattern="0.00"/></b></center></div></td>
			</tr>
			<tr>
				<td colspan="7"><div>&nbsp;<br></div></td>
			</tr>
		</c:if> --%>
		<c:if test="${datas['machinerollbreakinfo'].size() eq '2'}">
		<c:forEach items="${datas['machinerollbreakinfo']}" var="machinerbinfo">
				<tr>
					<td><center><div></div></center></td>
					<td><center><div>${machinerbinfo.shift}</div></center></td>
					<th colspan="2">${machinerbinfo.numberofrollswithbreaks}</th>
					<th colspan="2">${machinerbinfo.totalrollsproduce}</th>
					<td><center><div>${machinerbinfo.percentageofrollswithbreaks}</div></center></td>
					<c:set value="${totalRoll+machinerbinfo.numberofrollswithbreaks}" var="totalRoll1"/>
					<c:set value="${totalrollsproduce+machinerbinfo.totalrollsproduce}" var="totalrollsproduce"/>
					<c:set value="${(totalper+machinerbinfo.percentageofrollswithbreaks)}" var="totalper1"/>
				</tr>
			</c:forEach>
	
			<tr class="trrowgray">
				<td style="width: 35px;"><center></center></td>
				<td style="width: 45px;"><center>Total</center></td>
				<th colspan="2"><center><div><b>${totalRoll1}</b></div></center></th>
				<th colspan="2"><center><div><b>${totalrollsproduce}</b></div></center></th>
				<td><div><center><b><fmt:formatNumber value="${100-(totalRoll1/totalrollsproduce)*100}" pattern="0.00"/></b></center></div></td>
			</tr>
			<tr>
				<td colspan="7"><div>&nbsp;<br></div></td>
			</tr>
		</c:if>
		<c:if test="${datas['machinerollbreakinfo'].size() eq '1'}">
				<c:forEach items="${datas['machinerollbreakinfo']}" var="machinerbinfo">
					<c:if test="${fn:containsIgnoreCase(machinerbinfo.shift,'Day') }">
						<tr>
								<td><center><div></div></center></td>
								<td><center><div>${machinerbinfo.shift}</div></center></td>
								<th colspan="2">${machinerbinfo.numberofrollswithbreaks}</th>
								<th colspan="2">${machinerbinfo.totalrollsproduce}</th>
								<td><center><div>${machinerbinfo.percentageofrollswithbreaks}</div></center></td>
								<c:set value="${totalRoll+machinerbinfo.numberofrollswithbreaks}" var="totalRoll1"/>
								<c:set value="${totalrollsproduce+machinerbinfo.totalrollsproduce}" var="totalrollsproduce"/>
								<c:set value="${(totalper+machinerbinfo.percentageofrollswithbreaks)}" var="totalper1"/>
						</tr>
						<tr>
							<td style="width: 35px;"><center><div></div></center></td>
							<td style="width: 45px;"><center><div>Night</div></center></td>
							<th colspan="2"><center><div>0</div></center></th>
							<th colspan="2"><center><div>0</div></center></th>
							<td style="width: 50px;"><center><div>100</div></center></td>
						</tr>
						<tr class="trrowgray">
							<td style="width: 35px;"><center></center></td>
							<td style="width: 45px;"><center>Total</center></td>
							<th colspan="2"><center><div><b>${totalRoll1}</b></div></center></th>
							<th colspan="2"><center><div><b>${totalrollsproduce}</b></div></center></th>
							<td><div><center><b><fmt:formatNumber value="${100-(totalRoll1/totalrollsproduce)*100}" pattern="0.00"/></b></center></div></td>
						</tr>
						
					</c:if>
					<c:if test="${fn:containsIgnoreCase(machinerbinfo.shift,'Night') }">
							<tr>
								<td><center><div></div></center></td>
								<td><center><div>${machinerbinfo.shift}</div></center></td>
								<th colspan="2">${machinerbinfo.numberofrollswithbreaks}</th>
								<th colspan="2">${machinerbinfo.totalrollsproduce}</th>
								<td><center><div>${machinerbinfo.percentageofrollswithbreaks}</div></center></td>
								<c:set value="${totalRoll+machinerbinfo.numberofrollswithbreaks}" var="totalRoll1"/>
								<c:set value="${totalrollsproduce+machinerbinfo.totalrollsproduce}" var="totalrollsproduce"/>
								<c:set value="${(totalper+machinerbinfo.percentageofrollswithbreaks)}" var="totalper1"/>
						</tr>
						<tr>
							<td style="width: 35px;"><center><div></div></center></td>
							<td style="width: 45px;"><center><div>Day</div></center></td>
							<th colspan="2"><center><div>0</div></center></th>
							<th colspan="2"><center><div>0</div></center></th>
							<td style="width: 50px;"><center><div>100</div></center></td>
						</tr>
						<tr class="trrowgray">
							<td style="width: 35px;"><center></center></td>
							<td style="width: 45px;"><center>Total</center></td>
							<th colspan="2"><center><div><b>${totalRoll1}</b></div></center></th>
							<th colspan="2"><center><div><b>${totalrollsproduce}</b></div></center></th>
							<td><div><center><b><fmt:formatNumber value="${100-(totalRoll1/totalrollsproduce)*100}" pattern="0.00"/></b></center></div></td>
						</tr>
					</c:if>
				</c:forEach>
		</c:if>
		<c:if test="${datas['machinerollbreakinfo'].size() eq 0}">
				<tr>
					<td style="width: 35px;"><center><div></div></center></td>
					<td style="width: 45px;"><center><div>Day</div></center></td>
					<th colspan="2"><center><div>0</div></center></th>
					<th colspan="2"><center><div>0</div></center></th>
					<td style="width: 50px;"><center><div>100</div></center></td>
				</tr>
				<tr>
					<td style="width: 35px;"><center><div></div></center></td>
					<td style="width: 45px;"><center><div>Night</div></center></td>
					<th colspan="2"><center><div>0</div></center></th>
					<th colspan="2"><center><div>0</div></center></th>
					<td style="width: 50px;"><center><div>100</div></center></td>
				</tr>
				<tr class="trrowgray">
					<td style="width: 35px;"><center></center></td>
					<td style="width: 45px;"><center>Total</center></td>
					<th colspan="2"><center><div><b>0</b></div></center></th>
					<th colspan="2"><center><div><b>0</b></div></center></th>
					<td><div><center><b>100</b></center></div></td>
				</tr>
		</c:if>
	</tbody>
	<tr>
					<td colspan="7"><div>&nbsp;<br></div></td>
	</tr>
<!-- Code Ends Here Done By Roshan Tailor For Machine Producation -->
	<thead>
		<tr class="trobjrow">
			<th colspan="7">PM6 Wrapped Production  - ${date}</th>
		</tr>
		<tr>
			<th>Date</th>
			<th>Shift</th>
			<th>White</th>
			<th>Red</th>
			<th>Total</th>
			<th>Reject</th>
			<th>Remarks for Red/Reject</th>
		</tr>
	</thead>
	<tbody>
		<c:set value="${datas['wrapDay']}" var="wrapDay"/>
		<c:set value="${datas['wrapNigh']}" var="wrapNigh"/>
		<tr>
			<td><div>${date}</div></td>
			<td><div>${wrapDay.shift}</div></td>
			<td><div><fmt:formatNumber value="${wrapDay.whiteWeight}" pattern="0.00"/></div></td>
			<td><div><fmt:formatNumber value="${wrapDay.redWeight}" pattern="0.00"/></div></td>
			<td><div><fmt:formatNumber value="${wrapDay.whiteWeight+wrapDay.redWeight}" pattern="0.00"/></div></td>
			<td><div><fmt:formatNumber value="${wrapDay.rejectWeight}" pattern="0.00"/></div></td>
			<td><div>${wrapDay.comment}</div></td>
		</tr>
		<tr>
			<td><div></div></td>
			<td><div>${wrapNigh.shift}</div></td>
			<td><div><fmt:formatNumber value="${wrapNigh.whiteWeight}" pattern="0.00"/></div></td>
			<td><div><fmt:formatNumber value="${wrapNigh.redWeight}" pattern="0.00"/></div></td>
			<td><div><fmt:formatNumber value="${wrapNigh.whiteWeight+wrapNigh.redWeight}" pattern="0.00"/></div></td>
			<td><div><fmt:formatNumber value="${wrapNigh.rejectWeight}" pattern="0.00"/></div></td>
			<td><div>${wrapNigh.comment}</div></td>
		</tr>
	</tbody>
	<tfoot>	
		<tr>
			<td></td>
			<td><b>Total</b></td>
			<td><b><fmt:formatNumber value="${wrapDay.whiteWeight + wrapNigh.whiteWeight}" pattern="0.00"/></b> </td>
			<td><b><fmt:formatNumber value="${wrapDay.redWeight + wrapNigh.redWeight}" pattern="0.00"/></b> </td>
			<td><b><fmt:formatNumber value="${wrapDay.whiteWeight+wrapDay.redWeight+wrapNigh.whiteWeight+wrapNigh.redWeight}" pattern="0.00"/></b> </td>
			<td><b><fmt:formatNumber value="${wrapDay.rejectWeight + wrapNigh.rejectWeight}" pattern="0.00"/></b> </td>
			<td></td>
		</tr>
		<tr class="trrowgray">
			<c:set value="${datas['wpMTD']}" var="wpMTD"/>
			<td></td>
			<td><div><b>MTD</b></div></td>
			<td><div><b><fmt:formatNumber value="${wpMTD.whiteWeight}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${wpMTD.redWeight}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${wpMTD.redWeight+wpMTD.whiteWeight}" pattern="0.00"/></b></div></td>
			<td><div><b><fmt:formatNumber value="${wpMTD.rejectWeight}" pattern="0.00"/></b></div></td>
			<td></td>
		</tr>
	</tfoot>
</table>

<!-- 	Code Strats From Here Done By Roshan Tailor -->
<br>


<table id="reportTable1" class="table" style="width: 600px; margin: auto; font-size: 12px;">
	<thead>
		<tr class="trobjrow">
			<th colspan="7">PM6 Wrapped Sheet Break Summary - ${date}</th>
		</tr>
		<tr>
			<th style="width: 76px;"></th>
			<th style="width: 86px;">Shift</th>
			<th style="width: 131px;">Number of Rolls With Breaks</th>
			<th style="width: 113px;">Number of Rolls Produse</th>
			<th style="width: 100px;">Break Free %</th>
			
		</tr>
	</thead>
	<tbody>
		<%-- <c:if test="${datas['rollbreakinfo'].size() > 0}">
			<c:forEach items="${datas['rollbreakinfo']}" var="rbinfo">
				<tr>
					<td style="width: 35px;"><center><div></div></center></td>
					<td style="width: 45px;"><center><div>${rbinfo.shift}</div></center></td>
					<td style="width: 115px;"><center><div>${rbinfo.numberofrollswithbreaks}</div></center></td>
					<td style="width: 50px;"><center><div>${rbinfo.percentageofrollswithbreaks}</div></center></td>
					<c:set value="${totalRoll+rbinfo.numberofrollswithbreaks}" var="totalRoll"/>
					<c:set value="${(totalper+rbinfo.percentageofrollswithbreaks*100)/100}" var="totalper"/>
					<c:set value="${(totalper+rbinfo.percentageofrollswithbreaks)}" var="totalper"/>
				</tr>
			</c:forEach>
	
			<tr class="trrowgray">
				<td style="width: 35px;"><center></center></td>
				<td style="width: 45px;"><center>Total</center></td>
				<td style="width: 115px;"><center><div><b>${totalRoll}</b></div></center></td>
				<td><div><center><b><fmt:formatNumber value="${100-totalRoll}" pattern="0.00"/></b></center></div></td>
			</tr>
			<tr>
				<td colspan="7"><div>&nbsp;<br></div></td>
			</tr>
		</c:if> --%>
		<c:if test="${datas['rollbreakinfo'].size() eq '2'}">
		<c:forEach items="${datas['rollbreakinfo']}" var="rbinfo">
				<tr>
					<td style="width: 70px;"><center><div></div></center></td>
					<td style="width: 45px;"><center><div>${rbinfo.shift}</div></center></td>
					<td style="width: 115px;"><center><div>${rbinfo.numberofrollswithbreaks}</div></center></td>
					<td style="width: 115px;"><center><div>${rbinfo.totalrollsproduce}</div></center></td>
					<td style="width: 50px;"><center><div>${rbinfo.percentageofrollswithbreaks}</div></center></td>
					<c:set value="${totalRoll+rbinfo.numberofrollswithbreaks}" var="totalRoll"/>
					<c:set value="${TotalRollsProduce+rbinfo.totalrollsproduce}" var="TotalRollsProduce"/>
					<c:set value="${(totalper+rbinfo.percentageofrollswithbreaks)}" var="totalper"/>
				</tr>
			</c:forEach>
	
			<tr class="trrowgray">
				<td style="width: 70px;"><center></center></td>
				<td style="width: 45px;"><center>Total</center></td>
				<td style="width: 115px;"><center><div><b>${totalRoll}</b></div></center></td>
				<td style="width: 115px;"><center><div>${TotalRollsProduce }</div></center></td>	
				<td><div><center><b><fmt:formatNumber value="${100-(totalRoll/TotalRollsProduce)*100}" pattern="0.00"/></b></center></div></td>
			</tr>
			<tr>
				<td colspan="7"><div>&nbsp;<br></div></td>
			</tr>
		</c:if>
		<c:if test="${datas['rollbreakinfo'].size() eq '1'}">
				<c:forEach items="${datas['rollbreakinfo']}" var="rbinfo">
					<c:if test="${fn:containsIgnoreCase(rbinfo.shift,'Day') }">
						<tr>
							<td style="width: 70px;"><center><div></div></center></td>
							<td style="width: 45px;"><center><div>${rbinfo.shift}</div></center></td>
							<td style="width: 115px;"><center><div>${rbinfo.numberofrollswithbreaks}</div></center></td>
							<td style="width: 115px;"><center><div>${rbinfo.totalrollsproduce}</div></center></td>
							<td style="width: 50px;"><center><div>${rbinfo.percentageofrollswithbreaks}</div></center></td>
							<c:set value="${totalRoll+rbinfo.numberofrollswithbreaks}" var="totalRoll"/>
							<c:set value="${totalrollsproducewrap+rbinfo.totalrollsproduce}" var="totalrollsproducewrap"/>
							<c:set value="${(totalper+rbinfo.percentageofrollswithbreaks)}" var="totalper"/>
						</tr>
						<tr>
							<td style="width: 70px;"><center><div></div></center></td>
							<td style="width: 45px;"><center><div>Night</div></center></td>
							<td style="width: 115px;"><center><div>0</div></center></td>
							<td style="width: 115px;"><center><div>0</div></center></td>
							<td style="width: 50px;"><center><div>100</div></center></td>
						</tr>
						<tr class="trrowgray">
							<td style="width: 70px;"><center></center></td>
							<td style="width: 45px;"><center>Total</center></td>
							<td style="width: 115px;"><center><div><b>${totalRoll}</b></div></center></td>
							<td style="width: 115px;"><center><div><b>${totalrollsproducewrap}</b></div></center></td>
							<td><div><center><b><fmt:formatNumber value="${totalper}" pattern="0.00"/></b></center></div></td>
						</tr>
					</c:if>
					<c:if test="${fn:containsIgnoreCase(rbinfo.shift,'Night') }">
						<tr>
							<td style="width: 70px;"><center><div></div></center></td>
							<td style="width: 45px;"><center><div>${rbinfo.shift}</div></center></td>
							<td style="width: 115px;"><center><div>${rbinfo.numberofrollswithbreaks}</div></center></td>
							<td style="width: 115px;"><center><div>${rbinfo.totalrollsproduce}</div></center></td>
							<td style="width: 50px;"><center><div>${rbinfo.percentageofrollswithbreaks}</div></center></td>
							<c:set value="${totalRoll+rbinfo.numberofrollswithbreaks}" var="totalRoll"/>
							<c:set value="${totalrollsproducewrap+rbinfo.totalrollsproduce}" var="totalrollsproducewrap"/>
							<c:set value="${(totalper+rbinfo.percentageofrollswithbreaks)}" var="totalper"/>
						</tr>
						<tr>
							<td style="width: 70px;"><center><div></div></center></td>
							<td style="width: 45px;"><center><div>Day</div></center></td>
							<td style="width: 115px;"><center><div>0</div></center></td>
							<td style="width: 115px;"><center><div>0</div></center></td>
							<td style="width: 50px;"><center><div>100</div></center></td>
						</tr>
						<tr class="trrowgray">
							<td style="width: 70px;"><center></center></td>
							<td style="width: 45px;"><center>Total</center></td>
							<td style="width: 115px;"><center><div><b>${totalRoll}</b></div></center></td>
							<td style="width: 115px;"><center><div><b>${totalrollsproducewrap}</b></div></center></td>
							<td><div><center><b><fmt:formatNumber value="${totalper}" pattern="0.00"/></b></center></div></td>
						</tr>
					</c:if>
				</c:forEach>
				
		</c:if>
		<c:if test="${datas['rollbreakinfo'].size() eq 0}">
				<tr>
					<td style="width: 70px;"><center><div></div></center></td>
					<td style="width: 45px;"><center><div>Day</div></center></td>
					<td style="width: 115px;"><center><div>0</div></center></td>
					<td style="width: 115px;"><center><div>0</div></center></td>
					<td style="width: 50px;"><center><div>100</div></center></td>
				</tr>
				<tr>
					<td style="width: 70px;"><center><div></div></center></td>
					<td style="width: 45px;"><center><div>Night</div></center></td>
					<td style="width: 115px;"><center><div>0</div></center></td>
					<td style="width: 115px;"><center><div>0</div></center></td>
					<td style="width: 50px;"><center><div>100</div></center></td>
				</tr>
				<tr class="trrowgray">
					<td style="width: 70px;"><center></center></td>
					<td style="width: 45px;"><center>Total</center></td>
					<td style="width: 115px;"><center><div><b>0</b></div></center></td>
					<td style="width: 115px;"><center><div><b>0</b></div></center></td>
					<td><div><center><b>100</b></center></div></td>
				</tr>
		</c:if>
	</tbody>
				<tr class="trobjrow">
					<th colspan="7">Efficiency Down Time Summary Report</th>
				</tr>
	</tbody>


</table>
<!-- Code Ends Here Done By Roshan Tailor -->
<c:set value="${fn:length(datas1['summaryPrimaries'])}" var="len"/>
			
<c:if test="${len >0 }">

<table class="table" style="margin: auto; width: 600px;">
	<thead>
		<tr>
			<td></td>
			<td style="text-align: center;">HH</td>
			<td style="text-align: center;">MM</td>
			<!-- <td style="text-align: center;">OCCURRENCE</td> -->
		</tr>
	</thead>
	<tbody>
		
	
		<c:forEach items="${datas1['summaryPrimaries']}" var="pSum">
		<tr>
			<td style="text-align: left;">
				<b>${pSum.code}</b>
			</td>
			<td></td>
			<td></td>
			<!-- <td></td> -->
		</tr>
				
		<c:set value="${fn:length(pSum.summarySecondaries)}" var="len2"/>
		<c:if test="${len2 > 0}">
	
			<c:forEach items="${pSum.summarySecondaries}" var="sSum">
				<tr>
					<td style="text-align: left;">${sSum.code}</td>
					<td><center>${sSum.hh}</center></td>
					<td><center>${sSum.mm}</center></td>
					<%-- <td>${sSum.counter}</td> --%>
				</tr>
			</c:forEach>
			<tr>
				<td class="trrowgray" style="text-align: right;"><b>TOTAL</b></td>
				<td class="trrowgray"><center>${pSum.hh}</center></td>
				<td class="trrowgray"><center>${pSum.mm}</center></td>
				<!-- <td class="trrowgray"></td> -->
			</tr>	
			
			
		</c:if>
		
		</c:forEach>
		
		<tr>
			<td class="trrowgray2" style="text-align: right;"><b>GRAND TOTAL</b></td>
			<td class="trrowgray2"><center><b>${datas1['hh']}</b></center></td>
			<td class="trrowgray2"><center><b>${datas1['mm']}</b></center></td>
			<!-- <td class="trrowgray"></td> -->
		</tr>
		
	</tbody>
</table>

</c:if>
</div>
</c:if>					
				</div>

			</div>

		</div>


	</div>

</body>
</html>
