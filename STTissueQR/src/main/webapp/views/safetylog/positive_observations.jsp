<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<style type="text/css">
.stable {
	border-collapse: collapse;
	margin: auto;
}
.stable td{
	border: 1px solid gray;
	text-align: center;
}
.tdbgA{
	background-color: #F5D095;
}
.tdbgD{
	background-color: #FFEED3;
}
.tdbgL{
	background-color: #FFF4BE;
}
.stable select,.stable input[type=checkbox]{
	display: inline;
}
</style>

<spring:url value="/safetyhousekeeping/positiveObservations" var="viewURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		$('#viewBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var recurrence=$('select[name=recurrence]').val();
			if(sdate==''){
				alert('Please select from date.');
				return;
			}else if(edate==''){
				alert('Please select to date.');
				return;
			}else{
				
				location.href='${viewURL}/'+encodeURIComponent(sdate)+'/'+encodeURIComponent(edate)+'/'+encodeURIComponent(recurrence);
				
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
					<span class="label">Safety and Housekeeping - Schedule</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>From Date</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" readonly="readonly">							
							</td>
							<td>To Date</td>
							<td>
								<input type="text" name="edate" value="${edate}"  readonly="readonly">
							</td>
							<%-- <td>Recurrence</td>
							<td>
								<select name="recurrence" style="width: 120px;padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${recurrences}" var="rec">
										<c:choose>
											<c:when test="${rec.key eq recurrence}">
												<option value="${rec.key}" selected="selected">${rec.value}</option>		
											</c:when>
											<c:otherwise>
												<option value="${rec.key}">${rec.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td> --%>
							<td>
								<button id="viewBtn">View</button>
								<button id="printBtn">Print</button>
								&nbsp;&nbsp;&nbsp;<label > Total Count :  </label><label id=label ></label>
							</td>
						</tr>
					</table>

				</div>
<br>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<c:if test="${showFlag}">

<div style="display: none;">
	<spring:url value="/safetyhousekeepingreport/export/positiveObservations/excel" var="exportExlURL"/>
	<form id="exportExlForm"action="${exportExlURL}" method="post" target="_blank">
		<input type="hidden" name="sdate" value="${sdate}"/>
		<input type="hidden" name="edate" value="${edate}"/>
		<input type="hidden" name="recurrence" value="${recurrence}"/>
	</form>
</div>


<div id="printDiv">

<table class="stable">
<c:set value="${fn:length(dates)}" var="colNum"/>
	<thead id="tableHead">
		<tr>
			<td class="tdbgD" style="font-weight: bold;">Date</td>
			<c:forEach items="${dates}" var="date">
				<td  class="tdbgD"><fmt:formatDate value="${date}" pattern="MM-dd-yyyy"/> </td>
			</c:forEach>
		</tr>
		<tr>
			<td class="tdbgL" style="font-weight: bold;">Auditor</td>
			<c:forEach items="${dates}" var="date">
				<td class="tdbgD"><fmt:formatDate value="${date}" pattern="EEE"/> </td>
			</c:forEach>
		</tr>
	</thead>
	<tbody id="tableBody">
		<c:forEach items="${autiors}" var="autiors">
			<tr>
				<td class="tdbgL"><div style="width: 200px;">${autiors.name}</div></td>
				<c:if test="${colNum gt 0}">
					<c:forEach begin="0" end="${colNum-1}" varStatus="i">
						<td>
						<div style="width: 140px;">
							<input style="width: 30px;  height: 30px;" type="checkbox" name="status" title=""
							
							data-id=""
							data-autiors="${autiors.id}" 
							data-date='<fmt:formatDate value="${dates[i.index]}" pattern="MM-dd-yyyy"/>'
							>
							
								
						</div>
						</td>
					</c:forEach>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>

</div>
<spring:url value="/safetyhousekeeping/positiveObservations/save" var="saveURL"/>
<spring:url value="/safetyhousekeeping/positiveObservations/load" var="loadURL"/>
<spring:url value="/safetyhousekeeping/positiveObservations/status" var="statusURL"/>
<script type="text/javascript">
	var timerSave;
	var events;
	var count=0;
	var timerStatus;
	$(function(){
		
		$('input[name=status]').click(function(){
			var id=$(this).next().attr('data-id');
			var statusP=$(this).prop('checked');
			var date=$(this).attr('data-date');
			var autiors=$(this).attr('data-autiors');
			var ele=$(this);
			
				if(timerStatus){
					clearTimeout(timerStatus);
				}
				$('#tmessage').text('');
				$.ajax({
					url:'${statusURL}',
					type: 'POST',
					data :{
						id :id,
						date:date,
						autiors:autiors,
						auditStatus :$(this).prop('checked')
					},
					success:function(data){
						if(data.status){
							location.reload();
							if(statusP){
								$('#tmessage').text('Audit marked as complete.');
							}else{
								$('#tmessage').text('Audit marked as incomplete.');
							}
							timerStatus=setTimeout(function(){
								$('#tmessage').text('');
							}, 3000);
						}else{
							alert(data.error);
							ele.prop('checked',!statusP);
						}
					}
				});
			
		});
		
		$('#exportBtn').click(function(){
			$('#exportExlForm').submit();
		});
		
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
		
		
		
		
		function loadAllEvent(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
				$.ajax({
					url : '${loadURL}',
					type : 'POST',
					data:{
						sdate : sdate,
						edate : edate
					},
					success:function(data){
						
						events=data;
						
						$('#tmessage').text('');
						setEvents();
					}
				});
			
		}
		function changeEvents(){
			
		}
		function setEvents(){
			if(events){
				$('#tableBody input[type=checkbox]').prop('checked',false);
				$('#tableBody input[type=checkbox]').prop('data-id','');
				
				for(var i=0;i<events.length;i++){
					var event=events[i];
					$('#tableBody').find('input').each(function(){
						var autiors=$(this).attr('data-autiors');
						var date=$(this).attr('data-date');
						if(autiors==event.auditorId & date==event.date){
							$(this).val(event.auditorId);
							$(this).attr('data-id',event.id);
							$(this).prop('checked',event.auditStatus);
							if(event.auditStatus){
								$(this).prev().attr('title','Audit Complete.');
							}else{
								$(this).prev().attr('title','Audit Incomplete.');
							}

						}
						
					});
						if(event.auditStatus)
						{
							$('#label').text(++count);
						}
					
				}
			}
		}
		
		loadAllEvent();
		
	}); 
</script>


</c:if>
<br><br>
</div>



		</div>

	</div>

</div>
	
	

</body>
</html>
