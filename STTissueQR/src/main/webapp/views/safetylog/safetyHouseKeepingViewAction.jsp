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
body {
	margin: 0;
	padding: 3px;
}

.top-container {
	height: 26px;
	position: fixed;
	left: 0;
	right: 0;
}

.bot-container {
	position: fixed;
	top: 32px;
	left: 0;
	right: 0;
	bottom: 0;
	overflow: auto;
}

.table td {
	font-size: 12px;
}
</style>

<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
	});
</script>
</head>
<body>

	<div class="top-container">
		<div class="page-title">
			<span class="label">Actions</span>
		</div>
	</div>
	<div class="bot-container">
		<div class="table-selector">

			<table>
				<tr>
					<%-- <td>From Date</td>
					<td><input type="text" name="sdate" value="${sdate}"
						style="width: 80px;" readonly="readonly"></td>
					<td>To Date</td>
					<td><input type="text" name="edate" value="${edate}"
						style="width: 80px;" readonly="readonly"></td> --%>
					<td>
						&nbsp;
						<button id="newBtn">New</button>
						&nbsp;
						<button id="editBtn">Edit</button>
						&nbsp;
						<button id="deleteBtn">Delete</button>
					</td>

				</tr>
			</table>

		</div>


		<div style="position: fixed;top: 78px;right: 5px;left: 0;bottom: 0;overflow: auto;">

<!-- <div id="printDiv">	 -->

		
		<p style="font-size: 14px;">
			<b>Standard Type : </b> ${type}
		</p>
		<p style="font-size: 14px;">
			<b>Description : </b> ${housekeeping.description}
		</p>
		<br>
		
	
		<p style="font-size: 14px;text-align: center;" >
			<b>Audit Date : </b><fmt:formatDate value="${housekeepingTask.date}" pattern="MM-dd-yyyy"/> 
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			<b>Auditor : </b> ${housekeepingTask.auditorName}
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			<b>Area : </b> ${housekeepingTask.areaName}
		</p>
		

<c:if test="${showFlag}">	
	<table class="table" style="width: 600px; margin: auto;">
		<thead>
			<tr>
				<th style="width: 15px;"></th>
				<th>Description Of Finding</th>
				<th>Corrective Action</th>
				<th>By Whom</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(housekeepingActions) gt 0}">
				<c:forEach items="${housekeepingActions}" var="action">
					
					<%-- <c:if test="${empty action.closed}"> --%>
						<tr>
							<td><input type="radio" name="id" value="${action.id}"></td>
							<td>${action.descOfFinding}</td>
							<td>${action.correctiveAction}</td>
							<td>${action.byWhom}</td>
							<c:if test="${empty action.closed}">
								<td style="text-align: center;"><a href="javascript:void(0);" id="close_${action.id}" data-id="${action.id}">Close</a> </td>
							</c:if>
							<c:if test="${not empty action.closed}">
								<td style="text-align: center;">Closed</td>
							</c:if>
							<td>
							<c:if test="${not empty action.document}">
								<a href="<spring:url value="/assets/HousekeepingActionDocuments/${action.document}"/>" target="_blank">File</a>
							</c:if>
							</td>
						</tr>
					<%-- </c:if> --%>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(housekeepingActions) eq 0}">
				<tr>
					<td colspan="5" style="text-align: center;">Data not fond for this selection.</td>
				</tr>
				
			</c:if>
		</tbody>
	</table>
</c:if>
<!-- 
</div>	 -->	
			<br>
			<br>
		</div>

	




	</div>







	
	
	<spring:url value="/safetyhousekeeping/view/action/${sid}" var="viewURL" />
	<spring:url value="/safetyhousekeeping/delete/action" var="deleteURL" />
	<spring:url value="/safetyhousekeeping/close/action" var="closeURL" />

	<div id="dialog" title="Safety Housekeeping" style="display: none; overflow: hidden;">
		<iframe id="dialogPage" style="width: 100%; height: inherit; border: none;"></iframe>
	</div>

	<script type="text/javascript">
		$(function() {

			$('#printBtn').click(function(){
				$('#printDiv').printArea({
					retainAttr:['class','style']
				});
			});
			
			$('#newBtn').click(function() {
				var sid='${sid}';
				var taskId='${taskId}';
				parent.addAction(sid,taskId);
			});
			$('#editBtn').click(function() {
				var id=$('input[name=id]:checked').val();				
				if(id){
					parent.editAction(id);	
				}else{
					alert('Select row');
				}
				
			});

			$('#viewBtn').click(function() {
				var sdate = $('input[name=sdate]').val();
				var edate = $('input[name=edate]').val();
				location.href = '${viewURL}/' + sdate + '/' + edate;
			});

			$('#deleteBtn').click(function(){
				var id=$('input[name=id]:checked').val();
				
				if(id){
					$.ajax({
						url:'${deleteURL}',
						type:'GET',
						data:{id:id},
						success:function(data){
							if(data.flag){
								alert('Data removed from database.');
							}else{
								alert(data.error);
							}
							location.reload(true);
						}
					});
				}else{
					alert('Select row!');
				}
			});
			
			$('*[id^=close_]').click(function(){
				var id=$(this).attr('data-id');
				var url='${closeURL}/'+id;
				$("#dialog #dialogPage").attr('src',url);
				$("#dialog").dialog({
					width : 400,
					height : 400,
					modal : true,
					close : function() {
						$("#dialog #dialogPage").attr('src', "about:blank");
						location.href=location.href;
					}

				});
				
			});
		});
	</script>

</body>
</html>
