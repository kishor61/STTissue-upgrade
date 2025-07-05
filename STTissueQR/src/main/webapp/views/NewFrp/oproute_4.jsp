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
		<c:if test="${data.position == 'OP4'}">	
			<spring:url value="/frpobccCommon/OpRoute_4/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Route 4 Basement</span>
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

 <c:if test="${data.position == 'OP4'}">
   <div id="printDiv">
   		 <center>
   		  <c:if test="${data.position == 'OP4'}">
		   	<h1 style="font-size: 21px;color: #518f3e;">Operator Route 4 Basement</h1>
		 </c:if>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Route 4 Basement</h1>
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
							<td class="tg-yw4l" ><h1>STATION - EQUIPMENT</h1></td>	
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1>FREQ</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 10:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 02:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 06:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 10:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 02:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 06:00 AM</h1></td>						    			   					    		   
						</tr>
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DUMP CHESTS</h1></td>
							<td></td> 
							<td align="center" id="ok1"><input id="ok"  type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="ok" name="ok" ${data.ok == 'ok' ? 'checked' : ''}></td>
							<td align="center" id="ok2"><input id="button1pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1pm" name="button1pm" ${data.button1pm == 'button1pm' ? 'checked' : ''}></td>
							<td align="center" id="ok3"><input id="button5pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5pm" name="button5pm" ${data.button5pm == 'button5pm' ? 'checked' : ''}></td>
							<td align="center" id="ok4"><input id="button9pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button9pm" name="button9pm" ${data.button9pm == 'button9pm' ? 'checked' : ''}></td>
							<td align="center" id="ok5"><input id="button1am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1am" name="button1am" ${data.button1am == 'button1am' ? 'checked' : ''}></td>
							<td align="center" id="ok6"><input id="button5am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5am" name="button5am" ${data.button5am == 'button5am' ? 'checked' : ''}></td>
						
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>VISUAL INSPECTION</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dumpchests1_10am}" disabled name="dumpchests1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dumpchests1_02pm}" disabled name="dumpchests1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests1_06pm}" disabled name="dumpchests1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests1_10pm}" disabled name="dumpchests1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests1_02am}" disabled name="dumpchests1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests1_06am}" disabled name="dumpchests1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1> #1 DUMP CHEST PUMP (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dumpchests2_10am}"  name="dumpchests2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dumpchests2_02pm}"  name="dumpchests2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests2_06pm}"  name="dumpchests2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests2_10pm}"  name="dumpchests2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests2_02am}"  name="dumpchests2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests2_06am}"  name="dumpchests2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1> #2 DUMP CHEST PUMP (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dumpchests3_10am}"  name="dumpchests3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dumpchests3_02pm}"  name="dumpchests3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests3_06pm}"  name="dumpchests3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests3_10pm}"  name="dumpchests3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests3_02am}"  name="dumpchests3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests3_06am}"  name="dumpchests3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1> #1 DUMP CHEST AGITATOR (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dumpchests4_10am}"  name="dumpchests4_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dumpchests4_02pm}"  name="dumpchests4_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests4_06pm}"  name="dumpchests4_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests4_10pm}"  name="dumpchests4_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests4_02am}"  name="dumpchests4_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests4_06am}"  name="dumpchests4_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>#2 DUMP CHEST AGITATOR (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dumpchests5_10am}"  name="dumpchests5_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dumpchests5_02pm}"  name="dumpchests5_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests5_06pm}"  name="dumpchests5_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests5_10pm}"  name="dumpchests5_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests5_02am}"  name="dumpchests5_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dumpchests5_06am}"  name="dumpchests5_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						
<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">CONTAMINEX PUMP (A-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY & VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.contaminexpump1_10am}"  name="contaminexpump1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.contaminexpump1_02pm}"  name="contaminexpump1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump1_06pm}"  name="contaminexpump1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump1_10pm}"  name="contaminexpump1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump1_02am}"  name="contaminexpump1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump1_06am}"  name="contaminexpump1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>MOTOR & PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.contaminexpump2_10am}"  name="contaminexpump2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.contaminexpump2_02pm}"  name="contaminexpump2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump2_06pm}"  name="contaminexpump2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump2_10pm}"  name="contaminexpump2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump2_02am}"  name="contaminexpump2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump2_06am}"  name="contaminexpump2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK SEAL WATER  FLOW</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.contaminexpump3_10am}"  name="contaminexpump3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.contaminexpump3_02pm}"  name="contaminexpump3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump3_06pm}"  name="contaminexpump3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump3_10pm}"  name="contaminexpump3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump3_02am}"  name="contaminexpump3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.contaminexpump3_06am}"  name="contaminexpump3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">REJECTS COLLECTION BUNKER</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY & VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker1_10am}"  name="rejectscollectionbunker1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker1_02pm}"  name="rejectscollectionbunker1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker1_06pm}"  name="rejectscollectionbunker1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker1_10pm}"  name="rejectscollectionbunker1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker1_02am}"  name="rejectscollectionbunker1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker1_06am}"  name="rejectscollectionbunker1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK DRUM SCREEN HOPPER</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker2_10am}"  name="rejectscollectionbunker2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker2_02pm}"  name="rejectscollectionbunker2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker2_06pm}"  name="rejectscollectionbunker2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker2_10pm}"  name="rejectscollectionbunker2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker2_02am}"  name="rejectscollectionbunker2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectscollectionbunker2_06am}"  name="rejectscollectionbunker2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">BATCH PULPER BASEMENT (A-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK SEAL WATER FLOW</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement1_10am}"  name="batchpulperbasement1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement1_02pm}"  name="batchpulperbasement1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement1_06pm}"  name="batchpulperbasement1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement1_10pm}"  name="batchpulperbasement1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement1_02am}"  name="batchpulperbasement1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement1_06am}"  name="batchpulperbasement1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1> SEAL H2O PAN CLEAN, DRAINING</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement2_10am}"  name="batchpulperbasement2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement2_02pm}"  name="batchpulperbasement2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement2_06pm}"  name="batchpulperbasement2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement2_10pm}"  name="batchpulperbasement2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement2_02am}"  name="batchpulperbasement2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement2_06am}"  name="batchpulperbasement2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>PACKING CONDITION</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement3_10am}"  name="batchpulperbasement3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement3_02pm}"  name="batchpulperbasement3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement3_06pm}"  name="batchpulperbasement3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement3_10pm}"  name="batchpulperbasement3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement3_02am}"  name="batchpulperbasement3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement3_06am}"  name="batchpulperbasement3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>OIL TEMPERATURE RANGE 55-60o C</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement4_10am}"  name="batchpulperbasement4_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement4_02pm}"  name="batchpulperbasement4_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement4_06pm}"  name="batchpulperbasement4_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement4_10pm}"  name="batchpulperbasement4_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement4_02am}"  name="batchpulperbasement4_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.batchpulperbasement4_06am}"  name="batchpulperbasement4_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DETRASHER (A-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.detrasher1_10am}"  name="detrasher1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.detrasher1_02pm}"  name="detrasher1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher1_06pm}"  name="detrasher1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher1_10pm}"  name="detrasher1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher1_02am}"  name="detrasher1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher1_06am}"  name="detrasher1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>PUMP AND SCAVENGER</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.detrasher2_10am}"  name="detrasher2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.detrasher2_02pm}"  name="detrasher2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher2_06pm}"  name="detrasher2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher2_10pm}"  name="detrasher2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher2_02am}"  name="detrasher2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher2_06am}"  name="detrasher2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Seal Water to Packing</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.detrasher3_10am}" disabled name="detrasher3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.detrasher3_02pm}"  name="detrasher3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher3_06pm}"  name="detrasher3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher3_10pm}" disabled name="detrasher3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher3_02am}"  name="detrasher3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.detrasher3_06am}" disabled name="detrasher3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">REJECTS PRESS (A-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.rejectspress1_10am}"  name="rejectspress1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.rejectspress1_02pm}"  name="rejectspress1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress1_06pm}"  name="rejectspress1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress1_10pm}"  name="rejectspress1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress1_02am}"  name="rejectspress1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress1_06am}"  name="rejectspress1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>VERIFY RAM STROKING (WATCH IT)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.rejectspress2_10am}"  name="rejectspress2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.rejectspress2_02pm}"  name="rejectspress2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress2_06pm}"  name="rejectspress2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress2_10pm}"  name="rejectspress2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress2_02am}"  name="rejectspress2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress2_06am}"  name="rejectspress2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK HYDRAULIC SYSTEM</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.rejectspress3_10am}"  name="rejectspress3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.rejectspress3_02pm}"  name="rejectspress3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress3_06pm}"  name="rejectspress3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress3_10pm}"  name="rejectspress3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress3_02am}"  name="rejectspress3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rejectspress3_06am}"  name="rejectspress3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DEWATERING SCREW</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>SCREW TURNING</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dewateringscrew1_10am}"  name="dewateringscrew1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dewateringscrew1_02pm}"  name="dewateringscrew1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew1_06pm}"  name="dewateringscrew1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew1_10pm}"  name="dewateringscrew1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew1_02am}"  name="dewateringscrew1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew1_06am}"  name="dewateringscrew1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>DRAIN VALVE CLOSED</h1></td>
						<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dewateringscrew2_10am}"  name="dewateringscrew2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dewateringscrew2_02pm}"  name="dewateringscrew2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew2_06pm}"  name="dewateringscrew2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew2_10pm}"  name="dewateringscrew2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew2_02am}"  name="dewateringscrew2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew2_06am}"  name="dewateringscrew2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>STAPLES FALLING</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.dewateringscrew3_10am}"  name="dewateringscrew3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.dewateringscrew3_02pm}"  name="dewateringscrew3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew3_06pm}"  name="dewateringscrew3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew3_10pm}"  name="dewateringscrew3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew3_02am}"  name="dewateringscrew3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.dewateringscrew3_06am}"  name="dewateringscrew3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">CLARIFIED WATER CHEST (A-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY & VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest1_10am}"  name="clarifiedwaterchest1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest1_02pm}"  name="clarifiedwaterchest1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest1_06pm}"  name="clarifiedwaterchest1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest1_10pm}"  name="clarifiedwaterchest1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest1_02am}"  name="clarifiedwaterchest1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest1_06am}"  name="clarifiedwaterchest1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>MOTOR & PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest2_10am}"  name="clarifiedwaterchest2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest2_02pm}"  name="clarifiedwaterchest2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest2_06pm}"  name="clarifiedwaterchest2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest2_10pm}"  name="clarifiedwaterchest2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest2_02am}"  name="clarifiedwaterchest2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.clarifiedwaterchest2_06am}"  name="clarifiedwaterchest2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DEINK WHITE WATER CHEST (B-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY & VISUAL OF MOTOR & PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest1_10am}"  name="deinkwhitewaterchest1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest1_02pm}"  name="deinkwhitewaterchest1_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest1_06pm}"  name="deinkwhitewaterchest1_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest1_10pm}"  name="deinkwhitewaterchest1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest1_02am}"  name="deinkwhitewaterchest1_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest1_06am}"  name="deinkwhitewaterchest1_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>BAR SCREEN AND SUMP AREA</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest2_10am}"  name="deinkwhitewaterchest2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest2_02pm}"  name="deinkwhitewaterchest2_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest2_06pm}"  name="deinkwhitewaterchest2_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest2_10pm}"  name="deinkwhitewaterchest2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest2_02am}"  name="deinkwhitewaterchest2_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest2_06am}"  name="deinkwhitewaterchest2_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						 <tr>						 
							<td class="tg-yw4l" ><h1>COLLECT SUMP SAMPLE </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>1</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest3_10am}" disabled name="deinkwhitewaterchest3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest3_02pm}" disabled name="deinkwhitewaterchest3_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest3_06pm}" disabled name="deinkwhitewaterchest3_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest3_10pm}" disabled name="deinkwhitewaterchest3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest3_02am}" disabled name="deinkwhitewaterchest3_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest3_06am}"  name="deinkwhitewaterchest3_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Visual check of U Drains for stock</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest4_10am}" disabled name="deinkwhitewaterchest4_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest4_02pm}"  name="deinkwhitewaterchest4_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest4_06pm}" disabled  name="deinkwhitewaterchest4_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest4_10pm}"  name="deinkwhitewaterchest4_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest4_02am}" disabled name="deinkwhitewaterchest4_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest4_06am}"  name="deinkwhitewaterchest4_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>Roll Up All Wash-Up Hoses in Basement</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest5_10am}"  name="deinkwhitewaterchest5_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest5_02pm}"  name="deinkwhitewaterchest5_02pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest5_06pm}"  name="deinkwhitewaterchest5_06pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest5_10pm}"  name="deinkwhitewaterchest5_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest5_02am}"  name="deinkwhitewaterchest5_02am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deinkwhitewaterchest5_06am}"  name="deinkwhitewaterchest5_06am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 	<tr>
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
								<input type="text"  disabled id="cmt9amarea" class="input" value="${data.cmt9amarea}"  name="cmt9amarea" style="margin-left: 1px !important;float: none;"/>
							</td>
							<td >
								<input type="text"  disabled id="cmt1pmarea"class="input" value="${data.cmt1pmarea}"  name="cmt1pmarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td  >
								<input type="text" disabled  id="cmt5pmarea"class="input" value="${data.cmt5pmarea}"  name="cmt5pmarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td   >
								<input type="text"  disabled id="cmt9pmarea"class="input" value="${data.cmt9pmarea}"  name="cmt9pmarea"  style="margin-left: 1px !important;float: none;"/>
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
	    			 // $("input[name='cmt1pmarea']").prop('disabled', false);
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
	    			 // $("input[name='cmt1amarea']").prop('disabled', false);
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
    					  /*  $('input[name="dumpchests1_10am"]').val('OK'); */
    		    		   $('input[name="dumpchests2_10am"]').val('OK');
    		    		   $('input[name="dumpchests3_10am"]').val('OK');
    		    		   $('input[name="dumpchests4_10am"]').val('OK');
    		    		   $('input[name="dumpchests5_10am"]').val('OK');
    		    		   $('input[name="contaminexpump1_10am"]').val('OK');
    		    		   $('input[name="contaminexpump2_10am"]').val('OK');
    		    		   $('input[name="contaminexpump3_10am"]').val('OK');
    		    		   $('input[name="rejectscollectionbunker1_10am"]').val('OK');
    		    		   $('input[name="rejectscollectionbunker2_10am"]').val('OK');
    		    		   $('input[name="batchpulperbasement1_10am"]').val('OK');
    		    		   $('input[name="batchpulperbasement2_10am"]').val('OK');
    		    		   $('input[name="batchpulperbasement3_10am"]').val('OK');
    		    		   $('input[name="batchpulperbasement4_10am"]').val('OK');
    		    		   $('input[name="detrasher1_10am"]').val('OK');
    		    		   $('input[name="detrasher2_10am"]').val('OK');
    		    		  /*  $('input[name="detrasher3_10am"]').val('OK'); */
    		    		   $('input[name="rejectspress1_10am"]').val('OK');
    		    		   $('input[name="rejectspress2_10am"]').val('OK');
    		    		   $('input[name="rejectspress3_10am"]').val('OK');
    		    		   $('input[name="dewateringscrew1_10am"]').val('OK');
    		    		   $('input[name="dewateringscrew2_10am"]').val('OK');
    		    		   $('input[name="dewateringscrew3_10am"]').val('OK');
    		    		   $('input[name="clarifiedwaterchest1_10am"]').val('OK');
    		    		   $('input[name="clarifiedwaterchest2_10am"]').val('OK');
    		    		   $('input[name="deinkwhitewaterchest1_10am"]').val('OK');
    		    		   $('input[name="deinkwhitewaterchest2_10am"]').val('OK');
    		    		  /*  $('input[name="deinkwhitewaterchest3_10am"]').val('OK');
    		    		   $('input[name="deinkwhitewaterchest4_10am"]').val('OK'); */
    		    		   $('input[name="deinkwhitewaterchest5_10am"]').val('OK');
    		         }if(checkBox.checked!=true&&idClicked==="ok"){
    		        	 $('input[name="dumpchests1_10am"]').val('');
    		        	 $('input[name="dumpchests2_10am"]').val('');
    		        	 $('input[name="dumpchests3_10am"]').val('');
    		        	 $('input[name="dumpchests4_10am"]').val('');
    		        	 $('input[name="dumpchests5_10am"]').val('');
    		        	 $('input[name="contaminexpump1_10am"]').val('');
    		        	 $('input[name="contaminexpump2_10am"]').val('');
    		        	 $('input[name="contaminexpump3_10am"]').val('');
    		        	 $('input[name="rejectscollectionbunker1_10am"]').val('');
    		        	 $('input[name="rejectscollectionbunker2_10am"]').val('');
    		        	 $('input[name="batchpulperbasement1_10am"]').val('');
    		        	 $('input[name="batchpulperbasement2_10am"]').val('');
    		        	 $('input[name="batchpulperbasement3_10am"]').val('');
    		        	 $('input[name="batchpulperbasement4_10am"]').val('');
    		        	 $('input[name="detrasher1_10am"]').val('');
    		        	 $('input[name="detrasher2_10am"]').val('');
    		        	 $('input[name="detrasher3_10am"]').val('');
    		        	 $('input[name="rejectspress1_10am"]').val('');
    		        	 $('input[name="rejectspress2_10am"]').val('');
    		        	 $('input[name="rejectspress3_10am"]').val('');
    		        	 $('input[name="dewateringscrew1_10am"]').val('');
    		        	 $('input[name="dewateringscrew2_10am"]').val('');
    		        	 $('input[name="dewateringscrew3_10am"]').val('');
    		        	 $('input[name="clarifiedwaterchest1_10am"]').val('');
    		        	 $('input[name="clarifiedwaterchest2_10am"]').val('');
    		        	 $('input[name="deinkwhitewaterchest1_10am"]').val('');
    		        	 $('input[name="deinkwhitewaterchest2_10am"]').val('');
    		        	 $('input[name="deinkwhitewaterchest3_10am"]').val('');
    		        	 $('input[name="deinkwhitewaterchest4_10am"]').val('');
    		        	 $('input[name="deinkwhitewaterchest5_10am"]').val('');
    		         } 
    		   if(idClicked==='button1pm' && v3!='button5pm'&&document.getElementById("cmt1pm").checked==false){ 
    			   /*  $('input[name="dumpchests1_02pm"]').val('OK'); */
    	  		   $('input[name="dumpchests2_02pm"]').val('OK');
    	  		   $('input[name="dumpchests3_02pm"]').val('OK');
    	  		   $('input[name="dumpchests4_02pm"]').val('OK');
    	  		   $('input[name="dumpchests5_02pm"]').val('OK');
    	  		   $('input[name="contaminexpump1_02pm"]').val('OK');
    	  		   $('input[name="contaminexpump2_02pm"]').val('OK');
    	  		   $('input[name="contaminexpump3_02pm"]').val('OK');
    	  		   $('input[name="rejectscollectionbunker1_02pm"]').val('OK');
    	  		   $('input[name="rejectscollectionbunker2_02pm"]').val('OK');
    	  		   $('input[name="batchpulperbasement1_02pm"]').val('OK');
    	  		   $('input[name="batchpulperbasement2_02pm"]').val('OK');
    	  		   $('input[name="batchpulperbasement3_02pm"]').val('OK');
    	  		   $('input[name="batchpulperbasement4_02pm"]').val('OK');
    	  		   $('input[name="detrasher1_02pm"]').val('OK');
    	  		   $('input[name="detrasher2_02pm"]').val('OK');
    	  		   $('input[name="detrasher3_02pm"]').val('OK');
    	  		   $('input[name="rejectspress1_02pm"]').val('OK');
    	  		   $('input[name="rejectspress2_02pm"]').val('OK');
    	  		   $('input[name="rejectspress3_02pm"]').val('OK');
    	  		   $('input[name="dewateringscrew1_02pm"]').val('OK');
    	  		   $('input[name="dewateringscrew2_02pm"]').val('OK');
    	  		   $('input[name="dewateringscrew3_02pm"]').val('OK');
    	  		   $('input[name="clarifiedwaterchest1_02pm"]').val('OK');
    	  		   $('input[name="clarifiedwaterchest2_02pm"]').val('OK');
    	  		   $('input[name="deinkwhitewaterchest1_02pm"]').val('OK');
    	  		   $('input[name="deinkwhitewaterchest2_02pm"]').val('OK');
    	  		   /* $('input[name="deinkwhitewaterchest3_02pm"]').val('OK'); */
    	  		   $('input[name="deinkwhitewaterchest4_02pm"]').val('OK');
    	  		   $('input[name="deinkwhitewaterchest5_02pm"]').val('OK');
    	       }if(checkBox2.checked!=true&&idClicked==="button1pm"){
    	      	 $('input[name="dumpchests1_02pm"]').val('');
    	      	 $('input[name="dumpchests2_02pm"]').val('');
    	      	 $('input[name="dumpchests3_02pm"]').val('');
    	      	 $('input[name="dumpchests4_02pm"]').val('');
    	      	 $('input[name="dumpchests5_02pm"]').val('');
    	      	 $('input[name="contaminexpump1_02pm"]').val('');
    	      	 $('input[name="contaminexpump2_02pm"]').val('');
    	      	 $('input[name="contaminexpump3_02pm"]').val('');
    	      	 $('input[name="rejectscollectionbunker1_02pm"]').val('');
    	      	 $('input[name="rejectscollectionbunker2_02pm"]').val('');
    	      	 $('input[name="batchpulperbasement1_02pm"]').val('');
    	      	 $('input[name="batchpulperbasement2_02pm"]').val('');
    	      	 $('input[name="batchpulperbasement3_02pm"]').val('');
    	      	 $('input[name="batchpulperbasement4_02pm"]').val('');
    	      	 $('input[name="detrasher1_02pm"]').val('');
    	      	 $('input[name="detrasher2_02pm"]').val('');
    	      	 $('input[name="detrasher3_02pm"]').val('');
    	      	 $('input[name="rejectspress1_02pm"]').val('');
    	      	 $('input[name="rejectspress2_02pm"]').val('');
    	      	 $('input[name="rejectspress3_02pm"]').val('');
    	      	 $('input[name="dewateringscrew1_02pm"]').val('');
    	      	 $('input[name="dewateringscrew2_02pm"]').val('');
    	      	 $('input[name="dewateringscrew3_02pm"]').val('');
    	      	 $('input[name="clarifiedwaterchest1_02pm"]').val('');
    	      	 $('input[name="clarifiedwaterchest2_02pm"]').val('');
    	      	 $('input[name="deinkwhitewaterchest1_02pm"]').val('');
    	      	 $('input[name="deinkwhitewaterchest2_02pm"]').val('');
    	      	 $('input[name="deinkwhitewaterchest3_02pm"]').val('');
    	      	 $('input[name="deinkwhitewaterchest4_02pm"]').val('');
    	      	 $('input[name="deinkwhitewaterchest5_02pm"]').val('');
    	       } 
    		   if(idClicked==='button5pm' && v4!='button9pm'&&document.getElementById("cmt5pm").checked==false){ 
    			   /*    $('input[name="dumpchests1_06pm"]').val('OK'); */
    			   $('input[name="dumpchests2_06pm"]').val('OK');
    			   $('input[name="dumpchests3_06pm"]').val('OK');
    			   $('input[name="dumpchests4_06pm"]').val('OK');
    			   $('input[name="dumpchests5_06pm"]').val('OK');
    			   $('input[name="contaminexpump1_06pm"]').val('OK');
    			   $('input[name="contaminexpump2_06pm"]').val('OK');
    			   $('input[name="contaminexpump3_06pm"]').val('OK');
    			   $('input[name="rejectscollectionbunker1_06pm"]').val('OK');
    			   $('input[name="rejectscollectionbunker2_06pm"]').val('OK');
    			   $('input[name="batchpulperbasement1_06pm"]').val('OK');
    			   $('input[name="batchpulperbasement2_06pm"]').val('OK');
    			   $('input[name="batchpulperbasement3_06pm"]').val('OK');
    			   $('input[name="batchpulperbasement4_06pm"]').val('OK');
    			   $('input[name="detrasher1_06pm"]').val('OK');
    			   $('input[name="detrasher2_06pm"]').val('OK');
    			   $('input[name="detrasher3_06pm"]').val('OK');
    			   $('input[name="rejectspress1_06pm"]').val('OK');
    			   $('input[name="rejectspress2_06pm"]').val('OK');
    			   $('input[name="rejectspress3_06pm"]').val('OK');
    			   $('input[name="dewateringscrew1_06pm"]').val('OK');
    			   $('input[name="dewateringscrew2_06pm"]').val('OK');
    			   $('input[name="dewateringscrew3_06pm"]').val('OK');
    			   $('input[name="clarifiedwaterchest1_06pm"]').val('OK');
    			   $('input[name="clarifiedwaterchest2_06pm"]').val('OK');
    			   $('input[name="deinkwhitewaterchest1_06pm"]').val('OK');
    			   $('input[name="deinkwhitewaterchest2_06pm"]').val('OK');
    			  /*  $('input[name="deinkwhitewaterchest3_06pm"]').val('OK');
    			   $('input[name="deinkwhitewaterchest4_06pm"]').val('OK'); */
    			   $('input[name="deinkwhitewaterchest5_06pm"]').val('OK');
    	     }if(checkBox3.checked!=true&&idClicked==="button5pm"){
    	    	 $('input[name="dumpchests1_06pm"]').val('');
    	    	 $('input[name="dumpchests2_06pm"]').val('');
    	    	 $('input[name="dumpchests3_06pm"]').val('');
    	    	 $('input[name="dumpchests4_06pm"]').val('');
    	    	 $('input[name="dumpchests5_06pm"]').val('');
    	    	 $('input[name="contaminexpump1_06pm"]').val('');
    	    	 $('input[name="contaminexpump2_06pm"]').val('');
    	    	 $('input[name="contaminexpump3_06pm"]').val('');
    	    	 $('input[name="rejectscollectionbunker1_06pm"]').val('');
    	    	 $('input[name="rejectscollectionbunker2_06pm"]').val('');
    	    	 $('input[name="batchpulperbasement1_06pm"]').val('');
    	    	 $('input[name="batchpulperbasement2_06pm"]').val('');
    	    	 $('input[name="batchpulperbasement3_06pm"]').val('');
    	    	 $('input[name="batchpulperbasement4_06pm"]').val('');
    	    	 $('input[name="detrasher1_06pm"]').val('');
    	    	 $('input[name="detrasher2_06pm"]').val('');
    	    	 $('input[name="detrasher3_06pm"]').val('');
    	    	 $('input[name="rejectspress1_06pm"]').val('');
    	    	 $('input[name="rejectspress2_06pm"]').val('');
    	    	 $('input[name="rejectspress3_06pm"]').val('');
    	    	 $('input[name="dewateringscrew1_06pm"]').val('');
    	    	 $('input[name="dewateringscrew2_06pm"]').val('');
    	    	 $('input[name="dewateringscrew3_06pm"]').val('');
    	    	 $('input[name="clarifiedwaterchest1_06pm"]').val('');
    	    	 $('input[name="clarifiedwaterchest2_06pm"]').val('');
    	    	 $('input[name="deinkwhitewaterchest1_06pm"]').val('');
    	    	 $('input[name="deinkwhitewaterchest2_06pm"]').val('');
    	    	 $('input[name="deinkwhitewaterchest3_06pm"]').val('');
    	    	 $('input[name="deinkwhitewaterchest4_06pm"]').val('');
    	    	 $('input[name="deinkwhitewaterchest5_06pm"]').val('');
    	     } 
    		   if(idClicked==='button9pm' && v5!='button1am'&&document.getElementById("cmt9pm").checked==false){ 
    				  /*  $('input[name="dumpchests1_10pm"]').val('OK'); */
    			   $('input[name="dumpchests2_10pm"]').val('OK');
    			   $('input[name="dumpchests3_10pm"]').val('OK');
    			   $('input[name="dumpchests4_10pm"]').val('OK');
    			   $('input[name="dumpchests5_10pm"]').val('OK');
    			   $('input[name="contaminexpump1_10pm"]').val('OK');
    			   $('input[name="contaminexpump2_10pm"]').val('OK');
    			   $('input[name="contaminexpump3_10pm"]').val('OK');
    			   $('input[name="rejectscollectionbunker1_10pm"]').val('OK');
    			   $('input[name="rejectscollectionbunker2_10pm"]').val('OK');
    			   $('input[name="batchpulperbasement1_10pm"]').val('OK');
    			   $('input[name="batchpulperbasement2_10pm"]').val('OK');
    			   $('input[name="batchpulperbasement3_10pm"]').val('OK');
    			   $('input[name="batchpulperbasement4_10pm"]').val('OK');
    			   $('input[name="detrasher1_10pm"]').val('OK');
    			   $('input[name="detrasher2_10pm"]').val('OK');
    			  /*  $('input[name="detrasher3_10pm"]').val('OK'); */
    			   $('input[name="rejectspress1_10pm"]').val('OK');
    			   $('input[name="rejectspress2_10pm"]').val('OK');
    			   $('input[name="rejectspress3_10pm"]').val('OK');
    			   $('input[name="dewateringscrew1_10pm"]').val('OK');
    			   $('input[name="dewateringscrew2_10pm"]').val('OK');
    			   $('input[name="dewateringscrew3_10pm"]').val('OK');
    			   $('input[name="clarifiedwaterchest1_10pm"]').val('OK');
    			   $('input[name="clarifiedwaterchest2_10pm"]').val('OK');
    			   $('input[name="deinkwhitewaterchest1_10pm"]').val('OK');
    			   $('input[name="deinkwhitewaterchest2_10pm"]').val('OK');
    			   /* $('input[name="deinkwhitewaterchest3_10pm"]').val('OK'); */
    			   $('input[name="deinkwhitewaterchest4_10pm"]').val('OK');
    			   $('input[name="deinkwhitewaterchest5_10pm"]').val('OK');
    	   }if(checkBox4.checked!=true&&idClicked==="button9pm"){
    	  	 $('input[name="dumpchests1_10pm"]').val('');
    	  	 $('input[name="dumpchests2_10pm"]').val('');
    	  	 $('input[name="dumpchests3_10pm"]').val('');
    	  	 $('input[name="dumpchests4_10pm"]').val('');
    	  	 $('input[name="dumpchests5_10pm"]').val('');
    	  	 $('input[name="contaminexpump1_10pm"]').val('');
    	  	 $('input[name="contaminexpump2_10pm"]').val('');
    	  	 $('input[name="contaminexpump3_10pm"]').val('');
    	  	 $('input[name="rejectscollectionbunker1_10pm"]').val('');
    	  	 $('input[name="rejectscollectionbunker2_10pm"]').val('');
    	  	 $('input[name="batchpulperbasement1_10pm"]').val('');
    	  	 $('input[name="batchpulperbasement2_10pm"]').val('');
    	  	 $('input[name="batchpulperbasement3_10pm"]').val('');
    	  	 $('input[name="batchpulperbasement4_10pm"]').val('');
    	  	 $('input[name="detrasher1_10pm"]').val('');
    	  	 $('input[name="detrasher2_10pm"]').val('');
    	  	 $('input[name="detrasher3_10pm"]').val('');
    	  	 $('input[name="rejectspress1_10pm"]').val('');
    	  	 $('input[name="rejectspress2_10pm"]').val('');
    	  	 $('input[name="rejectspress3_10pm"]').val('');
    	  	 $('input[name="dewateringscrew1_10pm"]').val('');
    	  	 $('input[name="dewateringscrew2_10pm"]').val('');
    	  	 $('input[name="dewateringscrew3_10pm"]').val('');
    	  	 $('input[name="clarifiedwaterchest1_10pm"]').val('');
    	  	 $('input[name="clarifiedwaterchest2_10pm"]').val('');
    	  	 $('input[name="deinkwhitewaterchest1_10pm"]').val('');
    	  	 $('input[name="deinkwhitewaterchest2_10pm"]').val('');
    	  	 $('input[name="deinkwhitewaterchest3_10pm"]').val('');
    	  	 $('input[name="deinkwhitewaterchest4_10pm"]').val('');
    	  	 $('input[name="deinkwhitewaterchest5_10pm"]').val('');
    	   }  
   if(idClicked==='button1am' && v6!='button5am'&&document.getElementById("cmt1am").checked==false){ 
	   /*   $('input[name="dumpchests1_02am"]').val('OK'); */
	   $('input[name="dumpchests2_02am"]').val('OK');
	   $('input[name="dumpchests3_02am"]').val('OK');
	   $('input[name="dumpchests4_02am"]').val('OK');
	   $('input[name="dumpchests5_02am"]').val('OK');
	   $('input[name="contaminexpump1_02am"]').val('OK');
	   $('input[name="contaminexpump2_02am"]').val('OK');
	   $('input[name="contaminexpump3_02am"]').val('OK');
	   $('input[name="rejectscollectionbunker1_02am"]').val('OK');
	   $('input[name="rejectscollectionbunker2_02am"]').val('OK');
	   $('input[name="batchpulperbasement1_02am"]').val('OK');
	   $('input[name="batchpulperbasement2_02am"]').val('OK');
	   $('input[name="batchpulperbasement3_02am"]').val('OK');
	   $('input[name="batchpulperbasement4_02am"]').val('OK');
	   $('input[name="detrasher1_02am"]').val('OK');
	   $('input[name="detrasher2_02am"]').val('OK');
	   $('input[name="detrasher3_02am"]').val('OK');
	   $('input[name="rejectspress1_02am"]').val('OK');
	   $('input[name="rejectspress2_02am"]').val('OK');
	   $('input[name="rejectspress3_02am"]').val('OK');
	   $('input[name="dewateringscrew1_02am"]').val('OK');
	   $('input[name="dewateringscrew2_02am"]').val('OK');
	   $('input[name="dewateringscrew3_02am"]').val('OK');
	   $('input[name="clarifiedwaterchest1_02am"]').val('OK');
	   $('input[name="clarifiedwaterchest2_02am"]').val('OK');
	   $('input[name="deinkwhitewaterchest1_02am"]').val('OK');
	   $('input[name="deinkwhitewaterchest2_02am"]').val('OK');
	  /*  $('input[name="deinkwhitewaterchest3_02am"]').val('OK');
	   $('input[name="deinkwhitewaterchest4_02am"]').val('OK'); */
	   $('input[name="deinkwhitewaterchest5_02am"]').val('OK');
}if(checkBox5.checked!=true&&idClicked==="button1am"){
	 $('input[name="dumpchests1_02am"]').val('');
	 $('input[name="dumpchests2_02am"]').val('');
	 $('input[name="dumpchests3_02am"]').val('');
	 $('input[name="dumpchests4_02am"]').val('');
	 $('input[name="dumpchests5_02am"]').val('');
	 $('input[name="contaminexpump1_02am"]').val('');
	 $('input[name="contaminexpump2_02am"]').val('');
	 $('input[name="contaminexpump3_02am"]').val('');
	 $('input[name="rejectscollectionbunker1_02am"]').val('');
	 $('input[name="rejectscollectionbunker2_02am"]').val('');
	 $('input[name="batchpulperbasement1_02am"]').val('');
	 $('input[name="batchpulperbasement2_02am"]').val('');
	 $('input[name="batchpulperbasement3_02am"]').val('');
	 $('input[name="batchpulperbasement4_02am"]').val('');
	 $('input[name="detrasher1_02am"]').val('');
	 $('input[name="detrasher2_02am"]').val('');
	 $('input[name="detrasher3_02am"]').val('');
	 $('input[name="rejectspress1_02am"]').val('');
	 $('input[name="rejectspress2_02am"]').val('');
	 $('input[name="rejectspress3_02am"]').val('');
	 $('input[name="dewateringscrew1_02am"]').val('');
	 $('input[name="dewateringscrew2_02am"]').val('');
	 $('input[name="dewateringscrew3_02am"]').val('');
	 $('input[name="clarifiedwaterchest1_02am"]').val('');
	 $('input[name="clarifiedwaterchest2_02am"]').val('');
	 $('input[name="deinkwhitewaterchest1_02am"]').val('');
	 $('input[name="deinkwhitewaterchest2_02am"]').val('');
	 $('input[name="deinkwhitewaterchest3_02am"]').val('');
	 $('input[name="deinkwhitewaterchest4_02am"]').val('');
	 $('input[name="deinkwhitewaterchest5_02am"]').val('');
} 
   if(idClicked==='button5am'&&document.getElementById("cmt5am").checked==false){
	   /* $('input[name="dumpchests1_06am"]').val('OK'); */
	   $('input[name="dumpchests2_06am"]').val('OK');
	   $('input[name="dumpchests3_06am"]').val('OK');
	   $('input[name="dumpchests4_06am"]').val('OK');
	   $('input[name="dumpchests5_06am"]').val('OK');
	   $('input[name="contaminexpump1_06am"]').val('OK');
	   $('input[name="contaminexpump2_06am"]').val('OK');
	   $('input[name="contaminexpump3_06am"]').val('OK');
	   $('input[name="rejectscollectionbunker1_06am"]').val('OK');
	   $('input[name="rejectscollectionbunker2_06am"]').val('OK');
	   $('input[name="batchpulperbasement1_06am"]').val('OK');
	   $('input[name="batchpulperbasement2_06am"]').val('OK');
	   $('input[name="batchpulperbasement3_06am"]').val('OK');
	   $('input[name="batchpulperbasement4_06am"]').val('OK');
	   $('input[name="detrasher1_06am"]').val('OK');
	   $('input[name="detrasher2_06am"]').val('OK');
	/*    $('input[name="detrasher3_06am"]').val('OK'); */
	   $('input[name="rejectspress1_06am"]').val('OK');
	   $('input[name="rejectspress2_06am"]').val('OK');
	   $('input[name="rejectspress3_06am"]').val('OK');
	   $('input[name="dewateringscrew1_06am"]').val('OK');
	   $('input[name="dewateringscrew2_06am"]').val('OK');
	   $('input[name="dewateringscrew3_06am"]').val('OK');
	   $('input[name="clarifiedwaterchest1_06am"]').val('OK');
	   $('input[name="clarifiedwaterchest2_06am"]').val('OK');
	   $('input[name="deinkwhitewaterchest1_06am"]').val('OK');
	   $('input[name="deinkwhitewaterchest2_06am"]').val('OK');
	   $('input[name="deinkwhitewaterchest3_06am"]').val('OK');
	   $('input[name="deinkwhitewaterchest4_06am"]').val('OK');
	   $('input[name="deinkwhitewaterchest5_06am"]').val('OK');
}if(checkBox6.checked!=true&&idClicked==="button5am"){
	 $('input[name="dumpchests1_06am"]').val('');
	 $('input[name="dumpchests2_06am"]').val('');
	 $('input[name="dumpchests3_06am"]').val('');
	 $('input[name="dumpchests4_06am"]').val('');
	 $('input[name="dumpchests5_06am"]').val('');
	 $('input[name="contaminexpump1_06am"]').val('');
	 $('input[name="contaminexpump2_06am"]').val('');
	 $('input[name="contaminexpump3_06am"]').val('');
	 $('input[name="rejectscollectionbunker1_06am"]').val('');
	 $('input[name="rejectscollectionbunker2_06am"]').val('');
	 $('input[name="batchpulperbasement1_06am"]').val('');
	 $('input[name="batchpulperbasement2_06am"]').val('');
	 $('input[name="batchpulperbasement3_06am"]').val('');
	 $('input[name="batchpulperbasement4_06am"]').val('');
	 $('input[name="detrasher1_06am"]').val('');
	 $('input[name="detrasher2_06am"]').val('');
	 $('input[name="detrasher3_06am"]').val('');
	 $('input[name="rejectspress1_06am"]').val('');
	 $('input[name="rejectspress2_06am"]').val('');
	 $('input[name="rejectspress3_06am"]').val('');
	 $('input[name="dewateringscrew1_06am"]').val('');
	 $('input[name="dewateringscrew2_06am"]').val('');
	 $('input[name="dewateringscrew3_06am"]').val('');
	 $('input[name="clarifiedwaterchest1_06am"]').val('');
	 $('input[name="clarifiedwaterchest2_06am"]').val('');
	 $('input[name="deinkwhitewaterchest1_06am"]').val('');
	 $('input[name="deinkwhitewaterchest2_06am"]').val('');
	 $('input[name="deinkwhitewaterchest3_06am"]').val('');
	 $('input[name="deinkwhitewaterchest4_06am"]').val('');
	 $('input[name="deinkwhitewaterchest5_06am"]').val('');
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

