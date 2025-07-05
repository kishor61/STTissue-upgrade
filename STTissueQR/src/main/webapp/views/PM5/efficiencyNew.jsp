<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<spring:url value="/pm5efficiency/timediff" var="timediffURL" />
<spring:url value="/pm5efficiency/timedurtation" var="timedurtationURL" />
<spring:url value="/pm5efficiency/savenew" var="saveURL" />
<spring:url value="/pm5efficiency/delete" var="deleteURL" />
<spring:url value="/pm5efficiency/totalduration" var="totalTimeURL" />

<spring:url value="/pm5efficiency/current/info" var="currentInfoURL" />

<script type="text/javascript">
	var currentValue;
	$(function() {
		countTotalDuration();

		
		$('#deleteBtn').click(function(){
			var val=$('#efficiencyTable tbody input[name=id]:checked').val();
			
			if(val=='0'){
				currentValue='';
				alert("First row can't be deleted.");
				return;
			}

			if(val){
				$.ajax({
					url : '${deleteURL}',
					type : 'POST',
					data : {
						id : val
					},
					success : function(data) {
						if (data.status) {
							alert('Data removed successfully.');
							location.reload(true);
						} else {
							alert('Fail to delete data from database.');
							location.reload(true);
						}
					}
				});
			}else{
				var tr=$('#efficiencyTable tbody input[name=id]:checked').parent().parent();
				tr.remove();
			}
		});
		
		if('${showOldDate}'=='true'){
			$('input[name=fdate]').datepicker({
				dateFormat : 'mm-dd-yy',
				changeMonth : true,
				changeYear : true,
				minDate : '${edate}',
				maxDate : '${ndate}',
				onClose:function(){
					saveData($(this));
					$(this).parent().next().children().focus();
				}
			});
		}
		

		$('input[name=fdate]').focusin(setCurrentValue);
		$('select[name=shift]').focusin(setCurrentValue);
		$('select[name=crew]').focusin(setCurrentValue);
		$('select[name=fstartTimeHH]').focusin(setCurrentValue);
		$('select[name=fstartTimeMM]').focusin(setCurrentValue);
		$('select[name=gradeCode]').focusin(setCurrentValue);
		$('select[name=secondaryCode]').focusin(setCurrentValue);
		$('select[name=fendTimeHH]').focusin(setCurrentValue);
		$('select[name=fendTimeMM]').focusin(setCurrentValue);
		$('input[name=reel]').focusin(setCurrentValue);
		$('input[name=comment]').focusin(setCurrentValue);

		/* 
		$('input[name=fendTimeMM]').focusin(function() {
			currentValue = $(this).val();
			if ($(this).val() == '0') {
				$(this).val('');
			}
		});
		$('input[name=fendTimeHH]').focusin(function() {
			currentValue = $(this).val();
			if ($(this).val() == '0') {
				$(this).val('');
			}
		}); */

		$('select[name=shift]').focusout(shift);
		$('select[name=crew]').focusout(crew);
		$('select[name=fstartTimeHH]').focusout(fstartTimeHH);
		$('select[name=fstartTimeMM]').focusout(fstartTimeMM);
		$('select[name=gradeCode]').focusout(gradeCode);
		$('select[name=secondaryCode]').focusout(secondaryCode);
		$('select[name=secondaryCode]').change(setPrimaryCode);
		$('select[name=fendTimeHH]').focusout(fendTimeHH);
		$('select[name=fendTimeMM]').focusout(fendTimeMM);
		$('input[name=reel]').focusout(reel);
		$('input[name=comment]').focusout(comment);

		$('#addNewBtn').click(
				function() {
					var otr = $('#efficiencyTable tbody tr:last');

					var tr = $('#efficiencyTable tbody tr:last').clone();

					var ntr = tr.appendTo($('#efficiencyTable tbody'));
					
					//ntr.find('input[name=fendTimeHH]').val(0);
					//ntr.find('input[name=fendTimeMM]').val(0);
					ntr.find('input[name=reel]').val('');
					ntr.find('input[name=comment]').val('');
					ntr.find('input[name=id]').val('');
					
					
					ntr.find('select[name=shift]').val(otr.find('select[name=shift]').val());
					ntr.find('select[name=crew]').val(otr.find('select[name=crew]').val());
					ntr.find('select[name=gradeCode]').val(otr.find('select[name=gradeCode]').val());
					
					ntr.find('select[name=fstartTimeHH]').val(0);
					ntr.find('select[name=fstartTimeMM]').val(0);
					ntr.find('select[name=fendTimeHH]').val(0);
					ntr.find('select[name=fendTimeMM]').val(0);
					
					ntr.find('#dHH').text('0');
					ntr.find('#dMM').text('0');
					
					
					ntr.find('select[name=secondaryCode]').val('');
					ntr.find('select[name=secondaryCode]').parent().parent().find('.primaryCode').text('');
					ntr.find('select[name=secondaryCode]').parent().parent().find('.timeDiff').text('');
					
					ntr.find('input[name=fdate]').removeAttr('id');
					ntr.find('input[name=fdate]').removeAttr('class');
					
					
					if('${showOldDate}'=='true'){
						ntr.find('input[name=fdate]').datepicker({
							dateFormat : 'mm-dd-yy',
							changeMonth : true,
							changeYear : true,
							minDate : '${edate}',
							maxDate : '${ndate}',
							onClose:function(){
								saveData($(this));
								$(this).parent().next().children().focus();
							}
						});
					}
					
					
					
					ntr.find('select[name=shift]').focusout(shift);
					ntr.find('select[name=crew]').focusout(crew);
					ntr.find('select[name=fstartTimeHH]').focusout(fstartTimeHH);
					ntr.find('select[name=fstartTimeMM]').focusout(fstartTimeMM);
					
					ntr.find('select[name=fendTimeHH]').focusout(fendTimeHH);
					ntr.find('select[name=fendTimeMM]').focusout(fendTimeMM);
					
					ntr.find('select[name=gradeCode]').focusout(gradeCode);
					ntr.find('select[name=secondaryCode]').focusout(secondaryCode);
					
					ntr.find('select[name=secondaryCode]').change(setPrimaryCode);

					//ntr.find('input[name=fendTimeHH]').focusout(fendTimeHH);
					//ntr.find('input[name=fendTimeMM]').focusout(fendTimeMM);
					
					ntr.find('input[name=reel]').focusout(reel);
					ntr.find('input[name=comment]').focusout(comment);

					ntr.find('input[name=fdate]').focusout(setCurrentValue);
					ntr.find('select[name=shift]').focusout(setCurrentValue);
					ntr.find('select[name=crew]').focusout(setCurrentValue);
					
					ntr.find('select[name=fstartTimeHH]').focusout(setCurrentValue);
					ntr.find('select[name=fstartTimeMM]').focusout(setCurrentValue);
					
					ntr.find('select[name=fendTimeHH]').focusout(setCurrentValue);
					ntr.find('select[name=fendTimeMM]').focusout(setCurrentValue);
					
					
					ntr.find('select[name=gradeCode]').focusout(setCurrentValue);
					ntr.find('select[name=secondaryCode]').focusout(setCurrentValue);
					ntr.find('input[name=reel]').focusout(setCurrentValue);
					ntr.find('input[name=comment]').focusout(setCurrentValue);

					/* ntr.find('input[name=fendTimeMM]').focusin(function() {
						currentValue = $(this).val();
						if ($(this).val() == '0') {
							$(this).val('');
						}
					});
					ntr.find('input[name=fendTimeHH]').focusin(function() {
						currentValue = $(this).val();
						if ($(this).val() == '0') {
							$(this).val('');
						}
					});
 */
				//	
					if('${showOldDate}'=='false'){
						ntr.hide();
						$.ajax({
							url : '${currentInfoURL}',
							type :'POST',
							success:function(data){
								ntr.find('input[name=fdate]').val(data.date);	
								ntr.show();	
							},error:function(){
								location.reload(true);
							}
						});
						
					}
				});

		
	});
	function shift() {
		if ($(this).val() != '') {
			saveData($(this));
		}
	}

	function crew() {
		if ($(this).val() != '') {
			saveData($(this));
		}
	}

	function fstartTimeHH() {
		if ($(this).val() != '') {
			saveData($(this));
		}
		setEndTime($(this));
	}

	function fstartTimeMM() {
		
		if ($(this).val() != '') {
			saveData($(this));
		}
		setEndTime($(this));
	}

	function gradeCode() {
		if ($(this).val() != '') {
			saveData($(this));
		}
	}

	function secondaryCode() {
		if ($(this).val() != '') {
			saveData($(this));
		}
	}

	function fendTimeHH() {
		
		if ($(this).val() != '') {
			saveData($(this));
		}
		/* if ($('input[name=fendTimeHH]').val() == '') {
			$('input[name=fendTimeHH]').val(0);
		} */
		setEndTime($(this));
	}

	function fendTimeMM() {
		
		if ($(this).val() != '') {
			saveData($(this));
		}
		/* if ($('input[name=fendTimeMM]').val() == '') {
			$('input[name=fendTimeMM]').val(0);
		} */
		setEndTime($(this));
	}

	function reel() {
		//countTotalDuration();

		if ($(this).val() != '') {
			saveData($(this));
		}
	}
	function comment() {
		//countTotalDuration();

		if ($(this).val() != '') {
			saveData($(this));
		}
	}

	function setCurrentValue() {


		currentValue = $(this).val();
	}

	function setPrimaryCode() {
		//countTotalDuration();

		var element = $(this).find('option:selected');
		$(this).parent().parent().find('.primaryCode').text(element.attr('data-pcode'));
	}

	var saveFlag=false;
	var flagTimer;
	function saveData(jq) {
		
		
		
		$('#tmessage').text('');
		clearTimeout(flagTimer);
		if (jq.val() != currentValue) {
			
			var tr=jq.parent().parent();
			
			var id=tr.find('input[name=id]').val();
			var idEle=tr.find('input[name=id]');
			var fdate=tr.find('input[name=fdate]').val();
			var shift=tr.find('select[name=shift]').val();
			var crew=tr.find('select[name=crew]').val();
			var fstartTimeHH=tr.find('select[name=fstartTimeHH]').val();
			var fstartTimeMM=tr.find('select[name=fstartTimeMM]').val();
			var fendTimeHH=tr.find('select[name=fendTimeHH]').val();
			var fendTimeMM=tr.find('select[name=fendTimeMM]').val();
			var reel=tr.find('input[name=reel]').val();
			var gradeCode=tr.find('select[name=gradeCode]').val();
			var secondaryCode=tr.find('select[name=secondaryCode]').val();
			var comment=tr.find('input[name=comment]').val();
			
			
			
			if(secondaryCode!=''){
				
				if(saveFlag){
					return;
				}
				
				saveFlag=true;
				
				$.ajax({
					url:'${saveURL}',
					type:'POST',
					data:{
						id : id,
						fdate : fdate,
						shift : shift,
						crew : crew,
						fstartTimeHH : fstartTimeHH,
						fstartTimeMM : fstartTimeMM,
						fendTimeHH : fendTimeHH,
						fendTimeMM : fendTimeMM,
						reel : reel,
						gradeCode : gradeCode,
						secondaryCode : secondaryCode,
						comment : comment
					},
					success:function(data){
						if(data.status){
							idEle.val(data.id);
							$('#tmessage').text(data.message);
							flagTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
						}else{
							alert(data.error);
						}
						saveFlag=false;
						
						
					},
					error: function(xhr, status, error) {
						saveFlag=false;
						alert('Fail to save data in database.');
						location.reload(true);
					}
				});
				
			}
			
		}
	}
	
	function setEndTime(jq){
		var tr=jq.parent().parent();
		
		var sdHH=tr.find('select[name=fstartTimeHH]').val();
		var sdMM=tr.find('select[name=fstartTimeMM]').val();
		
		var edHH=tr.find('select[name=fendTimeHH]').val();
		var edMM=tr.find('select[name=fendTimeMM]').val();
		var sd=sdHH+":"+sdMM;
		var ed=edHH+":"+edMM;
		
		
		if(sd!='' && ed!=''){
			
			$.ajax({
				url:'${timedurtationURL}',
				type:'POST',
				data:{
					sd:sd,
					ed:ed
				},
				success:function(data){
					
					tr.find('#dHH').text(data.hh);
					tr.find('#dMM').text(data.mm);
					
					countTotalDuration();
				}
				
			});
		}
		
		
	}
	
function countTotalDuration(){
	
	
	var ehh=0;
	var emm=0;
	
  	$('#efficiencyTable tbody tr').each(function(i){
		var hs=$(this).find('#dHH').text();
		if(hs==''){
			hs='0';
		}
		if(!(isNaN(hs))){
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
	
}
	
</script>
<style type="text/css">
.table tbody td {
	margin: 0px;
	text-align: center;
}

.table tbody td input,.table tbody td select {
	width: inherit;
}

.table tbody td input {
	text-align: center;
}
/* Adjust textareas (if needed) */
.form-textarea {
    resize: vertical; /* Allow resizing of textareas vertically */
    height: 40px; /* Set height for a better look */
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    background-color: #f9f9f9;
    width: 100%;
    font-size: 14px;
}
/* Make all form fields have the same height */
input[type="text"], select, .form-textarea {
    height: 40px; /* Set a consistent height for input fields and selects */
    font-size: 14px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    background-color: #f9f9f9;
    width: 100%; /* Make it responsive */
    box-sizing: border-box;
    transition: all 0.3s ease;
}
/* Add padding to <td> for better spacing */
td {
    padding: 12px;
    vertical-align: middle; /* Ensure vertical centering in td */
}
/* Adjust width for <select> elements where necessary */
select[name="shift"],
select[name="crew"],
select[name="fstartTimeHH"],
select[name="fstartTimeMM"],
select[name="fendTimeHH"],
select[name="fendTimeMM"],
select[name="gradeCode"],
select[name="secondaryCode"] {
    width: 100%; /* Ensure selects take up available width */
}
/* Adjust select dropdown style */
select {
    padding: 10px;
    font-size: 14px;
    border-radius: 6px;
    background-color: #f9f9f9;
}

/* Uniform style for inputs when focused */
input[type="text"]:focus, select:focus {
    border-color: #4CAF50;
    background-color: #e6f7ff; /* Light blue background when focused */
    outline: none;
    box-shadow: 0 0 8px rgba(72, 144, 226, 0.3); /* Light blue glow */
}

</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div class="content-header" style=" padding-top: 10px !important;  padding-bottom: 0px !important; line-height: 0px !important;">
			<h5 style="text-align:center; font-weight:bold;color:#343e70;">Efficiency- Data Entry For PM5</h5>
	   </div>

		<div class="block3">
			<div class="pageContent">

				

<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">
<spring:url value="/pm5efficiency/new" var="oldDataURL" />
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
				var flag=confirm("Current shift date is "+shiftDate+". Do you want to load old data?");
				if(flag){
					location.href='${oldDataURL}/'+odate;
				}
			}else{
				location.href='${oldDataURL}';
			}
		});
		
	});
</script>

</security:authorize>


				<div class="table-selector"style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">

					<table>
						<tr>
							<td>Date</td>
							<td><input readonly="readonly" type="text" name="edate"
								value="${edate}" style="width: 80px; text-align: center;"></td>
							<td>
							<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">
								<input type="hidden" name="shiftdate" value="${shiftdate}">
								<button id="loadDataBtn">Load</button>
								&nbsp;
							</security:authorize>
								<button id="addNewBtn"class="btn btn-success btn-sm">Add New Row</button>
								&nbsp;
								<button id="deleteBtn"class="btn btn-danger btn-sm">
									Delete
								</button>
							</td>
						</tr>
					</table>

				</div>



				<c:set var="shifts" value="${fn:split('Day,Night',',')}"
					scope="request" />
				<c:set var="crews" value="${fn:split('A,B,C,D',',')}"
					scope="request" />

				<div
					style=width: 98%;bottom: 0;top: 102px;">
					<table id="efficiencyTable" class="table" style="font-size: 12px;">
						<thead style="text-align:center">
							<tr>
								<th rowspan="2"></th>
								<th rowspan="2">Date</th>
								<th rowspan="2">Shift</th>
								<th rowspan="2">Crew</th>
								<th colspan="2">Start Time</th>
								<th colspan="2">End Time</th>
								<th colspan="2">Duration</th>
								<th rowspan="2">Reel#</th>
								<th rowspan="2">Grade code</th>
								<th rowspan="2">Down Time Secondary Code</th>
								<th rowspan="2">Down Time Primary Code</th>
								<th rowspan="2">Comments</th>
							</tr>
							<tr>


								<th>HH</th>
								<th>MM</th>
								<th>HH</th>
								<th>MM</th>
								<th>HH</th>
								<th>MM</th>
							</tr>
						</thead>
						<tbody>
						
						<c:if test="${fn:length(efficiencies)>0 }">
<c:forEach items="${efficiencies}" var="ef">
	<tr>
	<td style="width: 10px;height: 40px;">
		
		<input type="radio" name="id" value="${ef.id}">
	</td>
	<td style="width: 70px;height: 40px;">
		<fmt:formatDate value="${ef.date}" pattern="MM-dd-yyyy" var="fmtDate"/>
		<input readonly="readonly" type="text" name="fdate" value="${fmtDate}"></td>
	<td style="width: 80px;height: 40px;">
		<select name="shift">
			<option value="">Select</option>
			<c:forEach items="${shifts}" var="s">
				<c:choose>
					<c:when test="${s eq ef.shift}">
						<option value="${s}" selected="selected">${s}</option>
					</c:when>
					<c:otherwise>
						<option value="${s}">${s}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</td>
	<td style="width: 80px;height: 40px;">
		<select name="crew">
			<option value="">Select</option>
			<c:forEach items="${crews}" var="c">
				<c:choose>
					<c:when test="${c eq ef.crew }">
						<option value="${c}" selected="selected">${c}</option>	
					</c:when>
					<c:otherwise>
						<option value="${c}">${c}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</td>
	<td style="width: 70px;height: 40px;">
		<fmt:formatDate value="${ef.startTime}" pattern="H" var="sH"/>
		
		<select name="fstartTimeHH">
			<option value="0">00</option>
			<c:forEach begin="1" end="23" var="h">
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
	</td>
	<td style="width: 70px;height: 40px;">
		<fmt:formatDate value="${ef.startTime}" pattern="m" var="sM"/>
		
		<select name="fstartTimeMM">
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
	<%-- <td style="width: 70px;height: 40px;">
		<input type="text" name="fendTimeHH" value="${ef.fendTimeHH}"  autocomplete="off">
	</td>
	<td style="width: 70px;">
		<input type="text" name="fendTimeMM" value="${ef.fendTimeMM}"  autocomplete="off">
	</td>
	 --%>
	 
	 <td style="width: 70px;">
		<fmt:formatDate value="${ef.endTime}" pattern="H" var="sH"/>
		
		<select name="fendTimeHH">
			<option value="0">00</option>
			<c:forEach begin="1" end="23" var="h">
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

	</td>
	<td style="width: 70px;">
		<fmt:formatDate value="${ef.endTime}" pattern="m" var="sM"/>
		
		<select name="fendTimeMM">
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
		<span id="dHH">${ef.fendTimeHH }</span>
	</td>
	<td>
		<span id="dMM">${ef.fendTimeMM}</span>
	</td>
	<td style="width: 80px;">
		<input type="text" name="reel" value="${ef.reel}"  autocomplete="off"></td>
	<td style="width: 100px;">
		<select name="gradeCode">
			<option value="">Select</option>
			<c:forEach items="${grades}" var="grade">
				<c:choose>
					<c:when test="${grade.gradeCode eq ef.gradeCode}">
						<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
					</c:when>
					<c:otherwise>
						<option value="${grade.gradeCode}">${grade.gradeCode}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</td>
	<td style="width: 180px;">
		<select name="secondaryCode">
			<option value="" data-pcode="">Select</option>
			<c:forEach items="${codes}" var="scode">
				<c:choose>
					<c:when test="${scode.id eq ef.secondaryCode.id}">
						<option value="${scode.id}" data-pcode="${scode.primaryCode.code}" selected="selected">${scode.code}</option>
					</c:when>
					<c:otherwise>
						<option value="${scode.id}" data-pcode="${scode.primaryCode.code}">${scode.code}</option>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</select>
	</td>
	<td style="width: 180px;">
		<span style="display: block; width: inherit;" class="primaryCode">${ef.secondaryCode.primaryCode.code }</span>
	</td>
	<td style="width: 250px;">
		<input type="text" name="comment" value="${ef.comment}" autocomplete="off">
	</td>


</tr>
							</c:forEach>
						
						</c:if>
						
						
						
						
						<c:if test="${fn:length(efficiencies) eq 0 }">
							<tr>
								<td style="width: 10px;">
									<input type="radio" name="id" value="0">
								</td>
								<td style="width: 80px;"><input readonly="readonly"
									type="text" name="fdate" value="${edate}"></td>
								<td style="width: 80px;"><select name="shift">
										<option value="">Select</option>
										<c:forEach items="${shifts}" var="s">
											<option value="${s}">${s}</option>
										</c:forEach>
								</select></td>
								<td style="width: 80px;"><select name="crew">
										<option value="">Select</option>
										<c:forEach items="${crews}" var="c">
											<option value="${c}">${c}</option>
										</c:forEach>
								</select></td>
								<td style="width: 70px;"><select name="fstartTimeHH">
										<option value="0">00</option>
										<c:forEach begin="1" end="23" var="h">
											<option value="${h}"><fmt:formatNumber
													minIntegerDigits="2" value="${h}" />
											</option>
										</c:forEach>
								</select></td>
								<td style="width: 70px;"><select name="fstartTimeMM">
										<option value="0">00</option>
										<c:forEach begin="1" end="59" var="m">
											<option value="${m}"><fmt:formatNumber
													minIntegerDigits="2" value="${m}" />
											</option>
										</c:forEach>
								</select></td>
								
								<!-- <td style="width: 70px;"><input type="text"
									name="fendTimeHH" value="0"  autocomplete="off"></td>
								<td style="width: 70px;"><input type="text"
									name="fendTimeMM" value="0"  autocomplete="off"></td> -->
									
								
								<td style="width: 70px;"><select name="fendTimeHH">
										<option value="0">00</option>
										<c:forEach begin="1" end="23" var="h">
											<option value="${h}"><fmt:formatNumber
													minIntegerDigits="2" value="${h}" />
											</option>
										</c:forEach>
								</select></td>
								<td style="width: 70px;"><select name="fendTimeMM">
										<option value="0">00</option>
										<c:forEach begin="1" end="59" var="m">
											<option value="${m}"><fmt:formatNumber
													minIntegerDigits="2" value="${m}" />
											</option>
										</c:forEach>
								</select></td>
								
								<td>
		<span id="dHH">${ef.fendTimeHH }</span>
	</td>
	<td>
		<span id="dMM">${ef.fendTimeMM}</span>
	</td>
									
		<!-- 						<td style="width: 80px;"><span
									style="display: block; width: inherit;" class="timeDiff"></span>
								</td>
		 -->						<td style="width: 80px;">
									<input type="text" name="reel"
									value=""  autocomplete="off"></td>
								<td style="width: 150px;"><select name="gradeCode">
										<option value="">Select</option>
										<c:forEach items="${grades}" var="grade">
											<option value="${grade.gradeCode}">${grade.gradeCode}</option>
										</c:forEach>
								</select></td>
								<td style="width: 180px;"><select name="secondaryCode">
										<option value="" data-pcode="">Select</option>
										<c:forEach items="${codes}" var="scode">
											<%-- <c:choose>
												<c:when test="${scode.id eq}">
													<option value="${scode.id}" title="${scode.primaryCode.code}" selected="selected">${scode.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${scode.id}" title="${scode.primaryCode.code}">${scode.code}</option>
												</c:otherwise>
											</c:choose> --%>
											<option value="${scode.id}"
												data-pcode="${scode.primaryCode.code}">${scode.code}</option>
										</c:forEach>
								</select></td>
								<td style="width: 180px;">
									<span style="display: block; width: inherit;" class="primaryCode"></span>
								</td>
								<td style="width: 250px;">
								
									<input type="text" name="comment" value="" autocomplete="off">
								
								</td>


							</tr>
						
						</c:if>
						
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="6" ></td>
								<td colspan="2" align="right"><b>Total Duration: </b></td>
								<td align="center">
									<span id="tHH"></span>
								</td>
								<td align="center">
									<span id="tMM"></span>
								</td>
								<td colspan="5"></td>
							</tr>
						</tfoot>
					</table>

				</div>

			</div>

		</div>


	</div>
	<!-- /.content-wrapper -->
	                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
	                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
	                   </footer>
</div>
</body>
</html>
