<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/baleinventoryreportdetail/detailreport/load" var="viewdataURL" />
<spring:url value="/baleinventoryreportdetail" var="barCodeOpeningMonth"/>
<spring:url value="/baleinventoryreportdetail/export" var="exportURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=startdate],input[name=enddate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>
<script>
$(function(){
	$('#openingbutton').click(function(){	
		var id=$('#wpbidr tbody input[name=startdate]').val();
		alert(id);
		location.href='${barCodeOpeningMonth}/barCodeOpeningMonthForm/'+encodeURIComponent(id);
	});
});
</script>
<script>
function blinker() {
	$('.blinking').fadeOut(500);
	$('.blinking').fadeIn(500);
}
setInterval(blinker, 1000);
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
				<!--<span class="label">Waste Paper Bale Inventory Report Detail</span> -->
				<span class="label">Barcode Inventory Report-Detail</span>
				</div>
				<div class="table-selector">
					<table id="wpbidr">
						<tr>
							<td>
								<form action="${viewdataURL}" method="get">
									<td>Start Date</td>
										<td><input readonly="readonly" type="text" name="startdate" value="${startdate}" style="width: 80px;"></td>
										<td></td>
									<td>End Date</td>
										<td><input readonly="readonly" type="text" name="enddate" value="${enddate}"  style="width: 80px;"></td>
										<td><input type="submit" id="viewbutton" name="viewbutton" value="View"  onclick="ButtonClicked();"></td>
								</form>
								<c:if test="${viewpage}">
									<form action="${exportURL}" method="POST">
											<td><input type="hidden" name="startdate" value="${startdate}" ></td>
											<td><input type="hidden" name="enddate" value="${enddate}"></td>
											<td><button id="exportbutton">Export</button></td>
									</form>
								</c:if>
							</td>
							<c:if test="${viewpage}">
							<td>	
								<input type="button" id="openingbutton" value="Enter Opening Month">
							</td>	
							</c:if>
						</tr>
					</table>
				</div>
				<c:if test="${fn:length(unloadbalesdata) eq 0 }">
							<tr>
								<td><b style="color: Green;">${enable}</b></td>
							</tr>
				</c:if>
				<c:if test="${fn:length(unloadbalesdata) > 0 }">
				
				</c:if>
<div id="buttonreplacement" style="margin-left:30px; display:none; position: absolute;!important">
		<img style="height: 105px; border: none;width: 137px;margin: 100px 0px 0px 500px;" alt="Transfering Data..." src='<spring:url value="/resources/images/gears.gif"/>'> 
</div>
<c:if test="${viewpage}">	
<table id="barcodedatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 80px;">Title</td>
			<!--1 -->
			<td style="width: 80px;">MWL</td>
			<!--2 -->
			<td style="width: 80px;">Prt mix</td>
			<!--3 -->																			
			<td style="width: 80px;">MCL</td>
			<!--4 -->
			<td style="width: 80px;">MWL W/IGS</td>
			<!--5 -->
			<td style="width: 80px;">CBS</td>
			<!--6 -->
			<td style="width: 80px;">Ctd Gdwd</td>
			<!--7 -->
			<td style="width: 80px;">SWL</td>
			<!--8 -->
			<td style="width: 80px;">ONP</td>
			<!--9 -->
			<td style="width: 80px;">OI News</td>
			<!--10 -->
			<td style="width: 80px;">Light Prt SBS</td>
			<!--11 -->
			<td style="width: 80px;">HW</td>
			<!--12 -->
			<td style="width: 80px;">Heavy Prt SBS</td>
			<!--13 -->
			<td style="width: 80px;">SOW</td>
			<!--14 -->
			<td style="width: 80px;">Unprt SBS</td>
			<!--15 -->
			<td style="width: 80px;">Newsblank</td>
			<!--16 -->
			<td style="width: 80px;">White Gdwd Blend</td>
			<!--17-->
			<td style="width: 80px;">Mail-Undeliverable</td>
			<!--18-->
			<td style="width: 80px;">Hogged Books</td>
			<!--19-->
			<td style="width: 80px;">OCC</td>
			<!--20-->
			<td style="width: 80px;">DLK</td>
			<!--21-->
			<td style="width: 80px;">Mixed Paper</td>
			<!--22 -->
			<td style="width: 80px;">Soft Wood Chips</td>
			<!--23 -->
			<td style="width: 80px;">Hard Wood Chips</td>
			<!--24 -->
			<td style="width: 80px;">PWE</td>
			<!--25 -->
			<td style="width: 80px;">White Broke</td>
			<!--26 -->
			<td style="width: 80px;">Brown Napkin  Broke</td>
			<!--27 -->
			<td style="width: 80px;">PULP Wet Lap</td>
			<!--28 -->
			<td style="width: 80px;">Virgin Pulp</td>
			<!--29 -->
			<td style="width: 80px;">Brown Wet Lap</td>
			<!--30 -->
			<td style="width: 80px;">Pulp Dry Lap</td>
			<!--31 -->
			<td style="width: 80px;">Other-Rolls</td>
			<!--32 -->
			<td style="width: 80px;">ST Bales wetlap</td>
			<!--33 -->
			<td style="width: 80px;">STT Baled Broke-Butl</td>
			<!--34 -->
			<td style="width: 80px;">Virgin Hard Wood</td>
			<!--35 -->
			<td style="width: 80px;">Virgin Soft Wood</td>
			<!-- 36 -->
			<td style="width: 80px;">Total Bales</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Month Opening</b></td>
			
			<td>${bc.mwl}</td>
			<td>${bc.prtmix}</td>
			<td>${bc.mcl}</td>
			<td>${bc.mwlwigs}</td>
			<td>${bc.cbs}</td>
			<td>${bc.ctdGdwd}</td>
			<td>${bc.swlsortedwhite}</td>
			<td>${bc.onpolnNewsprint}</td>
			<td>${bc.oinews}</td>
			<td>${bc.lightprtsbs}</td>
			<td>${bc.hw}</td>
			<td>${bc.lightprtsbs}</td>
			<td>${bc.sow}</td>
			<td>${bc.unprtsbs}</td>
			<td>${bc.newsblank}</td>
			<td>${bc.whitegdwdblend}</td>
			<td>${bc.mailundeliverable}</td>
			<td>${bc.hoggedbooks}</td>
			<td>${bc.occ}</td>
			<td>${bc.dlk}</td>
			<td>${bc.mixedpaper}</td>
			<td>${bc.softwoodchips}</td>
			<td>${bc.hardwoodchips}</td>
			<td>${bc.pwe}</td>
			<td>${bc.whitebroke}</td>
			<!-- 26 -->
			<td>${bc.brownnapkinbroke}</td>
			<td>${bc.pulpwetlap}</td>
			<td>${bc.virginpulp}</td>
			<td>${bc.brownwetLap}</td>
			<td>${bc.pulpdryLap}</td>
			<td>${bc.otherrolls}</td>
			<td>${bc.stbaleswetlap}</td>
			<td>${bc.sttbaledbrokebutl}</td>
			
			<td>${bc.virginhardwood}</td>
			<td>${bc.virginsoftwood}</td>
			
			<td>${bc.total}</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Unload</b></td>
			<td>${ulbs.totalbalesOfMWL}</td>
			<td>${ulbs.totalbalesOfPrtmix}</td>
			<td>${ulbs.totalbalesOfMCL}</td>
			<td>${ulbs.totalbalesOfMWLWorIGS}</td>
			<td>${ulbs.totalbalesOfCBS}</td>
			<td>${ulbs.totalbalesOfCtdGdwd}</td>
			<td>${ulbs.totalbalesOfSWL}</td>
			<td>${ulbs.totalbalesOfONPOldNewsPrint}</td>
			<td>${ulbs.totalbalesOfOINews}</td>
			<td>${ulbs.totalbalesOfLightPrtSBS}</td>
			<td>${ulbs.totalbalesOfHW}</td>
			<td>${ulbs.totalbalesOfHeavyPrtSBS}</td>
			<td>${ulbs.totalbalesOfSOW}</td>
			<td>${ulbs.totalbalesOfUnprtSBS}</td>
			<td>${ulbs.totalbalesOfNewsblank}</td>
			<td>${ulbs.totalbalesOfWhiteGdwdBlend}</td>
			<td>${ulbs.totalbalesOfMailUndeliverable}</td>
			<td>${ulbs.totalbalesOfHoggedBooks}</td>
			<td>${ulbs.totalbalesOfOCC}</td>
			<td>${ulbs.totalbalesOfDLK}</td>
			<td>${ulbs.totalbalesOfMixedPaper}</td>
			<td>${ulbs.totalbalesOfSoftWoodChips}</td>
			<td>${ulbs.totalbalesOfHardWoodChips}</td>
			<td>${ulbs.totalbalesOfPWE}</td>
			<td>${ulbs.totalbalesOfWhiteBroke}</td>
			<!--26 -->
			<td>${ulbs.totalbalesOfBrownNapkinBroke}</td>
			<td>${ulbs.totalbalesOfPULPWetLap}</td>
			<td>${ulbs.totalbalesOfVirginPulp}</td>
			<td>${ulbs.totalbalesOfBrownWetLap}</td>
			<td>${ulbs.totalbalesOfPulpDryLap}</td>
			<td>${ulbs.totalbalesOfOtherRolls}</td>
			<td>${ulbs.totalbalesOfSTBaleswetlap}</td>
			<td>${ulbs.totalbalesOfSTTBaledBroke}</td>
			
			<td>${ulbs.totalbalesOfVirginHardWood}</td>
			<td>${ulbs.totalbalesOfVirginSoftWood}</td>
			
			<td>${ulbs.totalUnloadBales}</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Consumed</b></td>
			<td>${cbs.totalbalesOfMWL}</td>
			<td>${cbs.totalbalesOfPrtmix}</td>
			<td>${cbs.totalbalesOfMCL}</td>
			<td>${cbs.totalbalesOfMWLWorIGS}</td>
			<td>${cbs.totalbalesOfCBS}</td>
			<td>${cbs.totalbalesOfCtdGdwd}</td>
			<td>${cbs.totalbalesOfSWL}</td>
			<td>${cbs.totalbalesOfONPOldNewsPrint}</td>
			<td>${cbs.totalbalesOfOINews}</td>
			<td>${cbs.totalbalesOfLightPrtSBS}</td>
			<td>${cbs.totalbalesOfHW}</td>
			<td>${cbs.totalbalesOfHeavyPrtSBS}</td>
			<td>${cbs.totalbalesOfSOW}</td>
			<td>${cbs.totalbalesOfUnprtSBS}</td>
			<td>${cbs.totalbalesOfNewsblank}</td>
			<td>${cbs.totalbalesOfWhiteGdwdBlend}</td>
			<td>${cbs.totalbalesOfMailUndeliverable}</td>
			<td>${cbs.totalbalesOfHoggedBooks}</td>
			<td>${cbs.totalbalesOfOCC}</td>
			<td>${cbs.totalbalesOfDLK}</td>
			<td>${cbs.totalbalesOfMixedPaper}</td>
			<td>${cbs.totalbalesOfSoftWoodChips}</td>
			<td>${cbs.totalbalesOfHardWoodChips}</td>
			<td>${cbs.totalbalesOfPWE}</td>
			<td>${cbs.totalbalesOfWhiteBroke}</td>
			<!--26 -->
			<td>${cbs.totalbalesOfBrownNapkinBroke}</td>
			<td>${cbs.totalbalesOfPULPWetLap}</td>
			<td>${cbs.totalbalesOfVirginPulp}</td>
			<td>${cbs.totalbalesOfBrownWetLap}</td>
			<td>${cbs.totalbalesOfPulpDryLap}</td>
			<td>${cbs.totalbalesOfOtherRolls}</td>
			<td>${cbs.totalbalesOfSTBaleswetlap}</td>
			<td>${cbs.totalbalesOfSTTBaledBroke}</td>
			
			
			<td>${cbs.totalbalesOfVirginHardWood}</td>
			<td>${cbs.totalbalesOfVirginSoftWood}</td>
			
			
			<td>${cbs.totalConsumedBales}</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Total</b></td>
			<td>${v1}</td>
			<td>${v2}</td>
			<td>${v3}</td>
			<td>${v4}</td>
			<td>${v5}</td>
			<td>${v6}</td>
			<td>${v7}</td>
			<td>${v8}</td>
			<td>${v9}</td>
			<td>${v10}</td>
			<td>${v11}</td>
			<td>${v12}</td>
			<td>${v13}</td>
			<td>${v14}</td>
			<td>${v15}</td>
			<td>${v16}</td>
			<td>${v17}</td>
			<td>${v18}</td>
			<td>${v19}</td>
			<td>${v20}</td>
			<td>${v21}</td>
			<td>${v22}</td>
			<td>${v23}</td>
			<td>${v24}</td>
			<td>${v25}</td>
			<td>${v26}</td>
			<td>${v27}</td>
			<td>${v28}</td>
			<td>${v29}</td>
			<td>${v30}</td>
			<td>${v31}</td>
			<td>${v32}</td>
			<td>${v33}</td>
			
			<td>${v67}</td>
			<td>${v68}</td>
			
			
			<td>${_final_ivt_total}</td>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
</c:if>
<c:if test="${showom}">
<br><br><br>
<h4 class="blinking"><b>Closing Of <strong style="color: red;">${previousMonth}</strong> and Opening Of <strong style="color: green;">${currentMonth}</strong></b></h4>
<table id="barcodedatat`able" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 1400px;">Title</td>
			<td style="width: 80px;">MWL</td>
			<td style="width: 80px;">Prt mix</td>
			<td style="width: 80px;">MCL</td>
			<td style="width: 80px;">MWL W/IGS</td>
			<td style="width: 80px;">CBS</td>
			<td style="width: 80px;">Ctd Gdwd</td>
			<td style="width: 80px;">SWL</td>
			<td style="width: 80px;">ONP</td>
			<td style="width: 80px;">OI News</td>
			<td style="width: 80px;">Light Prt SBS</td>
			<td style="width: 80px;">HW</td>
			<td style="width: 80px;">Heavy Prt SBS</td>
			<td style="width: 80px;">SOW</td>
			<td style="width: 80px;">Unprt SBS</td>
			<td style="width: 80px;">Newsblank</td>
			<td style="width: 80px;">White Gdwd Blend</td>
			<td style="width: 80px;">Mail-Undeliverable</td>
			<td style="width: 80px;">Hogged Books</td>
			<td style="width: 80px;">OCC</td>
			<td style="width: 80px;">DLK</td>
			<td style="width: 80px;">Mixed Paper</td>
			<td style="width: 80px;">Soft Wood Chips</td>
			<td style="width: 80px;">Hard Wood Chips</td>
			<td style="width: 80px;">PWE</td>
			<td style="width: 80px;">White Broke</td>
			<td style="width: 80px;">Brown Napkin  Broke</td>
			<td style="width: 80px;">PULP Wet Lap</td>
			<td style="width: 80px;">Virgin Pulp</td>
			<td style="width: 80px;">Brown Wet Lap</td>
			<td style="width: 80px;">Pulp Dry Lap</td>
			<td style="width: 80px;">Other-Rolls</td>
			<td style="width: 80px;">ST Bales wetlap</td>
			<td style="width: 80px;">STT Baled Broke-Butl</td>
			
			<td style="width: 80px;">Virgin Hard Wood</td>
			<td style="width: 80px;">Virgin Soft Wood</td>
			
			
			<td style="width: 80px;">Total Bales</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Bales</b></td>
			<td>${v1}</td>
			<td>${v2}</td>
			<td>${v3}</td>
			<td>${v4}</td>
			<td>${v5}</td>
			<td>${v6}</td>
			<td>${v7}</td>
			<td>${v8}</td>
			<td>${v9}</td>
			<td>${v10}</td>
			<td>${v11}</td>
			<td>${v12}</td>
			<td>${v13}</td>
			<td>${v14}</td>
			<td>${v15}</td>
			<td>${v16}</td>
			<td>${v17}</td>
			<td>${v18}</td>
			<td>${v19}</td>
			<td>${v20}</td>
			<td>${v21}</td>
			<td>${v22}</td>
			<td>${v23}</td>
			<td>${v24}</td>
			<td>${v25}</td>
			<td>${v26}</td>
			<td>${v27}</td>
			<td>${v28}</td>
			<td>${v29}</td>
			<td>${v30}</td>
			<td>${v31}</td>
			<td>${v32}</td>
			<td>${v33}</td>
			
			<td>${v67}</td>
			<td>${v68}</td>
			
			<td>${_final_ivt_total}</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Weight</b></td>
			<td><fmt:formatNumber value="${v34}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v35}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v36}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v37}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v38}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v39}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v40}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v41}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v42}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v43}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v44}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v45}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v46}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v47}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v48}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v49}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v50}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v51}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v52}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v53}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v54}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v55}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v56}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v57}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v58}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v59}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v60}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v61}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v62}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v63}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v64}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v65}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v66}" maxFractionDigits="2"/></td>
			
			<td><fmt:formatNumber value="${v69}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v70}" maxFractionDigits="2"/></td>
			
			
			<td><fmt:formatNumber value="${_final_ivt_total_weight}" maxFractionDigits="2"/></td>
		</tr>
		</thead>
</table>
</c:if>

			</div>

		</div>


	</div>

</body>
</html>
