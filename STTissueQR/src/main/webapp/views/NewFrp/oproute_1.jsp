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
		$('#tbbl td').css("fontSize", 15);
		$('#tbbl td h2').css("fontSize", 15);
		$('#tbbl td span').css("fontSize", 15);
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
		
		<c:if test="${data.position == 'OP1'}">	
			<spring:url value="/frpobccCommon/OpRoute_1/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Route 1 Process Floor</span>
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

 <c:if test="${data.position == 'OP1'}">
   <div id="printDiv">
   		 <center>
   		  <c:if test="${data.position == 'OP1'}">
		   	<h1 style="font-size: 21px;color: #518f3e;">Operator Route 1 Process Floor
		 </c:if> 
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Route 1 Process Floor
		 		</div>
		 		<%-- <div style="float: right;}">
		 			<span><b style="font-size: 15px;">Operator : </b>${data.operatorname}</span>
		 		</div> --%>
		 		<div style="float: right;    margin-right: -130px;">
		 		 <br/>
		 			<span><b style="font-size: 15px;">Date:</b>${data.date}</span> &nbsp;&nbsp;&nbsp;
		 			
		 		</div>
		 	</div>	
		 
		 			
				 <table border="1" style="width:75%" id="tbbl">				
						<tr>					    
						    <td class="tg-yw4l" >TECHNICIANS INITIALS</td>
						    <td>
								<input type="text" class="input" value="${data.techniciansinitials_freq}"  name="techniciansinitials_freq" style="margin: 1px !important;float: none;"/>
							</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_9am}"  name="techniciansinitials_9am" style="margin: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_1pm}"  name="techniciansinitials_1pm" style="margin: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_5pm}"  name="techniciansinitials_5pm" style="margin: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_9pm}"  name="techniciansinitials_9pm" style="margin: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_1am}"  name="techniciansinitials_1am" style="margin: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.techniciansinitials_5am}"  name="techniciansinitials_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>
						<tr>
							<td class="tg-yw4l" >STATION - EQUIPMENT</td>	
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;">FREQ</td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"> 09:00 AM</td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"> 01:00 PM</td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"> 05:00 PM</td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"> 09:00 PM</td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"> 01:00 AM</td>
						    <td  class="input" style="margin-left: 1px !important;text-align: center;float: none;"> 05:00 AM</td>			   					    		   
						</tr>
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">H. D. CLEANERS</td>
							<td></td> 
							<td align="center" id="ok1"><input id="ok"  type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="ok" name="ok" ${data.ok == 'ok' ? 'checked' : ''}></td>
							<td align="center" id="ok2"><input id="button1pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1pm" name="button1pm" ${data.button1pm == 'button1pm' ? 'checked' : ''}></td>
							<td align="center" id="ok3"><input id="button5pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5pm" name="button5pm" ${data.button5pm == 'button5pm' ? 'checked' : ''}></td>
							<td align="center" id="ok4"><input id="button9pm" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button9pm" name="button9pm" ${data.button9pm == 'button9pm' ? 'checked' : ''}></td>
							<td align="center" id="ok5"><input id="button1am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button1am" name="button1am" ${data.button1am == 'button1am' ? 'checked' : ''}></td>
							<td align="center" id="ok6"><input id="button5am" type="checkbox" style="width:15px;height:20px;margin-top: 4px;" value="button5am" name="button5am" ${data.button5am == 'button5am' ? 'checked' : ''}></td>
															
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >#1 HD CLEANER - flush </td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.hdcleaner1_9am}"  name="hdcleaner1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.hdcleaner1_1pm}"  name="hdcleaner1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner1_5pm}"  name="hdcleaner1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner1_9pm}"  name="hdcleaner1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner1_1am}"  name="hdcleaner1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner1_5am}"  name="hdcleaner1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >#2 HD CLEANER - flush </td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.hdcleaner2_9am}"  name="hdcleaner2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.hdcleaner2_1pm}"  name="hdcleaner2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner2_5pm}"  name="hdcleaner2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner2_9pm}"  name="hdcleaner2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner2_1am}"  name="hdcleaner2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner2_5am}"  name="hdcleaner2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >#3 HD CLEANER - flush </td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.hdcleaner3_9am}"  name="hdcleaner3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.hdcleaner3_1pm}"  name="hdcleaner3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner3_5pm}"  name="hdcleaner3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner3_9pm}"  name="hdcleaner3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner3_1am}"  name="hdcleaner3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner3_5am}"  name="hdcleaner3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >#4 HD CLEANER - flush </td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.hdcleaner4_9am}"  name="hdcleaner4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.hdcleaner4_1pm}"  name="hdcleaner4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner4_5pm}"  name="hdcleaner4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner4_9pm}"  name="hdcleaner4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner4_1am}"  name="hdcleaner4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleaner4_5am}"  name="hdcleaner4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >B-LINE H D. CLEANER </td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.hdcleanerb_9am}"  name="hdcleanerb_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.hdcleanerb_1pm}"  name="hdcleanerb_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleanerb_5pm}"  name="hdcleanerb_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleanerb_9pm}"  name="hdcleanerb_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleanerb_1am}"  name="hdcleanerb_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.hdcleanerb_5am}"  name="hdcleanerb_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DRUM SCREEN</td>
						 </tr> 
												 
							<td class="tg-yw4l" >OPEN/Close  INTERNAL SHOWER VALVE</td>
							<td class="tg-yw4l" style="text-align: center;">3</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.drumscreen1_9am}" disabled name="drumscreen1_9am" style="margin-left: 1px !important;float: none;background-color:#404040;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.drumscreen1_1pm}"  name="drumscreen1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen1_5pm}" disabled name="drumscreen1_5pm" style="margin-left: 1px !important;float: none;background-color:#404040;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen1_9pm}"  name="drumscreen1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen1_1am}" disabled name="drumscreen1_1am" style="margin-left: 1px !important;float: none;background-color:#404040;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen1_5am}"  name="drumscreen1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr>  
						<tr>						 						 
							<td class="tg-yw4l" >MOTOR AND BEARINGS OK</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.drumscreen2_9am}"  name="drumscreen2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.drumscreen2_1pm}"  name="drumscreen2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen2_5pm}"  name="drumscreen2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen2_9pm}"  name="drumscreen2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen2_1am}"  name="drumscreen2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen2_5am}"  name="drumscreen2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >A - Pulper feed conv. check drive fluid</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.drumscreen3_9am}"  name="drumscreen3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.drumscreen3_1pm}"  name="drumscreen3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen3_5pm}"  name="drumscreen3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen3_9pm}"  name="drumscreen3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen3_1am}"  name="drumscreen3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.drumscreen3_5am}"  name="drumscreen3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">COARSE SCREENS</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >PRIMARY COARSE "B" Mech Seal</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens1_9am}"  name="coarsescreens1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens1_1pm}"  name="coarsescreens1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens1_5pm}"  name="coarsescreens1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens1_9pm}"  name="coarsescreens1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens1_1am}"  name="coarsescreens1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens1_5am}"  name="coarsescreens1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >PRIMARY COARSE "A" PACKING</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens2_9am}"  name="coarsescreens2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens2_1pm}"  name="coarsescreens2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens2_5pm}"  name="coarsescreens2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens2_9pm}"  name="coarsescreens2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens2_1am}"  name="coarsescreens2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens2_5am}"  name="coarsescreens2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECONDARY COARSE "B" PACKING</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens3_9am}"  name="coarsescreens3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens3_1pm}"  name="coarsescreens3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens3_5pm}"  name="coarsescreens3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens3_9pm}"  name="coarsescreens3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens3_1am}"  name="coarsescreens3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens3_5am}"  name="coarsescreens3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECONDARY COARSE "A" PACKING</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens4_9am}"  name="coarsescreens4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens4_1pm}"  name="coarsescreens4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens4_5pm}"  name="coarsescreens4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens4_9pm}"  name="coarsescreens4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens4_1am}"  name="coarsescreens4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens4_5am}"  name="coarsescreens4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >Reject Sorter - showers</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens5_9am}"  name="coarsescreens5_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens5_1pm}"  name="coarsescreens5_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens5_5pm}"  name="coarsescreens5_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens5_9pm}"  name="coarsescreens5_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens5_1am}"  name="coarsescreens5_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens5_5am}"  name="coarsescreens5_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >Reject Sorter - Paddles</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens6_9am}"  name="coarsescreens6_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens6_1pm}"  name="coarsescreens6_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens6_5pm}"  name="coarsescreens6_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens6_9pm}"  name="coarsescreens6_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens6_1am}"  name="coarsescreens6_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens6_5am}"  name="coarsescreens6_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >TERTIARY COARSE "A" PACKING</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.coarsescreens7_9am}"  name="coarsescreens7_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.coarsescreens7_1pm}"  name="coarsescreens7_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens7_5pm}"  name="coarsescreens7_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens7_9pm}"  name="coarsescreens7_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens7_1am}"  name="coarsescreens7_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.coarsescreens7_5am}"  name="coarsescreens7_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">FINE SCREENS</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >PRIMARY FINE SCREEN "A" MECH SEAL</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.finescreens1_9am}"  name="finescreens1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.finescreens1_1pm}"  name="finescreens1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens1_5pm}"  name="finescreens1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens1_9pm}"  name="finescreens1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens1_1am}"  name="finescreens1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens1_5am}"  name="finescreens1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECONDARY FINE SCREEN "A" MECH SEAL</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.finescreens2_9am}"  name="finescreens2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.finescreens2_1pm}"  name="finescreens2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens2_5pm}"  name="finescreens2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens2_9pm}"  name="finescreens2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens2_1am}"  name="finescreens2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens2_5am}"  name="finescreens2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >TERTIARY FINE SCREEN"A" PACKING</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.finescreens3_9am}"  name="finescreens3_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.finescreens3_1pm}"  name="finescreens3_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens3_5pm}"  name="finescreens3_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens3_9pm}"  name="finescreens3_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens3_1am}"  name="finescreens3_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens3_5am}"  name="finescreens3_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >PRIMARY FINE SCREEN "B" MECH SEAL</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.finescreens4_9am}"  name="finescreens4_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.finescreens4_1pm}"  name="finescreens4_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens4_5pm}"  name="finescreens4_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens4_9pm}"  name="finescreens4_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens4_1am}"  name="finescreens4_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens4_5am}"  name="finescreens4_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECONDARY FINE SCREEN "B" MECH SEAL</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.finescreens5_9am}"  name="finescreens5_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.finescreens5_1pm}"  name="finescreens5_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens5_5pm}"  name="finescreens5_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens5_9pm}"  name="finescreens5_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens5_1am}"  name="finescreens5_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens5_5am}"  name="finescreens5_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >TERTIARY FINE SCREEN"B" PACKING</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.finescreens6_9am}"  name="finescreens6_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.finescreens6_1pm}"  name="finescreens6_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens6_5pm}"  name="finescreens6_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens6_9pm}"  name="finescreens6_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens6_1am}"  name="finescreens6_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.finescreens6_5am}"  name="finescreens6_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Shower Pumps</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECOND LOOP SHOWER PUMP</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.showerpumps1_9am}"  name="showerpumps1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.showerpumps1_1pm}"  name="showerpumps1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps1_5pm}"  name="showerpumps1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps1_9pm}"  name="showerpumps1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps1_1am}"  name="showerpumps1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps1_5am}"  name="showerpumps1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >FIRST LOOP SHOWER PUMP</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.showerpumps2_9am}"  name="showerpumps2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.showerpumps2_1pm}"  name="showerpumps2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps2_5pm}"  name="showerpumps2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps2_9pm}"  name="showerpumps2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps2_1am}"  name="showerpumps2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.showerpumps2_5am}"  name="showerpumps2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Decker Feed Pump</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECOND ST DECKER #1 FEED PUMP</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump1_9am}"  name="deckerfeedpump1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump1_1pm}"  name="deckerfeedpump1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump1_5pm}"  name="deckerfeedpump1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump1_9pm}"  name="deckerfeedpump1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump1_1am}"  name="deckerfeedpump1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump1_5am}"  name="deckerfeedpump1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >SECOND ST DECKER #2 FEED PUMP</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump2_9am}"  name="deckerfeedpump2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump2_1pm}"  name="deckerfeedpump2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump2_5pm}"  name="deckerfeedpump2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump2_9pm}"  name="deckerfeedpump2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump2_1am}"  name="deckerfeedpump2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.deckerfeedpump2_5am}"  name="deckerfeedpump2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">DAF</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >DAF PADDLE DRIVES</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.daf1_9am}"  name="daf1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.daf1_1pm}"  name="daf1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf1_5pm}"  name="daf1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf1_9pm}"  name="daf1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf1_1am}"  name="daf1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf1_5am}"  name="daf1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>						 
							<td class="tg-yw4l" >DAF UDS SYSTEM PUMP</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.daf2_9am}"  name="daf2_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.daf2_1pm}"  name="daf2_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf2_5pm}"  name="daf2_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf2_9pm}"  name="daf2_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf2_1am}"  name="daf2_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.daf2_5am}"  name="daf2_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
							</td>
						</tr> 
						<tr>
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Roll Up Process Floor Wash-up Hoses</td>
							<td class="tg-yw4l" style="text-align: center;">6</td>
							<td>						   					    		   
								<input type="text" class="input" value="${data.rollupprocessfloorwashuphoses1_9am}"  name="rollupprocessfloorwashuphoses1_9am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>					   					    		   
								<input type="text" class="input" value="${data.rollupprocessfloorwashuphoses1_1pm}"  name="rollupprocessfloorwashuphoses1_1pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rollupprocessfloorwashuphoses1_5pm}"  name="rollupprocessfloorwashuphoses1_5pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rollupprocessfloorwashuphoses1_9pm}"  name="rollupprocessfloorwashuphoses1_9pm" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rollupprocessfloorwashuphoses1_1am}"  name="rollupprocessfloorwashuphoses1_1am" style="margin-left: 1px !important;float: none;"/>	
							</td>
							<td>				   					    		   
								<input type="text" class="input" value="${data.rollupprocessfloorwashuphoses1_5am}"  name="rollupprocessfloorwashuphoses1_5am" style="margin-left: 1px !important;float: none;"/>					   					    		   
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
							<td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Missed Reason</td>
							<td class="tg-yw4l" style="text-align: center;"></td>
							<td >
								<input type="text" disabled id="cmt9amarea" class="input" value="${data.cmt9amarea}"  name="cmt9amarea" style="margin-left: 1px !important;float: none;"/>
							</td>
							<td >
								<input type="text" disabled id="cmt1pmarea"class="input" value="${data.cmt1pmarea}"  name="cmt1pmarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td  >
								<input type="text" disabled id="cmt5pmarea"class="input" value="${data.cmt5pmarea}"  name="cmt5pmarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td   >
								<input type="text" disabled id="cmt9pmarea"class="input" value="${data.cmt9pmarea}"  name="cmt9pmarea"  style="margin-left: 1px !important;float: none;"/>
							</td>
							<td  >
								<input type="text" disabled id="cmt1amarea" class="input" value="${data.cmt1amarea}"  name="cmt1amarea" style="margin-left: 1px !important;float: none;" />
							</td>
							<td  >
								<input type="text" disabled id="cmt5amarea" class="input" value="${data.cmt5amarea}"  name="cmt5amarea"  style="margin-left: 1px !important;float: none;"/>
							</td>
						</tr>					
				  </table>
				  <table border="1" style="width:75%">		
				 	 <tr>
						<td width="30%"><h1 style="font-size: 15px;">COMMENTS :</td>
						<td height="30">
							<p><textarea name="comments" cols="100" rows="5" ><c:out value="${data.comments}"/></textarea></p>
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
						<button class="button" type="submit" onclick="bClick()">Submit</button>
					</div>
			    </c:when>
			  
			    <c:otherwise>
			        <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn1" class="button">Print</button>
						<button class="button" type="submit" onclick="bClick()">Submit</button>
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
	    	   if(idClicked==="cmt9am"){
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
	    	   if(idClicked==="cmt1pm"){
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
	    	   if(idClicked==="cmt5pm"){
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
	    	   if(idClicked==="cmt9pm"){
	    		   var cmt9pmarea= $('#cmt9pmarea').val();
	    		   var ok= document.getElementById("button9pm");
	    		   if(cmt9pmarea==''&&ok.checked==false)
	    		  	 var miss = prompt("Please give  Reson for Missed Entry", "");
	    		   else
	    			   alert("Reason already submitted");
	    		   if(miss!=''&&miss!=null&&document.getElementById("button9pm").checked!=true){
	    			 //  $( "#button9pm" ).trigger( "click" );
	    			 // $("input[name='cmt9pmarea']").prop('disabled', false);
	    			   $("input[name='cmt9pmarea']").val(miss);
	    		   }else
	    			   $( "#cmt9pm" ).prop( "checked", false );	
	   					    			  
	    	   }
	    	   var checkBox = document.getElementById("cmt1am");	    	 
	    	   if(idClicked==="cmt1am"){
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
	    	   if(idClicked==="cmt5am"){
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
       $("#ok,#button1pm,#button5pm,#button9pm,#button1am,#button5am,#cmt9am,#cmt1pm,#cmt5pm,#cmt9pm,#cmt1am,#cmt5am").click(function() {
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
    				
    				  if(idClicked==='ok'&& v2!='button1pm'&&document.getElementById("cmt9am").checked==false){ 
    		        		  $('input[name="hdcleaner1_9am"]').val('Ok');
    		     			  $('input[name="hdcleaner2_9am"]').val('Ok');
    		     			  $('input[name="hdcleaner3_9am"]').val('Ok');
    		     			  $('input[name="hdcleaner4_9am"]').val('Ok');
    		     			  $('input[name="hdcleanerb_9am"]').val('Ok');
    		     			 // $('input[name="drumscreen1_9am"]').val('Ok');
    		     			  $('input[name="drumscreen2_9am"]').val('Ok');
    		     			  $('input[name="drumscreen3_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens1_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens2_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens3_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens4_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens5_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens6_9am"]').val('Ok');
    		     			  $('input[name="coarsescreens7_9am"]').val('Ok');
    		     			  $('input[name="finescreens1_9am"]').val('Ok');
    		     			  $('input[name="finescreens2_9am"]').val('Ok');
    		     			  $('input[name="finescreens3_9am"]').val('Ok');
    		     			  $('input[name="finescreens4_9am"]').val('Ok');
    		     			  $('input[name="finescreens5_9am"]').val('Ok');
    		     			  $('input[name="finescreens6_9am"]').val('Ok');
    		     			  $('input[name="showerpumps1_9am"]').val('Ok');
    		     			  $('input[name="showerpumps2_9am"]').val('Ok');
    		     			  $('input[name="deckerfeedpump1_9am"]').val('Ok');
    		     			  $('input[name="deckerfeedpump2_9am"]').val('Ok');
    		     			  $('input[name="daf1_9am"]').val('Ok');
    		     			  $('input[name="daf2_9am"]').val('Ok');
    		     			  $('input[name="rollupprocessfloorwashuphoses1_9am"]').val('Ok');
    		             
    		    	  }
    		   if(idClicked==='button1pm' && v3!='button5pm'&&document.getElementById("cmt1pm").checked==false){ 
    		        	 $('input[name="hdcleaner1_1pm"]').val('OK');
    					  $('input[name="hdcleaner2_1pm"]').val('OK');
    					  $('input[name="hdcleaner3_1pm"]').val('OK');
    					  $('input[name="hdcleaner4_1pm"]').val('OK');
    					  $('input[name="hdcleanerb_1pm"]').val('OK');
    					  $('input[name="drumscreen1_1pm"]').val('OK');
    					  $('input[name="drumscreen2_1pm"]').val('OK');
    					  $('input[name="drumscreen3_1pm"]').val('OK');
    					  $('input[name="coarsescreens1_1pm"]').val('OK');
    					  $('input[name="coarsescreens2_1pm"]').val('OK');
    					  $('input[name="coarsescreens3_1pm"]').val('OK');
    					  $('input[name="coarsescreens4_1pm"]').val('OK');
    					  $('input[name="coarsescreens5_1pm"]').val('OK');
    					  $('input[name="coarsescreens6_1pm"]').val('OK');
    					  $('input[name="coarsescreens7_1pm"]').val('OK');
    					  $('input[name="finescreens1_1pm"]').val('OK');
    					  $('input[name="finescreens2_1pm"]').val('OK');
    					  $('input[name="finescreens3_1pm"]').val('OK');
    					  $('input[name="finescreens4_1pm"]').val('OK');
    					  $('input[name="finescreens5_1pm"]').val('OK');
    					  $('input[name="finescreens6_1pm"]').val('OK');
    					  $('input[name="showerpumps1_1pm"]').val('OK');
    					  $('input[name="showerpumps2_1pm"]').val('OK');
    					  $('input[name="deckerfeedpump1_1pm"]').val('OK');
    					  $('input[name="deckerfeedpump2_1pm"]').val('OK');
    					  $('input[name="daf1_1pm"]').val('OK');
    					  $('input[name="daf2_1pm"]').val('OK');
    					  $('input[name="rollupprocessfloorwashuphoses1_1pm"]').val('OK');
		    	  }
    		   if(idClicked==='button5pm' && v4!='button9pm'&&document.getElementById("cmt5pm").checked==false){ 
    		      		 $('input[name="hdcleaner1_5pm"]').val('OK');
    					  $('input[name="hdcleaner2_5pm"]').val('OK');
    					  $('input[name="hdcleaner3_5pm"]').val('OK');
    					  $('input[name="hdcleaner4_5pm"]').val('OK');
    					  $('input[name="hdcleanerb_5pm"]').val('OK');
    					//  $('input[name="drumscreen1_5pm"]').val('OK');
    					  $('input[name="drumscreen2_5pm"]').val('OK');
    					  $('input[name="drumscreen3_5pm"]').val('OK');
    					  $('input[name="coarsescreens1_5pm"]').val('OK');
    					  $('input[name="coarsescreens2_5pm"]').val('OK');
    					  $('input[name="coarsescreens3_5pm"]').val('OK');
    					  $('input[name="coarsescreens4_5pm"]').val('OK');
    					  $('input[name="coarsescreens5_5pm"]').val('OK');
    					  $('input[name="coarsescreens6_5pm"]').val('OK');
    					  $('input[name="coarsescreens7_5pm"]').val('OK');
    					  $('input[name="finescreens1_5pm"]').val('OK');
    					  $('input[name="finescreens2_5pm"]').val('OK');
    					  $('input[name="finescreens3_5pm"]').val('OK');
    					  $('input[name="finescreens4_5pm"]').val('OK');
    					  $('input[name="finescreens5_5pm"]').val('OK');
    					  $('input[name="finescreens6_5pm"]').val('OK');
    					  $('input[name="showerpumps1_5pm"]').val('OK');
    					  $('input[name="showerpumps2_5pm"]').val('OK');
    					  $('input[name="deckerfeedpump1_5pm"]').val('OK');
    					  $('input[name="deckerfeedpump2_5pm"]').val('OK');
    					  $('input[name="daf1_5pm"]').val('OK');
    					  $('input[name="daf2_5pm"]').val('OK');
    					  $('input[name="rollupprocessfloorwashuphoses1_5pm"]').val('OK');
		    	  }
    		   if(idClicked==='button9pm' && v5!='button1am'&&document.getElementById("cmt9pm").checked==false){ 
    		     		 $('input[name="hdcleaner1_9pm"]').val('OK');
    					  $('input[name="hdcleaner2_9pm"]').val('OK');
    					  $('input[name="hdcleaner3_9pm"]').val('OK');
    					  $('input[name="hdcleaner4_9pm"]').val('OK');
    					  $('input[name="hdcleanerb_9pm"]').val('OK');
    					  $('input[name="drumscreen1_9pm"]').val('OK');
    					  $('input[name="drumscreen2_9pm"]').val('OK');
    					  $('input[name="drumscreen3_9pm"]').val('OK');
    					  $('input[name="coarsescreens1_9pm"]').val('OK');
    					  $('input[name="coarsescreens2_9pm"]').val('OK');
    					  $('input[name="coarsescreens3_9pm"]').val('OK');
    					  $('input[name="coarsescreens4_9pm"]').val('OK');
    					  $('input[name="coarsescreens5_9pm"]').val('OK');
    					  $('input[name="coarsescreens6_9pm"]').val('OK');
    					  $('input[name="coarsescreens7_9pm"]').val('OK');
    					  $('input[name="finescreens1_9pm"]').val('OK');
    					  $('input[name="finescreens2_9pm"]').val('OK');
    					  $('input[name="finescreens3_9pm"]').val('OK');
    					  $('input[name="finescreens4_9pm"]').val('OK');
    					  $('input[name="finescreens5_9pm"]').val('OK');
    					  $('input[name="finescreens6_9pm"]').val('OK');
    					  $('input[name="showerpumps1_9pm"]').val('OK');
    					  $('input[name="showerpumps2_9pm"]').val('OK');
    					  $('input[name="deckerfeedpump1_9pm"]').val('OK');
    					  $('input[name="deckerfeedpump2_9pm"]').val('OK');
    					  $('input[name="daf1_9pm"]').val('OK');
    					  $('input[name="daf2_9pm"]').val('OK');
    					  $('input[name="rollupprocessfloorwashuphoses1_9pm"]').val('OK');
		    	  }
    		   if(idClicked==='button1am'&& v6!='button5am'&&document.getElementById("cmt1am").checked==false){ 
		    		 
    		      
    		     		 $('input[name="hdcleaner1_1am"]').val('OK');
    					  $('input[name="hdcleaner2_1am"]').val('OK');
    					  $('input[name="hdcleaner3_1am"]').val('OK');
    					  $('input[name="hdcleaner4_1am"]').val('OK');
    					  $('input[name="hdcleanerb_1am"]').val('OK');
    					//  $('input[name="drumscreen1_1am"]').val('OK');
    					  $('input[name="drumscreen2_1am"]').val('OK');
    					  $('input[name="drumscreen3_1am"]').val('OK');
    					  $('input[name="coarsescreens1_1am"]').val('OK');
    					  $('input[name="coarsescreens2_1am"]').val('OK');
    					  $('input[name="coarsescreens3_1am"]').val('OK');
    					  $('input[name="coarsescreens4_1am"]').val('OK');
    					  $('input[name="coarsescreens5_1am"]').val('OK');
    					  $('input[name="coarsescreens6_1am"]').val('OK');
    					  $('input[name="coarsescreens7_1am"]').val('OK');
    					  $('input[name="finescreens1_1am"]').val('OK');
    					  $('input[name="finescreens2_1am"]').val('OK');
    					  $('input[name="finescreens3_1am"]').val('OK');
    					  $('input[name="finescreens4_1am"]').val('OK');
    					  $('input[name="finescreens5_1am"]').val('OK');
    					  $('input[name="finescreens6_1am"]').val('OK');
    					  $('input[name="showerpumps1_1am"]').val('OK');
    					  $('input[name="showerpumps2_1am"]').val('OK');
    					  $('input[name="deckerfeedpump1_1am"]').val('OK');
    					  $('input[name="deckerfeedpump2_1am"]').val('OK');
    					  $('input[name="daf1_1am"]').val('OK');
    					  $('input[name="daf2_1am"]').val('OK');
    					  $('input[name="rollupprocessfloorwashuphoses1_1am"]').val('OK');
    		     	
		    	  }
    		        if(idClicked==='button5am' &&document.getElementById("cmt5am").checked==false){
    		     		 $('input[name="hdcleaner1_5am"]').val('OK');
    					  $('input[name="hdcleaner2_5am"]').val('OK');
    					  $('input[name="hdcleaner3_5am"]').val('OK');
    					  $('input[name="hdcleaner4_5am"]').val('OK');
    					  $('input[name="hdcleanerb_5am"]').val('OK');
    					  $('input[name="drumscreen1_5am"]').val('OK');
    					  $('input[name="drumscreen2_5am"]').val('OK');
    					  $('input[name="drumscreen3_5am"]').val('OK');
    					  $('input[name="coarsescreens1_5am"]').val('OK');
    					  $('input[name="coarsescreens2_5am"]').val('OK');
    					  $('input[name="coarsescreens3_5am"]').val('OK');
    					  $('input[name="coarsescreens4_5am"]').val('OK');
    					  $('input[name="coarsescreens5_5am"]').val('OK');
    					  $('input[name="coarsescreens6_5am"]').val('OK');
    					  $('input[name="coarsescreens7_5am"]').val('OK');
    					  $('input[name="finescreens1_5am"]').val('OK');
    					  $('input[name="finescreens2_5am"]').val('OK');
    					  $('input[name="finescreens3_5am"]').val('OK');
    					  $('input[name="finescreens4_5am"]').val('OK');
    					  $('input[name="finescreens5_5am"]').val('OK');
    					  $('input[name="finescreens6_5am"]').val('OK');
    					  $('input[name="showerpumps1_5am"]').val('OK');
    					  $('input[name="showerpumps2_5am"]').val('OK');
    					  $('input[name="deckerfeedpump1_5am"]').val('OK');
    					  $('input[name="deckerfeedpump2_5am"]').val('OK');
    					  $('input[name="daf1_5am"]').val('OK');
    					  $('input[name="daf2_5am"]').val('OK');
    					  $('input[name="rollupprocessfloorwashuphoses1_5am"]').val('OK');
    		      	}
    		        if(checkBox.checked!=true&&idClicked==="ok"){
   		        	 $('input[name="hdcleaner1_9am"]').val('');
   					  $('input[name="hdcleaner2_9am"]').val('');
   					  $('input[name="hdcleaner3_9am"]').val('');
   					  $('input[name="hdcleaner4_9am"]').val('');
   					  $('input[name="hdcleanerb_9am"]').val('');
   					  $('input[name="drumscreen1_9am"]').val('');
   					  $('input[name="drumscreen2_9am"]').val('');
   					  $('input[name="drumscreen3_9am"]').val('');
   					  $('input[name="coarsescreens1_9am"]').val('');
   					  $('input[name="coarsescreens2_9am"]').val('');
   					  $('input[name="coarsescreens3_9am"]').val('');
   					  $('input[name="coarsescreens4_9am"]').val('');
   					  $('input[name="coarsescreens5_9am"]').val('');
   					  $('input[name="coarsescreens6_9am"]').val('');
   					  $('input[name="coarsescreens7_9am"]').val('');
   					  $('input[name="finescreens1_9am"]').val('');
   					  $('input[name="finescreens2_9am"]').val('');
   					  $('input[name="finescreens3_9am"]').val('');
   					  $('input[name="finescreens4_9am"]').val('');
   					  $('input[name="finescreens5_9am"]').val('');
   					  $('input[name="finescreens6_9am"]').val('');
   					  $('input[name="showerpumps1_9am"]').val('');
   					  $('input[name="showerpumps2_9am"]').val('');
   					  $('input[name="deckerfeedpump1_9am"]').val('');
   					  $('input[name="deckerfeedpump2_9am"]').val('');
   					  $('input[name="daf1_9am"]').val('');
   					  $('input[name="daf2_9am"]').val('');
   					  $('input[name="rollupprocessfloorwashuphoses1_9am"]').val('');
   		         } 
    		     	 if(checkBox2.checked!=true&&idClicked==="button1pm"){
    		        	 $('input[name="hdcleaner1_1pm"]').val('');
    					  $('input[name="hdcleaner2_1pm"]').val('');
    					  $('input[name="hdcleaner3_1pm"]').val('');
    					  $('input[name="hdcleaner4_1pm"]').val('');
    					  $('input[name="hdcleanerb_1pm"]').val('');
    					  $('input[name="drumscreen1_1pm"]').val('');
    					  $('input[name="drumscreen2_1pm"]').val('');
    					  $('input[name="drumscreen3_1pm"]').val('');
    					  $('input[name="coarsescreens1_1pm"]').val('');
    					  $('input[name="coarsescreens2_1pm"]').val('');
    					  $('input[name="coarsescreens3_1pm"]').val('');
    					  $('input[name="coarsescreens4_1pm"]').val('');
    					  $('input[name="coarsescreens5_1pm"]').val('');
    					  $('input[name="coarsescreens6_1pm"]').val('');
    					  $('input[name="coarsescreens7_1pm"]').val('');
    					  $('input[name="finescreens1_1pm"]').val('');
    					  $('input[name="finescreens2_1pm"]').val('');
    					  $('input[name="finescreens3_1pm"]').val('');
    					  $('input[name="finescreens4_1pm"]').val('');
    					  $('input[name="finescreens5_1pm"]').val('');
    					  $('input[name="finescreens6_1pm"]').val('');
    					  $('input[name="showerpumps1_1pm"]').val('');
    					  $('input[name="showerpumps2_1pm"]').val('');
    					  $('input[name="deckerfeedpump1_1pm"]').val('');
    					  $('input[name="deckerfeedpump2_1pm"]').val('');
    					  $('input[name="daf1_1pm"]').val('');
    					  $('input[name="daf2_1pm"]').val('');
    					  $('input[name="rollupprocessfloorwashuphoses1_1pm"]').val('');
    		      	}if(checkBox3.checked!=true&&idClicked==="button5pm"){
    		      		 $('input[name="hdcleaner1_5pm"]').val('');
    					  $('input[name="hdcleaner2_5pm"]').val('');
    					  $('input[name="hdcleaner3_5pm"]').val('');
    					  $('input[name="hdcleaner4_5pm"]').val('');
    					  $('input[name="hdcleanerb_5pm"]').val('');
    					  $('input[name="drumscreen1_5pm"]').val('');
    					  $('input[name="drumscreen2_5pm"]').val('');
    					  $('input[name="drumscreen3_5pm"]').val('');
    					  $('input[name="coarsescreens1_5pm"]').val('');
    					  $('input[name="coarsescreens2_5pm"]').val('');
    					  $('input[name="coarsescreens3_5pm"]').val('');
    					  $('input[name="coarsescreens4_5pm"]').val('');
    					  $('input[name="coarsescreens5_5pm"]').val('');
    					  $('input[name="coarsescreens6_5pm"]').val('');
    					  $('input[name="coarsescreens7_5pm"]').val('');
    					  $('input[name="finescreens1_5pm"]').val('');
    					  $('input[name="finescreens2_5pm"]').val('');
    					  $('input[name="finescreens3_5pm"]').val('');
    					  $('input[name="finescreens4_5pm"]').val('');
    					  $('input[name="finescreens5_5pm"]').val('');
    					  $('input[name="finescreens6_5pm"]').val('');
    					  $('input[name="showerpumps1_5pm"]').val('');
    					  $('input[name="showerpumps2_5pm"]').val('');
    					  $('input[name="deckerfeedpump1_5pm"]').val('');
    					  $('input[name="deckerfeedpump2_5pm"]').val('');
    					  $('input[name="daf1_5pm"]').val('');
    					  $('input[name="daf2_5pm"]').val('');
    					  $('input[name="rollupprocessfloorwashuphoses1_5pm"]').val('');
    		      	} if(checkBox4.checked!=true&&idClicked==="button9pm"){
    		     		 $('input[name="hdcleaner1_9pm"]').val('');
    					  $('input[name="hdcleaner2_9pm"]').val('');
    					  $('input[name="hdcleaner3_9pm"]').val('');
    					  $('input[name="hdcleaner4_9pm"]').val('');
    					  $('input[name="hdcleanerb_9pm"]').val('');
    					  $('input[name="drumscreen1_9pm"]').val('');
    					  $('input[name="drumscreen2_9pm"]').val('');
    					  $('input[name="drumscreen3_9pm"]').val('');
    					  $('input[name="coarsescreens1_9pm"]').val('');
    					  $('input[name="coarsescreens2_9pm"]').val('');
    					  $('input[name="coarsescreens3_9pm"]').val('');
    					  $('input[name="coarsescreens4_9pm"]').val('');
    					  $('input[name="coarsescreens5_9pm"]').val('');
    					  $('input[name="coarsescreens6_9pm"]').val('');
    					  $('input[name="coarsescreens7_9pm"]').val('');
    					  $('input[name="finescreens1_9pm"]').val('');
    					  $('input[name="finescreens2_9pm"]').val('');
    					  $('input[name="finescreens3_9pm"]').val('');
    					  $('input[name="finescreens4_9pm"]').val('');
    					  $('input[name="finescreens5_9pm"]').val('');
    					  $('input[name="finescreens6_9pm"]').val('');
    					  $('input[name="showerpumps1_9pm"]').val('');
    					  $('input[name="showerpumps2_9pm"]').val('');
    					  $('input[name="deckerfeedpump1_9pm"]').val('');
    					  $('input[name="deckerfeedpump2_9pm"]').val('');
    					  $('input[name="daf1_9pm"]').val('');
    					  $('input[name="daf2_9pm"]').val('');
    					  $('input[name="rollupprocessfloorwashuphoses1_9pm"]').val('');
    		     	} if(checkBox5.checked!=true&&idClicked==="button1am"){
    		     		 $('input[name="hdcleaner1_1am"]').val('');
    					  $('input[name="hdcleaner2_1am"]').val('');
    					  $('input[name="hdcleaner3_1am"]').val('');
    					  $('input[name="hdcleaner4_1am"]').val('');
    					  $('input[name="hdcleanerb_1am"]').val('');
    					  $('input[name="drumscreen1_1am"]').val('');
    					  $('input[name="drumscreen2_1am"]').val('');
    					  $('input[name="drumscreen3_1am"]').val('');
    					  $('input[name="coarsescreens1_1am"]').val('');
    					  $('input[name="coarsescreens2_1am"]').val('');
    					  $('input[name="coarsescreens3_1am"]').val('');
    					  $('input[name="coarsescreens4_1am"]').val('');
    					  $('input[name="coarsescreens5_1am"]').val('');
    					  $('input[name="coarsescreens6_1am"]').val('');
    					  $('input[name="coarsescreens7_1am"]').val('');
    					  $('input[name="finescreens1_1am"]').val('');
    					  $('input[name="finescreens2_1am"]').val('');
    					  $('input[name="finescreens3_1am"]').val('');
    					  $('input[name="finescreens4_1am"]').val('');
    					  $('input[name="finescreens5_1am"]').val('');
    					  $('input[name="finescreens6_1am"]').val('');
    					  $('input[name="showerpumps1_1am"]').val('');
    					  $('input[name="showerpumps2_1am"]').val('');
    					  $('input[name="deckerfeedpump1_1am"]').val('');
    					  $('input[name="deckerfeedpump2_1am"]').val('');
    					  $('input[name="daf1_1am"]').val('');
    					  $('input[name="daf2_1am"]').val('');
    					  $('input[name="rollupprocessfloorwashuphoses1_1am"]').val('');
    		     	}if(checkBox6.checked!=true&&idClicked==="button5am"){
    		     		 $('input[name="hdcleaner1_5am"]').val('');
    					  $('input[name="hdcleaner2_5am"]').val('');
    					  $('input[name="hdcleaner3_5am"]').val('');
    					  $('input[name="hdcleaner4_5am"]').val('');
    					  $('input[name="hdcleanerb_5am"]').val('');
    					  $('input[name="drumscreen1_5am"]').val('');
    					  $('input[name="drumscreen2_5am"]').val('');
    					  $('input[name="drumscreen3_5am"]').val('');
    					  $('input[name="coarsescreens1_5am"]').val('');
    					  $('input[name="coarsescreens2_5am"]').val('');
    					  $('input[name="coarsescreens3_5am"]').val('');
    					  $('input[name="coarsescreens4_5am"]').val('');
    					  $('input[name="coarsescreens5_5am"]').val('');
    					  $('input[name="coarsescreens6_5am"]').val('');
    					  $('input[name="coarsescreens7_5am"]').val('');
    					  $('input[name="finescreens1_5am"]').val('');
    					  $('input[name="finescreens2_5am"]').val('');
    					  $('input[name="finescreens3_5am"]').val('');
    					  $('input[name="finescreens4_5am"]').val('');
    					  $('input[name="finescreens5_5am"]').val('');
    					  $('input[name="finescreens6_5am"]').val('');
    					  $('input[name="showerpumps1_5am"]').val('');
    					  $('input[name="showerpumps2_5am"]').val('');
    					  $('input[name="deckerfeedpump1_5am"]').val('');
    					  $('input[name="deckerfeedpump2_5am"]').val('');
    					  $('input[name="daf1_5am"]').val('');
    					  $('input[name="daf2_5am"]').val('');
    					  $('input[name="rollupprocessfloorwashuphoses1_5am"]').val('');
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
