<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
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
		
		if(position == 'casepacker')
		{
			location.href="./../convertinglineOBCC/casePacker/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew+"&back="+true;
		}
		else if(position == 'rewind')
		{
			location.href="./../convertinglineOBCC/rewind/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew+"&back="+true;
		}
		
		else
		{
			alert("Please Select the Crew or Position");
		}
			
	
			
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
		
		<c:if test="${data.position == 'R2'}">	
			<spring:url value="/operatorCareCheckList/save" var="viewURL"/>
		</c:if>	
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">
			<center>
				<div class="page-title">
					<span class="label" style="font-size: 21px;color: red;">Operator Basic Care Back Date Entry</span>
				</div>
			</center>
				<div class="table-selector">
					
				
					
					
			 <input type="hidden" name="id" value="${data.id}"> 
							
					<table style="margin: auto;">					
					
						<tr>						
							<td> Position:</td>
							 <td>
								 <select style="width: 100%;" name="position" id="operator">
								    <option value="-1">Select Operator</option>
								 	<option value="casepacker" ${data.position == 'casepacker' ? 'selected' : ''}>Case Packer</option>
								 	<option value="rewind" ${data.position == 'rewind' ? 'selected' : ''}>RewindUnwinder</option>
								 	
								 </select>							
							</td>  
							
							<td> Operator Name:</td>
							<td>
								  <input type="text" name="operatorname" value="${data.operatorname}" id="operatorname"/>						
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
								 	<option value="1" ${data.shift == '1' ? 'selected' : ''}>1</option>
								 	<%-- <option value="2" ${data.shift == '2' ? 'selected' : ''}>2</option>
								 	 <option value="3" ${data.shift == '3' ? 'selected' : ''}>3</option> 
								 	 	 --%>			 
								 </select>							
							</td> 
							<td>
								<button type="button" id="printBtn">Print</button>
								<a href="../convertingObccView"><button  type="button" >Current Date Entry
							</button></a>
							</td>
	 					</tr>
					</table>
					 
				</div>
 			 <c:if test="${not empty message }">
				<span class="message">${message}</span>
			 </c:if>
 
 <br/> <br/>  <br/>
		
 <c:if test="${data.position == 'R2'}">
   <div id="printDiv">
		 <center>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<div><h1 style="font-size: 21px;color: #518f3e;">Back Date  Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>	</div>
		 		</div>
		 		<div style="float: right;}">
		 			<span><b style="font-size: 15px;">R2 Operator : </b>${data.operatorname}</span>
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
				 <table border="1" class="tg" style="background-color: white;width: 800px;" id="tbbl">
						
						
						<tr>
						    <td class="tg-yw4l" style="text-align: center;" ><h1 style="font-size: 15px;">Description</h1></td>
						    <td class="tg-yw4l"><h1 style="text-align: center;margin-left: -356px;font-size: 15px;" id="checkpoint">Check Point</h1><h1 style="float: right;margin: -15px 182px 0px 0px;font-size: 15px;">Remarks</h1></td>
						   
						</tr> 
						
						<tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>WINDER DECK STOPS</h2></td>
						     
						</tr> 
						  <tr>
						    <td class="tg-yw4l" >Movement </td>
						    <td class="tg-yw4l" style="text-align: center;">
						        
						    	<input type="radio"  name="movementcol1" value="true" ${data.movementcol1 == 'true' ? 'checked' : ''}/> Yes <input type="radio"  name="movementcol1" value="false" ${data.movementcol1 == 'false' ? 'checked' : ''}/> No
						    	
							   <%--  <input type="checkbox"  name="movementcol1" value="${data.movementcol1 eq 'true'?'1':'0'}"/> OK --%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    <input type="text" class="input" value="${data.movementcol1desc}" name="movementcol1desc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						  </tr>
						  <br />
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CONVEYOR</h2></td>
						     
						  </tr>
						 <tr>
						    <td class="tg-yw4l" > Chain Link/Pins  </td>
						    <td class="tg-yw4l" style="text-align: center;">
						   		 <input type="radio" value="true" ${data.conveyorcol1 == 'true' ? 'checked' : ''} name="conveyorcol1"/> Yes 
						   		 <input type="radio" value="false" name="conveyorcol1" ${data.conveyorcol1 == 'false' ? 'checked' : ''}/> No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		 <input type="text"class="input" value="${data.conveyorcol1desc}" name="conveyorcol1desc" placeholder="Remarks" style="margin-left: 66px;"/>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Conveyor Sections</td>
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.conveyorcol2 == 'true' ? 'checked' : ''} name="conveyorcol2"/> Yes 
						     <input type="radio" value="false" ${data.conveyorcol2 == 'false' ? 'checked' : ''} name="conveyorcol2"/>No   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" class="input" value="${data.conveyorcol2desc}" name="conveyorcol2desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l" >Motor - Overheating</td>
						    <td class="tg-yw4l" style="text-align: center;">
						     <input type="radio" value="true" ${data.conveyorcol3 == 'true' ? 'checked' : ''} name="conveyorcol3"/>Yes 
						     <input type="radio" value="false"  ${data.conveyorcol3 == 'false' ? 'checked' : ''} name="conveyorcol3"/>No    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						     <input type="text" value="${data.conveyorcol3desc}"  class="input"name="conveyorcol3desc" placeholder="Remarks" style="margin-left: 66px;"/> 
						    </td>
						    
						  </tr>
						  
						    <tr>
						    <td class="tg-yw4l" >Motor - Abnormal Sound</td>
						       
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.conveyorcol4 == 'true' ? 'checked' : ''} name="conveyorcol4"/>Yes 
						    <input type="radio" value="false"  ${data.conveyorcol4 == 'false' ? 'checked' : ''} name="conveyorcol4"/>No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" value="${data.conveyorcol4desc}"  class="input"name="conveyorcol4desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						     
						  </tr>
						  
						   <tr>
						    <td class="tg-yw4l" >PLC Control Panel </td>
						    <td class="tg-yw4l" style="text-align: center;">
						    <input type="radio" value="true" ${data.conveyorcol5 == 'true' ? 'checked' : ''} name="conveyorcol5"/>Yes 
						    <input type="radio" value="false"  ${data.conveyorcol5 == 'false' ? 'checked' : ''} name="conveyorcol5"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						    <input type="text" value="${data.conveyorcol5desc}" class="input" name="conveyorcol5desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    
						  </tr>
						  
						 
						   
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CORE SAW</h2></td>
						   
						  </tr>
						  <tr>
						    <td class="tg-yw4l"  >Power</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	
						    	
						    	<input type="radio" value="true" ${data.powercol1 == 'true' ? 'checked' : ''} name="powercol1"/> ON  
						    	<input type="radio" value="false" ${data.powercol1 == 'false' ? 'checked' : ''} name="powercol1"/> OFF &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol1desc}" class="input" name="powercol1desc" placeholder="Remarks" style="margin-left: 58px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  <tr>
						    <td class="tg-yw4l"  >Blade</td>
						    
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.powercol2 == 'true' ? 'checked' : ''} name="powercol2"/> Yes
						    	<input type="radio" value="false" ${data.powercol2 == 'false' ? 'checked' : ''} name="powercol2"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol2desc}" class="input" name="powercol2desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l">Vacuum</td>
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.powercol3 == 'true' ? 'checked' : ''} name="powercol3"/> Yes
						    	<input type="radio" value="false" ${data.powercol3 == 'false' ? 'checked' : ''} name="powercol3"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol3desc}"  class="input" name="powercol3desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						  
						  
						  <tr>
						    <td class="tg-yw4l"  >Size Adjustment Movement</td>
						     
						    	<td class="tg-yw4l" style="text-align: center;">
						    	<input type="radio" value="true" ${data.powercol4 == 'true' ? 'checked' : ''} name="powercol4"/> Yes
						    	<input type="radio" value="false" ${data.powercol4 == 'false' ? 'checked' : ''} name="powercol4"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input type="text" value="${data.powercol4desc}" class="input" name="powercol4desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						    
						  </tr>
						   	
						  <tr>
						    <td class="tg-yw4l" colspan="2" style="background-color: rgba(128, 128, 128, 0.52);"><h2>CORES</h2></td>
						   
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Correct Size For Order</td>
						   <td class="tg-yw4l" style="text-align: center;">
						   
						   <input type="radio" value="true" ${data.ordercol1 == 'true' ? 'checked' : ''} name="ordercol1"/> Yes
						   <input type="radio" value="false" ${data.ordercol1 == 'false' ? 'checked' : ''} name="ordercol1"/>No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   
						  <%--  <input type="checkbox" value="${data.ordercol1 eq 'true'?'1':'0'}" name="ordercol1"/> OK &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
						   <input type="text" value="${data.ordercol1desc}" class="input" name="ordercol1desc" placeholder="Remarks" style="margin-left: 66px;"/>  </td>
						    </td>
						     
						  </tr>
						 
						  <tr>
						  <!--  <td class="tg-yw4l"><input class="button" type="submit" value="Submit" name="Submit"/></td> -->
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
