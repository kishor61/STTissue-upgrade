<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<br><br> 
<script type="text/javascript">
	$(function(){
		
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
	});
</script> 
<div id="printDiv">
<table class="centerline-table" id="centerlineGradeTable" style="font-family:serif;font-size: 14px; ;">
 	<thead>
 	<tr>
 			<td>Grade Code</td>
 			<td colspan="3" style="padding: 4px;">
 				${grade.grade}
 			</td>
 			<td>
 				Issue Date
 			</td>
 			<td>
				${grade.fissueDate}
 			</td>
 			<td>
 				Revision
 			</td>
 			<td colspan="2">
 				${grade.revision}
 			</td>
 			<td></td>
 		</tr>
 	</thead>
 	<tbody>
 		
 		<tr style="background: #996633;color: #FFF;">
 			<td colspan="10">SECTION A: CENTERLINES</td>
 		</tr>
 		<tr style="background-color: #FDC893;">
 			<td style="width: 170px;"></td>
 			<td style="width: 50px;">Min</td>
 			<td style="width: 50px;">Target</td>
 			<td style="width: 50px;">Max</td>
 			<td style="width: 50px;">Unit</td>
 			
 			<td style="width: 170px;"></td>
 			<td style="width: 50px;">Min</td>
 			<td style="width: 50px;">Target</td>
 			<td style="width: 50px;">Max</td>
 			<td style="width: 50px;">Unit</td>
  		</tr>
  		
  		
  		
  		<tr>
  			<td>Basis weight target</td>
  			<td>${grade.qcsBasisWtTargetMinC}</td>
  			<td>${grade.qcsBasisWtTarget}</td>
  			<td>${grade.qcsBasisWtTargetMaxC}</td>
  			<td>#</td>
  			<td>Moisture target</td>
  			<td>${grade.moisturetargetMinC}</td>
  			<td>${grade.moisturetarget}</td>
  			<td>${grade.moisturetargetMaxC}</td>
  			<td>%</td>
  		</tr>
  		
  		
  		
  		
  		
  		
  		
  		
  		<tr>
  			<td>Yankee speed</td>
  			<td>${grade.yankeeSpeedMinC}</td>
  			<td>${grade.yankeeSpeed}</td>
  			<td>${grade.yankeeSpeedMaxC}</td>
  			<td>fpm</td>
  			<td>Yankee Release Flow</td>
  			<td>${grade.yankeeReleaseMinC}</td>
  			<td>${grade.yankeeRelease}</td>
  			<td>${grade.yankeeReleaseMaxC}</td>
  			<td>mg/m2</td>
  		</tr>
  		<%-- <tr>
  			<td>QCS Basis wt target</td>
  			<td>${grade.qcsBasisWtTargetMinC}</td>
  			<td>${grade.qcsBasisWtTarget}</td>
  			<td>${grade.qcsBasisWtTargetMaxC}</td>
  			<td>#</td>
  			 <td>Reel Moisture</td>
  			<td>${grade.reelMoistureMinC}</td>
  			<td>${grade.reelMoisture}</td>
  			<td>${grade.reelMoistureMaxC}</td>
  			<td>%</td>
  		</tr> --%>
  		<tr>
  			
  			<td>Yankee Adesive Flow</td>
  			<td>${grade.yankeeAdesiveMinC}</td>
  			<td>${grade.yankeeAdesive}</td>
  			<td>${grade.yankeeAdesiveMaxC} </td>
  			<td>mg/m2</td>
  			<td>Jet/Wire Ratio</td>
  			<td>${grade.jetWireRatioMinC}</td>
  			<td>${grade.jetWireRatio}</td>
  			<td>${grade.jetWireRatioMaxC}</td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Crepe</td>
  			<td>${grade.crepeMinC}</td>
  			<td>${grade.crepe}</td>
  			<td>${grade.crepeMaxC}</td>
  			<td>%</td>
  			<td>Fan Pump Flow</td>
  			<td>${grade.fanPumpFlowRateMinC}</td>
  			<td>${grade.fanPumpFlowRate}</td>
  			<td>${grade.fanPumpFlowRateMaxC}</td>
  			<td>gpm</td>
  		</tr>
  		<%-- <tr>
  			<td>Yankee Steam Pressure</td>
  			<td>${grade.yankeeSteamMinC}</td>
  			<td>${grade.yankeeSteam}</td>
  			<td>${grade.yankeeSteamMaxC}</td>
  			<td>psi</td>
  			<td>After Dryer Draw</td>
  			<td>${grade.afterDryerDrawMinC}</td>
  			<td>${grade.afterDryerDraw}</td>
  			<td>${grade.afterDryerDrawMaxC}</td>
  			<td>fpm</td>
  		</tr> --%>
  		<tr>
  			<td colspan="10">&nbsp;</td>
  		</tr>
  		<tr style="background: #996633;color: #FFF;">
 			<td colspan="10">SECTION B: PROCESS PARAMETERS</td>
 		</tr>
 		<tr style="background-color: #FDC893;">
 			<td style="width: 150px;"></td>
 			<td style="width: 50px;">Min</td>
 			<td style="width: 50px;">Target</td>
 			<td style="width: 50px;">Max</td>
 			<td style="width: 100px;">Unit</td>
 			
 			<td style="width: 150px;"></td>
 			<td style="width: 50px;">Min</td>
 			<td style="width: 50px;">Target</td>
 			<td style="width: 50px;">Max</td>
 			<td style="width: 100px;">Unit</td>
  		</tr>
  		<tr>
  			<%-- <td>After Dryer Steam</td>
  			<td>${grade.afterDryerSteamMinC}</td>
  			<td>${grade.afterDryerSteam}</td>
  			<td>${grade.afterDryerSteamMaxC}</td>
  			<td>psi</td> --%>
  			<td>Yankee Steam Pressure</td>
  			<td>${grade.yankeeSteamMinC}</td>
  			<td>${grade.yankeeSteam}</td>
  			<td>${grade.yankeeSteamMaxC}</td>
  			<td>psi</td>
  			
  			<td>Fan Pump speed</td>
  			<td>${grade.fanPumpSpeedMinC}</td>
  			<td>${grade.fanPumpSpeed}</td>
  			<td>${grade.fanPumpSpeedMaxC}</td>
  			<td>rpm</td>
  		</tr>
  		<%-- <tr>
  			<td>SPR loading Front/Back</td>
  			<td>${grade.sprLoadingMinC}</td>
  			<td>${grade.sprLoading}</td>
  			<td>${grade.sprLoadingMaxC}</td>
  			<td>psi</td>
  			<td>Total head</td>
  			<td>${grade.totalHeadMinC}</td>
  			<td>${grade.totalHead}</td>
  			<td>${grade.totalHeadMaxC}</td>
  			<td></td>
  		</tr> --%>
  		<tr>
  			<td>Felt Passivator Flow</td>
  			<td>${grade.feltPassivatorMinC}</td>
  			<td>${grade.feltPassivator}</td>
  			<td>${grade.feltPassivatorMaxC}</td>
  			<td>ml/min</td>
  			<td>Headbox level</td>
  			<td>${grade.headboxLevelMinC}</td>
  			<td>${grade.headboxLevel}</td>
  			<td>${grade.headboxLevelMaxC}</td>
  			<td></td>
  		</tr>
  		<tr>
  			<%-- <td>Sprayboom Pressure</td>
  			<td>${grade.sprayboomPressureMinC}</td>
  			<td>${grade.sprayboomPressure}</td>
  			<td>${grade.sprayboomPressureMaxC}</td>
  			<td>psi</td> --%>
  			<%-- <td>Horizontal slice local</td>
  			<td>${grade.horizontalSliceMinC}</td>
  			<td>${grade.horizontalSlice}</td>
  			<td>${grade.horizontalSliceMaxC}</td>
  			<td>in</td> --%>
  		</tr>
  		<%-- <tr>
  			<td>Vertical Slice local</td>
  			<td>${grade.verticalSliceMinC}</td>
  			<td>${grade.verticalSlice}</td>
  			<td>${grade.verticalSliceMaxC}</td>
  			<td>in</td>
  			
  			<td>Horizontal slice DCS</td>
  			<td>${grade.horizontalSliceDcsMinC}</td>
  			<td>${grade.horizontalSliceDcs}</td>
  			<td>${grade.horizontalSliceDcsMaxC}</td>
  			<td>in</td>
  		</tr> --%>
  		<tr>
  			<td>WE Fan Speed</td>
  			<td>${grade.wefanSpeedMinC}</td>
  			<td>${grade.wefanSpeed}</td>
  			<td>${grade.wefanSpeedMaxC}</td>
  			<td>rpm</td>
  			
  			<td>Horizontal slice DCS</td>
  			<td>${grade.horizontalSliceDcsMinC}</td>
  			<td>${grade.horizontalSliceDcs}</td>
  			<td>${grade.horizontalSliceDcsMaxC}</td>
  			<td>in</td>
  			
  			<%-- <td>Vertical Slice local</td>
  			<td>${grade.verticalSliceMinC}</td>
  			<td>${grade.verticalSlice}</td>
  			<td>${grade.verticalSliceMaxC}</td>
  			<td>in</td> --%>
  		</tr>
  		<tr>
  			<td>DE Fan Speed</td>
  			<td>${grade.defanSpeedMinC}</td>
  			<td>${grade.defanSpeed}</td>
  			<td>${grade.defanSpeedMaxC}</td>
  			<td>rpm</td>
  			<td>Vertical Slice DCS</td>
  			<td>${grade.verticalSliceDcsMinC}</td>
  			<td>${grade.verticalSliceDcs}</td>
  			<td>${grade.verticalSliceDcsMaxC}</td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<%-- <td>Make-up air damper</td>
  			<td>${grade.makeUpAirDamperMinC}</td>
  			<td>${grade.makeUpAirDamper}</td>
  			<td>${grade.makeUpAirDamperMaxC}</td>
  			<td>%</td> --%>
  			<%-- <td>Selectifier reject flow 1</td>
  			<td>${grade.selectifierRejectFlow1MinC}</td>
  			<td>${grade.selectifierRejectFlow1}</td>
  			<td>${grade.selectifierRejectFlow1MaxC}</td>
  			<td>gpm</td> --%>
  		</tr>
  		<tr>
  			<%-- <td>Exhaust damper</td>
  			<td>${grade.exhaustDamperMinC}</td>
  			<td>${grade.exhaustDamper}</td>
  			<td>${grade.exhaustDamperMaxC}</td>
  			<td>%</td> --%>
  			<%-- <td>Selectifier reject flow 2</td>
  			<td>${grade.selectifierRejectFlow2MinC}</td>
  			<td>${grade.selectifierRejectFlow2}</td>
  			<td>${grade.selectifierRejectFlow2MaxC}</td>
  			<td>gpm</td> --%>
  		</tr>
  		<%-- <tr>
  			<td>Low Density Cycle</td>
  			<td>${grade.lowDensityCycleTimeMinC}</td>
  			<td>${grade.lowDensityCycleTime}</td>
  			<td>${grade.lowDensityCycleTimeMaxC}</td>
  			<td>min</td>
  			
  			<td>Sec screen Cycle</td>
  			<td>${grade.secScreenCycleTimeMinC}</td>
  			<td>${grade.secScreenCycleTime}</td>
  			<td>${grade.secScreenCycleTimeMaxC}</td>
  			<td>min</td>
  		</tr> --%>
  		<tr>
  			<td>WE Hood Temperature</td>
  			<td>${grade.wehoodTemperatureMinC}</td>
  			<td>${grade.wehoodTemperature}</td>
  			<td>${grade.wehoodTemperatureMaxC}</td>
  			<td><sup>o</sup>F</td>
  			
  			<td>Exhaust Fan speed</td>
  			<td>${grade.exhaustFanSpeedMinC}</td>
  			<td>${grade.exhaustFanSpeed}</td>
  			<td>${grade.exhaustFanSpeedMaxC}</td>
  			<td>rpm</td>
  			
  			
  		</tr>
  		<tr>
  			
  			<%-- <td>Number of Refiners</td>
  			<td>${grade.numberOfRefinersMinC}</td>
  			<td>${grade.numberOfRefiners}</td>
  			<td>${grade.numberOfRefinersMaxC}</td>
  			<td>Nos.</td> --%>
  			
  			<%-- <td>Refiners Energy</td>
  			<td>${grade.refinersEnergyMinC}</td>
  			<td>${grade.refinersEnergy}</td>
  			<td>${grade.refinersEnergyMaxC}</td>
  			<td>kW</td> --%>
  		</tr>
  		<tr>
  			<td>Yankee &Delta; P</td>
  			<td>${grade.yankeeAPMinC}</td>
  			<td>${grade.yankeeAP}</td>
  			<td>${grade.yankeeAPMaxC}</td>
  			<td>psi</td>
  			
  			<td>DE Hood Temperature</td>
  			<td>${grade.dehoodTemperatureMinC}</td>
  			<td>${grade.dehoodTemperature}</td>
  			<td>${grade.dehoodTemperatureMaxC}</td>
  			<td><sup>o</sup>F</td>
  			
  		</tr>
  		<tr>
  			<%-- <td>After Dryer &Delta; P</td>
  			<td>${grade.afterDryerAPMinC}</td>
  			<td>${grade.afterDryerAP}</td>
  			<td>${grade.afterDryerAPMaxC}</td>
  			<td>psi</td> --%>
  			<%-- <td>Refiner Inlet Cy</td>
  			<td>${grade.refinerInletConsistencyMinC} </td>
  			<td>${grade.refinerInletConsistency}</td>
  			<td>${grade.refinerInletConsistencyMaxC}</td>
  			<td>%</td> --%>
  		</tr>
  		<tr>
  			<td>Sec Arm Loading</td>
  			<td>${grade.secArmLoadingMinC}</td>
  			<td>${grade.secArmLoading}</td>
  			<td>${grade.secArmLoadingMaxC}</td>
  			<td>pli</td>
  			<td>Machine Chest Cy</td>
  			<td>${grade.machineChestConsistencyMinC}</td>
  			<td>${grade.machineChestConsistency}</td>
  			<td>${grade.machineChestConsistencyMaxC}</td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Reel offset</td>
  			<td>${grade.reelOffsetMinC}</td>
  			<td>${grade.reelOffset}</td>
  			<td>${grade.reelOffsetMaxC}</td>
  			<td>pli</td>
  			<td>Stock flow</td>
  			<td>${grade.stockFlowMinC}</td>
  			<td>${grade.stockFlow}</td>
  			<td>${grade.stockFlowMaxC}</td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<%-- <td>Uhle Box North Valve</td>
  			<td>${grade.uhleBoxNorthValveMinC}</td>
  			<td>${grade.uhleBoxNorthValve}</td>
  			<td>${grade.uhleBoxNorthValveMaxC}</td>
  			<td>%</td> --%>
  			
  			<%-- <td>Uhle box South Valve</td>
  			<td>${grade.uhleBoxSouthValveMinC}</td>
  			<td>${grade.uhleBoxSouthValve}</td>
  			<td>${grade.uhleBoxSouthValveMaxC}</td>
  			<td>%</td> --%>
  			
  		</tr>
  		<tr>
  			
  			<td>Sweetner Flow</td>
  			<td>${grade.sweetnerFlowMinC}</td>
  			<td>${grade.sweetnerFlow}</td>
  			<td>${grade.sweetnerFlowMaxC}</td>
  			<td>gpm</td>
  			
  			<td>Broke Addition</td>
  			<td>${grade.brokeMinC}</td>
  			<td>${grade.broke}</td>
  			<td>${grade.brokeMaxC}</td>
  			<td>%</td>
  		</tr>
  		<%-- <tr>
  			<td>Flatbox 1 Valve # 6773</td>
  			<td>${grade.faltBox1VacuumValveMinC}</td>
  			<td>${grade.faltBox1VacuumValve}</td>
  			<td>${grade.faltBox1VacuumValveMaxC}</td>
  			<td>%</td>
  			<td>Wet strength</td>
  			<td>${grade.wetStrengthMinC}</td>
  			<td>${grade.wetStrength}</td>
  			<td>${grade.wetStrengthMaxC}</td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Flatbox 2 Valve # 6771</td>
  			<td>${grade.faltBox2VacuumValveMinC}</td>
  			<td>${grade.faltBox2VacuumValve}</td>
  			<td>${grade.faltBox2VacuumValveMaxC}</td>
  			<td>%</td>
  			<td colspan="5"></td>
  		</tr>
  		<tr>
  			<td>Flatbox 4 Valve # 6770</td>
  			<td>${grade.faltBox4VacuumValveMinC}</td>
  			<td>${grade.faltBox4VacuumValve}</td>
  			<td>${grade.faltBox4VacuumValveMaxC}</td>
  			<td>%</td>
  			<td colspan="5"></td>
  		</tr> --%>
  		<tr>
  			<td>SPR Loading Front</td>
  			<td>${grade.sprloadingfrontMinC}</td>
  			<td>${grade.sprloadingfront}</td>
  			<td>${grade.sprloadingfrontMaxC}</td>
  			<td>pli</td>
  			<td>SPR Loading Back</td>
  			<td>${grade.sprloadingbackMinC}</td>
  			<td>${grade.sprloadingback}</td>
  			<td>${grade.sprloadingbackMaxC}</td>
  			<td>pli</td>
  		</tr>
  		<tr>
  			<td>Pick Up Roll Vacuum	</td>
  			<td>${grade.pickuprollvacuumMinC}</td>
  			<td>${grade.pickuprollvacuum}</td>
  			<td>${grade.pickuprollvacuumMaxC}</td>
  			<td>in Hg</td>
  			<td>Uhle Box Vacuum</td>
  			<td>${grade.uhleboxvacuumMinC}</td>
  			<td>${grade.uhleboxvacuum}</td>
  			<td>${grade.uhleboxvacuumMaxC}</td>
  			<td>in Hg</td>
  		</tr>
  		<tr>
  			<td>SPR Vacuum</td>
  			<td>${grade.sprvacuumMinC}</td>
  			<td>${grade.sprvacuum}</td>
  			<td>${grade.sprvacuumMaxC}</td>
  			<td>in Hg</td>
  			<td>Primary Screen Reject Flow</td>
  			<td>${grade.primaryscreenrejectflowMinC}</td>
  			<td>${grade.primaryscreenrejectflow}</td>
  			<td>${grade.primaryscreenrejectflowMaxC}</td>
  			<td>in Hg</td>
  		</tr>
  		<tr>
  			<td>Blend Chest Cy	</td>
  			<td>${grade.blendchestcyMinC}</td>
  			<td>${grade.blendchestcy}</td>
  			<td>${grade.blendchestcyMaxC}</td>
  			<td>%</td>
  			<td>Refiner # 1 power</td>
  			<td>${grade.refiner1powerMinC}</td>
  			<td>${grade.refiner1power}</td>
  			<td>${grade.refiner1powerMaxC}</td>
  			<td>kw</td>
  		</tr>
  		<tr>
  			<td>Refiner # 2 Power</td>
  			<td>${grade.refiner2powerMinC}</td>
  			<td>${grade.refiner2power}</td>
  			<td>${grade.refiner2powerMaxC}</td>
  			<td>kw</td>
  			<td>Refiner # 1 Inlet Cy	</td>
  			<td>${grade.refiner1inletcyMinC}</td>
  			<td>${grade.refiner1inletcy}</td>
  			<td>${grade.refiner1inletcyMaxC}</td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Refiner # 2 Inlet Cy</td>
  			<td>${grade.refiner2inletcyMinC}</td>
  			<td>${grade.refiner2inletcy}</td>
  			<td>${grade.refiner2inletcyMaxC}</td>
  			<td>kw</td>
  			
  			<td>Total head</td>
  			<td>${grade.totalHeadMinC}</td>
  			<td>${grade.totalHead}</td>
  			<td>${grade.totalHeadMaxC}</td>
  			<td></td>
  			
  		</tr>
  		<tr>
  			<td>Machine chest pump speed</td>
  			<td>${grade.machinechestpumpspeedMinC}</td>
  			<td>${grade.machinechestpumpspeed}</td>
  			<td>${grade.machinechestpumpspeedMaxC}</td>
  			<td>kw</td>
  			
  			<td>Yankee MAP flow</td>
  			<td>${grade.yankeemapflowMinC}</td>
  			<td>${grade.yankeemapflow}</td>
  			<td>${grade.yankeemapflowMaxC}</td>
  			<td>kw</td>
  			
  		</tr>
  		
  		<tr>
  			<td>Wet strength flow</td>
  			<td>${grade.wetStrengthMinC}</td>
  			<td>${grade.wetStrength}</td>
  			<td>${grade.wetStrengthMaxC}</td>
  			<td>kw</td>
  		</tr>
  		<tr>
  			<td colspan="10">
  				<input type="hidden" name="id" value="${grade.id}">
  			</td>
  		</tr>
  		
 	</tbody>
 </table>
 </div>
 
 