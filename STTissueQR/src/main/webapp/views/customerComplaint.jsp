<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/customercomplaintreport/save" var="saveURL" />
<style type="text/css">
.button{
 text-decoration:none; 
 text-align:center; 
 padding:11px 32px; 
 border:solid 1px #004F72; 
 -webkit-border-radius:4px;
 -moz-border-radius:4px; 
 border-radius: 4px; 
 font:18px Arial, Helvetica, sans-serif; 
 font-weight:bold; 
 color:#E5FFFF; 
 background-color:#3BA4C7; 
 background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -ms-linear-gradient(top, #3BA4C7 0% ,#1982A5 100%); 
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 ); 
 background-image: linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);   
 -webkit-box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff; 
 -moz-box-shadow: 0px 0px 2px #bababa,  inset 0px 0px 1px #ffffff;  
 box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;  
  
  }
</style>
<script type="text/javascript">
$(function(){
	$('input[name=Proddate],input[name=Targetdate],input[name=Date]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;
$(function(){
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusin(doFocusIn);
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusout(doFocusOut);
		
		
		$('#addRowBtn').click(function(){
			
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
			var currenttime = date.getHours() + ":" + date.getMinutes();
			
			var otr = $('#yielddatatable tbody tr:last');
			var tr = $('#yielddatatable tbody tr:last').clone();
			var ntr = tr.appendTo($('#yielddatatable tbody'));
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=Date],input[name=Proddate],input[name=Targetdate]').removeAttr('id');
			ntr.find('input[name=Date],input[name=Proddate],input[name=Targetdate]').removeAttr('class');
			ntr.find('input[name=Date],input[name=Proddate],input[name=Targetdate]').val(mdy); //New Logic Applied By Roshan Tailor
			ntr.find('input[name=time]').val(currenttime);
			ntr.find('input[name=Date],input[name=Proddate],input[name=Targetdate]').datepicker({
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
		
	});
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( 
				(tb.attr('name')=='Date')|
				(tb.attr('name')=='Description')|
				(tb.attr('name')=='Grade')|
				(tb.attr('name')=='Customer')|
				(tb.attr('name')=='Type')|
 				(tb.attr('name')=='Proddate')|
				(tb.attr('name')=='Remarks')|
				(tb.attr('name')=='Resp')|
 				(tb.attr('name')=='Targetdate')|
				(tb.attr('name')=='Status')
				
			)
			{
				//Do Nothing 
					}
			else if(tb.attr('name')=='time'){
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
	
</script>
<script type="text/javascript">
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var Date=tr.find('input[name=Date]').val();
	var Description=tr.find('input[name=Description]').val();
	var Grade=tr.find('select[name=Grade]').val();
	var Customer=tr.find('select[name=Customer]').val();
	var Type=tr.find('input[name=Type]').val();
	var Prod=tr.find('input[name=Proddate]').val();
	var Remarks=tr.find('input[name=Remarks]').val();
	var Resp=tr.find('input[name=Resp]').val();
	var Targetdate=tr.find('input[name=Targetdate]').val();
	var Status=tr.find('input[name=Status]').val();
	
	var Date=tr.find('input[name=Date]').val();
	if(typeof Date==='undefined'){
		Date='';
	}
	var Description=tr.find('input[name=Description]').val();
	if(typeof Description==='undefined'){
		Description='';
	}
	var Grade=tr.find('select[name=Grade]').val();
	if(typeof Grade==='undefined'){
		Grade='';
	}
	
	var Customer=tr.find('select[name=Customer]').val();
	if(typeof Customer==='undefined'){
		Customer='';
	}
	var Type=tr.find('input[name=Type]').val();
	if(typeof Type==='undefined'){
		Type='';
	}
	var Proddate=tr.find('input[name=Proddate]').val();
	if(typeof Prod==='undefined'){
		Prod='';
	}
	var Remarks=tr.find('input[name=Remarks]').val();
	if(typeof Remarks==='undefined'){
		Remarks='';
	}
	var Resp=tr.find('input[name=Resp]').val();
	if(typeof Resp==='undefined'){
		Resp='';
	}
	var Targetdate=tr.find('input[name=Targetdate]').val();
	if(typeof Targetdate==='undefined'){
		Targetdate='';
	}
	var Status=tr.find('input[name=Status]').val();
	if(typeof Status==='undefined'){
		Status='';
	}
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$.ajax({
		url:'${saveURL}',
		type:'POST',
		data:{
			id : id,
			Date : Date,
			Description : Description,
			Grade : Grade,
			Customer : Customer,
			Type : Type,
			Proddate : Proddate,
			Remarks:Remarks,
			Resp:Resp,
			Targetdate:Targetdate,
			Status:Status
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
	//window.location.reload(true);
	
}
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Customer Complaint Entry Form</span>
				</div>
				<!-- <div class="table-selector">
					
					<table style="margin: auto;">
						<tr>
						<td>
								&nbsp;&nbsp;
								<button id="addRowBtn">Add Row</button>
							</td>	
						</tr>
					</table>
				</div> -->
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<center>
<%-- <table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td style="width: 100px;">&nbsp;</td>
			<td style="width: 100px;">Date</td>
			<td style="width: 100px;">Description</td>
			<td style="width: 100px;">Grade</td>
			<td style="width: 100px;">Customer</td>
			<td style="width: 100px;">Type</td>
			<td style="width: 100px;">Prod. date</td>
			<td style="width: 100px;">Follow up/Remarks</td>
			<td style="width: 100px;">Resp.</td>
			<td style="width: 100px;">Target date</td>
			<td style="width: 100px;">Status</td>
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(customerdatas) eq 0 }">
		<tr>
			<td><input type="radio" name="id" value=""></td>
			<td style="width: 80px;"><input readonly="readonly" type="text" name="Date" value="${date}" autocomplete="off"> </td>
			<td style="width: 60px;"><input type="text" name="Description" value="" autocomplete="off"> </td>
			<td style="width: 75px;">
				<!-- <input type="text" name="Grade" value="" autocomplete="off">  -->
				<select name="Grade" style="width: 200px">
					<option value="">Select</option>
					<c:forEach items="${cgrades}" var="cgrade">
								<option value="${cgrade.grade}">${cgrade.grade}</option>
					</c:forEach>
				</select>
			</td>
			<td style="width: 100px;">
<!-- 				<input type="text" name="Customer" value="" autocomplete="off"> -->
				<select name="Customer" style="width: 130px;padding: 2px;">
					<option value="">Select</option>
					<c:forEach items="${customers}" var="cust">
								<option value="${cust}">${cust}</option>	
					</c:forEach>
				</select>
			</td>
			<td style="width: 75px;"><input type="text" name="Type" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="Proddate" value="${proddateShow}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="Remarks" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="Resp" value="" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="Targetdate" value="${targetdateShow}" autocomplete="off"> </td>
			<td style="width: 75px;"><input type="text" name="Status" value="" autocomplete="off"> </td>
		</tr>
	</c:if>
	<c:if test="${fn:length(customerdatas)> 0 }">
		<c:forEach items="${customerdatas}" var="customerdatas">
			<tr>
				<td><input type="radio" name="id" value="${customerdatas.id}"></td>
			<td style="width: 80px;">
				<fmt:formatDate value="${customerdatas.date}" pattern="MM-dd-yyyy" var="dateFrom"/>
				<input readonly="readonly" type="text" name="Date"  value="${dateFrom}" autocomplete="off">
			</td>
			<td><input type="text" name="Description" value="${customerdatas.description}" autocomplete="off"></td>
			<td>
				<input type="text" name="Grade" value="${customerdatas.grade}" autocomplete="off">
				<select name="Grade" style="width: 200px">
					<option value="">Select</option>
					<c:forEach items="${cgrades}" var="cgrade">
						<c:choose>
							<c:when test="${cgrade.grade eq customerdatas.grade}">
								<option value="${cgrade.grade}" selected="selected">${cgrade.grade}</option>
							</c:when>
							<c:otherwise>
								<option value="${cgrade.grade}">${cgrade.grade}</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
			</td>
			<td>
				<input type="text" name="Customer" value="${customerdatas.customer}" autocomplete="off">
					<select name="Customer" style="width: 130px;padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${customers}" var="cust">
										
										<c:choose>
											<c:when test="${cust eq customerdatas.customer }">
												<option value="${cust}" selected="selected">${cust}</option>
											</c:when>
											<c:otherwise>
												<option value="${cust}">${cust}</option>	
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
					</select>				
			</td>
			<td><input type="text" name="Type" value="${customerdatas.type}" autocomplete="off"> </td>
			<td>
				<fmt:formatDate value="${customerdatas.proddate}" pattern="MM-dd-yyyy" var="proddate"/>
				<input readonly="readonly" type="text" name="Proddate"  value="${proddate}" >
			</td>
			<td><input type="text" name="Remarks" value="${customerdatas.remarks}" autocomplete="off"> </td>
			<td><input type="text" name="Resp" value="${customerdatas.resp}" autocomplete="off"> </td>
			<td>
				<fmt:formatDate value="${customerdatas.targetdate}" pattern="MM-dd-yyyy" var="targetdate"/>
				<input readonly="readonly" type="text" name="Targetdate"  value="${targetdate}">
			</td>
			<td><input type="text" name="Status" value="${customerdatas.status}" autocomplete="off"> </td>
			</tr>
			
		</c:forEach>
		</c:if>
	</tbody>
</table> --%>
<div><b style="color: green;">${message}</b></div>	
<form action="${saveURL}" method="POST" enctype="multipart/form-data">
<c:if test="${viewpage}">
<table class="tg">
<tr><input type="hidden" name="id" value=""></tr>		
  <tr>
    <td class="tg-yw4l">Date</td>
    <td class="tg-yw4l">
    	<input style="width: 360px;" readonly="readonly" type="text" name="Date" value="${date}" autocomplete="off">
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  
  <tr>
    <td class="tg-yw4l">Complaint / Issue</td>
    <td class="tg-yw4l">
    	<select name="complaintissue" style="width: 360px;";padding: 2px;" required="required">
					<option value="">Select</option>
					<option value="Customer Complaint">Customer Complaint</option>
					<option value="Internal Issue">Internal Issue</option>					
		</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  
  <tr>
    <td class="tg-yw4l">Description</td>
    <td class="tg-yw4l"><input style="width: 360px;" type="text" value="" name="Description"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Grade</td>
    <td class="tg-yw4l">
<!--     	<input type="text" value="" name="Grade"/> -->
   		<select name="Grade" style="width: 360px;">
					<option value="">Select</option>
					<c:forEach items="${cgrades}" var="cgrade">
								<option value="${cgrade.grade}">${cgrade.grade}</option>
					</c:forEach>
				</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Customer</td>
    <td class="tg-yw4l">
<!--     	<input type="text" value="" name="Customer"/> -->
    	<select name="Customer" style="width: 360px;";padding: 2px;">
					<option value="">Select</option>
					<c:forEach items="${customers}" var="cust">
								<option value="${cust}">${cust}</option>	
					</c:forEach>
		</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Type</td>
    <td class="tg-yw4l"><input style="width: 360px;" type="text" value="" name="Type"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Prod. Date</td>
    <td class="tg-yw4l">
    	<input type="text" style="width: 360px;" value="${proddateShow}" name="Proddate"/>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Corrective Action</td>
    <td class="tg-yw4l"><textarea style="margin: 0px; width: 358px; height: 60px;" value="" name="correctiveaction"></textarea></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Follow up/Remarks</td>
    <td class="tg-yw4l"><textarea style="margin: 0px; width: 358px; height: 60px;" value="" name="Remarks"></textarea></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Resp.</td>
    <td class="tg-yw4l">
<!--     <input type="text" value="" name="Resp"/> -->
    <textarea style="margin: 0px; width: 358px; height: 60px;" value="" name="Resp"></textarea></td>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Target Date</td>
    <td class="tg-yw4l"><input style="width: 360px;" type="text" value="${targetdateShow}" name="Targetdate"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Status</td>
    <td class="tg-yw4l"><textarea style="margin: 0px; width: 358px; height: 60px;" value="" name="Status"></textarea></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Attachments (Pictures, Docs)</td>
    <td class="tg-yw4l"><input type="file" name="file1" id="file1"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Attach Kaizen</td>
    <td class="tg-yw4l"><input type="file" name="file2" id="file2"></td>
    <td class="tg-yw4l"></td>
   <td class="tg-yw4l"><input class="button" type="Submit" value="Submit" name="Submit"/></td>
  </tr>
  </table>
</form>
</c:if>
<c:if test="${editpage}">
<c:if test="${fn:length(reportDataEdit)>0}">
<c:forEach items="${reportDataEdit}" var="rde">
<form action="${saveURL}" method="POST">
<table class="tg">
<tr><input type="hidden" name="id" value="${rde.id}"></tr>	
<tr>
    <td class="tg-yw4l">Date</td>
    <td class="tg-yw4l">
    	<fmt:formatDate value="${rde.date}" pattern="MM-dd-yyyy" var="date"/>
		<input style="width: 360px;" type="text" name="Date"  value="${date}">
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Complaint / Issue</td>
    <td class="tg-yw4l">
    	<select name="complaintissue" style="width: 360px;";padding: 2px;" required="required">
						<option value="">Select</option>		
					<c:if test="${rde.complaintissue eq 'Customer Complaint'}">
						<option value="Customer Complaint" selected="selected">Customer Complaint</option>
						<option value="Internal Issue" >Internal Issue</option>		
					</c:if>
					<c:if test="${rde.complaintissue eq 'Internal Issue'}">
					<option value="Customer Complaint" >Customer Complaint</option>
						<option value="Internal Issue" selected="selected">Internal Issue</option>		
					</c:if>
		</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Description</td>
    <td class="tg-yw4l"><input style="width: 360px;" type="text" value="${rde.description}" name="Description"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Grade</td>
    <td class="tg-yw4l">
<%--    		 <input type="text" value="${rde.grade}" name="Grade"/> --%>
	<select name="Grade" style="width: 360px;">
					<option value="">Select</option>
					<c:forEach items="${cgrades}" var="cgrade">
						<c:choose>
							<c:when test="${cgrade.grade eq rde.grade}">
								<option value="${cgrade.grade}" selected="selected">${cgrade.grade}</option>
							</c:when>
							<c:otherwise>
								<option value="${cgrade.grade}">${cgrade.grade}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
	</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Customer</td>
    <td class="tg-yw4l">
<%--     	<input type="text" value="${rde.customer}" name="Customer"/> --%>
					<select name="Customer" style="width: 360px;padding: 2px;">
						<option value="">Select</option>
						<c:forEach items="${customers}" var="cust">
							<c:choose>
								<c:when test="${cust eq rde.customer }">
									<option value="${cust}" selected="selected">${cust}</option>
								</c:when>
								<c:otherwise>
									<option value="${cust}">${cust}</option>	
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Type</td>
    <td class="tg-yw4l"><input  style="width: 360px;" type="text" value="${rde.type}" name="Type"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Prod. Date</td>
    <td class="tg-yw4l">
<%--     	<input type="text" value="${rde.proddate}" name="Proddate"/> --%>
    	<fmt:formatDate value="${rde.proddate}" pattern="MM-dd-yyyy" var="proddate"/>
		<input style="width: 360px;" type="text" name="Proddate"  value="${proddate}">
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Corrective Action</td>
    <td class="tg-yw4l"><textarea style="margin: 0px; width: 358px; height: 60px;" value="" name="correctiveaction">${rde.correctiveaction}</textarea></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Follow up/Remarks</td>
    <td class="tg-yw4l"><textarea style="margin: 0px; width: 358px; height: 92px;" value="" name="Remarks">${rde.remarks}</textarea></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Resp.</td>
    <td class="tg-yw4l">
<!--     	<input type="text" value="" name="Resp"/> -->
    	<textarea style="margin: 0px; width: 358px; height: 92px;" value="" name="Resp">${rde.resp}</textarea></td>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Target Date</td>
    <td class="tg-yw4l">
<%--    		 <input type="text" value="${rde.targetdate}" name="Targetdate"/> --%>
		<fmt:formatDate value="${rde.targetdate}" pattern="MM-dd-yyyy" var="targetdate"/>
		<input style="width: 360px;" type="text" name="Targetdate"  value="${targetdate}">
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Status</td>
    <td class="tg-yw4l"><textarea style="margin: 0px; width: 358px; height: 92px;" value="" name="Status">${rde.status}</textarea></td>
    <td class="tg-yw4l"></td>
 </tr>
  <tr>
    <td class="tg-yw4l">Attachments (Pictures, Docs)</td>
    <td class="tg-yw4l"><input type="file" name="file1" id="file1"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Attach Kaizen</td>
    <td class="tg-yw4l"><input type="file" name="file2" id="file2"></td>
    <td class="tg-yw4l"></td>
   <td class="tg-yw4l"><input class="button" type="Submit" value="Submit" name="Submit"/></td>
  </tr>
</table>
</form>
</c:forEach>
</c:if>
</c:if>
</center>
</div>

			</div>

		</div>


	</div>

</body>
</html>
