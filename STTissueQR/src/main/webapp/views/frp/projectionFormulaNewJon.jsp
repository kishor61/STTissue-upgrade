<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
	.tableForm {
		border: 1px solid #B6B6B6;
		border-collapse: collapse;
	}
	.tableForm td input[type=text] {
		width: 60px;
	}
	.tableForm td select{
		width: 120px;
		padding: 2px;
	}
	.tableForm td {
		padding: 1px;
		border:1px solid #B6B6B6;
	}

	@media print {
    	button {
	       display: none;
	    }
	}
}
</style>

<spring:url value="/frpprojectionJon/save" var="saveProjectionURL" />
<spring:url value="/frpprojectionJon/view"  var="viewURL"/>
<spring:url value="/frpprojectionJon/new"  var="newURL"/>

<script type="text/javascript">
	var currentValue;
	var saveFormFlag;
	var clearSaveTimer;
	$(function(){
		
		$('#type').change(function(){
			if($(this).val().length==0){
				location.href='${newURL}';
			}else{
				location.href='${newURL}/'+$(this).val();
			}
		});
		
		
		$('#projectionForm input[type=text],#projectionForm select,#projectionForm textarea').focusin(function(){
			currentValue=$(this).val();
		});
	
		$('#projectionForm input[type=text], #projectionForm select,#projectionForm textarea').focusout(function(){
			
			
			
			
			if(validate($(this))){
				return;
			}
			
			calculate();
			
			saveData($(this));
		});
		
		calculate();
	});
	
	function saveData(jq){
		if(currentValue==jq.val()){
			return;
		}
		
		
		
		
		$('#tmessage').text('');
		
		clearTimeout(clearSaveTimer);
		
		var ele=$('#projectionForm');
		
		var id=parseInt(ele.find('input[name=id]').val(),10) || 0;
		var idEle=ele.find('input[name=id]');
		
		var type=ele.find('input[name=type]').val();
		var type2=ele.find('select[name=type2]').val();
		
		if(type.length==0){
			alert('Select production type.');
			ele.find('select[name=type]').focus();
			return;
		}
	
		if(type2.length==0){
			return;
		}
		
		var input=parseFloat(ele.find('input[name=input]').val()) || 0;
		var mwlAndSwl=parseFloat(ele.find('input[name=mwlAndSwl]').val()) || 0;
		var sow=parseFloat(ele.find('input[name=sow]').val()) || 0;
		var cbs=parseFloat(ele.find('input[name=cbs]').val()) || 0;
		var sowAndMail=parseFloat(ele.find('input[name=sowAndMail]').val()) || 0;
		var growndwood=parseFloat(ele.find('input[name=growndwood]').val()) || 0;
		var dlk=parseFloat(ele.find('input[name=dlk]').val()) || 0;
		var occ=parseFloat(ele.find('input[name=occ]').val()) || 0;
		var others=parseFloat(ele.find('input[name=others]').val()) || 0;
		var remarks=ele.find('textarea[name=remarks]').val();
		
		var occMinR=parseFloat(ele.find('input[name=occMinR]').val()) || 0;
		var occMinC=parseFloat(ele.find('input[name=occMinC]').val()) || 0;
		var occTarget=parseFloat(ele.find('input[name=occTarget]').val()) || 0;
		var occMaxC=parseFloat(ele.find('input[name=occMaxC]').val()) || 0;
		var occMaxR=parseFloat(ele.find('input[name=occMaxR]').val()) || 0;
		var dlkMinR=parseFloat(ele.find('input[name=dlkMinR]').val()) || 0;
		var dlkMinC=parseFloat(ele.find('input[name=dlkMinC]').val()) || 0;
		var dlkTarget=parseFloat(ele.find('input[name=dlkTarget]').val()) || 0;
		var dlkMaxC=parseFloat(ele.find('input[name=dlkMaxC]').val()) || 0;
		var dlkMaxR=parseFloat(ele.find('input[name=dlkMaxR]').val()) || 0;
		var sowAndMailMinR=parseFloat(ele.find('input[name=sowAndMailMinR]').val()) || 0;
		var sowAndMailMinC=parseFloat(ele.find('input[name=sowAndMailMinC]').val()) || 0;
		var sowAndMailTarget=parseFloat(ele.find('input[name=sowAndMailTarget]').val()) || 0;
		var sowAndMailMaxC=parseFloat(ele.find('input[name=sowAndMailMaxC]').val()) || 0;
		var sowAndMailMaxR=parseFloat(ele.find('input[name=sowAndMailMaxR]').val()) || 0;
		var growndwoodMinR=parseFloat(ele.find('input[name=growndwoodMinR]').val()) || 0;
		var growndwoodMinC=parseFloat(ele.find('input[name=growndwoodMinC]').val()) || 0;
		var growndwoodTarget=parseFloat(ele.find('input[name=growndwoodTarget]').val()) || 0;
		var growndwoodMaxC=parseFloat(ele.find('input[name=growndwoodMaxC]').val()) || 0;
		var growndwoodMaxR=parseFloat(ele.find('input[name=growndwoodMaxR]').val()) || 0;
		var mwlAndSwlMinR=parseFloat(ele.find('input[name=mwlAndSwlMinR]').val()) || 0;
		var mwlAndSwlMinC=parseFloat(ele.find('input[name=mwlAndSwlMinC]').val()) || 0;
		var mwlAndSwlTarget=parseFloat(ele.find('input[name=mwlAndSwlTarget]').val()) || 0;
		var mwlAndSwlMaxC=parseFloat(ele.find('input[name=mwlAndSwlMaxC]').val()) || 0;
		var mwlAndSwlMaxR=parseFloat(ele.find('input[name=mwlAndSwlMaxR]').val()) || 0;
		var sowMinR=parseFloat(ele.find('input[name=sowMinR]').val()) || 0;
		var sowMinC=parseFloat(ele.find('input[name=sowMinC]').val()) || 0;
		var sowTarget=parseFloat(ele.find('input[name=sowTarget]').val()) || 0;
		var sowMaxC=parseFloat(ele.find('input[name=sowMaxC]').val()) || 0;
		var sowMaxR=parseFloat(ele.find('input[name=sowMaxR]').val()) || 0;
		var cbsMinR=parseFloat(ele.find('input[name=cbsMinR]').val()) || 0;
		var cbsMinC=parseFloat(ele.find('input[name=cbsMinC]').val()) || 0;
		var cbsTarget=parseFloat(ele.find('input[name=cbsTarget]').val()) || 0;
		var cbsMaxC=parseFloat(ele.find('input[name=cbsMaxC]').val()) || 0;
		var cbsMaxR=parseFloat(ele.find('input[name=cbsMaxR]').val()) || 0;
		var othersMinR=parseFloat(ele.find('input[name=othersMinR]').val()) || 0;
		var othersMinC=parseFloat(ele.find('input[name=othersMinC]').val()) || 0;
		var othersTarget=parseFloat(ele.find('input[name=othersTarget]').val()) || 0;
		var othersMaxC=parseFloat(ele.find('input[name=othersMaxC]').val()) || 0;
		var othersMaxR=parseFloat(ele.find('input[name=othersMaxR]').val()) || 0;
		
		//Mixed Paper
		var mixedPaper=parseFloat(ele.find('input[name=mixedPaper]').val()) || 0;	
		var mixedPaperMinR=parseFloat(ele.find('input[name=mixedPaperMinR]').val()) || 0;
		var mixedPaperMinC=parseFloat(ele.find('input[name=mixedPaperMinC]').val()) || 0;
		var mixedPaperTarget=parseFloat(ele.find('input[name=mixedPaperTarget]').val()) || 0;
		var mixedPaperMaxC=parseFloat(ele.find('input[name=mixedPaperMaxC]').val()) || 0;
		var mixedPaperMaxR=parseFloat(ele.find('input[name=mixedPaperMaxR]').val()) || 0;
		
		//Cut Book
		var cutBook=parseFloat(ele.find('input[name=cutBook]').val()) || 0;	
		var cutBookMinR=parseFloat(ele.find('input[name=cutBookMinR]').val()) || 0;
		var cutBookMinC=parseFloat(ele.find('input[name=cutBookMinC]').val()) || 0;
		var cutBookTarget=parseFloat(ele.find('input[name=cutBookTarget]').val()) || 0;
		var cutBookMaxC=parseFloat(ele.find('input[name=cutBookMaxC]').val()) || 0;
		var cutBookMaxR=parseFloat(ele.find('input[name=cutBookMaxR]').val()) || 0;
		
		//HW
		var hw=parseFloat(ele.find('input[name=hw]').val()) || 0;	
		var hwMinR=parseFloat(ele.find('input[name=hwMinR]').val()) || 0;
		var hwMinC=parseFloat(ele.find('input[name=hwMinC]').val()) || 0;
		var hwTarget=parseFloat(ele.find('input[name=hwTarget]').val()) || 0;
		var hwMaxC=parseFloat(ele.find('input[name=hwMaxC]').val()) || 0;
		var hwMaxR=parseFloat(ele.find('input[name=hwMaxR]').val()) || 0;
		
		//Unprt SBS
		var unprtsbs=parseFloat(ele.find('input[name=unprtsbs]').val()) || 0;	
		var unprtsbsMinR=parseFloat(ele.find('input[name=unprtsbsMinR]').val()) || 0;
		var unprtsbsMinC=parseFloat(ele.find('input[name=unprtsbsMinC]').val()) || 0;
		var unprtsbsTarget=parseFloat(ele.find('input[name=unprtsbsTarget]').val()) || 0;
		var unprtsbsMaxC=parseFloat(ele.find('input[name=unprtsbsMaxC]').val()) || 0;
		var unprtsbsMaxR=parseFloat(ele.find('input[name=unprtsbsMaxR]').val()) || 0;
		
		//Roshan Need To Print This On Load The Page
		var totalPrec=mwlAndSwl+sow+cbs+sowAndMail+growndwood+dlk+occ+others+mixedPaper+cutBook;
		console.log(totalPrec);
		totalPrec=totalPrec||0;
		
		$('#totalPrec').text(totalPrec.toFixed(2)+" %");
		var data={
				id : id,
				type : type,
				input : input,
				mwlAndSwl : mwlAndSwl,
				sow : sow,
				cbs : cbs,
				sowAndMail : sowAndMail,
				growndwood : growndwood,
				dlk : dlk,
				occ : occ,
				others : others,
				remarks :remarks,
				type2:type2,
				occMinR : occMinR,
				occMinC : occMinC,
				occTarget : occTarget,
				occMaxC : occMaxC,
				occMaxR : occMaxR,
				dlkMinR : dlkMinR,
				dlkMinC : dlkMinC,
				dlkTarget : dlkTarget,
				dlkMaxC : dlkMaxC,
				dlkMaxR : dlkMaxR,
				sowAndMailMinR : sowAndMailMinR,
				sowAndMailMinC : sowAndMailMinC,
				sowAndMailTarget : sowAndMailTarget,
				sowAndMailMaxC : sowAndMailMaxC,
				sowAndMailMaxR : sowAndMailMaxR,
				growndwoodMinR : growndwoodMinR,
				growndwoodMinC : growndwoodMinC,
				growndwoodTarget : growndwoodTarget,
				growndwoodMaxC : growndwoodMaxC,
				growndwoodMaxR : growndwoodMaxR,
				mwlAndSwlMinR : mwlAndSwlMinR,
				mwlAndSwlMinC : mwlAndSwlMinC,
				mwlAndSwlTarget : mwlAndSwlTarget,
				mwlAndSwlMaxC : mwlAndSwlMaxC,
				mwlAndSwlMaxR : mwlAndSwlMaxR,
				sowMinR : sowMinR,
				sowMinC : sowMinC,
				sowTarget : sowTarget,
				sowMaxC : sowMaxC,
				sowMaxR : sowMaxR,
				cbsMinR : cbsMinR,
				cbsMinC : cbsMinC,
				cbsTarget : cbsTarget,
				cbsMaxC : cbsMaxC,
				cbsMaxR : cbsMaxR,
				othersMinR : othersMinR,
				othersMinC : othersMinC,
				othersTarget : othersTarget,
				othersMaxC : othersMaxC,
				othersMaxR : othersMaxR,
				mixedPaper : mixedPaper,
				mixedPaperMinR : mixedPaperMinR,
				mixedPaperMinC : mixedPaperMinC,
				mixedPaperTarget : mixedPaperTarget,
				mixedPaperMaxC : mixedPaperMaxC,
				mixedPaperMaxR : mixedPaperMaxR,
				cutBook : cutBook,
				cutBookMinR : cutBookMinR,
				cutBookMinC : cutBookMinC,
				cutBookTarget : cutBookTarget,
				cutBookMaxC : cutBookMaxC,
				cutBookMaxR : cutBookMaxR,
				//Code Starts From Here Done By Roshan Tailor
				hw : hw,
				hwMinR :hwMinR,
				hwMinC :hwMinC,
				hwTarget :hwTarget,
				hwMaxC :hwMaxC,
				hwMaxR :hwMaxR,
				unprtsbs : unprtsbs,
				unprtsbsMinR :unprtsbsMinR,
				unprtsbsMinC :unprtsbsMinC,
				unprtsbsTarget :unprtsbsTarget,
				unprtsbsMaxC :unprtsbsMaxC,
				unprtsbsMaxR :unprtsbsMaxR
				//Code Ends Here Done By Roshan Tailor
		};
		
		if(saveFormFlag){
			return;
		}
		saveFormFlag=true;
		

		$.ajax({
			url:'${saveProjectionURL}',
			type :'POST',
			data : data,
			success:function(data){
				if(data.status){
					idEle.val(data.id);
					$('#tmessage').text(data.message);
					clearSaveTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				}else{
					alert(data.error);
				}
				saveFormFlag=false;
			},
			error: function(xhr, status, error) {
				alert('Server error.. :-(' );
				saveFormFlag=false;
			}
			
		});
	}
	
	function calculate(){
		var ele=$('#projectionForm');
		var input=parseFloat(ele.find('input[name=input]').val()) || 0;
		
		if(input!=0){
			
			var mwlAndSwl=parseFloat(ele.find('input[name=mwlAndSwl]').val()) || 0;
			
			mwlAndSwl=(mwlAndSwl*input)/100;
			ele.find('input[name=mwlAndSwl]').parent().next().text(mwlAndSwl.toFixed(2));
			
			var cbs=parseFloat(ele.find('input[name=cbs]').val()) || 0;
			cbs=(cbs*input)/100;
			ele.find('input[name=cbs]').parent().next().text(cbs.toFixed(2));
			
			var sow=parseFloat(ele.find('input[name=sow]').val()) || 0;
			sow=(sow*input)/100;
			ele.find('input[name=sow]').parent().next().text(sow.toFixed(2));
			
			
			var sowAndMail=parseFloat(ele.find('input[name=sowAndMail]').val()) || 0;
			sowAndMail=(sowAndMail*input)/100;
			ele.find('input[name=sowAndMail]').parent().next().text(sowAndMail.toFixed(2));
			
			var growndwood=parseFloat(ele.find('input[name=growndwood]').val()) || 0;
			growndwood=(growndwood*input)/100;
			ele.find('input[name=growndwood]').parent().next().text(growndwood.toFixed(2));
			
			var dlk=parseFloat(ele.find('input[name=dlk]').val()) || 0;
			dlk=(dlk*input)/100;
			ele.find('input[name=dlk]').parent().next().text(dlk.toFixed(2));
			
			var occ=parseFloat(ele.find('input[name=occ]').val()) || 0;
			occ=(occ*input)/100;
			ele.find('input[name=occ]').parent().next().text(occ.toFixed(2));
			
			var mixedPaper=parseFloat(ele.find('input[name=mixedPaper]').val()) || 0;
			mixedPaper=(mixedPaper*input)/100;
			ele.find('input[name=mixedPaper]').parent().next().text(mixedPaper.toFixed(2));
			
			var cutBook=parseFloat(ele.find('input[name=cutBook]').val()) || 0;
			cutBook=(cutBook*input)/100;
			ele.find('input[name=cutBook]').parent().next().text(cutBook.toFixed(2));
			
			var others=parseFloat(ele.find('input[name=others]').val()) || 0;
			others=(others*input)/100;
			ele.find('input[name=others]').parent().next().text(others.toFixed(2));
			
			//Code Starts From Here Done By Roshan Tailor
			var sw=parseFloat(ele.find('input[name=sw]').val()) || 0;
			sw=(sw*input)/100;
			ele.find('input[name=sw]').parent().next().text(sw.toFixed(2));
			
			var unprtsbs=parseFloat(ele.find('input[name=unprtsbs]').val()) || 0;
			unprtsbs=(unprtsbs*input)/100;
			ele.find('input[name=unprtsbs]').parent().next().text(unprtsbs.toFixed(2));
			
			
			//Code Ends Here Done By Roshan Tailor
		}
		
	}
	
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='type' | tb.attr('name')=='type2' | tb.attr('name')=='remarks'){
				
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


<!-- Code Done By Roshan Tailor To Print The Total Percentage of All Parameters -->
<c:if test="${type eq 'WH'}">
<script type="text/javascript">
$(document).ready(function(){
	var mwlAndSwl=parseFloat($("input[name=mwlAndSwl]").val()) || 0;
	var sow=parseFloat($("input[name=sow]").val()) || 0;
	var cbs=parseFloat($("input[name=cbs]").val()) || 0;
	var growndwood=parseFloat($("input[name=growndwood]").val()) || 0;
	var mixedPaper=parseFloat($("input[name=mixedPaper]").val()) || 0;
	var cutBook=parseFloat($("input[name=cutBook]").val()) || 0;
	var others=parseFloat($("input[name=others]").val()) || 0;

	var totalPrec=parseFloat(mwlAndSwl)+parseFloat(sow)+parseFloat(cbs)+parseFloat(growndwood)+parseFloat(mixedPaper)+parseFloat(cutBook)+parseFloat(others);
	
	console.log(totalPrec);
	totalPrec=totalPrec||0;

	$('#totalPrec').text(totalPrec.toFixed(2)+" %");
});
</script>
</c:if>

<c:if test="${type eq 'KF'}">
<script type="text/javascript">
$(document).ready(function(){
	var dlk=parseFloat($("input[name=dlk]").val()) || 0;
	var occ=parseFloat($("input[name=occ]").val()) || 0;
	var sow=parseFloat($("input[name=sow]").val()) || 0;
	var sowAndMail=parseFloat($("input[name=sowAndMail]").val()) || 0;
	var growndwood=parseFloat($("input[name=growndwood]").val()) || 0;
	var mixedPaper=parseFloat($("input[name=mixedPaper]").val()) || 0;
	var cutBook=parseFloat($("input[name=cutBook]").val()) || 0;
	var others=parseFloat($("input[name=others]").val()) || 0;

	var totalPrec=parseFloat(dlk)+parseFloat(occ)+parseFloat(sow)+parseFloat(sowAndMail)+parseFloat(growndwood)+parseFloat(mixedPaper)+parseFloat(cutBook)+parseFloat(others);
	
	console.log(totalPrec);
	totalPrec=totalPrec||0;
 
	$('#totalPrec').text(totalPrec.toFixed(2)+" %");
});
</script>
</c:if>

</head>
<body>
<div class="fixed-message">
	<span class="tmessage" id="tmessage"></span>
</div>

	<div class="container">


<table>
	<tr>
		<td>
			<button onclick="window.print();">Print</button>
			<button onclick="location.href='${newURL}'">New</button>
			<button onclick="location.href='${viewURL}'">View</button>
		 </td>
	</tr>
</table>
<hr>

<br>

<div style="margin: auto; width: 100%;text-align: center;">
	<span>Production Type:</span>
	<select id="type" tabindex="1" style="width: 150px; padding: 2px;">
		<option value="" >Select</option>
		<c:forEach items="${frpgrade}" var="grade">
			<c:choose>
				<c:when test="${grade.key eq type}">
					<option value="${grade.key}" selected="selected">${grade.value}</option>
				</c:when>
				<c:otherwise>
					<option value="${grade.key}" >${grade.value}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</div>
<br>
<hr>
<div style="overflow: auto; width: inherit;position: fixed;left: 0;right: 0;bottom: 0;top: 90px;">
<c:if test="${type eq 'KF'}">
	<table id="projectionForm" class="tableForm" style="margin: auto; width: 400px;">
	<tr>
		<td><div style="width:100px; text-align: center;">Napkin/Towel</div></td>
		<td colspan="3">
			<select name="type2" tabindex="1">
				<option value="" >Select</option>
				<c:forEach items="${frpgradetype}" var="gtpye2">
					<c:choose>
						<c:when test="${gtpye2.key eq projection.type2}">
							<option value="${gtpye2.key}" selected="selected">${gtpye2.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${gtpye2.key}" >${gtpye2.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		<td style="text-align: center;">Input</td>
		<td colspan="6"><input name="input" type="text" value="${projection.input}" tabindex="1"></td>
		
	</tr>
	<tr>
		<td colspan="9">&nbsp; </td>
	</tr>
	<tr>
		<td  colspan="2" class=" ui-state-default"></td>
		<td class=" ui-state-default"><div style="min-width: 50px;display: inline-block;text-align: center;" id="totalPrec">%</div></td>
		<td class=" ui-state-default"><div style="width: 100px;text-align: center;">Total Tons</div></td>
		<td class=" ui-state-default" style="text-align: center;">Min Reject</td>
		<td class=" ui-state-default" style="text-align: center;">Min Control</td>
		<td class=" ui-state-default" style="text-align: center;">Target</td>
		<td class=" ui-state-default" style="text-align: center;">Max Control</td>
		<td class=" ui-state-default" style="text-align: center;">Max Reject</td>
	</tr>
	
	<tr>
		<td colspan="2">DLK</td>
		<td><input name="dlk" type="text" value="${projection.dlk}" tabindex="1"></td>
		<td></td>
		<td><input name="dlkMinR" type="text" value="${projection.dlkMinR}" tabindex="1"></td>
		<td><input name="dlkMinC" type="text" value="${projection.dlkMinC}" tabindex="1"></td>
		<td><input name="dlkTarget" type="text" value="${projection.dlkTarget}" tabindex="1"></td>
		<td><input name="dlkMaxC" type="text" value="${projection.dlkMaxC}" tabindex="1"></td>
		<td><input name="dlkMaxR" type="text" value="${projection.dlkMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">OCC</td>
		<td><input name="occ" type="text" value="${projection.occ}" tabindex="1"></td>
		<td></td>
		<td><input name="occMinR" type="text" value="${projection.occMinR}" tabindex="1"></td>
		<td><input name="occMinC" type="text" value="${projection.occMinC}" tabindex="1"></td>
		<td><input name="occTarget" type="text" value="${projection.occTarget}" tabindex="1"></td>
		<td><input name="occMaxC" type="text" value="${projection.occMaxC}" tabindex="1"></td>
		<td><input name="occMaxR" type="text" value="${projection.occMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">SOW</td>
		<td><input name="sow" type="text" value="${projection.sow}" tabindex="1"></td>
		<td></td>
		<td><input name="sowMinR" type="text" value="${projection.sowMinR}" tabindex="1"></td>
		<td><input name="sowMinC" type="text" value="${projection.sowMinC}" tabindex="1"></td>
		<td><input name="sowTarget" type="text" value="${projection.sowTarget}" tabindex="1"></td>
		<td><input name="sowMaxC" type="text" value="${projection.sowMaxC}" tabindex="1"></td>
		<td><input name="sowMaxR" type="text" value="${projection.sowMaxR}" tabindex="1"></td>
		
	</tr>
	<tr>
		<td colspan="2">Mail</td>
		<td><input name="sowAndMail" type="text" value="${projection.sowAndMail}" tabindex="1"></td>
		<td></td>
		<td><input name="sowAndMailMinR" type="text" value="${projection.sowAndMailMinR}" tabindex="1"></td>
		<td><input name="sowAndMailMinC" type="text" value="${projection.sowAndMailMinC}" tabindex="1"></td>
		<td><input name="sowAndMailTarget" type="text" value="${projection.sowAndMailTarget}" tabindex="1"></td>
		<td><input name="sowAndMailMaxC" type="text" value="${projection.sowAndMailMaxC}" tabindex="1"></td>
		<td><input name="sowAndMailMaxR" type="text" value="${projection.sowAndMailMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Groundwood</td>
		<td><input name="growndwood" type="text" value="${projection.growndwood}" tabindex="1"></td>
		<td></td>
		<td><input name="growndwoodMinR" type="text" value="${projection.growndwoodMinR}" tabindex="1"></td>
		<td><input name="growndwoodMinC" type="text" value="${projection.growndwoodMinC}" tabindex="1"></td>
		<td><input name="growndwoodTarget" type="text" value="${projection.growndwoodTarget}" tabindex="1"></td>
		<td><input name="growndwoodMaxC" type="text" value="${projection.growndwoodMaxC}" tabindex="1"></td>
		<td><input name="growndwoodMaxR" type="text" value="${projection.growndwoodMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Mixed Paper</td>
		<td><input name="mixedPaper" type="text" value="${projection.mixedPaper}" tabindex="1"></td>
		<td></td>
		<td><input name="mixedPaperMinR" type="text" value="${projection.mixedPaperMinR}" tabindex="1"></td>
		<td><input name="mixedPaperMinC" type="text" value="${projection.mixedPaperMinC}" tabindex="1"></td>
		<td><input name="mixedPaperTarget" type="text" value="${projection.mixedPaperTarget}" tabindex="1"></td>
		<td><input name="mixedPaperMaxC" type="text" value="${projection.mixedPaperMaxC}" tabindex="1"></td>
		<td><input name="mixedPaperMaxR" type="text" value="${projection.mixedPaperMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Cut Book</td>
		<td><input name="cutBook" type="text" value="${projection.cutBook}" tabindex="1"></td>
		<td></td>
		<td><input name="cutBookMinR" type="text" value="${projection.cutBookMinR}" tabindex="1"></td>
		<td><input name="cutBookMinC" type="text" value="${projection.cutBookMinC}" tabindex="1"></td>
		<td><input name="cutBookTarget" type="text" value="${projection.cutBookTarget}" tabindex="1"></td>
		<td><input name="cutBookMaxC" type="text" value="${projection.cutBookMaxC}" tabindex="1"></td>
		<td><input name="cutBookMaxR" type="text" value="${projection.cutBookMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Others</td>
		<td><input name="others" type="text" value="${projection.others}" tabindex="1"></td>
		<td></td>
		<td><input name="othersMinR" type="text" value="${projection.othersMinR}" tabindex="1"></td>
		<td><input name="othersMinC" type="text" value="${projection.othersMinC}" tabindex="1"></td>
		<td><input name="othersTarget" type="text" value="${projection.othersTarget}" tabindex="1"></td>
		<td><input name="othersMaxC" type="text" value="${projection.othersMaxC}" tabindex="1"></td>
		<td><input name="othersMaxR" type="text" value="${projection.othersMaxR}" tabindex="1"></td>
	</tr>
	
	<!-- Code Starts From Here Done By Roshan Tailor -->
	<!-- This Code Is Commented As Per Requirement..They Told Us To Remove it -->

	<%-- <tr>
		<td colspan="2">SW</td>
		<td><input name="hw" type="text" value="${projection.sw}" tabindex="1"></td>
		<td></td>
		<td><input name="hwMinR" type="text" value="${projection.swMinR}" tabindex="1"></td>
		<td><input name="hwMinC" type="text" value="${projection.swMinC}" tabindex="1"></td>
		<td><input name="hwTarget" type="text" value="${projection.swTarget}" tabindex="1"></td>
		<td><input name="hwMaxC" type="text" value="${projection.swMaxC}" tabindex="1"></td>
		<td><input name="hwMaxR" type="text" value="${projection.swMaxR}" tabindex="1"></td>
	</tr>
	
	<tr>
		<td colspan="2">Unprt SBS</td>
		<td><input name="unprtsbs" type="text" value="${projection.unprtsbs}" tabindex="1"></td>
		<td></td>
		<td><input name="unprtsbsMinR" type="text" value="${projection.unprtsbsMinR}" tabindex="1"></td>
		<td><input name="unprtsbsMinC" type="text" value="${projection.unprtsbsMinC}" tabindex="1"></td>
		<td><input name="unprtsbsTarget" type="text" value="${projection.unprtsbsTarget}" tabindex="1"></td>
		<td><input name="unprtsbsMaxC" type="text" value="${projection.unprtsbsMaxC}" tabindex="1"></td>
		<td><input name="unprtsbsMaxR" type="text" value="${projection.unprtsbsMaxR}" tabindex="1"></td>
	</tr> --%>
	<!-- Code Ends Here Done By Roshan Tailor -->
	<tr>
		<td colspan="9">Remarks </td>
	</tr>
	<tr>
		<td colspan="9">
			<textarea name="remarks" style="width: 600px; height: 50px; resize:none;"  tabindex="1">${projection.remarks}</textarea> 
			<input type="hidden" name="id" value="${projection.id}" >
			<input type="hidden" name="type" value="${type}" >
		</td>
	</tr>
</table>

</c:if>

<c:if test="${type eq 'WH'}">
 	<table id="projectionForm" class="tableForm" style="margin: auto; width: 400px;">
	<tr>
		<td><div style="width:100px; text-align: center;">Napkin/Towel</div></td>
		<td colspan="3">
			<select name="type2" tabindex="1">
				<option value="" >Select</option>
				<c:forEach items="${frpgradetype}" var="gtpye2">
					<c:choose>
						<c:when test="${gtpye2.key eq projection.type2}">
							<option value="${gtpye2.key}" selected="selected">${gtpye2.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${gtpye2.key}" >${gtpye2.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		<td style="text-align: center;">Input</td>
		<td colspan="6"><input name="input" type="text" value="${projection.input}" tabindex="1"></td>
		
	</tr>
	<tr>
		<td colspan="9">&nbsp; </td>
	</tr>
	<tr>
		<td  colspan="2" class=" ui-state-default"></td>
		<td class=" ui-state-default"><div style="min-width: 50px;display: inline-block;text-align: center;" id="totalPrec">%</div></td>
		<td class=" ui-state-default"><div style="width: 100px;text-align: center;">Total Tons</div></td>
		<td class=" ui-state-default" style="text-align: center;">Min Reject</td>
		<td class=" ui-state-default" style="text-align: center;">Min Control</td>
		<td class=" ui-state-default" style="text-align: center;">Target</td>
		<td class=" ui-state-default" style="text-align: center;">Max Control</td>
		<td class=" ui-state-default" style="text-align: center;">Max Reject</td>
	</tr>
	
	<tr>
		<td colspan="2">MWL And SWL</td>
		<td><input name="mwlAndSwl" type="text" value="${projection.mwlAndSwl}" tabindex="1"></td>
		<td></td>
		<td><input name="mwlAndSwlMinR" type="text" value="${projection.mwlAndSwlMinR}" tabindex="1"></td>
		<td><input name="mwlAndSwlMinC" type="text" value="${projection.mwlAndSwlMinC}" tabindex="1"></td>
		<td><input name="mwlAndSwlTarget" type="text" value="${projection.mwlAndSwlTarget}" tabindex="1"></td>
		<td><input name="mwlAndSwlMaxC" type="text" value="${projection.mwlAndSwlMaxC}" tabindex="1"></td>
		<td><input name="mwlAndSwlMaxR" type="text" value="${projection.mwlAndSwlMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">SOW</td>
		<td><input name="sow" type="text" value="${projection.sow}" tabindex="1"></td>
		<td></td>
		<td><input name="sowMinR" type="text" value="${projection.sowMinR}" tabindex="1"></td>
		<td><input name="sowMinC" type="text" value="${projection.sowMinC}" tabindex="1"></td>
		<td><input name="sowTarget" type="text" value="${projection.sowTarget}" tabindex="1"></td>
		<td><input name="sowMaxC" type="text" value="${projection.sowMaxC}" tabindex="1"></td>
		<td><input name="sowMaxR" type="text" value="${projection.sowMaxR}" tabindex="1"></td>
		
	</tr>
	<tr>
		<td colspan="2">CBS</td>
		<td><input name="cbs" type="text" value="${projection.cbs}" tabindex="1"></td>
		<td></td>
		<td><input name="cbsMinR" type="text" value="${projection.cbsMinR}" tabindex="1"></td>
		<td><input name="cbsMinC" type="text" value="${projection.cbsMinC}" tabindex="1"></td>
		<td><input name="cbsTarget" type="text" value="${projection.cbsTarget}" tabindex="1"></td>
		<td><input name="cbsMaxC" type="text" value="${projection.cbsMaxC}" tabindex="1"></td>
		<td><input name="cbsMaxR" type="text" value="${projection.cbsMaxR}" tabindex="1"></td>
		
	</tr>
	<tr>
		<td colspan="2">Groundwood</td>
		<td><input name="growndwood" type="text" value="${projection.growndwood}" tabindex="1"></td>
		<td></td>
		<td><input name="growndwoodMinR" type="text" value="${projection.growndwoodMinR}" tabindex="1"></td>
		<td><input name="growndwoodMinC" type="text" value="${projection.growndwoodMinC}" tabindex="1"></td>
		<td><input name="growndwoodTarget" type="text" value="${projection.growndwoodTarget}" tabindex="1"></td>
		<td><input name="growndwoodMaxC" type="text" value="${projection.growndwoodMaxC}" tabindex="1"></td>
		<td><input name="growndwoodMaxR" type="text" value="${projection.growndwoodMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Mixed Paper</td>
		<td><input name="mixedPaper" type="text" value="${projection.mixedPaper}" tabindex="1"></td>
		<td></td>
		<td><input name="mixedPaperMinR" type="text" value="${projection.mixedPaperMinR}" tabindex="1"></td>
		<td><input name="mixedPaperMinC" type="text" value="${projection.mixedPaperMinC}" tabindex="1"></td>
		<td><input name="mixedPaperTarget" type="text" value="${projection.mixedPaperTarget}" tabindex="1"></td>
		<td><input name="mixedPaperMaxC" type="text" value="${projection.mixedPaperMaxC}" tabindex="1"></td>
		<td><input name="mixedPaperMaxR" type="text" value="${projection.mixedPaperMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Cut Book</td>
		<td><input name="cutBook" type="text" value="${projection.cutBook}" tabindex="1"></td>
		<td></td>
		<td><input name="cutBookMinR" type="text" value="${projection.cutBookMinR}" tabindex="1"></td>
		<td><input name="cutBookMinC" type="text" value="${projection.cutBookMinC}" tabindex="1"></td>
		<td><input name="cutBookTarget" type="text" value="${projection.cutBookTarget}" tabindex="1"></td>
		<td><input name="cutBookMaxC" type="text" value="${projection.cutBookMaxC}" tabindex="1"></td>
		<td><input name="cutBookMaxR" type="text" value="${projection.cutBookMaxR}" tabindex="1"></td>
	</tr>
	<tr>
		<td colspan="2">Others</td>
		<td><input name="others" type="text" value="${projection.others}" tabindex="1"></td>
		<td></td>
		<td><input name="othersMinR" type="text" value="${projection.othersMinR}" tabindex="1"></td>
		<td><input name="othersMinC" type="text" value="${projection.othersMinC}" tabindex="1"></td>
		<td><input name="othersTarget" type="text" value="${projection.othersTarget}" tabindex="1"></td>
		<td><input name="othersMaxC" type="text" value="${projection.othersMaxC}" tabindex="1"></td>
		<td><input name="othersMaxR" type="text" value="${projection.othersMaxR}" tabindex="1"></td>
	</tr>
	
	<tr>
		<td colspan="9">Remarks </td>
	</tr>
	<tr>
		<td colspan="9">
			<textarea name="remarks" style="width: 600px; height: 50px; resize:none;"  tabindex="1">${projection.remarks}</textarea> 
			<input type="hidden" name="id" value="${projection.id}" >
			<input type="hidden" name="type" value="${type}" >
		</td>
	</tr>
</table>

</c:if>

</div>



	</div>

</body>
</html>