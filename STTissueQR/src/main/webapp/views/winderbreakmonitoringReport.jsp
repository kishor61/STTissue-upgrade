<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/winderbreakmonitoring/report/load" var="showReportURL" />
<spring:url value="/winderbreakmonitoring/report/delete" var="deletewinderDataURL" />
<spring:url value="/winderbreakmonitoring/report/export" var="exportReportURL"/>
<spring:url value="/winderbreakmonitoring/editWinderReport" var="editURL" />
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
	$('#deleterowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#barcodedatatable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#barcodedatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deletewinderDataURL}',
					type:'POST',
					data:{id:val},
					success:function(data){
						if(data.status){
							alert('Data removed from database.');
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}
		}
	});
});
</script>
<script type="text/javascript">
$(function() {
	$('#editbutton')
			.click(
					function() {
						var id = $('input[name=id]:checked').val();
						var sdate = $('input[name=sdate]').val();
						var edate = $('input[name=edate]').val();
						if (id !='') {
							//location.href = '${editURL}/'+ id + location.search;
							location.href='${editURL}/'+encodeURIComponent(id)+'/'+encodeURIComponent(sdate)+'/'+encodeURIComponent(edate);
						} else {
							alert('Select row.');
						}
					});
		});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Winder Break Monitoring - Report</span>
				</div>
				<div class="table-selector">
						<table>
						<tr>
							<form action="${showReportURL}" method="get">
							<td>Start Date</td>
							<td><input readonly="readonly" type="text" name="sdate" value="${sdate}" style="width: 80px;"></td>
							<td></td>
							<td>End Date</td>
							<td><input readonly="readonly" type="text" name="edate" value="${edate}"  style="width: 80px;"></td>
							<td><input type="submit" id="viewbutton" name="viewbutton" value="View"></td>
							</form>
							<c:if test="${view}">
								<form action="${exportReportURL}" method="POST">
										<td><input type="hidden" name="sdate" value="${sdate}" ></td>
										<td><input type="hidden" name="edate" value="${edate}"></td>
										<td><button id="exportbutton">Export</button></td>
								</form>
								<td><button id="editbutton">Edit</button></td>
								<td><button id="deleterowbutton">Delete</button></td>	
							</c:if>
						</tr>
					</table>
				</div>
<center><div><b style="color: Green;">${message}</b></div></center>		
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
	<c:if test="${view}">
	<c:if test="${fn:length(winderMonitoringData) > 0 }">		
<center>
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<!-- <tr>
			<td style="width: 20px;"></td>
			<td style="width: 80px;">Date</td>
			<td style="width: 80px;">Shift</td>
			<td style="width: 80px;">Crew</td>
			<td style="width: 80px;">Reel #</td>
			<td style="width: 80px;">Set No</td>
			<td style="width: 80px;">Break At</td>
			<td style="width: 80px;">Loss Time</td>
			<td style="width: 80px;">Reason For Break</td>
			<td style="width: 80px;">Left Out In Spool</td>
			
			
			<td style="width: 20px;"></td>
			<td><b>Date</b></td>
			<td><b>Shift</b></td>
			<td><b>Crew</b></td>
			<td><b>Reel  #</b></td>
			<td><b>Set No</b></td>
			<td><b>Breaks/ stops</b></td>
			<td><b>Break/Stop time</b></td>
			<td><b>Start Time</b></td>
			<td><b>Downtime</b></td>
			<td><b>Reason for break</b></td>
			<td><b>Reason</b></td>
			<td><b>Comments</b></td>
		</tr> -->
		<tr>
			<td rowspan="2">&nbsp;</td>
			<td rowspan="2"><b>Date</b></td>
			<td rowspan="2"><b>Shift</b></td>
			<td rowspan="2"><b>Crew</b></td>
			<td rowspan="2"><b>Grade Code</b></td>
			<td rowspan="2"><b>Reel  #</b></td>
			<td rowspan="2"><b>Set No</b></td>
			<td rowspan="2"><b>Breaks/ stops</b></td>
			
			<td><b>Break/Stop time</b></td>
			<td><b>Start Time</b></td>
			<td><b>Down Time</b></td>
			
			<!-- <td><b>Loss time</b></td> -->
			<td rowspan="2"><b>Reason for break</b></td>
			<td rowspan="2"><b>Reason</b></td>
			<!-- <td><b>Left out in Spool</b></td> -->
			<td rowspan="2"><b>Comments</b></td>
		</tr>
		<tr>
		
		<td rowspan="2"><b>HH:MM</b></td>
		<td rowspan="2"><b>HH:MM</b></td>
		<td rowspan="2"><b>DD:HH:MM</b></td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${winderMonitoringData}" var="wmd">
			<tr>
				<td><input type="radio" name="id" value="${wmd.id}"></td>	
				<td><fmt:formatDate value="${wmd.date}" pattern="MM/dd/yyyy"/></td>
				<td><center>${wmd.shift}</center></td>
				<td><center>${wmd.crew}</center></td>
				<td><center>${wmd.gradeCode}</center></td>
				<td><center>${wmd.reel}</center></td>
				<td><center>${wmd.setNo}</center></td>
				<td><center>${wmd.breakAt}</center></td>
				<td><center><fmt:formatDate value="${wmd.stoptime}" pattern="HH:mm" var="stopTime"/>${stopTime}</center></td>
				<td><center><fmt:formatDate value="${wmd.starttime}" pattern="HH:mm" var="startTime"/>${startTime}</center></td>
				<td><center>${wmd.downtime}</center></td>
				<%-- <td>${wmd.losstime}</td> --%>
				<td><center>${wmd.reasonforbreak}</center></td>
				<td><center>${wmd.losstime}</center></td>
				<td><center>${wmd.leftoutinSpool}</center></td>
				</tr>
		</c:forEach>
	</tbody>
</table>
</center>
	</c:if>
	<c:if test="${fn:length(winderMonitoringData) eq 0 }">		
		<center>
			<div><b style="color: red;">No Data Available For Related Search</b></div>
		</center>
	</c:if>
	</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
