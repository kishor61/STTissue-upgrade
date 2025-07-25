<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>
<style type="text/css">
.table div{
	display:block;
	width: inherit;
	text-align: center;
}
.table td{
	padding: 2 !important;
}
</style>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP Press Quality Data - Report</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/frppressqualityreport/view/load" var="viewdataURL" />
					<form action="${viewdataURL}" method="get">
					<table style="margin: auto;">
						<tr>
							<td>Start Date</td>
							<td><input readonly="readonly" type="text" name="sdate" value="${sdate}" style="width: 80px;"></td>
							<td></td>
							<td>End Date</td>
							<td><input readonly="readonly" type="text" name="edate" value="${edate}"  style="width: 80px;"></td>
							<td></td>
							<td> &nbsp;&nbsp; Press Quality Type</td>
							<td>
								<select name="pType" style="width: 180px;">
									<option value="">Select</option>
									<c:forEach items="${qtypes }" var="qtype">
										<c:choose>
											<c:when test="${qtype.key eq  type }">
												<option value="${qtype.key}" selected="selected">${qtype.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${qtype.key}">${qtype.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								&nbsp;&nbsp;
								<input type="submit" id="viewBtn" value="View">
								<c:if test="${not empty type}">
									&nbsp;&nbsp;
									<input type="button" id="editRowBtn" value="Edit">
									&nbsp;&nbsp;
									<input type="button" id="exportBtn" value="Export">
									&nbsp;&nbsp;&nbsp;
									<input type="button" id="printBtn" value="Print">
									&nbsp;&nbsp;&nbsp;
									<input type="button" id="deleteRowBtn" value="Delete">
								</c:if>
							</td>	
												
						</tr>
					</table>
					</form>
				</div>

				<br>
				
<c:if test="${not empty type}">
<spring:url value="/frppressqualityreport/export" var="exportURL" />
<form id="exportForm" action="${exportURL}" method="post">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate}">
<input type="hidden" name="pType" value="${type}">
</form>
</c:if>				
				
				
<c:if test="${not empty type}">

<spring:url value="/frppressquality/edit" var="editURL" />

<script type="text/javascript">

$(function(){

	$('#exportBtn').click(function(){
		$('#exportForm').submit();
		return false;
	});
	
	$('#viewBtn').click(function(){
		var pType=$('select[name=pType]').val();
		if(pType==''){
			alert('Select quality type');
			$('select[name=pType]').focus();
			return false;
		}
		return true;
	});
	
	$('#editRowBtn').click(function(){
		var val=$('#qualityDataTable tbody input[name=id]:checked').val();
		var type=$('select[name=pType]').val();
		
		if(typeof val==='undefined'){
			alert('Select row');
		}if(typeof val==='undefined'){
			alert('Select Press Quality Type	');
		}else{
			var url='${editURL}/'+val+'/'+type+location.search;
			location.href=url;
		}
	});
	
	$('#printBtn').click(function(){
		$('#printDiv').printArea({
			retainAttr:['class','style']
		});
	});
});

	
</script>


<!-- Code Starts From Here Done By Roshan Tailor Added TPQ2 Date :- 03/27/2015 -->
<c:if test="${type eq 'SPC' || type eq 'TPQ' ||type eq 'TPQ2'|| type eq 'SECPRESSQ'  || type eq 'WL' || type eq 'IPSC' }">
<!-- Code Ends Here Done By Roshan Tailor -->
<spring:url value="/frppressquality/delete" var="deleteURL" />

<script type="text/javascript">
$(function(){
	$('#deleteRowBtn').click(function(){
		var dbtn=$(this);
		var val=$('#qualityDataTable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#qualityDataTable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
					type:'POST',
					data:{id:val},
					success:function(data){
						if(data.status){
							alert('Data removed from database.');
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}
		}
	});
});
</script>

</c:if>

<c:if test="${type eq 'SH'}">

<spring:url value="/frppressquality/deletesludgehauling" var="deleteURL" />

<script type="text/javascript">
$(function(){
	$('#deleteRowBtn').click(function(){
		var dbtn=$(this);
		var val=$('#qualityDataTable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#qualityDataTable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
					type:'POST',
					data:{id:val},
					success:function(data){
						if(data.status){
							alert('Data removed from database.');
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}
		}
	});
});
</script>
</c:if>

<c:if test="${type eq 'ST'}">

<spring:url value="/frppressquality/deleteStickiedata" var="deleteURL" />

<script type="text/javascript">
$(function(){
	$('#deleteRowBtn').click(function(){
		var dbtn=$(this);
		var val=$('#qualityDataTable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#qualityDataTable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
					type:'POST',
					data:{id:val},
					success:function(data){
						if(data.status){
							alert('Data removed from database.');
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}
		}
	});
});
</script>
</c:if>

</c:if>

<div id="printDiv">
<!-- TERTIARY PRESS QUALITY -->
<c:if test="${type eq 'TPQ' }">
<table id="qualityDataTable"  class="table" style="width: 800px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time</th>
			<th>Initials</th>
			<th>Brightness<br> (2/shift) Min 71.5<br> for tube conveyor</th>
<!-- 			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
			<th>L</th>
			<th>a</th>
			<th>b</th>	
<!-- 			Code Ends Here Done By Roshan Tailor  -->
			<th>Dirt <br> (2/shift)</th>
			<th>Stickies<br> (1/night shift)</th>
			<th>Ash <!-- <br>(1/week dayshift) --></th>	
			<th>Consistency</th>
			<th>Freeness</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td colspan="9" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality['1']}"></td>
				<td style="width: 80px;"><div>${quality['2']}</div></td>
				<td style="width: 60px;"><div>${quality['3']}</div></td>
				<td style="width: 75px;"><div>${quality['4']}</div></td>
				<td style="width: 100px;"><div>${quality['5']}</div></td>
<!-- 				Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
				<td style="width: 100px;"><div>${quality['6']}</div></td>
				<td style="width: 100px;"><div>${quality['7']}</div></td>
				<td style="width: 100px;"><div>${quality['8']}</div></td>
<!-- 				Code Ends Here Done By Roshan Tailor -->
				<td style="width: 75px;"><div>${quality['9']}</div></td>
				<td style="width: 75px;"><div>${quality['10']}</div></td>
				<td style="width: 75px;"><div>${quality['11']}</div></td>
				<td style="width: 75px;"><div>${quality['12']}</div></td>
				<td style="width: 75px;"><div>${quality['13']}</div></td>
				<td style="width: 98%;"><div>${quality['14']}</div></td>
			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<tfoot>
		<tr>
			<td>Avg</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="center"></td>
			<td></td>
			<td></td>
<!-- 			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
			<td></td>
			<td></td>
			<td></td>
<!-- 			Code Ends Here Done By Roshan Tailor		 -->
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tfoot>	
</table>
<script type="text/javascript">
	$(function(){
		var row=$('#qualityDataTable tbody tr').length;
		var col=$('#qualityDataTable tbody tr:nth-child(1) td').length;
		
		var brightnessCount=0;
		var brightness=0;
		if(row){
			for(var c=0;c<col;c++){
				var total=0;
				for(var r=0;r<row;r++){
					var txt=$('#qualityDataTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					if($.isNumeric( txt )){
						if(c==4){
							var num=parseFloat(txt);
							if(num>0){
								brightnessCount++;
							}
						}else{
							
						}
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0){
						//No Query
					}else if(c==4){
						brightness=total/brightnessCount;
					}
				}
			}
		}
		
		$('#qualityDataTable tfoot tr:eq(0)').find('td:eq(4)').text(brightness.toFixed(2));
			
	});

</script>

</c:if>

<!-- Code Starts From Here Done By Roshan Tailor Date :- 03/27/2015 -->
<!-- Tertiary Press Quality 2 Starts From Here -->
<c:if test="${type eq 'TPQ2' }">
<table id="qualityDataTable"  class="table" style="width: 800px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time</th>
			<th>Line</th>
			<th>Initials</th>
<!-- 		Code Strats From Here Done By Roshan TAilor Date :- 04/01/2015 -->
			<th>Bleaching Chemical</th>
<!-- 		Code Ends Here Done By Roshan Tailor -->
			<th>Brightness<br> (2/shift) Min 71.5<br> for tube conveyor</th>
<!-- 			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
			<th>L</th>
			<th>a</th>
			<th>b</th>	
<!-- 			Code Ends Here Done By Roshan Tailor  -->
			<th>Dirt <br> (2/shift)</th>
			<th>Stickies<br> (1/night shift)</th>
			<th>Ash <!-- <br>(1/week dayshift) --></th>	
			<th>Consistency</th>
			<th>Freeness</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td colspan="9" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality['1']}"></td>
				<td style="width: 80px;"><div>${quality['2']}</div></td>
				<td style="width: 60px;"><div>${quality['3']}</div></td>
				<td style="width: 60px;"><div>${quality['16']}</div></td>
				<td style="width: 75px;"><div>${quality['4']}</div></td>
<!-- 			Code Starts From Here Done By Roshan Tailor Date:- 04/01/2015 -->
				<td style="width: 75px;"><div>${quality['5']}</div></td>
<!-- 			Code ends Here Done By Roshan Tailor -->
				<td style="width: 100px;"><div>${quality['6']}</div></td>
<!-- 				Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
				<td style="width: 100px;"><div>${quality['7']}</div></td>
				<td style="width: 100px;"><div>${quality['8']}</div></td> <!--Here 7 Is Present In Controller  Line Number 511  -->
				<td style="width: 100px;"><div>${quality['9']}</div></td>
<!-- 				Code Ends Here Done By Roshan Tailor -->
				<td style="width: 75px;"><div>${quality['10']}</div></td>
				<td style="width: 75px;"><div>${quality['11']}</div></td>
				<td style="width: 75px;"><div>${quality['12']}</div></td>
				<td style="width: 75px;"><div>${quality['13']}</div></td>
				<td style="width: 75px;"><div>${quality['14']}</div></td>
				<td style="width: 98%;"><div>${quality['15']}</div></td>
			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<tfoot>
		<tr>
<td>Avg</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="center"></td>
			<td></td>
<!-- 		Code Starts From Here Done By Roshan Tailor -->
			<td></td>
<!-- 		Code Ends Here Done By Roshan Tailor  -->
			<td></td>
<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
			<td></td>
			<td></td>
			<td></td>
<!-- 		Code Ends Here Done By Roshan Tailor		 -->
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tfoot>	
</table>
<script type="text/javascript">
	$(function(){
		var row=$('#qualityDataTable tbody tr').length;
		var col=$('#qualityDataTable tbody tr:nth-child(1) td').length;
		
		var brightnessCount=0;
		var brightness=0;
		if(row){
			for(var c=0;c<col;c++){
				var total=0;
				for(var r=0;r<row;r++){
					var txt=$('#qualityDataTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					if($.isNumeric( txt )){
// 						Code Changed By Roshan Tailor
						if(c==5){
							console.log(txt);
							
							var num=parseFloat(txt);
							if(num>0){
								brightnessCount++;
							}
						}else{
							
						}
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0){
						//No Query
// 						Code Changed By Roshan Tailor
					}else if(c==5){

						brightness=total/brightnessCount;
					}
				}
			}
		}
		
		$('#qualityDataTable tfoot tr:eq(0)').find('td:eq(5)').text(brightness.toFixed(2));
			
	});

</script>

</c:if>
<!-- Teritary Press Quality 2 Ends Here -->
<!-- Code Ends Here Done By Roshan Tailor -->

<!-- Code Starts From Here Done By Roshan Tailor Added SECPRESSQ Date:- 03/27/2015 -->
<!-- Seconday Press Quality Starts From Here -->
<!-- stickies data  data START From Here By KIshor vaishnav  -->
<c:if test="${type eq 'ST' }">
<h1>LINE A</h1>
<table id="qualityDataTable"  class="table" style="width: 100%; margin: auto;font-size: 12px; ">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Initials</th>
			<th>Pri Fine sceen feed</th>
			<th>Pri Fine sceen accepts</th>
			<th>Effeciancy</th>
			<th>Tertiary Press</th>
			<th>6 Refiner</th>
			<th>6 Paper</th>
			<th>Comments</th>			
		</tr>
		</thead>
		
		<tbody>
		
		<tr>
		<td></td><td></td><td></td><td></td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td></td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				<thead >
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td></td>
		</tr>
		<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="qualities">
		<tr>
		<td><input type="radio" name="id" value="${qualities.id}"></td>
		<td style="width: 80px;text-align: center;">${qualities.date} </td>
		<td style="width: 60px;text-align: center;">${qualities.ttimeA} </td>
		<td style="width: 75px;text-align: center;">${qualities.tinitialsA} </td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.psfcountA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psftotalareaA} </td>
						<td style="width: 75px;text-align: center;">${qualities.psfavgareaA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psfppmA} </td>
					</tr>
				
			</table>
		</td>	
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.psacountA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psatotalareaA} </td>
						<td style="width: 75px;text-align: center;">${qualities.psaavgareaA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psappmA} </td>
					</tr>
				
			</table>
		</td>
		<td style="width: 75px;text-align: center;">${qualities.efficiencyA} </td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.tcountA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.ttotalareaA} </td>
						<td style="width: 75px;text-align: center;">${qualities.tavgareaA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.tppmA} </td>
					</tr>
				
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.recountA} </td>
						<td style="width: 75px;text-align: center;">${qualities.retotalareaA}</td>
						<td style="width: 75px;text-align: center;">${qualities.reavgareaA}</td>
						<td style="width: 75px;text-align: center;">${qualities.reppmA} </td>
					</tr>
				
			</table>
		</td>	
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px;">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.pacountA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.patotalareaA}  </td>
						<td style="width: 75px;text-align: center;">${qualities.paavgareaA}</td>
						<td style="width: 75px;text-align: center;">${qualities.pappmA}</td>
						
					</tr>
				
			</table>
		</td>
		<td style="width: 75px;text-align: center;">${qualities.psfcommentA},${qualities.psacommentA},${qualities.tcommentA},${qualities.recommentA},${qualities.pacommentA}</td>
		</tr>
		</c:forEach>
		</c:if>
		
		</tbody>

</table><br><br><br>

<h1>LINE B</h1>
<table id="qualityDataTable"  class="table" style="width: 100%; margin: auto;font-size: 12px; ">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Initials</th>
			<th>Pri Fine sceen feed</th>
			<th>Pri Fine sceen accepts</th>
			<th>Effeciancy</th>
			<th>Reaction Tower</th>
			<th>5 Refiner</th>
			<th>5 Paper</th>
			<th>Comments</th>			
		</tr>
		</thead>		
		<tbody>
		
		<tr>
		<td></td><td></td><td></td><td></td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td></td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				<thead>
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				<thead >
					<tr>
						<th>Count</th>
						<th>Total Area</th>
						<th>Avg Area</th>
						<th>PPM</th>
					</tr>
				</thead>
			</table>
		</td>
		<td></td>
		</tr>
		<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="qualities">
		<tr>
		<td><input type="radio" name="id" value="${qualities.id}"></td>
		<td style="width: 80px;text-align: center;">${qualities.date} </td>
		<td style="width: 60px;text-align: center;">${qualities.totimeB} </td>
		<td style="width: 75px;text-align: center;">${qualities.toinitialsB} </td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.psfcountB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psftotalareaB} </td>
						<td style="width: 75px;text-align: center;">${qualities.psfavgareaB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psfppmB} </td>
					</tr>
				
			</table>
		</td>	
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.psacountB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psatotalareaB} </td>
						<td style="width: 75px;text-align: center;">${qualities.psaavgareaB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.psappmB} </td>
					</tr>
				
			</table>
		</td>
		<td style="width: 75px;text-align: center;">${qualities.efficiencyA} </td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.tocountB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.tototalareaB} </td>
						<td style="width: 75px;text-align: center;">${qualities.toavgareaB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.toppmB} </td>
					</tr>
				
			</table>
		</td>
		<td>
			<table class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				
					<tr>
						<td style="width: 75px;text-align: center;">${qualities.recountB} </td>
						<td style="width: 75px;text-align: center;">${qualities.retotalareaB}</td>
						<td style="width: 75px;text-align: center;">${qualities.reavgareaB}</td>
						<td style="width: 75px;text-align: center;">${qualities.reppmB} </td>
					</tr>
				
			</table>
		</td>	
		<td>
			<table  class="table" style="width: 100%; margin: auto;font-size: 12px; ">
				
					<tr >
						<td style="width: 75px;text-align: center;">${qualities.pacountB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.patotalareaB}  </td>
						<td style="width: 75px;text-align: center;">${qualities.paavgareaB}</td>
						<td style="width: 75px;text-align: center;">${qualities.pappmB}</td>						
					</tr>
			
			</table>
		</td>
			<td style="width: 75px;text-align: center;">${qualities.psfcommentB},${qualities.psacommentB},${qualities.tocommentB},${qualities.recommentB},${qualities.pacommentB}</td>
		</tr>
		</c:forEach>
		</c:if>
		
		</tbody>

</table>
</c:if>
<!-- Code Ends Here Done By Kishor vaishnav  -->
<c:if test="${type eq 'SECPRESSQ' }">
<table id="qualityDataTable"  class="table" style="width: 800px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time</th>
			<th>Brightness</th>
			<th>ERIC</th>
			<th>A*</th>	
			<th>B*</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td colspan="9" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality['1']}"></td>
				<td style="width: 80px;"><div>${quality['2']}</div></td>
				<td style="width: 60px;"><div>${quality['3']}</div></td>
				<td style="width: 75px;"><div>${quality['5']}</div></td>
				<td style="width: 100px;"><div>${quality['14']}</div></td>
				<td style="width: 75px;"><div>${quality['15']}</div></td> <!-- Here 14,15,16 Are Data Base Table Column Number -->
				<td style="width: 75px;"><div>${quality['16']}</div></td>
				<td style="width: 75px;"><div>${quality['11']}</div></td>
			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<tfoot>
		<tr>
			<td>Avg</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="center"></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tfoot>	
</table>
<script type="text/javascript">
	$(function(){
		var row=$('#qualityDataTable tbody tr').length;
		var col=$('#qualityDataTable tbody tr:nth-child(1) td').length;
		
		var brightnessCount=0;
		var brightness=0;
		if(row){
			for(var c=0;c<col;c++){
				var total=0;
				for(var r=0;r<row;r++){
					var txt=$('#qualityDataTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					if($.isNumeric( txt )){
						if(c==4){
							var num=parseFloat(txt);
							if(num>0){
								brightnessCount++;
							}
						}else{
							
						}
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0){
						//No Query
					}else if(c==4){
						brightness=total/brightnessCount;
					}
				}
			}
		}
		
		$('#qualityDataTable tfoot tr:eq(0)').find('td:eq(3)').text(brightness.toFixed(2));
			
	});

</script>

</c:if>

<!-- FRP Sludge Press Consistency -->
<c:if test="${type eq 'SPC' }">
<table  id="qualityDataTable" class="table" style="width: 800px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time</th>
			<th>Initials</th>
			<th>Consistency<br> (1/shift)</th>
			<th>Grade</th>
			<th>Clarifier<br> Underflow<br>Running</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td colspan="8" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>	
	
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality['1']}"></td>
				<td style="width: 80px;"><div>${quality['2']}</div></td>
				<td style="width: 60px;"><div>${quality['3']}</div></td>
				<td style="width: 75px;"><div>${quality['4']}</div></td>
				<td style="width: 75px;"><div>${quality['5']}</div></td>
				<td style="width: 100px;"><div>${quality['6']}</div></td>
				<td style="width: 100px;"><div>${quality['7']}</div></td>
				<td style="width: 98%;"><div>${quality['8']}</div></td>
			</tr>
		</c:forEach>
	</c:if>
	
	</tbody>
</table>
</c:if>


<!-- IP Sludge  Consistency -->
<c:if test="${type eq 'IPSC' }">
<table  id="qualityDataTable" class="table" style="width: 400px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Consistency<br> (1/shift)</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td colspan="4" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>	
	
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality['1']}"></td>
				<td style="width: 80px;"><div>${quality['2']}</div></td>
				<td style="width: 60px;"><div>${quality['3']}</div></td>
				<td><div>${quality['4']}</div></td>
			</tr>
		</c:forEach>
	</c:if>
	
	</tbody>
</table>
</c:if>


<!-- WET LAP -->
<c:if test="${type eq 'WL' }">
<table id="qualityDataTable" class="table" style="width: 900px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time</th>
			<th>Lot</th>
			<th>Brightness</th>
			<th>Grade</th>
			<th>Stickies</th>
			<th>Dirt</th>
			<th>Consistency</th>
			<th>Ash</th>
			<th>Freeness</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td colspan="11" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>
	
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
		<tr>
				<td><input type="radio" name="id" value="${quality['1']}"></td>
				<td style="width: 80px;"><div>${quality['2']}</div></td>
				<td style="width: 60px;"><div>${quality['3']}</div></td>
				<td style="width: 75px;"><div>${quality['4']}</div></td>
				<td style="width: 75px;"><div>${quality['5']}</div></td>
				<td style="width: 100px;"><div>${quality['6']}</div></td>
				<td style="width: 75px;"><div>${quality['7']}</div></td>
				<td style="width: 75px;"><div>${quality['8']}</div></td>
				<td style="width: 75px;"><div>${quality['9']}</div></td>
				<td style="width: 75px;"><div>${quality['10']}</div></td>
				<td style="width: 75px;"><div>${quality['11']}</div></td>
				<td style="width: 98%;"><div>${quality['12']}</div></td>
		</tr>
		
		</c:forEach>
	</c:if>
	
	</tbody>
	
</table>
</c:if>





<c:if test="${type eq 'SH' }">
<table  id="qualityDataTable" class="table" style="width: 950px;margin: auto;font-size: 12px;text-align:  center;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Grade</th>
			<th>Sludge Hauled<br> (lbs)</th>
			<th>Sludge<br> Consistency</th>
<!-- 			Code Starts From Here Done By Roshan Tailor Date : - 03/21/2016 -->
			<th>Effluent<br>Consistency</th>
<!-- 			Code ends Here Dne By Roshan Tailor Date ;- 03/21/2016 -->
			<th>Rejects Bunker<br> Waste Hauled<br> (Lbs)</th>
			<th>Rejects Bunker<br> Waste <br>Consistency</th>
			<th>FRP Sludge<br> Press Running</th>
			<th>FRP Screw<br> Press Running</th>	
			<th>COD<br>Discharge</th>	
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(sludgeHaulings) eq 0 }">
		<tr>
			<td colspan="9" align="center">
				Data not available for this selection.
			</td>
		</tr>
	</c:if>
	<c:if test="${fn:length(sludgeHaulings) gt 0 }">
		<c:forEach items="${sludgeHaulings}" var="sludgeHauling">
			<tr>
				<td><input type="radio" name="id" value="${sludgeHauling.id}"></td>
				
				<td style="width: 80px;padding: 2px;">
					<fmt:formatDate value="${sludgeHauling.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					${dateFrom}
				</td>
				<td style="width: 100px;">${grades[sludgeHauling.grade]}</td>
				<td style="width: 100px;padding: 2px;">${sludgeHauling.sludgeHauled}</td>
				<td style="width: 100px;padding: 2px;">${sludgeHauling.sludgeConsistency}</td>
<!-- 				Cocde Starts From Here Done By Roshan Tailor Date :- 03/21/2016 -->
				<td style="width: 100px;padding: 2px;">${sludgeHauling.effluentConsistency}</td>
<!-- 				Code Ends Here Done By Roshan Tailor Date :- 03/21/2016 -->
				<td style="width: 100px;padding: 2px;">${sludgeHauling.rejectsBwHauled}</td>
				<td style="width: 100px;padding: 2px;">${sludgeHauling.rejectsBwConsistency}</td>
				<td style="width: 100px;">${ynflags[sludgeHauling.frpSludgePressRunning]}</td>
				<td style="width: 100px;">${ynflags[sludgeHauling.frpScrewPressRunning]}</td>
				<td style="width: 100px;">${sludgeHauling.coddischarge}</td>
			</tr>
		</c:forEach>
	</c:if>
		
		
    </tbody>
</table>
</c:if>


</div>
			</div>

		</div>


	</div>

</body>
</html>
