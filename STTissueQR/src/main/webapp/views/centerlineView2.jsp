<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<spring:url value="/centerline/deletecldata" var="deletecldataURL"/>

<script type="text/javascript">
var deletecldataURL='${deletecldataURL}';

</script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/centerline.js"/>'></script>
<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		
		$('select[name=grade]').off('change');
		$('#searchBtn').click(function(){
			var val=$('select[name=grade]').val();
			
			if(val==''){
				alert('Select Grade!')
				return false;
			}
			return true;
		});
	});
</script>
<style type="text/css">
.table2{
	border-collapse: collapse;
}
.table2 td,.table2 th{
	border: 1px solid gray;
}
</style>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>

		<spring:url value="/centerlinereport/load2" var="viewURL" />
		
		<div class="block3" style="overflow: auto;">
			<div class="pageContent">
				<div class="page-title">
					<span class="label">View Centerline Data</span>
				</div>
				<br>
				
				
				
				<div class="table-selector">
				<form id="searchForm" action="${viewURL}" method="post">
					<table>
						<tr>
							<td>From</td>
							<td><input type="text" name="sdate" value="${sdate}" style="width: 100px;" readonly="readonly"></td>
							<td>&nbsp;&nbsp; To</td>
							<td><input type="text" name="edate" value="${edate}" style="width: 100px;" readonly="readonly"></td>
							<td>&nbsp;&nbsp;Grade</td>
							<td>
							
								<select name="grade" style="width: 150px;">
									<option value="">Select</option>
									<option value="0">All</option>
									<c:forEach items="${clgrades}" var="clgrade">
										<c:choose>
											<c:when test="${clgrade['ID'] == grade}">
												<option value="${clgrade['ID']}" selected="selected">${clgrade['Grade']}</option>
											</c:when>
											<c:otherwise>
												<option value="${clgrade['ID']}">${clgrade['Grade']}</option>
											</c:otherwise>
										</c:choose>
										
										
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" value="Search" id="searchBtn">
								<c:if test="${fn:length(centerlineDatas) gt 0}">
	  								&nbsp;
									<input type="button" id="exportBtn" value="Export">
									
								</c:if>
								
							</td>
						</tr>
					</table>

				</form>
				<spring:url value="/centerline/edit" var="editURL"/>
				<c:if test="${fn:length(centerlineDatas) gt 0}">
					<script type="text/javascript">
						$(function(){
							$('#exportBtn').click(function(){
								$('#exportFrom').submit();
							});
							
						});
					</script>
				
					<spring:url value="/centerlinereport/export2" var="exportURL"/>
					<form id="exportFrom" action="${exportURL}" method="post">
							<input type="hidden" name="sdate" value="${sdate}">
							<input type="hidden" name="edate" value="${edate}">
							<input type="hidden" name="grade" value="${grade}">
					</form>
				</c:if>
				
			
				</div>
					<br>
				
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${single}">
<c:if test="${fn:length(centerlineDatas) gt 0}">
<table class="table2" style="font-size: 12px;text-align: center;min-width: 200px;">
	<tr>
		<th><div style="width: 150px;"></div> </th>
		<th>UNITS</th>
		<th>TARGET</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td><fmt:formatDate value="${centerline.date}" pattern="MM-dd-yyyy"/> </td>
		</c:forEach>
	</tr>
	
	<tr>	
		<th>Grade</th>
		<th></th>
		<th><div style="width: 150px;">${centerlineGrade.grade}</div></th>
		<c:forEach begin="1" end="${fn:length(centerlineDatas)}">
			<td><div style="width: 150px;">${centerlineGrade.grade}</div></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Shift</th>
		<th></th>
		<th></th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.shift}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Crew</th>
		<th></th>
		<th></th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.crew}</td>
		</c:forEach>
	</tr>
	<tr style="background: rgb(216, 216, 216);">
		<td colspan="${fn:length(centerlineDatas) + 3}"style="text-align: left;"><b>CENTRELINES</b></td>
		
	</tr>
	<tr>
		<th>Yankee speed</th>
		<th>fpm</th>
		<th>${centerlineGrade.yankeeSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>QCS Basis wt target</th>
		<th>#</th>
		<th>${centerlineGrade.qcsBasisWtTarget}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.qcsBasisWtTarget}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Reel Moisture</th>
		<th>%</th>
		<th>${centerlineGrade.reelMoisture}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.reelMoisture}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Crepe</th>
		<th>%</th>
		<th>${centerlineGrade.crepe}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.crepe}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee Steam  </th>
		<th>psi</th>
		<th>${centerlineGrade.yankeeSteam}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeSteam}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee Release</th>
		<th>mg/m2</th>
		<th>${centerlineGrade.yankeeRelease}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeRelease}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee Adesive</th>
		<th>mg/m2</th>
		<th>${centerlineGrade.yankeeAdesive}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeAdesive}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Jet Wire Ratio</th>
		<th></th>
		<th>${centerlineGrade.jetWireRatio}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.jetWireRatio}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Fan Pump flow rate</th>
		<th>gpm</th>
		<th>${centerlineGrade.fanPumpFlowRate}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.fanPumpFlowRate}</td>
		</c:forEach>
	</tr>
	
	<tr>
		<th>After Dryer Draw</th>
		<th>fpm</th>
		<th>${centerlineGrade.afterDryerDraw}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.afterDryerDraw}</td>
		</c:forEach>
	</tr>
	<tr style="background: rgb(216, 216, 216);">
		<td  colspan="${fn:length(centerlineDatas) + 3}" style="text-align: left;"><b>PROCESS PARAMETERS</b></td>
	</tr>
	<tr>
		<th>After Dryer Steam</th>
		<th>psi</th>
		<th>${centerlineGrade.afterDryerSteam}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.afterDryerSteam}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>SPR loading</th>
		<th>psi</th>
		<th>${centerlineGrade.sprLoading}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sprLoading}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Felt Passivator</th>
		<th>ml/min</th>
		<th>${centerlineGrade.feltPassivator}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.feltPassivator}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sprayboom Pressure</th>
		<th>psi</th>
		<th>${centerlineGrade.sprayboomPressure}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sprayboomPressure}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sprayboom Temparature</th>
		<th><sup>0</sup>F</th>
		<th>${centerlineGrade.sprayboomTemparature}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sprayboomTemparature}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>WE Fan Speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.wefanSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.wefanSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>DE Fan Speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.defanSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.defanSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Make-up air damper</th>
		<th>%</th>
		<th>${centerlineGrade.makeUpAirDamper}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.makeUpAirDamper}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Exhaust damper</th>
		<th>%</th>
		<th>${centerlineGrade.exhaustDamper}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.exhaustDamper}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Exhaust Fan speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.exhaustFanSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.exhaustFanSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>WE Hood Temperature</th>
		<th><sup>0</sup>F</th>
		<th>${centerlineGrade.wehoodTemperature}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.wehoodTemperature}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>DE Hood Temperature</th>
		<th><sup>0</sup>F</th>
		<th>${centerlineGrade.dehoodTemperature}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.dehoodTemperature}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee  &Delta; P</th>
		<th>psi</th>
		<th>${centerlineGrade.yankeeAP}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeAP}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>After Dryer Δ P</th>
		<th>psi</th>
		<th>${centerlineGrade.afterDryerAP}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.afterDryerAP}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sec Arm Loading</th>
		<th>pli</th>
		<th>${centerlineGrade.secArmLoading}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.secArmLoading}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Reel offset</th>
		<th>pli</th>
		<th>${centerlineGrade.reelOffset}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.reelOffset}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Uhle box North Valve</th>
		<th>%</th>
		<th>${centerlineGrade.uhleBoxNorthValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.uhleBoxNorthValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Uhle box South Valve</th>
		<th>%</th>
		<th>${centerlineGrade.uhleBoxSouthValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.uhleBoxSouthValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Falt box 1 Vacuum valve</th>
		<th>%</th>
		<th>${centerlineGrade.faltBox1VacuumValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.faltBox1VacuumValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Falt box 2 Vacuum valve</th>
		<th>%</th>
		<th>${centerlineGrade.faltBox2VacuumValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.faltBox2VacuumValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Falt box 4 Vacuum valve</th>
		<th>%</th>
		<th>${centerlineGrade.faltBox4VacuumValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.faltBox4VacuumValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Fan Pump speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.fanPumpSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.fanPumpSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Total head</th>
		<th></th>
		<th>${centerlineGrade.totalHead}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.totalHead}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Headbox level</th>
		<th></th>
		<th>${centerlineGrade.headboxLevel}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.headboxLevel}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Horizontal slice local</th>
		<th>in</th>
		<th>${centerlineGrade.horizontalSlice}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.horizontalSlice}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Horizontal slice dcs</th>
		<th>in</th>
		<th>${centerlineGrade.horizontalSliceDcs}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.horizontalSliceDcs}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Vertical Slice local</th>
		<th>in</th>
		<th>${centerlineGrade.verticalSlice}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.verticalSlice}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Vertical Slice dcs</th>
		<th>in</th>
		<th>${centerlineGrade.verticalSliceDcs}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.verticalSliceDcs}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Selectifier reject flow 1</th>
		<th>gpm</th>
		<th>${centerlineGrade.selectifierRejectFlow1}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.selectifierRejectFlow1}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Selectifier reject flow 2</th>
		<th>gpm</th>
		<th>${centerlineGrade.selectifierRejectFlow2}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.selectifierRejectFlow2}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sec screen Cycle time</th>
		<th>min</th>
		<th>${centerlineGrade.secScreenCycleTime}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.secScreenCycleTime}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Low Density Cycle Time</th>
		<th>min</th>
		<th>${centerlineGrade.lowDensityCycleTime}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.lowDensityCycleTime}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Refiners Energy</th>
		<th>kW</th>
		<th>${centerlineGrade.refinersEnergy}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.refinersEnergy}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Number of Refiners</th>
		<th>Nos.</th>
		<th>${centerlineGrade.numberOfRefiners}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.numberOfRefiners}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Refiner Inlet Consistency</th>
		<th>%</th>
		<th>${centerlineGrade.refinerInletConsistency}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.refinerInletConsistency}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Machine Chest Consistency</th>
		<th>%</th>
		<th>${centerlineGrade.machineChestConsistency}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.machineChestConsistency}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Stock flow</th>
		<th>gpm</th>
		<th>${centerlineGrade.stockFlow}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.stockFlow}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sweetner Flow</th>
		<th>gpm</th>
		<th>${centerlineGrade.sweetnerFlow}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sweetnerFlow}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Broke </th>
		<th>%</th>
		<th>${centerlineGrade.broke}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.broke}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Wet strength</th>
		<th>gpm</th>
		<th>${centerlineGrade.wetStrength}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.wetStrength}</td>
		</c:forEach>
	</tr>
	
</table>
<br>
<br>
<br>
</c:if>
</c:if>

<c:if test="${multiple}">

<table class="table2" style="font-size: 12px;text-align: center;min-width: 200px;">
	<tr>
		<th><div style="width: 150px;"></div> </th>
		<th>UNITS</th>
		<th>TARGET</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td><fmt:formatDate value="${centerline.rltDate}" pattern="MM-dd-yyyy"/> </td>
		</c:forEach>
	</tr>
	
	<tr>	
		<th>Grade</th>
		<th></th>
		<th><div style="width: 150px;">${centerlineGrade.grade}</div></th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td><div style="width: 150px;">${centerline.grade}</div></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Shift</th>
		<th></th>
		<th></th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.shift}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Crew</th>
		<th></th>
		<th></th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.crew}</td>
		</c:forEach>
	</tr>
	<tr style="background: rgb(216, 216, 216);">
		<td colspan="${fn:length(centerlineDatas) + 3}"style="text-align: left;"><b>CENTRELINES</b></td>
		
	</tr>
	<tr>
		<th>Yankee speed</th>
		<th>fpm</th>
		<th>${centerlineGrade.yankeeSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>QCS Basis wt target</th>
		<th>#</th>
		<th>${centerlineGrade.qcsBasisWtTarget}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.qcsBasisWtTarget}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Reel Moisture</th>
		<th>%</th>
		<th>${centerlineGrade.reelMoisture}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.reelMoisture}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Crepe</th>
		<th>%</th>
		<th>${centerlineGrade.crepe}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.crepe}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee Steam  </th>
		<th>psi</th>
		<th>${centerlineGrade.yankeeSteam}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeSteam}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee Release</th>
		<th>mg/m2</th>
		<th>${centerlineGrade.yankeeRelease}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeRelease}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee Adesive</th>
		<th>mg/m2</th>
		<th>${centerlineGrade.yankeeAdesive}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeAdesive}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Jet Wire Ratio</th>
		<th></th>
		<th>${centerlineGrade.jetWireRatio}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.jetWireRatio}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Fan Pump flow rate</th>
		<th>gpm</th>
		<th>${centerlineGrade.fanPumpFlowRate}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.fanPumpFlowRate}</td>
		</c:forEach>
	</tr>
	
	<tr>
		<th>After Dryer Draw</th>
		<th>fpm</th>
		<th>${centerlineGrade.afterDryerDraw}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.afterDryerDraw}</td>
		</c:forEach>
	</tr>
	<tr style="background: rgb(216, 216, 216);">
		<td  colspan="${fn:length(centerlineDatas) + 3}" style="text-align: left;"><b>PROCESS PARAMETERS</b></td>
	</tr>
	<tr>
		<th>After Dryer Steam</th>
		<th>psi</th>
		<th>${centerlineGrade.afterDryerSteam}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.afterDryerSteam}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>SPR loading</th>
		<th>psi</th>
		<th>${centerlineGrade.sprLoading}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sprLoading}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Felt Passivator</th>
		<th>ml/min</th>
		<th>${centerlineGrade.feltPassivator}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.feltPassivator}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sprayboom Pressure</th>
		<th>psi</th>
		<th>${centerlineGrade.sprayboomPressure}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sprayboomPressure}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sprayboom Temparature</th>
		<th><sup>0</sup>F</th>
		<th>${centerlineGrade.sprayboomTemparature}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sprayboomTemparature}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>WE Fan Speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.wefanSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.wefanSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>DE Fan Speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.defanSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.defanSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Make-up air damper</th>
		<th>%</th>
		<th>${centerlineGrade.makeUpAirDamper}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.makeUpAirDamper}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Exhaust damper</th>
		<th>%</th>
		<th>${centerlineGrade.exhaustDamper}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.exhaustDamper}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Exhaust Fan speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.exhaustFanSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.exhaustFanSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>WE Hood Temperature</th>
		<th><sup>0</sup>F</th>
		<th>${centerlineGrade.wehoodTemperature}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.wehoodTemperature}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>DE Hood Temperature</th>
		<th><sup>0</sup>F</th>
		<th>${centerlineGrade.dehoodTemperature}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.dehoodTemperature}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Yankee  &Delta; P</th>
		<th>psi</th>
		<th>${centerlineGrade.yankeeAP}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.yankeeAP}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>After Dryer Δ P</th>
		<th>psi</th>
		<th>${centerlineGrade.afterDryerAP}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.afterDryerAP}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sec Arm Loading</th>
		<th>pli</th>
		<th>${centerlineGrade.secArmLoading}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.secArmLoading}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Reel offset</th>
		<th>pli</th>
		<th>${centerlineGrade.reelOffset}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.reelOffset}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Uhle box North Valve</th>
		<th>%</th>
		<th>${centerlineGrade.uhleBoxNorthValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.uhleBoxNorthValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Uhle box South Valve</th>
		<th>%</th>
		<th>${centerlineGrade.uhleBoxSouthValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.uhleBoxSouthValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Falt box 1 Vacuum valve</th>
		<th>%</th>
		<th>${centerlineGrade.faltBox1VacuumValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.faltBox1VacuumValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Falt box 2 Vacuum valve</th>
		<th>%</th>
		<th>${centerlineGrade.faltBox2VacuumValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.faltBox2VacuumValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Falt box 4 Vacuum valve</th>
		<th>%</th>
		<th>${centerlineGrade.faltBox4VacuumValve}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.faltBox4VacuumValve}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Fan Pump speed</th>
		<th>rpm</th>
		<th>${centerlineGrade.fanPumpSpeed}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.fanPumpSpeed}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Total head</th>
		<th></th>
		<th>${centerlineGrade.totalHead}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.totalHead}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Headbox level</th>
		<th></th>
		<th>${centerlineGrade.headboxLevel}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.headboxLevel}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Horizontal slice local</th>
		<th>in</th>
		<th>${centerlineGrade.horizontalSlice}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.horizontalSlice}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Horizontal slice dcs</th>
		<th>in</th>
		<th>${centerlineGrade.horizontalSliceDcs}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.horizontalSliceDcs}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Vertical Slice local</th>
		<th>in</th>
		<th>${centerlineGrade.verticalSlice}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.verticalSlice}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Vertical Slice dcs</th>
		<th>in</th>
		<th>${centerlineGrade.verticalSliceDcs}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.verticalSliceDcs}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Selectifier reject flow 1</th>
		<th>gpm</th>
		<th>${centerlineGrade.selectifierRejectFlow1}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.selectifierRejectFlow1}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Selectifier reject flow 2</th>
		<th>gpm</th>
		<th>${centerlineGrade.selectifierRejectFlow2}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.selectifierRejectFlow2}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sec screen Cycle time</th>
		<th>min</th>
		<th>${centerlineGrade.secScreenCycleTime}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.secScreenCycleTime}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Low Density Cycle Time</th>
		<th>min</th>
		<th>${centerlineGrade.lowDensityCycleTime}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.lowDensityCycleTime}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Refiners Energy</th>
		<th>kW</th>
		<th>${centerlineGrade.refinersEnergy}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.refinersEnergy}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Number of Refiners</th>
		<th>Nos.</th>
		<th>${centerlineGrade.numberOfRefiners}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.numberOfRefiners}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Refiner Inlet Consistency</th>
		<th>%</th>
		<th>${centerlineGrade.refinerInletConsistency}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.refinerInletConsistency}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Machine Chest Consistency</th>
		<th>%</th>
		<th>${centerlineGrade.machineChestConsistency}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.machineChestConsistency}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Stock flow</th>
		<th>gpm</th>
		<th>${centerlineGrade.stockFlow}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.stockFlow}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Sweetner Flow</th>
		<th>gpm</th>
		<th>${centerlineGrade.sweetnerFlow}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.sweetnerFlow}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Broke </th>
		<th>%</th>
		<th>${centerlineGrade.broke}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.broke}</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Wet strength</th>
		<th>gpm</th>
		<th>${centerlineGrade.wetStrength}</th>
		<c:forEach items="${centerlineDatas}" var="centerline">
			<td>${centerline.wetStrength}</td>
		</c:forEach>
	</tr>
	
</table>
<br>
<br>
<br>

</c:if>
</div>
</div>
		</div>

</div>
	
</body>
</html>
