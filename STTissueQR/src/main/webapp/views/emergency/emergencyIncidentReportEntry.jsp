<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<spring:url value="/911Emergency/incidentReportEntry/save" var="saveURL" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="icon" type="image/x-icon" href='<spring:url value="/resources/favicon.ico"/>' />

<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery-ui-1.10.4.custom.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.qtip.min.js"/>'></script>

<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>
<title><spring:message code="app.name" /> Incident Report</title>
<style type="text/css">
body {
  background: rgb(204,204,204); 
}
page {
  background: white;
  display: block;
  margin: 0 auto;
  margin-bottom: 0.5cm;
  box-shadow: 0 0 0.5cm rgba(0,0,0,0.5);
}
page[size="A4"] {  
  width: 21cm;
  height: 29.7cm;
padding: 15px; 
}
@media print {
  body, page {
    margin: 0;
    box-shadow: 0;
  }
}
.qc_sec-1, qc_sec-2, qc_sec-3, qc_sec-4, qc_sec-5, qc_sec-6, qc_sec-7{
width:100%;
display:inline-block;
margin: 0 0 15px;
}
.qc_br_1{
border: 1px solid #000;
}
table{
width: 100%;   
}
.qc_h2txt{
font-size:16px;
}
input.no-outline{
 border-top-style: hidden;
        border-right-style: hidden;
        border-left-style: hidden;
        border-bottom-style: groove;
        background-color: #f9f9f9;
    max-width: 100%;
    margin-bottom: 5px;
}
}
.no-outline:focus, .no-outline2:focus {
        outline: none;
      }
input.no-outline2{
 border-top-style: hidden;
        border-right-style: hidden;
        border-left-style: hidden;
        border-bottom-style: groove;
        background-color: #f9f9f9;
    width: 100%;
    margin-bottom: 5px;
}


.qc_pagehead {
    background: #eee;
    border: 1px solid #bbb;
    margin: 10px 0;
    padding: 10px;
    line-height: 1.2;
}
.qc_pagehead p{
margin: 0px;
    padding: 0;
}

</style>
<script type="text/javascript">
	$(document).ready(function() {

		$('input[name=date1],input[name=date2]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true

		});
		$("input[type='checkbox']").on("change", function() {
			if ($(this).is(":checked"))
				$(this).val("true");
			else
				$(this).val("false");
		});
		
		$("input[type='checkbox']").each(function() {

			if ($(this).val() =='true') {
				this.checked = true;
			} else {
				this.checked = false;
			}

		});
		
	});
</script>
</head>
<body>
<form name="data" action="${saveURL}" method="post">
<page size="A4">
  <div class="qc_sec-1">
<table class="qc_br_1" cellspacing="0" cellpadding="0">
    <tbody>
      <tr>      
      <input type="hidden" name="id" value="${data.id}">
        <td rowspan="2" align="center" width="30%"><p class="qc_h2txt">Barnwell Tissue Solutions<b></b></p></td>
        <td rowspan="2" align="center" width="30%"><p class="qc_h2txt"><b>Incident Investigation Form</b></p></td>
        <td width="40%">
<table >
		<tr align="end">
 			<td >Number :</td>
			<td ><input type="text" class="no-outline" value="${data.number}" name="number" /></td>
		</tr>
<tr align="end">
 			<td>Owner :</td>
			<td><input type="text" class="no-outline" value="${data.owner}"  name="owner" /></td>
		</tr>
<tr align="end">
 			<td>Revision :</td>
			<td><input type="text" class="no-outline" value="${data.revision}"  name="revision" /></td>
		</tr>
<tr align="end">
 			<td>Date :</td>
			<td><input type="text" class="no-outline" value="${data.date1}" name="date1" /></td>
		</tr>
</table>
       </td>
      </tr>
      </tbody>
  </table>
</div>
<div class="qc_sec-2">
<table cellspacing="0" cellpadding="5">
		<tr>
 			<td >Investigator :</td>
			<td valign="top" width="20%"><input type="text" value="${data.investigator}"  class="no-outline2" name="investigator" /></td>
		
 			<td>Incident Type :</td>
			<td valign="top" width="15%"><input type="text"  value="${data.incidentType}" class="no-outline2" name="incidentType" /></td>
		
 			<td>Area :</td>
			<td valign="top" width="10%"><input type="text" value="${data.area}"  class="no-outline2" name="area" /></td>
		
 			<td>Date :</td>
			<td valign="top" width="10%"><input type="text" value="${data.date2}" class="no-outline2" name="date2" /></td>
		</tr>
</table>
</div>
<div class="qc_sec-3">
<div class="qc_pagehead">
<p><b>Preliminary Actions : </b> Take these steps before beginning the investigation</p>
</div>
<table cellspacing="7" cellpadding="0">
<tbody>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.preCheck1}" name="preCheck1" /></td>
<td>The first priority is getting care to any injured TMs, check their status and direct them to medical attention as necessary (First Aid, Emergency Room, 911)</td>
<tr>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.preCheck2}" name="preCheck2" /></td>
<td>If applicable, ask a TM to secure the scene to keep it undisturbed before you arrive</td>
<tr>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.preCheck3}" name="preCheck3" /></td>
<td>Ask a TM to start gathering anyone who may have information relating to the event</td>
<tr>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.preCheck4}" name="preCheck4" /></td>
<td>Assess if TMs in the area can safely continue to work after the incident (emotions, reduced staffing, equipment damage, etc.)</td>
<tr>
</tbody>
</table>
</div>
<div class="qc_sec-4">
<div class="qc_pagehead">
<p><b>Initial Facts : </b> Gather these facts to begin the investigation</p>
</div>
<table cellspacing="7" cellpadding="0">
<tbody>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.initCheck1}"   name="initCheck1" /></td>
<td>Date/time of incident: <input type="text" class="no-outline"  value="${data.initValue1}" name="initValue1" /></td>
</tr>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.initCheck2}"  name="initCheck2" /></td>
<td>Specific Location: <input type="text" class="no-outline"  value="${data.initValue2}" name="initValue2" /></td>
<tr>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"     value="${data.initCheck3}"  name="initCheck3" /></td>
<td>TMs involved: <input type="text" class="no-outline" value="${data.initValue3}" name="initValue3" style="width: 50%;" />  </td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.initCheck4}" name="initCheck4" /></td>
<td>Injury/Near Miss/Damage description: <br> <textarea   name="initValue4" cols="40" rows="5" style="width:100%;margin: 15px 0;">${data.initValue4}</textarea></td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.initCheck5}"  name="initCheck5" /></td>
<td>Take photos of the scene/equipment/tools and anything else pertinent to the investigation  </td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.initCheck6}"  name="initCheck6" /></td>
<td>If applicable, sketch a layout of the scene  </td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.initCheck7}" name="initCheck7" /></td>
<td>Collect any physical evidence (broken tools, training records, inspection sheets, damaged PPE, etc.) </td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"   value="${data.initCheck8}"  name="initCheck8" /></td>
<td>Interview the TMs involved in the incident and anyone else who may have knowledge of the events leading up to, during or after the incident occurred. Ask what they think caused the incident.  Record the interviews on notebook paper and include name of each interviewee.  </td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.initCheck9}"  name="initCheck9" /></td>
<td>Get help from a subject matter expert in the area/task involved in the incident (Area Lead, Lead Operator, etc.)  </td>
</tr>
</tbody>
</table>
</div>

<div class="qc_sec-5">
<div class="qc_pagehead">
<p><b>Description of Incident : </b> Include relevant events leading up to, during and after the incident occurred</p>
</div>
<textarea  name="descOfIncident"  cols="40" rows="12" style="width:100%;margin: 5px 0;">${data.descOfIncident}</textarea>
</div>
</page>
<page size="A4">
  <div class="qc_sec-6">
<div class="qc_pagehead">
<p><b>Cause(s) of the Incident : </b> Consider all possible contributing factors and states of mind listed below as potential causes of the incident, then narrow them down to discover the proximate cause.</p>
</div>
<textarea  name="causeOfIncident"   cols="40" rows="12" style="width:100%;margin: 5px 0;">${data.causeOfIncident}</textarea>
</div>
</div>
<div class="qc_sec-7">
<p><b>Possible Contributing Factors:</b></p>
<table cellspacing="5" cellpadding="0">
<tbody>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.lackOfCheckBox}"   name="lackOfCheckBox" /></td>
<td>Lack of procedure/policy</td>
<td width="5%" valign="top" align="center"><input type="checkbox"  value="${data.proceNotFollCheckbox}"   name="proceNotFollCheckbox" /></td>
<td>Procedure not followed</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.jsaCheckBox}"   name="jsaCheckBox" /></td>
<td>JSA</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.lackOfTraningCheckbox}"   name="lackOfTraningCheckbox" /></td>
<td>Lack of training</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.preUseInspecCheckbox}"   name="preUseInspecCheckbox" /></td>
<td>Pre-use inspection</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.equipmtCheckbox}" name="equipmtCheckbox" /></td>
<td>Equipment/tools serviceable</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.correctToolCheckbox}" name="correctToolCheckbox" /></td>
<td>Correct tools used</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.enviromentCondtnCheckbox}" name="enviromentCondtnCheckbox" /></td>
<td>Environmental conditions</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.walkingSurfaceCheckbox}" name="walkingSurfaceCheckbox" /></td>
<td>Walking/working surface</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.walkingSurfaceCheckbox}" name="lightVisibilityCheckbox" /></td>
<td>Lighting/visibility</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.walkingSurfaceCheckbox}"  name="poorHousekeepingCheckbox" /></td>
<td>Poor housekeeping</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.walkingSurfaceCheckbox}"  name="ergonCheckbox" /></td>
<td>Ergonomics</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.tightCheckbox}" name="tightCheckbox" /></td>
<td>Tight</td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.lineOfFireCheckbox}" name="lineOfFireCheckbox" /></td>
<td>Line of fire </td>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.eyesOnTaskCheckbox}" name="eyesOnTaskCheckbox" /></td>
<td>eyes on task</td>
</tr>
</tbody>
</table>

</div>
<div class="qc_sec-7">
<p><b>State of Mind:</b></p>
<table cellspacing="2" cellpadding="0">
<tbody>
<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.hurriedCheckbox}" name="hurriedCheckbox" /></td>
<td>Hurried</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.frustratedCheckbox}" name="frustratedCheckbox" /></td>
<td>Frustrated</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.fatiguedCheckbox}" name="fatiguedCheckbox" /></td>
<td>Fatigued</td>
</tr>

<tr>
<td width="5%" valign="top" align="center"><input type="checkbox" value="${data.complacentCheckbox}" name="complacentCheckbox" /></td>
<td>Complacent</td>
</tr>
</tbody>
</table>

</div>
<br>
<c:choose>
					<c:when test="${edit == 'yes'}">
						<div class="wrapper">
							<br /> <br />
							<input type="submit" value="Update">
						</div>
					</c:when>

					<c:otherwise>
						<div class="wrapper">
							<br /> <br />
							<input type="submit" value="Submit">
						</div>
					</c:otherwise>
				</c:choose>

</page>

</form>
</body>
</html>
