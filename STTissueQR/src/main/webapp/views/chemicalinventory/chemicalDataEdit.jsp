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
	.table td{
		text-align: center;
	}
	.table td input{
		text-align: center;
	}
	.tdgray{
		background-color: rgb(233, 233, 233);
		cursor: pointer;
	}
</style>

<spring:url value="/chemicalinv/chemicaldata/new" var="newURL" />
<spring:url value="/chemicalinv/chemicaldata/save" var="saveURL" />

<script type="text/javascript">
var currentVal;
var saveFormFlag=false;
var saveTimer;
$(function(){
		/* $('input[name=date]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true,
		    onClose : function(){
		    	location.href='${newURL}/'+$(this).val();
		    }
		}); */
		
	
		$('#newPage').button({
			icons : {
				primary : "ui-icon-circle-plus"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-circle-arrow-w"
			}
		});
		
		
		$('#tableBody input[type=text]').focusin(function(){
			currentVal=$(this).val();
		});
		$('#tableBody input[type=text]').focusout(function(){
			if(validate($(this))){
				return;
			}	
			
			saveData($(this));
		});
		
	});
	
	function saveData(jq){
		$('#tmessage').text('');
		if(saveTimer){
			clearTimeout(saveTimer);
		}
		
		var date=$('input[name=date]').val();
		
		var value=jq.val();
		
		if($.trim(value)==''){
			return;
		}
	
		if(currentVal!=value){
			
			var entryId=$('input[name=entryId]').val();
			var td=jq.parent().prev().prev();
		
			
			var id=td.find('input[name=id]').val();
			var idEle=td.find('input[name=id]');
			var cid=td.find('input[name=cid]').val();
			
			var consumption=parseFloat(value) || 0;
		
			
			
			if(saveFormFlag){
				return;
			}
			
			saveFormFlag=true;
			
			$.ajax({
				url : '${saveURL}',
				type : 'POST',
				data : {
					date : date,
					entryId : entryId,
					id : id,
					cid : cid,
					consumption : consumption
				},
				success:function(data){
					if(data.flag){
						idEle.val(data.id);
						$('#tmessage').text('Data saved in database successfully.');
						saveTimer=setTimeout(function(){$('#tmessage').text('');}, 3000);
					}else{
						alert(data.error);
					}
				}
					
			});
			
			
		}
		
		
		
	}
	
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='date'){
				return false;
			}else if(tb.attr('name')=='time'){
				var valid1 = (tb.val().search(/^\d{1}:\d{1}$/) != -1);
				var valid2 = (tb.val().search(/^\d{1}:\d{2}$/) != -1);
				var valid3 = (tb.val().search(/^\d{2}:\d{1}$/) != -1);
				var valid4 = (tb.val().search(/^\d{2}:\d{2}$/) != -1);
				if(!(valid1|valid2|valid3|valid4) ){
					alert('Enter a valid time.');
					setTimeout(function(){tb.focus();}, 10);
					saveFormFlag=true;
					return true;
				}
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

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Chemical - Edit</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>
							 	<a id="newPage" href="${newURL}">New</a>
							 	<spring:url value="/chemicalinvreport/view/detail/load?${backParam}" var="backURL"/>
							 	<a id="newPage" href="${backURL}">Back</a>							
							</td>
							
						</tr>
					</table>

				</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
		
<table class="table" style="margin: auto;width: 800px;">
	<thead>
		<tr>
			<td colspan="8">
				<b>Date</b>
				<input type="text" name="date" style="width: 90px;"readonly="readonly" value="${date}"><i>(Readonly)</i>
				<input type="hidden" value="${entryId}" name="entryId">
			</td>
		</tr>
	</thead>
	<tbody id="tableBody">
		<tr>
			<td></td>
			<td><b>SETPOINT</b></td>
			<td><b>ACTUAL VALUE</b></td>
			<td style="width: 50px;"></td>
			
			<td></td>
			<td><b>SETPOINT</b></td>
			<td><b>ACTUAL VALUE</b></td>
			<td style="width: 50px;"></td>
		</tr>
		<tr>
			<td colspan="8" style="background: #FDC893;text-align: left;"><b>Chemical Consumption</b></td>
		</tr>
		<c:set value="${fn:length(chemicals)}" var="len" scope="page"/>

		<c:choose>
			<c:when test="${(len)%2 eq 0}">
				<c:set value="${len/2}" var="len"  scope="page"/>
			</c:when>
			<c:otherwise>
				<c:set value="${(len/2) +1}" var="len"  scope="page"/>
			</c:otherwise>
		</c:choose>

		<c:set value="${0}" var="counter"/>
		
		<c:forEach begin="1" end="${len}" var="ch">
			<tr>
				
				
				<!-- Part First  -->
				
				<c:set value="${chemicals[counter]}" var="ch1"/>
				<td>
					<div>${ch1.chemicalCode}
						<input type="hidden" name="id" value="${ch1.chemicalDataId}" style="width: 30px;">
						<input type="hidden" name="cid" value="${ch1.id}">
					</div>
				</td>
				<td class="tdgray" style="width: 80px;"></td>
				<td style="width: 80px;"><input type="text" name="consumption" value="${ch1.consumption}" style="width: 78px;"></td>
				<td>${ch1.unit}</td>
				<c:set value="${counter+1}" var="counter"/>
				
				
				
				
				<!-- Part Second  -->
				
				<c:set value="${chemicals[counter]}" var="ch2"/>
				<c:choose>
					<c:when test="${not empty ch2}">
						<td>
							<div>${ch2.chemicalCode}
								<input type="hidden" name="id" value="${ch2.chemicalDataId}" style="width: 30px;">
								<input type="hidden" name="cid" value="${ch2.id}">
							</div>
						</td>
						<td class="tdgray"  style="width: 80px;"></td>
						<td style="width: 80px;"><input type="text" name="consumption" value="${ch2.consumption}"  style="width: 78px;"></td>
						<td>${ch2.unit}</td>
						<c:set value="${counter+1}" var="counter"/>
					</c:when>
					<c:otherwise>
						<td colspan="4">
							
						</td>
					</c:otherwise>
				
				</c:choose>
				
				
				
			</tr>
		</c:forEach>
	</tbody>
	
</table>

</div>				
				
			</div>

		</div>


	</div>

</body>
</html>
