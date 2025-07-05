<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
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
					<span class="label">Safety Log - Reviews</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>From Date</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" style="width: 80px;" readonly="readonly">
							</td>
							<td>To Date</td>
							<td>
								<input type="text" name="edate" value="${edate}"  style="width: 80px;" readonly="readonly">
							</td>
							<td>
								<button id="viewBtn">View</button>
								&nbsp;
								<c:if test="${showFlag }">
									<button id="editBtn">Edit-Days to Completion</button>
									&nbsp;
									<button id="resetBtn">Reset-Days to Completion</button>
									&nbsp;
									<button id="exportBtn">Export</button>
									&nbsp;
									<button id="printBtn">Print</button>
								</c:if>
								
							</td>
							
						</tr>
					</table>

				</div>

<br>
<c:if test="${showFlag }">
<div style="display: none;">
<form id="exportFrom" action='<spring:url value="/safetylogreport/export2"/>' method="post" target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
</div>
<spring:url value="/safetylog/edit/review" var="editURL"/>

<spring:url value="/safetylog/reset" var="resetURL"/>

<script type="text/javascript">
	$(function(){
		$('#exportBtn').click(function(){
			$('#exportFrom').submit();
		});
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea({
				retainAttr:['class','style']
			});
		});
		$('#resetBtn').click(function(){
			var id=$('input[name=id]:checked').val();
			
			if(id){
				$.ajax({
					url:'${resetURL}',
					type:'POST',
					data:{id:id},
					success:function(data){
						if(data.flag){
							alert('Data reset successfully.');
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
	});

</script>


<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<div id="printDiv">
<table class="table" style="width: 800px; margin: auto;">
	<thead>
		<tr>
			<td style="width: 15px;"></td>
			<th>Entry Date</th>
			<th>Incident Date</th>
			<th>Days To Report</th>
			<th>Description</th>
			<th>Days to Completion</th>
			<th>Employee</th>
			<th>Area</th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(safetyLogs) eq 0}">
		<tr>
			<td colspan="15">Data not available for this selection.</td>
		</tr>
	</c:if>
	
	<c:if test="${fn:length(safetyLogs) > 0}">
		<c:forEach items="${safetyLogs}" var="safetyLog">
			<tr>
				<td> <input type="radio" name="id" value="${safetyLog.id }"> </td>
				<td><div style="width: 80px;"><fmt:formatDate value="${safetyLog.date}" pattern="MM-dd-yyyy"/></div></td>
				
				<c:if test="${not empty safetyLog.incidentDate}">
					<td><div style="width: 80px;"><fmt:formatDate value="${safetyLog.incidentDate}" pattern="MM-dd-yyyy"/></div></td>
					<td><div style="width: 50px;text-align: center;">${safetyLog.daysToReport}</div> </td>
				</c:if>
				<c:if test="${empty safetyLog.incidentDate}">
					<td><div style="width: 80px;"></td>
					<td><div style="width: 50px;"></div> </td>
				</c:if>
				
				<td>${safetyLog.description}</td>
				<td style="text-align: center;">
					<c:if test="${empty safetyLog.dayToCompletion}">
						<a href="javascript:void(0)" id="close_${safetyLog.id}" data-id="${safetyLog.id}">Close</a>
					</c:if>
					<c:if test="${not empty safetyLog.dayToCompletion}">
						${safetyLog.numOfdays}
					</c:if>
					
				</td>
				<td>${safetyLog.employee}</td>
				<td>${safetyLog.area}</td>
				
			</tr>
			
		</c:forEach>
	</c:if>
	</tbody>
	
</table>
</div>
</div>
</c:if>

			</div>

		</div>


	</div>

<div id="dialog" title="Safety Log" style="display: none;overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit;border: none;"></iframe>
</div>
<spring:url value="/safetylogreport/view2" var="viewURL"/>
<spring:url value="/safetylog/close" var="closeURL"/>


<script type="text/javascript">
	
	$(function(){
		
		
		$('#viewBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			
			location.href='${viewURL}/'+sdate+'/'+edate;
		});
		
		$('*[id^=close_]').click(function(){
			var id=$(this).attr('data-id');
			if(id){
				
				$.ajax({
					url : '${closeURL}',
					type : 'POST',
					data : {id:id},
					success:function(data){
						if(data.flag){
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				}); 
			}else{
				alert('Invalid row!');
			}
		});
		$('#editBtn').click(function(){
			
			var id=$('input[name=id]:checked').val();
			if(id){
				
				 $("#dialog #dialogPage").attr('src', '${editURL}/'+id);
					$("#dialog").dialog({
				        width: 800,
				        height: 550,
				        modal: true,
				        position: {my: "center", at: "center", of: window.top},
				        close: function () {
				        	$("#dialog #dialogPage").attr('src', "about:blank");
				        	location.reload(true);
				        }
				    
				    }); 
			}else{
				alert('Select row!');
			}
			
			/**/
		});
	});

</script>
</body>
</html>
