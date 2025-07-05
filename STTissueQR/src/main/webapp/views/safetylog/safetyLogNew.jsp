<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=date],input[name=incidentDate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		$('#safetyForm input[type=text],#safetyForm select,#safetyForm textarea').focusout(function(){
			if(validate($(this))){
				return;
			}
		});
		
		$('#saveBtn').click(function(){
			var desc=$('textarea[name=description]').val();
			if($.trim(desc)==''){
				alert('Please enter description!');
				$('textarea[name=description]').focus();
				return false;
			}
			
			var flag=false;
			$('#safetyForm').find('input[type=text]').each(function(){
				if(validate($(this))){
					flag=true;
					return false;
				}
			});
			if(flag){
				return false;
			}
			
			
			return true;
		});
		
	});
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='employee'|
					tb.attr('name')=='date'|
					tb.attr('name')=='incidentDate'|
					tb.attr('name')=='area'|
					tb.attr('name')=='actionitems'|
					tb.attr('name')=='description'|
					tb.attr('name')=='categoryofincidents'|
					tb.attr('name')=='remarks'){
				
				return false;
			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				return true;
			}
		}
		return false;
	}
</script>
</head>
<body style="overflow: auto;">

<div class="container">
	<div class="page-title">
		<span class="label">Safety Log-New</span>
	</div>
<br>

<c:if test="${not empty error}">
	<span class="error">${error}</span>
</c:if>
<c:if test="${not empty message}">
	<span class="message">${message}</span>
</c:if>

<spring:url value="/safetylog/save" var="saveURL"/>
<form:form id="safetyForm" action="${saveURL}" method="post" modelAttribute="safetyLog">


<table>
	<tr>
		<td>Entry Date</td>
		<td><input type="text" style="width: 120px;" name="date" value='<fmt:formatDate value="${safetyLog.date}" pattern="MM-dd-yyyy"/>' readonly="readonly"></td>
		<td align="center">Employee</td>
		<td>
			<%-- <input type="text" maxlength="50"  style="width: 120px;" name="employee" value="${safetyLog.employee}"> --%>
			<select style="width: 120px;" name="employee">
			<c:if test="${safetyLog.employee ne '' && not empty safetyLog.employee}">
					<option value="FRP A" selected="selected">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'FRP A' || empty safetyLog.employee}">
					<option value="FRP A" selected="selected">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'FRP B'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B" selected="selected">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'FRP C'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C" selected="selected">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'FRP D'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D" selected="selected">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM5 A'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A" selected="selected">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM5 B'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B" selected="selected">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM5 C'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C" selected="selected">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM5 D'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D" selected="selected">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM6 A'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A" selected="selected">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM6 B'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B" selected="selected">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM6 C'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C" selected="selected">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'TM6 D'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D" selected="selected">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'Shipping'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping" selected="selected">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'Converting'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting" selected="selected">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				
				
				<c:if test="${safetyLog.employee eq 'Contractor'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor" selected="selected">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'Maintenance'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting">Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance" selected="selected">Maintenance</option>
					<option value="Management">Management</option>
				</c:if>
				<c:if test="${safetyLog.employee eq 'Management'}">
					<option value="FRP A">FRP A</option>
					<option value="FRP B">FRP B</option>
					<option value="FRP C">FRP C</option>
					<option value="FRP D">FRP D</option>
					<option value="TM5 A">TM5 A</option>
					<option value="TM5 B">TM5 B</option>
					<option value="TM5 C">TM5 C</option>
					<option value="TM5 D">TM5 D</option>
					<option value="TM6 A">TM6 A</option>
					<option value="TM6 B">TM6 B</option>
					<option value="TM6 C">TM6 C</option>
					<option value="TM6 D">TM6 D</option>
					<option value="Shipping">Shipping</option>
					<option value="Converting" >Converting</option>
					<option value="Contractor">Contractor</option>
					<option value="Maintenance">Maintenance</option>
					<option value="Management" selected="selected">Management</option>
				</c:if>
				
			</select>
		</td>
		<td align="center">Area</td>
		<td>
			<select style="width: 120px;" name="area">
				<c:if test="${safetyLog.area eq 'PM6' || empty safetyLog.area}">
					<option value="PM6" selected="selected">PM6</option>
					<option value="FRP">FRP</option>
					<option value="Converting">Converting</option>
					<option value="Shipping">Shipping</option>
					<option value="TM5">TM5</option>
					<option value="TM6">TM6</option>
					
				</c:if>
				<c:if test="${safetyLog.area eq 'FRP'}">
					<option value="PM6">PM6</option>
					<option value="FRP" selected="selected">FRP</option>
					<option value="Converting">Converting</option>
					<option value="Shipping">Shipping</option>
					<option value="TM5">TM5</option>
					<option value="TM6">TM6</option>
				</c:if>
				
				<c:if test="${safetyLog.area eq 'Converting'}">
					<option value="PM6">PM6</option>
					<option value="FRP" >FRP</option>
					<option value="Converting"selected="selected">Converting</option>
					<option value="Shipping">Shipping</option>
					<option value="TM5">TM5</option>
					<option value="TM6">TM6</option>
				</c:if>
				<c:if test="${safetyLog.area eq 'Shipping'}">
					<option value="PM6">PM6</option>
					<option value="FRP" selected="selected">FRP</option>
					<option value="Converting">Converting</option>
					<option value="Shipping"selected="selected">Shipping</option>
					<option value="TM5">TM5</option>
					<option value="TM6">TM6</option>
				</c:if>
				<c:if test="${safetyLog.area eq 'TM5'}">
					<option value="PM6">PM6</option>
					<option value="FRP" selected="selected">FRP</option>
					<option value="Converting">Converting</option>
					<option value="Shipping">Shipping</option>
					<option value="TM5"selected="selected">TM5</option>
					<option value="TM6">TM6</option>
				</c:if>
				<c:if test="${safetyLog.area eq 'TM6'}">
					<option value="PM6">PM6</option>
					<option value="FRP" selected="selected">FRP</option>
					<option value="Converting">Converting</option>
					<option value="Shipping">Shipping</option>
					<option value="TM5">TM5</option>
					<option value="TM6"selected="selected">TM6</option>
				</c:if>
				
			</select>
		</td>
	</tr>
	<tr>
		<td>Incident Date</td>
		<td ><input type="text" style="width: 120px;" name="incidentDate" value='<fmt:formatDate value="${safetyLog.incidentDate}" pattern="MM-dd-yyyy"/>' readonly="readonly"></td>
		<td align="center">Action Items</td>
		<td>
			<select style="width: 120px;" name="actionitems">
				<c:if test="${safetyLog.actionitems eq 'Crew Review' || empty safetyLog.actionitems}">
					<option value="Crew Review" selected="selected">Crew Review</option>
					<option value="EOP Developed">EOP Developed</option>
					<option value="PM Scheduled">PM Scheduled</option>
					<option value="Repairs Made">Repairs Made</option>
					<option value="SOP Developed">SOP Developed</option>
					<option value="Training Developed">Training Developed</option>
					
				</c:if>
				<c:if test="${safetyLog.actionitems eq 'EOP Developed'}">
					<option value="Crew Review" >Crew Review</option>
					<option value="EOP Developed"selected="selected">EOP Developed</option>
					<option value="PM Scheduled">PM Scheduled</option>
					<option value="Repairs Made">Repairs Made</option>
					<option value="SOP Developed">SOP Developed</option>
					<option value="Training Developed">Training Developed</option>
				</c:if>
				
				<c:if test="${safetyLog.actionitems eq 'PM Scheduled'}">
					<option value="Crew Review" >Crew Review</option>
					<option value="EOP Developed">EOP Developed</option>
					<option value="PM Scheduled" selected="selected">PM Scheduled</option>
					<option value="Repairs Made">Repairs Made</option>
					<option value="SOP Developed">SOP Developed</option>
					<option value="Training Developed">Training Developed</option>
				</c:if>
				<c:if test="${safetyLog.actionitems eq 'Repairs Made'}">
					<option value="Crew Review" >Crew Review</option>
					<option value="EOP Developed">EOP Developed</option>
					<option value="PM Scheduled">PM Scheduled</option>
					<option value="Repairs Made"selected="selected">Repairs Made</option>
					<option value="SOP Developed">SOP Developed</option>
					<option value="Training Developed">Training Developed</option>
				</c:if>
				<c:if test="${safetyLog.actionitems eq 'SOP Developed'}">
					<option value="Crew Review" >Crew Review</option>
					<option value="EOP Developed">EOP Developed</option>
					<option value="PM Scheduled">PM Scheduled</option>
					<option value="Repairs Made">Repairs Made</option>
					<option value="SOP Developed"selected="selected">SOP Developed</option>
					<option value="Training Developed">Training Developed</option>
				</c:if>
				<c:if test="${safetyLog.actionitems eq 'Training Developed'}">
					<option value="Crew Review" >Crew Review</option>
					<option value="EOP Developed">EOP Developed</option>
					<option value="PM Scheduled">PM Scheduled</option>
					<option value="Repairs Made">Repairs Made</option>
					<option value="SOP Developed">SOP Developed</option>
					<option value="Training Developed" selected="selected">Training Developed</option>
				</c:if>
				
			</select>
		</td>
		<!-- Category of Incidents -->
		<td align="center">Category of Incidents</td>
		<td>
			<select style="width: 250px;" name="categoryofincidents">
							<c:if test="${safetyLog.categoryofincidents eq 'Fire' || empty safetyLog.categoryofincidents}">
								<option value="Fire"  selected="selected">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'First Aid'}">
								<option value="Fire">Fire</option>
								<option value="First Aid" selected="selected">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Burn'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn" selected="selected">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Caught In, Under, Between'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between" selected="selected">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Electrical'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical" selected="selected">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Fall from Elevation'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation" selected="selected">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Fall Same Level'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level" selected="selected">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Fumes, Dust, Gas'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas" selected="selected">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Lost Time'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time" selected="selected">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Motor Vehicle'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle" selected="selected">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury OSHA Recordable'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable" selected="selected">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Overexertion'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion" selected="selected">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Reaction'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction" selected="selected">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Injury Struck or Cut By'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By" selected="selected">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Near Miss Equipment'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment" selected="selected">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Near Miss Practice'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice" selected="selected">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Property Damage Collision or Overturn'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn" selected="selected">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Property Damage Collapse'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse" selected="selected">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Property Damage Fire or Explosion'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion" selected="selected">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting">Property Damage Rupture or Bursting</option>
							</c:if>
							<c:if test="${safetyLog.categoryofincidents eq 'Property Damage Rupture or Bursting'}">
								<option value="Fire">Fire</option>
								<option value="First Aid">First Aid</option>
								<option value="Injury Burn">Injury Burn</option>
								<option value="Injury Caught In, Under, Between">Injury Caught In, Under, Between</option>
								<option value="Injury Electrical">Injury Electrical</option>
								<option value="Injury Fall from Elevation">Injury Fall from Elevation</option>
								<option value="Injury Fall Same Level">Injury Fall Same Level</option>
								<option value="Injury Fumes, Dust, Gas">Injury Fumes, Dust, Gas</option>
								<option value="Injury Lost Time">Injury Lost Time</option>
								<option value="Injury Motor Vehicle">Injury Motor Vehicle</option>
								<option value="Injury OSHA Recordable">Injury OSHA Recordable</option>
								<option value="Injury Overexertion">Injury Overexertion</option>
								<option value="Injury Reaction">Injury Reaction</option>
								<option value="Injury Struck or Cut By">Injury Struck or Cut By</option>
								<option value="Near Miss Equipment">Near Miss Equipment</option>
								<option value="Near Miss Practice">Near Miss Practice</option>
								<option value="Property Damage Collision or Overturn">Property Damage Collision or Overturn</option>
								<option value="Property Damage Collapse">Property Damage Collapse</option>
								<option value="Property Damage Fire or Explosion">Property Damage Fire or Explosion</option>
								<option value="Property Damage Rupture or Bursting" selected="selected">Property Damage Rupture or Bursting</option>
							</c:if>

					</select>
					</td>
	</tr>
	<tr>
		<td colspan="6"><br><hr><br></td>
	</tr>
	<tr>
		<td valign="top">Description<label class="error">*</label></td>
		<td colspan="5">
			<textarea style="width: 500px;height: 80px;" name="description" >${safetyLog.description}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="6"><br><hr><br></td>
	</tr>
	<tr>
		<td>Forklift Shutdown</td>
		<td><input name="forkliftShutdown" type="text"  style="width: 90px;" value="${safetyLog.forkliftShutdown}"></td>
		
		<td>Property Damage</td>
		<td><input name="propertyDamage" type="text"  style="width: 90px;" value="${safetyLog.propertyDamage}"></td>
		
		<td>Unsafe Work</td>
		<td><input name="unsafeWork" type="text"  style="width: 90px;" value="${safetyLog.unsafeWork}"></td>
	</tr>
	<tr>
		<td>Fire</td>
		<td><input name="fire" type="text"  style="width: 90px;" value="${safetyLog.fire}"></td>
		
		<td>Near Miss</td>
		<td><input name="nearMiss" type="text"  style="width: 90px;" value="${safetyLog.nearMiss}"></td>
		
		<td>First Aid</td>
		<td><input name="firstAid" type="text"  style="width: 90px;" value="${safetyLog.firstAid}"></td>
	</tr>
	<tr>
		<td>Recordable</td>
		<td><input name="recordable" type="text"  style="width: 90px;" value="${safetyLog.recordable}"></td>
		
		<td>Lost Time</td>
		<td><input name="lostTime" type="text"  style="width: 90px;" value="${safetyLog.lostTime}"></td>
		
		<td>Other</td>
		<td><input name="other" type="text"  style="width: 90px;" value="${safetyLog.other}"></td>
	</tr>
	<tr>
		<td colspan="6"><br><hr><br></td>
	</tr>
	<tr>
		<td valign="top">Remarks</td>
		<td colspan="5">
			<textarea style="width: 500px;height: 50px;" name="remarks">${safetyLog.remarks}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="6"><br><hr>
		<input type="hidden" name="id" value="${safetyLog.id}">
		<button type="submit" id="saveBtn">Save</button>
		</td>
		
	</tr>
</table>
</form:form>

</div>

</body>
</html>
