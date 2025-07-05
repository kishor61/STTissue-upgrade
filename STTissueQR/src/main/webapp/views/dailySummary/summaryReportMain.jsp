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
.dtable {
	border-collapse: collapse;
}

.dtable td, .dtable th {
	border: 1px solid gray;
	text-align: center;
}

.hbg {
	background-color: #EEE;
}

.dtable textarea {
	width: 535px;
	height: 50px;
	resize: none;
	margin-bottom: -4px;
}
</style>



<script type="text/javascript">
	
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		
		$('#viewBtn').button({
			icons : {
				primary : "ui-icon-search"
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
					<span class="label">Daily Summary - Report</span>
				</div>
				<br>
	

				<div class="table-selector">

	<spring:url value="/pmsummarydatareport/load/date" var="loadURL"/>
		<form action="${loadURL}" method="get">
					<table>
						<tr>
							<td>
								From
							</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" readonly="readonly" style="width: 90px;">
							</td>
							<td>
								To
							</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 90px;">
							</td>
							<td>
								<button type="submit" id="viewBtn">VIEW</button>
							</td>
						</tr>
					</table>
		</form>
				</div>

<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

				<br>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 180px;">
<c:if test="${showFlag}">

<table class="table" style="width: 300px;">
	<thead>
		<tr>
			<th>S.No</th>
			<th>Date</th>
			<th>Production Date</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(datas) gt 0}">
			<c:forEach items="${datas}" var="map" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td><fmt:formatDate value="${map['DATE']}" pattern="MM-dd-yyyy"/></td>
					<td><fmt:formatDate value="${map['PRODUCTIONDATE']}" pattern="MM-dd-yyyy"/></td>
					<td><a href='<spring:url value="/pmsummarydatareport/loaddata?id=${map['ID']}&sdate=${sdate}&edate=${edate}"/>'>VIEW</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>

</c:if>

<br>
<br>


</div>



			</div>

		</div>


	</div>


</body>
</html>
