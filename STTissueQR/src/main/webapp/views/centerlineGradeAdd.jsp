<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
 				<input name="gradeCode" style="width: 150px !important;text-transform: uppercase;" tabindex="1">
 			</td>
 			<td>
 				Issue Date
 			</td>
 			<td style="text-align: left  !important;">
				<input readonly="readonly" value="${date}" name="issueDate" style="width: 150px !important;text-transform: uppercase;" tabindex="1">
 			</td>
 			<td>
 				Revision
 			</td>
 			<td colspan="2" style="text-align: left  !important;">
 				<input name="revision" style="width: 100px !important;text-transform: uppercase;" tabindex="1">
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
  			<td><input class="number" name="yankeeSpeedMinC" value="" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSpeed" value="" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSpeedMaxC" value="" tabindex="1"> </td>
  			<td>fpm</td>
  			<td>Yankee Release</td>
  			<td><input class="number" name="yankeeReleaseMinC" value="" tabindex="2"> </td>
  			<td><input class="number" name="yankeeRelease" value="" tabindex="2"> </td>
  			<td><input class="number" name="yankeeReleaseMaxC" value="" tabindex="2"> </td>
  			<td>mg/m2</td>
  		</tr>
  		<tr>
  			<td>QCS Basis wt target</td>
  			<td><input class="number" name="qcsBasisWtTargetMinC" value="" tabindex="1"> </td>
  			<td><input class="number" name="qcsBasisWtTarget" value="" tabindex="1"> </td>
  			<td><input class="number" name="qcsBasisWtTargetMaxC" value="" tabindex="1"> </td>
  			<td>#</td>
  			<td>Yankee Adesive</td>
  			<td><input class="number" name="yankeeAdesiveMinC" value="" tabindex="2"> </td>
  			<td><input class="number" name="yankeeAdesive" value="" tabindex="2"> </td>
  			<td><input class="number" name="yankeeAdesiveMaxC" value="" tabindex="2"> </td>
  			<td>mg/m2</td>
  		</tr>
  		<tr>
  			<td>Reel Moisture</td>
  			<td><input class="number" name="reelMoistureMinC" value="" tabindex="1"> </td>
  			<td><input class="number" name="reelMoisture" value="" tabindex="1"> </td>
  			<td><input class="number" name="reelMoistureMaxC" value="" tabindex="1"> </td>
  			<td>%</td>
  			<td>Jet Wire Ratio</td>
  			<td><input class="number" name="jetWireRatioMinC" value="" tabindex="2"> </td>
  			<td><input class="number" name="jetWireRatio" value="" tabindex="2"> </td>
  			<td><input class="number" name="jetWireRatioMaxC" value="" tabindex="2"> </td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Crepe</td>
  			<td><input class="number" name="crepeMinC" value="" tabindex="1"> </td>
  			<td><input class="number" name="crepe" value="" tabindex="1"> </td>
  			<td><input class="number" name="crepeMaxC" value="" tabindex="1"> </td>
  			<td>%</td>
  			<td>Fan Pump flow rate</td>
  			<td><input class="number" name="fanPumpFlowRateMinC" value="" tabindex="2"> </td>
  			<td><input class="number" name="fanPumpFlowRate" value="" tabindex="2"> </td>
  			<td><input class="number" name="fanPumpFlowRateMaxC" value="" tabindex="2"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Yankee Steam</td>
  			<td><input class="number" name="yankeeSteamMinC" value="" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSteam" value="" tabindex="1"> </td>
  			<td><input class="number" name="yankeeSteamMaxC" value="" tabindex="1"> </td>
  			<td>psi</td>
  			<td>After Dryer Draw</td>
  			<td><input class="number" name="afterDryerDrawMinC" value="" tabindex="2"> </td>
  			<td><input class="number" name="afterDryerDraw" value="" tabindex="2"> </td>
  			<td><input class="number" name="afterDryerDrawMaxC" value="" tabindex="2"> </td>
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
  			<td><input class="number" name="afterDryerSteamMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerSteam" value="" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerSteamMaxC" value="" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Fan Pump speed</td>
  			<td><input class="number" name="fanPumpSpeedMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="fanPumpSpeed" value="" tabindex="4"> </td>
  			<td><input class="number" name="fanPumpSpeedMaxC" value="" tabindex="4"> </td>
  			<td>rpm</td>
  		</tr>
  		<tr>
  			<td>SPR loading Front/Back</td>
  			<td><input class="string1" name="sprLoadingMinC" value="" tabindex="3"> </td>
  			<td><input class="string1" name="sprLoading" value="" tabindex="3"> </td>
  			<td><input class="string1" name="sprLoadingMaxC" value="" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Total head</td>
  			<td><input class="number" name="totalHeadMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="totalHead" value="" tabindex="4"> </td>
  			<td><input class="number" name="totalHeadMaxC" value="" tabindex="4"> </td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Felt Passivator</td>
  			<td><input class="number" name="feltPassivatorMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="feltPassivator" value="" tabindex="3"> </td>
  			<td><input class="number" name="feltPassivatorMaxC" value="" tabindex="3"> </td>
  			<td>ml/min</td>
  			<td>Headbox level</td>
  			<td><input class="number" name="headboxLevelMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="headboxLevel" value="" tabindex="4"> </td>
  			<td><input class="number" name="headboxLevelMaxC" value="" tabindex="4"> </td>
  			<td></td>
  		</tr>
  		<tr>
  			<td>Sprayboom Pressure</td>
  			<td><input class="number" name="sprayboomPressureMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomPressure" value="" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomPressureMaxC" value="" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Horizontal slice Local</td>
  			<td><input class="string2" name="horizontalSliceMinC" value="" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSlice" value="" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSliceMaxC" value="" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>Sprayboom Temperature</td>
  			<td><input class="number" name="sprayboomTemparatureMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomTemparature" value="" tabindex="3"> </td>
  			<td><input class="number" name="sprayboomTemparatureMaxC" value="" tabindex="3"> </td>
  			<td><sup>o</sup>F</td>
  			<td>Horizontal slice DCS</td>
  			<td><input class="string2" name="horizontalSliceDcsMinC" value="" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSliceDcs" value="" tabindex="4"> </td>
  			<td><input class="string2" name="horizontalSliceDcsMaxC" value="" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>WE Fan Speed</td>
  			<td><input class="number" name="wefanSpeedMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="wefanSpeed" value="" tabindex="3"> </td>
  			<td><input class="number" name="wefanSpeedMaxC" value="" tabindex="3"> </td>
  			<td>rpm</td>
  			<td>Vertical Slice Local</td>
  			<td><input class="string2" name="verticalSliceMinC" value="" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSlice" value="" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSliceMaxC" value="" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>DE Fan Speed</td>
  			<td><input class="number" name="defanSpeedMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="defanSpeed" value="" tabindex="3"> </td>
  			<td><input class="number" name="defanSpeedMaxC" value="" tabindex="3"> </td>
  			<td>rpm</td>
  			<td>Vertical Slice DCS</td>
  			<td><input class="string2" name="verticalSliceDcsMinC" value="" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSliceDcs" value="" tabindex="4"> </td>
  			<td><input class="string2" name="verticalSliceDcsMaxC" value="" tabindex="4"> </td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>Make-up air damper</td>
  			<td><input class="number" name="makeUpAirDamperMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="makeUpAirDamper" value="" tabindex="3"> </td>
  			<td><input class="number" name="makeUpAirDamperMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td>Selectifier reject flow 1</td>
  			<td><input class="number" name="selectifierRejectFlow1MinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow1" value="" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow1MaxC" value="" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Exhaust damper</td>
  			<td><input class="number" name="exhaustDamperMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="exhaustDamper" value="" tabindex="3"> </td>
  			<td><input class="number" name="exhaustDamperMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td>Selectifier reject flow 2</td>
  			<td><input class="number" name="selectifierRejectFlow2MinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow2" value="" tabindex="4"> </td>
  			<td><input class="number" name="selectifierRejectFlow2MaxC" value="" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Exhaust Fan speed</td>
  			<td><input class="number" name="exhaustFanSpeedMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="exhaustFanSpeed" value="" tabindex="3"> </td>
  			<td><input class="number" name="exhaustFanSpeedMaxC" value="" tabindex="3"> </td>
  			<td>rpm</td>
  			<td>Sec screen Cycle</td>
  			<td><input class="number" name="secScreenCycleTimeMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="secScreenCycleTime" value="" tabindex="4"> </td>
  			<td><input class="number" name="secScreenCycleTimeMaxC" value="" tabindex="4"> </td>
  			<td>min</td>
  		</tr>
  		<tr>
  			<td>WE Hood Temperature</td>
  			<td><input class="number" name="wehoodTemperatureMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="wehoodTemperature" value="" tabindex="3"> </td>
  			<td><input class="number" name="wehoodTemperatureMaxC" value="" tabindex="3"> </td>
  			<td><sup>o</sup>F</td>
  			<td>Low Density Cycle</td>
  			<td><input class="number" name="lowDensityCycleTimeMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="lowDensityCycleTime" value="" tabindex="4"> </td>
  			<td><input class="number" name="lowDensityCycleTimeMaxC" value="" tabindex="4"> </td>
  			<td>min</td>
  		</tr>
  		<tr>
  			<td>DE Hood Temperature</td>
  			<td><input class="number" name="dehoodTemperatureMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="dehoodTemperature" value="" tabindex="3"> </td>
  			<td><input class="number" name="dehoodTemperatureMaxC" value="" tabindex="3"> </td>
  			<td><sup>o</sup>F</td>
  			<td>Refiners Energy</td>
  			<td><input class="number" name="refinersEnergyMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="refinersEnergy" value="" tabindex="4"> </td>
  			<td><input class="number" name="refinersEnergyMaxC" value="" tabindex="4"> </td>
  			<td>kW</td>
  		</tr>
  		<tr>
  			<td>Yankee &Delta; P</td>
  			<td><input class="number" name="yankeeAPMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="yankeeAP" value="" tabindex="3"> </td>
  			<td><input class="number" name="yankeeAPMaxC" value="" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Number of Refiners</td>
  			<td><input class="number" name="numberOfRefinersMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="numberOfRefiners" value="" tabindex="4"> </td>
  			<td><input class="number" name="numberOfRefinersMaxC" value="" tabindex="4"> </td>
  			<td>Nos.</td>
  		</tr>
  		<tr>
  			<td>After Dryer &Delta; P</td>
  			<td><input class="number" name="afterDryerAPMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerAP" value="" tabindex="3"> </td>
  			<td><input class="number" name="afterDryerAPMaxC" value="" tabindex="3"> </td>
  			<td>psi</td>
  			<td>Refiner Inlet Cy</td>
  			<td><input class="number" name="refinerInletConsistencyMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="refinerInletConsistency" value="" tabindex="4"> </td>
  			<td><input class="number" name="refinerInletConsistencyMaxC" value="" tabindex="4"> </td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Sec Arm Loading</td>
  			<td><input class="number" name="secArmLoadingMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="secArmLoading" value="" tabindex="3"> </td>
  			<td><input class="number" name="secArmLoadingMaxC" value="" tabindex="3"> </td>
  			<td>pli</td>
  			<td>Machine Chest Cy</td>
  			<td><input class="number" name="machineChestConsistencyMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="machineChestConsistency" value="" tabindex="4"> </td>
  			<td><input class="number" name="machineChestConsistencyMaxC" value="" tabindex="4"> </td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Reel offset</td>
  			<td><input class="number" name="reelOffsetMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="reelOffset" value="" tabindex="3"> </td>
  			<td><input class="number" name="reelOffsetMaxC" value="" tabindex="3"> </td>
  			<td>pli</td>
  			<td>Stock flow</td>
  			<td><input class="number" name="stockFlowMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="stockFlow" value="" tabindex="4"> </td>
  			<td><input class="number" name="stockFlowMaxC" value="" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Uhle Box North Valve</td>
  			<td><input class="number" name="uhleBoxNorthValveMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxNorthValve" value="" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxNorthValveMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td>Sweetner Flow</td>
  			<td><input class="number" name="sweetnerFlowMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="sweetnerFlow" value="" tabindex="4"> </td>
  			<td><input class="number" name="sweetnerFlowMaxC" value="" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Uhle box South Valve</td>
  			<td><input class="number" name="uhleBoxSouthValveMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxSouthValve" value="" tabindex="3"> </td>
  			<td><input class="number" name="uhleBoxSouthValveMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td>Broke</td>
  			<td><input class="number" name="brokeMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="broke" value="" tabindex="4"> </td>
  			<td><input class="number" name="brokeMaxC" value="" tabindex="4"> </td>
  			<td>%</td>
  		</tr>
  		<tr>
  			<td>Flatbox 1 Valve # 6770</td>
  			<td><input class="number" name="faltBox1VacuumValveMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="faltBox1VacuumValve" value="" tabindex="3"> </td>
  			<td><input class="number" name="faltBox1VacuumValveMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td>Wet strength</td>
  			<td><input class="number" name="wetStrengthMinC" value="" tabindex="4"> </td>
  			<td><input class="number" name="wetStrength" value="" tabindex="4"> </td>
  			<td><input class="number" name="wetStrengthMaxC" value="" tabindex="4"> </td>
  			<td>gpm</td>
  		</tr>
  		<tr>
  			<td>Flatbox 2 Valve # 6771</td>
  			<td><input class="number" name="faltBox2VacuumValveMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="faltBox2VacuumValve" value="" tabindex="3"> </td>
  			<td><input class="number" name="faltBox2VacuumValveMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td colspan="5"></td>
  		</tr>
  		<tr>
  			<td>Flatbox 4 Valve # 6770</td>
  			<td><input class="number" name="faltBox4VacuumValveMinC" value="" tabindex="3"> </td>
  			<td><input class="number" name="faltBox4VacuumValve" value="" tabindex="3"> </td>
  			<td><input class="number" name="faltBox4VacuumValveMaxC" value="" tabindex="3"> </td>
  			<td>%</td>
  			<td colspan="5"></td>	
  		</tr>
  		<tr>
  			<td colspan="10">
  				<input type="hidden" name="id" value="">
  			</td>
  		</tr>
  		
 	</tbody>
 </table>
 
 </div>