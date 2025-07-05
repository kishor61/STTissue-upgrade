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
 border:solid 1px #04F72; 
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
		
		<c:if test="${data.position == 'OP9'}">	
			<spring:url value="/frpobccCommon/OpRoute_9/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Route 8 Outside</span>
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
								 	<option value="OP8" ${data.position == 'OP8' ? 'selected' : ''}>Basement 6</option>
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

 <c:if test="${data.position == 'OP9'}">
   <div id="printDiv">
   		 <center>
   		  <c:if test="${data.position == 'OP9'}">
		   	<h1 style="font-size: 21px;color: #518f3e;">Operator Route 9B Line Basement</h1>
		 </c:if>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Route 9B Line Basement</h1>
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
								<input type="text" class="input" value="${data.techniciansinitials1}"  name="techniciansinitials1" style="margin-left: 1px !important;float: none;"/>
							</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.techniciansinitials2}"  name="techniciansinitials2" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.techniciansinitials3}"  name="techniciansinitials3" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials4}"  name="techniciansinitials4" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials5}"  name="techniciansinitials5" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials6}"  name="techniciansinitials6" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials7}"  name="techniciansinitials7" style="margin-left: 1px !important;float: none;"/>					   					    		   
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
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">B-Line Pulper Discharge Pump</h1></td>
								<td></td> 
							<td align="center" id="ok1"><input id="ok"  type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="ok" name="ok" ${data.ok == 'ok' ? 'checked' : ''}></td>
							<td align="center" id="ok2"><input id="button1pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1pm" name="button1pm" ${data.button1pm == 'button1pm' ? 'checked' : ''}></td>
							<td align="center" id="ok3"><input id="button5pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5pm" name="button5pm" ${data.button5pm == 'button5pm' ? 'checked' : ''}></td>
							<td align="center" id="ok4"><input id="button9pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button9pm" name="button9pm" ${data.button9pm == 'button9pm' ? 'checked' : ''}></td>
							<td align="center" id="ok5"><input id="button1am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1am" name="button1am" ${data.button1am == 'button1am' ? 'checked' : ''}></td>
							<td align="center" id="ok6"><input id="button5am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5am" name="button5am" ${data.button5am == 'button5am' ? 'checked' : ''}></td>
						
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement1_10am}"  name="oproute_9b_linebasement1_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement1_2pm}"  name="oproute_9b_linebasement1_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement1_6pm}"  name="oproute_9b_linebasement1_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement1_10pm}"  name="oproute_9b_linebasement1_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement1_2am}"  name="oproute_9b_linebasement1_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement1_6am}"  name="oproute_9b_linebasement1_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">CONTAMINEX PUMP (B-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement2_10am}"  name="oproute_9b_linebasement2_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement2_2pm}"  name="oproute_9b_linebasement2_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement2_6pm}"  name="oproute_9b_linebasement2_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement2_10pm}"  name="oproute_9b_linebasement2_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement2_2am}"  name="oproute_9b_linebasement2_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement2_6am}"  name="oproute_9b_linebasement2_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>MOTOR & PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement3_10am}"  name="oproute_9b_linebasement3_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement3_2pm}"  name="oproute_9b_linebasement3_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement3_6pm}"  name="oproute_9b_linebasement3_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement3_10pm}"  name="oproute_9b_linebasement3_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement3_2am}"  name="oproute_9b_linebasement3_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement3_6am}"  name="oproute_9b_linebasement3_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK SEAL WATER  FLOW</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement4_10am}"  name="oproute_9b_linebasement4_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement4_2pm}"  name="oproute_9b_linebasement4_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement4_6pm}"  name="oproute_9b_linebasement4_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement4_10pm}"  name="oproute_9b_linebasement4_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement4_2am}"  name="oproute_9b_linebasement4_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement4_6am}"  name="oproute_9b_linebasement4_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">BATCH PULPER BASEMENT (B-Line)</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK SEAL WATER FLOW</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement5_10am}"  name="oproute_9b_linebasement5_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement5_2pm}"  name="oproute_9b_linebasement5_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement5_6pm}"  name="oproute_9b_linebasement5_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement5_10pm}"  name="oproute_9b_linebasement5_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement5_2am}"  name="oproute_9b_linebasement5_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement5_6am}"  name="oproute_9b_linebasement5_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>SEAL H2O PAN CLEAN, DRAINING</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement6_10am}"  name="oproute_9b_linebasement6_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement6_2pm}"  name="oproute_9b_linebasement6_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement6_6pm}"  name="oproute_9b_linebasement6_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement6_10pm}"  name="oproute_9b_linebasement6_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement6_2am}"  name="oproute_9b_linebasement6_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement6_6am}"  name="oproute_9b_linebasement6_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>PACKING CONDITION</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement7_10am}"  name="oproute_9b_linebasement7_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement7_2pm}"  name="oproute_9b_linebasement7_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement7_6pm}"  name="oproute_9b_linebasement7_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement7_10pm}"  name="oproute_9b_linebasement7_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement7_2am}"  name="oproute_9b_linebasement7_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement7_6am}"  name="oproute_9b_linebasement7_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>OIL TEMPERATURE RANGE </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement8_10am}"  name="oproute_9b_linebasement8_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement8_2pm}"  name="oproute_9b_linebasement8_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement8_6pm}"  name="oproute_9b_linebasement8_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement8_10pm}"  name="oproute_9b_linebasement8_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement8_2am}"  name="oproute_9b_linebasement8_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement8_6am}"  name="oproute_9b_linebasement8_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DRUM SCREEN (B-Line)</h1></td>
						</tr>
						 <tr>						 
							<td class="tg-yw4l" ><h1>OPEN/Close  INTERNAL SHOWER VALVE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement9_10am}"  disabled   name="oproute_9b_linebasement9_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement9_2pm}"  name="oproute_9b_linebasement9_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement9_6pm}"   disabled  name="oproute_9b_linebasement9_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement9_10pm}"  name="oproute_9b_linebasement9_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement9_2am}"   disabled  name="oproute_9b_linebasement9_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement9_6am}"  name="oproute_9b_linebasement9_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>MOTOR AND BEARINGS OK</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement10_10am}"  name="oproute_9b_linebasement10_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement10_2pm}"  name="oproute_9b_linebasement10_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement10_6pm}"  name="oproute_9b_linebasement10_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement10_10pm}"  name="oproute_9b_linebasement10_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement10_2am}"  name="oproute_9b_linebasement10_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement10_6am}"  name="oproute_9b_linebasement10_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement11_10am}"  name="oproute_9b_linebasement11_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement11_2pm}"  name="oproute_9b_linebasement11_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement11_6pm}"  name="oproute_9b_linebasement11_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement11_10pm}"  name="oproute_9b_linebasement11_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement11_2am}"  name="oproute_9b_linebasement11_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement11_6am}"  name="oproute_9b_linebasement11_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">B-Line Pulper Feed Conveyor Drive</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY & VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement12_10am}"  name="oproute_9b_linebasement12_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement12_2pm}"  name="oproute_9b_linebasement12_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement12_6pm}"  name="oproute_9b_linebasement12_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement12_10pm}"  name="oproute_9b_linebasement12_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement12_2am}"  name="oproute_9b_linebasement12_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement12_6am}"  name="oproute_9b_linebasement12_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Heat Trace Breakers - Check during cold Temps</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement13_10am}"  name="oproute_9b_linebasement13_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement13_2pm}"  name="oproute_9b_linebasement13_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement13_6pm}"  name="oproute_9b_linebasement13_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement13_10pm}"  name="oproute_9b_linebasement13_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement13_2am}"  name="oproute_9b_linebasement13_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement13_6am}"  name="oproute_9b_linebasement13_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Roll Up Wash Up Hoses in B- Basement</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement14_10am}"  name="oproute_9b_linebasement14_10am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement14_2pm}"  name="oproute_9b_linebasement14_2pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement14_6pm}"  name="oproute_9b_linebasement14_6pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement14_10pm}"  name="oproute_9b_linebasement14_10pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement14_2am}"  name="oproute_9b_linebasement14_2am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_9b_linebasement14_6am}"  name="oproute_9b_linebasement14_6am" style="margin-left: 1px !important;float: none;"/>					   					    		   
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
								<input type="text" disabled id="cmt9amarea" class="input" value="${data.cmt9amarea}"  name="cmt9amarea" style="margin-left: 1px !important;float: none;"/>
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
								<input type="text"  disabled id="cmt1amarea" class="input" value="${data.cmt1amarea}"  name="cmt1amarea" style="margin-left: 1px !important;float: none;" />
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
	    			//  $("input[name='cmt5pmarea']").prop('disabled', false);
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
	    			//   $("input[name='cmt5amarea']").prop('disabled', false);
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
		$('input[name="oproute_9b_linebasement1_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement2_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement3_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement4_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement5_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement6_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement7_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement8_10am"]').val('OK');
		// $('input[name="oproute_9b_linebasement9_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement10_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement11_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement12_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement13_10am"]').val('OK');
		$('input[name="oproute_9b_linebasement14_10am"]').val('OK'); 
	
  }if(checkBox.checked!=true&&idClicked==="ok"){
	  $('input[name="oproute_9b_linebasement1_10am"]').val('');
	  $('input[name="oproute_9b_linebasement2_10am"]').val('');
	  $('input[name="oproute_9b_linebasement3_10am"]').val('');
	  $('input[name="oproute_9b_linebasement4_10am"]').val('');
	  $('input[name="oproute_9b_linebasement5_10am"]').val('');
	  $('input[name="oproute_9b_linebasement6_10am"]').val('');
	  $('input[name="oproute_9b_linebasement7_10am"]').val('');
	  $('input[name="oproute_9b_linebasement8_10am"]').val('');
	  $('input[name="oproute_9b_linebasement9_10am"]').val('');
	  $('input[name="oproute_9b_linebasement10_10am"]').val('');
	  $('input[name="oproute_9b_linebasement11_10am"]').val('');
	  $('input[name="oproute_9b_linebasement12_10am"]').val('');
	  $('input[name="oproute_9b_linebasement13_10am"]').val('');
	  $('input[name="oproute_9b_linebasement14_10am"]').val('');
	
    }    	 
   if(idClicked==='button1pm' && v3!='button5pm'&&document.getElementById("cmt1pm").checked==false){ 
		$('input[name="oproute_9b_linebasement1_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement2_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement3_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement4_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement5_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement6_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement7_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement8_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement9_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement10_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement11_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement12_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement13_2pm"]').val('OK');
		$('input[name="oproute_9b_linebasement14_2pm"]').val('OK');
	
  }if(checkBox2.checked!=true&&idClicked==="button1pm"){
	  $('input[name="oproute_9b_linebasement1_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement2_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement3_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement4_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement5_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement6_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement7_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement8_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement9_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement10_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement11_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement12_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement13_2pm"]').val('');
	  $('input[name="oproute_9b_linebasement14_2pm"]').val('');

    }    	 
  if(idClicked==='button5pm' && v4!='button9pm'&&document.getElementById("cmt5pm").checked==false){ 
		$('input[name="oproute_9b_linebasement1_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement2_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement3_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement4_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement5_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement6_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement7_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement8_6pm"]').val('OK');
	// 	$('input[name="oproute_9b_linebasement9_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement10_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement11_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement12_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement13_6pm"]').val('OK');
		$('input[name="oproute_9b_linebasement14_6pm"]').val('OK'); 
	
}if(checkBox3.checked!=true&&idClicked==="button5pm"){
	  $('input[name="oproute_9b_linebasement1_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement2_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement3_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement4_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement5_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement6_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement7_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement8_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement9_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement10_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement11_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement12_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement13_6pm"]').val('');
	  $('input[name="oproute_9b_linebasement14_6pm"]').val('');
	 
  }    	 
  if(idClicked==='button9pm' && v5!='button1am'&&document.getElementById("cmt9pm").checked==false){ 
		$('input[name="oproute_9b_linebasement1_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement2_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement3_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement4_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement5_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement6_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement7_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement8_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement9_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement10_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement11_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement12_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement13_10pm"]').val('OK');
		$('input[name="oproute_9b_linebasement14_10pm"]').val('OK');
		
  }if(checkBox4.checked!=true&&idClicked==="button9pm"){
	  $('input[name="oproute_9b_linebasement1_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement2_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement3_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement4_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement5_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement6_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement7_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement8_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement9_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement10_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement11_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement12_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement13_10pm"]').val('');
	  $('input[name="oproute_9b_linebasement14_10pm"]').val('');
	 
    }    	 
 if(idClicked==='button1am' && v6!='button5am'&&document.getElementById("cmt1am").checked==false){ 
		$('input[name="oproute_9b_linebasement1_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement2_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement3_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement4_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement5_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement6_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement7_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement8_2am"]').val('OK');
	// 	$('input[name="oproute_9b_linebasement9_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement10_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement11_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement12_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement13_2am"]').val('OK');
		$('input[name="oproute_9b_linebasement14_2am"]').val('OK'); 
		
  }if(checkBox5.checked!=true&&idClicked==="button1am"){
	  $('input[name="oproute_9b_linebasement1_2am"]').val('');
	  $('input[name="oproute_9b_linebasement2_2am"]').val('');
	  $('input[name="oproute_9b_linebasement3_2am"]').val('');
	  $('input[name="oproute_9b_linebasement4_2am"]').val('');
	  $('input[name="oproute_9b_linebasement5_2am"]').val('');
	  $('input[name="oproute_9b_linebasement6_2am"]').val('');
	  $('input[name="oproute_9b_linebasement7_2am"]').val('');
	  $('input[name="oproute_9b_linebasement8_2am"]').val('');
	  $('input[name="oproute_9b_linebasement9_2am"]').val('');
	  $('input[name="oproute_9b_linebasement10_2am"]').val('');
	  $('input[name="oproute_9b_linebasement11_2am"]').val('');
	  $('input[name="oproute_9b_linebasement12_2am"]').val('');
	  $('input[name="oproute_9b_linebasement13_2am"]').val('');
	  $('input[name="oproute_9b_linebasement14_2am"]').val('');
	 
    }    	 
  if(idClicked==='button5am' &&document.getElementById("cmt5am").checked==false){
		$('input[name="oproute_9b_linebasement1_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement2_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement3_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement4_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement5_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement6_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement7_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement8_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement9_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement10_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement11_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement12_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement13_6am"]').val('OK');
		$('input[name="oproute_9b_linebasement14_6am"]').val('OK');
	
  }if(checkBox6.checked!=true&&idClicked==="button5am"){
	  $('input[name="oproute_9b_linebasement1_6am"]').val('');
	  $('input[name="oproute_9b_linebasement2_6am"]').val('');
	  $('input[name="oproute_9b_linebasement3_6am"]').val('');
	  $('input[name="oproute_9b_linebasement4_6am"]').val('');
	  $('input[name="oproute_9b_linebasement5_6am"]').val('');
	  $('input[name="oproute_9b_linebasement6_6am"]').val('');
	  $('input[name="oproute_9b_linebasement7_6am"]').val('');
	  $('input[name="oproute_9b_linebasement8_6am"]').val('');
	  $('input[name="oproute_9b_linebasement9_6am"]').val('');
	  $('input[name="oproute_9b_linebasement10_6am"]').val('');
	  $('input[name="oproute_9b_linebasement11_6am"]').val('');
	  $('input[name="oproute_9b_linebasement12_6am"]').val('');
	  $('input[name="oproute_9b_linebasement13_6am"]').val('');
	  $('input[name="oproute_9b_linebasement14_6am"]').val('');
	
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
