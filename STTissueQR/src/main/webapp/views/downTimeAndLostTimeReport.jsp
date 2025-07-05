<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg .tg-yw4l {
	vertical-align: top
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
					<span class="label">DOWNTIME & LOST TIME REPORT</span>
				</div>
				<div class="table-selector">
					<spring:url value="/downtimeandlosttime/report/show" var="viewURL"/>
					<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View">
								&nbsp;
								&nbsp;
								<c:if test="${export}">
								 <td><input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export"></td>
								</c:if>
								
							</td>
							
						</tr>
					</table>
				</form>
<form id="exportFrom" action='<spring:url value="/downtimeandlosttime/report/show/export"/>'  method="GET" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
				</div>

			</div>
<c:if test="${show}">
			<table class="table" style="text-align: center;">
				<thead style="text-align: center;">
				<tr>
					<th >Date</th>
					<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grade&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<c:forEach items="${secondaryCode}" var="scode">
						<th >${scode.code}</th>
					</c:forEach>
					<th >Total Minutes</th>
					<th >Reel Tons</th>
					<th >Comments</th>
				</tr>
				</thead>
			<tbody>	
				
				<c:forEach items="${data}" var="datas">
				<tr>
					<td ><fmt:formatDate value="${datas.date}" pattern="MM/dd/yyyy"/></td>
					<td >${datas.gradeCode}</td>
					<td >${datas.totalannualoutage}</td>
					<td >${datas.totalbladechange}</td>
					<td >${datas.totalboilout}</td>
					<td >${datas.totalbreakbackedge}</td>
					<td >${datas.totalbreakfrontedge}</td>
					<td >${datas.totalbreakmiddle}</td>
					<td >${datas.totalbreakatreel}</td>
					<td >${datas.totalbreakatyankee}</td>
					<td >${datas.totalcleanupwashup}</td>
					<td >${datas.totalelectrical}</td>
					<td >${datas.totalfeltwash}</td>
					<td >${datas.totalfieldday}</td>
					<td >${datas.totalfireatreel}</td>
					<td >${datas.totalgradechange}</td>
					<td >${datas.totalheadboxflushing}</td>
					<td >${datas.totalheadboxsealfixing}</td>
					<td >${datas.totalhoodfire}</td>
					<td >${datas.totalinstrumentation}</td>
					<td >${datas.totaljetslittertrimsadjustment}</td>
					<td >${datas.totallackofair}</td>
					<td >${datas.totallackofsteam}</td>
					<td >${datas.totallackofstock}</td>
					<td >${datas.totalmechanical}</td>
					<td >${datas.totalmissedturnup}</td>
					<td >${datas.totalnoemptyspool}</td>
					<td >${datas.totalnowater}</td>
					<td >${datas.totalpoweroutage}</td>
					<td >${datas.totalscheduleclothingchange}</td>
					<td >${datas.totalsmoldering}</td>
					<td >${datas.totalsprayboomchange}</td>
					<td >${datas.totalstartup}</td>
					<td >${datas.totalstriptheYankee}</td>
					<td >${datas.totalturnup}</td>
					<td >${datas.totalunscheduledclothingchange}</td>
					<td >${datas.totalmin+datas.totalhr*60}</td>
					<td >${datas.reelton}</td>
					<td >${datas.comments}</td>
				</tr>
				<c:set value="${loopcount+1}" var="loopcount"/>
				<c:set value="${Totalannualoutage+datas.totalannualoutage}" var="Totalannualoutage"/>
				<c:set value="${Totalbladechange+datas.totalbladechange}" var="Totalbladechange"/>
				<c:set value="${Totalboilout+datas.totalboilout}" var="Totalboilout"/>
				<c:set value="${Totalbreakbackedge+datas.totalbreakbackedge}" var="Totalbreakbackedge"/>
				<c:set value="${Totalbreakfrontedge+datas.totalbreakfrontedge}" var="Totalbreakfrontedge"/>
				<c:set value="${Totalbreakmiddle+datas.totalbreakmiddle}" var="Totalbreakmiddle"/>
				<c:set value="${Totalbreakatreel+datas.totalbreakatreel}" var="Totalbreakatreel"/>
				<c:set value="${Totalbreakatyankee+datas.totalbreakatyankee}" var="Totalbreakatyankee"/>
				<c:set value="${Totalcleanupwashup+datas.totalcleanupwashup}" var="Totalcleanupwashup"/>
				<c:set value="${Totalelectrical+datas.totalelectrical}" var="Totalelectrical"/>
				<c:set value="${Totalfeltwash+datas.totalfeltwash}" var="Totalfeltwash"/>
				<c:set value="${Totalfieldday+datas.totalfieldday}" var="Totalfieldday"/>
				<c:set value="${Totalfireatreel+datas.totalfireatreel}" var="Totalfireatreel"/>
				<c:set value="${Totalgradechange+datas.totalgradechange}" var="Totalgradechange"/>
				<c:set value="${Totalheadboxflushing+datas.totalheadboxflushing}" var="Totalheadboxflushing"/>
				<c:set value="${Totalheadboxsealfixing+datas.totalheadboxsealfixing}" var="Totalheadboxsealfixing"/>
				<c:set value="${Totalhoodfire+datas.totalhoodfire}" var="Totalhoodfire"/>
				<c:set value="${Totalinstrumentation+datas.totalinstrumentation}" var="Totalinstrumentation"/>
				<c:set value="${Totaljetslittertrimsadjustment+datas.totaljetslittertrimsadjustment}" var="Totaljetslittertrimsadjustment"/>
				<c:set value="${Totallackofair+datas.totallackofair}" var="Totallackofair"/>
				<c:set value="${Totallackofsteam+datas.totallackofsteam}" var="Totallackofsteam"/>
				<c:set value="${Totallackofstock+datas.totallackofstock}" var="Totallackofstock"/>
				<c:set value="${Totalmechanical+datas.totalmechanical}" var="Totalmechanical"/>
				<c:set value="${Totalmissedturnup+datas.totalmissedturnup}" var="Totalmissedturnup"/>
				<c:set value="${Totalnoemptyspool+datas.totalnoemptyspool}" var="Totalnoemptyspool"/>
				<c:set value="${Totalnowater+datas.totalnowater}" var="Totalnowater"/>
				<c:set value="${Totalpoweroutage+datas.totalpoweroutage}" var="Totalpoweroutage"/>
				<c:set value="${Totalscheduleclothingchange+datas.totalscheduleclothingchange}" var="Totalscheduleclothingchange"/>
				<c:set value="${Totalsmoldering+datas.totalsmoldering}" var="Totalsmoldering"/>
				<c:set value="${Totalsprayboomchange+datas.totalsprayboomchange}" var="Totalsprayboomchange"/>
				<c:set value="${Totalstartup+datas.totalstartup}" var="Totalstartup"/>
				<c:set value="${TotalstriptheYankee+datas.totalstriptheYankee}" var="TotalstriptheYankee"/>
				<c:set value="${Totalturnup+datas.totalturnup}" var="Totalturnup"/>
				<c:set value="${Totalunscheduledclothingchange+datas.totalunscheduledclothingchange}" var="Totalunscheduledclothingchange"/>
				<c:set value="${GrandTotalMins+(datas.totalmin+datas.totalhr*60)}" var="GrandTotalMins"/>
				<c:set value="${GrandTotalReelTon+datas.reelton}" var="GrandTotalReelTon"/>
				
			</c:forEach>
			</tbody>
			<tbody>
				<tr style="background-color: rgba(165, 158, 82, 0.42);font-weight: 600;">
					<td rowspan="3">Days In Years <b style="color: red;">${loopcount}</b></td>
					<td >Total Minutes</td>
					<td>${Totalannualoutage}</td>
					<td>${Totalbladechange}</td>
					<td>${Totalboilout}</td>
					<td>${Totalbreakbackedge}</td>
					<td>${Totalbreakfrontedge}</td>
					<td>${Totalbreakmiddle}</td>
					<td>${Totalbreakatreel}</td>
					<td>${Totalbreakatyankee}</td>
					<td>${Totalcleanupwashup}</td>
					<td>${Totalelectrical}</td>
					<td>${Totalfeltwash}</td>
					<td>${Totalfieldday}</td>
					<td>${Totalfireatreel}</td>
					<td>${Totalgradechange}</td>
					<td>${Totalheadboxflushing}</td>
					<td>${Totalheadboxsealfixing}</td>
					<td>${Totalhoodfire}</td>
					<td>${Totalinstrumentation}</td>
					<td>${Totaljetslittertrimsadjustment}</td>
					<td>${Totallackofair}</td>
					<td>${Totallackofsteam}</td>
					<td>${Totallackofstock}</td>
					<td>${Totalmechanical}</td>
					<td>${Totalmissedturnup}</td>
					<td>${Totalnoemptyspool}</td>
					<td>${Totalnowater}</td>
					<td>${Totalpoweroutage}</td>
					<td>${Totalscheduleclothingchange}</td>
					<td>${Totalsmoldering}</td>
					<td>${Totalsprayboomchange}</td>
					<td>${Totalstartup}</td>
					<td>${TotalstriptheYankee}</td>
					<td>${Totalturnup}</td>
					<td>${Totalunscheduledclothingchange}</td>
					<td>${GrandTotalMins}</td>
					<td rowspan="3"><fmt:formatNumber value="${GrandTotalReelTon}" maxFractionDigits="2"/></td>
					<td rowspan="3"></td>
				</tr>
				<tr style="background-color: rgba(165, 158, 82, 0.42);font-weight: 600;">
					<td >&nbsp;</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr style="background-color: rgba(165, 158, 82, 0.42);font-weight: 600;">
					<td >Percentage</td>
					<td><fmt:formatNumber value="${Totalannualoutage/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalbladechange /(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalboilout /(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalbreakbackedge/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalbreakfrontedge/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalbreakmiddle/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalbreakatreel/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalbreakatyankee/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalcleanupwashup/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalelectrical/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalfeltwash/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalfieldday/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalfireatreel/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalgradechange/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalheadboxflushing/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalheadboxsealfixing/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalhoodfire/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalinstrumentation/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totaljetslittertrimsadjustment/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totallackofair/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totallackofsteam/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totallackofstock/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalmechanical/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalmissedturnup/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalnoemptyspool/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalnowater/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalpoweroutage/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalscheduleclothingchange/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalsmoldering/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalsprayboomchange/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalstartup/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${TotalstriptheYankee/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalturnup/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${Totalunscheduledclothingchange/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
					<td><fmt:formatNumber value="${GrandTotalMins/(loopcount*1440)*100}" maxFractionDigits="2"/>%</td>
				</tr>
				<tr style="    background-color: rgba(144, 144, 173, 0.42);font-weight: 600;text-align: left;">
					<td colspan="39"><h3>Year to Date Percentage: <fmt:formatNumber value="${GrandTotalMins/(loopcount*1440)*100}" maxFractionDigits="2"/>%</h3></td>
				</tr>
			</tbody>	
			</table>
			
			
			
			
			<%-- <table class="tg">
				<c:forEach items="${secondaryCode}" var="scode">
					<tr>
						<td class="tg-yw4l">${scode.code}</td>
					</tr>
				</c:forEach>	
				<c:forEach items="${data}" var="datas">
				<tr>
						<td class="tg-yw4l">${datas.totalbladechange}</td>
				</tr>
				</c:forEach>	
			</table> --%>
</c:if>
		</div>


	</div>

</body>
</html>
