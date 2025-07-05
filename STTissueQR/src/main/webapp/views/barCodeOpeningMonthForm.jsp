<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/baleinventoryreportdetail/addopeningdata" var="saveDataURL" />
<script type="text/javascript">
$(function(){
	$('input[name=date]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
		changeDate:false
	   // changeYear: true
	});
});
</script>
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

// $(function(){
// 		$('#yielddatatable tbody input, #yielddatatable tbody input').focusin(doFocusIn);
// 		$('#yielddatatable tbody input, #yielddatatable tbody input').focusout(doFocusOut);	
// 		/* $('#yielddatatable tbody select, #yielddatatable tbody select').focusout(doFocusOut);	
// 		$('#yielddatatable tbody select, #yielddatatable tbody select').focusout(doFocusIn);	 */
// 		$('#openingclosingtbl select[name=destination]').focusin(doFocusIn);
// 		$('#openingclosingtbl select[name=destination]').focusout(doFocusOut);	
// 		//ntr.find('input').focusin(doFocusIn);
// 	});
	
	function validatePQ(tb){
		if($.trim(tb.val())!=''){				
			if( (tb.attr('name')=='prtmix') | 
				(tb.attr('name')=='mwl') | 	
				(tb.attr('name')=='mcl') | 
				(tb.attr('name')=='mwlwigs') |
				(tb.attr('name')=='cbs') |
				(tb.attr('name')=='ctdGdwd')|
				(tb.attr('name')=='swlsortedwhite') |
				(tb.attr('name')=='onpolnNewsprint') | 	
				(tb.attr('name')=='oinews') | 
				(tb.attr('name')=='lightprtsbs') |
				(tb.attr('name')=='hw') |
				(tb.attr('name')=='heavyprtsbs')|
				(tb.attr('name')=='sow') |
				(tb.attr('name')=='unprtsbs') | 	
				(tb.attr('name')=='newsblank') | 
				(tb.attr('name')=='whitegdwdblend') |
				(tb.attr('name')=='mailundeliverable') |
				(tb.attr('name')=='hoggedbooks')|
				(tb.attr('name')=='occ') |
				(tb.attr('name')=='dlk') | 	
				(tb.attr('name')=='mixedpaper') | 
				(tb.attr('name')=='softwoodchips') |
				(tb.attr('name')=='hardwoodchips') |
				(tb.attr('name')=='whitebroke')|
				(tb.attr('name')=='pwe') |
				(tb.attr('name')=='brownnapkinbroke') | 	
				(tb.attr('name')=='pulpwetlap') | 
				(tb.attr('name')=='virginpulp') |
				(tb.attr('name')=='brownwetLap') |
				(tb.attr('name')=='pulpdryLap')|
				(tb.attr('name')=='otherrolls') |
				(tb.attr('name')=='stbaleswetlap') | 	
				(tb.attr('name')=='virginhardwood') | 	
				(tb.attr('name')=='virginsoftwood') | 	
				(tb.attr('name')=='sttbaledbrokebutl') |
				//Weight Starts From Here
				(tb.attr('name')=='prtmixw') | 
				(tb.attr('name')=='mwlw') | 	
				(tb.attr('name')=='mclw') | 
				(tb.attr('name')=='mwlwigsw') |
				(tb.attr('name')=='cbsw') |
				(tb.attr('name')=='ctdGdwdw')|
				(tb.attr('name')=='swlsortedwhitew') |
				(tb.attr('name')=='onpolnNewsprintw') | 	
				(tb.attr('name')=='oinewsw') | 
				(tb.attr('name')=='lightprtsbsw') |
				(tb.attr('name')=='hww') |
				(tb.attr('name')=='unprtsbsw')|
				(tb.attr('name')=='soww') |
				(tb.attr('name')=='unprtsbsw') | 	
				(tb.attr('name')=='newsblankw') | 
				(tb.attr('name')=='whitegdwdblendw') |
				(tb.attr('name')=='mailundeliverablew') |
				(tb.attr('name')=='hoggedbooksw')|
				(tb.attr('name')=='occw') |
				(tb.attr('name')=='dlkw') | 	
				(tb.attr('name')=='mixedpaperw') | 
				(tb.attr('name')=='softwoodchipsw') |
				(tb.attr('name')=='hardwoodchipsw') |
				(tb.attr('name')=='whitebrokew')|
				(tb.attr('name')=='pwew') |
				(tb.attr('name')=='brownnapkinbrokew') | 	
				(tb.attr('name')=='pulpwetlapw') | 
				(tb.attr('name')=='virginpulpw') |
				(tb.attr('name')=='brownwetLapw') |
				(tb.attr('name')=='pulpdryLapw')|
				(tb.attr('name')=='otherrollsw') |
				(tb.attr('name')=='stbaleswetlapw') | 	
				(tb.attr('name')=='virginhardwoodw') | 	
				(tb.attr('name')=='virginsoftwoodw') | 	
				(tb.attr('name')=='sttbaledbrokebutlw') 
				){

			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				saveLock=true;
				return true;
			}
		}
		saveLock=false;
		return false;
	}
	function doFocusIn()
	{
		currentVal=$(this).val();
	}
	function doFocusOut()
	{
		alert("Hi...");
		/* if(validatePQ($(this)))
		{
			alert("Alert 1");
			return;
		}
		
		if($(this).val()==currentVal)
		{
			alert("Alert 2");
			return;
		} */
		
		saveData($(this));
	  //The Above Code Will Call The saveData Method And Save Data Into Database
	}
	//Validate Code Ends Here Done By Roshan Tailor Date :- 04/21/2015
</script>
<script type="text/javascript">
function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var date=tr.find('input[name=date]').val();
	
	var Prtmix  =tr.find('input[name=prtmix]').val();
	var MWL  =tr.find('input[name=mwl]').val();
	var Mcl  =tr.find('input[name=mcl]').val();
	var MWLWIGS=tr.find('input[name=mwlwigs]').val();
	var Cbs  =tr.find('input[name=cbs]').val();
	var CtdGdwd  =tr.find('input[name=ctdGdwd]').val();
	var Swlsortedwhite  =tr.find('input[name=swlsortedwhite]').val();
	var OnpolnNewsprint  =tr.find('input[name=onpolnNewsprint]').val();
	var Oinews  =tr.find('input[name=oinews]').val();
	var Lightprtsbs  =tr.find('input[name=lightprtsbs]').val();
	var Hw  =tr.find('input[name=hw]').val();
	var Heavyprtsbs  =tr.find('input[name=heavyprtsbs]').val();
	var Sow  =tr.find('input[name=sow]').val();
	var Unprtsbs  =tr.find('input[name=unprtsbs]').val();
	var Newsblank  =tr.find('input[name=newsblank]').val();
	var Whitegdwdblend  =tr.find('input[name=whitegdwdblend]').val();
	var Mailundeliverable  =tr.find('input[name=mailundeliverable]').val();
	var Hoggedbooks  =tr.find('input[name=hoggedbooks]').val();
	var Occ  =tr.find('input[name=occ]').val();
	var Dlk  =tr.find('input[name=dlk]').val();
	var Mixedpaper  =tr.find('input[name=mixedpaper]').val();
	var Softwoodchips  =tr.find('input[name=softwoodchips]').val();
	var Hardwoodchips  =tr.find('input[name=hardwoodchips]').val();
	var Whitebroke  =tr.find('input[name=whitebroke]').val();
	var Pwe  =tr.find('input[name=pwe]').val();
	var Brownnapkinbroke  =tr.find('input[name=brownnapkinbroke]').val();
	var Pulpwetlap  =tr.find('input[name=pulpwetlap]').val();
	var Virginpulp  =tr.find('input[name=virginpulp]').val();
	var BrownwetLap  =tr.find('input[name=brownwetLap]').val();
	var PulpdryLap  =tr.find('input[name=pulpdryLap]').val();
	var Otherrolls  =tr.find('input[name=otherrolls]').val();
	var Stbaleswetlap  =tr.find('input[name=stbaleswetlap]').val();
	var Sttbaledbrokebutl  =tr.find('input[name=sttbaledbrokebutl]').val();
	
	var virginhardwood  =tr.find('input[name=virginhardwood]').val();
	var virginsoftwood  =tr.find('input[name=virginsoftwood]').val();
	
	//Weight Starts From Here
	var Prtmixw  =tr.find('input[name=prtmixw]').val();
	var Mwlw  =tr.find('input[name=mwlw]').val();
	var Mclw  =tr.find('input[name=mclw]').val();
	var MWLWIGSW  =tr.find('input[name=mwlwigsw]').val();
	var Cbsw  =tr.find('input[name=cbsw]').val();
	var CtdGdwdw  =tr.find('input[name=ctdGdwdw]').val();
	var Swlsortedwhitew  =tr.find('input[name=swlsortedwhitew]').val();
	var OnpolnNewsprintw  =tr.find('input[name=onpolnNewsprintw]').val();
	var Oinewsw  =tr.find('input[name=oinewsw]').val();
	var Lightprtsbsw  =tr.find('input[name=lightprtsbsw]').val();
	var Hww  =tr.find('input[name=hww]').val();
	var Heavyprtsbsw  =tr.find('input[name=heavyprtsbsw]').val();
	var Soww  =tr.find('input[name=soww]').val();
	var Unprtsbsw  =tr.find('input[name=unprtsbsw]').val();
	var Newsblankw  =tr.find('input[name=newsblankw]').val();
	var Whitegdwdblendw  =tr.find('input[name=whitegdwdblendw]').val();
	var Mailundeliverablew  =tr.find('input[name=mailundeliverablew]').val();
	var Hoggedbooksw  =tr.find('input[name=hoggedbooksw]').val();
	var Occw  =tr.find('input[name=occw]').val();
	var Dlkw  =tr.find('input[name=dlkw]').val();
	var Mixedpaperw  =tr.find('input[name=mixedpaperw]').val();
	var Softwoodchipsw  =tr.find('input[name=softwoodchipsw]').val();
	var Hardwoodchipsw  =tr.find('input[name=hardwoodchipsw]').val();
	var Whitebrokew  =tr.find('input[name=whitebrokew]').val();
	var Pwew  =tr.find('input[name=pwew]').val();
	var Brownnapkinbrokew =tr.find('input[name=brownnapkinbrokew]').val();
	var Pulpwetlapw  =tr.find('input[name=pulpwetlapw]').val();
	var Virginpulpw  =tr.find('input[name=virginpulpw]').val();
	var BrownwetLapw =tr.find('input[name=brownwetLapw]').val();
	var PulpdryLapw  =tr.find('input[name=pulpdryLapw]').val();
	var Otherrollsw  =tr.find('input[name=otherrollsw]').val();
	var Stbaleswetlapw  =tr.find('input[name=stbaleswetlapw]').val();
	var Sttbaledbrokebutlw  =tr.find('input[name=sttbaledbrokebutlw]').val();
	
	var virginhardwoodw  =tr.find('input[name=virginhardwoodw]').val();
	var virginsoftwoodw  =tr.find('input[name=virginsoftwoodw]').val();
	
	
	alert("Swlsortedwhite:"+Swlsortedwhite);
	alert(date);
 	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${saveDataURL}',
		type:'POST',
		data:{
				  date : date,
			 	  Prtmix  : Prtmix,   
			      MWL  :   MWL,
				  Mcl  :  Mcl ,
				  MWLWIGS  : MWLWIGS,  
				  Cbs  :   Cbs,
				  CtdGdwd  :  CtdGdwd,   
				  Swlsortedwhite  :  Swlsortedwhite ,
				  OnpolnNewsprint  :   OnpolnNewsprint,
				  Oinews  :   Oinews,
				  Lightprtsbs  :   Lightprtsbs,
				  Hw  :   Hw,
				  Heavyprtsbs  :   Heavyprtsbs,
				  Sow  :   Sow,
				  Unprtsbs  :   Unprtsbs,
				  Newsblank  :   Newsblank,
				  Whitegdwdblend  : Whitegdwdblend ,
				  Mailundeliverable  :   Mailundeliverable,
				  Hoggedbooks  :   Hoggedbooks,
				  Occ  :   Occ,
				  Dlk  :   Dlk,
				  Mixedpaper  : Mixedpaper  ,
				  Softwoodchips  :   Softwoodchips,
				  Hardwoodchips  :   Hardwoodchips,
				  Whitebroke  :   Whitebroke,
				  Pwe  :   Pwe,
				  Brownnapkinbroke  :   Brownnapkinbroke,
				  Pulpwetlap  :   Pulpwetlap,
				  Virginpulp  :   Virginpulp,
				  BrownwetLap  :  BrownwetLap, 
				  PulpdryLap  :   PulpdryLap,
				  Otherrolls  :   Otherrolls,
				  Stbaleswetlap  :   Stbaleswetlap,
				  Sttbaledbrokebutl  :   Sttbaledbrokebutl,
				  
				  virginhardwood  :   virginhardwood,
				  virginsoftwood  :   virginsoftwood,
				  
// 				  Weighr Starts From Here
				  Prtmixw  : Prtmixw,   
				  Mwlw  :   Mwlw,
				  Mclw  :  Mclw,
				  MWLWIGSW  : MWLWIGSW,  
				  Cbsw  :   Cbsw,
				  CtdGdwdw  :  CtdGdwdw,   
				  Swlsortedwhitew  :  Swlsortedwhitew,
				  OnpolnNewsprintw  :   OnpolnNewsprintw,
				  Oinewsw  :   Oinewsw,
				  Lightprtsbsw  :   Lightprtsbsw,
				  Hww  :   Hww,
				  Heavyprtsbsw  :   Heavyprtsbsw,
				  Soww  :   Soww,
				  Unprtsbsw  :   Unprtsbsw,
				  Newsblankw  :   Newsblankw,
				  Whitegdwdblendw  : Whitegdwdblendw,
				  Mailundeliverablew  :   Mailundeliverablew,
				  Hoggedbooksw  :   Hoggedbooksw,
				  Occw  :   Occw,
				  Dlkw  :   Dlkw,
				  Mixedpaperw  : Mixedpaperw,
				  Softwoodchipsw  :   Softwoodchipsw,
				  Hardwoodchipsw  :   Hardwoodchipsw,
				  Whitebrokew  :   Whitebrokew,
				  Pwew  :   Pwew,
				  Brownnapkinbrokew :   Brownnapkinbrokew,
				  Pulpwetlapw  :   Pulpwetlapw,
				  Virginpulpw  :   Virginpulpw,
				  BrownwetLapw :  BrownwetLapw, 
				  PulpdryLapw  :   PulpdryLapw,
				  Otherrollsw  :   Otherrollsw,
				  Stbaleswetlapw  :   Stbaleswetlapw,
				  Sttbaledbrokebutlw  :   Sttbaledbrokebutlw,
				  virginhardwoodw  :   virginhardwoodw,
				  virginsoftwoodw  :   virginsoftwoodw
		},
		
		success:function(data){
			
			//idEle.val(data.id);//By This line Of Code We Are Geting Current Line Number OF <TD>
			var msg=$('#tmessage').text(data.message);
			alert(msg);
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
	
}
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
					<span class="label">BARCODE-INVENTORY DETAIL REPORT-OPENING MONTH ENTRY</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Grade Code:</td>
							<td></td>
						</tr>
					</table>
				</div>
<style type="text/css">
.tftable {font-size:12px;color:#333333;width:50%;border-width: 1px;border-color: #ebab3a;border-collapse: collapse;}
.tftable th {font-size:12px;background-color:#e6983b;border-width: 1px;padding: 8px;border-style: solid;border-color: #ebab3a;text-align:left;}
.tftable tr {background-color:#ffffff;}
.tftable td {font-size:12px;border-width: 1px;padding: 8px;border-style: solid;border-color: #ebab3a;}
.tftable tr:hover {background-color:#ffff99;}
.myButton {
    background-color: #CB842E;
    -moz-border-radius: 28px;
    -webkit-border-radius: 28px;
    border-radius: 28px;
    border: 1px solid #CB842E;
    display: inline-block;
    cursor: pointer;
    color: #ffffff;
    font-family: Arial;
    font-size: 17px;
    padding: 0px 23px;
    text-decoration: none;
    text-shadow: 0px 1px 0px #CB842E;
</style>
<center>
<form action="${saveDataURL}" method="POST">
	
	<table class="tftable" border="1" id="yielddatatable">
		<tbody id="openingclosingtbl">
			<p><b style="color: green;">${message}</b></p>
			<tr><td>Month:</td><td><input type="text" name="date" value="${date}" required="required"/></td></tr>
			<tr><th>Grade</th><th>Month Opening Bales/Weight</th><th>Grade</th><th>Month Opening Bales/Weight</th></tr><br><br>
			<c:if test="${fn:length(openingMonth) eq 0}">
			<tbody id="yielddatainput">
			<tr>
				<td><b>Prt mix</b></td><td>Bales:<input style="width: 30px;" type="text" name="prtmix" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="prtmixw" value=""></td>
				<td><b>MWL</b></td><td>Bales:<input style="width: 30px;" type="text" name="mwl" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mwlw" value=""></td>
			</tr>
			<tr>
				<td><b>MCL</b></td><td>Bales:<input style="width: 30px;" type="text" name="mcl" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mclw" value=""></td>
				<td><b>MWL W/IGS</b></td><td>Bales:<input style="width: 30px;" type="text" name="mwlwigs" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mwlwigsw" value=""></td>
			</tr>
			<tr>
				<td><b>CBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="cbs" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="cbsw" value=""></td>
				<td><b>Ctd Gdwd</b></td><td>Bales:<input style="width: 30px;" type="text" name="ctdgdwd" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="ctdgdwdw" value=""></td>
			</tr>
			<tr>
				<td><b>SWL-Sorted White</b></td><td>Bales:<input style="width: 30px;" type="text" name="swlsortedwhite" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="swlsortedwhitew" value=""></td>
				<td><b>ONP-Old News Print</b></td><td>Bales:<input style="width: 30px;" type="text" name="onpolnNewsprint" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="onpolnNewsprintw" value=""></td>
			</tr>
			<tr>
				<td><b>OI News</td><td>Bales:<input style="width: 30px;" type="text" name="oinews" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="oinewsw" value=""></td>
				<td><b>Light Prt SBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="lightprtsbs" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="lightprtsbsw" value=""></td>
			</tr>	
			<tr>
				<td><b>HW</b></td><td>Bales:<input style="width: 30px;" type="text" name="hw" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="hww" value=""></td>
				<td><b>Heavy Prt SBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="heavyprtsbs" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="heavyprtsbs" value=""></td>
			</tr>
			<tr>
				<td><b>SOW</b></td><td>Bales:<input style="width: 30px;" type="text" name="sow" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="soww" value=""></td>
				<td><b>Unprt SBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="unprtsbs" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="unprtsbsw" value=""></td>
			</tr>
			<tr>
				<td><b>Newsblank</b></td><td>Bales:<input style="width: 30px;" type="text" name="newsblank" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="newsblankw" value=""></td>
				<td><b>White Gdwd Blend</b></td><td>Bales:<input style="width: 30px;" type="text" name="whitegdwdblend" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="prtmixweight" value=""></td>
			</tr>
			<tr>
				<td><b>Mail-Undeliverable</b></td><td>Bales:<input style="width: 30px;" type="text" name="mailundeliverable" value="${wd.mailundeliverable}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mailundeliverablew" value=""></td>
				<td><b>Hogged Books</b></td><td>Bales:<input style="width: 30px;" type="text" name="hoggedbooks" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="hoggedbooksw" value=""></td>
			</tr>
			<tr>
				<td><b>OCC</b></td><td>Bales:<input style="width: 30px;" type="text" name="occ" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="occw" value=""></td>
				<td><b>DLK</b></td><td>Bales:<input style="width: 30px;" type="text" name="dlk" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="dlkw" value=""></td>
			</tr>
			<tr>
				<td><b>Mixed Paper</b></td><td>Bales:<input style="width: 30px;" type="text" name="mixedpaper" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mixedpaperw" value=""></td>
				<td><b>Soft Wood Chips</b></td><td>Bales:<input style="width: 30px;" type="text" name="softwoodchips" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="softwoodchipsw" value=""></td>
			</tr>
			<tr>
				<td><b>Hard Wood Chips</b></td><td>Bales:<input style="width: 30px;" type="text" name="hardwoodchips" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="hardwoodchipsw" value=""></td>
				<td><b>White Broke</b></td><td>Bales:<input style="width: 30px;" type="text" name="whitebroke" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="whitebrokew" value=""></td>
			</tr>
			<tr>
				<td><b>PWE</b></td><td>Bales:<input style="width: 30px;" type="text" name="pwe" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="pwew" value=""></td>
				<td><b>Brown Napkin Broke</b></td><td>Bales:<input style="width: 30px;" type="text" name="brownnapkinbroke" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="brownnapkinbrokew" value=""></td>
			</tr>
			<tr>
				<td><b>PULP Wet Lap</b></td><td>Bales:<input style="width: 30px;" type="text" name="pulpwetlap" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="pulpwetlapw" value=""></td>
				<td><b>Virgin Pulp</b></td><td>Bales:<input style="width: 30px;" type="text" name="virginpulp" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="virginpulpw" value=""></td>
			</tr>
			<tr>
				<td><b>Brown Wet Lap</b></td><td>Bales:<input style="width: 30px;" type="text" name="brownwetLap" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="brownwetLapw" value=""></td>
				<td><b>Pulp Dry Lap</b></td><td>Bales:<input style="width: 30px;" type="text" name="pulpdryLap" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="pulpdryLapw" value=""></td>
			</tr>
			<tr>
				<td><b>Other--Rolls</b></td><td>Bales:<input style="width: 30px;" type="text" name="otherrolls" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="otherrollsw" value=""></td>
				<td><b>ST Bales wetlap</b></td><td>Bales:<input style="width: 30px;" type="text" name="stbaleswetlap" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="stbaleswetlapw" value=""></td>
			</tr>

			<!-- New Grade Code Added From Here -->
			<tr>
				<td><b>Virgin Hard Wood</b></td><td>Bales:<input style="width: 30px;" type="text" name="virginhardwood" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="virginhardwoodw" value=""></td>
				<td><b>Virgin Soft Wood</b></td><td>Bales:<input style="width: 30px;" type="text" name="virginsoftwood" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="virginsoftwoodw" value=""></td>
			</tr>
			

			<tr>
				<td><b>STT Baled Broke-Butl</b></td><td>Bales:<input style="width: 30px;" type="text" name="sttbaledbrokebutl" value="">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="sttbaledbrokebutlw" value=""></td>
				<td colspan="2"><input type="submit" class="myButton"  value="Submit" name="Submit"/></td>
			</tr>
			</tbody>
			</c:if>
			<c:if test="${fn:length(openingMonth)>0}">
			<c:forEach items="${openingMonth}" var="wd">
			<tbody id="yielddatainput">
			<tr>
				<td><b>Prt mix</b></td><td>Bales:<input style="width: 30px;" type="text" name="prtmix" value="${wd.prtmix}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="prtmixw" value="${wd.prtmixw}"></td>
				<td><b>MWL</b></td><td>Bales:<input style="width: 30px;" type="text" name="mwl" value="${wd.mwl}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mwlw" value="${wd.mwlw}"></td>
			</tr>
			<tr>
				<td><b>MCL</b></td><td>Bales:<input style="width: 30px;" type="text" name="mcl" value="${wd.mcl}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mclw" value="${wd.mclw}"></td>
				<td><b>MWL W/IGS</b></td><td>Bales:<input style="width: 30px;" type="text" name="mwlwigs" value="${wd.mwlwigs}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mwlwigsw" value="${wd.mwlwigsw}"></td>
			</tr>
			<tr>
				<td><b>CBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="cbs" value="${wd.cbs}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="cbsw" value="${wd.cbsw}"></td>
				<td><b>Ctd Gdwd</b></td><td>Bales:<input style="width: 30px;" type="text" name="ctdgdwd" value="${wd.ctdGdwd}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="ctdgdwdw" value="${wd.ctdGdwdw}"></td>
			</tr>
			<tr>
				<td><b>SWL-Sorted White</b></td><td>Bales:<input style="width: 30px;" type="text" name="swlsortedwhite" value="${wd.swlsortedwhite}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="swlsortedwhitew" value="${wd.swlsortedwhitew}"></td>
				<td><b>ONP-Old News Print</b></td><td>Bales:<input style="width: 30px;" type="text" name="onpolnNewsprint" value="${wd.onpolnNewsprint}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="onpolnNewsprintw" value="${wd.onpolnNewsprintw}"></td>
			</tr>
			<tr>
				<td><b>OI News</td><td>Bales:<input style="width: 30px;" type="text" name="oinews" value="${wd.oinews}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="oinewsw" value="${wd.oinewsw}"></td>
				<td><b>Light Prt SBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="lightprtsbs" value="${wd.lightprtsbs}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="lightprtsbsw" value="${wd.lightprtsbsw}"></td>
			</tr>	
			<tr>
				<td><b>HW</b></td><td>Bales:<input style="width: 30px;" type="text" name="hw" value="${wd.hw}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="hww" value="${wd.hww}"></td>
				<td><b>Heavy Prt SBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="heavyprtsbs" value="${wd.heavyprtsbs}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="heavyprtsbs" value="${wd.heavyprtsbsw}"></td>
			</tr>
			<tr>
				<td><b>SOW</b></td><td>Bales:<input style="width: 30px;" type="text" name="sow" value="${wd.sow}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="soww" value="${wd.soww}"></td>
				<td><b>Unprt SBS</b></td><td>Bales:<input style="width: 30px;" type="text" name="unprtsbs" value="${wd.unprtsbs}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="unprtsbsw" value="${wd.unprtsbsw}"></td>
			</tr>
			<tr>
				<td><b>Newsblank</b></td><td>Bales:<input style="width: 30px;" type="text" name="newsblank" value="${wd.newsblank}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="newsblankw" value="${wd.newsblankw}"></td>
				<td><b>White Gdwd Blend</b></td><td>Bales:<input style="width: 30px;" type="text" name="whitegdwdblend" value="${wd.whitegdwdblend}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="prtmixweight" value="${wd.whitegdwdblendw}"></td>
			</tr>
			<tr>
				<td><b>Mail-Undeliverable</b></td><td>Bales:<input style="width: 30px;" type="text" name="mailundeliverable" value="${wd.mailundeliverable}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mailundeliverablew" value="${wd.mailundeliverablew}"></td>
				<td><b>Hogged Books</b></td><td>Bales:<input style="width: 30px;" type="text" name="hoggedbooks" value="${wd.hoggedbooks}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="hoggedbooksw" value="${wd.hoggedbooksw}"></td>
			</tr>
			<tr>
				<td><b>OCC</b></td><td>Bales:<input style="width: 30px;" type="text" name="occ" value="${wd.occ}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="occw" value="${wd.occw}"></td>
				<td><b>DLK</b></td><td>Bales:<input style="width: 30px;" type="text" name="dlk" value="${wd.dlk}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="dlkw" value="${wd.dlkw}"></td>
			</tr>
			<tr>
				<td><b>Mixed Paper</b></td><td>Bales:<input style="width: 30px;" type="text" name="mixedpaper" value="${wd.mixedpaper}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="mixedpaperw" value="${wd.mixedpaperw}"></td>
				<td><b>Soft Wood Chips</b></td><td>Bales:<input style="width: 30px;" type="text" name="softwoodchips" value="${wd.softwoodchips}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="softwoodchipsw" value="${wd.softwoodchipsw}"></td>
			</tr>
			<tr>
				<td><b>Hard Wood Chips</b></td><td>Bales:<input style="width: 30px;" type="text" name="hardwoodchips" value="${wd.hardwoodchips}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="hardwoodchipsw" value="${wd.hardwoodchipsw}"></td>
				<td><b>White Broke</b></td><td>Bales:<input style="width: 30px;" type="text" name="whitebroke" value="${wd.whitebroke}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="whitebrokew" value="${wd.whitebrokew}"></td>
			</tr>
			<tr>
				<td><b>PWE</b></td><td>Bales:<input style="width: 30px;" type="text" name="pwe" value="${wd.pwe}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="pwew" value="${wd.pwew}"></td>
				<td><b>Brown Napkin Broke</b></td><td>Bales:<input style="width: 30px;" type="text" name="brownnapkinbroke" value="${wd.brownnapkinbroke}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="brownnapkinbrokew" value="${wd.brownnapkinbrokew}"></td>
			</tr>
			<tr>
				<td><b>PULP Wet Lap</b></td><td>Bales:<input style="width: 30px;" type="text" name="pulpwetlap" value="${wd.pulpwetlap}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="pulpwetlapw" value="${wd.pulpwetlapw}"></td>
				<td><b>Virgin Pulp</b></td><td>Bales:<input style="width: 30px;" type="text" name="virginpulp" value="${wd.virginpulp}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="virginpulpw" value="${wd.virginpulpw}"></td>
			</tr>
			<tr>
				<td><b>Brown Wet Lap</b></td><td>Bales:<input style="width: 30px;" type="text" name="brownwetLap" value="${wd.brownwetLap}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="brownwetLapw" value="${wd.brownwetLapw}"></td>
				<td><b>Pulp Dry Lap</b></td><td>Bales:<input style="width: 30px;" type="text" name="pulpdryLap" value="${wd.pulpdryLap}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="pulpdryLapw" value="${wd.pulpdryLapw}"></td>
			</tr>
			<tr>
				<td><b>Other--Rolls</b></td><td>Bales:<input style="width: 30px;" type="text" name="otherrolls" value="${wd.otherrolls}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="otherrollsw" value="${wd.otherrollsw}"></td>
				<td><b>ST Bales wetlap</b></td><td>Bales:<input style="width: 30px;" type="text" name="stbaleswetlap" value="${wd.stbaleswetlap}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="stbaleswetlapw" value="${wd.stbaleswetlapw}"></td>
			</tr>
			
			<!-- New Grade Code Added From Here -->
			<tr>
				<td><b>Virgin Hard Wood</b></td><td>Bales:<input style="width: 30px;" type="text" name="virginhardwood" value="${wd.virginhardwood}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="virginhardwoodw" value="${wd.virginhardwoodw}"></td>
				<td><b>Virgin Soft Wood</b></td><td>Bales:<input style="width: 30px;" type="text" name="virginsoftwood" value="${wd.virginsoftwood}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="virginsoftwoodw" value="${wd.virginsoftwoodw}"></td>
			</tr>
			
			
			<tr>
				<td><b>STT Baled Broke-Butl</b></td><td>Bales:<input style="width: 30px;" type="text" name="sttbaledbrokebutl" value="${wd.sttbaledbrokebutl}">&nbsp;&nbsp;&nbsp;&nbsp;Weight:<input style="width: 30px;" type="text" name="sttbaledbrokebutlw" value="${wd.sttbaledbrokebutlw}"></td>
				<td colspan="2"><input type="submit" class="myButton"  value="Submit" name="Submit"/></td>
			</tr>
			</tbody>
			</c:forEach>
		</c:if>
	</table>
</form>
</center>
			</div>

		</div>


	</div>

</body>
</html>
