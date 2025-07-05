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
.hdbg{
	background-color: #FCDBB4;
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

	<div class="top-container">
		<div class="page-title">
			<span class="label">Standard-Assignment</span>
			
			<br>
		</div>
	</div>
	<div class="bot-container">
		<div class="table-selector">

			<table>
				<tr>
					<td>Audit Date</td>
					<td>
						<input type="text" name="date" value="${date}" style="width: 80px;" >
					</td>
					<td>Areas</td>
					<td>
						<select name="type" style="padding: 2px;width: 120px;">
							<option value="">Select</option>
							<c:forEach items="${types}" var="st">
								<c:choose>
									<c:when test="${st.id eq type}">
										<option value="${st.id}" selected="selected">${st.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${st.id}">${st.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<td>Auditor</td>
					<td>
						<select name="auditor" style="padding: 2px;width: 100px;">
							<option value="">Select</option>
							<c:forEach items="${auditors}" var="user">
								<c:choose>
									<c:when test="${user.id eq auditor}">
										<option value="${user.id}" selected="selected">${user.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${user.id}">${user.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					
					</td>
					<%-- <td>Area</td>
					<td>
						<select name="area" style="padding: 2px;width: 100px;">
							<option value="">Select</option>
							<c:forEach items="${areas}" var="ar">
								<c:choose>
									<c:when test="${ar.id eq area}">
										<option value="${ar.id}" selected="selected">${ar.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${ar.id}">${ar.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					
					</td> --%>
					
					
				</tr>
				<tr>
				<td colspan="6" align="left">
					<button id="viewBtn">View</button>
					<!-- <button onclick="$('#printForm').submit();">Print</button> -->
					<c:if test="${showFlag}">
						<button onclick="$('#pdfForm').submit();">PDF</button>
						<spring:url value="/safetyhousekeepingreport/viewreport/${taskId}/${date}/${date}" var="reportURL"/>
						<button onclick="parent.window.location.href='${reportURL}'">Previous Audit Report</button>
					</c:if>
				</td>
				
				</tr>
			</table>

		</div>


		<div style="position: fixed; top: 100px; right: 5px; left: 0; bottom: 0; overflow: auto;">

	
		
<c:if test="${showFlag}">

<div style="display: none;">
	<spring:url value="/safetyhousekeepingreport/export/standard/pdf" var="pdfURL"/>
	<form id="pdfForm" action="${pdfURL}" method="post" target="_blank">
		<input type="hidden" name="taskId" value="${taskId}"> 
	</form>
</div>


	<table class="table" style="width: 600px; margin: auto;">
		<c:choose>
			<c:when test="${not empty type}">
						
						
						<tr>
							<th class="hdbg" style="width: 15px;"></th>
							<th class="hdbg" colspan="2">${type}</th>
							<th class="hdbg">
								<div style="width: 90px;">Score : <span id="${type}">0</span> %</div>
							</th>
							
						</tr>
						
						
						<c:forEach items="${housekeepings}" var="safetyHouse" varStatus="i">
								<tr>
									<td>
									<c:choose>
										<c:when test="${safetyHouse.completed}">
											<input type="checkbox" id="cid_${safetyHouse.id}" checked="checked" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="cid_${safetyHouse.id}" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">
										</c:otherwise>
									</c:choose>	
									</td>
									<td style="text-align: center;">${i.count}</td>
									<td>${safetyHouse.description}</td>
									<td style="text-align: center;"> 
										<c:if test="${safetyHouse.completed eq false}">
											<a href="javascript:void(0);" id="viewAction_${safetyHouse.id}" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">Actions</a>
										</c:if>
									 </td>
								</tr>

						</c:forEach>
					</tbody>
					
					
			</c:when>
			<c:otherwise>
			
				<c:forEach items="${types}" var="stdtype">

						<tr>
							<th class="hdbg" style="width: 15px;"></th>
							<th class="hdbg" colspan="2">${stdtype.name}</th>
							<th class="hdbg">
								<div style="width: 90px;">Score : <span id="${stdtype.id}">0</span> %</div>
							</th>
						</tr>
						
						<c:set value="${1}" var="conter"/>
						
						<c:forEach items="${housekeepings}" var="safetyHouse">
							<c:if test="${stdtype.id eq  safetyHouse.type}">
								<tr>
									<td>
									<c:choose>
										<c:when test="${safetyHouse.completed}">
											<input type="checkbox" id="cid_${safetyHouse.id}" checked="checked" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="cid_${safetyHouse.id}" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">
										</c:otherwise>
									</c:choose>	
									</td>
									<td style="text-align: center;">${conter}</td>
									<td>${safetyHouse.description}</td>
									<td style="text-align: center;"> 
										<c:if test="${safetyHouse.completed eq false}">
											<a href="javascript:void(0);" id="viewAction_${safetyHouse.id}" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">Actions</a>
										</c:if>
										<c:if test="${safetyHouse.completed eq true}">
											<a style="display: none;" href="javascript:void(0);" id="viewAction_${safetyHouse.id}" data-id="${safetyHouse.id}" data-task="${safetyHouse.taskId}">Actions</a>
										</c:if>
									 </td>
								</tr>
								<c:set value="${conter+1}" var="conter"/>
							</c:if>
						</c:forEach>
						<c:set value="${0}" var="conter"/>
					</tbody>
					
					</c:forEach>
			</c:otherwise>
		</c:choose>
		
		
		
	</table>
</c:if>

		
			<br>
			<br>
			
		</div>

	</div>






	<div id="dialog" title="Safety Housekeeping"
		style="display: none; overflow: hidden;">
		<iframe id="dialogPage"
			style="width: 100%; height: inherit; border: none;"></iframe>
	</div>

	<spring:url value="/safetyhousekeeping/view/task" var="viewURL" />
	<spring:url value="/safetyhousekeeping/delete/task" var="deleteURL" />
	<spring:url value="/safetyhousekeeping/check/task" var="checkedURL" />
	
	<spring:url value="/safetyhousekeeping/view/task/score" var="taskScoreURL" />

	<script type="text/javascript">
		$(function() {
			
			parent.resetAction();
			
			$('*[id^=cid_]').click(function(){
				var ele=$(this);
				var flag=$(this).prop('checked');
				var id=$(this).attr('data-id');
				var taskId=$(this).attr('data-task');

				$.ajax({
					url:'${checkedURL}',
					type:'POST',
					data:{
						id : id,
						checked : flag,
						taskId :taskId
						
					},
					success:function(data){
						if(data.flag){
							
							if(data.closed){
								var actionLink='#viewAction_'+id;
								if($(actionLink).is(":visible")){
									$(actionLink).hide();
								}else{
									$(actionLink).show();
								}
								getScore();
								
							}else{
								ele.prop('checked',!flag);
							}
							
							
						}else{
							alert(data.error);
							
						}
						
						
					}
				}); 
				
			});
			
			$('*[id^=viewAction_]').click(function(){
				var id=$(this).attr('data-id');
				var taskId=$(this).attr('data-task');
				parent.viewAction(id,taskId);
				
			});
			
			$('#viewBtn').click(function(){
				if($('select[name=type]').val()==''){
					alert('Select Area!');
				}else if($('select[name=auditor]').val()==''){
					alert('Select Auditor!');
				}/* else if($('select[name=area]').val()==''){
					alert('Select Area!');
				} */else if($('input[name=date]').val()==''){
					alert('Select Date!');
				}else{
					if($('select[name=type]').val()==''){
						location.href='${viewURL}/'+$('select[name=auditor]').val()
						 +'/'+$('select[name=auditor]').val()+'/'+encodeURIComponent($('input[name=date]').val());	
					}else{
						location.href='${viewURL}/'+$('select[name=type]').val()+'/'+$('select[name=auditor]').val()
						 +'/'+$('select[name=auditor]').val()+'/'+encodeURIComponent($('input[name=date]').val());
					}
				 
				}
			});
			
			$('#addBtn').click(function() {
				parent.addTask();
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
			
			$('#editBtn').click(function(){
				var id=$('input[name=id]:checked').val();
				if(id){
					parent.editTask(id);
				}else{
					alert('Select row!');
				}
			});
			
			
			getScore();
		});
		
		function getScore(){
			var taskId='${taskId}';
			
			if(taskId){
				$.ajax({
					url:'${taskScoreURL}',
					type: 'POST',
					data : {id : taskId},
					success:function(data){
						if(data){
							for(var i=0;i<data.length;i++){
								var type=data[i];
								if($('#'+type.id).length>0){
									$('#'+type.id).text(type.score);
								}
							}
						}
					}
				});
			}
		}
	</script>

</body>
</html>
