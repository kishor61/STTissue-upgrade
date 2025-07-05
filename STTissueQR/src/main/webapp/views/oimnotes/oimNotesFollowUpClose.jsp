<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=closed]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
	
		
		$('#saveBtn').click(function(){
			
			var closedBy=$('input[name=closedBy]').val();
			if($.trim(closedBy)==''){
				alert('Please enter user name!');
				return false;
			}
			
			
			return true;
		});
		
	});
</script>

</head>
<body>
<div class="page-title">
	<span class="label">Follow Up - Close</span>
</div>

<c:if test="${not empty error}">
<span class="error">${error }</span>
</c:if>
<c:if test="${not empty message}">
	<span id="message" class="message">${message}</span>
	<input type="hidden" value="${message}" name="successmsg" id="successmsg">
	<input type="hidden" value="${message}" name="successmsg1" id="successmsg1">
<!-- <script>
$('document').ready(function() {
	var msg=document.getElementById("successmsg");
	if(msg==""){
		
	}else{
		alert("Done..");
		//var msg1=document.getElementById("successmsg1");
		var msg1 = $('#successmsg1').val();
		alert("MSG::"+msg1);
		if(msg1=='Follow up closed.'){
			/* $("#dialogPage").remove();
			
			alert("Closeing Done...");
			window.open('', '_self', ''); //bug fix
			window.close(); */
			
			//window.location.href = 'http://localhost:8080/STTISSUE/oimnotesreport/load/openfollowups';
			var iframes= parent.document.getElementsByTagName("dialogPage");
			alert(iframes[0].getAttribute("id")) 
			
			$('#'+iframes[0].getAttribute('id').dialog('close'));
			$('#'+iframes[0].getAttribute('id').dialog('hide'));
			$('#'+iframes[0].getAttribute('id').dialog('destroy'));
				
		}else{
			return false;
		}
	}
	
	//Follow up closed.
});
</script> -->
<script>
	    $(document).ready(function () {
	    	  	parent.location.reload(); 
	    });
</script>
</c:if>
<br>

<spring:url value="/oimnotes/followup/close" var="closeURL"/>

<form:form action="${closeURL}" modelAttribute="followUp" method="post">
<table>
	<tr>
		<td>Date:</td>
		<td><input type="text" readonly="readonly" name="closed" value='<fmt:formatDate value="${followUp.closed}" pattern="MM-dd-yyyy"/>'> </td>
	</tr>
	<tr>
		<td>Your Name:</td>
		<td><input type="text" name="closedBy" value="${followUp.closedBy}" maxlength="50"> </td>
	</tr>
	<tr>
		<td valign="top">Notes:</td>
		<td><textarea name="notes" style="width: 200px;height: 80px;"></textarea> </td>
	</tr>
	<tr>
		<td></td>
		<td>
			<button id="saveBtn" type="submit">Save</button>
			<input type="hidden" name="id" value="${followUp.id}">
		</td>
	</tr>
</table>
	
</form:form>	


</body>
</html>
