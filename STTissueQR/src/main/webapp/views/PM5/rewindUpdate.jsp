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

<title><spring:message code="app.name" />- Rewinder Report Edit PM5</title>
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

<script type="text/javascript">
	$(function(){
		
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
					<span class="label">Quality Data Edit-Rewinder Testing< PM5/span>
				</div>
				<br>
			
					
				<div style="padding: 2px; overflow: auto; height: 450px; width: 98%;">
					
					<table class="table">
						<thead style="font-size: 12px;">
							
							<tr>
								<th style="width:200px;"></th>
								<th style="width:200px;">Date</th>
								<th style="width:80px;">Time</th>
								<th style="width:200px;">Grade Code</th>
								<th style="width:80px;">Reel #</th>
								<th style="width:80px;">Set #</th>
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
								<th style="width:80px;">Dirt Count<br> ppm</th>
								<th style="width:80px;">Absor-<br>bency Sec</th>
<!-- 								Code Starts From Here Done By Roshan Tailor  Date :-03/10/2015 MM/DD/YYYY--->
								<th style="width:100px;">L Value</th>
								<th style="width:100px;">A Value</th>
								<th style="width:100px;">B Value</th>	
<!-- 								Code Ends Here Done By Roshan Tailor -->
								<th style="width:100px;">Customer</th>
								<th>Remarks</th>
							</tr>
							
						</thead>
							<c:choose>
								<c:when test="${fn:length(datas) gt 0}">
									<tbody id="tableBody">
									
										<c:forEach items="${datas}" var="map">
											
												<c:set var="obj">${map['1']}</c:set>
												<c:choose>
													<c:when test="${obj eq 'OBJECTIVES'}">
														<tr>
															<td class="trobjrow"></td>
															<td class="trobjrow">${map['1']}</td>
															<td  class="trobjrow">N/A</td>
															<td  class="trobjrow">${map['2']}</td>
															<td  class="trobjrow">${map['3']}</td>
															<td  class="trobjrow">${map['4']}</td>
															<td  class="trobjrow">${map['5']}</td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['6'] - 0.0000}" maxFractionDigits="0"/></td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['7'] - 0.0000}" maxFractionDigits="0"/></td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['8'] - 0.0000}" maxFractionDigits="0"/></td>
															<td class="trobjrow">${map['9']}</td>
															<td class="trobjrow">${map['10']}</td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['11'] - 0.0000}" maxFractionDigits="0"/></td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['12'] - 0.0000}" maxFractionDigits="0"/></td>
															<td  class="trobjrow">${map['13']}</td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['14'] - 0.0000}" maxFractionDigits="0"/></td>
															<td  class="trobjrow"><fmt:formatNumber value="${map['15'] - 0.0000}" maxFractionDigits="0"/></td>
															<td  class="trobjrow">${map['16']}</td>
<!-- 															Code Starts From Here Done By Roshan Tailor Date :- 03/10/2015 MM/DD/YYYY -->
															<td  class="trobjrow">${map['17']}</td><!-- With The Help Of This Yellow Line Will Be Print ,Done By Roshan Tailor  -->
															<td  class="trobjrow">${map['18']}</td><!-- With The Help Of This Yellow Line Will Be Print ,Done By Roshan Tailor  -->
															<td  class="trobjrow">${map['19']}</td><!-- With The Help Of This Yellow Line Will Be Print ,Done By Roshan Tailor  -->
<!-- 															Code Ends Here Done By Roshan Tailor 	 -->
															<td  class="trobjrow">${map['20']}</td>
															<td  class="trobjrow">${map['21']}</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td>
																<input type="radio" name="rowCheckbox" value="${map['id']}"> 
															</td>
															
															<td>
																<input type="hidden" name="id" value="${map['id']}">
																<input type="text" style="width: 70px;" name="date" value="${map['1']}"  autocomplete="off">
															</td>
																
																
															<td> 
																<input type="text" class="textbox" name="time" value="${map['19']}"  autocomplete="off">						
															</td>
															
															<td> 
 <select name="gradeCode" style="width: 110px;padding: 1px;">
	<option value="">Select</option>
		<c:forEach items="${grades}" var="grade">
			<c:choose>
				<c:when test="${grade.gradeCode == map['2']}">
					<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
				</c:when>
				<c:otherwise>
					<option value="${grade.gradeCode}">${grade.gradeCode}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
		
															</td>
														
															<td> 
																<input readonly="readonly" type="text" class="textbox" name="reel" value="${map['3']}"  autocomplete="off">						
															</td>
															<td> 
																<input readonly="readonly" type="text" class="textbox" style="text-transform: uppercase;" name="setNo" value="${map['4']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['5C']}" name="actualBasisWt" value="${map['5']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['6C']}" name="bulk" value="${map['6']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['7C']}" name="mdTensile" value="${map['7']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['8C']}" name="cdTensile" value="${map['8']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['9C']}" name="mdStretch" value="${map['9']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['10C']}" name="mdcdTensileRatio" value="${map['10']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['11C']}" name="mdWetTensile" value="${map['11']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['12C']}" name="cdWetTensile" value="${map['12']}"  autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['13C']}" name="cdTensileRatio" value="${map['13']}" autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['14C']}" name="brightness" value="${map['14']}"  autocomplete="off">						
															</td>
															
															<td> 
																<input type="text" class="textbox ${map['15C']}" name="dirtCount" value="${map['15']}" autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox ${map['16C']}" name="absorbencySeconds" value="${map['16']}" autocomplete="off">						
															</td>
<!-- 															Code Starts From Here Done By Roshan Tailor Date :- 03/10/2015  MM/DD/YYYY  -->
<!-- 															With The Help Of ${map['16C']} Green Color Will Be Apper -->
															<td> 
																<input type="text" class="textbox  " name="lvalue" value="${map['23']}" autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox " name="avalue" value="${map['24']}" autocomplete="off">						
															</td>
															<td> 
																<input type="text" class="textbox " name="bvalue" value="${map['25']}" autocomplete="off">						
															</td>				
<!-- 															Code Ends Here Done By Roshan Tailor -->
															<td> 
																
																
																<select name="customer" style="width: 100px;padding: 1px;">
																	<option value="">Select</option>
																		<c:forEach items="${customers}" var="customer">
																			<c:set var="custName" value="${map['26']}"/>
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
															</td>
															<td> 
																<input type="text" name="remarks" value="${map['27']}">						
															</td>
														</tr>
													</c:otherwise>
												</c:choose>
											
												
										</c:forEach>
								</tbody>
								</c:when>
								<c:otherwise>
									<tbody>
										<tr>
											<td colspan="18">Record not found for this selection.</td>
										</tr>
									</tbody>
								</c:otherwise>
							</c:choose>
						
					</table>
					
				</div>
				
				<button onclick="window.history.back()" >Back</button>
				&nbsp;
				<button id="deleteBtn">Delete Row</button>
				
				<br>
				<table style="width: 100%;">
					<tr>
						<td><span class="message">${message}</span></td>
						<td><span class="error">${error}</span></td>
						<td><span class="error" id="setError"></span></td>
					</tr>
				</table>
				
				
			</div>

		</div>

	</div>
<spring:url value="/pm5rewind/delete" var="deleteUrl"/>
<spring:url value="/pm5rewind/update" var="updateRewindUrl"/>
<script type="text/javascript">

$(function(){
	
	var value=0;
	
	
	$('input[name=date]').datepicker({
		dateFormat:'mm/dd/yy',
		changeMonth: true,
	    changeYear: true,
	    onSelect: function() {
	        this.focus();
	     },
	     onClose:function(){
	    	 var tr=$(this).parent().parent();
				var id=tr.find('input[name=id]').val();
				var date=tr.find('input[name=date]').val();
				var time=tr.find('input[name=time]').val();
				var gradeCode=tr.find('select[name=gradeCode]').val();
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
// 				Code Starts From Here Done By Roshan Tailor Date :- 03/10/2015 MM/DD/YYYY
				var lvalue=tr.find('input[name=lvalue]').val();
				var avalue=tr.find('input[name=avalue]').val();
				var bvalue=tr.find('input[name=bvalue]').val();
// 				Code Ends Here Done By Roshan Tailor
				var customer=tr.find('select[name=customer]').val();
				var remarks=tr.find('input[name=remarks]').val();

				
				$.ajax({
					url:'${updateRewindUrl}',
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
// 						Code Starts From Here Done By Roshan Tailor Date :- 03/10/2015 MM/DD/YYYY
						lvalue : lvalue,
						avalue : avalue,
						bvalue : bvalue,
// 						Code Ends Here Done By Roshan Tailor
						customer : customer,
						remarks : remarks
					},
					success:function(data){
						if(data.status=='1'){
						//	alert('Data updated successfully.');
							location.reload(true);
						}
					}
				});

	     }
	});
	
	$("#tableBody tr input[type=text],#tableBody tr select[name=customer],#tableBody tr select[name=gradeCode]").focus(function(){
		value=$(this).val();
	});
	
	$("#tableBody tr input[type=text],#tableBody tr select[name=customer],#tableBody tr select[name=gradeCode]").focusout(function(){
		var val=$(this).val();
		
		
		if($(this).attr('type')=='text'){
			if(validate($(this))){
				return;
			}
		}
		
		var trRow=$(this).parent().parent();
		var md=trRow.find('input[name=mdTensile]').val();
		var cd=trRow.find('input[name=cdTensile]').val();
		trRow.find('input[name=mdcdTensileRatio]').val(coutMDCDRatio(md,cd));
		
		var cdWet=trRow.find('input[name=cdWetTensile]').val();
		trRow.find('input[name=cdTensileRatio]').val(coutCDWetDryRatio(cdWet,cd));
		
		
		
		if(value!=val){
			
			var tr=$(this).parent().parent();
			var id=tr.find('input[name=id]').val();
			var date=tr.find('input[name=date]').val();
			var time=tr.find('input[name=time]').val();
			var gradeCode=tr.find('select[name=gradeCode]').val();
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
// 			Code Starts From Here Done By Roshan Tailor Date :- 03/10/2015   MM/DD/YYYY
			var lvalue=tr.find('input[name=lvalue]').val();
			var avalue=tr.find('input[name=avalue]').val();
			var bvalue=tr.find('input[name=bvalue]').val();
// 			Code Ends Here Done By Roshan Tailor 
			var customer=tr.find('select[name=customer]').val();
			var remarks=tr.find('input[name=remarks]').val();

			$.ajax({
				url:'${updateRewindUrl}',
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
// 					Code Starts From Here Done By Rosha  Tailor Date:- 03/10/2015 MM/DD/YYYY
					lvalue : lvalue,
					avalue : avalue,
					bvalue : bvalue,
// 					Code Ends Here Done By Roshan Tailor
					customer : customer,
					remarks : remarks
				},
				success:function(data){
					if(data.status=='1'){
					//	alert('Data updated successfully.');
						location.reload(true);
					}
				}
			});
			
		}else{
			
		}
	});
	
	
	$('#deleteBtn').click(function(){
		
		
		var reelId=$('#tableBody input[type=radio]:checked').val();
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
function validate(tb){
	if($.trim(tb.val())!=''){
		if(tb.attr('name')=='date'|tb.attr('name')=='remarks'){
			return false;
		}else if(tb.attr('name')=='time'){
			var valid1 = (tb.val().search(/^\d{1}:\d{1}$/) != -1);
			var valid2 = (tb.val().search(/^\d{1}:\d{2}$/) != -1);
			var valid3 = (tb.val().search(/^\d{2}:\d{1}$/) != -1);
			var valid4 = (tb.val().search(/^\d{2}:\d{2}$/) != -1);
			if(!(valid1|valid2|valid3|valid4) ){
				alert('Enter a valid time.');
				setTimeout(function(){tb.focus();}, 10);
				return true;
			}
		}else if(isNaN(tb.val())){
			alert('Enter a valid number.');
			setTimeout(function(){tb.focus();}, 10);
			return true;
		}
	}
	return false;
}

</script>

</body>
</html>
