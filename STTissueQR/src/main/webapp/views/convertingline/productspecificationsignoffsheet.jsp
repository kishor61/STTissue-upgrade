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
<spring:url value="/convertinglinecustomerrolltesting/productspecificationsignoffsheet/save" var="saveURL" />
<spring:url value="/convertinglinecustomerrolltesting/productspecificationsignoffsheet/delete" var="deletewinderDataURL" />
<spring:url value="/convertinglinecustomerrolltesting/productspecificationsignoffsheet/view" var="oldDataURL" />
<style>

	.inpCls
	{
		    width: 90px;
	}
input
{
     text-align: center;
}
</style>

<script type="text/javascript">
	$(function(){
		 $('input[name=sdate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0
		});
		 
			$('#loadDataBtn').click(function(){
				var odate=$('input[name=sdate]').val();
				location.href='${oldDataURL}/'+odate;
			});
	});
</script>
<script type="text/javascript">
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var sdate=tr.find('input[name=sdate]').val();
	var time=tr.find('select[name=time]').val();
	var skucode=tr.find('select[name=skucode]').val();
	var rolldiameter=tr.find('input[name=rolldiameter]').val();
	var tailseal=tr.find('select[name=tailseal]').val();
	var core=tr.find('select[name=core]').val();
	var rollwidth=tr.find('input[name=rollwidth]').val();
	var embossing=tr.find('select[name=embossing]').val();
	var appereiance=tr.find('select[name=appereiance]').val();
	var appereianceapllet=tr.find('select[name=appereianceapllet]').val();
	
	var datecodeprinted=tr.find('select[name=datecodeprinted]').val();
	
	var rewinderspeed=tr.find('input[name=rewinderspeed]').val();
	var rejectedkdf=tr.find('input[name=rejectedkdf]').val();
	var comment=tr.find('input[name=comment]').val();
	var initials=tr.find('input[name=initials]').val();
	var boxappr=tr.find('input[name=boxappr]').val();
	var tape=tr.find('input[name=tape]').val();
	var enoghdle=tr.find('input[name=enoghdle]').val();
	
	
	var sdate=tr.find('input[name=sdate]').val();
	if(typeof sdate==='undefined'){
		sdate='';
	}
	var time=tr.find('select[name=time]').val();
	if(typeof time==='undefined'){
		time='';
	}
	var skucode=tr.find('select[name=skucode]').val();
	if(typeof skucode==='undefined'){
		skucode='';
	}
	var rolldiameter=tr.find('input[name=rolldiameter]').val();
	if(typeof rolldiameter==='undefined'){
		rolldiameter='';
	}
	var tailseal=tr.find('select[name=tailseal]').val();
	if(typeof tailseal==='undefined'){
		tailseal='';
	}
	var core=tr.find('select[name=core]').val();
	if(typeof core==='undefined'){
		core='';
	}
	var rollwidth=tr.find('input[name=rollwidth]').val();
	if(typeof rollwidth==='undefined'){
		rollwidth='';
	}
	var embossing=tr.find('select[name=embossing]').val();
	if(typeof embossing==='undefined'){
		embossing='';
	}
	var appereiance=tr.find('select[name=appereiance]').val();
	if(typeof appereiance==='undefined'){
		appereiance='';
	}
	var appereianceapllet=tr.find('select[name=appereianceapllet]').val();
	if(typeof appereianceapllet==='undefined'){
		appereianceapllet='';
	}

	var datecodeprinted=tr.find('select[name=datecodeprinted]').val();
	if(typeof datecodeprinted==='undefined'){
		datecodeprinted='';
	}
	
	var rewinderspeed=tr.find('input[name=rewinderspeed]').val();
	if(typeof rewinderspeed==='undefined'){
		rewinderspeed='';
	}
	
	var rejectedkdf=tr.find('input[name=rejectedkdf]').val();
	if(typeof rejectedkdf==='undefined'){
		rejectedkdf='';
	}
	var comment=tr.find('input[name=comment]').val();
	if(typeof comment==='undefined'){
		comment='';
	}
	
	var initials=tr.find('input[name=initials]').val();
	if(typeof initials==='undefined'){
		initials='';
	}
	var boxappr=tr.find('input[name=boxappr]').val();
	if(typeof boxappr==='undefined'){
		boxappr='';
	}
	var tape=tr.find('input[name=tape]').val();
	if(typeof tape==='undefined'){
		tape='';
	}
	var enoghdle=tr.find('input[name=enoghdle]').val();
	if(typeof enoghdle==='undefined'){
		enoghdle='';
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
			sdate : sdate,
			time : time,
			skucode : skucode,
			rolldiameter : rolldiameter,
			tailseal : tailseal,
			core : core,
			rollwidth : rollwidth,
			embossing : embossing,
			appereiance : appereiance,
			appereianceapllet : appereianceapllet,
			datecodeprinted : datecodeprinted,
			rejectedkdf : rejectedkdf,
			rewinderspeed : rewinderspeed,
			boxappr:boxappr,
			tape:tape,
			enoghdle:enoghdle,
			comment : comment,
			initials : initials
			
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
			
			var otr = $('#yielddatatable tbody tr:last');
			var tr = $('#yielddatatable tbody tr:last').clone();
			var ntr = tr.appendTo($('#yielddatatable tbody'));
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=sdate]').removeAttr('id');
			
			
			var text = ntr.find('select[name=Shift]').val($("#Shift option:selected" ).parent().parent().parent().text()); // Find the text
		    
			ntr.find('select[name=time]').val($('#time').val());
			ntr.find('input[name=sdate]').val($('#sdate').val());
			ntr.find('select[name=time]').val($("#time option:selected" ).text());
			ntr.find('select[name=skucode]').val($("#skucode option:selected" ).text());
			ntr.find('input[name=rolldiameter]').val($('#rolldiameter').val());
			ntr.find('select[name=tailseal]').val($('#tailseal').val());
			ntr.find('select[name=core]').val($('#core').val());
			ntr.find('input[name=rollwidth]').val($('#rollwidth').val());
			ntr.find('select[name=embossing]').val($("#embossing option:selected" ).text());
			ntr.find('select[name=appereiance]').val($("#appereiance option:selected" ).text());
			ntr.find('select[name=appereianceapllet]').val($("#appereianceapllet option:selected" ).text());
				
			
			
			ntr.find('input[name=rewinderspeed]').val($('#rewinderspeed').val());
			ntr.find('input[name=rejectedkdf]').val($('#rejectedkdf').val());
			ntr.find('input[name=boxappr]').val($('#boxappr').val());
			ntr.find('input[name=tape]').val($('#tape').val());
			ntr.find('input[name=enoghdle]').val($('#enoghdle').val());
			ntr.find('input[name=comment]').val($('#comment').val());
			ntr.find('input[name=initials]').val($('#initials').val());
			
			
			ntr.find('input').focusin(doFocusIn);
			ntr.find('select').focusin(doFocusIn);
			ntr.find('input').focusout(doFocusOut);
			ntr.find('select').focusout(doFocusOut);
			
		});
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( 
				(tb.attr('name')=='sdate')|
				(tb.attr('name')=='time')|
				(tb.attr('name')=='skucode')|
				(tb.attr('name')=='rolldiameter')|
				(tb.attr('name')=='tailseal')|
				(tb.attr('name')=='core')|
 				(tb.attr('name')=='rollwidth')|
				(tb.attr('name')=='embossing')|
				(tb.attr('name')=='appereiance')|
				(tb.attr('name')=='appereianceapllet')|
				(tb.attr('name')=='rewinderspeed')	|
				(tb.attr('name')=='rejectedkdf')	|
				(tb.attr('name')=='comment')	|
 				(tb.attr('name')=='initials')	
			)
			{
				//Do Nothing 
					}
			/* else if(tb.attr('name')=='time'){
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
			} */
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
					<span class="label">Converting Line - PRODUCT SPECIFICATION SIGN OFF SHEET</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Date</td>
							<td><input readonly="readonly" type="text" name="sdate" id="sdate" value="${currentdate}" style="width: 80px; text-align: center;"></td>
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
<!-- <div style="position: absolute;   overflow: auto;width: 98%;bottom: 0;top: 102px;"> -->
<center>
<table id="yielddatatable" class="table" style="width: 60%;">
	<thead style="text-align: center;">
		<tr>
			<td></td>
			<td>Time</td>
			<td>Rewinder Speed</td>
			<td>SKU  Code</td>
			<td>Roll Diameter</td>
			<td>Tail Seal</td>
			<td>Core</td>
			<td>Roll Width</td>
			<td>Embossing</td>
			<td>Over all<br> Appereiance</td>
			<td>Appereiance <br>After Palletized</td>
			<td>Date Code<br >Printed</td>
			<td>Rejected<br >KDF</td>
			<td>Box Apperance</td>
			<td>Tape</td>
			<td>Enough Handle</td>
			<td>Comments</td>
			<td>Initials</td>
		</tr>
		
	</thead>
	<tbody>
	
	<c:if test="${fn:length(data) eq 0 }">
	<tr>
			<td>
				<input type="radio" name="id" value="">
				<input type="hidden" value="${date}" name="sdate">
			</td>
			<td>
				<select name="time" id="time" style="width: 98px; padding: 2px;" required="required">
									<option value="7 AM" selected="selected">7 AM</option>
									<option value="8 AM">8 AM</option>
									<option value="9 AM">9 AM</option>
									<option value="10 AM">10 AM</option>
									<option value="11 AM">11 AM</option>
									<option value="12 PM">12 PM</option>
									<option value="1 PM">1 PM</option>
									<option value="2 PM">2 PM</option>
									<option value="3 PM">3 PM</option>
									<option value="4 PM">4 PM</option>
									<option value="5 PM">5 PM</option>
									<option value="6 PM">6 PM</option>
									<option value="7 PM">7 PM</option>
									<option value="8 PM">8 PM</option>
									<option value="9 PM">9 PM</option>
									<option value="10 PM">10 PM</option>
									<option value="11 PM">11 PM</option>
									<option value="12 AM">12 AM</option>
									<option value="1 AM">1 AM</option>
									<option value="2 AM">2 AM</option>
									<option value="3 AM">3 AM</option>
									<option value="4 AM">4 AM</option>
									<option value="5 AM">5 AM</option>
									<option value="6 AM">6 AM</option>
								</select>
								
			</td>
			<td><input type="text" class="inpCls"  value="" name="rewinderspeed"></td>
			<td>
			<select name="skucode" id="skucode" style="width: 100px; padding: 2px;" required="required">
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
			</td>
			<td>
			<input type="text" class="inpCls" name="rolldiameter" value=""/>
				<!-- <select name="rolldiameter" id="rolldiameter" style="width: 98px; padding: 2px;" required="required">
									<option value="Yes">Yes</option>
									<option value="No">No</option>
				</select> -->
				<!-- <input type="text" class="inpCls" name="rolldiameter" value=""/> -->
			</td>
			<td>
			<select name="tailseal" id="tailseal" style="width:60px; padding: 2px;" required="required">
									<option value="Yes">Yes</option>
									<option value="No">No</option>
				</select>
				<!-- <input type="text"  class="inpCls"name="tailseal" value=""/> -->
			</td>
			<td>
			<select name="core" id="core" style="width: 60px; padding: 2px;" required="required">
									<option value="Yes">Yes</option>
									<option value="No">No</option>
				</select>
				<!-- <input type="text" class="inpCls" name="core" value=""/> -->
			</td>
			<td>
			<input type="text" class="inpCls" name="rollwidth" value=""/>
			<!-- <select name="rollwidth" id="rollwidth" style="width: 98px; padding: 2px;" required="required">
									<option value="Yes">Yes</option>
									<option value="No">No</option>
				</select> -->
				<!-- <input type="text" class="inpCls" name="rollwidth" value=""/> -->
			</td>
			<td>
			<select name="embossing" id="embossing" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<option value="Good">Good</option>
									<option value="Fair">Fair</option>
									<option value="Poor">Poor</option>
								</select>
			</td>
			<td>
			<select name="appereiance" id="appereiance" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<option value="Good">Good</option>
									<option value="Fair">Fair</option>
									<option value="Poor">Poor</option>
								</select>
								
			</td>
			<td>
			<select name="appereianceapllet" id="appereianceapllet" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<option value="Good">Good</option>
									<option value="Fair">Fair</option>
									<option value="Poor">Poor</option>
								</select>
								
			</td>
			<td>
			<select name="datecodeprinted" id="datecodeprinted" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<option value="Yes">Yes</option>
									<option value="No">No</option>
								</select>
								
			</td>
			<td><input type="text" class="inpCls"  value="" name="rejectedkdf"></td>
			<td><input type="text" class="inpCls"  value="" name="boxappr"></td>
			<td><input type="text" class="inpCls"  value="" name="tape"></td>
			<td><input type="text" class="inpCls"  value="" name="enoghdle"></td>
			<td><input type="text" class="inpCls"  value="" name="comment"></td>
			<td><input type="text" class="inpCls" value="" name="initials"></td>
</tr>
</c:if>
<c:if test="${fn:length(data) > 0 }">
<c:forEach items="${data}" var="datas">
<tr>
			<td>
				<input type="radio" name="id" value="${datas.id}">
				<fmt:formatDate value="${datas.date}" var="dateS"  pattern="MM-dd-yyyy"/>
				<input style="width: 75px;" type="hidden"  name="sdate"  value="${dateS}" autocomplete="off" id="Date">
			</td>
			<td>
				<select name="time" id="time" style="width: 98px; padding: 2px;" required="required">
									<c:if test ="${datas.time eq'7 AM' || datas.time eq ''}">
										<option value="7 AM" selected="selected">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
											
										
									</c:if>
									<c:if test ="${datas.time eq'8 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM" selected="selected">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'9 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM" selected="selected">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'10 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM"selected="selected">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'11 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM"selected="selected">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'12 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM"selected="selected">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'1 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM"selected="selected">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'2 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM"selected="selected">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'3 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 AM">1 PM</option>
										<option value="2 AM">2 PM</option>
										<option value="3 PM"selected="selected">3 PM</option>
										<option value="4 AM">4 PM</option>
										<option value="5 AM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'4 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM"selected="selected">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'5 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM"selected="selected">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'6 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM"selected="selected">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'7 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM"selected="selected">7 PM</option>										
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'8 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM"selected="selected">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'9 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM"selected="selected">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'10 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM"selected="selected">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'11 PM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										
										<option value="11 PM"selected="selected">11 PM</option>
										<option value="12 AM">12 AM</option>
									<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'12 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM"selected="selected">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'1 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM"selected="selected">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'2 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM"selected="selected">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'3 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM"selected="selected">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									
									<c:if test ="${datas.time eq'4 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM"selected="selected">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'5 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM"selected="selected">5 AM</option>
										<option value="6 AM">6 AM</option>
									</c:if>
									<c:if test ="${datas.time eq'6 AM'}">
										<option value="7 AM">7 AM</option>
										<option value="8 AM">8 AM</option>
										<option value="9 AM">9 AM</option>
										<option value="10 AM">10 AM</option>
										<option value="11 AM">11 AM</option>
										<option value="12 PM">12 PM</option>
										<option value="1 PM">1 PM</option>
										<option value="2 PM">2 PM</option>
										<option value="3 PM">3 PM</option>
										<option value="4 PM">4 PM</option>
										<option value="5 PM">5 PM</option>
										<option value="6 PM">6 PM</option>
										<option value="7 PM">7 PM</option>
										<option value="8 PM">8 PM</option>
										<option value="9 PM">9 PM</option>
										<option value="10 PM">10 PM</option>
										<option value="11 PM">11 PM</option>
										<option value="12 AM">12 AM</option>
										<option value="1 AM">1 AM</option>
										<option value="2 AM">2 AM</option>
										<option value="3 AM">3 AM</option>
										<option value="4 AM">4 AM</option>
										<option value="5 AM">5 AM</option>
										<option value="6 AM"selected="selected">6 AM</option>
									</c:if>
								
								</select>
								
			</td>
			<td><input type="text" class="inpCls"  value="${datas.rewinderspeed}" name="rewinderspeed"></td>
			<td>
			<select name="skucode" id="skucode" style="width: 98px; padding: 2px;" required="required">
									<option value="-1">Select</option>
									<option value="All">All</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq datas.skucode }">
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
			<input type="text" class="inpCls" name="rolldiameter" value="${datas.rolldiameter}"/>
			<%-- <select name="rolldiameter" id="rolldiameter" style="width: 98px; padding: 2px;" required="required">
									<c:if test ="${datas.rolldiameter eq'Yes' || datas.rolldiameter eq'' }">
										<option value="Yes" selected="selected">Yes</option>
										<option value="No">No</option>
									</c:if>
									<c:if test ="${datas.rolldiameter eq'No'}">
										<option value="Yes">Yes</option>
										<option value="No" selected="selected">No</option>
									</c:if>
				</select> --%>
				<%-- <input type="text" class="inpCls" name="rolldiameter" value="${datas.rolldiameter}"/> --%>
			</td>
			<td>
			<select name="tailseal" id="tailseal" style="width: 60px; padding: 2px;" required="required">
									<c:if test ="${datas.tailseal eq'Yes' || datas.tailseal eq'' }">
										<option value="Yes" selected="selected">Yes</option>
										<option value="No">No</option>
									</c:if>
									<c:if test ="${datas.tailseal eq'No'}">
										<option value="Yes">Yes</option>
										<option value="No" selected="selected">No</option>
									</c:if>
				</select>
				<%-- <input type="text" class="inpCls" name="tailseal" value="${datas.tailseal}"/> --%>
			</td>
			<td>
			<select name="core" id="core" style="width: 60px; padding: 2px;" required="required">
									<c:if test ="${datas.core eq'Yes' || datas.core eq'' }">
										<option value="Yes" selected="selected">Yes</option>
										<option value="No">No</option>
									</c:if>
									<c:if test ="${datas.core eq'No'}">
										<option value="Yes">Yes</option>
										<option value="No" selected="selected">No</option>
									</c:if>
				</select>
				<%-- <input type="text" class="inpCls" name="core" value="${datas.core}"/> --%>
			</td>
			<td>
			<%-- <select name="rollwidth" id="rollwidth" style="width: 98px; padding: 2px;" required="required">
									<c:if test ="${datas.rollwidth eq'Yes' || datas.rollwidth eq'' }">
										<option value="Yes" selected="selected">Yes</option>
										<option value="No">No</option>
									</c:if>
									<c:if test ="${datas.rollwidth eq'No'}">
										<option value="Yes">Yes</option>
										<option value="No" selected="selected">No</option>
									</c:if>
				</select> --%>
				 <input type="text" class="inpCls" name="rollwidth" value="${datas.rollwidth}"/> 
			</td>
			<td>
			<select name="embossing" id="embossing" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test ="${datas.embossing eq'Good' || datas.embossing eq ''}">
										<option value="Good" selected="selected">Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.embossing eq'Fair'}">
										<option value="Good" >Good</option>
										<option value="Fair"selected="selected">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.embossing eq'Poor'}">
										<option value="Good" >Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor"selected="selected">Poor</option>
									</c:if>
									
									
									
									
								</select>
			</td>
			<td>
			<select name="appereiance" id="appereiance" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test ="${datas.appereiance eq'Good' || datas.appereiance eq ''}">
										<option value="Good" selected="selected">Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.appereiance eq'Fair'}">
										<option value="Good" >Good</option>
										<option value="Fair"selected="selected">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.appereiance eq'Poor'}">
										<option value="Good" >Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor"selected="selected">Poor</option>
									</c:if>
								</select>
			</td>
			<td>
			<select name="appereianceapllet" id="appereianceapllet" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test ="${datas.appereianceapllet eq'Good' || datas.appereianceapllet eq ''}">
										<option value="Good" selected="selected">Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.appereianceapllet eq'Fair'}">
										<option value="Good" >Good</option>
										<option value="Fair"selected="selected">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.appereianceapllet eq'Poor'}">
										<option value="Good" >Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor"selected="selected">Poor</option>
									</c:if>
								</select>
			</td>
			<td>
			<select name="datecodeprinted" id="datecodeprinted" style="width: 70px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test ="${empty datas.datecodeprinted}">
										<option value="Yes">Yes</option>
										<option value="No">No</option>
									</c:if>
									<c:if test ="${datas.datecodeprinted eq'Yes'}">
										<option value="Yes" selected="selected">Yes</option>
										<option value="No">No</option>
									</c:if>
									<c:if test ="${datas.datecodeprinted eq'No'}">
										<option value="Yes" >Yes</option>
										<option value="No"selected="selected">No</option>
									</c:if>
								</select>
								
								
			</td>
			<td><input type="text" class="inpCls"  value="${datas.rejectedkdf}" name="rejectedkdf"></td>
			<td><input type="text" class="inpCls"  value="${datas.boxappr}" name="boxappr"></td>
			<td><input type="text" class="inpCls"  value="${datas.tape}" name="tape"></td>
			<td><input type="text" class="inpCls"  value="${datas.enoghdle}" name="enoghdle"></td>
			<td><input type="text" class="inpCls" value="${datas.comment}" name="comment"></td>
			<td><input type="text" class="inpCls" value="${datas.initials}" name="initials"></td>
			<c:set value="${total+datas.rejectedkdf}" var="total"/>
	</tr>
	</c:forEach>
	<thead style="text-align: center;">
	<tr>
		<td colspan="10"></td>
		<td></td>
		<td><b>Total:</b></td>
		<td ><b>${total}</b></td>
		<td colspan="2"></td>
		
	</tr>
	</thead>
	
</c:if>	
	</tbody>
</table>
</center>
</div>
			</div>

		</div>


	</div>

</body>
</html>
