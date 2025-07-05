<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/frpcostoptimization/report/view" var="viewReport" />
<script type="text/javascript">
$(function(){
	$('input[name=dateS]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<style>
	.demo {
		border:1px solid #C0C0C0;
		border-collapse:collapse;
		padding:5px;
	}
	.demo th {
		border:1px solid #C0C0C0;
		padding:5px;
		background:#F0F0F0;
	}
	.demo td {
		border:1px solid #C0C0C0;
		padding:5px;
	}
</style>
</head>

<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP COST OPTIMIZATION REPORT</span>
				</div>
				<div class="table-selector">
					<form action="${viewReport}" method="get">
					<table>
						<tr>
							<td>Select Month:</td>
							<td>
								<input readonly="readonly" type="text" name="dateS" value="${dateS}">							
							</td>
							<td>
								<input type="submit" value="View" name="View"/>					
							</td>
						</tr>
					</table>
					</form>

				</div>
<c:if test="${view}">			
<center>
<br><br>
<table class="demo" style="width: 800px;">
	<%-- <caption></caption> --%>
	<thead>
	<tr>
		<th></th>
		<th></th>
		<th>As of ST Cost</th>
		<th style="width: 110px;">RISI NE Index</th>
		<th>Consumption in Ton</th>
		<th></th> 
	</tr>
	<tr>
		<th>Waste Paper Mix</th>
		<th>Mix Range %</th>
		<th style="width: 110px;">Waste with Freight</th>
		<th style="width: 110px;">Avg.Waste Price</th>
		<th><b style="color: red;"> From ${sdate} To ${edate}</b></th>
		<th>Consumption $</th> 
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${details}" var="goaldata">
	<tr>
		<td><center><b>SOW & CBS</b></center></td>
		<td><center><b>0--5</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.sowAndCbsF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.sowAndCbsW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${sowandcbs+fcw.sowandcbsweight}" var="sowandcbs"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${sowandcbs}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.sowAndCbsF*sowandcbs}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>News / News Blank</b></center></td>
		<td><center><b>5--15</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.newsBankF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.newsBankW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${news+fcw.newsblankweight}" var="news"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${news}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.newsBankF*news}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>OCC</b></center></td>
		<td><center><b>35--55</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.occF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.occW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${occ+fcw.occweight}" var="occ"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${occ}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.occF*occ}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>DLK</b></center></td>
		<td><center><b>5--15</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.dlkF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.dlkW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${dlk+fcw.dlkweight}" var="dlk"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${dlk}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.dlkF*dlk}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>Mail</b></center></td>
		<td><center><b>0--15</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.mailF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.mailW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${mail+fcw.mailweight}" var="mail"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${mail}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.mailF*mail}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>Mixed / other Krft</b></center></td>
		<td><center><b>5--20</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.mixedOtherF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.mixedOtherW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${mixed+fcw.mixedcraftweight}" var="mixed"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${mixed}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.mixedOtherF*mixed}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>Cut Book</b></center></td>
		<td><center><b>5--20</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.cutbookF}</b></center></td>
		<td style="background-color: #F1F1D5;"><center><b>${goaldata.cutbookW}</b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${cutbook+fcw.cutorhoggedBookweight}" var="cutbook"/>	
		</c:forEach>
		<td><center><b><fmt:formatNumber value="${cutbook}" maxFractionDigits="2"/></b></center></td>
		<td><center><b><fmt:formatNumber value="${goaldata.cutbookF*cutbook}" maxFractionDigits="2"/></b></center></td>
	</tr>
<!-- 	Final Calculation Starts From Here -->
		<c:forEach items="${frpConsumedWeight}" var="finalcal">
			<c:set value="${total+finalcal.newsblankweight+finalcal.sowandcbsweight+finalcal.occweight+finalcal.dlkweight+finalcal.mailweight+finalcal.mixedcraftweight+finalcal.cutorhoggedBookweight}" var="total"/>	
		</c:forEach>
	<tr>
		<td><center><b>Total</b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<td style="background-color: #F1F1D5;"><center><b><fmt:formatNumber value="${total}" maxFractionDigits="2"/></b></center></td>
		<td><center><b></b></center></td>
	</tr>
	<tr>
		<td><center><b>Total Fiber Cost Fed</b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<c:forEach items="${frpConsumedWeight}" var="fcw">
			<c:set value="${sowandcbs+goaldata.sowAndCbsF*fcw.sowandcbsweight}" var="sowandcbs"/>	
			<c:set value="${news+goaldata.newsBankF*fcw.newsblankweight}" var="news"/>	
			<c:set value="${occ+goaldata.occF*fcw.occweight}" var="occ"/>	
			<c:set value="${dlk+goaldata.dlkF*fcw.dlkweight}" var="dlk"/>	
			<c:set value="${mail+goaldata.mailF*fcw.mailweight}" var="mail"/>
			<c:set value="${mixed+goaldata.mixedOtherF*fcw.mixedcraftweight}" var="mixed"/>
			<c:set value="${cutbook+goaldata.cutbookF*fcw.cutorhoggedBookweight}" var="cutbook"/>	
		</c:forEach>
		<c:set value="${sowandcbs+news+occ+dlk+mail+mixed+cutbook}" var="totalfibercost"/>	
		<td style="background-color: #F1F1D5;"><center><b><fmt:formatNumber value="${totalfibercost}" maxFractionDigits="2"/></b></center></td>
	</tr>
	<tr>
		<td><center><b>Total Cost/ Ton Fed Tracker</b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<td><center><b></b></center></td>
		<td><center><b><fmt:formatNumber value="" maxFractionDigits="2"/></b></center></td>
		<td style="background-color: #F1F1D5;"><center><b><fmt:formatNumber value="${totalfibercost/total}" maxFractionDigits="2"/></b></center></td>
	</tr>
<!-- 	Final Calculation ends Here -->
	<tbody>
	</tbody>
	</c:forEach>
</table>
</center>
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
