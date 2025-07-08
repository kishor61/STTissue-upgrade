<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<!-- Required CSS files -->
<link rel="stylesheet" href="/STTissueQR/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="/STTissueQR/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<link rel="stylesheet" href="/STTissueQR/plugins/icheck/icheck-bootstrap.min.css">
<link rel="stylesheet" href="/STTissueQR/dist/css/layout.css">
<link href="/STTissueQR/dist/css/stylesheet.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/2.10.1/styles/overlayscrollbars.min.css">
<link rel="stylesheet" href="/STTissueQR/plugins/daterangepicker/daterangepicker.css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<link href="/STTissueQR/dist/css/HeaderNew.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href='<spring:url value="dist/img/favicon.ico"/>' />

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
		 
			<spring:url value="/utilityOperatorpm5/save" var="viewURL"/>
		 		
			
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
				<span class="message">${message}</span>
			 </c:if>
 
 <br/> <br/>  <br/>

 <c:if test="${data.position == 'utilityoperator'}">
   <div id="printDiv">
		 <center>
		 
		 <c:if test="${data.shift == 'day'}">
		   <h1 style="font-size: 21px;color: #518f3e;">Day Shift Form</h1>
		 </c:if> 
		 <c:if test="${data.shift == 'night'}">
		   <h1 style="font-size: 21px;color: #518f3e;">Night Shift Form</h1>
		 </c:if>  
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">Operator Basic Care CheckList</h1>
		 		</div>
		 		<div style="float: right;}">
		 			<span><b style="font-size: 15px;">Utility Operator : </b>${data.operatorName}</span>
		 		</div>
		 		<div style="float: right;    margin-right: -130px;">
		 		 <br/>
		 			<span><b style="font-size: 15px;">Date:</b>${data.edate}</span> &nbsp;&nbsp;&nbsp;
		 			<span><b style="font-size: 15px;">Shift:</b>${data.shift}</span> 
		 		</div>
		 	</div>	
		 	
		 	
		 			<h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						  	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </h3>
				 <table border="1" class="tg" style="background-color: white;width: 1000px;" id="tbbl">
						
						
						<tr>
						    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
						    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
						   
						</tr> 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Clamp Truck</h2></td>
						     
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Check list completed</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.checklistcompleted == 'true' ? 'checked' : ''} name="checklistcompleted"/> Yes 
						   		 <input type="radio" value="false" name="checklistcompleted" ${data.checklistcompleted == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.checklistcompletedDesc}" name="checklistcompletedDesc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						    
						  </tr>
						  
						  
						 <tr>
						    <td class="tg-yw4l" >Clamps clean  of burrs</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.clampscleanofburrs == 'true' ? 'checked' : ''} name="clampscleanofburrs"/> Yes 
						   		 <input type="radio" value="false" name="clampscleanofburrs" ${data.clampscleanofburrs == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.clampscleanofburrsDesc}" name="clampscleanofburrsDesc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Any visible issue</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.anyvisibleissue == 'true' ? 'checked' : ''} name="anyvisibleissue"/> Yes 
						     <input type="radio" value="false" ${data.anyvisibleissue == 'false' ? 'checked' : ''} name="anyvisibleissue"/>No   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" class="input" value="${data.anyvisibleissueDesc}" name="anyvisibleissueDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    
						  </tr>
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" >motorized hand truck</td>
						    <td class="tg-yw4l" style="text-align: center;">
						     <input type="radio" value="true" ${data.motorizedhandtruck == 'true' ? 'checked' : ''} name="motorizedhandtruck"/>Yes 
						     <input type="radio" value="false"  ${data.motorizedhandtruck == 'false' ? 'checked' : ''} name="motorizedhandtruck"/>No    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						     <input type="text" value="${data.motorizedhandtruckDesc}"  class="input"name="motorizedhandtruckDesc" placeholder="Remarks" style="margin-left: 66px;"/> 
						    </td>
						    
						  </tr>
						  
						    <tr>
						    <td class="tg-yw4l" >Battery changes and cable intact</td>
						       
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.batterychangesandcableintact == 'true' ? 'checked' : ''} name="batterychangesandcableintact"/>Yes 
						    <input type="radio" value="false"  ${data.batterychangesandcableintact == 'false' ? 'checked' : ''} name="batterychangesandcableintact"/>No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" value="${data.batterychangesandcableintactDesc}"  class="input"name="batterychangesandcableintactDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						     
						  </tr> 
						  --%>
						  <tr>
						    <td class="tg-yw4l"  >Caution light  operational</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<input type="radio" value="true" ${data.cautionlightoperational == 'true' ? 'checked' : ''} name="cautionlightoperational"/> Yes  
						    	<input type="radio" value="false" ${data.cautionlightoperational == 'false' ? 'checked' : ''} name="cautionlightoperational"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.cautionlightoperationalDesc}" class="input" name="cautionlightoperationalDesc" placeholder="Remarks" style="margin-left: 58px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >Control Arm operating properly</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.controlarmoperatingproperly == 'true' ? 'checked' : ''} name="controlarmoperatingproperly"/> Yes
						    	<input type="radio" value="false" ${data.controlarmoperatingproperly == 'false' ? 'checked' : ''} name="controlarmoperatingproperly"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.controlarmoperatingproperlyDesc}" class="input" name="controlarmoperatingproperlyDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l">Any movement issue</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.anymovementissue == 'true' ? 'checked' : ''} name="anymovementissue"/> Yes
						    	<input type="radio" value="false" ${data.anymovementissue == 'false' ? 'checked' : ''} name="anymovementissue"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.anymovementissueDesc}"  class="input" name="anymovementissueDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Truck  blow down</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.handtruckblowdown == 'true' ? 'checked' : ''} name="handtruckblowdown"/> Yes
						    	<input type="radio" value="false" ${data.handtruckblowdown == 'false' ? 'checked' : ''} name="handtruckblowdown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.handtruckblowdownDesc}" class="input" name="handtruckblowdownDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Lifting  properly</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.liftingproperly == 'true' ? 'checked' : ''} name="liftingproperly"/> Yes
						    	<input type="radio" value="false" ${data.liftingproperly == 'false' ? 'checked' : ''} name="liftingproperly"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.liftingproperlyDesc}" class="input" name="liftingproperlyDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  <%-- 
						   <tr>
						    <td class="tg-yw4l"  >Both fold  out  wings  open or closed</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.bothfoldoutwingsopenorclosed == 'true' ? 'checked' : ''} name="bothfoldoutwingsopenorclosed"/> Yes
						    	<input type="radio" value="false" ${data.bothfoldoutwingsopenorclosed == 'false' ? 'checked' : ''} name="bothfoldoutwingsopenorclosed"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.bothfoldoutwingsopenorclosedDesc}" class="input" name="bothfoldoutwingsopenorclosedDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Both are to be opened and closed at the same time</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.botharetobeopenedandclosedatthesametime == 'true' ? 'checked' : ''} name="botharetobeopenedandclosedatthesametime"/> Yes
						   <input type="radio" value="false" ${data.botharetobeopenedandclosedatthesametime == 'false' ? 'checked' : ''} name="botharetobeopenedandclosedatthesametime"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.botharetobeopenedandclosedatthesametimeDesc}" class="input" name="botharetobeopenedandclosedatthesametimeDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>						     
						  </tr>
						   --%>
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Trailer dock</h2></td>
						   
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >All locks operational     </td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.alllocksoperational == 'true' ? 'checked' : ''} name="alllocksoperational"/> Yes
						   <input type="radio" value="false" ${data.alllocksoperational == 'false' ? 'checked' : ''} name="alllocksoperational"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.alllocksoperationalDesc}" class="input" name="alllocksoperationalDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>						     
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >All light intact  and working</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.alllightintactandworking == 'true' ? 'checked' : ''} name="alllightintactandworking"/> Yes
						   <input type="radio" value="false" ${data.alllightintactandworking == 'false' ? 'checked' : ''} name="alllightintactandworking"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.alllightintactandworkingDesc}" class="input" name="alllightintactandworkingDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Glad hand  locks being used</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.gladhandlocksbeingused == 'true' ? 'checked' : ''} name="gladhandlocksbeingused"/> Yes
						   <input type="radio" value="false" ${data.gladhandlocksbeingused == 'false' ? 'checked' : ''} name="gladhandlocksbeingused"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.gladhandlocksbeingusedDesc}" class="input" name="gladhandlocksbeingusedDesc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
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
			
 	</c:if>			
	  </form>		
	  
	  
	  
	  
	   
	  

		</div>


	</div>

</body>
</html>
