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
		
		$('textarea').keypress(function(e) {
		    var tval = $('textarea').val(),
		        tlength = tval.length,
		        set = 200,
		        remain = parseInt(set - tlength);
		  // $('#charCount').text('Char. Remain ('+remain+')');
		    if (remain <= 0 && e.which !== 0 && e.charCode !== 0) {
		        $('textarea').val((tval).substring(0, tlength - 1))
		    }
		});
		
		$('#saveBtn').click(function(){
			
		/* 	var description=$('textarea[name=description]').val();
			if($.trim(description)==''){
				alert('Please enter description!');
				return false;
			}
			*/
			var stype=$('select[name=stype]').val();
			if(stype==''){
				alert('Select standard type!');
				return false;
			} 
			
			var area=$('select[name=area]').val();
			if(area==''){
				alert('Select area!');
				return false;
			}
			
			var auditor=$('select[name=auditor]').val();
			if(auditor==''){
				alert('Select auditor!');
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
		<span class="label">Safety Housekeeping - Edit Assignment</span>
	</div>
<br>

<c:if test="${not empty error}">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

<spring:url value="/safetyhousekeeping/save/task" var="saveURL"/>
<form:form id="safetyForm" action="${saveURL}" method="post" modelAttribute="housekeepingTask">


<table>
	<tr>
		<td valign="top">Standard Type:</td>
		<td>
			<select name="stype" style="padding: 2px; width: 200px;" >
				<option value="">Select</option>
				<c:forEach items="${types}" var="st">
					<c:choose>
						<c:when test="${st.id eq housekeeping.stype}">
							<option value="${st.id}" selected="selected">${st.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${st.id}">${st.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Area:</td>
		<td>
			<select name="area" style="padding: 2px; width: 200px;">
				<option value="">Select</option>
				<c:forEach items="${areas}" var="area">
					<c:choose>
						<c:when test="${area.name eq housekeepingTask.area}">
							<option value="${area.name}" selected="selected">${area.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${area.name}">${area.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Auditor:</td>
		<td>
			<select name="auditor" style="padding: 2px; width: 200px;">
				<option value="">Select</option>
				<c:forEach items="${autiors}" var="auditor">
					<c:choose>
						<c:when test="${auditor.name eq housekeepingTask.auditor}">
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
	<tr>
		<td>Date:</td>
		<td>
		<input type="text" name="date" readonly="readonly" value='<fmt:formatDate value="${housekeepingTask.date}" pattern="MM-dd-yyyy" />'>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<button type="submit" id="saveBtn">Save</button>
			<input type="hidden" name="id" value="${housekeepingTask.id}">
		 </td>
	</tr>
</table>
</form:form>

</div>

</body>
</html>
