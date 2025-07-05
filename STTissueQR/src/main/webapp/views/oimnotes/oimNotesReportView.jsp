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
.hkhead{
background-color: #F9D8C1;
text-align: center;
font-weight: bold;
}
</style>
<script type="text/javascript">
$(function(){
	$('#backBtn').button({
		icons : {
			primary : "ui-icon-circle-arrow-w"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-pencil"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-document"
		}
	});
});
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
					<span class="label">Process Improvement Meeting Notes</span>
				</div>
				<br>
				
	<div class="table-selector">
					
					<table>
						<tr>
							<td>
								<button id="backBtn" onclick="history.back();">BACK</button>
								
								<spring:url value="/oimnotes/main" var="editURL"/>
								<c:choose>
									<c:when test="${not empty categoryId}">
									
										<a href="${editURL}?categoryId=${categoryId}&sdate=${sdate}&edate=${edate}">EDIT</a>
										<a href='<spring:url value="/oimnotesreport/export/pdf/${categoryId}/${sdate}/${edate}"/>' target="_blank">PDF</a>
									</c:when>
									<c:otherwise>
										<a href="${editURL}?sdate=${sdate}&edate=${edate}">EDIT</a>
										<a href='<spring:url value="/oimnotesreport/export/pdf/${sdate}/${edate}"/>' target="_blank">PDF</a>
										
									</c:otherwise>
								</c:choose>
								
								
							</td>
							
						</tr>
					</table>

				</div>
<br>


<div style="position: fixed;top:150px; bottom: 0;left: 0;right: 0;overflow: auto;"">

<c:set value="${1}" var="counter"/>
<c:set value="${1}" var="counter2"/>
<table class="table" style="width: 900px; margin: auto;">
	<c:forEach items="${categories}" var="cat">
		<tr>
			<td class="hkhead" colspan="9">${cat.category}</td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="2"><b>S.No</b></td>
			<td colspan="6" style="text-align: left;"><b>Summary</b></td>
			<td style="text-align: center;"><b>Date</b></td>
		</tr>
		
		<c:forEach items="${summaries}" var="summary">
			<c:if test="${summary.categoryId eq  cat.id}">
				<tr>
					<td colspan="2" style="text-align: center;">${counter}</td>
					<td colspan="6" style="font-size: 14px;">${summary.summary}</td>
					<td><div style="width: 80px;text-align: center;"><fmt:formatDate value="${summary.entryDate}" pattern="MM-dd-yyyy"/></div></td>
				
				</tr>
				
				<c:if test="${fn:length(summary.followUps) gt 0}">
					<tr>
						<td style="text-align: center;width: 15px;" rowspan="${fn:length(summary.followUps)+1 }"></td>
						<td style="text-align: center;"><b>Tag</b></td>
						<td style="text-align: center;;"><b>Follow Up</b></td>
						<td style="text-align: center;"><b>Responsibility</b></td>
						<td style="text-align: center;"><b>Timeline</b></td>
						<td style="text-align: center;"><b>Recurrence</b></td>
						<td style="text-align: center;"><b>Status</b></td>
						<td style="text-align: center;"><div style="width: 80px;text-align: center;"><b>Closed By</b></div></td>
						<td style="text-align: center;"><b>Closed On</b></td>
					</tr>
					<c:forEach items="${summary.followUps}" var="followUp">
						<tr>
							<td style="text-align: center;background-color: ${followUp.tagColor};"></td>
							
							<td style="text-align: left;">${followUp.followUp}
							
							<br>
							
							<c:if test="${followUp.historyCount gt 0}">
								<a class="hisLink" style="font-size: 10px;color: #1364F5;text-transform: uppercase;" href="<spring:url value="/oimnotes/followup/history/${followUp.id}"/>" target="_blank">Change History</a>
							</c:if>
							
							</td>
							<td style="text-align: center;">${followUp.responsibility}</td>
							<td style="text-align: center;"><div style="width: 80px;text-align: center;"><fmt:formatDate value="${followUp.timeline}" pattern="MM-dd-yyyy"/></div> </td>
							<td style="text-align: center;">${recurrences[followUp.recurrence]}</td>
							<td style="text-align: center;">
								<c:choose>
									<c:when test="${not empty followUp.closed}">
										Closed
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0)" id="close_${followUp.id}" data-id="${followUp.id}">Open</a>
									</c:otherwise>
								</c:choose>
								
							</td>
							<td style="text-align: center;">${followUp.closedBy}</td>
							<td style="text-align: center;"><fmt:formatDate value="${followUp.closed}" pattern="MM-dd-yyyy"/></td>
							
						</tr>
						<c:set value="${counter2+1}" var="counter2"/>
					</c:forEach>
						
				</c:if>
				
				
				<c:set value="${counter+1}" var="counter"/>
			</c:if>	
		</c:forEach>
		
	<%-- 	
		 --%>
		<tr>
			<td colspan="3" style="border: none;"><div style="height: 20px;"></div></td>
		</tr>
		<c:set value="${1}" var="counter"/>
		<c:set value="${1}" var="counter2"/>
	</c:forEach>
</table>

</div>

</div>
</div>
</div>

<spring:url value="/oimnotes/followup/close" var="closeURL"/>


<div id="dialog" title="PROCESS IMPROVEMENT MEETING NOTES" style="display: none;">
	<iframe id="dialogPage" style="width: 98%; height: inherit;border: none;"></iframe>
</div>

<script type="text/javascript">
$(function(){
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
