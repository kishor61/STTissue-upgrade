<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<!--
<link href="../demoengine/demoengine.min.css" rel="stylesheet">
<script src="../demoengine/demoengine.min.js" defer></script>
 -->
<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/ui-darkness/jquery-ui.min.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>

<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/wastepaperreport/addtomaster" var="savewastepaperDataURL" />
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<!-- Code Starts From Here Done By Roshan Tailor Date:-06/20/2015 Night Shift-->
<!-- <script>
		$(function() {
			var date1 = new Date;
			date1.setHours(0, 0, 0, 0);
			date1.setDate(1);
			var date2 = new Date;
			date2.setHours(0, 0, 0, 0);
			date2.setDate(22);
			$('input[name=sdate],input[name=edate]').datepicker({
				dateFormat:'mm-dd-yy',
				changeMonth: true,
			    changeYear: true,
				beforeShowDay: function(date) {
					return [date < date1 || date > date2, ""];
				}
			});
		});
	</script> -->
<!-- 	Code Ends Here Done By Roshan Tailor Ends Here Date:-06/20/2015 Night Shift -->
<!-- Code Starts From Here Done By Roshan Tailor Date :- 06/09/2015 Night Shift-->
<script type="text/javascript">
var total = 0;
var total1=0;
$(function(){
    $('input:checkbox').click(function(event) {
        if($(this).is(':checked'))
        { 	
        	var parentTr = $(this).closest('tr');
        	parentTr.css('background-color', '#D8D8D8');
			var val1=$(this).parent().parent().parent().find('input[name=freightinvoiceno]').val();
			
        }
        else{
            var parentTr = $(this).closest('tr');
            parentTr.css('background-color', 'white');
            var val1=$(this).parent().parent().parent().find('input[name=freightinvoiceno]').val();
          
        }
        });
});
</script>
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

$(function(){
		$('#yielddatatable tbody input, #yielddatatable tbody input').focusin(doFocusIn);
		$('#yielddatatable tbody input, #yielddatatable tbody input').focusout(doFocusOut);	
		/* $('#yielddatatable tbody select, #yielddatatable tbody select').focusout(doFocusOut);	
		$('#yielddatatable tbody select, #yielddatatable tbody select').focusout(doFocusIn);	 */
		$('#yielddatatable select[name=destination]').focusin(doFocusIn);
		$('#yielddatatable select[name=destination]').focusout(doFocusOut);	
		//ntr.find('input').focusin(doFocusIn);
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){				
			if( (tb.attr('name')=='masterPO') | 
				(tb.attr('name')=='releaseNo') | 	
				(tb.attr('name')=='freightinvoiceno') | 
				(tb.attr('name')=='freightinvoiced') |
				(tb.attr('name')=='deduction') |
				(tb.attr('name')=='detentioncharges')|
				(tb.attr('name')=='destination') |
				(tb.attr('name')=='estimatedfreight') |
				(tb.attr('name')=='pricePerTon') |
				(tb.attr('name')=='gradeid') 
				){

			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				saveLock=true;
				return true;
			}
		}
		saveLock=false;
		return false;
	}
	function doFocusIn()
	{
		currentVal=$(this).val();
	}
	function doFocusOut()
	{
		if(validatePQ($(this)))
		{
			return;
		}
		
		if($(this).val()==currentVal)
		{
			return;
		}
		
		saveData($(this));
	  //The Above Code Will Call The saveData Method And Save Data Into Database
	}
	//Validate Code Ends Here Done By Roshan Tailor Date :- 04/21/2015
</script>
<script type="text/javascript">
function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');//This Returning Us Value Of Current Id And Helping Us For Update The Line 
	var date=tr.find('input[name=date]').val();
	var masterPO=tr.find('input[name=masterPO]').val();
	var releaseNo=tr.find('input[name=releaseNo]').val();
	var freightinvoiceno=tr.find('input[name=freightinvoiceno]').val();
	var freightinvoiced=tr.find('input[name=freightinvoiced]').val();
	var detentioncharges=tr.find('input[name=detentioncharges]').val();
	var deduction=tr.find('input[name=deduction]').val();
	var destination=tr.find('select[name=destination]').val();
	var estimatedfreight=tr.find('input[name=estimatedfreight]').val();
	var pricePerTon=tr.find('input[name=pricePerTon]').val();
	var gradeid=tr.find('input[name=gradeid]').val();
	
 	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${savewastepaperDataURL}',
		type:'POST',
		data:{
			id : id,
			date : date,
			masterPO : masterPO,
			releaseNo : releaseNo,
			freightinvoiceno : freightinvoiceno,
			freightinvoiced : freightinvoiced,
			detentioncharges : detentioncharges,
			deduction : deduction,
			destination : destination,
			estimatedfreight: estimatedfreight,
			pricePerTon : pricePerTon,
			gradeid : gradeid
		},
		
		success:function(data){
			
			idEle.val(data.id);//By This line Of Code We Are Geting Current Line Number OF <TD>
			$('#tmessage').text(data.message);
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
	
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	$('input:text').focus(
    function(){
        $(this).css({'background-color' : '#FFFFEE '});
    });

    $('input:text').blur(
    function(){
        $(this).css({'background-color' : '#DFD8D1'});
    });
    $('select').focus(
    	    function(){
    	        $(this).css({'background-color' : '#DFD8D1 '});
    	    });
});
</script>
<!-- Code Ends Here Done By Roshan Tailor Date :- 06/08/2015 Night Shift -->
<!-- Code Starts From Here Done By Roshan Tailor Date:- 07/03/2015 MM/DD/YYYY Night Shift-->
<spring:url value="/wastepaperreport" var="editEstimatedFriegt"/>
<script type="text/javascript">
$(function(){
		$('#freightBtn').click(function(){	
			var id=$('#yielddatatable tbody input[name=rowCheckbox]:checked').val();
			if(id=='' || typeof id ==='undefined'){
				alert("Please select the radio button.");
				return false;
			}
			if(id!='-1'){
				location.href='${editEstimatedFriegt}/editEstimatedFriegt/'+encodeURIComponent(id);
			}
			else if(typeof id ==='undefined'){
				alert('Select grade code.');
				return false;
			}	
		});
});
</script>
<script>
$(function(){
	$('#addfreightBtn').click(function(){	
		location.href='${editEstimatedFriegt}/addEstimatedFreightValue';
	});
});
//Below Code Is For To Hide The Search Section
	$(document).ready(function() {
		$("#singleSearch").click(function() {
			$("#table-selector").slideToggle("slow");
			 $("#table-selector1").show();
		});
	});
	
	$(document).ready(function() {
		$("#multipleSearch").click(function() {
			$("#table-selector").slideToggle("slow");
			 $("#table-selector1").hide();
		});
	});
	
</script>
<!-- Code Ends Here Done By Roshan Tailor Date :- 07/03/2015 MM/DD/YYYY Night Shift-->
<style type="text/css">
.table td{
text-align: center;
}
</style>
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
					<span class="label">ST Tissue - Wastepaper Detail Report</span>
				</div>
				<br>
				<div class="table-selector" id="table-selector">
				
				<spring:url value="/wastepaperreport/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get">	
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
								&nbsp;
								&nbsp;
								<c:if test="${viewFlagMultipleSearchData}">
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
								<!--Code Starts From Here Done By Roshan Tailor Date:- 06/08/2015 MM/DD/YYYY -->
									<!-- <input type="button" id="viewmaster" onclick="" value="View Master">
									<input type="button" id="transfertomaster" onclick="$('#transfertomaster').submit();" value="Transfer To Master">	 -->
								<!--Code Ends Here Done By Roshan Tailor Date :- 06/08/2015 MM/DD/YYYY -->
								<input type="button" id="freightBtn" value="Edit Estimated Freight">
								<input type="button" id="addfreightBtn" value="Add Estimated Freight">
								</c:if>
								
							</td>
							<td><input type="button" id="singleSearch" value="Single Search"></td>
						</tr>
					</table>
				</form>
				</div>
				<!--Code Starts From Here For Multiple Search Done By Roshan -->
				<c:if test="${viewFlagForSingleSearchBar}">
					<div class="table-selector" id="table-selector1" style="display: none;">
						<spring:url value="/wastepaperreport/viewSingleSearch" var="viewSingleSearch"/>
					<form name="dataForm" action="${viewSingleSearch }" method="get">	
						<table style="margin: auto;">
							<tr>
								<td>Release Number:</td>
								<td>
									<input type="text" name="releaseNumber" value="${releaseNumber}">							
								</td>
								</td>
								<td>
									<input id="viewDataBtn" type="submit" value="View">
								</td>
								<td><input type="button" id="multipleSearch" value="Multiple Search"></td>
							</tr>
						</table>
					</form>
					</div>
				</c:if>
				<!--Code Ends Here For Multiple Search Done By Roshan Tailor -->
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<c:if test="${viewFlagMultipleSearchData}">
<form id="exportFrom" action='<spring:url value="/wastepaperreport/export"/>' method="get" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<!-- Code Starts From Here Done By Roshan Tailor Date :- 06/08/2015 MM/DD/YYYY Night Shift -->
<form id="transfertomaster" action='<spring:url value="/wastepaperreport/transfertomaster"/>' method="get" style="display:none; ">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<!-- Code Ends Here Done By Roshan Tailor Date :-06/08/2015  -->

<table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td>&nbsp;</td>
			<td>MasterPO</td>
			<td>Release No</td>
			<td><div style="width: 150px;">Vandor Name</div></td>
			<td>Dropped Date</td>
			<td>Unloaded Date</td>
			<td><div style="width: 150px;">Item Description</div></td>
			<td>Bales</td>
			<td>Net  Tons</td>
			<td>$ Price Per Ton</td>
			<td>$ Extention</td>
			<td><div style="width: 150px;">Carrier</div></td>
			<td>Trailer No</td>
			<td><div style="width: 150px;">Shipping City</div></td>
			<td>Shipping State</td>
			<td>Estimated Freight</td>
			<td>Freight Invoice No</td>
			<td>Freight Invoiced $</td>
<!-- 		Code Starts From Here And Column Added By Roshan Tailor Date:- 06/04/2015 MM/DD/YYYY -->
			<td>Detention Charges</td>
<!-- 		Code Ends Here Done By Roshan Tailor Date:- 04/06/2015  -->
			<td>$ Freight CHBK</td>
<!-- 		The Below Column <Deduction> Is Added By Roshan Tailor,According To Recuirement Of Dinesh Sir -->
			<td><b style="color: red;">Deduction</b></td>
			<td>$ Grand Total</td>
			<td>Destination</td>
			<td>Comment</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${details}" var="wd">
			<tr>
				<!-- <td>
					<input type="radio" name="rowCheckbox" value="">
				</td> -->
				<td><input type="checkbox" name="rowCheckbox" value="${wd.id}"></td>
				<td>
					${wd.masterPO}
					<input type="hidden" value="${wd.masterPO}" name="masterPO">
				</td>
				<td>
					${wd.releaseNo}
					<input type="hidden" value="${wd.releaseNo}" name="releaseNo">
				</td>
				<td>
					${wd.vandorName}
					<input type="hidden" value="${wd.vandorName}" name="vandorName">	
				</td>
				<td>
					<fmt:formatDate value="${wd.droppedDate}" pattern="MM/dd/yyyy"/>
				</td>
				<td>
					<fmt:formatDate value="${wd.unloadedDate}" pattern="MM/dd/yyyy"/>
					<input type="hidden" value="${wd.unloadedDate}" name="unloadedDate">
				</td>
				<td>
					${wd.itemDescription}
					<input type="hidden" value="${wd.itemDescription}" name="itemDescription">
					<input type="hidden" value="${wd.gradeid}" name="gradeid">
				</td>
				<td>
					${wd.bales}
					<input type="hidden" value="${wd.bales}" name="bales">
				</td>
				<td>
					<fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/>
					<input type="hidden" value="${wd.netTons}" name="netTons">
				</td>
				<td>
					<input style="width: 43px; background-color: #E8E8AF;" type="text" value="${wd.pricePerTon}" name="pricePerTon"/>
					<input type="hidden" value="${wd.pricePerTon}" name="pricePerTon">
				</td>
				<td>
					<fmt:formatNumber value="${wd.extention}" maxFractionDigits="2" var="extention"/>
					${extention}
					<input type="hidden" value="${extention}" name="extention">
				</td>
				<td>
					${wd.carrier}
					<input type="hidden" value="${wd.carrier}" name="carrier">
				</td>
				<td>
					${wd.trailerNo}
					<input type="hidden" value="${wd.trailerNo}" name="trailerNo"> 
				</td>
				<td>
					${wd.shippingCity}
					<input type="hidden" value="${wd.shippingCity}" name="shippingCity">
				</td>
				<td>
					${wd.shippingState}
					<input type="hidden" value="${wd.shippingState}" name="shippingState">
				</td>
				<td>
					<%-- <input style="width: 43px;background-color: #E8E8AF;" type="text" value="${wd.estimatedFreight}" name="estimatedfreight"/>
					<input type="hidden" value="" name=""> --%>
					<fmt:formatNumber value="${wd.estimatedFreight}" maxFractionDigits="2" var="estimatedFreight"/>
					<input type="hidden" value="${estimatedFreight}" name="estimatedFreight"> 
					${estimatedFreight}
					
				</td>
				<td>
					<input style="width: 43px; background-color: #E8E8AF;" type="text" value="${wd.freightInvoiceNo}" name="freightinvoiceno"/>
					<input type="hidden" value="" name="freightinvoiceno">
				</td>
				<td>
					<input style="width: 43px; background-color: #E8E8AF;" type="text" value="${wd.freightInvoiced}" name="freightinvoiced">
					<input type="hidden" name="" value="freightinvoiced">
				</td>
<!-- 			Code Starts From Here And Text Box Added Too By Roshan Tailor Date:- 06/04/20115 -->
				<td>
					<input style="width: 43px;background-color: #E8E8AF;" type="text" value="${wd.detentionCharges}" name="detentioncharges">
					<input type="hidden" value="" name="detentioncharges">
				</td>
<!-- 			Code Ends Here Done By Roshan Tailor Date:- 06/04/2015 -->
				<c:if test ="${wd.freightCHBKPending eq'Pending'}">
				        <td>
							<%--<fmt:formatNumber value="${wd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>
							${freightCHBK}
							 <input type="hidden" value="${freightCHBK}" name="freightCHBK"> --%> 
							 Pending
						</td>
 				</c:if>
 				<c:if test ="${wd.freightCHBKPending ne 'Pending'}">
				        <td>
							<fmt:formatNumber value="${wd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>
							$(${freightCHBK})
							<input type="hidden" value="${freightCHBK}" name="freightCHBK">
						</td>
 				</c:if>
 				<td>
 					<input style="width: 43px;background-color: #E8E8AF;" type="text" value="${wd.deduction}" name="deduction">
 				</td>
				<td>
					<fmt:formatNumber value="${wd.grandTotal}" maxFractionDigits="2" var="grandTotal"/>
					<input type="hidden" value="${grandTotal}" name="grandTotal"> 
					${grandTotal}
				</td>
				<td>
					<select name="destination" style="background-color: #E8E8AF;">
						<option value="">Select</option>
						<c:forEach items="${destinations}" var="destinations">
								<c:choose>
									<c:when test="${destinations.key eq wd.destination}">
										<option value="${destinations.key}" selected="selected">${destinations.value}</option>
									</c:when>
									<c:otherwise>
										<option value="${destinations.key}">${destinations.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
				</td>
				<td>
					<div style="height: 50px;width: 500px;">${wd.comment}</div>
					<input type="hidden" value="${wd.comment}" name="comment">
				</td>	
			</tr>
			
		</c:forEach>
	</tbody>
</table>
</c:if>

<!-- Code Starts From Here For Single Search -->
<c:if test="${viewFlagForSingleSearchData}">
<form id="exportFrom" action='<spring:url value="/wastepaperreport/export"/>' method="get" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<!-- Code Starts From Here Done By Roshan Tailor Date :- 06/08/2015 MM/DD/YYYY Night Shift -->
<form id="transfertomaster" action='<spring:url value="/wastepaperreport/transfertomaster"/>' method="get" style="display:none; ">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<!-- Code Ends Here Done By Roshan Tailor Date :-06/08/2015  -->

<table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td>&nbsp;</td>
			<td>MasterPO</td>
			<td>Release No</td>
			<td><div style="width: 150px;">Vandor Name</div></td>
			<td>Dropped Date</td>
			<td>Unloaded Date</td>
			<td><div style="width: 150px;">Item Description</div></td>
			<td>Bales</td>
			<td>Net  Tons</td>
			<td>$ Price Per Ton</td>
			<td>$ Extention</td>
			<td><div style="width: 150px;">Carrier</div></td>
			<td>Trailer No</td>
			<td><div style="width: 150px;">Shipping City</div></td>
			<td>Shipping State</td>
			<td>Estimated Freight</td>
			<td>Freight Invoice No</td>
			<td>Freight Invoiced $</td>
<!-- 		Code Starts From Here And Column Added By Roshan Tailor Date:- 06/04/2015 MM/DD/YYYY -->
			<td>Detention Charges</td>
<!-- 		Code Ends Here Done By Roshan Tailor Date:- 04/06/2015  -->
			<td>$ Freight CHBK</td>
<!-- 		The Below Column <Deduction> Is Added By Roshan Tailor,According To Recuirement Of Dinesh Sir -->
			<td><b style="color: red;">Deduction</b></td>
			<td>$ Grand Total</td>
			<td>Destination</td>
			<td>Comment</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${details}" var="wd">
			<tr>
				<!-- <td>
					<input type="radio" name="rowCheckbox" value="">
				</td> -->
				<td><input type="checkbox" name="rowCheckbox" value="${wd.id}"></td>
				<td>
					${wd.masterPO}
					<input type="hidden" value="${wd.masterPO}" name="masterPO">
				</td>
				<td>
					${wd.releaseNo}
					<input type="hidden" value="${wd.releaseNo}" name="releaseNo">
				</td>
				<td>
					${wd.vandorName}
					<input type="hidden" value="${wd.vandorName}" name="vandorName">	
				</td>
				<td>
					<fmt:formatDate value="${wd.droppedDate}" pattern="MM/dd/yyyy"/>
				</td>
				<td>
					<fmt:formatDate value="${wd.unloadedDate}" pattern="MM/dd/yyyy"/>
					<input type="hidden" value="${wd.unloadedDate}" name="unloadedDate">
				</td>
				<td>
					${wd.itemDescription}
					<input type="hidden" value="${wd.itemDescription}" name="itemDescription">
					<input type="hidden" value="${wd.gradeid}" name="gradeid">
				</td>
				<td>
					${wd.bales}
					<input type="hidden" value="${wd.bales}" name="bales">
				</td>
				<td>
					<fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/>
					<input type="hidden" value="${wd.netTons}" name="netTons">
				</td>
				<td>
					<input style="width: 43px; background-color: #E8E8AF;" type="text" value="${wd.pricePerTon}" name="pricePerTon"/>
					<input type="hidden" value="${wd.pricePerTon}" name="pricePerTon">
				</td>
				<td>
					<fmt:formatNumber value="${wd.extention}" maxFractionDigits="2" var="extention"/>
					${extention}
					<input type="hidden" value="${extention}" name="extention">
				</td>
				<td>
					${wd.carrier}
					<input type="hidden" value="${wd.carrier}" name="carrier">
				</td>
				<td>
					${wd.trailerNo}
					<input type="hidden" value="${wd.trailerNo}" name="trailerNo"> 
				</td>
				<td>
					${wd.shippingCity}
					<input type="hidden" value="${wd.shippingCity}" name="shippingCity">
				</td>
				<td>
					${wd.shippingState}
					<input type="hidden" value="${wd.shippingState}" name="shippingState">
				</td>
				<td>
					<%-- <input style="width: 43px;background-color: #E8E8AF;" type="text" value="${wd.estimatedFreight}" name="estimatedfreight"/>
					<input type="hidden" value="" name=""> --%>
					<fmt:formatNumber value="${wd.estimatedFreight}" maxFractionDigits="2" var="estimatedFreight"/>
					<input type="hidden" value="${estimatedFreight}" name="estimatedFreight"> 
					${estimatedFreight}
					
				</td>
				<td>
					<input style="width: 43px; background-color: #E8E8AF;" type="text" value="${wd.freightInvoiceNo}" name="freightinvoiceno"/>
					<input type="hidden" value="" name="freightinvoiceno">
				</td>
				<td>
					<input style="width: 43px; background-color: #E8E8AF;" type="text" value="${wd.freightInvoiced}" name="freightinvoiced">
					<input type="hidden" name="" value="freightinvoiced">
				</td>
<!-- 			Code Starts From Here And Text Box Added Too By Roshan Tailor Date:- 06/04/20115 -->
				<td>
					<input style="width: 43px;background-color: #E8E8AF;" type="text" value="${wd.detentionCharges}" name="detentioncharges">
					<input type="hidden" value="" name="detentioncharges">
				</td>
<!-- 			Code Ends Here Done By Roshan Tailor Date:- 06/04/2015 -->
				<c:if test ="${wd.freightCHBKPending eq'Pending'}">
				        <td>
							<%--<fmt:formatNumber value="${wd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>
							${freightCHBK}
							 <input type="hidden" value="${freightCHBK}" name="freightCHBK"> --%> 
							 Pending
						</td>
 				</c:if>
 				<c:if test ="${wd.freightCHBKPending ne 'Pending'}">
				        <td>
							<fmt:formatNumber value="${wd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>
							$(${freightCHBK})
							<input type="hidden" value="${freightCHBK}" name="freightCHBK">
						</td>
 				</c:if>
 				<td>
 					<input style="width: 43px;background-color: #E8E8AF;" type="text" value="${wd.deduction}" name="deduction">
 				</td>
				<td>
					<fmt:formatNumber value="${wd.grandTotal}" maxFractionDigits="2" var="grandTotal"/>
					<input type="hidden" value="${grandTotal}" name="grandTotal"> 
					${grandTotal}
				</td>
				<td>
					<select name="destination" style="background-color: #E8E8AF;">
						<option value="">Select</option>
						<c:forEach items="${destinations}" var="destinations">
								<c:choose>
									<c:when test="${destinations.key eq wd.destination}">
										<option value="${destinations.key}" selected="selected">${destinations.value}</option>
									</c:when>
									<c:otherwise>
										<option value="${destinations.key}">${destinations.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
				</td>
				<td>
					<div style="height: 50px;width: 500px;">${wd.comment}</div>
					<input type="hidden" value="${wd.comment}" name="comment">
				</td>	
			</tr>
			
		</c:forEach>
	</tbody>
</table>
</c:if>
<!-- Code Ends Here For Single Search-->
</div>
			</div>

		</div>


	</div>

</body>
</html>
