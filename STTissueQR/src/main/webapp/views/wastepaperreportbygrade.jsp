<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepaperreportbygrade/load" var="viewdataURL" />
<spring:url value="/wastepaperreportbygrade/export" var="byGradeExportURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>
<script>
$(document).ready(function(){
	$("#viewbutton").click(function(){
    	var machinType = $('select[name=grade]').val();
    	if(machinType== null || machinType==""){
        	alert("Please Select The Grade.");
        	return false;
        }
    });
});
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
					<span class="label">Waste Paper Report By Grade</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
						<form action="${viewdataURL}" method="get">
							<td>From:<input type="text" value="${sdate}" name="sdate"></td>
							<td>To:<input type="text" value="${edate}" name="edate"></td>
							<td>Grade:
								<!--666 Value Is For All Grades Developer Can Change Accordingly,It Assumed Only -->
								<select name="grade" id="grade" style="width: 200px;">
										<option value="">Select</option>
										<option value="666">All</option>
										<c:forEach items="${gradeName}" var="gn">
												<option value="${gn.gradeid}">${gn.grade}</option>
										</c:forEach>
								</select>
							</td>
							<td><input type="submit" id="viewbutton" value="View" name="viewbutton"/></td>
						</form>
						 <c:if test="${viewpage}">
								<form action="${byGradeExportURL}" method="POST">
										<td><input type="hidden" name="startdate" value="${sdate}" ></td>
										<td><input type="hidden" name="enddate" value="${edate}"></td>
										<td><input type="hidden" name="grade" value="${srchdgradeid}"></td>
										<td><button id="exportbutton">Export</button></td>
								</form>
						</c:if>
						</tr>
					</table>
				</div>
				<c:if test="${fn:length(details) > 0 }">	
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<!-- <td style="width: 120px;">Receipt No</td> -->
			<td style="width: 120px;">Master PO</td>
			<td style="width: 120px;">Release No</td>
			<td style="width: 120px;">Vandor Name</td>
			<td style="width: 130px;">Droped Date</td>
			<td style="width: 120px;">Unloaded Date</td>
			<td style="width: 120px;">Item Description</td>
			<td style="width: 120px;">Bales</td>
			<td style="width: 120px;">Net Tons</td>
			<td style="width: 120px;">$ Price Per Ton</td>
			<td style="width: 120px;">$ Extention</td>
			<td style="width: 120px;">Carrier</td>
			<td style="width: 120px;">Trailer No</td>
			<td style="width: 120px;">Shipping City</td>
			<td style="width: 120px;">Shipping State</td>
			<td style="width: 120px;">Estimated Freight</td>
			<td style="width: 120px;">Freight Invoiced $</td>
			<td style="width: 120px;">$ Freight CHBK</td>
			<td style="width: 120px;">$ Grand Total</td>
			<td style="width: 120px;">Destination</td>
			<td style="width: 120px;">Comment</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${details}" var="gd">
	<tr>
				<!-- <td>RN</td> -->
				<td>${gd.masterPO}</td>
				<td>${gd.releaseNo}</td>
				<td>${gd.vandorName}</td>
				<td><fmt:formatDate value="${gd.droppedDate}" pattern="MM-dd-yyyy" var="droppedDate"/>${droppedDate}</td>
				<td><fmt:formatDate value="${gd.unloadedDate}" pattern="MM-dd-yyyy" var="unloadedDate"/>${unloadedDate}</td>
				<td>${gd.itemDescription}</td>
				<td>${gd.bales}</td>
				<td><fmt:formatNumber value="${gd.netTons}" var="nettons" maxFractionDigits="2"/>${nettons}</td>
				<td>$${gd.pricePerTon}</td>
				<td><fmt:formatNumber value="${gd.extention}" maxFractionDigits="2" var="extention"/>$${extention}</td>
				<td>${gd.carrier}</td>
				<td>${gd.trailerNo}</td>
				<td>${gd.shippingCity}</td>
				<td>${gd.shippingState }</td>
				<td><fmt:formatNumber value="${gd.estimatedFreight}" maxFractionDigits="4" var="estimatedFreight"/>$${estimatedFreight}</td>
				<td>$${gd.freightInvoiced}</td>
				<c:if test ="${gd.freightCHBKPending eq'Pending'}">
				        <td>Pending</td>
 				</c:if>
 				<c:if test ="${gd.freightCHBKPending ne 'Pending'}">
				        <td>
							<fmt:formatNumber value="${gd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>$(${freightCHBK})
						</td>
 				</c:if>
				<td><fmt:formatNumber value="${gd.grandTotal}" maxFractionDigits="2" var="grandTotal"/>$${grandTotal}</td>
				<td>${gd.destination}</td>
				<td>${gd.comment}</td>
	</tr>	
	</c:forEach>
	<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><b>${wpd.itemDescription} Total</b></td>
				<td><fmt:formatNumber value="${wpd.totalbales}" var="totalbales" maxFractionDigits="2"/><b>${totalbales}</b></td>
				<td><fmt:formatNumber value="${wpd.netTons}" var="netTons" maxFractionDigits="2"/><b>$${netTons}</b></td>
				<td><fmt:formatNumber value="${wpd.pricePerTon}" var="pricePerTon" maxFractionDigits="2"/><b>$${pricePerTon}</b></td>
				<td><fmt:formatNumber value="${extensionTotal}" var="extentiontotal" maxFractionDigits="2"/><b>$${extentiontotal}</b></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><fmt:formatNumber value="${wpd.freightInvoiced}" var="freightInvoiced" maxFractionDigits="2"/><b>$${freightInvoiced}</b></td>
				<td><fmt:formatNumber value="${wpd.freightCHBK}" var="freightCHBK" maxFractionDigits="2"/><b>$${freightCHBK}</b></td>
				<td><fmt:formatNumber value="${wpd.grandTotal}" var="grandTotal" maxFractionDigits="2"/><b>$${grandTotal}</b></td>
				<td></td>
				<td></td>
	</tr>	
	</table>
</c:if>
<c:if test="${fn:length(details) eq 0 }">
<table>
	<thead style="text-align: center;">
		<tr>
			<td style="width: 200px;"><b style="color: red;">No Data Found For This Search</b></td>
		</tr>
	</thead>
</table>
			
</c:if>

			</div>

		</div>


	</div>

</body>
</html>
