<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/frpobccReport/checkdata" var="checkURL" />
<spring:url value="/frpobccReport/hit" var="hitURL" />
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<script type="text/javascript">
$(function(){
	$('input[name=date]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true,
	    //minDate:-1
	});
	

	/* $("input[type='checkbox']").on("change",function(){
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
		
			
	}); */
	
});
 
function operatorSelect(value)
{
	var position  = $('#operator').val();
	var date = $('#date').val();
	var operatorname = $('#operatorname').val();
	var crew  = $('#crew').val();
	if(crew!='-1')
	{
		/* $.ajax({
		url:'${checkURL}',
		type:'POST',
		data:{
			date :date,
			position:position					
		},
		success:function(data){
			
			if(data.check==true){
				var entry=confirm("Entry Already Exist. Do You Want To Edit");
				if(entry==true)
				{
					location.href="./../frpobccCommon/select?position="+position+"&date="+date+"&crew="+crew;
				}
				else
					location.href="./../frpobccCommon/view?position="+position+"&date="+date+"&crew="+crew;
			}
			else
				location.href="./../frpobccCommon/select?position="+position+"&date="+date+"&crew="+crew;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-()' );
			
		}
	}); */
	location.href="./../frpobccCommon/select?position="+position+"&date="+date+"&crew="+crew;
	}
	else
	{
		if(!alert('Please first select the Crew')){window.location.reload();}
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
width: 100px;
text-align:center;
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
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
		
		<c:if test="${data.position == 'OP7'}">	
			<spring:url value="/frpobccCommon/OpRoute_7/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Route 7 Outside</span>
				</div>
				<div class="table-selector">
					
				
					
					
			 <input type="hidden" name="id" value="${data.id}"> 
	
					<table style="margin: auto;">
						<tr>
						<td> Date:</td>
							  <td>
								<input type="text" readonly name="date" value="${data.date}" id="date">							
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
							<td> Area:</td>
							 <td>
								 <select style="width: 100%;" name="position" id="operator" onchange="operatorSelect(this.value);">
								    <option value="-1">Select Operator</option>
								 	<option value="OP1" ${data.position == 'OP1' ? 'selected' : ''}>Process Floor 1</option>
								 	<option value="OP2" ${data.position == 'OP2' ? 'selected' : ''}>Process Floor 2</option>
								 	<option value="OP3" ${data.position == 'OP3' ? 'selected' : ''}>Process Floor 3</option>
								 	<option value="OP4" ${data.position == 'OP4' ? 'selected' : ''}>Basement 4</option>
								 	<option value="OP5" ${data.position == 'OP5' ? 'selected' : ''}>Basement 5</option>
								 	<option value="OP6" ${data.position == 'OP6' ? 'selected' : ''}>Basement 6</option>
								 	<option value="OP7" ${data.position == 'OP7' ? 'selected' : ''}>Outside 7</option>
								 	<option value="OP8" ${data.position == 'OP8' ? 'selected' : ''}>Outside 8</option>
								 	<option value="OP9" ${data.position == 'OP9' ? 'selected' : ''}>B Line Basement 9</option>								 	
							</td>  
							
							<%-- <td> Operator Name:</td>
							<td>
								  <input type="text" name="operatorname" value="${data.operatorname}" id="operatorname"/>						
							</td> --%>
							 
							
							
							
							<%-- <td> Shift:</td>
							<td>
								 <select style="width: 100%;" name="shift" onchange="operatorSelect(this.value);" id="shift">
								    <option value="-1">Select Shift</option>
								 	<option value="day" ${data.shift == 'day' ? 'selected' : ''}>Day</option>
								 	<option value="night" ${data.shift == 'night' ? 'selected' : ''}>Night</option>
								 </select>							
							</td>  --%>
							<td>
								<button type="button" id="printBtn">Print</button>
							</td>
	 					</tr>
					</table>
					 
				</div>
 			 <c:if test="${not empty message }">
				<span class="message">${message}</span>
			 </c:if>
 
 <br/> <br/>  <br/>

 <c:if test="${data.position == 'OP7'}">
   <div id="printDiv">
   		 <center>
   		 <c:if test="${data.position == 'OP7'}">
		   	<h1 style="font-size: 21px;color: #518f3e;">Operator Route 7 Outside</h1>
		 </c:if> 
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Route 7 Outside</h1>
		 		</div>
		 		<div style="float: right;}">
		 			<span><b style="font-size: 15px;">Operator : </b>${data.operatorname}</span>
		 		</div>
		 		<div style="float: right;    margin-right: -130px;">
		 		 <br/>
		 			<span><b style="font-size: 15px;">Date:</b>${data.date}</span> &nbsp;&nbsp;&nbsp;
		 			<%-- <span><b style="font-size: 15px;">Shift:</b>${data.shift}</span>  --%>
		 		</div>
		 	</div>	
		 	
		 				<%-- <h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						  	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </h3> --%> 
				 <table border="1" style="width:80%" id="tbbl">				
						<tr>					    
						    <td class="tg-yw4l" ><h1>TECHNICIANS INITIALS</h1></td>
						    <td>
								<input type="text" class="input" value="${data.techniciansinitials_freq}"  name="techniciansinitials_freq" style="margin-left: 1px !important;float: none;"/>
							</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_9am}"  name="techniciansinitials_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_1pm}"  name="techniciansinitials_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_5pm}"  name="techniciansinitials_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_9pm}"  name="techniciansinitials_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_1am}"  name="techniciansinitials_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_5am}"  name="techniciansinitials_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>
							<td class="tg-yw4l" ><h1>STATION - EQUIPMENT</h1></td>	<td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1>FREQ</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 09:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 01:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 05:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 09:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 01:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 05:00 AM</h1></td>						    			   					    		   
						</tr>
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">V-BRITE TANK</h1></td>
							<td></td> 
							<td align="center" id="ok1"><input id="ok"  type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="ok" name="ok" ${data.ok == 'ok' ? 'checked' : ''}></td>
							<td align="center" id="ok2"><input id="button1pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1pm" name="button1pm" ${data.button1pm == 'button1pm' ? 'checked' : ''}></td>
							<td align="center" id="ok3"><input id="button5pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5pm" name="button5pm" ${data.button5pm == 'button5pm' ? 'checked' : ''}></td>
							<td align="center" id="ok4"><input id="button9pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button9pm" name="button9pm" ${data.button9pm == 'button9pm' ? 'checked' : ''}></td>
							<td align="center" id="ok5"><input id="button1am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1am" name="button1am" ${data.button1am == 'button1am' ? 'checked' : ''}></td>
							<td align="center" id="ok6"><input id="button5am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5am" name="button5am" ${data.button5am == 'button5am' ? 'checked' : ''}></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>VISUAL INSPECTIONS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.vbritetank1_9am}"  name="vbritetank1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.vbritetank1_1pm}"  name="vbritetank1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank1_5pm}"  name="vbritetank1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank1_9pm}"  name="vbritetank1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank1_1am}"  name="vbritetank1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank1_5am}"  name="vbritetank1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>TANK LEVEL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.vbritetank2_9am}"  name="vbritetank2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.vbritetank2_1pm}"  name="vbritetank2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank2_5pm}"  name="vbritetank2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank2_9pm}"  name="vbritetank2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank2_1am}"  name="vbritetank2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank2_5am}"  name="vbritetank2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>DIKE AREA</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.vbritetank3_9am}"  name="vbritetank3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.vbritetank3_1pm}"  name="vbritetank3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank3_5pm}"  name="vbritetank3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank3_9pm}"  name="vbritetank3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank3_1am}"  name="vbritetank3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.vbritetank3_5am}"  name="vbritetank3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						 						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Caustic Unloading Area</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>VISUAL INSPECTION</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea1_9am}"  name="causticunloadingarea1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea1_1pm}"  name="causticunloadingarea1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea1_5pm}"  name="causticunloadingarea1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea1_9pm}"  name="causticunloadingarea1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea1_1am}"  name="causticunloadingarea1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea1_5am}"  name="causticunloadingarea1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Area Clean - Hoses rolled up</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea2_9am}"  name="causticunloadingarea2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea2_1pm}"  name="causticunloadingarea2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea2_5pm}"  name="causticunloadingarea2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea2_9pm}"  name="causticunloadingarea2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea2_1am}"  name="causticunloadingarea2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.causticunloadingarea2_5am}"  name="causticunloadingarea2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">CLARIFIER</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>RAKE DRIVE UNITS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifier1_9am}"  name="clarifier1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifier1_1pm}"  name="clarifier1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier1_5pm}"  name="clarifier1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier1_9pm}"  name="clarifier1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier1_1am}"  name="clarifier1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier1_5am}"  name="clarifier1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						 <tr>						 
							<td class="tg-yw4l" ><h1>Biocide Bags in Clarifier (10 every Tue and Thur)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>1</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifier2_9am}" disabled name="clarifier2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifier2_1pm}"  name="clarifier2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier2_5pm}" disabled name="clarifier2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier2_9pm}" disabled name="clarifier2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier2_1am}" disabled name="clarifier2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier2_5am}" disabled name="clarifier2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>   
						<tr>						 
							<td class="tg-yw4l" ><h1>TORQUE ON RAKE DRIVE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifier3_9am}"  name="clarifier3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifier3_1pm}"  name="clarifier3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier3_5pm}"  name="clarifier3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier3_9pm}"  name="clarifier3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier3_1am}"  name="clarifier3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier3_5am}"  name="clarifier3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>SLUDGE PUMP # 1</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifier4_9am}"  name="clarifier4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifier4_1pm}"  name="clarifier4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier4_5pm}"  name="clarifier4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier4_9pm}"  name="clarifier4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier4_1am}"  name="clarifier4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier4_5am}"  name="clarifier4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>SLUDGE PUMP # 2</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifier5_9am}"  name="clarifier5_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifier5_1pm}"  name="clarifier5_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier5_5pm}"  name="clarifier5_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier5_9pm}"  name="clarifier5_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier5_1am}"  name="clarifier5_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifier5_5am}"  name="clarifier5_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE PUMPS DIKE DRAIN</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>  VALVE CLOSED</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain1_9am}"  name="sludgepumpsdikedrain1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain1_1pm}"  name="sludgepumpsdikedrain1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain1_5pm}"  name="sludgepumpsdikedrain1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain1_9pm}"  name="sludgepumpsdikedrain1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain1_1am}"  name="sludgepumpsdikedrain1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain1_5am}"  name="sludgepumpsdikedrain1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>CLARIFIER CLEARWELL PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain2_9am}"  name="sludgepumpsdikedrain2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain2_1pm}"  name="sludgepumpsdikedrain2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain2_5pm}"  name="sludgepumpsdikedrain2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain2_9pm}"  name="sludgepumpsdikedrain2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain2_1am}"  name="sludgepumpsdikedrain2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.sludgepumpsdikedrain2_5am}"  name="sludgepumpsdikedrain2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">MILL & FIRE WATER SYSTEM</h1></td>
						</tr>
						 <tr>						 
							<td class="tg-yw4l" ><h1>VISUAL CHECKS:</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1></h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem1_9am}" disabled name="mill_firewatersystem1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem1_1pm}" disabled name="mill_firewatersystem1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem1_5pm}" disabled name="mill_firewatersystem1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem1_9pm}" disabled name="mill_firewatersystem1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem1_1am}" disabled name="mill_firewatersystem1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem1_5am}" disabled name="mill_firewatersystem1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>MILL WATER PUMP #1</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem2_9am}"  name="mill_firewatersystem2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem2_1pm}"  name="mill_firewatersystem2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem2_5pm}"  name="mill_firewatersystem2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem2_9pm}"  name="mill_firewatersystem2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem2_1am}"  name="mill_firewatersystem2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem2_5am}"  name="mill_firewatersystem2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>MILL WATER PUMP #2</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem3_9am}"  name="mill_firewatersystem3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem3_1pm}"  name="mill_firewatersystem3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem3_5pm}"  name="mill_firewatersystem3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem3_9pm}"  name="mill_firewatersystem3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem3_1am}"  name="mill_firewatersystem3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem3_5am}"  name="mill_firewatersystem3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>HVAC COOLING WATER PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem4_9am}"  name="mill_firewatersystem4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem4_1pm}"  name="mill_firewatersystem4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem4_5pm}"  name="mill_firewatersystem4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem4_9pm}"  name="mill_firewatersystem4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem4_1am}"  name="mill_firewatersystem4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem4_5am}"  name="mill_firewatersystem4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>DIKE DRAIN VALVES CLOSED</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem5_9am}"  name="mill_firewatersystem5_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem5_1pm}"  name="mill_firewatersystem5_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem5_5pm}"  name="mill_firewatersystem5_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem5_9pm}"  name="mill_firewatersystem5_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem5_1am}"  name="mill_firewatersystem5_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem5_5am}"  name="mill_firewatersystem5_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>FIRE PUMPS </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem6_9am}"  name="mill_firewatersystem6_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem6_1pm}"  name="mill_firewatersystem6_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem6_5pm}"  name="mill_firewatersystem6_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem6_9pm}"  name="mill_firewatersystem6_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem6_1am}"  name="mill_firewatersystem6_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem6_5am}"  name="mill_firewatersystem6_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>CONTROL PANEL   AUTO / ON</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem7_9am}"  name="mill_firewatersystem7_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem7_1pm}"  name="mill_firewatersystem7_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem7_5pm}"  name="mill_firewatersystem7_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem7_9pm}"  name="mill_firewatersystem7_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem7_1am}"  name="mill_firewatersystem7_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.mill_firewatersystem7_5am}"  name="mill_firewatersystem7_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">PLANT AIR COMPRESSORS</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>LEAD COMPRESSOR #1 OR #2</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors1_9am}"  name="plantaircompressors1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors1_1pm}"  name="plantaircompressors1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors1_5pm}"  name="plantaircompressors1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors1_9pm}"  name="plantaircompressors1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors1_1am}"  name="plantaircompressors1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors1_5am}"  name="plantaircompressors1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>AIR TEMPERATURE L.P. OUT</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors2_9am}"  name="plantaircompressors2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors2_1pm}"  name="plantaircompressors2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors2_5pm}"  name="plantaircompressors2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors2_9pm}"  name="plantaircompressors2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors2_1am}"  name="plantaircompressors2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors2_5am}"  name="plantaircompressors2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>AIR TEMPERATURE H.P. OUT</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors3_9am}"  name="plantaircompressors3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors3_1pm}"  name="plantaircompressors3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors3_5pm}"  name="plantaircompressors3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors3_9pm}"  name="plantaircompressors3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors3_1am}"  name="plantaircompressors3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors3_5am}"  name="plantaircompressors3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>AIR TEMPERATURE H.P. IN</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors4_9am}"  name="plantaircompressors4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors4_1pm}"  name="plantaircompressors4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors4_5pm}"  name="plantaircompressors4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors4_9pm}"  name="plantaircompressors4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors4_1am}"  name="plantaircompressors4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors4_5am}"  name="plantaircompressors4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>OIL TEMPERATURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors5_9am}"  name="plantaircompressors5_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors5_1pm}"  name="plantaircompressors5_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors5_5pm}"  name="plantaircompressors5_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors5_9pm}"  name="plantaircompressors5_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors5_1am}"  name="plantaircompressors5_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors5_5am}"  name="plantaircompressors5_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>OIL PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors6_9am}"  name="plantaircompressors6_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors6_1pm}"  name="plantaircompressors6_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors6_5pm}"  name="plantaircompressors6_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors6_9pm}"  name="plantaircompressors6_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors6_1am}"  name="plantaircompressors6_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors6_5am}"  name="plantaircompressors6_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>DISCHARGE PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors7_9am}"  name="plantaircompressors7_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors7_1pm}"  name="plantaircompressors7_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors7_5pm}"  name="plantaircompressors7_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors7_9pm}"  name="plantaircompressors7_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors7_1am}"  name="plantaircompressors7_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors7_5am}"  name="plantaircompressors7_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>INTERCOOLER PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors8_9am}"  name="plantaircompressors8_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors8_1pm}"  name="plantaircompressors8_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors8_5pm}"  name="plantaircompressors8_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors8_9pm}"  name="plantaircompressors8_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors8_1am}"  name="plantaircompressors8_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors8_5am}"  name="plantaircompressors8_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>FILTER INDICATOR</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors9_9am}"  name="plantaircompressors9_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors9_1pm}"  name="plantaircompressors9_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors9_5pm}"  name="plantaircompressors9_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors9_9pm}"  name="plantaircompressors9_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors9_1am}"  name="plantaircompressors9_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors9_5am}"  name="plantaircompressors9_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
				 		<tr>						 
							<td class="tg-yw4l" ><h1>WATER TEMPERATURE COMP.</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors10_9am}"  name="plantaircompressors10_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors10_1pm}"  name="plantaircompressors10_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors10_5pm}"  name="plantaircompressors10_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors10_9pm}"  name="plantaircompressors10_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors10_1am}"  name="plantaircompressors10_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors10_5am}"  name="plantaircompressors10_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
					<%--	<tr>						 
							<td class="tg-yw4l" ><h1>BLOW DOWN AIR RECEIVER TANK (DRAIN VLV AT BOTTOM) EVERY MONDAY AT 4 PM </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors11_9am}"  name="plantaircompressors11_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors11_1pm}"  name="plantaircompressors11_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors11_5pm}"  name="plantaircompressors11_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors11_9pm}"  name="plantaircompressors11_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors11_1am}"  name="plantaircompressors11_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors11_5am}"  name="plantaircompressors11_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>EVERY MONDAY AT 4 PM </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors12_9am}"  name="plantaircompressors12_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors12_1pm}"  name="plantaircompressors12_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors12_5pm}"  name="plantaircompressors12_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors12_9pm}"  name="plantaircompressors12_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors12_1am}"  name="plantaircompressors12_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors12_5am}"  name="plantaircompressors12_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>SWITCH AIR COMPRESSORS EVERY MONDAY AT 4 PM </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors13_9am}"  name="plantaircompressors13_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors13_1pm}"  name="plantaircompressors13_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors13_5pm}"  name="plantaircompressors13_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors13_9pm}"  name="plantaircompressors13_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors13_1am}"  name="plantaircompressors13_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors13_5am}"  name="plantaircompressors13_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>RECORD AIR COMPRESSORS LOADED TIME (HOURS) WHEN COMPRESSORS ARE SWITCH</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors14_9am}"  name="plantaircompressors14_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors14_1pm}"  name="plantaircompressors14_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors14_5pm}"  name="plantaircompressors14_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors14_9pm}"  name="plantaircompressors14_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors14_1am}"  name="plantaircompressors14_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors14_5am}"  name="plantaircompressors14_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  --%>
						<tr>						 
							<td class="tg-yw4l" ><h1>#1 COMPRESSORS LOADED TIME</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors15_9am}"  name="plantaircompressors15_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors15_1pm}"  name="plantaircompressors15_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors15_5pm}"  name="plantaircompressors15_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors15_9pm}"  name="plantaircompressors15_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors15_1am}"  name="plantaircompressors15_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors15_5am}"  name="plantaircompressors15_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>#2 COMPRESSORS LOADED TIME</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.plantaircompressors16_9am}"  name="plantaircompressors16_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.plantaircompressors16_1pm}"  name="plantaircompressors16_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors16_5pm}"  name="plantaircompressors16_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors16_9pm}"  name="plantaircompressors16_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors16_1am}"  name="plantaircompressors16_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.plantaircompressors16_5am}"  name="plantaircompressors16_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">MILL AIR DRYER</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>AIR PRESSURE INLET SIDE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer1_9am}"  name="millairdryer1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer1_1pm}"  name="millairdryer1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer1_5pm}"  name="millairdryer1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer1_9pm}"  name="millairdryer1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer1_1am}"  name="millairdryer1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer1_5am}"  name="millairdryer1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>AIR PRESSURE OUTLET SIDE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer2_9am}"  name="millairdryer2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer2_1pm}"  name="millairdryer2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer2_5pm}"  name="millairdryer2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer2_9pm}"  name="millairdryer2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer2_1am}"  name="millairdryer2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer2_5am}"  name="millairdryer2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>TEMPERATURE INLET SIDE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer3_9am}"  name="millairdryer3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer3_1pm}"  name="millairdryer3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer3_5pm}"  name="millairdryer3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer3_9pm}"  name="millairdryer3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer3_1am}"  name="millairdryer3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer3_5am}"  name="millairdryer3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>TEMPERATURE OUTLET SIDE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer4_9am}"  name="millairdryer4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer4_1pm}"  name="millairdryer4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer4_5pm}"  name="millairdryer4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer4_9pm}"  name="millairdryer4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer4_1am}"  name="millairdryer4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer4_5am}"  name="millairdryer4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>DEW POINT</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer5_9am}"  name="millairdryer5_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer5_1pm}"  name="millairdryer5_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer5_5pm}"  name="millairdryer5_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer5_9pm}"  name="millairdryer5_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer5_1am}"  name="millairdryer5_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer5_5am}"  name="millairdryer5_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>INDICATE DRYER TOWER</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer6_9am}"  name="millairdryer6_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer6_1pm}"  name="millairdryer6_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer6_5pm}"  name="millairdryer6_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer6_9pm}"  name="millairdryer6_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer6_1am}"  name="millairdryer6_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer6_5am}"  name="millairdryer6_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>DRYING STAGE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.millairdryer7_9am}"  name="millairdryer7_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.millairdryer7_1pm}"  name="millairdryer7_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer7_5pm}"  name="millairdryer7_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer7_9pm}"  name="millairdryer7_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer7_1am}"  name="millairdryer7_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.millairdryer7_5am}"  name="millairdryer7_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						 <tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">POLYMER AREA WATER FLOW RATE</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>PROFLOC 2724  (GPM)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>2</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate1_9am}"disabled  name="polymerareawaterflowrate1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate1_1pm}"  name="polymerareawaterflowrate1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate1_5pm}"disabled  name="polymerareawaterflowrate1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate1_9pm}" disabled name="polymerareawaterflowrate1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate1_1am}"  name="polymerareawaterflowrate1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate1_5am}" disabled name="polymerareawaterflowrate1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>PROFLOC 1414  (GPM)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>2</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate2_9am}"disabled  name="polymerareawaterflowrate2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate2_1pm}"  name="polymerareawaterflowrate2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate2_5pm}"disabled  name="polymerareawaterflowrate2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate2_9pm}" disabled name="polymerareawaterflowrate2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate2_1am}"  name="polymerareawaterflowrate2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate2_5am}" disabled name="polymerareawaterflowrate2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>FENNOFIX 502 (CC/MIN)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>2</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate3_9am}" disabled name="polymerareawaterflowrate3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate3_1pm}"  name="polymerareawaterflowrate3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate3_5pm}" disabled name="polymerareawaterflowrate3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate3_9pm}" disabled name="polymerareawaterflowrate3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate3_1am}"  name="polymerareawaterflowrate3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerareawaterflowrate3_5am}" disabled name="polymerareawaterflowrate3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">POLYMER FLOW RATE</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>PROFLOC 2724  (GPM)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>2</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.polymerflowrate1_9am}" disabled name="polymerflowrate1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.polymerflowrate1_1pm}"  name="polymerflowrate1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate1_5pm}"disabled  name="polymerflowrate1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate1_9pm}" disabled name="polymerflowrate1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate1_1am}"  name="polymerflowrate1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate1_5am}" disabled name="polymerflowrate1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>PROFLOC 1414  (GPM)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>2</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.polymerflowrate2_9am}"disabled  name="polymerflowrate2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.polymerflowrate2_1pm}"  name="polymerflowrate2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate2_5pm}" disabled name="polymerflowrate2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate2_9pm}" disabled name="polymerflowrate2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate2_1am}"  name="polymerflowrate2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate2_5am}" disabled name="polymerflowrate2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>FENNOFIX 502 (CC/MIN)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>2</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.polymerflowrate3_9am}" disabled name="polymerflowrate3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.polymerflowrate3_1pm}"  name="polymerflowrate3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate3_5pm}" disabled name="polymerflowrate3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate3_9pm}" disabled name="polymerflowrate3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate3_1am}"  name="polymerflowrate3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.polymerflowrate3_5am}" disabled name="polymerflowrate3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">TOTE LEVELS:</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>PROFLOC 2724</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.totelevels1_9am}"  name="totelevels1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.totelevels1_1pm}"  name="totelevels1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels1_5pm}"  name="totelevels1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels1_9pm}"  name="totelevels1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels1_1am}"  name="totelevels1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels1_5am}"  name="totelevels1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>PROFLOC 1414</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.totelevels2_9am}"  name="totelevels2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.totelevels2_1pm}"  name="totelevels2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels2_5pm}"  name="totelevels2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels2_9pm}"  name="totelevels2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels2_1am}"  name="totelevels2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels2_5am}"  name="totelevels2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>FENNOFIX 502</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.totelevels3_9am}"  name="totelevels3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.totelevels3_1pm}"  name="totelevels3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels3_5pm}"  name="totelevels3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels3_9pm}"  name="totelevels3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels3_1am}"  name="totelevels3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels3_5am}"  name="totelevels3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						 <tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">HEAT TRACE- Check all breakers during cold weather</h1></td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>430-CP3, 430-HPT1, HPT2, HPT3</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.totelevels4_9am}"  name="totelevels4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.totelevels4_1pm}" disabled name="totelevels4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels4_5pm}"  name="totelevels4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels4_9pm}" disabled name="totelevels4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels4_1am}"  name="totelevels4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.totelevels4_5am}" disabled name="totelevels4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>   
						<tr>
							<td style="text-align:center;background-color:powderblue;color:blue;font-size:16px;" >MISEED ROUND </td>
							<td></td>
							<td align="center"><input id="cmt9am" type="checkbox" ${data.cmt9amarea.length() >0 ? 'checked' : ''} style="width:20px;height:20px;margin-top: 6px;"></td>
							<td align="center"><input id="cmt1pm" type="checkbox" ${data.cmt1pmarea.length() >0 ? 'checked' : ''} style="width:20px;height:20px;margin-top: 4px;"></td>
							<td align="center"><input id="cmt5pm" type="checkbox" ${data.cmt5pmarea.length() >0 ? 'checked' : ''} style="width:20px;height:20px;margin-top: 4px;"></td>
							<td align="center"><input id="cmt9pm" type="checkbox" ${data.cmt9pmarea.length() >0 ? 'checked' : ''} style="width:20px;height:20px;margin-top: 4px;"></td>
							<td align="center"><input id="cmt1am" type="checkbox" ${data.cmt1amarea.length() >0 ? 'checked' : ''} style="width:20px;height:20px;margin-top: 4px;"></td>
							<td align="center"><input id="cmt5am" type="checkbox" ${data.cmt5amarea.length() >0 ? 'checked' : ''} style="width:20px;height:20px;margin-top: 4px;"></td>
						</tr>
						<tr >
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Missed Reason</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1></h1></td>
							<td >
								<input type="text" disabled  id="cmt9amarea" class="input" value="${data.cmt9amarea}"  name="cmt9amarea" style="margin-left: 1px !important;float: none;"/>
							</td>
							<td >
								<input type="text" disabled  id="cmt1pmarea"class="input" value="${data.cmt1pmarea}"  name="cmt1pmarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td  >
								<input type="text" disabled  id="cmt5pmarea"class="input" value="${data.cmt5pmarea}"  name="cmt5pmarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td   >
								<input type="text" disabled  id="cmt9pmarea"class="input" value="${data.cmt9pmarea}"  name="cmt9pmarea"  style="margin-left: 1px !important;float: none;"/>
							</td>
							<td  >
								<input type="text" disabled  id="cmt1amarea" class="input" value="${data.cmt1amarea}"  name="cmt1amarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td  >
								<input type="text" disabled  id="cmt5amarea" class="input" value="${data.cmt5amarea}"  name="cmt5amarea"  style="margin-left: 1px !important;float: none;"/>
							</td>
						</tr>										
				</table>
				 <table border="1" style="width:80%">		
				 	 <tr>
						<td width="30%"><h1 style="font-size: 15px;">COMMENTS :</h1></td>
						<td height="30">
							<p><textarea name="comments" cols="110" rows="5"><c:out value="${data.comments}"/></textarea></p>
						</td>					   					    		   
						</tr>	
				  </table>
		    </center>
		 </div>
		 		 
			   <c:choose>
			    <c:when test="${edit == 'yes'}">
			       <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn1" class="button">Print</button>
						<button class="button" type="submit"onclick="bClick()">Submit</button>
					</div>
			    </c:when>
			  
			    <c:otherwise>
			        <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn1" class="button">Print</button>
						<button class="button" type="submit"onclick="bClick()">Submit</button>
					</div>
			    </c:otherwise>
			</c:choose>
			
 	</c:if>	
 	</div>		
	  </form>		
		</div>
	</div>
	<script type="text/javascript">
	
	$(document).ready(function() {
    	   if(document.getElementById("cmt9am").checked==true&&document.getElementById("ok").checked==true)
    	   {
    		   $('#ok1').css({"background-color":"red"});
    		}
    	   if(document.getElementById("cmt1pm").checked==true&&document.getElementById("button1pm").checked==true)
    	   {
    		   $('#ok2').css({"background-color":"red"});
    	   }
    	   if(document.getElementById("cmt5pm").checked==true&&document.getElementById("button5pm").checked==true)
    	   {
    		   $('#ok3').css({"background-color":"red"});
    	   }
    	   if(document.getElementById("cmt9pm").checked==true&&document.getElementById("button9pm").checked==true)
    	   {
    		   $('#ok4').css({"background-color":"red"});
    	   }
    	   if(document.getElementById("cmt1am").checked==true&&document.getElementById("button1am").checked==true)
    	   {
    		   $('#ok5').css({"background-color":"red"});
    	   }
    	   if(document.getElementById("cmt5am").checked==true&&document.getElementById("button5am").checked==true)
    	   {
    		   $('#ok6').css({"background-color":"red"});
    	   }	
	});
	var idClicked;
	 $(document).ready(function() {
		 var count=0
	       $("input").click(function() { 	    	  
	    	   var checkBox = document.getElementById("cmt9am");
	    	   if(checkBox.checked==true&&idClicked==="cmt9am"){
	    		   var cmt9amarea= $('#cmt9amarea').val();
	    		   var ok= document.getElementById("ok");	    			   
	    		   if(cmt9amarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			  alert("Data already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("ok").checked!=true){
	    			  // $( "#ok" ).trigger( "click");
	    			// $("input[name='cmt9amarea']").prop('disabled', false);
	    			   $("input[name='cmt9amarea']").val(miss);
	    		   }else
	    			   $( "#cmt9am" ).prop( "checked", false );	
	    	   }	    		   
	    	  
	    	   var checkBox = document.getElementById("cmt1pm");	    	   
	    	   if(checkBox.checked==true&&idClicked==="cmt1pm"){
	    		   var cmt1pmarea= $('#cmt1pmarea').val();
	    		   var ok= document.getElementById("button1pm");
	    		   if(cmt1pmarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			   alert("Reason already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("button1pm").checked!=true){
	    			  // $( "#button1pm" ).trigger( "click" );
	    			//  $("input[name='cmt1pmarea']").prop('disabled', false);
	    			   $("input[name='cmt1pmarea']").val(miss);
	    		   }else
	    			   $( "#cmt1pm" ).prop( "checked", false );	
	    	   				    			  
	    	   }
	    	   var checkBox = document.getElementById("cmt5pm");
	    	   if(checkBox.checked==true&&idClicked==="cmt5pm"){
	    		   var cmt5pmarea= $('#cmt5pmarea').val();
	    		   var ok= document.getElementById("button5pm");
	    		   if(cmt5pmarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			   alert("Reason already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("button5pm").checked!=true){
	    			  // $( "#button5pm" ).trigger( "click" );
	    			 // $("input[name='cmt5pmarea']").prop('disabled', false);
	    			   $("input[name='cmt5pmarea']").val(miss);
	    		   }else
	    			   $( "#cmt5pm" ).prop( "checked", false );	
   	   					    			  
	    	   }
	    	   var checkBox = document.getElementById("cmt9pm");	    	  
	    	   if(checkBox.checked==true&&idClicked==="cmt9pm"){
	    		   var cmt9pmarea= $('#cmt9pmarea').val();
	    		   var ok= document.getElementById("button9pm");
	    		   if(cmt9pmarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			   alert("Reason already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("button9pm").checked!=true){
	    			 //  $( "#button9pm" ).trigger( "click" );
	    			//  $("input[name='cmt9pmarea']").prop('disabled', false);
	    			   $("input[name='cmt9pmarea']").val(miss);
	    		   }else
	    			   $( "#cmt9pm" ).prop( "checked", false );	
	   					    			  
	    	   }
	    	   var checkBox = document.getElementById("cmt1am");	    	 
	    	   if(checkBox.checked==true&&idClicked==="cmt1am"){
	    		   var cmt1amarea= $('#cmt1amarea').val();
	    		   var ok= document.getElementById("button1am");
	    		   if(cmt1amarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			   alert("Reason already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("button1am").checked!=true){
	    			 //  $( "#button1am" ).trigger( "click" );
	    			//  $("input[name='cmt1amarea']").prop('disabled', false);
	    			   $("input[name='cmt1amarea']").val(miss);
	    		   }else
	    			   $( "#cmt1am" ).prop( "checked", false );	
  					    			  
	    	   }
	    	   var checkBox = document.getElementById("cmt5am");
	    	   if(checkBox.checked==true&&idClicked==="cmt5am"){
	    		   var cmt5amarea= $('#cmt5amarea').val();
	    		   var ok= document.getElementById("button5am");
	    		   if(cmt5amarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			   alert("Reason already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("button5am").checked!=true){
	    			 //  $( "#button5am" ).trigger( "click" );
	    			 //  $("input[name='cmt5amarea']").prop('disabled', false);
	    			   $("input[name='cmt5amarea']").val(miss);
	    		   }else
	    			   $( "#cmt5am" ).prop( "checked", false );	
 					 	    			  
	    	   }
	       });
		 
	 });
	 $(document).ready(function() { 
       $("input").click(function() {
    	   var checkBox = document.getElementById("ok");
    	   var checkBox2 = document.getElementById("button1pm");
    	   var checkBox3 = document.getElementById("button5pm");
    	   var checkBox4 = document.getElementById("button9pm");
    	   var checkBox5 = document.getElementById("button1am");
    	   var checkBox6 = document.getElementById("button5am");
    	   /*  var cmt9amarea= $('#cmt9amarea').val();
    	   var cmt1pmarea= $('#cmt1pmarea').val();
    	   var cmt5pmarea= $('#cmt5pmarea').val();
    	   var cmt9pmarea= $('#cmt9pmarea').val();
    	   var cmt1amarea= $('#cmt1amarea').val();
    	   var cmt5amarea= $('#cmt5amarea').val();
    	  	if(checkBox.checked==true && cmt9amarea!='')
    		{
    		  alert("Missed Entry already filled");
    		  location.reload();
    		}else if(checkBox2.checked==true && cmt1pmarea!='')
    		{
      		  alert("Missed Entry already filled");
      		  location.reload();
      		}else if(checkBox3.checked==true && cmt5pmarea!='')
    		{
        		  alert("Missed Entry already filled");
        		  location.reload();
        		}else if(checkBox4.checked==true && cmt9pmarea!='')
        		{
            		  alert("Missed Entry already filled");
            		  location.reload();
            		}else if(checkBox5.checked==true && cmt1amarea!='')
            		{
                		  alert("Missed Entry already filled");
                		  location.reload();
                		}else if(checkBox6.checked==true && cmt5amarea!='')
                		{
                    		  alert("Missed Entry already filled");
                    		  location.reload();
                    		} */
    	  	
    	  	var position  = $('#operator').val();
    		var date = $('#date').val();
    	  	$.ajax({
    			url:'${hitURL}',
    			type:'POST',
    			data:{
    				date :date,
    				position:position    				
    			},
    			success:function(data){
    				var v1=data.ok1;
    				var v2=data.ok2;
    				var v3=data.ok3;
    				var v4=data.ok4;
    				var v5=data.ok5;
    				var v6=data.ok6;  
  if(idClicked==='ok' && v2!='button1pm'&&document.getElementById("cmt9am").checked==false){ 
	   $('input[name="vbritetank1_9am"]').val('OK');
	   $('input[name="vbritetank2_9am"]').val('OK');
	   $('input[name="vbritetank3_9am"]').val('OK');
	   $('input[name="causticunloadingarea1_9am"]').val('OK');
	   $('input[name="causticunloadingarea2_9am"]').val('OK');
	   $('input[name="clarifier1_9am"]').val('OK');
	 /*   $('input[name="clarifier2_9am"]').val('OK'); */
	   $('input[name="clarifier3_9am"]').val('OK');
	   $('input[name="clarifier4_9am"]').val('OK');
	   $('input[name="clarifier5_9am"]').val('OK');
	   
	   $('input[name="sludgepumpsdikedrain1_9am"]').val('OK');
	   $('input[name="sludgepumpsdikedrain2_9am"]').val('OK');
	  /*  $('input[name="mill_firewatersystem1_9am"]').val('OK'); */
	    $('input[name="mill_firewatersystem2_9am"]').val('OK');
		$('input[name="mill_firewatersystem3_9am"]').val('OK');
		  $('input[name="mill_firewatersystem4_9am"]').val('OK');
		$('input[name="mill_firewatersystem5_9am"]').val('OK');
		$('input[name="mill_firewatersystem6_9am"]').val('OK');	
		$('input[name="mill_firewatersystem7_9am"]').val('OK');	  
	
	   $('input[name="plantaircompressors1_9am"]').val('OK');
	    $('input[name="plantaircompressors2_9am"]').val('OK');
		 $('input[name="plantaircompressors3_9am"]').val('OK');
		 $('input[name="plantaircompressors4_9am"]').val('OK');
		  $('input[name="plantaircompressors5_9am"]').val('OK');
		  $('input[name="plantaircompressors6_9am"]').val('OK');
		 $('input[name="plantaircompressors7_9am"]').val('OK');
		  $('input[name="plantaircompressors8_9am"]').val('OK');
		 $('input[name="plantaircompressors9_9am"]').val('OK');
		 $('input[name="plantaircompressors10_9am"]').val('OK');
		  $('input[name="plantaircompressors11_9am"]').val('OK');
		 $('input[name="plantaircompressors12_9am"]').val('OK');
		  $('input[name="plantaircompressors13_9am"]').val('OK');
		 $('input[name="plantaircompressors14_9am"]').val('OK'); 
		  $('input[name="plantaircompressors15_9am"]').val('OK');
		  $('input[name="plantaircompressors16_9am"]').val('OK');
		  
		  
	   $('input[name="millairdryer1_9am"]').val('OK');
	   $('input[name="millairdryer2_9am"]').val('OK');
	   $('input[name="millairdryer3_9am"]').val('OK');
	   $('input[name="millairdryer4_9am"]').val('OK');
	   $('input[name="millairdryer5_9am"]').val('OK');
	   $('input[name="millairdryer6_9am"]').val('OK');
	   $('input[name="millairdryer7_9am"]').val('OK');
	   
	   
	/*    $('input[name="polymerareawaterflowrate1_9am"]').val('OK');
	   $('input[name="polymerareawaterflowrate2_9am"]').val('OK');
	   $('input[name="polymerareawaterflowrate3_9am"]').val('OK'); */
	   /* $('input[name="polymerflowrate1_9am"]').val('OK');
  		$('input[name="polymerflowrate2_9am"]').val('OK');
  		$('input[name="polymerflowrate3_9am"]').val('OK'); */
	   $('input[name="totelevels1_9am"]').val('OK');
	   $('input[name="totelevels2_9am"]').val('OK');
	   $('input[name="totelevels3_9am"]').val('OK');
	   $('input[name="totelevels4_9am"]').val('OK');
 }if(checkBox.checked!=true&&idClicked==="ok"){
        	 $('input[name="vbritetank1_9am"]').val('');
  		   $('input[name="vbritetank2_9am"]').val('');
  		   $('input[name="vbritetank3_9am"]').val('');
  		   $('input[name="causticunloadingarea1_9am"]').val('');
  		   $('input[name="causticunloadingarea2_9am"]').val('');
  		   $('input[name="clarifier1_9am"]').val('');
  		   $('input[name="clarifier2_9am"]').val('');
  		   $('input[name="clarifier3_9am"]').val('');
  		   $('input[name="clarifier4_9am"]').val('');
  		   $('input[name="clarifier5_9am"]').val('');
  		   
  		   $('input[name="sludgepumpsdikedrain1_9am"]').val('');
  		   $('input[name="sludgepumpsdikedrain2_9am"]').val('');
  		   $('input[name="mill_firewatersystem1_9am"]').val('');
  		    $('input[name="mill_firewatersystem2_9am"]').val('');
  			$('input[name="mill_firewatersystem3_9am"]').val('');
    		  $('input[name="mill_firewatersystem4_9am"]').val('');
    		$('input[name="mill_firewatersystem5_9am"]').val('');
    		$('input[name="mill_firewatersystem6_9am"]').val('');	
    		$('input[name="mill_firewatersystem7_9am"]').val('');	  
	
	   $('input[name="plantaircompressors1_9am"]').val('');
	    $('input[name="plantaircompressors2_9am"]').val('');
		 $('input[name="plantaircompressors3_9am"]').val('');
		 $('input[name="plantaircompressors4_9am"]').val('');
		  $('input[name="plantaircompressors5_9am"]').val('');
		  $('input[name="plantaircompressors6_9am"]').val('');
		 $('input[name="plantaircompressors7_9am"]').val('');
		  $('input[name="plantaircompressors8_9am"]').val('');
		 $('input[name="plantaircompressors9_9am"]').val('');
		 $('input[name="plantaircompressors10_9am"]').val('');
		  $('input[name="plantaircompressors11_9am"]').val('');
		 $('input[name="plantaircompressors12_9am"]').val('');
		  $('input[name="plantaircompressors13_9am"]').val('');
		 $('input[name="plantaircompressors14_9am"]').val(''); 
		  $('input[name="plantaircompressors15_9am"]').val('');
		 $('input[name="plantaircompressors16_9am"]').val('');
		  
		  
	   $('input[name="millairdryer1_9am"]').val('');
	   $('input[name="millairdryer2_9am"]').val('');
	   $('input[name="millairdryer3_9am"]').val('');
	   $('input[name="millairdryer4_9am"]').val('');
	   $('input[name="millairdryer5_9am"]').val('');
	   $('input[name="millairdryer6_9am"]').val('');
	   $('input[name="millairdryer7_9am"]').val('');
	   
	   
	   $('input[name="polymerareawaterflowrate1_9am"]').val('');
	   $('input[name="polymerareawaterflowrate2_9am"]').val('');
	   $('input[name="polymerareawaterflowrate3_9am"]').val('');
	 /* $('input[name="polymerflowrate1_9am"]').val('');
	$('input[name="polymerflowrate2_9am"]').val('');
	$('input[name="polymerflowrate3_9am"]').val(''); */
	
	   $('input[name="totelevels1_9am"]').val('');
	   $('input[name="totelevels2_9am"]').val('');
	   $('input[name="totelevels3_9am"]').val('');
	   $('input[name="totelevels4_9am"]').val('');
 }
   if(idClicked==='button1pm' && v3!='button5pm'&&document.getElementById("cmt1pm").checked==false){ 

       $('input[name="vbritetank1_1pm"]').val('OK');
		   $('input[name="vbritetank2_1pm"]').val('OK');
		   $('input[name="vbritetank3_1pm"]').val('OK');
		   $('input[name="causticunloadingarea1_1pm"]').val('OK');
		   $('input[name="causticunloadingarea2_1pm"]').val('OK');
		   $('input[name="clarifier1_1pm"]').val('OK');
		   $('input[name="clarifier2_1pm"]').val('OK');
		   $('input[name="clarifier3_1pm"]').val('OK');
		   $('input[name="clarifier4_1pm"]').val('OK');
		   $('input[name="clarifier5_1pm"]').val('OK');
		   
		   $('input[name="sludgepumpsdikedrain1_1pm"]').val('OK');
		   $('input[name="sludgepumpsdikedrain2_1pm"]').val('OK');
		  /*  $('input[name="mill_firewatersystem1_1pm"]').val('OK'); */
		    $('input[name="mill_firewatersystem2_1pm"]').val('OK');
			$('input[name="mill_firewatersystem3_1pm"]').val('OK');
		  $('input[name="mill_firewatersystem4_1pm"]').val('OK');
		$('input[name="mill_firewatersystem5_1pm"]').val('OK');
		$('input[name="mill_firewatersystem6_1pm"]').val('OK');	
		$('input[name="mill_firewatersystem7_1pm"]').val('OK');	  
		
		   $('input[name="plantaircompressors1_1pm"]').val('OK');
		    $('input[name="plantaircompressors2_1pm"]').val('OK');
			 $('input[name="plantaircompressors3_1pm"]').val('OK');
			 $('input[name="plantaircompressors4_1pm"]').val('OK');
			  $('input[name="plantaircompressors5_1pm"]').val('OK');
			  $('input[name="plantaircompressors6_1pm"]').val('OK');
			 $('input[name="plantaircompressors7_1pm"]').val('OK');
			  $('input[name="plantaircompressors8_1pm"]').val('OK');
			 $('input[name="plantaircompressors9_1pm"]').val('OK');
			 $('input[name="plantaircompressors10_1pm"]').val('OK');
			  $('input[name="plantaircompressors11_1pm"]').val('OK');
			 $('input[name="plantaircompressors12_1pm"]').val('OK');
			  $('input[name="plantaircompressors13_1pm"]').val('OK');
			 $('input[name="plantaircompressors14_1pm"]').val('OK'); 
			  $('input[name="plantaircompressors15_1pm"]').val('OK');
			  $('input[name="plantaircompressors16_1pm"]').val('OK');
			  
			  
		   $('input[name="millairdryer1_1pm"]').val('OK');
		   $('input[name="millairdryer2_1pm"]').val('OK');
		   $('input[name="millairdryer3_1pm"]').val('OK');
		   $('input[name="millairdryer4_1pm"]').val('OK');
		   $('input[name="millairdryer5_1pm"]').val('OK');
		   $('input[name="millairdryer6_1pm"]').val('OK');
		   $('input[name="millairdryer7_1pm"]').val('OK');
		   
		   
		   $('input[name="polymerareawaterflowrate1_1pm"]').val('OK');
		   $('input[name="polymerareawaterflowrate2_1pm"]').val('OK');
		   $('input[name="polymerareawaterflowrate3_1pm"]').val('OK');
		    $('input[name="polymerflowrate1_1pm"]').val('OK');
	  		$('input[name="polymerflowrate2_1pm"]').val('OK');
	  		$('input[name="polymerflowrate3_1pm"]').val('OK'); 
		   $('input[name="totelevels1_1pm"]').val('OK');
		   $('input[name="totelevels2_1pm"]').val('OK');
		   $('input[name="totelevels3_1pm"]').val('OK');
		  /*  $('input[name="totelevels4_1pm"]').val('OK'); */
 }if(checkBox2.checked!=true&&idClicked==="button1pm"){
	 $('input[name="vbritetank1_1pm"]').val('');
	   $('input[name="vbritetank2_1pm"]').val('');
	   $('input[name="vbritetank3_1pm"]').val('');
	   $('input[name="causticunloadingarea1_1pm"]').val('');
	   $('input[name="causticunloadingarea2_1pm"]').val('');
	   $('input[name="clarifier1_1pm"]').val('');
	   $('input[name="clarifier2_1pm"]').val('');
	   $('input[name="clarifier3_1pm"]').val('');
	   $('input[name="clarifier4_1pm"]').val('');
	   $('input[name="clarifier5_1pm"]').val('');
	   
	   $('input[name="sludgepumpsdikedrain1_1pm"]').val('');
	   $('input[name="sludgepumpsdikedrain2_1pm"]').val('');
	   $('input[name="mill_firewatersystem1_1pm"]').val('');
	    $('input[name="mill_firewatersystem2_1pm"]').val('');
		$('input[name="mill_firewatersystem3_1pm"]').val('');
		  $('input[name="mill_firewatersystem4_1pm"]').val('');
		$('input[name="mill_firewatersystem5_1pm"]').val('');
		$('input[name="mill_firewatersystem6_1pm"]').val('');	
		$('input[name="mill_firewatersystem7_1pm"]').val('');	  
	
	   $('input[name="plantaircompressors1_1pm"]').val('');
	    $('input[name="plantaircompressors2_1pm"]').val('');
		 $('input[name="plantaircompressors3_1pm"]').val('');
		 $('input[name="plantaircompressors4_1pm"]').val('');
		  $('input[name="plantaircompressors5_1pm"]').val('');
		  $('input[name="plantaircompressors6_1pm"]').val('');
		 $('input[name="plantaircompressors7_1pm"]').val('');
		  $('input[name="plantaircompressors8_1pm"]').val('');
		 $('input[name="plantaircompressors9_1pm"]').val('');
		 $('input[name="plantaircompressors10_1pm"]').val('');
		  $('input[name="plantaircompressors11_1pm"]').val('');
		 $('input[name="plantaircompressors12_1pm"]').val('');
		  $('input[name="plantaircompressors13_1pm"]').val('');
		 $('input[name="plantaircompressors14_1pm"]').val(''); 
		  $('input[name="plantaircompressors15_1pm"]').val('');
		 $('input[name="plantaircompressors16_1pm"]').val('');
		  
		  
	   $('input[name="millairdryer1_1pm"]').val('');
	   $('input[name="millairdryer2_1pm"]').val('');
	   $('input[name="millairdryer3_1pm"]').val('');
	   $('input[name="millairdryer4_1pm"]').val('');
	   $('input[name="millairdryer5_1pm"]').val('');
	   $('input[name="millairdryer6_1pm"]').val('');
	   $('input[name="millairdryer7_1pm"]').val('');
	   
	   
	   $('input[name="polymerareawaterflowrate1_1pm"]').val('');
	   $('input[name="polymerareawaterflowrate2_1pm"]').val('');
	   $('input[name="polymerareawaterflowrate3_1pm"]').val('');
	 /* $('input[name="polymerflowrate1_1pm"]').val('');
	$('input[name="polymerflowrate2_1pm"]').val('');
	$('input[name="polymerflowrate3_1pm"]').val(''); */
	
	   $('input[name="totelevels1_1pm"]').val('');
	   $('input[name="totelevels2_1pm"]').val('');
	   $('input[name="totelevels3_1pm"]').val('');
	   $('input[name="totelevels4_1pm"]').val('');
 } 		        
  if(idClicked==='button5pm' && v4!='button9pm'&&document.getElementById("cmt5pm").checked==false){ 
	     $('input[name="vbritetank1_5pm"]').val('OK');
		   $('input[name="vbritetank2_5pm"]').val('OK');
		   $('input[name="vbritetank3_5pm"]').val('OK');
		   $('input[name="causticunloadingarea1_5pm"]').val('OK');
		   $('input[name="causticunloadingarea2_5pm"]').val('OK');
		   $('input[name="clarifier1_5pm"]').val('OK');
		  /*  $('input[name="clarifier2_5pm"]').val('OK'); */
		   $('input[name="clarifier3_5pm"]').val('OK');
		   $('input[name="clarifier4_5pm"]').val('OK');
		   $('input[name="clarifier5_5pm"]').val('OK');
		   
		   $('input[name="sludgepumpsdikedrain1_5pm"]').val('OK');
		   $('input[name="sludgepumpsdikedrain2_5pm"]').val('OK');
		   $('input[name="mill_firewatersystem1_5pm"]').val('OK');
		    /* $('input[name="mill_firewatersystem2_5pm"]').val('OK'); */
			$('input[name="mill_firewatersystem3_5pm"]').val('OK');
			  $('input[name="mill_firewatersystem4_5pm"]').val('OK');
			$('input[name="mill_firewatersystem5_5pm"]').val('OK');
			$('input[name="mill_firewatersystem6_5pm"]').val('OK');	
			$('input[name="mill_firewatersystem7_5pm"]').val('OK');	  
		
		   $('input[name="plantaircompressors1_5pm"]').val('OK');
		    $('input[name="plantaircompressors2_5pm"]').val('OK');
			 $('input[name="plantaircompressors3_5pm"]').val('OK');
			 $('input[name="plantaircompressors4_5pm"]').val('OK');
			  $('input[name="plantaircompressors5_5pm"]').val('OK');
			  $('input[name="plantaircompressors6_5pm"]').val('OK');
			 $('input[name="plantaircompressors7_5pm"]').val('OK');
			  $('input[name="plantaircompressors8_5pm"]').val('OK');
			 $('input[name="plantaircompressors9_5pm"]').val('OK');
			 $('input[name="plantaircompressors10_5pm"]').val('OK');
			  $('input[name="plantaircompressors11_5pm"]').val('OK');
			 $('input[name="plantaircompressors12_5pm"]').val('OK');
			  $('input[name="plantaircompressors13_5pm"]').val('OK');
			 $('input[name="plantaircompressors14_5pm"]').val('OK'); 
			  $('input[name="plantaircompressors15_5pm"]').val('OK');
			  $('input[name="plantaircompressors16_5pm"]').val('OK');
			  
			  
		   $('input[name="millairdryer1_5pm"]').val('OK');
		   $('input[name="millairdryer2_5pm"]').val('OK');
		   $('input[name="millairdryer3_5pm"]').val('OK');
		   $('input[name="millairdryer4_5pm"]').val('OK');
		   $('input[name="millairdryer5_5pm"]').val('OK');
		   $('input[name="millairdryer6_5pm"]').val('OK');
		   $('input[name="millairdryer7_5pm"]').val('OK');
		   
		   
		 /*   $('input[name="polymerareawaterflowrate1_5pm"]').val('OK');
		   $('input[name="polymerareawaterflowrate2_5pm"]').val('OK');
		   $('input[name="polymerareawaterflowrate3_5pm"]').val('OK'); */
		   /* $('input[name="polymerflowrate1_5pm"]').val('OK');
	  		$('input[name="polymerflowrate2_5pm"]').val('OK');
	  		$('input[name="polymerflowrate3_5pm"]').val('OK'); */
		   $('input[name="totelevels1_5pm"]').val('OK');
		   $('input[name="totelevels2_5pm"]').val('OK');
		   $('input[name="totelevels3_5pm"]').val('OK');
		   $('input[name="totelevels4_5pm"]').val('OK');
	 }if(checkBox3.checked!=true&&idClicked==="button5pm"){
		 $('input[name="vbritetank1_5pm"]').val('');
		   $('input[name="vbritetank2_5pm"]').val('');
		   $('input[name="vbritetank3_5pm"]').val('');
		   $('input[name="causticunloadingarea1_5pm"]').val('');
		   $('input[name="causticunloadingarea2_5pm"]').val('');
		   $('input[name="clarifier1_5pm"]').val('');
		   $('input[name="clarifier2_5pm"]').val('');
		   $('input[name="clarifier3_5pm"]').val('');
		   $('input[name="clarifier4_5pm"]').val('');
		   $('input[name="clarifier5_5pm"]').val('');
		   
		   $('input[name="sludgepumpsdikedrain1_5pm"]').val('');
		   $('input[name="sludgepumpsdikedrain2_5pm"]').val('');
		   $('input[name="mill_firewatersystem1_5pm"]').val('');
		    $('input[name="mill_firewatersystem2_5pm"]').val('');
			$('input[name="mill_firewatersystem3_5pm"]').val('');
			  $('input[name="mill_firewatersystem4_5pm"]').val('');
			$('input[name="mill_firewatersystem5_5pm"]').val('');
			$('input[name="mill_firewatersystem6_5pm"]').val('');	
			$('input[name="mill_firewatersystem7_5pm"]').val('');	  
		
		   $('input[name="plantaircompressors1_5pm"]').val('');
		    $('input[name="plantaircompressors2_5pm"]').val('');
			 $('input[name="plantaircompressors3_5pm"]').val('');
			 $('input[name="plantaircompressors4_5pm"]').val('');
			  $('input[name="plantaircompressors5_5pm"]').val('');
			  $('input[name="plantaircompressors6_5pm"]').val('');
			 $('input[name="plantaircompressors7_5pm"]').val('');
			  $('input[name="plantaircompressors8_5pm"]').val('');
			 $('input[name="plantaircompressors9_5pm"]').val('');
			 $('input[name="plantaircompressors10_5pm"]').val('');
			  $('input[name="plantaircompressors11_5pm"]').val('');
			 $('input[name="plantaircompressors12_5pm"]').val('');
			  $('input[name="plantaircompressors13_5pm"]').val('');
			 $('input[name="plantaircompressors14_5pm"]').val(''); 
			  $('input[name="plantaircompressors15_5pm"]').val('');
			 $('input[name="plantaircompressors16_5pm"]').val('');
			  
			  
		   $('input[name="millairdryer1_5pm"]').val('');
		   $('input[name="millairdryer2_5pm"]').val('');
		   $('input[name="millairdryer3_5pm"]').val('');
		   $('input[name="millairdryer4_5pm"]').val('');
		   $('input[name="millairdryer6_5pm"]').val('');
		   $('input[name="millairdryer7_5pm"]').val('');
		   
		   
		   $('input[name="polymerareawaterflowrate1_5pm"]').val('');
		   $('input[name="polymerareawaterflowrate2_5pm"]').val('');
		   $('input[name="polymerareawaterflowrate3_5pm"]').val('');
		 /* $('input[name="polymerflowrate1_5pm"]').val('');
		$('input[name="polymerflowrate2_5pm"]').val('');
		$('input[name="polymerflowrate3_5pm"]').val(''); */
		
		   $('input[name="totelevels1_5pm"]').val('');
		   $('input[name="totelevels2_5pm"]').val('');
		   $('input[name="totelevels3_5pm"]').val('');
		   $('input[name="totelevels4_5pm"]').val('');
	 } 
   if(idClicked==='button9pm' && v5!='button1am'&&document.getElementById("cmt9pm").checked==false){ 
	   $('input[name="vbritetank1_9pm"]').val('OK');
	   $('input[name="vbritetank2_9pm"]').val('OK');
	   $('input[name="vbritetank3_9pm"]').val('OK');
	   $('input[name="causticunloadingarea1_9pm"]').val('OK');
	   $('input[name="causticunloadingarea2_9pm"]').val('OK');
	   $('input[name="clarifier1_9pm"]').val('OK');
	  /*  $('input[name="clarifier2_9pm"]').val('OK'); */
	   $('input[name="clarifier3_9pm"]').val('OK');
	   $('input[name="clarifier4_9pm"]').val('OK');
	   $('input[name="clarifier5_9pm"]').val('OK');
	   
	   $('input[name="sludgepumpsdikedrain1_9pm"]').val('OK');
	   $('input[name="sludgepumpsdikedrain2_9pm"]').val('OK');
	/*    $('input[name="mill_firewatersystem1_9pm"]').val('OK'); */
	    $('input[name="mill_firewatersystem2_9pm"]').val('OK');
		$('input[name="mill_firewatersystem3_9pm"]').val('OK');
		  $('input[name="mill_firewatersystem4_9pm"]').val('OK');
		$('input[name="mill_firewatersystem5_9pm"]').val('OK');
		$('input[name="mill_firewatersystem6_9pm"]').val('OK');	
		$('input[name="mill_firewatersystem7_9pm"]').val('OK');	  
	
	   $('input[name="plantaircompressors1_9pm"]').val('OK');
	    $('input[name="plantaircompressors2_9pm"]').val('OK');
		 $('input[name="plantaircompressors3_9pm"]').val('OK');
		 $('input[name="plantaircompressors4_9pm"]').val('OK');
		  $('input[name="plantaircompressors5_9pm"]').val('OK');
		  $('input[name="plantaircompressors6_9pm"]').val('OK');
		 $('input[name="plantaircompressors7_9pm"]').val('OK');
		  $('input[name="plantaircompressors8_9pm"]').val('OK');
		 $('input[name="plantaircompressors9_9pm"]').val('OK');
		 $('input[name="plantaircompressors10_9pm"]').val('OK');
		  $('input[name="plantaircompressors11_9pm"]').val('OK');
		 $('input[name="plantaircompressors12_9pm"]').val('OK');
		  $('input[name="plantaircompressors13_9pm"]').val('OK');
		 $('input[name="plantaircompressors14_9pm"]').val('OK'); 
		  $('input[name="plantaircompressors15_9pm"]').val('OK');
		  $('input[name="plantaircompressors16_9pm"]').val('OK');
		  
		  
	   $('input[name="millairdryer1_9pm"]').val('OK');
	   $('input[name="millairdryer2_9pm"]').val('OK');
	   $('input[name="millairdryer3_9pm"]').val('OK');
	   $('input[name="millairdryer4_9pm"]').val('OK');
	   $('input[name="millairdryer5_9pm"]').val('OK');
	   $('input[name="millairdryer6_9pm"]').val('OK');
	   $('input[name="millairdryer7_9pm"]').val('OK');
	   
	   
	 /*   $('input[name="polymerareawaterflowrate1_9pm"]').val('OK');
	   $('input[name="polymerareawaterflowrate2_9pm"]').val('OK');
	   $('input[name="polymerareawaterflowrate3_9pm"]').val('OK'); */
	   /* $('input[name="polymerflowrate1_9pm"]').val('OK');
  		$('input[name="polymerflowrate2_9pm"]').val('OK');
  		$('input[name="polymerflowrate3_9pm"]').val('OK'); */
	   $('input[name="totelevels1_9pm"]').val('OK');
	   $('input[name="totelevels2_9pm"]').val('OK');
	   $('input[name="totelevels3_9pm"]').val('OK');
	/*    $('input[name="totelevels4_9pm"]').val('OK'); */
 }if(checkBox4.checked!=true&&idClicked==="button9pm"){
        	 $('input[name="vbritetank1_9pm"]').val('');
  		   $('input[name="vbritetank2_9pm"]').val('');
  		   $('input[name="vbritetank3_9pm"]').val('');
  		   $('input[name="causticunloadingarea1_9pm"]').val('');
  		   $('input[name="causticunloadingarea2_9pm"]').val('');
  		   $('input[name="clarifier1_9pm"]').val('');
  		   $('input[name="clarifier2_9pm"]').val('');
  		   $('input[name="clarifier3_9pm"]').val('');
  		   $('input[name="clarifier4_9pm"]').val('');
  		   $('input[name="clarifier5_9pm"]').val('');
  		   
  		   $('input[name="sludgepumpsdikedrain1_9pm"]').val('');
  		   $('input[name="sludgepumpsdikedrain2_9pm"]').val('');
  		   $('input[name="mill_firewatersystem1_9pm"]').val('');
  		    $('input[name="mill_firewatersystem2_9pm"]').val('');
  			$('input[name="mill_firewatersystem3_9pm"]').val('');
    		  $('input[name="mill_firewatersystem4_9pm"]').val('');
    		$('input[name="mill_firewatersystem5_9pm"]').val('');
    		$('input[name="mill_firewatersystem6_9pm"]').val('');	
    		$('input[name="mill_firewatersystem7_9pm"]').val('');	  
	
	   $('input[name="plantaircompressors1_9pm"]').val('');
	    $('input[name="plantaircompressors2_9pm"]').val('');
		 $('input[name="plantaircompressors3_9pm"]').val('');
		 $('input[name="plantaircompressors4_9pm"]').val('');
		  $('input[name="plantaircompressors5_9pm"]').val('');
		  $('input[name="plantaircompressors6_9pm"]').val('');
		 $('input[name="plantaircompressors7_9pm"]').val('');
		  $('input[name="plantaircompressors8_9pm"]').val('');
		 $('input[name="plantaircompressors9_9pm"]').val('');
		 $('input[name="plantaircompressors10_9pm"]').val('');
		  $('input[name="plantaircompressors11_9pm"]').val('');
		 $('input[name="plantaircompressors12_9pm"]').val('');
		  $('input[name="plantaircompressors13_9pm"]').val('');
		 $('input[name="plantaircompressors14_9pm"]').val(''); 
		  $('input[name="plantaircompressors15_9pm"]').val('');
		 $('input[name="plantaircompressors16_9pm"]').val('');
		  
		  
	   $('input[name="millairdryer1_9pm"]').val('');
	   $('input[name="millairdryer2_9pm"]').val('');
	   $('input[name="millairdryer3_9pm"]').val('');
	   $('input[name="millairdryer4_9pm"]').val('');
	   $('input[name="millairdryer5_9pm"]').val('');
	   $('input[name="millairdryer6_9pm"]').val('');
	   $('input[name="millairdryer7_9pm"]').val('');
	   
	   
	   $('input[name="polymerareawaterflowrate1_9pm"]').val('');
	   $('input[name="polymerareawaterflowrate2_9pm"]').val('');
	   $('input[name="polymerareawaterflowrate3_9pm"]').val('');
	 /* $('input[name="polymerflowrate1_9pm"]').val('');
	$('input[name="polymerflowrate2_9pm"]').val('');
	$('input[name="polymerflowrate3_9pm"]').val(''); */
	
	   $('input[name="totelevels1_9pm"]').val('');
	   $('input[name="totelevels2_9pm"]').val('');
	   $('input[name="totelevels3_9pm"]').val('');
	   $('input[name="totelevels4_9pm"]').val('');
 } 
  if(idClicked==='button1am' && v6!='button5am'&&document.getElementById("cmt1am").checked==false){ 
	   $('input[name="vbritetank1_1am"]').val('OK');
	   $('input[name="vbritetank2_1am"]').val('OK');
	   $('input[name="vbritetank3_1am"]').val('OK');
	   $('input[name="causticunloadingarea1_1am"]').val('OK');
	   $('input[name="causticunloadingarea2_1am"]').val('OK');
	   $('input[name="clarifier1_1am"]').val('OK');
	   /* $('input[name="clarifier2_1am"]').val('OK'); */
	   $('input[name="clarifier3_1am"]').val('OK');
	   $('input[name="clarifier4_1am"]').val('OK');
	   $('input[name="clarifier5_1am"]').val('OK');
	   
	   $('input[name="sludgepumpsdikedrain1_1am"]').val('OK');
	   $('input[name="sludgepumpsdikedrain2_1am"]').val('OK');
	   $('input[name="mill_firewatersystem1_1am"]').val('OK');
	   /*  $('input[name="mill_firewatersystem2_1am"]').val('OK'); */
		$('input[name="mill_firewatersystem3_1am"]').val('OK');
		  $('input[name="mill_firewatersystem4_1am"]').val('OK');
		$('input[name="mill_firewatersystem5_1am"]').val('OK');
		$('input[name="mill_firewatersystem6_1am"]').val('OK');	
		$('input[name="mill_firewatersystem7_1am"]').val('OK');	  
	
	   $('input[name="plantaircompressors1_1am"]').val('OK');
	    $('input[name="plantaircompressors2_1am"]').val('OK');
		 $('input[name="plantaircompressors3_1am"]').val('OK');
		 $('input[name="plantaircompressors4_1am"]').val('OK');
		  $('input[name="plantaircompressors5_1am"]').val('OK');
		  $('input[name="plantaircompressors6_1am"]').val('OK');
		 $('input[name="plantaircompressors7_1am"]').val('OK');
		  $('input[name="plantaircompressors8_1am"]').val('OK');
		 $('input[name="plantaircompressors9_1am"]').val('OK');
		 $('input[name="plantaircompressors10_1am"]').val('OK');
		  $('input[name="plantaircompressors11_1am"]').val('OK');
		 $('input[name="plantaircompressors12_1am"]').val('OK');
		  $('input[name="plantaircompressors13_1am"]').val('OK');
		 $('input[name="plantaircompressors14_1am"]').val('OK'); 
		  $('input[name="plantaircompressors15_1am"]').val('OK');
		  $('input[name="plantaircompressors16_1am"]').val('OK');
		  
		  
	   $('input[name="millairdryer1_1am"]').val('OK');
	   $('input[name="millairdryer2_1am"]').val('OK');
	   $('input[name="millairdryer3_1am"]').val('OK');
	   $('input[name="millairdryer4_1am"]').val('OK');
	   $('input[name="millairdryer5_1am"]').val('OK');
	   $('input[name="millairdryer6_1am"]').val('OK');
	   $('input[name="millairdryer7_1am"]').val('OK');
	   
	   
	   $('input[name="polymerareawaterflowrate1_1am"]').val('OK');
	   $('input[name="polymerareawaterflowrate2_1am"]').val('OK');
	   $('input[name="polymerareawaterflowrate3_1am"]').val('OK');
	  $('input[name="polymerflowrate1_1am"]').val('OK');
  		$('input[name="polymerflowrate2_1am"]').val('OK');
  		$('input[name="polymerflowrate3_1am"]').val('OK');
	   $('input[name="totelevels1_1am"]').val('OK');
	   $('input[name="totelevels2_1am"]').val('OK');
	   $('input[name="totelevels3_1am"]').val('OK');
	   $('input[name="totelevels4_1am"]').val('OK');
}if(checkBox5.checked!=true&&idClicked==="button1am"){
        	 $('input[name="vbritetank1_1am"]').val('');
  		   $('input[name="vbritetank2_1am"]').val('');
  		   $('input[name="vbritetank3_1am"]').val('');
  		   $('input[name="causticunloadingarea1_1am"]').val('');
  		   $('input[name="causticunloadingarea2_1am"]').val('');
  		   $('input[name="clarifier1_1am"]').val('');
  		   $('input[name="clarifier2_1am"]').val('');
  		   $('input[name="clarifier3_1am"]').val('');
  		   $('input[name="clarifier4_1am"]').val('');
  		   $('input[name="clarifier5_1am"]').val('');
  		   
  		   $('input[name="sludgepumpsdikedrain1_1am"]').val('');
  		   $('input[name="sludgepumpsdikedrain2_1am"]').val('');
  		   $('input[name="mill_firewatersystem1_1am"]').val('');
  		    $('input[name="mill_firewatersystem2_1am"]').val('');
  			$('input[name="mill_firewatersystem3_1am"]').val('');
    		  $('input[name="mill_firewatersystem4_1am"]').val('');
    		$('input[name="mill_firewatersystem5_1am"]').val('');
    		$('input[name="mill_firewatersystem6_1am"]').val('');	
    		$('input[name="mill_firewatersystem7_1am"]').val('');	  
	
	   $('input[name="plantaircompressors1_1am"]').val('');
	    $('input[name="plantaircompressors2_1am"]').val('');
		 $('input[name="plantaircompressors3_1am"]').val('');
		 $('input[name="plantaircompressors4_1am"]').val('');
		  $('input[name="plantaircompressors5_1am"]').val('');
		  $('input[name="plantaircompressors6_1am"]').val('');
		 $('input[name="plantaircompressors7_1am"]').val('');
		  $('input[name="plantaircompressors8_1am"]').val('');
		 $('input[name="plantaircompressors9_1am"]').val('');
		 $('input[name="plantaircompressors10_1am"]').val('');
		  $('input[name="plantaircompressors11_1am"]').val('');
		 $('input[name="plantaircompressors12_1am"]').val('');
		  $('input[name="plantaircompressors13_1am"]').val('');
		 $('input[name="plantaircompressors14_1am"]').val(''); 
		  $('input[name="plantaircompressors15_1am"]').val('');
		 $('input[name="plantaircompressors16_1am"]').val('');
		  
		  
	   $('input[name="millairdryer1_1am"]').val('');
	   $('input[name="millairdryer2_1am"]').val('');
	   $('input[name="millairdryer3_1am"]').val('');
	   $('input[name="millairdryer4_1am"]').val('');
	   $('input[name="millairdryer5_1am"]').val('');
	   $('input[name="millairdryer6_1am"]').val('');
	   $('input[name="millairdryer7_1am"]').val('');
	   
	   
	   $('input[name="polymerareawaterflowrate1_1am"]').val('');
	   $('input[name="polymerareawaterflowrate2_1am"]').val('');
	   $('input[name="polymerareawaterflowrate3_1am"]').val('');
	 /* $('input[name="polymerflowrate1_1am"]').val('');
	$('input[name="polymerflowrate2_1am"]').val('');
	$('input[name="polymerflowrate3_1am"]').val(''); */
	
	   $('input[name="totelevels1_1am"]').val('');
	   $('input[name="totelevels2_1am"]').val('');
	   $('input[name="totelevels3_1am"]').val('');
	   $('input[name="totelevels4_1am"]').val('');
}
  if(idClicked==='button5am' &&document.getElementById("cmt5am").checked==false){
	   $('input[name="vbritetank1_5am"]').val('OK');
	   $('input[name="vbritetank2_5am"]').val('OK');
	   $('input[name="vbritetank3_5am"]').val('OK');
	   $('input[name="causticunloadingarea1_5am"]').val('OK');
	   $('input[name="causticunloadingarea2_5am"]').val('OK');
	   $('input[name="clarifier1_5am"]').val('OK');
	 /*   $('input[name="clarifier2_5am"]').val('OK'); */
	   $('input[name="clarifier3_5am"]').val('OK');
	   $('input[name="clarifier4_5am"]').val('OK');
	   $('input[name="clarifier5_5am"]').val('OK');
	   
	   $('input[name="sludgepumpsdikedrain1_5am"]').val('OK');
	   $('input[name="sludgepumpsdikedrain2_5am"]').val('OK');
	/*    $('input[name="mill_firewatersystem1_5am"]').val('OK'); */
	    $('input[name="mill_firewatersystem2_5am"]').val('OK');
		$('input[name="mill_firewatersystem3_5am"]').val('OK');
		  $('input[name="mill_firewatersystem4_5am"]').val('OK');
		$('input[name="mill_firewatersystem5_5am"]').val('OK');
		$('input[name="mill_firewatersystem6_5am"]').val('OK');	
		$('input[name="mill_firewatersystem7_5am"]').val('OK');	  
	
	   $('input[name="plantaircompressors1_5am"]').val('OK');
	    $('input[name="plantaircompressors2_5am"]').val('OK');
		 $('input[name="plantaircompressors3_5am"]').val('OK');
		 $('input[name="plantaircompressors4_5am"]').val('OK');
		  $('input[name="plantaircompressors5_5am"]').val('OK');
		  $('input[name="plantaircompressors6_5am"]').val('OK');
		 $('input[name="plantaircompressors7_5am"]').val('OK');
		  $('input[name="plantaircompressors8_5am"]').val('OK');
		 $('input[name="plantaircompressors9_5am"]').val('OK');
		 $('input[name="plantaircompressors10_5am"]').val('OK');
		  $('input[name="plantaircompressors11_5am"]').val('OK');
		 $('input[name="plantaircompressors12_5am"]').val('OK');
		  $('input[name="plantaircompressors13_5am"]').val('OK');
		 $('input[name="plantaircompressors14_5am"]').val('OK'); 
		  $('input[name="plantaircompressors15_5am"]').val('OK');
		  $('input[name="plantaircompressors16_5am"]').val('OK');
		  
		  
	   $('input[name="millairdryer1_5am"]').val('OK');
	   $('input[name="millairdryer2_5am"]').val('OK');
	   $('input[name="millairdryer3_5am"]').val('OK');
	   $('input[name="millairdryer4_5am"]').val('OK');
	   $('input[name="millairdryer5_5am"]').val('OK');
	   $('input[name="millairdryer6_5am"]').val('OK');
	   $('input[name="millairdryer7_5am"]').val('OK');
	   
	   
/* 	   $('input[name="polymerareawaterflowrate1_5am"]').val('OK');
	   $('input[name="polymerareawaterflowrate2_5am"]').val('OK');
	   $('input[name="polymerareawaterflowrate3_5am"]').val('OK'); */
	   /* $('input[name="polymerflowrate1_5am"]').val('OK');
  		$('input[name="polymerflowrate2_5am"]').val('OK');
  		$('input[name="polymerflowrate3_5am"]').val('OK'); */
	   $('input[name="totelevels1_5am"]').val('OK');
	   $('input[name="totelevels2_5am"]').val('OK');
	   $('input[name="totelevels3_5am"]').val('OK');
	/*    $('input[name="totelevels4_5am"]').val('OK'); */
}if(checkBox6.checked!=true&&idClicked==="button5am"){
        	 $('input[name="vbritetank1_5am"]').val('');
  		   $('input[name="vbritetank2_5am"]').val('');
  		   $('input[name="vbritetank3_5am"]').val('');
  		   $('input[name="causticunloadingarea1_5am"]').val('');
  		   $('input[name="causticunloadingarea2_5am"]').val('');
  		   $('input[name="clarifier1_5am"]').val('');
  		   $('input[name="clarifier2_5am"]').val('');
  		   $('input[name="clarifier3_5am"]').val('');
  		   $('input[name="clarifier4_5am"]').val('');
  		   $('input[name="clarifier5_5am"]').val('');
  		   
  		   $('input[name="sludgepumpsdikedrain1_5am"]').val('');
  		   $('input[name="sludgepumpsdikedrain2_5am"]').val('');
  		   $('input[name="mill_firewatersystem1_5am"]').val('');
  		    $('input[name="mill_firewatersystem2_5am"]').val('');
  			$('input[name="mill_firewatersystem3_5am"]').val('');
    		  $('input[name="mill_firewatersystem4_5am"]').val('');
    		$('input[name="mill_firewatersystem5_5am"]').val('');
    		$('input[name="mill_firewatersystem6_5am"]').val('');	
    		$('input[name="mill_firewatersystem7_5am"]').val('');	  
	
	   $('input[name="plantaircompressors1_5am"]').val('');
	    $('input[name="plantaircompressors2_5am"]').val('');
		 $('input[name="plantaircompressors3_5am"]').val('');
		 $('input[name="plantaircompressors4_5am"]').val('');
		  $('input[name="plantaircompressors5_5am"]').val('');
		  $('input[name="plantaircompressors6_5am"]').val('');
		 $('input[name="plantaircompressors7_5am"]').val('');
		  $('input[name="plantaircompressors8_5am"]').val('');
		 $('input[name="plantaircompressors9_5am"]').val('');
		 $('input[name="plantaircompressors10_5am"]').val('');
		  $('input[name="plantaircompressors11_5am"]').val('');
		 $('input[name="plantaircompressors12_5am"]').val('');
		  $('input[name="plantaircompressors13_5am"]').val('');
		 $('input[name="plantaircompressors14_5am"]').val(''); 
		  $('input[name="plantaircompressors15_5am"]').val('');
		 $('input[name="plantaircompressors16_5am"]').val('');
		  
		  
	   $('input[name="millairdryer1_5am"]').val('');
	   $('input[name="millairdryer2_5am"]').val('');
	   $('input[name="millairdryer3_5am"]').val('');
	   $('input[name="millairdryer4_5am"]').val('');
	   $('input[name="millairdryer5_5am"]').val('');
	   $('input[name="millairdryer6_5am"]').val('');
	   $('input[name="millairdryer7_5am"]').val('');
	   
	   
	   $('input[name="polymerareawaterflowrate1_5am"]').val('');
	   $('input[name="polymerareawaterflowrate2_5am"]').val('');
	   $('input[name="polymerareawaterflowrate3_5am"]').val('');
	 /* $('input[name="polymerflowrate1_5am"]').val('');
	$('input[name="polymerflowrate2_5am"]').val('');
	$('input[name="polymerflowrate3_5am"]').val(''); */
	
	   $('input[name="totelevels1_5am"]').val('');
	   $('input[name="totelevels2_5am"]').val('');
	   $('input[name="totelevels3_5am"]').val('');
	   $('input[name="totelevels4_5am"]').val('');
}
    			},
    			error: function(xhr, status, error) {
    				alert('Server error.. :-(' );
    				
    			}
    		});
    			
    	
       }); 
   }); 
	 $("input").click(function(e){
		     idClicked = e.target.id;
		});
	 
	 function bClick() {
		 var checkBox1 = document.getElementById("cmt9am");
		 var checkBox2 = document.getElementById("cmt1pm");
		 var checkBox3 = document.getElementById("cmt5pm");
		 var checkBox4 = document.getElementById("cmt9pm");
		 var checkBox5 = document.getElementById("cmt1am");
		 var checkBox6 = document.getElementById("cmt5am");
		 if(checkBox1.checked)
		 {
			document.getElementById("ok").checked=true;			
		 }
		 if(checkBox2.checked)
		 {
			document.getElementById("button1pm").checked=true;			
		 }
		 if(checkBox3.checked)
		 {
			document.getElementById("button5pm").checked=true;			
		 }
		 if(checkBox4.checked)
		 {
			document.getElementById("button9pm").checked=true;			
		 }
		 if(checkBox5.checked)
		 {
			document.getElementById("button1am").checked=true;			
		 }
		 if(checkBox6.checked)
		 {
			document.getElementById("button5am").checked=true;			
		 }	
		 $("input[name='cmt9amarea']").prop('disabled', false);
		 $("input[name='cmt1pmarea']").prop('disabled', false);
		 $("input[name='cmt5pmarea']").prop('disabled', false);
		 $("input[name='cmt9pmarea']").prop('disabled', false);
		 $("input[name='cmt1amarea']").prop('disabled', false);
		 $("input[name='cmt5amarea']").prop('disabled', false);
		}
	</script>
</body>
</html>
