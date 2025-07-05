<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<spring:url value="/911Emergency/view/inident/update" var="updateURL" />
<spring:url value="/911Emergency/edit" var="emrgencyeditUrl"/>
<spring:url value="/911EmergencyReport/checkuser/" var="checkUser" />

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<script type="text/javascript">
	$(function() {
		
		$("input[type='checkbox']").on("change", function() {
			if ($(this).is(":checked"))
				$(this).val("1");
			else
				$(this).val("0");
		});
		 $('input[name=investigation]').change(function() {
				$('input[name=investigation]').val($(this).val());
			});
			
		$("input[type='checkbox']").each(function() {		
					if ($(this).val() == 1) {
						this.checked = true;
					} else {
		
					}
		
		});
	function operatorSelect(value) {
		var id=$('#incidenttable tbody input[name=id]:checked').val();			
			window.location.href='${emrgencyeditUrl}/'+encodeURIComponent(id);		
	}
});
</script>
<style type="text/css">
.button {
	text-decoration: none;
	text-align: center;
	padding: 11px 32px;
	border: solid 1px #004F72;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	font: 18px Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: #E5FFFF;
	background-color: #3BA4C7;
	background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
	background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
	background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
	background-image: -ms-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5',endColorstr='#1982A5', GradientType=0);
	background-image: linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
	-webkit-box-shadow: 0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;
	-moz-box-shadow: 0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;
	box-shadow: 0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;
}

.wrapper {
	text-align: center;
}

.input {
	margin-left: 66px;
	float: right;
	height: 19px;
	width: 240px;
}
</style>
<script type="text/javascript">
	$(function() {
		var wid = 900;
		$('#printBtn').click(function() {
			$('#tbbl').width(wid)
			$("#checkpoint").css({
				marginLeft : "-284px"
			});
			$('#div_show').show();
			$('#printDiv').printArea();
			$('#tbbl').width(800)
			$("#checkpoint").css({
				marginLeft : "-356px"
			});
			$('#div_show').hide();
		});
	});
	$(function() {
		$( "#dialog" ).dialog({ autoOpen: false,
            height: 200,
            width: 200,
         position: {my: "top middle",
                    at: "top middle",
                    of: "#header"} });
		$('#cancel').click(function(){
			$( "#dialog" ).dialog( "close" );	    
		});
		$('#showdata').click(function() {
			 $( "#dialog" ).dialog( "open" );
		});
		$("#login").click(function() {	
		var firstname=$('input[name=firstname]').val();	
		var pwd=$('input[name=pwd]').val();
			 $.ajax({
					url:'${checkUser}',
					type:'POST',
					data:{
						firstname : firstname,
						pwd : pwd
					},
					success:function(data){
						if(data.status)
						{
							$('input[name=effectedbytheincident]').show();
							
						}
						else
							$('input[name=effectedbytheincident]').hide();
						$( "#dialog" ).dialog( "close" );
					}
				});
			 	
		});
	});
	function validateform() {
		$('#loadPage').show();		
	}
</script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<script type="text/javascript">
	$(function() {
		$('#printBtn').click(function() {
			$('#tbbl td').css("fontSize", 25);
			$('#tbbl td h2').css("fontSize", 25);
			$('#tbbl td span').css("fontSize", 25);
			$('#printDiv').printArea();
		});
	});
</script>
<script type="text/javascript">
$(document).ready(function() {
	$(function() {
		$('#printBtn').click(function() {
			$('#tbbl td').css("fontSize", 25);
			$('#tbbl td h2').css("fontSize", 25);
			$('#tbbl td span').css("fontSize", 25);
			$('#printDiv').printArea();
		});
	});

	$('#submit').click(function() {
		var starIncidentLocation = $('#starIncidentLocation').val();
		var status = $('#status').val();
		var dateOfIncident = $('#dateOfIncident').val();
		var timeOfIncident = $('#timeOfIncident').val();
		var dateReported = $('#dateReported').val();
		
		var effectedbytheincident=$('#effectedbytheincident').val();
		
		var employeeNumber=$('#employeeNumber').val();
		var crew = $('#crew').val();	
		if (status == '-1' || starIncidentLocation == '-1'|| dateOfIncident == '' || timeOfIncident == ''
			|| effectedbytheincident == ''|| employeeNumber == ''|| crew=='-1') {
			if (crew == '-1') {
				$('#err_crew').show();
				$('#err_crew').css({
					"color" : "red"
				});
			} else {
				$('#err_crew').hide();
			}
			if (status == '-1') {
				$('#err_status').show();
				$('#err_status').css({
					"color" : "red"
				});
			} else {
				$('#err_status').hide();
			}
			if (starIncidentLocation == '-1') {
				$('#err_starIncidentLocation').show();
				$('#err_starIncidentLocation').css({
					"color" : "red"
				});
			} else {
				$('#err_starIncidentLocation').hide();
			}

			if (dateOfIncident == '') {
				$('#err_dateOfIncident').show();
				$('#err_dateOfIncident').css({
					"color" : "red"
				});
			} else {
				$('#err_dateOfIncident').hide();
			}
			if (timeOfIncident == '') {
				$('#err_timeOfIncident').show();
				$('#err_timeOfIncident').css({
					"color" : "red"
				});
			} else {
				$('#err_timeOfIncident').hide();
			}
			if (effectedbytheincident == '') {
				$('#err_effectedbytheincident').show();
				$('#err_effectedbytheincident').css({
					"color" : "red"
				});
			} else {
				$('#err_effectedbytheincident').hide();
			}
			if (employeeNumber == '') {
				$('#err_employeeNumber').show();
				$('#err_employeeNumber').css({
					"color" : "red"
				});
			} else {
				$('#err_employeeNumber').hide();
			}
			$('#err_').show();
			$('#err_').css({
				"color" : "red"
			});
			return false;
		} else {
			return true;
		}
	});
	$('select').on('change', function() {		
		var starIncidentLocation = $('#starIncidentLocation').val();
		var status = $('#status').val();			
		if(status !='-1')
		{
			$('#err_status').hide();			
						
		}
		if(starIncidentLocation !='-1')
		{
			$('#err_starIncidentLocation').hide();			
						
		}
	});

	$('input').on('change', function() {
		var dateOfIncident = $('#dateOfIncident').val();
		var timeOfIncident = $('#timeOfIncident').val();
		if (dateOfIncident != '') {
			$('#err_dateOfIncident').hide();
		} 
		if (timeOfIncident != '') {
			$('#err_timeOfIncident').hide();
		}
	});	
		$('input[type=checkbox]').change( function(){		
		    	var status = '';	    
		    	$('input[type=checkbox]:checked').each(function () {		    		   
		    		// status= status+(this.id)+","; 
		    		status= status+(this.id)+","; 
		    	}) 
		    	$('input[name=starCategory]').val(status);
		});

		var starCat=$('input[name=starCategory]').val().split(",");
		$.each(starCat,function(i){				
			$('#'+starCat[i]).prop('checked', true);
		});
		  
			$("input[name='furtherFollowUpRequested']").on("change", function() {
				if ($(this).is(":checked"))
					$(this).val("1");
				else
					$(this).val("0");
				
			});

			
	    	
		var furtherFollowUpRequested=$('input[name=furtherFollowUpRequested]').val();
		//alert(furtherFollowUpRequested);
		if(furtherFollowUpRequested=='1')
			{
			$('input[name=furtherFollowUpRequested]').prop('checked', true);			
			}
	});
</script>


</head>
<body>

	<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading"
				src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
	</div>

	<div class="container">

		<%-- <div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div> --%>


		<div class="block3" style="overflow: auto;">
			<form name="dataForm" id ="form" action="${updateURL}" method="post"
				onsubmit="validateform()" >
				<div class="pageContent">

					<div class="page-title">
						<span class="label">Incident Analysis Report Entry</span>						
					</div>
					<div class="table-selector">




						<input type="hidden" name="id" value="${data.id}">

						<table style="margin: auto;">
							<tr>
								<td>Incident Type:</td>
								<td><select style="width: 100%;" name="incidentType" id="incidentType">
										<option value="-1">Select Incident Type</option>
										<option value="Near_Miss" ${data.incidentType == 'Near_Miss' ? 'selected' : ''}>Near Miss</option>
										<option value="First_Aid" ${data.incidentType == 'First_Aid' ? 'selected' : ''}>First Aid</option>
										<option value="Medical_Treatment" ${data.incidentType == 'Medical_Treatment' ? 'selected' : ''}>Medical Treatment</option>
										<option value="Intervention" ${data.incidentType == 'Intervention' ? 'selected' : ''}>Intervention </option>
										<option value="Unsafe_Condition" ${data.incidentType == 'Unsafe_Condition' ? 'selected' : ''}>Unsafe Condition</option>
										<option value="Safe_Report" ${data.incidentType == 'Safe_Report' ? 'selected' : ''}>Safe Report</option>
										<option value="Damage_Report" ${data.incidentType == 'Damage_Report' ? 'selected' : ''}>Damage Report</option>
										
								</select></td>

								<td>Reported By:</td>
								<td><input type="text" name="employeeNumber" value="${data.employeeNumber}" id="employeeNumber" />
									<label hidden id="err_employeeNumber">Please Fill The Reported By: *****</label></td>

								<td>Date:</td>
								<td><input type="text" readonly name="edate"
									value="${data.edate}" id="edate""></td>
								<td>Shift:</td>
								<td><select style="width: 100%;" name="shift"
									onchange="operatorSelect(this.value);" id="shift">
										<option value="-1">Select Shift</option>
										<option value="day" ${data.shift == 'day' ? 'selected' : ''}>Day</option>
										<option value="night"
											${data.shift == 'night' ? 'selected' : ''}>Night</option>


								</select></td>

							</tr>
						</table>

					</div>
					<c:if test="${not empty message }">

						<span class="message"><center>
								<h>${message}</h>
							</center></span>
					</c:if>

					<br /> <br /> <br />

					<c:if test="${not empty data.incidentType }">
						<div id="printDiv">
							<center>
								<div style="display: none;" id="div_show">
									<div>
										<h1 style="float: left; font-size: 19px;">Incident
											Analysis Report</h1>
											<td><input type="text" hidden name="id"  value="${data.id}"></td>
									</div>
									<div style="float: right;">
										<span><b style="font-size: 15px;">Team Member Name :
										</b>${data.employeeNumber}</span>
									</div>
									<div style="float: right; margin-right: -130px;">
										<br /> <span><b style="font-size: 15px;">Date:</b>${data.edate}</span>
										&nbsp;&nbsp;&nbsp; <span><b style="font-size: 15px;">Shift:</b>${data.shift}</span>
									</div>
								</div>
								<h1 style="float: center; font-size: 19px;">Incident Analysis Report</h1>
								<br /> <br />

								<table style="margin: auto;">
									<tr>
									<td>
										<div id="dialog" title="Basic dialog">
										<form>User Name:
									        <input type="text" name="firstname" />
									        <br/>Password:
									        <input type="password" name="pwd" />
									        <button type="button" id="login">Login</button>
									        <button type="button" id="cancel">Cancel</button>
									    </form>
									</div>
									</td>
									</tr>
									<tr>
								<td style="font-size: 18px;">Team:</td>
								<td><select  name="crew" id="crew">
										<option value="-1">Select Team</option>
										<option value="A" ${data.crew == 'A' ? 'selected' : ''}>A</option>
										<option value="B" ${data.crew == 'B' ? 'selected' : ''}>B</option>
										<option value="C" ${data.crew == 'C' ? 'selected' : ''}>C</option>
										<option value="D" ${data.crew == 'D' ? 'selected' : ''}>D</option>
										<option value="E&I" ${data.crew == 'E&I' ? 'selected' : ''}>E&I</option>
										<option value="maintenance"
											${data.crew == 'maintenance' ? 'selected' : ''}>Maintenance</option>
										<option value="officeadmin"
											${data.crew == 'officeadmin' ? 'selected' : ''}>Office
											Admin</option>
										<option value="dayTeam1" ${data.crew == 'dayTeam1' ? 'selected' : ''}>Day Team 1</option>
										<option value="dayTeam2" ${data.crew == 'dayTeam2' ? 'selected' : ''}>Day Team 2</option>
										<option value="other"
											${data.crew == 'other' ? 'selected' : ''}>Other</option>
								</select>
								<label hidden id="err_crew">Please	Fill The Effected by The Incident</label>
								</td>
								</tr>
									<tr>
										<td style="font-size: 18px;">Effected by The Incident:</td>										
										<td><input hidden type="text" name="effectedbytheincident" value="${data.effectedbytheincident}" id="effectedbytheincident" />
										<button type="button" id="showdata">Show Data</button>
										<label hidden id="err_effectedbytheincident">Please	Fill The Effected by The Incident</label></td>
									</tr>
									<tr>

										<td style="font-size: 18px;">Safe Report:</td>
										<td><textarea id="safeReportId" 
												placeholder="What did You See....."
												value="${data.safeReport}" name="safeReport" rows="7"
												cols="100">${data.safeReport}</textarea></td>
									</tr>

										<td style="font-size: 18px;">Status :</td>
										<td><select  name="status" id="status">
												<option value="-1">Select status</option>
												<option value="Open" ${data.status == 'Open' ? 'selected' : ''}>Open</option>
												<option value="Closed" ${data.status == 'Closed' ? 'selected' : ''}>Closed</option>
										</select><label hidden id="err_status">Please select Status</label></td>
									</tr>
									<%-- <tr>
										<td style="font-size: 18px;">Your Star Area:</td>
										<td><input type="text" style="width: 29%;"
											value="${data.yourStartArea}" name="yourStartArea" /></td>
									</tr> --%>
									<tr>
										<td style="font-size: 18px;">Date Of Incident:</td>
										<td><input type="text"  readonly value="${data.dateOfIncident}"
											name="dateOfIncident" id="dateOfIncident"  /><label hidden id="err_dateOfIncident">Please
												Choose Date Of Incident </label>
											<input type="text" value="${data.timeOfIncident}" name="time"
											id="time" placeholder="HH:MM:SSS"  /><label hidden id="err_timeOfIncident">Please
												Put Time Of Incident(Military
											Time)Like HH:MM:SSS </label></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Date Reported:</td>
										<td><input type="text" readonly value="${data.dateReported}"
											name="dateReported" id="dateReported" />

										</td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Mill Area Where Incident Occured:</td>										
										<td><select name="starIncidentLocation" id="starIncidentLocation" onChange="changearea(this.value);">
												<option value="-1"  selected>Select Incident Area</option>
												<option value="TM6" ${data.starIncidentLocation == 'TM6' ? 'selected' : ''}>TM 6</option>
												<option value="TM5" ${data.starIncidentLocation == 'TM5' ? 'selected' : ''}>TM 5</option>
												<option value="FRP" ${data.starIncidentLocation == 'FRP' ? 'selected' : ''}>FRP</option>
												<option value="Shipping" ${data.starIncidentLocation == 'Shipping' ? 'selected' : ''}>Shipping</option>
												<option value="MaterialHandling" ${data.starIncidentLocation == 'MaterialHandling' ? 'selected' : ''}>Material Handling</option>
												<option value="Utilities" ${data.starIncidentLocation == 'Utilities' ? 'selected' : ''}>Utilities</option>
												<option value="StockPrep" ${data.starIncidentLocation == 'StockPrep' ? 'selected' : ''}>Stock </option>
												<option value="Shopsandstores" ${data.starIncidentLocation == 'Shopsandstores' ? 'selected' : ''}>Shops and stores</option>
												<option value="Other" ${data.starIncidentLocation == 'Other' ? 'selected' : ''}>Other</option>										
										</select><label hidden id="err_starIncidentLocation">Please Select Mill Area Where Incident Occured</label></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Mill Area System :</td>										
										<td style="font-size: 18px;">	
											<select name="locationIncidentOccured" id="locationIncidentOccured">
											    <option value="${data.locationIncidentOccured}"  selected>${data.locationIncidentOccured}</option>											   
											</select>										
										</td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Description Of Event:</td>
										<td><textarea id="descpOfEvent"
												value="${data.descpOfEvent}" name="descpOfEvent" rows="9"
												cols="150">${data.descpOfEvent}</textarea></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Incident Category :</td>
										<td>Mark the star Category that best fit the risk involved</td>

									</tr>
									<tr>
										<td width="14%"></td>
										<td style="width: 86%">

										<table style="width: 100%">
												<tr>
												<input hidden type="text" value="${data.starCategory}" name="starCategory" />
													<td style="width: 20%"><strong style="display: block">1.0
															Body Position</strong>															
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox"value="" id="checkbox11" /> <label
																for="checkbox1">1.1 Struck By/Struck Against</label></li>
															<li><input type="checkbox"value="" id="checkbox12" /> <label
																for="checkbox1">l.2 Pinch Point</label></li>
															<li><input type="checkbox"value="" id="checkbox13" /> <label
																for="checkbox1">1.3 Eyes on Path</label></li>
															<li><input type="checkbox"value="" id="checkbox14" /> <label
																for="checkbox1">1.4 Eyes On Task</label></li>
															<li><input type="checkbox"value="" id="checkbox15" /> <label
																for="checkbox1">1.5 Ascending /Descending</label></li>
														</ul></td>
													<td style="width: 80%"><strong style="display: block">
															2.0 ERGONOMICS</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox"value="" id="checkbox21" /> <label
																for="checkbox1">2.1 Lifting/Lowering</label></li>
															<li><input type="checkbox"value="" id="checkbox22" /> <label
																for="checkbox1">2.2 Awkward Posture</label></li>
															<li><input type="checkbox"value="" id="checkbox23" /> <label
																for="checkbox1">2.3 Repetition /Long Duration</label></li>
															<li><input type="checkbox"value="" id="checkbox24" /> <label
																for="checkbox1">24 Forceful Exertion
																	/Push/Pull/Grip</label></li>
														</ul></td>
												</tr>
												<tr>
													<td style="width: 20%"><strong style="display: block">
															3.0 SELECTION/CONDITION/USE</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox"value=""  id="checkbox31" /> <label
																for="checkbox1">3.1 Tools& Equipment</label></li>
															<li><input type="checkbox"value="" id="checkbox32" /> <label
																for="checkbox1">3.2 Mobile Equipment</label></li>
															<li><input type="checkbox"value="" id="checkbox33" /> <label
																for="checkbox1"> 3.3 Cranes</label></li>

														</ul></td>
													<td style="width: 80%"><strong style="display: block">
															4.0 PROCEDURES</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox"value=""  id="checkbox41" /> <label
																for="checkbox1">4.1 Lockout/Tagout/Energy ISO</label></li>
															<li><input type="checkbox" value="" id="checkbox42" /> <label
																for="checkbox1">4.2 Communication Hazards</label></li>
															<li><input type="checkbox" value="" id="checkbox43" /> <label
																for="checkbox1">4.3 Pre/Post Job Inspection</label></li>
															<li><input type="checkbox" value="" id="checkbox44" /> <label
																for="checkbox1">4.4 Communication of Location </label></li>
														</ul></td>
												</tr>
												<tr>
													<td style="width: 20%"><strong style="display: block">
															5.0 PPE</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox51" /> <label
																for="checkbox1"> 5.1 Standard PPE</label></li>
															<li><input type="checkbox" value="" id="checkbox52" /> <label
																for="checkbox1">5.2 Job Specific PPE</label></li>
															<li><input type="checkbox"  value=""id="checkbox53" /> <label
																for="checkbox1">5.3 Fall Protection</label></li>

														</ul></td>
													<td style="width: 80%"><strong style="display: block">
															6.0 Environment</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox61"/> <label
																for="checkbox1">6.1Walking /Working Surfaces</label></li>
															<li><input type="checkbox" value="" id="checkbox62" /> <label
																for="checkbox1">6.2 Housekeeping Storage</label></li>
															<li><input type="checkbox" value="" id="checkbox63"  /> <label
																for="checkbox1">6.3 Lighting</label></li>
															<li><input type="checkbox" value="" id="checkbox64"/> <label
																for="checkbox1">6.4 Air Quality</label></li>
														</ul></td>
												</tr>
												<tr>
													<td style="width: 20%"><strong style="display: block">
															7.0 STATE OF MIND</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox"  value="" id="checkbox71" /> <label
																for="checkbox">7.1 Hurried</label></li>
															<li><input type="checkbox"  value="" id="checkbox72" /> <label
																for="checkbox1">7.2 Frustrated</label></li>
															<li><input type="checkbox" value=""id="checkbox73" /> <label
																for="checkbox1">7.3 Fatigued</label></li>
															<li><input type="checkbox" value="" id="checkbox74" /> <label
																for="checkbox">7.4 Complacent</label></li>
															
														</ul></td>
													
												</tr>
												
											</table>


										</td>
										
								</tr>
									<tr>
										<td style="width: 20%;font-size: 18px;">Further Follow Up Requested </td>
										<td style="width: 5%;height: 5%;">
										<input type="checkbox" name="furtherFollowUpRequested" value="${data.furtherFollowUpRequested}" /></td>										 
									</tr>	
									<%-- <c:if test="${yesFlage}">
									<tr>
										<td style="width: 20%; font-size: 18px;">Incident Investigation Report</td>
										<td style="width: 5%; height: 5%;">
											 <label><input type="radio" value="Yes" name="investigation"> Yes </label>  
						    				 <label><input type="radio" value="No"  name="investigation" checked> No </label>
										</td>
									</tr>
									</c:if> --%>
								</table>

							</center>
						</div>
				</div>


				<c:choose>
					<c:when test="${edit == 'yes'}">
						<div class="wrapper">
							<br /> <br />
							<button type="button" id="printBtn" class="button">Print</button>
							<button class="button" type="submit">Edit</button>
						</div>
					</c:when>

					<c:otherwise>
						<div class="wrapper">
							<br /> <br />
							<button type="button" id="printBtn1" class="button">Print</button>
							<button class="button" type="submit" id="submit">Update</button>
							<label hidden id="err_">Please First Correct all Errors.....</label>
						</div>
					</c:otherwise>
				</c:choose>

				</c:if>
			</form>

		</div>


	</div>
<script type="text/javascript">
		var locationIncidentOccuredByStarIncidentLocation = {
				TM6 : [ "wetend", "dryend","rewinder", "wrapper", "docks" ],
				TM5 : [ "wetend", "dryend","rewinder", "wrapper", "docks" ],
				FRP : [ "Machine floor", "Machine basement", "warehouse", "receiving docks", "office" ],
				Shipping : [ "warehouse","Loading Docks","office "],
				MaterialHandling : [ "Pulp Make Down", "Additives" ],
				Utilities : [ "Boiler", "Clarifier", "Air Systems" ],
				StockPrep : [ "Stock Prep" ],
				Shopsandstores : [ "Shops "," stores " ],
				Other : [ "PGW", "Wood Room/Wood Yard", "Scale House",
						"Super Calendars", "Winders" ]
				
			}
	    function changearea(value) {
	        if (value.length == 0) document.getElementById("locationIncidentOccured").innerHTML = "<option></option>";
	        else {
	            var locationIncidentOccuredOptions = "";
	            for (locationIncidentOccuredId in locationIncidentOccuredByStarIncidentLocation[value]) {
	            	locationIncidentOccuredOptions += "<option>" + locationIncidentOccuredByStarIncidentLocation[value][locationIncidentOccuredId] + "</option>";
	            }
	            document.getElementById("locationIncidentOccured").innerHTML = locationIncidentOccuredOptions;
	        }
	    }
</script>
</body>
</html>
