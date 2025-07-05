<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
	
	table td{
		text-align: center;
	}
	table td input[type=text]{
		font-size: 12px;
		font-family: sans-serif;
		text-align: center!important;
		width: 96%;
	}
	table .textbox{
		width: 40px;
	}
</style>
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
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Converting Line 171 Reporting - Ship To Date Report By SKU Code</span>
				</div>
				<div class="table-selector">
					<spring:url value="/convertinglinereport/shiptodatereportbyskucodewise/view/data" var="viewURL"/>
					<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td style="display: none;">Start Date:</td>
							<td style="display: none;"><input readonly="readonly" type="text" name="sdate" value="${sdate}"></td>
							<td style="display: none;">End Date:</td>
							<td style="display: none;"><input readonly="readonly" type="text" name="edate" value="${edate}"></td>
							
							<td>Start Month: 
								 <select name="month" id="month" style="width: 200px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test="${month eq ''}">
									<option value="">Select</option>
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '01'}">
									<option value="01" selected="selected">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '02'}">
									<option value="01" >January</option>
									<option value="02" selected="selected">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '03'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03  selected="selected"">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '04'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04"  selected="selected">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '05'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05" selected="selected">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '06'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06" selected="selected">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '07'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07" selected="selected">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '08'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08" selected="selected">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '09'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09" selected="selected">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '10'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10" selected="selected">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '11'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11" selected="selected">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${month eq '12'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12" selected="selected">December</option>
									</c:if>	
									
								</select>
							</td>
							<td>End Month: 
								 <select name="emonth" id="emonth" style="width: 200px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test="${emonth eq ''}">
									<option value="">Select</option>
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '01'}">
									<option value="01" selected="selected">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '02'}">
									<option value="01" >January</option>
									<option value="02" selected="selected">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '03'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03  selected="selected"">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '04'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04"  selected="selected">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '05'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05" selected="selected">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '06'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06" selected="selected">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '07'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07" selected="selected">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '08'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08" selected="selected">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '09'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09" selected="selected">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '10'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10" selected="selected">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '11'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11" selected="selected">November</option>
									<option value="12">December</option>
									</c:if>	
									<c:if test="${emonth eq '12'}">
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12" selected="selected">December</option>
									</c:if>	
									
								</select>
							</td>
							<td>Year: 
								 <select name="year" id="year" style="width: 200px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test="${year eq ''}">
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									</c:if>
									<c:if test="${year eq '2016'}">
									<option value="2016" selected="selected">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									</c:if>
									<c:if test="${year eq '2017'}">
									<option value="2016">2016</option>
									<option value="2017" selected="selected">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									</c:if>
									<c:if test="${year eq '2018'}">
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018" selected="selected">2018</option>
									<option value="2019">2019</option>
									</c:if>
									<c:if test="${year eq '2019'}">
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019" selected="selected">2019</option>
									</c:if>
								</select>
							</td>
							<td>SKU Code: 
								<select name="skucode" id="skucode" style="width: 200px; padding: 2px;" required="required">
									<option value="-1">Select</option>
									<option value="All" selected="selected">All</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq searchedskucode }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
											</c:when>
											<c:otherwise>
												<option value="${skucode.productcode}">${skucode.productcode}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
								<!-- <input id="exportbtn" type="button" value="Export" onclick="exportExcel()"/> -->
							</td>
						</tr>
					</table>
					</form>
					

				</div>
<c:if test="${fn:length(skuWiseData)>0}">
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table class="table" id="yielddatatable">
						<thead style="font-size: 12px;">
						<tr>
								<th class="trobjrow" colspan="2" style="width:80px;">SKU Code Information</th>
								<th class="trobjrow" colspan="15" style="width:80px;">Forecast</th>
							</tr>
						<tr>
								<!-- <th style="width:200px;">Date</th> -->
								<!-- <th style="width:200px;">Month</th> -->
								<!-- <th style="width:200px;">Customer Name</th> -->
								<th style="width:80px;">SKU Code</th>
								<th style="width:145px;"></th>
							<c:if test="${January}">
									<th style="width:80px;">January</th>
								</c:if>
								<c:if test="${February}">
									<th style="width:80px;">February</th>
								</c:if>
								<c:if test="${March}">
									<th style="width:80px;">March</th>
								</c:if>
								<c:if test="${April}">
									<th style="width:80px;">April</th>
								</c:if>
								<c:if test="${May}">
									<th style="width:80px;">May</th>
								</c:if>
								<c:if test="${June}">
									<th style="width:80px;">June</th>
								</c:if>
								<c:if test="${July}">
									<th style="width:80px;">July</th>
								</c:if>
								<c:if test="${August}">
									<th style="width:80px;">August</th>
								</c:if>
								<c:if test="${September}">
									<th style="width:80px;">September</th>
								</c:if>
								<c:if test="${October}">
									<th style="width:80px;">October</th>
								</c:if>
								<c:if test="${November}">
									<th style="width:80px;">November</th>
								</c:if>
								<c:if test="${December}">
									<th style="width:80px;">December</th>
								</c:if>	
							</tr>
						</thead>
						<tbody id="yielddatainput">
							
									<c:forEach items="${skuWiseData}" var="data">
											<tr>
													<%-- <td><fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy" var="dateH"/>${dateH}</td> --%>
													<%-- <td rowspan="4"> ${data.month}</td> --%>
													<%-- <td rowspan="4"style="background-color: rgba(255, 188, 0, 0.22);"><b> ${data.customer}</b></td> --%>
													<td rowspan="5"style="background-color: rgba(255, 188, 0, 0.22);"><b> ${data.skucode}</b></td>
													<td style="background-color: #ffbc00;"><b>Forecast</b></td>
													<c:if test="${January}">
														<td> ${data.january}</td>
													</c:if>
													<c:if test="${February}">
														<td> ${data.february}</td>
													</c:if>
													<c:if test="${March}">
														<td> ${data.march}</td>
													</c:if>
													<c:if test="${April}">
														<td> ${data.april}</td>
													</c:if>
													<c:if test="${May}">
														<td> ${data.may}</td>
													</c:if>
													<c:if test="${June}">
														<td> ${data.june}</td>
													</c:if>
													<c:if test="${July}">
														<td> ${data.july}</td>
													</c:if>
													<c:if test="${August}">
														<td> ${data.august}</td>
													</c:if>
													<c:if test="${September}">
														<td> ${data.september}</td>
													</c:if>
													<c:if test="${October}">
														<td> ${data.october}</td>
													</c:if>
													<c:if test="${November}">
														<td> ${data.november}</td>
													</c:if>
													<c:if test="${December}">
														<td> ${data.december}</td>
													</c:if>
											</tr>	
											<tr>
													<!-- <td  rowspan="2"></td> -->
													<td  style="background-color: #ffbc00;"><b>Order PO Ship To Date Quantity</b></td>
													<c:if test="${January}">
														<td> ${data.januaryorderedpo}</td>
													</c:if>
													<c:if test="${February}">
														<td> ${data.februaryorderedpo}</td>
													</c:if>
													<c:if test="${March}">
														<td> ${data.marchorderedpo}</td>
													</c:if>
													<c:if test="${April}">
														<td> ${data.aprilorderedpo}</td>
													</c:if>
													<c:if test="${May}">
														<td> ${data.mayorderedpo}</td>
													</c:if>
													<c:if test="${June}">
														<td> ${data.juneorderedpo}</td>
													</c:if>
													<c:if test="${July}">
														<td> ${data.julyorderedpo}</td>
													</c:if>
													<c:if test="${August}">
														<td> ${data.augustorderedpo}</td>
													</c:if>
													<c:if test="${September}">
														<td> ${data.septemberorderedpo}</td>
													</c:if>
													<c:if test="${October}">
														<td> ${data.octoberorderedpo}</td>
													</c:if>
													<c:if test="${November}">
														<td> ${data.novemberorderedpo}</td>
													</c:if>
													<c:if test="${December}">
														<td> ${data.decemberorderedpo}</td>
													</c:if>
											</tr>	
											<tr>
													<!-- <td  rowspan="2"></td> -->
													<td  style="background-color: #ffbc00;"><b> Order Shipped Quantity</b></td>
													<c:if test="${January}">
														<td> ${data.januaryqty}</td>
													</c:if>
													<c:if test="${February}">
														<td> ${data.februaryqty}</td>
													</c:if>
													<c:if test="${March}">
														<td> ${data.marchqty}</td>
													</c:if>
													<c:if test="${April}">
														<td> ${data.aprilqty}</td>
													</c:if>
													<c:if test="${May}">
														<td> ${data.mayqty}</td>
													</c:if>
													<c:if test="${June}">
														<td> ${data.juneqty}</td>
													</c:if>
													<c:if test="${July}">
														<td> ${data.julyqty}</td>
													</c:if>
													<c:if test="${August}">
														<td> ${data.augustqty}</td>
													</c:if>
													<c:if test="${September}">
														<td> ${data.septemberqty}</td>
													</c:if>
													<c:if test="${October}">
														<td> ${data.octoberqty}</td>
													</c:if>
													<c:if test="${November}">
														<td> ${data.novemberqty}</td>
													</c:if>
													<c:if test="${December}">
														<td> ${data.decemberqty}</td>
													</c:if>
											</tr>	
											<tr style="background-color: #F5DA81;">
													<td style="background-color: #ffbc00;"><b>Difference</b></td>
													<c:if test="${January}">
														<td><b> ${data.januaryqty-data.january}</b>  </td>
													</c:if>
													<c:if test="${February}">
														<td><b> ${data.februaryqty-data.february} </b> </td>
													</c:if>
													<c:if test="${March}">
														<td><b> ${data.marchqty-data.march} </b></td>
													</c:if>
													<c:if test="${April}">
														<td><b> ${data.aprilqty-data.april}  </b></td>
													</c:if>
													<c:if test="${May}">
														<td><b> ${data.mayqty-data.may} </b></td>
													</c:if>
													<c:if test="${June}">
														<td><b> ${data.juneqty-data.june} </b></td>
													</c:if>
													<c:if test="${July}">
														<td><b> ${data.julyqty-data.july}  </b></td>
													</c:if>
													<c:if test="${August}">
														<td><b> ${data.augustqty-data.august}</b> </td>
													</c:if>
													<c:if test="${September}">
														<td><b> ${data.septemberqty-data.september} </b> </td>
													</c:if>
													<c:if test="${October}">
														<td><b> ${data.octoberqty-data.october}  </b></td>
													</c:if>
													<c:if test="${November}">
														<td><b> ${data.novemberqty-data.november}</b>  </td>
													</c:if>
													<c:if test="${December}">
														<td><b> ${data.decemberqty-data.december}</b>  </td>
													</c:if>
											</tr>
											<tr style="background-color: #F5DA81;">
													<td style="background-color: #ffbc00;"><b>Forecast %</b></td>
													<c:if test="${January}">
													<c:if test ="${data.january eq 0}">
														<td> <b><fmt:formatNumber value="${(data.januaryqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${data.january gt 0}">
														<td> <b><fmt:formatNumber value="${(data.januaryqty/data.january)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
													<c:if test="${February}">
													<c:if test ="${data.february eq 0}">
														<td><b> <fmt:formatNumber value="${(data.februaryqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.february gt 0}">
														<td><b> <fmt:formatNumber value="${(data.februaryqty/data.february)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${March}">
													<c:if test ="${data.march eq 0}">
														<td><b> <fmt:formatNumber value="${(data.marchqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.march gt 0}">
														<td><b> <fmt:formatNumber value="${(data.marchqty/data.march)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${April}">
													<c:if test ="${data.april eq 0}">
														<td><b> <fmt:formatNumber value="${(data.aprilqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.april gt 0}">
														<td><b> <fmt:formatNumber value="${(data.aprilqty/data.april)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${May}">
													<c:if test ="${data.may eq 0}">
														<td><b> <fmt:formatNumber value="${(data.mayqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.may gt 0}">
														<td><b> <fmt:formatNumber value="${(data.mayqty/data.may)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${June}">
													<c:if test ="${data.june eq 0}">
														<td><b> <fmt:formatNumber value="${(data.juneqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${data.june gt 0}">
														<td><b> <fmt:formatNumber value="${(data.juneqty/data.june)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
													<c:if test="${July}">
													<c:if test ="${data.july eq 0}">
														<td><b> <fmt:formatNumber value="${(data.julyqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.july gt 0}">
														<td><b> <fmt:formatNumber value="${(data.julyqty/data.july)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${August}">
													<c:if test ="${data.august eq 0}">
														<td><b> <fmt:formatNumber value="${(data.augustqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.august gt 0}">
														<td><b> <fmt:formatNumber value="${(data.augustqty/data.august)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${September}">
													<c:if test ="${data.september eq 0}">
														<td><b> <fmt:formatNumber value="${(data.septemberqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${data.september gt 0}">
														<td><b> <fmt:formatNumber value="${(data.septemberqty/data.september)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
													<c:if test="${October}">
													<c:if test ="${data.october eq 0}">
														<td><b> <fmt:formatNumber value="${(data.octoberqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.october gt 0}">
														<td><b> <fmt:formatNumber value="${(data.octoberqty/data.october)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${November}">
													<c:if test ="${data.november eq 0}">
														<td><b> <fmt:formatNumber value="${(data.novemberqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${data.november gt 0}">
														<td><b> <fmt:formatNumber value="${(data.novemberqty/data.november)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${December}">
													<c:if test ="${data.december eq 0}">
														<td><b> <fmt:formatNumber value="${(data.decemberqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${data.december gt 0}">
														<td><b> <fmt:formatNumber value="${(data.decemberqty/data.december)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
											</tr>	
											<c:if test="${fn:length(skuWiseData)>1}">
													<td colspan="16" style="border: 0px !important;">&nbsp;</td>
											</c:if>	
											
										</c:forEach>	
										
										<!-- For Grand Total -->
											<br />
											<tr>
													<%-- <td><fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy" var="dateH"/>${dateH}</td> --%>
													<%-- <td rowspan="4"> ${data.month}</td> --%>
													<!-- <td rowspan="4" style="background-color: rgb(90, 158, 48);"><b></b></td> -->
													<td rowspan="5" style="background-color: rgb(90, 158, 48);"><b>Grand Total</b></td>
													<td style="background-color: #0095ff;"><b>Forecast</b></td>
													 <c:forEach items="${skuWiseData}" var="data">
														 <c:set value="${totaljanuary+data.january}" var="totaljanuary"/>
														 <c:set value="${totalfebruary+data.february}" var="totalfebruary"/>
														 <c:set value="${totalmarch+data.march}" var="totalmarch"/>
														 <c:set value="${totalapril+data.april}" var="totalapril"/>
														 <c:set value="${totalmay+data.may}" var="totalmay"/>
														 <c:set value="${totaljune+data.june}" var="totaljune"/>
														 <c:set value="${totaljuly+data.july}" var="totaljuly"/>
														 <c:set value="${totalaugust+data.august}" var="totalaugust"/>
														 <c:set value="${totalseptember+data.september}" var="totalseptember"/>
														 <c:set value="${totaloctober+data.october}" var="totaloctober"/>
														 <c:set value="${totalnovember+data.november}" var="totalnovember"/>
														 <c:set value="${totaldecember+data.december}" var="totaldecember"/>
													 </c:forEach>
													<c:if test="${January}">
														<td>${totaljanuary}</td>
													</c:if>
													<c:if test="${February}">
														<td>${totalfebruary}</td>
													</c:if>
													<c:if test="${March}">	
														<td>${totalmarch}</td>
													</c:if>
													<c:if test="${April}">
														<td>${totalapril}</td>
													</c:if>
													<c:if test="${May}">
														<td>${totalmay}</td>
													</c:if>
													<c:if test="${June}">
														<td>${totaljune}</td>
													</c:if>
													<c:if test="${July}">
														<td>${totaljuly}</td>
													</c:if>
													<c:if test="${August}">
														<td>${totalaugust}</td>
													</c:if>
													<c:if test="${September}">
														<td>${totalseptember}</td>
													</c:if>	
													<c:if test="${October}">
														<td>${totaloctober}</td>
													</c:if>
													<c:if test="${November}">
														<td>${totalnovember}</td>
													</c:if>
													<c:if test="${December}">
														<td>${totaldecember}</td>
													</c:if>
											</tr>	
											<tr>
											<!-- <td  rowspan="2"></td> -->
												<td  style="background-color: #0095ff;"><b>Order PO Ship To Date Quantity</b></td>
													<c:forEach items="${skuWiseData}" var="data">
														<c:set value="${totaljanuaryorderedpo+data.januaryorderedpo}" var="totaljanuaryorderedpo"/>
														<c:set value="${totalfebruaryorderedpo+data.februaryorderedpo}" var="totalfebruaryorderedpo"/>
														<c:set value="${totalmarchorderedpo+data.marchorderedpo}" var="totalmarchorderedpo"/>
														<c:set value="${totalaprilorderedpo+data.aprilorderedpo}" var="totalaprilorderedpo"/>
														<c:set value="${totalmayorderedpo+data.mayorderedpo}" var="totalmayorderedpo"/>
														<c:set value="${totaljuneorderedpo+data.juneorderedpo}" var="totaljuneorderedpo"/>
														<c:set value="${totaljulyorderedpo+data.julyorderedpo}" var="totaljulyorderedpo"/>
														<c:set value="${totalaugustorderedpo+data.augustorderedpo}" var="totalaugustorderedpo"/>
														<c:set value="${totalseptemberorderedpo+data.septemberorderedpo}" var="totalseptemberorderedpo"/>
														<c:set value="${totaloctoberorderedpo+data.octoberorderedpo}" var="totaloctoberorderedpo"/>
														<c:set value="${totalnovemberorderedpo+data.novemberorderedpo}" var="totalnovemberorderedpo"/>
														<c:set value="${totaldecemberorderedpo+data.decemberorderedpo}" var="totaldecemberorderedpo"/>
													</c:forEach>
												<c:if test="${January}">
													<td>${totaljanuaryorderedpo}</td>
												</c:if>
												<c:if test="${February}">
													<td>${totalfebruaryorderedpo}</td>
												</c:if>
												<c:if test="${March}">
													<td>${totalmarchorderedpo}</td>
												</c:if>
												<c:if test="${April}">
													<td>${totalaprilorderedpo}</td>
												</c:if>
												<c:if test="${May}">
													<td>${totalmayorderedpo}</td>
												</c:if>
												<c:if test="${June}">
													<td>${totaljuneorderedpo}</td>
												</c:if>
												<c:if test="${July}">
													<td>${totaljulyorderedpo}</td>
												</c:if>
												<c:if test="${August}">
													<td>${totalaugustorderedpo}</td>
												</c:if>
												<c:if test="${September}">
													<td>${totalseptemberorderedpo}</td>
												</c:if>
												<c:if test="${October}">
													<td>${totaloctoberorderedpo}</td>
												</c:if>
												<c:if test="${November}">
													<td>${totalnovemberorderedpo}</td>
												</c:if>
												<c:if test="${December}">
													<td>${totaldecemberorderedpo}</td>
												</c:if>
											</tr>	
											<tr>
													<!-- <td  rowspan="2"></td> -->
													<td  style="background-color: #0095ff;"><b> Order Shipped Quantity</b></td>
													 <c:forEach items="${skuWiseData}" var="data">
														 <c:set value="${totaljanuaryqty+data.januaryqty}" var="totaljanuaryqty"/>
														 <c:set value="${totalfebruaryqty+data.februaryqty}" var="totalfebruaryqty"/>
														 <c:set value="${totalmarchqty+data.marchqty}" var="totalmarchqty"/>
														 <c:set value="${totalaprilqty+data.aprilqty}" var="totalaprilqty"/>
														 <c:set value="${totalmayqty+data.mayqty}" var="totalmayqty"/>
														 <c:set value="${totaljuneqty+data.juneqty}" var="totaljuneqty"/>
														 <c:set value="${totaljulyqty+data.julyqty}" var="totaljulyqty"/>
														 <c:set value="${totalaugustqty+data.augustqty}" var="totalaugustqty"/>
														 <c:set value="${totalseptemberqty+data.septemberqty}" var="totalseptemberqty"/>
														 <c:set value="${totaloctoberqty+data.octoberqty}" var="totaloctoberqty"/>
														 <c:set value="${totalnovemberqty+data.novemberqty}" var="totalnovemberqty"/>
														 <c:set value="${totaldecemberqty+data.decemberqty}" var="totaldecemberqty"/>
													 </c:forEach>
													<c:if test="${January}">
														<td>${totaljanuaryqty}</td>
													</c:if>
													<c:if test="${February}">
														<td>${totalfebruaryqty}</td>
													</c:if>
													<c:if test="${March}">
														<td>${totalmarchqty}</td>
													</c:if>
													<c:if test="${April}">
														<td>${totalaprilqty}</td>
													</c:if>
													<c:if test="${May}">
														<td>${totalmayqty}</td>
													</c:if>
													<c:if test="${June}">
														<td>${totaljuneqty}</td>
													</c:if>
													<c:if test="${July}">
														<td>${totaljulyqty}</td>
													</c:if>
													<c:if test="${August}">
														<td>${totalaugustqty}</td>
													</c:if>
													<c:if test="${September}">
														<td>${totalseptemberqty}</td>
													</c:if>
													<c:if test="${October}">
														<td>${totaloctoberqty}</td>
													</c:if>
													<c:if test="${November}">
														<td>${totalnovemberqty}</td>
													</c:if>
													<c:if test="${December}">
														<td>${totaldecemberqty}</td>
													</c:if>
											</tr>	
											
											<tr style="background-color: rgba(204, 255, 0, 0.65);">
													<td style="background-color: #0095ff;"><b>Difference</b></td>
													<c:if test="${January}">
														<td><b>${totaljanuaryqty-totaljanuary}</b></td>
													</c:if>
													<c:if test="${February}">
														<td><b>${totalfebruaryqty-totalfebruary}</b></td>
													</c:if>
													<c:if test="${March}">
														<td><b>${totalmarchqty-totalmarch}</b></td>
													</c:if>
													<c:if test="${April}">
														<td><b>${totalaprilqty-totalapril}</b></td>
													</c:if>
													<c:if test="${May}">
														<td><b>${totalmayqty-totalmay}</b></td>
													</c:if>
													<c:if test="${June}">
														<td><b>${totaljuneqty-totaljune}</b></td>
													</c:if>
													<c:if test="${July}">
														<td><b>${totaljulyqty-totaljuly}</b></td>
													</c:if>
													<c:if test="${August}">
														<td><b>${totalaugustqty-totalaugust}</b></td>
													</c:if>
													<c:if test="${September}">
														<td><b>${totalseptemberqty-totalseptember}</b></td>
													</c:if>
													<c:if test="${October}">
														<td><b>${totaloctoberqty-totaloctober}</b></td>
													</c:if>
													<c:if test="${November}">
														<td><b>${totalnovemberqty-totalnovember}</b></td>
													</c:if>
													<c:if test="${December}">
														<td><b>${totaldecemberqty-totaldecember}</b></td>
													</c:if>
											</tr>
											<tr style="background-color: rgba(204, 255, 0, 0.65);">
													<td style="background-color: #0095ff;"><b>Forecast %</b></td>
													<c:if test="${January}">
													<c:if test ="${totaljanuary eq 0}">
														<td> <b><fmt:formatNumber value="${(totaljanuaryqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${totaljanuary gt 0}">
														<td> <b><fmt:formatNumber value="${(totaljanuaryqty/dtotaljanuary)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
													<c:if test="${February}">
													<c:if test ="${totalfebruary eq 0}">
														<td><b> <fmt:formatNumber value="${(totalfebruaryqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totalfebruary gt 0}">
														<td><b> <fmt:formatNumber value="${(totalfebruaryqty/totalfebruary)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${March}">
													<c:if test ="${totalmarch eq 0}">
														<td><b> <fmt:formatNumber value="${(totalmarchqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totalmarch gt 0}">
														<td><b> <fmt:formatNumber value="${(totalmarchqty/totalmarch)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${April}">
													<c:if test ="${totalapril eq 0}">
														<td><b> <fmt:formatNumber value="${(totalaprilqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totalapril gt 0}">
														<td><b> <fmt:formatNumber value="${(totalaprilqty/totalapril)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${May}">
													<c:if test ="${totalmay eq 0}">
														<td><b> <fmt:formatNumber value="${(totalmayqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totalmay gt 0}">
														<td><b> <fmt:formatNumber value="${(totalmayqty/totalmay)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${June}">
													<c:if test ="${totaljune eq 0}">
														<td><b> <fmt:formatNumber value="${(totaljuneqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${totaljune gt 0}">
														<td><b> <fmt:formatNumber value="${(totaljuneqty/totaljune)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
													<c:if test="${July}">
													<c:if test ="${totaljuly eq 0}">
														<td><b> <fmt:formatNumber value="${(totaljulyqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totaljuly gt 0}">
														<td><b> <fmt:formatNumber value="${(totaljulyqty/totaljuly)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${August}">
													<c:if test ="${totalaugust eq 0}">
														<td><b> <fmt:formatNumber value="${(totalaugustqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totalaugust gt 0}">
														<td><b> <fmt:formatNumber value="${(totalaugustqty/totalaugust)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${September}">
													<c:if test ="${totalseptember eq 0}">
														<td><b> <fmt:formatNumber value="${(totalseptemberqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${totalseptember gt 0}">
														<td><b> <fmt:formatNumber value="${(totalseptemberqty/totalseptember)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
													<c:if test="${October}">
													<c:if test ="${totaloctober eq 0}">
														<td><b> <fmt:formatNumber value="${(totaloctoberqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totaloctober gt 0}">
														<td><b> <fmt:formatNumber value="${(totaloctoberqty/totaloctober)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${November}">
													<c:if test ="${totalnovember eq 0}">
														<td><b> <fmt:formatNumber value="${(totalnovemberqty/1)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													<c:if test ="${totalnovember gt 0}">
														<td><b> <fmt:formatNumber value="${(totalnovemberqty/totalnovember)*100}" maxFractionDigits="2"/> % </b></td>
													</c:if>
													</c:if>
													<c:if test="${December}">
													<c:if test ="${totaldecember eq 0}">
														<td><b> <fmt:formatNumber value="${(totaldecemberqty/1)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													<c:if test ="${totaldecember gt 0}">
														<td><b> <fmt:formatNumber value="${(totaldecemberqty/totaldecember)*100}" maxFractionDigits="2"/> %</b></td>
													</c:if>
													</c:if>
											</tr>	
											<c:if test="${fn:length(skuWiseData)>1}">
													<td colspan="16" style="border: 0px !important;">&nbsp;</td>
											</c:if>			
							</tbody>
								
								
							
						
					</table>
</div>
</c:if>
			</div>

		</div>


	</div>
	 <spring:url value="/convertinglinereport/skucodewise/ExcelExport" var="exportURL"/>
<script>

   function exportExcel()
   {
	   var sdate = $('#sdate').val()
	   var edate = $('#edate').val()
	   var skucode = $('#skucode').val()
	   if(skucode!=-1)
		{
		   location.href='${exportURL}?sdate='+sdate+'&edate='+edate+'&skucode='+skucode;
		}
	   else
		  {
		   alert("Please Select SKUCODE"); 
		  }
	   
	   
	    
   }
</script>
</body>
</html>
