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
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Waste Paper Mill Yield Report</span>
				</div>

				<div class="table-selector">
				<spring:url value="/wastepapermillyieldreport/view/data" var="viewURL"/>
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
							</td>
							<td>
								<c:if test="${viewpage}">
									<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export">
								</c:if>
							</td>
						</tr>
					</table>
				</form>
<form id="exportFrom" action='<spring:url value="/wastepapermillyieldreport/exportreport"/>' method="post" style="display:none; " target="_blank">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 80px;background-color: rgb(142, 131, 24);"><b>Date</b></td>
			<td colspan="8" style="width: 80px;background-color: #6BB900;"><b>Pulper 3 Input</b></td>
			<td style="width: 80px;background-color: #6BB900;"></td>
			<td colspan="22" style="width: 80px;background-color: rgb(0, 162, 185);"><b>Pulper 4 Input</b></td>
			<td style="width: 80px;background-color: rgb(183, 148, 19);"></td>
			<td style="width: 80px;background-color: #B14AB3;"></td>
			<td style="width: 80px;background-color: rgba(24, 0, 128, 0.46);"><b>Gross</b></td>
			
			<td colspan="3" style="width: 80px;background-color: rgba(189, 0, 81, 0.59);"><b>Net</b></td>
			<td style="width: 80px;background-color: white;"></td>
			<td colspan="9" style="width: 80px;background-color: rgba(50, 130, 103, 0.55);"><b>Pulper 3 Output</b></td>
			
			<td style="width: 80px;background-color: white;"></td>
			<td colspan="4" style="width: 80px;background-color: rgba(0, 17, 197, 0.69);"><b>Mill Yield</b></td>
			<!-- <td colspan="5" style="width: 80px;background-color: rgba(212, 208, 243, 0.69);"><b>Virgin</b></td>
			<td style="width: 80px;background-color: white;"></td>
			<td colspan="3" style="width: 80px;background-color: rgba(212, 130, 243, 0.69);"><b>Sow Consumption</b></td>
		 -->
		</tr>
		<tr>
			<td style="width: 80px;">Date</td>
			<!--1 -->			
			<td style="width: 80px;">Wet Lap Pulp</td>
			<!--2 -->
			<td style="width: 80px;">Pulp Dry Lap</td>
			<td style="width: 80px;">Vigin Pulp</td>
			<!--3 -->
			<td style="width: 80px;">Virgin Soft Wood</td>
			<td style="width: 80px;">Virgin Hard Wood</td>
			<td style="width: 80px;">Virgin-SW Fluff</td>
			<td style="width: 80px;">Virgin-Transitn pulp</td>																			
			<td style="width: 80px;">Broke</td>
			<td style="width: 80px;">ST Bales Wetlap</td>
			<!--4 -->
			<td style="width: 80px;">Hard White</td>
			<td style="width: 80px;">Mail-Undeliverable</td>
			<td style="width: 80px;">CGWD</td>
			<!--5 -->
			<td style="width: 80px;">CTDGDWD</td>
			<td style="width: 80px;">CGWD Section</td>
			<!--6 -->
			<td style="width: 80px;">Brown Broke</td>
			<td style="width: 80px;">MWL</td>
			<!--7 -->
			<td style="width: 80px;">ONP-Old News Print</td>
			<td style="width: 80px;">SCN News</td>
			<!--8 -->
			<td style="width: 80px;">Newblank</td>
			<td style="width: 80px;">Other</td>
			<!--9 -->
			<td style="width: 80px;">DLK</td>
			<td style="width: 80px;">Mixed Paper</td>
			<!--10 -->
			<td style="width: 80px;">SOW</td>
			<td style="width: 80px;">SW</td>
			<!--11 -->
			<td style="width: 80px;">SWL</td>
			<td style="width: 80px;">White Bland</td>
			<!--12 -->
			<td style="width: 80px;">White Blend</td>
			<td style="width: 80px;">OCC</td>
			<!--13 -->
			<td style="width: 80px;">ST Bales Wetlap</td>
			<td style="width: 80px;">Light Prt SBS</td>
			<!--14 -->
			<td style="width: 80px;">Heavy Prt SBS</td>
			<td style="width: 80px;">Pulper 3 Tons I/P</td>
			<!--15-->
			<td style="width: 80px;">Pulper 4 Tons I/P</td>
			<td style="width: 80px;">Total Mill Production</td>
			<!--16-->
			<td style="width: 80px;">Sca Virgin Pulp</td>
			<td style="width: 80px;">ST Virgin Production</td>
			<td style="width: 80px;">Trim</td>
			<!--17-->
			<td style="width: 80px;">Net Mill Production</td>
			<td style="width: 80px;">Virgin Soft Wood</td>
			<td style="width: 80px;">Virgin Hard Wood</td>
			<td style="width: 80px;">Virgin-SW Fluff</td>
			<td style="width: 80px;">Virgin-Transitn pulp</td>
			<!--18-->
			<td style="width: 80px;">PULP Wet Lap O/P</td>
			<td style="width: 80px;">PULP Dry Lap O/P</td>
			<!--19-->
			<td style="width: 80px;">Virgin Pulp O/P</td>
			<td style="width: 80px;">Broke O/P</td>
			<!--20 -->
			<td style="width: 80px;">ST Bales Wetlap</td>
			
			<td style="width: 80px;">Total O/P Alternate Fiber</td>
			<!--21 -->
			<td style="width: 80px;">RF OutPut</td>
			<td style="width: 80px;">ST Bales WetLap</td>
			<!--22 -->
			<td style="width: 80px;">Adjusted RF production</td>
			<td style="width: 80px;">RFYield %</td>
			
			
			<!-- <td style="width: 80px;">Virgin Soft Wood</td>
			<td style="width: 80px;">Virgin Hard Wood</td>
			<td style="width: 80px;">Virgin-SW Fluff</td>
			<td style="width: 80px;">Virgin Eucalyptus</td>
			<td style="width: 80px;">Total Virgin Input</td>
			<td style="width: 80px;">Virgin Yield %</td>
			
			
			<td style="width: 80px;">Sow Consumption</td>
			<td style="width: 80px;">Pulper 4 Input</td>
			<td style="width: 80px;">Sow%</td> -->
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${consumedbalesdata}" var="ubd">
			<tr>
					<td style="color: white;background-color: green;"><b style="color: white;"><center><fmt:formatDate value="${ubd.date}" pattern="MM/dd/yyyy"/></center></b></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfpulpwetlap}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfpulpdrylap}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfvirginpulp}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSoftWood*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginHardWood*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSW_Fluff*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginEucalyptus*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldbroke}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfstbaleswetlap}" maxFractionDigits="2"/></center></td>
					
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfhw}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfcbs}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldcgwd}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfctdgdwd}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldcgwdsection}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfmcl}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfmwl}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfunctdflyleafshvgs}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfmwlwigs}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfnewsblank}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfother}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfpmix}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfpwe}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfsow}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldsw}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfswl}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldwhiteblend}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldwhitebland}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfocccorrugated}" maxFractionDigits="2"/></center></td>
					<td><center>0</center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOflightprtsbs}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfheavyprtsbs}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldtotalofpulpar3}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldtotalofpulpar4}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldtotalmillproduction}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldscavirginpulp}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.stvirginproduction}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldtrimloss}" maxFractionDigits="2"/></center></td>
					
					<td><center><fmt:formatNumber value="${ubd.yieldtotalmillproduction-ubd.stvirginproduction-ubd.yieldscavirginpulp+ubd.yieldtrimloss}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSoftWood*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginHardWood*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSW_Fluff*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginEucalyptus*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfpulpwetlap*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfpulpdrylap*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfvirginpulp*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldbroke*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfstbaleswetlap*90/100}" maxFractionDigits="2"/></center></td>
					
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginEucalyptus*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesweightOfpulpwetlap*90/100+ubd.totalbalesweightOfpulpdrylap*90/100+ubd.totalbalesweightOfvirginpulp*90/100+ubd.yieldbroke*90/100+ubd.totalbalesweightOfstbaleswetlap*90/100}" maxFractionDigits="2"/></center></td>
					<!-- RF Output -->
					<td><center><fmt:formatNumber value="${(ubd.yieldtotalmillproduction-ubd.yieldscavirginpulp+ubd.yieldtrimloss)-(ubd.totalbalesofVirginEucalyptus*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesweightOfpulpwetlap*90/100+ubd.totalbalesweightOfpulpdrylap*90/100+ubd.totalbalesweightOfvirginpulp*90/100+ubd.yieldbroke*90/100+ubd.totalbalesweightOfstbaleswetlap*90/100)}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldstbaleswetLap}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${(ubd.yieldtotalmillproduction-ubd.yieldscavirginpulp+ubd.yieldtrimloss)-(ubd.totalbalesofVirginEucalyptus*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesweightOfpulpwetlap*90/100+ubd.totalbalesweightOfpulpdrylap*90/100+ubd.totalbalesweightOfvirginpulp*90/100+ubd.yieldbroke*90/100+ubd.totalbalesweightOfstbaleswetlap*90/100)+(ubd.yieldstbaleswetLap)}" maxFractionDigits="2"/></center></td>
					<!-- RF Yield % -->
					<td><center><fmt:formatNumber value="${(((ubd.yieldtotalmillproduction-ubd.yieldscavirginpulp+ubd.yieldtrimloss)-(ubd.totalbalesofVirginEucalyptus*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesweightOfpulpwetlap*90/100+ubd.totalbalesweightOfpulpdrylap*90/100+ubd.totalbalesweightOfvirginpulp*90/100+ubd.yieldbroke*90/100+ubd.totalbalesweightOfstbaleswetlap*90/100)+(ubd.yieldstbaleswetLap))/ubd.yieldtotalofpulpar4)*100}" maxFractionDigits="2"/></center></td>
					
					<%-- <!-- Virgin  -->
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSoftWood*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginHardWood*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSW_Fluff*90/100}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginEucalyptus*90/100}" maxFractionDigits="2"/></center></td>
					<!-- Virgin Total -->
					<td><center><fmt:formatNumber value="${ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginEucalyptus*90/100}" maxFractionDigits="2"/></center></td>
					<!-- Virgin Yield % -->
					<c:if test="${(ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginEucalyptus*90/100)!=0}">
						<td><center><fmt:formatNumber value="${ubd.stvirginproduction/(ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginEucalyptus*90/100)*100}" maxFractionDigits="2"/></center></td>
					</c:if>
					<c:if test="${(ubd.totalbalesofVirginSoftWood*90/100+ubd.totalbalesofVirginHardWood*90/100+ubd.totalbalesofVirginSW_Fluff*90/100+ubd.totalbalesofVirginEucalyptus*90/100)==0}">
						<td><center><fmt:formatNumber value="0" maxFractionDigits="2"/></center></td>
					</c:if>
					
					
					<td><center><fmt:formatNumber value="${ubd.totalbalesweightOfsow}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${ubd.yieldtotalofpulpar4-ubd.totalbalesweightOfnewsblank}" maxFractionDigits="2"/></center></td>
					<td><center><fmt:formatNumber value="${(ubd.totalbalesweightOfsow/(ubd.yieldtotalofpulpar4-ubd.totalbalesweightOfnewsblank))*100}" maxFractionDigits="2"/></center></td>
			 --%>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
			</div>
	
		</div>


	</div>

</body>
</html>
