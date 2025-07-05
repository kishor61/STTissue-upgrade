<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<style type="text/css">
.table input,.table select {
	width: inherit;
	text-align: center;
}
.table td{
	padding: 0 !important;
}
</style>


<spring:url value="/frppressquality/new" var="newTypeURL" />
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;


$(function(){
		$('select[name=pType]').change(function(){
			var val=$(this).val();
			
			if(val!=''){
				location.href='${newTypeURL}/'+val;
			}else{
				location.href='${newTypeURL}';
			}
			
		});
		
		$('input[name=date]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0,
			onClose:function(){
			//	saveData($(this));
				$(this).parent().next().children().focus();
			}
		});
		
		// Bind focus handlers for ST table
		$('#qualityDataTableST tbody input, #qualityDataTableST tbody select').unbind('focusin focusout');
		$('#qualityDataTableST tbody input, #qualityDataTableST tbody select').on('focusin', doFocusInst).on('focusout', doFocusOutst);
		
		$('#addRowBtn').click(function(){
			 if ($('select[name=pType]').val() === 'ST') {
          var $tbody = $('#qualityDataTableST tbody'),
              // capture the last non-empty date seen
              lastDate = $tbody.find('input[name=date]').map(function(){
                return this.value;
              }).get().reverse().filter(Boolean)[0] || '${date}';

          // clone the first 10 rows template
          var template = $tbody.find('tr').slice(0,10).clone();

          // clear only the id fields, reset others except date
          template.each(function(){
            $(this).find('input').each(function(){
              var nm = this.name;
              if (nm === 'id')        { $(this).val(''); }
              else if (nm === 'date') { $(this).val(lastDate); }
              else                    { $(this).val(''); }
            });
            // rebind ST focus handlers
            $(this).find('input, select').unbind('focusin focusout');
            $(this).find('input, select').on('focusin', doFocusInst).on('focusout', doFocusOutst);
          });

          $tbody.append(template);
          template.first().find('input').first().focus();
			 }
    else{
			
			var otr = $('#qualityDataTable tbody tr:last');
			var odate=otr.find('input[name=date]').val();
			var tr = $('#qualityDataTable tbody tr:last').clone();
			
			var ntr = tr.appendTo($('#qualityDataTable tbody'));
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=date]').removeAttr('id');
			ntr.find('input[name=date]').removeAttr('class');
			ntr.find('input[name=date]').val(odate);
			ntr.find('input[name=date]').datepicker({
				dateFormat : 'mm-dd-yy',
				changeMonth : true,
				changeYear : true,
				onClose:function(){
					//saveData($(this));
					$(this).parent().next().children().focus();
				}
			});
			
			ntr.find('input[name=time]').focus();
			ntr.find('input').focusin(doFocusIn);
			ntr.find('select').focusin(doFocusIn);
			ntr.find('input').focusout(doFocusOut);
			ntr.find('select').focusout(doFocusOut);

			}
			
		});
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( (tb.attr('name')=='initials') | 
				(tb.attr('name')=='grade') |
				(tb.attr('name')=='cuRunning')|
				(tb.attr('name')=='comments') |
				(tb.attr('name')=='frpSludgePressRunning') |
				(tb.attr('name')=='frpScrewPressRunning') |
// 				Code Starts From Here Done By Roshan Tailor Date :- 03/16/2015
				(tb.attr('name')=='astar') |
				(tb.attr('name')=='bstar') |
				(tb.attr('name')=='line') |
				(tb.attr('name')=='comment') |
// 				Code Ends Here Done By Roshan Tailor
				(tb.attr('name')=='date')
				){
					//Do Nothing
			}else if(tb.attr('name')=='time'){
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
	function doFocusInst(){
		currentVal=$(this).val();
	}
	function doFocusOutst(){		
		saveData($(this));
	}
	
	$(document).ready(function(){
		// Get values from input fields for Press A and B counts
		var psfcountA=$('input[name=psfcountA]').val(); // Primary Fine Screen Feed count for Press A
		var psacountA=$('input[name=psacountA]').val(); // Primary Fine Screen Accepts count for Press A  
		var psfcountB=$('input[name=psfcountB]').val(); // Primary Fine Screen Feed count for Press B
		var psacountB=$('input[name=psacountB]').val(); // Primary Fine Screen Accepts count for Press B
		var efficiencyA=$('input[name=efficiencyA]').val(); // Efficiency % for Press A
		var efficiencyB=$('input[name=efficiencyB]').val(); // Efficiency % for Press B
		
		// Validation checks - highlight fields in red if invalid:
		
		// Press A Feed count should be positive
		if(parseInt(psfcountA)<=0)
			$('input[name=psfcountA]').css("background-color", "red");
			
		// Press A Accepts count should be:
		// - Greater than 0 (positive)
		// - Less than Feed count (can't accept more than total feed)
		if(parseInt(psacountA)<=0||parseInt(psacountA)>parseInt(psfcountA))
			$('input[name=psacountA]').css("background-color", "red");
			
		// Same validation for Press B counts
		if(parseInt(psfcountB)<=0)
			$('input[name=psfcountB]').css("background-color", "red");
		if(parseInt(psacountB)<=0||parseInt(psacountB)>parseInt(psfcountB))
			$('input[name=psacountB]').css("background-color", "red");	
	
		// If efficiency is invalid (<=0), highlight all related fields
		if(parseInt(efficiencyA)<=0)
		{
			$('input[name=psfcountA]').css("background-color", "red");
			$('input[name=psacountA]').css("background-color", "red");
			$('input[name=efficiencyA]').css("background-color", "red");
		}
		if(parseInt(efficiencyB)<=0)
		{
			$('input[name=psfcountB]').css("background-color", "red");
			$('input[name=psacountB]').css("background-color", "red");
			$('input[name=efficiencyB]').css("background-color", "red");
		}

		// Calculate efficiency if counts are valid
		// Efficiency Formula = ((Feed Count - Accepts Count) / Feed Count) * 100
		// This shows what percentage of input material was removed/rejected
		if(parseInt(psfcountA)>=0 && parseInt(psacountA)>=0){
			var efficiencyA =Math.round( ((parseInt(psfcountA)-parseInt(psacountA))/parseInt(psfcountA))*100);
			var efficiencyA= $('input[name=efficiencyA]').val(parseInt(efficiencyA));	
		}
		
		if(parseInt(psacountB)>=0 && parseInt(psfcountB)>=0){			
			var efficiencyB =Math.round( ((parseInt(psfcountB)-parseInt(psacountB))/parseInt(psfcountB))*100);
			$('input[name=efficiencyB]').val(efficiencyB);
		}				
	});
</script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
		<jsp:include page="./header.jsp"></jsp:include>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP Press Quality Data</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table style="margin: auto;">
						<tr>
						
							<td> &nbsp;&nbsp; Press Quality Type</td>
							<td>
								<select name="pType" style="width: 200px;">
									<option value="">Select</option>
									<c:forEach items="${qtypes }" var="qtype">
										<c:choose>
											<c:when test="${qtype.key eq  type }">
												<option value="${qtype.key}" selected="selected">${qtype.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${qtype.key}">${qtype.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<c:if test="${not empty type}">
								&nbsp;&nbsp;
								<button id="addRowBtn">Add Row</button>
								&nbsp;&nbsp;
								<button id="deleteRowBtn">Delete</button>
								<c:if test="${type eq 'SH'}">
									<button onclick="location.href='<spring:url value="/frppressquality/shbackdatedentry"/>'">Back Dated Entry</button></td> 
								</c:if>
								</c:if>
							</td>	
												
						</tr>
					</table>

				</div>

				<br>
<c:if test="${not empty type}">



<!-- Code Starts (Modified) From Here Done By Roshan Tailor Date :- 03/21/2015 -->
<c:if test="${type eq 'SPC' || type eq 'TPQ' || type eq 'TPQ2'||type eq 'SECPRESSQ' ||type eq 'WL' || type eq 'IPSC'}">
<!-- Code Ends Here Done By Roshan Tailor -->
<spring:url value="/frppressquality/save" var="saveURL" />
<spring:url value="/frppressquality/delete" var="deleteURL" />


<script type="text/javascript">

$(function(){
	$('#deleteRowBtn').click(function(){
		
		var rowCount = $('#qualityDataTable tbody tr').length;
		if(rowCount==1){
			alert("You can't delete first row.");
			return;
		}
		
		var dbtn=$(this);
		var val=$('#qualityDataTable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#qualityDataTable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
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

function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	var date=tr.find('input[name=date]').val();
	var time=tr.find('input[name=time]').val();
	
	if(time==''){
		alert("Please enter valid time.");
		tr.find('input[name=time]').focus();
		return;
	}
	
	var lot=tr.find('input[name=lot]').val();
	if(typeof lot==='undefined'){
		lot=0;
	}
	var initials=tr.find('input[name=initials]').val();
	if(typeof initials==='undefined'){
		initials='';
	}
// 	Code Starts From Here Done By Roshan Tailor Date :- 04/01/2015
	var bleachingchemical=tr.find('input[name=bleachingchemical]').val();
	if(typeof bleachingchemical==='undefined'){
		bleachingchemical='';
	}
	
// Code ends Here Done By Roshan Tailor
	var grade=tr.find('select[name=grade]').val();
	if(typeof grade==='undefined'){
		grade='';
	}
	var brightness=tr.find('input[name=brightness]').val();
	if(typeof brightness==='undefined'){
		brightness=0;
	}
// 	Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
	
	var line=tr.find('select[name=line]').val();
	if(typeof line==='undefined'){
		line='';
	}
	
	var lvalue=tr.find('input[name=lvalue]').val();
	if(typeof lvalue==='undefined'){
		lvalue=0;
	}
	var avalue=tr.find('input[name=avalue]').val();
	if(typeof avalue==='undefined'){
		avalue=0;
	}
	var bvalue=tr.find('input[name=bvalue]').val();
	if(typeof bvalue==='undefined'){
		bvalue=0;
	}
	
// Code Ends Here Done By Roshan Tailor
	var dirt=tr.find('input[name=dirt]').val();
	if(typeof dirt==='undefined'){
		dirt=0;
	}
	var stickies=tr.find('input[name=stickies]').val();
	if(typeof stickies==='undefined'){
		stickies=0;
	}
	var consistency=tr.find('input[name=consistency]').val();
	if(typeof consistency==='undefined'){
		consistency=0;
	}
	var ash=tr.find('input[name=ash]').val();
	if(typeof ash==='undefined'){
		ash=0;
	}
	var cuRunning=tr.find('select[name=cuRunning]').val();
	if(typeof cuRunning==='undefined'){
		cuRunning='';
	}
	var comments=tr.find('input[name=comments]').val();
	var qualityType=$('select[name=pType]').val();
	if(qualityType==''){
		return;
	}

	if(qualityType=='WL'){
		if(lot==0){
			tr.find('input[name=lot]').focus();
			return;
		}
		
	}
	
	
	//New Field
	var freeness=tr.find('input[name=freeness]').val();
	if(typeof freeness==='undefined'){
		freeness=0;
	}
	//Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015
	var eric=tr.find('input[name=eric]').val();
	if(typeof eric==='undefined'){
		eric=0;
	}
	var astar=tr.find('select[name=astar]').val();
	if(typeof astar==='undefined'){
		astar=0;
	}
	var bstar=tr.find('select[name=bstar]').val();
	if(typeof bstar==='undefined'){
		bstar=0;
	}
	//Code Ends Here Done By Roshan Tailor
	if(freeness<0 | freeness>1000){
		alert('Freeness range should be 0 - 1000.');
		tr.find('input[name=freeness]').focus();
		return;
	}
	if(consistency!=0 & qualityType!='IPSC'){
		if(consistency<20 | consistency>60){
			tr.find('input[name=consistency]').focus();
			alert('Consistency  range should be 20% - 60%.');
			return;
		}
	}
	
// 	alert("lvalue::"+lvalue);
// 	alert("avalue::"+avalue);
// 	alert("bvalue::"+bvalue);
	
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
			time : time,
			lot : lot,
			initials : initials,
// 			Code Starts From Here Done By Roshan TAilor Date :- 04/01/2015
			bleachingchemical : bleachingchemical,
// 			Code Ends Here Done By Roshan Tailor
			grade : grade,
			brightness : brightness,
// 			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015
			lvalue : lvalue,
			avalue : avalue,
			bvalue : bvalue,
// 			Code Ends Here Done By Roshan Tailor
			dirt : dirt,
			stickies : stickies,
			consistency : consistency,
			ash : ash,
			cuRunning : cuRunning,
			comments : comments,
			qualityType : qualityType,
			freeness : freeness,
			//Code Starts From Here Done By Roshan Tailor Date :- 03/24/2015 MM/DD/YYYY
			eric : eric,
			astar : astar,
			bstar : bstar,
			line : line 
			//Code Ends Here Done By Roshan Tailor
			
			
		},
		success:function(data){
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
	
}
</script>


</c:if>

<c:if test="${type eq 'SH'}">

<spring:url value="/frppressquality/savesludgehauling" var="saveURL" />
<spring:url value="/frppressquality/deletesludgehauling" var="deleteURL" />

<script type="text/javascript">

$(function(){
$('#deleteRowBtn').click(function(){
		
		var rowCount = $('#qualityDataTable tbody tr').length;
		if(rowCount==1){
			alert("You can't delete first row.");
			return;
		}
		
		var dbtn=$(this);
		var val=$('#qualityDataTable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#qualityDataTable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
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

function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	var date=tr.find('input[name=date]').val();
	var grade=tr.find('select[name=grade]').val();
	var sludgeHauled=tr.find('input[name=sludgeHauled]').val();
	var sludgeConsistency=tr.find('input[name=sludgeConsistency]').val();
//Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016
	var effluentConsistency=tr.find('input[name=effluentConsistency]').val();
//Code Ends Here Done By Roshan Tailor Date :- 03/21/2016
	var rejectsBwHauled=tr.find('input[name=rejectsBwHauled]').val();
	var rejectsBwConsistency=tr.find('input[name=rejectsBwConsistency]').val();
	var frpSludgePressRunning=tr.find('select[name=frpSludgePressRunning]').val();
	var frpScrewPressRunning=tr.find('select[name=frpScrewPressRunning]').val();
// 	Code Starts Feom Here Done By Roshan Tailor 
	var frpScrewPressConsistency=tr.find('input[name=frpScrewPressConsistency]').val();
	
	var coddischarge=tr.find('input[name=coddischarge]').val();
// 	Code Ends Here Done By Roshan Tailor
	
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
			grade : grade,
			sludgeHauled : sludgeHauled,
			sludgeConsistency : sludgeConsistency,
			rejectsBwHauled : rejectsBwHauled,
			rejectsBwConsistency : rejectsBwConsistency,
			frpSludgePressRunning : frpSludgePressRunning,
			frpScrewPressRunning : frpScrewPressRunning,
			frpScrewPressConsistency : frpScrewPressConsistency,
			//Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016
			effluentConsistency : effluentConsistency,
			coddischarge : coddischarge
			//Code Ends Her4e Done By Roshan Tailor Date :- 03/21/2016
		},
		success:function(data){
			
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				
			}else{
				
				alert("You Have Erroe ::: "+data.error);
				
			}
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
	
}

</script>

</c:if>

<c:if test="${type eq 'ST'}">

<spring:url value="/frppressquality/savesstickies " var="saveURL" />
<spring:url value="/frppressquality/deleteStickiedata " var="deleteURL" />

<script type="text/javascript">

$(function(){
$('#deleteRowBtn').click(function(){
		
		var rowCount = $('#qualityDataTableST tbody tr').length;
		if(rowCount==1){
			alert("You can't delete first row.");
			return;
		}
		
		var dbtn=$(this);
		var val=$('#qualityDataTableST tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				$('#qualityDataTableST tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
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

 function saveData(jq){
                var tr    = jq.closest('tr');
                    idEl  = tr.find('input[name=id]');
                    idVal = idEl.val();
                    date  = tr.find('input[name=date]').val();

                // all ST-row fields:
                var data = {
                  id: idVal,
                  date: date,
                  ttimeA:    tr.find('input[name=ttimeA]').val(),
                  tinitialsA:tr.find('input[name=tinitialsA]').val(),
                  tcountA:   tr.find('input[name=tcountA]').val(),
                  ttotalareaA:tr.find('input[name=ttotalareaA]').val(),
                  tavgareaA: tr.find('input[name=tavgareaA]').val(),
                  tppmA:     tr.find('input[name=tppmA]').val(),
                  tcommentA: tr.find('input[name=tcommentA]').val(),

                  retimeA:    tr.find('input[name=retimeA]').val(),
                  reinitialsA:tr.find('input[name=reinitialsA]').val(),
                  recountA:   tr.find('input[name=recountA]').val(),
                  retotalareaA:tr.find('input[name=retotalareaA]').val(),
                  reavgareaA: tr.find('input[name=reavgareaA]').val(),
                  reppmA:     tr.find('input[name=reppmA]').val(),
                  recommentA: tr.find('input[name=recommentA]').val(),

                  patimeA:    tr.find('input[name=patimeA]').val(),
                  painitialsA:tr.find('input[name=painitialsA]').val(),
                  pacountA:   tr.find('input[name=pacountA]').val(),
                  patotalareaA:tr.find('input[name=patotalareaA]').val(),
                  paavgareaA: tr.find('input[name=paavgareaA]').val(),
                  pappmA:     tr.find('input[name=pappmA]').val(),
                  pacommentA: tr.find('input[name=pacommentA]').val(),

                  totimeB:    tr.find('input[name=totimeB]').val(),
                  toinitialsB:tr.find('input[name=toinitialsB]').val(),
                  tocountB:   tr.find('input[name=tocountB]').val(),
                  tototalareaB:tr.find('input[name=tototalareaB]').val(),
                  toavgareaB: tr.find('input[name=toavgareaB]').val(),
                  toppmB:     tr.find('input[name=toppmB]').val(),
                  tocommentB: tr.find('input[name=tocommentB]').val(),

                  retimeB:    tr.find('input[name=retimeB]').val(),
                  reinitialsB:tr.find('input[name=reinitialsB]').val(),
                  recountB:   tr.find('input[name=recountB]').val(),
                  retotalareaB:tr.find('input[name=retotalareaB]').val(),
                  reavgareaB: tr.find('input[name=reavgareaB]').val(),
                  reppmB:     tr.find('input[name=reppmB]').val(),
                  recommentB: tr.find('input[name=recommentB]').val(),

                  patimeB:    tr.find('input[name=patimeB]').val(),
                  painitialsB:tr.find('input[name=painitialsB]').val(),
                  pacountB:   tr.find('input[name=pacountB]').val(),
                  patotalareaB:tr.find('input[name=patotalareaB]').val(),
                  paavgareaB: tr.find('input[name=paavgareaB]').val(),
                  pappmB:     tr.find('input[name=pappmB]').val(),
                  pacommentB: tr.find('input[name=pacommentB]').val(),

                  psftimeA:    tr.find('input[name=psftimeA]').val(),
                  psfinitialsA:tr.find('input[name=psfinitialsA]').val(),
                  psfcountA:   tr.find('input[name=psfcountA]').val(),
                  psftotalareaA:tr.find('input[name=psftotalareaA]').val(),
                  psfavgareaA: tr.find('input[name=psfavgareaA]').val(),
                  psfppmA:     tr.find('input[name=psfppmA]').val(),
                  psfcommentA: tr.find('input[name=psfcommentA]').val(),

                  psatimeA:    tr.find('input[name=psatimeA]').val(),
                  psainitialsA:tr.find('input[name=psainitialsA]').val(),
                  psacountA:   tr.find('input[name=psacountA]').val(),
                  psatotalareaA:tr.find('input[name=psatotalareaA]').val(),
                  psaavgareaA: tr.find('input[name=psaavgareaA]').val(),
                  psappmA:     tr.find('input[name=psappmA]').val(),
                  psacommentA: tr.find('input[name=psacommentA]').val(),

                  psftimeB:    tr.find('input[name=psftimeB]').val(),
                  psfinitialsB:tr.find('input[name=psfinitialsB]').val(),
                  psfcountB:   tr.find('input[name=psfcountB]').val(),
                  psftotalareaB:tr.find('input[name=psftotalareaB]').val(),
                  psfavgareaB: tr.find('input[name=psfavgareaB]').val(),
                  psfppmB:     tr.find('input[name=psfppmB]').val(),
                  psfcommentB: tr.find('input[name=psfcommentB]').val(),

                  psatimeB:    tr.find('input[name=psatimeB]').val(),
                  psainitialsB:tr.find('input[name=psainitialsB]').val(),
                  psacountB:   tr.find('input[name=psacountB]').val(),
                  psatotalareaB:tr.find('input[name=psatotalareaB]').val(),
                  psaavgareaB: tr.find('input[name=psaavgareaB]').val(),
                  psappmB:     tr.find('input[name=psappmB]').val(),
                  psacommentB: tr.find('input[name=psacommentB]').val()
                };

                if (saveLock) return;
                saveLock = true;

                $.ajax({
                  url: '${saveURL}',
                  type:'POST',
                  data: data,
                  success: function(resp){                      
                       if (resp.status) {
                      idEl.val(resp.id);
                      if(resp.count==0)
                          location.reload();
                      
                      $('#tmessage').text(resp.message);
                      clearTimer = setTimeout(function(){ $('#tmessage').text(''); }, 5000);
                    } else {
                      alert(resp.error);
                    }
                    saveLock = false;
                  },
                  error: function(){ alert('Server error'); saveLock = false; }
                });
              }
</script>

</c:if>


</c:if>


<!-- TERTIARY PRESS QUALITY -->
<c:if test="${type eq 'TPQ' }">
<table id="qualityDataTable"  class="table" style="width: 1000px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Initials</th>
			<th>Brightness<br> (2/shift) Min 71.5<br> for tube conveyor</th>
<!-- 			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
			<th>L</th>
			<th>a</th>
			<th>b</th>	
<!-- 			Code Ends Here Done By Roshan Tailor -->
			<th>Dirt <br> (2/shift)</th>
			<th>Stickies<br> (1/night shift)</th>
			<th>Ash <!-- <br>(1/week dayshift) --></th>	
			<th>Consistency</th>
			<th>Freeness</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="time" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="initials" value="" autocomplete="off"> </td>
			<td style="width: 100px;"><input type="text" name="brightness" value="" autocomplete="off"> </td>
<!-- 			Code Starts From Here Done By Roshan TAilor Date :- 03/30/2015 -->
			<td style="width: 75px;"><input type="text" name="lvalue" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="avalue" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="bvalue" value="" autocomplete="off"> </td>
<!-- 			Code Ends Here Done By Roshan Tailor -->
			<td style="width: 75px;"><input type="text" name="dirt" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="stickies" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="ash" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="consistency" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="freeness" value="" autocomplete="off"> </td>
			<td style="width: 98%;"><input type="text" name="comments" value="" autocomplete="off"> </td>
		</tr>
	</c:if>
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality.id}"></td>
				<td style="width: 80px;">
					<fmt:formatDate value="${quality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input readonly="readonly" type="text" name="date" value="${dateFrom}" autocomplete="off">
				</td>
				<td style="width: 60px;">
					<fmt:formatDate value="${quality.date}" pattern="HH:mm" var="timeFrom"/>
					<input type="text" name="time" value="${timeFrom}" autocomplete="off"> 
				</td>
				<td style="width: 75px;"><input type="text" name="initials" value="${quality.initials}" autocomplete="off"> </td>
				<td style="width: 100px;"><input type="text" name="brightness" value="${quality.brightness}" autocomplete="off"> </td>
<!-- 				Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
				<td style="width: 75px;"><input type="text" name="lvalue" value="${quality.lvalue}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="avalue" value="${quality.avalue}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="bvalue" value="${quality.bvalue}" autocomplete="off"> </td>
<!-- 				Code Ends Here Done By Roshan Tailor  -->
				<td style="width: 75px;"><input type="text" name="dirt" value="${quality.dirt}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="stickies" value="${quality.stickies}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="ash" value="${quality.ash}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="consistency" value="${quality.consistency}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="freeness" value="${quality.freeness}" autocomplete="off"> </td>
				<td style="width: 98%;"><input type="text" name="comments" value="${quality.comments}" autocomplete="off"> </td>
			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="14"><span class="error">*</span> - Mandatory field.</td>
		</tr>
	</tfoot>
</table>
</c:if>

<!-- stickies data  data START From Here By KIshor vaishnav  -->
<c:if test="${type eq 'ST' }">
<table id="qualityDataTableST"  class="table" style="width: 1000px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Initials</th>
			<th>Line</th>
			<th>Location</th>
			<th>Count</th>
			<th>Total Area</th>
			<th>Avg Area</th>
			<th>PPM</th>
			<th>Efficiency</th>
			<th>Comments</th>
			
			
			
		</tr>
		</thead>
		
		<tbody>
			<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
		<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="ttimeA" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="tinitialsA" value="" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;">A</td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen feed</td>
			<td style="width: 75px;"><input type="text" name="psfcountA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psftotalareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfavgareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfppmA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfcommentA" value="" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="ttimeA" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="tinitialsA" value="" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen accepts</td>
			<td style="width: 75px;"><input type="text" name="psacountA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psatotalareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psaavgareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psappmA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="efficiencyA" value="" autocomplete="off" >  </td>
			<td style="width: 75px;"><input type="text" name="psacommentA" value="" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="ttimeA" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="tinitialsA" value="" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Tertiary Press</td>
			<td style="width: 75px;"><input type="text" name="tcountA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="ttotalareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tavgareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tppmA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tcommentA" value="" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="retimeA" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="reinitialsA" value="" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">6 Refiner</td>
			<td style="width: 75px;"><input type="text" name="recountA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="retotalareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reavgareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reppmA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="recommentA" value="" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="patimeA" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="painitialsA" value="" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">6 Paper</td>
			<td style="width: 75px;"><input type="text" name="pacountA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="patotalareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="paavgareaA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="pappmA" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="pacommentA" value="" autocomplete="off">  </td>
		</tr>
		<tr>
	<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="totimeB" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="toinitialsB" value="" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;">B</td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen feed</td>
			<td style="width: 75px;"><input type="text" name="psfcountB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psftotalareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfavgareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfppmB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfcommentB" value="" autocomplete="off">  </td>
		</tr>
		<tr>
	<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="totimeB" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="toinitialsB" value="" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen accepts</td>
			<td style="width: 75px;"><input type="text" name="psacountB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psatotalareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psaavgareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psappmB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="EfficiencyB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psacommentB" value="" autocomplete="off">  </td>
		</tr>
		<tr>
	<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="totimeB" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="toinitialsB" value="" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Reaction Tower</td>
			<td style="width: 75px;"><input type="text" name="tocountB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tototalareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="toavgareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="toppmB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tocommentB" value="" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="retimeB" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="reinitialsB" value="" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">5 Refiner</td>
			<td style="width: 75px;"><input type="text" name="recountB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="retotalareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reavgareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reppmB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="recommentB" value="" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=""></td>
		<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
		
			<td style="width: 60px;"><input type="text" name="patimeB" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="painitialsB" value="" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">5 Paper</td>
			<td style="width: 75px;"><input type="text" name="pacountB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="patotalareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="paavgareaB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="pappmB" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="pacommentB" value="" autocomplete="off">  </td>
		</tr>
		</c:if>
		
		<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="qualities">
		<tr>
		<td><input type="radio" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="psftimeA" value="${qualities.psftimeA}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="psfinitialsA" value="${qualities.psfinitialsA}" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;">A</td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen feed</td>
			<td style="width: 75px;"><input type="number" name="psfcountA" value="${qualities.psfcountA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psftotalareaA" value="${qualities.psftotalareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfavgareaA" value="${qualities.psfavgareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfppmA" value="${qualities.psfppmA}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="psfcommentA" value="${qualities.psfcommentA}" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="psatimeA" value="${qualities.psatimeA}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="psainitialsA" value="${qualities.psainitialsA}" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen accepts</td>
			<td style="width: 75px;"><input type="number" name="psacountA" value="${qualities.psacountA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psatotalareaA" value="${qualities.psatotalareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psaavgareaA" value="${qualities.psaavgareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psappmA" value="${qualities.psappmA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="number" name="efficiencyA" value="${qualities.efficiencyA}"+"%" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psacommentA" value="${qualities.psacommentA}" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="ttimeA" value="${qualities.ttimeA}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="tinitialsA" value="${qualities.tinitialsA}" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Tertiary Press</td>
			<td style="width: 75px;"><input type="text" name="tcountA" value="${qualities.tcountA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="ttotalareaA" value="${qualities.ttotalareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tavgareaA" value="${qualities.tavgareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tppmA" value="${qualities.tppmA}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="tcommentA" value="${qualities.tcommentA}" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="retimeA" value="${qualities.retimeA}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="reinitialsA" value="${qualities.reinitialsA}" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">6 Refiner</td>
			<td style="width: 75px;"><input type="text" name="recountA" value="${qualities.recountA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="retotalareaA" value="${qualities.retotalareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reavgareaA" value="${qualities.reavgareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reppmA" value="${qualities.reppmA}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="recommentA" value="${qualities.recommentA}" autocomplete="off">  </td>
		</tr>
		<tr>
			<td><input type="hidden" name="id" value="${qualities.id}"></td>
		<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="patimeA" value="${qualities.patimeA}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="painitialsA" value="${qualities.painitialsA}" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">6 Paper</td>
			<td style="width: 75px;"><input type="text" name="pacountA" value="${qualities.pacountA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="patotalareaA" value="${qualities.patotalareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="paavgareaA" value="${qualities.paavgareaA}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="pappmA" value="${qualities.pappmA}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="pacommentA" value="${qualities.pacommentA}" autocomplete="off">  </td>
		</tr>
		
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="psftimeB" value="${qualities.psftimeB}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="psfinitialsB" value="${qualities.psfinitialsB}" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;">B</td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen feed</td>
			<td style="width: 75px;"><input type="text" name="psfcountB" value="${qualities.psfcountB}" autocomplete="off" onfocusout="valueCheck()">  </td>
			<td style="width: 75px;"><input type="text" name="psftotalareaB" value="${qualities.psftotalareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfavgareaB" value="${qualities.psfavgareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psfppmB" value="${qualities.psfppmB}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="psfcommentB" value="${qualities.psfcommentB}" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="psatimeB" value="${qualities.psatimeB}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="psainitialsB" value="${qualities.psainitialsB}" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Pri Fine sceen accepts</td>
			<td style="width: 75px;"><input type="text" name="psacountB" value="${qualities.psacountB}" autocomplete="off" onfocusout="valueCheck()">  </td>
			<td style="width: 75px;"><input type="text" name="psatotalareaB" value="${qualities.psatotalareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psaavgareaB" value="${qualities.psaavgareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psappmB" value="${qualities.psappmB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="efficiencyB" value="${qualities.efficiencyB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="psacommentB" value="${qualities.psacommentB}" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="totimeB" value="${qualities.totimeB}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="toinitialsB" value="${qualities.toinitialsB}" autocomplete="off"> </td>
			<td style="text-align: center;font-size:15px;"></td>
			<td style="text-align: center;font-size:15px;">Reaction Tower</td>
			<td style="width: 75px;"><input type="text" name="tocountB" value="${qualities.tocountB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="tototalareaB" value="${qualities.tototalareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="toavgareaB" value="${qualities.toavgareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="toppmB" value="${qualities.toppmB}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="tocommentB" value="${qualities.tocommentB}" autocomplete="off">  </td>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value="${qualities.id}"></td>
		    <td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="retimeB" value="${qualities.retimeB}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="reinitialsB" value="${qualities.reinitialsB}" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">5 Refiner</td>
			<td style="width: 75px;"><input type="text" name="recountB" value="${qualities.recountB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="retotalareaB" value="${qualities.retotalareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reavgareaB" value="${qualities.reavgareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="reppmB" value="${qualities.reppmB}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="recommentB" value="${qualities.recommentB}" autocomplete="off">  </td>
		</tr>
		<tr>
			<td><input type="hidden" name="id" value="${qualities.id}"></td>
			<td style="width: 80px;"><input readonly="readonly" type="hidden" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="patimeB" value="${qualities.patimeB}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="painitialsB" value="${qualities.painitialsB}" autocomplete="off"> </td>
			<td ></td>
			<td style="text-align: center;font-size:15px;">5 Paper</td>
			<td style="width: 75px;"><input type="text" name="pacountB" value="${qualities.pacountB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="patotalareaB" value="${qualities.patotalareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="paavgareaB" value="${qualities.paavgareaB}" autocomplete="off">  </td>
			<td style="width: 75px;"><input type="text" name="pappmB" value="${qualities.pappmB}" autocomplete="off">  </td>
			<td></td>
			<td style="width: 75px;"><input type="text" name="pacommentB" value="${quality.pacommentB}" autocomplete="off">  </td>
		</tr>
		</c:forEach>
		</c:if>
		
		</tbody>

		
	
	<tfoot>
		<tr>
			<td colspan="14"><span class="error">*</span> - Mandatory field.</td>
		</tr>
	</tfoot>
</table>
</c:if>
<!-- stickies data  data END From Here -->

<!-- TPQ 2 Starts From Here -->
<!-- Code Starts From Here Done By Roshan Tailor Date :- 03/21/2015 -->

<c:if test="${type eq 'TPQ2' }">
<table id="qualityDataTable"  class="table" style="width: 1000px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Line</th>
			<th>Initials</th>
<!-- 			Code Starts From Here Done By Roshan Tailor Date:- 04/01/2015 -->
			<th>Bleaching Chemical</th>
<!-- 			Code Ends Here Done By Roshan Tailor -->
			<th>Brightness<br> (2/shift) Min 71.5<br> for tube conveyor</th>
			<!-- 			Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
			<th>L</th>
			<th>a</th>
			<th>b</th>	
<!-- 			Code Ends Here Done By Roshan Tailor -->
			<th>Dirt <br> (2/shift)</th>
			<th>Stickies<br> (1/night shift)</th>
			<th>Ash <!-- <br>(1/week dayshift) --></th>	
			<th>Consistency</th>
			<th>Freeness</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="time" value="" autocomplete="off"> </td>
			<td>
				<select name="line" id="line" style="width: 100px;">
					<option value="">Select Line</option>
					<option value="A">A</option>
					<option value="B">B</option>
				</select>
			</td>
			<td style="width: 75px;"><input type="text" name="initials" value="" autocomplete="off"> </td>
<!-- 			Code Starts From Here Done By Roshan Tailor DAte :- 04/01/2015  -->
			<td style="width: 75px;"><input type="text" name="bleachingchemical" value="" autocomplete="off"> </td>
<!-- 			Code Ends Here Done By Roshan Tailor 	 -->
			<td style="width: 100px;"><input type="text" name="brightness" value="" autocomplete="off"> </td>
			<!-- 			Code Starts From Here Done By Roshan TAilor Date :- 03/30/2015 -->
			<td style="width: 75px;"><input type="text" name="lvalue" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="avalue" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="bvalue" value="" autocomplete="off"> </td>
<!-- 			Code Ends Here Done By Roshan Tailor -->
			<td style="width: 75px;"><input type="text" name="dirt" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="stickies" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="ash" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="consistency" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="freeness" value="" autocomplete="off"> </td>
			<td style="width: 98%;"><input type="text" name="comments" value="" autocomplete="off"> </td>
		</tr>
	</c:if>
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality.id}"></td>
				<td style="width: 80px;">
					<fmt:formatDate value="${quality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input readonly="readonly" type="text" name="date" value="${dateFrom}" autocomplete="off">
				</td>
				<td style="width: 60px;">
					<fmt:formatDate value="${quality.date}" pattern="HH:mm" var="timeFrom"/>
					<input type="text" name="time" value="${timeFrom}" autocomplete="off"> 
				</td>
				<td>
					<select name="line" id="line" style="width: 100px;">
						<option value="">Select Line</option>
						<c:if test="${quality.line eq 'A'}">
							<option value="A" selected="selected">A</option>
							<option value="B">B</option>
						</c:if>
						<c:if test="${quality.line eq 'B'}">
							<option value="A">A</option>
							<option value="B" selected="selected">B</option>
						</c:if>
						<c:if test="${quality.line eq ''}">
							<option value="A">A</option>
							<option value="B">B</option>
						</c:if>
					</select>
				</td>
				<td style="width: 75px;"><input type="text" name="initials" value="${quality.initials}" autocomplete="off"> </td>
<!-- 				Code Starts From Here Done By Roshan Tailor Date :- 04/01/2015 -->
				<td style="width: 75px;"><input type="text" name="bleachingchemical" value="${quality.bleachingchemical}" autocomplete="off"> </td>
<!-- 				Code Ends Here Done BY Roshan Tailor -->
				<td style="width: 100px;"><input type="text" name="brightness" value="${quality.brightness}" autocomplete="off"> </td>
<!-- 				Code Starts From Here Done By Roshan Tailor Date :- 03/30/2015 -->
				<td style="width: 75px;"><input type="text" name="lvalue" value="${quality.lvalue}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="avalue" value="${quality.avalue}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="bvalue" value="${quality.bvalue}" autocomplete="off"> </td>
<!-- 				Code Ends Here Done By Roshan Tailor  -->
				<td style="width: 75px;"><input type="text" name="dirt" value="${quality.dirt}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="stickies" value="${quality.stickies}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="ash" value="${quality.ash}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="consistency" value="${quality.consistency}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="freeness" value="${quality.freeness}" autocomplete="off"> </td>
				<td style="width: 98%;"><input type="text" name="comments" value="${quality.comments}" autocomplete="off"> </td>
			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<tfoot>
		<tr>
<td colspan="16"><span class="error">*</span> - Mandatory field.</td>
		</tr>
	</tfoot>
</table>
</c:if>

<!-- Code Ends Here Done By Roshan Tailor-->
<!-- TPQ 2 Ends Here -->
<!-- Code Starts From Here Done By Roshan Tailor Date:- 03/24/2015 -->
<!-- Secondary Press Quality Starts Here -->
<c:if test="${type eq 'SECPRESSQ' }">
<table id="qualityDataTable"  class="table" style="width: 500px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time</th>
			<th>Brightness</th>
			<th>ERIC</th>
			<th>A*</th>
			<th>B*</th>
			<th>Comment</th>	
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="time" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="brightness" value="" autocomplete="off"> </td>
			<td style="width: 100px;"><input type="text" name="eric" value="" autocomplete="off"> </td>
			<td style="width: 75px;">
				<select name="astar">
					<option value="">Select</option>
					<c:forEach items="${astar}" var="astar">
						<option value="${astar.key}">${astar.value}</option>
					</c:forEach>
				</select>
			</td>
			<td style="width: 75px;">
				<select name="bstar">
					<option value="">Select</option>
					<c:forEach items="${bstar}" var="bstar">
						<option value="${bstar.key}">${bstar.value}</option>
					</c:forEach>
				</select>
			</td>
			<td style="width: 200px;"><input type="text" name="comments" value="" autocomplete="off"> </td>
		</tr>
	</c:if>
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality.id}"></td>
				<td style="width: 80px;">
					<fmt:formatDate value="${quality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input readonly="readonly" type="text" name="date" value="${dateFrom}" autocomplete="off">
				</td>
				<td style="width: 60px;">
					<fmt:formatDate value="${quality.date}" pattern="HH:mm" var="timeFrom"/>
					<input type="text" name="time" value="${timeFrom}" autocomplete="off"> 
				</td>
				<td style="width: 75px;"><input type="text" name="brightness" value="${quality.brightness}" autocomplete="off"> </td>
				<td style="width: 100px;"><input type="text" name="eric" value="${quality.eric}" autocomplete="off"> </td>
				<td style="width: 75px;">
				<select name="astar">
					<option value="">Select</option>
					<c:forEach items="${astar}" var="astar">
							<c:choose>
								<c:when test="${astar.key eq quality.astar}">
									<option value="${astar.key}" selected="selected">${astar.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${astar.key}">${astar.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
			</td>
				<td style="width: 75px;">
				<select name="bstar">
					<option value="">Select</option>
					<c:forEach items="${bstar}" var="bstar">
							<c:choose>
								<c:when test="${bstar.key eq quality.bstar}">
									<option value="${bstar.key}" selected="selected">${bstar.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${bstar.key}">${bstar.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
			</td>
				<td style="width: 200px;"><input type="text" name="comments" value="${quality.comments}" autocomplete="off"> </td>
			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="12"><span class="error">*</span> - Mandatory field.</td>
		</tr>
	</tfoot>
</table>
</c:if>
<!-- Secondary Press Quality Ends Here -->
<!-- Code Ends Here Done By Roshan Tailor -->
<!-- FRP Sludge Press Consistency -->
<c:if test="${type eq 'SPC' }">
<table  id="qualityDataTable" class="table" style="width: 800px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Initials</th>
			<th>Consistency<br> (1/shift)</th>
			<th>Grade</th>
			<th>Clarifier<br> Underflow<br>Running</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="time" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="initials" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="consistency" value="" autocomplete="off"> </td>
			<td style="width: 100px;">
				<select name="grade">
					<option value="">Select</option>
					<c:forEach items="${grades}" var="grade">
						<option value="${grade.key}">${grade.value}</option>
					</c:forEach>
				</select>
			</td>
			<td style="width: 100px;">
				<select name="cuRunning">
					<option value="">Select</option>
					<c:forEach items="${ynflags}" var="ynflag">
						<option value="${ynflag.key}">${ynflag.value}</option>
					</c:forEach>
				</select>
			</td>
			<td style="width: 98%;"><input type="text" name="comments" value="" autocomplete="off"> </td>
		</tr>
	</c:if>	
	
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality.id}"></td>
				<td style="width: 80px;">
					<fmt:formatDate value="${quality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input readonly="readonly" type="text" name="date" value="${dateFrom}" autocomplete="off">
				</td>
				<td style="width: 60px;">
					<fmt:formatDate value="${quality.date}" pattern="HH:mm" var="timeFrom"/>
					<input type="text" name="time" value="${timeFrom}" autocomplete="off"> 
				</td>
				<td style="width: 75px;"><input type="text" name="initials" value="${quality.initials}" autocomplete="off"> </td>
				<td style="width: 75px;"><input type="text" name="consistency" value="${quality.consistency}" autocomplete="off"> </td>
				<td style="width: 100px;">
					<select name="grade">
						<option value="">Select</option>
						<c:forEach items="${grades}" var="grade">
							<c:choose>
								<c:when test="${grade.key eq quality.grade}">
									<option value="${grade.key}" selected="selected">${grade.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${grade.key}">${grade.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td style="width: 100px;">
					<select name="cuRunning">
						<option value="">Select</option>
						<c:forEach items="${ynflags}" var="ynflag">
							<c:choose>
								<c:when test="${ynflag.key eq quality.cuRunning}">
									<option value="${ynflag.key}" selected="selected">${ynflag.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${ynflag.key}">${ynflag.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td style="width: 98%;"><input type="text" name="comments" value="${quality.comments}" autocomplete="off"> </td>
			</tr>
		</c:forEach>
	</c:if>
	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="12"><span class="error">*</span> - Mandatory field.</td>
		</tr>
	</tfoot>
</table>
</c:if>


<!-- IP Sludge Consistency -->
<c:if test="${type eq 'IPSC' }">
<table  id="qualityDataTable" class="table" style="width: 400px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Consistency</th>
			<th>Comments</th>	
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="consistency" value="" autocomplete="off"> </td>
			<td style="width: 98%;"><input type="text" name="comments" value="" autocomplete="off"> </td>
		</tr>
	</c:if>	
	
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
			<tr>
				<td><input type="radio" name="id" value="${quality.id}"></td>
				<td style="width: 80px;">
					<fmt:formatDate value="${quality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input readonly="readonly" type="text" name="date" value="${dateFrom}" autocomplete="off">
				</td>
				<td style="width: 75px;"><input type="text" name="consistency" value="${quality.consistency}" autocomplete="off"> </td>
				<td style="width: 98%;"><input type="text" name="comments" value="${quality.comments}" autocomplete="off"> </td>
			</tr>
		</c:forEach>
	</c:if>
	
	</tbody>
	
</table>
</c:if>



<!-- WET LAP -->
<c:if test="${type eq 'WL' }">
<table id="qualityDataTable" class="table" style="width: 1000px; margin: auto;font-size: 12px; margin-left: 280px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Time<span class="error">*</span></th>
			<th>Lot<span class="error">*</span> </th>
			<th>Brightness</th>
			<th>Grade</th>
			<th>Stickies</th>
			<th>Dirt</th>
			<th>Consistency</th>
			<th>Ash</th>
			<th>Freeness</th>
			<th>Comments</th>	
			
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(qualities) eq 0 }">
			<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="time" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="lot" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="brightness" value="" autocomplete="off"> </td>
			<td style="width: 100px;">
				<select name="grade">
					<option value="">Select</option>
					<c:forEach items="${grades}" var="grade">
						<option value="${grade.key}">${grade.value}</option>
					</c:forEach>
				</select>
			</td>
			<td style="width: 75px;"><input type="text" name="stickies" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="dirt" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="consistency" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="ash" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="freeness" value="" autocomplete="off"> </td>
			<td style="width: 98%;"><input type="text" name="comments" value="" autocomplete="off"> </td>
		</tr>
	</c:if>
	
	<c:if test="${fn:length(qualities)> 0 }">
		<c:forEach items="${qualities}" var="quality">
		<tr>
				<td><input type="radio" name="id" value="${quality.id}"></td>
				<td style="width: 80px;padding: 2px;">
					<fmt:formatDate value="${quality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input readonly="readonly" type="text" name="date" value="${dateFrom}" autocomplete="off">
				</td>
				<td style="width: 60px;padding: 2px;">
					<fmt:formatDate value="${quality.date}" pattern="HH:mm" var="timeFrom"/>
					<input type="text" name="time" value="${timeFrom}" autocomplete="off"> 
				</td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="lot" value="${quality.lot}" autocomplete="off"> </td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="brightness" value="${quality.brightness}" autocomplete="off"> </td>
				<td style="width: 100px;">
					<select name="grade">
						<option value="">Select</option>
						<c:forEach items="${grades}" var="grade">
							<c:choose>
								<c:when test="${grade.key eq quality.grade}">
									<option value="${grade.key}" selected="selected">${grade.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${grade.key}">${grade.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="stickies" value="${quality.stickies}" autocomplete="off"> </td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="dirt" value="${quality.dirt}" autocomplete="off"> </td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="consistency" value="${quality.consistency}" autocomplete="off"> </td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="ash" value="${quality.ash}" autocomplete="off"> </td>
				<td style="width: 75px;padding: 2px;"><input type="text" name="freeness" value="${quality.freeness}" autocomplete="off"> </td>
				<td style="width: 98%;padding: 2px;"><input type="text" name="comments" value="${quality.comments}" autocomplete="off"> </td>
			</tr>
		
		</c:forEach>
	</c:if>
	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="12"><span class="error">*</span> - Mandatory field.</td>
		</tr>
	</tfoot>
</table>
	
</c:if>

<c:if test="${type eq 'SH' }">
<table  id="qualityDataTable" class="table" style="width: 800px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 20px;">&nbsp;</th>
			<th>Date</th>
			<th>Grade</th>
			<th>Sludge Hauled<br> (lbs)</th>
			<th>Sludge<br> Consistency</th>
			<!-- Code Starts From Here Done By Roshan Tailor Date:- 03/21/2016 -->
			<th>Effluent<br>Consistency</th>
			<!-- Code Ends Here Done By Roshan Tailor Date:- 03/21/2016 -->
			<th>Rejects Bunker<br> Waste Hauled<br> (Lbs)</th>
			<th>Rejects Bunker<br> Waste <br>Consistency</th>
			<th>FRP Sludge<br> Press Running</th>
			<th>FRP Screw<br> Press Running</th>
			
			<th>COD<br>Discharge(mg/L)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${sludgeHaulings}" var="sludgeHauling">
			<tr>
				<td><input type="radio" name="id" value="${sludgeHauling.id}"></td>
				
				<td style="width: 80px;padding: 2px;">
					<fmt:formatDate value="${sludgeHauling.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
					<input type="text" name="date" value="${dateFrom}">
				</td>
				<td style="width: 100px;">
					<select name="grade">
						<option value="">Select</option>
						<c:forEach items="${grades}" var="grade">
							<c:choose>
								<c:when test="${grade.key eq sludgeHauling.grade}">
									<option value="${grade.key}" selected="selected">${grade.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${grade.key}">${grade.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td style="width: 100px;padding: 2px;"><input type="text" name="sludgeHauled" value="${sludgeHauling.sludgeHauled}" autocomplete="off"></td>
				<td style="width: 100px;padding: 2px;"><input type="text" name="sludgeConsistency" value="${sludgeHauling.sludgeConsistency}" autocomplete="off"></td>
<!-- 				Code Starts From Here Done By Roshan Tailor Date :-03/21/2016 -->
				<td style="width: 100px;padding: 2px;"><input type="text" name="effluentConsistency" value="${sludgeHauling.effluentConsistency}" autocomplete="off"></td>
<!-- 				Code Ends Here Done By Roshan Tailor Date :- 03/21/2016 -->
				<td style="width: 100px;padding: 2px;"><input type="text" name="rejectsBwHauled" value="${sludgeHauling.rejectsBwHauled}" autocomplete="off"></td>
				<td style="width: 100px;padding: 2px;"><input type="text" name="rejectsBwConsistency" value="${sludgeHauling.rejectsBwConsistency}" autocomplete="off"></td>
				<td style="width: 100px;">
					<select name="frpSludgePressRunning">
						<option value="">Select</option>
						<c:forEach items="${ynflags}" var="ynflag">
							<c:choose>
								<c:when test="${ynflag.key eq sludgeHauling.frpSludgePressRunning}">
									<option value="${ynflag.key}" selected="selected">${ynflag.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${ynflag.key}">${ynflag.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td style="width: 100px;">
					<select name="frpScrewPressRunning">
						<option value="">Select</option>
						<c:forEach items="${ynflags}" var="ynflag">
							<c:choose>
								<c:when test="${ynflag.key eq sludgeHauling.frpScrewPressRunning}">
									<option value="${ynflag.key}" selected="selected">${ynflag.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${ynflag.key}">${ynflag.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td style="width: 100px;padding: 2px;"><input type="text" name="coddischarge" value="${sludgeHauling.coddischarge}" autocomplete="off"></td>
			</tr>
		</c:forEach>
		
		
    </tbody>
</table>
</c:if>

			</div>

		</div>


	</div>

</body>
</html>
