<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/wastepaperreceivingreport/report" var="viewdataURL" />
<spring:url value="/wastepaperreceivingreport/exportpdf" var="exportPdfURL"/>
<spring:url value="/wastepaperreceivingreport/exportexcel" var="exportExcelURL"/>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Waste Paper Receiving Report</span>
				</div>
				<div class="table-selector">
					<table>
						<tr>
							<td>
								<form action="${viewdataURL}" method="get">
									<td>Release Number:</td>
									<td><input type="text" value="${releaseNumber}" name="releaseNumber"/></td>
									<td><input type="submit" value="View" name="View"></td>
								</form>
							</td>
							<c:if test="${viewpage}">
							<td>
								<form action="${exportPdfURL}" method="POST">
									<td><input type="hidden" value="${releaseNumber}" name="releaseNumber"/></td>
									<td><button id="exportbutton">Export PDF</button></td>
								</form>
							</td>
							<td>
								<form action="${exportExcelURL}" method="POST">
									<td><input type="hidden" value="${releaseNumber}" name="releaseNumber"/></td>
									<td><button id="exportexcelbutton">Export Excel</button></td>
								</form>
							</td>
							<c:if test="${receivinfReport.size() eq '2'}">
								<td>
									<td><h3><b style="color: green;">This Release have <b style="color: red;">${receivinfReport.size()}</b> Grades.</b></h3></td>
								</td>
							</c:if>
							
							</c:if>	
						</tr>
					</table>

				</div>
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{font-family:Arial, sans-serif;font-size:11px;padding:5px 0px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;width: 154px;}
.tg th{font-family:Arial, sans-serif;font-size:11px;font-weight:normal;padding:5px 0px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
</style>
<br><br>
<center>
<c:if test="${viewpage}">

<table style="border: 1px solid;width: 623px;">
	<tr>	
		<td style="background-color:#CB842E;font-size: 12px !important;padding: 6px;"><center><b><font size="6" color="black">ST Tissue, LLC WASTEPAPER RECEIVING REPORT</font></b></center></td>
	</tr>
</table>
<%-- <c:forEach items="${receivinfReport}" var="wd">
<table class="tg" style="border: 2px solid;">
  <!-- <tr>
    <td class="tg-031e">ST Receipt #</td>
    <td class="tg-031e" style="border: 0px;"></td>
    <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e"></td>
  </tr> -->
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Master PO #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.masterPO}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Release #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${wd.releaseNo}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Vendor</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.vandorName}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Grade Ordered</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${wd.itemDescription}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Date Dropped</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatDate value="${wd.droppedDate}" pattern="MM/dd/yyyy"/></td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Date Unloaded</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatDate value="${wd.droppedDate}" pattern="MM/dd/yyyy"/></td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Carrier</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.carrier}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Trailer #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.trailerNo}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Origin</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${wd.shippingCity},${wd.shippingState}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Weight</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></td>
    <td class="tg-031e" style="border: 0px;"></td>
  </tr>
  <tr>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Received Grade</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Bales</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Received Weight</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Tons</b></center></td>
  </tr>
  <tr>
    <td class="tg-031e"><b><center>${wd.itemDescription}</b></center></td>
    <td class="tg-031e"><center>${wd.bales}</center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/></center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Total Of Good Received Weight</b></center></td>
   	<td class="tg-031e"><center>${wd.bales}</center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/></center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Total Reject</b></center></td>
    <td class="tg-031e"><center>0</center></td>
    <td class="tg-031e"><center>0.0</center></td>
    <td class="tg-031e"><center>0.0</center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Freight Charge Back</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    
    			<c:if test ="${wd.freightCHBKPending eq'Pending'}">
				        <td class="tg-031e"><center>Pending</center></td>
 				</c:if>
 				<c:if test ="${wd.freightCHBKPending ne 'Pending'}">
				        <center><td class="tg-031e">
							<fmt:formatNumber value="${wd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>
						</td></center>
 				</c:if>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Detention Charges</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"><center>${wd.detentionCharges}</center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Tonu Charges</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
  </tr>
  
</table>
	<c:if test="${receivinfReport.size() eq '2'}">
		&nbsp;
	</c:if>
</c:forEach>  --%>

<c:if test="${fn:length(receivinfReport) eq 1}">
   <c:forEach items="${receivinfReport}" var="wd">
<table class="tg" style="border: 2px solid;">
  <!-- <tr>
    <td class="tg-031e">ST Receipt #</td>
    <td class="tg-031e" style="border: 0px;"></td>
    <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e"></td>
  </tr> -->
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Master PO #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.masterPO}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Release #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${wd.releaseNo}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Vendor</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.vandorName}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Grade Ordered</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${wd.itemDescription}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Date Dropped</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatDate value="${wd.droppedDate}" pattern="MM/dd/yyyy"/></td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Date Unloaded</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatDate value="${wd.droppedDate}" pattern="MM/dd/yyyy"/></td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Carrier</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.carrier}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Trailer #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${wd.trailerNo}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Origin</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${wd.shippingCity},${wd.shippingState}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Weight</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></td>
    <td class="tg-031e" style="border: 0px;"></td>
  </tr>
  <tr>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Received Grade</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Bales</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Received Weight</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Tons</b></center></td>
  </tr>
  <tr>
    <td class="tg-031e"><b><center>${wd.itemDescription}</b></center></td>
    <td class="tg-031e"><center>${wd.bales}</center></td>
    <%-- <td class="tg-031e"><center>${wd.bales-rejectbales}</center></td> --%>
    <%-- <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000-rejectweight}" maxFractionDigits="2"/></center></td> --%>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></center></td>
   <%--  <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons-rejectweight/2000}" maxFractionDigits="2"/></center></td> --%>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/></center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Total Of Good Received Weight</b></center></td>
   	<td class="tg-031e"><center>${wd.bales}</center></td>
   	<%-- <td class="tg-031e"><center>${wd.bales-rejectbales}</center></td> --%>
   <%--  <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000-rejectweight}" maxFractionDigits="2"/></center></td> --%>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></center></td>
    <%-- <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons-rejectweight/2000}" maxFractionDigits="2"/></center></td> --%>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/></center></td>
  </tr>
  <%-- <tr>
    <td class="tg-031e"><center><b>Total Reject</b></center></td>
     <td class="tg-031e"><center>0</center></td>
    <td class="tg-031e"><center>0</center></td>
    <td class="tg-031e"><center>0</center></td>
  </tr> --%>
<c:if test="${fn:length(rejectBales) eq 0}">
  <tr>
    <td class="tg-031e"><center><b>Total Reject</b></center></td>
    <td class="tg-031e"><center>0</center></td>
    <td class="tg-031e"><center>0.0</center></td>
    <td class="tg-031e"><center>0.0</center></td>
  </tr>
</c:if>
<c:if test="${fn:length(rejectBales) gt 0}">
  <tr>
    <td class="tg-031e"><center><b>Total Reject</b></center></td>
    <td class="tg-031e"><center>${rejectbales}</center></td>
    <td class="tg-031e"><center>${rejectweight}</center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${rejectweight/2000}" maxFractionDigits="2"/></center></td>
  </tr>
</c:if>
  <tr>
    <td class="tg-031e"><center><b>Freight Charge Back</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    
    			<c:if test ="${wd.freightCHBKPending eq'Pending'}">
				        <td class="tg-031e"><center>Pending</center></td>
 				</c:if>
 				<c:if test ="${wd.freightCHBKPending ne 'Pending'}">
				        <center><td class="tg-031e">
							<fmt:formatNumber value="${wd.freightCHBK}" maxFractionDigits="2" var="freightCHBK"/>
							<center>${freightCHBK}</center>
						</td></center>
 				</c:if>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Detention Charges</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"><center>${wd.detentionCharges}</center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Tonu Charges</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
  </tr>
  
</table>
	<c:if test="${receivinfReport.size() eq '2'}">
		&nbsp;
	</c:if>
</c:forEach> 
</c:if>

<c:if test="${fn:length(receivinfReport) gt 1}">
<table class="tg" style="border: 2px solid;">
  <!-- <tr>
    <td class="tg-031e">ST Receipt #</td>
    <td class="tg-031e" style="border: 0px;"></td>
    <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e"></td>
  </tr> -->
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Master PO #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${receivinfReport[0].masterPO}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Release #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${receivinfReport[0].releaseNo}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Vendor</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${receivinfReport[0].vandorName}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Grade Ordered</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${receivinfReport[0].itemDescription}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Date Dropped</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatDate value="${receivinfReport[0].droppedDate}" pattern="MM/dd/yyyy"/></td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Date Unloaded</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatDate value="${receivinfReport[0].droppedDate}" pattern="MM/dd/yyyy"/></td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Carrier</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${receivinfReport[0].carrier}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Trailer #</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
      <td class="tg-031e" style="border: 0px;">${receivinfReport[0].trailerNo}</td>
     <td class="tg-031e" style="border: 0px;"></td>
   
  </tr>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Origin</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;">${receivinfReport[0].shippingCity},${receivinfReport[0].shippingState}</td>
     <td class="tg-031e" style="border: 0px;"></td>
    
  </tr>
  <c:forEach items="${receivinfReport}" var="wd">
     			<c:set value="${totalgradeweight+wd.netTons}" var="totalgradeweight"/>
  </c:forEach>
  <tr>
    <td class="tg-031e" style="border: 0px;"><b style="padding: 0px 0px 0px 50px;">Weight</b></td>
     <td class="tg-031e" style="border: 0px;"></td>
     <td class="tg-031e" style="border: 0px;"><fmt:formatNumber value="${totalgradeweight*2000}" maxFractionDigits="2"/></td>
    <td class="tg-031e" style="border: 0px;"></td>
  </tr>
  <tr>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Received Grade</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Bales</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Received Weight</b></center></td>
    <td class="tg-031e" style="background-color: gainsboro;"><center><b>Tons</b></center></td>
  </tr>
   <c:forEach items="${receivinfReport}" var="wd">
  <tr>
    <td class="tg-031e"><b><center>${wd.itemDescription}</b></center></td>
    <td class="tg-031e"><center>${wd.bales}</center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons*2000}" maxFractionDigits="2"/></center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${wd.netTons}" maxFractionDigits="2"/></center></td>
    
    <c:set value="${totalgradebales+wd.bales}" var="totalgradebales"/>
    <c:set value="${totalgradeweight1+wd.netTons}" var="totalgradeweight1"/>
    <c:set value="${totalnettons+wd.netTons}" var="totalnettons"/>
  </tr>
  </c:forEach>
  <tr>
    <td class="tg-031e"><center><b>Total Of Good Received Weight</b></center></td>
   	<td class="tg-031e"><center>${totalgradebales}</center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${totalgradeweight1*2000}" maxFractionDigits="2"/></center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${totalnettons}" maxFractionDigits="2"/></center></td>
  </tr>
<c:if test="${fn:length(rejectBales) eq 0}">
  <tr>
    <td class="tg-031e"><center><b>Total Reject</b></center></td>
    <td class="tg-031e"><center>0</center></td>
    <td class="tg-031e"><center>0.0</center></td>
    <td class="tg-031e"><center>0.0</center></td>
  </tr>
</c:if>
<c:if test="${fn:length(rejectBales) gt 0}">
  <tr>
    <td class="tg-031e"><center><b>Total Reject</b></center></td>
    <td class="tg-031e"><center>${rejectbales}</center></td>
    <td class="tg-031e"><center>${rejectweight}</center></td>
    <td class="tg-031e"><center><fmt:formatNumber value="${rejectweight/2000}" maxFractionDigits="2"/></center></td>
  </tr>
</c:if>
  <tr>
    <td class="tg-031e"><center><b>Freight Charge Back</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <c:forEach items="${receivinfReport}" var="wd">
      <c:set value="${totalFCB+wd.freightCHBK}" var="totalFCB"/>
    </c:forEach>
    			<c:if test ="${receivinfReport[0].freightCHBKPending eq'Pending'}">
				        <td class="tg-031e"><center>Pending</center></td>
 				</c:if>
 				<c:if test ="${receivinfReport[0].freightCHBKPending ne 'Pending'}">
				        <center><td class="tg-031e">
							<fmt:formatNumber value="${totalFCB}" maxFractionDigits="2" var="freightCHBK"/>
							<center>${freightCHBK}</center>
						</td></center>
 				</c:if>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Detention Charges</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"><center>${receivinfReport[0].detentionCharges+receivinfReport[1].detentionCharges}</center></td>
  </tr>
  <tr>
    <td class="tg-031e"><center><b>Tonu Charges</b></center></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
    <td class="tg-031e"></td>
  </tr>
  
</table>
	<%-- <c:if test="${receivinfReport.size() eq '2'}">
		&nbsp;
	</c:if> --%>

</c:if>



						<table style="border: 1px solid; width: 623px;">
							<tr>
								<td
									style="background-color: yellow; font-size: 12px !important; padding: 6px;"><center>
										<b><font size="6" color="black">Copyright 2008 ST
												Tissue LLC</font></b>
									</center></td>
							</tr>
						</table>
					</c:if>
</center>
			</div>

		</div>


	</div>

</body>
</html>
