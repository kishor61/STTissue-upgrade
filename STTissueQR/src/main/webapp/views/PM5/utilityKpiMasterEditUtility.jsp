<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>

<spring:url value="/pm5utilitykpimaster/saveutility"  var="saveUrl"/>


<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

	$(function(){
		$('input[name=date]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			onClose:function(){
				saveData($(this));
				$(this).parent().next().children().focus();
			}
		});
		
		$('#utilityTable tbody input').focusin(doFocusIn);
		$('#utilityTable tbody input').focusout(doFocusOut);
		
		
		
		
		
	});
	
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
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	var date=tr.find('input[name=date]').val();
	var time=tr.find('input[name=time]').val();
	var lb60=tr.find('input[name=lb60]').val();
	var consumption1=tr.find('input[name=consumption1]').val();
	var lb150=tr.find('input[name=lb150]').val();
	var consumption2=tr.find('input[name=consumption2]').val();
	var millWater=tr.find('input[name=millWater]').val();
	var consumption3=tr.find('input[name=consumption3]').val();
	var condensate=tr.find('input[name=condensate]').val();
	var consumption4=tr.find('input[name=consumption4]').val();
	var riverWater=tr.find('input[name=riverWater]').val();
	var riverWaterData=tr.find('input[name=riverWaterData]').val();
	
	
	if(saveLock){
		return;
	}
	
	saveLock=true;
	
	$.ajax({
		url:'${saveUrl}',
		type:'POST',
		data:{
			id : id,
			date : date,
			time : time,
			lb60 : lb60,
			consumption1 : consumption1,
			lb150 : lb150,
			consumption2 : consumption2,
			millWater : millWater,
			consumption3 : consumption3,
			condensate : condensate,
			consumption4 : consumption4,
			riverWater : riverWater,
			riverWaterData : riverWaterData

		},
		success:function(data){
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				
				updateRow(data.pdata);
				
			}else{
				alert(data.error);
			}
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
}

function updateRow(data){
	/* if(data.id){
		var idEle=$("#utilityTable tbody input[value="+data.id+"]");
		if(idEle){
			var tr=idEle.parent().parent();
			tr.find('input[name=consumption1]').val(data.consumption1).addClass('ucell');
			tr.find('input[name=consumption2]').val(data.consumption2).addClass('ucell');
			tr.find('input[name=consumption3]').val(data.consumption3).addClass('ucell');
			tr.find('input[name=consumption4]').val(data.consumption4).addClass('ucell');
			
			setTimeout(function(){
				tr.find('.ucell').each(function(){
					
					$(this).removeClass('ucell');
				});
			}, 2000);
			
		}
	} */
}

function validatePQ(tb){
	if($.trim(tb.val())!=''){
		if( (tb.attr('name')=='date')
			){
			saveLock=false;
			return false;
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
			
			saveLock=false;
			return false;
			
		}else if(isNaN(tb.val())){
			alert('Enter a valid number.');
			setTimeout(function(){tb.focus();}, 10);
			saveLock=true;
			return true;
		}else if(tb.val()%1!==0){
			alert('Enter whole number only.');
			setTimeout(function(){tb.focus();}, 10);
			saveLock=true;
			return true;
		}
		tb.val(parseInt(tb.val(), 10));
	}
	saveLock=false;
	return false;
}
</script>


<table id="utilityTable" class="table" style="width: 600px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 10px;"></th>
			<th>Date</th>
			<th>Time</th>
			<!-- <th>60 lb</th> -->
			<th><!-- Consumption <br>lbs -->60lb</th>
			<!-- <th>150 lb <br>lbs</th> -->
			<th><!-- Consumption<br>lbs -->150lb</th>
			<!-- <th>Mill water<br>Gallons</th> -->
			<th><!-- Consumption<br>Gallons -->Mill Water</th>
		<!-- 	<th>Condensate</th> -->
			<th><!-- Consumption -->Condesate</th>
			<th>River Water</th>
			<th>River Water<br>Temp</th>
		</tr>
	</thead>
	<tbody>
	
	<c:if test="${fn:length(utilityDatas)>0 }">
		<c:forEach items="${utilityDatas}" var="data">
			<tr>
				<td><input type="radio" name="id" value="${data.id}"> </td>
				<td style="width: 80px;">
					<fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy" var="fdate"/>
					<input type="text" name="date" value="${fdate}" readonly="readonly"> 
					
				</td>
				<td style="width: 90px;">
					<fmt:formatDate value="${data.date}" pattern="HH:mm" var="ftime"/>
					<input type="text" name="time" value="${ftime}">
				</td>
				<%-- <td style="width: 90px;"><input type="text" name="lb60" value="${data.lb60}"> </td> --%>
				<td style="width: 90px;"><input type="text" name="consumption1" value="${data.consumption1}"> </td>
				<%-- <td style="width: 90px;"><input type="text" name="lb150" value="${data.lb150}"> </td> --%>
				<td style="width: 90px;"><input type="text" name="consumption2" value="${data.consumption2}"> </td>
				<%-- <td style="width: 90px;"><input type="text" name="millWater" value="${data.millWater}"> </td> --%>
				<td style="width: 90px;"><input type="text" name="consumption3" value="${data.consumption3}"> </td>
				<%-- <td style="width: 90px;"><input type="text" name="condensate" value="${data.condensate}"> </td> --%>
				<td style="width: 90px;"><input type="text" name="consumption4" value="${data.consumption4}"> </td>
				<td style="width: 90px;"><input type="text" name="riverWaterData" value="${data.riverWaterData}"> </td>
				<td style="width: 90px;"><input type="text" name="riverWater" value="${data.riverWater}"> </td>
			</tr>
		</c:forEach>
	</c:if>
	
	</tbody>
</table>
</div>				

