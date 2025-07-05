<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate], input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>

<style type="text/css">
 .table td{
 	text-align: center;
 }
</style>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Safety Housekeeping - Report</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>
								From
							</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" readonly="readonly" style="width: 70px;">
							</td>
							<td>
								To
							</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 70px;">
							</td>
							
							
							<td>
								<button id="loadBtn">Load</button>
								
								
							</td>
						</tr>
					</table>

				</div>


<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
	
<c:if test="${flagShow}">
<table class="table" style="width: 500px; margin: auto;">
	<thead>
		<tr>
			<td>Audit Date</td>
			<td>Area</td>
			<td>Auditor</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${housekeepingTasks}" var="task">
		<c:if test="${not empty task.completed}">
			<tr>
				<td><fmt:formatDate value="${task.date}" pattern="MM-dd-yyyy"/></td>
				<td>${task.areaName}</td>
				<td>${task.auditorName}</td>
				<td style="text-align: center;">
				<a href='<spring:url value="/safetyhousekeepingreport/viewreport/${task.id}/${sdate}/${edate}"/>'>VIEW</a>
				&nbsp;
				<a href='<spring:url value="/safetyhousekeepingreport/export/standard/pdf/${task.id}"/>' target="_blank">PDF</a>
				&nbsp;
				<%-- <a href='<spring:url value="/safetyhousekeeping/delete/task/${task.id}"/>' id="delete_${task.id}">DELETE</a> --%>
				 
				</td>
			</tr>
		</c:if>
		</c:forEach>
	</tbody>
</table>

</c:if>
	
	
	
	

</div>



			</div>

		</div>


	</div>


<div id="passwordDialog" style="display: none;" title="User Authentication">
	<table>
		<tr>
			<td>Please enter password</td>
		</tr>
		<tr>
			<td><input type="password" name="password"> </td>
		</tr>
		<tr>
			<td><span class="error"></span> </td>
		</tr>
	</table>
</div>

<spring:url value="/safetyhousekeepingreport/load/data" var="loadData"/>

<script type="text/javascript">
		$(function(){
			
			$('#loadBtn').click(function(){
				var sdate=$('input[name=sdate]').val();
				var edate=$('input[name=edate]').val();
				location.href='${loadData}/'+encodeURIComponent(sdate)+'/'+encodeURIComponent(edate);
			});
			
			$('*[id^=delete_]').click(function(e){
				e.preventDefault();
				$('#passwordDialog input[name=password]').val('');
				$('#passwordDialog .error').text('');
				var url=$(this).attr('href');
				
				$("#passwordDialog").dialog({
		            width: 300,
		            height: 180,
		            modal: true,
		            buttons: {
		                "Continue": function() {
		                	var ele=$( this );
		                	var pass=$('#passwordDialog input[name=password]').val();
		                	if($.trim(pass)==''){
		                		$('#passwordDialog .error').text('Please enter password!');
		                		return;
		                	}
		                	$('#passwordDialog .error').text('');
		                
		                	$.ajax({
		                		url:url,
		                		type:'POST',
		                		data:{password:pass},
		                		success:function(data){
		                			if(data.flag){
		                				ele.dialog("close");
		                				alert('Data removed from database.');
		                				location.reload(true);
		                			}else{
		                				$('#passwordDialog .error').text(data.error);
		                			}
		                		}
		                	});
		                 
		                },
		                Cancel: function() {
		                  $( this ).dialog( "close" );
		                }
		            }
		        });
				
			});
			
		});
	
	</script>
	
</body>
</html>
