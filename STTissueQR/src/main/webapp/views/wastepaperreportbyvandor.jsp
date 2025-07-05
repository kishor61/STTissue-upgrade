<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepaperreportbyvandor/load" var="viewdataURL" />
<spring:url value="/wastepaperreportbyvandor/export" var="byVandorExportURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
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
					<span class="label">Waste Paper Report By Vandor</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
						<form action="${viewdataURL}" method="get">
							<td>From:<input type="text" value="${sdate}" name="sdate"></td>
							<td>To:<input type="text" value="${edate}" name="edate"></td>
							<td>Vendor:
								<%-- <select name="vendor" style="width: 200px;">
										<option value="">Select</option>
										<c:forEach items="${vendorName}" var="ctg">
												<option value="${ctg.vendorname}">${ctg.vendorname}</option>
										</c:forEach>
										
									<c:forEach items="${vendorName }" var="ctg">
										<c:choose>
											<c:when test="${ctg eq  0 }">
												<option value="${selectedVandor}" selected="selected">${selectedVandor}</option>
											</c:when>
											<c:otherwise>
												<option value="${ctg.vendorname}">${ctg.vendorname}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
										
								</select> --%>
								
								
								<select name="vendor" style="width: 200px; padding: 2px;" tabindex="2">
									<option value="">Select</option>
									<c:forEach items="${vendorName}" var="ctg">
										<c:choose>
											<c:when test="${srchdendor eq ctg.vendorname }">
												<option value="${ctg.vendorname}" selected="selected">${ctg.vendorname}</option>																
											</c:when>
											<c:otherwise>
												<option value="${ctg.vendorname}" >${ctg.vendorname}</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</select>
							</td>
							<td><input type="submit" id="viewbutton" value="View" name="viewbutton"></td>
						</form>
						<c:if test="${viewpage}">
								<form action="${byVandorExportURL}" method="POST">
										<td><input type="hidden" name="startdate" value="${sdate}" ></td>
										<td><input type="hidden" name="enddate" value="${edate}"></td>
										<td><input type="hidden" name="vendor" value="${srchdendor}"></td>
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
		<c:forEach items="${details}" var="vd">
	<tr>
				<!-- <td>RN</td> -->
				<td>${vd.masterPO}</td>
				<td>${vd.releaseNo}</td>
				<td>${vd.vandorName}</td>
				<td><fmt:formatDate value="${vd.droppedDate}" pattern="MM-dd-yyyy" var="droppedDate"/>${droppedDate}</td>
				<td><fmt:formatDate value="${vd.unloadedDate}" pattern="MM-dd-yyyy" var="unloadedDate"/>${unloadedDate}</td>
				<td>${vd.itemDescription}</td>
				<td>${vd.bales}</td>
				<td><fmt:formatNumber value="${vd.netTons}" var="nettons" maxFractionDigits="2"/>${nettons}</td>
				<td>$${vd.pricePerTon}</td>
				<td><fmt:formatNumber value="${vd.extention}" maxFractionDigits="2" var="extention"/>$${extention}</td>
				<td>${vd.carrier}</td>
				<td>${vd.trailerNo}</td>
				<td>${vd.shippingCity}</td>
				<td>${vd.shippingState }</td>
				<td><fmt:formatNumber value="${vd.estimatedFreight}" maxFractionDigits="4" var="estimatedFreight"/>$${estimatedFreight}</td>
				<td>$${vd.freightInvoiced}</td>
				<c:if test ="${vd.freightCHBKPending eq'Pending'}">
				        <td>Pending</td>
 				</c:if>
 				<c:if test ="${vd.freightCHBKPending ne 'Pending'}">
				        <td>
							<fmt:formatNumber value="${vd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>$(${freightCHBK})
						</td>
 				</c:if>
				<td><fmt:formatNumber value="${vd.grandTotal}" maxFractionDigits="2" var="grandTotal"/>$${grandTotal}</td>
				<td>${vd.destination}</td>
				<td>${vd.comment}</td>
	</tr>	
	</c:forEach>
	<tr>
				<!-- <td></td> -->
				<td></td>
				<td></td>
				<td><b>${wpd.vandorName} Total</b></td>
				<td></td>
				<td></td>
				<td></td>
				<td><fmt:formatNumber value="${wpd.totalbales}" var="totalbales" maxFractionDigits="2"/><b>${totalbales}</b></td>
				<td><fmt:formatNumber value="${wpd.netTons}" var="netTons" maxFractionDigits="2"/><b>${netTons}</b></td>
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
<br><br>
<c:if test="${fn:length(details) eq 0 }">
	<div>
		<center><h2><b style=" color: red;font-size: initial;">No Data Available For The Selected Criteria.</b></h2></center>
	</div>	
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
