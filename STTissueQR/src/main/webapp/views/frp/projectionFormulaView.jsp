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

.table {
	border-collapse: collapse;
	width: 800px;

}
.table td,table th {
	padding: 2px;
	text-align: center; 
}
	@media print {
    	button {
	       display: none;
	    }
	}
</style>



</head>
<body>
<div class="fixed-message">
	<span class="tmessage" id="tmessage"></span>
</div>

	<div class="container">
<spring:url value="/frpprojection/new"  var="newURL"/>
<spring:url value="/frpprojection/edit"  var="editURL"/>
<spring:url value="/frpprojection/delete"  var="deleteURL"/>
<table>
	<tr>
		<td>
			<button onclick="window.print();">Print</button>
			<button onclick="location.href='${newURL}'">New</button>
			<button id="editBtn">Edit</button>
			<button id="deleteBtn">Delete</button>
		 </td>
	</tr>
</table>
<hr>
<spring:url value="/frpprojection/view"  var="viewURL"/>
<script type="text/javascript">
	$(function(){
		$('#editBtn').click(function(){
			var id=$('#projectTable input[name=id]:checked').val();
			if(id){
				var url='${editURL}/'+id;
				location.href=url;
			}else{
				alert('Select row!');
			}
		});
		
		$('#type').change(function(){
			if($(this).val().length==0){
				location.href='${viewURL}';
			}else{
				location.href='${viewURL}/'+$(this).val();
			}
		});
		
		$('#deleteBtn').click(function(){
			
			var id=$('#projectTable input[name=id]:checked').val();
			if(id){
				if(confirm("Are you sure you want to delete this formula from database?")){
					$.ajax({
						url: '${deleteURL}/'+id,
						type: 'GET',
						success:function(data){
							if(data){
								alert('Data removed from database.');
							}else{
								alert('Failed to remove data from database.')
							}
							location.reload(true);
						}
					});
				}
			}else{
				alert('Select row!');
			}
		});
		
	});
</script>

<br>
<div style="margin: auto; width: 100%;text-align: center;">
	<span>Production Type:</span>
	<select id="type" tabindex="1" style="width: 150px; padding: 2px;">
		<option value="" >Select</option>
		<c:forEach items="${frpgrade}" var="grade">
			<c:choose>
				<c:when test="${grade.key eq type}">
					<option value="${grade.key}" selected="selected">${grade.value}</option>
				</c:when>
				<c:otherwise>
					<option value="${grade.key}" >${grade.value}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</div>
<br>
<hr>
<div style="overflow: auto; width: inherit;position: fixed;left: 0;right: 0;bottom: 0;top: 90px;">
<c:if test="${type eq 'WH'}">
<table class="table ui-widget-content ui-widget">
	<thead>
		<tr>
			<th rowspan="2"></th>
			<th rowspan="2">Production Type</th>
			<th rowspan="2">Napkin/Towel</th>
			<th rowspan="2">Input Tons</th>
			<th colspan="7">SWL</th>
			<th colspan="7">MWL</th>
			<th colspan="7">SOW</th>			
			<th colspan="7">Hard White</th>
			<th colspan="7">White Broke</th>
			
			<th rowspan="7" style="width: 200px;">Remarks</th>
		</tr>
		<tr>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>			
		</tr>
	</thead>
	<tbody  id="projectTable">
		<c:if test="${fn:length(projections)>0}">
			<c:forEach items="${projections}" var="projection">
				<tr>
					<td><input type="radio" name="id" value="${projection.id}"> </td>
					<td>${frpgrade[projection.type]}</td>
					<td>${frpgradetype[projection.type2]}</td>
					<td>${projection.input}</td>
					<td>${projection.white_swl}</td>
					<td><fmt:formatNumber value="${(projection.white_swl*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.white_swlMinR}</td>
					<td>${projection.white_swlMinC}</td>
					<td>${projection.white_swlTarget}</td>
					<td>${projection.white_swlMaxC}</td>
					<td>${projection.white_swlMaxR}</td>
					
					<td>${projection.white_mwl}</td>
					<td><fmt:formatNumber value="${(projection.white_mwl*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.white_mwlMinR}</td>
					<td>${projection.white_mwlMinC}</td>
					<td>${projection.white_mwlTarget}</td>
					<td>${projection.white_mwlMaxC}</td>
					<td>${projection.white_mwlMaxR}</td>
					
					<td>${projection.sow}</td>
					<td><fmt:formatNumber value="${(projection.sow*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.sowMinR}</td>
					<td>${projection.sowMinC}</td>
					<td>${projection.sowTarget}</td>
					<td>${projection.sowMaxC}</td>
					<td>${projection.sowMaxR}</td>
					
					
					<td>${projection.hw}</td>
					<td><fmt:formatNumber value="${(projection.hw*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.hwMinR}</td>
					<td>${projection.hwMinC}</td>
					<td>${projection.hwTarget}</td>
					<td>${projection.hwMaxC}</td>
					<td>${projection.hwMaxR}</td>
					
					<td>${projection.unprtsbs}</td>
					<td><fmt:formatNumber value="${(projection.unprtsbs*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.unprtsbsMinR}</td>
					<td>${projection.unprtsbsMinC}</td>
					<td>${projection.unprtsbsTarget}</td>
					<td>${projection.unprtsbsMaxC}</td>
					<td>${projection.unprtsbsMaxR}</td>
					
					
					
					<td>${projection.remarks}</td>
				</tr>
			</c:forEach>
		</c:if>
	
		
		
	</tbody>
	
</table>
</c:if>

<c:if test="${type eq 'KF'}">
<table class="table ui-widget-content ui-widget">
	<thead>
		<tr>
			<th rowspan="2"></th>
			<th rowspan="2">Production Type</th>
			<th rowspan="2">Napkin/Towel</th>
			<th rowspan="2">Input Tons</th>
			<th colspan="7">OCC</th>
			<th colspan="7">OCC-Grocery</th>
			<th colspan="7">DLK</th>		
			<th colspan="7">SOW</th>
			<th colspan="7">Mail</th>
			<th colspan="7">ONP-Old News Print</th>
			<th colspan="7">SCN News</th>
			<th colspan="7">Mixed Paper</th>
			<th colspan="7">Brown Broke</th>
			<th colspan="7">SWL</th>
			<th colspan="7">MWL</th>
			<th rowspan="2" style="width: 200px;">Remarks</th>
		</tr>
		<tr>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			
			<td>%</td>
			<td>Ton</td>
			<td>MinR</td>
			<td>MinC</td>
			<td>Target</td>
			<td>MaxC</td>
			<td>MaxR</td>
			
		</tr>
	</thead>
	<tbody  id="projectTable">
		<c:if test="${fn:length(projections)>0}">
			<c:forEach items="${projections}" var="projection">
				<tr>
					<td><input type="radio" name="id" value="${projection.id}"> </td>
					<td>${frpgrade[projection.type]}</td>
					<td>${frpgradetype[projection.type2]}</td>
					<td>${projection.input}</td>
					
					<td>${projection.occ}</td>
					<td><fmt:formatNumber value="${(projection.occ*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.occMinR}</td>
					<td>${projection.occMinC}</td>
					<td>${projection.occTarget}</td>
					<td>${projection.occMaxC}</td>
					<td>${projection.occMaxR}</td>
					
					<td>${projection.occ_GROCERY_MRF}</td>
					<td><fmt:formatNumber value="${(projection.occ_GROCERY_MRF*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.occ_GROCERY_MRFMinR}</td>
					<td>${projection.occ_GROCERY_MRFMinC}</td>
					<td>${projection.occ_GROCERY_MRFTarget}</td>
					<td>${projection.occ_GROCERY_MRFMaxC}</td>
					<td>${projection.occ_GROCERY_MRFMaxR}</td>
					
					<td>${projection.dlk}</td>
					<td><fmt:formatNumber value="${(projection.dlk*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.dlkMinR}</td>
					<td>${projection.dlkMinC}</td>
					<td>${projection.dlkTarget}</td>
					<td>${projection.dlkMaxC}</td>
					<td>${projection.dlkMaxR}</td>	
					
					<td>${projection.sow}</td>
					<td><fmt:formatNumber value="${(projection.sow*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.sowMinR}</td>
					<td>${projection.sowMinC}</td>
					<td>${projection.sowTarget}</td>
					<td>${projection.sowMaxC}</td>
					<td>${projection.sowMaxR}</td>	
										
					<td>${projection.sowAndMail}</td>
					<td><fmt:formatNumber value="${(projection.sowAndMail*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.sowAndMailMinR}</td>
					<td>${projection.sowAndMailMinC}</td>
					<td>${projection.sowAndMailTarget}</td>
					<td>${projection.sowAndMailMaxC}</td>
					<td>${projection.sowAndMailMaxR}</td>				
					
					
					<td>${projection.ol_News}</td>
					<td><fmt:formatNumber value="${(projection.ol_News*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.ol_NewsMinR}</td>
					<td>${projection.ol_NewsMinC}</td>
					<td>${projection.ol_NewsTarget}</td>
					<td>${projection.ol_NewsMaxC}</td>
					<td>${projection.ol_NewsMaxR}</td>
					
					<td>${projection.onp_scn}</td>
					<td><fmt:formatNumber value="${(projection.onp_scn*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.onp_scnMinR}</td>
					<td>${projection.onp_scnMinC}</td>
					<td>${projection.onp_scnTarget}</td>
					<td>${projection.onp_scnMaxC}</td>
					<td>${projection.onp_scnMaxR}</td>
					
					<td>${projection.mixedPaper}</td>
					<td><fmt:formatNumber value="${(projection.mixedPaper*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.mixedPaperMinR}</td>
					<td>${projection.mixedPaperMinC}</td>
					<td>${projection.mixedPaperTarget}</td>
					<td>${projection.mixedPaperMaxC}</td>
					<td>${projection.mixedPaperMaxR}</td>
					
					<td>${projection.others}</td>
					<td><fmt:formatNumber value="${(projection.others*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.othersMinR}</td>
					<td>${projection.othersMinC}</td>
					<td>${projection.othersTarget}</td>
					<td>${projection.othersMaxC}</td>
					<td>${projection.othersMaxR}</td>
					
					<td>${projection.white_swl}</td>
					<td><fmt:formatNumber value="${(projection.white_swl*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.white_swlMinR}</td>
					<td>${projection.white_swlMinC}</td>
					<td>${projection.white_swlTarget}</td>
					<td>${projection.white_swlMaxC}</td>
					<td>${projection.white_swlMaxR}</td>
					
					<td>${projection.white_mwl}</td>
					<td><fmt:formatNumber value="${(projection.white_mwl*projection.input)/100 }" maxFractionDigits="2" pattern="#.##"/> </td>
					<td>${projection.white_mwlMinR}</td>
					<td>${projection.white_mwlMinC}</td>
					<td>${projection.white_mwlTarget}</td>
					<td>${projection.white_mwlMaxC}</td>
					<td>${projection.white_mwlMaxR}</td>
					
					
					<td>${projection.remarks}</td>
				</tr>
			</c:forEach>
		</c:if>
		
		
		<c:if test="${fn:length(projections) eq 0}">
		
		</c:if>
		
		
	</tbody>
	
</table>
</c:if>
</div>



</div>

</body>
</html>
