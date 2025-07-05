<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/clrewinder/save" var="saveURL" />
<spring:url value="/clrewinder/report/delete" var="deletewinderDataURL" />
<spring:url value="/clrewinder/view" var="oldDataURL" />
<spring:url value="/clrewinder/timedurtation" var="timedurtationURL" />
<!-- <script type="text/javascript">
$(function(){
	$('input[name=Proddate],input[name=Targetdate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>  -->
<script type="text/javascript">
	$(function(){
		 $('input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0
		});
		
		$('#loadDataBtn').click(function(){
			var shiftDate=$('input[name=shiftdate]').val();
			var odate=$('input[name=edate]').val();
			
			
			if(shiftDate!=odate){
				var flag=confirm("Do you want to load old data?");
				if(flag){
					location.href='${oldDataURL}/'+odate;
				}
			}else{
				location.href='${oldDataURL}';
			}
		});
		
		
		
	});
</script>
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;
$(function(){
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusin(doFocusIn);
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusout(doFocusOut);
		
		
		$('#addRowBtn').click(function(){
			
			var date = new Date(); //New Logic Applied By Roshan Tailor
			var currentmonth=(date.getMonth() + 1);
			var currentdate=date.getDate();
			var currentyeare=date.getFullYear();
			var mdy;
			
			if(currentmonth<10){
				 currentmonth='0'+currentmonth
				 mdy=(currentmonth + '-' + currentdate + '-' + currentyeare); //New Logic Applied By Roshan Tailor
			}else{
				mdy=(date.getMonth() + 1) + '-' + date.getDate() + '-' +  date.getFullYear();
			}
			var currenttime = date.getHours() + ":" + date.getMinutes();
			
			var otr = $('#yielddatatable tbody tr:last');
			var tr = $('#yielddatatable tbody tr:last').clone();
			var ntr = tr.appendTo($('#yielddatatable tbody'));
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=Date]').removeAttr('id');
			ntr.find('input[name=Date]').removeAttr('class');
			ntr.find('input[name=Date]').val(mdy); //New Logic Applied By Roshan Tailor
			ntr.find('input[name=time]').val(currenttime);
			
			
			var text = ntr.find('select[name=Shift]').val($("#Shift option:selected" ).parent().parent().parent().text()); // Find the text
		    //alert(text);
			
			ntr.find('select[name=Shift]').val($("#Shift option:selected" ).text());
			
			ntr.find('select[name=Crew]').val($("#Crew option:selected" ).text());
			ntr.find('select[name=gradeCode]').val($("#gradeCode option:selected" ).text());
			ntr.find('input[name=Date]').val($('#Date').val());
			
						
			/* ntr.find('input[name=Date]').datepicker({
				dateFormat : 'mm-dd-yy',
				changeMonth : true,
				changeYear : true,
				onClose:function(){
					//saveData($(this));
					$(this).parent().next().children().focus();
				}
			}); */
			
			ntr.find('input[name=time]').focus();
			ntr.find('input').focusin(doFocusIn);
			ntr.find('select').focusin(doFocusIn);
			ntr.find('input').focusout(doFocusOut);
			ntr.find('select').focusout(doFocusOut);
			
		});
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( 
				(tb.attr('name')=='Date')|
				(tb.attr('name')=='Shift')|
				(tb.attr('name')=='Crew')|
				(tb.attr('name')=='gradeCode')|
				(tb.attr('name')=='Reel')|
				(tb.attr('name')=='SetNo')|
 				(tb.attr('name')=='BreakAt')|
				(tb.attr('name')=='Losstime')|
				(tb.attr('name')=='Reasonforbreak')|
				(tb.attr('name')=='Reason')	|
 				(tb.attr('name')=='LeftoutinSpool')	|
 				(tb.attr('name')=='Stoptime')	|
 				(tb.attr('name')=='Starttime')	
			)
			{
				//Do Nothing 
					}
			else if(tb.attr('name')=='time'){
				var valid1 = (tb.val().search(/^\d{1}:\d{1}$/) != -1);
				var valid2 = (tb.val().search(/^\d{1}:\d{2}$/) != -1);
				var valid3 = (tb.val().search(/^\d{2}:\d{1}$/) != -1);
				var valid4 = (tb.val().search(/^\d{2}:\d{2}$/) != -1);
				if(!(valid1|valid2|valid3|valid4) ){
					alert('Enter a valid time in 24 hours format.(For example 21:00');
					setTimeout(function(){tb.focus();}, 10);
					saveLock=true;
					return true;
				}
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
	

	function doFocusIn(){
		currentVal=$(this).val();
	}
	function doFocusOut(){
		if(validatePQ($(this))){
			return;
		}
		
		if($(this).val()==currentVal){
			return;
		}
		
		saveData($(this));
	}
	
</script>
<script type="text/javascript">
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var Date=tr.find('input[name=Date]').val();
	var Shift=tr.find('select[name=Shift]').val();
	var Crew=tr.find('select[name=Crew]').val();
	var gradeCode=tr.find('select[name=gradeCode]').val();
	var Reel=tr.find('input[name=Reel]').val();
	var SetNo=tr.find('input[name=SetNo]').val();
	var BreakAt=tr.find('select[name=BreakAt]').val();
	var Losstime=tr.find('input[name=Losstime]').val();
	var Reasonforbreak=tr.find('select[name=Reasonforbreak]').val();
	var LeftoutinSpool=tr.find('input[name=LeftoutinSpool]').val();
	
	/* var Stoptime=tr.find('input[name=Stoptime]').val();
	var Starttime=tr.find('input[name=Starttime]').val(); */
	
	var Stophr=tr.find('select[name=Stophr]').val();
	var Stopmin=tr.find('select[name=Stopmin]').val();
	
	var Starthr=tr.find('select[name=Starthr]').val();
	var Startmin=tr.find('select[name=Startmin]').val();
	
	var Stoptime=Stophr+":"+Stopmin;
	var Starttime=Starthr+":"+Startmin;
	
	/* alert(Stophr);
	alert(Stopmin);
	alert(Starthr);
	alert(Startmin);
	 */
	/* alert("Stoptime::"+Stoptime);
	alert("Starttime::"+Starttime); */
	var Downtime=tr.find('input[name=Downtime]').val();
	
	
	/* var endTime =tr.find('input[name=Stoptime]').val();
	var startTime =tr.find('input[name=Starttime]').val();
	
	var diff = Math.abs(new Date('2011/10/09 '+endTime+'') - new Date('2011/10/09 '+startTime+''));
	
	alert(diff);
	
	var startDate = new Date("January 1, 1970 " + startTime);
	var endDate = new Date("January 1, 1970 " + endTime);
	
	alert(startDate);
	alert(endDate);
	
	var timeDiff = Math.abs(startDate - endDate);

	var hh = Math.floor(timeDiff / 1000 / 60 / 60);
	if(hh < 10) {
	    hh = '0' + hh;
	}
	timeDiff -= hh * 1000 * 60 * 60;
	var mm = Math.floor(timeDiff / 1000 / 60);
	if(mm < 10) {
	    mm = '0' + mm;
	}
	timeDiff -= mm * 1000 * 60;
	var ss = Math.floor(timeDiff / 1000);
	if(ss < 10) {
	    ss = '0' + ss;
	}

	alert("Time Diff- " + hh + ":" + mm + ":" + ss);
	 */
	/* 
	 function countTotalDuration(){
		
		 
		
		var ehh=0;
		var emm=0;
		
	  	$('#yielddatatable tbody tr').each(function(i){
			var hs=$(this).find('#dHH').text();
			console.log(hs);
			
			if(hs==''){
				hs='0';
				console.log("if"+hs);
			}
			if(!(isNaN(hs))){
				console.log(hs);
				ehh+=parseInt(hs, 10);
			}
			var ms=$(this).find('#dMM').text();
			if(ms==''){
				ms='0';
			}
			if(!isNaN(ms)){
				emm+=parseInt(ms, 10);
			}
		}); 
		 
		
		
		var totalMin=ehh*60+emm;
		var hours = Math.floor( totalMin / 60); 
	    var minutes = totalMin % 60;
	    
		$('#tHH').text(hours);
		$('#tMM').text(minutes);
		
	} */
	 
	 
	
	var Date=tr.find('input[name=Date]').val();
	if(typeof Date==='undefined'){
		Date='';
	}
	var Shift=tr.find('select[name=Shift]').val();
	if(typeof Shift==='undefined'){
		Shift='';
	}
	var Crew=tr.find('select[name=Crew]').val();
	if(typeof Crew==='undefined'){
		Crew='';
	}
	var gradeCode=tr.find('select[name=gradeCode]').val();
	if(typeof gradeCode==='undefined'){
		gradeCode='';
	}
	var Reel=tr.find('input[name=Reel]').val();
	if(typeof Reel==='undefined'){
		Reel='';
	}
	var SetNo=tr.find('input[name=SetNo]').val();
	if(typeof SetNo==='undefined'){
		SetNo='';
	}
	var BreakAt=tr.find('select[name=BreakAt]').val();
	if(typeof BreakAt==='undefined'){
		BreakAt='';
	}
	var Losstime=tr.find('input[name=Losstime]').val();
	if(typeof Losstime==='undefined'){
		Losstime='';
	}
	var Reasonforbreak=tr.find('select[name=Reasonforbreak]').val();
	if(typeof Reasonforbreak==='undefined'){
		Reasonforbreak='';
	}
	var LeftoutinSpool=tr.find('input[name=LeftoutinSpool]').val();
	if(typeof LeftoutinSpool==='undefined'){
		LeftoutinSpool='';
	}
	
	var Stophr=tr.find('select[name=Stophr]').val();
	if(typeof Stophr==='undefined'){
		Stophr='';
	}
	var Stopmin=tr.find('select[name=Stopmin]').val();
	if(typeof Stopmin==='undefined'){
		Stopmin='';
	}
	
	var Starthr=tr.find('select[name=Starthr]').val();
	if(typeof Starthr==='undefined'){
		Starthr='';
	}
	var Startmin=tr.find('select[name=Startmin]').val();
	if(typeof Startmin==='undefined'){
		Startmin='';
	}
	/* var Stoptime=tr.find('select[name=Stoptime]').val();
	if(typeof Stoptime==='undefined'){
		Stoptime='';
	}
	var Starttime=tr.find('select[name=Starttime]').val();
	if(typeof Starttime==='undefined'){
		Starttime='';
	}  */
	var Downtime=tr.find('input[name=Downtime]').val();
	if(typeof Downtime==='undefined'){
		Downtime='';
	}
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${saveURL}',
		type:'POST',
		data:{
			id : id,
			Date : Date,
			Shift : Shift,
			Crew : Crew,
			gradeCode : gradeCode,
			Reel : Reel,
			SetNo : SetNo,
			BreakAt : BreakAt,
			Losstime : Losstime,
			Reasonforbreak : Reasonforbreak,
			LeftoutinSpool : LeftoutinSpool,
			Stoptime : Stoptime,
			Starttime : Starttime,
			Downtime : Downtime
			
		},
		success:function(data){
			
			//countTotalDuration();
			
			var lotEle=tr.find('input[name=lot]');
			
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				
				if(lotEle){
					lotEle.removeClass('redBorder');
				}
				
			}else{
				
				if(data.ERLOT){
					setTimeout(function(){lotEle.focus();}, 100);
					lotEle.addClass('redBorder');
					alert(data.error);
				}else{
					alert(data.error);
				}
				
			}
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
			if(Starthr=='' || Starthr=='0'){
				
			}else{
				location.href='${oldDataURL}/'+Date;
			}
}
</script>
<script type="text/javascript">
$(function(){
	$('#deleterowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#yielddatatable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				alert("First Row Can't Delete.");
				//$('#yielddatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deletewinderDataURL}',
					type:'POST',
					data:{id:val},
					success:function(data){
						if(data.status){
							alert('Data removed from database.');
							location.reload(true);
						}else{
							alert(data.error);
						}
					}
				});
			}
		}
	});
});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Winder Break Monitoring</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Date</td>
							<td><input readonly="readonly" type="text" name="edate"
								value="${date}" style="width: 80px; text-align: center;"></td>
							<td><security:authorize access="hasRole('ADMIN')">
								<input type="hidden" name="shiftdate" value="${shiftdate}">
								<security:authorize access="hasRole('ADMIN')">
									<button id="loadDataBtn">Load</button>
								</security:authorize>
								&nbsp;
							</security:authorize>
								<button id="addRowBtn">Add New Row</button>
								&nbsp;
								<button id="deleterowbutton">
									Delete
								</button>
							</td>
						</tr>
					</table>
					
					<!-- <table style="margin: auto;">
						<tr>
						<td>
								&nbsp;&nbsp;
								<button id="addRowBtn">Add Row</button>
							</td>	
						</tr>
					</table> -->

				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<center>
<table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td rowspan="2">&nbsp;</td>
			<td rowspan="2"><b>Date</b></td>
			<td rowspan="2"><b>Shift</b></td>
			<!-- <td rowspan="2"><b>Crew</b></td> -->
			<td rowspan="2"><b>Grade Code</b></td>
			<!-- <td rowspan="2"><b>Reel  #</b></td>
			<td rowspan="2"><b>Set No</b></td> -->
			<td rowspan="2"><b>SKU Code</b></td>
			
			<!-- 			<td><b>Break/Stop time</b></td> -->
			<td><b>Start Time</b></td>
			<!-- 			<td><b>Start Time</b></td> -->
			<td><b>End Time</b></td>
			<td><b>Downtime</b></td>
			
			<!-- <td><b>Loss time</b></td> -->
			<td rowspan="2"><b>Reason for break</b></td>
			<td rowspan="2"><b>Reason</b></td>
			<!-- <td><b>Left out in Spool</b></td> -->
			<td rowspan="2"><b>Comments</b></td>
		</tr>
		<tr>
		
		<td rowspan="2"><b>HH:MM</b></td>
		<td rowspan="2"><b>HH:MM</b></td>
		<td rowspan="2"><b>HH:MM</b></td>
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(moniterdatas) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td><input readonly="readonly" style="width: 75px;" type="text" name="Date" value="${date}" autocomplete="off" id="Date"> </td>
			<td>
				<!-- <input type="text" name="Shift" value="" autocomplete="off"> -->
				<select name="Shift" style="width: 72px;padding: 2px;" tabindex="2" id="Shift">
				<option value="">Select</option>
				<c:forEach items="${shifts}" var="ptype">
					<option value="${ptype.key}" >${ptype.value}</option>
				</c:forEach>
			</select>
			</td>
			<input type="hidden" name="Crew" value="A" autocomplete="off">
			<%-- <td>
				<!-- <input type="text" name="Crew" value="" autocomplete="off"> -->
				<select name="Crew" style="width: 63px;padding: 2px;" tabindex="2" id="Crew">
					<option value="">Select</option>
					<option value="A">A</option>
					<c:forEach items="${crews}" var="crew">
						<option value="${crew.key}" >${crew.value}</option>
					</c:forEach>
				</select>
			</td> --%>
			<td>
				<select name="gradeCode" style="width: 120px;padding: 1px;" id="gradeCode">
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
			</td>
			<!-- <input type="text" name="Reel" style="width: 58px;" value="" autocomplete="off"> -->
			<input type="hidden" name="Reel" style="width: 58px;" value="" autocomplete="off">
			<!-- <input type="text" name="SetNo" style="width: 58px;" value="" autocomplete="off"> -->
			<input type="hidden" name="SetNo" style="width: 58px;" value="" autocomplete="off">
			<td><!-- <input type="text" name="BreakAt" style="width: 58px;" value="" autocomplete="off"> --> 
			
			<select name="BreakAt" id="skucode" style="width: 200px; padding: 2px;" required="required">
									<option value="-1">Select</option>
									<option value="All">All</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq searchedskucode }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
											</c:when>
											<c:otherwise>
												<option value="${skucode.productcode}">${skucode.productcode}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
			</td>
			<td>
			
		<fmt:formatDate value="${ef.startTime}" pattern="H" var="sH"/>
		
		<select name="Stophr">
			<option value="0">00</option> 
			<c:forEach begin="1" end="24" var="h">
				<c:choose>
					<c:when test="${h eq  sH}">
						<option value="${h}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${h}"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	 	
			
	<fmt:formatDate value="${ef.startTime}" pattern="m" var="sM"/>
		
		<select name="Stopmin">
			<option value="0">00</option>
			<c:forEach begin="1" end="59" var="m">
				<c:choose>
					<c:when test="${m eq sM}">
						<option value="${m}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:when>
					<c:otherwise>
						<option value="${m}"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>		
			
			<!-- <input type="text" name="Stoptime" style="width: 58px;" value="" autocomplete="off">  -->
		</td>
		
		 <td>
		 
		<fmt:formatDate value="${ef.endTime}" pattern="H" var="sH"/>
		<select name="Starthr">
			<option value="0">00</option> 
			<c:forEach begin="1" end="24" var="h">
				<c:choose>
					<c:when test="${h eq  sH}">
						<option value="${h}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${h}"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		
		<fmt:formatDate value="${ef.endTime}" pattern="m" var="sM"/>
		
		<select name="Startmin">
			 <option value="0">00</option>
			<c:forEach begin="1" end="59" var="m">
				<c:choose>
					<c:when test="${m eq sM}">
						<option value="${m}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:when>
					<c:otherwise>
						<option value="${m}"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		 
		 <!-- <input type="text" name="Starttime" style="width: 58px;" value="" autocomplete="off"> --> 
		 
		 </td>
			<td>
			
			
			<!-- <input type="text" name="Downtime" style="width: 58px;" value="" autocomplete="off"> -->
			
			<span id="dHH">${ef.fendTimeHH }</span>
			
			<span id="dMM">${ef.fendTimeMM}</span>
			
			
			 </td>
			
			
			<!-- <td><input type="text" name="Losstime" style="width: 58px;" value="" autocomplete="off"> </td> -->
			<td>
				<!-- <input type="text" name="Reasonforbreak" value="" autocomplete="off"> -->
				<select name="Reasonforbreak">
					<option value="">Select </option>
					<c:forEach items="${moniterbreakreason}" var="mbrare">
								<option value="${mbrare.secondarycode}">${mbrare.secondarycode}</option>
					</c:forEach>
				</select>
			</td>
			<td><input type="text" name="Losstime" style="width: 58px;" value="" autocomplete="off"> </td>
			<td><input type="text" name="LeftoutinSpool" value="" autocomplete="off"> </td>
			
		</tr>
		<%-- <tr>
			<td colspan="6"></td>
			<td style="text-align: center;"><b>Total<br />Down Time</b></td>
			<td style="text-align: center;"><b>${totaldowntime}</b></td>
			<td colspan="3"></td>
		</tr> --%>
		<%-- <div>
			<span><b>Total<br />Down Time</b></span>: <span><b>${totaldowntime}</b></span>
		</div> --%>
		
	</c:if>
	<c:if test="${fn:length(moniterdatas)> 0 }">
		<c:forEach items="${moniterdatas}" var="moniterdatas">
			<tr>
			<td><input type="radio" name="id" value="${moniterdatas.id}"></td>
			<td>
				<fmt:formatDate value="${moniterdatas.date}" var="dateS"  pattern="MM-dd-yyyy"/>
				<input style="width: 75px;" type="text" name="Date"  value="${dateS}" autocomplete="off" id="Date">
			</td>
			<td>
				<%-- <input type="text" name="Shift" value="${moniterdatas.shift}" autocomplete="off"> --%>
				<select name="Shift" style="padding: 2px;" tabindex="2" id="Shift">
				<option value="">Select</option>
				<c:forEach items="${shifts}" var="ptype">
					<c:choose>
						<c:when test="${ptype.key eq moniterdatas.shift}">
							<option value="${ptype.key}" selected="selected">${ptype.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${ptype.key}" >${ptype.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			</td>
			<input type="hidden" name="Crew" value="A" autocomplete="off">
			<%-- <td>
				<input type="text" name="Crew" value="${moniterdatas.crew}" autocomplete="off">
				<select name="Crew" style="padding: 2px;" tabindex="2" id="Crew">
				<option value="A">A</option>
				<c:forEach items="${crews}" var="crew">
					<c:choose>
						<c:when test="${crew.key eq moniterdatas.crew}">
							<option value="${crew.key}" selected="selected">${crew.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${crew.key}" >${crew.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
			</td> --%>
			<td>
				<select name="gradeCode" style="width: 120px;padding: 1px;" id="gradeCode">
				<option value="-1">Select</option>
				<c:forEach items="${grades}" var="grade">
					<c:choose>
						<c:when test="${grade.gradeCode eq moniterdatas.gradeCode}">
							<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
						</c:when>
						<c:otherwise>
							<option value="${grade.gradeCode}">${grade.gradeCode}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
			</td>
				<%-- <input type="text" name="Reel" style="width: 58px;" value="${moniterdatas.reel}" autocomplete="off"> --%>
				<input type="hidden" name="Reel" style="width: 58px;" value="${moniterdatas.reel}" autocomplete="off">
			
				<%-- <input type="text" name="SetNo" style="width: 58px;" value="${moniterdatas.setNo}" autocomplete="off"> --%>
				<input type="hidden" name="SetNo" style="width: 58px;" value="${moniterdatas.setNo}" autocomplete="off">
			<td>
			
			<select name="BreakAt" id="skucode" style="width: 200px; padding: 2px;" required="required">
									<option value="-1">Select</option>
									<option value="All">All</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq moniterdatas.breakAt }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
											</c:when>
											<c:otherwise>
												<option value="${skucode.productcode}">${skucode.productcode}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
			<%-- <input type="text" name="BreakAt"  style="width: 58px;" value="${moniterdatas.breakAt}" autocomplete="off"> --%> </td>
			
			
			<%-- <td><input type="text" name="Stoptime" style="width: 58px;" value="${moniterdatas.stoptime}" autocomplete="off"> </td>
			<td><input type="text" name="Starttime" style="width: 58px;" value="${moniterdatas.starttime}" autocomplete="off"> </td> --%>
			
			<td>
			
		<fmt:formatDate value="${moniterdatas.stoptime}" pattern="H" var="sH"/>
		
		<select name="Stophr">
			<option value="0">00</option>
			<c:forEach begin="1" end="24" var="h">
				<c:choose>
					<c:when test="${h eq  sH}">
						<option value="${h}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${h}"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	 	
			
	<fmt:formatDate value="${moniterdatas.stoptime}" pattern="m" var="sM"/>
		
		<select name="Stopmin">
			<option value="0">00</option>
			<c:forEach begin="1" end="59" var="m">
				<c:choose>
					<c:when test="${m eq sM}">
						<option value="${m}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:when>
					<c:otherwise>
						<option value="${m}"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>	
		 
			</td>
			<td>
				<fmt:formatDate value="${moniterdatas.starttime}" pattern="H" var="sH"/>
			<select name="Starthr">
				<option value="0">00</option>
				<c:forEach begin="1" end="24" var="h">
					<c:choose>
						<c:when test="${h eq  sH}">
							<option value="${h}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
						</c:when>
						<c:otherwise>
							<option value="${h}"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			
			
			<fmt:formatDate value="${moniterdatas.starttime}" pattern="m" var="sM"/>
			
			<select name="Startmin">
				<option value="0">00</option>
				<c:forEach begin="1" end="59" var="m">
					<c:choose>
						<c:when test="${m eq sM}">
							<option value="${m}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
						</c:when>
						<c:otherwise>
							<option value="${m}"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			</td>	
			<td>
				<%--  <input type="text" name="Downtime" style="width: 58px;" value="${moniterdatas.downtime}" autocomplete="off"> --%> 
				<input type="hidden"value="${moniterdatas.downtime}" name="Downtime">
				<center>${moniterdatas.downtime}</center>
			 </td>
		 	
			<%-- <td><input type="text" name="Losstime" style="width: 58px;" value="${moniterdatas.losstime}" autocomplete="off"> </td> --%>
			<td>
				<%-- <input type="text" name="Reasonforbreak"  value="${moniterdatas.reasonforbreak}" autocomplete="off"> --%>
				<select name="Reasonforbreak">
					<option value="">Select</option>
					<c:forEach items="${moniterbreakreason}" var="mbrare">
						<c:choose>
							<c:when test="${mbrare.secondarycode eq moniterdatas.reasonforbreak}">
								<option value="${mbrare.secondarycode}" selected="selected">${mbrare.secondarycode}</option>
							</c:when>
							<c:otherwise>
								<option value="${mbrare.secondarycode}">${mbrare.secondarycode}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</td>
			<td><input type="text" name="Losstime" value="${moniterdatas.losstime}" autocomplete="off"> </td>
			<td><input type="text" name="LeftoutinSpool" value="${moniterdatas.leftoutinSpool}" autocomplete="off"> </td>
			</tr>
			
		</c:forEach>
		
		</c:if>
	</tbody>
</table>
<table class="table" style="width: auto;position: inherit !important;width: 208px;height: 39px;">
<tbody>
	<tr style="text-align: center;">
		<td style="background: rgb(240, 220, 200);font-size: 15px;font-weight: 600;">Total:</td>
		<td style="background: rgb(240, 220, 200);font-size: 15px;font-weight: 600;">${totaldowntime}</td>
	</tr>
</table>
	<%-- <div style="background-color: rgba(99, 109, 70, 0.31);width: 80%;border: 2px solid;">
		
			<span style="margin: 0px 0px 0px 39px;"><b>Total</b>: <span/><span  style="margin: 0px 0px 0px 69px; font-size: 18px;"><b>${totaldowntime}</b></span>
	</div> --%>


</center>
</div>
			</div>

		</div>


	</div>

</body>
</html>
