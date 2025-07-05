<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
	body {
	overflow: auto;
}
.centerline-table tr{
	height: 20px !important;
}
</style>
<script type="text/javascript">
	$(function(){
		
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
		
	});
</script> 
</head>
<body>


<button id="printBtn">Print</button>
<button onclick="window.close();">Close</button>
<hr>
<div id="printDiv">

<div style="padding: 10px;">
	<table style="font-size: 11px; width: 650px;" class="centerline-table" id="centerlineTable">
		
		<tr>
			<td align="center" colspan="2">GRADE CODE:</td>
			<td colspan="3" align="center">
				${cgrade.grade}
			</td>
			<td colspan="2"></td>
			<td>Issue Date</td>
			<td>
				${cgrade.fissueDate}
			</td>

		</tr>
		<tr style="height: 20px;">
			<td style="width: 50px;">CREW:</td>
			<td>
				${cdata.crew}
			</td>
			<td style="width: 50px;">SHIFT:</td>
			<td>	
				${cdata.shift}
			</td>
			<td>DATE:</td>
			<td colspan="2" style="text-align: left;">
				${cdata.fdate}
			</td>
			<td >Revision</td>
			<td  style="text-align: left;">${cgrade.revision}</td>
		</tr>
		<tr style="text-align: center; font-size: 12px;">
			<td colspan="2">&nbsp;</td>
			<td>Setpoint</td>
			<td>Actual Value</td>
			<td>Unit of Measure</td>
			<td></td>
			<td>Setpoint</td>
			<td>Actual Value</td>
			<td>Unit of Measure</td>
		</tr>
		
	
		<tr style="background-color: #FDC893;">
			<td colspan="9" style="text-align: left;">SECTION A: CENTERLINES</td>
		</tr>
	


		<tr>
	
			<td style="" colspan="2">Yankee speed</td>
			<td style="width: 60px;" class="vcolor">${cgrade.yankeeSpeed}</td>
			<td style="width: 60px;">${cdata.yankeeSpeed}</td>
			<td style="width: 50px;">fpm</td>
			<td style="width: 150px;">Yankee Release</td>
			<td style="width: 60px;" class="vcolor">${cgrade.yankeeRelease}</td>
			<td style="width: 60px;">${cdata.yankeeRelease}</td>
			<td style="width: 50px;">mg/m2</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">QCS Basis wt target</td>
			<td class="vcolor">${cgrade.qcsBasisWtTarget}</td>
			<td>${cdata.qcsBasisWtTarget}</td>
			<td>#</td>
			<td>Yankee Adesive</td>
			<td class="vcolor">${cgrade.yankeeAdesive}</td>
			<td>${cdata.yankeeAdesive}</td>
			<td>mg/m2</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Reel Moisture</td>
			<td class="vcolor">${cgrade.reelMoisture}</td>
			<td>${cdata.reelMoisture}</td>
			<td>%</td>
			<td>Jet Wire Ratio</td>
			<td class="vcolor">${cgrade.jetWireRatio}</td>
			<td>${cdata.jetWireRatio}</td>
			<td></td>
		</tr>
		
		<tr>
			
			<td colspan="2">Crepe</td>
			<td class="vcolor">${cgrade.crepe}</td>
			<td>${cdata.crepe}</td>
			<td>%</td>
			<td>Fan Pump flow rate</td>
			<td class="vcolor">${cgrade.fanPumpFlowRate}</td>
			<td>${cdata.fanPumpFlowRate}</td>
			<td>gpm</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Yankee Steam </td>
			<td class="vcolor">${cgrade.yankeeSteam}</td>
			<td>${cdata.yankeeSteam}</td>
			<td>psi</td>
			<td>After Dryer Draw</td>
			<td class="vcolor">${cgrade.afterDryerDraw}</td>
			<td>${cdata.afterDryerDraw}</td>
			<td>fpm</td>
		</tr>
		
		<tr>
			<td colspan="9" style="text-align: left;">
				Revision History (date, parameter, explanation): 
			</td>
		</tr>
		<tr>
			<td colspan="9" valign="top" style="text-align: left;height: 60px;">
				${cdata.noteSecA}
			</td>
		</tr>
		<tr style="background-color: #FDC893;">
			<td colspan="9" style="text-align: left;">SECTION B: PROCESS PARAMETERS</td>
		</tr>
		<tr>
			
			<td colspan="2">After Dryer Steam</td>
			<td class="vcolor">${cgrade.afterDryerSteam}</td>
			<td>${cdata.afterDryerSteam}</td>
			<td>psi</td>
			<td>Fan Pump speed</td>
			<td class="vcolor">${cgrade.fanPumpSpeed}</td>
			<td>${cdata.fanPumpSpeed}</td>
			<td>rpm</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">SPR loading Front/Back</td>
			<td class="vcolor">${cgrade.sprLoading}</td>
			<td>${cdata.sprLoading}</td>
			<td >psi</td>
			<td>Total head</td>
			<td class="vcolor">${cgrade.totalHead}</td>
			<td>${cdata.totalHead}</td>
			<td></td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Felt Passivator</td>
			<td class="vcolor">${cgrade.feltPassivator}</td>
			<td>${cdata.feltPassivator}</td>
			<td>ml/min</td>
			<td>Headbox level</td>
			<td class="vcolor">${cgrade.headboxLevel}</td>
			<td>${cdata.headboxLevel}</td>
			<td></td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Sprayboom Pressure</td>
			<td class="vcolor">${cgrade.sprayboomPressure}</td>
			<td>${cdata.sprayboomPressure}</td>
			<td>psi</td>
			<td>Horizontal slice local </td>
			<td class="vcolor">${cgrade.horizontalSlice}</td>
			<td>${cdata.horizontalSlice}</td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Sprayboom Temparature</td>
			<td class="vcolor">${cgrade.sprayboomTemparature}</td>
			<td>${cdata.sprayboomTemparature}</td>
			<td><sup>O</sup>F</td>
			<td>Horizontal slice dcs</td>
			<td class="vcolor">${cgrade.horizontalSliceDcs}</td>
			<td>${cdata.horizontalSliceDcs}</td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">WE Fan Speed</td>
			<td class="vcolor">${cgrade.wefanSpeed}</td>
			<td>${cdata.wefanSpeed}</td>
			<td>rpm</td>
			<td>Vertical Slice local</td>
			<td class="vcolor">${cgrade.verticalSlice}</td>
			<td>${cdata.verticalSlice}</td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">DE Fan Speed</td>
			<td class="vcolor">${cgrade.defanSpeed}</td>
			<td>${cdata.defanSpeed}</td>
			<td>rpm</td>
			<td>Vertical Slice dcs</td>
			<td class="vcolor">${cgrade.verticalSliceDcs}</td>
			<td>${cdata.verticalSliceDcs}</td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Make-up air damper</td>
			<td class="vcolor">${cgrade.makeUpAirDamper}</td>
			<td>${cdata.makeUpAirDamper}</td>
			<td>%</td>
			<td>Selectifier reject flow 1</td>
			<td class="vcolor">${cgrade.selectifierRejectFlow1}</td>
			<td>${cdata.selectifierRejectFlow1}</td>
			<td>gpm</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Exhaust damper</td>
			<td class="vcolor">${cgrade.exhaustDamper}</td>
			<td>${cdata.exhaustDamper}</td>
			<td>%</td>
			<td>Selectifier reject flow 2</td>
			<td class="vcolor">${cgrade.selectifierRejectFlow2}</td>
			<td>${cdata.selectifierRejectFlow2}</td>
			<td>gpm</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Exhaust Fan speed</td>
			<td class="vcolor">${cgrade.exhaustFanSpeed}</td>
			<td>${cdata.exhaustFanSpeed}</td>
			<td>rpm</td>
			<td>Sec screen Cycle</td>
			<td class="vcolor">${cgrade.secScreenCycleTime}</td>
			<td>${cdata.secScreenCycleTime}</td>
			<td>min</td>
		</tr>
		
		<tr>
			
			<td colspan="2">WE Hood Temperature</td>
			<td class="vcolor">${cgrade.wehoodTemperature}</td>
			<td>${cdata.wehoodTemperature}</td>
			<td><sup>0</sup>F</td>
			<td>Low Density Cycle</td>
			<td class="vcolor">${cgrade.lowDensityCycleTime}</td>
			<td>${cdata.lowDensityCycleTime}</td>
			<td>min</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">DE Hood Temperature</td>
			<td class="vcolor">${cgrade.dehoodTemperature}</td>
			<td>${cdata.dehoodTemperature}</td>
			<td><sup>0</sup>F</td>
			<td>Refiners Energy</td>
			<td class="vcolor">${cgrade.refinersEnergy}</td>
			<td>${cdata.refinersEnergy}</td>
			<td>kW</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Yankee  &Delta; P</td>
			<td class="vcolor">${cgrade.yankeeAP}</td>
			<td>${cdata.yankeeAP}</td>
			<td>psi</td>
			<td>Number of Refiners</td>
			<td class="vcolor">${cgrade.numberOfRefiners}</td>
			<td>${cdata.numberOfRefiners}</td>
			<td>Nos.</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">After Dryer &Delta; P</td>
			<td class="vcolor">${cgrade.afterDryerAP}</td>
			<td>${cdata.afterDryerAP}</td>
			<td>psi</td>
			<td>Refiner Inlet Cy</td>
			<td class="vcolor">${cgrade.refinerInletConsistency}</td>
			<td>${cdata.refinerInletConsistency}</td>
			<td>%</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Sec Arm Loading</td>
			<td class="vcolor">${cgrade.secArmLoading}</td>
			<td>${cdata.secArmLoading}</td>
			<td>pli</td>
			<td>Machine Chest Cy</td>
			<td class="vcolor">${cgrade.machineChestConsistency}</td>
			<td>${cdata.machineChestConsistency}</td>
			<td>%</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Reel offset</td>
			<td class="vcolor">${cgrade.reelOffset}</td>
			<td>${cdata.reelOffset}</td>
			<td>pli</td>
			<td>Stock flow</td>
			<td class="vcolor">${cgrade.stockFlow}</td>
			<td>${cdata.stockFlow}</td>
			<td>gpm</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Uhle Box North Valve  </td>
			<td class="vcolor">${cgrade.uhleBoxNorthValve}</td>
			<td>${cdata.uhleBoxNorthValve}</td>
			<td>%</td>
			<td>Sweetner Flow</td>
			<td class="vcolor">${cgrade.sweetnerFlow}</td>
			<td>${cdata.sweetnerFlow}</td>
			<td>gpm</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Uhle box South Valve</td>
			<td class="vcolor">${cgrade.uhleBoxSouthValve}</td>
			<td>${cdata.uhleBoxSouthValve}</td>
			<td>%</td>
			<td>Broke </td>
			<td class="vcolor">${cgrade.broke}</td>
			<td>${cdata.broke}</td>
			<td>%</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Flatbox 1 Valve #6773</td>
			<td class="vcolor">${cgrade.faltBox1VacuumValve}</td>
			<td>${cdata.faltBox1VacuumValve}</td>
			<td>%</td>
			<td>Wet strength</td>
			<td class="vcolor">${cgrade.wetStrength}</td>
			<td>${cdata.wetStrength}</td>
			<td>gpm</td>
		</tr>
		<tr>
			<td colspan="2">Flatbox 2 Valve # 6771</td>
			<td class="vcolor">${cgrade.faltBox2VacuumValve}</td>
			<td>${cdata.faltBox2VacuumValve}</td>
			<td>%</td>
			<td colspan="5"></td>
		</tr>
		<tr>
			<td colspan="2">Flatbox 4 Valve # 6770</td>
			<td class="vcolor">${cgrade.faltBox4VacuumValve}</td>
			<td>${cdata.faltBox4VacuumValve}</td>
			<td>%</td>
		</tr>
		
		<tr>
			<td colspan="9" style="text-align: left;">
				Revision History (date, parameter, explanation): 
			</td>
		</tr>
		<tr>
			<td colspan="9" valign="top" style="text-align: left;height: 60px;">
				${cdata.noteSecB}
			</td>
		</tr>

	
	</table>

</div>

</div>

 <script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
 


</body>
</html>
