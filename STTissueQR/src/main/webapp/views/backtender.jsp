<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/operatorCareCheckList/checkObcc" var="checkURL" />
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
	$('input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
	    minDate:-1
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
						location.href="./../operatorCareCheckList/viewoperator?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'backtender')
					{
						location.href="./../backtender/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'stockoperator')
					{
						location.href="./../stockoperator/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'machinetender')
					{
						location.href="./../machineTend/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'utilityoperator')
					{
						location.href="./../UtilityOperator/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'R1')
					{
						location.href="./../R1Operator/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
						
					
				}else
				{
					var entry=confirm("Entry Already Available Do you Want to Edit  Click OK  Cencle it");
					if(entry==true){
						if(position == 'R2')
						{
							location.href="./../operatorCareCheckList/viewoperator?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'backtender')
						{
							location.href="./../backtender/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'stockoperator')
						{
							location.href="./../stockoperator/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'machinetender')
						{
							location.href="./../machineTend/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'utilityoperator')
						{
							location.href="./../UtilityOperator/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R1')
						{
							location.href="./../R1Operator/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
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
<body>

<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
</div>



	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
		 
		<c:if test="${data.position == 'backtender'}">	
			<spring:url value="/backtender/save" var="viewURL"/>
		</c:if>		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Basic Care CheckList</span>
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
		 			<span><b style="font-size: 15px;">BackTender Operator : </b>${data.operatorName}</span>
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
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Reel Hydraulic System</h2></td>
						     
						</tr> 
						  <tr>
						    <td class="tg-yw4l" >Tank Level </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 64px;">Tank Oil Level   </span> <input type="text" class="input" value="${data.reelCol1}" placeholder="Tank Level" name="reelCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.reelCol1Desc}" name="reelCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Record Tank Oil Temperature </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Oil Temperature   </span> <input type="text" class="input" value="${data.reelCol2}" placeholder="Oil Temperature" name="reelCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.reelCol2Desc}" name="reelCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" > Hydraulic Pump Abnormal sound</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    
						   		  <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.reelCol3Inbound}" placeholder="" name="reelCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.reelCol3Outbound}" placeholder=" " name="reelCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.reelCol3Desc}" name="reelCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" > Hydraulic Motor Temperature &deg;C</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		<input type="text" class="input" value="${data.showerWaterCol7Inbound}" placeholder="Temp" name="showerWaterCol7Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		<input type="text"class="input" value="${data.reelCol4Desc}" name="reelCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   
						   
						    <tr>
						    <td class="tg-yw4l" >Gauge Pressure </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 101px;">  Pressure   </span> <input type="text" class="input" value="${data.reelCol5}" placeholder="Oil Temperature" name="reelCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.reelCol5Desc}" name="reelCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  	
						     
						  <br />
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Machine Lubrication System</h2></td>
						     
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Record Lubrication tank Oil Level</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 60px;">  Tank Oil Level   </span> <input type="text" class="input" value="${data.machineLubricationCol1}" placeholder="Tank Level" name="machineLubricationCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.machineLubricationCol1Desc}" name="machineLubricationCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Record Tank Oil Temperature</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 21px;">  Tank Oil Temperature </span> <input type="text" class="input" value="${data.machineLubricationCol2}" placeholder="Tank Level" name="machineLubricationCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.machineLubricationCol2Desc}" name="machineLubricationCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   
						
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Record Oil Filter inlet Temperature</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 21px;">  Tank Oil Temperature   </span> <input type="text" class="input" value="${data.machineLubricationCol4}" placeholder="Tank Level" name="machineLubricationCol4" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.machineLubricationCol4Desc}" name="machineLubricationCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Verify Oil Filter Differential Pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 101px;">  Pressure   </span><input type="text" class="input" value="${data.machineLubricationCol5}" placeholder="Tank Level" name="machineLubricationCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.machineLubricationCol5Desc}" name="machineLubricationCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   
						  
						   
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Condensate system </h2></td>
						   
						  </tr>
						  <tr>
						    <td class="tg-yw4l"  >Low dryer condensate pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound </span> 
						    	<input type="radio" value="true" ${data.condensateCol1 == 'true' ? 'checked' : ''} name="condensateCol1"/> Yes  
						    	<input type="radio" value="false" ${data.condensateCol1 == 'false' ? 'checked' : ''} name="condensateCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol1Desc}" class="input" name="condensateCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Low dryer condensate pump Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 
						    	 
						    	  <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.condensateCol2Inbound}" placeholder="" name="condensateCol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.condensateCol2Outbound}" placeholder=" " name="condensateCol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.condensateCol2Desc}" class="input" name="condensateCol2Desc" placeholder="Remarks" style="float: right;"/> 
						    	 
						    	 
						    	 
						    	
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Condensate vacuum pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound </span> 
						    	<input type="radio" value="true" ${data.condensateCol3 == 'true' ? 'checked' : ''} name="condensateCol3"/> Yes  
						    	<input type="radio" value="false" ${data.condensateCol3 =='false' ? 'checked' : ''} name="condensateCol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol3Desc}" class="input" name="condensateCol3Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Condensate vacuum pump Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	  <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.condensateCol4Inbound}" placeholder="" name="condensateCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.condensateCol4Outbound}" placeholder=" " name="condensateCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.condensateCol4Desc}" class="input" name="condensateCol4Desc" placeholder="Remarks" style="float: right;"/> 
						    	 
						     
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Roll bay air compressor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound </span> 
						    	<input type="radio" value="true" ${data.condensateCol5 =='true' ? 'checked' : ''} name="condensateCol5"/> Yes  
						    	<input type="radio" value="false" ${data.condensateCol5 =='false' ? 'checked' : ''} name="condensateCol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol5Desc}" class="input" name="condensateCol5Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Yankee separator drain</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.condensateCol6 =='true' ? 'checked' : ''} name="condensateCol6"/> Open  
						    	<input type="radio" value="false" ${data.condensateCol6 =='false' ? 'checked' : ''} name="condensateCol6"/> Close &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol6Desc}" class="input" name="condensateCol6Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Yankee separator motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	
						    	  <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.condensateCol7Inbound}" placeholder="" name="condensateCol7Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.condensateCol7Outbound}" placeholder=" " name="condensateCol7Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.condensateCol7Desc}" class="input" name="condensateCol7Desc" placeholder="Remarks" style="float: right;"/> 
						    	 
						    	  
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >After dryer separator drain</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.condensateCol8 =='true' ? 'checked' : ''} name="condensateCol8"/> Open  
						    	<input type="radio" value="false" ${data.condensateCol8 =='false' ? 'checked' : ''} name="condensateCol8"/> Close &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol8Desc}" class="input" name="condensateCol8Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						    <tr>
						    <td class="tg-yw4l"  >After dryer separator motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	  <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.condensateCol9Inbound}" placeholder="" name="condensateCol9Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.condensateCol9Outbound}" placeholder=" " name="condensateCol9Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.condensateCol9Desc}" class="input" name="condensateCol9Desc" placeholder="Remarks" style="float: right;"/> 
						    	 
						    	 
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l"  >Ross Fulton Tank pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound  </span> 
						    	<input type="radio" value="true" ${data.condensateCol10 =='true' ? 'checked' : ''} name="condensateCol10"/> Yes  
						    	<input type="radio" value="false" ${data.condensateCol10 =='false' ? 'checked' : ''} name="condensateCol10"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol10Desc}" class="input" name="condensateCol10Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						 
						 <tr>
						    <td class="tg-yw4l"  >Ross Fulton Tank pump motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	  <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.condensateCol11Inbound}" placeholder="" name="condensateCol11Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.condensateCol11Outbound}" placeholder=" " name="condensateCol11Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.condensateCol11Desc}" class="input" name="condensateCol11Desc" placeholder="Remarks" style="float: right;"/> 
						    	  
						    </td>
						    
						  </tr> 
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Condensate drain in IP line</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.condensateCol12 =='true' ? 'checked' : ''} name="condensateCol12"/> Open  
						    	<input type="radio" value="false" ${data.condensateCol12 =='false' ? 'checked' : ''} name="condensateCol12"/> Close &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol12Desc}" class="input" name="condensateCol12Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Atmospheric condensate tank pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound </span> 
						    	<input type="radio" value="true" ${data.condensateCol13 =='true' ? 'checked' : ''} name="condensateCol13"/> Yes  
						    	<input type="radio" value="false" ${data.condensateCol13 =='false' ? 'checked' : ''} name="condensateCol13"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.condensateCol13Desc}" class="input" name="condensateCol13Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Atmospheric condensate tank pump motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.condensateCol14Inbound}" placeholder="" name="condensateCol14Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.condensateCol14Outbound}" placeholder=" " name="condensateCol14Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.condensateCol14Desc}" class="input" name="condensateCol14Desc" placeholder="Remarks" style="float: right;"/> 
						    	
						    	  
						    </td>
						    
						  </tr>
						  
						   	
						  <tr>
						      <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Shower water system</h2></td>
						  </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >Warm water tank</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Overflow  </span> 
						    	<input type="radio" value="true" ${data.showerWaterCol1 =='true' ? 'checked' : ''} name="showerWaterCol1"/> Yes  
						    	<input type="radio" value="false" ${data.showerWaterCol1 =='false' ? 'checked' : ''} name="showerWaterCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showerWaterCol1Desc}" class="input" name="showerWaterCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 
						   <tr>
						    <td class="tg-yw4l"  >Wam water pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound  </span> 
						    	<input type="radio" value="true" ${data.showerWaterCol2 =='true' ? 'checked' : ''} name="showerWaterCol2"/> Yes  
						    	<input type="radio" value="false" ${data.showerWaterCol2 =='false' ? 'checked' : ''} name="showerWaterCol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showerWaterCol2Desc}" class="input" name="showerWaterCol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >Wam water pump Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.showerWaterCol3Inbound}" placeholder="" name="showerWaterCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.showerWaterCol3Outbound}" placeholder=" " name="showerWaterCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.showerWaterCol3Desc}" class="input" name="showerWaterCol3Desc" placeholder="Remarks" style="float: right;"/> 
						    	
						    	 
						    </td>
						    
						  </tr> 
						 
						 
						   <tr>
						    <td class="tg-yw4l"  >Tepid water return Pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound  </span> 
						    	<input type="radio" value="true" ${data.showerWaterCol4 =='true' ? 'checked' : ''} name="showerWaterCol4"/> Yes  
						    	<input type="radio" value="false" ${data.showerWaterCol4 =='false' ? 'checked' : ''} name="showerWaterCol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showerWaterCol4Desc}" class="input" name="showerWaterCol4Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >Tepid water return Pump Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.showerWaterCol5Inbound}" placeholder="" name="showerWaterCol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.showerWaterCol5Outbound}" placeholder=" " name="showerWaterCol5Outbound" style="margin-left: 1px !important;float: none;     width: 81px;"/>
						    	 <input type="text" value="${data.showerWaterCol5Desc}" class="input" name="showerWaterCol5Desc" placeholder="Remarks" style="float: right;"/> 
						    	 
						    	 
						    	 
						    </td>
						    
						  </tr> 
						 
						 
						
						 <tr>
						    <td class="tg-yw4l" >River Water Filter inlet pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 72px;"> Inlet Pressure  </span> <input type="text" class="input" value="${data.showerWaterCol8}" placeholder=" " name="showerWaterCol8" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.showerWaterCol8Desc}" name="showerWaterCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >River Water Filter outlet pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 62px;"> Outlet Pressure </span>   <input type="text" class="input" value="${data.showerWaterCol9}" placeholder=" " name="showerWaterCol9" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.showerWaterCol9Desc}" name="showerWaterCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Lubrication </h2></td>
						   
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Tending-side SPR Bearing Oil Flow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol1}" placeholder=" " name="lubricationCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCol1Desc}" name="lubricationCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >Tending-side Yankee BRG Oil Flow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 41px">  Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol2}" placeholder=" " name="lubricationCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCol2Desc}" name="lubricationCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >Tending-side SPR Internal BRG Oil Flow </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol3}" placeholder=" " name="lubricationCol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCol3Desc}" name="lubricationCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						    <tr>
						    <td class="tg-yw4l" >Drive-side Yankee Gear Box Oil Flow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 41px">  Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol4}" placeholder=" " name="lubricationCol4" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCol4Desc}" name="lubricationCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Drive-side Yankee GB Oil Flow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 41px"> Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol5}" placeholder=" " name="lubricationCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCo5Desc}" name="lubricationCo5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Drive-side Yankee Bearing Oil Flow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 41px">  Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol6}" placeholder=" " name="lubricationCol6" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCo6Desc}" name="lubricationCo6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Drive-side SPR Bearing Oil Flow</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Sight-glass Setting </span>  <input type="text" class="input" value="${data.lubricationCol7}" placeholder=" " name="lubricationCol7" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.lubricationCo7Desc}" name="lubricationCo7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						</c:if>
						
						 <c:if test="${data.shift == 'night'}"> 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>After - dryer & Benchboard Area </h2></td>
						   
						  </tr>
						 
						 
						   <tr>
						    <td class="tg-yw4l"  >Verify Dryer felt edges are smooth</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.afterDryerCol1 =='true' ? 'checked' : ''} name="afterDryerCol1"/> Yes  
						    	<input type="radio" value="false" ${data.afterDryerCol1 =='false' ? 'checked' : ''} name="afterDryerCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.afterDryerCol1Desc}" class="input" name="afterDryerCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						 
						  <tr>
						    <td class="tg-yw4l" >Top Stretch Felt Tension (PSI)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Loading Pressure </span>  <input type="text" class="input" value="${data.afterDryerCol2}" placeholder=" " name="afterDryerCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.afterDryerCol2Desc}" name="afterDryerCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Bottom Stretch Felt Tension (PSI)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Loading Pressure </span>  <input type="text" class="input" value="${data.afterDryerCol3}" placeholder=" " name="afterDryerCol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.afterDryerCol3Desc}" name="afterDryerCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Eqpt Name: Scanner </h2></td>
						   
						  </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >Verify Scanner Air Filter is Clean</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.eqptScannerCol1 =='true' ? 'checked' : ''} name="eqptScannerCol1"/> Yes  
						    	<input type="radio" value="false" ${data.eqptScannerCol1 =='false' ? 'checked' : ''} name="eqptScannerCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.eqptScannerCol1Desc}" class="input" name="eqptScannerCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr> 
						
						 <tr>
						    <td class="tg-yw4l"  >Clean the scanner heads</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.eqptScannerCol3 =='true' ? 'checked' : ''} name="eqptScannerCol3"/> Yes  
						    	<input type="radio" value="false" ${data.eqptScannerCol3 =='false' ? 'checked' : ''} name="eqptScannerCol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.eqptScannerCol3Desc}" class="input" name="eqptScannerCol3Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr> 
						 
						 
						 <tr>
						    <td class="tg-yw4l"  >Cleanliness of the opearting floor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.eqptScannerCol4 =='true' ? 'checked' : ''} name="eqptScannerCol4"/> Yes  
						    	<input type="radio" value="false" ${data.eqptScannerCol4 =='false' ? 'checked' : ''} name="eqptScannerCol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.eqptScannerCol4Desc}" class="input" name="eqptScannerCol4Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr> 
						 
						  <tr>
						    <td class="tg-yw4l"  >Spool starter fire condition</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.eqptScannerCol5 =='true' ? 'checked' : ''} name="eqptScannerCol5"/> Yes  
						    	<input type="radio" value="false" ${data.eqptScannerCol5 =='false' ? 'checked' : ''} name="eqptScannerCol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.eqptScannerCol5Desc}" class="input" name="eqptScannerCol5Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr> 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Eqpt Name: Reel Section & Benchboard </h2></td>
						   
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l"  >Verify brakes pads condition is acceptable</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.eqptReelSectionCol1 =='true' ? 'checked' : ''} name="eqptReelSectionCol1"/> Yes  
						    	<input type="radio" value="false" ${data.eqptReelSectionCol1 =='false' ? 'checked' : ''} name="eqptReelSectionCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.eqptReelSectionCol1Desc}" class="input" name="eqptReelSectionCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 <tr>
						    <td class="tg-yw4l" >Mill Supply Air Pressure (PSI) </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 83px"> Air Pressure </span>   <input type="text" class="input" value="${data.eqptReelSectionCol2}" placeholder=" " name="eqptReelSectionCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.eqptReelSectionCol2Desc}" name="eqptReelSectionCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Reel Doctor Loading Pressure (PSI)  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">  Loading Pressure </span>  <input type="text" class="input" value="${data.eqptReelSectionCol3}" placeholder=" " name="eqptReelSectionCol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.eqptReelSectionCol3Desc}" name="eqptReelSectionCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Reel Brake Loading Pressure (PSI) </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">  Loading Pressure </span>  <input type="text" class="input" value="${data.eqptReelSectionCol4}" placeholder=" " name="eqptReelSectionCol4" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.eqptReelSectionCol4Desc}" name="eqptReelSectionCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >After-dryer Doctor Loading Pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">  Loading Pressure </span> <input type="text" class="input" value="${data.eqptReelSectionCol5}" placeholder=" " name="eqptReelSectionCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.eqptReelSectionCol5Desc}" name="eqptReelSectionCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Oil Flows</h2></td>
						   
						  </tr>
						  
						    <tr>
						    <td class="tg-yw4l"  >DS2 (F)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.oilFlowCol1 =='true' ? 'checked' : ''} name="oilFlowCol1"/> Yes  
						    	<input type="radio" value="false" ${data.oilFlowCol1 =='false' ? 'checked' : ''} name="oilFlowCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.oilFlowCol1Desc}" class="input" name="oilFlowCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l"  >DS3 (H)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.oilFlowCol2 =='true' ? 'checked' : ''} name="oilFlowCol2"/> Yes  
						    	<input type="radio" value="false" ${data.oilFlowCol2 =='false' ? 'checked' : ''} name="oilFlowCol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.oilFlowCol2Desc}" class="input" name="oilFlowCol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l"  >DS4 (I)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.oilFlowCol3 =='true' ? 'checked' : ''} name="oilFlowCol3"/> Yes  
						    	<input type="radio" value="false" ${data.oilFlowCol3 =='false' ? 'checked' : ''} name="oilFlowCol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.oilFlowCol3Desc}" class="input" name="oilFlowCol3Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						  <tr>
						    <td class="tg-yw4l"  >DS5 (N)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.oilFlowCol4 =='true' ? 'checked' : ''} name="oilFlowCol4"/> Yes  
						    	<input type="radio" value="false" ${data.oilFlowCol4 =='false' ? 'checked' : ''} name="oilFlowCol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.oilFlowCol4Desc}" class="input" name="oilFlowCol4Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >RGBXT</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 49px">    Oil Flow Setting </span>  <input type="text" class="input" value="${data.oilFlowCol5}" placeholder=" " name="oilFlowCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.oilFlowCol5Desc}" name="oilFlowCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l" >RBRG</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 49px">    Oil Flow Setting </span> <input type="text" class="input" value="${data.oilFlowCol6}" placeholder=" " name="oilFlowCol6" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.oilFlowCol6Desc}" name="oilFlowCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l" >RGBXS</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 49px">    Oil Flow Setting </span> <input type="text" class="input" value="${data.oilFlowCol7}" placeholder=" " name="oilFlowCol7" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.oilFlowCol7Desc}" name="oilFlowCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Mezzanine</h2></td>
						   
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Verify DE Combustion External Filters are <br /> clean and not plugged/dirty </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.mezzanineCol1 =='true' ? 'checked' : ''} name="mezzanineCol1"/> Yes  
						    	<input type="radio" value="false" ${data.mezzanineCol1 =='false' ? 'checked' : ''} name="mezzanineCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.mezzanineCol1Desc}" class="input" name="mezzanineCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 
						 <tr>
						    <td class="tg-yw4l"  >Verify WE Combustion Ext Filters are clean </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.mezzanineCol2 =='true' ? 'checked' : ''} name="mezzanineCol2"/> Yes  
						    	<input type="radio" value="false" ${data.mezzanineCol2 =='false' ? 'checked' : ''} name="mezzanineCol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.mezzanineCol2Desc}" class="input" name="mezzanineCol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 
						 <tr>
						    <td class="tg-yw4l"  >Verify DE Yankee Hood Supply Fan Bearing Oil levels (2)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.mezzanineCol3 =='true' ? 'checked' : ''} name="mezzanineCol3"/> Yes  
						    	<input type="radio" value="false" ${data.mezzanineCol3 =='false' ? 'checked' : ''} name="mezzanineCol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.mezzanineCol3Desc}" class="input" name="mezzanineCol3Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 <tr>
						    <td class="tg-yw4l"  >Inspect Drive Side Clearance between Hood and Yankee <br/> Dryer for pluggage/build-up. </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.mezzanineCol4 =='true' ? 'checked' : ''} name="mezzanineCol4"/> Yes  
						    	<input type="radio" value="false" ${data.mezzanineCol4 =='false' ? 'checked' : ''} name="mezzanineCol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.mezzanineCol4Desc}" class="input" name="mezzanineCol4Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 <tr>
						    <td class="tg-yw4l"  >Verify WE Yankee Hood Supply Fan Bearing Oil levels (2) </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.mezzanineCol5 =='true' ? 'checked' : ''} name="mezzanineCol5"/> Yes  
						    	<input type="radio" value="false" ${data.mezzanineCol5 =='false' ? 'checked' : ''} name="mezzanineCol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.mezzanineCol5Desc}" class="input" name="mezzanineCol5Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
					</c:if>	  
					
					<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);height: 16px;"><h2></h2></td>
						     
				    </tr> 
						
						
						 <tr>
						    <td class="tg-yw4l"  >Blow down Yankee catwalks, top of hood and <br /> hood duct work  </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol1}" placeholder=" " name="fillupcol1" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol1Desc}" name="fillupcol1Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						 <tr>
						    <td class="tg-yw4l"  >Wash and clean  floors from the  after dryers to <br /> refiners  (T/S and D/S)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol2}" placeholder=" " name="fillupcol2" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol2Desc}" name="fillupcol2Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						 <tr>
						    <td class="tg-yw4l"  >Clean basement from Loose paper when needed</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol3}" placeholder=" " name="fillupcol3" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol3Desc}" name="fillupcol3Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						 <c:if test="${data.shift == 'night'}"> 
						 <tr>
						    <td class="tg-yw4l"  >Blow down After Dryers and frame work   </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol4}" placeholder=" " name="fillupcol4" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol4Desc}" name="fillupcol4Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						</c:if> 
						 <tr>
						    <td class="tg-yw4l"  >Check Chemical totes and change if needed</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol5}" placeholder=" " name="fillupcol5" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol5Desc}" name="fillupcol5Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						  
						 <tr>
						    <td class="tg-yw4l"  >At least 3 blades should be on top of blade <br /> platform and all used blades cut up by end of shift </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol6}" placeholder=" " name="fillupcol6" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol6Desc}" name="fillupcol6Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						 <tr>
						    <td class="tg-yw4l"  >Area around reel should be free from loose paper </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	 <input type="text" class="input" value="${data.fillupcol7}" placeholder=" " name="fillupcol7" style="margin-left: 1px !important;float: none;"/>
							     <input type="text" class="input" value="${data.fillupcol7Desc}" name="fillupcol7Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	</td>
						    </td>
						    
						 </tr>	
						 <tr>
						    <td class="tg-yw4l">Skinning Doctor Loading Pressure(PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							    	Loading Pressure<input type="text" value="${data.condensateCol15}"  name="condensateCol15"/>
							    	<input type="text" value="${data.condensateCol15Desc}" class="input" name="condensateCol15Desc" placeholder="Remarks" style="float: right;"/>  </td>
							    </td>
						 </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Creeping Doctor Loading Pressure(PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							   		 Loading Pressure<input type="text" value="${data.machineLubricationCol3}" name="machineLubricationCol3" /> 
							   		 <input type="text"class="input" value="${data.machineLubricationCol3Desc}" name="machineLubricationCol3Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						 </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >Verify Creeping Doctor Oscillation</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.afterDryerCol4 =='true' ? 'checked' : ''} name="afterDryerCol4"/> Yes  
						    	<input type="radio" value="false" ${data.afterDryerCol4 =='false' ? 'checked' : ''} name="afterDryerCol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.afterDryerCol4Desc}" class="input" name="afterDryerCol4Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						  </tr> 
						  <tr>
						    <td class="tg-yw4l"  >Empty All wet end trash cans </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.showerWaterCol6 =='true' ? 'checked' : ''} name="showerWaterCol6"/> Yes  
						    	<input type="radio" value="false" ${data.showerWaterCol6 =='false' ? 'checked' : ''} name="showerWaterCol6"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showerWaterCol6Desc}" class="input" name="showerWaterCol6Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>						    
						 </tr>
						  <tr>
						    <td class="tg-yw4l"  >Blow off all machine drive motors </td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.showerWaterCol11 =='true' ? 'checked' : ''} name="showerWaterCol11"/> Yes  
						    	<input type="radio" value="false" ${data.showerWaterCol11 =='false' ? 'checked' : ''} name="showerWaterCol11"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showerWaterCol7Desc}" class="input" name="showerWaterCol7Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr> 
						   <tr>
						     <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Chemical totes </h2></td>
						   
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >Felt Passivator Supply Tank </td>
						    <td class="tg-yw4l" style="text-align: center;">
								     Level	<input type="text" value="${data.afterDryerCol5}"  name="afterDryerCol5"/>
								     <input type="text" value="${data.afterDryerCol5Desc}" class="input" name="afterDryerCol5Desc" placeholder="Remarks" style="float: right;"/>  </td>
							    </td>
						  </tr> 
						  
						  
						  <tr>
							    <td class="tg-yw4l"  >Defoamer Supply Tank</td>
							    
							    	<td class="tg-yw4l" style="text-align: center;">
							    	Level <input type="text" value="${data.afterDryerCol6}"  name="afterDryerCol6"/>
							    	<input type="text" value="${data.afterDryerCol6Desc}" class="input" name="afterDryerCol6Desc" placeholder="Remarks" style="float: right;"/>  </td>
							    </td>
						   </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Adhesive Supply Tank</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	Level<input type="text" value="${data.eqptScannerCol2}"  name="eqptScannerCol2"/>
						    	<input type="text" value="${data.eqptScannerCol2Desc}" class="input" name="eqptScannerCol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr> 
						 
						 <tr>
						    <td class="tg-yw4l"  >Coating Supply Tank</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	Level <input type="text" value="${data.checkbladechange}"  name="checkbladechange"/>
									  <input type="text" value="${data.checkbladechangeremark}" class="input" name="checkbladechangeremark" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l"  >Release Supply Tank</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="text" value="${data.celovesforholes}"  name="celovesforholes"/>
						    	<input type="text" value="${data.celovesforholesremark}" class="input" name="celovesforholesremark" placeholder="Remarks" style="float: right;"/>  </td>
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