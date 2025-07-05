<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="./common.jsp"></jsp:include>
<spring:url	
	value="/qulitycheck_pm6/qualitychecklist/check" var="checkURL" />
<spring:url
	value="/qulitycheck_pm6/qualitychecklist/save" var="saveURL" />
<spring:url
	value="/qulitycheck_pm6/productspecificationsignoffsheet/delete"
	var="deletewinderDataURL" />
<spring:url
	value="/qulitycheck_pm6/productspecificationsignoffsheet/view" var="oldDataURL" />
	<spring:url value="/qulitycheck_pm6/timediff/save" var="timediffURL"/>
<style>
.inpCls {
	width: 90px;
}
.tr {
	margin-left: 85px;
}

input {
	text-align: center;
}
</style>

<script type="text/javascript">

function operatorSelect(value)
{  
	
	if(value=='day')
	{
		
		$('#day').show();
		$('#night').hide();
		
	} else if (value=='night') {
			
		$('#night').show();
		$('#day').hide();
	}	
}
	$(function() {
		$('input[name=sdate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0
		});

		$('#loadDataBtn').click(function() {
			var odate = $('input[name=sdate]').val();
			location.href = '${oldDataURL}/' + odate;
		});	
	
		
		$('#machinedown').click(function() {
			
			if($('select[name=fendTimeHH]').val()=='HH'||$('select[name=fendTimeMM]').val()=='MM'||$('select[name=fstartTimeHH]').val()=='HH'||$('select[name=fstartTimeMM]').val()=='MM'||$('select[name=shift').val()==''){
				alert("Please select Machine down Time and Shift")
			}else{
				
				var sdHH=$('select[name=fstartTimeHH]').val();
				var sdMM=$('select[name=fstartTimeMM]').val();				
				var edHH=$('select[name=fendTimeHH]').val();
				var edMM=$('select[name=fendTimeMM]').val();
				var sd=sdHH+":"+sdMM;
				var ed=edHH+":"+edMM;
				
			//	location.href = '${timediffURL}/' + sd+'/'+ed;$('#tmessage').text('');
				
				

				var id = $('input[name=id]').val();
				var idEle = $('input[name=id]');
				var shift=$('select[name=shift]').val();
				var sdate = $('input[name=sdate]').val();
				var time = $('select[name=time]').val();
				var gradecode = $('select[name=gradecode]').val();
				var customer = $('select[name=customer]').val();
				var setnumber = $('input[name=setnumber]').val();
				var position = $('input[name=position]').val();
				var holes = $('select[name=holes]').val();
				var core = $('select[name=core]').val();
				var corrugation = $('select[name=corrugation]').val();
				var EdgeQulity = $('select[name=EdgeQulity]').val();

				var widthofroll = $('input[name=widthofroll]').val();
				var diameterofroll = $('input[name=diameterofroll]').val();
				var r1r2initial = $('input[name=r1r2initial]').val();
				var auditerinitial = $('input[name=auditerinitial]').val();

				/*
				 var appereiance=$('select[name=appereiance]').val();
				 var appereianceapllet=$('select[name=appereianceapllet]').val();
				 var datecodeprinted=$('select[name=datecodeprinted]').val();
				 var rolldiameter=$('select[name=rolldiameter]').val();
				 var sdate=tr.find('input[name=sdate]').val();
				
				 */

				if (typeof sdate === 'undefined') {
					sdate = '';
				}
				var time = $('select[name=time]').val();
				if (typeof time === 'undefined') {
					time = '';
				}
				var gradecode = $('select[name=gradecode]').val();
				if (typeof gradecode === 'undefined') {
					gradecode = '';
				}

				var customer = $('select[name=customer]').val();
				if (typeof holes === 'undefined') {
					holes = '';
				}
				var setnumber = $('input[name=setnumber]').val();
				if (typeof holes === 'undefined') {
					holes = '';
				}

				var position = $('input[name=position]').val();
				if (typeof holes === 'undefined') {
					holes = '';
				}

				var holes = $('select[name=holes]').val();
				if (typeof holes === 'undefined') {
					holes = '';
				}
				var core = $('select[name=core]').val();
				if (typeof core === 'undefined') {
					core = '';
				}
				var corrugation = $('select[name=corrugation]').val();
				if (typeof corrugation === 'undefined') {
					corrugation = '';
				}
				var EdgeQulity = $('select[name=EdgeQulity]').val();
				if (typeof EdgeQulity === 'undefined') {
					EdgeQulity = '';
				}

				var widthofroll = $('input[name=widthofroll]').val();
				if (typeof widthofroll === 'undefined') {
					widthofroll = '';
				}

				var diameterofroll = $('input[name=diameterofroll]').val();
				if (typeof diameterofroll === 'undefined') {
					diameterofroll = '';
				}
				var r1r2initial = $('input[name=r1r2initial]').val();
				if (typeof r1r2initial === 'undefined') {
					r1r2initial = '';
				}

				var auditerinitial = $('input[name=auditerinitial]').val();
				if (typeof auditerinitial === 'undefined') {
					auditerinitial = '';
				}
			
				
				if (saveLock) {
					return;
				}
				 var check=false;
				 $.ajax({
						url : '${checkURL}',
						type : 'POST',
						data : {
							id : id,
							sdate : sdate,
							sd:sd,
							ed:ed,
							shift:shift,
							time : time
						},
						success : function(data) {
							if(data.count<8)
							{
								if(data.check)
								{
									if (confirm("You Realy Want To Submit Click Ok Otherwise Cencel it.")) {
										saveLock = true;
										$.ajax({
											url : '${timediffURL}',
											type : 'POST',
											data : {
												id : id,
												sdate : sdate,
												time : time,
												gradecode : gradecode,
												customer : customer,
												holes : holes,
												core : core,
												corrugation : corrugation,
												EdgeQulity : EdgeQulity,
												setnumber : setnumber,
												position : position,
												diameterofroll : diameterofroll,
												widthofroll : widthofroll,
												r1r2initial : r1r2initial,
												auditerinitial : auditerinitial,
												ed:ed,
												sd:sd,
												machinedown:"yes",
												shift:shift

											},
											success : function(data) {
												location.reload(true);
												//countTotalDuration();
											
												//var lotEle = tr.find('input[name=lot]');

												if (data.status) {
													idEle.val(data.id);
													$('#tmessage').text(data.message);
													clearTimer = setTimeout(function() {
														$('#tmessage').text('');
													}, 5000);

													if (lotEle) {
														lotEle.removeClass('redBorder');
													}

												} else {

													if (data.ERLOT) {
														setTimeout(function() {
															lotEle.focus();
														}, 100);
														lotEle.addClass('redBorder');
														alert(data.error);
													} else {
														alert(data.error);
													}

												}
												saveLock = false;
												location.reload(true);
											},
											error : function(xhr, status, error) {
												alert('Server error.. :-(');
												saveLock = false;
											}
										});
									
								 location.reload(true);
								 } else {
									  
									}
								}else{
									alert('Machine already down OR Entry already filled in given start and End time  please chose another time ');
								}
							}else{
								alert('All Entries are already Completed if you want to enter machine down first Delete Entry')
							}	
						},
						error : function(xhr, status, error) {
							alert('Server error.. :-(');
						}
					});			
				
			}
			
			
		});
	});
	

</script>
<script type="text/javascript">
	function saveData(jq) {
		$('#tmessage').text('');
		clearTimeout(clearTimer);

		var tr = jq.parent().parent();

		var id = tr.find('input[name=id]').val();
		var idEle = tr.find('input[name=id]');

		var sdate = tr.find('input[name=sdate]').val();
		var time = tr.find('select[name=time]').val();
		var gradecode = tr.find('select[name=gradecode]').val();
		var customer = tr.find('select[name=customer]').val();
		var setnumber = tr.find('input[name=setnumber]').val();
		var position = tr.find('input[name=position]').val();
		var holes = tr.find('select[name=holes]').val();
		var core = tr.find('select[name=core]').val();
		var corrugation = tr.find('select[name=corrugation]').val();
		var EdgeQulity = tr.find('select[name=EdgeQulity]').val();

		var widthofroll = tr.find('input[name=widthofroll]').val();
		var diameterofroll = tr.find('input[name=diameterofroll]').val();
		var r1r2initial = tr.find('input[name=r1r2initial]').val();
		var auditerinitial = tr.find('input[name=auditerinitial]').val();

		/*
		 var appereiance=tr.find('select[name=appereiance]').val();
		 var appereianceapllet=tr.find('select[name=appereianceapllet]').val();
		 var datecodeprinted=tr.find('select[name=datecodeprinted]').val();
		 var rolldiameter=tr.find('select[name=rolldiameter]').val();
		 var sdate=tr.find('input[name=sdate]').val();
		
		 */

		if (typeof sdate === 'undefined') {
			sdate = '';
		}
		var time = tr.find('select[name=time]').val();
		if (typeof time === 'undefined') {
			time = '';
		}
		var gradecode = tr.find('select[name=gradecode]').val();
		if (typeof gradecode === 'undefined') {
			gradecode = '';
		}

		var customer = tr.find('select[name=customer]').val();
		if (typeof holes === 'undefined') {
			holes = '';
		}
		var setnumber = tr.find('input[name=setnumber]').val();
		if (typeof holes === 'undefined') {
			holes = '';
		}

		var position = tr.find('input[name=position]').val();
		if (typeof holes === 'undefined') {
			holes = '';
		}

		var holes = tr.find('select[name=holes]').val();
		if (typeof holes === 'undefined') {
			holes = '';
		}
		var core = tr.find('select[name=core]').val();
		if (typeof core === 'undefined') {
			core = '';
		}
		var corrugation = tr.find('select[name=corrugation]').val();
		if (typeof corrugation === 'undefined') {
			corrugation = '';
		}
		var EdgeQulity = tr.find('select[name=EdgeQulity]').val();
		if (typeof EdgeQulity === 'undefined') {
			EdgeQulity = '';
		}

		var widthofroll = tr.find('input[name=widthofroll]').val();
		if (typeof widthofroll === 'undefined') {
			widthofroll = '';
		}

		var diameterofroll = tr.find('input[name=diameterofroll]').val();
		if (typeof diameterofroll === 'undefined') {
			diameterofroll = '';
		}
		var r1r2initial = tr.find('input[name=r1r2initial]').val();
		if (typeof r1r2initial === 'undefined') {
			r1r2initial = '';
		}

		var auditerinitial = tr.find('input[name=auditerinitial]').val();
		if (typeof auditerinitial === 'undefined') {
			auditerinitial = '';
		}
		/*	
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
		 var rolldiameter=tr.find('select[name=rolldiameter]').val();
		 if(typeof rolldiameter==='undefined'){
		 rolldiameter='';
		 }
		
		
		 */

		if (saveLock) {
			return;
		}
		saveLock = true;
		$.ajax({
			url : '${saveURL}',
			type : 'POST',
			data : {
				id : id,
				sdate : sdate,
				time : time,
				gradecode : gradecode,
				customer : customer,
				holes : holes,
				core : core,
				corrugation : corrugation,
				EdgeQulity : EdgeQulity,
				setnumber : setnumber,
				position : position,
				diameterofroll : diameterofroll,
				widthofroll : widthofroll,
				r1r2initial : r1r2initial,
				auditerinitial : auditerinitial

			},
			success : function(data) {

				//countTotalDuration();

				var lotEle = tr.find('input[name=lot]');

				if (data.status) {
					idEle.val(data.id);
					$('#tmessage').text(data.message);
					clearTimer = setTimeout(function() {
						$('#tmessage').text('');
					}, 5000);

					if (lotEle) {
						lotEle.removeClass('redBorder');
					}

				} else {

					if (data.ERLOT) {
						setTimeout(function() {
							lotEle.focus();
						}, 100);
						lotEle.addClass('redBorder');
						alert(data.error);
					} else {
						alert(data.error);
					}

				}
				saveLock = false;
			},
			error : function(xhr, status, error) {
				alert('Server error.. :-(');
				saveLock = false;
			}
		});
	
	}
</script>
<script type="text/javascript">
	var currentVal = '';
var saveLock;
var clearTimer;
$(function() {
	$('#yielddatatable tbody input, #yielddatatable tbody select').focusin(
			doFocusIn);
	$('#yielddatatable tbody input, #yielddatatable tbody select')
			.focusout(doFocusOut);

	$('#addRowBtn')
	.click(	function() {
		
		var id = $('input[name=id]').val();				
		var sdate = $('input[name=sdate]').val();
		var sdHH=$('select[name=fstartTimeHH]').val();
		var sdMM=$('select[name=fstartTimeMM]').val();				
		var edHH=$('select[name=fendTimeHH]').val();
		var edMM=$('select[name=fendTimeMM]').val();
		var sd=sdHH+":"+sdMM;
		var ed=edHH+":"+edMM;	
		
		 $.ajax({
				url : '${checkURL}',
				type : 'POST',
				data : {
					sd:sd,
					ed:ed,
					sdate : sdate
				},
				success : function(data) {
					if(data.count)
					{

						var date = new Date(); 
						var currentmonth = (date.getMonth() + 1);
						var currentdate = date.getDate();
						var currentyeare = date.getFullYear();
						var mdy;
					
						var otr = $('#yielddatatable tbody tr:last');
						var tr = $('#yielddatatable1 tbody tr:last').clone();
						tr.show();
						var ntr = tr.appendTo($('#yielddatatable tbody'));

						ntr.find('input').val('');
						ntr.find('select').val('');
						ntr.find('input[name=sdate]').removeAttr('id');

						var text = ntr.find('select[name=Shift]').val(
								$("#Shift option:selected").parent()
										.parent().parent().text()); // Find the text

						ntr.find('select[name=time]').val($('#time').val());
						ntr.find('input[name=sdate]')
								.val($('#sdate').val());
						ntr.find('select[name=time]').val(
								$("#time option:selected").text());
						ntr.find('select[name=gradecode]').val(
								$("#gradecode option:selected").text());
						ntr.find('select[name=customer]').val(
								$('#customer').val());
						ntr.find('select[name=holes]').val(
								$('#holes').val());
						ntr.find('select[name=core]').val($('#core').val());
						ntr.find('select[name=corrugation]').val(
								$('#corrugation').val());
						ntr.find('select[name=EdgeQulity]').val(
								$("#EdgeQulity option:selected").text());
						ntr.find('input[name=setnumber]').val(
								$("#setnumber").val());
						ntr.find('input[name=position]').val(
								$("#position").val());

						ntr.find('input[name=widthofroll]').val(
								$('#widthofroll').val());
						ntr.find('input[name=diameterofroll]').val(
								$('#diameterofroll').val());
						ntr.find('input[name=r1r2initial]').val(
								$('#r1r2initial').val());
						ntr.find('input[name=auditerinitial]').val(
								$('#auditerinitial').val());

						ntr.find('input').focusin(doFocusIn);
						ntr.find('select').focusin(doFocusIn);
						ntr.find('input').focusout(doFocusOut);
						ntr.find('select').focusout(doFocusOut);
					}else{
						alert('Today\'s Entry is complet ')
					}	
						},
						error : function(xhr, status, error) {
							alert('Server error.. :-(');
						}
					});		
					
		});
});

 function validatePQ(tb) {
	 
	if ($.trim(tb.val()) != '') 
	  {
		if ((tb.attr('name') == 'sdate') | (tb.attr('name') == 'time')
				| (tb.attr('name') == 'gradecode')
				| (tb.attr('name') == 'customer')
				| (tb.attr('name') == 'holes')
				| (tb.attr('name') == 'core')
				| (tb.attr('name') == 'corrugation')
				| (tb.attr('name') == 'EdgeQulity')
				| (tb.attr('name') == 'setnumber')
				| (tb.attr('name') == 'position')
				| (tb.attr('name') == 'widthofroll')
				| (tb.attr('name') == 'diameterofroll')
				| (tb.attr('name') == 'r1r2initial')
				| (tb.attr('name') == 'auditerinitial'))

	
	saveLock = false;
	return false;
	  }
} 

function doFocusIn() {
	currentVal = $(this).val();
}
function doFocusOut() {
	 if (validatePQ($(this))) {
		return;
	}

	if ($(this).val() == currentVal) {
		return;
	}

	saveData($(this));
}
</script>
<script type="text/javascript">
	$(function() {
		$('#deleterowbutton').click(function() {
			var dbtn = $(this);
			var val = $('#yielddatatable tbody input[name=id]:checked').val();
			if (typeof val === 'undefined') {
				alert('Select row');
			} else {
				if (val == '') {
					alert("First Row Can't Delete.");
					//$('#yielddatatable tbody input[name=id]:checked').parent().parent().remove();
				} else {
					dbtn.attr('disabled', 'disabled');
					$.ajax({
						url : '${deletewinderDataURL}',
						type : 'POST',
						data : {
							id : val
						},
						success : function(data) {
							if (data.status) {
								alert('Data removed from database.');
								location.reload(true);
							} else {
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
			<jsp:include page="./header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Daily Quality check list R1-R2</span>
				</div>
				<div class="table-selector">

					<table>
						<tr>
							<td>Date</td>
							<td><input readonly="readonly" type="text" name="sdate"id="sdate" value="${currentdate}" style="width: 80px; text-align: center;"></td>
							<td><security:authorize access="hasRole('ADMIN')">
									<input type="hidden" name="shiftdate" value="${shiftdate}">
									<security:authorize access="hasRole('ADMIN')">
										<button id="loadDataBtn">Load</button>
									</security:authorize>
								&nbsp;
							</security:authorize>
								<button id="addRowBtn">Add New Row</button> &nbsp;
								<button id="deleterowbutton">Delete</button>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								
							
								
								<td style="font-weight:bold;font-size: large">Machine DownTime &nbsp;&nbsp; </td>
									<td> Shift:</td>
							<!-- <td>
								 <select style="width: 100%;" name="shift" id="shift" onchange="operatorSelect(this.value);">
								    <option value="">Select Shift</option>
								 	<option value="day" >Day</option>
								 	<option value="night">Night</option>	 
								 
								 </select>							
							</td> -->
							<td>
							<table>
							
								<tr id="day" >
								<td>Start Time
								 
									 <select name="fstartTimeHH" ">
										<option value="0">HH</option>
										<c:forEach begin="0" end="23" var="h">
											
													<option value="${h}">${h}</option>
												
											
										</c:forEach>
									</select>
									<select name="fstartTimeMM" cssStyle="width:50px;">
										<option value="0">MM</option>
										<c:forEach begin="0" end="59" var="m">
											
											
													<option value="${m}">${m}</option>
												
										</c:forEach>
									</select> 
								 </td>
								 <td>End Time
								 	 <select name="fendTimeHH" ">
										<option value="0">HH</option>
										<c:forEach begin="0" end="23" var="h">
													<option value="${h}">${h}</option>
									</c:forEach>
									</select>
									<select name="fendTimeMM" cssStyle="width:50px;">
										<option value="0">MM</option>
										<c:forEach begin="0" end="59" var="m">
											
											
													<option value="${m}">${m}</option>
												
										</c:forEach>
									</select>
									<button id="machinedown">submit</button></td>									
								</tr>
							</table>
							</td>
							<td >
									<b><span  class="blink_me" id="timeDiff" >ToatlDuartion &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${totaldiff} Hr</span></b>
									</td>
							</tr>
					</table>
					
					
					<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<!-- <div style="position: absolute;   overflow: auto;width: 98%;bottom: 0;top: 102px;"> -->
<center>
<table id="yielddatatable1" class="table" style="width: 60%; display: none;">
	<tbody >
	 
		<tr  >
			<td><input type="radio" name="id" value=""> 
			<input	type="hidden" value="${date}" name="sdate">
		</td>
			<td><select name="time" id="time"
				style="width: 98px; padding: 2px;" required="required">
				<option value="">Select</option>
					<option value="7 AM" selected="selected">7 AM</option>
					<option value="10 AM">10 AM</option>
					<option value="1 PM">1 PM</option>
					<option value="4 PM">4 PM</option>
					<option value="7 PM">7 PM</option>
					<option value="10 PM">10 PM</option>
					<option value="1 AM">1 AM</option>
					<option value="4 AM">4 AM</option>
			</select></td>
			
				<td><select name="gradecode" id="gradecode"
	            style="width: 100px; padding: 2px;" required="required">
		<option value="">Select</option>
									<c:forEach items="${gradecode}" var="grade">
										<c:choose>
											<c:when test="${grade.gradeCode eq gradeCode}">
												<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
											</c:when>
											<c:otherwise>
												<option value="${grade.gradeCode}">${grade.gradeCode}</option>
											</c:otherwise>
										</c:choose>
									
										
									</c:forEach>
      </select></td>
      
      <td><select name="customer"
											style="width: 100px; padding: 1px;">
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
										</select> <!-- <input type="text" name="customer" value="" autocomplete="off"> -->
										</td>
										<td><input type="number" class="inpCls" value=""
											name="setnumber"></td>
										<td><input type="text" class="inpCls" value=""
											name="position"></td>
										<td><input type="text" class="inpCls" value=""
											name="widthofroll"></td>
										<td><input type="text" class="inpCls" value=""
											name="diameterofroll"></td>
										<td><select name="core" id="core"
											style="width: 98px; padding: 2px;" required="required">
											<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
										<td><select name="corrugation" id="corrugation"
											style="width: 98px; padding: 2px;" required="required">
											<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
										<td><select name="holes" id="holes"
											style="width: 98px; padding: 2px;" required="required">
											<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
										<td><select name="EdgeQulity" id="EdgeQulity"
											style="width: 80px; padding: 2px;" required="required">
												<option value="">Select</option>
												<option value="Good">Good</option>
												<option value="Fair">Fair</option>
												<option value="Poor">Poor</option>
										</select></td>

										<td><input type="text" class="inpCls" value=""
											name="r1r2initial"></td>
										<td><input type="text" class="inpCls" value=""
											name="auditerinitial"></td>
			
			</tr>
		</tbody></table>

<table id="yielddatatable" class="table" style="width: 60%;">
	<thead style="text-align: center;">
		<tr>
									<td></td>
									<td>Time</td>
									<td>Grade Code</td>
									<td>Customer</td>
									<td>setNumber</td>
									<td>Position</td>
									<td>Wigth of Roll</td>
									<td>Diameter of Roll</td>
									<td>Core</td>
									<td>Corrugation</td>
									<td>Holes</td>
									<td>EdgeQulity</td>
									<td>R1/R2 <br>Initial
									</td>
									<td>Auditer<br>Initial
									</td>


								</tr>
		
	</thead>
	<tbody>
	 <c:if test="${fn:length(data) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""> <input
				type="hidden" value="${date}" name="sdate"></td>
			<td><select name="time" id="time"
				style="width: 98px; padding: 2px;" required="required">
			    	<option value="">Select</option>					
					<option value="7 AM" selected="selected">7 AM</option>
					<option value="10 AM">10 AM</option>
					<option value="1 PM">1 PM</option>
					<option value="4 PM">4 PM</option>
					<option value="7 PM">7 PM</option>
					<option value="10 PM">10 PM</option>
					<option value="1 AM">1 AM</option>
					<option value="4 AM">4 AM</option>
			</select></td>
			
				<td><select name="gradecode" id="gradecode"
	            style="width: 100px; padding: 2px;" required="required">
		<option value="">Select</option>
									<c:forEach items="${gradecode}" var="grade">
										<c:choose>
											<c:when test="${grade.gradeCode eq gradeCode}">
												<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
											</c:when>
											<c:otherwise>
												<option value="${grade.gradeCode}">${grade.gradeCode}</option>
											</c:otherwise>
										</c:choose>
									
										
									</c:forEach>
      </select></td>
      
      <td><select name="customer"
											style="width: 100px; padding: 1px;">
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
										</select> <!-- <input type="text" name="customer" value="" autocomplete="off"> -->
										</td>
										<td><input type="number" class="inpCls" value=""
											name="setnumber"></td>
										<td><input type="text" class="inpCls" value=""
											name="position"></td>
										<td><input type="text" class="inpCls" value=""
											name="widthofroll"></td>
										<td><input type="text" class="inpCls" value=""
											name="diameterofroll"></td>
										<td><select name="core" id="core"
											style="width: 98px; padding: 2px;" required="required">
											<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
										<td><select name="corrugation" id="corrugation"
											style="width: 98px; padding: 2px;" required="required">
												<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
										<td><select name="holes" id="holes"
											style="width: 98px; padding: 2px;" required="required">
												<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
										</select></td>
										<td><select name="EdgeQulity" id="EdgeQulity"
											style="width: 80px; padding: 2px;" required="required">
												<option value="">Select</option>
												<option value="Good">Good</option>
												<option value="Fair">Fair</option>
												<option value="Poor">Poor</option>
										</select></td>

										<td><input type="text" class="inpCls" value=""
											name="r1r2initial"></td>
										<td><input type="text" class="inpCls" value=""
											name="auditerinitial"></td>
			
			</tr>
		</c:if>
		
		<c:if test="${fn:length(data) > 0 }">
									<c:forEach items="${data}" var="datas">
										<c:if test="${datas.machinedown=='yes' }">
										<tr>
										
										<td><input type="radio" name="id" value="${datas.id}">
											<fmt:formatDate value="${datas.date}" var="dateS" pattern="MM-dd-yyyy" /> <input style="width: 75px;"
												type="hidden" name="sdate" value="${dateS}"	autocomplete="off" id="Date">
												
										</td>
												<td  colspan="14" style="background-color: red;text-align: center;font-size: 15px">
													Machine Down &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<fmt:formatDate  value="${datas.stime}" var="dateS" pattern="HH:mm" />  Start Time : ${dateS} 
													<fmt:formatDate  value="${datas.etime}" var="dateE" pattern="HH:mm" />  End Time : ${dateE}  
												</td>
										</tr>				
										</c:if>
										<c:if test="${datas.machinedown=='No' }">
										<tr>
											<td><input type="radio" name="id" value="${datas.id}">
												<fmt:formatDate value="${datas.date}" var="dateS"
													pattern="MM-dd-yyyy" /> <input style="width: 75px;"
												type="hidden" name="sdate" value="${dateS}"
												autocomplete="off" id="Date"></td>
											<td><select name="time" id="time"
												style="width: 98px; padding: 2px;" required="required">
													<c:if test="${datas.time eq'7 AM' || datas.time eq ''}">
														<option value="7 AM" selected="selected">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM">4 AM</option>


													</c:if>
													<c:if test="${datas.time eq'10 AM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM" selected="selected">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM">4 AM</option>
													</c:if>
													<c:if test="${datas.time eq'1 PM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM" selected="selected">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM">4 AM</option>
													</c:if>
													<c:if test="${datas.time eq'4 PM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM" selected="selected">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM">4 AM</option>
													</c:if>
													<c:if test="${datas.time eq'7 PM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM" selected="selected">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM">4 AM</option>
													</c:if>
													<c:if test="${datas.time eq'10 PM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM" selected="selected">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM">4 AM</option>
													</c:if>
													<c:if test="${datas.time eq'1 AM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM" selected="selected">1AM</option>
														<option value="4 AM">4 AM</option>
													</c:if>
													<c:if test="${datas.time eq'4 AM'}">
														<option value="7 AM">7 AM</option>
														<option value="10 AM">10 AM</option>
														<option value="1 PM">1 PM</option>
														<option value="4 PM">4 PM</option>
														<option value="7 PM">7 PM</option>
														<option value="10 PM">10 PM</option>
														<option value="1 AM">1 AM</option>
														<option value="4 AM" selected="selected">4 AM</option>
													</c:if>

											</select></td>
											
									<td><select name="gradecode" id="gradecode" style="width: 98px; padding: 2px;" required="required">
												
									<c:forEach items="${gradecode}" var="gradecode">
										<c:choose>
											<c:when test="${gradecode.gradeCode eq datas.gradecode }">
												<option value="${datas.gradecode}" selected="selected">${datas.gradecode}</option>
											</c:when>
											<c:otherwise>
												<option value="${gradecode.gradeCode}">${gradecode.gradeCode}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
			                     </td>	
			                     <td> 
														<select name="customer" style="width: 100px;padding: 1px;">
															<option value="">Select</option>
																<c:forEach items="${customers}" var="customer">
																	<c:choose>
																		<c:when test="${customer eq datas.customer}">
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
											
											
										<td><input type="number" class="inpCls" value="${datas.setnumber}"
												name="setnumber"></td>
												
											<td><input type="text" class="inpCls" value="${datas.position}"
												name="position"></td>
												
											<td><input type="text" class="inpCls" value="${datas.widthofroll}"
												name="widthofroll"></td>
											<td><input type="text" class="inpCls" value="${datas.diameterofroll}"
												name="diameterofroll"></td>
												<td>
											<select name="core" id="core" style="width: 98px; padding: 2px;" required="required">
											<c:if test ="${datas.core eq'Yes' || datas.core eq'' }">
												<option value="Yes" selected="selected">Yes</option>
												<option value="No">No</option>
											</c:if>
											<c:if test ="${datas.core eq'No'}">
											<option value="">Select</option>
												<option value="Yes">Yes</option>
												<option value="No" selected="selected">No</option>
											</c:if>
												</select>
												<%-- <input type="text" class="inpCls" name="rollwidth" value="${datas.rollwidth}"/> --%>
											</td>
											
											
											<td>
											    <select name="corrugation" id="corrugation" style="width: 98px; padding: 2px;" required="required">
													<c:if test ="${datas.corrugation eq'Yes' || datas.corrugation eq'' }">
														<option value="Yes" selected="selected">Yes</option>
														<option value="No">No</option>
													</c:if>
													<c:if test ="${datas.corrugation eq'No'}">
														<option value="Yes">Yes</option>
														<option value="No" selected="selected">No</option>
													</c:if>
														</select>
												<%-- <input type="text" class="inpCls" name="rollwidth" value="${datas.rollwidth}"/> --%>
											</td>
											<!-- <td><select name="holes" id="holes"
												style="width: 98px; padding: 2px;" required="required">
													<option value="Yes">Yes</option>
													<option value="No">No</option>
											</select></td> -->
											
											<td>
											    <select name="holes" id="holes" style="width: 98px; padding: 2px;" required="required">
													<c:if test ="${datas.holes eq'Yes' || datas.holes eq'' }">
														<option value="Yes" selected="selected">Yes</option>
														<option value="No">No</option>
													</c:if>
													<c:if test ="${datas.holes eq'No'}">
														<option value="Yes">Yes</option>
														<option value="No" selected="selected">No</option>
													</c:if>
														</select>
												<%-- <input type="text" class="inpCls" name="rollwidth" value="${datas.rollwidth}"/> --%>
											</td>
											
											<!-- <td><select name="EdgeQulity" id="EdgeQulity"
												style="width: 80px; padding: 2px;" required="required">
													<option value="">Select</option>
													<option value="Good">Good</option>
													<option value="Fair">Fair</option>
													<option value="Poor">Poor</option>
											</select></td> -->
											
											
						<td>
			                        <select name="EdgeQulity" id="EdgeQulity" style="width: 80px; padding: 2px;" required="required">
									<option value="">Select</option>
									<c:if test ="${datas.edgequlity eq'Good' || datas.edgequlity eq ''}">
										<option value="Good" selected="selected">Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.edgequlity eq'Fair'}">
										<option value="Good" >Good</option>
										<option value="Fair"selected="selected">Fair</option>
										<option value="Poor">Poor</option>
									</c:if>
									<c:if test ="${datas.edgequlity eq'Poor'}">
										<option value="Good" >Good</option>
										<option value="Fair">Fair</option>
										<option value="Poor"selected="selected">Poor</option>
									</c:if>
								</select>
		        	</td>
			

											<td><input type="text" class="inpCls" value="${datas.r1r2initial}"
												name="r1r2initial"></td>
												
											<td><input type="text" class="inpCls" value="${datas.auditerinitial}"
												name="auditerinitial"></td>
												
											
										</tr>
										</c:if>
									</c:forEach>
								

								</c:if>
		
		</tbody>
		
	
	
	</table>
	</center>
	</div>

					
					

				</div>
				
			</div>

		</div>


	</div>

</body>
</html>
