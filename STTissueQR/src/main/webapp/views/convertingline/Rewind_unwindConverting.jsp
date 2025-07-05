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
	$('input[name=date]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true,
	    maxDate:1
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
		
			
	});
	
});
 
function operatorSelect(value)
{
	var position  = $('#operator').val();
	var date = $('#date').val();
	var operatorname = $('#operatorname').val();
	var crew  = $('#crew').val();
	var shift =$('#shift').val(); 
	var back=${back};
	
	//alert(operator);
	//alert(date);
	if(crew!='-1' && position!='-1')
		if(position == 'casepacker')
		{
			location.href="../../convertinglineOBCC/casePacker/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew+"&back="+back;
		}
		else if(position == 'rewind')
		{
			location.href="../../convertinglineOBCC/rewind/view?shift="+value+"&position="+position+"&date="+date+"&operatorname="+operatorname+"&crew="+crew+"&back="+back;
		}
		
		else
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
width: 200px;
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
		
		
			<spring:url value="/convertinglineOBCC/rewind/save" var="viewURL"/>
		
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post" onsubmit="validateform()">
			<div class="pageContent">

				<center>
				<div class="page-title">
					<span class="label" style="font-size: 21px;color: #518f3e;">CenterLine Rewind Unwind  </span>
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
								 	<option value="rewind" ${data.position == 'rewind' ? 'selected' : ''}>RewindUnwindr</option>
								 	
								 	
							</td>  
							
							<td> Operator Name:</td>
							<td>
								  <input type="text" name="operatorname" value="${data.operatorname}" id="operatorname"/>						
							</td>
							 
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
							<td> Shift:</td>
							<td>
								 <select style="width: 100%;" name="shift" onchange="operatorSelect(this.value);" id="shift">
								    <option value="-1">Select Shift</option>
								   <option value="1" ${data.shift == '1' ? 'selected' : ''}>1</option>
								 	<%-- <option value="2" ${data.shift == '2' ? 'selected' : ''}>2</option>
								 	<option value="3" ${data.shift == '3' ? 'selected' : ''}>3</option> --%>
								 </select>							
							</td> 
							<td>
								<button type="button" id="printBtn">Print</button>
								<a href="../convertingObccView"><button  type="button" >Current Date Entry
							</button></a>
							<a href="../convertingObccBackView"><button  type="button" >Back Dated Entry
							</button></a>
							</td>
	 					</tr>
					</table>
					 
				</div>
 			 <c:if test="${not empty message }">
				<span class="message">${message}</span>
			 </c:if>
 
 <br/> <br/>  <br/>

 
   <div id="printDiv">
		 <center>
		 	<div style="display:none;" id="div_show">
		 		<div>
		 			<h1 style= "float: left;font-size: 19px;">RewindUnwind Entry Form</h1>
		 		</div>
		 		<div style="float: right;}">
		 			<span><b style="font-size: 15px;">Operator 1: </b>${data.operatorname}</span>
		 		</div>
		 		<div style="float: right;    margin-right: -130px;">
		 		 <br/>
		 			<span><b style="font-size: 15px;">Date:</b>${data.date}</span> &nbsp;&nbsp;&nbsp;
		 			<span><b style="font-size: 15px;">Shift:</b>${data.shift}</span> 
		 		</div>
		 	</div>	
		 	 <c:if test="${data.shift == '1'}">
		   
		   	<c:if test="${back==true}">					
					<h1 style="font-size: 21px;color: #518f3e;">Shift 1 RewindUnwind Back Date Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>							
			</c:if>
			<c:if test="${back==false}">					
					<h1 style="font-size: 21px;color: #518f3e;">Shift 1 RewindUnwind Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>					
			</c:if>	
		    <h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						  	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </h3>
		 </c:if> 
		 <c:if test="${data.shift == '2'}">
		 <c:if test="${back==true}">					
					<h1 style="font-size: 21px;color: #518f3e;">Shift 2 RewindUnwind Back Date Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>							
			</c:if>
			<c:if test="${back==false}">					
					<h1 style="font-size: 21px;color: #518f3e;">Shift 2 RewindUnwind Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>					
			</c:if>	
		    <h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						  	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </h3>
		 </c:if>
		 <c:if test="${data.shift == '3'}">
		   
		   	<c:if test="${back==true}">					
					<h1 style="font-size: 21px;color: #518f3e;">Shift 3 RewindUnwind Back Date Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>							
			</c:if>
			<c:if test="${back==false}">					
					<h1 style="font-size: 21px;color: #518f3e;">Shift 3 RewindUnwind Form &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>					
			</c:if>	
		    <h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						  	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </h3>
		 </c:if> 
		 	
		 				<%-- <h1 style="font-size: 21px;color:#f5070b;style="text-align: center;">Machine Down</h1>
						  	<h3>
						    	<input type="radio" value="true" ${data.machinedown == 'true' ? 'checked' : ''} name="machinedown"/> Yes  
						    	<input type="radio" value="false" ${data.machinedown == 'false' ? 'checked' : ''} name="machinedown"/> No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </h3> --%>
				 <table border="1" class="tg" style="background-color: white;width: 800px;" id="tbbl">				

						<tr>
						<td class="tg-yw4l" >Item Runing on Rewinder</td>
							<td style="margin-left: 100px !important;float: none;">
								<select name="itemonrewind"  class="input" id="itemonrewind" style="margin-left: 100px !important;float: none;" ">
									<option value="">Select</option>
									
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq moniterdatas.breakAt }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
													</c:when>
													<c:otherwise>
													<option value="${skucode.productcode}">${skucode.productcode}</option>	
													</c:otherwise>
									    </c:choose>
								  </c:forEach>
						     </select>
						</td>
						<%-- <td class="tg-yw4l" ><h1>Item Runing on Rewinder</h1></td>
							<td style="margin-left: 100px !important;float: none;">
								<select name="itemonrewind" id="itemonrewind" style="width: 100px; padding: 2px;" required="required">
									<option value="">Select</option>
									
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq moniterdatas.breakAt }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
													</c:when>
													<c:otherwise>
													<option value="${skucode.productcode}">${skucode.productcode}</option>	
													</c:otherwise>
									    </c:choose>
								  </c:forEach>
						     </select>
						</td> --%>
					</tr>
					  <tr>
					  <td class="tg-yw4l" ><h1>Footage number in Program</h1></td>
					    <td>
							<input type="text" class="input" value="${data.footagenumber}"  name="footagenumber" style="margin-left: 100px !important;float: none;"/>
						</td>						    
					</tr>
					 <tr>
					 <td class="tg-yw4l" ><h1>Diameter number in program</h1></td>
					    <td>
							<input type="text" class="input" value="${data.diameternumber}"  name="diameternumber" style="margin-left: 100px !important;float: none;"/>
						</td>						    
					</tr>
					 <tr>
					 <td class="tg-yw4l" ><h1>Actual footage tested</h1></td>
					    <td>
							<input type="text" class="input" value="${data.actualfootage}"  name="actualfootage" style="margin-left: 100px !important;float: none;"/>
						</td>						    
					</tr>
					 <tr>
					 <td class="tg-yw4l" ><h1>Actual diameter of product out of log saw</h1></td>
					    <td>
							<input type="text" class="input" value="${data.actualdiameter}"  name="actualdiameter" style="margin-left: 100px !important;float: none;"/>
						</td>						    
					</tr>
					 <tr>
					 <td class="tg-yw4l" ><h1>Paper grade in unwind stands</h1></td>
					    <td>
							<input type="text" class="input" value="${data.papergrade}"  name="papergrade" style="margin-left: 100px !important;float: none;"/>
						</td>						    
					</tr>
					
 
					  <tr>
						    <td class="tg-yw4l" >Logsaw grinding stone cleaned</td>
						    <td><select name="logsawstone" id="logsawstone"
											class="input"  style="margin-left: 100px !important;float: none;" required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Unwind stand stones cleaned </td>
						   <td><select name="unwindstandcleaned" id="unwindstandcleaned"
											class="input"  style="margin-left: 100px !important;float: none;" required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Tape straight and in tact </td>
						    <td><select name="transferglue" id="areaClean"
											class="input"  style="margin-left: 100px !important;float: none;" required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>	
						    
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Transfer glue level good </td>
						    <td><select name="transferglue" id="areaClean"
											class="input"  style="margin-left: 100px !important;float: none;"required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>	
						    
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >Tail tie glue level good </td>
						    <td><select name="tailtieglue" id="areaClean"
											class="input"  style="margin-left: 100px !important;float: none;"  required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
  

 
 
						  </tr>
						  <tr>
						    <td class="tg-yw4l" >>No more than 1st of log </td>
						    <td><select name="nomore1stlog" id="nomore1stlog"
											class="input"  style="margin-left: 100px !important;float: none;"  required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
						   <!--  <td class="tg-yw4l" >No more than 1st of log </td>
						    <td><select name="nomore1stlog" id="areaClean" 
											style="width: 98px; padding: 2px;" required="required">
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>		 -->			    
						  </tr>
					 <tr>
					 <td class="tg-yw4l" ><h1>Coning(Core positioners in if so)</h1></td>
					    <td>
							<input type="text" class="input" value="${data.nomore1stlog}"  name="nomore1stlog" style="margin-left: 100px !important;float: none;"/>
						</td>						    
					</tr>
					 <tr>
					 <td class="tg-yw4l" ><h1>Roll length within 1/8th of program</h1></td>
					    <td>
							<input type="text" class="input" value="${data.rolllength}"  name="rolllength" style="margin-left: 100px !important;float: none;"/>
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
			
 	
 	</div>		
	  </form>		
		</div>
	</div>
</body>
</html>
