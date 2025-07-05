<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="./common.jsp"></jsp:include>
<spring:url value="/operatorCareCheckList/checkObcc" var="checkURL" />
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<script type="text/javascript">
$(function(){
	$('input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true,
	    maxDate:-1
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
						location.href="./../operatorCareCheckList/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'backtender')
					{
						location.href="./../backtender/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'stockoperator')
					{
						location.href="./../stockoperator/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'machinetender')
					{
						location.href="./../machineTend/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'utilityoperator')
					{
						location.href="./../UtilityOperator/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'R1')
					{
						location.href="./../R1Operator/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
						
					
				}else
				{
					var entry=confirm("Entry Already Available Do you Want to Edit  Click OK  Cencle it");
					if(entry==true){
						if(position == 'R2')
						{
							location.href="./../operatorCareCheckList/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'backtender')
						{
							location.href="./../backtender/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'stockoperator')
						{
							location.href="./../stockoperator/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'machinetender')
						{
							location.href="./../machineTend/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'utilityoperator')
						{
							location.href="./../UtilityOperator/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R1')
						{
							location.href="./../R1Operator/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
					}
					else
						{  alert("You click on cencle proceed further")}
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
<script type="text/javascript">
	$(function(){
		var wid = 1000;
		$('#printBtn').click(function(){
			$('#tbbl').width(wid)
			$("#checkpoint").css( { marginLeft : "-284px"} );
			$('#div_show').show();
			$('#printDiv').printArea();
			$('#tbbl').width(1122)
			$("#checkpoint").css( { marginLeft : "-356px" } );
			$('#div_show').hide();
		});
	});
	
	function validateform()
	{
		$('#loadPage').show();
	}
	
</script>
</head>
<body>

<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
</div>

	<div class="container">

		<div class="block1">
			<jsp:include page="./header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
		 
		<c:if test="${data.position == 'stockoperator'}">	
			<spring:url value="/stockoperator/save" var="viewURL"/>
		</c:if>		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Basic Care CheckList PM6  <center>Back Date Entry Form</center></span>
				</div>
				<div class="table-selector">
					
				
					
					
			 <input type="hidden" name="id" value="${data.id}"> 
	
					<table style="margin: auto;">
						<tr>
							<td> Position:</td>
							 <td>
								 <select style="width: 100%;" name="position" id="operator">
								    <option value="-1">Select Operator</option>
								 	<option value="backtender" ${data.position == 'backtender' ? 'selected' : ''}>Back Tender</option>
								 	<option value="stockoperator" ${data.position == 'stockoperator' ? 'selected' : ''}>Stock Operator</option>
								 	<option value="machinetender" ${data.position == 'machinetender' ? 'selected' : ''}>Machine Tender</option>
								 	<option value="R1" ${data.position == 'R1' ? 'selected' : ''}>R1 </option>
								 	<option value="R2" ${data.position == 'R2' ? 'selected' : ''}>R2 </option>
								 	<option value="utilityoperator" ${data.position == 'utilityoperator' ? 'selected' : ''}>Utility Operator </option>
								 
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
								<button type="button" id="printBtn">Print</button>
								<a href="../operatorCareCheckList/checkObcc/back"><button  type="button" >Backdated Entry
								</button></a>
							</td>
	 					</tr>
					</table>
					 
				</div>
 			 <c:if test="${not empty message }">
				<span class="message">${message}</span>
			 </c:if>
 
 <br/> <br/>  <br/>

 <%-- <c:if test="${data.position == 'backtender'}"> --%>
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
		 			<span><b style="font-size: 15px;">Stock Operator : </b>${data.operatorName}</span>
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
						<c:if test="${data.shift == 'day'}"> 	
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>HD Storage chest</h2></td>
						     
						</tr> 
						 
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" > HD Storage chest Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hdStorageChestCol1 == 'true' ? 'checked' : ''} name="hdStorageChestCol1"/> Yes 
						   		 <input type="radio" value="false" name="hdStorageChestCol1" ${data.hdStorageChestCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hdStorageChestCol1Desc}" name="hdStorageChestCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >HD Storage chest Agitator Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hdStorageChestCol2Inbound}" placeholder="" name="hdStorageChestCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hdStorageChestCol2Outbound}" placeholder=" " name="hdStorageChestCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hdStorageChestCol2Desc}" name="hdStorageChestCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						<%--   <tr>
						    <td class="tg-yw4l" > De-ink stock supply pump #1</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hdStorageChestCol3 == 'true' ? 'checked' : ''} name="hdStorageChestCol3"/> Yes 
						   		 <input type="radio" value="false" name="hdStorageChestCol3" ${data.hdStorageChestCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hdStorageChestCol3Desc}" name="hdStorageChestCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   --%>
						  
						   <tr>
						    <td class="tg-yw4l" >De-ink stock supply pump #1 Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hdStorageChestCol4Inbound}" placeholder="" name="hdStorageChestCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hdStorageChestCol4Outbound}" placeholder=" " name="hdStorageChestCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hdStorageChestCol4Desc}" name="hdStorageChestCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						 <%--  <tr>
						    <td class="tg-yw4l" > De-ink stock supply pump #2</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hdStorageChestCol5 == 'true' ? 'checked' : ''} name="hdStorageChestCol5"/> Yes 
						   		 <input type="radio" value="false" name="hdStorageChestCol5" ${data.hdStorageChestCol5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hdStorageChestCol5Desc}" name="hdStorageChestCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  
						   <tr>
						    <td class="tg-yw4l" >De-ink stock supply pump #2 Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hdStorageChestCol6Inbound}" placeholder="" name="hdStorageChestCol6Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hdStorageChestCol6Outbound}" placeholder=" " name="hdStorageChestCol6Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hdStorageChestCol6Desc}" name="hdStorageChestCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" > De-ink pulp dilution pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hdStorageChestCol7 == 'true' ? 'checked' : ''} name="hdStorageChestCol7"/> Yes 
						   		 <input type="radio" value="false" name="hdStorageChestCol7" ${data.hdStorageChestCol7 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hdStorageChestCol7Desc}" name="hdStorageChestCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						   <tr>
						    <td class="tg-yw4l" >De-ink pulp dilution pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hdStorageChestCol8Inbound}" placeholder="" name="hdStorageChestCol8Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hdStorageChestCol8Outbound}" placeholder=" " name="hdStorageChestCol8Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hdStorageChestCol8Desc}" name="hdStorageChestCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Blend Chest</h2></td>
						     
						 </tr> 
						 
						 
						 <%--  <tr>
						    <td class="tg-yw4l" >Blend chest Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.blendChestCol1 == 'true' ? 'checked' : ''} name="blendChestCol1"/> Yes 
						   		 <input type="radio" value="false" name="blendChestCol1" ${data.blendChestCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.blendChestCol1Desc}" name="blendChestCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  --%>
						  <tr>
						    <td class="tg-yw4l" >Blend chest Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.blendChestCol2Inbound}" placeholder="" name="blendChestCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.blendChestCol2Outbound}" placeholder=" " name="blendChestCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.blendChestCol2Desc}" name="blendChestCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 <%-- 
						  <tr>
						    <td class="tg-yw4l" >Sweetner pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.blendChestCol3 == 'true' ? 'checked' : ''} name="blendChestCol3"/> Yes 
						   		 <input type="radio" value="false" name="blendChestCol3" ${data.blendChestCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.blendChestCol3Desc}" name="blendChestCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  --%>
						   <tr>
						    <td class="tg-yw4l" >Sweetner pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.blendChestCol4Inbound}" placeholder="" name="blendChestCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.blendChestCol4Outbound}" placeholder=" " name="blendChestCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.blendChestCol4Desc}" name="blendChestCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Sec Screen Feed tank</h2></td>
						     
						 </tr> 
						  
						 <%--  <tr>
						    <td class="tg-yw4l" >Secondary screen feed tank Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.seeScreenFeedTandCol1 == 'true' ? 'checked' : ''} name="seeScreenFeedTandCol1"/> Yes 
						   		 <input type="radio" value="false" name="seeScreenFeedTandCol1" ${data.seeScreenFeedTandCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.seeScreenFeedTandCol1Desc}" name="seeScreenFeedTandCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>
						 
						  <tr>
						    <td class="tg-yw4l" >Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.seeScreenFeedTandCol2Inbound}" placeholder="" name="seeScreenFeedTandCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.seeScreenFeedTandcol2Outbound}" placeholder=" " name="seeScreenFeedTandcol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.seeScreenFeedTandCol2Desc}" name="seeScreenFeedTandCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 <%-- 
						  <tr>
						    <td class="tg-yw4l" >Secondary screen feed Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.seeScreenFeedTandCol3 == 'true' ? 'checked' : ''} name="seeScreenFeedTandCol3"/> Yes 
						   		 <input type="radio" value="false" name="seeScreenFeedTandCol3" ${data.seeScreenFeedTandCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.seeScreenFeedTandCol3Desc}" name="seeScreenFeedTandCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  --%>
						   <tr>
						    <td class="tg-yw4l" >Secondary screen feed Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.seeScreenFeedTandCol4Inbound}" placeholder="" name="seeScreenFeedTandCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.seeScreenFeedTandcol4Outbound}" placeholder=" " name="seeScreenFeedTandcol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.seeScreenFeedTandCol4Desc}" name="seeScreenFeedTandCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Machine chest</h2></td>
						     
						 </tr> 
						 <%-- 
						 
						 <tr>
						    <td class="tg-yw4l" >Machine chest pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.machineChestCol1 == 'true' ? 'checked' : ''} name="machineChestCol1"/> Yes 
						   		 <input type="radio" value="false" name="machineChestCol1" ${data.machineChestCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.machineChestCol1Desc}" name="machineChestCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  --%>
						  <tr>
						    <td class="tg-yw4l" >Machine chest pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.machineChestCol2Inbound}" placeholder="" name="machineChestCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.machineChestCol2Outbound}" placeholder=" " name="machineChestCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.machineChestCol2Desc}" name="machineChestCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 <%--  <tr>
						    <td class="tg-yw4l" >Blend chest Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.machineChestCol3 == 'true' ? 'checked' : ''} name="machineChestCol3"/> Yes 
						   		 <input type="radio" value="false" name="machineChestCol3" ${data.machineChestCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.machineChestCol3Desc}" name="machineChestCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>
						 
						  <tr>
						    <td class="tg-yw4l" >Blend chest Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.machineChestCol4Inbound}" placeholder="" name="machineChestCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.machineChestCol4Outbound}" placeholder=" " name="machineChestCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.machineChestCol4Desc}" name="machineChestCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 <%-- 
						  <tr>
						    <td class="tg-yw4l" >Machine chest Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.machineChestCol5 == 'true' ? 'checked' : ''} name="machineChestCol5"/> Yes 
						   		 <input type="radio" value="false" name="machineChestCol5" ${data.machineChestCol5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.machineChestCol5Desc}" name="machineChestCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  --%>
						  <tr>
						    <td class="tg-yw4l" >Machine chest Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.machineChestCol6Inbound}" placeholder="" name="machineChestCol6Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.machineChestCol6Outbound}" placeholder=" " name="machineChestCol6Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.machineChestCol6Desc}" name="machineChestCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Cleaners</h2></td>
						     
						 </tr> 
						 <%-- 
						   <tr>
						    <td class="tg-yw4l" >Low density cleaner</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.cleannersCol1 == 'true' ? 'checked' : ''} name="cleannersCol1"/> Yes 
						   		 <input type="radio" value="false" name="cleannersCol1" ${data.cleannersCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.cleannersCol1Desc}" name="cleannersCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  --%>
						
						  <tr>
						    <td class="tg-yw4l" >Secondary selectifier screen</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.cleannersCol2 == 'true' ? 'checked' : ''} name="cleannersCol2"/> Yes 
						   		 <input type="radio" value="false" name="cleannersCol2" ${data.cleannersCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.cleannersCol2Desc}" name="cleannersCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >Secondary selectifier screen Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.cleannersCol3Inbound}" placeholder="" name="cleannersCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.cleannersCol3Outbound}" placeholder=" " name="cleannersCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.cleannersCol3Desc}" name="cleannersCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>De-ink stock chest</h2></td>
						     
						 </tr> 
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >De-ink stock Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.deLinkStockCol1 == 'true' ? 'checked' : ''} name="deLinkStockCol1"/> Yes 
						   		 <input type="radio" value="false" name="deLinkStockCol1" ${data.deLinkStockCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.deLinkStockCol1Desc}" name="deLinkStockCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l" >De-ink stock Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.deLinkStockCol2Inbound}" placeholder="" name="deLinkStockCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.deLinkStockCol2Outbound}" placeholder=" " name="deLinkStockCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.deLinkStockCol2Desc}" name="deLinkStockCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>White water pumps</h2></td>
						     
						   </tr> 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >White water Transfer Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterCol1 == 'true' ? 'checked' : ''} name="whiteWaterCol1"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterCol1" ${data.whiteWaterCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterCol1Desc}" name="whiteWaterCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						   <tr>
						    <td class="tg-yw4l" >White water Transfer Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterCol2Inbound}" placeholder="" name="whiteWaterCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterCol2Outbound}" placeholder=" " name="whiteWaterCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterCol2Desc}" name="whiteWaterCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Save all Shower Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterCol3 == 'true' ? 'checked' : ''} name="whiteWaterCol3"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterCol3" ${data.whiteWaterCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterCol3Desc}" name="whiteWaterCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Save all Shower Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterCol4Inbound}" placeholder="" name="whiteWaterCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterCol4Outbound}" placeholder=" " name="whiteWaterCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterCol4Desc}" name="whiteWaterCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 
						 <tr>
						    <td class="tg-yw4l" >Consistency Dilution pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterCol5 == 'true' ? 'checked' : ''} name="whiteWaterCol5"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterCol5" ${data.whiteWaterCol5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterCol5Desc}" name="whiteWaterCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >Consistency Dilution pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterCol6Inbound}" placeholder="" name="whiteWaterCol6Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterCol6Outbound}" placeholder=" " name="whiteWaterCol6Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterCol6Desc}" name="whiteWaterCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >River Water Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterCol7 == 'true' ? 'checked' : ''} name="whiteWaterCol7"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterCol7" ${data.whiteWaterCol7 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterCol7Desc}" name="whiteWaterCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						 <tr>
						    <td class="tg-yw4l" >River Water pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterCol8Inbound}" placeholder="" name="whiteWaterCol8Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterCol8Outbound}" placeholder=" " name="whiteWaterCol8Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterCol8Desc}" name="whiteWaterCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Couch Pit</h2></td>
						     
						   </tr> 
						 
						 
						 
						 <%--   <tr>
						    <td class="tg-yw4l" >Couch pit Drain</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.couchPitCol1 == 'true' ? 'checked' : ''} name="couchPitCol1"/> Yes 
						   		 <input type="radio" value="false" name="couchPitCol1" ${data.couchPitCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.couchPitCol1Desc}" name="couchPitCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>
						 
						 
						 
						   <tr>
						    <td class="tg-yw4l" >Couch pit Agitator West</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.couchPitCol2 == 'true' ? 'checked' : ''} name="couchPitCol2"/> Yes 
						   		 <input type="radio" value="false" name="couchPitCol2" ${data.couchPitCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.couchPitCol2Desc}" name="couchPitCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >Couch pit Agitator West Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchPitCol3Inbound}" placeholder="" name="couchPitCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchPitCol3Outbound}" placeholder=" " name="couchPitCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchPitCol3Desc}" name="couchPitCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						 
						 <tr>
						    <td class="tg-yw4l" >Couch pit Agitator East</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.couchPitCol4 == 'true' ? 'checked' : ''} name="couchPitCol4"/> Yes 
						   		 <input type="radio" value="false" name="couchPitCol4" ${data.couchPitCol4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.couchPitCol4Desc}" name="couchPitCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Couch pit Agitator East Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchPitCol5Inbound}" placeholder="" name="couchPitCol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchPitCol5Outbound}" placeholder=" " name="couchPitCol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchPitCol5Desc}" name="couchPitCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						 <%--  <tr>
						    <td class="tg-yw4l" >Couch pit trim Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.couchPitCol6 == 'true' ? 'checked' : ''} name="couchPitCol6"/> Yes 
						   		 <input type="radio" value="false" name="couchPitCol6" ${data.couchPitCol6 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.couchPitCol6Desc}" name="couchPitCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l" >Couch pit trim Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchPitCol7Inbound}" placeholder="" name="couchPitCol7Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchPitCol7Outbound}" placeholder=" " name="couchPitCol7Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchPitCol7Desc}" name="couchPitCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						  <tr>
						    <td class="tg-yw4l" >Couch pit trim Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchPitCol8Inbound}" placeholder="" name="couchPitCol8Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchPitCol8Outbound}" placeholder=" " name="couchPitCol8Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchPitCol8Desc}" name="couchPitCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >Couch Pit Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.couchPitCol9 == 'true' ? 'checked' : ''} name="couchPitCol9"/> Yes 
						   		 <input type="radio" value="false" name="couchPitCol9" ${data.couchPitCol9 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.couchPitCol9Desc}" name="couchPitCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  --%>
						 
						  <tr>
						    <td class="tg-yw4l" >Couch Pit Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchPitCol10Inbound}" placeholder="" name="couchPitCol10Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchPitCol10Outbound}" placeholder=" " name="couchPitCol10Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchPitCol10Desc}" name="couchPitCol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" >Couch Pit Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchPitCol11Inbound}" placeholder="" name="couchPitCol11Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchPitCol11Outbound}" placeholder=" " name="couchPitCol11Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchPitCol11Desc}" name="couchPitCol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Yankee Pulper</h2></td>
						     
						   </tr> 
						   
						   
						   
						   
						<%--  <tr>
						    <td class="tg-yw4l" >Yankee Pulper Overflow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePulperCol1 == 'true' ? 'checked' : ''} name="yankeePulperCol1"/> Yes 
						   		 <input type="radio" value="false" name="yankeePulperCol1" ${data.yankeePulperCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePulperCol1Desc}" name="yankeePulperCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>  
						  <td class="tg-yw4l" >Yankee Pulper Drain</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePulperCol1Drain == 'true' ? 'checked' : ''} name="yankeePulperCol1Drain"/> Open 
						   		 <input type="radio" value="false" name="yankeePulperCol1Drain" ${data.yankeePulperCol1Drain == 'false' ? 'checked' : ''}/> Close  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePulperCol1DrainDesc}" name="yankeePulperCol1DrainDesc" placeholder="Remarks" style="float: right;"/>
						    </td>
						   
						 
						  </tr>
						   
						   <tr>
						    <td class="tg-yw4l" >Yankee Pulper East Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePulperCol2 == 'true' ? 'checked' : ''} name="yankeePulperCol2"/> Yes 
						   		 <input type="radio" value="false" name="yankeePulperCol2" ${data.yankeePulperCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePulperCol2Desc}" name="yankeePulperCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>
						   
						   <tr>
						    <td class="tg-yw4l" >Yankee Pulper East Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePulperCol3Inbound}" placeholder="" name="yankeePulperCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePulperCol3Outbound}" placeholder=" " name="yankeePulperCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePulperCol3Desc}" name="yankeePulperCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						   
						   
						   <%--  <tr>
						    <td class="tg-yw4l" >Yankee Pulper West Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePulperCol4 == 'true' ? 'checked' : ''} name="yankeePulperCol4"/> Yes 
						   		 <input type="radio" value="false" name="yankeePulperCol4" ${data.yankeePulperCol4 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePulperCol4Desc}" name="yankeePulperCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>
						   
						   
						<tr>
						    <td class="tg-yw4l" >Yankee Pulper West Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePulperCol5Inbound}" placeholder="" name="yankeePulperCol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePulperCol5Outbound}" placeholder=" " name="yankeePulperCol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePulperCol5Desc}" name="yankeePulperCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>     
						 <%--   
						   
						  <tr>
						    <td class="tg-yw4l" >Yankee pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePulperCol6 == 'true' ? 'checked' : ''} name="yankeePulperCol6"/> Yes 
						   		 <input type="radio" value="false" name="yankeePulperCol6" ${data.yankeePulperCol6 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePulperCol6Desc}" name="yankeePulperCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						   
						    --%>
						   
						    
						<tr>
						    <td class="tg-yw4l" >Yankee pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePulperCol7Inbound}" placeholder="" name="yankeePulperCol7Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePulperCol7Outbound}" placeholder=" " name="yankeePulperCol7Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePulperCol7Desc}" name="yankeePulperCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>       
						   
						 <%--   
						   
						  <tr>
						    <td class="tg-yw4l" >Yankee trim pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePulperCol8 == 'true' ? 'checked' : ''} name="yankeePulperCol8"/> Yes 
						   		 <input type="radio" value="false" name="yankeePulperCol8" ${data.yankeePulperCol8 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePulperCol8Desc}" name="yankeePulperCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						   
						   
						   
						 <tr>
						    <td class="tg-yw4l" >Yankee trim pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePulperCol9Inbound}" placeholder="" name="yankeePulperCol9Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePulperCol9Outbound}" placeholder=" " name="yankeePulperCol9Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePulperCol9Desc}" name="yankeePulperCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						   --%>
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);height: 16px;"><h2></h2></td>
						     
				    	</tr> 
				    	
				    	  
					  
						 </c:if>
						 
						 <c:if test="${data.shift == 'night'}"> 	  	
						   	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Broke Deflaker</h2></td>
						   
						  </tr>
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Broke Deflaker</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.brokeDeflakerCol1 == 'true' ? 'checked' : ''} name="brokeDeflakerCol1"/> Yes 
						   		 <input type="radio" value="false" name="brokeDeflakerCol1" ${data.brokeDeflakerCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.brokeDeflakerCol1Desc}" name="brokeDeflakerCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Deflaker Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.brokeDeflakerCol2Inbound}" placeholder="" name="brokeDeflakerCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.brokeDeflakerCol2Outbound}" placeholder=" " name="brokeDeflakerCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.brokeDeflakerCol2Desc}" name="brokeDeflakerCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						  
						   <tr>
						    <td class="tg-yw4l" >Sealing water</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.brokeDeflakerCol3 == 'true' ? 'checked' : ''} name="brokeDeflakerCol3"/> Yes 
						   		 <input type="radio" value="false" name="brokeDeflakerCol3" ${data.brokeDeflakerCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.brokeDeflakerCol3Desc}" name="brokeDeflakerCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						     	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Refining system</h2></td>
						   
						  </tr>
						  
						 <tr>
						    <td class="tg-yw4l" >Refiner #</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.refiningSystemCol1}" placeholder="" name="refiningSystemCol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.refiningSystemCol1Desc}" name="refiningSystemCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  <%--    
						   <tr>
						    <td class="tg-yw4l" >Refiner # Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.refiningSystemCol2 == 'true' ? 'checked' : ''} name="refiningSystemCol2"/> Yes 
						   		 <input type="radio" value="false" name="refiningSystemCol2" ${data.refiningSystemCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.refiningSystemCol2Desc}" name="refiningSystemCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						 <tr>
						    <td class="tg-yw4l" >Refiner #  Load/unload Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.refiningSystemCol3Inbound}" placeholder="" name="refiningSystemCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.refiningSystemCol3Outbound}" placeholder=" " name="refiningSystemCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.refiningSystemCol3Desc}" name="refiningSystemCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						  --%>
						  <tr>
						    <td class="tg-yw4l" >Oil Level</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.refiningSystemCol4}" placeholder="" name="refiningSystemCol4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.refiningSystemCol4Desc}" name="refiningSystemCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>   
						 
						 
						   <tr>
						    <td class="tg-yw4l" >Sealing water</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.refiningSystemCol5}" placeholder="" name="refiningSystemCol5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.refiningSystemCol5Desc}" name="refiningSystemCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>   
						 <%-- 
						   
						 <tr>
						    <td class="tg-yw4l" >Refiner #</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.refiningSystemCol6}" placeholder="" name="refiningSystemCol6" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.refiningSystemCol6Desc}" name="refiningSystemCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						  
						  
						  
						 <tr>
						    <td class="tg-yw4l" >Refiner # Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.refiningSystemCol7 == 'true' ? 'checked' : ''} name="refiningSystemCol7"/> Yes 
						   		 <input type="radio" value="false" name="refiningSystemCol7" ${data.refiningSystemCol7 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.refiningSystemCol7Desc}" name="refiningSystemCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Refiner #  Load/unload Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.refiningSystemCol8Inbound}" placeholder="" name="refiningSystemCol8Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.refiningSystemCol8Outbound}" placeholder=" " name="refiningSystemCol8Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.refiningSystemCol8Desc}" name="refiningSystemCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						  
						    <tr>
						    <td class="tg-yw4l" >Oil Level</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.refiningSystemCol9}" placeholder="" name="refiningSystemCol9" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.refiningSystemCol9Desc}" name="refiningSystemCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>   
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Sealing water</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.refiningSystemCol10}" placeholder="" name="refiningSystemCol10" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.refiningSystemCol10Desc}" name="refiningSystemCol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>   
						  
						   --%>
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>White water pumps</h2></td>
						   
						  </tr>
						  
						 <%--  
						  <tr>
						    <td class="tg-yw4l" >White water Transfer Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterPumpCol1 == 'true' ? 'checked' : ''} name="whiteWaterPumpCol1"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterPumpCol1" ${data.whiteWaterPumpCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterPumpCol1Desc}" name="whiteWaterPumpCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						   --%>
						   <tr>
						    <td class="tg-yw4l" >White water Transfer Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterPumpCol2Inbound}" placeholder="" name="whiteWaterPumpCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterPumpCol2Outbound}" placeholder=" " name="whiteWaterPumpCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterPumpCol2Desc}" name="whiteWaterPumpCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >Save all Shower Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterPumpCol3 == 'true' ? 'checked' : ''} name="whiteWaterPumpCol3"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterPumpCol3" ${data.whiteWaterPumpCol3 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterPumpCol3Desc}" name="whiteWaterPumpCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>
						 <tr>
						    <td class="tg-yw4l" >Save all Shower Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterPumpCol4Inbound}" placeholder="" name="whiteWaterPumpCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterPumpCol4Outbound}" placeholder=" " name="whiteWaterPumpCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterPumpCol4Desc}" name="whiteWaterPumpCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 <%--  
						  <tr>
						    <td class="tg-yw4l" >Consistency Dilution pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.whiteWaterPumpCol5 == 'true' ? 'checked' : ''} name="whiteWaterPumpCol5"/> Yes 
						   		 <input type="radio" value="false" name="whiteWaterPumpCol5" ${data.whiteWaterPumpCol5 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.whiteWaterPumpCol5Desc}" name="whiteWaterPumpCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  --%>
						   <tr>
						    <td class="tg-yw4l" >Consistency Dilution pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whiteWaterPumpCol6Inbound}" placeholder="" name="whiteWaterPumpCol6Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whiteWaterPumpCol6Outbound}" placeholder=" " name="whiteWaterPumpCol6Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whiteWaterPumpCol6Desc}" name="whiteWaterPumpCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 <%--  
						  
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Silo</h2></td>
						   
						  </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Silo level</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.silloCol1}" placeholder="" name="silloCol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.silloCol1Desc}" name="silloCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    
						  
						   <tr>
						    <td class="tg-yw4l" >Drain</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.silloCol2 == 'true' ? 'checked' : ''} name="silloCol2"/> Open 
						   		 <input type="radio" value="false" name="silloCol2" ${data.silloCol2 == 'false' ? 'checked' : ''}/> Close  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.silloCol2Desc}" name="silloCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Basis weight valve position in DCS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.silloCol3}" placeholder="" name="silloCol3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.silloCol3Desc}" name="silloCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>    --%> 
						 <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Yankee Pulper</h2></td>
						   
						  </tr>

<%-- 
						  <tr>
						    <td class="tg-yw4l" >Yankee Pulper Overflow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePumplerCol1 == 'true' ? 'checked' : ''} name="yankeePumplerCol1"/> Yes 
						   		 <input type="radio" value="false" name="yankeePumplerCol1" ${data.yankeePumplerCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePumplerCol1Desc}" name="yankeePumplerCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						
						
						
						 <tr>
						    <td class="tg-yw4l" >Yankee Pulper Drain</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePumplerCol1Drain == 'true' ? 'checked' : ''} name="yankeePumplerCol1Drain"/> Open 
						   		 <input type="radio" value="false" name="yankeePumplerCol1Drain" ${data.yankeePumplerCol1Drain == 'false' ? 'checked' : ''}/> Close  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePumplerCol1DrainDesc}" name="yankeePumplerCol1DrainDesc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						
						
						
						

					   <tr>
						    <td class="tg-yw4l" >Yankee Pulper East Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePumplerCol2 == 'true' ? 'checked' : ''} name="yankeePumplerCol2"/> Yes 
						   		 <input type="radio" value="false" name="yankeePumplerCol2" ${data.yankeePumplerCol2 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePumplerCol2Desc}" name="yankeePumplerCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
 --%>
 						<tr>
						    <td class="tg-yw4l" >Yankee Pulper East Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePumplerCol3Inbound}" placeholder="" name="yankeePumplerCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePumplerCol3Outbound}" placeholder=" " name="yankeePumplerCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePumplerCol3Desc}" name="yankeePumplerCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
<%-- 
 						<tr>
						    <td class="tg-yw4l" >Yankee Pulper West Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePumplerCol4 == 'true' ? 'checked' : ''} name="yankeePumplerCol4"/> Yes 
						   		 <input type="radio" value="false" name="yankeePumplerCol4" ${data.yankeePumplerCol4 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePumplerCol4Desc}" name="yankeePumplerCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
 --%>
						<tr>
						    <td class="tg-yw4l" >Yankee Pulper West Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePumplerCol5Inbound}" placeholder="" name="yankeePumplerCol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePumplerCol5Outbound}" placeholder=" " name="yankeePumplerCol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePumplerCol5Desc}" name="yankeePumplerCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
							
					<%-- 	
						<tr>
						    <td class="tg-yw4l" >Yankee pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePumplerCol6 == 'true' ? 'checked' : ''} name="yankeePumplerCol6"/> Yes 
						   		 <input type="radio" value="false" name="yankeePumplerCol6" ${data.yankeePumplerCol6 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePumplerCol6Desc}" name="yankeePumplerCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr> --%>

						<tr>
						    <td class="tg-yw4l" >Yankee pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePumplerCol7Inbound}" placeholder="" name="yankeePumplerCol7Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePumplerCol7Outbound}" placeholder=" " name="yankeePumplerCol7Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePumplerCol7Desc}" name="yankeePumplerCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 

						
						<%-- 	
						<tr>
						    <td class="tg-yw4l" >Yankee trim pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeePumplerCol8 == 'true' ? 'checked' : ''} name="yankeePumplerCol8"/> Yes 
						   		 <input type="radio" value="false" name="yankeePumplerCol8" ${data.yankeePumplerCol8 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeePumplerCol8Desc}" name="yankeePumplerCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						
						
						<tr>
						    <td class="tg-yw4l" >Yankee trim pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeePumplerCol9Inbound}" placeholder="" name="yankeePumplerCol9Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeePumplerCol9Outbound}" placeholder=" " name="yankeePumplerCol9Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeePumplerCol9Desc}" name="yankeePumplerCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						 --%>
						 <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Broke System</h2></td>
						   
						  </tr>
						 
							<%-- 
						 <tr>
						    <td class="tg-yw4l" >Broke Chest level</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol1}" placeholder="" name="brokeSystemCol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol1Desc}" name="brokeSystemCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <tr>
						    <td class="tg-yw4l" >Central broke chest agitator Double</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol2}" placeholder="" name="brokeSystemCol2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol2Desc}" name="brokeSystemCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						   --%>
						   <tr>
						    <td class="tg-yw4l" >Agitator Motor &deg;C</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol3}" placeholder="Temp" name="brokeSystemCol3" style="margin-left: 1px !important;float: none; width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol3Desc}" name="brokeSystemCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						   <tr>
						    <td class="tg-yw4l" >Broke chest agitator South east single</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol4}" placeholder="" name="brokeSystemCol4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol4Desc}" name="brokeSystemCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <tr>
						    <td class="tg-yw4l" >Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol5}" placeholder="Temp" name="brokeSystemCol5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol5Desc}" name="brokeSystemCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <tr>
						    <td class="tg-yw4l" >Broke chest agitator South west single</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol6}" placeholder="" name="brokeSystemCol6" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol6Desc}" name="brokeSystemCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <tr>
						    <td class="tg-yw4l" >Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol7}" placeholder="Temp" name="brokeSystemCol7" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol7Desc}" name="brokeSystemCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <%-- 
						  
						  <tr>
						    <td class="tg-yw4l" >Broke chest pump East</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol8}" placeholder="" name="brokeSystemCol8" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol8Desc}" name="brokeSystemCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  --%> 
						  <tr>
						    <td class="tg-yw4l" >Broke chest pump East Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol9}" placeholder="" name="brokeSystemCol9" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol9Desc}" name="brokeSystemCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" >Broke chest pump West</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol10}" placeholder="" name="brokeSystemCol10" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol10Desc}" name="brokeSystemCol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						   --%>
						  
						    <tr>
						    <td class="tg-yw4l" >Broke chest pump West Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.brokeSystemCol11}" placeholder="Temp" name="brokeSystemCol11" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.brokeSystemCol11Desc}" name="brokeSystemCol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Save All</h2></td>
						   
						  </tr>
						  <%-- 
						  
						   <tr>
						    <td class="tg-yw4l" >Save all Vat</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" class="input" value="${data.saveAllCol1}" placeholder="" name="saveAllCol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						 
						   		 <input type="text"class="input" value="${data.saveAllCol1Desc}" name="saveAllCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						   --%>
						  
						<tr>
						    <td class="tg-yw4l" >Segments</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.saveAllCol2 == 'true' ? 'checked' : ''} name="saveAllCol2"/> Work 
						   		 <input type="radio" value="false" name="saveAllCol2" ${data.saveAllCol2 == 'false' ? 'checked' : ''}/> Plug &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.saveAllCol2Desc}" name="saveAllCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 <tr>
						    <td class="tg-yw4l" >Nozzles</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.saveAllCol3 == 'true' ? 'checked' : ''} name="saveAllCol3"/> Work 
						   		 <input type="radio" value="false" name="saveAllCol3" ${data.saveAllCol3 == 'false' ? 'checked' : ''}/> Plug &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.saveAllCol3Desc}" name="saveAllCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Save all Cylinder Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.saveAllCol4Inbound}" placeholder="" name="saveAllCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.saveAllCol4Outbound}" placeholder=" " name="saveAllCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.saveAllCol4Desc}" name="saveAllCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l" >Segement cleaning shower</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.saveAllCol5 == 'true' ? 'checked' : ''} name="saveAllCol5"/> On 
						   		 <input type="radio" value="false" name="saveAllCol5" ${data.saveAllCol5 == 'false' ? 'checked' : ''}/> Off &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.saveAllCol5Desc}" name="saveAllCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Peel off shower</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.saveAllCol6 == 'true' ? 'checked' : ''} name="saveAllCol6"/> On 
						   		 <input type="radio" value="false" name="saveAllCol6" ${data.saveAllCol6 == 'false' ? 'checked' : ''}/> Off &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.saveAllCol6Desc}" name="saveAllCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Hydrapulper</h2></td>
						   
						  </tr>
						  
						    
						   <tr>
						    <td class="tg-yw4l" >Hydrapulper East Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hydrapulperCol2Inbound}" placeholder="" name="hydrapulperCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hydrapulperCol2outbound}" placeholder=" " name="hydrapulperCol2outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hydrapulperCol2Desc}" name="hydrapulperCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  
						  
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" >Lube system pump East Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hydrapulperCol4Inbound}" placeholder="" name="hydrapulperCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hydrapulperCol4outbound}" placeholder=" " name="hydrapulperCol4outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hydrapulperCol4Desc}" name="hydrapulperCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						   --%>
						   <tr>
						    <td class="tg-yw4l" >Hydrapulper West Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hydrapulperCol8Inbound}" placeholder="" name="hydrapulperCol8Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hydrapulperCol8outbound}" placeholder=" " name="hydrapulperCol8outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hydrapulperCol8Desc}" name="hydrapulperCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >Lube system pump West Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hydrapulperCol10Inbound}" placeholder="" name="hydrapulperCol10Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hydrapulperCol10outbound}" placeholder=" " name="hydrapulperCol10outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hydrapulperCol10Desc}" name="hydrapulperCol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>  --%>
						   <tr>
						    <td class="tg-yw4l" >Hydrapulper stock Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hydrapulperCol14Inbound}" placeholder="" name="hydrapulperCol14Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hydrapulperCol14outbound}" placeholder=" " name="hydrapulperCol14outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hydrapulperCol14Desc}" name="hydrapulperCol14Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  <%-- 
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Hydrapulper East</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol1 == 'true' ? 'checked' : ''} name="hydrapulperCol1"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol1" ${data.hydrapulperCol1 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol1Desc}" name="hydrapulperCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						 
						  
						   <tr>
						    <td class="tg-yw4l" >Lube system pump East</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol3 == 'true' ? 'checked' : ''} name="hydrapulperCol3"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol3" ${data.hydrapulperCol3 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol3Desc}" name="hydrapulperCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						  
						   <tr>
						    <td class="tg-yw4l" >Cooling Coil</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol5 == 'true' ? 'checked' : ''} name="hydrapulperCol5"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol5" ${data.hydrapulperCol5 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol5Desc}" name="hydrapulperCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Lube oil system East Filter</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol6 == 'true' ? 'checked' : ''} name="hydrapulperCol6"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol6" ${data.hydrapulperCol6 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol6Desc}" name="hydrapulperCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Hydrapulper West</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol7 == 'true' ? 'checked' : ''} name="hydrapulperCol7"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol7" ${data.hydrapulperCol7 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol7Desc}" name="hydrapulperCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Lube system pump West</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol9 == 'true' ? 'checked' : ''} name="hydrapulperCol9"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol9" ${data.hydrapulperCol9 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol9Desc}" name="hydrapulperCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						 </tr>
						 
						  
						   <tr>
						    <td class="tg-yw4l" >Cooling Coil</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol11 == 'true' ? 'checked' : ''} name="hydrapulperCol11"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol11" ${data.hydrapulperCol11 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol11Desc}" name="hydrapulperCol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						   </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Lube oil system West Filter</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol12 == 'true' ? 'checked' : ''} name="hydrapulperCol12"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol12" ${data.hydrapulperCol12 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol12Desc}" name="hydrapulperCol12Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						   </tr>
						   
						   
						  <tr>
						    <td class="tg-yw4l" >Hydrapulper stock Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol13 == 'true' ? 'checked' : ''} name="hydrapulperCol13"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol13" ${data.hydrapulperCol13 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol13Desc}" name="hydrapulperCol13Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						   </tr>
						
						   <tr>
						    <td class="tg-yw4l" >Hydrapulper trim pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.hydrapulperCol15 == 'true' ? 'checked' : ''} name="hydrapulperCol15"/> Yes 
						   		 <input type="radio" value="false" name="hydrapulperCol15" ${data.hydrapulperCol15 == 'false' ? 'checked' : ''}/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.hydrapulperCol15Desc}" name="hydrapulperCol15Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						 
						   </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Hydrapulper trim pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.hydrapulperCol16Inbound}" placeholder="" name="hydrapulperCol16Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.hydrapulperCol16outbound}" placeholder=" " name="hydrapulperCol16outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.hydrapulperCol16Desc}" name="hydrapulperCol16Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						   --%>
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);height: 16px;"><h2></h2></td>
						     
				    	</tr> 
				    	
				     
						  
						</c:if> 
						
						<%-- 
						
						 <tr>
						    <td class="tg-yw4l" >Wash M/c floors from the of after dryers to refiners</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	Every Shift:  <input type="text" class="input" value="${data.desccol1}" placeholder=" " name="desccol1" style="margin-left: 1px !important;float: none;"/>
						    	   
						    	
							     <input type="text" class="input" value="${data.desccol1Desc}" name="desccol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  <tr>
						    <td class="tg-yw4l" >Effluent Sampler working condition:</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.effluentsamplerworkingcondition == 'true' ? 'checked' : ''} name="effluentsamplerworkingcondition"/> Yes 
						   		 <input type="radio" value="false" name="effluentsamplerworkingcondition" ${data.effluentsamplerworkingcondition == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.effluentsamplerworkingconditionDesc}" name="effluentsamplerworkingconditionDesc" placeholder="Remarks" style="float: right;"/>
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
						<button class="button" type="submit">Update</button>
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