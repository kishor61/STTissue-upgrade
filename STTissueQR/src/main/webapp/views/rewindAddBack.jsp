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
<title><spring:message code="app.name" /> - Rewinder Entry</title>
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

<jsp:include page="common.jsp"></jsp:include>



<spring:url value="/rewind/save" var="saveUrl"/>
<spring:url value="/rewind/add/back" var="rewindUrl"/>
<spring:url value="/rewind/check" var="checkUrl"/>
<spring:url value="/rewind/setnocheck" var="checkRewindUrl"/>
<spring:url value="/rewind/delete" var="deleteUrl"/>

<spring:url value="/reel/findmatch" var="findmatchUrl"/>

<script type="text/javascript" src='<spring:url value="/dist/js/old/rewinder.js"/>'></script>

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
				location.href='${rewindUrl}/'+encodeURIComponent(val);
			}
		});
		
		$('#loadBtn').click(function(){
			var date=$('input[name=selectDate]').val();
			var gradeCode=$('select[name=gradeCode]').val();
			var reelNo=$('select[name=reelNo]').val();
			if(date!='' & gradeCode!='-1' & reelNo!='-1'){
				location.href='${rewindUrl}/'+encodeURIComponent(date)+'/'+encodeURIComponent(gradeCode)+'/'+encodeURIComponent(reelNo);
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
		if($(this).attr('name')!=='remarks'
			& $(this).attr('name')!=='date'
			& $(this).attr('name')!=='time'
			& $(this).attr('name')!=='gradeCode'
			& $(this).attr('name')!=='reel'
			& $(this).attr('name')!=='customer'
			& $(this).attr('name')!=='setNo'){
			
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
			
			
			
			var gradeCode=tr.find('input[name=gradeCode]').val();
			var reel=tr.find('input[name=reel]').val();
			var setNo=tr.find('input[name=setNo]').val();
			
			if($.trim(time)=='' | $.trim(setNo)==''){
				
				return;
			}else if(validate(timeEle)){
				return;
			}
			
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
			var customer=tr.find('select[name=customer]').val();
			var remarks=tr.find('input[name=remarks]').val();
			
			
			var checkboxEle=tr.find('input[name=rowCheckbox]');
			
			if(saveFormFlag){
				return;
			}
			
			
			
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
						customer : customer,
						remarks : remarks
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
						alert('Fail to save data in database. (Reel# '+reel+')' );
						location.reload(true);
					}
				});
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
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
			<div
					          class="content-header"
					          style="
					            padding-top: 10px !important;
					            padding-bottom: 0px !important;
					            line-height: 0px !important;
					          "
					><h5 style="text-align:center; font-weight:bold;color:#343e70;">Quality Data BACKDATED ENTRY-Rewind Testing</h5></div>

				
				<div class="table-selector"style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">
					
					<table style="width: 100%;">
						<tr >
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
							<select name="reelNo" style="width: 70px;padding: 1px;">
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
								</select>
							Date:
							<input type="text" value="${date}" style="width: 80px;" name="selectDate" >
							
								<input type="button" value="Load"  class="btn btn-success btn-sm" id="loadBtn"> 
								&nbsp; <button id="findBtn"class="btn btn-info btn-sm">Find Reel</button>
								<c:if test="${showForm}">
								<!-- 	&nbsp; <button onclick="window.location.reload(true);">Refresh</button> -->
									&nbsp; <input type="button" id="addMoreBtn" class="btn btn-success btn-sm" value="Add More Row">
									&nbsp; <button id="deleteBtn" class="btn btn-danger btn-sm">Delete</button>
								</c:if>	
								
							</td>
						
							<td style="width:100px; text-align: right;">
								<c:if test="${showForm}">
							 	<button id="findMatchBtn" class="btn btn-info btn-sm">Find Match</button>
							 	</c:if>
							 </td>
						</tr>
					</table>
					
					 
					
					
				</div>
				
				<div style="padding: 2px; overflow: auto; bottom: 0;left: 5px;right: 5px;top: 150px;">
					<c:if test="${showForm}">
					<span class="error" style="color:red">*</span> <span class="error" style="color:red"> Mandatory fields.</span>
					</c:if>
					
					
					
					<table class="table">
						<thead style="font-size: 11px;">
							
							
							<c:if test="${showForm}">
							
							<tr>
								<th style="width:10px;" rowspan="2">
									<!-- <input type="checkbox" name="rowCheckboxAll"> -->
								</th>
								<th style="width:200px;">Date</th>
								<th style="width:200px;">Grade Code</th>
								<th style="width:80px;">Reel #</th>
								<th style="width:80px;">Time<span class="error">*</span></th>
								<th style="width:80px;">Set #<span class="error">*</span></th>
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
								<th style="width:100px;">Customer</th>
								<th>Remarks</th>
							</tr>
							<tr style="text-align:center">
								<th class="trobjrow">OBJECTIVE</th>
								<th class="trobjrow">${gradeCode}</th>
								<th class="trobjrow">${reelNo}</th>
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
														<input type="radio" name="rowCheckbox" value="${rewind.id}"> 
													</td>
													<td>
														<input type="hidden" name="id" value="${rewind.id}">
													
														<fmt:formatDate value="${rewind.date}" pattern="MM/dd/yyyy" var="rewinddate"/>
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${rewinddate}" autocomplete="off"></td>
													
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${rewind.gradeCode}" autocomplete="off">			
													</td>
													<td> 
														<input readonly="readonly" type="text" class="textbox" name="reel" value="${rewind.reel}" autocomplete="off">						
													</td>
													<td> 
														<fmt:formatDate value="${rewind.time}" pattern="H:m" var="reeltime"/>
														<input type="text"  class="textbox" name="time" value="${reeltime}"  autocomplete="off">			
													</td>
													<td> 
														<input style="text-transform: uppercase;" type="text" class="textbox" name="setNo" value="${rewind.setNo}" autocomplete="off">						
													</td>
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
														<select name="customer" style="width: 100px;padding: 1px;">
															<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																		<c:when test="${customer eq custName}">
																			<option value="${customer}" selected="selected">${customer}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${customer}">${customer}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</select>
														<%-- <input type="text" name="customer" value="${rewind.customer}">	 --%>					
													</td>
													<td> 
														<input type="text" name="remarks" value="${rewind.remarks}">						
													</td>
												</tr>
										</c:forEach>
								</tbody>
								</c:when>
								<c:otherwise>
									<tbody id="rewindTaableBody">
											<c:forEach begin="1" end="1">
												<tr>
													<td>
														<input type="radio" name="rowCheckbox" value="">
													</td>
													<td>
														<input type="hidden" name="id" value="">
													
														<input readonly="readonly" type="text" style="width: 70px;" name="date" value="${formatedDate}" autocomplete="off"></td>
													
													
													<td> 
														<input readonly="readonly" type="text" style="width: 90px;" name="gradeCode" value="${gradeCode}" autocomplete="off">			
													</td>
													
													<td> 
														<input readonly="readonly" type="text" class="textbox" name="reel" value="${reelNo}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="time" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" style="text-transform: uppercase;" class="textbox newreel" name="setNo" value="" autocomplete="off">						
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
														<input type="text" class="textbox" name="dirtCount" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="absorbencySeconds" value="" autocomplete="off">						
													</td>
													<td>
														<select name="customer" style="width: 100px;padding: 1px;">
																<option value="">Select</option>
																
																
																
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																		<c:when test="${customer == custName}">
																			<option value="${customer}" selected="selected">${customer}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${customer}">${customer}</option>
																		</c:otherwise>
																	</c:choose>
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
							$('#rewindTaableBody tr').each(function(){
								
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
<script type="text/javascript">
		$(function(){
			$('#addMoreBtn').click(function(){
				
				var reelLastId=$('#rewindTaableBody tr:last').find('input[name=id]').val();
				if(!($.isNumeric(reelLastId))){
					$('#rewindTaableBody tr:last').find('input[name=setNo]').focus();
					return false;
				}
				
				var tr = $('#rewindTaableBody tr:last').clone();

				var ntr = tr.appendTo($('#rewindTaableBody'));
				
				ntr.find('input[type=text]').val('0');
				
				ntr.find('input[type=text]').removeClass('redcolor');
				ntr.find('input[type=text]').removeClass('yellowcolor');
				ntr.find('input[type=text]').removeClass('greencolor');
				ntr.find('input[name=id]').val('');
				ntr.find('input[name=date]').val('${formatedDate}');
				ntr.find('input[name=gradeCode]').val('${gradeCode}');
				
				ntr.find('input[name=reel]').val('${reelNo}');
				
				ntr.find('select[name=customer]').val('${custName}');
				ntr.find('input[name=setNo]').val('');
				ntr.find('input[name=remarks]').val('');
				ntr.find('input[name=rowCheckbox]').val('');
			
				//$( "#rewindTaableBody tr:last" ).hide();
				
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
				//$('#rewindTaableBody input[name=time]').focusout(function(){otherValidate($(this));});
				
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
