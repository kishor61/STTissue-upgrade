<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<!-- Below Script Is Written By Roshan Tailor -->
<script type="text/javascript">
function ButtonClicked()
{
   document.getElementById("formsubmitbutton").style.display = "none"; // to undisplay
   document.getElementById("buttonreplacement").style.display = ""; // to display
   return true;
}
var FirstLoading = true;
function RestoreSubmitButton()
{
   if( FirstLoading )
   {
      FirstLoading = false;
      return;
   }
   document.getElementById("formsubmitbutton").style.display = ""; // to display
   document.getElementById("buttonreplacement").style.display = "none"; // to undisplay
}
// To disable restoring submit button, disable or delete next line.
document.onfocus = RestoreSubmitButton;
</script>
<script type="text/javascript">
function ButtonClicked1()
{
   document.getElementById("viewDataBtn").style.display = ""; // to undisplay
   document.getElementById("buttonreplacement1").style.display = ""; // to display
   return true;
}
var FirstLoading = true;
function RestoreSubmitButton()
{
   if( FirstLoading )
   {
      FirstLoading = false;
      return;
   }
   document.getElementById("viewDataBtn").style.display = ""; // to display
   document.getElementById("buttonreplacement1").style.display = "none"; // to undisplay
}
// To disable restoring submit button, disable or delete next line.
document.onfocus = RestoreSubmitButton;
</script>
<!-- Script Ends Here Done By Roshan Tailor And Copy Write Too -->
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Transfer Price Per Ton Data</span>
				</div>
				<div class="table-selector">
					
				<spring:url value="/transferpricepertondata/view/data" var="viewURL"/>
				<form name="dataForm" action="${viewURL}" method="get">	
					<table style="margin: auto;">
						<tr>
							<td>Start Date:</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}">							
							</td>
							<td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}">							
							</td>
							<td>
								<input id="viewDataBtn" type="submit" value="View" onclick="ButtonClicked1();">
								&nbsp;
								&nbsp;	
							</td>
							<c:if test="${view}">
								<td>
									<div id="formsubmitbutton">
										<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();ButtonClicked();"  value="Transfer Price/Ton">
									<div>
								</td>
							</c:if>
						</tr>
					</table>
					
				</form>
					
				</div>
<div id="buttonreplacement1" style="margin-left:30px; display:none;">
		<img style="height: 105px; border: none;width: 137px;margin: 144px 0px 0px 249px;" alt="Loading Data..." src='<spring:url value="/resources/images/g0v.gif"/>'> 
</div>
<div id="buttonreplacement" style="margin-left:30px; display:none;">
		<img style="height: 105px; border: none;width: 137px;margin: 144px 0px 0px 249px;" alt="Transfering Data..." src='<spring:url value="/resources/images/gears.gif"/>'> 
</div>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<c:if test="${view}">
<form id="exportFrom" action='<spring:url value="/transferpricepertondata/transfer/rlt"/>' method="get" style="display:none; ">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
</form>
<center>
<table id="yielddatatable" class="table" style="width: auto;">
	<thead style="text-align: center;">
		<tr>
			<td>&nbsp;</td>
			<td>MasterPO</td>
			<td>Release No</td>
			<td>Price Per Ton</td>
			<td>Grade Code</td>
			<td>Grade Id</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${details}" var="wd">
			<tr>
				<td><input type="checkbox" name="rowCheckbox" value="${wd.id}"></td>
				<td>${wd.masterPO}</td>
				<td>${wd.releaseNo}</td>
				<td>${wd.pricePerTon}
					<%-- <input style="width: 70px; background-color: #E8E8AF;" type="text" value="${wd.pricePerTon}" name="pricePerTon"/> --%>
				</td>
				<td>
					${wd.itemDescription}
					<input type="hidden" value="${wd.itemDescription}" name="itemDescription">
					<input type="hidden" value="${wd.gradeid}" name="gradeid">
				</td>
				<td>${wd.gradeid}</td>
			</tr>
			
		</c:forEach>
	</tbody>
</table>
</center>
</c:if>
</div>
			</div>

		</div>


	</div>

</body>
</html>
