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
<%-- <spring:url value="/frpyield/new" var="addrow" /> --%>
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
		
		
		
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusin(doFocusIn);
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusout(doFocusOut);
		
		$('#addrowbutton').click(function(){
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
			
			//var currentdate=(date.getMonth() + 1) + '-' + date.getDate() + '-' +  date.getFullYear(); //New Logic Applied By Roshan Tailor
			
			var otr = $('#yielddatatable tbody tr:last');
			//var odate=otr.find('input[name=date]').val();  // This Is Commented By Roshan Tailor Date :- 04/30/2015 Night Shift
			var tr = $('#yielddatatable tbody tr:last').clone();
			var ntr = tr.appendTo($('#yielddatatable tbody'));
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=date]').removeAttr('id');
			ntr.find('input[name=date]').removeAttr('class');
			ntr.find('input[name=date]').val(mdy); //New Logic Applied By Roshan Tailor
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
			
		});
		//Code For Add New Row Ends Here Done By Roshan Tailor Date :- 04/21/2015 Night Shift
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( (tb.attr('name')=='initials') | 
				(tb.attr('name')=='grade') |
				(tb.attr('name')=='cuRunning')|
				(tb.attr('name')=='comments') |
				(tb.attr('name')=='frpSludgePressRunning') |
				(tb.attr('name')=='frpScrewPressRunning') |
				(tb.attr('name')=='astar') |
				(tb.attr('name')=='bstar') |
				(tb.attr('name')=='comment') |
				(tb.attr('name')=='date')
				){

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
	
	//The Below Code Is To Call The Validate Function Done By Roshan Tailor Date:- 04/21/2015
	
	function doFocusIn()
	{
		currentVal=$(this).val();
	}
	//Above Code  Will Call The doFocusIn Function
	function doFocusOut()
	{
		if(validatePQ($(this)))
		{
			return;
		}
		
		if($(this).val()==currentVal)
		{
			return;
		}
		
		saveData($(this));
	  //The Above Code Will Call The saveData Method And Save Data Into Database
	}
	//Validate Code Ends Here Done By Roshan Tailor Date :- 04/21/2015
</script>
<spring:url value="/frpyield/save" var="saveyieldDataURL" />
<spring:url value="/frpyield/delete" var="deleteyieldDataURL" />
</head>
<script type="text/javascript">
function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');//This Returning Us Value Of Current Id And Helping Us For Update The Line 
	var date=tr.find('input[name=date]').val();
	var sampleno=tr.find('input[name=sampleno]').val();
	if(sampleno==''){
		alert("Please enter valid time.");
		tr.find('input[name=sampleno]').focus();
		return;
	}
	var rfdetrasherrejcts=tr.find('input[name=rfdetrasherrejcts]').val();
	var rfhdcleaner=tr.find('input[name=rfhdcleaner]').val();
	var rftertiarycoarse=tr.find('input[name=rftertiarycoarse]').val();
	var rftertiaryfine=tr.find('input[name=rftertiaryfine]').val();
	var rffrwdcleaner=tr.find('input[name=rffrwdcleaner]').val();
	var rfprimcell=tr.find('input[name=rfprimcell]').val();
	var rfseccell=tr.find('input[name=rfseccell]').val();
	var rffsdclarifier=tr.find('input[name=rffsdclarifier]').val();
	var cyofdww=tr.find('input[name=cyofdww]').val();
	var rchdcleaner=tr.find('input[name=rchdcleaner]').val();
	var rctertiarycoarse=tr.find('input[name=rctertiarycoarse]').val();
	var rctertiaryfine=tr.find('input[name=rctertiaryfine]').val();
	var rcfrwdcleaner=tr.find('input[name=rcfrwdcleaner]').val();
	var rcprimcell=tr.find('input[name=rcprimcell]').val();
	var rcseccell=tr.find('input[name=rcseccell]').val();
	var rcfsdclarifier=tr.find('input[name=rcfsdclarifier]').val();
	var ashdww=tr.find('input[name=ashdww]').val();
	var ashpupler=tr.find('input[name=ashpupler]').val();

	var ashtertiarypress=tr.find('input[name=ashtertiarypress]').val();	
 	//alert("lvalue::"+rfdetrasherrejcts);
	
 	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${saveyieldDataURL}',
		type:'POST',
		data:{
			id : id,
			date : date,
			sampleno : sampleno,
			rfdetrasherrejcts : rfdetrasherrejcts,
			rfhdcleaner : rfhdcleaner,
			rftertiarycoarse : rftertiarycoarse,
			rftertiaryfine : rftertiaryfine,
			rffrwdcleaner : rffrwdcleaner,
			rfprimcell : rfprimcell,
			rfseccell : rfseccell,
			rffsdclarifier : rffsdclarifier,
			cyofdww : cyofdww,
			rchdcleaner : rchdcleaner,
			rctertiarycoarse : rctertiarycoarse,
			rctertiaryfine : rctertiaryfine,
			rcfrwdcleaner : rcfrwdcleaner,
			rcprimcell : rcprimcell,
			rcseccell : rcseccell,
			rcfsdclarifier : rcfsdclarifier,
			ashdww : ashdww,
			ashpupler : ashpupler,
			ashtertiarypress : ashtertiarypress
		},
		
		success:function(data){
			
			idEle.val(data.id);//By This line Of Code We Are Geting Current Line Number OF <TD>
			$('#tmessage').text(data.message);
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
			
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
	
}
</script>
<!-- Java Script To Delete A Row Starts From Here Done By Roshan Tailor Date:- 04/22/2015 -->
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
				$('#yielddatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteyieldDataURL}',
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
<!-- Java Srcipt to Delete A Row Ends Here Done By Roshan Tailor Date :- 04/22/2015 -->
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP YIELD DATA ENTRY</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<!--<td>YIELD Row</td> -->
							<td><input type="button" id="addrowbutton" name="addmorerow" value="Add Row"></td>
							<td><input type="button" id="deleterowbutton" name="deleterow" value="Delete Row"></td>
						</tr>
					</table>

				</div>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<table class="table" id="yielddatatable">
						<thead style="font-size: 12px;">
						<tr>
								<th style="width:10px;" rowspan="2">
									<!-- <input type="checkbox" name="rowCheckboxAll"> -->
								</th>
								<th style="width:200px;">Date</th>
								<th style="width:200px;">Sample No</th>
								<th style="width:80px;">Detrasher<br>Rejects</th>
								<th style="width:80px;">HD<br>Cleaners</th>
								<th style="width:80px;">Tertiary<br>Coarse</th>
								<th style="width:80px;">Tertiary<br>Fine </th>
								<th style="width:80px;">Forward<br>Cleaner</th>
								<th style="width:80px;">Prim<br>FlotCell</th>
								<th style="width:80px;">Sec.<br>Flot Cell</th>
								<th style="width:80px;">First<br>Stage Deckers<br>to clarifier</th>
								<th style="width:80px;">Cy of DWW <br>from Mill</th>
								<th style="width:80px;">HD<br>Cleaners</th>
								<th style="width:80px;">Tertiary<br>Coarse</th>
								<th style="width:80px;">Tertiary<br>Fine</th>
								<th style="width:80px;">Forward<br>Cleaner</th>
								<th style="width:80px;">Prim Flot<br>Cell</th>
								<th style="width:80px;">Sec. Flot<br>Cell</th>
								<th style="width:80px;">First Stage Deckers<br>to clarifier</th>
								<th style="width:80px;">DWW from <br>Mill</th>
								<th style="width:80px;">Pulper</th>
								<th style="width:80px;">Tertiary<br>Press</th>
							</tr>
							<tr>
								<th class="trobjrow"></th>
								<th class="trobjrow"></th>
								<th class="trobjrow">TPD</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">gpm</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>
								<th class="trobjrow">%</th>								   
							</tr>
						</thead>
						<tbody id="yielddatainput">
									
							<c:if test="${fn:length(qualities) eq 0 }">
							<tr>
													<td>
														<input type="radio" name="rowCheckbox" value=""> 
													</td>
													<td>
														<input type="hidden" name="id" value="">
														<input type="text" style="width: 70px;" name="date" value="${currentdate}"  autocomplete="off"></td>
														
													<td> 
														<input type="text" style="width: 90px;" name="sampleno" value=""  autocomplete="off">			
													</td>
													<td> 
														<input  type="text" class="textbox" name="rfdetrasherrejcts" value=""  autocomplete="off">						
													</td>
													<td>
														
														<input type="text"  class="textbox" name="rfhdcleaner" value=""  autocomplete="off">
													</td>
													<td> 
														<input type="text" class="textbox" name="rftertiarycoarse" value=""  autocomplete="off">						
													</td>
													
													<td> 
														<input type="text" class="textbox" name="rftertiaryfine" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rffrwdcleaner" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rfprimcell" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rfseccell" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rffsdclarifier" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cyofdww" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rchdcleaner" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rctertiarycoarse" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rctertiaryfine" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcfrwdcleaner" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcprimcell" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcseccell" value="" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcfsdclarifier" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="ashdww" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="ashpupler" value=""  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="ashtertiarypress" value=""  autocomplete="off">						
													</td>
												</tr>
							</c:if>
							
							<c:if test="${fn:length(qualities)>0}">
							<c:forEach items="${qualities}" var="yieldquality">
							<tr>
													<td>
														<input type="radio" name="id"  value="${yieldquality.id}"> 
													</td>
													<td>
														<input type="hidden" name="id" value="${yieldquality.id}">
														<fmt:formatDate value="${yieldquality.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
														<input type="text" style="width: 70px;" name="date"  value="${dateFrom}"  autocomplete="off" readonly="readonly"></td>
													<td> 
														<input type="text" style="width: 90px;" name="sampleno" value="${yieldquality.sampleno}"  autocomplete="off">			
													</td>
													<td> 
														<input  type="text" class="textbox" name="rfdetrasherrejcts" value="${yieldquality.rfdetrasherrejcts}"  autocomplete="off">						
													</td>
													<td>
														
														<input type="text"  class="textbox" name="rfhdcleaner" value="${yieldquality.rfhdcleaner}"  autocomplete="off">
													</td>
													<td> 
														<input type="text" class="textbox" name="rftertiarycoarse" value="${yieldquality.rftertiarycoarse}"  autocomplete="off">						
													</td>
													
													<td> 
														<input type="text" class="textbox" name="rftertiaryfine" value="${yieldquality.rftertiaryfine}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rffrwdcleaner" value="${yieldquality.rffrwdcleaner}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rfprimcell" value="${yieldquality.rfprimcell}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rfseccell" value="${yieldquality.rfseccell}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rffsdclarifier" value="${yieldquality.rffsdclarifier}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="cyofdww" value="${yieldquality.cyofdww}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rchdcleaner" value="${yieldquality.rchdcleaner}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rctertiarycoarse" value="${yieldquality.rctertiarycoarse}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rctertiaryfine" value="${yieldquality.rctertiaryfine}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcfrwdcleaner" value="${yieldquality.rcfrwdcleaner}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcprimcell" value="${yieldquality.rcprimcell}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcseccell" value="${yieldquality.rcseccell}" autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="rcfsdclarifier" value="${yieldquality.rcfsdclarifier}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="ashdww" value="${yieldquality.ashdww}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="ashpupler" value="${yieldquality.ashpupler}"  autocomplete="off">						
													</td>
													<td> 
														<input type="text" class="textbox" name="ashtertiarypress" value="${yieldquality.ashtertiarypress}"  autocomplete="off">						
													</td>
												</tr>
							</c:forEach>
							</c:if>			
											
												
										
								</tbody>
								
								
							
						
					</table>

</div>
    
			</div>

		</div>


	</div>

</body>
</html>
