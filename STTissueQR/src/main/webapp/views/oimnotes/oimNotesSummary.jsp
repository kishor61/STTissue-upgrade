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
.table td{
	font-size: 12px;
}
</style>

<script type="text/javascript">
$(function(){
	$('input[name=date], input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
	
	$('#printBtn').click(function(){
		$('#printForm').submit();
	});
	$('#exportBtn').click(function(){
		$('#exportForm').submit();
	});
});
</script>
</head>
<body>
	<div class="top-container">
		<div class="page-title">
			<span class="label" style="font-size: 12px;">Summary</span>
			
			&nbsp;&nbsp;
			<button id="createBtn">New</button>
			<button id="editBtn">Edit</button>
			<button id="deleteBtn">Delete</button>
			
		</div>
	</div>
	<div class="bot-container">
		<div class="table-selector" style="width: 97%;">
					
					<table style="margin: auto;">
						<tr>
							<td>Category:</td>
							<td>
								<select name="categoryId" style="width: 100px;">
									<option value="">All</option>
									<c:forEach items="${categories}" var="ctg">
										<c:choose>
											<c:when test="${ctg.id eq categoryId}">
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
								From
							</td>
							<td>
								<input type="text" name="date" value="${date}" readonly="readonly" style="width: 70px;">
							</td>
							<td>
								To
							</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 70px;">
							</td>
							<td>
								<button id="viewBtn">View</button>
								<spring:url value="/oimnotesreport/main" var="reportURL"/>
								<button onclick="parent.window.location.href='${reportURL}'">Reports</button> 
								
							</td>
						</tr>
					</table>

				</div>
				
				


	<br>
<div style="display: none;">
	<form id="printForm" action='<spring:url value="/oimnotesreport/print"/>' method="get" target="_blank">
		<input type="hidden" name="sdate" value="${date}">
		<input type="hidden" name="edate" value="${edate}">
		<input type="hidden" name="categoryId" value="${categoryId}">
	</form>
	<form id="exportExcelForm" action='<spring:url value="/oimnotesreport/export/excel"/>' method="post" target="_blank">
		<input type="hidden" name="sdate" value="${date}">
		<input type="hidden" name="edate" value="${edate}">
		<input type="hidden" name="categoryId" value="${categoryId}">
	</form>
	<form id="exportPdfForm" action='<spring:url value="/oimnotesreport/export/pdf"/>' method="post" target="_blank">
		<input type="hidden" name="sdate" value="${date}">
		<input type="hidden" name="edate" value="${edate}">
		<input type="hidden" name="categoryId" value="${categoryId}">
	</form>
</div>


<c:if test="${show}">


	<table class="table" id="summaryTable">
		<c:forEach items="${categories}" var="ctg">
			
			
			<tr  class="head">
				<th style="width: 10px;background-color: #F7E3D0;"></th>
				<th style="background-color: #F7E3D0;">Item</th>
				<th style="background-color: #F7E3D0;">${ctg.category}</th>
				<th style="background-color: #F7E3D0;">Date</th>
				<th style="width: 60px;background-color: #F7E3D0;"></th>
			</tr>
	
			<c:if test="${fn:length(summaries)>0}">	
					
					<c:set value="${1}" var="counter"/>
					<c:forEach items="${summaries}" var="summary">
						<c:if test="${ctg.id eq summary.categoryId}">
						
							
							<tr class="body">
								<td><input type="radio" name="id" value="${summary.id}"></td>
								<td align="center">${counter}</td>
								<td>${summary.summary}</td>
								
								<td><div style="width: 70px;text-align: center;"><fmt:formatDate value="${summary.entryDate}" pattern="MM-dd-yyyy"/></div> </td>
								<td>
									<spring:url value="/oimnotes/followup/view" var="followUpURL"/>
									<a href="${followUpURL}/${summary.id}" id="follow_${summary.id}">Follow Up</a> 
								</td>
							</tr>
							
							<c:set value="${counter+1}" var="counter"/>
						</c:if>
					</c:forEach>
					<tr>
						<td colspan="5" style="height: 25px;border: none;">&nbsp; </td>
					</tr>
				</c:if>
				
				
			
			
			
		</c:forEach>	
	</table>





</c:if>				
				
	</div>




<spring:url value="/oimnotes/summary/view" var="viewURL"/>
<spring:url value="/oimnotes/summary/delete" var="deleteURL"/>

<c:if test="${fn:length(summaries)>0}">	
	<script type="text/javascript">
		$(function(){
			parent.viewFollowUp('${followUpURL}/${summaries[0].id}');
		});
	</script>
</c:if>

<c:if test="${fn:length(summaries) eq 0}">	
	<script type="text/javascript">
		$(function(){
			parent.viewFollowUp('${followUpURL}');
		});
	</script>
</c:if>

<spring:url value="/oimnotes/summary" var="viewAllURL"/>
<script type="text/javascript">
$(function(){
	
	$('#summaryTable tr').each(function(){
		if(!($(this).next().attr('class')) & ($(this).attr('class')=='head') & ($(this).next().attr('class')!='body')){
			$(this).hide();
			$(this).next().hide();
		}
	});
	
	$('#createBtn').click(function(){
		parent.createSummary();
	});
	
	$('#viewBtn').click(function(){
		
		var date=$('input[name=date]').val();
		if(!date){
			alert('Select from date!');
			return false;
		}
		
		var edate=$('input[name=edate]').val();
		if(!edate){
			alert('Select to date!');
			return false;
		}
		
		var ctg=$('select[name=categoryId]').val();
		if(!ctg){
			location.href='${viewAllURL}/'+encodeURIComponent(date)+'/'+encodeURIComponent(edate);
		}else{
			
			
			location.href='${viewURL}/'+encodeURIComponent(ctg)+'/'+encodeURIComponent(date)+'/'+encodeURIComponent(edate);
			
		}
		
		
	});
	
	$('#editBtn').click(function(){
		var id=$('input[name=id]:checked').val();
		if(id){
			
			parent.editSummary(id);
		}else{
			alert('Select row!');
		}
	});
	
	$('*[id^=follow_]').click(function(e){
		e.preventDefault();
		
		parent.viewFollowUp($(this).attr('href'));
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
});
</script>
</body>
</html>
