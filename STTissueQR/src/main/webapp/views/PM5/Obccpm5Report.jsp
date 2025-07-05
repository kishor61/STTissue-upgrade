<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
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
<spring:url value="/OBCCPM5Report/view/report/data/detailedreport/email" var="emailURL"/>
<spring:url value="/OBCCPM5Report/view/report/data/detailedreport/count" var="countURl"/>
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

<!-- CSS overrides to fix style conflicts with header.jsp -->
<style type="text/css">
    /* Override container styling */
    .container {
        width: 100%;
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto;
        margin-top: 60px; /* Add margin to avoid header overlap */
    }
    
    /* Ensure proper form styling */
    .table-selector table {
        margin: auto;
        border-collapse: separate;
        border-spacing: 5px;
    }
    
    .table-selector td {
        padding: 5px;
    }
    
    /* Fix button styling */
    input[type="submit"], input[type="button"] {
        padding: 5px 10px;
        margin: 0 5px;
    }
    
    /* Fix main content area */
    .block3 {
        margin-top: 20px;
        overflow: auto;
    }
    
    /* Page title styling */
    .page-title {
        margin-bottom: 20px;
        text-align: center;
    }
    
    .page-title .label {
        font-size: 18px;
        font-weight: bold;
    }
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<jsp:include page="../header.jsp"></jsp:include>
		 
	<div class="container">

		
	<div class="page-box" id="loadPage">
			<div style="margin-top: 200px;">
				<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
			</div>
		</div>


		<div class="block3" style="overflow: auto;">
		
		 	
			<spring:url value="/OBCCPM5Report/view/report/data/detailedreport/export" var="viewURL"/>
		 
		 <form name="dataForm" action="${viewURL}" method="post">
			<div style="margin-left: 300px;">

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
								    <option value="-1">Select Operator</option>
								 	<option value="leadoperator" >Lead Operator</option>
								 	<option value="stockoperator">Stock Operator</option>								 	
								 	<option value="R1" >R1Winder </option>
								 	<option value="R1WaterJetsDown" >R1WaterJets</option>
								 	<option value="R2" >R2Winder</option>
								 	<option value="R2WaterJetsDown" >R2WaterJets</option>
								 	<option value="utilityoperator" >Utility WaterJets</option>	
								 	<option value="WinderDown" >Utility Winder</option>									 								 	
								 </select>							
							</td>
						    
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
							<!-- <td><input type="button" name="pdf" id="pdf" value="PDF" onclick="exportPdfFile();"/></td> -->
							<td><input type="button" id="mailBtn" value="Send Mail"></td>
							  
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
				  if(val=="leadoperator")
					{
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
					}
				  else if(val=="stockoperator")
				   {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				   }
				  else if(val=="R2")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }
				  else if(val=="R2WaterJetsDown")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }
				  
				  else if(val=="R1")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }
				  else if(val=="R1WaterJetsDown")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }
				  else if(val=="utilityoperator")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }
				  else if(val=="WinderDown")
				  {
					  $("#shiftlabl").show();
					  $("#shiftmenu").show();
				  }				  
				  else
				  {
					  
					  $("#shiftlabl").hide();
					  $("#shiftmenu").hide();
					  
					  //getDataForProcessbar();
					  
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
				 if(position == 'R1' || position == 'R2' || position == 'leadoperator'||position=="stockoperator"||position=="utilityoperator")
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
					 
					 if(position == 'R1' || position == 'R2' || position == 'leadoperator'||position=="stockoperator"||position=="utilityoperator")
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
