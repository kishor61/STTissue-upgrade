<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate], input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>

<style type="text/css">
 .table td{
 	text-align: center;
 }
</style>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Process Improvement Meeting Notes - Reports</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
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
								<input type="text" name="sdate" value="${date}" readonly="readonly" style="width: 70px;">
							</td>
							<td>
								To
							</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 70px;">
							</td>
							<td>
								<button id="loadBtn">Load</button>
								
								
							</td>
						</tr>
					</table>

				</div>


<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<c:if test="${flagShow}">

<c:if test="${empty categoryId}">
<table class="table" style="width: 300px; margin: auto;">
	<thead>
		<tr>
			<td>Date</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${summaries}" var="summary">
			<tr>
				<td><fmt:formatDate value="${summary.entryDate}" pattern="MM-dd-yyyy" var="date"/>${date} </td>
				<td>
					<a href='<spring:url value="/oimnotesreport/view/${date}/${date}"/>' >VIEW</a>
					&nbsp;
					<a href='<spring:url value="/oimnotesreport/export/pdf/${date}/${date}"/>' target="_blank">PDF</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>

<c:if test="${not empty categoryId}">
<table class="table" style="width: 300px; margin: auto;">
	<thead>
		<tr>
			<td>Date</td>
			<td>Category</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${summaries}" var="summary">
			<tr>
				<td><fmt:formatDate value="${summary.entryDate}" pattern="MM-dd-yyyy" var="date"/>${date} </td>
				<td>${summary.category }</td>
				<td>
					<a href='<spring:url value="/oimnotesreport/view/${summary.categoryId}/${date}/${date}"/>'>VIEW</a>
					&nbsp;
					<a href='<spring:url value="/oimnotesreport/export/pdf/${summary.categoryId}/${date}/${date}"/>' target="_blank">PDF</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>


</c:if>

</div>



			</div>

		</div>


	</div>
	
<spring:url value="/oimnotesreport/load/dates" var="loadURL"/>
<script type="text/javascript">
	$('#loadBtn').click(function(){
		var categoryId=$('select[name=categoryId]').val();
		var sdate=$('input[name=sdate]').val();
		var edate=$('input[name=edate]').val();
		if(categoryId==''){
			location.href='${loadURL}/'+encodeURIComponent(sdate)+'/'+encodeURIComponent(edate);
		}else{
			location.href='${loadURL}/'+categoryId+'/'+encodeURIComponent(sdate)+'/'+encodeURIComponent(edate);
		}
		
	});
</script>
</body>
</html>
