<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<spring:url value="/frpproductionopdataentry/save" var="saveUrl"/>

<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

$(function(){
		
		$('#yielddatatable tbody input,#yielddatatable tbody select').focusin(doFocusIn);
		$('#yielddatatable tbody input,#yielddatatable tbody select').focusout(doFocusOut);
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( 
				(tb.attr('name')=='shift') |
				(tb.attr('name')=='crew') |
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
		//currentVal=$(this).val();
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
	}
</script>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<script type="text/javascript">
function saveData(jq){
	
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent().parent(); //Here Were Three Parent Do Them Only Two
	
	var id=tr.find('input[name=id]').val();
	
	var date=tr.find('input[name=date]').val();
	var shift=tr.find('select[name=shift]').val();
	var crew=tr.find('select[name=crew]').val();
	var productiontype=tr.find('select[name=productiontype]').val();
	var col1=tr.find('input[name=col1]').val();
	//var col2=tr.find('input[name=col2]').val();
	var col3=tr.find('input[name=col3]').val();
	var col4=tr.find('input[name=col4]').val();
	var col5=tr.find('input[name=col5]').val();
	var col6=tr.find('input[name=col6]').val();
	var col7=tr.find('input[name=col7]').val();
	var col9=tr.find('input[name=col9]').val();
	var col10=tr.find('input[name=col10]').val();
	var col11=tr.find('input[name=col11]').val();
	var col10a=tr.find('input[name=col10a]').val();
	
	var col11b=tr.find('input[name=col11b]').val();
	var col6b=tr.find('input[name=col6b]').val();
	var col7b=tr.find('input[name=col7b]').val();
	var col8b=tr.find('input[name=col8b]').val();
	var col9b=tr.find('input[name=col9b]').val();
	var col10b=tr.find('input[name=col10b]').val();
	var col12b=tr.find('input[name=col12b]').val();
	var col12=tr.find('input[name=col12]').val();
	
	
 	if(saveLock){
		return;
	}
 	$('#loadPage').show();
	saveLock=true;
	$.ajax({
		url:'${saveUrl}',
		type:'POST',
		data:{
			id : id,
			date : date,
			crew : crew,
			shift : shift,
			col1 : col1,
			col3 : col3,
			col4 : col4,
			col5 : col5,
			col6 : col6,
			col7 : col7,
			col9 : col9,
			col10 : col10,
			col11 : col11,
			col10a : col10a,
			productiontype : productiontype,
			col11b : col11b,
			col6b : col6b,
			col7b : col7b,
			col8b : col8b,
			col9b : col9b,
			col10b : col10b,
			col12b : col12b,
			col12 : col12
		},
		
		success:function(data){
			
			//$('#tmessage').text(data.message);
			$('#rltmessage').text('Data Updated Successfully.');
			clearTimer=setTimeout(function(){$('#tmessage').text('');}, 2000);
			saveLock=false;
			//window.setTimeout('location.reload()', 1000);
			$('#loadPage').hide();
			
		},
		error: function(xhr, status, error) {
			console.log("xhr",xhr);
			console.log("status",status);
			console.log("error",error);
			alert('Server error.. :-(' );
			$('#loadPage').hide();
			$('#rltmessage').text(''); 
			saveLock=false;
		}
	});
	
}
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="../header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
			<div class="page-title">
					<span class="label">FRP Production Operator Data Entry Report</span>
				</div>
				<div class="table-selector">
					
					
					<table style="margin: auto;">
						<tr>
							<td>Edit Report</td>
						</tr>
					</table>
				

				</div>
<center><p id="rltmessage" style="color: green;"></p></center>
<c:if test="${showreport}">
		<c:if test="${fn:length(details) eq 0 }">	
			<div>
				<p><b style="color: red;">No Data Found For Related Search.</b></p>
			</div>	
		</c:if>	

<br>		
<c:if test="${fn:length(details) > 0 }">	
<div id="printDiv">
<table id="yielddatatable" border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:100%" cellpadding="3" cellspacing="3">
	<tr>
		<td style="background-color: #00B8FF;"></td>
		<td style="background-color: #00B8FF;"><center><b>Date</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>Shift</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>Crew</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>Production Type</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>DEINK W.W. PUMP<br>4 3 1 - FT -6875</b></center></td>
		<%-- <td style="background-color: #00B8FF;"><center><b>60 # STEAM TO<br>BACKUP HEATER<br>430-FT-6946</b></center</td> --%>
		<td style="background-color: #00B8FF;"><center><b>WATER TO FIRE/<br>MILL WATER TANK<br>430-FT-6956<br># 1008</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>FIRE SYSTEM WATER<br>430-FT-6959<br># 1009</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>DEINKING PLANT<br>EFFLUENT<br>431-FT-6083</b></center></td>
		<td style="background-color: #00B8FF;"><center><b>SEWER FLOW </b></center></td>
		
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/>HD LEVEL AS OF<br>7 AM / 7 PM</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/>TONS PRODUCED TO <br>TO PCC TANK</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/>WETLAP TONS<br>PRODUCED</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/>YIELD</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/>WASTE PAPER FED</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/># OF BATCHES FED<br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line A-</span><br/>Current Run Rate<br></b></center></td>
		
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/>PCC Tank LEVEL AS OF<br>7 AM / 7 PM</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/>TONS PRODUCED TO <br>THE TUBE CONVEYOR</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/>B to A PULP <br></b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/>YIELD</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/>WASTE PAPER FED</b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/># OF BATCHES FED<br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></b></center></td>
		<td style="background-color: #00B8FF;"><center><b><span style="color: red;">Line B-</span><br/>Current Run Rate<br></b></center></td>
		
	</tr>
<c:forEach items="${details}" var="data">
	
	<tr>
			
		 <td style="background-color: #6EA23E;"><input type="radio" value="${data.id}" name="id"></td>
		 <fmt:formatDate value="${data.date}" pattern="MM/dd/yyyy" var="date"/>
		
		<td style="background-color: #6EA23E;">
			<input type="hidden" value="${date}" name="date">	
			<b><fmt:formatDate value="${data.date}" pattern="MM/dd/yyyy"/></b>
		</td>
		<td>
			<select name="shift" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<c:if test="${data.shift=='DAY'}">
										<option value="DAY" selected="selected">Day</option>
										<option value="NIGHT">Night</option>
									</c:if>
									<c:if test="${data.shift=='NIGHT'}">
										<option value="DAY" >Day</option>
										<option value="NIGHT" selected="selected">Night</option>
									</c:if>
									<c:if test="${data.shift=='None'}">
										<option value="DAY" >Day</option>
										<option value="NIGHT" >Night</option>
									</c:if>
			</select>
		</td>
		<td>
			<select name="crew" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<c:if test="${data.crew=='A'}">
										<option value="A" selected="selected" >A</option>
										<option value="B" >B</option>
										<option value="C" >C</option>
										<option value="D" >D</option>
									</c:if>
									<c:if test="${data.crew=='B'}">
										<option value="A" >A</option>
										<option value="B" selected="selected" >B</option>
										<option value="C" >C</option>
										<option value="D" >D</option>
									</c:if>
									<c:if test="${data.crew=='C'}">
										<option value="A" >A</option>
										<option value="B" >B</option>
										<option value="C"selected="selected"  >C</option>
										<option value="D" >D</option>
									</c:if>
									<c:if test="${data.crew=='D'}">
										<option value="A" >A</option>
										<option value="B" >B</option>
										<option value="C" >C</option>
										<option value="D"selected="selected"  >D</option>
									</c:if>
									<c:if test="${data.crew=='None'}">
										<option value="A" >A</option>
										<option value="B" >B</option>
										<option value="C" >C</option>
										<option value="D" >D</option>
									</c:if>
							</select>
		</td>
		<td>
			<select name="productiontype" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<option value="Kraft" selected="selected">Kraft</option>
			</select>
									
		</td>
		<td><center><input type="text" value="${data.col1}" name="col1" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col3}" name="col3" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col4}" name="col4" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col5}" name="col5" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col12}" name="col12" style="width: 75px;"></center></td>
		
		<td><center><input type="text" value="${data.col11}" name="col11" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col6}" name="col6" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col7}" name="col7" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${((data.getCol6()+data.getCol7())/data.getCol9())*100}" name="" style="width: 75px;" readonly="readonly"></center></td>
		<td><center><input type="text" value="${data.col9}" name="col9" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col10}" name="col10" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col10a}" name="col10a" style="width: 75px;"></center></td>
		
		<td><center><input type="text" value="${data.col11b}" name="col11b" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col6b}" name="col6b" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col7b}" name="col7b" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${((data.getCol6b()+data.getCol7b())/data.getCol9b())*100}" name="" style="width: 75px;" readonly="readonly"></center></td>
		<td><center><input type="text" value="${data.col9b}" name="col9b" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col10b}" name="col10b" style="width: 75px;"></center></td>
		<td><center><input type="text" value="${data.col12b}" name="col12b" style="width: 75px;"></center></td>
		
	</tr>
</c:forEach>
</table>


</div>
		</c:if>
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
