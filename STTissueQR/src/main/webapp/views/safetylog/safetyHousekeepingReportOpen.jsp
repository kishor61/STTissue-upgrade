<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>z
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/style.css"/>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/custom-theme/jquery-ui-1.10.4.custom.min.css"/>'>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery-ui-1.10.4.custom.min.js"/>'></script>
<style type="text/css">
.hkmain{
	background-color: rgb(219, 195, 163);
}
.hkhead{
	background-color: #F0F0F0;
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
					<span class="label">Safety Housekeeping - Open Actions Report</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Area</td>
							<td>
								<select name="area" style="padding: 3px;">
									<option value="0">All</option>
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
							</td>
							<td>Auditor</td>
							<td>
								<select name="auditor" style="padding: 3px;">
									<option value="0">All</option>
									<c:forEach items="${auditors}" var="au">
										<c:choose>
											<c:when test="${au.id eq auditor}">
												<option value="${au.id}" selected="selected">${au.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${au.id}">${au.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>By Whom</td>
							<td>
								<select name="bywhom" style="padding: 3px;">
									<option value="">All</option>
									<c:forEach items="${auditors}" var="au">
										<c:choose>
											<c:when test="${au.name eq bywhom}">
												<option value="${au.name}" selected="selected">${au.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${au.name}">${au.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<button id="viewBtn">View</button>
								
								&nbsp;
								<input type="button" value="Send Mail" id="sendMailBtn">
								
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;
								<a href='<spring:url value="/safetyhousekeepingreport/export/openreport/pdf?area=${area}&auditor=${auditor}&bywhom=${bywhom}"/>' target="_blank">PDF</a>	
							</td>
						</tr>
					</table>

				</div>
<br>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<table class="table" style="width: 900px; margin: auto;">
		
		<c:forEach items="${housekeepings}" var="h">
			<c:if test="${fn:length(h.actions) gt 0}">
			<tr>
				<td class="hkmain" colspan="5" style="font-weight: bold;text-align: center;">Description</td>
				<td class="hkmain" colspan="3" style="font-weight: bold;text-align: center;">Standard Type</td>
			</tr>
			<tr>
				
				<td colspan="5">${h.description }</td>
				<td colspan="3">${h.type }</td>
			</tr>
			<%-- 
			 --%>
			<tr>
				<td class="hkhead" style="text-align: center;"><div style="width: 100px;">Auditor</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 100px;">Area</div></td>
				<td  class="hkhead" style="text-align: center;">Description Of Finding</td>
				<td  class="hkhead" style="text-align: center;">Corrective Action</td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 100px;">By Whom</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 80px;">Date</div></td>
				<td  class="hkhead" style="text-align: center;"><div style="width: 40px;">Days</div></td>
				<td  class="hkhead" style="text-align: center;"></td>
			</tr>
			<c:forEach items="${h.actions}" var="ac">
				<tr>
					<td style="text-align: center;">${ac.auditorName }</td>
					<td style="text-align: center;">${ac.areaName }</td>
					<td >${ac.descOfFinding }</td>
					<td>${ac.correctiveAction }</td>
					<td style="text-align: center;">${ac.byWhom}</td>
					<td style="text-align: center;"><fmt:formatDate value="${ac.date }" pattern="MM-dd-yyyy"/> </td>
					<td style="text-align: center;">${ac.days }</td>
					<td style="text-align: center;"><a href="javascript:void(0)" id="close_${ac.id}" data-id="${ac.id}">Close</a> </td>
				
				</tr>
			</c:forEach>
				<tr>
					<td colspan="8">&nbsp;<div style="height: 30px;"></div> </td>
				</tr>
				
			
			</c:if>
			
			
			
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
<spring:url value="/safetyhousekeepingreport/openreports/filter" var="filterLoadURL"/>

<spring:url value="/safetyhousekeepingreport/openreport/email" var="emailURL"/>

<script type="text/javascript">
	$(function(){
		
		
		$('#sendMailBtn').click(function(){
			
			var btn=$(this);
			if(confirm('Do you want to send Safety Housekeeping - Open Actions Report? ')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'GET',
					success : function(data){
						if(data){
							$('#tmessage').text('Mail sent successfully.');
						}else{
							$('#tmessage').text('Failure to send email. Please contact to administrator.');
						}
						btn=btn.prop('disabled',false);
						setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}
				});
			}
			
		});
		
		
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
		
		$('#viewBtn').click(function(){
			location.href='${filterLoadURL}?area='+encodeURIComponent($('select[name=area]').val())+
					'&auditor='+encodeURIComponent($('select[name=auditor]').val())+
					'&bywhom='+encodeURIComponent($('select[name=bywhom]').val());
		});
	});
	
</script>

</body>
</html>
