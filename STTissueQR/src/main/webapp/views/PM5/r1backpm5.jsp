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
			<c:if test="${data.position == 'R1'}">	
						<spring:url value="/r1operatorpm5/save" var="viewURL"/>
			</c:if>				
		<form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
					<div class="pageContent">
						<div class="table-selector" style="background-color:#2189b9 !important; border: 1px solid #7e00ff42;">
								
			 <input type="hidden" name="id" value="${data.id}"> 
	
					<table style="margin: auto;">
						<tr>
							<td> Position:</td>
							 <td style="background-color: white; width:70%;">
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
							<td>
								  <input type="text" name="operatorName" value="${data.operatorName}" id="operatorname"/>						
							</td>
							 
							<td> Date:</td>
							  <td>
								<input type="text" readonly name="edate" value="${data.edate}" id="edate">							
							</td>
							
							<td> Crew:</td>
							<td>
								 <select style="width: 100%;" name="crew" id="crew">
								    <option value="-1">Select Crew</option>
								 	<option value="A" ${data.crew == 'A' ? 'selected' : ''}>A</option>
								 	<option value="B" ${data.crew == 'B' ? 'selected' : ''}>B</option>
								 	<option value="C" ${data.crew == 'C' ? 'selected' : ''}>C</option>
								 	<option value="D" ${data.crew == 'D' ? 'selected' : ''}>D</option>
								 
								 </select>							
							</td>
							<td> Shift:</td>
							<td>
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
						
						
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>LEAD-IN ROLL</h2></td>
						     
						</tr> 
						  
						   
						   <tr>
						    <td class="tg-yw4l" > BEARINGS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.leadInRollCol1 == 'true' ? 'checked' : ''} name="leadInRollCol1"/> Yes 
						   		 <input type="radio" value="false" name="leadInRollCol1" ${data.leadInRollCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.leadInRollCol1Desc}" name="leadInRollCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span style="margin-left: -87px;">Oil Leakage</span>
						   		 <input type="radio" value="true" ${data.leadInRollCol2 == 'true' ? 'checked' : ''} name="leadInRollCol2"/> Yes 
						   		 <input type="radio" value="false" name="leadInRollCol2" ${data.leadInRollCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.leadInRollCol2Desc}" name="leadInRollCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.leadInRollCol3 == 'true' ? 'checked' : ''} name="leadInRollCol3"/> Yes 
						   		 <input type="radio" value="false" ${data.leadInRollCol3 == 'false' ? 'checked' : ''} name="leadInRollCol3"/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.leadInRollCol3Desc}" name="leadInRollCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >MOTOR FOR LEAD-IN ROLL</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	  <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.leadInRollCol4 == 'true' ? 'checked' : ''} name="leadInRollCol4"/> Yes 
						   		 <input type="radio" value="false" name="leadInRollCol4" ${data.leadInRollCol4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.leadInRollCol4Desc}" name="leadInRollCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	  <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.leadInRollCol5 == 'true' ? 'checked' : ''} name="leadInRollCol5"/> Yes 
						   		 <input type="radio" value="false" name="leadInRollCol5" ${data.leadInRollCol5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.leadInRollCol5Desc}" name="leadInRollCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>SECTIONAL ROLL</h2></td>
						     
						</tr> 
						  
						 
						  <tr>
						     <td class="tg-yw4l" >BEARINGS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						          <span style="margin-left: -88px;">Free Turning</span>
						   		 <input type="radio" value="true" ${data.sectionRollCol1 == 'true' ? 'checked' : ''} name="sectionRollCol1"/> Yes 
						   		 <input type="radio" value="false" name="sectionRollCol1" ${data.sectionRollCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.sectionRollCol1Desc}" name="sectionRollCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>BREAK ASSEMBLY</h2></td>
						     
						   </tr> 
						  
						  <tr>
						    <td class="tg-yw4l" >AIR LINES  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -61px;">Leakage</span>
						   		 <input type="radio" value="true" ${data.breakAssemblyCol1 == 'true' ? 'checked' : ''} name="breakAssemblyCol1"/> Yes 
						   		 <input type="radio" value="false" name="breakAssemblyCol1" ${data.breakAssemblyCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.breakAssemblyCol1Desc}" name="breakAssemblyCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  <tr>
						    <td class="tg-yw4l" >BRAKE SHOES </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.breakAssemblyCol2 == 'true' ? 'checked' : ''} name="breakAssemblyCol2"/> Yes 
						   		 <input type="radio" value="false" name="breakAssemblyCol2" ${data.breakAssemblyCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.breakAssemblyCol2Desc}" name="breakAssemblyCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>SLITTERS</h2></td>
						     
						   </tr> 
						  
						  <tr>
						    <td class="tg-yw4l" >MOTORS </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.slittersCol1 == 'true' ? 'checked' : ''} name="slittersCol1"/> Yes 
						   		 <input type="radio" value="false" name="slittersCol1" ${data.slittersCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.slittersCol1Desc}" name="slittersCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    </tr>
						    <tr>
						    <td class="tg-yw4l" >ANVILS </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.slittersCol2 == 'true' ? 'checked' : ''} name="slittersCol2"/> Yes 
						   		 <input type="radio" value="false" name="slittersCol2" ${data.slittersCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.slittersCol2Desc}" name="slittersCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    </tr>
						  <tr>
						    <td class="tg-yw4l" >SLITTER BLADES </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.slittersCol3 == 'true' ? 'checked' : ''} name="slittersCol3"/> Yes 
						   		 <input type="radio" value="false" name="slittersCol3" ${data.slittersCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.slittersCol3Desc}" name="slittersCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  	<tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>TRIM ASSEMBLY</h2></td>
						     
						   </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >CHUTE </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.trimAssemblyCol1 == 'true' ? 'checked' : ''} name="trimAssemblyCol1"/> Yes 
						   		 <input type="radio" value="false" name="trimAssemblyCol1" ${data.trimAssemblyCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.trimAssemblyCol1Desc}" name="trimAssemblyCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >BLOWER MOTOR </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.trimAssemblyCol2 == 'true' ? 'checked' : ''} name="trimAssemblyCol2"/> Yes 
						   		 <input type="radio" value="false" name="trimAssemblyCol2" ${data.trimAssemblyCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.trimAssemblyCol2Desc}" name="trimAssemblyCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.trimAssemblyCol3 == 'true' ? 'checked' : ''} name="trimAssemblyCol3"/> Yes 
						   		 <input type="radio" value="false" name="trimAssemblyCol3" ${data.trimAssemblyCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.trimAssemblyCol3Desc}" name="trimAssemblyCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >BLOWER BELTS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.trimAssemblyCol4 == 'true' ? 'checked' : ''} name="trimAssemblyCol4"/> Yes 
						   		 <input type="radio" value="false" name="trimAssemblyCol4" ${data.trimAssemblyCol4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.trimAssemblyCol4Desc}" name="trimAssemblyCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>TENSION ROLL</h2></td>
						     
						   </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >BEARINGS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span style="margin-left: -96px;">Free Truning</span>
						   		 <input type="radio" value="true" ${data.tensiionRollCol1 == 'true' ? 'checked' : ''} name="tensiionRollCol1"/> Yes 
						   		 <input type="radio" value="false" name="tensiionRollCol1" ${data.tensiionRollCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tensiionRollCol1Desc}" name="tensiionRollCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >SECTIONS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -96px;">No Build-Up</span>
						   		 <input type="radio" value="true" ${data.tensiionRollCol2 == 'true' ? 'checked' : ''} name="tensiionRollCol2"/> Yes 
						   		 <input type="radio" value="false" name="tensiionRollCol2" ${data.tensiionRollCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tensiionRollCol2Desc}" name="tensiionRollCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >PLC PANEL READOUT</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	
						   		 <input type="radio" value="true" ${data.tensiionRollCol3 == 'true' ? 'checked' : ''} name="tensiionRollCol3"/> Yes 
						   		 <input type="radio" value="false" name="tensiionRollCol3" ${data.tensiionRollCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tensiionRollCol3Desc}" name="tensiionRollCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WINDER DRUM #1</h2></td>
						     
						   </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >BEARINGS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col1 == 'true' ? 'checked' : ''} name="winderDrum1Col1"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col1" ${data.winderDrum1Col1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col1Desc}" name="winderDrum1Col1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -96px;">Oil Leakage</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col2 == 'true' ? 'checked' : ''} name="winderDrum1Col2"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col2" ${data.winderDrum1Col2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col2Desc}" name="winderDrum1Col2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col3 == 'true' ? 'checked' : ''} name="winderDrum1Col3"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col3" ${data.winderDrum1Col3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col3Desc}" name="winderDrum1Col3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >MOTOR</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col4 == 'true' ? 'checked' : ''} name="winderDrum1Col4"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col4" ${data.winderDrum1Col4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col4Desc}" name="winderDrum1Col4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col5 == 'true' ? 'checked' : ''} name="winderDrum1Col5"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col5" ${data.winderDrum1Col5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col5Desc}" name="winderDrum1Col5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <%-- <tr>
						    <td class="tg-yw4l" >GEAR REDUCER</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col6 == 'true' ? 'checked' : ''} name="winderDrum1Col6"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col6" ${data.winderDrum1Col6 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col6Desc}" name="winderDrum1Col6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.winderDrum1Col7 == 'true' ? 'checked' : ''} name="winderDrum1Col7"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum1Col7" ${data.winderDrum1Col7 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum1Col7Desc}" name="winderDrum1Col7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> --%>
						  
						  
						  
						  
						  
						   <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WINDER DRUM #2</h2></td>
						     
						   </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >BEARINGS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col1 == 'true' ? 'checked' : ''} name="winderDrum2Col1"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col1" ${data.winderDrum2Col1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col1Desc}" name="winderDrum2Col1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -96px;">Oil Leakage</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col2 == 'true' ? 'checked' : ''} name="winderDrum2Col2"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col2" ${data.winderDrum2Col2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col2Desc}" name="winderDrum2Col2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col3 == 'true' ? 'checked' : ''} name="winderDrum2Col3"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col3" ${data.winderDrum2Col3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col3Desc}" name="winderDrum2Col3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >MOTOR</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col4 == 'true' ? 'checked' : ''} name="winderDrum2Col4"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col4" ${data.winderDrum2Col4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col4Desc}" name="winderDrum2Col4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -115px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col5 == 'true' ? 'checked' : ''} name="winderDrum2Col5"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col5" ${data.winderDrum2Col5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col5Desc}" name="winderDrum2Col5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						<%--   <tr>
						    <td class="tg-yw4l" >GEAR REDUCER</td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col6 == 'true' ? 'checked' : ''} name="winderDrum2Col6"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col6" ${data.winderDrum2Col6 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col6Desc}" name="winderDrum2Col6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span style="margin-left: -96px;"> Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.winderDrum2Col7 == 'true' ? 'checked' : ''} name="winderDrum2Col7"/> Yes 
						   		 <input type="radio" value="false" name="winderDrum2Col7" ${data.winderDrum2Col7 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.winderDrum2Col7Desc}" name="winderDrum2Col7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> --%>
						  
						  
						  <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>ROLL EJECTOR</h2></td>
						     
						   </tr>
						  
						  <br/>
						   <tr>
						    <td class="tg-yw4l" >AIR LINES </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rollEjectorCol1 == 'true' ? 'checked' : ''} name="rollEjectorCol1"/> Yes 
						   		 <input type="radio" value="false" name="rollEjectorCol1" ${data.rollEjectorCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rollEjectorCol1Desc}" name="rollEjectorCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >SWITCHES </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rollEjectorCol2 == 'true' ? 'checked' : ''} name="rollEjectorCol2"/> Yes 
						   		 <input type="radio" value="false" name="rollEjectorCol2" ${data.rollEjectorCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rollEjectorCol2Desc}" name="rollEjectorCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >MECHANICAL </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rollEjectorCol3 == 'true' ? 'checked' : ''} name="rollEjectorCol3"/> Yes 
						   		 <input type="radio" value="false" name="rollEjectorCol3" ${data.rollEjectorCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rollEjectorCol3Desc}" name="rollEjectorCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>RIDER ROLL</h2></td>
						     
						   </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >BEARINGS </td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.riderRollCol1 == 'true' ? 'checked' : ''} name="riderRollCol1"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol1" ${data.riderRollCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol1Desc}" name="riderRollCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -96px;">Oil Leakage</span>
						   		 <input type="radio" value="true" ${data.riderRollCol2 == 'true' ? 'checked' : ''} name="riderRollCol2"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol2" ${data.riderRollCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol2Desc}" name="riderRollCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -96px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.riderRollCol3 == 'true' ? 'checked' : ''} name="riderRollCol3"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol3" ${data.riderRollCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol3Desc}" name="riderRollCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >MOTOR </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.riderRollCol4 == 'true' ? 'checked' : ''} name="riderRollCol4"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol4" ${data.riderRollCol4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol4Desc}" name="riderRollCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -96px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.riderRollCol5 == 'true' ? 'checked' : ''} name="riderRollCol5"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol5" ${data.riderRollCol5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol5Desc}" name="riderRollCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >BELTS </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.riderRollCol6 == 'true' ? 'checked' : ''} name="riderRollCol6"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol6" ${data.riderRollCol6 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol6Desc}" name="riderRollCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >MOVEMENT </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.riderRollCol7 == 'true' ? 'checked' : ''} name="riderRollCol7"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol7" ${data.riderRollCol7 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol7Desc}" name="riderRollCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >LOCKING DEVICE </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.riderRollCol8 == 'true' ? 'checked' : ''} name="riderRollCol8"/> Yes 
						   		 <input type="radio" value="false" name="riderRollCol8" ${data.riderRollCol8 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.riderRollCol8Desc}" name="riderRollCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>BOWED ROLL</h2></td>
						     
						   </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >MOTOR </td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -88px;">Over Heating</span>
						   		 <input type="radio" value="true" ${data.bowedRollCol1 == 'true' ? 'checked' : ''} name="bowedRollCol1"/> Yes 
						   		 <input type="radio" value="false" name="bowedRollCol1" ${data.bowedRollCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.bowedRollCol1Desc}" name="bowedRollCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" > </td>
						    <td class="tg-yw4l" style="text-align: center;">
						     	 <span style="margin-left: -96px;">Abnormal Sound</span>
						   		 <input type="radio" value="true" ${data.bowedRollCol2 == 'true' ? 'checked' : ''} name="bowedRollCol2"/> Yes 
						   		 <input type="radio" value="false" name="bowedRollCol2" ${data.bowedRollCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.bowedRollCol2Desc}" name="bowedRollCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >BELT </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.bowedRollCol3 == 'true' ? 'checked' : ''} name="bowedRollCol3"/> Yes 
						   		 <input type="radio" value="false" name="bowedRollCol3" ${data.bowedRollCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.bowedRollCol3Desc}" name="bowedRollCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CORE CHUCKS</h2></td>
						     
						   </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >BEARINGS </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.coreChucksCol1 == 'true' ? 'checked' : ''} name="coreChucksCol1"/> Yes 
						   		 <input type="radio" value="false" name="coreChucksCol1" ${data.coreChucksCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.coreChucksCol1Desc}" name="coreChucksCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >MOVEMENT </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.coreChucksCol2 == 'true' ? 'checked' : ''} name="coreChucksCol2"/> Yes 
						   		 <input type="radio" value="false" name="coreChucksCol2" ${data.coreChucksCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.coreChucksCol2Desc}" name="coreChucksCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >HYDRAULIC CONTROLS </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span style="margin-left: -60px;">Leakage</span>
						   		 <input type="radio" value="true" ${data.coreChucksCol3 == 'true' ? 'checked' : ''} name="coreChucksCol3"/> Yes 
						   		 <input type="radio" value="false" name="coreChucksCol3" ${data.coreChucksCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.coreChucksCol3Desc}" name="coreChucksCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.coreChucksCol4 == 'true' ? 'checked' : ''} name="coreChucksCol4"/> Yes 
						   		 <input type="radio" value="false" name="coreChucksCol4" ${data.coreChucksCol4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.coreChucksCol4Desc}" name="coreChucksCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>NIP GUARD</h2></td>
						     
						   </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >MOVEMENT</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.nipGuardCol1 == 'true' ? 'checked' : ''} name="nipGuardCol1"/> Yes 
						   		 <input type="radio" value="false" name="nipGuardCol1" ${data.nipGuardCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.nipGuardCol1Desc}" name="nipGuardCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >HYDRAULIC CONTROLS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.nipGuardCol2 == 'true' ? 'checked' : ''} name="nipGuardCol2"/> Yes 
						   		 <input type="radio" value="false" name="nipGuardCol2" ${data.nipGuardCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.nipGuardCol2Desc}" name="nipGuardCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" ></td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span style="margin-left: -60px;">Leakage</span>
						   		 <input type="radio" value="true" ${data.nipGuardCol3 == 'true' ? 'checked' : ''} name="nipGuardCol3"/> Yes 
						   		 <input type="radio" value="false" name="nipGuardCol3" ${data.nipGuardCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.nipGuardCol3Desc}" name="nipGuardCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    	<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>TABLE LIFT GATE</h2></td>
						     
						   </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >AIR LINES </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.tableLeftGateCol1 == 'true' ? 'checked' : ''} name="tableLeftGateCol1"/> Yes 
						   		 <input type="radio" value="false" name="tableLeftGateCol1" ${data.tableLeftGateCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tableLeftGateCol1Desc}" name="tableLeftGateCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >MOVEMENT</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.tableLeftGateCol2 == 'true' ? 'checked' : ''} name="tableLeftGateCol2"/> Yes 
						   		 <input type="radio" value="false" name="tableLeftGateCol2" ${data.tableLeftGateCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tableLeftGateCol2Desc}" name="tableLeftGateCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						     
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
						  		<!-- /.content-wrapper -->
						  			                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
						  			                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
						  			                   </footer>
						  </div>
						  </div>
						  </body>
						  </html>