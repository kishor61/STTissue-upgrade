<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepaperreport/editEstimatedFriegtValue" var="editfreightDataURL" />
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

$(function(){
		$('#Freightdatatable tbody input, #Freightdatatable tbody select').focusin(doFocusIn);
		$('#Freightdatatable tbody input, #Freightdatatable tbody select').focusout(doFocusOut);
		
	});
	function doFocusIn()
	{
		
		currentVal=$(this).val();
	}
	function doFocusOut()
	{
		saveData($(this));
	}
</script>
<script type="text/javascript">
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();

	var carrier=tr.find('input[name=carrier]').val();
	var shippingCity=tr.find('input[name=shippingCity]').val();
	var shippingState=tr.find('input[name=shippingState]').val();
	var estimatedFreight=tr.find('input[name=estimatedFreight]').val();
	var grade=tr.find('select[name=grade]').val();
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${editfreightDataURL}',
		type:'POST',
		data:{
			id : id,
			carrier : carrier,
			shippingCity : shippingCity,
			shippingState : shippingState,
			estimatedFreight : estimatedFreight,
			grade : grade
		},
		
		success:function(data){
			
			idEle.val(data.id);//By This line Of Code We Are Geting Current Line Number OF <TD>
			$('#tmessage').text(data.message);
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
	  window.setTimeout(function(){location.reload()},3000)
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
					<span class="label">Waste Paper Estimated Freight Edit</span>
				</div>
				
			<div class="table-selector">
					<table>
						<tr>
								
								<!-- <td><button id="deletebutton">Delete</button></td>
								<td>|</td>
								<a href='<spring:url value="/wastepaperreport"/>?startdate=${startingdate}&enddate=${endingdate}'>Back To Report</a>
								 -->
								<td><a href='<spring:url value="/wastepaperreport/view/"/>'>Back</a></td>
								
						</tr>
				</table>
			</div>
			<div>${message}</div>
			<div style="padding: 411px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: -228px;">
<table class="table" id="Freightdatatable">
						<thead style="font-size: 12px;">
						<tr>
								<th style="width:10px;" rowspan="2"></th>
								<th style="width:50px;">Carrier</th>
								<th style="width:50px;">Shipping City</th>
								<th style="width:50px;">Shipping Stater</th>
								<th style="width:50px;">Estimate Freight Price</th>
								<th style="width:50px;">Grade</th>
								
							</tr>
						</thead>
						<tbody id="yielddatainput">
							<c:if test="${fn:length(editFreight)>0}">
							<c:forEach items="${editFreight}" var="editFreight">
							<tr>
								<td>
									<input type="radio" name="id"  value="${editFreight.id}"> 
								</td>
								<td>
									<input type="text" style="width: 70px;" name="carrier"  value="${editFreight.carrier}"  autocomplete="off"></td>
								<td> 
									<input type="text" style="width: 90px;" name="shippingCity" value="${editFreight.shippingCity}"  autocomplete="off">			
								</td>
								<td> 
									<input  type="text" class="textbox" name="shippingState" value="${editFreight.shippingState}"  autocomplete="off">						
								</td>
								<td>
									
									<input type="text"  class="textbox" name="estimatedFreight" value="${editFreight.estimatedFreight}"  autocomplete="off">
								</td>
								
								<td>
									<select name="grade" id="grade" required="required">
										<option value="">Select</option>
										<c:forEach items="${gradeName}" var="gn">
												<c:when test="${editFreight.gradeid eq gn.id}">
													<option value="${gn.gradeid}" selected="selected">${gn.grade}</option>
												</c:when>
												<c:otherwise>
													<option value="${gn.gradeid}">${gn.grade}(${gn.gradeid })</option>
												</c:otherwise>
											<%-- 	<option value="${gn.gradeid}">${gn.grade}(${gn.gradeid })</option> --%>
										</c:forEach>
										
										
										
										
										<%-- <c:forEach items="${destinations}" var="destinations">
								<c:choose>
									<c:when test="${destinations.key eq wd.destination}">
										<option value="${destinations.key}" selected="selected">${destinations.value}</option>
									</c:when>
									<c:otherwise>
										<option value="${destinations.key}">${destinations.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach> --%>
							
							
							
							
									</select>
								</td>								
							</tr>
							</c:forEach>
							</c:if>			
						</tbody>
								
								
							
						
					</table>

</div>

			</div>

		</div>


	</div>

</body>
</html>
