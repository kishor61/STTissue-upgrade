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
<spring:url value="/manintenanceMonitoring/save" var="saveURL" />
<spring:url value="/manintenanceMonitoring/delete" var="deletewinderDataURL" />
<spring:url value="/manintenanceMonitoring/view" var="oldDataURL" />
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
		 $('input[name=eedate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0
		});
		
		$('#loadDataBtn').click(function(){
			var shiftDate=$('input[name=shiftdate]').val();
			var odate=$('input[name=eedate]').val();
			
			
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
			console.log(ntr)
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=eDate]').removeAttr('id');
			ntr.find('input[name=eDate]').removeAttr('class');
			ntr.find('input[name=eDate]').val(mdy); //New Logic Applied By Roshan Tailor
			ntr.find('input[name=time]').val(currenttime);
			
			
			var text = ntr.find('select[name=skuCode]').val($("#skuCode option:selected" ).parent().parent().parent().text()); // Find the text
		    //alert(text);
			
			ntr.find('select[name=area]').val($("#area option:selected" ).text());
			
			  
			ntr.find('input[name=eDate]').val($('#Date').val());
			 
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
				(tb.attr('name')=='skuCode')|
				(tb.attr('name')=='area')|
				(tb.attr('name')=='errorCode')|
				(tb.attr('name')=='errorDescription')|
				(tb.attr('name')=='commants')|
				(tb.attr('name')=='errorFile')
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
	
	
	function uploadFile() {
  
		 console.log("file",f1);
		  //var file = $('#file').val();
		  
		  var filename = tr.find('input[name=commants]').val().replace(/C:\\fakepath\\/i, '')
		  console.log("file",filename)
		  f1 = i.concat("_").concat(filename);
		  console.log("bankstatement1",f1)
		 
		  
	 
		
 }
	
</script>
<script type="text/javascript">
var f1=''
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var Date=tr.find('input[name=eDate]').val();
	var skuCode=tr.find('select[name=skuCode]').val();
	var area=tr.find('select[name=area]').val();
	 
	var errorCode=tr.find('input[name=errorCode]').val();
	var errorDescription=tr.find('input[name=errorDescription]').val();
	var commants=tr.find('input[name=commants]').val();
	 
	 
	//alert(id); 
	
	 
	
	var Date=tr.find('input[name=eDate]').val();
	if(typeof Date==='undefined'){
		Date='';
	}
	var skuCode=tr.find('select[name=skuCode]').val();
	if(typeof skuCode==='undefined'){
		skuCode='';
	}
	
	var area=tr.find('select[name=area]').val();
	if(typeof area==='undefined'){
		area='';
	}
	 
	var errorCode=tr.find('input[name=errorCode]').val();
	
	var errorDescription=tr.find('input[name=errorDescription]').val();
	var commants=tr.find('input[name=commants]').val();
	 
	if(typeof SetNo==='undefined'){
		SetNo='';
	}
	 
	  
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$('#loadPage').show();
	$.ajax({
		url:'${saveURL}',
		type:'POST',
		data:{
			id : id,
			Date : Date,
			skuCode:skuCode,
			area:area,
			errorCode:errorCode,
			errorDescription:errorDescription,
			commants:commants
		},
		success:function(data){
			
			//countTotalDuration();
			
			var lotEle=tr.find('input[name=lot]');
			
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				location.reload();
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
			$('#loadPage').hide();
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
			/* if(Starthr=='' || Starthr=='0'){
				
			}else{
				location.href='${oldDataURL}/'+Date;
			} */
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
<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
</div>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Maintenance Log</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Date</td>
							<td><input readonly="readonly" type="text" name="eedate"value="${date}" style="width: 80px; text-align: center;"></td>
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
<table id="yielddatatable" class="table">
	<thead style="text-align: center;">
		<tr>
			<td rowspan="2">&nbsp;</td>
			<td rowspan="2"><b>Date</b></td>
			<!-- <td rowspan="2"><b>Shift</b></td> -->
			<!-- <td rowspan="2"><b>Crew</b></td> -->
			<!-- <td rowspan="2"><b>Grade Code</b></td> -->
			<!-- <td rowspan="2"><b>Reel  #</b></td>
			<td rowspan="2"><b>Set No</b></td> -->
			<td rowspan="2"><b>SKU Code</b></td>
			<td rowspan="2"><b>Area</b>
			
			<!-- 			<td><b>Break/Stop time</b></td> -->
			<!-- <td><b>Start Time</b></td>
						<td><b>Start Time</b></td>
			<td><b>End Time</b></td>
			<td><b>Downtime</b></td>
			 -->
			<!-- <td><b>Loss time</b></td> -->
			<td rowspan="2"><b>Error Code</b></td>
			<td rowspan="2"><b>Error Description</b></td>
			<!-- <td><b>Left out in Spool</b></td> -->
			<td rowspan="2"><b>Comments</b></td>
			<!-- <td rowspan="2"><b>Picture (If any)</b></td> -->
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(moniterdatas) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td><input readonly="readonly" style="width: 75px;" type="text" name="eDate" value="${date}" autocomplete="off" id="Date"> </td>
			<td> 
			<select name="skuCode" id="skucode" style="width: 100px; padding: 2px;" required="required">
									<option value="-1">Select</option>
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
				<!-- <input type="text" name="Reasonforbreak" value="" autocomplete="off"> -->
				<select name="area">
					<!-- <option value="-1">Select</option>
								  <option value="unwined">Unwined</option>
								  <option value="rewinder">Rewinder</option>
								  <option value="logsaw">Logsaw</option>
								  <option value="casepacker">Casepacker</option>
								  <option value="coremachine">Core Machine</option> -->
								  
								  
								  <option value="-1">Select</option>
									<c:forEach items="${arealst}" var="arealst">
										<c:choose>
											<c:when test="${arealst.name eq searchedskucode }">
												<option value="${arealst.name}" selected="selected">${arealst.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${arealst.name}">${arealst.name}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								  
								  
				</select>
			</td>
			<td><input type="text" name="errorCode" style="width: 97px;" value="" autocomplete="off"> </td>
			<td style="width: 500px;"><input type="text"  style="width: 500px;" name="errorDescription" value="" autocomplete="off"> </td>
			<td style="width: 801px;"><input type="text" style="width: 801px;" name="commants" value="" autocomplete="off"> </td>
			<!-- <td><input type="file" name="errorFile" id="errorFile" value="" autocomplete="off"> </td> -->
			
		</tr>
		
	</c:if>
	
	<c:if test="${fn:length(moniterdatas) > 0 }">
	 <c:forEach items="${moniterdatas}" var="moniterdatas">
		<tr>
			<td><input type="radio" name="id" value="${moniterdatas.id}"></td>
			
			<td><%-- <fmt:formatDate value="${moniterdatas.eDate}" var="dateS"  pattern="yyyy"/> --%>
				<fmt:formatDate value="${moniterdatas.eDate}" var="dateS"  pattern="MM-dd-yyyy"/>
				<input style="width: 75px;" type="text" name="eDate"  value="${dateS}" autocomplete="off" id="Date"></td>
			<td> 
			<select name="skuCode" id="skucode" style="width: 100px; padding: 2px;" required="required">
									<option value="-1">Select</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq moniterdatas.skuCode }">
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
				<!-- <input type="text" name="Reasonforbreak" value="" autocomplete="off"> -->
				<select name="area">
					 <option value="-1">Select</option>
									<c:forEach items="${arealst}" var="arealst">
										<c:choose>
											<c:when test="${arealst.name eq moniterdatas.area }">
												<option value="${arealst.name}" selected="selected">${arealst.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${arealst.name}">${arealst.name}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
				</select>
			</td>
			<td><input type="text" name="errorCode" style="width: 97px;" value="${moniterdatas.errorCode}" autocomplete="off"> </td>
			<td style="width: 500px;"><input type="text" style="width: 500px;" name="errorDescription" value="${moniterdatas.errorDescription}" autocomplete="off"> </td>
			<td style="width: 801px;"><input type="text" style="width: 801px;" name="commants" value="${moniterdatas.commants}" autocomplete="off"> </td>
			<!-- <td><input type="file" name="errorFile" value="" autocomplete="off"> </td> -->
			
		</tr>
	</c:forEach>	
		
	</c:if>
	
 
	<%--  <c:if test="${fn:length(moniterdatas)> 0 }">
		<c:forEach items="${moniterdatas}" var="moniterdatas">
			<tr>
			<td><input type="radio" name="id" value="${moniterdatas.id}"></td>
			<td>
				<fmt:formatDate value="${moniterdatas.date}" var="dateS"  pattern="MM-dd-yyyy"/>
				<input style="width: 75px;" type="text" name="Date"  value="${dateS}" autocomplete="off" id="Date">
			</td>
			<td>
				<input type="text" name="Shift" value="${moniterdatas.shift}" autocomplete="off">
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
			<td>
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
			</td>
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
				<input type="text" name="Reel" style="width: 58px;" value="${moniterdatas.reel}" autocomplete="off">
				<input type="hidden" name="Reel" style="width: 58px;" value="${moniterdatas.reel}" autocomplete="off">
			
				<input type="text" name="SetNo" style="width: 58px;" value="${moniterdatas.setNo}" autocomplete="off">
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
			<input type="text" name="BreakAt"  style="width: 58px;" value="${moniterdatas.breakAt}" autocomplete="off"> </td>
			
			
			<td><input type="text" name="Stoptime" style="width: 58px;" value="${moniterdatas.stoptime}" autocomplete="off"> </td>
			<td><input type="text" name="Starttime" style="width: 58px;" value="${moniterdatas.starttime}" autocomplete="off"> </td>
			
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
				 <input type="text" name="Downtime" style="width: 58px;" value="${moniterdatas.downtime}" autocomplete="off"> 
				<input type="hidden"value="${moniterdatas.downtime}" name="Downtime">
				<center>${moniterdatas.downtime}</center>
			 </td>
		 	
			<td><input type="text" name="Losstime" style="width: 58px;" value="${moniterdatas.losstime}" autocomplete="off"> </td>
			<td>
				<input type="text" name="Reasonforbreak"  value="${moniterdatas.reasonforbreak}" autocomplete="off">
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
		
		</c:if> --%>
	</tbody>
</table>
<%-- <table class="table" style="width: auto;position: inherit !important;width: 208px;height: 39px;">
<tbody>
	<tr style="text-align: center;">
		<td style="background: rgb(240, 220, 200);font-size: 15px;font-weight: 600;">Total:</td>
		<td style="background: rgb(240, 220, 200);font-size: 15px;font-weight: 600;">${totaldowntime}</td>
	</tr>
</table> --%>
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
