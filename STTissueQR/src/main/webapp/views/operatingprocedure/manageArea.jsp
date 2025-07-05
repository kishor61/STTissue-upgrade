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
</head>
<body style="overflow: auto;">
<table class="table">
	<c:forEach items="${areas}" var="type" varStatus="i">
		<tr>
			<td style="width: 15px;">${i.count}</td>
			<td>${type}</td>
			<td style="width: 200px;"><input type="text" style="width: 100px;display: none;"><button style="display: none;" name="saveBtn" value="${type}">SAVE</button> <button name="editBtn">EDIT</button> </td>
		</tr>
	</c:forEach>
</table>

<spring:url value="/operatingprocedure/updateAreaNameEdit" var="updateArea"/>

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
			alert('Please enter new Area!');
			$(this).prev().focus();
			return;
		}
		
		$(this).val('Saving....');
		$(this).prop('disabled',true);
		
		$.ajax({
			url:'${updateArea}',
			type:'POST',
			data:{
				newcat: newVal,
				oldcat: oldVal
			},
			success:function(data){
				if(data){
					location.reload(true);
				}else{
					alert('Unable to rename Area. Please try later.')
				}
			}
		});
		
	});
	
});

</script>
</body>
</html>
