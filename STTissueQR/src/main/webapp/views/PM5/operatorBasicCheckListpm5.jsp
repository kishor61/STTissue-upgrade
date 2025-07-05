<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/operatorCareCheckListPM5/checkObcc" var="checkURL" />
<script type="text/javascript">
$(function(){
	 $('input[name=edate]').datepicker({
	dateFormat:'mm-dd-yy',
	changeMonth: true,
    changeYear: true,
    minDate:-1,
}); 


	$("input[type='checkbox']").on("change",function(){
	   if($(this).is(":checked"))
	      $(this).val("1");
	    else
	      $(this).val("0");
	});
	$("#backBtn").on("click",function(){
		$('input[name=edate]').datepicker('option', {minDate: -365})
	});
	$("input[type='checkbox']").each(function(){
		  		 
			if($(this).val()==1)
				{
				   this.checked = true;
				}
			else
				{
				
				}
		
			// alert( $(this).val());
		  
	});

	
});
 
	function operatorSelect(value)
	{
		var position  = $('#operator').val();
		var date = $('#edate').val();
		var operatorname = $('#operatorname').val();
		var crew  = $('#crew').val();
		var shift =$('#shift').val(); 
		//alert(operator);
		//alert(date);
		if(crew!='-1' && position!='-1')
		{
			$.ajax({
				url:'${checkURL}',
				type:'POST',
				data:{
					date :date,
					position:position,
					shift:shift
					
				},
				success:function(data){
					
					if(data.check){	
						
						if(position == 'R2')
						{
							location.href="./../r2operatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'WinderDown')
						{
							location.href="./../winderdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R1WaterJetsDown')
						{
							location.href="./../r1waterjetsdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R2WaterJetsDown')
						{
							location.href="./../r2waterjetsdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'stockoperator')
						{
							location.href="./../stockoperatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'leadoperator')
						{
							location.href="./../leadoperatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R1')
						{
							location.href="./../r1operatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'utilityoperator')
						{
							location.href="./../utilityOperatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
					}else
					{
						var entry=confirm("Entry Already Available Do you Want to Edit  Click OK  Cencle it");
						if(entry==true){
							if(position == 'R2')
							{
								location.href="./../r2operatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'WinderDown')
							{
								location.href="./../winderdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'R1WaterJetsDown')
							{
								location.href="./../r1waterjetsdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'R2WaterJetsDown')
							{
								location.href="./../r2waterjetsdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'stockoperator')
							{
								location.href="./../stockoperatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'leadoperator')
							{
								location.href="./../leadoperatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'R1')
							{
								location.href="./../r1operatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
							else if(position == 'utilityoperator')
							{
								location.href="./../utilityOperatorpm5/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
							}
						}
						else
							{  
							alert("You click on cencle proceed further")
						}
					}
				},
				error: function(xhr, status, error) {
					alert('Server error.. :-(' );
					
				}
			});
	
		}else
		{
			alert("Please Select the Crew or Position");
		}
		
}
</script> 
<style type="text/css">
/* Base styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
}

/* Form container styles */
.table-selector {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    padding: 20px;
    margin: 20px auto;
    max-width: 1400px;
}

/* Filter row styles */
.filter-row {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    margin-bottom: 20px;
    align-items: center;
}

.filter-group {
    display: flex;
    flex-direction: column;
    min-width: 200px;
    flex: 1;
}

.filter-label {
    font-weight: 600;
    margin-bottom: 5px;
    color: #333;
}

/* Input and select styles */
select, input[type="text"] {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    width: 100%;
    box-sizing: border-box;
    background-color: #fff;
    transition: border-color 0.3s ease;
}

select:focus, input[type="text"]:focus {
    border-color: #3BA4C7;
    outline: none;
    box-shadow: 0 0 0 2px rgba(59,164,199,0.2);
}

/* Button styles */
.btn {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
    text-align: center;
    display: inline-block;
}

.btn-success {
    background-color: #28a745;
    color: white;
}

.btn-success:hover {
    background-color: #218838;
}

.print-btn {
    background-color: #3BA4C7;
    color: white;
    padding: 10px 20px;
    border-radius: 4px;
    font-weight: 600;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.print-btn:hover {
    background-color: #1982A5;
}

/* Table styles */
.tg {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
    background-color: white;
}

.tg td {
    padding: 12px;
    border: 1px solid #ddd;
    vertical-align: middle;
}

.tg td h1, .tg td h2 {
    margin: 0;
    font-size: 16px;
    color: #333;
}

/* Radio button styles */
input[type="radio"] {
    margin-right: 5px;
}

/* Header styles */
.content-header h5 {
    color: #343e70;
    font-size: 20px;
    margin: 0;
    padding: 15px 0;
}

/* Message styles */
.message {
    display: block;
    text-align: center;
    padding: 10px;
    margin: 10px 0;
    background-color: #f8f9fa;
    border-radius: 4px;
}

/* Print specific styles */
@media print {
    .table-selector {
        box-shadow: none;
        border: none;
    }
    
    .tg {
        page-break-inside: avoid;
    }
    
    .no-print {
        display: none;
    }
}

/* Responsive adjustments */
@media (max-width: 768px) {
    .filter-row {
        flex-direction: column;
    }
    
    .filter-group {
        width: 100%;
    }
    
    .tg {
        font-size: 14px;
    }
    
    .tg td {
        padding: 8px;
    }
}
</style>
<script type="text/javascript">
	$(function(){
		// Consolidate print functionality into a single function
		function handlePrint() {
			// Check if the form content is visible
			if ($('#printDiv').is(':visible')) {
				// Store original styles
				var originalWidth = $('#tbbl').width();
				var originalFontSize = $('#tbbl td').css('fontSize');
				var originalH2FontSize = $('#tbbl td h2').css('fontSize');
				var originalSpanFontSize = $('#tbbl td span').css('fontSize');
				var originalMarginLeft = $("#checkpoint").css('marginLeft');

				// Apply print styles
				$('#tbbl').width(900);
				$('#tbbl td').css("fontSize", "25px");
				$('#tbbl td h2').css("fontSize", "25px");
				$('#tbbl td span').css("fontSize", "25px");
				$("#checkpoint").css({ marginLeft : "-284px"});
				$('#div_show').show();

				// Print and restore styles
				$('#printDiv').printArea({
					afterPrint: function() {
						// Restore original styles
						$('#tbbl').width(originalWidth);
						$('#tbbl td').css("fontSize", originalFontSize);
						$('#tbbl td h2').css("fontSize", originalH2FontSize);
						$('#tbbl td span').css("fontSize", originalSpanFontSize);
						$("#checkpoint").css({ marginLeft : originalMarginLeft });
						$('#div_show').hide();
					}
				});
			} else {
				alert("Please select an operator position first");
			}
		}

		// Attach the handler to both print buttons using class instead of ID
		$('.print-button').click(handlePrint);
	});
	
	function validateform()
	{
		$('#loadPage').show();
	}
	
	function funDate(){
		alert("You Can't Change Date. If you Want to Date Entry in Back Date Then Press Back Date Entry");
		document.getElementById("edate").disabled=true;
	}
</script>
<script type="text/javascript">
$(function(){
	$('#printBtn').click(function(){
		$('#tbbl td').css("fontSize", 25);
		$('#tbbl td h2').css("fontSize", 25);
		$('#tbbl td span').css("fontSize", 25);
		$('#printDiv').printArea();
	});
});
</script> 
<script type="text/javascript">
$(function(){
	$('#printBtn1').click(function(){
		$('#tbbl td').css("fontSize", 25);
		$('#tbbl td h2').css("fontSize", 25);
		$('#tbbl td span').css("fontSize", 25);
		$('#printDiv').printArea();
	});
});



/* onclick="location.href='<spring:url value="/operatorCareCheckListPM5/checkObcc/back"/>'" */

 
 
</script> 


</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">Operator Basic Care CheckList PM5</h5></div>

		<div class="block3" style="overflow: auto;">
		
		<c:if test="${data.position == 'operatorCare'}">	
			<spring:url value="/operatorCareCheckListPM5/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">
				<div class="table-selector">
					<div class="filter-row">
						<div class="filter-group">
							<span class="filter-label">Position:</span>
							<select name="position" id="operator">
								<option value="-1">Select Operator</option>
								<option value="leadoperator" ${data.position == 'leadoperator' ? 'selected' : ''}>LeadOperator</option>
								<option value="stockoperator" ${data.position == 'stockoperator' ? 'selected' : ''}>Stock Operator</option>
								<option value="R1" ${data.position == 'R1' ? 'selected' : ''}>R1Winder</option>
								<option value="R1WaterJetsDown" ${data.position == 'R1WaterJetsDown' ? 'selected' : ''}>R1WaterJets</option>
								<option value="R2" ${data.position == 'R2' ? 'selected' : ''}>R2Winder</option>
								<option value="R2WaterJetsDown" ${data.position == 'R2WaterJetsDown' ? 'selected' : ''}>R2WaterJets</option>
								<option value="utilityoperator" ${data.position == 'utilityoperator' ? 'selected' : ''}>Utility WaterJets</option>
								<option value="WinderDown" ${data.position == 'WinderDown' ? 'selected' : ''}>Utility Winder</option>
							</select>
						</div>
						
						<div class="filter-group">
							<span class="filter-label">Operator Name:</span>
							<input type="text" name="operatorname" value="${data.operatorname}" id="operatorname"/>
						</div>
						
						<div class="filter-group">
							<span class="filter-label">Date:</span>
							<input type="text" readonly name="edate" value="${data.edate}" id="edate">
						</div>
						
						<div class="filter-group">
							<span class="filter-label">Crew:</span>
							<select name="crew" id="crew">
								<option value="-1">Select Crew</option>
								<option value="A" ${data.crew == 'A' ? 'selected' : ''}>A</option>
								<option value="B" ${data.crew == 'B' ? 'selected' : ''}>B</option>
								<option value="C" ${data.crew == 'C' ? 'selected' : ''}>C</option>
								<option value="D" ${data.crew == 'D' ? 'selected' : ''}>D</option>
							</select>
						</div>
						
						<div class="filter-group">
							<span class="filter-label">Shift:</span>
							<select name="shift" onchange="operatorSelect(this.value);" id="shift">
								<option value="-1">Select Shift</option>
								<option value="day" ${data.shift == 'day' ? 'selected' : ''}>Day</option>
								<option value="night" ${data.shift == 'night' ? 'selected' : ''}>Night</option>
							</select>
						</div>
						
						<div class="action-buttons">
							<button type="button" class="print-btn print-button" onclick="return false;">Print</button>
						</div>
					</div>
				</div>
 			 <c:if test="${not empty message }">
 			  
				<span class="message"><center><h>${message}</h></center></span>
			 </c:if>
 
 <br/> <br/>  <br/>

 <c:if test="${data.position == 'R2'}">
   <div id="printDiv">
		 <center>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Basic Care CheckList</h1>
		 		</div>
		 		<div style="float: right;}">
		 			<span><b style="font-size: 15px;">R2 Operator : </b>${data.operatorname}</span>
		 		</div>
		 		<div style="float: right;    margin-right: -130px;">
		 		 <br/>
		 			<span><b style="font-size: 15px;">Date:</b>${data.edate}</span> &nbsp;&nbsp;&nbsp;
		 			<span><b style="font-size: 15px;">Shift:</b>${data.shift}</span> 
		 		</div>
		 	</div>	
				 <table border="1" class="tg" style="background-color: white;width: 800px;" id="tbbl">
						
						
						<tr>
						    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
						    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
						   
						</tr> 
						
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WINDER DECK STOPS</h2></td>
						     
						</tr> 
						  <tr>
						    <td class="tg-yw4l" >Movement </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="radio"  name="movementcol1" value="true" ${data.movementcol1 == 'true' ? 'checked' : ''}/> Yes <input type="radio"  name="movementcol1" value="false" ${data.movementcol1 == 'false' ? 'checked' : ''}/> No
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.movementcol1desc}" name="movementcol1desc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						  </tr>
						  <br />
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CONVEYOR</h2></td>
						     
						  </tr>
						 <tr>
						    <td class="tg-yw4l" > Chain Link/Pins  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.conveyorcol1 == 'true' ? 'checked' : ''} name="conveyorcol1"/> Yes 
						   		 <input type="radio" value="false" name="conveyorcol1" ${data.conveyorcol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.conveyorcol1desc}" name="conveyorcol1desc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Conveyor Sections</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.conveyorcol2 == 'true' ? 'checked' : ''} name="conveyorcol2"/> Yes 
						     <input type="radio" value="false" ${data.conveyorcol2 == 'false' ? 'checked' : ''} name="conveyorcol2"/>No   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" class="input" value="${data.conveyorcol2desc}" name="conveyorcol2desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Motor - Overheating</td>
						    <td class="tg-yw4l" style="text-align: center;">
						     <input type="radio" value="true" ${data.conveyorcol3 == 'true' ? 'checked' : ''} name="conveyorcol3"/>Yes 
						     <input type="radio" value="false"  ${data.conveyorcol3 == 'false' ? 'checked' : ''} name="conveyorcol3"/>No    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						     <input type="text" value="${data.conveyorcol3desc}"  class="input"name="conveyorcol3desc" placeholder="Remarks" style="margin-left: 66px;"/> 
						    </td>
						    
						  </tr>
						  
						    <tr>
						    <td class="tg-yw4l" >Motor - Abnormal Sound</td>
						       
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.conveyorcol4 == 'true' ? 'checked' : ''} name="conveyorcol4"/>Yes 
						    <input type="radio" value="false"  ${data.conveyorcol4 == 'false' ? 'checked' : ''} name="conveyorcol4"/>No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" value="${data.conveyorcol4desc}"  class="input"name="conveyorcol4desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						     
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >PLC Control Panel </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.conveyorcol5 == 'true' ? 'checked' : ''} name="conveyorcol5"/>Yes 
						    <input type="radio" value="false"  ${data.conveyorcol5 == 'false' ? 'checked' : ''} name="conveyorcol5"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" value="${data.conveyorcol5desc}" class="input" name="conveyorcol5desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    
						  </tr>
						  
						 
						   
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CORE SAW</h2></td>
						   
						  </tr>
						  <tr>
						    <td class="tg-yw4l"  >Power</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<input type="radio" value="true" ${data.powercol1 == 'true' ? 'checked' : ''} name="powercol1"/> ON  
						    	<input type="radio" value="false" ${data.powercol1 == 'false' ? 'checked' : ''} name="powercol1"/> OFF &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol1desc}" class="input" name="powercol1desc" placeholder="Remarks" style="margin-left: 58px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >Blade</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.powercol2 == 'true' ? 'checked' : ''} name="powercol2"/> Yes
						    	<input type="radio" value="false" ${data.powercol2 == 'false' ? 'checked' : ''} name="powercol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol2desc}" class="input" name="powercol2desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l">Vacuum</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.powercol3 == 'true' ? 'checked' : ''} name="powercol3"/> Yes
						    	<input type="radio" value="false" ${data.powercol3 == 'false' ? 'checked' : ''} name="powercol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol3desc}"  class="input" name="powercol3desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Size Adjustment Movement</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.powercol4 == 'true' ? 'checked' : ''} name="powercol4"/> Yes
						    	<input type="radio" value="false" ${data.powercol4 == 'false' ? 'checked' : ''} name="powercol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol4desc}" class="input" name="powercol4desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						   	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CORES</h2></td>
						   
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Correct Size For Order</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.ordercol1 == 'true' ? 'checked' : ''} name="ordercol1"/> Yes
						   <input type="radio" value="false" ${data.ordercol1 == 'false' ? 'checked' : ''} name="ordercol1"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   
						  <%--  <input type="checkbox" value="${data.ordercol1 eq 'true'?'1':'0'}" name="ordercol1"/> OK &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
						   <input type="text" value="${data.ordercol1desc}" class="input" name="ordercol1desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						 
						  <tr>
						  <!--  <td class="tg-yw4l"><input class="button" type="submit" value="Submit" name="Submit"/></td> -->
						  </tr>
				  </table>
		    </center>
		 </div>
		 	
			</div>
			  	
			 
			   <c:choose>
			    <c:when test="${edit == 'yes'}">
			       <div class="wrapper">
						<br /><br />
						<button type="button" class="print-btn print-button" onclick="return false;">Print</button>
						<button class="print-btn" type="submit">Edit</button>
					</div>
			    </c:when>
			  
			    <c:otherwise>
			        <div class="wrapper">
						<br /><br />
						<button type="button" class="print-btn print-button" onclick="return false;">Print</button>
						<button class="print-btn" type="submit">Submit</button>
					</div>
			    </c:otherwise>
			</c:choose>
			
 	</c:if>			
	  </form>	  

		</div>


	</div>

</body>
</html>
