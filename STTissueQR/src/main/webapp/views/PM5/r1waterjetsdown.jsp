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
		$('#tbbl td').css("fontSize", 12);
		$('#tbbl td h2').css("fontSize", 12);
		$('#tbbl td span').css("fontSize", 12);
		
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
					<c:if test="${data.position == 'R1WaterJetsDown'}">	
								<spring:url value="/r1waterjetsdown/save" var="viewURL"/>
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
									<td style="width:15%;">
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
									<td style="width:15%;">
										 <select style="width: 100%;" name="shift" onchange="operatorSelect(this.value);" id="shift">
										    <option value="-1">Select Shift</option>
										 	<option value="day" ${data.shift == 'day' ? 'selected' : ''}>Day</option>
										 	<option value="night" ${data.shift == 'night' ? 'selected' : ''}>Night</option>
										 	 
										 
										 </select>							
									</td> 
									<td style="width:20%;">
										<button type="button" id="printBtn" class="btn btn-success btn-sm">Print</button>
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
				 		 			<span><b style="font-size: 15px;">R1 Water Jetsdown Operator : </b>${data.operatorName}</span> &nbsp;&nbsp;&nbsp;
				 		 		
				 		 			<span><b style="font-size: 15px;">Date:</b>${data.edate}</span> &nbsp;&nbsp;&nbsp;
				 		 			<span><b style="font-size: 15px;">Shift:</b>${data.shift}</span> 
								
								</div>
				 				
							
						 <table border="1" class="tg" style="background-color: white; width:70%;" id="tbbl">
								
								
								<tr style="text-align: center;background-color:#2189b9 !important;" >
								    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
								    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
								   
								</tr> 
								
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Shaft puller</h2></td>
						     
						</tr> 			   
						   <tr>
						    <td class="tg-yw4l" > ExtractorTabeLevel</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.extractorTabeLevel == 'true' ? 'checked' : ''} name="extractorTabeLevel"/> Yes 
						   		 <input type="radio" value="false" name="extractorTabeLevel" ${data.extractorTabeLevel == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.extractorTabeLevelDesc}" name="extractorTabeLevelDesc" placeholder="Remarks" style="float: right;"/>
						    </td>				    
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" > AllRollersInWorkingCondition</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.allRollersInWorkingCondition == 'true' ? 'checked' : ''} name="allRollersInWorkingCondition"/> Yes 
						   		 <input type="radio" value="false" name="allRollersInWorkingCondition" ${data.allRollersInWorkingCondition == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.allRollersInWorkingConditionDesc}" name="allRollersInWorkingConditionDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" > AnyAbnormalSounds</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anyAbnormalSounds == 'true' ? 'checked' : ''} name="anyAbnormalSounds"/> Yes 
						   		 <input type="radio" value="false" name="anyAbnormalSounds" ${data.anyAbnormalSounds == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anyAbnormalSoundsDesc}" name="anyAbnormalSoundsDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	 
						  <tr>
						    <td class="tg-yw4l" > HydralicMotorIssues</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydralicMotorIssues == 'true' ? 'checked' : ''} name="hydralicMotorIssues"/> Yes 
						   		 <input type="radio" value="false" name="hydralicMotorIssues" ${data.hydralicMotorIssues == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydralicMotorIssuesDesc}" name="hydralicMotorIssuesDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > AnyHydralicLeaks</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anyHydralicLeaks == 'true' ? 'checked' : ''} name="anyHydralicLeaks"/> Yes 
						   		 <input type="radio" value="false" name="anyHydralicLeaks" ${data.anyHydralicLeaks == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anyHydralicLeaksDesc}" name="anyHydralicLeaksDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > sensorsAndLimitSwitchesWorking</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.sensorsAndLimitSwitchesWorking == 'true' ? 'checked' : ''} name="sensorsAndLimitSwitchesWorking"/> Yes 
						   		 <input type="radio" value="false" name="sensorsAndLimitSwitchesWorking" ${data.sensorsAndLimitSwitchesWorking == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.sensorsAndLimitSwitchesWorkingDesc}" name="sensorsAndLimitSwitchesWorkingDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > ChainAndSprocketsAllOk</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.chainAndSprocketsAllOk == 'true' ? 'checked' : ''} name="chainAndSprocketsAllOk"/> Yes 
						   		 <input type="radio" value="false" name="chainAndSprocketsAllOk" ${data.chainAndSprocketsAllOk == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.chainAndSprocketsAllOkDesc}" name="chainAndSprocketsAllOkDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" > WetAndCraneWorking</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.wetAndCraneWorking == 'true' ? 'checked' : ''} name="wetAndCraneWorking"/> Yes 
						   		 <input type="radio" value="false" name="wetAndCraneWorking" ${data.wetAndCraneWorking == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.wetAndCraneWorkingDesc}" name="wetAndCraneWorkingDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > AllHookesworking</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.allHookesworking == 'true' ? 'checked' : ''} name="allHookesworking"/> Yes 
						   		 <input type="radio" value="false" name="allHookesworking" ${data.allHookesworking == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.allHookesworkingDesc}" name="allHookesworkingDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	 --%>			  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WATER JETS</h2></td>
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" > Water Pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.waterPressure == 'true' ? 'checked' : ''} name="waterPressure"/> Yes 
						   		 <input type="radio" value="false" name="waterPressure" ${data.waterPressure == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.waterPressureDesc}" name="waterPressureDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" > Pump Control Station InUse</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		1 <input type="text" value="${data.pumpControlStationInUse}" name="pumpControlStationInUse" />
						   		2 <input type="text" value="${data.pumpControlStationInUse2}" name="pumpControlStationInUse2" />
						   		 <input type="text"class="input" value="${data.pumpControlStationInUseDesc}" name="pumpControlStationInUseDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Front And Back Table ScrewOK</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		1 <input type="text" value="${data.frontAndBackTableScrewOk}" name="frontAndBackTableScrewOk" />
						   		2 <input type="text" value="${data.frontAndBackTableScrewOk2}" name="frontAndBackTableScrewOk2" />
						   		 <input type="text"class="input" value="${data.frontAndBackTableScrewOkDesc}" name="frontAndBackTableScrewOkDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Table And Lift Screws BlownDown</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.tableAndLiftScrewsBlownDown == 'true' ? 'checked' : ''} name="tableAndLiftScrewsBlownDown"/> Yes 
						   		 <input type="radio" value="false" name="tableAndLiftScrewsBlownDown" ${data.tableAndLiftScrewsBlownDown == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tableAndLiftScrewsBlownDownDesc}" name="tableAndLiftScrewsBlownDownDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Any Trim Shoot Issues</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anyTrimShootIssues == 'true' ? 'checked' : ''} name="anyTrimShootIssues"/> Yes 
						   		 <input type="radio" value="false" name="anyTrimShootIssues" ${data.anyTrimShootIssues == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anyTrimShootIssuesDesc}" name="anyTrimShootIssuesDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Table Drain Clean</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.tableDrainClean == 'true' ? 'checked' : ''} name="tableDrainClean"/> Yes 
						   		 <input type="radio" value="false" name="tableDrainClean" ${data.tableDrainClean == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.tableDrainCleanDesc}" name="tableDrainCleanDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Flush Lines Clean</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.flueshLinesClean == 'true' ? 'checked' : ''} name="flueshLinesClean"/> Yes 
						   		 <input type="radio" value="false" name="flueshLinesClean" ${data.flueshLinesClean == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.flueshLinesCleanDesc}" name="flueshLinesCleanDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" > Check Cooling Water</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.checkCoolingWater == 'true' ? 'checked' : ''} name="checkCoolingWater"/> Yes 
						   		 <input type="radio" value="false" name="checkCoolingWater" ${data.checkCoolingWater == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.checkCoolingWaterDesc}" name="checkCoolingWaterDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   --%>
						  <tr>
						    <td class="tg-yw4l" > All Panel Lights Working</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.allPanelLightsWorking == 'true' ? 'checked' : ''} name="allPanelLightsWorking"/> Yes 
						   		 <input type="radio" value="false" name="allPanelLightsWorking" ${data.allPanelLightsWorking == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.allPanelLightsWorkingDesc}" name="allPanelLightsWorkingDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Air Shafts Holding</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.airShaftsHolding == 'true' ? 'checked' : ''} name="airShaftsHolding"/> Yes 
						   		 <input type="radio" value="false" name="airShaftsHolding" ${data.airShaftsHolding == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.airShaftsHoldingDesc}" name="airShaftsHoldingDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Any Break Issues</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anyBreakingIssues == 'true' ? 'checked' : ''} name="anyBreakingIssues"/> Yes 
						   		 <input type="radio" value="false" name="anyBreakingIssues" ${data.anyBreakingIssues == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anyBreakingIssuesDesc}" name="anyBreakingIssuesDesc" placeholder="Remarks" style="float: right;"/>
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
					  </body>
					  </html>