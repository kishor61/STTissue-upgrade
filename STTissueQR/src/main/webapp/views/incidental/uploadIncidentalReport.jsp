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
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<spring:url value="/incidentaluser/review/action" var="reviewURL" />
<spring:url value="/incidentaluser/delete" var="deleteURL" />
<script type="text/javascript">
	$(function(){
		$('*[id^=close_]').click(function(){
			var id=$(this).attr('data-id');
			var url='${reviewURL}/'+id;
			$("#dialog #dialogPage").attr('src',url);
			$("#dialog").dialog({
				width : 400,
				height : 300,
				modal : true,
				close : function() {
					$("#dialog #dialogPage").attr('src', "about:blank");
					location.href=location.href;
				}

			});
			
		});
		$('#deleteBtn').click(function() {
			var val = $('input[name=id]:checked').val();
			if (val) {
				$.ajax({
				url : '${deleteURL}',
				type : 'POST',
				data : {
					id : val
				},
				success : function(
						data) {
					if (data.status) {
						alert('Data removed successfully.');
						location
								.reload(true);
					} else {
						alert('Fail to delete data from database.');
						location
								.reload(true);
					}
				}
						});
			} else {
				alert('Select row.');
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
					<span class="label">Uploaded-Incidental Document(s)</span>
				</div>
				<div class="table-selector" id="table-selector">
				
				<spring:url value="/incidentaluser/view/data" var="viewURL"/>
				<form action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
							</td>
							<td>
								<input id="deleteBtn" value="Delete" type="button">
							</td>
						</tr>
					</table>
				</form>
				</div>

<center>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td>&nbsp;</td>
			<td><b>Date</b></td>
			<td><b>Document</b></td>
			<td><b>Subject</b></td>
			<td><b>Description</b></td>
			<td><b>Download</b></td>
			<td><b>Action</b></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${details}" var="wd">
			<tr>
				<td><input type="radio" value="${wd.id}" name="id"></td>
				<td>
					<fmt:formatDate value="${wd.date}" pattern="MM/dd/yyyy"/>
				
				</td>
				<td>${wd.file}</td>
				<td>${wd.comment}</td>	
				<td>${wd.description}</td>	
				<td><a href='<spring:url value="/incidentaluser/view/data/downloadfile/${wd.id}"/>' target="_blank">Download Attachment</a></td>
					<%-- <td><a href="${path}/Incidental_Uploaded_Documents_Roshan/${wd.file}">Download Attachment</a></td> --%>
				<td style="text-align: center;"><a href="javascript:void(0)" id="close_${wd.id}" data-id="${wd.id}">Review</a> </td>
			</tr>
			
		</c:forEach>
	</tbody>
</table>
<div id="dialog" title="INCIDENTAL DOCUMENT REVIEW" style="display: none; overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit; border: none;"></iframe>
</div>
</div>
</center>
			</div>

		</div>


	</div>

</body>
</html>
