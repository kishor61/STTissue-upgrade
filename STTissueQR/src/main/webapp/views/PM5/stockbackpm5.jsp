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
<script type="text/javascript">
$(function(){
	 $('input[name=edate]').datepicker({
	dateFormat:'mm-dd-yy',
	changeMonth: true,
    changeYear: true,
    maxDate:-1
}); 
	 function funDate(){
			alert("You Can't Change Datae If you Want to  Date Entry in Back Date Then  Press Back Date Entry")
			document.getElementById("edate").disabled=true;}

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
						location.href="./../r2operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'WinderDown')
					{
						location.href="./../winderdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'stockoperator')
					{
						location.href="./../stockoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'leadoperator')
					{
						location.href="./../leadoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'R1')
					{
						location.href="./../r1operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}
					else if(position == 'utilityoperator')
					{
						location.href="./../utilityOperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
					}							
					
				}else
				{
					var entry=confirm("Entry Already Available Do you Want to Edit  Click OK  Cencle it");
					if(entry==true){
						if(position == 'R2')
						{
							location.href="./../r2operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'WinderDown')
						{
							location.href="./../winderdown/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'stockoperator')
						{
							location.href="./../stockoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'leadoperator')
						{
							location.href="./../leadoperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'R1')
						{
							location.href="./../r1operatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
						}
						else if(position == 'utilityoperator')
						{
							location.href="./../utilityOperatorpm5/back?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew;
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
		 
		<c:if test="${data.position == 'stockoperator'}">	
			<spring:url value="/stockoperatorpm5/save" var="viewURL"/>
		</c:if>		
			
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
								<input type="text" name="edate" value="${data.edate}" id="edate"  onclick="funDate()">							
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
								<a href="../operatorCareCheckListPM5/checkObcc/back"><button  type="button"  class="btn btn-success btn-sm">Backdated Entry
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
			<h1 style="font-size: 21px;color:#f5070b; stext-align: center;">Machine Down
									  	
									    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
									    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</h1>
					 	
					 <table border="1" class="tg" style="background-color: white;width: 1122px;width:70%" id="tbbl">
						
						
						<tr style="text-align: center;background-color:#2189b9 !important;" >
						    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
						    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
						   
						</tr> 
						<c:if test="${data.shift == 'day'}"> 	
					
				    	<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Fiber Supply Tank</h2></td>
						     
						</tr> 
						 
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >% Of Pull To Machine</td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.fibersupplytankcol1}" placeholder="" name="fibersupplytankcol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.fibersupplytankcol1Desc}" name="fibersupplytankcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  	 --%>					   
						   <tr>
						    <td class="tg-yw4l" >Supply Tank Level </td>
						    <td class="tg-yw4l" style="text-align: center;">						    
						   		  <input type="text" class="input" value="${data.fibersupplytankcol2}" placeholder="" name="fibersupplytankcol2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.fibersupplytankcol2Desc}" name="fibersupplytankcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Supply Tank  Agitator</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.fibersupplytankcol3== 'true' ? 'checked' : ''} name="fibersupplytankcol3"/> Yes  
						    	<input type="radio" value="false" ${data.fibersupplytankcol3== 'false' ? 'checked' : ''} name="fibersupplytankcol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.fibersupplytankcol3Desc}" name="fibersupplytankcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Supply Tank Agitator Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.fibersupplytankcol4Inbound}" placeholder="" name="fibersupplytankcol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.fibersupplytankcol4Outbound}" placeholder=" " name="fibersupplytankcol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.fibersupplytankcol4Desc}" name="fibersupplytankcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>						  
						   <tr>
						    <td class="tg-yw4l" >Supply Tank Feed Pump Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.fibersupplytankcol5Inbound}" placeholder="" name="fibersupplytankcol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.fibersupplytankcol4Outbound}" placeholder=" " name="fibersupplytankcol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.fibersupplytankcol5Desc}" name="fibersupplytankcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>						  
						  <tr>
						    <td class="tg-yw4l" >Supply Tank Feed Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	 <span> No Abnormal Sound</span>
						        <input type="radio" value="true" ${data.fibersupplytankcol6== 'true' ? 'checked' : ''} name="fibersupplytankcol6"/> Yes  
						    	<input type="radio" value="false" ${data.fibersupplytankcol6== 'false' ? 'checked' : ''} name="fibersupplytankcol6"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.fibersupplytankcol6Desc}" name="fibersupplytankcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						  
						  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Mix Chest</h2></td>
						     
						</tr> 
						<%-- 
						   <tr>
						    <td class="tg-yw4l" >Mix Chest Tank</td>
						    <td class="tg-yw4l" style="text-align: center;">						    
						   		  <input type="text" class="input" value="${data.mixchestcol1}" placeholder="" name="mixchestcol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.mixchestcol1Desc}" name="mixchestcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr> 
						   --%>
						   <tr>
						    <td class="tg-yw4l" >Mix Chest Pump Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.mixchestcol2Inbound}" placeholder="" name="mixchestcol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.mixchestcol2Outbound}" placeholder=" " name="mixchestcol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.mixchestcol2Desc}" name="mixchestcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>
						    
						 </tr>
						 <tr>
						    <td class="tg-yw4l" >Mix Chest Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.mixchestcol3== 'true' ? 'checked' : ''} name="mixchestcol3"/> Yes  
						    	<input type="radio" value="false" ${data.mixchestcol3== 'false' ? 'checked' : ''} name="mixchestcol3"/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.mixchestcol3Desc}" name="mixchestcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						 </tr>
						 <tr>
						    <td class="tg-yw4l" >Sweetner pump Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.mixchestcol5Inbound}" placeholder="" name="mixchestcol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.mixchestcol5Outbound}" placeholder=" " name="mixchestcol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.mixchestcol5Desc}" name="mixchestcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						 </tr>
						   <tr>
						    <td class="tg-yw4l" >Sweetner pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.mixchestcol4== 'true' ? 'checked' : ''} name="mixchestcol4"/> Yes  
						    	<input type="radio" value="false" ${data.mixchestcol4== 'false' ? 'checked' : ''} name="mixchestcol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.mixchestcol4Desc}" name="mixchestcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Blend Chest</h2></td>
						     
						</tr> 
							<%-- 					 					  
						   <tr>
						    <td class="tg-yw4l" >Blend Chest Tank</td>
						    <td class="tg-yw4l" style="text-align: center;">						    
						   		  <input type="text" class="input" value="${data.blendchestcol1}" placeholder="" name="blendchestcol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
								  <input type="text"class="input" value="${data.blendchestcol1Desc}" name="blendchestcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  	 --%>					   				  
						   <tr>
						    <td class="tg-yw4l" >Blend ches Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.blendchestcol3Inbound}" placeholder="" name="blendchestcol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.blendchestcol3Outbound}" placeholder=" " name="blendchestcol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.blendchestcol3Desc}" name="blendchestcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Blend chest Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.blendchestcol2== 'true' ? 'checked' : ''} name="blendchestcol2"/> Yes  
						    	<input type="radio" value="false" ${data.blendchestcol2== 'false' ? 'checked' : ''} name="blendchestcol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.blendchestcol2Desc}" name="blendchestcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Machine chest</h2></td>
						     
						</tr> 
						 <%-- 
						  
						   <tr>
						    <td class="tg-yw4l" >Machine Chest Level</td>
						    <td class="tg-yw4l" style="text-align: center;">						    
						   		  <input type="text" class="input" value="${data.machinechestcol1}" placeholder="" name="machinechestcol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  
						   		 <input type="text"class="input" value="${data.machinechestcol1Desc}" name="machinechestcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	 --%>				  
						    <tr>
						    <td class="tg-yw4l" >Machine chest Agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.machinechestcol3Inbound}" placeholder="" name="machinechestcol3Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.machinechestcol3Outbound}" placeholder=" " name="machinechestcol3Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.machinechestcol3Desc}" name="machinechestcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Machine chest Agitator </td>
						    <td class="tg-yw4l" style="text-align: center;">
						          <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.machinechestcol2== 'true' ? 'checked' : ''} name="machinechestcol2"/> Yes  
						    	<input type="radio" value="false" ${data.machinechestcol2== 'false' ? 'checked' : ''} name="machinechestcol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.machinechestcol2Desc}" name="machinechestcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>						  
						    <tr>
						    <td class="tg-yw4l" >Machine chest Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.machinechestcol5Inbound}" placeholder="" name="machinechestcol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.machinechestcol5Outbound}" placeholder=" " name="machinechestcol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.machinechestcol5Desc}" name="machinechestcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						<tr>
						    <td class="tg-yw4l" >Machine chest Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.machinechestcol4== 'true' ? 'checked' : ''} name="machinechestcol4"/> Yes  
						    	<input type="radio" value="false" ${data.machinechestcol4== 'false' ? 'checked' : ''} name="machinechestcol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.machinechestcol4Desc}" name="machinechestcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
								  
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Couch Pit</h2></td>
						     
						</tr> 
						  
						  
						   <tr>
						    <td class="tg-yw4l" >Couch pit Agitator West</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.couchpitcol1== 'true' ? 'checked' : ''} name="couchpitcol1"/> Yes  
						    	<input type="radio" value="false" ${data.couchpitcol1== 'false' ? 'checked' : ''} name="couchpitcol1"/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.couchpitcol1Desc}" name="couchpitcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >Couch pit Agitator West Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchpitcol2Inbound}" placeholder="" name="couchpitcol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchpitcol2Outbound}" placeholder=" " name="couchpitcol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchpitcol2Desc}" name="couchpitcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>						  
						   <tr>
						    <td class="tg-yw4l" >Couch pit Agitator East</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.couchpitcol3== 'true' ? 'checked' : ''} name="couchpitcol3"/> Yes  
						    	<input type="radio" value="false" ${data.couchpitcol3== 'false' ? 'checked' : ''} name="couchpitcol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.couchpitcol3Desc}" name="couchpitcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>					  
						   <tr>
						    <td class="tg-yw4l" >Couch pit Agitator East Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchpitcol4Inbound}" placeholder="" name="couchpitcol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchpitcol4Outbound}" placeholder=" " name="couchpitcol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchpitcol4Desc}" name="couchpitcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >Couch pit Pump Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.couchpitcol5Inbound}" placeholder="" name="couchpitcol5Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.couchpitcol5Outbound}" placeholder=" " name="couchpitcol5Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.couchpitcol5Desc}" name="couchpitcol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>					  
						   <tr>
						    <td class="tg-yw4l"> Couch pit Pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						        <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.couchpitcol6== 'true' ? 'checked' : ''} name="couchpitcol6"/> Yes  
						    	<input type="radio" value="false" ${data.couchpitcol6== 'false' ? 'checked' : ''} name="couchpitcol6"/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.couchpitcol6Desc}" name="couchpitcol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  
						 <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2></h2></td>
						 </tr> 
						 
						    <td class="tg-yw4l">Clean Scanner Head </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.cleanscannerheadcol1== 'true' ? 'checked' : ''} name="cleanscannerheadcol1"/> Yes  
						    	<input type="radio" value="false" ${data.cleanscannerheadcol1== 'false' ? 'checked' : ''} name="cleanscannerheadcol1 "/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.cleanscannerheadcol1Desc}" name="cleanscannerheadcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr> 
						  
						  <tr>
						    <td class="tg-yw4l">Spool Starter Working Properly </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.spoolstarterworkingproperlycol1== 'true' ? 'checked' : ''} name="spoolstarterworkingproperlycol1"/> Yes  
						    	<input type="radio" value="false" ${data.spoolstarterworkingproperlycol1== 'false' ? 'checked' : ''} name="spoolstarterworkingproperlycol1"/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.spoolstarterworkingproperlycol1Desc}" name="spoolstarterworkingproperlycol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr> 
						  <%-- 
						  <tr>
						    <td class="tg-yw4l">Beak Pass Acceptable </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.beakpassacceptablecol1== 'true' ? 'checked' : ''} name="beakpassacceptablecol1"/> Yes  
						    	<input type="radio" value="false" ${data.beakpassacceptablecol1== 'false' ? 'checked' : ''} name="beakpassacceptablecol1"/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.beakpassacceptablecol1Desc}" name="beakpassacceptablecol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>  
						  --%>					  				  
						 </c:if>
						 
						 <c:if test="${data.shift == 'night'}">						   	
						
						<tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Refining:</h2></td>
						</tr>
						<tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Refiner 1# </h2></td>
						</tr>  
						  <tr>
						    <td class="tg-yw4l" >Refiner Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.refiner1col1== 'true' ? 'checked' : ''} name="refiner1col1"/> Yes  
						    	<input type="radio" value="false" ${data.refiner1col1== 'false' ? 'checked' : ''} name="refiner1col1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.refiner1col1Desc}" name="refiner1col1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Refiner load /unload Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.refiner1col2Inbound}" placeholder="" name="refiner1col2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.refiner1col2Outbound}" placeholder=" " name="refiner1col2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.refiner1col2Desc}" name="refiner1col2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >Oil level </td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.refiner1col3}" placeholder="" name="refiner1col3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.refiner1col3Desc}" name="refiner1col3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Seal Water</td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.refiner1col4}" placeholder="" name="refiner1col4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.refiner1col4Desc}" name="refiner1col4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>Refiner 2# </h2></td>
						</tr>  
						   <tr>
						    <td class="tg-yw4l" >Refiner Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.refiner2col1== 'true' ? 'checked' : ''} name="refiner2col1"/> Yes  
						    	<input type="radio" value="false" ${data.refiner2col1== 'false' ? 'checked' : ''} name="refiner2col1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.refiner2col1Desc}" name="refiner2col1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Refiner load/ unload Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.refiner2col2Inbound}" placeholder="" name="refiner2col2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.refiner2col2Outbound}" placeholder=" " name="refiner2col2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.refiner2col2Desc}" name="refiner2col2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >Oil level </td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.refiner2col3}" placeholder="" name="refiner2col3" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.refiner2col3Desc}" name="refiner2col3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Seal Water</td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.refiner2col4}" placeholder="" name="refiner2col4" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.refiner2col4Desc}" name="refiner2col4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						 <tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>White water pumps</h2></td>
						</tr>  
						<tr>
						    <td class="tg-yw4l" >Consistency Dilution pump</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.whitewaterpumpscol1== 'true' ? 'checked' : ''} name="whitewaterpumpscol1"/> Yes  
						    	<input type="radio" value="false" ${data.whitewaterpumpscol1== 'false' ? 'checked' : ''} name="whitewaterpumpscol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.whitewaterpumpscol1Desc}" name="whitewaterpumpscol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Consistency Dilution pump motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whitewaterpumpscol2Inbound}" placeholder="" name="whitewaterpumpscol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whitewaterpumpscol2Outbound}" placeholder=" " name="whitewaterpumpscol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whitewaterpumpscol2Desc}" name="whitewaterpumpscol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						     <td class="tg-yw4l" >Combined water pump  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.whitewaterpumpscol3== 'true' ? 'checked' : ''} name="whitewaterpumpscol3"/> Yes  
						    	<input type="radio" value="false" ${data.whitewaterpumpscol3== 'false' ? 'checked' : ''} name="whitewaterpumpscol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.whitewaterpumpscol3Desc}" name="whitewaterpumpscol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Combined water pump motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.whitewaterpumpscol4Inbound}" placeholder="" name="whitewaterpumpscol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.whitewaterpumpscol4Outbound}" placeholder=" " name="whitewaterpumpscol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.whitewaterpumpscol4Desc}" name="whitewaterpumpscol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <%-- 
						   <tr>
						    <td class="tg-yw4l" >FRP white water chest </td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.whitewaterpumpscol5}" placeholder="" name="whitewaterpumpscol5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.whitewaterpumpscol5Desc}" name="whitewaterpumpscol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >White water chest </td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.whitewaterpumpscol6}" placeholder="" name="whitewaterpumpscol6" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.whitewaterpumpscol6Desc}" name="whitewaterpumpscol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						   <tr>
						    <td class="tg-yw4l" >Silo  level </td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.whitewaterpumpscol7}" placeholder="" name="whitewaterpumpscol7" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.whitewaterpumpscol7Desc}" name="whitewaterpumpscol7Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr> 
						  --%>
						<tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2> Yankee pulper</h2></td>
						</tr>  
							<tr>	
						     <td class="tg-yw4l" >Yankee pulper East agitator </td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Leakage</span>
						    	<input type="radio" value="true" ${data.yankeepulpercol1== 'true' ? 'checked' : ''} name="yankeepulpercol1"/> Yes  
						    	<input type="radio" value="false" ${data.yankeepulpercol1== 'false' ? 'checked' : ''} name="yankeepulpercol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.yankeepulpercol1Desc}" name="yankeepulpercol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
							<tr>
						    <td class="tg-yw4l" >Yankee pulper East Agitator motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeepulpercol2Inbound}" placeholder="" name="yankeepulpercol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeepulpercol2Outbound}" placeholder=" " name="yankeepulpercol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeepulpercol2Desc}" name="yankeepulpercol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>	
						     <td class="tg-yw4l" >Yankee pulper West agitator </td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span>No Leakage</span>
						    	<input type="radio" value="true" ${data.yankeepulpercol3== 'true' ? 'checked' : ''} name="yankeepulpercol3"/> Yes  
						    	<input type="radio" value="false" ${data.yankeepulpercol3== 'false' ? 'checked' : ''} name="yankeepulpercol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.yankeepulpercol3Desc}" name="yankeepulpercol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Yankee pulper West agitator motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeepulpercol4Inbound}" placeholder="" name="yankeepulpercol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeepulpercol4Outbound}" placeholder=" " name="yankeepulpercol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeepulpercol4Desc}" name="yankeepulpercol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>							  
						   <tr>	
						     <td class="tg-yw4l" >Yankee pulper pump </td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.yankeepulpercol5== 'true' ? 'checked' : ''} name="yankeepulpercol5"/> Yes  
						    	<input type="radio" value="false" ${data.yankeepulpercol5== 'false' ? 'checked' : ''} name="yankeepulpercol5"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.yankeepulpercol5Desc}" name="yankeepulpercol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Yankee pulper motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.yankeepulpercol6Inbound}" placeholder="" name="yankeepulpercol6Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.yankeepulpercol6Outbound}" placeholder=" " name="yankeepulpercol6Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.yankeepulpercol6Desc}" name="yankeepulpercol6Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						 						<tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2> Broke System:</h2></td>
						</tr> 
						<tr>	
						     <td class="tg-yw4l" >Broke chest agitator south </td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.borkechestcol1== 'true' ? 'checked' : ''} name="borkechestcol1"/> Yes  
						    	<input type="radio" value="false" ${data.borkechestcol1== 'false' ? 'checked' : ''} name="borkechestcol1"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.borkechestcol1Desc}" name="borkechestcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Broke chest agitator south motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.borkechestcol2Inbound}" placeholder="" name="borkechestcol2Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.borkechestcol2Outbound}" placeholder=" " name="borkechestcol2Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.borkechestcol2Desc}" name="borkechestcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  <tr>	
						     <td class="tg-yw4l" >Broke chest agitator north</td>
						    <td class="tg-yw4l" style="text-align: center;">
						         <span> No Abnormal Sound</span>
						    	<input type="radio" value="true" ${data.borkechestcol3== 'true' ? 'checked' : ''} name="borkechestcol3"/> Yes  
						    	<input type="radio" value="false" ${data.borkechestcol3== 'false' ? 'checked' : ''} name="borkechestcol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.borkechestcol3Desc}" name="borkechestcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Broke chest agitator north </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.borkechestcol4Inbound}" placeholder="" name="borkechestcol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.borkechestcol4Outbound}" placeholder=" " name="borkechestcol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.borkechestcol4Desc}" name="borkechestcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  						<tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2> Save All</h2></td>
						</tr> 
						 <tr>
						    <td class="tg-yw4l" >Segments</td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.saveallcol1}" placeholder="" name="saveallcol1" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.saveallcol1Desc}" name="saveallcol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >Nozzles</td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.saveallcol2}" placeholder="" name="saveallcol2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.saveallcol2Desc}" name="saveallcol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	<tr>	
						     <td class="tg-yw4l" >knock of shawer</td>
						    <td class="tg-yw4l" style="text-align: center;">						        
						    	<input type="radio" value="true" ${data.saveallcol3== 'true' ? 'checked' : ''} name="saveallcol3"/> ON 
						    	<input type="radio" value="false" ${data.saveallcol3== 'false' ? 'checked' : ''} name="saveallcol3"/> OFF &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.saveallcol3Desc}" name="saveallcol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
							<tr>
						    <td class="tg-yw4l" >Save all motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.saveallcol4Inbound}" placeholder="" name="saveallcol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.saveallcol4Outbound}" placeholder=" " name="saveallcol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.saveallcol4Desc}" name="saveallcol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  						<tr>
								<td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>SydraPulper</h2></td>
						</tr> 
						  
							<tr>
						    <td class="tg-yw4l" >SydraPulper agitator Motor</td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.sydrapulpercol1Inbound}" placeholder="" name="sydrapulpercol1Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.sydrapulpercol1Outbound}" placeholder=" " name="sydrapulpercol1Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.sydrapulpercol1Desc}" name="sydrapulpercol1Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						   <tr>
						    <td class="tg-yw4l" >SydraPulper</td>						   
						    <td class="tg-yw4l" style="text-align: center;">
						     		<span>GEAR UNIT</span>						  
						   		  <input type="text" class="input" value="${data.sydrapulpercol2}" placeholder="" name="sydrapulpercol2" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.sydrapulpercol2Desc}" name="sydrapulpercol2Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  	<tr>	
						     <td class="tg-yw4l" >SydraPulper Pumpr</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    	<span>NO Abnormal Sound</span>						        
						    	<input type="radio" value="true" ${data.sydrapulpercol3== 'true' ? 'checked' : ''} name="sydrapulpercol3"/> ON 
						    	<input type="radio" value="false" ${data.sydrapulpercol3== 'false' ? 'checked' : ''} name="sydrapulpercol3"/> OFF &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.sydrapulpercol3Desc}" name="sydrapulpercol3Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >SydraPulper Pump Motor </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <span style="margin-right: 56px;"> Temperature   </span> Inbound:<input type="text" class="input" value="${data.sydrapulpercol4Inbound}" placeholder="" name="sydrapulpercol4Inbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  Outbound:<input type="text" class="input" value="${data.sydrapulpercol4Outbound}" placeholder=" " name="sydrapulpercol4Outbound" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		 <input type="text"class="input" value="${data.sydrapulpercol4Desc}" name="sydrapulpercol4Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						  
						   <tr>
						    <td class="tg-yw4l" >SydraPulper Level</td>
						    <td class="tg-yw4l" style="text-align: center;">						  
						   		  <input type="text" class="input" value="${data.sydrapulpercol5}" placeholder="" name="sydrapulpercol5" style="margin-left: 1px !important;float: none;    width: 81px;"/>
						   		  <input type="text"class="input" value="${data.sydrapulpercol5Desc}" name="sydrapulpercol5Desc" placeholder="Remarks" style="float: right;"/>
						    </td>						    
						  </tr>	
						
						</c:if> 
						 
						   
				  </table>
		    </center>
		 </div>
		 	
			</div>
			  	
			 
			   <c:choose>
			    <c:when test="${edit == 'yes'}">
			       <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn"  class="btn btn-success btn-sm">Print</button>
						<button  class="btn btn-success btn-sm" type="submit">Edit</button>
					</div>
			    </c:when>
			  
			    <c:otherwise>
			        <div class="wrapper">
						<br /><br />
						<button type="button" id="printBtn"  class="btn btn-success btn-sm">Print</button>
						<button  class="btn btn-success btn-sm" type="submit">Submit</button>
					</div>
			    </c:otherwise>
			</c:choose>
			
 	<%-- </c:if>	 --%>		
	  </form>		
	  
	 
	  

		</div>


	</div>

</body>
</html>