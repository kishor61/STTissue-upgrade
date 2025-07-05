<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/operatorCareCheckListPM5/checkObcc" var="checkURL" />
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<script type="text/javascript">
$(function(){
	 $('input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true,
		    minDate:0,
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
					alert("Data Enter Alredy");
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
<body>

<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
</div>


	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
		
		 
		
		 
			<spring:url value="/utilityOperatorpm5/save" var="viewURL"/>
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Basic Care CheckList For PM5</span>
				</div>
				<div class="table-selector">
					
				
					
					
			 <input type="hidden" name="id" value="${data.id}"> 
	
					<table style="margin: auto;">
						<tr>
							<td> Position:</td>
							 <td>
								 <select style="width: 100%;" name="position" id="operator">
								    <option value="-1">Select Operator</option>
								 	<option value="leadoperator" ${data.position == 'leadoperator' ? 'selected' : ''}>LeadOperator</option>
								 	<option value="stockoperator" ${data.position == 'stockoperator' ? 'selected' : ''}>Stock Operator</option>								 	
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
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WRAPPER - WULFTEC NORTH</h2></td>
						     
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" > TOWER </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.wrapperFoxCol1 == 'true' ? 'checked' : ''} name="wrapperFoxCol1"/> Yes 
						   		 <input type="radio" value="false" name="wrapperFoxCol1" ${data.wrapperFoxCol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.wrapperFoxCol1Desc}" name="wrapperFoxCol1Desc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						    
						  </tr>
						  
						  
						 <tr>
						    <td class="tg-yw4l" > STRETCH WRAP DRIVE ASSEMBLY </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.wrapperFoxCol2 == 'true' ? 'checked' : ''} name="wrapperFoxCol2"/> Yes 
						   		 <input type="radio" value="false" name="wrapperFoxCol2" ${data.wrapperFoxCol2 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.wrapperFoxCol2Desc}" name="wrapperFoxCol2Desc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >CONTROL PANEL</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.wrapperFoxCol3 == 'true' ? 'checked' : ''} name="wrapperFoxCol3"/> Yes 
						     <input type="radio" value="false" ${data.wrapperFoxCol2 == 'false' ? 'checked' : ''} name="wrapperFoxCol3"/>No   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" class="input" value="${data.wrapperFoxCol3Desc}" name="wrapperFoxCol3Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Motor - Overheating</td>
						    <td class="tg-yw4l" style="text-align: center;">
						     <input type="radio" value="true" ${data.wrapperFoxCol4 == 'true' ? 'checked' : ''} name="wrapperFoxCol4"/>Yes 
						     <input type="radio" value="false"  ${data.wrapperFoxCol4 == 'false' ? 'checked' : ''} name="wrapperFoxCol4"/>No    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						     <input type="text" value="${data.wrapperFoxCol4Desc}"  class="input"name="wrapperFoxCol4Desc" placeholder="Remarks" style="margin-left: 66px;"/> 
						    </td>
						    
						  </tr>
						  
						    <tr>
						    <td class="tg-yw4l" >Motor - Abnormal Sound</td>
						       
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.wrapperFoxCol5 == 'true' ? 'checked' : ''} name="wrapperFoxCol5"/>Yes 
						    <input type="radio" value="false"  ${data.wrapperFoxCol5 == 'false' ? 'checked' : ''} name="wrapperFoxCol5"/>No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" value="${data.wrapperFoxCol5Desc}"  class="input"name="wrapperFoxCol5Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						     
						  </tr>
						 
						 
						   
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WRAPPER - WULFTEC SOUTH</h2></td>
						   
						  </tr>
						  <tr>
						    <td class="tg-yw4l"  >TOWER</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<input type="radio" value="true" ${data.wrapperWuftechCol1 == 'true' ? 'checked' : ''} name="wrapperWuftechCol1"/> Yes  
						    	<input type="radio" value="false" ${data.wrapperWuftechCol1 == 'false' ? 'checked' : ''} name="wrapperWuftechCol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.wrapperWuftechCol1Desc}" class="input" name="wrapperWuftechCol1Desc" placeholder="Remarks" style="margin-left: 58px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >STRETCH WRAP DRIVE ASSEMBLY</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.wrapperWuftechCol2 == 'true' ? 'checked' : ''} name="wrapperWuftechCol2"/> Yes
						    	<input type="radio" value="false" ${data.wrapperWuftechCol2 == 'false' ? 'checked' : ''} name="wrapperWuftechCol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.wrapperWuftechCol2Desc}" class="input" name="wrapperWuftechCol2Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l">CONTROL PANEL</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.wrapperWuftechCol3 == 'true' ? 'checked' : ''} name="wrapperWuftechCol3"/> Yes
						    	<input type="radio" value="false" ${data.wrapperWuftechCol3 == 'false' ? 'checked' : ''} name="wrapperWuftechCol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.wrapperWuftechCol3Desc}"  class="input" name="wrapperWuftechCol3Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Motor - Overheating</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.wrapperWuftechCol4 == 'true' ? 'checked' : ''} name="wrapperWuftechCol4"/> Yes
						    	<input type="radio" value="false" ${data.wrapperWuftechCol4 == 'false' ? 'checked' : ''} name="wrapperWuftechCol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.wrapperWuftechCol4Desc}" class="input" name="wrapperWuftechCol4Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >Motor - Abnormal Sound</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.wrapperWuftechCol5 == 'true' ? 'checked' : ''} name="wrapperWuftechCol5"/> Yes
						    	<input type="radio" value="false" ${data.wrapperWuftechCol5 == 'false' ? 'checked' : ''} name="wrapperWuftechCol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.wrapperWuftechCol5Desc}" class="input" name="wrapperWuftechCol5Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l"  >TURN TABLE </td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.wrapperWuftechCol6 == 'true' ? 'checked' : ''} name="wrapperWuftechCol6"/> Yes
						    	<input type="radio" value="false" ${data.wrapperWuftechCol6 == 'false' ? 'checked' : ''} name="wrapperWuftechCol6"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.wrapperWuftechCol6Desc}" class="input" name="wrapperWuftechCol6Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						   	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>SCALE</h2></td>
						   
						  </tr>
						   
						   <tr>
						    <td class="tg-yw4l" >CONTROL PANEL</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.scaleCol1 == 'true' ? 'checked' : ''} name="scaleCol1"/> Yes
						   <input type="radio" value="false" ${data.scaleCol1 == 'false' ? 'checked' : ''} name="scaleCol1"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.scaleCol1Desc}" class="input" name="scaleCol1Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >SCALE PLATFORM</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.scaleCol2 == 'true' ? 'checked' : ''} name="scaleCol2"/> Yes
						   <input type="radio" value="false" ${data.scaleCol2 == 'false' ? 'checked' : ''} name="scaleCol2"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.scaleCol2Desc}" class="input" name="scaleCol2Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >AUTOMATIC WEIGHT INPUT</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.scaleCol3 == 'true' ? 'checked' : ''} name="scaleCol3"/> Yes
						   <input type="radio" value="false" ${data.scaleCol3 == 'false' ? 'checked' : ''} name="scaleCol3"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.scaleCol3Desc}" class="input" name="scaleCol3Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  
						   <tr>
						    <td class="tg-yw4l" >WEIGHT VERIFIED</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.scaleCol4 == 'true' ? 'checked' : ''} name="scaleCol4"/> Yes
						   <input type="radio" value="false" ${data.scaleCol4 == 'false' ? 'checked' : ''} name="scaleCol4"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="text" value="${data.scaleCol4Desc}" class="input" name="scaleCol4Desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2></h2></td>
						   
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Clean Winder Are,Roll </br>Wrap Area And Roll Handling  Area</td>
						     <td class="tg-yw4l" style="text-align: center;">					        
						    	 <input type="text" class="input" value="${data.scaleCol5}" placeholder="" name="scaleCol5" style="margin-left: 1px !important;float: none;"/>
						    	 <input type="text" class="input" value="${data.scaleCol5Desc}" name="scaleCol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						     
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Clean Ramp And Loading Docks</td>
						   <td class="tg-yw4l" style="text-align: center;">						        
						    	 <input type="text" class="input" value="${data.scaleCol6}" placeholder="" name="scaleCol6" style="margin-left: 1px !important;float: none;"/>
						    	 <input type="text" class="input" value="${data.scaleCol6Desc}" name="scaleCol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						     
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Clean All Steps Leading Downstairs Or Loading Ramp</td>
						   <td class="tg-yw4l" style="text-align: center;">						        
						    	 <input type="text" class="input" value="${data.scaleCol7}" placeholder="" name="scaleCol7" style="margin-left: 1px !important;float: none;"/>
						    	 <input type="text" class="input" value="${data.scaleCol7Desc}" name="scaleCol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						     
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Empty Dryend Trash Cans</td>
						   <td class="tg-yw4l" style="text-align: center;">						        
						    	 <input type="text" class="input" value="${data.scaleCol8}" placeholder="" name="scaleCol8" style="margin-left: 1px !important;float: none;"/>
						    	 <input type="text" class="input" value="${data.scaleCol8Desc}" name="scaleCol8Desc" placeholder="Remarks" style="float: right;"/>
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
