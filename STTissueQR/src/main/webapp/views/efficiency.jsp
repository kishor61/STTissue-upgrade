<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/jquery.ui.timepicker.css"/>'>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.ui.timepicker.js"/>'></script>
<spring:url value="/efficiency/timediff" var="timediffURL"/>
<script type="text/javascript">
$(function(){
	$('input[name=fdate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});

	
	$('input[name=fendTimeHH]').focusin(function(){
		if($('input[name=fendTimeHH]').val()=='0'){
			$('input[name=fendTimeHH]').val('');
		}
	});
	
	$('input[name=fendTimeMM]').focusin(function(){
		if($('input[name=fendTimeMM]').val()=='0'){
			$('input[name=fendTimeMM]').val('');
		}
	});
	
	
	$('input[name=fendTimeHH],input[name=fendTimeMM]').focusout(function(){
		if($('input[name=fendTimeHH]').val()==''){
			$('input[name=fendTimeHH]').val(0);
		}
		if($('input[name=fendTimeMM]').val()==''){
			$('input[name=fendTimeMM]').val(0);
		}
		var sdHH=$('select[name=fstartTimeHH]').val();
		var sdMM=$('select[name=fstartTimeMM]').val();
		
		var edHH=$('input[name=fendTimeHH]').val();
		var edMM=$('input[name=fendTimeMM]').val();
		var sd=sdHH+":"+sdMM;
		if(sd!=''){
			$.ajax({
				url:'${timediffURL}',
				type:'POST',
				data:{
					sd:sd,
					edHH:edHH,
					edMM:edMM
				},
				success:function(data){
					$('#timeDiff').html('End Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  '+data);
				}
				
			});
		}
	});
	$('select[name=fstartTimeHH],select[name=fstartTimeMM]').change(function(){
		if($('input[name=fendTimeHH]').val()==''){
			$('input[name=fendTimeHH]').val(0);
		}
		if($('input[name=fendTimeMM]').val()==''){
			$('input[name=fendTimeMM]').val(0);
		}
		var sdHH=$('select[name=fstartTimeHH]').val();
		var sdMM=$('select[name=fstartTimeMM]').val();
		
		var edHH=$('input[name=fendTimeHH]').val();
		var edMM=$('input[name=fendTimeMM]').val();
		var sd=sdHH+":"+sdMM;
		if(sd!=''){
			$.ajax({
				url:'${timediffURL}',
				type:'POST',
				data:{
					sd:sd,
					edHH:edHH,
					edMM:edMM
				},
				success:function(data){
					$('#timeDiff').html('End Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  '+data);
				}
				
			});
		}
	});
});

</script>
<style type="text/css">
.table-selector td {
	vertical-align: top;
}
</style>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Efficiency- Data Entry</span>
				</div>
				<br>


				<div style="padding: 2px;">
					<spring:url value="/efficiency/save" var="saveURL" />
					<form:form action="${saveURL}" modelAttribute="efficiency" method="post">
						<table>
						
							<tr>
								<td style="width: 100px;">Date</td>
								<td style="width: 200px;"><form:input path="fdate" readonly="true"/></td>
								<td style="width: 100px;">Shift</td>
								<td>
									<c:set var="shifts" value="${fn:split('Day,Night',',')}" scope="request"/>
								
									<form:select path="shift" cssStyle="width: 150px;">
										<form:option value="">Select</form:option>
										<c:forEach items="${shifts}" var="s">
											<form:option value="${s}">${s}</form:option>
										</c:forEach>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Start Time</td>
								<td>
									<form:select path="fstartTimeHH" cssStyle="width:50px;">
										<option value="0">HH</option>
										<c:forEach begin="1" end="24" var="h">
											<c:choose>
												<c:when test="${h eq efficiency.fstartTimeHH}">
													<option value="${h}" selected="selected">${h}</option>
												</c:when>
												<c:otherwise>
													<option value="${h}">${h}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select>
									<form:select path="fstartTimeMM" cssStyle="width:50px;">
										<option value="0">MM</option>
										<c:forEach begin="1" end="59" var="m">
											
											<c:choose>
												<c:when test="${m eq efficiency.fstartTimeMM}">
													<option value="${m}" selected="selected">${m}</option>
												</c:when>
												<c:otherwise>
													<option value="${m}">${m}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select>
								 </td>
								<td>Crew</td>
								<td>
									<c:set var="crews" value="${fn:split('A,B,C,D',',')}" scope="request" />
									<form:select path="crew" cssStyle="width: 150px;">
										<form:option value="">Select</form:option>
										<c:forEach items="${crews}" var="c">
											<form:option value="${c}">${c}</form:option>
										</c:forEach>
									</form:select>
								
								</td>
							</tr>
							<tr>
								<td>Duration</td>
								<td>
									<form:input path="fendTimeHH" cssStyle="width:30px;"/> HH&nbsp;
									<form:input path="fendTimeMM" cssStyle="width:30px;"/> MM
								</td>
								<td colspan="2">
									<b><span id="timeDiff"><fmt:formatDate value="${efficiency.endTime}" pattern="HH:mm" var="eHM"/>End Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${eHM }</span></b>
								</td>
								
							</tr>
							<tr>
								<td>Reel#</td>
								<td><form:input path="reel"/></td>
								<td>Grade code</td>
								<td>
									<form:select path="gradeCode" cssStyle="width: 150px;">
										<form:option value="">Select</form:option>
										<c:forEach items="${grades}" var="grade">
											<form:option value="${grade.gradeCode}">${grade.gradeCode}</form:option>
										</c:forEach>
									
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Down Time<br> Secondary Code</td>
								<td>
								
									<form:select id="secondaryCode" path="secondaryCode.id" cssStyle="width: 150px;">
										<option value="">Select</option>
										<c:forEach items="${codes}" var="scode">
											<c:choose>
												<c:when test="${scode.id eq efficiency.secondaryCode.id}">
													<option value="${scode.id}" title="${scode.primaryCode.code}" selected="selected">${scode.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${scode.id}" title="${scode.primaryCode.code}">${scode.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select>
								</td>
								<td>Down Time<br> Primary Code</td>
								<td><span id="primaryCode">${efficiency.secondaryCode.primaryCode.code}</span> </td>
							</tr>
							<tr>
								<td valign="top">Comments</td>
								<td colspan="3"><form:textarea path="comment" cssStyle="width: 456px; height: 72px;"/> </td>
								
							</tr>
							<tr>
								<td colspan="4">
									<form:hidden path="id"/>
									<form:hidden path="queryString"/>
									<input type="submit" value="Submit" id="saveBtn">
									&nbsp;&nbsp;
									<span class="error">${error}</span>
								<span class="message">${message}</span>
								</td>
							</tr>
						</table>
					</form:form>
				</div>
<script type="text/javascript">
$(function(){
	
	$('#secondaryCode').change(function(){
		 var element = $(this).find('option:selected'); 
		 $('#primaryCode').text(element.attr('title'));
	});
	
	$('#saveBtn').click(function(){
		if($('input[name=fdate]').val()==''){
			alert('Select date');
			$('input[name=fdate]').focus();
			return false;
		}
		if($('select[name=shift]').val()==''){
			alert('Select shift');
			$('select[name=shift]').focus();
			return false;
		}
		
	
		if($('select[name=crew]').val()==''){
			alert('Select crew');
			$('select[name=crew]').focus();
			return false;
		}
		
		

		if($('input[name=fendTimeHH]').val()==''){
			alert('Enter end time HH(hours)');
			$('input[name=fendTimeHH]').focus();
			return false;
		}
		if(isNaN($('input[name=fendTimeHH]').val())){
			alert('Enter valid end time HH(hours)');
			$('input[name=fendTimeHH]').focus();
			return false;
		}
		
		if($('input[name=fendTimeMM]').val()==''){
			alert('Enter end time MM (minutes)');
			$('input[name=fendTimeMM]').focus();
			return false;
		}
		if(isNaN($('input[name=fendTimeMM]').val())){
			alert('Enter valid end time MM (minutes)');
			$('input[name=fendTimeMM]').focus();
			return false;
		}
		
		if($('input[name=reel]').val()==''){
			alert('Enter reel#');
			$('input[name=reel]').focus();
			return false;
		}
		
		if($('select[name=gradeCode]').val()==''){
			alert('Select grade code');
			$('select[name=gradeCode]').focus();
			return false;
		}
		
		if($('#secondaryCode').val()==''){
			alert('Downtime Secondary code');
			$('#secondaryCode').focus();
			return false;
		}
		
		return true;
	});
});
</script>



			</div>

		</div>


	</div>

</body>
</html>
