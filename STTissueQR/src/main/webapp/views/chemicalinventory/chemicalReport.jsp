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
				
				<form action='<spring:url value="/chemicalinvreport/view"/>' method="get">	
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
							 	Secondary Code							
							</td>
							<td>
								<select name="sid" style="padding: 2px;width: 100px;">
									<option value="0">ALL</option>
									<c:forEach items="${secondaryCodes}" var="sc">
										<c:choose>
											<c:when test="${sc.id eq sid}">
												<option value="${sc.id}" selected="selected">${sc.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${sc.id}">${sc.name}</option>
											</c:otherwise>
										</c:choose>	
									</c:forEach>
								</select>
							</td>
							<td>
							 	Primary Code							
							</td>
							<td>
								<select name="pid" style="padding: 2px;width: 100px;">
									<option value="0">ALL</option>
									<c:forEach items="${primaryCodes}" var="pc">
										<c:choose>
											<c:when test="${pc.id eq pid}">
												<option value="${pc.id}" selected="selected">${pc.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${pc.id}">${pc.name}</option>
											</c:otherwise>
										</c:choose>	
									</c:forEach>
								</select>
							</td>
							<td>
								<button type="submit">VIEW</button>
								<button type="button" id="editBtn">EDIT</button>
								<button type="button" id="deleteBtn">DELETE</button>
								<c:if test="${show}">	
									<a href='<spring:url value="/chemicalinvreport/export/excel?sdate=${sdate}&edate=${edate}&sid=${sid}&pid=${pid}"/>' target="_blank">EXCEL</a>
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
			<th style="width: 15px;"></th>
			<th style="width: 90px;">Date</th>
			<th style="width: 100px;">Consumption</th>
			<th>Chemical</th>
			<th>Secondary Code</th>
			<th>Primary Code</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reportDatas}" var="data" >
			<c:set scope="page" var="date" value="${data.date}"/>
			<c:set scope="page" var="entryId" value="${data.entryId}"/>
			<c:set scope="page" value="${fn:length(data.datas)}" var="len"/>
			<c:forEach items="${data.datas}" var="ch" varStatus="index">
				<c:choose>
					<c:when test="${index.count eq 1}">
						<tr>
							
							<td rowspan="${len}"><input type="radio" name="entryId" data-entryId="${entryId}" data-date='<fmt:formatDate value="${date}" pattern="MM-dd-yyyy"/>'> </td>
							<td rowspan="${len}"><fmt:formatDate value="${date}" pattern="MM-dd-yyyy"/></td>
							<td>${ch.consumption}</td>
							<td>${ch.chemicalCode}</td>
							<td>${ch.secondaryName}</td>
							<td>${ch.primaryName}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${ch.consumption}</td>
							<td>${ch.chemicalCode}</td>
							<td>${ch.secondaryName}</td>
							<td>${ch.primaryName}</td>
							<%-- <td>NE 1= ${index.count}</td> --%>
						</tr>
					</c:otherwise>
				</c:choose>	
			
			</c:forEach>
		
		</c:forEach>
	
	</tbody>
</table>


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



</c:if>
</div>				
				
			</div>

		</div>


	</div>

</body>
</html>
