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
					<span class="label">Safety Log</span>
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
									<button id="editBtn">Edit</button>
									&nbsp;
									<button id="deleteBtn">Delete</button>
									&nbsp;
									<button id="exportBtn">Export</button>
									&nbsp;
									<button id="printBtn">Print</button>
								</c:if>
								&nbsp;|&nbsp;
								<button id="createBtn">Create</button>
							</td>
							
						</tr>
					</table>

				</div>

<br>
<c:if test="${showFlag }">
<div style="display: none;">
<form id="exportFrom" action='<spring:url value="/safetylogreport/export"/>' method="post" target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
</div>
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
		
	});

</script>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<div id="printDiv">
<table class="table" style="width: 800px; margin: auto;">
	<thead>
		<tr>
			<th style="width: 20px;"></th>
			<th>Entry Date</th>
			<th>Description</th>
			<th>Employee</th>
			
			<th>Action Items</th>
			<th>Category of<br />Incidents</th>
			
			<th>Forklift Shutdown</th>
			<th>Property Damage</th>
			<th>Unsafe Work</th>
			<th>Fire</th>
			<th>Near Miss</th>
			<th>First Aid</th>
			<th>Recordable</th>
			<th>Lost Time</th>
			<th>Other</th>
			<th>Area</th>
			<th>Remarks</th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(safetyLogs) eq 0}">
		<tr>
			<td colspan="17">Data not available for this selection.</td>
		</tr>
	</c:if>
	
	<c:set value="${0}"  var="forkliftShutdownTotal"/>
	<c:set value="${0}"  var="propertyDamageTotal"/>
	<c:set value="${0}"  var="unsafeWorkTotal"/>
	<c:set value="${0}"  var="fireTotal"/>
	<c:set value="${0}"  var="nearMissTotal"/>
	<c:set value="${0}"  var="firstAidTotal"/>
	<c:set value="${0}"  var="recordableTotal"/>
	<c:set value="${0}"  var="lostTimeTotal"/>
	<c:set value="${0}"  var="otherTotal"/>
	
	<c:if test="${fn:length(safetyLogs) > 0}">
		<c:forEach items="${safetyLogs}" var="safetyLog">
			<tr>
				<td> <input type="radio" name="id" value="${safetyLog.id }"> </td>
				<td><div style="width: 80px;text-align: center;"><fmt:formatDate value="${safetyLog.date}" pattern="MM-dd-yyyy"/></div></td>
				<td>${safetyLog.description}</td>
				<td>${safetyLog.employee}</td>
				<td>${safetyLog.actionitems}</td>
				<td>${safetyLog.categoryofincidents}</td>
				<td style="text-align: center;"><c:if test="${safetyLog.forkliftShutdown ne 0}">${safetyLog.forkliftShutdown}</c:if></td>
				<td style="text-align: center;"><c:if test="${safetyLog.propertyDamage ne 0}">${safetyLog.propertyDamage}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.unsafeWork ne 0}">${safetyLog.unsafeWork}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.fire ne 0}">${safetyLog.fire}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.nearMiss ne 0}">${safetyLog.nearMiss}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.firstAid ne 0}">${safetyLog.firstAid}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.recordable ne 0}">${safetyLog.recordable}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.lostTime ne 0}">${safetyLog.lostTime}</c:if> </td>
				<td style="text-align: center;"><c:if test="${safetyLog.other ne 0}">${safetyLog.other}</c:if> </td>
				<td>${safetyLog.area}</td>
				<td>${safetyLog.remarks}</td>
			</tr>
			<c:set value="${forkliftShutdownTotal+safetyLog.forkliftShutdown}"  var="forkliftShutdownTotal"/>
			<c:set value="${propertyDamageTotal+safetyLog.propertyDamage}"  var="propertyDamageTotal"/>
			<c:set value="${unsafeWorkTotal+safetyLog.unsafeWork}"  var="unsafeWorkTotal"/>
			<c:set value="${fireTotal+safetyLog.fire}"  var="fireTotal"/>
			<c:set value="${nearMissTotal+safetyLog.nearMiss}"  var="nearMissTotal"/>
			<c:set value="${firstAidTotal+safetyLog.firstAid}"  var="firstAidTotal"/>
			<c:set value="${recordableTotal+safetyLog.recordable}"  var="recordableTotal"/>
			<c:set value="${lostTimeTotalsafetyLog.lostTime}"  var="lostTimeTotal"/>
			<c:set value="${otherTotal+safetyLog.other}"  var="otherTotal"/>
		</c:forEach>
	</c:if>
	</tbody>
	<c:if test="${fn:length(safetyLogs) > 0}">
		
		
	
		<tfoot>
			<tr>
				<td colspan="6" style="text-align: right;"><b>Total</b></td>
				<td style="text-align: center;"><b>${forkliftShutdownTotal}</b></td>
				<td  style="text-align: center;"><b>${propertyDamageTotal}</b></td>
				<td  style="text-align: center;"><b>${unsafeWorkTotal}</b></td>
				<td  style="text-align: center;"><b>${fireTotal}</b></td>
				<td  style="text-align: center;"><b>${nearMissTotal}</b></td>
				<td  style="text-align: center;"><b>${firstAidTotal}</b></td>
				<td  style="text-align: center;"><b>${recordableTotal}</b></td>
				<td  style="text-align: center;"><b>${lostTimeTotal}</b></td>
				<td  style="text-align: center;"><b>${otherTotal}</b></td>
				<td colspan="2"></td>
			</tr>
		</tfoot>
	</c:if>
</table>
<br><br>
</div>
</div>
</c:if>

			</div>

		</div>


	</div>

<div id="dialog" title="Safety Log" style="display: none;overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit;border: none;"></iframe>
</div>

<spring:url value="/safetylog/add" var="addURL"/>
<spring:url value="/safetylogreport/view" var="viewURL"/>

<spring:url value="/safetylog/edit" var="editURL"/>
<spring:url value="/safetylog/delete" var="deleteURL"/>

<script type="text/javascript">
	
	$(function(){
		$('#createBtn').click(function(){
			$("#dialog #dialogPage").attr('src', '${addURL}');
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
		});
		
		$('#viewBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			
			location.href='${viewURL}/'+sdate+'/'+edate;
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
		
		$('#deleteBtn').click(function(){
			var id=$('input[name=id]:checked').val();
			if(id){
				$.ajax({
					url : '${deleteURL}',
					type : 'POST',
					data : {id:id},
					success:function(data){
						if(data.flag){
							alert('Data removed from database.')
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}else{
				alert('Select row!');
			}
		});
	});

</script>
</body>
</html>
