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
		width: 100px;
	}
	.tableForm td select{
		width: 120px;
		padding: 2px;
	}
	.tableForm td {
		padding: 1px;
	}
	.tdleft{
		border-left:1px solid #B6B6B6; 
	}
	.tdbot{
		border-bottom:1px solid #B6B6B6;
	}

	@media print {
    	button {
	       display: none;
	    }
	}
}
</style>

<spring:url value="/frpprojection/save" var="saveProjectionURL" />

<script type="text/javascript">
	var currentValue;
	var saveFormFlag;
	var clearSaveTimer;
	$(function(){
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
		
		var type=ele.find('select[name=type]').val();
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
		var sowAndCbs=parseFloat(ele.find('input[name=sowAndCbs]').val()) || 0;
		var whiteGrade=parseFloat(ele.find('input[name=whiteGrade]').val()) || 0;
		var growndwood=parseFloat(ele.find('input[name=growndwood]').val()) || 0;
		var dlk=parseFloat(ele.find('input[name=dlk]').val()) || 0;
		var occ=parseFloat(ele.find('input[name=occ]').val()) || 0;
		var others=parseFloat(ele.find('input[name=others]').val()) || 0;
		var remarks=ele.find('textarea[name=remarks]').val();
		
		var data={
				id : id,
				type : type,
				input : input,
				mwlAndSwl : mwlAndSwl,
				sowAndCbs : sowAndCbs,
				whiteGrade : whiteGrade,
				growndwood : growndwood,
				dlk : dlk,
				occ : occ,
				others : others,
				remarks :remarks,
				type2:type2
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
			
			var sowAndCbs=parseFloat(ele.find('input[name=sowAndCbs]').val()) || 0;
			sowAndCbs=(sowAndCbs*input)/100;
			ele.find('input[name=sowAndCbs]').parent().next().text(sowAndCbs.toFixed(2));
			
			var whiteGrade=parseFloat(ele.find('input[name=whiteGrade]').val()) || 0;
			whiteGrade=(whiteGrade*input)/100;
			ele.find('input[name=whiteGrade]').parent().next().text(whiteGrade.toFixed(2));
			
			var growndwood=parseFloat(ele.find('input[name=growndwood]').val()) || 0;
			growndwood=(growndwood*input)/100;
			ele.find('input[name=growndwood]').parent().next().text(growndwood.toFixed(2));
			
			var dlk=parseFloat(ele.find('input[name=dlk]').val()) || 0;
			dlk=(dlk*input)/100;
			ele.find('input[name=dlk]').parent().next().text(dlk.toFixed(2));
			
			var occ=parseFloat(ele.find('input[name=occ]').val()) || 0;
			occ=(occ*input)/100;
			ele.find('input[name=occ]').parent().next().text(occ.toFixed(2));
			
			var others=parseFloat(ele.find('input[name=others]').val()) || 0;
			others=(others*input)/100;
			ele.find('input[name=others]').parent().next().text(others.toFixed(2));
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

</head>
<body>
<div class="fixed-message">
	<span class="tmessage" id="tmessage"></span>
</div>

	<div class="container">

<spring:url value="/frpprojection/view"  var="viewURL"/>
<spring:url value="/frpprojection/new"  var="newURL"/>
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

<table id="projectionForm" class="tableForm" style="margin: auto; width: 400px;">
	<tr>
		<td class="tdbot" style="width: 90px;text-align: center;">Production Type</td>
		<td class="tdbot" style="width: 145px" >
			<select name="type" tabindex="1">
				<option value="" >Select</option>
				<c:forEach items="${frpgrade}" var="grade">
					<c:choose>
						<c:when test="${grade.key eq projection.type}">
							<option value="${grade.key}" selected="selected">${grade.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${grade.key}" >${grade.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		<td style="width:30px; text-align: center;" class="tdleft tdbot">Napkin/Towel </td>
		<td class="tdbot">
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
	</tr>
	<tr>
		<td class="tdbot">Input</td>
		<td class="tdbot"><input name="input" type="text" value="${projection.input}" tabindex="1"></td>
		<td class="tdbot"></td>
		<td class="tdbot"></td>
	</tr>
	<tr>
		<td class="tdbot" colspan="4">&nbsp; </td>
	</tr>
	<tr>
		<td class="tdbot ui-state-default"></td>
		<td class="tdbot ui-state-default"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; %</td>
		<td class="tdbot ui-state-default" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Total Tons</td>
	</tr>
	<tr>
		<td>MWL & SWL</td>
		<td class="tdleft"><input name="mwlAndSwl" type="text" value="${projection.mwlAndSwl}" tabindex="1"></td>
		<td  colspan="2"  class="tdleft tdbot"></td>
	</tr>
	<tr>
		<td>SOW & CBS</td>
		<td class="tdleft"><input name="sowAndCbs" type="text" value="${projection.sowAndCbs}" tabindex="1"></td>
		<td  colspan="2"  class="tdleft tdbot"></td>
		
	</tr>
	<tr>
		<td>White grades</td>
		<td class="tdleft"><input name="whiteGrade" type="text" value="${projection.whiteGrade}" tabindex="1"></td>
		<td  colspan="2"  class="tdleft tdbot"></td>
	</tr>
	<tr>
		<td>Groundwood</td>
		<td class="tdleft"><input name="growndwood" type="text" value="${projection.growndwood}" tabindex="1"></td>
		<td  colspan="2"  class="tdleft tdbot"></td>
	</tr>
	<tr>
		<td>DLK</td>
		<td class="tdleft"><input name="dlk" type="text" value="${projection.dlk}" tabindex="1"></td>
		<td  colspan="2"  class="tdleft tdbot"></td>
	</tr>
	<tr>
		<td>OCC</td>
		<td class="tdleft"><input name="occ" type="text" value="${projection.occ}" tabindex="1"></td>
		<td colspan="2"  class="tdleft tdbot"></td>
	</tr>
	<tr>
		<td class="tdbot">Others</td>
		<td class="tdleft tdbot"><input name="others" type="text" value="${projection.others}" tabindex="1"></td>
		<td colspan="2"  class="tdleft tdbot"></td>
	</tr>
	<tr>
		<td class="tdbot" colspan="4">Remarks </td>
	</tr>
	<tr>
		<td colspan="4">
			<textarea name="remarks" style="width: 400px; height: 50px; resize:none;"  tabindex="1">${projection.remarks}</textarea> 
			<input type="hidden" name="id" value="${projection.id}" >
		</td>
	</tr>
</table>



	</div>

</body>
</html>
