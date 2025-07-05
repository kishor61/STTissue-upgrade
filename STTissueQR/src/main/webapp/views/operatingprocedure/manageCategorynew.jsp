<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<style>
.select-style {
    border: 1px solid #ccc;
    width: 120px;
    border-radius: 3px;
    overflow: hidden;
    background: #fafafa url("data:image/png;base64,R0lGODlhDwAUAIABAAAAAP///yH5BAEAAAEALAAAAAAPABQAAAIXjI+py+0Po5wH2HsXzmw//lHiSJZmUAAAOw==") no-repeat 90% 50%;
}

.select-style select {
    padding: 5px 8px;
    width: 130%;
    border: none;
    box-shadow: none;
    background: transparent;
    background-image: none;
    -webkit-appearance: none;
}

.select-style select:focus {
    outline: none;
}
.table th, .table td {
    border: 0px solid gray;
}
.select-style select {
    width: 100% !important;
}
</style>



</head>
<body style="overflow: auto;">
<security:authorize access="hasAnyRole('ADMIN')">
<spring:url value="/operatingprocedure/save" var="saveURL"/>
<form action="${saveURL}" method="post" enctype="multipart/form-data">
<table class="table">
	<%-- <c:forEach items="${types}" var="type" varStatus="i">
		<tr>
			<td style="width: 15px;">${i.count}</td>
			<td>${type}</td>
			<td style="width: 200px;"><input type="text" style="width: 100px;display: none;"><button style="display: none;" name="saveBtn" value="${type}">SAVE</button> <button name="editBtn">EDIT</button> </td>
		</tr>
	</c:forEach> --%>
	<tr>
		<td>Select Area</td>
		<td class="select-style">
			<select name="area" style="width: 150px; padding: 3px;" required="required">
					<option value="-1">Select</option>
					<c:forEach items="${areas}" var="are">
						<option value="${are.area}">${are.area}</option>
					</c:forEach>
			</select>
			
		</td>
		</br>
	</tr>
	
	<tr>
		<td>Main Category</td>
		<td class="select-style">
			<!-- <select name="type" required="required">
				<option value="-1">Select</option>
				<option value="Quality">Quality</option>
				<option value="Management">Management</option>
				<option value="Safty">Safty</option>
				<option value="Environment">Environment</option>
			</select>
			 -->
			<select name="type" style="width: 150px; padding: 3px;" required="required">
					<option value="-1">Select</option>
					<c:forEach items="${maincategory}" var="pcode">
						<option value="${pcode.maincategoname}">${pcode.maincategoname}</option>
					</c:forEach>
			</select>
			
		</td>
		</br>
	</tr>
	<tr>
		
		<td>Sub Category</td>
		<td class="select-style">
			<!-- <select name="subType" required="required">
				<option value="-1">Select</option>
				<option value="Policies">Policies</option>
				<option value="Objective">Objective</option>
				<option value="Commentent">Commentent</option>
			</select> -->
			<select name="subType" style="width: 150px; padding: 3px;" required="required">
					<option value="-1">Select</option>
					<c:forEach items="${subcategory}" var="pcode">
						<option value="${pcode.entersubcatname}">${pcode.entersubcatname}</option>
					</c:forEach>
			</select>
			
		</td>
		
	</tr>
	<tr style="position: absolute;">
		<td>
			<input type="file" name="file">
		</td>
		
		<td>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${not empty error}">
				<span class="error">${error}</span>
				<script>
					    $(document).ready(function () {
					    	  	parent.location.reload(); 
					    });
				</script>
			</c:if>
			<c:if test="${not empty message}">
				<span class="message">${message}</span>
				<script>
					    $(document).ready(function () {
					    	  	parent.location.reload(); 
					    });
				</script>
			</c:if>
		</td>
		
		<td></br><input type="submit" value="SAVE"></td>
	</tr>
	
</table>
</form>
</security:authorize>
<spring:url value="/operatingprocedure/updatecategory" var="updateCategory"/>

<script type="text/javascript">
$(function(){
	$('button[name=editBtn]').click(function(){
		$(this).prev().show();
		$(this).prev().prev().show();
		$(this).hide();
	});
	$('button[name=saveBtn]').click(function(){
		var newVal=$(this).prev().val();
		var oldVal=$(this).val();
		if($.trim(newVal)==''){
			alert('Please enter new category!');
			$(this).prev().focus();
			return;
		}
		
		$(this).val('Saving....');
		$(this).prop('disabled',true);
		
		$.ajax({
			url:'${updateCategory}',
			type:'POST',
			data:{
				newcat: newVal,
				oldcat: oldVal
			},
			success:function(data){
				if(data){
					location.reload(true);
				}else{
					alert('Unable to rename Category. Please try later.')
				}
			}
		});
		
	});
	
});

</script>

</body>
</html>
