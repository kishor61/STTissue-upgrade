<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <div style="padding: 5px;">
 <spring:url value="/centerlinegrade/save" var="saveURL"/>
 <script type="text/javascript">
 var saveGradeURL='${saveURL}';
 
 </script>
 <table class="centerline-table" id="centerlineGradeTable">
 	<tbody>
 		<tr>
 			<td style=" width: 208px;">Grade Code</td>
 			<td colspan="3" style="text-align: left  !important;">
 				<input name="gradeCode" value="${grade.grade}" style="width: 150px !important;text-transform: uppercase;" tabindex="1">
 			</td>
 				<td>
 				Issue Date
 			</td>
 			<td style="text-align: left  !important;">
 				<fmt:formatDate value="${grade.issueDate}" pattern="MM-dd-yyyy" var="date"/>
				<input readonly="readonly" name="issueDate" value="${date}" style="width: 150px !important;text-transform: uppercase;" tabindex="1">
 			</td>
 			<td>
 				Revision
 			</td>
 			<td colspan="2" style="text-align: left  !important;">
 				<input name="revision" value="${grade.revision}" style="width: 100px !important;text-transform: uppercase;" tabindex="1">
 			</td>
 			<td></td>
 		</tr>
 		<tr style="background: #996633;color: #FFF;">
 			<td colspan="10">SECTION A: CENTERLINES</td>
 		</tr>
 		<tr style="background-color: #FDC893;">
 			<td style="width: 233px;"></td>
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
  			<td>Yankee speed</td>
  			<td><input class="number" name="yankeeSpeedMinC" value="${grade.yankeeSpeedMinC}" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSpeed" value="${grade.yankeeSpeed}" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSpeedMaxC" value="${grade.yankeeSpeedMaxC}" tabindex="1"> </td>
  			<td>fpm</td>
  			<td>Yankee Release</td>
  			<td><input class="number" name="yankeeReleaseMinC" value="${grade.yankeeReleaseMinC}" tabindex="2"> </td>
  			<td><input class="number" name="yankeeRelease" value="${grade.yankeeRelease}" tabindex="2"> </td>
  			<td><input class="number" name="yankeeReleaseMaxC" value="${grade.yankeeReleaseMaxC}" tabindex="2"> </td>
  			<td>mg/m2</td>
  		</tr>
  		<tr>
  			<td>QCS Basis wt target</td>
  			<td><input class="number" name="qcsBasisWtTargetMinC" value="${grade.qcsBasisWtTargetMinC}" tabindex="1"> </td>
  			<td><input class="number" name="qcsBasisWtTarget" value="${grade.qcsBasisWtTarget}" tabindex="1"> </td>
  			<td><input class="number" name="qcsBasisWtTargetMaxC" value="${grade.qcsBasisWtTargetMaxC}" tabindex="1"> </td>
  			<td>#</td>
  			<td>Yankee Adesive</td>
  			<td><input class="number" name="yankeeAdesiveMinC" value="${grade.yankeeAdesiveMinC}" tabindex="2"> </td>
  			<td><input class="number" name="yankeeAdesive" value="${grade.yankeeAdesive}" tabindex="2"> </td>
  			<td><input class="number" name="yankeeAdesiveMaxC" value="${grade.yankeeAdesiveMaxC}" tabindex="2"> </td>
  			<td>mg/m2</td>
  		</tr>
  		<tr>
  			<td>Reel Moisture</td>
  			<td><input class="number" name="reelMoistureMinC" value="${grade.reelMoistureMinC}" tabindex="1"> </td>
  			<td><input class="number" name="reelMoisture" value="${grade.reelMoisture}" tabindex="1"> </td>
  			<td><input class="number" name="reelMoistureMaxC" value="${grade.reelMoistureMaxC}" tabindex="1"> </td>
  			<td>%</td>
  			<td>Jet Wire Ratio</td>
  			<td><input class="number" name="jetWireRatioMinC" value="${grade.jetWireRatioMinC}" tabindex="2"> </td>
  			<td><input class="number" name="jetWireRatio" value="${grade.jetWireRatio}" tabindex="2"> </td>
  			<td><input class="number" name="jetWireRatioMaxC" value="${grade.jetWireRatioMaxC}" tabindex="2"> </td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Crepe</td>
  			<td><input class="number" name="crepeMinC" value="${grade.crepeMinC}" tabindex="1"> </td>
  			<td><input class="number" name="crepe" value="${grade.crepe}" tabindex="1"> </td>
  			<td><input class="number" name="crepeMaxC" value="${grade.crepeMaxC}" tabindex="1"> </td>
  			<td>%</td>
  			<td>Fan Pump flow rate</td>
  			<td><input class="number" name="fanPumpFlowRateMinC" value="${grade.fanPumpFlowRateMinC}" tabindex="2"> </td>
  			<td><input class="number" name="fanPumpFlowRate" value="${grade.fanPumpFlowRate}" tabindex="2"> </td>
  			<td><input class="number" name="fanPumpFlowRateMaxC" value="${grade.fanPumpFlowRateMaxC}" tabindex="2"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Yankee Steam</td>
  			<td><input class="number" name="yankeeSteamMinC" value="${grade.yankeeSteamMinC}" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSteam" value="${grade.yankeeSteam}" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSteamMaxC" value="${grade.yankeeSteamMaxC}" tabindex="1"> </td>
  			<td>psi</td>
  			<td>After Dryer Draw</td>
  			<td><input class="number" name="afterDryerDrawMinC" value="${grade.afterDryerDrawMinC}" tabindex="2"> </td>
  			<td><input class="number" name="afterDryerDraw" value="${grade.afterDryerDraw}" tabindex="2"> </td>
  			<td><input class="number" name="afterDryerDrawMaxC" value="${grade.afterDryerDrawMaxC}" tabindex="2"> </td>
  			<td>fpm</td>
  		</tr>
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
  			<td>After Dryer Steam</td>
  			<td><input class="number" name="afterDryerSteamMinC" value="${grade.afterDryerSteamMinC}" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerSteam" value="${grade.afterDryerSteam}" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerSteamMaxC" value="${grade.afterDryerSteamMaxC}" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Fan Pump speed</td>
  			<td><input class="number" name="fanPumpSpeedMinC" value="${grade.fanPumpSpeedMinC}" tabindex="4"> </td>
  			<td><input class="number" name="fanPumpSpeed" value="${grade.fanPumpSpeed}" tabindex="4"> </td>
  			<td><input class="number" name="fanPumpSpeedMaxC" value="${grade.fanPumpSpeedMaxC}" tabindex="4"> </td>
  			<td>rpm</td>
  		</tr>
  		<tr>
  			<td>SPR loading Front/Back</td>
  			<td><input class="string1" name="sprLoadingMinC" value="${grade.sprLoadingMinC}" tabindex="3"> </td>
  			<td><input class="string1" name="sprLoading" value="${grade.sprLoading}" tabindex="3"> </td>
  			<td><input class="string1" name="sprLoadingMaxC" value="${grade.sprLoadingMaxC}" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Total head</td>
  			<td><input class="number" name="totalHeadMinC" value="${grade.totalHeadMinC}" tabindex="4"> </td>
  			<td><input class="number" name="totalHead" value="${grade.totalHead}" tabindex="4"> </td>
  			<td><input class="number" name="totalHeadMaxC" value="${grade.totalHeadMaxC}" tabindex="4"> </td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Felt Passivator</td>
  			<td><input class="number" name="feltPassivatorMinC" value="${grade.feltPassivatorMinC}" tabindex="3"> </td>
  			<td><input class="number" name="feltPassivator" value="${grade.feltPassivator}" tabindex="3"> </td>
  			<td><input class="number" name="feltPassivatorMaxC" value="${grade.feltPassivatorMaxC}" tabindex="3"> </td>
  			<td>ml/min</td>
  			<td>Headbox level</td>
  			<td><input class="number" name="headboxLevelMinC" value="${grade.headboxLevelMinC}" tabindex="4"> </td>
  			<td><input class="number" name="headboxLevel" value="${grade.headboxLevel}" tabindex="4"> </td>
  			<td><input class="number" name="headboxLevelMaxC" value="${grade.headboxLevelMaxC}" tabindex="4"> </td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Sprayboom Pressure</td>
  			<td><input class="number" name="sprayboomPressureMinC" value="${grade.sprayboomPressureMinC}" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomPressure" value="${grade.sprayboomPressure}" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomPressureMaxC" value="${grade.sprayboomPressureMaxC}" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Horizontal Slice Local</td>
  			<td><input class="string2" name="horizontalSliceMinC" value="${grade.horizontalSliceMinC}" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSlice" value="${grade.horizontalSlice}" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSliceMaxC" value="${grade.horizontalSliceMaxC}" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>Sprayboom Temperature</td>
  			<td><input class="number" name="sprayboomTemparatureMinC" value="${grade.sprayboomTemparatureMinC}" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomTemparature" value="${grade.sprayboomTemparature}" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomTemparatureMaxC" value="${grade.sprayboomTemparatureMaxC}" tabindex="3"> </td>
  			<td><sup>o</sup>F</td>
  			<td>Horizontal Slice DCS</td>
  			<td><input class="string2" name="horizontalSliceDcsMinC" value="${grade.horizontalSliceDcsMinC}" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSliceDcs" value="${grade.horizontalSliceDcs}" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSliceDcsMaxC" value="${grade.horizontalSliceDcsMaxC}" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>WE Fan Speed</td>
  			<td><input class="number" name="wefanSpeedMinC" value="${grade.wefanSpeedMinC}" tabindex="3"> </td>
  			<td><input class="number" name="wefanSpeed" value="${grade.wefanSpeed}" tabindex="3"> </td>
  			<td><input class="number" name="wefanSpeedMaxC" value="${grade.wefanSpeedMaxC}" tabindex="3"> </td>
  			<td>rpm</td>
  			<td>Vertical Slice Local</td>
  			<td><input class="string2" name="verticalSliceMinC" value="${grade.verticalSliceMinC}" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSlice" value="${grade.verticalSlice}" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSliceMaxC" value="${grade.verticalSliceMaxC}" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>DE Fan Speed</td>
  			<td><input class="number" name="defanSpeedMinC" value="${grade.defanSpeedMinC}" tabindex="3"> </td>
  			<td><input class="number" name="defanSpeed" value="${grade.defanSpeed}" tabindex="3"> </td>
  			<td><input class="number" name="defanSpeedMaxC" value="${grade.defanSpeedMaxC}" tabindex="3"> </td>
  			<td>rpm</td>
  			<td>Vertical Slice DCS</td>
  			<td><input class="string2" name="verticalSliceDcsMinC" value="${grade.verticalSliceDcsMinC}" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSliceDcs" value="${grade.verticalSliceDcs}" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSliceDcsMaxC" value="${grade.verticalSliceDcsMaxC}" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>Make-up air damper</td>
  			<td><input class="number" name="makeUpAirDamperMinC" value="${grade.makeUpAirDamperMinC}" tabindex="3"> </td>
  			<td><input class="number" name="makeUpAirDamper" value="${grade.makeUpAirDamper}" tabindex="3"> </td>
  			<td><input class="number" name="makeUpAirDamperMaxC" value="${grade.makeUpAirDamperMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td>Selectifier reject flow 1</td>
  			<td><input class="number" name="selectifierRejectFlow1MinC" value="${grade.selectifierRejectFlow1MinC}" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow1" value="${grade.selectifierRejectFlow1}" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow1MaxC" value="${grade.selectifierRejectFlow1MaxC}" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Exhaust damper</td>
  			<td><input class="number" name="exhaustDamperMinC" value="${grade.exhaustDamperMinC}" tabindex="3"> </td>
  			<td><input class="number" name="exhaustDamper" value="${grade.exhaustDamper}" tabindex="3"> </td>
  			<td><input class="number" name="exhaustDamperMaxC" value="${grade.exhaustDamperMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td>Selectifier reject flow 2</td>
  			<td><input class="number" name="selectifierRejectFlow2MinC" value="${grade.selectifierRejectFlow2MinC}" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow2" value="${grade.selectifierRejectFlow2}" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow2MaxC" value="${grade.selectifierRejectFlow2MaxC}" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Exhaust Fan speed</td>
  			<td><input class="number" name="exhaustFanSpeedMinC" value="${grade.exhaustFanSpeedMinC}" tabindex="3"> </td>
  			<td><input class="number" name="exhaustFanSpeed" value="${grade.exhaustFanSpeed}" tabindex="3"> </td>
  			<td><input class="number" name="exhaustFanSpeedMaxC" value="${grade.exhaustFanSpeedMaxC}" tabindex="3"> </td>
  			<td>rpm</td>
  			<td>Sec screen Cycle</td>
  			<td><input class="number" name="secScreenCycleTimeMinC" value="${grade.secScreenCycleTimeMinC}" tabindex="4"> </td>
  			<td><input class="number" name="secScreenCycleTime" value="${grade.secScreenCycleTime}" tabindex="4"> </td>
  			<td><input class="number" name="secScreenCycleTimeMaxC" value="${grade.secScreenCycleTimeMaxC}" tabindex="4"> </td>
  			<td>min</td>
  		</tr>
  		<tr>
  			<td>WE Hood Temperature</td>
  			<td><input class="number" name="wehoodTemperatureMinC" value="${grade.wehoodTemperatureMinC}" tabindex="3"> </td>
  			<td><input class="number" name="wehoodTemperature" value="${grade.wehoodTemperature}" tabindex="3"> </td>
  			<td><input class="number" name="wehoodTemperatureMaxC" value="${grade.wehoodTemperatureMaxC}" tabindex="3"> </td>
  			<td><sup>o</sup>F</td>
  			<td>Low Density Cycle</td>
  			<td><input class="number" name="lowDensityCycleTimeMinC" value="${grade.lowDensityCycleTimeMinC}" tabindex="4"> </td>
  			<td><input class="number" name="lowDensityCycleTime" value="${grade.lowDensityCycleTime}" tabindex="4"> </td>
  			<td><input class="number" name="lowDensityCycleTimeMaxC" value="${grade.lowDensityCycleTimeMaxC}" tabindex="4"> </td>
  			<td>min</td>
  		</tr>
  		<tr>
  			<td>DE Hood Temperature</td>
  			<td><input class="number" name="dehoodTemperatureMinC" value="${grade.dehoodTemperatureMinC}" tabindex="3"> </td>
  			<td><input class="number" name="dehoodTemperature" value="${grade.dehoodTemperature}" tabindex="3"> </td>
  			<td><input class="number" name="dehoodTemperatureMaxC" value="${grade.dehoodTemperatureMaxC}" tabindex="3"> </td>
  			<td><sup>o</sup>F</td>
  			<td>Refiners Energy</td>
  			<td><input class="number" name="refinersEnergyMinC" value="${grade.refinersEnergyMinC}" tabindex="4"> </td>
  			<td><input class="number" name="refinersEnergy" value="${grade.refinersEnergy}" tabindex="4"> </td>
  			<td><input class="number" name="refinersEnergyMaxC" value="${grade.refinersEnergyMaxC}" tabindex="4"> </td>
  			<td>kW</td>
  		</tr>
  		<tr>
  			<td>Yankee &Delta; P</td>
  			<td><input class="number" name="yankeeAPMinC" value="${grade.yankeeAPMinC}" tabindex="3"> </td>
  			<td><input class="number" name="yankeeAP" value="${grade.yankeeAP}" tabindex="3"> </td>
  			<td><input class="number" name="yankeeAPMaxC" value="${grade.yankeeAPMaxC}" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Number of Refiners</td>
  			<td><input class="number" name="numberOfRefinersMinC" value="${grade.numberOfRefinersMinC}" tabindex="4"> </td>
  			<td><input class="number" name="numberOfRefiners" value="${grade.numberOfRefiners}" tabindex="4"> </td>
  			<td><input class="number" name="numberOfRefinersMaxC" value="${grade.numberOfRefinersMaxC}" tabindex="4"> </td>
  			<td>Nos.</td>
  		</tr>
  		<tr>
  			<td>After Dryer &Delta; P</td>
  			<td><input class="number" name="afterDryerAPMinC" value="${grade.afterDryerAPMinC}" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerAP" value="${grade.afterDryerAP}" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerAPMaxC" value="${grade.afterDryerAPMaxC}" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Refiner Inlet Cy</td>
  			<td><input class="number" name="refinerInletConsistencyMinC" value="${grade.refinerInletConsistencyMinC}" tabindex="4"> </td>
  			<td><input class="number" name="refinerInletConsistency" value="${grade.refinerInletConsistency}" tabindex="4"> </td>
  			<td><input class="number" name="refinerInletConsistencyMaxC" value="${grade.refinerInletConsistencyMaxC}" tabindex="4"> </td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Sec Arm Loading</td>
  			<td><input class="number" name="secArmLoadingMinC" value="${grade.secArmLoadingMinC}" tabindex="3"> </td>
  			<td><input class="number" name="secArmLoading" value="${grade.secArmLoading}" tabindex="3"> </td>
  			<td><input class="number" name="secArmLoadingMaxC" value="${grade.secArmLoadingMaxC}" tabindex="3"> </td>
  			<td>pli</td>
  			<td>Machine Chest Cy</td>
  			<td><input class="number" name="machineChestConsistencyMinC" value="${grade.machineChestConsistencyMinC}" tabindex="4"> </td>
  			<td><input class="number" name="machineChestConsistency" value="${grade.machineChestConsistency}" tabindex="4"> </td>
  			<td><input class="number" name="machineChestConsistencyMaxC" value="${grade.machineChestConsistencyMaxC}" tabindex="4"> </td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Reel offset</td>
  			<td><input class="number" name="reelOffsetMinC" value="${grade.reelOffsetMinC}" tabindex="3"> </td>
  			<td><input class="number" name="reelOffset" value="${grade.reelOffset}" tabindex="3"> </td>
  			<td><input class="number" name="reelOffsetMaxC" value="${grade.reelOffsetMaxC}" tabindex="3"> </td>
  			<td>pli</td>
  			<td>Stock flow</td>
  			<td><input class="number" name="stockFlowMinC" value="${grade.stockFlowMinC}" tabindex="4"> </td>
  			<td><input class="number" name="stockFlow" value="${grade.stockFlow}" tabindex="4"> </td>
  			<td><input class="number" name="stockFlowMaxC" value="${grade.stockFlowMaxC}" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Uhle Box North Valve</td>
  			<td><input class="number" name="uhleBoxNorthValveMinC" value="${grade.uhleBoxNorthValveMinC}" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxNorthValve" value="${grade.uhleBoxNorthValve}" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxNorthValveMaxC" value="${grade.uhleBoxNorthValveMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td>Sweetner Flow</td>
  			<td><input class="number" name="sweetnerFlowMinC" value="${grade.sweetnerFlowMinC}" tabindex="4"> </td>
  			<td><input class="number" name="sweetnerFlow" value="${grade.sweetnerFlow}" tabindex="4"> </td>
  			<td><input class="number" name="sweetnerFlowMaxC" value="${grade.sweetnerFlowMaxC}" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Uhle box South Valve</td>
  			<td><input class="number" name="uhleBoxSouthValveMinC" value="${grade.uhleBoxSouthValveMinC}" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxSouthValve" value="${grade.uhleBoxSouthValve}" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxSouthValveMaxC" value="${grade.uhleBoxSouthValveMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td>Broke</td>
  			<td><input class="number" name="brokeMinC" value="${grade.brokeMinC}" tabindex="4"> </td>
  			<td><input class="number" name="broke" value="${grade.broke}" tabindex="4"> </td>
  			<td><input class="number" name="brokeMaxC" value="${grade.brokeMaxC}" tabindex="4"> </td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Flatbox 1 Valve #6773</td>
  			<td><input class="number" name="faltBox1VacuumValveMinC" value="${grade.faltBox1VacuumValveMinC}" tabindex="3"> </td>
  			<td><input class="number" name="faltBox1VacuumValve" value="${grade.faltBox1VacuumValve}" tabindex="3"> </td>
  			<td><input class="number" name="faltBox1VacuumValveMaxC" value="${grade.faltBox1VacuumValveMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td>Wet strength</td>
  			<td><input class="number" name="wetStrengthMinC" value="${grade.wetStrengthMinC}" tabindex="4"> </td>
  			<td><input class="number" name="wetStrength" value="${grade.wetStrength}" tabindex="4"> </td>
  			<td><input class="number" name="wetStrengthMaxC" value="${grade.wetStrengthMaxC}" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Flatbox 2 Valve # 6771</td>
  			<td><input class="number" name="faltBox2VacuumValveMinC" value="${grade.faltBox2VacuumValveMinC}" tabindex="3"> </td>
  			<td><input class="number" name="faltBox2VacuumValve" value="${grade.faltBox2VacuumValve}" tabindex="3"> </td>
  			<td><input class="number" name="faltBox2VacuumValveMaxC" value="${grade.faltBox2VacuumValveMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td colspan="5"></td>
  		</tr>
  		<tr>
  			<td>Flatbox 4 Valve # 6770</td>
  			<td><input class="number" name="faltBox4VacuumValveMinC" value="${grade.faltBox4VacuumValveMinC}" tabindex="3"> </td>
  			<td><input class="number" name="faltBox4VacuumValve" value="${grade.faltBox4VacuumValve}" tabindex="3"> </td>
  			<td><input class="number" name="faltBox4VacuumValveMaxC" value="${grade.faltBox4VacuumValveMaxC}" tabindex="3"> </td>
  			<td>%</td>
  			<td colspan="5"></td>
  		</tr>
  		<tr>
  			<td colspan="10">
  				<input type="hidden" name="id" value="${id}">
  			</td>
  		</tr>
  		
 	</tbody>
 </table>
 <spring:url value="/validuser" var="checkUserURL"/>
 <script type="text/javascript">
 	$(function(){
 		$('#centerlineGradeTable input, #centerlineGradeTable select').attr('disabled','disabled');
 		$('#passwordBtn').click(checkUserAuth);
 		$('#passwordForm').find('#passwordVal').keypress(function(e){
 			if ( e.which == 13 ) {
 			    e.preventDefault();
 			    checkUserAuth();
 			  }
 		});
 	});

 	function checkUserAuth(){
 		var val=$('#passwordForm').find('#passwordVal').val();

 		if($.trim(val)!=''){
				$.ajax({
		 			url:'${checkUserURL}',
		 			type:'POST',
		 			data:{
		 				code:val
		 			},
		 			success:function(data){
		 				if(data.status){
		 					$('#centerlineGradeTable input, #centerlineGradeTable select').removeAttr('disabled');
		 					$('#dialog').hide();
		 				}else{
		 					$('#passwordForm #passError').text('Invalid password. Try again?');
		 				}
		 			}
		 		});
			}
 	}
 </script>
 </div>
 
