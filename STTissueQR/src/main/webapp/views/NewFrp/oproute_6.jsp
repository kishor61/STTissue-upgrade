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
		
		<c:if test="${data.position == 'OP6'}">	
			<spring:url value="/frpobccCommon/OpRoute_6/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Route 6 Basement</span>
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

 <c:if test="${data.position == 'OP6'}">
   <div id="printDiv">
   		 <center>
   		  <c:if test="${data.position == 'OP6'}">
		   	<h1 style="font-size: 21px;color: #518f3e;">Operator Route 6 Basement</h1>
		 </c:if>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Route 6 Basement</h1>
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
				 <table border="1" style="width:75%" id="tbbl">				
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
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 8:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 12:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 4:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 8:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 12:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 4:00 AM</h1></td>
						  </tr>
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Visual check of U Drains for stock</h1></td>
							 <td></td>  
							<td align="center" id="ok1"><input id="ok"  type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="ok" name="ok" ${data.ok == 'ok' ? 'checked' : ''}></td>
							<td align="center" id="ok2"><input id="button1pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1pm" name="button1pm" ${data.button1pm == 'button1pm' ? 'checked' : ''}></td>
							<td align="center" id="ok3"><input id="button5pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5pm" name="button5pm" ${data.button5pm == 'button5pm' ? 'checked' : ''}></td>
							<td align="center" id="ok4"><input id="button9pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button9pm" name="button9pm" ${data.button9pm == 'button9pm' ? 'checked' : ''}></td>
							<td align="center" id="ok5"><input id="button1am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1am" name="button1am" ${data.button1am == 'button1am' ? 'checked' : ''}></td>
							<td align="center" id="ok6"><input id="button5am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5am" name="button5am" ${data.button5am == 'button5am' ? 'checked' : ''}></td>
						</tr>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>Seal Water Pump #2</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock1_08am}"  name="visualcheckofudrainsforstock1_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock1_12pm}"  name="visualcheckofudrainsforstock1_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock1_04pm}"  name="visualcheckofudrainsforstock1_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock1_08pm}"  name="visualcheckofudrainsforstock1_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock1_12am}"  name="visualcheckofudrainsforstock1_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock1_04am}"  name="visualcheckofudrainsforstock1_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Seal Water Pump #2</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock2_08am}"  name="visualcheckofudrainsforstock2_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock2_12pm}"  name="visualcheckofudrainsforstock2_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock2_04pm}"  name="visualcheckofudrainsforstock2_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock2_08pm}"  name="visualcheckofudrainsforstock2_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock2_12am}"  name="visualcheckofudrainsforstock2_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock2_04am}"  name="visualcheckofudrainsforstock2_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Fine Screen Agitator (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock3_08am}"  name="visualcheckofudrainsforstock3_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock3_12pm}"  name="visualcheckofudrainsforstock3_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock3_04pm}"  name="visualcheckofudrainsforstock3_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock3_08pm}"  name="visualcheckofudrainsforstock3_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock3_12am}"  name="visualcheckofudrainsforstock3_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock3_04am}"  name="visualcheckofudrainsforstock3_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Fine Screen Feed Pump (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock4_08am}"  name="visualcheckofudrainsforstock4_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock4_12pm}"  name="visualcheckofudrainsforstock4_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock4_04pm}"  name="visualcheckofudrainsforstock4_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock4_08pm}"  name="visualcheckofudrainsforstock4_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock4_12am}"  name="visualcheckofudrainsforstock4_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock4_04am}"  name="visualcheckofudrainsforstock4_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Secondary Fine Screen Agitator (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock5_08am}"  name="visualcheckofudrainsforstock5_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock5_12pm}"  name="visualcheckofudrainsforstock5_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock5_04pm}"  name="visualcheckofudrainsforstock5_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock5_08pm}"  name="visualcheckofudrainsforstock5_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock5_12am}"  name="visualcheckofudrainsforstock5_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock5_04am}"  name="visualcheckofudrainsforstock5_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Secondary Fine Screen Pump (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock6_08am}"  name="visualcheckofudrainsforstock6_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock6_12pm}"  name="visualcheckofudrainsforstock6_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock6_04pm}"  name="visualcheckofudrainsforstock6_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock6_08pm}"  name="visualcheckofudrainsforstock6_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock6_12am}"  name="visualcheckofudrainsforstock6_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock6_04am}"  name="visualcheckofudrainsforstock6_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Fine Screen Dilution Pump (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock7_08am}"  name="visualcheckofudrainsforstock7_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock7_12pm}"  disabled name="visualcheckofudrainsforstock7_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock7_04pm}"  name="visualcheckofudrainsforstock7_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock7_08pm}"  disabled name="visualcheckofudrainsforstock7_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock7_12am}"  name="visualcheckofudrainsforstock7_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock7_04am}"  disabled name="visualcheckofudrainsforstock7_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>   
						<tr>						 
							<td class="tg-yw4l" ><h1>DAF CWW Discharge Pump (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock8_08am}"  name="visualcheckofudrainsforstock8_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock8_12pm}"  name="visualcheckofudrainsforstock8_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock8_04pm}"  name="visualcheckofudrainsforstock8_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock8_08pm}"  name="visualcheckofudrainsforstock8_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock8_12am}"  name="visualcheckofudrainsforstock8_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock8_04am}"  name="visualcheckofudrainsforstock8_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Fine Screen Agitator (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock9_08am}"  name="visualcheckofudrainsforstock9_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock9_12pm}"  name="visualcheckofudrainsforstock9_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock9_04pm}"  name="visualcheckofudrainsforstock9_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock9_08pm}"  name="visualcheckofudrainsforstock9_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock9_12am}"  name="visualcheckofudrainsforstock9_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock9_04am}"  name="visualcheckofudrainsforstock9_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Fine Screen Feed Pump (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock10_08am}"  name="visualcheckofudrainsforstock10_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock10_12pm}"  name="visualcheckofudrainsforstock10_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock10_04pm}"  name="visualcheckofudrainsforstock10_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock10_08pm}"  name="visualcheckofudrainsforstock10_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock10_12am}"  name="visualcheckofudrainsforstock10_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock10_04am}"  name="visualcheckofudrainsforstock10_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Press Shower Pump (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock11_08am}"  name="visualcheckofudrainsforstock11_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock11_12pm}"  name="visualcheckofudrainsforstock11_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock11_04pm}"  name="visualcheckofudrainsforstock11_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock11_08pm}"  name="visualcheckofudrainsforstock11_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock11_12am}"  name="visualcheckofudrainsforstock11_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock11_04am}"  name="visualcheckofudrainsforstock11_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Press Filtrate Pump (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock12_08am}"  name="visualcheckofudrainsforstock12_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock12_12pm}"  name="visualcheckofudrainsforstock12_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock12_04pm}"  name="visualcheckofudrainsforstock12_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock12_08pm}"  name="visualcheckofudrainsforstock12_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock12_12am}"  name="visualcheckofudrainsforstock12_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock12_04am}"  name="visualcheckofudrainsforstock12_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Second Loop Press Feed Pump</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock13_08am}"  name="visualcheckofudrainsforstock13_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock13_12pm}"  name="visualcheckofudrainsforstock13_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock13_04pm}"  name="visualcheckofudrainsforstock13_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock13_08pm}"  name="visualcheckofudrainsforstock13_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock13_12am}"  name="visualcheckofudrainsforstock13_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock13_04am}"  name="visualcheckofudrainsforstock13_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Second Loop Press Feed Chest Agitator</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock14_08am}"  name="visualcheckofudrainsforstock14_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock14_12pm}"  name="visualcheckofudrainsforstock14_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock14_04pm}"  name="visualcheckofudrainsforstock14_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock14_08pm}"  name="visualcheckofudrainsforstock14_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock14_12am}"  name="visualcheckofudrainsforstock14_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock14_04am}"  name="visualcheckofudrainsforstock14_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Press Feed Pump (A-Line) (Old Sec Press feed)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock15_08am}"  name="visualcheckofudrainsforstock15_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock15_12pm}"  name="visualcheckofudrainsforstock15_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock15_04pm}"  name="visualcheckofudrainsforstock15_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock15_08pm}"  name="visualcheckofudrainsforstock15_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock15_12am}"  name="visualcheckofudrainsforstock15_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock15_04am}"  name="visualcheckofudrainsforstock15_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Tertiary Press Agitator (A-Line) (Old Sec Press feed)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock16_08am}"  name="visualcheckofudrainsforstock16_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock16_12pm}"  name="visualcheckofudrainsforstock16_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock16_04pm}"  name="visualcheckofudrainsforstock16_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock16_08pm}"  name="visualcheckofudrainsforstock16_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock16_12am}"  name="visualcheckofudrainsforstock16_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock16_04am}"  name="visualcheckofudrainsforstock16_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>		 
							<td class="tg-yw4l" ><h1>B-Line Decker Filtrate Pump</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock17_08am}"  name="visualcheckofudrainsforstock17_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock17_12pm}"  name="visualcheckofudrainsforstock17_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock17_04pm}"  name="visualcheckofudrainsforstock17_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock17_08pm}"  name="visualcheckofudrainsforstock17_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock17_12am}"  name="visualcheckofudrainsforstock17_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock17_04am}"  name="visualcheckofudrainsforstock17_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>1st STAGE DECKER FILTRATE PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock18_08am}"  name="visualcheckofudrainsforstock18_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock18_12pm}"  name="visualcheckofudrainsforstock18_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock18_04pm}"  name="visualcheckofudrainsforstock18_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock18_08pm}"  name="visualcheckofudrainsforstock18_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock18_12am}"  name="visualcheckofudrainsforstock18_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock18_04am}"  name="visualcheckofudrainsforstock18_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>SEC. Loop PRESS FILTRATE PUMP (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock19_08am}"  name="visualcheckofudrainsforstock19_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock19_12pm}"  name="visualcheckofudrainsforstock19_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock19_04pm}"  name="visualcheckofudrainsforstock19_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock19_08pm}"  name="visualcheckofudrainsforstock19_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock19_12am}"  name="visualcheckofudrainsforstock19_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock19_04am}"  name="visualcheckofudrainsforstock19_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>1st ST. DECKER SHOWER PUMP </h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock20_08am}"  name="visualcheckofudrainsforstock20_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock20_12pm}"  name="visualcheckofudrainsforstock20_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock20_04pm}"  name="visualcheckofudrainsforstock20_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock20_08pm}"  name="visualcheckofudrainsforstock20_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock20_12am}"  name="visualcheckofudrainsforstock20_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock20_04am}"  name="visualcheckofudrainsforstock20_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>PRI. MICRO SCREEN FEED PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock21_08am}"  name="visualcheckofudrainsforstock21_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock21_12pm}"  name="visualcheckofudrainsforstock21_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock21_04pm}"  name="visualcheckofudrainsforstock21_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock21_08pm}"  name="visualcheckofudrainsforstock21_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock21_12am}"  name="visualcheckofudrainsforstock21_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock21_04am}"  name="visualcheckofudrainsforstock21_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						
						
						<tr>						 
							<td class="tg-yw4l" ><h1>PRI MICRO SCREEN CHEST AGITATOR</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock22_08am}"  name="visualcheckofudrainsforstock22_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock22_12pm}"  name="visualcheckofudrainsforstock22_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock22_04pm}"  name="visualcheckofudrainsforstock22_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock22_08pm}"  name="visualcheckofudrainsforstock22_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock22_12am}"  name="visualcheckofudrainsforstock22_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock22_04am}"  name="visualcheckofudrainsforstock22_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Sec Coarse Screen Feed Pump (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock23_08am}"  name="visualcheckofudrainsforstock23_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock23_12pm}"  name="visualcheckofudrainsforstock23_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock23_04pm}"  name="visualcheckofudrainsforstock23_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock23_08pm}"  name="visualcheckofudrainsforstock23_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock23_12am}"  name="visualcheckofudrainsforstock23_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock23_04am}"  name="visualcheckofudrainsforstock23_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>Sec Coarse Screen Agitator (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock24_08am}"  name="visualcheckofudrainsforstock24_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock24_12pm}"  name="visualcheckofudrainsforstock24_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock24_04pm}"  name="visualcheckofudrainsforstock24_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock24_08pm}"  name="visualcheckofudrainsforstock24_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock24_12am}"  name="visualcheckofudrainsforstock24_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock24_04am}"  name="visualcheckofudrainsforstock24_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>2nd ST. DECKER SHOWER PUMP (B-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock25_08am}"  name="visualcheckofudrainsforstock25_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock25_12pm}"  name="visualcheckofudrainsforstock25_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock25_04pm}"  name="visualcheckofudrainsforstock25_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock25_08pm}"  name="visualcheckofudrainsforstock25_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock25_12am}"  name="visualcheckofudrainsforstock25_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock25_04am}"  name="visualcheckofudrainsforstock25_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>REJ. TANK shower pump</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock26_08am}"  name="visualcheckofudrainsforstock26_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock26_12pm}"  name="visualcheckofudrainsforstock26_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock26_04pm}"  name="visualcheckofudrainsforstock26_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock26_08pm}"  name="visualcheckofudrainsforstock26_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock26_12am}"  name="visualcheckofudrainsforstock26_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock26_04am}"  name="visualcheckofudrainsforstock26_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>First Loop Press filtrate pump</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock27_08am}"  name="visualcheckofudrainsforstock27_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock27_12pm}"  name="visualcheckofudrainsforstock27_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock27_04pm}"  name="visualcheckofudrainsforstock27_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock27_08pm}"  name="visualcheckofudrainsforstock27_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock27_12am}"  name="visualcheckofudrainsforstock27_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock27_04am}"  name="visualcheckofudrainsforstock27_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>PRI. FINE SCREEN FEED PUMP (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock28_08am}"  name="visualcheckofudrainsforstock28_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock28_12pm}"  name="visualcheckofudrainsforstock28_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock28_04pm}"  name="visualcheckofudrainsforstock28_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock28_08pm}"  name="visualcheckofudrainsforstock28_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock28_12am}"  name="visualcheckofudrainsforstock28_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock28_04am}"  name="visualcheckofudrainsforstock28_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>PRI. FINE SCREEN CHEST AGITATOR (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock29_08am}"  name="visualcheckofudrainsforstock29_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock29_12pm}"  name="visualcheckofudrainsforstock29_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock29_04pm}"  name="visualcheckofudrainsforstock29_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock29_08pm}"  name="visualcheckofudrainsforstock29_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock29_12am}"  name="visualcheckofudrainsforstock29_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock29_04am}"  name="visualcheckofudrainsforstock29_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>ELUTRIATION PUMP</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock30_08am}"  name="visualcheckofudrainsforstock30_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock30_12pm}"  name="visualcheckofudrainsforstock30_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock30_04pm}"  name="visualcheckofudrainsforstock30_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock30_08pm}"  name="visualcheckofudrainsforstock30_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock30_12am}"  name="visualcheckofudrainsforstock30_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock30_04am}"  name="visualcheckofudrainsforstock30_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 						
						<tr>						 
							<td class="tg-yw4l" ><h1>Pulper Discharge Pump (A-Line)</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock31_08am}"  name="visualcheckofudrainsforstock31_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock31_12pm}"  name="visualcheckofudrainsforstock31_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock31_04pm}"  name="visualcheckofudrainsforstock31_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock31_08pm}"  name="visualcheckofudrainsforstock31_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock31_12am}"  name="visualcheckofudrainsforstock31_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock31_04am}"  name="visualcheckofudrainsforstock31_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Heat Trace-Check all breakers during cold weather</h1></td>
						</tr>
						 <tr>						 
							<td class="tg-yw4l" ><h1>431-HTP1, HTP2, HTP3</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock32_08am}"  name="visualcheckofudrainsforstock32_08am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock32_12pm}"  disabled name="visualcheckofudrainsforstock32_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock32_04pm}"  name="visualcheckofudrainsforstock32_04pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock32_08pm}"  disabled name="visualcheckofudrainsforstock32_08pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock32_12am}"  name="visualcheckofudrainsforstock32_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.visualcheckofudrainsforstock32_04am}"  disabled name="visualcheckofudrainsforstock32_04am" style="margin-left: 1px !important;float: none;"/>					   					    		   
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
				 <table border="1" style="width:75%">		
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
	    		//	 $("input[name='cmt9amarea']").prop('disabled', false);
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
		$('input[name="visualcheckofudrainsforstock1_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock2_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock3_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock4_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock5_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock6_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock7_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock8_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock9_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock10_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock11_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock12_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock13_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock14_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock15_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock16_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock17_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock18_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock19_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock20_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock21_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock22_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock23_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock24_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock25_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock26_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock27_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock28_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock29_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock30_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock31_08am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock32_08am"]').val('OK');
  }if(checkBox.checked!=true&&idClicked==="ok"){
	  $('input[name="visualcheckofudrainsforstock1_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock2_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock3_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock4_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock5_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock6_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock7_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock8_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock9_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock10_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock11_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock12_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock13_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock14_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock15_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock16_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock17_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock18_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock19_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock20_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock21_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock22_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock23_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock24_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock25_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock26_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock27_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock28_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock29_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock30_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock31_08am"]').val('');
	  $('input[name="visualcheckofudrainsforstock32_08am"]').val('');
    }    	 
  if(idClicked==='button1pm' && v3!='button5pm'&&document.getElementById("cmt1pm").checked==false){ 
	  $('input[name="visualcheckofudrainsforstock1_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock2_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock3_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock4_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock5_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock6_12pm"]').val('OK');
	//	$('input[name="visualcheckofudrainsforstock7_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock8_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock9_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock10_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock11_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock12_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock13_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock14_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock15_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock16_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock17_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock18_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock19_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock20_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock21_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock22_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock23_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock24_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock25_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock26_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock27_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock28_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock29_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock30_12pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock31_12pm"]').val('OK');
	//	$('input[name="visualcheckofudrainsforstock32_12pm"]').val('OK');
}if(checkBox2.checked!=true&&idClicked==="button1pm"){
	  $('input[name="visualcheckofudrainsforstock1_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock2_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock3_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock4_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock5_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock6_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock7_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock8_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock9_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock10_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock11_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock12_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock13_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock14_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock15_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock16_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock17_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock18_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock19_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock20_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock21_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock22_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock23_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock24_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock25_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock26_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock27_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock28_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock29_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock30_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock31_12pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock32_12pm"]').val('');
  }    	 
   if(idClicked==='button5pm' && v4!='button9pm'&&document.getElementById("cmt5pm").checked==false){ 
		$('input[name="visualcheckofudrainsforstock1_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock2_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock3_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock4_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock5_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock6_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock7_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock8_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock9_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock10_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock11_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock12_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock13_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock14_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock15_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock16_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock17_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock18_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock19_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock20_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock21_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock22_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock23_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock24_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock25_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock26_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock27_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock28_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock29_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock30_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock31_04pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock32_04pm"]').val('OK');
}if(checkBox3.checked!=true&&idClicked==="button5pm"){
	  $('input[name="visualcheckofudrainsforstock1_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock2_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock3_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock4_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock5_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock6_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock7_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock8_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock9_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock10_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock11_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock12_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock13_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock14_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock15_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock16_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock17_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock18_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock19_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock20_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock21_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock22_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock23_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock24_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock25_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock26_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock27_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock28_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock29_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock30_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock31_04pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock32_04pm"]').val('');
  }    	 
   if(idClicked==='button9pm' && v5!='button1am'&&document.getElementById("cmt9pm").checked==false){ 
		$('input[name="visualcheckofudrainsforstock1_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock2_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock3_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock4_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock5_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock6_08pm"]').val('OK');
		//$('input[name="visualcheckofudrainsforstock7_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock8_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock9_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock10_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock11_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock12_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock13_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock14_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock15_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock16_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock17_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock18_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock19_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock20_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock21_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock22_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock23_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock24_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock25_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock26_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock27_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock28_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock29_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock30_08pm"]').val('OK');
		$('input[name="visualcheckofudrainsforstock31_08pm"]').val('OK');
		//$('input[name="visualcheckofudrainsforstock32_08pm"]').val('OK');
  }if(checkBox4.checked!=true&&idClicked==="button9pm"){
	  $('input[name="visualcheckofudrainsforstock1_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock2_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock3_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock4_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock5_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock6_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock7_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock8_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock9_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock10_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock11_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock12_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock13_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock14_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock15_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock16_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock17_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock18_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock19_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock20_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock21_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock22_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock23_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock24_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock25_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock26_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock27_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock28_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock29_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock30_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock31_08pm"]').val('');
	  $('input[name="visualcheckofudrainsforstock32_08pm"]').val('');
    }    	 
   if(idClicked==='button1am' && v6!='button5am'&&document.getElementById("cmt1am").checked==false){ 
		$('input[name="visualcheckofudrainsforstock1_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock2_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock3_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock4_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock5_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock6_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock7_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock8_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock9_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock10_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock11_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock12_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock13_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock14_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock15_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock16_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock17_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock18_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock19_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock20_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock21_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock22_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock23_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock24_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock25_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock26_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock27_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock28_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock29_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock30_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock31_12am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock32_12am"]').val('OK');
  }if(checkBox5.checked!=true&&idClicked==="button1am"){
	  $('input[name="visualcheckofudrainsforstock1_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock2_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock3_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock4_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock5_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock6_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock7_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock8_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock9_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock10_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock11_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock12_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock13_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock14_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock15_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock16_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock17_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock18_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock19_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock20_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock21_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock22_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock23_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock24_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock25_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock26_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock27_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock28_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock29_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock30_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock31_12am"]').val('');
	  $('input[name="visualcheckofudrainsforstock32_12am"]').val('');
    }    	 
  if(idClicked==='button5am' &&document.getElementById("cmt5am").checked==false){
		$('input[name="visualcheckofudrainsforstock1_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock2_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock3_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock4_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock5_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock6_04am"]').val('OK');
	//	$('input[name="visualcheckofudrainsforstock7_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock8_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock9_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock10_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock11_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock12_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock13_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock14_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock15_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock16_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock17_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock18_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock19_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock20_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock21_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock22_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock23_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock24_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock25_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock26_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock27_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock28_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock29_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock30_04am"]').val('OK');
		$('input[name="visualcheckofudrainsforstock31_04am"]').val('OK');
	//	$('input[name="visualcheckofudrainsforstock32_04am"]').val('OK');
  }if(checkBox6.checked!=true&&idClicked==="button5am"){
	  $('input[name="visualcheckofudrainsforstock1_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock2_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock3_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock4_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock5_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock6_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock7_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock8_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock9_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock10_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock11_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock12_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock13_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock14_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock15_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock16_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock17_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock18_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock19_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock20_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock21_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock22_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock23_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock24_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock25_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock26_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock27_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock28_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock29_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock30_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock31_04am"]').val('');
	  $('input[name="visualcheckofudrainsforstock32_04am"]').val('');
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
