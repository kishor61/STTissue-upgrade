<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>



<spring:url value="/centerline/getclgrade" var="getgradeURL"/>
<spring:url value="/centerline/savecldata" var="savecldataURL"/>
<spring:url value="/centerline/getcurrentgrade" var="getcurrentGradeURL"/>
<spring:url value="/centerline/loaddata" var="loaddataGradeURL"/>
<spring:url value="/centerline/deletecldata" var="deletecldataURL"/>
<spring:url value="/centerline/print" var="printURL"/>
<%-- <spring:url value="/centerline/getencodedgrade" var="getGradeCodeURL"/> --%>
<spring:url value="/centerline/print/grade" var="printGradeURL"/>
<script type="text/javascript">
var getGradeUrl='${getgradeURL}';
var savecldataUrl='${savecldataURL}';
var loadcldataUrl='${loaddataGradeURL}';
var deletecldataURL='${deletecldataURL}';

$(function(){
	$.ajax({
		url:'${getcurrentGradeURL}',
		type: 'POST',
		success:function(data){
			
			 if(data.length!=0){
					for(var i=0;i<data.length;i++){
						
						
						
						var tableBody=$('#currentTable');
						var tr='<tr>'+
						//	'<td></td>'+
						//	'<td>'+data[i].DATE+'</td>'+
							'<td>'+
							'<a href="javascript:loadRunningGrade('+data[i].ID+')">'+data[i].GRADE+'</a>'+
						//	' &nbsp;<a href="javascript:deletecl('+data[i].ID+')">Delete</a>'+
							'</td>'+
							'</tr>';
							tableBody.append(tr); 
					}

				}
		}
	});
	
});

</script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/centerline.js"/>'></script>

<script type="text/javascript">
	$(function(){
		$( "input[name=issueDate]" ).datepicker( "destroy" );
		
		$('#printBtn').click(function(){
			var aele=$(this);
			if($('input[name=id]').val()!=''){
				var link='${printURL}/'+$('input[name=id]').val();
				$(this).prop('href',link);
				return true;
			}else{
				var grade=$('select[name=grade]').val();
				if(grade!=''){
					var link='${printGradeURL}/'+grade;
					window.open(link);
					/* $.ajax({
						url:'${getGradeCodeURL}',
						type:'POST',
						data:{grade:grade},
						success:function(data){
							
						}
					}); */
				}
				return false;
			}
		});
	});
</script>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">
				<div class="page-title">
					<span class="label">Centerline Data Entry</span>
				</div>
				<br>
				
				</div>
				
		<div class="table-selector">

				<table style="width: 100%;">
					<tr>
					
						<td align="center"><a href="#" id="printBtn" target="_blank">Print Page</a> </td>
					</tr>
				</table>
			</div>
<div style="padding: 10px;" id="printDiv">
	<table class="centerline-table" id="centerlineTable">
	<thead>	
		<tr>
			<td align="center" colspan="2">GRADE CODE:</td>
			<td colspan="3" align="center">
			<select name="grade" style="width: 230px;" tabindex="1">
			
					<option value="">Select Grade</option>
					<c:forEach items="${clgrades}" var="map">
						<option value="${map['ID']}">${map['Grade']}</option>
					</c:forEach>
					
			</select></td>
			<td colspan="2"></td>
			<td>Issue Date</td>
			<td>
				<input readonly="readonly" style="width: 78px;" type="text" name="issueDate" value="${date}">
			</td>

		</tr>
		<tr style="height: 20px;">
			<td style="width: 70px;">CREW:</td>
			<td>
				<select name="crew" style="width: 90px;" tabindex="3">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
				</select>
			</td>
			<td >SHIFT:</td>
			<td>	
				<select name="shift" style="width: 72px;" tabindex="4">
					<option class="Day">Day</option>
					<option class="Night">Night</option>
				</select>
			</td>
			<td>DATE:</td>
			<td colspan="2" style="text-align: left;">
				<input readonly="readonly" style="width: 150px;"  type="text" name="date" value="${date}" tabindex="5">
			</td>
			<td >Revision</td>
			<td  style="text-align: left;"><input type="text" readonly="readonly" name="revision"></td>
		</tr>
		<tr style="height: 40px; text-align: center; font-size: 12px;">
			<td colspan="2">&nbsp;</td>
			<td>Setpoint</td>
			<td>Actual Value</td>
			<td>Unit of Measure</td>
			<td></td>
			<td>Setpoint</td>
			<td>Actual Value</td>
			<td>Unit of Measure</td>
		</tr>
		
		</thead>
		<tbody>
		<tr style="background-color: #FDC893;">
			<td colspan="9" style="text-align: left;">SECTION A: CENTERLINES</td>
		</tr>
	


		<tr>
	
			<td style="" colspan="2">Yankee speed</td>
			<td style="width: 80px;" class="vcolor"></td>
			<td style="width: 60px;"><input class="number" type="text" name="yankeeSpeed" tabindex="6"> </td>
			<td style="width: 70px;">fpm</td>
			<td style="width: 135px;">Yankee Release</td>
			<td style="width: 80px;" class="vcolor"></td>
			<td style="width: 60px;"><input  class="number" type="text" name="yankeeRelease" tabindex="12"> </td>
			<td style="width: 70px;">mg/m2</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">QCS Basis wt target</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="qcsBasisWtTarget" tabindex="8"> </td>
			<td>#</td>
			<td>Yankee Adesive</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="yankeeAdesive" tabindex="13"> </td>
			<td>mg/m2</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Reel Moisture</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="reelMoisture" tabindex="9"> </td>
			<td>%</td>
			<td>Jet Wire Ratio</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="jetWireRatio" tabindex="14"> </td>
			<td></td>
		</tr>
		
		<tr>
			
			<td colspan="2">Crepe</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="crepe" tabindex="10"> </td>
			<td>%</td>
			<td>Fan Pump flow rate</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="fanPumpFlowRate" tabindex="15"> </td>
			<td>gpm</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Yankee Steam </td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="yankeeSteam" tabindex="11"> </td>
			<td>psi</td>
			<td>After Dryer Draw</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="afterDryerDraw" tabindex="15"> </td>
			<td>fpm</td>
		</tr>
		
		<tr>
			<td colspan="9" style="text-align: left;">
				Revision History (date, parameter, explanation): 
			</td>
		</tr>
		<tr style="height: 100px;">
			<td colspan="9">
				<textarea name="noteSecA" style="width: 798px; height: 100px;" tabindex="16"></textarea>
			</td>
		</tr>
		<tr style="background-color: #FDC893;">
			<td colspan="9" style="text-align: left;">SECTION B: PROCESS PARAMETERS</td>
		</tr>
		<tr>
			
			<td colspan="2">After Dryer Steam</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="afterDryerSteam" tabindex="17"> </td>
			<td>psi</td>
			<td>Fan Pump speed</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="fanPumpSpeed" tabindex="37"> </td>
			<td>rpm</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">SPR loading Front/Back</td>
			<td class="vcolor"></td>
			<td><input  class="string1" type="text" name="sprLoading" tabindex="18"> </td>
			<td >psi</td>
			<td>Total head</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="totalHead" tabindex="38"> </td>
			<td></td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Felt Passivator</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="feltPassivator" tabindex="19"> </td>
			<td>ml/min</td>
			<td>Headbox level</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="headboxLevel" tabindex="39"> </td>
			<td></td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Sprayboom Pressure</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="sprayboomPressure" tabindex="20"> </td>
			<td>psi</td>
			<td>Horizontal slice local</td>
			<td class="vcolor"></td>
			<td><input  class="string2" type="text" name="horizontalSlice" tabindex="40"> </td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Sprayboom Temperature</td>
			<td class="vcolor"></td>
			<td><input class="number" type="text" name="sprayboomTemparature" tabindex="21"> </td>
			<td><sup>O</sup>F</td>
			<td>Horizontal slice dcs</td>
			<td class="vcolor"></td>
			<td><input  class="string2" type="text" name="horizontalSliceDcs" tabindex="40"> </td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">WE Fan Speed</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="wefanSpeed" tabindex="22"> </td>
			<td>rpm</td>
			<td>Vertical Slice local</td>
			<td class="vcolor"></td>
			<td><input  class="string2" type="text" name="verticalSlice" tabindex="41"> </td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">DE Fan Speed</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="defanSpeed" tabindex="23"> </td>
			<td>rpm</td>
			<td>Vertical Slice dcs</td>
			<td class="vcolor"></td>
			<td><input  class="string2" type="text" name="verticalSliceDcs" tabindex="41"> </td>
			<td>in</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Make-up air damper</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="makeUpAirDamper" tabindex="24"> </td>
			<td>%</td>
			<td>Selectifier reject flow 1</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="selectifierRejectFlow1" tabindex="42"> </td>
			<td>gpm</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Exhaust damper</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="exhaustDamper" tabindex="25"> </td>
			<td>%</td>
			<td>Selectifier reject flow 2</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="selectifierRejectFlow2" tabindex="43"> </td>
			<td>gpm</td>
		</tr>
		
		<tr>
			
			<td colspan="2">Exhaust Fan speed</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="exhaustFanSpeed" tabindex="26"> </td>
			<td>rpm</td>
			<td>Sec screen Cycle</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="secScreenCycleTime" tabindex="44"> </td>
			<td>min</td>
		</tr>
		
		<tr>
			
			<td colspan="2">WE Hood Temperature</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="wehoodTemperature" tabindex="27"> </td>
			<td><sup>0</sup>F</td>
			<td>Low Density Cycle</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="lowDensityCycleTime" tabindex="45"> </td>
			<td>min</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">DE Hood Temperature</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="dehoodTemperature" tabindex="28"> </td>
			<td><sup>0</sup>F</td>
			<td>Refiners Energy</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="refinersEnergy" tabindex="46"> </td>
			<td>kW</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Yankee  &Delta; P</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="yankeeAP" tabindex="29"> </td>
			<td>psi</td>
			<td>Number of Refiners</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="numberOfRefiners" tabindex="47"> </td>
			<td>Nos.</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">After Dryer &Delta; P</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="afterDryerAP" tabindex="30"> </td>
			<td>psi</td>
			<td>Refiner Inlet Cy</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="refinerInletConsistency" tabindex="48"> </td>
			<td>%</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Sec Arm Loading</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="secArmLoading" tabindex="31"> </td>
			<td>pli</td>
			<td>Machine Chest Cy</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="machineChestConsistency" tabindex="49"> </td>
			<td>%</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Reel offset</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="reelOffset" tabindex="32"> </td>
			<td>pli</td>
			<td>Stock flow</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="stockFlow" tabindex="50"> </td>
			<td>gpm</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Uhle Box North Valve  </td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="uhleBoxNorthValve" tabindex="33"> </td>
			<td>%</td>
			<td>Sweetner Flow</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="sweetnerFlow" tabindex="51"> </td>
			<td>gpm</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Uhle box South Valve</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="uhleBoxSouthValve" tabindex="34"> </td>
			<td>%</td>
			<td>Broke </td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="broke" tabindex="52"> </td>
			<td>%</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">Flatbox 1 Valve # 6773</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="faltBox1VacuumValve" tabindex="35"> </td>
			<td>%</td>
			<td>Wet strength</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="wetStrength" tabindex="53"> </td>
			<td>gpm</td>
		</tr>
		<tr>
			<td colspan="2">Flatbox 2 Valve # 6771</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="faltBox2VacuumValve" tabindex="36"> </td>
			<td>%</td>
			<td colspan="5"></td>
		</tr>
		<tr>
			<td colspan="2">Flatbox 4 Valve # 6770</td>
			<td class="vcolor"></td>
			<td><input  class="number" type="text" name="faltBox4VacuumValve" tabindex="36"> </td>
			<td>%</td>
			<td colspan="5"></td>
		</tr>
		
		<tr>
			<td colspan="9" style="text-align: left;">
				Revision History (date, parameter, explanation): 
			</td>
		</tr>
		<tr style="height: 100px;">
			<td colspan="9">
				<textarea name="noteSecB" style="width: 798px; height: 100px;" tabindex="64"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="9"> <input type="hidden" name="id" > </td>
		</tr>
		</tbody>
	</table>

</div>

</div>
			</div>



<div class="lefttwindow" id="leftWindow">
<div class="title">Grade</div>	
		<table id="currentTable" style="width: 100%;font-size: 12px;text-align: center;" class="table" >
			
		</table>	
	
</div>



</body>
</html>
