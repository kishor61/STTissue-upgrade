<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<spring:url value="/911EmergencyReport/incidentReportEntry/" var="viewURL" />
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
		$('input[name=edate],input[name=sdate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			minDate : -1,
		});
	});
</script>

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
		$('#printBtn').click(function() {
			$('#tbbl td').css("fontSize", 25);
			$('#tbbl td h2').css("fontSize", 25);
			$('#tbbl td span').css("fontSize", 25);
			$('#printDiv').printArea();
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
		$("#submit").click(function() {	
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
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>

<spring:url value="/911EmergencyReport/detailsreportview" var="emrgencyUrl"/>
<spring:url value="/911Emergency/edit" var="emrgencyeditUrl"/>
<script type="text/javascript">
$(document).ready(function() {
	
	$('input[type="checkbox"]').on('click', function(ev){
	    ev.preventDefault();
	})
	
	$('#viewButton').on('click', function(ev){
		var status = $('#status').val();
		if(status=='-1')
		{
			alert("Please Select the status ");			 
			 return false;
		}
	})
	
	$('#editButton').on('click', function(ev){		
		var id=$('input[name=id]').val();	
			window.location.href='${emrgencyeditUrl}/'+encodeURIComponent(id);
		
	});	
		var starCat=$('input[name=starCategory]').val().split(",");
		$.each(starCat,function(i){				
			$('#'+starCat[i]).prop('checked', true);
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
					<c:if test="${not empty message }">
						<span class="message"><center>
								<h>${message}</h>
							</center></span>
					</c:if>	
							<h1 style="margin-left: 0;
    font-size: 19px;
    padding: 1rem 0;
    text-align: center;"><button onclick="history.back();" style="margin: 0%;
    position: absolute;
    left: 0;
    top: 13px;">Back</button>Incident Analysis Report</h1>	
		<div style="background-color: lightblue;  height: 600px;  width: 100%;  
  overflow-y: auto;">																	
							<table style="margin: auto;
    width: 100%;
    border: thin;
    border-color: #a46313;
    border-style: solid;
    border-spacing: 2px;
    overflow-y: scroll;
    padding: 10px;
    /* line-height: 30px; */
    border-width: 3px;
    background: #f9f9f9;" id="incidenttable" >								
							<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">							
								<tr><td><input type="radio" name="id" value="${data.id}">
										<button type="button" id="editButton" value="Edit">Edit</button></td>
								</tr>
							</security:authorize>
									<tr>
										<td style="font-size: 18px; width: 25%;">Incident Type:</td>
										<td style="font-size: 18px; width: 75%;"><label id="incidentType" value="${data.incidentType}" name="incidentType" >${data.incidentType}</label></td>
									</tr>
									<tr>
									<td>
										<div id="dialog" title="Basic dialog">
										<form>User Name:
									        <input type="text" name="firstname" />
									        <br/>Password:
									        <input type="password" name="pwd" />
									        <button type="button" id="submit">Login</button>
									        <button type="button" id="cancel">Cancel</button>
									    </form>
									</div>
									</td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Effected by The Incident:</td>										
										<td><input readonly hidden type="text" name="effectedbytheincident" value="${data.effectedbytheincident}" id="effectedbytheincident" />
										<button type="button" id="showdata">Show Data</button></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Safe Report:</td>
										<td><label id="safeReportId" 
												placeholder="What did You See....."
												value="${data.safeReport}" name="safeReport" rows="7"
												cols="100">${data.safeReport}</label></td>
									<tr>
										<td style="font-size: 18px;">Status :</td>
										<td><label type="text" style="width: 29%;" value="${data.status}" name="status" >${data.status}</label></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Your Star Area:</td>
										<td><label type="text" style="width: 29%;"
											value="${data.yourStartArea}" name="yourStartAreaa id="yourStartAreaa">${data.yourStartArea}</label></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Date Of Incident:</td>
										<td>
											<label type="text" value="${data.dateOfIncident}" name="dateOfIncident" id="dateOfIncident" >${data.dateOfIncident}</label>
											<label type="text" value="${data.timeOfIncident}" name="timeOfIncident" id="timeOfIncident">${data.timeOfIncident}</label>
										</td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Date Of Reported:</td>
										<td><label type="text" value="${data.dateReported}"
											name="dateReported" id="dateReported" style="width: 29%;" >${data.dateReported}</label>

										</td>
									</tr>
									<tr>
										<!-- <td style="font-size: 18px;">Star Incident Location:</td> -->
										<td style="font-size: 18px;">Mill Area Where Incident Occured :</td>
										
										<td><label type="text"
											value="${data.starIncidentLocation}"
											name="starIncidentLocation" style="width: 29%;" >${data.starIncidentLocation}</label></td>
									</tr>
									<tr>
										<!-- <td style="font-size: 18px;">Location Incident Occured:</td> -->
										<td style="font-size: 18px;"> Mill Area System :</td>										
										<td><label id="locationIncidentOccured" value="${data.locationIncidentOccured}"
												name="locationIncidentOccured" rows="2" cols="30">${data.locationIncidentOccured}</label>

										</td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Description Of Event:</td>
										<td><textarea id="descpOfEvent"
												value="${data.descpOfEvent}" name="descpOfEvent" rows="9"
												cols="60"  readonly>${data.descpOfEvent}</textarea></td>
									</tr>
									<tr>
										<td style="font-size: 18px;">Star Category:</td>
										<td>(Mark the star Category that best fit the risk
											involved)</td>

									</tr>
									<tr>
										<td width="14%"></td>
										<td style="width: 86%">

											<table style="width: 100%" id="starCategoryTable" >
												<tr id="tr1"><td hidden>
												<input hidden type="text" value="${data.starCategory}" name="starCategory" /></td>
													<td style="width: 20%"><strong style="display: block">1 BODY POSITION</strong>															
														<ul style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox11" />1.1 Struck By/Struck Against</li>
															<li><input type="checkbox" value="" id="checkbox12" />l.2 Pinch Point</li>
															<li><input type="checkbox" value="" id="checkbox13" />1.3 Eyes on Path</li>
															<li><input type="checkbox" value="" id="checkbox14" />1.4 Eyes On Task</li>
															<li><input type="checkbox" value="" id="checkbox15" />1.5 Ascending /Descending</li>
														</ul>
													</td>
													<td style="width: 80%"><strong style="display: block">2 ERGONOMICS</strong>
														<ul style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox21" /> 2.1 Lifting/Lowering</li>
															<li><input type="checkbox" value="" id="checkbox22" />2.2 Awkward Posture</li>
															<li><input type="checkbox" value="" id="checkbox23" />2.3 Repetition /Long Duration</li>
															<li><input type="checkbox" value="" id="checkbox24" />24 Forceful Exertion/Push/Pull/Grip</li>
														</ul>
													</td>
												<tr>
												<tr>
													<td style="width: 20%"><strong style="display: block">3 SELECTION/CONDITION/USE</strong>
														<ul style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value=""  id="checkbox31" />3.1 Tools& Equipment</li>
															<li><input type="checkbox" value="" id="checkbox32" />3.2 Mobile Equipment</li>
															<li><input type="checkbox" value="" id="checkbox33" />3.3 Cranes</li>

														</ul>
													</td>
													<td style="width: 80%"><strong style="display: block">4 PROCEDURES</strong>
														<ul style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value=""  id="checkbox41" />4.1 Lockout/Tag out/Energy ISO</li>
															<li><input type="checkbox" value="" id="checkbox42" />4.2 Communication of Hazards</li>
															<li><input type="checkbox" value="" id="checkbox43" />4.3 Pre /Post Job Inspection</li>
															<li><input type="checkbox" value="" id="checkbox44" />4.4 Communication of Location </li>
														</ul>
													</td>
												<tr>
												<tr>
													<td style="width: 20%"><strong style="display: block">5 PPE</strong>
														<ul style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox51" />5.1 Standard PPE</li>
															<li><input type="checkbox" value="" id="checkbox52" />5.2 Job Specific PPE</li>
															<li><input type="checkbox" value=""id="checkbox53" />5.3 Fall Protection</li>
														</ul>
													</td>
													<td style="width: 80%"><strong style="display: block">6 Environment</strong>
														<ul
															style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox61" />6.1Walking /Working Surfaces</li>
															<li><input type="checkbox" value="" id="checkbox62" />6.2 Housekeeping Storage</li>
															<li><input type="checkbox" value="" id="checkbox63" />6.3 Lighting</li>
															<li><input type="checkbox" value="" id="checkbox64" />6.4 Air Quality</li>
														</ul>
													</td>
												<tr>
												<tr>
													<td style="width: 20%"><strong style="display: block">7 STATE OF MIND</strong>
														<ul style="list-style: none; margin: 10px 0 0; padding: 0;">
															<li><input type="checkbox" value="" id="checkbox71" />7.1 Hurried</li>
															<li><input type="checkbox" value="" id="checkbox72" />7.2 Frustrated</li>
															<li><input type="checkbox" value=""id="checkbox73" />7.3 Fatigued</li>
															<li><input type="checkbox" value="" id="checkbox74" />7.4 Complacent</label></li>	
														</ul>
													</td>	
												<tr>	
											</table>
										</td>							
									</tr>
									<tr>
										<td style="width: 20%;font-size: 18px;">Further Follow Up Requested </td>
										<td style="width: 5%;height: 5%;">
										<input type="checkbox" name="furtherFollowUpRequested" value="${data.furtherFollowUpRequested}" /></td>										 
									</tr>
									<c:if test="${yesFlage}">
										<tr>
											<td style="width: 20%;font-size: 18px;">Incident Investigation Form </td>
											<td style="width: 5%; height: 5%;"><a target="_blank"
														href='${viewURL}${data.id}'>View Form</a></td>									 
										</tr>	
									</c:if>						
						</table>
						</dev>
</body>
</html>
