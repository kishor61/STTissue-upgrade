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
   maxDate:-1
}); 
	 function funDate(){
			alert("You Can't Change Datae If you Want to  Date Entry in Back Date Then  Press Back Date Entry")
			document.getElementById("edate").disabled=true;}

	$("input[type='checkbox']").on("change",function(){
	   if($(this).is(":checked"))
	      $(this).val("1");
	    else
	      $(this).val("0");
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
						location.href="./../r2operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'stockoperator')
					{
						location.href="./../stockoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'leadoperator')
					{
						location.href="./../leadoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'R1')
					{
						location.href="./../r1operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'utilityoperator')
					{
						location.href="./../utilityOperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}							
					
				}else
				{
					var entry=confirm("Entry Already Available Do you Want to Edit  Click OK  Cencle it");
					if(entry==true){
						if(position == 'R2')
						{
							location.href="./../r2operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'stockoperator')
						{
							location.href="./../stockoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'leadoperator')
						{
							location.href="./../leadoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R1')
						{
							location.href="./../r1operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'utilityoperator')
						{
							location.href="./../utilityOperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
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
  .wrapper {
    text-align: center;
}
.input{
margin-left: 66px;
float: right;
height: 19px;
width: 240px;
}

 
</style>
<script type="text/javascript">
	$(function(){
		var wid = 900;
		$('#printBtn').click(function(){
			$('#tbbl').width(wid)
			$("#checkpoint").css( { marginLeft : "-284px"} );
			$('#div_show').show();
			$('#printDiv').printArea();
			$('#tbbl').width(800)
			$("#checkpoint").css( { marginLeft : "-356px" } );
			$('#div_show').hide();
		});
	});
	
	function validateform()
	{
		$('#loadPage').show();
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
</script> 

</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
<div id="printDiv">	
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div class="content-header" style=" padding-top: 10px !important; padding-bottom: 0px !important; line-height: 0px !important;">
			<h5 style="text-align:center; font-weight:bold;color:#2189b9;">Operator Basic Care CheckList PM5</h5>
		</div>

		<div class="block3" style="overflow: auto;">
			<c:if test="${data.position == 'leadoperator'}">	
						<spring:url value="/leadoperatorpm5/save" var="viewURL"/>
			</c:if>
		<form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
					<div class="pageContent">
						<div class="table-selector" style="background-color:#2189b9 !important; border: 1px solid #7e00ff42;">
								
			 <input type="hidden" name="id" value="${data.id}"> 
	
					<table style="margin: auto;">
						<tr>
							<td> Position:</td>
							 <td style="width:20%;">
								 <select style="width: 100%;" name="position" id="operator">
								    <option value="-1">Select Operator</option>
								 	<option value="leadoperator" ${data.position == 'leadoperator' ? 'selected' : ''}>LeadOperator</option>
								 	<option value="stockoperator" ${data.position == 'stockoperator' ? 'selected' : ''}>Stock Operator</option>								 	
								 	<option value="R1" ${data.position == 'R1' ? 'selected' : ''}>R1Winder</option>
								 	<option value="R1WaterJetsDown" ${data.position == 'R1WaterJetsDown' ? 'selected' : ''}>R1WaterJets </option>								 	
								 	<option value="R2" ${data.position == 'R2' ? 'selected' : ''}>R2Winder </option>
								 	<option value="R2WaterJetsDown" ${data.position == 'R2WaterJetsDown' ? 'selected' : ''}>R2WaterJets</option>
								 	<option value="utilityoperator" ${data.position == 'utilityoperator' ? 'selected' : ''}>Utility WaterJets </option>								 	
								 	<option value="WinderDown" ${data.position == 'WinderDown' ? 'selected' : ''}>Utility Winder</option>
								 	
								 </select>							
							</td>  
							<td> Operator Name:</td>
							<td style="width:20%;">
								  <input type="text" name="operatorName" value="${data.operatorName}" id="operatorname"/>						
							</td>
							 
							<td> Date:</td>
							  <td style="width:20%;">
								<input type="text" readonly name="edate" value="${data.edate}" id="edate"  ">							
							</td>
							
							<td> Crew:</td>
							<td style="width:10%;">
								 <select style="width: 100%;" name="crew" id="crew">
								    <option value="-1">Select Crew</option>
								 	<option value="A" ${data.crew == 'A' ? 'selected' : ''}>A</option>
								 	<option value="B" ${data.crew == 'B' ? 'selected' : ''}>B</option>
								 	<option value="C" ${data.crew == 'C' ? 'selected' : ''}>C</option>
								 	<option value="D" ${data.crew == 'D' ? 'selected' : ''}>D</option>
								 
								 </select>							
							</td>
							<td> Shift:</td>
							<td style="width:10%;">
								 <select style="width: 100%;" name="shift" onchange="operatorSelect(this.value);" id="shift">
								    <option value="-1">Select Shift</option>
								 	<option value="day" ${data.shift == 'day' ? 'selected' : ''}>Day</option>
								 	<option value="night" ${data.shift == 'night' ? 'selected' : ''}>Night</option>
								 	 
								 
								 </select>							
							</td> 
							<td>
								<button type="button" id="printBtn" class="btn btn-success btn-sm">Print</button>
								<a href="../operatorCareCheckListPM5/checkObcc/back"><button  type="button" class="btn btn-success btn-sm">Backdated Entry
																							</button></a>
							</td>
	 					</tr>
					</table>
					 
				</div>
 			 <c:if test="${not empty message }">
				<h3 style="font-size: 21px;color:#07f533;text-align: center;"><span class="message">${message}</span></h3>
			 </c:if>
 
 <br/> <br/>  <br/>    
 <center> 
		 <c:if test="${data.shift == 'day'}">
		   <h1 style="font-size: 21px;color: #518f3e;">Day Shift Form</h1>
		 </c:if> 
		 <c:if test="${data.shift == 'night'}">
		   <h1 style="font-size: 21px;color: #518f3e;">Night Shift Form</h1>
		 </c:if> 
		 <h1 style="font-size: 21px;color:#f5070b;text-align: center;">Machine Down
		 									  <input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
		 									   <input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 	</h1></br>
		 				<div style="float: left;    margin-left: 15%;">
		 		 			<span><b style="font-size: 15px;">R1 Operator : </b>${data.operatorName}</span> &nbsp;&nbsp;&nbsp;
		 		 		
		 		 			<span><b style="font-size: 15px;">Date:</b>${data.edate}</span> &nbsp;&nbsp;&nbsp;
		 		 			<span><b style="font-size: 15px;">Shift:</b>${data.shift}</span> 
						
						</div>
		 				
					
				 <table border="1" class="tg" style="background-color: white; width:70%;" id="tbbl">
						
						
						<tr style="text-align: center;background-color:#2189b9 !important;" >
						    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
						    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
						   
						</tr> 
						
					 <c:if test="${data.shift == 'day'}"> 	
						
						
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Forming Section</h2></td>
						     
						</tr> 
						  <tr>
						    <td class="tg-yw4l" >Verify Fabric Tension </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <input type="text" class="input" value="${data.formatingsectioncol1}" placeholder="" name="formatingsectioncol1" style="margin-left: 1px !important;float: none;"/>
						    	
							    <input type="text" class="input" value="${data.formatingsectioncol1Desc}" name="formatingsectioncol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >High pressure wire shower</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <input type="text" class="input" value="${data.formatingsectioncol2}" placeholder="" name="formatingsectioncol2" style="margin-left: 1px !important;float: none;"/>
						    	
							    <input type="text" class="input" value="${data.formatingsectioncol2Desc}" name="formatingsectioncol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" > Supply Air</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		 <input type="text" class="input" value="${data.formatingsectioncol3}" placeholder="" name="formatingsectioncol3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.formatingsectioncol3Desc}" name="formatingsectioncol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  						  
						   <tr>
						    <td class="tg-yw4l" > Wire guide diagram </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   	<input type="text" class="input" value="${data.formatingsectioncol4}" placeholder="" name="formatingsectioncol4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   	 <input type="text"class="input" value="${data.formatingsectioncol4Desc}" name="formatingsectioncol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						    <tr>
						    <td class="tg-yw4l" >Counter Balance</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.formatingsectioncol5}" placeholder="" name="formatingsectioncol5" style="margin-left: 1px !important;float: none;"/>
						    	
							   
							    <input type="text" class="input" value="${data.formatingsectioncol5Desc}" name="formatingsectioncol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						   
						    <tr>
						    <td class="tg-yw4l" >Tension</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.formatingsectioncol6}" placeholder="" name="formatingsectioncol6" style="margin-left: 1px !important;float: none;"/>
						    	
							  
							    <input type="text" class="input" value="${data.formatingsectioncol6Desc}" name="formatingsectioncol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l" >Tension Roll Counter wieght</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.formatingsectioncol7}" placeholder="" name="formatingsectioncol7" style="margin-left: 1px !important;float: none;"/>
						    	
							   
							    <input type="text" class="input" value="${data.formatingsectioncol7Desc}" name="formatingsectioncol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  	
						     
						  <br />
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Couch Roll</h2></td>
						     
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Primary Holder Loading</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.couchrollcol1}" placeholder="" name="couchrollcol1" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.couchrollcol1Desc}" name="couchrollcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Secondary Holder Loading</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.couchrollcol2}" placeholder="" name="couchrollcol2" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.couchrollcol2Desc}" name="couchrollcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   
						  
						 <tr>
						    <td class="tg-yw4l" >Breast Roll Loading</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.couchrollcol3}" placeholder="" name="couchrollcol3" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.couchrollcol3Desc}" name="couchrollcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Breast Roll edges clean</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.couchrollcol4}" placeholder="" name="couchrollcol4" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.couchrollcol4Desc}" name="couchrollcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Breast Roll Shower</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	PSI<input type="text"  value="${data.couchrollcol5}" placeholder="" name="couchrollcol5" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.couchrollcol5Desc}" name="couchrollcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Head Box Blanced</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="radio" value="true" ${data.couchrollcol6 == 'true' ? 'checked' : ''} name="couchrollcol6"/> Yes  
						    	<input type="radio" value="false" ${data.couchrollcol6 == 'false' ? 'checked' : ''} name="couchrollcol6"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.couchrollcol6Desc}" name="couchrollcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >Trim Squared Working Properly</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="radio" value="true" ${data.couchrollcol7 == 'true' ? 'checked' : ''} name="couchrollcol7"/> Yes  
						    	<input type="radio" value="false" ${data.couchrollcol7 == 'false' ? 'checked' : ''} name="couchrollcol7"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.couchrollcol7Desc}" name="couchrollcol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						    --%>
				
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Pick Up Felt Guide</h2></td>
						   
						  </tr>
						 <tr>
						    <td class="tg-yw4l" > Supply Air</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.picupfeltguidecol1}" placeholder="" name="picupfeltguidecol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.picupfeltguidecol1Desc}" name="picupfeltguidecol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						 <tr>
						    <td class="tg-yw4l" > Diaphragm</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.picupfeltguidecol2}" placeholder="" name="picupfeltguidecol2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.picupfeltguidecol2Desc}" name="picupfeltguidecol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" > Pick Up Roll Holder</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.picupfeltguidecol3}" placeholder="" name="picupfeltguidecol3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.picupfeltguidecol3Desc}" name="picupfeltguidecol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  
						 <tr>
						    <td class="tg-yw4l" > Couch Roll Holder</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.picupfeltguidecol4}" placeholder="" name="picupfeltguidecol4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.picupfeltguidecol4Desc}" name="picupfeltguidecol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>

						 
						   	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Suction Pressure Roll</h2></td>
						   
						  </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l" > Lubrication Showers</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.suctionpressurerollcol1}" placeholder="" name="suctionpressurerollcol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.suctionpressurerollcol1Desc}" name="suctionpressurerollcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 
						   <tr>
						    <td class="tg-yw4l" > Suction Box Position</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.suctionpressurerollcol2}" placeholder="" name="suctionpressurerollcol2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.suctionpressurerollcol2Desc}" name="suctionpressurerollcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 <%-- 
					 <tr>
						    <td class="tg-yw4l" >SPR Loading</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.suctionpressurerollcol3}" placeholder="" name="suctionpressurerollcol3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.suctionpressurerollcol3Desc}" name="suctionpressurerollcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" > Air pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.suctionpressurerollcol4}" placeholder="" name="suctionpressurerollcol4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.suctionpressurerollcol4Desc}" name="suctionpressurerollcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 <tr>
						    <td class="tg-yw4l" >vacuum</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <input type="text" class="input" value="${data.suctionpressurerollcol5}" placeholder="" name="suctionpressurerollcol5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.suctionpressurerollcol5Desc}" name="suctionpressurerollcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
					 
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Yankee Dryer </h2></td>
						   
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Skinng Doctor Loading</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <input type="text" class="input" value="${data.yankeedryerCol1}" placeholder=" " name="yankeedryerCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.yankeedryerCol1Desc}" name="yankeedryerCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >Crepring Doctor Loading</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.yankeedryerCol2}" placeholder=" " name="yankeedryerCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.yankeedryerCol2Desc}" name="yankeedryerCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >yankee Pressure </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <input type="text" class="input" value="${data.yankeedryerCol3}" placeholder=" " name="yankeedryerCol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.yankeedryerCol3Desc}" name="yankeedryerCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						    <tr>
						    <td class="tg-yw4l" >Yankee Diffrence Pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.yankeedryerCol4}" placeholder=" " name="yankeedryerCol4" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.yankeedryerCol4Desc}" name="yankeedryerCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  --%>
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Press Felt Area </h2></td>
						   
						  </tr>
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >Uhle Box Vacuum</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.pressfeltareacol1}" placeholder=" " name="pressfeltareacol1" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.pressfeltareacol1Desc}" name="pressfeltareacol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  --%>
						    <tr>
						    <td class="tg-yw4l" >Verify Shower Oscillation</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="radio" value="true" ${data.pressfeltareacol2 == 'true' ? 'checked' : ''} name="pressfeltareacol2"/> Yes  
						    	<input type="radio" value="false" ${data.pressfeltareacol2 == 'false' ? 'checked' : ''} name="pressfeltareacol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.pressfeltareacol2Desc}" name="pressfeltareacol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   </tr>
						   <%-- 
						   <tr>
						    <td class="tg-yw4l" >verify Felt Guide Paddle Position</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.pressfeltareacol3}" placeholder=" " name="pressfeltareacol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.pressfeltareacol3Desc}" name="pressfeltareacol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  --%>
						   </tr>
						   <tr>
						    <td class="tg-yw4l" >Uhle Box Cleanness</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.pressfeltareacol4}" placeholder=" " name="pressfeltareacol4" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.pressfeltareacol4Desc}" name="pressfeltareacol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>						  
						 
						  <tr>
						    <td class="tg-yw4l" > Felt Passivator Nozzels Supplying</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.pressfeltareacol5}" placeholder=" " name="pressfeltareacol5" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.pressfeltareacol5Desc}" name="pressfeltareacol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Uhle Box Lubrication Shower</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.pressfeltareacol6}" placeholder=" " name="pressfeltareacol6" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.pressfeltareacol6Desc}" name="pressfeltareacol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Felt High Pressure Shower</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.pressfeltareacol7}" placeholder=" " name="pressfeltareacol7" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.pressfeltareacol7Desc}" name="pressfeltareacol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Lube oil System </h2></td>
						   
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Lube Oil Temp</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol1}" placeholder=" " name="lubeoilsystemcol1" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol1Desc}" name="lubeoilsystemcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  
						   </tr>
						   </tr>
						   <tr>
						    <td class="tg-yw4l" >Lube Oil Feed</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol2}" placeholder=" " name="lubeoilsystemcol2" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol2Desc}" name="lubeoilsystemcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  
						   </tr>
						   <tr>
						    <td class="tg-yw4l" >Lube Oil Line</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol3}" placeholder=" " name="lubeoilsystemcol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol3Desc}" name="lubeoilsystemcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   </tr>
						   <tr>
						    <td class="tg-yw4l" >Lube Oil Tank Temp</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol4}" placeholder=" " name="lubeoilsystemcol4" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol4Desc}" name="lubeoilsystemcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   </tr>
						   <tr>
						    <td class="tg-yw4l" >Zero Spd Pressure SetPoint</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol5}" placeholder=" " name="lubeoilsystemcol5" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol5Desc}" name="lubeoilsystemcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   </tr>
						   <tr>
						    <td class="tg-yw4l" >Low Spd Pressure SetPoint</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol6}" placeholder=" " name="lubeoilsystemcol6" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol6Desc}" name="lubeoilsystemcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >High Spd Pressure SetPoint</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="text" class="input" value="${data.lubeoilsystemcol7}" placeholder=" " name="lubeoilsystemcol7" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubeoilsystemcol7Desc}" name="lubeoilsystemcol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>F5 ABB ACCURAY </h2></td>
						   
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Blow air and Clean up Top and Bot</br> 
						    window sensors BW &HPIR Moisture</td>
						    <td class="tg-yw4l" style="text-align: center;">					    	
						    	<input type="radio" value="true" ${data.f5abbaccuraycol1 == 'true' ? 'checked' : ''} name="f5abbaccuraycol1"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol1 == 'false' ? 'checked' : ''} name="f5abbaccuraycol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol1Desc}" class="input" name="f5abbaccuraycol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						 </tr>
						  <tr>
						    <td class="tg-yw4l"  >Blow air and Clean up Top Window</br>
						    both Side edge Sensor</td>
							 <td class="tg-yw4l" style="text-align: center;">
							   	<input type="radio" value="true" ${data.f5abbaccuraycol2 == 'true' ? 'checked' : ''} name="f5abbaccuraycol2"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol2 == 'false' ? 'checked' : ''} name="f5abbaccuraycol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol2Desc}" class="input" name="f5abbaccuraycol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						  <%-- <tr>
						    <td class="tg-yw4l"  >Scanner Cooling Blower Mesh and</br>
						    Filter take off and put Backk</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.f5abbaccuraycol3 == 'true' ? 'checked' : ''} name="f5abbaccuraycol3"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol3 == 'false' ? 'checked' : ''} name="sf5abbaccuraycol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol3Desc}" class="input" name="f5abbaccuraycol3Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						 </tr> 
						 
						 
						 
						  <tr>
						   <td class="tg-yw4l"  >Scanner Cooling Blower Mesh and</br>
						    Filter take off and put Backk</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
			
						    	<input type="radio" value="true" ${data.f5abbaccuraycol3 == 'true' ? 'checked' : ''} name="f5abbaccuraycol3"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol3 == 'false' ? 'checked' : ''} name="f5abbaccuraycol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol3Desc}" class="input" name="f5abbaccuraycol3Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 --%>
						  <tr>
						    <td class="tg-yw4l"  >Scanner Air Supply Regular </br>
						    Gauge Pressure PSI 1</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
			
						    	<input type="radio" value="true" ${data.f5abbaccuraycol4 == 'true' ? 'checked' : ''} name="f5abbaccuraycol4"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol4 == 'false' ? 'checked' : ''} name="f5abbaccuraycol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol4Desc}" class="input" name="f5abbaccuraycol4Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						  <tr>
						    <td class="tg-yw4l"  >Scanner Air Supply Regular Gauge</br>
						    Pressure PSI 2</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<input type="radio" value="true" ${data.f5abbaccuraycol5 == 'true' ? 'checked' : ''} name="f5abbaccuraycol5"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol5 == 'false' ? 'checked' : ''} name="f5abbaccuraycol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol5Desc}" class="input" name="f5abbaccuraycol5Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 <%-- 
						  <tr>
						    <td class="tg-yw4l"  >Cooling Blower Mesh Change Every Week</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.f5abbaccuraycol6 == 'true' ? 'checked' : ''} name="f5abbaccuraycol6"/> Yes  
						    	<input type="radio" value="false" ${data.f5abbaccuraycol6 == 'false' ? 'checked' : ''} name="f5abbaccuraycol6"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.f5abbaccuraycol6Desc}" class="input" name="f5abbaccuraycol6Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						   --%>
						</c:if>
						
						 <c:if test="${data.shift == 'night'}"> 
	 						
	 						 <tr>
						   			 <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Shower Water System </h2></td>
							</tr> 
							<%-- 
							<tr>
						    <td class="tg-yw4l" >Warm Water Tank Level</td>
						    <td class="tg-yw4l" style="text-align: center;">						    						        
						    	<input type="text" class="input" value="${data.showerwaterSystemcol1}" placeholder=" " name="showerwaterSystemcol1" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.showerwaterSystemcol1Desc}" name="showerwaterSystemcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   --%>					  
						   <tr>
						    <td class="tg-yw4l" >Warm Water Tank Pump </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		  Inbound:<input type="text" class="input" value="${data.showerwaterSystemcolin2}" placeholder="" name="showerwaterSystemcolin2" style="margin-left: 3px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.showerwaterSystemcolout2}" placeholder=" " name="showerwaterSystemcolout2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.showerwaterSystemcol2Desc}" name="showerwaterSystemcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						    <tr>
						    <td class="tg-yw4l" >Warm Water Tank Motor Temp </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		  Inbound:<input type="text" class="input" value="${data.showerwaterSystemcolin3}" placeholder="" name="showerwaterSystemcolin3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.showerwaterSystemcolout3}" placeholder=" " name="showerwaterSystemcolout3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.showerwaterSystemcol3Desc}" name="showerwaterSystemcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						  <tr>
						    <td class="tg-yw4l" >High Pressure Shower Pump </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Abnormal Sound </span> 						        
						    	<input type="radio" value="true" ${data.showerwaterSystemcol4== 'true' ? 'checked' : ''} name="showerwaterSystemcol4"/> Yes  
						    	<input type="radio" value="false" ${data.showerwaterSystemcol4== 'false' ? 'checked' : ''} name="showerwaterSystemcol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.showerwaterSystemcol4Desc}" name="showerwaterSystemcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						   </tr>		
						    <tr>
						    <td class="tg-yw4l" >High Pressure Shower Pressure Motor Temp </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		  Inbound:<input type="text" class="input" value="${data.showerwaterSystemcolin5}" placeholder="" name="showerwaterSystemcolin5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.showerwaterSystemcolout5}" placeholder=" " name="showerwaterSystemcolout5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.showerwaterSystemcol5Desc}" name="showerwaterSystemcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>							  
						  <tr>
						    <td class="tg-yw4l" >High Pressure Shower Pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>PSIG </span>					        
						    	<input type="text" class="input" value="${data.showerwaterSystemcol6}" placeholder=" " name="showerwaterSystemcol6" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.showerwaterSystemcol6Desc}" name="showerwaterSystemcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>						  
						   <tr>
						    <td class="tg-yw4l" >Press Hp Shower Press </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>PSIG</span>					        
						    	<input type="text" class="input" value="${data.showerwaterSystemcol7}" placeholder=" " name="showerwaterSystemcol7" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.showerwaterSystemcol7Desc}" name="showerwaterSystemcol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						    <tr>
						    <td class="tg-yw4l" >Machine Shower Booster Pump Motor Temp </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		  Inbound:<input type="text" class="input" value="${data.showerwaterSystemcolin8}" placeholder="" name="showerwaterSystemcolin8" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.showerwaterSystemcolout8}" placeholder=" " name="showerwaterSystemcolout8" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.showerwaterSystemcol8Desc}" name="showerwaterSystemcol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>							  
						   <tr>
						    <td class="tg-yw4l" >Machine Shower Booster Pump </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Abnormal Sound </span> 						        
						    	<input type="radio" value="true" ${data.showerwaterSystemcol9== 'true' ? 'checked' : ''} name="showerwaterSystemcol9"/> Yes  
						    	<input type="radio" value="false" ${data.showerwaterSystemcol9== 'false' ? 'checked' : ''} name="showerwaterSystemcol9"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.showerwaterSystemcol9Desc}" name="showerwaterSystemcol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  				
							<tr>
						    <td class="tg-yw4l" >Fresh Water Pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">						    						        
						    	<input type="text" class="input" value="${data.showerwaterSystemcol10}" placeholder=" " name="showerwaterSystemcol10" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.showerwaterSystemcol10Desc}" name="showerwaterSystemcol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	<%-- 				
							<tr>
						    <td class="tg-yw4l" >Fresh Water </td>
						    <td class="tg-yw4l" style="text-align: center;">						    						        
						    	<input type="text" class="input" value="${data.showerwaterSystemcol11}" placeholder=" " name="showerwaterSystemcol11" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.showerwaterSystemcol11Desc}" name="showerwaterSystemcol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   --%>
						   <tr>
						   			<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Fan Pump</h2></td>
						   </tr> 
						  
						  	<tr>
						    <td class="tg-yw4l" >Fan Pump Sealing Water </td>
						    <td class="tg-yw4l" style="text-align: center;">						    						        
						    	<input type="text" class="input" value="${data.fanpumpcol1}" placeholder=" " name="fanpumpcol1" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.fanpumpcol1Desc}" name="fanpumpcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						    <tr>
						    <td class="tg-yw4l" >Fan Pump Motor Temp</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		  Inbound:<input type="text" class="input" value="${data.fanpumpcolin2}" placeholder="" name="fanpumpcolin2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.fanpumpcolout2}" placeholder=" " name="fanpumpcolout2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.fanpumpcol2Desc}" name="fanpumpcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >Fan Pump  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Abnormal Sound </span> 						        
						    	<input type="radio" value="true" ${data.fanpumpcol3== 'true' ? 'checked' : ''} name="fanpumpcol3"/> Yes  
						    	<input type="radio" value="false" ${data.fanpumpcol3== 'false' ? 'checked' : ''} name="fanpumpcol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.fanpumpcol3Desc}" name="fanpumpcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						  <tr>
						   			<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Primary Thin Stock Screen</h2></td>
						  </tr> 
						    <tr>
						    <td class="tg-yw4l" >Primary Thin Stock Screen  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Seal Water</span>					        
						    	<input type="text" class="input" value="${data.primarythinstockscreencol1}" placeholder=" " name="primarythinstockscreencol1" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.primarythinstockscreencol1Desc}" name="primarythinstockscreencol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						    <tr>
						    <td class="tg-yw4l" >Primary Screen Reject Value </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Position</span>					        
						    	<input type="text" class="input" value="${data.primarythinstockscreencol2}" placeholder=" " name="primarythinstockscreencol2" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.primarythinstockscreencol2Desc}" name="primarythinstockscreencol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	<%-- 
						   <tr>
						    <td class="tg-yw4l" >Primary Thin Stock Screen </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Position</span>					        
						    	<input type="text" class="input" value="${data.primarythinstockscreencol3}" placeholder=" " name="primarythinstockscreencol3" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.primarythinstockscreencol3Desc}" name="primarythinstockscreencol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	 --%>
						    <tr>
						    <td class="tg-yw4l" >Primary Thin Stock Screen Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Abnormal Sound </span> 						        
						    	<input type="radio" value="true" ${data.primarythinstockscreencol4== 'true' ? 'checked' : ''} name="primarythinstockscreencol4"/> Yes  
						    	<input type="radio" value="false" ${data.primarythinstockscreencol4== 'false' ? 'checked' : ''} name="primarythinstockscreencol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.primarythinstockscreencol4Desc}" name="primarythinstockscreencol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
							 <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump</h2></td>
						   </tr> 	
						    <tr>
						    <td class="tg-yw4l" >Vacuum Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Abnormal Sound </span> 						        
						    	<input type="radio" value="true" ${data.vacuumpumpcol1== 'true' ? 'checked' : ''} name="vacuumpumpcol1"/> Yes  
						    	<input type="radio" value="false" ${data.vacuumpumpcol1== 'false' ? 'checked' : ''} name="vacuumpumpcol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.vacuumpumpcol1Desc}" name="vacuumpumpcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Motor Temp</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		  Inbound:<input type="text" class="input" value="${data.vacuumpumpcolin2}" placeholder="" name="vacuumpumpcolin2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.vacuumpumpcolout2}" placeholder=" " name="vacuumpumpcolout2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.vacuumpumpcol2Desc}" name="vacuumpumpcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						    <tr>
						    <td class="tg-yw4l" >Vacuum Pump Seal Water Valve</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	North 					        
						    	<input type="text" class="input"  value="${data.vacuumpumpcol3}" placeholder=" " name="vacuumpumpcol3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						        South 					        
						    	<input type="text" class="input"  value="${data.primarythinstockscreencol3}" placeholder=" " name="primarythinstockscreencol3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol3Desc}" name="vacuumpumpcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Seal Water</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>GPM</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol4}" placeholder=" " name="vacuumpumpcol4" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol4Desc}" name="vacuumpumpcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#1</h2></td>
						   </tr> 
						   
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol5}" placeholder=" " name="vacuumpumpcol5" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol5Desc}" name="vacuumpumpcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol6}" placeholder=" " name="vacuumpumpcol6" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol6Desc}" name="vacuumpumpcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						    <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#2</h2></td>
						   </tr> 
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol7}" placeholder=" " name="vacuumpumpcol7" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol7Desc}" name="vacuumpumpcol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol8}" placeholder=" " name="vacuumpumpcol8" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol8Desc}" name="vacuumpumpcol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						    <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#3</h2></td>
						   </tr> 
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol9}" placeholder=" " name="vacuumpumpcol9" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol9Desc}" name="vacuumpumpcol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol10}" placeholder=" " name="vacuumpumpcol10" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol10Desc}" name="vacuumpumpcol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						    <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#4</h2></td>
						   </tr> 
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol11}" placeholder=" " name="vacuumpumpcol11" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol11Desc}" name="vacuumpumpcol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol12}" placeholder=" " name="vacuumpumpcol12" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol12Desc}" name="vacuumpumpcol12Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						    <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#5</h2></td>
						   </tr> 
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol13}" placeholder=" " name="vacuumpumpcol13" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol13Desc}" name="vacuumpumpcol13Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol14}" placeholder=" " name="vacuumpumpcol14" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol14Desc}" name="vacuumpumpcol14Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						    <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#6</h2></td>
						   </tr> 
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol15}" placeholder=" " name="vacuumpumpcol15" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol15Desc}" name="vacuumpumpcol15Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol16}" placeholder=" " name="vacuumpumpcol16" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol16Desc}" name="vacuumpumpcol16Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						    <tr>
						   		<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum Pump#7</h2></td>
						   </tr> 
						  <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(North)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol17}" placeholder=" " name="vacuumpumpcol17" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol17Desc}" name="vacuumpumpcol17Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>		
						   <tr>
						    <td class="tg-yw4l" >Vacuum Pump Bearing(South)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>Temp</span>					        
						    	<input type="text" class="input" value="${data.vacuumpumpcol18}" placeholder=" " name="vacuumpumpcol18" style="margin-left: 1px !important;float: none;"/>
						        <input type="text" class="input" value="${data.vacuumpumpcol18Desc}" name="vacuumpumpcol18Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						
						 </c:if>
						    
				  </table>
		    </center>
		 </div>
		 	
			</div>
			  	
			 
			   <c:choose>
			    <c:when test="${edit == 'yes'}">
			       <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn" class="btn btn-success btn-sm">Print</button>
						<button class="btn btn-success btn-sm" type="submit">Edit</button>
					</div>
			    </c:when>
			  
			    <c:otherwise>
			        <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn" class="btn btn-success btn-sm">Print</button>
						<button class="btn btn-success btn-sm" type="submit">Submit</button>
					</div>
			    </c:otherwise>
			</c:choose>
			
 		
	  </form>		
	  
	 
	  

		</div>


	</div>

</body>
</html>