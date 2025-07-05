<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />

<title><spring:message code="app.name" /> - Reel Entry PM5</title>
<style type="text/css">
	
	table td{
		text-align: center;
	}
	table td input[type=text]{
		font-size: 12px;
		font-family: sans-serif;
		text-align: center!important;
	}
	table .textbox{
		width: 40px;
	}
</style>

<jsp:include page="../common.jsp"></jsp:include>



<spring:url value="/pm5reel/add/back" var="reelUrl"/>
<spring:url value="/pm5reel/check" var="checkUrl"/>
<spring:url value="/pm5reel/reelnocheck" var="checkReelUrl"/>
<spring:url value="/pm5reel/delete" var="deleteUrl"/>

<spring:url value="/pm5reel/save" var="saveUrl"/>
<spring:url value="/pm5reel/findmatch" var="findmatchUrl"/>

<spring:url value="/pm5reel/brightness/info" var="brightnessInfoUrl"/>

<script type="text/javascript" src='<spring:url value="/dist/js/old/reel.js"/>'></script>

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
		
		$('#loadBtn').click(function(){
			var date=$('input[name=selectDate]').val();
			var gradeCode=$('select[name=gradeCode]').val();
			if(date!='' & gradeCode!='-1'){
				location.href='${reelUrl}/'+encodeURIComponent(date)+'/'+encodeURIComponent(gradeCode);
			}else{
				alert('Please select date or grade code.');
			}
		});
		
		
		$('#reelTaableBody input[name=actualBasisWt]').focusout(function(){actualBasisWtValidate($(this));});
		$('#reelTaableBody input[name=bulk]').focusout(function(){bulkValidate($(this));});
		$('#reelTaableBody input[name=mdTensile]').focusout(function(){mdTensileValidate($(this));});
		$('#reelTaableBody input[name=cdTensile]').focusout(function(){cdTensileValidate($(this));});
		$('#reelTaableBody input[name=mdStretch]').focusout(function(){mdStretchValidate($(this));});
		$('#reelTaableBody input[name=mdcdTensileRatio]').focusout(function(){mdcdTensileRatioValidate($(this));});
		$('#reelTaableBody input[name=mdWetTensile]').focusout(function(){mdWetTensileValidate($(this));});
		$('#reelTaableBody input[name=cdWetTensile]').focusout(function(){cdWetTensileValidate($(this));});
		$('#reelTaableBody input[name=cdTensileRatio]').focusout(function(){cdTensileRatioValidate($(this));});
		$('#reelTaableBody input[name=brightness]').focusout(function(){brightnessValidate($(this));});
		
		$('#reelTaableBody input[type=text]').focusout(saveFormData);
		$('#reelTaableBody select[name=customer]').focusout(saveFormData);
		
		
		$('#reelTaableBody input[name=scannerBasisWt]').focusout(function(){otherValidate($(this));});
		$('#reelTaableBody input[name=fwaFlow]').focusout(function(){otherValidate($(this));});
		$('#reelTaableBody input[name=dirtCount]').focusout(function(){otherValidate($(this));});
		$('#reelTaableBody input[name=tph]').focusout(function(){otherValidate($(this));});
		$('#reelTaableBody input[name=trim]').focusout(function(){otherValidate($(this));});
		$('#reelTaableBody input[name=crepeRatio]').focusout(function(){otherValidate($(this));});
		//$('#reelTaableBody input[name=time]').focusout(function(){otherValidate($(this));});
		
		getBrightnessAvg();
	});

	
	function getBrightnessAvg(){
		$.ajax({
			url:'${brightnessInfoUrl}',
			type:'POST',
			success:function(data){
				$('#frpBrightnessAvg').text(data.frpBrightnessAvg);
				$('#machBrightnessAvg').text(data.machBrightnessAvg);
				setTimeout(function(){getBrightnessAvg();}, 1000*60*15);
			},
			error:function(){
				setTimeout(function(){getBrightnessAvg();}, 1000*60*15);
			}
		});
	}
	
	function elelmentId(e){
		
		var val=$(this).val();
		if(val!='' & !isNaN(val)){
			var num=parseInt(val, 10);
			if(num==0){
				$(this).val('');
			}
			
		}

		
		currentValue=$(this).val();
		
		
		//
		var trRow=$(this).parent().parent();
		var md=trRow.find('input[name=mdTensile]').val();
		var cd=trRow.find('input[name=cdTensile]').val();
		trRow.find('input[name=mdcdTensileRatio]').val(coutMDCDRatio(md,cd));
		
		var cdWet=trRow.find('input[name=cdWetTensile]').val();
		trRow.find('input[name=cdTensileRatio]').val(coutCDWetDryRatio(cdWet,cd));
		
		var fwaP=trRow.find('input[name=fwaFlow]').val();
		var tphP=trRow.find('input[name=tph]').val();
		//trRow.find('input[name=fwaDosage]').val(countFwaDosage(fwaP,tphP)); //Commented By Roshan Tailor Date:- 01-19-2016  MM-DD-YYYY
		
		
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
		
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP10'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP07'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP05'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP09'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP08'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP06'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP01'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP04'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		
		/* $.ajax({
			url:'${checkUrl}',
			type:'POST',
			data:{
				value:tb.val(),
				grade:$('input[name=gradeCodeR]').val(),
				prop:'GP03'
			},
			success:function(data){
				setBoxColor(tb,data);
			}
		}); */
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
		//$('#setError').text('');
		
		var val=$(this).val();
		
		if($(this).attr('name')!=='remarks'
			& $(this).attr('name')!=='date'
			& $(this).attr('name')!=='time'
			& $(this).attr('name')!=='gradeCode'
			& $(this).attr('name')!=='reel'
			& $(this).attr('name')!=='customer'){
			
			if(val==''){
				$(this).val('0');
			}
		}
		
		if(currentValue!=val){
			
		
			
			var tr=$(this).parent().parent();
			
			var idEle=tr.find('input[name=id]');
			var reelEle=tr.find('input[name=reel]');
			
			var id=tr.find('input[name=id]').val();
			var date=tr.find('input[name=date]').val();
			if(date==''){
				return;
			}
			
			
			var gradeCode=tr.find('input[name=gradeCode]').val();
			var reel=tr.find('input[name=reel]').val();
			
			if(validate(tr.find('input[name=reel]'))){return;}
			
			var time=tr.find('input[name=time]').val();
			var timeEle=tr.find('input[name=time]');
			
			if($.trim(time)=='' | $.trim(reel)==''){
				return;
			}else if(validate(timeEle)){
				return;
			}
			
			var scannerBasisWt=tr.find('input[name=scannerBasisWt]').val();
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
			var fwaFlow=tr.find('input[name=fwaFlow]').val();
			var dirtCount=tr.find('input[name=dirtCount]').val();
			var fwaDosage=tr.find('input[name=fwaDosage]').val();
			var tph=tr.find('input[name=tph]').val();
			var trim=tr.find('input[name=trim]').val();
			var crepeRatio=tr.find('input[name=crepeRatio]').val();
			var customer=tr.find('select[name=customer]').val();
			var remarks=tr.find('input[name=remarks]').val();
			
			//var enterAutoFlag=$('input[name=enterAutoFlag]').val();
			//var elementIndex=$('input[name=elementIndex]').val();
			
			
			var checkboxEle=tr.find('input[name=rowCheckbox]');
			
			if(saveFormFlag){
				return;
			}
			
			/* var ids=[];
			$('#reelTaableBody input[name=id]').each(function(){
				ids.push($(this).val());
			});
			 */
			
			
			if(reel!=''){
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
						scannerBasisWt : scannerBasisWt,
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
						fwaFlow : fwaFlow,
						dirtCount : dirtCount,
						fwaDosage : fwaDosage,
						tph : tph,
						trim : trim,
						crepeRatio : crepeRatio,
						customer : customer,
						remarks : remarks
						//enterAutoFlag : enterAutoFlag,
						//elementIndex : elementIndex,
						//ids:ids.toString()
					},
					success:function(data){
						
						saveFormFlag=false;
						if(data.flag){
							idEle.val(data.id);
							checkboxEle.val(data.id);
							$('#tmessage').text('Data saved in database.');	
							if(reelEle.hasClass('redBorder')){
								reelEle.removeClass('redBorder');
								//$('#setError').text('');
							}
						}else{
							alert(data.error);
							if(data.field=='time'){
								timeEle.focus();
							}else{
								reelEle.addClass('redBorder');
								reelEle.focus();	
							}
						}
					
						
					},
					error: function(xhr, status, error) {
						alert('Fail to save data in database. (Reel# '+reel+')' );
						location.reload(true);
					}
				});
			}
			
			
		}
	}
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='remarks'|tb.attr('name')=='date'){
				return false;
			}else if(tb.attr('name')=='time'){
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
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
			<div
					          class="content-header"
					          style="
					            padding-top: 10px !important;
					            padding-bottom: 0px !important;
					            line-height: 0px !important;
					          "
					><h5 style="text-align:center; font-weight:bold;color:#343e70;">Quality Data Entry-Reel Testing For PM5</h5></div>
<input type="hidden" id="maxReel" value="${maxReel}">
<!-- Dailog -->
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
	<!--<div class="container">-->

		<div class="block3" id="block3">
			<div class="pageContent">
				<div class="table-selector" style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">
					
					<table style="width: 100%;">
						<tr>
							<td style="text-align: left;">
							Date:
							<input readonly="readonly" type="text" value="${date}" style="width: 100px;" name="selectDate" >
							Grade Code:

								<select name="gradeCode" style="width: 130px;padding: 1px;">
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
							
							<input type="button" value="Load" id="loadBtn" class="btn btn-success btn-sm"> 
							&nbsp; <button id="findBtn"class="btn btn-info btn-sm" >Find Reel</button>
							<c:if test="${showForm}">
							<!--  &nbsp; <button onclick="window.location.reload(true);">Refresh</button> -->
							 &nbsp; <button id="addMoreBtn"class="btn btn-success btn-sm">Add More Row</button>
							 &nbsp; <button id="deleteBtn" class="btn btn-danger btn-sm">Delete</button>
							<!-- &nbsp;&nbsp;
							<div style="display: inline-block;">
								<b>FRP Brightness : </b><span id="frpBrightnessAvg"></span>
								&nbsp;|&nbsp;
								<b>Machine Brightness : </b><span id="machBrightnessAvg"></span>
							</div>-->
							</c:if>
							 </td>
							 <td style=" text-align: right;width: 200px;">
							 	<c:if test="${showForm}">
							 		<button id="findMatchBtn"class="btn btn-info btn-sm">Find Match</button>
							 	</c:if>
							 </td>
						</tr>
					</table>

				</div>
				
					
				<div style="padding: 2px; overflow: auto;bottom: 0;left: 5px;right: 5px;top: 150px;">
					<c:if test="${showForm}">
					<span class="error" style="color:red">*</span> <span class="error" style="color:red"> Mandatory fields.</span>
					</c:if>
					<table class="table">
						<thead style="font-size: 12px;">
							
							
							<c:if test="${showForm}">
							
							<tr>
								<th style="width:10px;" rowspan="2">
									<!-- <input type="checkbox" name="rowCheckboxAll"> -->
								</th>
								<th style="width:200px;">Date</th>
								<th style="width:200px;">Grade Code</th>
								<th style="width:80px;">Reel # <span class="error">*</span></th>
								<th style="width:80px;">Time<span class="error">*</span></th>
								<th style="width:80px;">Scanner Basis wt <br> lbs /3000ft</th>
								<th style="width:80px;">Actual Basis wt  <br>  lbs /3000ft</th>
								<th style="width:80px;">Bulk  <br>  mils/8 ply</th>
								<th style="width:80px;">MD Tensile <br>  g/inch</th>
								<th style="width:80px;">CD Tensile <br>  g/inch</th>
								<th style="width:80px;">MD %  <br> Stretch</th>
								<th style="width:80px;">MD/CD Tensile Ratio</th>
								<th style="width:80px;">MD Wet Tensile<br> g/inch</th>
								<th style="width:80px;">CD Wet Tensile<br> g/inch</th>
								<th style="width:80px;">CD Tensile Ratio<br> Wet/Dry</th>
								<th style="width:80px;">Bright<br> ness %</th>
								<th style="width:80px;">FWA Flow<br> (ml/min)</th>
								<th style="width:80px;">Dirt Count<br> ppm</th>
								<!-- <th style="width:80px;">FWA Dosage<br> lb/Ton</th> -->
								<th style="width:80px;">Moisture %</th>
<!-- 								Above Tag Line Name Has Been Changed By Roshan Tailor Date :- 19-01-2016 -->
								<th style="width:80px;">TPH</th>
								<th style="width:80px;">Trim</th>
								<th style="width:80px;">Crepe Ratio</th>
								<th style="width:100px;">Customer</th>
								<th>Remarks</th>
							</tr>
							
							<tr style="text-align:center">
								<th class="trobjrow">OBJECTIVE</th>
								<th class="trobjrow">${gradeCode}</th>
								<th class="trobjrow"></th>
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">N/A</th>
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
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">
									<a href="javascript:void(0)" class="phyprop"><fmt:formatNumber value="${objective['GP011'].target - 0.0000}" maxFractionDigits="0"/></a>
									<div style="display: none; font-size: 14px;">
										<table>
											<tr>
												<td>Reject Min</td> <td>${objective['GP11'].rejectMin}</td>
											</tr>
											<tr>
												<td>Control Min</td> <td>${objective['GP11'].controlMin}</td>
											</tr>
											<tr>
												<td>Target</td> <td><fmt:formatNumber value="${objective['GP011'].target - 0.0000}" maxFractionDigits="0"/></td>
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
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">N/A</th>
								<th class="trobjrow">N/A</th>
							</tr>
							
							</c:if>
						</thead>
						
						<c:if test="${showForm}">
							
							<c:choose>
								<c:when test="${fn:length(reels) gt 0}">
									<tbody id="reelTaableBody">
									
										<c:forEach items="${reels}" var="reel">
											
												<tr>
													<td>
														<input type="radio" name="rowCheckbox" value="${reel.id}"> 
													</td>
													<td>
														<input type="hidden" name="id" value="${reel.id}">
													
														<fmt:formatDate value="${reel.date}" pattern="MM/dd/yyyy" var="reeldate"/>
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${reeldate}"  autocomplete="off"></td>
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${reel.gradeCode}"  autocomplete="off">			
													</td>
													<td> 
														<input  type="text" class="textbox" name="reel" value="${reel.reel}"  autocomplete="off">						
													</td>
													<td>
														<fmt:formatDate value="${reel.time}" pattern="H:m" var="reeltime"/>
														<input type="text"  class="textbox" name="time" value="${reeltime}"  autocomplete="off">
													</td>
													<td> 
														<input type="text" class="textbox" name="scannerBasisWt" value="${reel.scannerBasisWt}"  autocomplete="off">						
													</td>
													
													<td> 
														<input type="text" class="textbox" name="actualBasisWt" value="${reel.actualBasisWt}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="bulk" value="${reel.bulk}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdTensile" value="${reel.mdTensile}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensile" value="${reel.cdTensile}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdStretch" value="${reel.mdStretch}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdcdTensileRatio" value="${reel.mdcdTensileRatio}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="mdWetTensile" value="${reel.mdWetTensile}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdWetTensile" value="${reel.cdWetTensile}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cdTensileRatio" value="${reel.wetDryRatio}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="brightness" value="${reel.brightness}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="fwaFlow" value="${reel.fwaFlow}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="dirtCount" value="${reel.dirtCount}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="fwaDosage" value="${reel.fwaDosage}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="tph" value="${reel.tph}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="trim" value="${reel.trim}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="crepeRatio" value="${reel.crepeRatio}"  autocomplete="off">						
													</td>
													<td> 
														<select name="customer" style="width: 100px;padding: 1px;">
															<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																		<c:when test="${customer eq reel.customer}">
																			<option value="${customer}" selected="selected">${customer}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${customer}">${customer}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</select>

															<%-- <input type="text" name="customer" value="${reel.customer}">	 --%>					
													</td>
													<td> 
														<input type="text" name="remarks" value="${reel.remarks}">						
													</td>
												</tr>
										</c:forEach>
								</tbody>
								</c:when>
								<c:otherwise>
									<tbody id="reelTaableBody">
											<c:forEach begin="1" end="1">
												<tr>
													<td>
														<input type="radio" name="rowCheckbox" value="">
													</td>
													<td>
														<input type="hidden" name="id">
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${formatedDate}" autocomplete="off"></td>
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">			
													</td>
													<td> 
														<input type="text" class="textbox newreel" name="reel" value="" autocomplete="off">						
													</td>
													<td>
														<input type="text" class="textbox" name="time" value="" autocomplete="off">
													</td>
													<td> 
														<input type="text" class="textbox" name="scannerBasisWt" value="" autocomplete="off">						
													</td>
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
														<input type="text" class="textbox" name="fwaFlow" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="dirtCount" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="fwaDosage" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="tph" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="trim" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="crepeRatio" value="" autocomplete="off">						
													</td>
													<td> 
															<select name="customer" style="width: 100px;padding: 1px;">
																<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<option value="${customer}">${customer}</option>
																</c:forEach>
															</select>
														<!-- <input type="text" name="customer" value="" autocomplete="off"> -->						
													</td>
													<td> 
														<input type="text" name="remarks" value="" autocomplete="off">						
													</td>
												</tr>
											</c:forEach>
									</tbody>
								</c:otherwise>
							</c:choose>
						</c:if>
					</table>
				
				</div>
				
				<c:if test="${fn:length(reels) gt 0}">
					<script type="text/javascript">
						$(function(){
							$('#reelTaableBody tr').each(function(){
								
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
				
				</c:if>
				
				
				<c:if test="${showForm}">
					<!-- <input type="submit" value="Save" id="saveReelFormBtn">  -->
					
					<%-- <input type="hidden" name="elementIndex" value="${elementIndex}">
					<input type="hidden" name=trIndex value="${trIndex}">
					<input type="hidden" name="tdIndex" value="${tdIndex}">
					<input type="hidden" name="gradeCodeR" value="${gradeCode}"> --%>
					<input type="hidden" name="formatedDate" value="${formatedDate}">
				</c:if>
				
				
				<c:if test="${showForm}">
					<script type="text/javascript">
						$(function(){
							$('#reelTaableBody input[type=text]').bind('focus',elelmentId);
							$('#reelTaableBody tr').eq($('input[name=trIndex]').val()).find('td').eq($('input[name=tdIndex]').val()).find('input').focus();
							
					
							
							$('#deleteBtn').click(function(){
								/* var reelId=[];
								$('#reelTaableBody tr input[type=radio]').each(function(){
									if($(this).prop('checked')){
										if($(this).val()!=''){
											reelId.push($(this).val());
										}
										
									}
								}); */
								var reelId=$('#reelTaableBody tr input[type=radio]:checked').val();
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
												location.href=location.href;
											}	
										}
										
									});
								}
								
							});
							
						});

					</script>
				</c:if>
				
				<br>
				<table style="width: 100%;">
					<tr>
						<td><span class="message" id="message">${message}</span></td>
						<td><span class="error">${error}</span></td>
						<td><span class="error" id="setError"></span></td>
					</tr>
				</table>
				
				
			</div>

		</div>

	</div>
<spring:url value="/pm5reel/getCurrentData" var="getCurrentData" />	
<script type="text/javascript">
	$(function(){
		$('#addMoreBtn').click(function(){
			var reelLastId=$('#reelTaableBody tr:last').find('input[name=id]').val();
			if(!($.isNumeric(reelLastId))){
				$('#reelTaableBody tr:last').find('input[name=reel]').focus();
				return false;
			}
			

			var tr = $('#reelTaableBody tr:last').clone();

			var ntr = tr.appendTo($('#reelTaableBody'));
			
			ntr.find('input[type=text]').val('0');
			
			ntr.find('input[type=text]').removeClass('redcolor');
			ntr.find('input[type=text]').removeClass('yellowcolor');
			ntr.find('input[type=text]').removeClass('greencolor');
			ntr.find('input[name=id]').val('');
			ntr.find('input[name=time]').val('');
			ntr.find('input[name=reel]').val('');
			ntr.find('input[name=date]').val('${formatedDate}');
			ntr.find('input[name=gradeCode]').val('${gradeCode}');
			//ntr.find('select[name=customer]').val('');
			ntr.find('input[name=remarks]').val('');
			ntr.find('input[name=rowCheckbox]').val('');
			
			
			$( "#reelTaableBody tr:last" ).hide();
			
			
			$('#reelTaableBody input[type=text]').unbind('focusout');
			
			$('#reelTaableBody input[name=actualBasisWt]').focusout(function(){actualBasisWtValidate($(this));});
			$('#reelTaableBody input[name=bulk]').focusout(function(){bulkValidate($(this));});
			$('#reelTaableBody input[name=mdTensile]').focusout(function(){mdTensileValidate($(this));});
			$('#reelTaableBody input[name=cdTensile]').focusout(function(){cdTensileValidate($(this));});
			$('#reelTaableBody input[name=mdStretch]').focusout(function(){mdStretchValidate($(this));});
			$('#reelTaableBody input[name=mdcdTensileRatio]').focusout(function(){mdcdTensileRatioValidate($(this));});
			$('#reelTaableBody input[name=mdWetTensile]').focusout(function(){mdWetTensileValidate($(this));});
			$('#reelTaableBody input[name=cdWetTensile]').focusout(function(){cdWetTensileValidate($(this));});
			$('#reelTaableBody input[name=cdTensileRatio]').focusout(function(){cdTensileRatioValidate($(this));});
			$('#reelTaableBody input[name=brightness]').focusout(function(){brightnessValidate($(this));});
			

			$('#reelTaableBody input[type=text]').unbind('focus');
			$('#reelTaableBody input[type=text]').bind('focus',elelmentId);
			
			
			
			$('#reelTaableBody input[type=text]').focusout(saveFormData);
			
			$('#reelTaableBody select[name=customer]').unbind('focus');
			$('#reelTaableBody select[name=customer]').focusout(saveFormData);
			
			
			$('#reelTaableBody input[name=scannerBasisWt]').focusout(function(){otherValidate($(this));});
			$('#reelTaableBody input[name=fwaFlow]').focusout(function(){otherValidate($(this));});
			$('#reelTaableBody input[name=dirtCount]').focusout(function(){otherValidate($(this));});
			$('#reelTaableBody input[name=tph]').focusout(function(){otherValidate($(this));});
			$('#reelTaableBody input[name=trim]').focusout(function(){otherValidate($(this));});
			$('#reelTaableBody input[name=crepeRatio]').focusout(function(){otherValidate($(this));});
			//$('#reelTaableBody input[name=time]').focusout(function(){otherValidate($(this));});
			$( "#reelTaableBody tr:last" ).show();
			$( "#reelTaableBody tr:last" ).find('input[name=reel]').focus();
		});
		
	});
	
</script>



<div id="reelInfoDialog" style="display: none;" title="Find Reel">
	<iframe id="dialogPage" style="width: 98%; height: inherit;border: none;"></iframe>
</div>

<spring:url value="/pm5reel/reelinfo" var="reelInfoUrl"/>

<script type="text/javascript">
	$(function(){
		$('#findBtn').click(function(){
			$("#reelInfoDialog #dialogPage").attr('src', '${reelInfoUrl}');
	        $("#reelInfoDialog").dialog({
	            width: 500,
	            height: 400,
	            modal: true,
	            close: function () {
	                $("#reelInfoDialog #dialogPage").attr('src', "about:blank");
	            }
	        });
		});
	});

</script>



</div>
<!-- /.content-wrapper -->
                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
                   </footer>
</div>
</body>
</html>
