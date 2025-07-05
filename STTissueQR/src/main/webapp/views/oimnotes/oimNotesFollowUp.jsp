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
table td{
	font-size: 12px;
}

</style>
</head>
<body>
	<div class="top-container">
		<div class="page-title">
			<span class="label" style="font-size: 12px;">Follow Up</span>
		</div>
	</div>
	<div class="bot-container">
		<c:if test="${summary.id gt 0}">
		<div class="table-selector" style="margin: auto;">
			<table>
				<tr>
					<td>
						<button id="newBtn">New</button>
						<button id="editBtn">Edit</button>
						<button id="deleteBtn">Delete</button>
						<button id="printBtn">Print</button>
					</td>
					<td>&nbsp;&nbsp;&nbsp;Tag:
						<select name="tagColor" style="width: 100px; padding: 3px; background-color: ${color};">
							<option style="background-color: white:;" value=""> All</option>
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
			</table>
			
		</div>
		
		
		<div id="printDiv">	

		<div style="padding: 2px;font-size: 16px;font-family: serif;">
			<p><b>Category :</b> ${summary.category} </p>
			<p style="padding: 2px;font-size: 14px;">
			<b>Summary :</b> 
			${summary.summary}</p>
		</div>
		
		<table class="table">
		<thead>
			<tr>
				<th style="width: 10px;"></th>
				<th>Item</th>
				<th>Follow Up</th>
				<th>Responsibility</th>
				<th>Timeline</th>
				<th>Recurrence</th>
				<th>Entry Date</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="tableBody">
			<c:forEach items="${followUps}" var="follow" varStatus="i">
				<tr>
					<c:choose>
						<c:when test="${not empty follow.tagColor}">
							<td style="background-color:${follow.tagColor};"><input name="id" type="radio" value="${follow.id}"></td>
						</c:when>
						<c:otherwise>
							<td>${follow.tagColor}<input name="id" type="radio" value="${follow.id}"></td>	
						</c:otherwise>
					</c:choose>
					
					<td>${i.index+1}</td>
					<td>${follow.followUp}</td>
					<td>${follow.responsibility }</td>
					<td><div style="width: 80px;text-align: center;"><fmt:formatDate value="${follow.timeline}" pattern="MM-dd-yyyy"/></div> </td>
					<td>${recurrences[follow.recurrence]}</td>
					<td><div style="width: 80px;text-align: center;"><fmt:formatDate value="${follow.entryDate}" pattern="MM-dd-yyyy"/></div> </td>
					<td style="text-align: center;width: 110px;">
						<div style="width: 110px;">
							<a class="abtn" href="javascript:void(0)" id="close_${follow.id}" data-id="${follow.id}">Close</a>
							<a href="<spring:url value="/oimnotes/followup/history/${follow.id}"/>" target="_blank">View Change History</a>
							
							<c:if test="${not empty follow.file}">
								<a href="<spring:url value="/assets/UploadedDocuments/${follow.file}"/>" target="_blank">File</a>
							</c:if>
						</div>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
		</table>
	</div>
	</c:if>
</div>	
<spring:url value="/oimnotes/followup/delete" var="deleteURL"/>
<spring:url value="/oimnotes/followup/view/${sid}" var="viewURL"/>
<spring:url value="/oimnotes/followup/close" var="closeURL"/>


<div id="dialog" title="PROCESS IMPROVEMENT MEETING NOTES" style="display: none;">
	<iframe id="dialogPage" style="width: 98%; height: inherit;border: none;"></iframe>
</div>


<script type="text/javascript">
$(function(){
	
	$('select[name=tagColor]').change(function(){
		if($(this).val()==''){
			location.href='${viewURL}';
		}else{
			location.href='${viewURL}/'+$(this).val();
		}
	});
	
	
	 $( "#tableBody .abtn" ).button({
	      icons: {
	        primary: "ui-icon-circle-close"
	      },
	      text: false
	    }).next().button({
	       	  icons: {
	            primary: "ui-icon-clipboard"
	          },
		      text: false
        }).next().button({
	       	  icons: {
	            primary: "ui-icon-document"
	          },
		      text: false
	    });
	
	$('#newBtn').click(function(){
		var id='${summary.id}';
		parent.addFollowUp(id);
	});
	$('#editBtn').click(function(){
		var id=$('input[name=id]:checked').val();
		if(id){
			
			//alert('OK');
			parent.editFollowUp(id);
		}else{
			alert('Select row!');
		}
	});
	$('#printBtn').click(function(){
		$('#printDiv').printArea({
			retainAttr:['class','style']
		});
	});
	$('#deleteBtn').click(function(){
		var id=$('input[name=id]:checked').val();
		if(id){
			$.ajax({
				url:'${deleteURL}',
				type:'POST',
				data:{id:id},
				success:function(data){
					if(data.status){
						alert('Data removed from database');
						location.reload(true);
					}else{
						alert('Fail to remove data from database');
						location.reload(true);
					}
				},
				error:function(){
					alert('Server error..');
				}
			});
			
		}else{
			alert('Select row!');
		}
	});
	
	$('*[id^=close_]').click(function(){
		var id=$(this).attr('data-id');
		if(id){
			$("#dialog #dialogPage").attr('src', '${closeURL}/'+id);
			$("#dialog").dialog({
		        width: 400,
		        height: 400,
		        modal: true,
		        close: function () {
		        	$("#dialog #dialogPage").attr('src', "about:blank");
		        	location.reload(true);
		        }
		    
		    });
			
		}
	});
});
</script>	
</body>
</html>
