<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<style type="text/css">
.myButton {
	background-color:#CB842E;
	-moz-border-radius:28px;
	-webkit-border-radius:28px;
	border-radius:28px;
	border:1px solid #CB842E;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:0px 23px;
	text-decoration:none;
	text-shadow:0px 1px 0px #CB842E;
}
.myButton:hover {
	background-color:#5cbf2a;
}
.myButton:active {
	position:relative;
	top:1px;
}

</style>
<spring:url value="/wastepaperreport/addnewEstimatedFreight" var="addfreightDataURL" />
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;
$(function(){
		$('#addvalue').click(doclicksubmit);
		
	});
	function doFocusIn()
	{
		
		currentVal=$(this).val();
	}
	function doclicksubmit()
	{
		saveData($(this));
	}
</script>
<script type="text/javascript">
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);

	var carrier=$('input[name=carrier]').val();
	var shippingCity=$('input[name=shippingCity]').val();
	var shippingState=$('input[name=shippingState]').val();
	var estimatedFreight=$('input[name=estimatedFreight]').val();
	var grade=$('select[name=grade]').val();
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${addfreightDataURL}',
		type:'POST',
		data:{
			carrier : carrier,
			shippingCity : shippingCity,
			shippingState : shippingState,
			estimatedFreight : estimatedFreight,
			grade : grade
		},
		
		success:function(data){
			$('#tmessage').text(data.message);
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
		
	});
	 window.setTimeout('location.reload()', 3000); //Reloads after three seconds
}
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Add New Estimated Freight Value</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Estimated Freight For Waste Paper Report</td>
							<td>
							</td>
						</tr>
					</table>
				</div>
			
			<div style="padding: 411px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: -228px;">
				
				<table id="addfreighttbl" border="4" style="background-color:#FFFFCC;border-collapse:collapse;border:4px solid #CC9933;color:#000000;width:100%" cellpadding="10" cellspacing="1">
					<tr>
						<td><b>Carrier:</b></td>
						<td><input type="text" value="" name="carrier" required="required"/></td>
					</tr>
					<tr>
						<td><b>Shipping City:</b></td>
						<td><input type="text" value="" name="shippingCity" required="required"/></td>
					</tr>
					<tr>
						<td><b>Shipping State:</b></td>
						<td><input type="text" value="" name="shippingState" required="required"/></td>
					</tr>
					<tr>
						<td><b>Estimated Freight Price:</b></td>
						<td><input type="text" value="" name="estimatedFreight" required="required"></td>
					</tr>
					<tr>
						<td><b>Grade:</b></td>
						<td>
							<select name="grade" id="grade" required="required">
										<option value="">Select</option>
										<c:forEach items="${gradeName}" var="gn">
												<option value="${gn.gradeid}">${gn.grade}(${gn.gradeid })</option>
										</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<td><a href='../wastepaperreport/view' class="myButton">Cancle</a></td>
						<td><button id="addvalue" value="Add" name="Add" class="myButton">Add</button></td>
					</tr>
				</table>
				

		</div>
				
			</div>

		</div>


	</div>

</body>
</html>
