<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>


<style type="text/css">
	.table td{
		text-align: center;
	}
</style>

<spring:url value="/chemicalinv/chemicaldata/new" var="newURL" />
<spring:url value="/chemicalinv/chemicaldata/save" var="saveURL" />

<script type="text/javascript">
var currentVal;
var saveFormFlag=false;
var saveTimer;
$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		$('button:first').button({
			icons : {
				primary : "ui-icon-search"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-pencil"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-trash"
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
					<span class="label">Chemical - Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<form action='<spring:url value="/chemicalinvreport/view/detail/load"/>' method="get">	
					<table>
						<tr>
							<td>
							 	From							
							</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" readonly="readonly" style="width: 80px;text-align: center;">
							</td>
							<td>
							 	To							
							</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 80px;text-align: center;">
							</td>
							
							
							<td>
								<button type="submit">VIEW</button>
								<c:if test="${show}">
									<button type="button" id="editBtn">EDIT</button>
									<button type="button" id="deleteBtn">DELETE</button>
									<a href='<spring:url value="/chemicalinvreport/export/detail/excel?sdate=${sdate}&edate=${edate}"/>' target="_blank">EXCEL</a>
								</c:if>
							</td>
						</tr>
					</table>
				</form>
				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${show}">		
	<table class="table" style="margin: auto;">
			<thead>
				<tr>
					<th style="width: 15px;" rowspan="3"></th>
					<th rowspan="3" style="width: 100px;">DATE</th>
					
					<c:forEach items="${reportData.primaryCodes}" var="pcode">
						<td colspan="${pcode.count}">${pcode.name}</td>
					</c:forEach>
					
				</tr>
				<tr>
					<c:forEach items="${reportData.secondaryCodes}" var="scode">
						<td colspan="${scode.count}">${scode.name}</td>
					</c:forEach>
				</tr>
				<tr>
					<c:forEach items="${reportData.datas}" var="chemical">
						<td>${chemical.chemicalCode}</td>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${reportData.reportDatas}" var="data">
					<tr>
						<td><input type="radio" name="entryId" data-entryId="${data.entryId}" data-date="${data.date}"></td>
						<td>${data.date}</td>
						<c:forEach items="${data.values}" var="value">
							<td>${value}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td>TOTAL</td>
					<c:forEach items="${reportData.datas}" var="chemicalTotal">
						<td>${chemicalTotal.totalConsumption}</td>
					</c:forEach>
				</tr>
			</tfoot>
	</table>
</c:if>

</div>				
				
			</div>

		</div>


	</div>
<spring:url value="/chemicalinv/chemicaldata/edit" var="editURL"/>
<spring:url value="/chemicalinv/chemicaldata/delete" var="deleteURL"/>

<script type="text/javascript">
	$(function(){
		$('#editBtn').click(function(){
			var selected=$('input[name=entryId]:checked');
			if(selected){
				var entryId=selected.attr('data-entryId');
				var date=selected.attr('data-date');
				if(entryId){
					location.href='${editURL}/'+encodeURIComponent(date)+'/'+encodeURIComponent(entryId)+'?${backParam}';
				}else{
					alert('Please select row.');
				}
			}
		});
		
		$('#deleteBtn').click(function(){
			var selected=$('input[name=entryId]:checked');
			if(selected){
				var entryId=selected.attr('data-entryId');
				var date=selected.attr('data-date');
				if(entryId){
					
					if(confirm("Do you want to remove data?")){
						$.ajax({
							url:'${deleteURL}',
							data:{
								date : date,
								entryId : entryId
							},
							success:function(data){
								if(data.flag){
									alert('Data removed from database.');
									location.reload(true);
								}else{
									alert(data.error);
								}
							}
						});
					}
					
				}else{
					alert('Please select row.');
				}
			}
		});
		
		
		
	});

</script>
</body>
</html>
