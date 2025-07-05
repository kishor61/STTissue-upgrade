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
							</td>
						</tr>
					</table>

				</div>
<br>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<c:if test="${showFlag}">

<table class="stable">
<c:set value="${fn:length(dates)}" var="colNum"/>
	<thead id="tableHead">
		<tr>
			<td class="tdbgA" style="font-weight: bold;text-align: center;">Auditor</td>
			<c:forEach begin="1" end="${colNum}">
				<td class="tdbgA">
					<select name="auditor" style="width: 100px; padding: 3px;">
						<option value="">Select</option>
						<c:forEach items="${autiors}" var="auditor">
							<option value="${auditor.id}">${auditor.name}</option>
						</c:forEach>
					</select>
				</td>
			</c:forEach>
		</tr>
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
						<td><input type="checkbox" 
						data-id=""
						data-area="${area.id}" 
						data-auditor="" 
						data-date='<fmt:formatDate value="${dates[i.index]}" pattern="MM-dd-yyyy"/>'> </td>
					</c:forEach>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>
<spring:url value="/safetyhousekeeping/schedule/save" var="saveURL"/>
<spring:url value="/safetyhousekeeping/schedule/load" var="loadURL"/>
<script type="text/javascript">
	var timerSave;
	var events;
	$(function(){
		$('select[name=auditor]').change(function(){
			var col=$(this).parent().index();
			var auditor=$(this).val();
			$('#tableBody tr').each(function(){
				$(this).find('td:eq('+col+')').children('input[type=checkbox]').attr('data-auditor',auditor);
			});
			changeEvents();
		});
		
		$('#tableBody input[type=checkbox]').click(function(e){
			
			var ele=$(this);
			
			var id=$(this).attr('data-id');
			var auditor=$(this).attr('data-auditor');
			var area=$(this).attr('data-area');
			var date=$(this).attr('data-date');
			var deleted=$(this).prop('checked');
			var recurrence=$('select[name=recurrence]').val();
			
			
			if(!auditor){
				alert('Select auditor!');
				
				if($(this).prop('checked')){
					$(this).prop('checked',false);
				}else{
					$(this).prop('checked',true);
				}
				
			}else if(!recurrence){
				alert('Select recurrence!');
				
				if($(this).prop('checked')){
					$(this).prop('checked',false);
				}else{
					$(this).prop('checked',true);
				}
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
						recurrence : recurrence,
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
			if(events){
				$('#tableBody input[type=checkbox]').prop('checked',false);
				$('#tableBody input[type=checkbox]').prop('data-id','');
				
				for(var i=0;i<events.length;i++){
					var event=events[i];
					$('#tableBody').find('input[type=checkbox]').each(function(){
						var auditor=$(this).attr('data-auditor');
						var area=$(this).attr('data-area');
						var date=$(this).attr('data-date');
						if(auditor==event.auditor &
								area==event.area &
								date==event.formatedDate){
							$(this).prop('checked',true);
							$(this).attr('data-id',event.id);

						}
						
					});
				}
			}
		}
		function setEvents(){
			if(events){
				
				$('#tableBody input[type=checkbox]').prop('checked',false);
				$('#tableBody input[type=checkbox]').prop('data-id','');
				
				for(var i=0;i<events.length;i++){
					var event=events[i];
					$('#tableBody').find('input[type=checkbox]').each(function(){
						var area=$(this).attr('data-area');
						var date=$(this).attr('data-date');
						if(area==event.area & date==event.formatedDate){
							var tdIndex=$(this).parent().index();
							$('#tableHead tr:first-child').find('td:eq('+tdIndex+')').children('select[name=auditor]').val(event.auditor);
							$('#tableBody tr').each(function(){
								$(this).find('td:eq('+tdIndex+')').children('input[type=checkbox]').attr('data-auditor',event.auditor);
							});
						}
					});
				}
				
			changeEvents();
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
