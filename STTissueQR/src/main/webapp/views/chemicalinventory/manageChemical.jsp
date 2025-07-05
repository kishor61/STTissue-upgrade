<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Chemical</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/chemicalinv/chemical/save" var="saveURL"/>
					<form action="${saveURL}" method="post">
						<table>
							<tr>
								<td>Chemical</td>
								<td>
									<select name="cid" style="width: 150px; padding: 3px;">
										<option value="">Select</option>
										<c:forEach items="${chemicalCodes}" var="ccode">
										
											<c:choose>
												<c:when test="${ccode.id eq chemical.cid}">
													<option value="${ccode.id}" selected="selected">${ccode.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${ccode.id}">${ccode.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<td>Secondary Code</td>
								<td>
									<select name="sid" style="width: 150px; padding: 3px;">
										<option value="">Select</option>
										<c:forEach items="${chemicalSecondaryCodes}" var="scode">
										
											<c:choose>
												<c:when test="${scode.id eq chemical.sid}">
													<option value="${scode.id}" selected="selected">${scode.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${scode.id}">${scode.name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<td>
									<button type="submit" id="saveBtn">Save</button>
									<input type="hidden" name="id" value="${chemical.id}">
									<spring:url value="/chemicalinv/chemical/manage" var="newURL" />
									
									<c:if test="${chemical.id gt 0}">
										<button type="button" onclick="location.href='${newURL}'">New</button>
									</c:if>
								</td>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<button type="button" id="manageChBtn">Manage Chemical Codes</button>
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

<table class="table" style="width: 800px; margin: auto;">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Chemical</th>
			<th>Secondary Chemical</th>
			<th>Primary Chemical</th>
			<th style="width: 150px;"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${chemicals}" var="ch" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${ch.chemicalCode}</td>
				<td>${ch.secondaryName}</td>
				<td>${ch.primaryName}</td>
				<td style="text-align: center;">
					<a href='<spring:url value="/chemicalinv/chemical/edit/${ch.id}"></spring:url>'>Edit</a>
					&nbsp;&nbsp;
					<a href='<spring:url value="/chemicalinv/chemical/delete/${ch.id}"></spring:url>'>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

			</div>

		</div>


	</div>
	
<div id="chemicalDialog" style="display: none;overflow: hidden;" title="Checmical Code">
	<iframe id="dialogPage" style="width: 100%; height: inherit;border: none;"></iframe>
</div>	
<spring:url value="/chemicalinv/chemicalcode/manage" var="chemicalCodeURL"/>	
<script type="text/javascript">
$(function(){
	$('#saveBtn').click(function(){
		
		var cid=$('select[name=cid]').val();
		if($.trim(cid)==''){
			alert('Select chemical.');
			return false;
		}
		
		var sid=$('select[name=sid]').val();
		if($.trim(sid)==''){
			alert('Select secondary code.');
			return false;
		}
		return true;
	});
	
	$('#manageChBtn').click(function(){
		$("#chemicalDialog #dialogPage").attr('src', '${chemicalCodeURL}');
        $("#chemicalDialog").dialog({
            width: 700,
            height: 400,
            modal: true,
            close: function () {
                $("#chemicalDialog #dialogPage").attr('src', "about:blank");
                location.reload(true);
            }
        });
	});
});
</script>
</body>
</html>
