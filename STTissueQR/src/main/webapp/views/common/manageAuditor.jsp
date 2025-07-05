<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

$(function(){
		$('#yielddatatable tbody input, #yielddatatable tbody input').focusin(doFocusIn);
		$('#yielddatatable tbody input, #yielddatatable tbody input').focusout(doFocusOut);	
		
		$('#yielddatatable tbody select, #yielddatatable tbody select').focusin(doFocusIn);
		$('#yielddatatable tbody select, #yielddatatable tbody select').focusout(doFocusOut);	
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){				
			if( (tb.attr('name')=='email') | 
				(tb.attr('name')=='status') 
				){

			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				saveLock=true;
				return true;
			}
		}
		saveLock=false;
		return false;
	}
	function doFocusIn()
	{
		currentVal=$(this).val();
	}
	function doFocusOut()
	{
		if(validatePQ($(this)))
		{
			return;
		}
		
		if($(this).val()==currentVal)
		{
			return;
		}
		
		saveData($(this));
	}
</script>
<spring:url value="/auditor/edit/status" var="statusURL" />
<script type="text/javascript">
function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]'); 
	var email=tr.find('input[name=email]').val();
	var status=tr.find('select[name=status]').val();
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${statusURL}',
		type:'POST',
		data:{
			id : id,
			email : email,
			status : status
			
		},
		success:function(data){
			idEle.val(data.id);
			$('#tmessage').text(data.message);
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
	
}
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Manage Auditor</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/auditor/save" var="saveURL"/>
					<form action="${saveURL}" method="post">
						<table>
							<tr>
								<td>Name</td>
								<td>
									<input type="text" name="name" value="${auditor.name}">
								</td>
								<td>Email</td>
								<td>
									<input type="text" name="email" value="${auditor.email}">
								</td>
								<td>
									<button type="submit">Save</button>
									<input type="hidden" name="id" value="${auditor.id}">
									<spring:url value="/auditor/manage" var="newURL" />
									
									<c:if test="${auditor.id gt 0}">
										<button type="button" onclick="location.href='${newURL}'">New</button>
									</c:if>
								</td>
							</tr>
						</table>
					</form>
				</div>


<br>

<c:if test="${not empty error }">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message }">
	<span class="message">${message}</span>
</c:if>

<table id="yielddatatable" class="table" style="width: 500px; margin: auto;">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Auditor Name</th>
			<th>Email</th>
			<th>Action</th>
			<th>Status</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${auditors}" var="user" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${user.name}</td>
				<td>
					${user.email}
					<input type="hidden" name="email" id="email" value="${user.email}">
				</td>
				<td>
					<a href='<spring:url value="/auditor/edit/${user.id}"></spring:url>'>Edit</a>
				</td>
				<td>
					<select name="status" id="status" >
						<option value="">Select</option>
						<c:forEach items="${status}" var="destinations">
								<c:choose>
									<c:when test="${destinations.key eq user.status}">
										<c:if test="${user.status eq 'Active' }">
											<option value="${destinations.key}" selected="selected">${destinations.value}</option>
										</c:if>
										<c:if test="${user.status eq 'In-Active' }">
											<option value="${destinations.key}" selected="selected">${destinations.value}</option>
										</c:if>
									</c:when>
									<c:otherwise>
										<option value="${destinations.key}">${destinations.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

			</div>

		</div>


	</div>

</body>
</html>
