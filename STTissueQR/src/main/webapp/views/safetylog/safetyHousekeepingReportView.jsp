<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/style.css"/>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/custom-theme/jquery-ui-1.10.4.custom.min.css"/>'>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery-ui-1.10.4.custom.min.js"/>'></script>
<style type="text/css">
.hkhead{
background-color: #C8C8C8;
}
</style>
</head>
<body>

<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>

<spring:url value="/safetyhousekeepingreport/load/data/${sdate}/${edate}" var="backURL"/>
								
		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Safety Housekeeping</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>
								
								<button onclick="location.href='${backURL}'">Back To Report</button>
								<spring:url value="/safetyhousekeeping/edit/task/${housekeepingTask.id}" var="editTaskURL"/>
								<button onclick="location.href='${editTaskURL}'">Edit</button>
								<button value="<spring:url value="/safetyhousekeeping/delete/task/${housekeepingTask.id}"/>" id="deleteBtn">Delete</button>
								&nbsp;&nbsp;
								|
								&nbsp;&nbsp;
								<a href='<spring:url value="/safetyhousekeepingreport/export/standard/pdf/${housekeepingTask.id}"/>' target="_blank">PDF</a>
								
							</td>
						</tr>
					</table>

				</div>
<br>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table class="table" style="width: 900px; margin: auto;">


		<thead>
				<tr>
					<td colspan="3" style="text-align: center;"><b>Audit Date: </b><fmt:formatDate value="${housekeepingTask.date}" pattern="MM-dd-yyyy"/>  </td>
					<td  colspan="2" style="text-align: center;"><b>Auditor: </b>${housekeepingTask.auditorName }</td>
					<td  colspan="3" style="text-align: center;"><b>Area: </b>${housekeepingTask.areaName }</td>
					
				</tr>
		</thead>
	<c:forEach items="${types}" var="type">
	
	
	
		<tbody>
				
				<tr>
					<td style="width: 15px;" class="hkhead"></td>
					<td style="width: 15px;" class="hkhead"><b>S.No.</b></td>
					<td colspan="5" style="text-align: center;" class="hkhead"><b>${type.name}</b></td>
					<td style="text-align: center;font-weight: bold;" class="hkhead">Score: <fmt:formatNumber value="${type.score }"/> </td>
				</tr>
			
			
			
			<c:set value="${1}" var="counter"/>
			
			<c:forEach items="${housekeepings}"  var="housekeeping" varStatus="i">
				
				<c:if test="${type.id eq  housekeeping.type}">
						<tr>
								<td class="hkheadrow">
									<c:if test="${housekeeping.completed}">
										<span class="ui-icon ui-icon-check"></span>
									</c:if>
								</td>
								<td class="hkheadrow" style="text-align: center;">${counter}</td>
								<td class="hkheadrow" colspan="6">${housekeeping.description}</td>
								<c:set value="${counter+1}" var="counter"/>
							</tr>
							
							<c:if test="${fn:length(housekeeping.actions) gt 0}">
								
								<tr>
									<td class="hkaction" colspan="2" rowspan="${fn:length(housekeeping.actions)+1}" style="vertical-align: middle;text-align: center;"><b>Actions</b></td>
									<td class="hkaction" style="text-align: center;"><div style="width:150px;"><b>Description Of Finding</b></div></td>
									<td class="hkaction" style="text-align: center;"><div style="min-width:150px;"><b>Corrective Action</b></div></td>
									<td class="hkaction" style="text-align: center;"><div style="min-width:80px;"><b>By Whom</b></div></td>
									<td class="hkaction" style="text-align: center;"><b>Status</b></td>
									<td class="hkaction" style="text-align: center;"><div style="width: 80px;"><b>Closed By</b></div></td>
									<td class="hkaction" style="text-align: center;"><div style="width: 80px;"><b>Closed On</b></div></td>
									
								</tr>
								<c:forEach items="${housekeeping.actions}" var="action">
									<tr>
										<%-- <td colspan="2" style="text-align: center;">
											<input type="radio" name="fid" value="${action.id}">
										</td> --%>
										<td class="hkactionrow" >${action.descOfFinding}</td>
										<td class="hkactionrow" >${action.correctiveAction}</td>
										<td class="hkactionrow" >${action.byWhom}</td>
										<td class="hkactionrow"  style="text-align: center;">
											<c:choose>
												<c:when test="${empty action.closed}">
													<a href="javascript:void(0);" id="close_${action.id}" data-id="${action.id}">Open</a>
												</c:when>
												<c:otherwise>
													Closed
												</c:otherwise>
											</c:choose>
										</td>
										<td class="hkactionrow" >${action.closedBy}</td>
										<td class="hkactionrow" style="text-align: center;"><fmt:formatDate value="${action.closed}" pattern="MM-dd-yyyy"/></td>
										
									</tr>
								</c:forEach>
								<!-- <tr>
									<td colspan="9"><div style="height: 20px;"></div></td>
								</tr> -->
							</c:if>
				
				</c:if>
				
				
			
			
			</c:forEach>
			<c:set value="${1}" var="counter"/>
			<tr>
				<td colspan="8">&nbsp; </td>
			</tr>
			
			</tbody>
	</c:forEach>
</table>
</div>
			</div>

		</div>


	</div>

<div id="dialog" title="Safety Housekeeping" style="display: none; overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit; border: none;"></iframe>
</div>
<spring:url value="/safetyhousekeeping/close/action" var="closeURL" />
<spring:url value="/safetyhousekeeping/edit/action" var="editActionURL"/>

<script type="text/javascript">
	$(function(){
		/* $('#editBtn').click(function(){
			var fid=$('input[name=fid]:checked').val();
			if(fid){
				editAction(fid);
			}else{
				alert('Select row!');
			}
		}); */
		$('*[id^=close_]').click(function(){
			var id=$(this).attr('data-id');
			var url='${closeURL}/'+id;
			$("#dialog #dialogPage").attr('src',url);
			$("#dialog").dialog({
				width : 400,
				height : 300,
				modal : true,
				close : function() {
					$("#dialog #dialogPage").attr('src', "about:blank");
					location.href=location.href;
				}

			});
			
		});
	});
	/* function editAction(id){
		$("#dialog #dialogPage").attr('src', '${editActionURL}/'+id);
		$("#dialog").dialog({
			width : 600,
			height : 400,
			modal : true,
			position : {
				my : "center",
				at : "center",
				of : window.top
			},
			close : function() {
				$("#dialog #dialogPage").attr('src', "about:blank");
				location.reload(true);
			}

		});
	} */
</script>
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
			
			$('#deleteBtn').click(function(e){
				e.preventDefault();
				$('#passwordDialog input[name=password]').val('');
				$('#passwordDialog .error').text('');
				var url=$(this).val();
				
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
		                				location.href='${backURL}';
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
