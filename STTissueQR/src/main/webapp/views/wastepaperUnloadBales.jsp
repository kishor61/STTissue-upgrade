<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/baleinventoryunload/unloadbales/load" var="viewdataURL" />
<spring:url value="/baleinventoryunload/export" var="unlodBalesExportURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=startdate],input[name=enddate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>
<!-- Below Script Is Written By Roshan Tailor -->
<script type="text/javascript">
function ButtonClicked()
{
   document.getElementById("viewbutton").style.display = ""; // to undisplay
   document.getElementById("buttonreplacement").style.display = ""; // to display
   return true;
}
var FirstLoading = true;
function RestoreSubmitButton()
{
   if( FirstLoading )
   {
      FirstLoading = false;
      return;
   }
   document.getElementById("viewbutton").style.display = ""; // to display
   document.getElementById("buttonreplacement").style.display = "none"; // to undisplay
}
// To disable restoring submit button, disable or delete next line.
document.onfocus = RestoreSubmitButton;
</script>
<!-- Script Ends Here Done By Roshan Tailor And Copy Write Too -->
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
				<!--<span class="label">Waste Paper Unload Bales</span> -->
				<span class="label">Barcode Unload Bales - Gradewise</span>
				</div>
				<div class="table-selector" style="width: 2431px;">
					<table>
						<tr>
							<form action="${viewdataURL}" method="get">
							<td>Start Date</td>
							<td><input readonly="readonly" type="text" name="startdate" value="${startdate}" style="width: 80px;"></td>
							<td></td>
							<td>End Date</td>
							<td><input readonly="readonly" type="text" name="enddate" value="${enddate}"  style="width: 80px;"></td>
							<td><input type="submit" id="viewbutton" name="viewbutton" value="View" onclick="ButtonClicked();"></td>
							</form>
							<c:if test="${viewpage}">
								<form action="${unlodBalesExportURL}" method="POST">
										<td><input type="hidden" name="startdate" value="${startdate}" ></td>
										<td><input type="hidden" name="enddate" value="${enddate}"></td>
										<td><button id="exportbutton">Export</button></td>
								</form>
							</c:if>
						</tr>
					</table>
				</div>
				<%-- <c:if test="${fn:length(unloadbalesdata) eq 0 }">
							<tr>
								<td><b style="color: Green;">Select Date To See Data..</b></td>
							</tr>
				</c:if> --%>
<div id="buttonreplacement" style="margin-left:30px; display:none; position: absolute;!important">
		<img style="height: 105px; border: none;width: 137px;margin: 100px 0px 0px 500px;" alt="Transfering Data..." src='<spring:url value="/resources/images/gears.gif"/>'> 
</div>
<c:if test="${fn:length(unloadbalesdata) > 0 }">				
	<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 80px;">Date</td>
			<!--1 -->
			<td style="width: 80px;">MWL</td>
			<td style="width: 80px;">MWL Wt.</td>
			<!--2 -->
			<td style="width: 80px;">Prt mix</td>
			<td style="width: 80px;">Prt mix Wt.</td>
			<!--3 -->																			
			
			<td style="width: 80px;">MCL</td>
			<td style="width: 80px;">MCL Wt.</td>
			<!--4 -->
			
			<td style="width: 80px;">MWL W/IGS</td>
			<td style="width: 80px;">MWL W/IGS Wt.</td>
			<!--5 -->
			
			<td style="width: 80px;">CBS</td>
			<td style="width: 80px;">CBS Wt.</td>
			<!--6 -->
			
			<td style="width: 80px;">Ctd Gdwd</td>
			<td style="width: 80px;">Ctd Gdwd Wt.</td>
			<!--7 -->
			
			<td style="width: 80px;">SWL</td>
			<td style="width: 80px;">SWL WT.</td>
			<!--8 -->
			
			<td style="width: 80px;">ONP</td>
			<td style="width: 80px;">ONP Wt.</td>
			<!--9 -->
			
			<td style="width: 80px;">OI News</td>
			<td style="width: 80px;">OI News Wt.</td>
			<!--10 -->
			
			<td style="width: 80px;">Light Prt SBS</td>
			<td style="width: 80px;">Light Prt SBS Wt.</td>
			<!--11 -->
			
			<td style="width: 80px;">HW</td>
			<td style="width: 80px;">HW Wt.</td>
			<!--12 -->
			
			<td style="width: 80px;">Heavy Prt SBS</td>
			<td style="width: 80px;">Heavy Prt SBS Wt.</td>
			<!--13 -->
			
			<td style="width: 80px;">SOW</td>
			<td style="width: 80px;">SOW Wt.</td>
			<!--14 -->
			
			<td style="width: 80px;">Unprt SBS</td>
			<td style="width: 80px;">Unprt SBS Wt.</td>
			<!--15 -->
			
			<td style="width: 80px;">Newsblank</td>
			<td style="width: 80px;">Newsblank Wt.</td>
			<!--16 -->
			
			<td style="width: 80px;">White Gdwd Blend</td>
			<td style="width: 80px;">White Gdwd Blend Wt.</td>
			<!--17-->
			
			<td style="width: 80px;">Mail-Undeliverable</td>
			<td style="width: 80px;">Mail-Undeliverable Wt.</td>
			<!--18-->
			
			<td style="width: 80px;">Hogged Books</td>
			<td style="width: 80px;">Hogged Books Wt.</td>
			<!--19-->
			
			<td style="width: 80px;">OCC</td>
			<td style="width: 80px;">OCC Weight</td>
			<!--20-->
			
			<td style="width: 80px;">DLK</td>
			<td style="width: 80px;">DLK Weight</td>
			<!--21-->
			
			<td style="width: 80px;">Mixed Paper</td>
			<td style="width: 80px;">Mixed Paper Weight</td>
			<!--22 -->
			
			<td style="width: 80px;">Soft Wood Chips</td>
			<td style="width: 80px;">Soft Wood Chips Weight</td>
			<!--23 -->
			
			<td style="width: 80px;">Hard Wood Chips</td>
			<td style="width: 80px;">Hard Wood Chips Weight</td>
			<!--24 -->
			
			<td style="width: 80px;">PWE</td>
			<td style="width: 80px;">PWE Weight</td>
			<!--25 -->
			
			<td style="width: 80px;">White Broke</td>
			<td style="width: 80px;">White Broke Weight</td>
			<!--26 -->
			
			<td style="width: 80px;">Brown Napkin  Broke</td>
			<td style="width: 80px;">Brown Napkin Broke WT.</td>
			<!--27 -->
			
			<td style="width: 80px;">PULP Wet Lap</td>
			<td style="width: 80px;">PULP Wet Lap WT.</td>
			<!--28 -->
			
			<td style="width: 80px;">Virgin Pulp</td>
			<td style="width: 80px;">Virgin Pulp WT.</td>
			<!--29 -->
			
			<td style="width: 80px;">Brown Wet Lap</td>
			<td style="width: 80px;">Brown Wet Lap WT.</td>
			<!--30 -->
			
			<td style="width: 80px;">Pulp Dry Lap</td>
			<td style="width: 80px;">Pulp Dry Lap WT.</td>
			<!--31 -->
			
			<td style="width: 80px;">Other-Rolls</td>
			<td style="width: 80px;">Other-Rolls WT.</td>
			<!--32 -->
			
			<td style="width: 80px;">ST Bales wetlap</td>
			<td style="width: 80px;">ST Bales wetlap WT.</td>
			<!--33 -->
			
			<td style="width: 80px;">STT Baled Broke-Butl</td>
			<td style="width: 80px;">STT Baled Broke-Butl WT.</td>
			<!-- 34 -->
			
			<!--New Grade Coded Added Starts From Here  14-11-2017 -->
			
			<!-- 35 -->
			<td style="width: 80px;">Virgin Hard Wood</td>
			<td style="width: 80px;">Virgin Hard Wood WT.</td>
			<!-- 36 -->
			<td style="width: 80px;">Virgin Soft Wood</td>
			<td style="width: 80px;">Virgin Soft Wood WT.</td>
			
			<td style="width: 80px;">Total Bales</td>
			<td style="width: 80px;">Total Weight</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${unloadbalesdata}" var="ubd">
			<tr>
				<td><fmt:formatDate value="${ubd.date}" pattern="MM/dd/yyyy"/></td>
				
				<!-- 1 -->
				<td>${ubd.totalbalesOfMWL}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForMWL}" maxFractionDigits="2"/></td>
				
				<!-- 2 -->
				<td>${ubd.totalbalesOfPrtmix}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForPrtmix}" maxFractionDigits="2"/></td>
				
				<!-- 3 -->
				<td>${ubd.totalbalesOfMCL}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForMCL}" maxFractionDigits="2"/></td>
				
				<!-- 4 -->
				<td>${ubd.totalbalesOfMWLWorIGS}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForMWLWorIGS}" maxFractionDigits="2"/></td>
				
				<!-- 5 -->
				<td>${ubd.totalbalesOfCBS}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForCBS}" maxFractionDigits="2"/></td>
				
				<!-- 6 -->
				<td>${ubd.totalbalesOfCtdGdwd}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForCtdGdwd}" maxFractionDigits="2"/></td>
				
				<!-- 7 -->
				<td>${ubd.totalbalesOfSWL}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForSWL}" maxFractionDigits="2"/></td>
				
				<!-- 8 -->
				<td>${ubd.totalbalesOfONPOldNewsPrint}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForONPOldNewsPrint}" maxFractionDigits="2"/></td>
				
				<!-- 9 -->
				<td>${ubd.totalbalesOfOINews}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForOINews}" maxFractionDigits="2"/></td>
				
				<!-- 10 -->
				<td>${ubd.totalbalesOfLightPrtSBS}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForLightPrtSBS}" maxFractionDigits="2"/></td>
				
				<!-- 11 -->
				<td>${ubd.totalbalesOfHW}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForHW}" maxFractionDigits="2"/></td>
				
				<!-- 12 -->
				<td>${ubd.totalbalesOfHeavyPrtSBS}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForHeavyPrtSBS}" maxFractionDigits="2"/></td>
				
				<!-- 13 -->
				<td>${ubd.totalbalesOfSOW}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForSOW}" maxFractionDigits="2"/></td>
				
				<!-- 14 -->
				<td>${ubd.totalbalesOfUnprtSBS}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForUnprtSBS}" maxFractionDigits="2"/></td>
				
				<!-- 15 -->
				<td>${ubd.totalbalesOfNewsblank}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForNewsblank}" maxFractionDigits="2"/></td>
				
				<!-- 16 -->
				<td>${ubd.totalbalesOfWhiteGdwdBlend}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForWhiteGdwdBlend}" maxFractionDigits="2"/></td>
				
				<!-- 17 -->
				<td>${ubd.totalbalesOfMailUndeliverable}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForMailUndeliverable}" maxFractionDigits="2"/></td>
				
				<!-- 18 -->
				<td>${ubd.totalbalesOfHoggedBooks}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForHoggedBooks}" maxFractionDigits="2"/></td>
				
				<!--19  -->
				<td>${ubd.totalbalesOfOCC}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForOCC}" maxFractionDigits="2"/></td>
				
				<!-- 20 -->
				<td>${ubd.totalbalesOfDLK}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForDLK}" maxFractionDigits="2"/></td>
				
				<!-- 21 -->
				<td>${ubd.totalbalesOfMixedPaper}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForMixedPaper}" maxFractionDigits="2"/></td>
				
				<!-- 22 -->
				<td>${ubd.totalbalesOfSoftWoodChips}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForSoftWoodChips}" maxFractionDigits="2"/></td>
				
				<!-- 23 -->
				<td>${ubd.totalbalesOfHardWoodChips}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForHardWoodChips}" maxFractionDigits="2"/></td>
				
				<!-- 24 -->
				<td>${ubd.totalbalesOfPWE}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForPWE}" maxFractionDigits="2"/></td>
				
				<!-- 25 -->
				<td>${ubd.totalbalesOfWhiteBroke}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForWhiteBroke}" maxFractionDigits="2"/></td>
				
				<!-- 26 -->
				<td>${ubd.totalbalesOfBrownNapkinBroke}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForBrownNapkinBroke}" maxFractionDigits="2"/></td>
				
				<!-- 27 -->
				<td>${ubd.totalbalesOfPULPWetLap}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForPULPWetLap}" maxFractionDigits="2"/></td>
				
				<!-- 28 -->
				<td>${ubd.totalbalesOfVirginPulp}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForVirginPulp}" maxFractionDigits="2"/></td>
				
				<!-- 29 -->
				<td>${ubd.totalbalesOfBrownWetLap}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForBrownWetLap}" maxFractionDigits="2"/></td>
				
				<!-- 30 -->
				<td>${ubd.totalbalesOfPulpDryLap}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForPulpDryLap}" maxFractionDigits="2"/></td>
				
				<!-- 31 -->
				<td>${ubd.totalbalesOfOtherRolls}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForOtherRolls}" maxFractionDigits="2"/></td>
				
				<!-- 32 -->
				<td>${ubd.totalbalesOfSTBaleswetlap}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForSTBaleswetlap}" maxFractionDigits="2"/></td>
				
				<!-- 33 -->
				<td>${ubd.totalbalesOfSTTBaledBroke}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForSTTBaledBroke}" maxFractionDigits="2"/></td>
				
				<!--New Grade Code Added Starts From Here 14-11-2017  -->
				
				<!-- 34 -->
				<td>${ubd.totalbalesOfVirginHardWood}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForVirginHardWood}" maxFractionDigits="2"/></td>
				
				<!-- 35 -->
				<td>${ubd.totalbalesOfVirginSoftWood}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweightForVirginSoftWood}" maxFractionDigits="2"/></td>
				
				
				<%-- <c:set value="${ubd.totalbalesOfMWL+ubd.totalbalesOfPrtmix+ubd.totalbalesOfMCL+ubd.totalbalesOfMWLWorIGS+ubd.totalbalesOfCBS+ubd.totalbalesOfCtdGdwd+ubd.totalbalesOfSWL+ubd.totalbalesOfONPOldNewsPrint+ubd.totalbalesOfOINews+ubd.totalbalesOfLightPrtSBS+ubd.totalbalesOfHW+ubd.totalbalesOfHeavyPrtSBS+ubd.totalbalesOfSOW+ubd.totalbalesOfUnprtSBS+ubd.totalbalesOfNewsblank+ubd.totalbalesOfWhiteGdwdBlend+ubd.totalbalesOfMailUndeliverable+ubd.totalbalesOfHoggedBooks+ubd.totalbalesOfOCC+ubd.totalbalesOfDLK+ubd.totalbalesOfMixedPaper+ubd.totalbalesOfSoftWoodChips+ubd.totalbalesOfHardWoodChips+ubd.totalbalesOfPWE+ubd.totalbalesOfWhiteBroke+ubd.totalbalesOfBrownNapkinBroke+ubd.totalbalesOfPULPWetLap+ubd.totalbalesOfVirginPulp+ubd.totalbalesOfBrownWetLap+ubd.totalbalesOfPulpDryLap+ubd.totalbalesOfOtherRolls+ubd.totalbalesOfSTBaleswetlap+ubd.totalbalesOfSTTBaledBroke}" var="totalBales"/>		
				<c:set value="${totalWeight+duplicatecountvalue.duplicategrosstons}" var="totalWeight"/> 
					 --%>
				<td>${ubd.totalbales}</td>
				<td><fmt:formatNumber value="${ubd.totalbalesweight}" var="totalbalesweight"/>${totalbalesweight}</td>
					<!--1  -->
					<c:set value="${totalbalesweightForMWL+ubd.totalbalesweightForMWL}" var="totalbalesweightForMWL"/>		
					<c:set value="${totalbalesOfMWL+ubd.totalbalesOfMWL}" var="totalbalesOfMWL"/>
					<!--2  -->
					<c:set value="${totalbalesweightForPrtmix+ubd.totalbalesweightForPrtmix}" var="totalbalesweightForPrtmix"/>
					<c:set value="${totalbalesOfPrtmix+ubd.totalbalesOfPrtmix}" var="totalbalesOfPrtmix"/>
					<!--3  -->
					<c:set value="${totalbalesweightForMCL+ubd.totalbalesweightForMCL}" var="totalbalesweightForMCL"/>
					<c:set value="${totalbalesOfMCL+ubd.totalbalesOfMCL}" var="totalbalesOfMCL"/>
					<!-- 4 -->
					<c:set value="${totalbalesweightForMWLWorIGS+ubd.totalbalesweightForMWLWorIGS}" var="totalbalesweightForMWLWorIGS"/>
					<c:set value="${totalbalesOfMWLWorIGS+ubd.totalbalesOfMWLWorIGS}" var="totalbalesOfMWLWorIGS"/>
					<!--  5-->
					<c:set value="${totalbalesweightForCBS+ubd.totalbalesweightForCBS}" var="totalbalesweightForCBS"/>
					<c:set value="${totalbalesOfCBS+ubd.totalbalesOfCBS}" var="totalbalesOfCBS"/>
					<!--6  -->
					<c:set value="${totalbalesweightForCtdGdwd+ubd.totalbalesweightForCtdGdwd}" var="totalbalesweightForCtdGdwd"/>
					<c:set value="${totalbalesOfCtdGdwd+ubd.totalbalesOfCtdGdwd}" var="totalbalesOfCtdGdwd"/>
					<!-- 7 -->
					<c:set value="${totalbalesweightForSWL+ubd.totalbalesweightForSWL}" var="totalbalesweightForSWL"/>
					<c:set value="${totalbalesOfSWL+ubd.totalbalesOfSWL}" var="totalbalesOfSWL"/>
					<!-- 8 -->
					<c:set value="${totalbalesweightForONPOldNewsPrint+ubd.totalbalesweightForONPOldNewsPrint}" var="totalbalesweightForONPOldNewsPrint"/>
					<c:set value="${totalbalesOfONPOldNewsPrint+ubd.totalbalesOfONPOldNewsPrint}" var="totalbalesOfONPOldNewsPrint"/>
					<!-- 9 -->
					<c:set value="${totalbalesweightForOINews+ubd.totalbalesweightForOINews}" var="totalbalesweightForOINews"/>
					<c:set value="${totalbalesOfOINews+ubd.totalbalesOfOINews}" var="totalbalesOfOINews"/>
					<!--10  -->
					<c:set value="${totalbalesweightForLightPrtSBS+ubd.totalbalesweightForLightPrtSBS}" var="totalbalesweightForLightPrtSBS"/>
					<c:set value="${totalbalesOfLightPrtSBS+ubd.totalbalesOfLightPrtSBS}" var="totalbalesOfLightPrtSBS"/>
					<!-- 11 -->
					<c:set value="${totalbalesweightForHW+ubd.totalbalesweightForHW}" var="totalbalesweightForHW"/>
					<c:set value="${totalbalesOfHW+ubd.totalbalesOfHW}" var="totalbalesOfHW"/>
					<!--12  -->
					<c:set value="${totalbalesweightForHeavyPrtSBS+ubd.totalbalesweightForHeavyPrtSBS}" var="totalbalesweightForHeavyPrtSBS"/>
					<c:set value="${totalbalesOfHeavyPrtSBS+ubd.totalbalesOfHeavyPrtSBS}" var="totalbalesOfHeavyPrtSBS"/>
					<!-- 13 -->
					<c:set value="${totalbalesweightForSOW+ubd.totalbalesweightForSOW}" var="totalbalesweightForSOW"/>
					<c:set value="${totalbalesOfSOW+ubd.totalbalesOfSOW}" var="totalbalesOfSOW"/>
					<!--14  -->
					<c:set value="${totalbalesweightForUnprtSBS+ubd.totalbalesweightForUnprtSBS}" var="totalbalesweightForUnprtSBS"/>
					<c:set value="${totalbalesOfUnprtSBS+ubd.totalbalesOfUnprtSBS}" var="totalbalesOfUnprtSBS"/>
					<!-- 15 -->
					<c:set value="${totalbalesweightForNewsblank+ubd.totalbalesweightForNewsblank}" var="totalbalesweightForNewsblank"/>
					<c:set value="${totalbalesOfNewsblank+ubd.totalbalesOfNewsblank}" var="totalbalesOfNewsblank"/>
					<!-- 16 -->
					<c:set value="${totalbalesweightForWhiteGdwdBlend+ubd.totalbalesweightForWhiteGdwdBlend}" var="totalbalesweightForWhiteGdwdBlend"/>
					<c:set value="${totalbalesOfWhiteGdwdBlend+ubd.totalbalesOfWhiteGdwdBlend}" var="totalbalesOfWhiteGdwdBlend"/>
					<!-- 17 -->
					<c:set value="${totalbalesweightForMailUndeliverable+ubd.totalbalesweightForMailUndeliverable}" var="totalbalesweightForMailUndeliverable"/>
					<c:set value="${totalbalesOfMailUndeliverable+ubd.totalbalesOfMailUndeliverable}" var="totalbalesOfMailUndeliverable"/>
					<!--18  -->
					<c:set value="${totalbalesweightForHoggedBooks+ubd.totalbalesweightForHoggedBooks}" var="totalbalesweightForHoggedBooks"/>
					<c:set value="${totalbalesOfHoggedBooks+ubd.totalbalesOfHoggedBooks}" var="totalbalesOfHoggedBooks"/>
					<!-- 19 -->
					<c:set value="${totalbalesweightForOCC+ubd.totalbalesweightForOCC}" var="totalbalesweightForOCC"/>
					<c:set value="${totalbalesOfOCC+ubd.totalbalesOfOCC}" var="totalbalesOfOCC"/>
					<!-- 20 -->
					<c:set value="${totalbalesweightForDLK+ubd.totalbalesweightForDLK}" var="totalbalesweightForDLK"/>
					<c:set value="${totalbalesOfDLK+ubd.totalbalesOfDLK}" var="totalbalesOfDLK"/>
					<!-- 21 -->
					<c:set value="${totalbalesweightForMixedPaper+ubd.totalbalesweightForMixedPaper}" var="totalbalesweightForMixedPaper"/>
					<c:set value="${totalbalesOfMixedPaper+ubd.totalbalesOfMixedPaper}" var="totalbalesOfMixedPaper"/>
					<!-- 22 -->
					<c:set value="${totalbalesweightForSoftWoodChips+ubd.totalbalesweightForSoftWoodChips}" var="totalbalesweightForSoftWoodChips"/>
					<c:set value="${totalbalesOfSoftWoodChips+ubd.totalbalesOfSoftWoodChips}" var="totalbalesOfSoftWoodChips"/>
					<!-- 22 -->
					<c:set value="${totalbalesweightForHardWoodChips+ubd.totalbalesweightForHardWoodChips}" var="totalbalesweightForHardWoodChips"/>
					<c:set value="${totalbalesOfHardWoodChips+ubd.totalbalesOfHardWoodChips}" var="totalbalesOfHardWoodChips"/>
					<!-- 23 -->
					<c:set value="${totalbalesweightForPWE+ubd.totalbalesweightForPWE}" var="totalbalesweightForPWE"/>
					<c:set value="${totalbalesOfPWE+ubd.totalbalesOfPWE}" var="totalbalesOfPWE"/>
					<!-- 24 -->
					<c:set value="${totalbalesweightForWhiteBroke+ubd.totalbalesweightForWhiteBroke }" var="totalbalesweightForWhiteBroke"/>
					<c:set value="${totalbalesOfWhiteBroke+ubd.totalbalesOfWhiteBroke}" var="totalbalesOfWhiteBroke"/>
					<!-- 25 -->
					<c:set value="${totalbalesweightForBrownNapkinBroke+ubd.totalbalesweightForBrownNapkinBroke}" var="totalbalesweightForBrownNapkinBroke"/>
					<c:set value="${totalbalesOfBrownNapkinBroke+ubd.totalbalesOfBrownNapkinBroke}" var="totalbalesOfBrownNapkinBroke"/>
					<!-- 26 -->
					<c:set value="${totalbalesweightForPULPWetLap+ubd.totalbalesweightForPULPWetLap}" var="totalbalesweightForPULPWetLap"/>
					<c:set value="${totalbalesOfPULPWetLap+ubd.totalbalesOfPULPWetLap}" var="totalbalesOfPULPWetLap"/>
					<!-- 27 -->
					<c:set value="${totalbalesweightForVirginPulp+ubd.totalbalesweightForVirginPulp}" var="totalbalesweightForVirginPulp"/>
					<c:set value="${totalbalesOfVirginPulp+ubd.totalbalesOfVirginPulp}" var="totalbalesOfVirginPulp"/>
					<!-- 28 -->
					<c:set value="${totalbalesweightForBrownWetLap+ubd.totalbalesweightForBrownWetLap}" var="totalbalesweightForBrownWetLap"/>
					<c:set value="${totalbalesOfBrownWetLap+ubd.totalbalesOfBrownWetLap}" var="totalbalesOfBrownWetLap"/>
					<!-- 29 -->
					<c:set value="${totalbalesweightForPulpDryLap+ubd.totalbalesweightForPulpDryLap}" var="totalbalesweightForPulpDryLap"/>
					<c:set value="${totalbalesOfPulpDryLap+ubd.totalbalesOfPulpDryLap}" var="totalbalesOfPulpDryLap"/>
					<!-- 30 -->
					<c:set value="${totalbalesweightForOtherRolls+ubd.totalbalesweightForOtherRolls}" var="totalbalesweightForOtherRolls"/>
					<c:set value="${totalbalesOfOtherRolls+ubd.totalbalesOfOtherRolls}" var="totalbalesOfOtherRolls"/>
					<!-- 31 -->
					<c:set value="${totalbalesweightForSTBaleswetlap+ubd.totalbalesweightForSTBaleswetlap}" var="totalbalesweightForSTBaleswetlap"/>
					<c:set value="${totalbalesOfSTBaleswetlap+ubd.totalbalesOfSTBaleswetlap}" var="totalbalesOfSTBaleswetlap"/>
					<!-- 32 -->
					<c:set value="${totalbalesweightForSTTBaledBroke+ubd.totalbalesweightForSTTBaledBroke}" var="totalbalesweightForSTTBaledBroke"/>
					<c:set value="${totalbalesOfSTTBaledBroke+ubd.totalbalesOfSTTBaledBroke}" var="totalbalesOfSTTBaledBroke"/>
					
					<!--New Grade Code Added From Here 14-11-2017  -->
					<c:set value="${totalbalesweightForVirginHardWood+ubd.totalbalesweightForVirginHardWood}" var="totalbalesweightForVirginHardWood"/>
					<c:set value="${totalbalesOfVirginHardWood+ubd.totalbalesOfVirginHardWood}" var="totalbalesOfVirginHardWood"/>
					
					<c:set value="${totalbalesweightForVirginSoftWood+ubd.totalbalesweightForVirginSoftWood}" var="totalbalesweightForVirginSoftWood"/>
					<c:set value="${totalbalesOfVirginSoftWood+ubd.totalbalesOfVirginSoftWood}" var="totalbalesOfVirginSoftWood"/>
					
					<!-- 33 -->
					<c:set value="${finaltotalbales+ubd.totalbales}" var="finaltotalbales"/>
					<c:set value="${finaltotalbalesweight+ubd.totalbalesweight}" var="finaltotalbalesweight"/>
									
			</tr>
		</c:forEach>
		<tr style="background-color: yellow;">
				<td><b>Total:</b></td>
				
				<!--1  -->
				<td><b>${totalbalesOfMWL}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForMWL}" var="totalbalesweightForMWL"/>${totalbalesweightForMWL}</b></td>
				
				<!--2  -->
				<td><b>${totalbalesOfPrtmix}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForPrtmix}" var="totalbalesweightForPrtmix"/>${totalbalesweightForPrtmix}</b></td>
				
				<!--3  -->
				<td><b>${ totalbalesOfMCL}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForMCL}" var="totalbalesweightForMCL"/>${ totalbalesweightForMCL}</b></td>
				
				<!--4  -->
				<td><b>${totalbalesOfMWLWorIGS }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForMWLWorIGS}" var="totalbalesweightForMWLWorIGS"/>${ totalbalesweightForMWLWorIGS}</b></td>
				
				<!--5  -->
				<td><b>${totalbalesOfCBS }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForCBS}" var="totalbalesweightForCBS"/>${totalbalesweightForCBS }</b></td>
				
				<!--6  -->
				<td><b>${totalbalesOfCtdGdwd }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForCtdGdwd}" var="totalbalesweightForCtdGdwd"/>${totalbalesweightForCtdGdwd }</b></td>
				
				<!--7  -->
				<td><b>${totalbalesOfSWL }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForSWL}" var="totalbalesweightForSWL"/>${totalbalesweightForSWL }</b></td>
				
				<!--8  -->
				<td><b>${totalbalesOfONPOldNewsPrint }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForONPOldNewsPrint}" var="totalbalesweightForONPOldNewsPrint"/>${totalbalesweightForONPOldNewsPrint }</b></td>
				
				<!--9  -->
				<td><b>${totalbalesOfOINews }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForOINews}" var="totalbalesweightForOINews"/>${totalbalesweightForOINews }</b></td>
				
				<!--10  -->
				<td><b>${totalbalesOfLightPrtSBS }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForLightPrtSBS}" var="totalbalesweightForLightPrtSBS"/>${totalbalesweightForLightPrtSBS }</b></td>
				
				<!--11  -->
				<td><b>${totalbalesOfHW }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForHW}" var="totalbalesweightForHW"/>${totalbalesweightForHW }</b></td>
				
				<!--12  -->
				<td><b>${totalbalesOfHeavyPrtSBS }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForHeavyPrtSBS}" var="totalbalesweightForHeavyPrtSBS"/>${totalbalesweightForHeavyPrtSBS }</b></td>
				
				<!--13  -->
				<td><b>${totalbalesOfSOW }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForSOW}" var="totalbalesweightForSOW"/>${totalbalesweightForSOW }</b></td>
				
				<!--14  -->
				<td><b>${totalbalesOfUnprtSBS }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForUnprtSBS}" var="totalbalesweightForUnprtSBS"/>${totalbalesweightForUnprtSBS }</b></td>
				
				<!--15  -->
				<td><b>${totalbalesOfNewsblank }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForNewsblank}" var="totalbalesweightForNewsblank"/>${totalbalesweightForNewsblank }</b></td>
				
				<!--16  -->
				<td><b>${totalbalesOfWhiteGdwdBlend }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForWhiteGdwdBlend}" var="totalbalesweightForWhiteGdwdBlend"/>${totalbalesweightForWhiteGdwdBlend }</b></td>
				
				<!--17  -->
				<td><b>${totalbalesOfMailUndeliverable }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForMailUndeliverable}" var="totalbalesweightForMailUndeliverable"/>${totalbalesweightForMailUndeliverable }</b></td>
				
				<!--18  -->
				<td><b>${totalbalesOfHoggedBooks }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForHoggedBooks}" var="totalbalesweightForHoggedBooks"/>${totalbalesweightForHoggedBooks }</b></td>
				
				<!--19  -->
				<td><b>${totalbalesOfOCC }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForOCC}" var="totalbalesweightForOCC"/>${totalbalesweightForOCC }</b></td>
				
				<!--20  -->
				<td><b>${ totalbalesOfDLK}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForDLK}" var="totalbalesweightForDLK"/>${totalbalesweightForDLK }</b></td>
				
				<!--21  -->
				<td><b>${ totalbalesOfMixedPaper}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForMixedPaper}" var="totalbalesweightForMixedPaper"/>${totalbalesweightForMixedPaper }</b></td>
				
				<!--22  -->
				<td><b>${ totalbalesOfSoftWoodChips}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForSoftWoodChips}" var="totalbalesweightForSoftWoodChips"/>${totalbalesweightForSoftWoodChips }</b></td>
				
				<!--23  -->
				<td><b>${totalbalesOfHardWoodChips }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForHardWoodChips}" var="totalbalesweightForHardWoodChips"/>${ totalbalesweightForHardWoodChips}</b></td>
				
				<!--24  -->
				<td><b>${totalbalesOfPWE }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForPWE}" var="totalbalesweightForPWE"/>${totalbalesweightForPWE }</b></td>
				
				<!--25  -->
				<td><b>${totalbalesOfWhiteBroke }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForWhiteBroke}" var="totalbalesweightForWhiteBroke"/>${totalbalesweightForWhiteBroke }</b></td>
				
				<!--26  -->
				<td><b>${totalbalesOfBrownNapkinBroke }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForBrownNapkinBroke}" var="totalbalesweightForBrownNapkinBroke"/>${totalbalesweightForBrownNapkinBroke }</b></td>
				
				<!--27  -->
				<td><b>${totalbalesOfPULPWetLap }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForPULPWetLap}" var="totalbalesweightForPULPWetLap"/>${totalbalesweightForPULPWetLap }</b></td>
				
				<!--28  -->
				<td><b>${totalbalesOfVirginPulp}</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForVirginPulp}" var="totalbalesweightForVirginPulp"/>${totalbalesweightForVirginPulp }</b></td>
				
				<!--29  -->
				<td><b>${totalbalesOfBrownWetLap }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForBrownWetLap}" var="totalbalesweightForBrownWetLap"/>${totalbalesweightForBrownWetLap }</b></td>
				
				<!--30  -->
				<td><b>${totalbalesOfPulpDryLap }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForPulpDryLap}" var="totalbalesweightForPulpDryLap"/>${totalbalesweightForPulpDryLap }</b></td>
				
				<!--31  -->
				<td><b>${totalbalesOfOtherRolls }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForOtherRolls}" var="totalbalesweightForOtherRolls"/>${totalbalesweightForOtherRolls }</b></td>
				
				<!--32  -->
				<td><b>${totalbalesOfSTBaleswetlap }</b></td>
				<td><b><fmt:formatNumber value="${totalbalesweightForSTBaleswetlap}" var="totalbalesweightForSTBaleswetlap"/>${totalbalesweightForSTBaleswetlap }</b></td>
				
				<!--33  -->
				<td><b>${totalbalesOfSTTBaledBroke }</b></td> 
				<td><b><fmt:formatNumber value="${totalbalesweightForSTTBaledBroke}" var="totalbalesweightForSTTBaledBroke"/>${totalbalesweightForSTTBaledBroke}</b></td>
				
				<!--New Grade Code Added From Here 14-11-2017  -->
				
				<td><b>${totalbalesOfVirginHardWood }</b></td> 
				<td><b><fmt:formatNumber value="${totalbalesweightForVirginHardWood}" var="totalbalesweightForVirginHardWood"/>${totalbalesweightForVirginHardWood}</b></td>
				
				<td><b>${totalbalesOfVirginSoftWood }</b></td> 
				<td><b><fmt:formatNumber value="${totalbalesweightForVirginSoftWood}" var="totalbalesweightForVirginSoftWood"/>${totalbalesweightForVirginSoftWood}</b></td>
				
				
				<!--34  -->
				<td><b>${finaltotalbales}</b></td>
				<td><b><fmt:formatNumber value="${finaltotalbalesweight}" var="finaltotalbalesweight" maxFractionDigits="2"/>${finaltotalbalesweight}</b></td>
		</tr>
	</tbody>
</table>
</c:if>
	</div>
		</div>
<!-- Another Code From Here Starts  -->
<!-- <div >
	<table>
	<thead>
		
	</thead>
	
</table>
</div> -->
<!-- Another Code Ends Here  -->

	</div>

</body>
</html>
