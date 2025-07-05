<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<style type="text/css">
	.frptable{
		border-collapse: collapse;
		margin: auto; 
		border: 1px solid gray;
		
	}
	.frptable input[type=text]{
		width: 80px;
		height: 12px;
		font-size: 10px;
	}
	.frptable tr{
		height: 20px;
	}
	.frptable td{
		padding: 0 6px 0 6px;
	}
	.trobjrow{
		border: 1px solid gray;
	}
	.rightb{
		border-right: 1px solid gray;
	}
	
</style>
<spring:url value="/frpproduction/save" var="saveURL"/>
<spring:url value="/frpproduction/new" var="newURL"/>
<!-- Ccode Starts From Here Done By Roshan Tailor  -->
<spring:url value="/frpproduction/pressqualityinfo" var="pressqualityinfo"/>
<!-- Code Ends Here Done By Roshan Tailor -->
<c:choose>
	<c:when test="${editFlag}">
<script type="text/javascript">
	$(function(){
		$('input[name=date]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true,
		    onClose:function(){
		    	saveFRPData($(this));
		    }
		});
		
		$('select[name=prodType]').change(function(){
			if($(this).val()==''){
				alert('Select production type');
			}else{
				saveFRPData($(this));
			}
		});
		$('select[name=grade]').change(function(){
			if($(this).val()==''){
				alert('Select grade type');
			}else{
				saveFRPData($(this));
			}
		});
		
	});
</script>	
	
	</c:when>
	<c:otherwise>
<script type="text/javascript">
	$(function(){
		$('input[name=date]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true,
		    onClose:function(){
		    	getAvg($('input[name=date]').val());
		    }
		});
		
	});
</script>
	</c:otherwise>
</c:choose>



<script type="text/javascript">
var currentVal;
var saveLock=false;
var clearFPRTimer;
$(function(){
	
	//Get Data from press quality
	getAvg($('input[name=date]').val());
	
	$('#frpTable input[type=text],#frpTable tbody textarea').focusin(function(){
		currentVal=$(this).val();
		//calculation();
	});
	
	$('#frpTable tbody input[type=text],#frpTable tbody textarea').focusout(function(){
		
		
		if(validate($(this))){
			return;
		}
		
		calculation();
		
		saveFRPData($(this));

	});
	
	function calculation(){
		var tb=$('#frpTable tbody');
		
		var dcsWPFeedADST=tb.find('input[name=dcsWPFeedADST]').val();
		var  dcsWPFADST=0;
		if(dcsWPFeedADST!=''){
			dcsWPFADST=parseFloat(dcsWPFeedADST);
		}
		
		var totalProdADST=tb.find('input[name=totalProdADST]').val();
		var tPDST=0;
		if(totalProdADST!=''){
			tPDST=parseFloat(totalProdADST);
		}
		
		var ratio1=0;
		if(dcsWPFADST!=0){
			ratio1=(tPDST/dcsWPFADST)*100;
		}
		if(!isNaN(ratio1)){
			tb.find('input[name=yieldDcs]').val(ratio1.toFixed(2));
		}else{
			tb.find('input[name=yieldDcs]').val(0);
		}
		
		
		var trackerWPfeed=tb.find('input[name=trackerWPfeed]').val();
		var twpFeed=0;
		if(trackerWPfeed!=''){
			twpFeed=parseFloat(trackerWPfeed);
		}
		
		var ratio2=0;
		if(twpFeed!=0){
			ratio2=(tPDST/twpFeed)*100;
		}
		if(!isNaN(ratio2)){
			tb.find('input[name=yieldTracker]').val(ratio2.toFixed(2));
		}else{
			tb.find('input[name=yieldTracker]').val(0);
		}
		
		
		//count Total
		var wpmMwl=tb.find('input[name=wpmMwl]').val();
		var wpmMwlNum=0;
		if(!isNaN(wpmMwl) & wpmMwl!=''){
			wpmMwlNum=parseFloat(wpmMwl);
		}
		
		var wpmPrintMix=tb.find('input[name=wpmPrintMix]').val();
		var wpmPrintMixNum=0;
		if(!isNaN(wpmPrintMix) & wpmPrintMix!=''){
			wpmPrintMixNum=parseFloat(wpmPrintMix);
		}
		
		var wpmSow=tb.find('input[name=wpmSow]').val();
		var wpmSowNum=0;
		if(!isNaN(wpmSow) & wpmSow!=''){
			wpmSowNum=parseFloat(wpmSow);
		}
		
		var wpmCbs=tb.find('input[name=wpmCbs]').val();
		var wpmCbsNum=0;
		if(!isNaN(wpmCbs) & wpmCbs!=''){
			wpmCbsNum=parseFloat(wpmCbs);
		}
		
		var wpmSowAndCbs=tb.find('input[name=wpmSowAndCbs]').val();
		var wpmSowAndCbsNum=0;
		if(!isNaN(wpmSowAndCbs) & wpmSowAndCbs!=''){
			wpmSowAndCbsNum=parseFloat(wpmSowAndCbs);
		}
		
		var wpmCtdGrwd=tb.find('input[name=wpmCtdGrwd]').val();
		var wpmCtdGrwdNum=0;
		if(!isNaN(wpmCtdGrwd) & wpmCtdGrwd!=''){
			wpmCtdGrwdNum=parseFloat(wpmCtdGrwd);
		}
		
		var wpmSwl=tb.find('input[name=wpmSwl]').val();
		var wpmSwlNum=0;
		if(!isNaN(wpmSwl) & wpmSwl!=''){
			wpmSwlNum=parseFloat(wpmSwl);
		}
		
		var wpmOcc=tb.find('input[name=wpmOcc]').val();
		var wpmOccNum=0;
		if(!isNaN(wpmOcc) & wpmOcc!=''){
			wpmOccNum=parseFloat(wpmOcc);
		}
		
		var wpmNewsNewsblank=tb.find('input[name=wpmNewsNewsblank]').val();
		var wpmNewsNewsblankNum=0;
		if(!isNaN(wpmNewsNewsblank) & wpmNewsNewsblank!=''){
			wpmNewsNewsblankNum=parseFloat(wpmNewsNewsblank);
		}
		
		var wpmDlk=tb.find('input[name=wpmDlk]').val();
		var wpmDlkNum=0;
		if(!isNaN(wpmDlk) & wpmDlk!=''){
			wpmDlkNum=parseFloat(wpmDlk);
		}
		
		var wpmOther=tb.find('input[name=wpmOther]').val();
		var wpmOtherNum=0;
		if(!isNaN(wpmOther) & wpmOther!=''){
			wpmOtherNum=parseFloat(wpmOther);
		}
		
		
		var wpMailUndeliverable=tb.find('input[name=wpMailUndeliverable]').val();
		var wpMailUndeliverableNum=0;
		if(!isNaN(wpMailUndeliverable) & wpMailUndeliverable!=''){
			wpMailUndeliverableNum=parseFloat(wpMailUndeliverable);
		}
		
		
		var wpmTotalNum=wpmMwlNum+
		wpmPrintMixNum+
		wpmSowNum+
		wpmCbsNum+
		wpmSowAndCbsNum+
		wpmCtdGrwdNum+
		wpmSwlNum+
		wpmOccNum+
		wpmNewsNewsblankNum+
		wpmDlkNum+
		wpmOtherNum+
		wpMailUndeliverableNum;
		tb.find('input[name=wpmTotal]').val(wpmTotalNum.toFixed(2));
	
		tb.find('input[name=mrWhiteGrades]').val(0);
		tb.find('input[name=mrGroundwood]').val(0);
		tb.find('input[name=mrOcc]').val(0);
		tb.find('input[name=mrDlk]').val(0);
		tb.find('input[name=mrMwlAndSwl]').val(0);
		tb.find('input[name=mrSowAndCbs]').val(0);
		
		//var mrWhiteGrades=tb.find('input[name=mrWhiteGrades]').val();
		var mtdMMwlAndSwlNum=0;
		if(wpmTotalNum!=0){
			var prodType=$('select[name=prodType]').val();
			if(prodType=='BW'){
				mtdMMwlAndSwlNum=((wpmMwlNum+wpmSwlNum)/wpmTotalNum)*100;
				tb.find('input[name=mrMwlAndSwl]').val(mtdMMwlAndSwlNum.toFixed(2));
				
				var mrSowAndCbsNum=((wpmPrintMixNum+wpmCbsNum+wpmCtdGrwdNum+wpmSowNum)/wpmTotalNum)*100;
				tb.find('input[name=mrSowAndCbs]').val(mrSowAndCbsNum.toFixed(2));

			}
			
			if(prodType=='KF'){
				
				
				var mrWhiteGradesNum=((wpmMwlNum+wpmPrintMixNum+wpmSwlNum+wpmSowAndCbsNum)/wpmTotalNum)*100;
				tb.find('input[name=mrWhiteGrades]').val(mrWhiteGradesNum.toFixed(2));
				
				var mrGroundwoodNum=((wpmNewsNewsblankNum+wpmCtdGrwdNum)/wpmTotalNum)*100;
				tb.find('input[name=mrGroundwood]').val(mrGroundwoodNum.toFixed(2));
				
				var mrDlkNum=(wpmDlkNum/wpmTotalNum)*100;
				tb.find('input[name=mrDlk]').val(mrDlkNum.toFixed(2));
				
				var mrOccNum=(wpmOccNum/wpmTotalNum)*100;
				tb.find('input[name=mrOcc]').val(mrOccNum.toFixed(2));
				
				
				var mrMailUndeliverableNum=(wpMailUndeliverableNum/wpmTotalNum)*100;
				tb.find('input[name=mrMailUndeliverable]').val(mrMailUndeliverableNum.toFixed(2));
			}
			
			//Changes
			var mrOtherNum=(wpmOtherNum/wpmTotalNum)*100;
			tb.find('input[name=mrOther]').val(mrOtherNum.toFixed(2));
			
			
			var mrMwlAndSwl=parseFloat(tb.find('input[name=mrMwlAndSwl]').val()) || 0;
			var mrSowAndCbs=parseFloat(tb.find('input[name=mrSowAndCbs]').val()) || 0;
			var mrWhiteGrades=parseFloat(tb.find('input[name=mrWhiteGrades]').val()) || 0;
			var mrGroundwood=parseFloat(tb.find('input[name=mrGroundwood]').val()) || 0;
			var mrOcc=parseFloat(tb.find('input[name=mrOcc]').val()) || 0;
			var mrDlk=parseFloat(tb.find('input[name=mrDlk]').val()) || 0;
			var mrOther=parseFloat(tb.find('input[name=mrOther]').val()) || 0;
			var mrMailUndeliverable=parseFloat(tb.find('input[name=mrMailUndeliverable]').val()) || 0;
			
			var totalMixRatio=mrMwlAndSwl+mrSowAndCbs+mrWhiteGrades+mrGroundwood+mrOcc+mrDlk+mrOther+mrMailUndeliverable;
			tb.find('input[name=totalmix]').val(totalMixRatio.toFixed(2));
		}
		
	}
	calculation();
	
	
	
	function validate(jq){
		if(jq.attr('name')=='comments'){
			return false;
		}
		
		if(jq.attr('name')=='targetBrightness'){
			var val=jq.val();
			if(val!=''){
				if(val.indexOf('-')>0){
					if(!isNaN(val.split("-")[0]) & !isNaN(val.split("-")[1])){
						return false;
					}else{
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.(For example '74' and '74-45' value allowed)");
						return true;
					}
				}else{
					if(isNaN(val)){
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.(For example '74' and '74-45' value allowed)");
						return true;
					}else{
						return false;
					}
				}
			}else{
				return false;
			}
		}else if(jq.attr('name')=='pmAvgBrite'){
			var val=jq.val();
			if(val!=''){
				if(val.indexOf('/')>0){
					if(!isNaN(val.split("/")[0]) & !isNaN(val.split("/")[1])){
						return false;
					}else{
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.(For example '74' or '74/45' value is allowed)");
						return true;
					}
				}else{
					if(isNaN(val)){
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.(For example '74' or '74/45' value is allowed)");
						return true;
					}else{
						return false;
					}
				}
			}else{
				return false;
			}
		}else if(jq.attr('name')=='pmTargetBrite'){
			var val=jq.val();
			if(val!=''){
				if(val.indexOf('/')>0){
					if(!isNaN(val.split("/")[0]) & !isNaN(val.split("/")[1])){
						return false;
					}else{
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.(For example '74' and '74/45' value allowed)");
						return true;
					}
				}else{
					if(isNaN(val)){
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.(For example '74' and '74/45' value allowed)");
						return true;
					}else{
						return false;
					}
				}
			}else{
				return false;
			}
	}
		else{
			var val=jq.val();
			if(val!='')
			{
				if(isNaN(val))
				{
// 					Code Starts From Here Done By Roshan Tailor Date :- 03/26/2015   MM/DD/YYYY 
					var secpressqualityavgastar = document.getElementById('secpressqualityavgastar').value;
					var secpressqualityavgbstar = document.getElementById('secpressqualityavgbstar').value;
					var clarifierunderflowpumpruningYN = document.getElementById('clarifierunderflowpumpruningYN').value;
					//alert(secpressqualityavgastar);
					if(secpressqualityavgastar=='Red'){}
					else if(secpressqualityavgastar=='Green'){}
					else if(secpressqualityavgbstar=='Yellow'){}
					else if(secpressqualityavgbstar=='Blue'){}
					else if(clarifierunderflowpumpruningYN=='Y'){}
					else if(clarifierunderflowpumpruningYN=='N'){}
// 					Code Ends Here Done By Roshan Tailor
					else{
						setTimeout(function(){jq.focus();}, 100);
						alert("Enter valid number.");
						return true;
					}
					
				}else
				{
					return false;
				}
			}
			else{
				return false;
			}
			
			return false;
			
		}
	}
	
});
function saveFRPData(jq){
	
	if(currentVal==jq.val()){
		return;
	}
	
	$('#tmessage').text('');
	clearTimeout(clearFPRTimer);
	
	var tb=$('#frpTable tbody');
	
	var date=$('input[name=date]').val();
	var prodType=$('select[name=prodType]').val();
	
	if(prodType==''){
		setTimeout(function(){$('select[name=prodType]').focus();}, 100);
		alert('Select Production Type.');
		return;
	}
	
	var id=tb.find('input[name=id]').val();
	var idEle=tb.find('input[name=id]');
	var hdStorage=tb.find('input[name=hdStorage]').val();
	var dcsWPFeedADST=tb.find('input[name=dcsWPFeedADST]').val();
	var primaryPressADST=tb.find('input[name=primaryPressADST]').val();
	var wetLapProdADST=tb.find('input[name=wetLapProdADST]').val();
	var totalProdADST=tb.find('input[name=totalProdADST]').val();
	var trackerWPfeed=tb.find('input[name=trackerWPfeed]').val();
	var yieldDcs=tb.find('input[name=yieldDcs]').val();
	var yieldTracker=tb.find('input[name=yieldTracker]').val();
	var freshWater=tb.find('input[name=freshWater]').val();
	var mrMwlAndSwl=tb.find('input[name=mrMwlAndSwl]').val();
	var mrSowAndCbs=tb.find('input[name=mrSowAndCbs]').val();
	var mrDlk=tb.find('input[name=mrDlk]').val();
	var mrOcc=tb.find('input[name=mrOcc]').val();
	var mrWhiteGrades=tb.find('input[name=mrWhiteGrades]').val();
	var mrGroundwood=tb.find('input[name=mrGroundwood]').val();
	var mrOther=tb.find('input[name=mrOther]').val();
	var wpmMwl=tb.find('input[name=wpmMwl]').val();
	var wpmPrintMix=tb.find('input[name=wpmPrintMix]').val();
	var wpmSow=tb.find('input[name=wpmSow]').val();
	var wpmCbs=tb.find('input[name=wpmCbs]').val();
	var wpmSowAndCbs=tb.find('input[name=wpmSowAndCbs]').val();
	var wpmCtdGrwd=tb.find('input[name=wpmCtdGrwd]').val();
	var wpmSwl=tb.find('input[name=wpmSwl]').val();
	var wpmOcc=tb.find('input[name=wpmOcc]').val();
	var wpmNewsNewsblank=tb.find('input[name=wpmNewsNewsblank]').val();
	var wpmDlk=tb.find('input[name=wpmDlk]').val();
	var wpmOther=tb.find('input[name=wpmOther]').val();
	var wpmTotal=tb.find('input[name=wpmTotal]').val();
	var targetBrightness=tb.find('input[name=targetBrightness]').val();
	var dailyAvg=tb.find('input[name=dailyAvg]').val();
	var pmTargetBrite=tb.find('input[name=pmTargetBrite]').val();
	var pmAvgBrite=tb.find('input[name=pmAvgBrite]').val();
	var comments=tb.find('textarea[name=comments]').val();
	var grade=$('select[name=grade]').val();
	
	//wpMailUndeliverable
			
	//
	var freshWaterEle=tb.find('input[name=freshWater]');
	
	//New Fields
	var wpMailUndeliverable=tb.find('input[name=wpMailUndeliverable]').val();
	var freshWater2=tb.find('input[name=freshWater2]').val();
	
	var freshWaterEle2=tb.find('input[name=freshWater2]');
	
	if(saveLock){
		return;
	}
	saveLock=true;
	
	$.ajax({
		url:'${saveURL}',
		type:'POST',
		data:{
			id : id,
			date : date,
			hdStorage : hdStorage,
			dcsWPFeedADST : dcsWPFeedADST,
			primaryPressADST : primaryPressADST,
			wetLapProdADST : wetLapProdADST,
			totalProdADST : totalProdADST,
			trackerWPfeed : trackerWPfeed,
			yieldDcs : yieldDcs,
			yieldTracker : yieldTracker,
			freshWater : freshWater,
			mrMwlAndSwl : mrMwlAndSwl,
			mrSowAndCbs : mrSowAndCbs,
			mrDlk : mrDlk,
			mrOcc : mrOcc,
			mrWhiteGrades : mrWhiteGrades,
			mrGroundwood : mrGroundwood,
			mrOther : mrOther,
			wpmMwl : wpmMwl,
			wpmPrintMix : wpmPrintMix,
			wpmSow : wpmSow,
			wpmCbs : wpmCbs,
			wpmSowAndCbs : wpmSowAndCbs,
			wpmCtdGrwd : wpmCtdGrwd,
			wpmSwl : wpmSwl,
			wpmOcc : wpmOcc,
			wpmNewsNewsblank : wpmNewsNewsblank,
			wpmDlk : wpmDlk,
			wpmOther : wpmOther,
			wpmTotal : wpmTotal,
			targetBrightness : targetBrightness,
			dailyAvg : dailyAvg,
			pmTargetBrite : pmTargetBrite,
			pmAvgBrite : pmAvgBrite,
			comments : comments,
			prodType : prodType,
			wpMailUndeliverable : wpMailUndeliverable,
			grade : grade,
			freshWater2 : freshWater2
		},
		success:function(data){
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearFPRTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			}else{
				alert(data.error);
			}
			
			freshWaterEle.val(data.freshWater);
			freshWaterEle2.val(data.freshWater2);
			
			$('#mtdDCSYield').val(data.dcsYield);
			$('#mtdTrackYield').val(data.trackerYield);
			
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
}
</script>
<!-- Code Starts From Here Done By Roshan Tailor Date :- 03/21/2015 -->
<script type="text/javascript">
function getAvg(date) {
	//alert("Hi..........");
	$.ajax({
		url:'${pressqualityinfo}',
		type: "POST",
		data:{
			date:$('input[name=date]').val()
		},
		datatype: "text/html",								
		success: function(data) {
			 //$("#sludgepressconsistency").html(data);// To Check The Results
			 $(document).ready(function() {
		    		 $('#mixratiobrightness').val(data.brightnessAvg);
		    		 
		    		 //Code Modified By Roshan Tailor On 03/21/2015
		    		 $('#tertpressbrightness').val(data.avgtertpressbrightness);
		    		 $('#tertpressdirt').val(data.avgtertpressdirt);
		    		 $('#tertpressstickies').val(data.avgtertpressstickies);
		    		 $('#tertpressash').val(data.avgtertpressash);
		    		
		    		//map For SEC Press OR SECPRESSQ.
		    		 $('#secpressqualityavgbrightness').val(data.avgsecpressqbrightness);
		    		 $('#secpressqualityavgeric').val(data.avgeric);
		    		 $('#secpressqualityavgastar').val(data.avgastar);
		    		 $('#secpressqualityavgbstar').val(data.avgbstar);
		    		 
		    		//map For TERT Press OR TPQ1 AND TPQ2.
		    		 $('#tertpressbrightness').val(data.avgtertpressbrightness);
					 $('#tertpressdirt').val(data.avgtertpressdirt);
					 $('#tertpressstickies').val(data.avgtertpressstickies);
					 $('#tertpressash').val(data.avgtertpressash);
		    		//Map For Sludge Press Consistency.
		    		 $('#sludgepressconsistency').val(data.avgCons1);
		    		//Map For Screw Press Consistency.
		    		$('#screwpressconsistency').val(data.avgCons2);
		    		//Map For Clarifier Under Running Or Not.
		    		$('#clarifierunderflowpumpruningYN').val(data.CURuning);
		           
		        }); 
		}
	});			
}
		
</script>
<!-- Code Ends Here Done By Roshan Tailor -->
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP Production - Data Entry</span>
				</div>
				<br>
				<br>
<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea({
				retainAttr:['class','style']
			});
		});
	});
</script>

				
				<div class="table-selector">
					<button onclick="window.location.href='${newURL}'">New</button>
					<c:if test="${not empty backParam}">
								<spring:url value="/frpproductionreport/view/data" var="backURL"/>
								
								<button onclick="location.href='${backURL}?${backParam}'">Back to Report</button>
					</c:if>
					
					<button id="printBtn">Print</button>
				</div>
				<div>

<div id="printDiv">		
<table style="margin: auto;">
	<tr>
		<td>Date</td>
		<td>
			<input readonly="readonly" type="text" name="date" value="${date}" style="width: 70px;" tabindex="1">
		</td>
		<td>Production Type</td>
		<td>
			<select name="prodType" style="width: 120px;padding: 2px;" tabindex="2">
				<option value="">Select</option>
				<c:forEach items="${ptypes}" var="ptype">
					<c:choose>
						<c:when test="${ptype.key eq frpProdcution.prodType}">
							<option value="${ptype.key}" selected="selected">${ptype.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${ptype.key}" >${ptype.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		<td>Grade Type</td>
		<td>
			<select name="grade" style="padding: 2px;" tabindex="2">
				<option value="">Select</option>
				<c:forEach items="${grades}" var="gtype">
					<c:choose>
						<c:when test="${gtype.key eq frpProdcution.grade}">
							<option value="${gtype.key}" selected="selected">${gtype.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${gtype.key}" >${gtype.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		
	</tr>
</table>
		
<table class="frptable" id="frpTable">
	<tr>
		<td>HD storage (%)</td>
		<td class="rightb"><input type="text" name="hdStorage" value="${frpProdcution.hdStorage}" tabindex="3"></td>
		
		<td>Yield DCS</td>
		<td><input readonly="readonly" type="text" name="yieldDcs" value="${frpProdcution.yieldDcs}">%</td>
		
	</tr>
	<tr>
		<td>DCS Wastepaper feed ADST</td>
		<td class="rightb"><input type="text" name="dcsWPFeedADST" value="${frpProdcution.dcsWPFeedADST}" tabindex="3"></td>
		
		<td>Yield Tracker</td>
		<td><input readonly="readonly" type="text" name="yieldTracker" value="${frpProdcution.yieldTracker}">%</td>
		
	</tr>
	<tr>
		<td>Secondary press ADST</td>
		<td class="rightb"><input type="text" name="primaryPressADST" value="${frpProdcution.primaryPressADST}" tabindex="3"></td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td>Wet Lap production ADST</td>
		<td  class="rightb"><input type="text" name="wetLapProdADST" value="${frpProdcution.wetLapProdADST}" tabindex="3"></td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td>Total Production ADST</td>
		<td class="rightb"><input type="text" name="totalProdADST" value="${frpProdcution.totalProdADST}" tabindex="3"></td>
		<td colspan="2"  class="trobjrow">Month To Date</td>
	</tr>
	<tr>
		<td>Tracker Wastepaper feed</td>
		<td class="rightb"><input type="text" name="trackerWPfeed" value="${frpProdcution.trackerWPfeed}" tabindex="3"></td>
		<td>MTD DCS yield</td>
		<td><input type="text" id="mtdDCSYield" value="${dcsYield}" readonly="readonly">%</td>
	</tr>
	
	<tr>
		<td colspan="2" class="rightb">&nbsp;</td>
		<td>MTD Tracker yield</td>
		<td><input type="text" id="mtdTrackYield" value="${trackerYield}" readonly="readonly">%</td>
	</tr>
	
	<tr>
		<td>Fresh Water #1008</td>
		<td  class="rightb"><input type="text" name="freshWater" value="${frpProdcution.freshWater}" tabindex="3"></td>
		<td colspan="2">&nbsp;</td>	
	</tr>
	
	<tr>
		<td>Fresh Water #1009</td>
		<td  class="rightb"><input type="text" name="freshWater2" value="${frpProdcution.freshWater2}" tabindex="3"></td>
		<td colspan="2">&nbsp;</td>	
	</tr>
	
	
	
	<tr>
		<td colspan="2" class="rightb">&nbsp;</td>
		<td colspan="2">&nbsp;</td>
	</tr>
	

	<tr class="trobjrow">
		<td colspan="2">Wastepaper Mix</td>
		<td  colspan="2" class="rightb">Mix Ratio</td>
	</tr>
	<tr>
		<td>MWL</td>
		<td class="rightb"><input type="text" name="wpmMwl" value="${frpProdcution.wpmMwl}" tabindex="3"></td>
		
		<td>MWL &#38; SWL</td>
		<td><input readonly="readonly" type="text" name="mrMwlAndSwl" value="${frpProdcution.mrMwlAndSwl}">%</td>
		
	</tr>
	<tr>
		<td>Print mix</td>
		<td class="rightb"><input type="text" name="wpmPrintMix" value="${frpProdcution.wpmPrintMix}" tabindex="3"></td>
		
		<td>SOW &#38; CBS</td>
		<td><input readonly="readonly" type="text" name="mrSowAndCbs" value="${frpProdcution.mrSowAndCbs}">%</td>
	</tr>
	<tr>
		<td>CBS</td>
		<td class="rightb"><input type="text" name="wpmCbs" value="${frpProdcution.wpmCbs}" tabindex="3"></td>
		
		<td>White grades</td>
		<td><input type="text" readonly="readonly" name="mrWhiteGrades" value="${frpProdcution.mrWhiteGrades}">%</td>
	</tr>
	<tr>
		<td>SOW</td>
		<td class="rightb"><input type="text" name="wpmSow" value="${frpProdcution.wpmSow}" tabindex="3"></td>
		
		<td>Groundwood</td>
		<td><input readonly="readonly" type="text" name="mrGroundwood" value="${frpProdcution.mrGroundwood}">%</td>
	</tr>
	<tr>
		<td>SOW &#38; CBS</td>
		<td class="rightb"><input type="text" name="wpmSowAndCbs" value="${frpProdcution.wpmSowAndCbs}" tabindex="3"></td>
		
		<td>DLK</td>
		<td><input readonly="readonly" type="text" name="mrDlk" value="${frpProdcution.mrDlk}">%</td>
	</tr>
	<tr>
		<td>SWL</td>
		<td class="rightb"><input type="text" name="wpmSwl" value="${frpProdcution.wpmSwl}" tabindex="3"></td>
		
		<td>OCC</td>
		<td><input readonly="readonly" type="text" name="mrOcc" value="${frpProdcution.mrOcc}">%</td>
	</tr>
	<tr>
		<td>Ctd grwd</td>
		<td class="rightb"><input type="text" name="wpmCtdGrwd" value="${frpProdcution.wpmCtdGrwd}" tabindex="3"></td>
		
		<td>Mail Undeliverable</td>
		<td><input readonly="readonly" type="text" name="mrMailUndeliverable" value="${frpProdcution.mrOther}">%</td>
		
	</tr>
	<tr>
		<td>OCC</td>
		<td class="rightb"><input type="text" name="wpmOcc" value="${frpProdcution.wpmOcc}" tabindex="3"></td>
		<td>Other</td>
		<td><input readonly="readonly" type="text" name="mrOther" value="${frpProdcution.mrOther}">%</td>
	</tr>
	<tr>
		<td>News / newsblank</td>
		<td class="rightb"><input type="text" name="wpmNewsNewsblank" value="${frpProdcution.wpmNewsNewsblank}" tabindex="3"></td>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td>DLK</td>
		<td class="rightb"><input type="text" name="wpmDlk" value="${frpProdcution.wpmDlk}" tabindex="3"></td>
		<td><b>Total Mix Ratio</b></td>
		<td><input type="text" name="totalmix" readonly="readonly">%</td>
		
	</tr>
	<tr>
		<td>Mail Undeliverable</td>
		<td class="rightb"><input type="text" name="wpMailUndeliverable" value="${frpProdcution.wpMailUndeliverable}" tabindex="3"></td>
<!-- 		<td colspan="2">&nbsp;</td> -->
<!-- 	Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015 MM/DD/YYYY -->
		<td>Clarifier Under Flow Pump Runing</td>
		<td><input type="text" name="clarifierunderflowpumpruningYN" id="clarifierunderflowpumpruningYN"  tabindex="3" readonly="readonly"></td>
<!-- 	Code Ends Here Done By Roshan Tailor -->
	</tr>
	<tr>
		<td>Mixed/other</td>
		<td class="rightb"><input type="text" name="wpmOther" value="${frpProdcution.wpmOther}" tabindex="3"></td>
<!-- 		<td colspan="2">&nbsp;</td> -->
<!-- 	Code Starts From Here Done By Roshan Tailor Date :-03/17/2015	 -->
		<td>Sludge Press Consistency</td>
		<td><input type="text" name="sludgepressconsistency" id="sludgepressconsistency" value="" tabindex="3" readonly="readonly"></td>
<!-- 	Code Ends Here Done By Roshan Tailor -->
	</tr>
	<tr>
		<td>Total</td>
		<td class="rightb"><input readonly="readonly" type="text" name="wpmTotal" value="${frpProdcution.wpmTotal}"></td>
<!-- 	Code Starts From Here Done By Roshan Tailor Date :- 03/17/2015 -->
		<td>Screw Press Consistency</td>
		<td><input type="text" name="screwpressconsistency" id="screwpressconsistency" value="" tabindex="3" readonly="readonly"></td>
<!-- 	Code ends Here Done BY Roshan Tailor -->
	</tr>
	<tr>
		<td colspan="2" class="rightb">&nbsp;</td>
<!-- 		<td colspan="2"><b>Secondary Press Quality</b></td> -->
		<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 04/08/2015 -->
		<td><b>Secondary Press Quality</b></td>
		<td><b>Tertiary Press Quality</b></td>
<!-- 		Code Ends Here Done By Roshan Tailor -->	
	</tr>
	<tr>
		<td>Target brightness</td>
		<td class="rightb"><input type="text" name="targetBrightness" id="targetBrightness" value="${frpProdcution.targetBrightness}" tabindex="3"></td>
		<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 04/08/2015 -->
		<td>Brightness:<input type="text" name="secpressqualityavgbrightness" id="secpressqualityavgbrightness" value="" tabindex="3" readonly="readonly"></td>
		<td>Brightness:<input type="text" name="tertpressbrightness" id="tertpressbrightness"  value="" tabindex="3" readonly="readonly"></td>
		<!-- 		Code Ends Here Done By Roshan Tailor -->		
	</tr>
	<tr>
		<td>Daily avg</td>
		<td class="rightb"><input type="text" name="dailyAvg" value="${frpProdcution.dailyAvg}" tabindex="3"></td>
		<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 04/08/2015 -->
		<td>ERIC:<input type="text" style="margin: 0px 0px 0px 24px ! important;" name="secpressqualityavgeric" id="secpressqualityavgeric" value="" tabindex="3"b readonly="readonly"></td>
		<td>Dirt:<input type="text" style="margin: 0px 0px 0px 31px ! important;" name="tertpressdirt" id="tertpressdirt"  value="" tabindex="3" readonly="readonly"></td>
		<!-- 		Code Ends Here Done By Roshan Tailor -->
	</tr>
	<tr>
		<!-- 		Code Starts And Ends Here Done By Roshan Tailor Date :- 03/17/2015 MM/DD/YYYY -->
		<td>TP # 1 Consistency </td>
		<td class="rightb"><input type="text" name="pmTargetBrite" value="${frpProdcution.pmTargetBrite}" tabindex="3"></td>
		<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 04/08/2015 -->
		<td>A*:<input type="text" style="margin: 0px 0px 0px 35px ! important;" name="secpressqualityavgastar" id="secpressqualityavgastar" value=""  readonly="readonly" tabindex="3"></td>
		<td>Stickies:<input type="text" style="margin: 0px 0px 0px 14px ! important;" name="tertpressstickies" id="tertpressstickies"  value="" tabindex="3" readonly="readonly"></td>
		<!-- 		Code Ends Here Done By Roshan Tailor -->
	</tr>
	<tr>
		<td>TP # 2 Consistency </td>
		<td class="rightb"><input type="text" name="pmAvgBrite" value="${frpProdcution.pmAvgBrite}" tabindex="3"></td>
		<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 04/08/2015 -->
		<td>B*:<input type="text" style="margin: 0px 0px 0px 35px ! important;" name="secpressqualityavgbstar" id="secpressqualityavgbstar" value=""  readonly="readonly" tabindex="3"></td>
		<td>Ash:<input type="text" style="margin: 0px 0px 0px 31px ! important;" name="tertpressash" id="tertpressash"  value="" tabindex="3" readonly="readonly"></td>
		<!-- 		Code Ends Here Done By Roshan Tailor -->
	</tr>
		<!-- 	Code Starts From Here Done By Roshan Tailor Date :-03/21/2015 -->
	<tr>
		<td colspan="2" class="rightb">&nbsp;</td>
		<!-- 		<td colspan="2"><b>Tertiary Press Quality</b></td> -->
	</tr>
<!-- 	Code Ends Here Done By Roshan Tailor Date :- 03/21/2015 -->
	<tr>
		<td colspan="2" class="rightb">&nbsp;</td>
		<td colspan="2"></td>
	</tr>
	
	<tr class="trobjrow">
		<td colspan="4" class="rightb">Comments</td>
		
	</tr>
	<tr>
		<td colspan="4">
			<textarea name="comments" style="width: 530px; height: 80px;" tabindex="4">${frpProdcution.comments}</textarea>
		</td>
	</tr>
	<tr style="height: 0px;">
		<td colspan="4"><input type="hidden" name="id" value="${frpProdcution.id}" > </td>
	</tr>
	
</table>
</div>
				<br><br>
				</div>
			</div>

		</div>


	</div>

</body>
</html>
