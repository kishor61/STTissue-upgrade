<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('#saveBtn').click(function(){
			var name=$.trim($('input[name=name]').val());
			if(name==''){
				alert('Please enter customer name.');
				return false;
			}
			
			return true;
		});
	});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Add Area</span>
				</div>
	<br>
	<span class="error">${error}</span>
	<span class="message">${message}</span>
	
<form action='<spring:url value="/manintenanceMonitoringArea/savearea"/>' method="post">
				<table style="padding: 5px;">
					<tr>
						<td>Area Name</td>
						
						<td><input type="text" name="name" style="width: 161px;"></td>
					</tr>
					
					<tr>
						<td>Description</td>
						
						<td><textarea name="description"></textarea></td>
					</tr>
					 
					<tr>
						
						<td colspan="2" align="center"> 
							<input type="submit" value="Submit" id="saveBtn">
						</td>
					</tr>
				</table>
</form>
			</div>

		</div>


	</div>

</body>
</html>
