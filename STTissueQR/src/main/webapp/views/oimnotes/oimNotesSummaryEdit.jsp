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
});
</script>
</head>
<body>

<div class="page-title">
	<span class="label" style="font-size: 12px;">Edit Summary</span>
</div>
<br>
<spring:url value="/oimnotes/summary/save" var="saveURL"/>
<form action="${saveURL}" method="post">
<table>
	<tr>
		<td>Category:</td>
		<td>
			<select name="categoryId" style="width: 150px;">
				<option value="">Select</option>
				<c:forEach items="${categories}" var="ctg">
					<c:choose>
						<c:when test="${ctg.id eq summaryObj.categoryId}">
							<option value="${ctg.id}" selected="selected">${ctg.category}</option>
						</c:when>
						<c:otherwise>
							<option value="${ctg.id}">${ctg.category}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		<td>
			Date
		</td>
		<td>
			<input type="text" name="entryDate" value='<fmt:formatDate value="${summaryObj.entryDate}"  pattern="MM-dd-yyyy"/>' readonly="readonly" style="width: 100px;">
		</td>
		
	</tr>
	<tr>
		<td valign="top">Summary</td>
		<td colspan="3">
		<textarea name="summary" style="width: 279px; height: 60px; resize: none;">${summaryObj.summary}</textarea>
		<br>
		<span id="charCount">Max Char. (200)</span>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit" id="saveBtn">Save</button> 
			<input type="hidden" name="id" value="${summaryObj.id}">
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

<script type="text/javascript">
	$(function(){
		$('#saveBtn').click(function(){
			var ctg=$('select[name=categoryId]').val();
			if(!ctg){
				alert('Select category!');
				return false;
			}
			
			var date=$('input[name=entryDate]').val();
			if(!date){
				alert('Select date!');
				return false;
			}
			
			var summary=$('textarea[name=summary]').val();
			if(summary.length==0){
				alert('Please enter summary!');
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
	});
</script>

</body>
</html>
