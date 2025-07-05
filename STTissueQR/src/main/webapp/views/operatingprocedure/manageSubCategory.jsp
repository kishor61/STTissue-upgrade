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

	<c:forEach items="${types}" var="typeOb">
		<c:set value="${1}" var="count"/>
		<tr>
			<td colspan="3">${typeOb.name}</td>
		</tr>
		<c:forEach items="${typeOb.subType}" var="subType">
			<tr>
				<td style="width: 15px;">${count}</td>
				<td>${subType}</td>
				<td style="width: 200px;"><input type="text" style="width: 100px;display: none;"><button style="display: none;" name="saveBtn" data-type="${typeOb.name}" data-subtype="${subType}">SAVE</button> <button name="editBtn">EDIT</button> </td>
			</tr>
			<c:set value="${count+1}" var="count"/>
		</c:forEach>
	</c:forEach>
</table>

<spring:url value="/operatingprocedure/updatesubcategory" var="updateSubCategory"/>

<script type="text/javascript">
$(function(){
	$('button[name=editBtn]').click(function(){
		$(this).prev().show();
		$(this).prev().prev().show();
		$(this).hide();
	});
	$('button[name=saveBtn]').click(function(){
		var newVal=$(this).prev().val();
		var oldVal=$(this).attr('data-subtype');
		var type=$(this).attr('data-type');
		
		
		if($.trim(newVal)==''){
			alert('Please enter new category!');
			$(this).prev().focus();
			return;
		}
		
		$(this).val('Saving....');
		$(this).prop('disabled',true);
		
		$.ajax({
			url:'${updateSubCategory}',
			type:'POST',
			data:{
				newcat: newVal,
				oldcat: oldVal,
				type: type
			},
			success:function(data){
				if(data){
					location.reload(true);
				}else{
					alert('Unable to rename sub Category. Please try later.')
				}
			}
		});
		
	});
	
});

</script>
</body>
</html>
