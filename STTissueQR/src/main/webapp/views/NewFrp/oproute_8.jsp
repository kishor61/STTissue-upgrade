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
		
		<c:if test="${data.position == 'OP8'}">	
			<spring:url value="/frpobccCommon/OpRoute_8/save" var="viewURL"/>
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

 <c:if test="${data.position == 'OP8'}">
   <div id="printDiv">
   		 <center>
   		  <c:if test="${data.position == 'OP8'}">
		   	<h1 style="font-size: 21px;color: #518f3e;">Operator Route 8 Outside</h1>
		 </c:if>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Route 8 Outside</h1>
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
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 8:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 12:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 4:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 8:00 PM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 12:00 AM</h1></td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"><h1> 4:00 AM</h1></td>
						  </tr>
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE PRESS FEED PUMP #1</h1></td>
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
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside1_8am}"  name="oproute_8outside1_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside1_12pm}"  name="oproute_8outside1_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside1_4pm}"  name="oproute_8outside1_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside1_8pm}"  name="oproute_8outside1_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside1_12am}"  name="oproute_8outside1_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside1_4am}"  name="oproute_8outside1_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE PRESS FEED PUMP #2</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside2_8am}"  name="oproute_8outside2_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside2_12pm}"  name="oproute_8outside2_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside2_4pm}"  name="oproute_8outside2_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside2_8pm}"  name="oproute_8outside2_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside2_12am}"  name="oproute_8outside2_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside2_4am}"  name="oproute_8outside2_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SPARE SLUDGE PRESS FEED PUMP</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside3_8am}"  name="oproute_8outside3_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside3_12pm}"  name="oproute_8outside3_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside3_4pm}"  name="oproute_8outside3_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside3_8pm}"  name="oproute_8outside3_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside3_12am}"  name="oproute_8outside3_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside3_4am}"  name="oproute_8outside3_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE PRESS SHOWER PUMP</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside4_8am}"  name="oproute_8outside4_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside4_12pm}"  name="oproute_8outside4_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside4_4pm}"  name="oproute_8outside4_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside4_8pm}"  name="oproute_8outside4_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside4_12am}"  name="oproute_8outside4_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside4_4am}"  name="oproute_8outside4_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE PRESS FEED TANK AGIT</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside5_8am}"  name="oproute_8outside5_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside5_12pm}"  name="oproute_8outside5_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside5_4pm}"  name="oproute_8outside5_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside5_8pm}"  name="oproute_8outside5_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside5_12am}"  name="oproute_8outside5_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside5_4am}"  name="oproute_8outside5_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE PRESS #1</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside6_8am}"  name="oproute_8outside6_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside6_12pm}"  name="oproute_8outside6_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside6_4pm}"  name="oproute_8outside6_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside6_8pm}"  name="oproute_8outside6_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside6_12am}"  name="oproute_8outside6_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside6_4am}"  name="oproute_8outside6_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						 <tr>						 
							<td class="tg-yw4l" ><h1>Identify and treat any slippery areas on floor around press. Eliminate slip hazard</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside7_8am}"  name="oproute_8outside7_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside7_12pm}"  disabled  name="oproute_8outside7_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside7_4pm}"  name="oproute_8outside7_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside7_8pm}"  disabled  name="oproute_8outside7_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside7_12am}"  name="oproute_8outside7_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside7_4am}"  disabled  name="oproute_8outside7_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1> FLUSH SHOWERS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside8_8am}"  name="oproute_8outside8_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside8_12pm}"  name="oproute_8outside8_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside8_4pm}"  name="oproute_8outside8_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside8_8pm}"  name="oproute_8outside8_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside8_12am}"  name="oproute_8outside8_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside8_4am}"  name="oproute_8outside8_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>TOP TENSION ROLL PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside9_8am}"  disabled  name="oproute_8outside9_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside9_12pm}"  name="oproute_8outside9_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside9_4pm}" disabled   name="oproute_8outside9_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside9_8pm}"  name="oproute_8outside9_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside9_12am}"  disabled  name="oproute_8outside9_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside9_4am}"  name="oproute_8outside9_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>BOTTOM TENSION ROLL PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside10_8am}"  disabled  name="oproute_8outside10_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside10_12pm}"  name="oproute_8outside10_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside10_4pm}"  disabled  name="oproute_8outside10_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside10_8pm}"  name="oproute_8outside10_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside10_12am}"  disabled  name="oproute_8outside10_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside10_4am}"  name="oproute_8outside10_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>BELT REGULATOR PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside11_8am}"  disabled  name="oproute_8outside11_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside11_12pm}"  name="oproute_8outside11_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside11_4pm}" disabled   name="oproute_8outside11_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside11_8pm}"  name="oproute_8outside11_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside11_12am}" disabled   name="oproute_8outside11_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside11_4am}"  name="oproute_8outside11_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>PRESS NIP ROLL #1</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside12_8am}" disabled   name="oproute_8outside12_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside12_12pm}"  name="oproute_8outside12_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside12_4pm}" disabled   name="oproute_8outside12_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside12_8pm}"  name="oproute_8outside12_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside12_12am}" disabled   name="oproute_8outside12_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside12_4am}"  name="oproute_8outside12_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>PRESS NIP ROLL #2</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside13_8am}"  disabled  name="oproute_8outside13_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside13_12pm}"  name="oproute_8outside13_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside13_4pm}"  disabled  name="oproute_8outside13_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside13_8pm}"  name="oproute_8outside13_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside13_12am}" disabled   name="oproute_8outside13_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside13_4am}"  name="oproute_8outside13_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>PRESS NIP ROLL #3</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside14_8am}" disabled   name="oproute_8outside14_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside14_12pm}"  name="oproute_8outside14_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside14_4pm}"  disabled  name="oproute_8outside14_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside14_8pm}"  name="oproute_8outside14_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside14_12am}" disabled   name="oproute_8outside14_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside14_4am}"  name="oproute_8outside14_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">GRAVITY BELT THICKENER # 1</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK AROUND AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside15_8am}"  name="oproute_8outside15_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside15_12pm}"  name="oproute_8outside15_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside15_4pm}"  name="oproute_8outside15_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside15_8pm}"  name="oproute_8outside15_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside15_12am}"  name="oproute_8outside15_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside15_4am}"  name="oproute_8outside15_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>FLUSH SHOWERS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside16_8am}"  name="oproute_8outside16_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside16_12pm}"  name="oproute_8outside16_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside16_4pm}"  name="oproute_8outside16_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside16_8pm}"  name="oproute_8outside16_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside16_12am}"  name="oproute_8outside16_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside16_4am}"  name="oproute_8outside16_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						 <tr>		 
							<td class="tg-yw4l" ><h1>BELT TENSION PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside17_8am}"disabled  name="oproute_8outside17_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside17_12pm}"  name="oproute_8outside17_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside17_4pm}" disabled name="oproute_8outside17_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside17_8pm}"  name="oproute_8outside17_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside17_12am}" disabled name="oproute_8outside17_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside17_4am}"  name="oproute_8outside17_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>BELT REGULATOR PRESSURE</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside18_8am}" disabled name="oproute_8outside18_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside18_12pm}"  name="oproute_8outside18_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside18_4pm}" disabled name="oproute_8outside18_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside18_8pm}"  name="oproute_8outside18_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside18_12am}" disabled name="oproute_8outside18_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside18_4am}"  name="oproute_8outside18_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SCREW PRESS</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>WALK BY AND VISUAL</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>6</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside19_8am}"  name="oproute_8outside19_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside19_12pm}"  name="oproute_8outside19_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside19_4pm}"  name="oproute_8outside19_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside19_8pm}"  name="oproute_8outside19_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside19_12am}"  name="oproute_8outside19_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside19_4am}"  name="oproute_8outside19_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						 <tr>						 
							<td class="tg-yw4l" ><h1>#1 SCREW CONVEYOR</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside20_8am}" disabled name="oproute_8outside20_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside20_12pm}"  name="oproute_8outside20_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside20_4pm}" disabled   name="oproute_8outside20_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside20_8pm}"  name="oproute_8outside20_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside20_12am}" disabled   name="oproute_8outside20_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside20_4am}"  name="oproute_8outside20_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>#2 SCREW CONVEYOR</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside21_8am}" disabled   name="oproute_8outside21_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside21_12pm}"  name="oproute_8outside21_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside21_4pm}" disabled   name="oproute_8outside21_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside21_8pm}"  name="oproute_8outside21_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside21_12am}" disabled   name="oproute_8outside21_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside21_4am}"  name="oproute_8outside21_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						
						
						<tr>						 
							<td class="tg-yw4l" ><h1>SCREW PRESS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside22_8am}" disabled   name="oproute_8outside22_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside22_12pm}"  name="oproute_8outside22_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside22_4pm}"  disabled  name="oproute_8outside22_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside22_8pm}"  name="oproute_8outside22_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside22_12am}"  disabled  name="oproute_8outside22_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside22_4am}"  name="oproute_8outside22_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>Screw Press Gear unit oil level</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside23_8am}"  disabled  name="oproute_8outside23_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside23_12pm}"  name="oproute_8outside23_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside23_4pm}"  disabled  name="oproute_8outside23_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside23_8pm}"  name="oproute_8outside23_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside23_12am}" disabled   name="oproute_8outside23_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside23_4am}"  name="oproute_8outside23_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>#3 SCREW CONVEYOR</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside24_8am}"  disabled  name="oproute_8outside24_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside24_12pm}"  name="oproute_8outside24_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside24_4pm}"  disabled  name="oproute_8outside24_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside24_8pm}"  name="oproute_8outside24_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside24_12am}" disabled   name="oproute_8outside24_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside24_4am}"  name="oproute_8outside24_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">SLUDGE, TRIPPER AND SHUTTLE CONVEYORS</h1></td>
						</tr>
						<tr>						 
							<td class="tg-yw4l" ><h1>SLUDGE, TRIPPER AND SHUTTLE CONVEYORS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside25_8am}"  disabled  name="oproute_8outside25_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside25_12pm}"  name="oproute_8outside25_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside25_4pm}"  disabled  name="oproute_8outside25_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside25_8pm}"  name="oproute_8outside25_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside25_12am}"  disabled  name="oproute_8outside25_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside25_4am}"  name="oproute_8outside25_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK LIMIT SWITCHES</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside26_8am}"  disabled  name="oproute_8outside26_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside26_12pm}"  name="oproute_8outside26_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside26_4pm}"  disabled  name="oproute_8outside26_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside26_8pm}"  name="oproute_8outside26_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside26_12am}"  disabled  name="oproute_8outside26_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside26_4am}"  name="oproute_8outside26_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK BELT CONDITION/TRACKING</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside27_8am}" disabled   name="oproute_8outside27_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside27_12pm}"  name="oproute_8outside27_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside27_4pm}"  disabled  name="oproute_8outside27_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside27_8pm}"  name="oproute_8outside27_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside27_12am}" disabled   name="oproute_8outside27_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside27_4am}"  name="oproute_8outside27_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>CHECK PULLEYS</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>3</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside28_8am}"  disabled  name="oproute_8outside28_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside28_12pm}"  name="oproute_8outside28_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside28_4pm}"  disabled  name="oproute_8outside28_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside28_8pm}"  name="oproute_8outside28_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside28_12am}" disabled   name="oproute_8outside28_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside28_4am}"  name="oproute_8outside28_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" ><h1>#1 Sludge press Discharge Consistency</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>1</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside29_8am}" disabled   name="oproute_8outside29_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside29_12pm}"  name="oproute_8outside29_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside29_4pm}"  disabled  name="oproute_8outside29_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside29_8pm}"  disabled  name="oproute_8outside29_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside29_12am}" disabled   name="oproute_8outside29_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside29_4am}"  disabled  name="oproute_8outside29_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 
							<td class="tg-yw4l" ><h1>#2 Sludge press Discharge Consistency</h1></td>
							<td class="tg-yw4l" style="text-align: center;"><h1>1</h1></td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.oproute_8outside30_8am}"  disabled  name="oproute_8outside30_8am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.oproute_8outside30_12pm}"  name="oproute_8outside30_12pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside30_4pm}"  disabled  name="oproute_8outside30_4pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside30_8pm}"  disabled  name="oproute_8outside30_8pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside30_12am}"  disabled  name="oproute_8outside30_12am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.oproute_8outside30_4am}"  disabled  name="oproute_8outside30_4am" style="margin-left: 1px !important;float: none;"/>					   					    		   
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
		$('input[name="oproute_8outside1_8am"]').val('OK');
		$('input[name="oproute_8outside2_8am"]').val('OK');
		$('input[name="oproute_8outside3_8am"]').val('OK');
		$('input[name="oproute_8outside4_8am"]').val('OK');
		$('input[name="oproute_8outside5_8am"]').val('OK');
		$('input[name="oproute_8outside6_8am"]').val('OK');
		$('input[name="oproute_8outside7_8am"]').val('OK');
		$('input[name="oproute_8outside8_8am"]').val('OK');
		/* $('input[name="oproute_8outside9_8am"]').val('OK');
		$('input[name="oproute_8outside10_8am"]').val('OK');
		$('input[name="oproute_8outside11_8am"]').val('OK');
		$('input[name="oproute_8outside12_8am"]').val('OK');
		$('input[name="oproute_8outside13_8am"]').val('OK');
		$('input[name="oproute_8outside14_8am"]').val('OK'); */
		$('input[name="oproute_8outside15_8am"]').val('OK');
		$('input[name="oproute_8outside16_8am"]').val('OK');
	/* 	$('input[name="oproute_8outside17_8am"]').val('OK');
		$('input[name="oproute_8outside18_8am"]').val('OK'); */
		$('input[name="oproute_8outside19_8am"]').val('OK');
		/* $('input[name="oproute_8outside20_8am"]').val('OK');
		$('input[name="oproute_8outside21_8am"]').val('OK');
		$('input[name="oproute_8outside22_8am"]').val('OK');
		$('input[name="oproute_8outside23_8am"]').val('OK');
		$('input[name="oproute_8outside24_8am"]').val('OK');
		$('input[name="oproute_8outside25_8am"]').val('OK');
		$('input[name="oproute_8outside26_8am"]').val('OK');
		$('input[name="oproute_8outside27_8am"]').val('OK');
		$('input[name="oproute_8outside28_8am"]').val('OK');
		$('input[name="oproute_8outside29_8am"]').val('OK');
		$('input[name="oproute_8outside30_8am"]').val('OK');
		$('input[name="oproute_8outside31_8am"]').val('OK');
		$('input[name="oproute_8outside32_8am"]').val('OK'); */
  }if(checkBox.checked!=true&&idClicked==="ok"){
	  $('input[name="oproute_8outside1_8am"]').val('');
	  $('input[name="oproute_8outside2_8am"]').val('');
	  $('input[name="oproute_8outside3_8am"]').val('');
	  $('input[name="oproute_8outside4_8am"]').val('');
	  $('input[name="oproute_8outside5_8am"]').val('');
	  $('input[name="oproute_8outside6_8am"]').val('');
	  $('input[name="oproute_8outside7_8am"]').val('');
	  $('input[name="oproute_8outside8_8am"]').val('');
	  $('input[name="oproute_8outside9_8am"]').val('');
	  $('input[name="oproute_8outside10_8am"]').val('');
	  $('input[name="oproute_8outside11_8am"]').val('');
	  $('input[name="oproute_8outside12_8am"]').val('');
	  $('input[name="oproute_8outside13_8am"]').val('');
	  $('input[name="oproute_8outside14_8am"]').val('');
	  $('input[name="oproute_8outside15_8am"]').val('');
	  $('input[name="oproute_8outside16_8am"]').val('');
	  $('input[name="oproute_8outside17_8am"]').val('');
	  $('input[name="oproute_8outside18_8am"]').val('');
	  $('input[name="oproute_8outside19_8am"]').val('');
	  $('input[name="oproute_8outside20_8am"]').val('');
	  $('input[name="oproute_8outside21_8am"]').val('');
	  $('input[name="oproute_8outside22_8am"]').val('');
	  $('input[name="oproute_8outside23_8am"]').val('');
	  $('input[name="oproute_8outside24_8am"]').val('');
	  $('input[name="oproute_8outside25_8am"]').val('');
	  $('input[name="oproute_8outside26_8am"]').val('');
	  $('input[name="oproute_8outside27_8am"]').val('');
	  $('input[name="oproute_8outside28_8am"]').val('');
	  $('input[name="oproute_8outside29_8am"]').val('');
	  $('input[name="oproute_8outside30_8am"]').val('');
	  $('input[name="oproute_8outside31_8am"]').val('');
	  $('input[name="oproute_8outside32_8am"]').val('');
    }    	 
  if(idClicked==='button1pm' && v3!='button5pm'&&document.getElementById("cmt1pm").checked==false){ 
		$('input[name="oproute_8outside1_12pm"]').val('OK');
		$('input[name="oproute_8outside2_12pm"]').val('OK');
		$('input[name="oproute_8outside3_12pm"]').val('OK');
		$('input[name="oproute_8outside4_12pm"]').val('OK');
		$('input[name="oproute_8outside5_12pm"]').val('OK');
		$('input[name="oproute_8outside6_12pm"]').val('OK');
	//	$('input[name="oproute_8outside7_12pm"]').val('OK');
		$('input[name="oproute_8outside8_12pm"]').val('OK');
		$('input[name="oproute_8outside9_12pm"]').val('OK');
		$('input[name="oproute_8outside10_12pm"]').val('OK');
		$('input[name="oproute_8outside11_12pm"]').val('OK');
		$('input[name="oproute_8outside12_12pm"]').val('OK');
		$('input[name="oproute_8outside13_12pm"]').val('OK');
		$('input[name="oproute_8outside14_12pm"]').val('OK');
		$('input[name="oproute_8outside15_12pm"]').val('OK');
		$('input[name="oproute_8outside16_12pm"]').val('OK');
		$('input[name="oproute_8outside17_12pm"]').val('OK');
		$('input[name="oproute_8outside18_12pm"]').val('OK');
		$('input[name="oproute_8outside19_12pm"]').val('OK');
		$('input[name="oproute_8outside20_12pm"]').val('OK');
		$('input[name="oproute_8outside21_12pm"]').val('OK');
		$('input[name="oproute_8outside22_12pm"]').val('OK');
		$('input[name="oproute_8outside23_12pm"]').val('OK');
		$('input[name="oproute_8outside24_12pm"]').val('OK');
		$('input[name="oproute_8outside25_12pm"]').val('OK');
		$('input[name="oproute_8outside26_12pm"]').val('OK');
		$('input[name="oproute_8outside27_12pm"]').val('OK');
		$('input[name="oproute_8outside28_12pm"]').val('OK');
		$('input[name="oproute_8outside29_12pm"]').val('OK');
		$('input[name="oproute_8outside30_12pm"]').val('OK');
		$('input[name="oproute_8outside31_12pm"]').val('OK');
	//	$('input[name="oproute_8outside32_12pm"]').val('OK');
  }if(checkBox2.checked!=true&&idClicked==="button1pm"){
	  $('input[name="oproute_8outside1_12pm"]').val('');
	  $('input[name="oproute_8outside2_12pm"]').val('');
	  $('input[name="oproute_8outside3_12pm"]').val('');
	  $('input[name="oproute_8outside4_12pm"]').val('');
	  $('input[name="oproute_8outside5_12pm"]').val('');
	  $('input[name="oproute_8outside6_12pm"]').val('');
	  $('input[name="oproute_8outside7_12pm"]').val('');
	  $('input[name="oproute_8outside8_12pm"]').val('');
	  $('input[name="oproute_8outside9_12pm"]').val('');
	  $('input[name="oproute_8outside10_12pm"]').val('');
	  $('input[name="oproute_8outside11_12pm"]').val('');
	  $('input[name="oproute_8outside12_12pm"]').val('');
	  $('input[name="oproute_8outside13_12pm"]').val('');
	  $('input[name="oproute_8outside14_12pm"]').val('');
	  $('input[name="oproute_8outside15_12pm"]').val('');
	  $('input[name="oproute_8outside16_12pm"]').val('');
	  $('input[name="oproute_8outside17_12pm"]').val('');
	  $('input[name="oproute_8outside18_12pm"]').val('');
	  $('input[name="oproute_8outside19_12pm"]').val('');
	  $('input[name="oproute_8outside20_12pm"]').val('');
	  $('input[name="oproute_8outside21_12pm"]').val('');
	  $('input[name="oproute_8outside22_12pm"]').val('');
	  $('input[name="oproute_8outside23_12pm"]').val('');
	  $('input[name="oproute_8outside24_12pm"]').val('');
	  $('input[name="oproute_8outside25_12pm"]').val('');
	  $('input[name="oproute_8outside26_12pm"]').val('');
	  $('input[name="oproute_8outside27_12pm"]').val('');
	  $('input[name="oproute_8outside28_12pm"]').val('');
	  $('input[name="oproute_8outside29_12pm"]').val('');
	  $('input[name="oproute_8outside30_12pm"]').val('');
	  $('input[name="oproute_8outside31_12pm"]').val('');
	  $('input[name="oproute_8outside32_12pm"]').val('');
    }    	 
   if(idClicked==='button5pm' && v4!='button9pm'&&document.getElementById("cmt5pm").checked==false){ 
		$('input[name="oproute_8outside1_4pm"]').val('OK');
		$('input[name="oproute_8outside2_4pm"]').val('OK');
		$('input[name="oproute_8outside3_4pm"]').val('OK');
		$('input[name="oproute_8outside4_4pm"]').val('OK');
		$('input[name="oproute_8outside5_4pm"]').val('OK');
		$('input[name="oproute_8outside6_4pm"]').val('OK');
		$('input[name="oproute_8outside7_4pm"]').val('OK');
		$('input[name="oproute_8outside8_4pm"]').val('OK');
	/* 	$('input[name="oproute_8outside9_4pm"]').val('OK');
		$('input[name="oproute_8outside10_4pm"]').val('OK');
		$('input[name="oproute_8outside11_4pm"]').val('OK');
		$('input[name="oproute_8outside12_4pm"]').val('OK');
		$('input[name="oproute_8outside13_4pm"]').val('OK');
		$('input[name="oproute_8outside14_4pm"]').val('OK'); */
		$('input[name="oproute_8outside15_4pm"]').val('OK');
		$('input[name="oproute_8outside16_4pm"]').val('OK');
		/* $('input[name="oproute_8outside17_4pm"]').val('OK');
		$('input[name="oproute_8outside18_4pm"]').val('OK'); */
		$('input[name="oproute_8outside19_4pm"]').val('OK');
		/* $('input[name="oproute_8outside20_4pm"]').val('OK');
		$('input[name="oproute_8outside21_4pm"]').val('OK');
		$('input[name="oproute_8outside22_4pm"]').val('OK');
		$('input[name="oproute_8outside23_4pm"]').val('OK');
		$('input[name="oproute_8outside24_4pm"]').val('OK');
		$('input[name="oproute_8outside25_4pm"]').val('OK');
		$('input[name="oproute_8outside26_4pm"]').val('OK');
		$('input[name="oproute_8outside27_4pm"]').val('OK');
		$('input[name="oproute_8outside28_4pm"]').val('OK');
		$('input[name="oproute_8outside29_4pm"]').val('OK');
		$('input[name="oproute_8outside30_4pm"]').val('OK');
		$('input[name="oproute_8outside31_4pm"]').val('OK');
		$('input[name="oproute_8outside32_4pm"]').val('OK'); */
}if(checkBox3.checked!=true&&idClicked==="button5pm"){
	  $('input[name="oproute_8outside1_4pm"]').val('');
	  $('input[name="oproute_8outside2_4pm"]').val('');
	  $('input[name="oproute_8outside3_4pm"]').val('');
	  $('input[name="oproute_8outside4_4pm"]').val('');
	  $('input[name="oproute_8outside5_4pm"]').val('');
	  $('input[name="oproute_8outside6_4pm"]').val('');
	  $('input[name="oproute_8outside7_4pm"]').val('');
	  $('input[name="oproute_8outside8_4pm"]').val('');
	  $('input[name="oproute_8outside9_4pm"]').val('');
	  $('input[name="oproute_8outside10_4pm"]').val('');
	  $('input[name="oproute_8outside11_4pm"]').val('');
	  $('input[name="oproute_8outside12_4pm"]').val('');
	  $('input[name="oproute_8outside13_4pm"]').val('');
	  $('input[name="oproute_8outside14_4pm"]').val('');
	  $('input[name="oproute_8outside15_4pm"]').val('');
	  $('input[name="oproute_8outside16_4pm"]').val('');
	  $('input[name="oproute_8outside17_4pm"]').val('');
	  $('input[name="oproute_8outside18_4pm"]').val('');
	  $('input[name="oproute_8outside19_4pm"]').val('');
	  $('input[name="oproute_8outside20_4pm"]').val('');
	  $('input[name="oproute_8outside21_4pm"]').val('');
	  $('input[name="oproute_8outside22_4pm"]').val('');
	  $('input[name="oproute_8outside23_4pm"]').val('');
	  $('input[name="oproute_8outside24_4pm"]').val('');
	  $('input[name="oproute_8outside25_4pm"]').val('');
	  $('input[name="oproute_8outside26_4pm"]').val('');
	  $('input[name="oproute_8outside27_4pm"]').val('');
	  $('input[name="oproute_8outside28_4pm"]').val('');
	  $('input[name="oproute_8outside29_4pm"]').val('');
	  $('input[name="oproute_8outside30_4pm"]').val('');
	  $('input[name="oproute_8outside31_4pm"]').val('');
	  $('input[name="oproute_8outside32_4pm"]').val('');
  }    	 
   if(idClicked==='button9pm' && v5!='button1am'&&document.getElementById("cmt9pm").checked==false){ 
		$('input[name="oproute_8outside1_8pm"]').val('OK');
		$('input[name="oproute_8outside2_8pm"]').val('OK');
		$('input[name="oproute_8outside3_8pm"]').val('OK');
		$('input[name="oproute_8outside4_8pm"]').val('OK');
		$('input[name="oproute_8outside5_8pm"]').val('OK');
		$('input[name="oproute_8outside6_8pm"]').val('OK');
		//$('input[name="oproute_8outside7_8pm"]').val('OK');
		$('input[name="oproute_8outside8_8pm"]').val('OK');
		$('input[name="oproute_8outside9_8pm"]').val('OK');
		$('input[name="oproute_8outside10_8pm"]').val('OK');
		$('input[name="oproute_8outside11_8pm"]').val('OK');
		$('input[name="oproute_8outside12_8pm"]').val('OK');
		$('input[name="oproute_8outside13_8pm"]').val('OK');
		$('input[name="oproute_8outside14_8pm"]').val('OK');
		$('input[name="oproute_8outside15_8pm"]').val('OK');
		$('input[name="oproute_8outside16_8pm"]').val('OK');
		$('input[name="oproute_8outside17_8pm"]').val('OK');
		$('input[name="oproute_8outside18_8pm"]').val('OK');
		$('input[name="oproute_8outside19_8pm"]').val('OK');
		$('input[name="oproute_8outside20_8pm"]').val('OK');
		$('input[name="oproute_8outside21_8pm"]').val('OK');
		$('input[name="oproute_8outside22_8pm"]').val('OK');
		$('input[name="oproute_8outside23_8pm"]').val('OK');
		$('input[name="oproute_8outside24_8pm"]').val('OK');
		$('input[name="oproute_8outside25_8pm"]').val('OK');
		$('input[name="oproute_8outside26_8pm"]').val('OK');
		$('input[name="oproute_8outside27_8pm"]').val('OK');
		$('input[name="oproute_8outside28_8pm"]').val('OK');
		//$('input[name="oproute_8outside29_8pm"]').val('OK');
	//$('input[name="oproute_8outside30_8pm"]').val('OK');
		//$('input[name="oproute_8outside31_8pm"]').val('OK');
		//$('input[name="oproute_8outside32_8pm"]').val('OK');
  }if(checkBox4.checked!=true&&idClicked==="button9pm"){
	  $('input[name="oproute_8outside1_8pm"]').val('');
	  $('input[name="oproute_8outside2_8pm"]').val('');
	  $('input[name="oproute_8outside3_8pm"]').val('');
	  $('input[name="oproute_8outside4_8pm"]').val('');
	  $('input[name="oproute_8outside5_8pm"]').val('');
	  $('input[name="oproute_8outside6_8pm"]').val('');
	  $('input[name="oproute_8outside7_8pm"]').val('');
	  $('input[name="oproute_8outside8_8pm"]').val('');
	  $('input[name="oproute_8outside9_8pm"]').val('');
	  $('input[name="oproute_8outside10_8pm"]').val('');
	  $('input[name="oproute_8outside11_8pm"]').val('');
	  $('input[name="oproute_8outside12_8pm"]').val('');
	  $('input[name="oproute_8outside13_8pm"]').val('');
	  $('input[name="oproute_8outside14_8pm"]').val('');
	  $('input[name="oproute_8outside15_8pm"]').val('');
	  $('input[name="oproute_8outside16_8pm"]').val('');
	  $('input[name="oproute_8outside17_8pm"]').val('');
	  $('input[name="oproute_8outside18_8pm"]').val('');
	  $('input[name="oproute_8outside19_8pm"]').val('');
	  $('input[name="oproute_8outside20_8pm"]').val('');
	  $('input[name="oproute_8outside21_8pm"]').val('');
	  $('input[name="oproute_8outside22_8pm"]').val('');
	  $('input[name="oproute_8outside23_8pm"]').val('');
	  $('input[name="oproute_8outside24_8pm"]').val('');
	  $('input[name="oproute_8outside25_8pm"]').val('');
	  $('input[name="oproute_8outside26_8pm"]').val('');
	  $('input[name="oproute_8outside27_8pm"]').val('');
	  $('input[name="oproute_8outside28_8pm"]').val('');
	  $('input[name="oproute_8outside29_8pm"]').val('');
	  $('input[name="oproute_8outside30_8pm"]').val('');
	  $('input[name="oproute_8outside31_8pm"]').val('');
	  $('input[name="oproute_8outside32_8pm"]').val('');
    }    	 
   if(idClicked==='button1am' && v6!='button5am'&&document.getElementById("cmt1am").checked==false){ 
		$('input[name="oproute_8outside1_12am"]').val('OK');
		$('input[name="oproute_8outside2_12am"]').val('OK');
		$('input[name="oproute_8outside3_12am"]').val('OK');
		$('input[name="oproute_8outside4_12am"]').val('OK');
		$('input[name="oproute_8outside5_12am"]').val('OK');
		$('input[name="oproute_8outside6_12am"]').val('OK');
		$('input[name="oproute_8outside7_12am"]').val('OK');
		$('input[name="oproute_8outside8_12am"]').val('OK');
	/* 	$('input[name="oproute_8outside9_12am"]').val('OK');
		$('input[name="oproute_8outside10_12am"]').val('OK');
		$('input[name="oproute_8outside11_12am"]').val('OK');
		$('input[name="oproute_8outside12_12am"]').val('OK');
		$('input[name="oproute_8outside13_12am"]').val('OK');
		$('input[name="oproute_8outside14_12am"]').val('OK'); */
		$('input[name="oproute_8outside15_12am"]').val('OK');
		$('input[name="oproute_8outside16_12am"]').val('OK');
		/* $('input[name="oproute_8outside17_12am"]').val('OK');
		$('input[name="oproute_8outside18_12am"]').val('OK'); */
		$('input[name="oproute_8outside19_12am"]').val('OK');
		/* $('input[name="oproute_8outside20_12am"]').val('OK');
		$('input[name="oproute_8outside21_12am"]').val('OK');
		$('input[name="oproute_8outside22_12am"]').val('OK');
		$('input[name="oproute_8outside23_12am"]').val('OK');
		$('input[name="oproute_8outside24_12am"]').val('OK');
		$('input[name="oproute_8outside25_12am"]').val('OK');
		$('input[name="oproute_8outside26_12am"]').val('OK');
		$('input[name="oproute_8outside27_12am"]').val('OK');
		$('input[name="oproute_8outside28_12am"]').val('OK');
		$('input[name="oproute_8outside29_12am"]').val('OK');
		$('input[name="oproute_8outside30_12am"]').val('OK');
		$('input[name="oproute_8outside31_12am"]').val('OK');
		$('input[name="oproute_8outside32_12am"]').val('OK'); */
  }if(checkBox5.checked!=true&&idClicked==="button1am"){
	  $('input[name="oproute_8outside1_12am"]').val('');
	  $('input[name="oproute_8outside2_12am"]').val('');
	  $('input[name="oproute_8outside3_12am"]').val('');
	  $('input[name="oproute_8outside4_12am"]').val('');
	  $('input[name="oproute_8outside5_12am"]').val('');
	  $('input[name="oproute_8outside6_12am"]').val('');
	  $('input[name="oproute_8outside7_12am"]').val('');
	  $('input[name="oproute_8outside8_12am"]').val('');
	  $('input[name="oproute_8outside9_12am"]').val('');
	  $('input[name="oproute_8outside10_12am"]').val('');
	  $('input[name="oproute_8outside11_12am"]').val('');
	  $('input[name="oproute_8outside12_12am"]').val('');
	  $('input[name="oproute_8outside13_12am"]').val('');
	  $('input[name="oproute_8outside14_12am"]').val('');
	  $('input[name="oproute_8outside15_12am"]').val('');
	  $('input[name="oproute_8outside16_12am"]').val('');
	  $('input[name="oproute_8outside17_12am"]').val('');
	  $('input[name="oproute_8outside18_12am"]').val('');
	  $('input[name="oproute_8outside19_12am"]').val('');
	  $('input[name="oproute_8outside20_12am"]').val('');
	  $('input[name="oproute_8outside21_12am"]').val('');
	  $('input[name="oproute_8outside22_12am"]').val('');
	  $('input[name="oproute_8outside23_12am"]').val('');
	  $('input[name="oproute_8outside24_12am"]').val('');
	  $('input[name="oproute_8outside25_12am"]').val('');
	  $('input[name="oproute_8outside26_12am"]').val('');
	  $('input[name="oproute_8outside27_12am"]').val('');
	  $('input[name="oproute_8outside28_12am"]').val('');
	  $('input[name="oproute_8outside29_12am"]').val('');
	  $('input[name="oproute_8outside30_12am"]').val('');
	  $('input[name="oproute_8outside31_12am"]').val('');
	  $('input[name="oproute_8outside32_12am"]').val('');
    }    	 
   if(idClicked==='button5am' &&document.getElementById("cmt5am").checked==false){
		$('input[name="oproute_8outside1_4am"]').val('OK');
		$('input[name="oproute_8outside2_4am"]').val('OK');
		$('input[name="oproute_8outside3_4am"]').val('OK');
		$('input[name="oproute_8outside4_4am"]').val('OK');
		$('input[name="oproute_8outside5_4am"]').val('OK');
		$('input[name="oproute_8outside6_4am"]').val('OK');
	//	$('input[name="oproute_8outside7_4am"]').val('OK');
		$('input[name="oproute_8outside8_4am"]').val('OK');
		$('input[name="oproute_8outside9_4am"]').val('OK');
		$('input[name="oproute_8outside10_4am"]').val('OK');
		$('input[name="oproute_8outside11_4am"]').val('OK');
		$('input[name="oproute_8outside12_4am"]').val('OK');
		$('input[name="oproute_8outside13_4am"]').val('OK');
		$('input[name="oproute_8outside14_4am"]').val('OK');
		$('input[name="oproute_8outside15_4am"]').val('OK');
		$('input[name="oproute_8outside16_4am"]').val('OK');
		$('input[name="oproute_8outside17_4am"]').val('OK');
		$('input[name="oproute_8outside18_4am"]').val('OK');
		$('input[name="oproute_8outside19_4am"]').val('OK');
		$('input[name="oproute_8outside20_4am"]').val('OK');
		$('input[name="oproute_8outside21_4am"]').val('OK');
		$('input[name="oproute_8outside22_4am"]').val('OK');
		$('input[name="oproute_8outside23_4am"]').val('OK');
		$('input[name="oproute_8outside24_4am"]').val('OK');
		$('input[name="oproute_8outside25_4am"]').val('OK');
		$('input[name="oproute_8outside26_4am"]').val('OK');
		$('input[name="oproute_8outside27_4am"]').val('OK');
		$('input[name="oproute_8outside28_4am"]').val('OK');
		//$('input[name="oproute_8outside29_4am"]').val('OK');
		//$('input[name="oproute_8outside30_4am"]').val('OK');
		//$('input[name="oproute_8outside31_4am"]').val('OK');
	//	$('input[name="oproute_8outside32_4am"]').val('OK');
  }if(checkBox6.checked!=true&&idClicked==="button5am"){
	  $('input[name="oproute_8outside1_4am"]').val('');
	  $('input[name="oproute_8outside2_4am"]').val('');
	  $('input[name="oproute_8outside3_4am"]').val('');
	  $('input[name="oproute_8outside4_4am"]').val('');
	  $('input[name="oproute_8outside5_4am"]').val('');
	  $('input[name="oproute_8outside6_4am"]').val('');
	  $('input[name="oproute_8outside7_4am"]').val('');
	  $('input[name="oproute_8outside8_4am"]').val('');
	  $('input[name="oproute_8outside9_4am"]').val('');
	  $('input[name="oproute_8outside10_4am"]').val('');
	  $('input[name="oproute_8outside11_4am"]').val('');
	  $('input[name="oproute_8outside12_4am"]').val('');
	  $('input[name="oproute_8outside13_4am"]').val('');
	  $('input[name="oproute_8outside14_4am"]').val('');
	  $('input[name="oproute_8outside15_4am"]').val('');
	  $('input[name="oproute_8outside16_4am"]').val('');
	  $('input[name="oproute_8outside17_4am"]').val('');
	  $('input[name="oproute_8outside18_4am"]').val('');
	  $('input[name="oproute_8outside19_4am"]').val('');
	  $('input[name="oproute_8outside20_4am"]').val('');
	  $('input[name="oproute_8outside21_4am"]').val('');
	  $('input[name="oproute_8outside22_4am"]').val('');
	  $('input[name="oproute_8outside23_4am"]').val('');
	  $('input[name="oproute_8outside24_4am"]').val('');
	  $('input[name="oproute_8outside25_4am"]').val('');
	  $('input[name="oproute_8outside26_4am"]').val('');
	  $('input[name="oproute_8outside27_4am"]').val('');
	  $('input[name="oproute_8outside28_4am"]').val('');
	  $('input[name="oproute_8outside29_4am"]').val('');
	  $('input[name="oproute_8outside30_4am"]').val('');
	  $('input[name="oproute_8outside31_4am"]').val('');
	  $('input[name="oproute_8outside32_4am"]').val('');
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
