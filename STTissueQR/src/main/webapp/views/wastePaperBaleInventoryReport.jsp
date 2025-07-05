<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/baleinventoryreport/report/load" var="viewdataURL" />
<spring:url value="/baleinventoryreport/export" var="baleInvExportURL"/>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate]').datepicker({
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
<spring:url value="/baleinventoryreport/report/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		
		
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send WASTE PAPER BALE INVENTORY REPORT - REPORT for :'+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate
					},
					success : function(data){
						if(data){
							$('#tmessage').text('Mail sent successfully.');
						}else{
							$('#tmessage').text('Failure to send email. Please contact to administrator.');
						}
						btn=btn.prop('disabled',false);
						setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}
				});
			}
			
			
			
		});
	});
</script>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Waste Paper Bale Inventory Report</span>
				</div>
				<div class="table-selector">
					<table>
						<tr>
							<td>
								<form action="${viewdataURL}" method="get">
									<input type="text" name="sdate" value="${sdate}"/>
									<td><input type="submit" id="viewbutton" name="viewbutton" value="View" onclick="ButtonClicked();"></td>
								</form>
							</td>
							<c:if test="${viewpage}">	
							<td>
								<form action="${baleInvExportURL}" method="POST">
										<td><input type="hidden" name="sdate" value="${sdate}" ></td>
										<td><button id="exportbutton">Export</button></td>
								</form>
							</td>
							<td>
								<input type="button" value="Send Mail" id="sendMailBtn">
							</td>
							</c:if>
							<td>
							</td>
						</tr>
					</table>
				</div>
<div id="buttonreplacement" style="margin-left:30px; display:none; position: absolute;!important">
		<img style="height: 105px; border: none;width: 137px;margin: 100px 0px 0px 500px;" alt="Transfering Data..." src='<spring:url value="/resources/images/gears.gif"/>'> 
</div>
<c:if test="${viewpage}">	
<table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 80px;">ST. GRADES</td>
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
<!-- 			<td style="width: 80px;">Brown Wet Lap</td> -->
<!-- 			This code Commented To Show The Data Of PM6 Its Grade Code Is 80 -->
			<!--30 -->
			<td style="width: 80px;">Pulp Dry Lap</td>
			<!--31 -->
			<td style="width: 80px;">Other-Rolls</td>
			<!--32 -->
			<td style="width: 80px;">STT Baled Broke-Butl</td>
			<!--33 -->
			<!-- 			<td style="width: 80px;">ST Bales wetlap</td> -->
			<!-- 			This code Commented To Show The Data Of PM6 Its Grade Code Is 95 -->
			<td style="width: 80px;">STT-WetLAp Bales<br>PM6-Brown</td>
			
			<td style="width: 80px;">STT-Wetlap Bales<br>PM6-White</td>
			<!--33 -->
			<!-- <td style="width: 80px;">ST Wetlap Bales PM6-White</td>
			34
			<td style="width: 80px;">ST Wetlap Bales PM6-Brown</td> -->
			<!--35 -->
			<td style="width: 80px;">ST Wetlap Bales FRP-White</td>
			<!--36 -->
			<td style="width: 80px;">ST Wetlap Bales FRP-Brown</td>
			
			
			<!--37 -->
			<td style="width: 80px;">Virgin Hard Wood</td>
			
			<!--38 -->
			<td style="width: 80px;">Virgin Soft Wood</td>
			
			
			<!--39 -->
			<td style="width: 80px;">Total</td>
		</tr>
		<tr style="background-color: white;">
			<td><b>Total Bales</b></td>
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
			<td>${v30}</td>
			<td>${v31}</td>
			<td>${v33}</td>
			<td>${v29}</td>
			<td>${v32}</td>
			<td>${frps.stt_wetlapbales_pm6_white}</td>
			<td>${frps.stt_wetlapbales_pm6_brown}</td>
			
			
			<td>${v67}</td>
			<td>${v68}</td>
			
			<td>${totalBales}</td>
			
		</tr>
		<tr style="background-color: white;">
			<td><b>Total Tonnage</b></td>
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
			<td><fmt:formatNumber value="${v63}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v64}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v66}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v62}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v65}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${frps.stt_wetlapbales_pm6_white_weight}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${frps.stt_wetlapbales_pm6_brown_weight}" maxFractionDigits="2"/></td>
			
			<td><fmt:formatNumber value="${v69}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${v70}" maxFractionDigits="2"/></td>
			
			
			<td><fmt:formatNumber value="${_final_ivt_total_weight}" maxFractionDigits="2"/></td>
			
		</tr>
		<tr style="background-color: white;">
			<td><b>Total No. Bales<br>Consumed<br><fmt:formatDate value="${yesterdayDate}" pattern="MM/dd/yyyy"/></b></td>
			<td>${cbos.totalbalesOfMWL}</td>
			<td>${cbos.totalbalesOfPrtmix}</td>
			<td>${cbos.totalbalesOfMCL}</td>
			<td>${cbos.totalbalesOfMWLWorIGS}</td>
			<td>${cbos.totalbalesOfCBS}</td>
			<td>${cbos.totalbalesOfCtdGdwd}</td>
			<td>${cbos.totalbalesOfSWL}</td>
			<td>${cbos.totalbalesOfONPOldNewsPrint}</td>
			<td>${cbos.totalbalesOfOINews}</td>
			<td>${cbos.totalbalesOfLightPrtSBS}</td>
			<td>${cbos.totalbalesOfHW}</td>
			<td>${cbos.totalbalesOfHeavyPrtSBS}</td>
			<td>${cbos.totalbalesOfSOW}</td>
			<td>${cbos.totalbalesOfUnprtSBS}</td>
			<td>${cbos.totalbalesOfNewsblank}</td>
			<td>${cbos.totalbalesOfWhiteGdwdBlend}</td>
			<td>${cbos.totalbalesOfMailUndeliverable}</td>
			<td>${cbos.totalbalesOfHoggedBooks}</td>
			<td>${cbos.totalbalesOfOCC}</td>
			<td>${cbos.totalbalesOfDLK}</td>
			<td>${cbos.totalbalesOfMixedPaper}</td>
			<td>${cbos.totalbalesOfSoftWoodChips}</td>
			<td>${cbos.totalbalesOfHardWoodChips}</td>
			<td>${cbos.totalbalesOfPWE}</td>
			<td>${cbos.totalbalesOfWhiteBroke}</td>
			<td>${cbos.totalbalesOfBrownNapkinBroke}</td>
			<td>${cbos.totalbalesOfPULPWetLap}</td>
			<td>${cbos.totalbalesOfVirginPulp}</td>
			
			<td>${cbos.totalbalesOfPulpDryLap}</td>
			<td>${cbos.totalbalesOfOtherRolls}</td>
			<td>${cbos.totalbalesOfSTTBaledBroke}</td>
			<td>${cbos.totalbalesOfBrownWetLap}</td>
			<td>${cbos.totalbalesOfSTBaleswetlap}</td>
			<%--
			This Code Commented By roshan When Found Grade Code Of 95 And 80
			<td>${cbos.STT_WetlapBales_PM6_White}</td>
			<td>${cbos.STT_WetlapBales_PM6_Brown}</td> 
			--%>
			<td></td>
			<td></td>
			
			<td>${cbos.totalbalesweightForVirginHardWood}</td>
			<td>${cbos.totalbalesweightForVirginSoftWood}</td>
			
			<td>${cbos.total_cbod_bales}</td>
			
		</tr>
		<tr style="background-color: white;">
			<td><b>Consumed Tonnage</b></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForMWL}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForPrtmix}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForMCL}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForMWLWorIGS}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForCBS}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForCtdGdwd}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForSWL}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForONPOldNewsPrint}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForOINews}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForLightPrtSBS}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForHW}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForHeavyPrtSBS}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForSOW}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForUnprtSBS}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForNewsblank}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForWhiteGdwdBlend}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForMailUndeliverable}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForHoggedBooks}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForOCC}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForDLK}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForMixedPaper}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForSoftWoodChips}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForHardWoodChips}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForPWE}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForWhiteBroke}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForBrownNapkinBroke}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForPULPWetLap}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForVirginPulp}" maxFractionDigits="2"/></td>
			
			<td><fmt:formatNumber value="${cbos.totalbalesweightForPulpDryLap}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForOtherRolls}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForSTTBaledBroke}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForBrownWetLap}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesweightForSTBaleswetlap}" maxFractionDigits="2"/></td>
			<td></td>
			<td></td>
			
			<td><fmt:formatNumber value="${cbos.totalbalesOfVirginHardWood}" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${cbos.totalbalesOfVirginSoftWood}" maxFractionDigits="2"/></td>
			
			
			<td><fmt:formatNumber value="${cbos.total_cbod_weight}" maxFractionDigits="2"/></td>
			
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
</c:if>

			</div>

		</div>


	</div>

</body>
</html>
