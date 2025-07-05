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
		 
		<c:if test="${data.position == 'machinetender'}">	
			<spring:url value="/machineTend/save" var="viewURL"/>
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
		 			<span><b style="font-size: 15px;">machine Tender Operator : </b>${data.operatorName}</span>
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
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Forming Section</h2></td>
						     
						</tr> 
						  <tr>
						    <td class="tg-yw4l" >Verify Fabric Tension with Tensometer </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 32px;">Tensometer Reading    </span> <input type="text" class="input" value="${data.formingSectionCol1}"  name="formingSectionCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol1Desc}" name="formingSectionCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Throat - Front (GPM) </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Seal Water Flow    </span> <input type="text" class="input" value="${data.formingSectionCol2}"  name="formingSectionCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol2Desc}" name="formingSectionCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Vat - Front  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Seal Water Flow    </span> <input type="text" class="input" value="${data.formingSectionCol3}"   name="formingSectionCol3" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol3Desc}" name="formingSectionCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Slice - Front</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Seal Water Flow    </span> <input type="text" class="input" value="${data.formingSectionCol4}"   name="formingSectionCol4" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol4Desc}" name="formingSectionCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Slice - Back </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Seal Water Flow    </span> <input type="text" class="input" value="${data.formingSectionCol5}"   name="formingSectionCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol5Desc}" name="formingSectionCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Throat - Back </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Seal Water Flow    </span> <input type="text" class="input" value="${data.formingSectionCol6}"  name="formingSectionCol6" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol6Desc}" name="formingSectionCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Vat - Back </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 56px;"> Seal Water Flow    </span> <input type="text" class="input" value="${data.formingSectionCol7}"   name="formingSectionCol7" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol7Desc}" name="formingSectionCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Supply Air Pressure (PSI) </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 46px;"> Gauge Pressure      </span> <input type="text" class="input" value="${data.formingSectionCol8}"   name="formingSectionCol8" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol8Desc}" name="formingSectionCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Wire Guide Diaphragm Air Pressure (PSI)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 46px;"> Gauge Pressure  </span> <input type="text" class="input" value="${data.formingSectionCol9}"   name="formingSectionCol9" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol9Desc}" name="formingSectionCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Counter Balance Air Pressure (PSI) </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 46px;"> Gauge Pressure   </span> <input type="text" class="input" value="${data.formingSectionCol10}"   name="formingSectionCol10" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol10Desc}" name="formingSectionCol10Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Tension Air Pressure (PSI) </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 46px;"> Gauge Pressure   </span> <input type="text" class="input" value="${data.formingSectionCol11}"   name="formingSectionCol11" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol11Desc}" name="formingSectionCol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Tension Roll Counter Weight Air Pressure  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 46px;"> Gauge Pressure   </span> <input type="text" class="input" value="${data.formingSectionCol12}"   name="formingSectionCol12" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.formingSectionCol12Desc}" name="formingSectionCol12Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   
						  
						  
						   <tr>
						    <td class="tg-yw4l" > Verify Wire edges are smooth </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.formingSectionCol13 == 'true' ? 'checked' : ''} name="formingSectionCol13"/> Yes 
						   		 <input type="radio" value="false" name="formingSectionCol13" ${data.formingSectionCol13 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.formingSectionCol13Desc}" name="formingSectionCol13Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" > Wire Guide Position Correct & Cleanliness </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.formingSectionCol14 == 'true' ? 'checked' : ''} name="formingSectionCol14"/> Yes 
						   		 <input type="radio" value="false" name="formingSectionCol14" ${data.formingSectionCol14 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.formingSectionCol14Desc}" name="formingSectionCol14Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Check Headbox Air Compressor Inlet Filter Cleanliness</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.checkheadboxaircompressorintelfiltercleanliness == 'true' ? 'checked' : ''} name="checkheadboxaircompressorintelfiltercleanliness"/> Yes 
						   		 <input type="radio" value="false" name="checkheadboxaircompressorintelfiltercleanliness" ${data.checkheadboxaircompressorintelfiltercleanliness == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.checkheadboxaircompressorintelfiltercleanlinessdesc}" name="checkheadboxaircompressorintelfiltercleanlinessdesc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Rotating Showers</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rotatingShowers == 'true' ? 'checked' : ''} name="rotatingShowers"/> ON 
						   		 <input type="radio" value="false" name="rotatingShowers" ${data.rotatingShowers == 'false' ? 'checked' : ''}/> OFF  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rotatingShowersremark}" name="rotatingShowersremark" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Rotating Showers Valve</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" value="${data.rotationShowersValve}" name="rotationShowersValve" /> PSI  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rotationShowersValveremark}" name="rotationShowersValveremark" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Suction Pressure Roll</h2></td>
						     
						 </tr> 
						 
						 
						 
						  <tr>
						    	<td class="tg-yw4l" >Lubrication Shower Pressure (PSI) </td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;"> Shower  Pressure   </span> <input type="text" class="input" value="${data.suctionPressureRollCol1}"   name="suctionPressureRollCol1" style="margin-left: 1px !important;float: none;"/>
							    	
								     
								    <input type="text" class="input" value="${data.suctionPressureRollCol1Desc}" name="suctionPressureRollCol1Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						   <tr>
						    	<td class="tg-yw4l" >Cleaning Shower Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;"> Shower  Pressure   </span> <input type="text" class="input" value="${data.suctionPressureRollCol2}"   name="suctionPressureRollCol2" style="margin-left: 1px !important;float: none;"/>
							    	
								    
								    <input type="text" class="input" value="${data.suctionPressureRollCol2Desc}" name="suctionPressureRollCol2Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						   <tr>
						    	<td class="tg-yw4l" >SPR  Loading Pressure  </td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 39px;"> Loading  Pressure   </span> <input type="text" class="input" value="${data.suctionPressureRollCol3}"   name="suctionPressureRollCol3" style="margin-left: 1px !important;float: none;"/>
							    	
								     
								    <input type="text" class="input" value="${data.suctionPressureRollCol3Desc}" name="suctionPressureRollCol3Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						   <tr>
						    	<td class="tg-yw4l" >Suction Box Position </td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 96px;"> Position    </span> <input type="text" class="input" value="${data.suctionPressureRollCol4}"   name="suctionPressureRollCol4" style="margin-left: 1px !important;float: none;"/>
							    	
								     
								    <input type="text" class="input" value="${data.suctionPressureRollCol4Desc}" name="suctionPressureRollCol4Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>  
						  
						   <tr>
						    	<td class="tg-yw4l" >Vacuum Level ("Hg) </td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 96px;"> Vacuum  </span> <input type="text" class="input" value="${data.suctionPressureRollCol5}"   name="suctionPressureRollCol5" style="margin-left: 1px !important;float: none;"/>
							    	
								      
								    <input type="text" class="input" value="${data.suctionPressureRollCol5Desc}" name="suctionPressureRollCol5Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						   <tr>
						    	<td class="tg-yw4l" >Air to Packing Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 66px;"> Air  Pressure   </span> <input type="text" class="input" value="${data.suctionPressureRollCol6}"   name="suctionPressureRollCol6" style="margin-left: 1px !important;float: none;"/>
							    	
								    
								    <input type="text" class="input" value="${data.suctionPressureRollCol6Desc}" name="suctionPressureRollCol6Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" > SPR Doctor Cleanliness </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.suctionPressureRollCol7 == 'true' ? 'checked' : ''} name="suctionPressureRollCol7"/> Yes 
						   		 <input type="radio" value="false" name="suctionPressureRollCol7" ${data.suctionPressureRollCol7 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.suctionPressureRollCol7Desc}" name="suctionPressureRollCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Yankee Dryer & doctors </h2></td>
						     
						 </tr> 
						 
						<%--  
						  <tr>
						    	<td class="tg-yw4l" >Skinning Doctor Loading Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;"> Loading  Pressure    </span> <input type="text" class="input" value="${data.yankeeDryerCol1}"  name="yankeeDryerCol1" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.yankeeDryerCol1Desc}" name="yankeeDryerCol1Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    	<td class="tg-yw4l" >Creping Doctor Loading Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;"> Loading  Pressure    </span> <input type="text" class="input" value="${data.yankeeDryerCol2}"   name="yankeeDryerCol2" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.yankeeDryerCol2Desc}" name="yankeeDryerCol2Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" > Verify Creping Doctor Oscillation  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeeDryerCol3 == 'true' ? 'checked' : ''} name="yankeeDryerCol3"/> Yes 
						   		 <input type="radio" value="false" name="yankeeDryerCol3" ${data.yankeeDryerCol3 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeeDryerCol3Desc}" name="yankeeDryerCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  <tr>
						    	<td class="tg-yw4l" >Felt Roll No. 2 Doctor Loading Pressure</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;"> Loading  Pressure    </span> <input type="text" class="input" value="${data.yankeeDryerCol4}"  name="yankeeDryerCol4" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.yankeeDryerCol4Desc}" name="yankeeDryerCol4Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" > Sprayboom shower Position  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.yankeeDryerCol5 == 'true' ? 'checked' : ''} name="yankeeDryerCol5"/> Yes 
						   		 <input type="radio" value="false" name="yankeeDryerCol5" ${data.yankeeDryerCol5 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.yankeeDryerCol5Desc}" name="yankeeDryerCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Drive Roll Gearbox Temperatures </h2></td>
						     
						 </tr> 
						 
						 
						 
						  <tr>
						    	<td class="tg-yw4l" >Couch Roll Drive Motor Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol1}"   name="driveRollCol1" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol1Desc}" name="driveRollCol1Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						 
						 <tr>
						    	<td class="tg-yw4l" >Pick-up Roll Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol2}"  name="driveRollCol2" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol2Desc}" name="driveRollCol2Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  
						  
						  <tr>
						    	<td class="tg-yw4l" >Wire Turning Roll Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol3}"   name="driveRollCol3" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol3Desc}" name="driveRollCol3Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    	<td class="tg-yw4l" >Suction Pressure Roll Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol4}"   name="driveRollCol4" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol4Desc}" name="driveRollCol4Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    	<td class="tg-yw4l" >Yankee Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol5}"   name="driveRollCol5" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol5Desc}" name="driveRollCol5Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    	<td class="tg-yw4l" >After-dryer Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol6}"   name="driveRollCol6" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol6Desc}" name="driveRollCol6Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    	<td class="tg-yw4l" >Reel Drum Gearbox Temp.</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gearbox Temp </span> <input type="text" class="input" value="${data.driveRollCol7}"   name="driveRollCol7" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol7Desc}" name="driveRollCol7Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    	<td class="tg-yw4l" >Check Yankee Wet and Dry end temp on In board and Out Board of Motor:</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;"></span> <input type="text" class="input" value="${data.driveRollCol8}"   name="driveRollCol8" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.driveRollCol8Desc}" name="driveRollCol8Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Press Section Benchboard Area </h2></td>
						     
						 </tr> 
						  
						 
						  <tr>
						    	<td class="tg-yw4l" >Couch Roll Doctor Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gauge Pressure    </span> <input type="text" class="input" value="${data.pressSectionCol1}"  name="pressSectionCol1" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.pressSectionCol1Desc}" name="pressSectionCol1Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						
						
						
						
						
						  
						  
						  
						   <tr>
						    	<td class="tg-yw4l" >Automatic Felt Guide Supply Pressure </td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gauge Pressure    </span> <input type="text" class="input" value="${data.pressSectionCol2}"  name="pressSectionCol2" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.pressSectionCol2Desc}" name="pressSectionCol2Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    	<td class="tg-yw4l" >Manual Felt Guide Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gauge Pressure    </span> <input type="text" class="input" value="${data.pressSectionCol3}"  name="pressSectionCol3" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.pressSectionCol3Desc}" name="pressSectionCol3Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						   <tr>
						    	<td class="tg-yw4l" >Press Felt Stretch Roll Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gauge Pressure    </span> <input type="text" class="input" value="${data.pressSectionCol4}"   name="pressSectionCol4" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.pressSectionCol4Desc}" name="pressSectionCol4Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						
						
						  <tr>
						    	<td class="tg-yw4l" >Inside Wire HP Shower Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gauge Pressure    </span> <input type="text" class="input" value="${data.pressSectionCol5}"   name="pressSectionCol5" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.pressSectionCol5Desc}" name="pressSectionCol5Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" > Verify Inside Wire HP Shower Oscillation</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.pressSectionCol6 == 'true' ? 'checked' : ''} name="pressSectionCol6"/> Yes 
						   		 <input type="radio" value="false" name="pressSectionCol6" ${data.pressSectionCol6 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.pressSectionCol6Desc}" name="pressSectionCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						 
						  <tr>
						    	<td class="tg-yw4l" >Outside Wire HP Shower Pressure (PSI)</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	 <span style="margin-right: 46px;">Gauge Pressure    </span> <input type="text" class="input" value="${data.pressSectionCol7}"   name="pressSectionCol7" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.pressSectionCol7Desc}" name="pressSectionCol7Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" > Verify Outside Wire HP Shower Oscillation</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.pressSectionCol8 == 'true' ? 'checked' : ''} name="pressSectionCol8"/> Yes 
						   		 <input type="radio" value="false" name="pressSectionCol8" ${data.pressSectionCol8 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.pressSectionCol8Desc}" name="pressSectionCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						 </tr>			  	
						     
						  <br />
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Upper Press Felt Area</h2></td>
						     
						  </tr>
						  
						  
						  <%--  <tr>
						    <td class="tg-yw4l" >South Uhle Box Vacuum ("Hg)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 60px;">Vacuum Level     </span> <input type="text" class="input" value="${data.upperPressCol1}"   name="upperPressCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
							    <input type="text" class="input" value="${data.upperPressCol1Desc}" name="upperPressCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> --%>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Uhle Box Vacuum ("Hg)</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 60px;">Vacuum Level     </span> <input type="text" class="input" value="${data.upperPressCol2}"   name="upperPressCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
							    <input type="text" class="input" value="${data.upperPressCol2Desc}" name="upperPressCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" > Verify HP Press Felt Shower Oscillation</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.upperPressCol3 == 'true' ? 'checked' : ''} name="upperPressCol3"/> Yes 
						   		 <input type="radio" value="false" name="upperPressCol3" ${data.upperPressCol3 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.upperPressCol3Desc}" name="upperPressCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <%-- 
						  <tr>
						    <td class="tg-yw4l" > Verify Felt Guide Paddle Position </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.upperPressCol4 == 'true' ? 'checked' : ''} name="upperPressCol4"/> Yes 
						   		 <input type="radio" value="false" name="upperPressCol4" ${data.upperPressCol4 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.upperPressCol4Desc}" name="upperPressCol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  <tr>
						    <td class="tg-yw4l" > Uhlebox cleanliness  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.upperPressCol5 == 'true' ? 'checked' : ''} name="upperPressCol5"/> Yes 
						   		 <input type="radio" value="false" name="upperPressCol5" ${data.upperPressCol5 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.upperPressCol5Desc}" name="upperPressCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" > Felt passivator shower Nozzles spinning</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.upperPressCol6 == 'true' ? 'checked' : ''} name="upperPressCol6"/> Yes 
						   		 <input type="radio" value="false" name="upperPressCol6" ${data.upperPressCol6 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.upperPressCol6Desc}" name="upperPressCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Verify Felt edges are smooth</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.upperPressCol7 == 'true' ? 'checked' : ''} name="upperPressCol7"/> Yes 
						   		 <input type="radio" value="false" name="upperPressCol7" ${data.upperPressCol7 == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.upperPressCol7Desc}" name="upperPressCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" > Uhlebox Lubrication Shower </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.upperPressCol8 == 'true' ? 'checked' : ''} name="upperPressCol8"/> On  
						   		 <input type="radio" value="false" name="upperPressCol8" ${data.upperPressCol8 == 'false' ? '' : ''}/> Off  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.upperPressCol8Desc}" name="upperPressCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" > Press Felt HP Cleaning Shower </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="text" value="${data.upperPressCol9}" name="upperPressCol9" />
						   		 <input type="text"class="input" value="${data.upperPressCol9Desc}" name="upperPressCol9Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						 
						  
						   <%-- 
						   
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Chemical totes </h2></td>
						   
						  </tr>
						  
						  
						    <tr>
							    <td class="tg-yw4l" >Felt Passivator Supply tank</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	<span style="margin-right: 60px;">Level    </span> <input type="text" class="input" value="${data.chemicalTotesCol1}"   name="chemicalTotesCol1" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.chemicalTotesCol1Desc}" name="chemicalTotesCol1Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  	</tr>
						  	
						  	<tr>
							    <td class="tg-yw4l" >Defoamer Supply tank</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	<span style="margin-right: 60px;">Level   </span> <input type="text" class="input" value="${data.chemicalTotesCol2}"   name="chemicalTotesCol2" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.chemicalTotesCol2Desc}" name="chemicalTotesCol2Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  	</tr>
						  	
						  	<tr>
							    <td class="tg-yw4l" >Adhesive supply tank</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	<span style="margin-right: 60px;">Level    </span> <input type="text" class="input" value="${data.chemicalTotesCol3}"   name="chemicalTotesCol3" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.chemicalTotesCol3Desc}" name="chemicalTotesCol3Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  	</tr>
						  	
						  	<tr>
							    <td class="tg-yw4l" >Coating supply tank</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	<span style="margin-right: 60px;">Level    </span> <input type="text" class="input" value="${data.chemicalTotesCol4}"   name="chemicalTotesCol4" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.chemicalTotesCol4Desc}" name="chemicalTotesCol4Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  	</tr>
						  	
						  	<tr>
							    <td class="tg-yw4l" >Release supply tank</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	<span style="margin-right: 60px;">Level    </span> <input type="text" class="input" value="${data.chemicalTotesCol5}"   name="chemicalTotesCol5" style="margin-left: 1px !important;float: none;"/>
							    	
								    <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK  
								    <input type="text" class="input" value="${data.chemicalTotesCol5Desc}" name="chemicalTotesCol5Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  	</tr>
						    --%>
						 </c:if>
						 
						 <c:if test="${data.shift == 'night'}"> 	  	
						   	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Fan Pump</h2></td>
						   
						  </tr>
						  
						  
						  
						  
						  	<tr>
							    <td class="tg-yw4l" >Fan Pump sealing water</td>
							    <td class="tg-yw4l" style="text-align: center;">
							        
							    	<span style="margin-right: 106px;"> </span> <input type="text" class="input" value="${data.fanPumpCol1}"   name="fanPumpCol1" style="margin-left: 1px !important;float: none;"/>
							    	
								   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%>  
								    <input type="text" class="input" value="${data.fanPumpCol1Desc}" name="fanPumpCol1Desc" placeholder="Remarks" style="float: right;"/>
							    </td>
						    
						  	</tr>
						  
						  
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >Fan pump Gearbox</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span>Abnormal Sound </span> 
						    	<input type="radio" value="true" ${data.fanPumpCol2 == 'true' ? 'checked' : ''} name="fanPumpCol2"/> Yes  
						    	<input type="radio" value="false" ${data.fanPumpCol2 == 'false' ? '' : ''} name="fanPumpCol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.fanPumpCol2Desc}" class="input" name="fanPumpCol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						 </tr>
						 
						 
						   <tr>
						    <td class="tg-yw4l"  >Fan pump Gearbox</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	  <span style="margin-right: 56px;"> Temperature   </span> West:<input type="text" class="input" value="${data.fanPumpCol3Inbound}" placeholder="" name="fanPumpCol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  East:<input type="text" class="input" value="${data.fanPumpCol3Outbound}" placeholder=" " name="fanPumpCol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.fanPumpCol3Desc}" name="fanPumpCol3Desc" placeholder="Remarks" style="float: right;"/>
						    	
						     
						    </td>
						    
						 </tr>
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >Fan Pump Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.fanPumpCol4Inbound}" placeholder="" name="fanPumpCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.fanPumpCol4Outbound}" placeholder=" " name="fanPumpCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.fanPumpCol4Desc}" name="fanPumpCol4Desc" placeholder="Remarks" style="float: right;"/>
						    	 
						    	 
						    </td>
						    
						  </tr> 
						 
						  <tr>
						    <td class="tg-yw4l" >Rotating Showers</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rotatingShowers == 'true' ? 'checked' : ''} name="rotatingShowers"/> ON 
						   		 <input type="radio" value="false" name="rotatingShowers" ${data.rotatingShowers == 'false' ? 'checked' : ''}/> OFF  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rotatingShowersremark}" name="rotatingShowersremark" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Rotating Showers Valve</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.rotationShowersValve == 'true' ? 'checked' : ''} name="rotationShowersValve"/> ON 
						   		 <input type="radio" value="false" name="rotationShowersValve" ${data.rotationShowersValve == 'false' ? 'checked' : ''}/> OFF  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.rotationShowersValveremark}" name="rotationShowersValveremark" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Selectifier screen </h2></td>
						   
						  </tr>
						 
						  <tr>
						    <td class="tg-yw4l" >Inlet pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 12px"> Outlet pressure</span>  <input type="text" class="input" value="${data.selectifierScreenCol1}" placeholder=" " name="selectifierScreenCol1" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.selectifierScreenCol1Desc}" name="selectifierScreenCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >Outlet pressure</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        	<span style="margin-right: 106px;"></span>
						    	   <input type="text" class="input" value="${data.selectifierScreenCol2}" placeholder=" " name="selectifierScreenCol2" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.selectifierScreenCol2Desc}" name="selectifierScreenCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <%-- 
						    <tr>
						    <td class="tg-yw4l" >#1 Selectifier screen North </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Gear seal </span>  <input type="text" class="input" value="${data.selectifierScreenCol3}" placeholder=" " name="selectifierScreenCol3" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.selectifierScreenCol3Desc}" name="selectifierScreenCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >#1 Selectifier screen North Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> West:<input type="text" class="input" value="${data.selectifierScreenCol4Inbound}" placeholder="" name="selectifierScreenCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  East:<input type="text" class="input" value="${data.selectifierScreenCol4Outbound}" placeholder=" " name="selectifierScreenCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.selectifierScreenCol4Desc}" name="selectifierScreenCol4Desc" placeholder="Remarks" style="float: right;"/>
						    	 
						    </td>
						    
						  </tr> 
						  
						  <%-- 
						    <tr>
						    <td class="tg-yw4l" >#2 Selectifier screen South</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 41px"> Gear seal </span>  <input type="text" class="input" value="${data.selectifierScreenCol5}" placeholder=" " name="selectifierScreenCol5" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.selectifierScreenCol5Desc}" name="selectifierScreenCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  <tr>
						    <td class="tg-yw4l"  >#2 Selectifier screen South Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> West:<input type="text" class="input" value="${data.selectifierScreenCol6Inbound}" placeholder="" name="selectifierScreenCol6Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  East:<input type="text" class="input" value="${data.selectifierScreenCol6Outbound}" placeholder=" " name="selectifierScreenCol6Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.selectifierScreenCol6Desc}" name="selectifierScreenCol6Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	
						    	 
						    	 
						    </td>
						    
						  </tr> 
						  
						  
						 <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Selectifier Lube System </h2></td>
						   
						  </tr>
						
						
						
						<!-- <tr>
						    <td class="tg-yw4l"  >Lube oil area</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;"> -->
						    	
						    	
						    	
						    	<tr>
								    <td class="tg-yw4l" >Lube oil area </td>
								    <td class="tg-yw4l" style="text-align: center;">
								        
								    	  <span style="margin-right: 6px"> Leakage </span>   <input type="text" class="input" value="${data.selectifierScreenCol7}" placeholder=" " name="selectifierScreenCol7" style="margin-left: 1px !important;float: none;"/>
								    	
									     <input type="text" class="input" value="${data.selectifierScreenCol7Desc}" name="selectifierScreenCol7Desc" placeholder="Remarks" style="float: right;"/>
								    </td>
								    
								  </tr>
						    	
						    	
						    	
						    	<%--   <span>Leakage</span> 
						    	<input type="radio" value="true" ${data.selectifierScreenCol7 == 'true' ? 'checked' : ''} name="selectifierScreenCol7"/> Yes  
						    	<input type="radio" value="false" ${data.selectifierScreenCol7 == 'false' ? '' : ''} name="selectifierScreenCol7"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.selectifierScreenCol7Desc}" class="input" name="selectifierScreenCol7Desc" placeholder="Remarks" style="float: right;"/>  </td>
						     
						    
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >#1 Lube pump North</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	  <span>Abnormal Sound</span> 
						    	<input type="radio" value="true" ${data.selectifierScreenCol8 == 'true' ? 'checked' : ''} name="selectifierScreenCol8"/> Yes  
						    	<input type="radio" value="false" ${data.selectifierScreenCol8 == 'false' ? '' : ''} name="selectifierScreenCol8"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.selectifierScreenCol8Desc}" class="input" name="selectifierScreenCol8Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						 
						 
						 
						  <tr>
						    <td class="tg-yw4l"  >#1 Lube pump North Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    		<span style="margin-right: 56px;"> Temperature   </span> North:<input type="text" class="input" value="${data.selectifierScreenCol9Inbound}" placeholder="" name="selectifierScreenCol9Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 	 South:<input type="text" class="input" value="${data.selectifierScreenCol9Outbound}" placeholder=" " name="selectifierScreenCol9Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 	<input type="text"class="input" value="${data.selectifierScreenCol9Desc}" name="selectifierScreenCol9Desc" placeholder="Remarks" style="float: right;"/>
						    	 
						    	 
						    </td>
						    
						  </tr> 	 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >#1 Lube pump South</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	  <span>Abnormal Sound</span> 
						    	<input type="radio" value="true" ${data.selectifierScreenCol10 == 'true' ? 'checked' : ''} name="selectifierScreenCol10"/> Yes  
						    	<input type="radio" value="false" ${data.selectifierScreenCol10 == 'false' ? '' : ''} name="selectifierScreenCol10"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.selectifierScreenCol10Desc}" class="input" name="selectifierScreenCol10Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l"  >#2 Lube pump South Motor</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    		<span style="margin-right: 56px;"> Temperature   </span> North:<input type="text" class="input" value="${data.selectifierScreenCol11Inbound}" placeholder="" name="selectifierScreenCol11Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 	 South:<input type="text" class="input" value="${data.selectifierScreenCol11Outbound}" placeholder=" " name="selectifierScreenCol11Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 	<input type="text"class="input" value="${data.selectifierScreenCol11Desc}" name="selectifierScreenCol11Desc" placeholder="Remarks" style="float: right;"/>
						    	  
						    </td>
						    
						  </tr> 	 
						 
						  
						    --%>
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Vacuum pumps </h2></td>
						   
						  </tr>
						 
						 <%-- 
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump motor 100 Hp</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.vacumePumpCol1 == 'true' ? 'checked' : ''} name="vacumePumpCol1"/> Yes  
						    	<input type="radio" value="false" ${data.vacumePumpCol1 == 'false' ? '' : ''} name="vacumePumpCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.vacumePumpCol1Desc}" class="input" name="vacumePumpCol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Vacuum pump motor 100 Hp</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.vacumePumpCol2 == 'true' ? 'checked' : ''} name="vacumePumpCol2"/> Yes  
						    	<input type="radio" value="false" ${data.vacumePumpCol2 == 'false' ? '' : ''} name="vacumePumpCol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.vacumePumpCol2Desc}" class="input" name="vacumePumpCol2Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						   --%>
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#8 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol3 == 'true' ? 'checked' : ''} name="vacumePumpCol3"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol3 == 'false' ? '' : ''} name="vacumePumpCol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	  
							     <input type="text" class="input" value="${data.vacumePumpCol3Desc}" name="vacumePumpCol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#8 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
					    	     <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.vacumePumpCol4Inbound}" placeholder="" name="vacumePumpCol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
					   		 	 Outbound:<input type="text" class="input" value="${data.vacumePumpCol4Outbound}" placeholder=" " name="vacumePumpCol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
					   		 	<input type="text"class="input" value="${data.vacumePumpCol4Desc}" name="vacumePumpCol4Desc" placeholder="Remarks" style="float: right;"/>
						    	 
						    	 
						    	 
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#8 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	     <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.vacumePumpCol5Inbound}" placeholder="" name="vacumePumpCol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 	 Outbound:<input type="text" class="input" value="${data.vacumePumpCol5Outbound}" placeholder=" " name="vacumePumpCol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 	<input type="text"class="input" value="${data.vacumePumpCol5Desc}" name="vacumePumpCol5Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	
						    </td>
						    
						  </tr> 
						  <%-- 
						  
						    <tr>
						    <td class="tg-yw4l"  >Vacuum pump motor 1500 Hp</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.vacumePumpCol6 == 'true' ? 'checked' : ''} name="vacumePumpCol6"/> Yes  
						    	<input type="radio" value="false" ${data.vacumePumpCol6 == 'false' ? '' : ''} name="vacumePumpCol6"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.vacumePumpCol6Desc}" class="input" name="vacumePumpCol6Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						   --%>
						  
						  <tr>
						    <td class="tg-yw4l"  >Vacuum pump motor 1500 Hp</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> North:<input type="text" class="input" value="${data.vacumePumpCol7Inbound}" placeholder="" name="vacumePumpCol7Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
					   		 	 South:<input type="text" class="input" value="${data.vacumePumpCol7Outbound}" placeholder=" " name="vacumePumpCol7Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
					   		 	<input type="text"class="input" value="${data.vacumePumpCol7Desc}" name="vacumePumpCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr> 
						  
						  <tr>
						    <td class="tg-yw4l" >Vacuum pump#2 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span>  
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol8 == 'true' ? 'checked' : ''} name="vacumePumpCol8"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol8 == 'false' ? '' : ''} name="vacumePumpCol8"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	 
						    	
							     <input type="text" class="input" value="${data.vacumePumpCol8Desc}" name="vacumePumpCol8Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >Vacuum pump#02 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol9}" placeholder="" name="vacumePumpCol9" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   
						    	<input type="text" value="${data.vacumePumpCol9Desc}" class="input" name="vacumePumpCol9Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#02 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol10}" placeholder="" name="vacumePumpCol10" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	  
						    	<input type="text" value="${data.vacumePumpCol10Desc}" class="input" name="vacumePumpCol10Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#3 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol11 == 'true' ? 'checked' : ''} name="vacumePumpCol11"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol11 == 'false' ? '' : ''} name="vacumePumpCol11"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	  
						    	   
						    	
							     <input type="text" class="input" value="${data.vacumePumpCol11Desc}" name="vacumePumpCol11Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Vacuum pump#03 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol12}" placeholder="" name="vacumePumpCol12" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	
						    	  
						    	<input type="text" value="${data.vacumePumpCol12Desc}" class="input" name="vacumePumpCol12Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr> 
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#03 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol13}" placeholder="" name="vacumePumpCol13" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						    	
						    	<input type="text" value="${data.vacumePumpCol13Desc}" class="input" name="vacumePumpCol13Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr>
						  
						  <%-- 
						  <tr>
						    <td class="tg-yw4l"  >Vacuum pump motor 1750 Hp</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 
						    	<input type="radio" value="true" ${data.vacumePumpCol14 == 'true' ? 'checked' : ''} name="vacumePumpCol14"/> Yes  
						    	<input type="radio" value="false" ${data.vacumePumpCol14 == 'false' ? '' : ''} name="vacumePumpCol14"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.vacumePumpCol14Desc}" class="input" name="vacumePumpCol14Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						   --%>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump motor 1750 Hp</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> North:<input type="text" class="input" value="${data.vacumePumpCol15Inbound}" placeholder="" name="vacumePumpCol15Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
					   		 	 South:<input type="text" class="input" value="${data.vacumePumpCol15Outbound}" placeholder=" " name="vacumePumpCol15Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
					   		 	<input type="text"class="input" value="${data.vacumePumpCol15Desc}" name="vacumePumpCol15Desc" placeholder="Remarks" style="float: right;"/>
						    	
						    	 
						    	 
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#11 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol16 == 'true' ? 'checked' : ''} name="vacumePumpCol16"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol16 == 'false' ? '' : ''} name="vacumePumpCol16"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	 
							     <input type="text" class="input" value="${data.vacumePumpCol16Desc}" name="vacumePumpCol16Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#011 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol17}" placeholder="" name="vacumePumpCol17" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	<input type="text" value="${data.vacumePumpCol17Desc}" class="input" name="vacumePumpCol17Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#011 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol18}" placeholder="" name="vacumePumpCol18" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						    	 <input type="text" value="${data.vacumePumpCol18Desc}" class="input" name="vacumePumpCol18Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr>
						  
						 
						  
						    <tr>
						    <td class="tg-yw4l" >Vacuum pump#12 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol19 == 'true' ? 'checked' : ''} name="vacumePumpCol19"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol19 == 'false' ? '' : ''} name="vacumePumpCol19"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						     	
							     <input type="text" class="input" value="${data.vacumePumpCol19Desc}" name="vacumePumpCol19Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#012 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol20}" placeholder="" name="vacumePumpCol20" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						    	 
						    	<input type="text" value="${data.vacumePumpCol20Desc}" class="input" name="vacumePumpCol20Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#012 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol21}" placeholder="" name="vacumePumpCol21" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						    	 <input type="text" value="${data.vacumePumpCol21Desc}" class="input" name="vacumePumpCol21Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#13 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span>  
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol22 == 'true' ? 'checked' : ''} name="vacumePumpCol22"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol22 == 'false' ? '' : ''} name="vacumePumpCol22"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	  
						     	
							     <input type="text" class="input" value="${data.vacumePumpCol22Desc}" name="vacumePumpCol22Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#013 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol23}" placeholder="" name="vacumePumpCol23" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.vacumePumpCol23Desc}" class="input" name="vacumePumpCol23Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#013 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol24}" placeholder="" name="vacumePumpCol24" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.vacumePumpCol24Desc}" class="input" name="vacumePumpCol24Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#14 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol25 == 'true' ? 'checked' : ''} name="vacumePumpCol25"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol25 == 'false' ? '' : ''} name="vacumePumpCol25"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	  
						    	
							     <input type="text" class="input" value="${data.vacumePumpCol25Desc}" name="vacumePumpCol25Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#014 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	  <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol26}" placeholder="" name="vacumePumpCol26" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						    	  <input type="text" value="${data.vacumePumpCol26Desc}" class="input" name="vacumePumpCol26Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#014 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol27}" placeholder="" name="vacumePumpCol27" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.vacumePumpCol27Desc}" class="input" name="vacumePumpCol27Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" >Vacuum pump#15 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span>  
						    	  
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol28 == 'true' ? 'checked' : ''} name="vacumePumpCol28"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol28 == 'false' ? '' : ''} name="vacumePumpCol28"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	 
						    	
							     <input type="text" class="input" value="${data.vacumePumpCol28Desc}" name="vacumePumpCol28Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#015 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol29}" placeholder="" name="vacumePumpCol29" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						        <input type="text" value="${data.vacumePumpCol29Desc}" class="input" name="vacumePumpCol29Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#015 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol30}" placeholder="" name="vacumePumpCol30" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 <input type="text" value="${data.vacumePumpCol30Desc}" class="input" name="vacumePumpCol30Desc" placeholder="Remarks" style="float: right;"/>  
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#16 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol31 == 'true' ? 'checked' : ''} name="vacumePumpCol31"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol31 == 'false' ? '' : ''} name="vacumePumpCol31"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	   
						    	
							     <input type="text" class="input" value="${data.vacumePumpCol31Desc}" name="vacumePumpCol31Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#016 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol32}" placeholder="" name="vacumePumpCol32" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						        <input type="text" value="${data.vacumePumpCol32Desc}" class="input" name="vacumePumpCol32Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#016 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	 <span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol33}" placeholder="" name="vacumePumpCol33" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	 
						    	 
						    	<input type="text" value="${data.vacumePumpCol33Desc}" class="input" name="vacumePumpCol33Desc" placeholder="Remarks" style="float: right;"/> 
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Vacuum pump#17 </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  <span style="margin-right: 6px"> Seal water flooding </span> 
						    	  
						    	  <input type="radio" value="true" ${data.vacumePumpCol34 == 'true' ? 'checked' : ''} name="vacumePumpCol34"/> Yes  
						    	  <input type="radio" value="false" ${data.vacumePumpCol34 == 'false' ? '' : ''} name="vacumePumpCol34"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	    
						    	
							     <input type="text" class="input" value="${data.vacumePumpCol34Desc}" name="vacumePumpCol34Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#017 bearing (North)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol35}" placeholder="" name="vacumePumpCol35" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	<input type="text" value="${data.vacumePumpCol35Desc}" class="input" name="vacumePumpCol35Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Vacuum pump#017 bearing (South)</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	<span style="margin-right: 56px;"> Temperature   </span> <input type="text" class="input" value="${data.vacumePumpCol36}" placeholder="" name="vacumePumpCol36" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						    	<input type="text" value="${data.vacumePumpCol36Desc}" class="input" name="vacumePumpCol36Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr>
						  
						   
						  
						 
						 
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>River Water Seal System </h2></td>
						   
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >River water strainer  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">IN</span>  <input type="text"  value="${data.riverWaterCol1}" placeholder=" " name="riverWaterCol1" style="margin-left: 1px !important;float: none;"/>
						    	<span style="margin-right: 49px">OUT</span>  <input type="text" value="${data.riverWaterCol1Out}" placeholder=" " name="riverWaterCol1Out" style="margin-left: 1px !important;float: none;"/>
						    	<input type="text" class="input" value="${data.riverWaterCol1Desc}" name="riverWaterCol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" >River water filter </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">IN</span>  <input type="text"  value="${data.riverWaterCol2}" placeholder=" " name="riverWaterCol2" style="margin-left: 1px !important;float: none;"/>
						    	<span style="margin-right: 49px">OUT</span>  <input type="text"  value="${data.riverWaterCol2Out}" placeholder=" " name="riverWaterCol2Out" style="margin-left: 1px !important;float: none;"/>
						    	
							     <input type="text" class="input" value="${data.riverWaterCol2Desc}" name="riverWaterCol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Shower Water System </h2></td>
						   
						  </tr>
						  <%-- 
						 <tr>
						    <td class="tg-yw4l"  >#2 Fresh Water booster pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	  <span>Abnormal Sound</span> 
						    	<input type="radio" value="true" ${data.showercol1 == 'true' ? 'checked' : ''} name="showercol1"/> Yes  
						    	<input type="radio" value="false" ${data.showercol1 == 'false' ? '' : ''} name="showercol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showercol1Desc}" class="input" name="showercol1Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						   --%>
						  
						  <tr>
						    <td class="tg-yw4l" >#2 Fresh Water booster pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">  Temparature </span> North: <input type="text" class="input" value="${data.showercol2North}" placeholder=" " name="showercol2North" style="margin-left: 1px !important;float: none;width: 81px !important;"/>
						    	   South: <input type="text" class="input" value="${data.showercol2South}" placeholder=" " name="showercol2South" style="margin-left: 1px !important;float: none;width: 81px !important;"/>
						    	
							     <input type="text" class="input" value="${data.showercol2Desc}" name="showercol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <%-- 
						   <tr>
						    <td class="tg-yw4l"  >#3 Fresh Water booster pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	  <span>Abnormal Sound</span> 
						    	<input type="radio" value="true" ${data.showercol3 == 'true' ? 'checked' : ''} name="showercol3"/> Yes  
						    	<input type="radio" value="false" ${data.showercol3 == 'false' ? '' : ''} name="showercol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showercol3Desc}" class="input" name="showercol3Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						   --%>
						   <tr>
						    <td class="tg-yw4l" >#3 Fresh Water booster pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">  Temparature </span> North: <input type="text" class="input" value="${data.showercol4North}" placeholder=" " name="showercol4North" style="margin-left: 1px !important;float: none;width: 81px !important;"/>
						    	   South: <input type="text" class="input" value="${data.showercol4South}" placeholder=" " name="showercol4South" style="margin-left: 1px !important;float: none;width: 81px !important;"/>
						    	
							     <input type="text" class="input" value="${data.showercol4Desc}" name="showercol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <%-- 
						    <tr>
						    <td class="tg-yw4l"  >HP Shower Pump</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	  <span>Abnormal Sound</span> 
						    	<input type="radio" value="true" ${data.showercol5 == 'true' ? 'checked' : ''} name="showercol5"/> Yes  
						    	<input type="radio" value="false" ${data.showercol5 == 'false' ? '' : ''} name="showercol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.showercol5Desc}" class="input" name="showercol5Desc" placeholder="Remarks" style="float: right;"/>  </td>
						    </td>
						    
						  </tr> 
						   --%>
						  
						    <tr>
						    <td class="tg-yw4l" >HP Shower Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	 <span style="margin-right: 49px">  Temparature </span> West: <input type="text" class="input" value="${data.showercol6North}" placeholder=" " name="showercol6North" style="margin-left: 1px !important;float: none;width: 81px !important;"/>
						    	   East: <input type="text" class="input" value="${data.showercol6South}" placeholder=" " name="showercol6South" style="margin-left: 1px !important;float: none;width: 81px !important;"/>
						    	
							     <input type="text" class="input" value="${data.showercol6Desc}" name="showercol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						    <tr>
						    <td class="tg-yw4l" >HP Shower pump filter</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<span style="margin-right: 49px">IN</span> <input type="text"  value="${data.showercol7}" placeholder=" " name="showercol7" style="margin-left: 1px !important;float: none;"/>
						    	  <span style="margin-right: 49px">OUT</span> <input type="text" value="${data.showercol7Out}" placeholder=" " name="showercol7Out" style="margin-left: 1px !important;float: none;"/>
						    	   <input type="text" class="input" value="${data.showercol7Desc}" name="showercol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						</c:if> 						
						
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);height: 16px;"><h2></h2></td>
						     
				    	</tr> 
				    	
				    	 <tr>
						    <td class="tg-yw4l" >Fill out Centerline sheets</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	   
						    	  Every Shift :<input type="radio" value="true" ${data.fillupcentcol1 == 'true' ? 'checked' : ''} name="fillupcentcol1"/> Yes  
						    	  <input type="radio" value="false" ${data.fillupcentcol1 == 'false' ? '' : ''} name="fillupcentcol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	   
						    	 
						    	
							     <input type="text" class="input" value="${data.fillupcentcol1Desc}" name="fillupcentcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >Logbook update with M/c adjustments and process <br/> changes during the shift</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	   Every Shift :<input type="radio" value="true" ${data.fillupcentcol2 == 'true' ? 'checked' : ''} name="fillupcentcol2"/> Yes  
						    	  <input type="radio" value="false" ${data.fillupcentcol2 == 'false' ? '' : ''} name="fillupcentcol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	   
						    	
							     <input type="text" class="input" value="${data.fillupcentcol2Desc}" name="fillupcentcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Wash M/c floors from the of after dryers to refiners</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	    Every Shift :<input type="radio" value="true" ${data.fillupcentcol3 == 'true' ? 'checked' : ''} name="fillupcentcol3"/> Yes  
						    	  <input type="radio" value="false" ${data.fillupcentcol3 == 'false' ? '' : ''} name="fillupcentcol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	   
						    	
							     <input type="text" class="input" value="${data.fillupcentcol3Desc}" name="fillupcentcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						   --%>
						  
						   <tr>
						    <td class="tg-yw4l" >Clean control room</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	  Every Shift :<input type="radio" value="true" ${data.fillupcentcol4 == 'true' ? 'checked' : ''} name="fillupcentcol4"/> Yes  
						    	  <input type="radio" value="false" ${data.fillupcentcol4 == 'false' ? '' : ''} name="fillupcentcol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	   
						    	
							     <input type="text" class="input" value="${data.fillupcentcol4Desc}" name="fillupcentcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						   <c:if test="${data.shift == 'day'}"> 
						   <tr>
						    <td class="tg-yw4l" >Sprayboom changing</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        <input type="radio" value="true" ${data.fillupcentcol3 == 'true' ? 'checked' : ''} name="fillupcentcol3"/> Yes  
						    	 <input type="radio" value="false" ${data.fillupcentcol3 == 'false' ? '' : ''} name="fillupcentcol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	  <input type="text" class="input" value="${data.fillupcentcol5Desc}" name="fillupcentcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
				    <%-- 
				     	<tr>
						    <td class="tg-yw4l" >Emergency Alarm Test</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	   <input type="text" class="input" value="${data.fillupcentcol6}" placeholder=" " name="fillupcentcol6" style="margin-left: 1px !important;float: none;"/>
						    	   
						    	
							     <input type="text" class="input" value="${data.fillupcentcol6Desc}" name="fillupcentcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Combustion air filters cleaning</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	   <input type="text" class="input" value="${data.fillupcentcol7}" placeholder=" " name="fillupcentcol7" style="margin-left: 1px !important;float: none;"/>
						    	   
						    	
							     <input type="text" class="input" value="${data.fillupcentcol7Desc}" name="fillupcentcol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						  <!-- Code Starts From Here Done By Roshan Tailor -->
						  <tr>
						    <td class="tg-yw4l" >Check Air Filter For Head Box</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.checkairfilterforheadbox == 'true' ? 'checked' : ''} name="checkairfilterforheadbox"/> Yes 
						   		 <input type="radio" value="false" name="checkairfilterforheadbox" ${data.checkairfilterforheadbox == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.checkairfilterforheadboxremark}" name="checkairfilterforheadboxremark" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Blow Wet end and Dry End Motor:</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.blowwetendanddryendmotor == 'true' ? 'checked' : ''} name="blowwetendanddryendmotor"/> Yes 
						   		 <input type="radio" value="false" name="blowwetendanddryendmotor" ${data.blowwetendanddryendmotor == 'false' ? '' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.blowwetendanddryendmotorremark}" name="blowwetendanddryendmotorremark" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						  </tr>
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Headbox Air Filters Cleaning:</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	Every Shift :<input type="radio" value="true" ${data.headboxairfilterscleaning == 'true' ? 'checked' : ''} name="headboxairfilterscleaning"/> Yes  
						    	<input type="radio" value="false" ${data.headboxairfilterscleaning == 'false' ? '' : ''} name="headboxairfilterscleaning"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" class="input" value="${data.headboxairfilterscleaningdesc}" name="headboxairfilterscleaningdesc" placeholder="Remarks" style="float: right;"/>
						    </td>
						  </tr>
						  <!-- Code Ends Here Done By Roshan Tailor -->
						   --%>
						  
						  
						  </c:if>
						  
						   
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