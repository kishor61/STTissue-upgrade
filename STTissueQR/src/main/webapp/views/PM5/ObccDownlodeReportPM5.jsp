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
.button {
    text-decoration: none;
    text-align: center;
    padding: 10px 20px;
    border: solid 1px #004F72;
    border-radius: 4px;
    font: 16px Arial, Helvetica, sans-serif;
    font-weight: bold;
    color: #E5FFFF;
    background-color: #3BA4C7;
    background-image: linear-gradient(to bottom, #3BA4C7 0%, #1982A5 100%);
    box-shadow: 0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;
    cursor: pointer;
    transition: all 0.3s ease;
}

.button:hover {
    background-color: #1982A5;
    background-image: linear-gradient(to bottom, #1982A5 0%, #3BA4C7 100%);
}

.wrapper {
    text-align: center;
    margin: 20px 0;
}

.input-field {
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    width: 180px;
}

.input-field:focus {
    border-color: #66afe9;
    outline: 0;
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102,175,233,.6);
}

.form-container {
    background-color: #f9f9f9;
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 20px;
    margin: 20px auto;
    max-width: 800px;
}

.form-row {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-bottom: 15px;
}

.form-group {
    margin: 0 10px;
    display: flex;
    align-items: center;
}

.form-label {
    margin-right: 10px;
    font-weight: bold;
}

.page-title {
    text-align: center;
    margin-bottom: 20px;
}

.page-title .label {
    font-size: 24px;
    font-weight: bold;
    color: #333;
}

.message {
    color: #3BA4C7;
    font-weight: bold;
    font-size: 16px;
    margin: 10px 0;
    display: block;
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
<body class="hold-transition sidebar-mini layout-fixed">
<jsp:include page="../header.jsp"></jsp:include>

	<div class="container">
		<div class="block3" style="overflow: auto;">
		<spring:url value="/OBCCPM5Report/view/report/data/detailedreport/exportPercentage" var="viewURL"/>
		<form name="dataForm" action="${viewURL}" method="post">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Operator Basic Care CheckList</span>
				</div>
				
				<div class="form-container">
					<div class="form-row">
						<div class="form-group">
							<label class="form-label">Start Date:</label>
							<input type="text" name="startDate" value="${startDate}" id="startDate" class="input-field">
						</div>
						
						<div class="form-group">
							<label class="form-label">End Date:</label>
							<input type="text" name="endDate" value="${endDate}" id="endDate" class="input-field">
						</div>
						
						<div class="form-group" id="shiftlabl" style="display:none;">
							<label class="form-label">Shift:</label>
							<select class="input-field" name="shift" id="shift">
								<option value="-1">Select Shift</option>
								<option value="day">Day</option>
								<option value="night">Night</option>
								<option value="both">Both</option>
							</select>
						</div>
					</div>
					
					<div class="wrapper">
						<input type="submit" name="submit" value="Export" class="button">
						<input type="button" id="mailBtn" value="Send Mail" class="button">
					</div>
					
					<div style="text-align: center;">
						<span id="tmessage" class="message"></span>
						<c:if test="${not empty message}">
							<span class="message">${message}</span>
						</c:if>
					</div>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>
