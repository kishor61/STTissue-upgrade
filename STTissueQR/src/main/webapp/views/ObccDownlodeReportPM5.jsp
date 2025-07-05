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
<spring:url value="/OBCCPM5Report/view/report/data/detailedreport/exportPercentage/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=startDate]').val();
			var edate=$('input[name=endDate]').val();
			var btn=$(this);
			
			if(confirm('Do You Really Want To Send Mail.')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate
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

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
		
		 	
		<spring:url value="/OBCCPM5Report/view/report/data/detailedreport/exportPercentage" var="viewURL"/>
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
						 
							<!-- <td> Position:</td>
							 <td>
								 <select style="width: 100%;" name="position" id="operator" onchange="Showshift(this.value)">
								    <option value="-1">Select Operator</option>
								 	<option value="backtender" >Back Tender</option>
								 	<option value="stockoperator">Stock Operator</option>
								 	<option value="machinetender">Machine Tender</option>
								 	<option value="R1" >R1 </option>
								 	<option value="R2" >R2 </option>
								 	<option value="utilityoperator">Utility Operator </option>
								 </select>							
							</td> -->
						    
							<td id="shiftlabl" style="display:none;"> Shift:</td>
							 <td id="shiftmenu" style="display:none;">
								  <select style="width: 100%;" name="shift" id="shift">
								    <option value="-1">Select Shift</option>
								 	<option value="day" >Day</option>
								 	<option value="night">Night</option>
								 	<option value="both">Both</option>
								 </select>							
							</td>
		
		 
						  	
							<td>&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" value="Export"></td>
							<td><input type="button" id="mailBtn" value="Send Mail"></td>
							  
	 					</tr>	 
					</table>
					 
				</div>
				
				
	  </form>		
		</div>
		
		<div style="text-align: center;">
			<c:if test="${not empty message }">
				<span class="message" style="font-weight: bolder;font-size: large;">${message}</span>
			</c:if>
			
		</div>
		


	</div>



	<!-- <script>
			 function Showshift(val)
			 {
				 //alert(val);
				  if(val=="backtender")
					{
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
					}
				  else if(val=="stockoperator")
				   {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				   }
				  else if(val=="machinetender")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }
				  else
				  {
					  //alert("calling")
					  $("#shiftlabl").hide();
					  $("#shiftmenu").hide();
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
			 
		</script> -->

</body>
</html>
