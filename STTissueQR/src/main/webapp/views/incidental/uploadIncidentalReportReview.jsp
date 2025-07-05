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
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 

<spring:url value="/incidentaluser/check/reviedotnot" var="checkreviedotnot" />
<script>
	function myJobType() {
		var urlAccess='';
		var name = document.getElementById("name").value;
		var id = document.getElementById("id").value;
		
		var objectData = {};
   		var objectDataString = JSON.stringify(objectData);
   		$('#light').show(); 
   		$.ajax({
   			type : "POST",
   			cache: false,
   			url:'${checkreviedotnot}',
   			dataType : "html",
   			data : {
   				id : id ,
   				name : name
   			},
   			success : function(data) {
   				if(data){
   					var obj = jQuery.parseJSON(data);
   				   // $('#reviewdornot').html(obj.reviewdornot);
   				}
   				if(obj.reviewdornot>0){
   					//$('#reviewdornot').html(obj.reviewdornot);
   					$('#reviewdornot').text("You have already reviewed this document.");
   					$('#subbutton').prop('disabled', true);

   				} else{
   					$('#subbutton').prop('disabled', false);
   					$('#reviewdornot').text("");
   				} 
   			},
   			 error: function (xhr, status) {
   				alert('Some Error Accoured ! Please Contact To Roshan.');
   				return false;
   			}
   		});
   	

	}
</script>
</head>
<body>
<div class="page-title">
	<span class="label">Incidental Document- Review Action</span>
</div>

<c:if test="${not empty error}">
<span class="error">${error }</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message }</span>
	<!-- <script>
	$(function(){
		var myvar = ${flag};
		alert("calling");
		if (myvar == 1)
		{
			alert("calling");
			$(".ui-dialog").hide();
		}
		
		
	});
	</script> -->
	<script>
	    $(document).ready(function () {
	    	  	parent.location.reload(); 
	    });
	</script>
	
</c:if>
<br>

<spring:url value="/incidentaluser/review/action/save" var="saveURL"/>
<form:form action="${saveURL}" modelAttribute="housekeepingAction" method="post">
		<table>
			<tr>
				<td>Date:</td>
				<td>
					<input readonly="readonly" type="text" name="date" value="${sdate}"> 
					<input readonly="readonly" type="hidden"name="id" id="id" value="${id}">
				</td>
			</tr>
			<tr>
				<td>Your Name:</td>
				<td><select name="name" style="width: 150px; padding: 3px;" id="name" onchange="myJobType()" required="required">
						<option value="">Select</option>
						<c:forEach items="${auditors}" var="data">
							<option value="${data.name}">${data.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><textarea name="comment"
						style="margin: 0px; width: 280px; height: 104px;"
						required="required"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<!-- <button id="saveBtn" type="submit">Reviewed</button> -->
					<button type="submit" id="subbutton">Reviewed</button></br>
					<p id="reviewdornot" style="color:  green;font-size: 18px;"></p>
				</td>

			</tr>
		</table>

	</form:form>	


</body>
</html>
