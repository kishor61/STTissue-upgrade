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
	
	table td{
		text-align: center;
	}
	table td input[type=text]{
		font-size: 12px;
		font-family: sans-serif;
		text-align: center!important;
		width: 96%;
	}
	table .textbox{
		width: 40px;
	}
</style>
<script type="text/javascript">
$(function(){
	$('input[name=date],input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>

<spring:url value="/convertingline/skuspecificationdataentry/save" var="saveConvertingLineDataURL"/>


<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

$(function(){
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
			var tr = $('#yielddatatable tbody tr:last').clone();
			var ntr = tr.appendTo($('#yielddatatable tbody'));
			
			
			ntr.find('input').val('');
			ntr.find('input[name=date]').removeAttr('id');
			ntr.find('input[name=date]').removeAttr('class');
			ntr.find('input[name=date]').val(mdy); //New Logic Applied By Roshan Tailor
			ntr.find('input[name=date]').datepicker({
				dateFormat : 'mm-dd-yy',
				changeMonth : true,
				changeYear : true,
				onClose:function(){
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
				(tb.attr('name')=='custname') |
				(tb.attr('name')=='skucode') |
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
<script type="text/javascript">
function saveData(jq){
	
	var tr=jq.parent().parent();
	var custname=tr.find('input[name=custname]').val();
	
	if(custname!=""){

		$('#tmessage').text('');
		clearTimeout(clearTimer);
		
		
		
		var id=tr.find('input[name=rowCheckbox]').val();
		var idEle=tr.find('input[name=id]');//This Returning Us Value Of Current Id And Helping Us For Update The Line 
		
		var date=tr.find('input[name=date]').val();
		var custname=tr.find('select[name=custname]').val();
		var skucode=tr.find('select[name=skucode]').val();
		var January=tr.find('input[name=January]').val();
		var February=tr.find('input[name=February]').val();
		var March=tr.find('input[name=March]').val();
		var April=tr.find('input[name=April]').val();
		var May=tr.find('input[name=May]').val();
		var June=tr.find('input[name=June]').val();
		var July=tr.find('input[name=July]').val();
		var August=tr.find('input[name=August]').val();
		var September=tr.find('input[name=September]').val();
		var October=tr.find('input[name=October]').val();
		var November=tr.find('input[name=November]').val();
		var December=tr.find('input[name=December]').val();	
	 	
		var checkboxEle=tr.find('input[name=rowCheckbox]');
		
	 	if(saveLock){
			return;
		}
		saveLock=true;
		$.ajax({
			url:'${saveConvertingLineDataURL}',
			type:'POST',
			data:{
				id : id,
				date : date,
				custname : custname,
				skucode : skucode,
				January : January,
				February : February,
				March : March,
				April : April,
				May : May,
				June : June,
				July : July,
				August : August,
				September : September,
				October : October,
				November : November,
				December : December
			},
			
			success:function(data){
				
				idEle.val(data.id);//By This line Of Code We Are Geting Current Line Number OF <TD>
				checkboxEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				
				saveLock=false;
			},
			error: function(xhr, status, error) {
				alert('Server error.. :-(' );
				saveLock=false;
			}
		});
	}else{
		
	}
	
}
</script> 
<spring:url value="/convertingline/delete" var="deletewinderDataURL" />
<script type="text/javascript">
$(function(){
	$('#deleterowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#yielddatatable tbody input[name=rowCheckbox]:checked').val();
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
<spring:url value="/convertingline/skuspecificationdataentry/view/backdateddata/editid" var="parentURl"></spring:url>
<script type="text/javascript">
$(function(){
	$('#editrowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#yielddatatable tbody input[name=rowCheckbox]:checked').val();
		if(typeof val==='undefined'){
			alert('Please Select A Row To Edit The Record.');
		}else{
			if(val==''){
				alert("First Row Can't Delete.");
				//$('#yielddatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				//window.open("${parentURl}/"+val);
				//window.location.href='${parentURl}/'+val;
				$('#'+val+'').css('display','');
				$('#'+val+'').css("background-color", "#CB842E");
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

				<c:if test="${coreentry}">
				<div class="page-title">
					<span class="label">Converting Line Data Entry</span>
				</div>
				</c:if>
				<c:if test="${backentry}">
				<div class="page-title">
					<span class="label">Converting Line Back Dated Entry</span>
				</div>
				</c:if>
				<div class="table-selector">
					<c:if test="${coreentry}">
					<table>
						<tr>
							<!--<td>YIELD Row</td> -->
							<!-- <td><input type="button" id="addrowbutton" name="addmorerow" value="Add Row"></td> -->
							<td><input type="button" id="deleterowbutton" name="deleterow" value="Delete Row"></td>
							<td><input type="button" id="editrowbutton" name="editrow" value="Edit"></td>
							<%-- <td><button onclick="location.href='<spring:url value="/convertingline/skuspecificationdataentry/add/back"/>'">Backdated Entry</button></td> --%>
						</tr>
					</table>
					</c:if>
					<c:if test="${backentry}">
					<spring:url value="/convertingline/skuspecificationdataentry/view/backdateddata" var="viewURL"/>
					<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate"value="${currentdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${currentdate}">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="Load">
							</td>
						</tr>
					</table>
					</form>
					</c:if>
				</div>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${coreentry}">
<table class="table" id="yielddatatable">
						<thead style="font-size: 12px;">
						<tr>
								<th class="trobjrow" colspan="4" style="width:80px;">Information Selection</th>
								<th class="trobjrow" colspan="13" style="width:80px;">Projections</th>
							</tr>
						<tr>
								<th style="width:10px;" rowspan="2">
									<!-- <input type="checkbox" name="rowCheckboxAll"> -->
								</th>
								<th style="width:200px;">Date</th>
								<th style="width:200px;">Customer Name</th>
								<th style="width:80px;">SKU Code</th>
								<th style="width:80px;">January</th>
								<th style="width:80px;">February</th>
								<th style="width:80px;">March</th>
								<th style="width:80px;">April</th>
								<th style="width:80px;">May</th>
								<th style="width:80px;">June</th>
								<th style="width:80px;">July</th>
								<th style="width:80px;">August</th>
								<th style="width:80px;">September</th>
								<th style="width:80px;">October</th>
								<th style="width:80px;">November</th>
								<th style="width:80px;">December</th>
							</tr>
						</thead>
							<tbody id="yielddatainput">
								<c:if test="${fn:length(currentData) eq 0 }">
									<tr>
										<td colspan="16" style="font-size: 21px; color: #cb842e;">You
											Have Not Entred Data (Forecast Value) For Perticular Search
											And Date Range.</td>
									</tr>
								</c:if>
								<c:if test="${fn:length(currentData)>0}">
									<c:forEach items="${currentData}" var="data">
										<tr>
											<td><input type="radio" name="rowCheckbox"
												value="${data.id}"></td>
											<td><fmt:formatDate value="${data.date}"
													pattern="MM-dd-yyyy" var="dateH" /> ${dateH}</td>
											<td>${data.customer}</td>
											<td>${data.skucode}</td>
											<td>${data.january}</td>
											<td>${data.february}</td>
											<td>${data.march}</td>
											<td>${data.april}</td>
											<td>${data.may}</td>
											<td>${data.june}</td>
											<td>${data.july}</td>
											<td>${data.august}</td>
											<td>${data.september}</td>
											<td>${data.october}</td>
											<td>${data.november}</td>
											<td>${data.december}</td>
										</tr>
										<tr style="display: none;" id="${data.id}">
											<td><input type="radio" name="rowCheckbox" value="${data.id}"></td>
											<td>
												<fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy" var="dateH" /> 
												<input type="text" value="${dateH}" name="date">
											</td>
											<td> 
													 <select name="custname" id="custname" style="width: 200px; padding: 2px;">
														<option value="">Select</option>
														<c:forEach items="${custname}" var="cust">
															<c:choose>
																<c:when test="${cust.customer eq data.customer }">
																	<option value="${cust.customer}" selected="selected">${cust.customer}</option>
																</c:when>
																<c:otherwise>
																Roshan Tailor ; ${cust.customer}
																	<option value="${cust.customer}">${cust.customer}</option>	
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
													</td>
													<td> 
													<select name="skucode" id="" style="width: 200px; padding: 2px;">
														<option value="">Select</option>
														<c:forEach items="${skucode}" var="skucode">
															<c:choose>
																<c:when test="${skucode.productcode eq data.skucode }">
																	<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
																</c:when>
																<c:otherwise>
																	<option value="${skucode.productcode}">${skucode.productcode}</option>	
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
													</td>
											<td><input type="text" value="${data.january}" name="January"></td>
											<td><input type="text" value="${data.february}" name="February"></td>
											<td><input type="text" value="${data.march}" name="March"></td>
											<td><input type="text" value="${data.april}" name="April"></td>
											<td><input type="text" value="${data.may}" name="May"></td>
											<td><input type="text" value="${data.june}" name="June"></td>
											<td><input type="text" value="${data.july}" name="July"></td>
											<td><input type="text" value="${data.august}" name="August"></td>
											<td><input type="text" value="${data.september}" name="September"></td>
											<td><input type="text" value="${data.october}" name="October"></td>
											<td><input type="text" value="${data.november}" name="November"></td>
											<td><input type="text" value="${data.december}" name="December"></td>
										</tr>
									</c:forEach>
								</c:if>

							</tbody>




						</table>
</c:if>
<c:if test="${backentry}">
</c:if>
</div>


			</div>

		</div>


	</div>

</body>
</html>
