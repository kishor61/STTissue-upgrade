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

<spring:url value="/safetyhousekeeping/schedule" var="viewURL"/>
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
			}else if(recurrence==''){
				alert('Please select recurrence.');
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
							<td>Recurrence</td>
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
							</td>
							<td>
								<button id="viewBtn">View</button>
								<button id="printBtn">Print</button>
								<button id="exportBtn">Excel</button>
							</td>
						</tr>
					</table>

				</div>
<br>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<c:if test="${showFlag}">

<div style="display: none;">
	<spring:url value="/safetyhousekeepingreport/export/schedule/excel" var="exportExlURL"/>
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
				<td class="tdbgD"><fmt:formatDate value="${date}" pattern="MM-dd-yyyy"/> </td>
			</c:forEach>
		</tr>
		<tr>
			<td class="tdbgL" style="font-weight: bold;">Area</td>
			<c:forEach items="${dates}" var="date">
				<td class="tdbgD"><fmt:formatDate value="${date}" pattern="EEE"/> </td>
			</c:forEach>
		</tr>
	</thead>
	<tbody id="tableBody">
		<c:forEach items="${areas}" var="area">
			<tr>
				<td class="tdbgL"><div style="width: 200px;">${area.name}</div></td>
				<c:if test="${colNum gt 0}">
					<c:forEach begin="0" end="${colNum-1}" varStatus="i">
						<td>
						<div style="width: 140px;">
							<input type="checkbox" name="status" title="">
							<select style="width: 120px; padding: 2px;"
							data-id=""
							data-area="${area.id}" 
							data-date='<fmt:formatDate value="${dates[i.index]}" pattern="MM-dd-yyyy"/>'
							>
								<option value="">&nbsp;</option>
								<c:forEach items="${autiors}" var="auditor">
									<option value="${auditor.id}">${auditor.name}</option>
								</c:forEach>
							</select>
						</div>
						</td>
					</c:forEach>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>

</div>
<spring:url value="/safetyhousekeeping/schedule/save" var="saveURL"/>
<spring:url value="/safetyhousekeeping/schedule/load" var="loadURL"/>
<spring:url value="/safetyhousekeeping/schedule/status" var="statusURL"/>
<script type="text/javascript">
	var timerSave;
	var events;
	var timerStatus;
	$(function(){
		
		$('input[name=status]').click(function(){
			var id=$(this).next().attr('data-id');
			var statusP=$(this).prop('checked');
			var ele=$(this);
			
			if(id){
				if(timerStatus){
					clearTimeout(timerStatus);
				}
				$('#tmessage').text('');
				$.ajax({
					url:'${statusURL}',
					type: 'POST',
					data :{
						id :id,
						auditStatus :$(this).prop('checked')
					},
					success:function(data){
						if(data.status){
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
			}else{
				alert('Task not scheduled for this selection.');
				$(this).prop('checked',false);
			}
		});
		
		$('#exportBtn').click(function(){
			$('#exportExlForm').submit();
		});
		
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
		$('#tableBody select').change(function(e){
			
			var ele=$(this);
			
			var id=$(this).attr('data-id');
			var auditor=$(this).val();
			var area=$(this).attr('data-area');
			var date=$(this).attr('data-date');
			var deleted=false;
			if(auditor!=''){
				deleted=true;
			}
			var recurrence=$('select[name=recurrence]').val();
			
			
			if(!recurrence){
				alert('Select recurrence!');
				
				$(this).val('');
			}else{
				
				
				
				$('#tmessage').text('');
				if(timerSave){
					clearTimeout(timerSave);
				}
				
				$.ajax({
					url : '${saveURL}',
					type : 'POST',
					data :{
						id : id,
						auditor : auditor,
						area : area,
						recurrence : recurrence,
						date : date,
						deleted : deleted
					},
					success:function(data){
						if(data.flag){
							$('#tmessage').text(data.message);
							
							timerSave=setTimeout(function(){$('#tmessage').text('');}, 5000);
							
							ele.attr('data-id',data.id);
						}else{
							alert(data.error);
							ele.prop('checked',false);
						}
						loadAllEvent();
					}
				});
			}
			
			
		});
		
		
		
		function loadAllEvent(){
			var recurrence=$('select[name=recurrence]').val();
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			if(recurrence!=''){
				$('#tmessage').text('Loading scheduled events.Please wait....');
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
			
		}
		function changeEvents(){
			
		}
		function setEvents(){
			if(events){
				$('#tableBody input[type=checkbox]').prop('checked',false);
				$('#tableBody input[type=checkbox]').prop('data-id','');
				
				for(var i=0;i<events.length;i++){
					var event=events[i];
					$('#tableBody').find('select').each(function(){
						var area=$(this).attr('data-area');
						var date=$(this).attr('data-date');
						if(area==event.area &
								date==event.formatedDate){
							$(this).val(event.auditor);
							$(this).attr('data-id',event.id);
							$(this).prev().prop('checked',event.auditStatus);
							if(event.auditStatus){
								$(this).prev().attr('title','Audit Complete.');
							}else{
								$(this).prev().attr('title','Audit Incomplete.');
							}

						}
						
					});
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
