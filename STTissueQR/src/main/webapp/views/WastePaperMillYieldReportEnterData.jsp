<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepapermillyieldreport/entermilldata/save" var="saveURL"/>
<spring:url value="/wastepapermillyieldreport/entermilldata/new" var="newTypeURL"/>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;


$(function(){
		$('input[name=sdate]').change(function(){
			var val=$(this).val();
			
			var otr = $('#qualityDataTable tbody tr:last');
			var odate=otr.find('input[name=sdate]').val();
			//var crew=otr.find('select[name=crew]').val();
			if(val!=''){
				location.href='${newTypeURL}/'+odate;
			}else{
				location.href='${newTypeURL}';
			}
			
		});
	});
</script>
<style type="text/css">
.button{
 text-decoration:none; 
 text-align:center; 
 padding:11px 32px; 
 border:solid 1px #004F72; 
 -webkit-border-radius:4px;
 -moz-border-radius:4px; 
 border-radius: 4px; 
 font:18px Arial, Helvetica, sans-serif; 
 font-weight:bold; 
 color:#E5FFFF; 
 background-color:#3BA4C7; 
 background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -ms-linear-gradient(top, #3BA4C7 0% ,#1982A5 100%); 
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 ); 
 background-image: linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);   
 -webkit-box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff; 
 -moz-box-shadow: 0px 0px 2px #bababa,  inset 0px 0px 1px #ffffff;  
 box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;  
  
  }
</style>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Waste Paper Mill Yield Data Entry</span>
				</div>
<form id="yieldFrom" action='<spring:url value="/wastepapermillyieldreport/entermilldata/detailedreport"/>' method="GET" style="display:none; " target="_blank">

</form>	
<form name="dataForm" action="${saveURL}" method="POST">	
				<div class="table-selector" style="background-color: rgba(142, 131, 24, 0.47);">
				<spring:url value="/wastepapermillyieldreport/view/data" var="viewURL"/>
				
					<table id="qualityDataTable" style="margin: auto;">
						<tbody>
						<tr>
							<td><b>Entry Date:</b></td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<%-- <td>
								<button onClick="window.location.href='<spring:url value="/wastepapermillyieldreport/entermilldata/detailedreport"/>'" value="Export">Entered Data For Yield Report</button>		
							</td> --%>
							<td>
								<input type="button" id="yielddetailed" onclick="$('#yieldFrom').submit();" value="Entered Data For Yield Report">
							</td>
						</tr>
						</tbody>
					</table>
				</div>
				
<center><p><b style="color: green;">${message}</b></p></center>				
<c:if test="${show}">
<c:if test="${fn:length(data) eq 0 }">
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<!-- <tr>
			<td style="width: 80px;background-color: rgb(142, 131, 24);"><b>Date</b></td>
		</tr> -->
		<tr>
			<td style="width: 80px;background-color: #6BB900;"><b>Pulper 3 Input</b></td>
			<td><b>Broke:</b></td>
			<td>
				<input type="hidden" value="" name="id">
				<input type="text" value="" name="broke" required="required">
			</td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td style="width: 80px;background-color: #B85700;"><b>SCA Virgin Pulp</b></td>
			<td><b>SCA Virgin Pulp:</b></td>
			<td><input type="text" value="" name="ScaVirginPulp" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td style="width: 80px;background-color: rgba(63, 55, 195, 0.48);"><b>Trim Loss</b></td>
			<td><b>Trim Loss:</b></td>
			<td><input type="text" value="" name="TrimLoss" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td style="width: 80px;background-color: rgba(0, 17, 197, 0.69);"><b>Mill Yield</b></td>
			<td><b>ST Bales WetLap:</b></td>
			<td><input type="text" value="" name="STBalesWetLap" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td  style="width: 80px;background-color: rgb(0, 162, 185);"><b>Pulper 4 Input</b></td>
			<td><b>CGWD:</b></td>
			<td><input type="text" value="" name="cgwd" required="required"></td>
			<td><b>CGWD Section:</b></td>
			<td><input type="text" value="" name="cgwdSection" required="required"></td>
			<td><b>SW:</b></td>
			<td><input type="text" value="" name="sw" required="required"></td>
			<td><b>White Bland:</b></td>
			<td><input type="text" value="" name="whiteBland" required="required"></td>
			<td><b>White Blend:</b></td>
			<td><input type="text" value="" name="whiteBlend" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td colspan="13" style="background-color: white;border: 0px;">
				<input class="button" type="Submit" value="Save" name="Submit">
			</td>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
</div>
</c:if>
<c:if test="${fn:length(data) gt 0 }">
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<!-- <tr>
			<td style="width: 80px;background-color: rgb(142, 131, 24);"><b>Date</b></td>
		</tr> -->
		<c:forEach items="${data}" var="data">
		
		<tr>
			
			<td style="width: 80px;background-color: #6BB900;"><b>Pulper 3 Input</b></td>
			<td><b>Broke:</b></td>
			<td>
				<input type="hidden" value="${data.id}" name="id">
				<input type="text" value="${data.yieldbroke}" name="broke" required="required">
			</td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td style="width: 80px;background-color: #B85700;"><b>SCA Virgin Pulp</b></td>
			<td><b>SCA Virgin Pulp:</b></td>
			<td><input type="text" value="${data.yieldscavirginpulp}" name="ScaVirginPulp" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td style="width: 80px;background-color: rgba(63, 55, 195, 0.48);"><b>Trim Loss</b></td>
			<td><b>Trim Loss:</b></td>
			<td><input type="text" value="${data.yieldtrimloss}" name="TrimLoss" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td style="width: 80px;background-color: rgba(0, 17, 197, 0.69);"><b>Mill Yield</b></td>
			<td><b>ST Bales WetLap:</b></td>
			<td><input type="text" value="${data.yieldstbaleswetLap}" name="STBalesWetLap" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		<tr>
			<td  style="width: 80px;background-color: rgb(0, 162, 185);"><b>Pulper 4 Input</b></td>
			<td><b>CGWD:</b></td>
			<td><input type="text" value="${data.yieldcgwd}" name="cgwd" required="required"></td>
			<td><b>CGWD Section:</b></td>
			<td><input type="text" value="${data.yieldcgwdsection}" name="cgwdSection" required="required"></td>
			<td><b>SW:</b></td>
			<td><input type="text" value="${data.yieldsw}" name="sw" required="required"></td>
			<td><b>White Bland:</b></td>
			<td><input type="text" value="${data.yieldwhitebland}" name="whiteBland" required="required"></td>
			<td><b>White Blend:</b></td>
			<td><input type="text" value="${data.yieldwhiteblend}" name="whiteBlend" required="required"></td>
		</tr>
		
		<tr><td style="background-color: white;border: 0px !important;"></td></tr>
		</c:forEach>
		<tr>
			<td colspan="13" style="background-color: white;border: 0px;">
				<c:if test="${fn:length(data) eq 0 }">
					<input class="button" type="Submit" value="Save" name="Submit">
				</c:if>
				<c:if test="${fn:length(data) gt 0 }">
					<input class="button" type="Submit" value="Edit" name="Submit">
				</c:if>
			</td>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
</div>
</c:if>
</c:if>
</form>
	</div>

		</div>


	</div>
</body>
</html>
