<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=date]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
	
		
		$('#saveBtn').click(function(){
			 var descOfFinding=$('textarea[name=descOfFinding]').val();
			 if($.trim(descOfFinding)==''){
				 alert('Please enter description of finding!');
				 return false;
			 }
			 
			 var correctiveAction=$('textarea[name=correctiveAction]').val();
			 if($.trim(correctiveAction)==''){
				 alert('Please enter corrective action!');
				 return false;
			 }
			
			 var byWhom=$('select[name=byWhom]').val();
			if(byWhom==''){
				alert('Select by whom!');
				return false;
			}
			
			return true;
		});
		
	});
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='employee'|tb.attr('name')=='date'
				|tb.attr('name')=='area'|tb.attr('name')=='description'
				|tb.attr('name')=='remarks'){
				
				return false;
			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				return true;
			}
		}
		return false;
	}
</script>
</head>
<body style="overflow: auto;">

<div class="container">
	<div class="page-title">
		<span class="label">Safety Housekeeping - Edit Action</span>
	</div>
<br>

<c:if test="${not empty error}">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

<spring:url value="/safetyhousekeeping/save/action" var="saveURL"/>
<form:form id="safetyForm" action="${saveURL}" method="post" enctype="multipart/form-data" modelAttribute="housekeepingAction">


<table>
	<tr>
		<td valign="top">Description Of Finding:</td>
		<td><textarea name="descOfFinding" style="width: 300px; height: 50px;">${housekeepingAction.descOfFinding}</textarea> </td>
	</tr>
	<tr>
		<td valign="top">Corrective Action:</td>
		<td><textarea name="correctiveAction" style="width: 300px; height: 50px;">${housekeepingAction.correctiveAction}</textarea> </td>
	</tr>
	<tr>
		<td>By Whom:</td>
		<td>
		<select name="byWhom" style="padding: 2px; width: 200px;">
				<option value="">Select</option>
				<c:forEach items="${autiors}" var="auditor">
					<c:choose>
						<c:when test="${auditor.name eq housekeepingAction.byWhom}">
							<option value="${auditor.name}" selected="selected">${auditor.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${auditor.name}">${auditor.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
	<%-- <tr>
		<td>Date:</td>
		<td><input type="text" name="date" readonly="readonly" value='<fmt:formatDate value="${housekeepingAction.date}" pattern="MM-dd-yyyy"/>'></td>
	</tr> --%>
	<tr>
		<td>File/Doc/Images</td>
		<td><input type="file" name="file">&nbsp;&nbsp;&nbsp;
			<c:if test="${not empty housekeepingAction.document}">
				<a href="<spring:url value="/assets/HousekeepingActionDocuments/${housekeepingAction.document}"/>" target="_blank">Open File</a>
			</c:if>	
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<button type="submit" id="saveBtn">Save</button>
			<input type="hidden" name="id" value="${housekeepingAction.id}">
			<input type="hidden" name="sid" value="${housekeepingAction.sid}">	
			<input type="hidden" name="tid" value="${housekeepingAction.tid}">
		</td>
	</tr>
</table>
</form:form>

</div>

</body>
</html>
