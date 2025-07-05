<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>


<style type="text/css">
.table-selector table input[type=text] {
	width: 100px;
	text-align: center;
}
.table td div{
	width: inherit !important;
	text-align: center;
}
.table tfoot td{
	text-align: center;
}
.boldTr{
	font-weight: bold;
	background-color: rgb(226, 226, 226);
}
</style>

<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
</head>
<body>
<jsp:include page="../_loader.jsp"/>
	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">PM6 Tissue Wrapped Tons - Report</span>
				</div>
				<br>
				<div class="table-selector">
				
				<spring:url value="/productionwarpreport/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL }" method="get">	
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
								<input type="submit" value="View">
								&nbsp;
								&nbsp;
								<c:if test="${viewFlag}">
									<input type="button" id="exportBtn" value="Export">
									&nbsp;
									<input type="button" id="printBtn" value="Print">
								</c:if>
							</td>
						</tr>
					</table>
				</form>
				
				</div>
				
				
				<br>
				<br>

<div style="position: absolute;bottom: 0;width: 98%;top: 103px;overflow: auto;">
<c:if test="${viewFlag}">

<script type="text/javascript">
	$(function(){
		$('#exportBtn').click(function(){
			$('#exportForm').submit();
			return false;
		});
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
		
	});
</script>

<spring:url value="/productionwarpreport/export" var="exportURL"/>
<form target="_blank" id="exportForm" action="${exportURL}" method="post">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate}">
</form>

<div id="printDiv">
<table class="table" style="margin: auto; font-size: 12px; width: 700px;">
	
	<thead>
		<tr class="trobjrow">
			<th colspan="10">PM6 TISSUE Wrapped Tons with Machine Production ${reportFrom} - ${reportTo}
			 </th>
		</tr>
		<tr>
			<th rowspan="2" style="width: 80px;">Month</th>
			<th rowspan="2" style="width: 80px;">Reel<br> Tons Act.</th>
			<th colspan="2" style="width: 80px;">White Net Tons</th>
			<th colspan="2" style="width: 80px;">Red Net Tons</th>
			<th rowspan="2" style="width: 80px;">MTD<br> Total Net</th>
			<th rowspan="2" style="width: 80px;">MTD<br> Average</th>
			<th rowspan="2" style="width: 80px;">Target<br> Tons</th>
			<th rowspan="2" style="width: 80px;">Monthly <br>Efficiency <br>%</th>
			
		</tr>
		<tr>
			<th>White</th>
			<th>Brown</th>
			<th>White</th>
			<th>Brown</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(hisdatas)>0}">
		<c:forEach items="${hisdatas}" var="data">
			<c:if test="${data['11'] eq 'YT'}">
				<tr class="boldTr">
					<td><div>${data['1']}</div></td>
					<td><div>${data['2']}</div></td>
					<td><div>${data['3']}</div></td>
					<td><div>${data['4']}</div></td>
					<td><div>${data['5']}</div></td>
					<td><div>${data['6']}</div></td>
					<td><div>${data['7']}</div></td>
					<td><div>${data['8']}</div></td>
					<td><div>${data['9']}</div></td>
					<td><div>${data['10']}</div></td>
				</tr>
			</c:if>
			<c:if test="${data['11'] eq ''}">
				<tr>
					<td><div>${data['1']}</div></td>
					<td><div>${data['2']}</div></td>
					<td><div>${data['3']}</div></td>
					<td><div>${data['4']}</div></td>
					<td><div>${data['5']}</div></td>
					<td><div>${data['6']}</div></td>
					<td><div>${data['7']}</div></td>
					<td><div>${data['8']}</div></td>
					<td><div>${data['9']}</div></td>
					<td><div>${data['10']}</div></td>
				</tr>
			</c:if>
			
		</c:forEach>
		</c:if>
	</tbody>
	
</table>
	
<table id="reportTable" class="table" style="margin: auto; font-size: 12px; width: 700px;">
		
	<thead>
		<tr class="trobjrow">
			<th colspan="10">ST Tissue LLC, PM6 TISSUE WRAPPED TONS -
				<fmt:parseDate  value="${sdate}" pattern="MM-dd-yyyy" var="parsedDate"/>
				<fmt:formatDate value="${parsedDate}" pattern="MMMM yyyy"/>
			 </th>
		</tr>
		<tr>
			<th rowspan="2" style="width: 80px;">Date</th>
			<th rowspan="2" style="width: 80px;">Machine Production</th>
			<th colspan="2" style="width: 80px;">White Tons</th>
			<th colspan="2" style="width: 80px;">Red Tons</th>
			<th rowspan="2" style="width: 80px;">Total<br> Net<br>Tons</th>
			<th rowspan="2" style="width: 80px;">Daily<br> Average</th>
			<th rowspan="2" style="width: 80px;">Target<br> Tons</th>
			<th rowspan="2" style="width: 80px;">Monthly <br>Efficiency <br>%</th>
			
		</tr>
		<tr>
			<th>White</th>
			<th>Brown</th>
			<th>White</th>
			<th>Brown</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(datas)>0}">
		<c:forEach items="${datas}" var="data">
			<tr>
			
				<td><div>${data['1']}</div></td>
				<td><div>${data['2']}</div></td>
				<td><div>${data['3']}</div></td>
				<td><div>${data['4']}</div></td>
				<td><div>${data['5']}</div></td>
				<td><div>${data['6']}</div></td>
				<td><div>${data['7']}</div></td>
				<td><div>${data['8']}</div></td>
				<td><div>${data['9']}</div></td>
				<td><div>${data['10']}</div></td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${fn:length(datas) eq 0}">
			<tr>
				<td colspan="9"><div style="height: 30px;"><br>Data not available for this selection.<br><br></div><td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
	
		<tr>
			<td>Total</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	
		</tr>
	</tfoot>

</table>
</div>
<br><br>

<script type="text/javascript">
	$(function(){
		var row=$('#reportTable tbody tr').length;
		var col=$('#reportTable tbody tr:nth-child(1) td').length;
		
		
		
		if(row){
			for(var c=0;c<col;c++){
				var total=0;
				for(var r=0;r<row;r++){
					var txt=$('#reportTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					if($.isNumeric( txt )){
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0){
						//No Query
					}else if(c==9){
						//alert('OK');
					}else if(c==7){
						var avg=total/row;
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(avg.toFixed(2));
					}else{
						$('#reportTable tfoot tr:eq(0)').find('td:eq('+c+')').text(total.toFixed(2));	
					}
				}
			}
		}
		
		var firstVal=parseFloat($('#reportTable tfoot tr:eq(0)').find('td:eq(2)').text());
		if(isNaN(firstVal)){
			firstVal=0;
		}
		var secondVal=parseFloat($('#reportTable tfoot tr:eq(0)').find('td:eq(3)').text());
		if(isNaN(secondVal)){
			secondVal=0;
		}
		
		var targetVal=parseFloat($('#reportTable tfoot tr:eq(0)').find('td:eq(8)').text());
		if(isNaN(targetVal)){
			targetVal=0;
		}
		var effVal=0;
		if(targetVal!=0){
			effVal=((firstVal+secondVal)/targetVal)*100;
		}
		$('#reportTable tfoot tr:eq(0)').find('td:eq(9)').text(effVal.toFixed(2));
	});

</script>

</c:if>					
				</div>

			</div>

		</div>


	</div>

</body>
</html>
