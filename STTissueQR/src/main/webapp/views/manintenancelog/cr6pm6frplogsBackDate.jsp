<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/manintenancelog/save" var="saveURL" />
<spring:url value="/manintenancelog/delete" var="deletewinderDataURL" />
<spring:url value="/manintenancelog/view/backdate" var="oldDataURL" />
<!-- <script type="text/javascript">
$(function(){
	$('input[name=Proddate],input[name=Targetdate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>  -->

<script type="text/javascript">
var centerlineGrades=${centerlineGrades};

$(function(){
$('#yielddatatable tbody input[name=prodtypeorgradecode]').autocomplete({
		minLength: 1,
	    source: function( request, response ) {
	      response( $.ui.autocomplete.filter(
	    	 centerlineGrades, extractLast( request.term ) ) );
	    },
	    focus: function() {
	      return false;
	    },
	    select: function( event, ui ) {
	      var terms = split( this.value );
	      terms.pop();
	      terms.push( ui.item.value );
	      terms.push( "" );
	      this.value = terms.join( ", " );
	      return false;
	    }
	});
function split( val ) {
    return val.split( /,\s*/ );
}
function extractLast( term ) {
	  return split( term ).pop();
}	
	
});
</script>
<script type="text/javascript">
	$(function(){
		 $('input[name=eedate],input[name=date]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0
		});
		
		$('#loadDataBtn').click(function(){
			var shiftDate=$('input[name=shiftdate]').val();
			var odate=$('input[name=eedate]').val();
			var shift=$('input[name=shift]').val();
			
			if(shift==""){
				alert("Please Select The Shift.");
			}else{
				
				if(shiftDate!=odate){
					var flag=confirm("Do you want to load old data?");
					if(flag){
						location.href='${oldDataURL}/'+odate+'/'+shift;
					}
				}else{
					location.href='${oldDataURL}';
				}
			}
			
			
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
		
		$('#yielddatatable tbody textarea, #yielddatatable tbody textarea').focusout(doFocusOut);
		
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
			console.log(ntr)
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=date]').removeAttr('id');
			ntr.find('input[name=date]').removeAttr('class');
			ntr.find('input[name=date]').val(mdy); //New Logic Applied By Roshan Tailor
			ntr.find('input[name=time]').val(currenttime);
			
			
			var text = ntr.find('select[name=skuCode]').val($("#skuCode option:selected" ).parent().parent().parent().text()); // Find the text
		    //alert(text);
			
			ntr.find('select[name=area]').val($("#area option:selected" ).text());
			ntr.find('textarea[name=comments]').val($("" ).text());
			  
			ntr.find('input[name=date]').val($('#date').val());
			
			
			
			var target='${target}';
			if(target==='ADMIN' || target==='OPERATOR' || target==='OPERATOR4'){
				ntr.find('input[name=prodtypeorgradecode]').removeAttr('id');
				ntr.find('input[name=prodtypeorgradecode]').removeAttr('class');
				ntr.find('input[name=prodtypeorgradecode]').autocomplete({
					minLength: 1,
			        source: function( request, response ) {
			          response( $.ui.autocomplete.filter(
			        	 centerlineGrades, extractLast( request.term ) ) );
			        },
			        focus: function() {
			          return false;
			        },
			        select: function( event, ui ) {
			          var terms = split( this.value );
			          terms.pop();
			          terms.push( ui.item.value );
			          terms.push( "" );
			          this.value = terms.join( ", " );
			          return false;
			        }
			    });
				
				function split( val ) {
				    return val.split( /,\s*/ );
				}
				function extractLast( term ) {
					  return split( term ).pop();
				}	
					
			}else{
				ntr.find('select[name=prodtypeorgradecode]').val($("#prodtypeorgradecode option:selected" ).text());
			}
			
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
				(tb.attr('name')=='date')|
				(tb.attr('name')=='prodtypeorgradecode')|
				(tb.attr('name')=='area')|
				(tb.attr('name')=='error')|
				(tb.attr('name')=='comments')|
				(tb.attr('name')=='prodtypeorgradecode')|
				(tb.attr('name')=='team')|
				(tb.attr('name')=='shift')
			)
			{
				//Do Nothing 
					}
			else if(isNaN(tb.val())){
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
	
	
	function uploadFile() {
  
		 console.log("file",f1);
		  //var file = $('#file').val();
		  
		  var filename = tr.find('input[name=comments]').val().replace(/C:\\fakepath\\/i, '')
		  console.log("file",filename)
		  f1 = i.concat("_").concat(filename);
		  console.log("bankstatement1",f1)
}
	
</script>
<script type="text/javascript">
var f1=''
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var date=tr.find('input[name=date]').val();
	
	var target='${target}';
	var prodtypeorgradecode='';
	if(target==='Admin' || target==='OPERATOR' || target==='OPERATOR4'){
		prodtypeorgradecode=tr.find('input[name=prodtypeorgradecode]').val();	
	}else{
		prodtypeorgradecode=tr.find('select[name=prodtypeorgradecode]').val();	
	}
	
	var area=tr.find('select[name=area]').val();
	var error=tr.find('input[name=error]').val();
	var comments=tr.find('textarea[name=comments]').val();
	
	var shift=tr.find('select[name=shift]').val();
	var team=tr.find('select[name=team]').val();
	 
	 
	//alert(id); 
	
	 
	
	var date=tr.find('input[name=date]').val();
	if(typeof date==='undefined'){
		date='';
	}
	var target1='${target}';
	var prodtypeorgradecode='';
	if(target1==='ADMIN' || target1==='OPERATOR' || target1==='OPERATOR4'){
		prodtypeorgradecode=tr.find('input[name=prodtypeorgradecode]').val();
		if(typeof prodtypeorgradecode==='undefined'){
			prodtypeorgradecode='';
		}
	}else{
		prodtypeorgradecode=tr.find('select[name=prodtypeorgradecode]').val();
		if(typeof prodtypeorgradecode==='undefined'){
			prodtypeorgradecode='';
		}
	}
	
	
	var area=tr.find('select[name=area]').val();
	if(typeof area==='undefined'){
		area='';
	}
	 
	var error=tr.find('input[name=error]').val();
	if(typeof error==='undefined'){
		error='';
	}
	
	var comments=tr.find('textarea[name=comments]').val();
	if(typeof comments==='undefined'){
		comments='';
	}
	
	var shift=tr.find('select[name=shift]').val();
	if(typeof shift==='undefined'){
		shift='';
	}
	
	var team=tr.find('select[name=team]').val();
	if(typeof team==='undefined'){
		team='';
	}
	
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$('#loadPage').show();
	$.ajax({
		url:'${saveURL}',
		type:'POST',
		data:{
			id : id,
			date : date,
			prodtypeorgradecode : prodtypeorgradecode,
			area : area,
			error : error,
			comments : comments,
			team : team,
			shift : shift
		},
		success:function(data){
			
			//countTotalDuration();
			
			var lotEle=tr.find('input[name=lot]');
			
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				location.reload();
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
			$('#loadPage').hide();
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});	
}
 

</script>
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
</head>
<body>
<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
</div>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Log Data Entry</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Date</td>
							<td><input readonly="readonly" type="text" name="eedate"value="${date}" style="width: 80px; text-align: center;"></td>
							<td>
								<input type="hidden" name="shift" value="ALL">
							</td>
							<td>
							<security:authorize access="hasAnyRole('ADMIN,OPERATOR,OPERATOR4')">
								<input type="hidden" name="shiftdate" value="${shiftdate}">
								<security:authorize access="hasAnyRole('ADMIN,OPERATOR,OPERATOR4')">
									<button id="loadDataBtn">Load</button>
								</security:authorize>
								&nbsp;
							</security:authorize>
								<!-- <button id="addRowBtn">Add New Row</button> -->
								&nbsp;
								<button id="deleterowbutton">
									Delete
								</button>
							</td>
						</tr>
					</table>
				

				</div>
<c:if test="${showdata}">
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<center>
<table id="yielddatatable" class="table" style="width: 79%;">
	<thead style="text-align: center;">
		<tr>
			<td rowspan="2">&nbsp;</td>
			<td rowspan="2"><b>Date</b></td>
			<td ><b>Operator</b></td>
			<td ><b>Shift</b></td>
			<td ><b>Team</b></td>
			<security:authorize access="hasAnyRole('OPERATOR2')">
				<td rowspan="2"><b>Production Type</b></td>
			</security:authorize>
			<security:authorize access="hasAnyRole('ADMIN,OPERATOR4,OPERATOR')">
				<td rowspan="2"><b>Grade Code</b></td>
			</security:authorize>
			
			<!-- <td rowspan="2"><b>Area</b> -->
			<!-- <td rowspan="2"><b>Error</b></td> -->
			<td rowspan="2"><b>Comments/Notes</b></td>
		</tr>
	</thead>
	<tbody>
	<c:if test="${fn:length(moniterdatas) eq 0 }">
		<tr style="height: 70px;">
			<td><input type="radio" name="id" value=""></td>
			<td><input readonly="readonly" style="width: 75px;" type="text" name="date" value="${date}" autocomplete="off" id="Date"> </td>
			<c:if test="${data.usertype eq 'ADMIN'}">
				<td>ADMIN</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR'}">
				<td>CR6</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR2'}">
				<td>FRP</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR3'}">
				<td>STI</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR4'}">
				<td>PM</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR5'}">
				<td>CL</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR6'}">
				<td>CR5</td>
			</c:if>
			<td>
				<select name="shift" id="shift"
					style="width: 100px; padding: 2px;" required="required"
					tabindex="2">
						<option value="">Select</option>
						<c:forEach items="${shift}" var="shifts">
							<c:choose>
								<c:when test="${shifts.key eq data.shift}">
									<option value="${shifts.key}" selected="selected">${shifts.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${shifts.key}">${shifts.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select> 
				
			</td>
			<td>
						<select name="team" id="team" style="width: 100px; padding: 2px;" required="required" tabindex="2">
					<option value="">Select</option>
					<c:forEach items="${team}" var="teams" >
						<c:choose>
							<c:when test="${teams.key eq data.team}">
								<option value="${teams.key}" selected="selected">${teams.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${teams.key}" >${teams.value}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				
			</td>
			<td> 
			<security:authorize access="hasAnyRole('ADMIN,OPERATOR4,OPERATOR')">
			<%-- <select name="prodtypeorgradecode" id="prodtypeorgradecode" style="width: 100px; padding: 2px;" required="required">
					<option value="-1">Select</option>
					<c:forEach items="${prodtypeorgradecode}" var="grades">
						<c:choose>
							<c:when test="${grades.gradeCode eq data.prodtypeorgradecode }">
								<option value="${grades.gradeCode}" selected="selected">${grades.gradeCode}</option>
							</c:when>
							<c:otherwise>
								<option value="${grades.gradeCode}">${grades.gradeCode}</option>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> --%>
			<input type="text" name="prodtypeorgradecode" value="" style="width: 300px;height: 70px;">
			</security:authorize>	
			<security:authorize access="hasAnyRole('OPERATOR2')">
				<select name="prodtypeorgradecode" id="prodtypeorgradecode" style="width: 100px; padding: 2px;" required="required" tabindex="2">
					<option value="">Select</option>
					<c:forEach items="${prodtypeorgradecode}" var="grades" >
						<c:choose>
							<c:when test="${grades.key eq data.prodtypeorgradecode}">
								<option value="${grades.key}" selected="selected">${grades.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${grades.key}" >${grades.value}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</security:authorize>
			</td>
			
			<%-- <td>
				<select name="area" id="area">
				  <option value="-1">Select</option>
					<c:forEach items="${area}" var="arealst">
						<c:choose>
							<c:when test="${arealst.areaname eq data.area }">
								<option value="${arealst.areaname}" selected="selected">${arealst.areaname}</option>
							</c:when>
							<c:otherwise>
								<option value="${arealst.areaname}">${arealst.areaname}</option>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</td> --%>
			<!-- <td style="width: 500px;"><input type="text"  style="width: 500px;" name="error" value="" autocomplete="off"> </td> -->
			<td style="width: 500px;">
			<!-- <input type="text" style="width: 801px;height: 70px;" name="comments" value="" autocomplete="off"> -->
			<textarea style="width: 801px;height: 500px;" name="comments"  ></textarea>
			</td>
			
		</tr>
		
	</c:if>
	
	<c:if test="${fn:length(moniterdatas) > 0 }">
	 <c:forEach items="${moniterdatas}" var="data">
		<tr style="height: 70px;">
			<td><input type="radio" name="id" value="${data.id}"></td>
			
			<td>
				<fmt:formatDate value="${data.date}" var="dateS"  pattern="MM-dd-yyyy"/>
				<input style="width: 75px;" type="text" name="date"  value="${dateS}" autocomplete="off" id="date">
			</td>
			<c:if test="${data.usertype eq 'ADMIN'}">
				<td>ADMIN</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR'}">
				<td>CR6</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR2'}">
				<td>FRP</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR3'}">
				<td>STI</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR4'}">
				<td>PM</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR5'}">
				<td>CL</td>
			</c:if>
			<c:if test="${data.usertype eq 'OPERATOR6'}">
				<td>CR5</td>
			</c:if>
			<td>
			<select name="shift" id="shift"
				style="width: 100px; padding: 2px;" required="required"
				tabindex="2">
					<option value="">Select</option>
					<c:forEach items="${shift}" var="shifts">
						<c:choose>
							<c:when test="${shifts.key eq data.shift}">
								<option value="${shifts.key}" selected="selected">${shifts.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${shifts.key}">${shifts.value}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select> 

			</td>
			<td>
						<select name="team" id="team" style="width: 100px; padding: 2px;" required="required" tabindex="2">
					<option value="">Select</option>
					<c:forEach items="${team}" var="teams" >
						<c:choose>
							<c:when test="${teams.key eq data.team}">
								<option value="${teams.key}" selected="selected">${teams.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${teams.key}" >${teams.value}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				
			</td>
			<td> 
			<security:authorize access="hasAnyRole('ADMIN,OPERATOR4,OPERATOR')">
			<%-- <select name="prodtypeorgradecode" id="prodtypeorgradecode" style="width: 100px; padding: 2px;" required="required">
					<option value="-1">Select</option>
					<c:forEach items="${prodtypeorgradecode}" var="grades">
						<c:choose>
							<c:when test="${grades.gradeCode eq data.prodtypeorgradecode }">
								<option value="${grades.gradeCode}" selected="selected">${grades.gradeCode}</option>
							</c:when>
							<c:otherwise>
								<option value="${grades.gradeCode}">${grades.gradeCode}</option>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> --%>
				<input type="text" name="prodtypeorgradecode" value="${data.prodtypeorgradecode }" style="width: 300px;height: 70px;">
			</security:authorize>	
			<security:authorize access="hasAnyRole('OPERATOR2')">
				<select name="prodtypeorgradecode" id="prodtypeorgradecode" style="width: 100px; padding: 2px;" required="required" tabindex="2">
					<option value="">Select</option>
					<c:forEach items="${prodtypeorgradecode}" var="grades" >
						<c:choose>
							<c:when test="${grades.key eq data.prodtypeorgradecode}">
								<option value="${grades.key}" selected="selected">${grades.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${grades.key}" >${grades.value}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</security:authorize>
			</td>
			
			<%-- <td>
				<select name="area" id="area">
				  <option value="-1">Select</option>
					<c:forEach items="${area}" var="arealst">
						<c:choose>
							<c:when test="${arealst.areaname eq data.area }">
								<option value="${arealst.areaname}" selected="selected">${arealst.areaname}</option>
							</c:when>
							<c:otherwise>
								<option value="${arealst.areaname}">${arealst.areaname}</option>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</td> --%>
			<%-- <td style="width: 500px;"><input type="text" style="width: 400px;" name="error" value="${data.error}" autocomplete="off"> </td> --%>
			<td style="width: 801px;">
				<%-- <input type="text" style="width: 500px;height: 70px;" name="comments" value="${data.comments}" autocomplete="off"> --%>
				<textarea style="width: 801px;height: 70px;" name="comments"  >${data.comments}</textarea>
			</td>
			<!-- <td><input type="file" name="errorFile" value="" autocomplete="off"> </td> -->
			
		</tr>
	</c:forEach>	
		
	</c:if>
	
	</tbody>
</table>
</center>
</div>
</c:if>
			</div>

		</div>


	</div>

</body>
</html>
