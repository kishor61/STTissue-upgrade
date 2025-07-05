<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>

<script type="text/javascript">
$(function(){
	$('input[name=startDate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
	
	$('input[name=endDate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
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

<style>
#myProgress {
  position: relative;
  width: 50%;
  height: 26px;
  background-color: #ddd;
}

#myBar {
  position: absolute;
  width: 1%;
  height: 100%;
  background-color: #4CAF50;
  	
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
</script>
<spring:url value="/OBCCReport/view/report/data/detailedreport/email" var="emailURL"/>
<spring:url value="/OBCCReport/view/report/data/detailedreport/count" var="countURl"/>
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=startDate]').val();
			var edate=$('input[name=endDate]').val();
			var position=$('select[name=position]').val();
			
			var btn=$(this);
			
			if(confirm('Do You Want To Send Mail For '+position+' Operator.')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate,
						position : position 
					},
					success : function(data){
						if(data){
							$('#tmessage').text('Mail sent successfully.');
						}else{
							$('#tmessage').text('Failure to send email. Please contact to administrator.');
						}
						btn=btn.prop('disabled',false);
						setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}
				});
			}
			
			
			
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
		
		 	
			<spring:url value="/convertinglineOBCC/view/report/data/detailedreport/export" var="viewURL"/>
		 
		 		
			
		 <form name="dataForm" action="${viewURL}" method="post">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Basic Care CheckList</span>
				</div>
				<div class="table-selector">
					
				
					
					
			 <%-- <input type="hidden" name="id" value="${data.id}"> --%> 
	
					<table style="margin: auto;">
						<tr>
						
							<td> Start Date:</td>
							  <td>
								<input type="text" name="startDate" value="${startDate}" id="startDate">							
							</td>
							
							<td> End Date:</td>
							  <td>
								<input type="text" name="endDate" value="${endDate}" id="endDate">							
							</td>
						 
							<td> Position:</td>
							 <td>
								 <select style="width: 100%;" name="position" id="operator" onchange="Showshift(this.value)">
								    <option value="">Select Operator</option>
								 	<option value="casepacker" ${data.position == 'casepacker' ? 'selected' : ''}>Case Packer</option>
								 	<option value="rewind" ${data.position == 'rewind' ? 'selected' : ''}>RewindUnwindr</option>
								 						 	
								 </select>							
							</td>
						    
							<td id="shiftlabl" style="display:none;"> Shift:</td>
							 <td id="shiftmenu" style="display:none;">
								  <select style="width: 100%;" name="shift" id="shift">
								    <option value="">Select Shift</option>
								 	<option value="1" >1</option>
								 	<!-- <option value="2">2</option>
								 	<option value="3">3</option>
								 	<option value="both">ALL</option> -->
								 </select>							
							</td>
		
		 
						  	
							<td>&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" value="Export"></td>
							<!-- <td><input type="button" name="pdf" id="pdf" value="PDF" onclick="exportPdfFile();"/></td>
							<td><input type="button" id="mailBtn" value="Send Mail"></td> -->
							  
	 					</tr>	 
					</table>
					 
				</div>
				<br /><br /><br />
				<center>
					<span id="ttt" style="display: none;"><h2 style="color: #592003;font-size: 20px;">You Are Going to Download <span id="tete" style="color: #592003;font-size: 20px;">0</span>% Data.</h2></span>
					<div id="myProgress" style="display: none">
	  					<div id="myBar"><span id="id1" style="font-size: 20px;font-weight: 800;color: white;">0%</span></div>
					</div>
				</center>
				
	  </form>		
		</div>
		
		<div style="text-align: center;">
			<c:if test="${not empty message }">
				<span class="message" style="font-weight: bolder;font-size: large;">${message}</span>
			</c:if>
			
		</div>
		


	</div>
	 
	<script>
			 function Showshift(val)
			 {
				 //alert(val);
				  if(val=="casepacker")
					{
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
					}
				  else if(val=="rewind")
				   {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				   }
				  
				  $("#shift").val('-1');
			 }
			 
			 function exportPdfFile()
			 {
				 var sdate = $('#startDate').val();
				 var edate= $('#endDate').val();
				 var position = $('#operator').val(); 
				 var shift = $('#shift').val();
				 var flag= $('#shift').is(':visible');
				 if(position == 'R1' || position == 'R2' || position == 'utilityoperator')
				 {
					 location.href='./view/report/data/detailedreport/export/PDF?sdate='+sdate+'&edate='+edate+'&position='+position+'&shift='+shift;
				 }
				 else
				 {
					 
					 if(shift != '-1')
					 {
						 location.href='./view/report/data/detailedreport/export/PDF?sdate='+sdate+'&edate='+edate+'&position='+position+'&shift='+shift;
					 }
					 else
					 {
						 if(position == '-1' && flag == false)
							{
							 alert("Please Select The Position");
							} 
						 else
							 {
							 	alert("Please Select The Shift According to Position");							 
							 }

					 }
					  
				 }
				 $('#shift').val('-1');
 			 }
			 
			 function getDataForProcessbar()
			 {
				 var sdate = $('#startDate').val();
				 var edate= $('#endDate').val();
				 var position = $('#operator').val(); 
				 var shift = $('#shift').val();
				 var flag= $('#shift').is(':visible');
				 
				  
				 if(position != -1)
				 {
					 $('#loadPage').show();
					 
					 
					 var obj; 
					 
					 if(position == 'R1' || position == 'R2' || position == 'utilityoperator')
					 {
						 obj ={
					           "sdate" : sdate,
					           "edate" : edate,
					           "position" : position,
					           "shift":-1
					           }
						 
						 
					 }
	 				 else
					 {
	 					obj ={
	 				           "sdate" : sdate,
	 				           "edate" : edate,
	 				           "position" : position,
	 				           "shift":shift
	 				           }
					 }
					 $.ajax({
							url:'${countURl}',
							type: 'POST',
							data :obj,
							success : function(data){
	 							//alert(data);
	 							$('#myProgress').show();
	 							
	 							$("#myBar").css("width", data + '%');
	 							
	 							$("#id1" ).text(data+"%");
	 							$("#tete" ).text(data);
	 							
	 							$('#ttt').show();
	 							$('#loadPage').hide();
	 							
	 							//$( "div" ).text( "The width for the " + ele + " is " + w + "px." );
							}
	 							
						});
					 
					 
					 
			     }
				 else
			 	{
					 alert("Please Select the Position");
			 	}
				 
			 }
			 
			 
		</script>
		
		

</body>
</html>
