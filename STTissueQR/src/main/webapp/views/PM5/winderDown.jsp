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
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
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
		var operatorname = $('#operatorName').val();
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
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
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
				<div class="table-selector" style="background-color:#2189b9 !important; border: 1px solid #7e00ff42;">
												
													
							 <input type="hidden" name="id" value="${data.id}"> 
					
									<table style="margin: auto;">
										<tr>
											<td> Position:</td>
											 <td>
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
												<input type="text"  readonly name="edate" value="${data.edate}" id="edate"  onclick="funDate()">							
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
												<button type="button" id="printBtn"  class="btn btn-success btn-sm">Print</button>
											</td>
					 					</tr>
									</table>
									 
								</div>
 			 <c:if test="${not empty message }">
 			  
				<span class="message"><center><h>${message}</h></center></span>
			 </c:if>
 
 <br/> <br/>  <br/>

 
   <div id="printDiv">
    
		 <center>
		 
		 <c:if test="${data.shift == 'day'}">
		   <h1 style="font-size: 21px;color: #518f3e;">Day Shift Form</h1>
		 </c:if> 
		 <c:if test="${data.shift == 'night'}">
		   <h1 style="font-size: 21px;color: #518f3e;">Night Shift Form</h1>
		 </c:if>  
		 
		 	<div style="display: none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 25px;">Operator Basic Care CheckList</h1>
		 		</div>
		 		
		 		<div style="float: right;}">
		 			<span><b style="font-size: 15px;">WinderDown Operator : </b>${data.operatorName}</span>
		 		</div>
		 		<div style="float: right;    margin-right: -130px;">
		 		 <br/>
		 			<span><b style="font-size: 15px;">Date:</b>${data.edate}</span> &nbsp;&nbsp;&nbsp;
		 			<span><b style="font-size: 15px;">Shift:</b>${data.shift}</span> 
		 		</div>
		 	</div>	
		 	<br/><br/><br/><br/><br/>
		 	
		 					<h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						   	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</h3>
		 	
		 	
				 <table border="1" class="tg" style="background-color: white;width: 1122px;" id="tbbl">
						
						
						<tr>
						    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
						    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
						   
						</tr> 
						
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CORE SAW</h2></td>
						     
						</tr> 			   
						   <tr>
						    <td class="tg-yw4l" > Power</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.power == 'true' ? 'checked' : ''} name="power"/> Yes 
						   		 <input type="radio" value="false" name="power" ${data.power == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.powerDesc}" name="powerDesc" placeholder="Remarks" style="float: right;"/>
						    </td>				    
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" > Blade</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.blade == 'true' ? 'checked' : ''} name="blade"/> Yes 
						   		 <input type="radio" value="false" name="blade" ${data.blade == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.bladeDesc}" name="bladeDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" > Size Adjustment Movement</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.sizeadjustmentmovement == 'true' ? 'checked' : ''} name="sizeadjustmentmovement"/> Yes 
						   		 <input type="radio" value="false" name="sizeadjustmentmovement" ${data.sizeadjustmentmovement == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.sizeadjustmentmovementDesc}" name="sizeadjustmentmovementDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Roll UPENDER</h2></td>
						  </tr>	 
						  <tr>
						    <td class="tg-yw4l" > Roll Kicker Working Properly</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rollkickerworkingproperly == 'true' ? 'checked' : ''} name="rollkickerworkingproperly"/> Yes 
						   		 <input type="radio" value="false" name="rollkickerworkingproperly" ${data.rollkickerworkingproperly == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rollkickerworkingproperlyDesc}" name="rollkickerworkingproperlyDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Any Hydraulic Leaks</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anyhydraulicleaks == 'true' ? 'checked' : ''} name="anyhydraulicleaks"/> Yes 
						   		 <input type="radio" value="false" name="anyhydraulicleaks" ${data.anyhydraulicleaks == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anyhydraulicleaksDesc}" name="anyhydraulicleaksDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Upright Bumper and Cushion Bumper Working Properly</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.uprightbumperandcushionbumperworkingproperly == 'true' ? 'checked' : ''} name="uprightbumperandcushionbumperworkingproperly"/> Yes 
						   		 <input type="radio" value="false" name="uprightbumperandcushionbumperworkingproperly" ${data.uprightbumperandcushionbumperworkingproperly == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.uprightbumperandcushionbumperworkingproperlyDesc}" name="uprightbumperandcushionbumperworkingproperlyDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Any Control Panel Issues</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anycontrolpanelissues == 'true' ? 'checked' : ''} name="anycontrolpanelissues"/> Yes 
						   		 <input type="radio" value="false" name="anycontrolpanelissues" ${data.anycontrolpanelissues == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anycontrolpanelissuesDesc}" name="anycontrolpanelissuesDesc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" > Any Noticeable issues With Conveyor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.anynoticeableissueswithconveyor == 'true' ? 'checked' : ''} name="anynoticeableissueswithconveyor"/> Yes 
						   		 <input type="radio" value="false" name="anynoticeableissueswithconveyor" ${data.anynoticeableissueswithconveyor == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.anynoticeableissueswithconveyorDesc}" name="anynoticeableissueswithconveyorDesc" placeholder="Remarks" style="float: right;"/>
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
						<button type="button" id="printBtn1" class="button">Print</button>
						<button class="button" type="submit">Edit</button>
					</div>
			    </c:when>
			  
			    <c:otherwise>
			        <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn1" class="button">Print</button>
						<button class="button" type="submit">Submit</button>
					</div>
			    </c:otherwise>
			</c:choose>
			
 	<%-- </c:if>	 --%>		
	  </form>		
	  
	 
	  

		</div>


	</div>

</body>
</html>