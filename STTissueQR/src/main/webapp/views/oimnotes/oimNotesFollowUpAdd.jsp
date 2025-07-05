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
</style>

<script type="text/javascript">
$(function(){
	$('input[name=entryDate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
	$('input[name=timeline]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
</head>
<body>

<div class="page-title">
	<span class="label" style="font-size: 12px;">Create New Follow Up</span>
</div>
<br>
<spring:url value="/oimnotes/followup/save" var="saveURL" />
<form action="${saveURL}" method="post" enctype="multipart/form-data">
<table>
	<tr>
		
		<td>
			Date
		</td>
		<td>
			<input type="text" name="entryDate" value='<fmt:formatDate value="${folloupObj.entryDate}"  pattern="MM-dd-yyyy"/>' readonly="readonly" style="width: 100px;">
		</td>
		<td>
			Responsibility
		</td>
		<td>
			<input type="text" name="responsibility" value='${folloupObj.responsibility}' style="width: 100px;">
		</td>
	</tr>
	<tr>	
		<td>
			Timeline
		</td>
		<td>
			<input type="text" name="timeline" value='<fmt:formatDate value="${folloupObj.timeline}"  pattern="MM-dd-yyyy"/>' readonly="readonly" style="width: 100px;">
		</td>
		<td colspan="2"><input type="radio" name="checkFlag" value="1" checked="checked"></td>
		<%-- <c:if test="${empty folloupObj.timeline}">
			<td colspan="2"><input type="radio" name="checkFlag" value="1"></td>
		</c:if>
		<c:if test="${not empty folloupObj.timeline}">
			<td colspan="2"><input type="radio" name="checkFlag" value="1" checked="checked"></td>
		</c:if> --%>
	</tr>
	<tr>
		<td>Recurrence</td>
		<td><%-- <input type="text" name="recurrence" value="${folloupObj.recurrence}" readonly="readonly" style="width: 100px;"> --%>
			<select name="recurrence" style="width: 104px; padding: 2px;" disabled="disabled">
				<option value="">Select</option>
				<c:forEach items="${recurrences}" var="r">
					<c:choose>
					<c:when test="${r.key eq folloupObj.recurrence}">
						<option value="${r.key}" selected="selected">${r.value}</option>
					</c:when>
					<c:otherwise>
						<option value="${r.key}">${r.value}</option>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</select>
		</td>
		
		<td colspan="2"><input type="radio" name="checkFlag" value="2"></td>
		<%-- <c:if test="${empty folloupObj.recurrence}">
			<td colspan="2"><input type="radio" name="checkFlag" value="2"></td>
		</c:if>
		<c:if test="${not empty folloupObj.recurrence}">
			<td colspan="2"><input type="radio" name="checkFlag" value="2" checked="checked"></td>
		</c:if> --%>
		
	</tr>
	<tr>
		<td valign="top">Follow Up</td>
		<td colspan="3">
		<textarea name="followUp" style="width: 279px; height: 60px; resize: none;">${folloupObj.followUp}</textarea>
		<br>
		<span id="charCount">Max Char. (200)</span>
		</td>
	</tr>
	<tr>
		<td valign="top">Tag </td>
		<td colspan="3">
			<select name="tagColor" style="width: 100px; padding: 3px;">
				<option style="background-color: white: ;">All</option>
				<c:forEach items="${colors}" var="colorCode">
					<c:choose>
						<c:when test="${colorCode eq color}">
							<option style="background-color: ${colorCode};" value="${colorCode}" selected="selected">${colorCode}</option>
						</c:when>
						<c:otherwise>
							<option style="background-color: ${colorCode};" value="${colorCode}">${colorCode}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td valign="top">Change History</td>
		<td colspan="3">
		<textarea name="noteHistory" style="width: 279px; height: 40px; resize: none;">${folloupObj.noteHistory}</textarea>
		
		</td>
	</tr>
	<tr>
		<td valign="top">File/Document</td>
		<td colspan="3">
		<input type="file" name="file">
		
		</td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit" id="saveBtn">Save</button> 
			<input type="hidden" name="id" value="${folloupObj.id}">
			<input type="hidden" name="summaryId" value="${folloupObj.summaryId}">
		</td>
	</tr>
</table>
</form>
<c:if test="${not empty error }">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message }">
	<span class="message">${message}</span>
</c:if>


<fmt:formatDate value="${folloupObj.timeline}"  pattern="MM-dd-yyyy" var="timelineDate"/>
<script type="text/javascript">
	$(function(){
		$('#saveBtn').click(function(){
			
			
			var date=$('input[name=entryDate]').val();
			if(!date){
				alert('Select date!');
				return false;
			}
			
			var responsibility=$('input[name=responsibility]').val();
			if(!responsibility){
				alert('Enter  responsibility!');
				return false;
			}
			/* var timeline=$('input[name=timeline]').val();
			if(!timeline){
				alert('Select  timeline!');
				return false;
			}
			 */
			
			var followUp=$('textarea[name=followUp]').val();
			if(followUp.length==0){
				alert('Please enter follow up!');
				return false;
			}
			
			return true;
		});
		$('textarea').keypress(function(e) {
		    var tval = $('textarea').val(),
		        tlength = tval.length,
		        set = 200,
		        remain = parseInt(set - tlength);
		    $('#charCount').text('Char. Remain ('+remain+')');
		    if (remain <= 0 && e.which !== 0 && e.charCode !== 0) {
		        $('textarea').val((tval).substring(0, tlength - 1))
		    }
		});
		
		
		
		$('input[name=checkFlag]').click(function(){
			if($(this).val()==1){
				$('input[name=timeline]').val('${timelineDate}');
				$('input[name=timeline]').prop('disabled', false);
				$('select[name=recurrence]').val('');
				$('select[name=recurrence]').prop('disabled', true);
			}else if($(this).val()==2){
				
				$('input[name=timeline]').val('');
				$('input[name=timeline]').prop('disabled', true);
				$('select[name=recurrence]').val('${folloupObj.recurrence}');
				$('select[name=recurrence]').prop('disabled', false);
			}
		});
		
	});
</script>

</body>
</html>
