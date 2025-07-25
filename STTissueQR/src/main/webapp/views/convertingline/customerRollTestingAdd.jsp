<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<title><spring:message code="app.name" /> - CONVERTING LINE 171 - CUSTOMER ROLL TESTING Entry</title>
<style type="text/css">
	
	table td{
		text-align: center;
	}
	table td input[type=text]{
		font-size: 11px !important;
		font-family: sans-serif;
		text-align: center!important;
	}
	table .textbox{
		width: 40px;
	}
</style>

<jsp:include page="../common.jsp"></jsp:include>



<spring:url value="/convertinglinecustomerrolltesting/save" var="saveUrl"/>
<spring:url value="/convertinglinecustomerrolltesting/save/update" var="saveUrlUpdate"/>
<spring:url value="/convertinglinecustomerrolltesting/add" var="convertinglineUrl"/>
<spring:url value="/convertinglinecustomerrolltesting/check" var="checkUrl"/>
<spring:url value="/convertinglinecustomerrolltesting/setnocheck" var="checkRewindUrl"/>
<spring:url value="/convertinglinecustomerrolltesting/delete" var="deleteUrl"/>

<spring:url value="/reel/findmatch" var="findmatchUrl"/>

<script type="text/javascript" src='<spring:url value="/resources/js/rewinder.js"/>'></script>

<script type="text/javascript">
var findmatchUrl='${findmatchUrl}';
var currentValue;
	$(function(){
		
		$('.phyprop').qtip({
			 content: {
				text:function(event, api) {
		           
		            return $(this).next().html();
		        },
			    title: 'Physical Properties'
			  },
			  position: {
			        my: 'bottom center',
			        at: 'top center'
			 }
		});
		
		
		
		
		$('input[name=selectDate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		$('select[name=gradeCode]').change(function(){
			var val=$(this).val();
			if(val!="-1"){
				location.href='${convertinglineUrl}/'+encodeURIComponent(val);
			}
		});
		
		$('#loadBtn').click(function(){
			var date=$('input[name=selectDate]').val();
			var gradeCode=$('select[name=gradeCode]').val();
			var reelNo=$('input[name=reelNo]').val();
			if(date!='' & gradeCode!='-1' & reelNo!='-1'){
				location.href='${convertinglineUrl}/'+encodeURIComponent(gradeCode)+'/'+encodeURIComponent(reelNo);
			}else{
				alert('Please select date or grade code or reel.');
			}
		});
		
		
		$('#rewindTaableBody input[name=actualBasisWt]').focusout(function(){actualBasisWtValidate($(this));});
		$('#rewindTaableBody input[name=bulk]').focusout(function(){bulkValidate($(this));});
		$('#rewindTaableBody input[name=mdTensile]').focusout(function(){mdTensileValidate($(this));});
		$('#rewindTaableBody input[name=cdTensile]').focusout(function(){cdTensileValidate($(this));});
		$('#rewindTaableBody input[name=mdStretch]').focusout(function(){mdStretchValidate($(this));});
		$('#rewindTaableBody input[name=mdcdTensileRatio]').focusout(function(){mdcdTensileRatioValidate($(this));});
		$('#rewindTaableBody input[name=mdWetTensile]').focusout(function(){mdWetTensileValidate($(this));});
		$('#rewindTaableBody input[name=cdWetTensile]').focusout(function(){cdWetTensileValidate($(this));});
		$('#rewindTaableBody input[name=cdTensileRatio]').focusout(function(){cdTensileRatioValidate($(this));});
		$('#rewindTaableBody input[name=brightness]').focusout(function(){brightnessValidate($(this));});
	
		$('#rewindTaableBody input[type=text]').focusout(saveFormData);
		$('#rewindTaableBody select[name=customer]').focusout(saveFormData);
	
		$('#rewindTaableBody input[name=dirtCount]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=absorbencySeconds]').focusout(function(){otherValidate($(this));});
// 		Code Starts From Here Done By Roshan Tailor Date:-03/07/2015   MM/DD/YYYY
		$('#rewindTaableBody input[name=lvalue]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=avalue]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=bvalue]').focusout(function(){otherValidate($(this));});
// 		Code Ends Here Done By Roshan Tailor 
		
		//Code Starts From Here For Finish Good Testing
		/* $('#rewindTaableBody input[name=testingactualBasisWt]').focusout(function(){actualBasisWtValidate($(this));});
		$('#rewindTaableBody input[name=testingbulk]').focusout(function(){bulkValidate($(this));});
		$('#rewindTaableBody input[name=testingmdTensile]').focusout(function(){mdTensileValidate($(this));});
		$('#rewindTaableBody input[name=testingcdTensile]').focusout(function(){cdTensileValidate($(this));});
		$('#rewindTaableBody input[name=testingmdStretch]').focusout(function(){mdStretchValidate($(this));});
		$('#rewindTaableBody input[name=testingmdcdTensileRatio]').focusout(function(){mdcdTensileRatioValidate($(this));});
		$('#rewindTaableBody input[name=testingmdWetTensile]').focusout(function(){mdWetTensileValidate($(this));});
		$('#rewindTaableBody input[name=testingcdWetTensile]').focusout(function(){cdWetTensileValidate($(this));});
		$('#rewindTaableBody input[name=testingcdTensileRatio]').focusout(function(){cdTensileRatioValidate($(this));});
		$('#rewindTaableBody input[name=testingbrightness]').focusout(function(){brightnessValidate($(this));});
	
		$('#rewindTaableBody input[type=text]').focusout(saveFormData);
		$('#rewindTaableBody select[name=testingcustomer]').focusout(saveFormData);
	
		$('#rewindTaableBody input[name=testingdirtCount]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=testingabsorbencySeconds]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=testinglvalue]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=testingavalue]').focusout(function(){otherValidate($(this));});
		$('#rewindTaableBody input[name=testingbvalue]').focusout(function(){otherValidate($(this));}); */
		//Code Ends Here For Finish Good Testing
		//$('#rewindTaableBody input[name=time]').focusout(function(){otherValidate($(this));});
	});
	
	function elelmentId(){
		
		var val=$(this).val();
		if(val!='' & !isNaN(val)){
			var num=parseInt(val, 10);
			if(num==0){
				$(this).val('');
			}
			
		}
		currentValue=$(this).val();
		
		
		var trRow=$(this).parent().parent();
		var md=trRow.find('input[name=mdTensile]').val();
		var cd=trRow.find('input[name=cdTensile]').val();
		trRow.find('input[name=mdcdTensileRatio]').val(coutMDCDRatio(md,cd));
		
		var cdWet=trRow.find('input[name=cdWetTensile]').val();
		trRow.find('input[name=cdTensileRatio]').val(coutCDWetDryRatio(cdWet,cd));
	
	}
	
	function otherValidate(tb){
		if(validate(tb)){return;}
	}
	
	function brightnessValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP02'].rejectMin}",
				minC:"${objective['GP02'].controlMin}",
				target:"${objective['GP02'].target}",
				maxC:"${objective['GP02'].controlMax}",
				maxR:"${objective['GP02'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
	}
	
	function cdTensileRatioValidate(tb){
		if(validate(tb)){return;}
		var data={
				minR:"${objective['GP10'].rejectMin}",
				minC:"${objective['GP10'].controlMin}",
				target:"${objective['GP10'].target}",
				maxC:"${objective['GP10'].controlMax}",
				maxR:"${objective['GP10'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
		
		
	}
	
	function cdWetTensileValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP07'].rejectMin}",
				minC:"${objective['GP07'].controlMin}",
				target:"${objective['GP07'].target}",
				maxC:"${objective['GP07'].controlMax}",
				maxR:"${objective['GP07'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
			
		
	}
	
	function mdWetTensileValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP05'].rejectMin}",
				minC:"${objective['GP05'].controlMin}",
				target:"${objective['GP05'].target}",
				maxC:"${objective['GP05'].controlMax}",
				maxR:"${objective['GP05'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
	
	}
	
	function mdcdTensileRatioValidate(tb){
		if(validate(tb)){return;}
		var data={
				minR:"${objective['GP09'].rejectMin}",
				minC:"${objective['GP09'].controlMin}",
				target:"${objective['GP09'].target}",
				maxC:"${objective['GP09'].controlMax}",
				maxR:"${objective['GP09'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
	
	}
	
	function mdStretchValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP08'].rejectMin}",
				minC:"${objective['GP08'].controlMin}",
				target:"${objective['GP08'].target}",
				maxC:"${objective['GP08'].controlMax}",
				maxR:"${objective['GP08'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
		
	
	}
	
	function cdTensileValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP06'].rejectMin}",
				minC:"${objective['GP06'].controlMin}",
				target:"${objective['GP06'].target}",
				maxC:"${objective['GP06'].controlMax}",
				maxR:"${objective['GP06'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});

	}
	
	function actualBasisWtValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP01'].rejectMin}",
				minC:"${objective['GP01'].controlMin}",
				target:"${objective['GP01'].target}",
				maxC:"${objective['GP01'].controlMax}",
				maxR:"${objective['GP01'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});
	
	}
	
	function mdTensileValidate(tb){
		if(validate(tb)){return;}
		
		var data={
				minR:"${objective['GP04'].rejectMin}",
				minC:"${objective['GP04'].controlMin}",
				target:"${objective['GP04'].target}",
				maxC:"${objective['GP04'].controlMax}",
				maxR:"${objective['GP04'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});

	}
	
	function bulkValidate(tb){
		if(validate(tb)){return;}
		var data={
				minR:"${objective['GP03'].rejectMin}",
				minC:"${objective['GP03'].controlMin}",
				target:"${objective['GP03'].target}",
				maxC:"${objective['GP03'].controlMax}",
				maxR:"${objective['GP03'].rejectMax}",
				value:tb.val()
			};
			//alert(JSON.stringify(data));
			$.ajax({
				url:'${checkUrl}',
				type:'POST',
				data:data,
				success:function(data){
					setBoxColor(tb,data);
				}
			});

	}

	
	function setBoxColor(tb,data){
		
		//alert(data.color);
		
		if(data.color==1){
			if(tb.hasClass('redcolor')){
				tb.removeClass('redcolor');
			}else if(tb.hasClass('greencolor')){
				tb.removeClass('greencolor');
			}else if(tb.hasClass('yellowcolor')){
				tb.removeClass('yellowcolor');
			}
			
			tb.addClass('redcolor');
		}else if(data.color==2){
			if(tb.hasClass('redcolor')){
				tb.removeClass('redcolor');
			}else if(tb.hasClass('greencolor')){
				tb.removeClass('greencolor');
			}else if(tb.hasClass('yellowcolor')){
				tb.removeClass('yellowcolor');
			}
			tb.addClass('yellowcolor');
		}else if(data.color==3){
			if(tb.hasClass('redcolor')){
				tb.removeClass('redcolor');
			}else if(tb.hasClass('greencolor')){
				tb.removeClass('greencolor');
			}else if(tb.hasClass('yellowcolor')){
				tb.removeClass('yellowcolor');
			}
			tb.addClass('greencolor');
		}else if(data.color==0){
			if(tb.hasClass('redcolor')){
				tb.removeClass('redcolor');
			}else if(tb.hasClass('greencolor')){
				tb.removeClass('greencolor');
			}else if(tb.hasClass('yellowcolor')){
				tb.removeClass('yellowcolor');
			}
		}
	}
	
	var saveFormFlag=false;
	function saveFormData(){
	
		
		
		$('#tmessage').text('');
		
		var val=$(this).val();
		if(
			$(this).attr('name')!=='remarks'
			& $(this).attr('name')!=='date'
			& $(this).attr('name')!=='time'
			& $(this).attr('name')!=='gradeCode'
			& $(this).attr('name')!=='reel'
			& $(this).attr('name')!=='customer'
			& $(this).attr('name')!=='setNo'
			& $(this).attr('name')!=='testingremarks'
			& $(this).attr('name')!=='testingdate'
			& $(this).attr('name')!=='testingtime'
			& $(this).attr('name')!=='testinggradeCode'
			& $(this).attr('name')!=='testingreel'
			& $(this).attr('name')!=='testingcustomer'
			& $(this).attr('name')!=='testingsetNo'	
		)
		{
			
			if(val==''){
				$(this).val('0');
			}
		}
		
		
	
		
		if(currentValue!=val){
			
			
			
			var tr=$(this).parent().parent();
			
			var idEle=tr.find('input[name=id]');
			var reelEle=tr.find('input[name=setNo]');
			
			var tr=$(this).parent().parent();
			var id=tr.find('input[name=id]').val();
			var date=tr.find('input[name=date]').val();
			if(date==''){
				return;
			}
			var time=tr.find('input[name=time]').val();
			var timeEle=tr.find('input[name=time]');
			
			if($.trim(time)==''){
				alert('Please enter valid time.');
				tr.find('input[name=time]').focus();
				return;
			}else if(validate(timeEle)){
				return;
			}
			
			
			var RollTesting=tr.find('input[name=RollTesting]').val();
			//alert(RollTesting);
			if(RollTesting=='ParentRollEntry'){
				var gradeCode=tr.find('input[name=gradeCode]').val();
				var reel=tr.find('input[name=reel]').val();
				var setNo=tr.find('input[name=setNo]').val();
				var actualBasisWt=tr.find('input[name=actualBasisWt]').val();
				var bulk=tr.find('input[name=bulk]').val();
				var mdTensile=tr.find('input[name=mdTensile]').val();
				var cdTensile=tr.find('input[name=cdTensile]').val();
				var mdStretch=tr.find('input[name=mdStretch]').val();
				var mdcdTensileRatio=tr.find('input[name=mdcdTensileRatio]').val();
				var mdWetTensile=tr.find('input[name=mdWetTensile]').val();
				var cdWetTensile=tr.find('input[name=cdWetTensile]').val();
				var cdTensileRatio=tr.find('input[name=cdTensileRatio]').val();
				var brightness=tr.find('input[name=brightness]').val();
				var dirtCount=tr.find('input[name=dirtCount]').val();
				var absorbencySeconds=tr.find('input[name=absorbencySeconds]').val();
//	 			Code Starts From Here Done By Roshan Tailor Date:- 03/07/2015 MM/DD/YYYY
				var lvalue=tr.find('input[name=lvalue]').val();
				var avalue=tr.find('input[name=avalue]').val();
				var bvalue=tr.find('input[name=bvalue]').val();
//	 			Code Ends Here Done By Roshan Tailor
				var customer=tr.find('input[name=customer]').val();
				var remarks=tr.find('input[name=remarks]').val();
				
				
				//Code Starts From Here For Finish Good Testing 
				var testinggradeCode=tr.find('input[name=testinggradeCode]').val();
			
				
				var testingreel=tr.find('input[name=testingreel]').val();
				var testingsetNo=tr.find('input[name=testingsetNo]').val();
				var testingactualBasisWt=tr.find('input[name=testingactualBasisWt]').val();
				var testingbulk=tr.find('input[name=testingbulk]').val();
				var testingmdTensile=tr.find('input[name=testingmdTensile]').val();
				var testingcdTensile=tr.find('input[name=testingcdTensile]').val();
				var testingmdStretch=tr.find('input[name=testingmdStretch]').val();
				var testingmdcdTensileRatio=tr.find('input[name=testingmdcdTensileRatio]').val();
				var testingmdWetTensile=tr.find('input[name=testingmdWetTensile]').val();
				var testingcdWetTensile=tr.find('input[name=testingcdWetTensile]').val();
				var testingcdTensileRatio=tr.find('input[name=testingcdTensileRatio]').val();
				var testingbrightness=tr.find('input[name=testingbrightness]').val();
				var testingdirtCount=tr.find('input[name=testingdirtCount]').val();
				var testingabsorbencySeconds=tr.find('input[name=testingabsorbencySeconds]').val();
				var testinglvalue=tr.find('input[name=testinglvalue]').val();
				var testingavalue=tr.find('input[name=testingavalue]').val();
				var testingbvalue=tr.find('input[name=testingbvalue]').val();
				var testingcustomer=tr.find('input[name=testingcustomer]').val();
				var testingremarks=tr.find('input[name=testingremarks]').val();
				//Code Ends Here For Finish Good Testing
				
				var checkboxEle=tr.find('input[name=rowCheckbox]');
				
				if(saveFormFlag){
					return;
				}
//	 			Code Starts From Here Done By Roshan Tailor 
//	 			alert("lValue Is:"+lvalue);
//	 			alert("aValue Is:"+avalue);
//	 			alert("bValue Is:"+bvalue);
//	 			Code Ends Here Done By Roshan  Tailor

				if(setNo!=''){
					saveFormFlag=true;
					$.ajax({
						url:'${saveUrl}',
						type:'POST',
						data:{
							id : id,
							date : date,
							time : time,
							gradeCode : gradeCode,
							reel : reel,
							setNo : setNo,
							actualBasisWt : actualBasisWt,
							bulk : bulk,
							mdTensile : mdTensile,
							cdTensile : cdTensile,
							mdStretch : mdStretch,
							mdcdTensileRatio : mdcdTensileRatio,
							mdWetTensile : mdWetTensile,
							cdWetTensile : cdWetTensile,
							cdTensileRatio : cdTensileRatio,
							brightness : brightness,
							dirtCount : dirtCount,
							absorbencySeconds : absorbencySeconds,
//	 						Code Starts From Here Done By Roshan Tailor Date :- 63/07/2015  MM/DD/2015
							lvalue:lvalue,
							avalue:avalue,
							bvalue:bvalue,
//	 						Code Ends Here Done By Roshan Tailor 	
							customer : customer,
							remarks : remarks,
							//Code Starts From Here For Finish Good Testing
							testinggradeCode : testinggradeCode,
							testingreel : testingreel,
							testingsetNo : testingsetNo,
							testingactualBasisWt : testingactualBasisWt,
							testingbulk : testingbulk,
							testingmdTensile : testingmdTensile,
							testingcdTensile : testingcdTensile,
							testingmdStretch : testingmdStretch,
							testingmdcdTensileRatio : testingmdcdTensileRatio,
							testingmdWetTensile : testingmdWetTensile,
							testingcdWetTensile : testingcdWetTensile,
							testingcdTensileRatio : testingcdTensileRatio,
							testingbrightness : testingbrightness,
							testingdirtCount : testingdirtCount,
							testingabsorbencySeconds : testingabsorbencySeconds,
							testinglvalue:testinglvalue,
							testingavalue:testingavalue,
							testingbvalue:testingbvalue,
							testingcustomer : testingcustomer,
							testingremarks : testingremarks
							//Code Ends Here For Finish Good Testing
							
							
						},
						success:function(data){
						
							saveFormFlag=false;
							if(data.flag){
								idEle.val(data.id);
								checkboxEle.val(data.id);
								$('#tmessage').text('Data saved in database.');	
								if(reelEle.hasClass('redBorder')){
									reelEle.removeClass('redBorder');
									
								}
							}else{
								reelEle.addClass('redBorder');
								alert('Set# '+setNo+' aready exist in database.' );
								
								reelEle.focus();
							}
						
							
						},
						error: function(xhr, status, error) {
							alert('Fail to save data in database. (Reel# '+reel+').Wait!! Reloading Page,and trying again.' );
							location.reload(true);
						}
					});
				}
			}else if(RollTesting='ConvertedRollEntry'){
				
				var gradeCode=tr.find('input[name=gradeCode]').val();
				var reel=tr.find('input[name=reel]').val();
				var setNo=tr.find('input[name=setNo]').val();
				var testingactualBasisWt=tr.find('input[name=testingactualBasisWt]').val();
				var testingbulk=tr.find('input[name=testingbulk]').val();
				var testingmdTensile=tr.find('input[name=testingmdTensile]').val();
				var testingcdTensile=tr.find('input[name=testingcdTensile]').val();
				var testingmdStretch=tr.find('input[name=testingmdStretch]').val();
				var testingmdcdTensileRatio=tr.find('input[name=testingmdcdTensileRatio]').val();
				var testingmdWetTensile=tr.find('input[name=testingmdWetTensile]').val();
				var testingcdWetTensile=tr.find('input[name=testingcdWetTensile]').val();
				var testingcdTensileRatio=tr.find('input[name=testingcdTensileRatio]').val();
				var testingbrightness=tr.find('input[name=testingbrightness]').val();
				var testingdirtCount=tr.find('input[name=testingdirtCount]').val();
				var testingabsorbencySeconds=tr.find('input[name=testingabsorbencySeconds]').val();
				var testinglvalue=tr.find('input[name=testinglvalue]').val();
				var testingavalue=tr.find('input[name=testingavalue]').val();
				var testingbvalue=tr.find('input[name=testingbvalue]').val();
				var testingcustomer=tr.find('input[name=testingcustomer]').val();
				var testingremarks=tr.find('input[name=testingremarks]').val();
				var checkboxEle=tr.find('input[name=rowCheckbox]');
				
				//alert(setNo);
				if(saveFormFlag){
					return;
				}

				if(setNo!=''){
					saveFormFlag=true;
					$.ajax({
						url:'${saveUrlUpdate}',
						type:'POST',
						data:{
							id : id,
							date : date,
							time : time,
							gradeCode : gradeCode,
							reel : reel,
							setNo : setNo,
							testingactualBasisWt : testingactualBasisWt,
							testingbulk : testingbulk,
							testingmdTensile : testingmdTensile,
							testingcdTensile : testingcdTensile,
							testingmdStretch : testingmdStretch,
							testingmdcdTensileRatio : testingmdcdTensileRatio,
							testingmdWetTensile : testingmdWetTensile,
							testingcdWetTensile : testingcdWetTensile,
							testingcdTensileRatio : testingcdTensileRatio,
							testingbrightness : testingbrightness,
							testingdirtCount : testingdirtCount,
							testingabsorbencySeconds : testingabsorbencySeconds,
							testinglvalue:testinglvalue,
							testingavalue:testingavalue,
							testingbvalue:testingbvalue,
							testingcustomer : testingcustomer,
							testingremarks : testingremarks
							
						},
						success:function(data){
						
							saveFormFlag=false;
							if(data.flag){
								idEle.val(data.id);
								checkboxEle.val(data.id);
								$('#tmessage').text('Data saved in database.');	
								if(reelEle.hasClass('redBorder')){
									reelEle.removeClass('redBorder');
									
								}
							}else{
								reelEle.addClass('redBorder');
								alert('Set# '+setNo+' aready exist in database.' );
								
								reelEle.focus();
							}
						
							
						},
						error: function(xhr, status, error) {
							alert('Fail to save data in database. (Reel# '+reel+').Wait!! Reloading Page,and trying again.' );
							location.reload(true);
						}
					});
				}
			
			}
			
			
			
		}
	}	
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='time'){
				var valid1 = (tb.val().search(/^\d{1}:\d{1}$/) != -1);
				var valid2 = (tb.val().search(/^\d{1}:\d{2}$/) != -1);
				var valid3 = (tb.val().search(/^\d{2}:\d{1}$/) != -1);
				var valid4 = (tb.val().search(/^\d{2}:\d{2}$/) != -1);
				if(!(valid1|valid2|valid3|valid4) ){
					alert('Enter a valid time.');
					setTimeout(function(){tb.focus();}, 10);
					saveFormFlag=true;
					return true;
				}
			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				saveFormFlag=true;
				return true;
			}
		}
		saveFormFlag=false;
		return false;
	}
</script>
<spring:url value="/convertinglinecustomerrolltesting/add/row" var="addrowURL"/>
<script type="text/javascript">  
$(function(){
$('#addMoreRow').click(function(){
	var gradeCode=$('select[name=gradeCode]').val();
	var reelNo=$('input[name=reelNo]').val();
	//alert('${addrowURL}/'+encodeURIComponent(gradeCode)+'/'+encodeURIComponent(reelNo));
	window.location.href='${addrowURL}/'+encodeURIComponent(gradeCode)+'/'+encodeURIComponent(reelNo);
				
		});
});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">CONVERTING LINE 171 - CUSTOMER ROLL TESTING Entry</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table style="width: 100%;">
						<tr>
							<td style="text-align: left;">
								Grade Code:
								<select name="gradeCode" style="width: 150px;padding: 1px;">
									<option value="-1">Select</option>
									<c:forEach items="${grades}" var="grade">
										<c:choose>
											<c:when test="${grade.gradeCode eq gradeCode}">
												<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
											</c:when>
											<c:otherwise>
												<option value="${grade.gradeCode}">${grade.gradeCode}</option>
											</c:otherwise>
										</c:choose>
									
										
									</c:forEach>
								</select>
							Reel:
							<%-- <select name="reelNo" style="width: 70px;padding: 1px;">
									<option value="-1">Select</option>
									<c:forEach items="${reels}" var="reel">
										<c:choose>
											<c:when test="${reel eq reelNo}">
												<option value="${reel}" selected="selected">${reel}</option>
											</c:when>
											<c:otherwise>
												<option value="${reel}">${reel}</option>
											</c:otherwise>
										</c:choose>
									
										
									</c:forEach>
								</select> --%>
								<input type="text" name="reelNo" id="reelNo" value="${reelNo}">
								<input type="button" value="Load" id="loadBtn"> 
								&nbsp; <button id="findBtn">Find Reel</button>
								<c:if test="${showForm}">
								<!-- 	&nbsp; <button onclick="window.location.reload(true);">Refresh</button> -->
									<!-- &nbsp; <input type="button" id="addMoreBtn" value="Add More Row"> -->
									&nbsp; <input type="button" id="addMoreRow" value="Add More Row">
									&nbsp; <button id="deleteBtn">Delete</button>
									<security:authorize access="hasRole('ADMIN')">
									 &nbsp; <%-- <button onclick="location.href='<spring:url value="/rewind/add/back"/>'">Backdated Entry</button> --%>
									</security:authorize>
								</c:if>
								
							</td>
							
							<td style=" width: 100px;text-align: right;">
								<c:if test="${showForm}">
							 	<button id="findMatchBtn">Find Match</button>
							 	</c:if>
							 </td>
						</tr>
					</table>
					
					 
					
					
				</div>
				
				
				<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
					<c:if test="${showForm}">
						<span class="error">*</span> Mandatory fields.
					</c:if>
					<table class="table">
						<thead style="font-size: 11px;">
							
							
							<c:if test="${showForm}">
							
							<tr>
								<th style="width:10px;" rowspan="2">
									<!-- <input type="checkbox" name="rowCheckboxAll"> -->
								</th>
								<th style="width:200px;">Date</th>
								<th style="width:200px;">Target</th>
								<th style="width:200px;">Grade Code</th>
								<th style="width:80px;">Reel #</th>
								<th style="width:80px;">Time<span class="error">*</span></th>
								<!-- <th style="width:80px;">Set #<span class="error">*</span></th> -->
								<th style="width:80px;">Actual Basis wt  <br>  lbs /3000ft</th>
								<th style="width:80px;">Bulk  <br>  mils /8 ply</th>
								<th style="width:80px;">MD Tensile <br>  g/inch</th>
								<th style="width:80px;">CD Tensile <br>  g/inch</th>
								<th style="width:80px;">MD %  <br> Stretch</th>
								<th style="width:80px;">MD/CD Tensile Ratio</th>
								<th style="width:80px;">MD Wet Tensile<br> g/inch</th>
								<th style="width:80px;">CD Wet Tensile<br> g/inch</th>
								<th style="width:80px;">CD Tensile Ratio<br> Wet/Dry</th>
								<th style="width:80px;">Bright<br> ness %</th>
								<th style="width:80px;">Dirt Count<br> ppm</th>
								<th style="width:80px;">Absor- bency <br>Sec</th>
<!-- 								Code Starts From Here Done By Roshan Tailor  Date :- 03/05/2015  Format  mm/dd/yyyy-->
								<th style="width:100px;">L Value</th>
								<th style="width:100px;">A Value</th>
								<th style="width:100px;">B Value</th>
<!-- 								Code Ends Here Done By Roshan Tailor -->
								<th style="width:100px;">Customer</th>
								<th>Remarks</th>
							</tr>
							<tr>
								<th class="trobjrow">OBJECTIVE</th>
								<th class="trobjrow"></th>
								<th class="trobjrow">${gradeCode}</th>
								<th class="trobjrow">${reelNo}</th>
								<th class="trobjrow">N/A</th>
								<!-- <th class="trobjrow">N/A</th> -->
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP01'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP01'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP01'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP01'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP01'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP01'].rejectMax}</td>
											</tr>
										</table>
									</div>
								
								
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP03'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP03'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP03'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP03'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP03'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP03'].rejectMax}</td>
											</tr>
										</table>
									</div>
								
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP04'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP04'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP04'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP04'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP04'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP04'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP06'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP06'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP06'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP06'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP06'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP06'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP08'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP08'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP08'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP08'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP08'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP08'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP09'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP09'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP09'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP09'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP09'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP09'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP05'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP05'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP05'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP05'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP05'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP05'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP07'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP07'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP07'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP07'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP07'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP07'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP10'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP10'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP10'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP10'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP10'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP10'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP02'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP02'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP02'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP02'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP02'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP02'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP11'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP11'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP11'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP11'].target - 0.0000}" maxFractionDigits="0"/></td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP11'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP11'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP12'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP12'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP12'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP12'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP12'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP12'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
<!-- 								Code Starts From Here Done By Roshan Tailor Date :- 03/12/2015- -->
<!-- Updated Code Starts From Here -->
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP13'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP13'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP13'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP13'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP13'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP13'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP14'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP14'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP14'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP14'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP14'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP14'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop">${objective['GP15'].target}</a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP15'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP15'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td>${objective['GP15'].target}</td>
											</tr>
											<tr>
												<td>Control Max</td> <td>${objective['GP15'].controlMax}</td>
											</tr>
											<tr>
												<td>Reject Max</td> <td>${objective['GP15'].rejectMax}</td>
											</tr>
										</table>
									</div>
								</th>
<!-- 								Cocde Ends Here Done By Roshan Tailor  -->
<!-- 								Updated Code Ends Here -->
								<th class="trobjrow"></th>
								<th class="trobjrow"></th>
							</tr>
							
							</c:if>
						</thead>
						
						<c:if test="${showForm}">
							
							<c:choose>
								<c:when test="${fn:length(rewinds) gt 0}">
									<tbody id="rewindTaableBody">
									
										<c:forEach items="${rewinds}" var="rewind">
												<tr>
													<td>
														<input type="hidden"value="ParentRollEntry"name="RollTesting">
														<input type="radio" name="rowCheckbox" value="${rewind.id}"> 
													</td>
													<td>
														<input type="hidden" name="id" value="${rewind.id}">
													
														<fmt:formatDate value="${rewind.date}" pattern="MM/dd/yyyy" var="rewinddate"/>
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${rewinddate}" autocomplete="off">
													</td>
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="ParentRoll" value="Parent Roll" autocomplete="off">			
													</td>
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${rewind.gradeCode}" autocomplete="off">			
													</td>
													<td> 
														<input readonly="readonly" type="text" class="textbox" name="reel" value="${rewind.reel}" autocomplete="off">						
													</td>
													<td> 
														<fmt:formatDate value="${rewind.time}" pattern="H:m" var="reeltime"/>
														<input type="text"  class="textbox" name="time" value="${reeltime}"  autocomplete="off">			
														<input style="text-transform: uppercase;" type="hidden" class="textbox" name="setNo" value="${rewind.setNo}" autocomplete="off">	
													</td>
													<%-- <td> 
														<input style="text-transform: uppercase;" type="text" class="textbox" name="setNo" value="${rewind.setNo}" autocomplete="off">						
													</td> --%>
													<td> 
														<input type="text" class="textbox" name="actualBasisWt" value="${rewind.actualBasisWt}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bulk" value="${rewind.bulk}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdTensile" value="${rewind.mdTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensile" value="${rewind.cdTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdStretch" value="${rewind.mdStretch}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdcdTensileRatio" value="${rewind.mdcdTensileRatio}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdWetTensile" value="${rewind.mdWetTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdWetTensile" value="${rewind.cdWetTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensileRatio" value="${rewind.cdTensileRatio}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="brightness" value="${rewind.brightness}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="dirtCount" value="${rewind.dirtCount}" autocomplete="off">						
													</td>
													
													
													<td> 
														<input type="text" class="textbox" name="absorbencySeconds" value="${rewind.absorbencySeconds}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="lvalue" value="${rewind.lvalue}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="avalue" value="${rewind.avalue}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bvalue" value="${rewind.bvalue}" autocomplete="off">						
													</td>
													<td> 
														<%-- <select name="customer" style="width: 100px;padding: 1px;">
															<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																	<c:when test="${customer eq custName}">
<!-- 																		Cose Starts From Here Done By Roshan Tailor Date :-03/11/2015 MM/DD/YYYY -->
<!-- 																			In The Below Code In Added ${rewind.customer} In Both In Value As Well As In Selected Also  -->
																			<option value="${rewind.customer}" selected="selected">${rewind.customer}</option>
<!-- 																			Code Emds From Here Done By Roshan Tailor  -->
																		</c:when>
																		<c:otherwise>
																			<option value="${customer}">${customer}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</select> --%>
															
															<input type="text" name="customer" value="ST Converting" disabled="disabled">
															
														<%-- <input type="text" name="customer" value="${rewind.customer}">	 --%>					
													</td>
													<td> 
														<input type="text" name="remarks" value="${rewind.remarks}">						
													</td>
												</tr>
												<tr>
												
												<!-- This Section is For Finish Good Product Testing, Starts From Here -->
													<td>
														<input type="hidden"value="ConvertedRollEntry"name="RollTesting">
														<input type="radio" name="rowCheckbox" value="${rewind.id}"> 
													</td>
													<td>
														<input type="hidden" name="id" value="${rewind.id}">
													
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${cDate}" autocomplete="off">
													</td>
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="Converted Roll" value="Converted Roll" autocomplete="off">			
													</td>
													<td>
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">	
													</td>
													<td><input readonly="readonly" type="text" class="textbox" name="reel" value="${reelNo}" autocomplete="off"></td>
													<td> 
														<input type="text" class="textbox" name="time" value="${cTime }" autocomplete="off">	
														<input type="hidden" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="${rewind.testingsetNo}" autocomplete="off">						
													</td>
													
													<%-- <td> 
														<input type="text" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="${rewind.testingsetNo}" autocomplete="off">						
													</td> --%>
													<td> 
														<input type="text" class="textbox" name="testingactualBasisWt" value="${rewind.testingactualBasisWt}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbulk" value="${rewind.testingbulk}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdTensile" value="${rewind.testingmdTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdTensile" value="${rewind.testingcdTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdStretch" value="${rewind.testingmdStretch}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdcdTensileRatio" value="${rewind.testingmdcdTensileRatio}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdWetTensile" value="${rewind.testingmdWetTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdWetTensile" value="${rewind.testingcdWetTensile}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdTensileRatio" value="${rewind.testingcdTensileRatio}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbrightness" value="${rewind.testingbrightness}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingdirtCount" value="${rewind.testingdirtCount}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingabsorbencySeconds" value="${rewind.testingabsorbencySeconds}" autocomplete="off">						
													</td>
													
													<td> 
														<input type="text" class="textbox" name="testinglvalue" value="${rewind.testinglvalue}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingavalue" value="${rewind.testingavalue}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbvalue" value="${rewind.testingbvalue}" autocomplete="off">						
													</td>
													<td>
															<input type="text" name="testingcustomer" value="ST Converting" disabled="disabled">
													</td>
													<td> 
														<input type="text" name="testingremarks" value="${rewind.testingremarks}" autocomplete="off">						
													</td>
												</tr>
												<!-- Finish Good Product Section Ends Here -->
										</c:forEach>
										
										<!-- New Conditions To Add A New Row Starts From Here -->
										<!-- Roshan -->
										<c:if test="${addnewrow}">
										<tr>
													<td>
														<input type="hidden"value="ParentRollEntry"name="RollTesting">
														<input type="radio" name="rowCheckbox" value=""> 
													</td>
													<td>
														<input type="hidden" name="id" value="">
													
														<fmt:formatDate value="${date}" pattern="MM/dd/yyyy" var="rewinddate"/>
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${cDate}" autocomplete="off">
													</td>
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="ParentRoll" value="Parent Roll" autocomplete="off">			
													</td>
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">			
													</td>
													<td> 
														<input readonly="readonly" type="text" class="textbox" name="reel" value="${reelNo}" autocomplete="off">						
													</td>
													<td> 
														<fmt:formatDate value="${rewind.time}" pattern="H:m" var="reeltime"/>
														<input type="text"  class="textbox" name="time" value="${cTime}"  autocomplete="off">		
														<input style="text-transform: uppercase;" type="hidden" class="textbox" name="setNo" value="000" autocomplete="off">			
													</td>
													<!-- <td> 
														<input style="text-transform: uppercase;" type="text" class="textbox" name="setNo" value="" autocomplete="off">						
													</td> -->
													<td> 
														<input type="text" class="textbox" name="actualBasisWt" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bulk" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdStretch" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdcdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="brightness" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="dirtCount" value="" autocomplete="off">						
													</td>
													
													
													<td> 
														<input type="text" class="textbox" name="absorbencySeconds" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="lvalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="avalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bvalue" value="" autocomplete="off">						
													</td>
													<td> 
														<%-- <select name="customer" style="width: 100px;padding: 1px;">
															<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																	<c:when test="${customer eq custName}">
<!-- 																		Cose Starts From Here Done By Roshan Tailor Date :-03/11/2015 MM/DD/YYYY -->
<!-- 																			In The Below Code In Added ${rewind.customer} In Both In Value As Well As In Selected Also  -->
																			<option value="${rewind.customer}" selected="selected">${rewind.customer}</option>
<!-- 																			Code Emds From Here Done By Roshan Tailor  -->
																		</c:when>
																		<c:otherwise>
																			<option value="${customer}">${customer}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</select> --%>
															
															<input type="text" name="customer" value="ST Converting" disabled="disabled">
															
														<%-- <input type="text" name="customer" value="${rewind.customer}">	 --%>					
													</td>
													<td> 
														<input type="text" name="remarks" value=""">						
													</td>
												</tr>
												<tr>
												
												<!-- This Section is For Finish Good Product Testing, Starts From Here -->
													<td>
														<input type="hidden"value="ConvertedRollEntry"name="RollTesting">
														<input type="radio" name="rowCheckbox" value=""> 
													</td>
													<td>
														<input type="hidden" name="id" value="">
													
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${cDate}" autocomplete="off">
													</td>
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="Converted Roll" value="Converted Roll" autocomplete="off">			
													</td>
													<td>
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">	
													</td>
													<td><input readonly="readonly" type="text" class="textbox" name="reel" value="${reelNo}" autocomplete="off"></td>
													<td> 
														<input type="text" class="textbox" name="time" value="${cTime }" autocomplete="off">	
														<input type="hidden" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="000" autocomplete="off">							
													</td>
													
													<!-- <td> 
														<input type="text" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="" autocomplete="off">						
													</td> -->
													<td> 
														<input type="text" class="textbox" name="testingactualBasisWt" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbulk" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdStretch" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdcdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbrightness" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingdirtCount" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingabsorbencySeconds" value="" autocomplete="off">						
													</td>
													
													<td> 
														<input type="text" class="textbox" name="testinglvalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingavalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbvalue" value="" autocomplete="off">						
													</td>
													<td>
															<input type="text" name="testingcustomer" value="ST Converting" disabled="disabled">
													</td>
													<td> 
														<input type="text" name="testingremarks" value="" autocomplete="off">						
													</td>
												</tr>
												
												<!-- Finish Good Product Section Ends Here -->
												</c:if>
										<!-- Tailor -->
										<!-- New Conditions To Add A New Row Ends Here -->
								</tbody>
								</c:when>
								<c:otherwise>
									<tbody id="rewindTaableBody">
											<c:forEach begin="1" end="1">
												<tr>
													<td>
														<input type="hidden"value="ParentRollEntry"name="RollTesting">
														<input type="radio" name="rowCheckbox" value=""> 
													</td>
													<td>
														<input type="hidden" name="id" value="">
													
														<fmt:formatDate value="${date}" pattern="MM/dd/yyyy" var="rewinddate"/>
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${cDate}" autocomplete="off">
													</td>
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="ParentRoll" value="Parent Roll" autocomplete="off">			
													</td>
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">			
													</td>
													<td> 
														<input readonly="readonly" type="text" class="textbox" name="reel" value="${reelNo}" autocomplete="off">						
													</td>
													<td> 
														<fmt:formatDate value="${rewind.time}" pattern="H:m" var="reeltime"/>
														<input type="text"  class="textbox" name="time" value="${cTime}"  autocomplete="off">		
														<input style="text-transform: uppercase;" type="hidden" class="textbox" name="setNo" value="000" autocomplete="off">				
													</td>
													<!-- <td> 
														<input style="text-transform: uppercase;" type="text" class="textbox" name="setNo" value="" autocomplete="off">						
													</td> -->
													<td> 
														<input type="text" class="textbox" name="actualBasisWt" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bulk" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdStretch" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdcdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="brightness" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="dirtCount" value="" autocomplete="off">						
													</td>
													
													
													<td> 
														<input type="text" class="textbox" name="absorbencySeconds" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="lvalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="avalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bvalue" value="" autocomplete="off">						
													</td>
													<td> 
														<%-- <select name="customer" style="width: 100px;padding: 1px;">
															<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																	<c:when test="${customer eq custName}">
<!-- 																		Cose Starts From Here Done By Roshan Tailor Date :-03/11/2015 MM/DD/YYYY -->
<!-- 																			In The Below Code In Added ${rewind.customer} In Both In Value As Well As In Selected Also  -->
																			<option value="${rewind.customer}" selected="selected">${rewind.customer}</option>
<!-- 																			Code Emds From Here Done By Roshan Tailor  -->
																		</c:when>
																		<c:otherwise>
																			<option value="${customer}">${customer}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</select> --%>
															
															<input type="text" name="customer" value="ST Converting" disabled="disabled">
															
														<%-- <input type="text" name="customer" value="${rewind.customer}">	 --%>					
													</td>
													<td> 
														<input type="text" name="remarks" value=""">						
													</td>
												</tr>
												<tr>
												
												<!-- This Section is For Finish Good Product Testing, Starts From Here -->
													<td>
														<input type="hidden"value="ConvertedRollEntry"name="RollTesting">
														<input type="radio" name="rowCheckbox" value=""> 
													</td>
													<td>
														<input type="hidden" name="id" value="">
													
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${cDate}" autocomplete="off">
													</td>
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="Converted Roll" value="Converted Roll" autocomplete="off">			
													</td>
													<td>
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">	
													</td>
													<td><input readonly="readonly" type="text" class="textbox" name="reel" value="${reelNo}" autocomplete="off"></td>
													<td> 
														<input type="text" class="textbox" name="time" value="${cTime }" autocomplete="off">		
														<input type="hidden" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="000" autocomplete="off">					
													</td>
													
													<!-- <td> 
														<input type="text" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="" autocomplete="off">						
													</td> -->
													<td> 
														<input type="text" class="textbox" name="testingactualBasisWt" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbulk" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdStretch" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdcdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingmdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdWetTensile" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingcdTensileRatio" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbrightness" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingdirtCount" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingabsorbencySeconds" value="" autocomplete="off">						
													</td>
													
													<td> 
														<input type="text" class="textbox" name="testinglvalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingavalue" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="testingbvalue" value="" autocomplete="off">						
													</td>
													<td>
															<input type="text" name="testingcustomer" value="ST Converting" disabled="disabled">
													</td>
													<td> 
														<input type="text" name="testingremarks" value="" autocomplete="off">						
													</td>
												</tr>
												
												<!-- Finish Good Product Section Ends Here -->
											</c:forEach>
									</tbody>
								</c:otherwise>
							</c:choose>
						</c:if>
					</table>
					
				</div>
				
				 
					<script type="text/javascript">
						$(function(){
							//alert("call1")
							$('#rewindTaableBody tr').each(function(){
								//alert("call2")
								actualBasisWtValidate($(this).find('input[name=actualBasisWt]'));
								bulkValidate($(this).find('input[name=bulk]'));
								mdTensileValidate($(this).find('input[name=mdTensile]'));
								cdTensileValidate($(this).find('input[name=cdTensile]'));
								mdStretchValidate($(this).find('input[name=mdStretch]'));
								mdcdTensileRatioValidate($(this).find('input[name=mdcdTensileRatio]'));
								mdWetTensileValidate($(this).find('input[name=mdWetTensile]'));
								cdWetTensileValidate($(this).find('input[name=cdWetTensile]'));
								cdTensileRatioValidate($(this).find('input[name=cdTensileRatio]'));
								brightnessValidate($(this).find('input[name=brightness]'));
							});
						});
					</script>
				
				 
				
			

				
				<c:if test="${showForm}">
					<script type="text/javascript">
						$(function(){
							$('#rewindTaableBody input[type=text]').bind('focus',elelmentId);
							
							
							$('#deleteBtn').click(function(){
								
								
								var reelId=$('#rewindTaableBody tr input[type=radio]:checked').val();
								if(reelId==''){
									alert('Either row is not available in database or blank.');
								}
							
								if(reelId!=''){
									$.ajax({
										url:'${deleteUrl}',
										type:'POST',
										data:{
											ids : reelId.toString()
										},
										success:function(data){
											if(data.flag){
												alert('Record has been deleted successfully.');
												location.reload(true);
											}	
										}
										
									});
								}
								
							});
							
						});
							
					
					</script>
				</c:if>
				
				<br>
					
				
			</div>

		</div>

	</div>

<spring:url value="/rewind/getCurrentData" var="getCurrentData" />
<script type="text/javascript">
	$(function(){
		$('#addMoreBtn').click(function(){
			
			
			var reelLastId=$('#rewindTaableBody tr:last').find('input[name=id]').val();
			if(!($.isNumeric(reelLastId))){
				$('#rewindTaableBody tr:last').find('input[name=setNo]').focus();
				return false;
			}
			//This Code Is For Parent Roll Testing
			var tr = $('#rewindTaableBody tr:last').clone();
			var tr1 = $('#rewindTaableBody tbody:last').clone();
			var ntr = tr.appendTo($('#rewindTaableBody'));
			
			ntr.find('input[type=text]').val('0');
			
			ntr.find('input[type=text]').removeClass('redcolor');
			ntr.find('input[type=text]').removeClass('yellowcolor');
			ntr.find('input[type=text]').removeClass('greencolor');
			ntr.find('input[name=id]').val('');
			ntr.find('input[name=date]').val('');
			ntr.find('input[name=gradeCode]').val('${gradeCode}');
			
			ntr.find('input[name=reel]').val('${reelNo}');
			
			ntr.find('input[name=customer]').val('ST Converting');
			ntr.find('input[name=ParentRoll]').val('Parent Roll');
			ntr.find('input[name=setNo]').val('');
			ntr.find('input[name=remarks]').val('');
			ntr.find('input[name=rowCheckbox]').val('');
		
			$( "#rewindTaableBody tr:last" ).hide();
			
			$('#rewindTaableBody input[type=text]').unbind('focusout');
		
			
			$('#rewindTaableBody input[name=actualBasisWt]').focusout(function(){actualBasisWtValidate($(this));});
			$('#rewindTaableBody input[name=bulk]').focusout(function(){bulkValidate($(this));});
			$('#rewindTaableBody input[name=mdTensile]').focusout(function(){mdTensileValidate($(this));});
			$('#rewindTaableBody input[name=cdTensile]').focusout(function(){cdTensileValidate($(this));});
			$('#rewindTaableBody input[name=mdStretch]').focusout(function(){mdStretchValidate($(this));});
			$('#rewindTaableBody input[name=mdcdTensileRatio]').focusout(function(){mdcdTensileRatioValidate($(this));});
			$('#rewindTaableBody input[name=mdWetTensile]').focusout(function(){mdWetTensileValidate($(this));});
			$('#rewindTaableBody input[name=cdWetTensile]').focusout(function(){cdWetTensileValidate($(this));});
			$('#rewindTaableBody input[name=cdTensileRatio]').focusout(function(){cdTensileRatioValidate($(this));});
			$('#rewindTaableBody input[name=brightness]').focusout(function(){brightnessValidate($(this));});
			

			$('#rewindTaableBody input[type=text]').bind('focus',elelmentId);
			
			
			$( "#rewindTaableBody tr:last" ).find('input[name=time]').focus();
			
			$('#rewindTaableBody input[type=text]').focusout(saveFormData);
			
			$('#rewindTaableBody select[name=customer]').unbind('focus');
			$('#rewindTaableBody select[name=customer]').focusout(saveFormData);
			
			$('#rewindTaableBody input[name=dirtCount]').focusout(function(){otherValidate($(this));});
			$('#rewindTaableBody input[name=absorbencySeconds]').focusout(function(){otherValidate($(this));});
			$('#rewindTaableBody input[name=lvalue]').focusout(function(){otherValidate($(this));});
			$('#rewindTaableBody input[name=avalue]').focusout(function(){otherValidate($(this));});
			$('#rewindTaableBody input[name=bvalue]').focusout(function(){otherValidate($(this));});
			
			$.ajax({
				url:'${getCurrentData}',
				type:'POST',
				success:function(data){
					$( "#rewindTaableBody tr:last" ).find('input[name=date]').val(data.date);
					$( "#rewindTaableBody tr:last" ).find('input[name=time]').val(data.time);
					$( "#rewindTaableBody tr:last" ).show();
					$('#rewindTaableBody tr:last').find('input[name=setNo]').focus();
				},
				error: function(xhr, status, error) {
					alert('Server error :--');
					location.reload(true);
				}
			});
			
		});
		
	});
	
</script>

<div id="rewindInfoDialog" style="display: none;" title="Find Reel and Set No">
	<iframe id="dialogPage" style="width: 98%; height: inherit; border: none;"></iframe>
</div>

<spring:url value="/rewind/rwindinfo" var="rewindInfoURL"/>

<script type="text/javascript">
	$(function(){
		
		$('#findBtn').click(function(){
			$("#rewindInfoDialog #dialogPage").attr('src', '${rewindInfoURL}');
	        $("#rewindInfoDialog").dialog({
	            width: 700,
	            height: 500,
	            modal: true,
	            close: function () {
	           		$("#rewindInfoDialog #dialogPage").attr('src', "about:blank");
	            }
	        });
		});
	});
</script>

<div class="dialog" id="dialog">
	<div class="dialog-header" id="dialogHeader">
		<div style="float: left">
			<span>Find Match-Reel</span>
		</div>
		<div style="float: right;">
			<a style="color: white;" href="javascript:void(0)" onclick="$('#dialog').hide();">Close</a>
		</div>
		
	</div>
	<div class="dialog-body" id="dialogBody">
		
	
	</div>
</div>
</body>
</html>