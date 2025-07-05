<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<spring:url value="/pm5centerline/deletecldata" var="deletecldataURL"/>

<script type="text/javascript">
var deletecldataURL='${deletecldataURL}';

</script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/centerline.js"/>'></script>
<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		
		$('select[name=grade]').off('change');
	});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>

		<spring:url value="/pm5centerlinereport/load2" var="viewURL" />
		
		<div class="block3" style="overflow: auto;">
			<div class="pageContent">
				<div class="page-title">
					<span class="label">View Centerline Data For PM5</span>
				</div>
				<br>
				
				
				
				<div class="table-selector">
				<form id="searchForm" action="${viewURL}" method="post">
					<table>
						<tr>
							<td>From</td>
							<td><input type="text" name="sdate" value="${sdate}" style="width: 100px;" readonly="readonly"></td>
							<td>&nbsp;&nbsp; To</td>
							<td><input type="text" name="edate" value="${edate}" style="width: 100px;" readonly="readonly"></td>
							<td>&nbsp;&nbsp;Grade</td>
							<td>
							
								<select name="grade" style="width: 150px;">
									<option value="0">ALL</option>
									<c:forEach items="${clgrades}" var="clgrade">
										<c:choose>
											<c:when test="${clgrade['ID'] == grade}">
												<option value="${clgrade['ID']}" selected="selected">${clgrade['Grade']}</option>
											</c:when>
											<c:otherwise>
												<option value="${clgrade['ID']}">${clgrade['Grade']}</option>
											</c:otherwise>
										</c:choose>
										
										
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" value="Search">
								<c:if test="${fn:length(datas) gt 0}">
	  								&nbsp;
									<input type="button" id="exportBtn" value="Export">
									&nbsp;
									<!-- <input type="button" id="editBtn" value="Edit">
									&nbsp;
									&nbsp;
									<input type="button" id="deletetBtn" value="Delete"> -->
									
								</c:if>
								
							</td>
						</tr>
					</table>

				</form>
				<spring:url value="/pm5centerline/edit" var="editURL"/>
				<c:if test="${fn:length(datas) gt 0}">
					<script type="text/javascript">
						$(function(){
							$('#exportBtn').click(function(){
								$('#exportFrom').submit();
							});
							
							$('#editBtn').click(function(){
								var val=$('input[name=id]:checked').val();
								
								if(val){
									location.href='${editURL}/'+val;
								}
								
							});
							
							$('#deletetBtn').click(function(){
								var val=$('input[name=id]:checked').val();
								if(val){
									if(confirm("Are you sure you want to delete?")){
										deleteclfromView(val);
									}	
								}
								
							});
						});
					</script>
				
					<spring:url value="/pm5centerlinereport/export" var="exportURL"/>
					<form id="exportFrom" action="${exportURL}" method="post">
							<input type="hidden" name="sdate" value="${sdate}">
							<input type="hidden" name="edate" value="${edate}">
							<input type="hidden" name="grade" value="${grade}">
					</form>
				</c:if>
				
			
				</div>
					<br>
				
<div style="padding: 10px;"></div>
<c:if test="${fn:length(datas) gt 0}">
<table class="table" style="font-size: 12px;text-align: center;">
	<thead>
	<tr>
		<th></th>
		<th>Date</th>
		<th>Grade</th>
		<th>Shift</th>
		<th>Crew</th>
		<th>Yankee<br>speed</th>
		<th>QCS<br>Basis<br>wt<br>target</th>
		<th>Reel<br>Moisture</th>
		<th>Crepe</th>
		<th>Yankee<br>Steam<br><br></th>
		<th>Yankee<br>Release</th>
		<th>Yankee<br>Adesive</th>
		<th>Jet<br>Wire<br>Ratio</th>
		<th>Fan<br>Pump<br>flow<br>rate</th>
		<th>After<br>Dryer<br>Draw</th>
		<th>After<br>Dryer<br>Steam</th>
		<th>SPR<br>loading</th>
		<th>Felt<br>Passivator</th>
		<th>Sprayboom<br>Pressure</th>
		<th>Sprayboom<br>Temparature</th>
		<th>WE<br>Fan<br>Speed</th>
		<th>DE<br>Fan<br>Speed</th>
		<th>Make-up<br>air<br>damper</th>
		<th>Exhaust<br>damper</th>
		<th>Exhaust<br>Fan<br>speed</th>
		<th>WE<br>Hood<br>Temperature</th>
		<th>DE<br>Hood<br>Temperature</th>
		<th>Yankee<br><br>&Delta; P</th>
		<th>After<br>Dryer<br>Δ P</th>
		<th>Sec<br>Arm<br>Loading</th>
		<th>Reel<br>offset</th>
		<th>Uhle<br>box<br>North<br>Valve</th>
		<th>Uhle<br>box<br>South<br>Valve</th>
		<th>Falt<br>box 1<br>Vacuum<br>valve</th>
		<th>Falt<br>box 2<br>Vacuum<br>valve</th>
		<th>Falt<br>box 4<br>Vacuum<br>valve</th>
		<th>Fan<br>Pump<br>speed</th>
		<th>Total<br>head</th>
		<th>Headbox<br>level</th>
		<th>Horizontal<br>slice<br>local</th>
		<th>Horizontal<br>slice<br>dcs</th>
		<th>Vertical<br>Slice<br>local</th>
		<th>Vertical<br>Slice<br>dcs</th>
		<th>Selectifier<br>reject<br>flow 1</th>
		<th>Selectifier<br>reject<br>flow 2</th>
		<th>Sec<br>screen<br>Cycle<br>time</th>
		<th>Low<br>Density<br>Cycle<br>Time</th>
		<th>Refiners<br>Energy</th>
		<th>Number<br>of<br>Refiners</th>
		<th>Refiner<br>Inlet<br>Consistency</th>
		<th>Machine<br>Chest<br>Consistency</th>
		<th>Stock<br>flow</th>
		<th>Sweetner<br>Flow</th>
		<th>Broke<br></th>
		<th>Wet<br>strength</th>
		<!-- <th>Revision<br> History 1 </th>
		<th>Revision<br> History 2 </th> -->
		
	</tr>
	</thead>
	<tbody>
	
	<c:forEach items="${datas}" var="map">
		<c:choose>
			<c:when test="${map['1'] eq 'OB' }">
				<tr class="trobjrow">
					<td></td>
					<td>OBJECTIVE</td>
					<td>${map['49']}</td>
					<td>${map['50']}</td>
					<td>${map['51']}</td>
					
					<td>${map['2']}</td>
					<td>${map['3']}</td>
					<td>${map['4']}</td>
					<td>${map['5']}</td>
					<td>${map['6']}</td>
					<td>${map['7']}</td>
					<td>${map['8']}</td>
					<td>${map['9']}</td>
					<td>${map['10']}</td>
					
					<td>${map['55']}</td>
					
					<td>${map['11']}</td>
					<td>${map['12']}</td>
					<td>${map['13']}</td>
					<td>${map['14']}</td>
					<td>${map['15']}</td>
					<td>${map['16']}</td>
					<td>${map['17']}</td>
					<td>${map['18']}</td>
					<td>${map['19']}</td>
					<td>${map['20']}</td>
					<td>${map['21']}</td>
					<td>${map['22']}</td>
					<td>${map['23']}</td>
					<td>${map['24']}</td>
					<td>${map['25']}</td>
					<td>${map['26']}</td>
					<td>${map['27']}</td>
					<td>${map['28']}</td>
					<td>${map['29']}</td>
					<td>${map['30']}</td>
					<td>${map['31']}</td>
					<td>${map['32']}</td>
					<td>${map['33']}</td>
					<td>${map['34']}</td>
					<td>${map['35']}</td>
					
					<td>${map['56']}</td>
					
					<td>${map['36']}</td>
					
					<td>${map['57']}</td>
					
					
					<td>${map['37']}</td>
					<td>${map['38']}</td>
					<td>${map['39']}</td>
					<td>${map['40']}</td>
					<td>${map['41']}</td>
					<td>${map['42']}</td>
					<td>${map['43']}</td>
					<td>${map['44']}</td>
					<td>${map['45']}</td>
					<td>${map['46']}</td>
					<td>${map['47']}</td>
					<td>${map['48']}</td>
					<%-- <td>${map['53']}</td>
					<td>${map['54']}</td> --%>
					
				</tr>
			</c:when>
			<c:otherwise>
			<tr>
			
				<td><input type="radio" name="id" value="${map['52']}"> </td>
				<td>${map['1']}</td>
				<td>${map['49']}</td>
				<td>${map['50']}</td>
				<td>${map['51']}</td>
				
				<td class="${map['2C']}">${map['2']}</td>
				<td class="${map['3C']}">${map['3']}</td>
				<td class="${map['4C']}">${map['4']}</td>
				<td class="${map['5C']}">${map['5']}</td>
				<td class="${map['6C']}">${map['6']}</td>
				<td class="${map['7C']}">${map['7']}</td>
				<td class="${map['8C']}">${map['8']}</td>
				<td class="${map['9C']}">${map['9']}</td>
				<td class="${map['10C']}">${map['10']}</td>
				
				<td class="${map['55C']}">${map['55']}</td>
				
				<td class="${map['11C']}">${map['11']}</td>
				<td class="${map['12C']}">${map['12']}</td>
				<td class="${map['13C']}">${map['13']}</td>
				<td class="${map['14C']}">${map['14']}</td>
				<td class="${map['15C']}">${map['15']}</td>
				<td class="${map['16C']}">${map['16']}</td>
				<td class="${map['17C']}">${map['17']}</td>
				<td class="${map['18C']}">${map['18']}</td>
				<td class="${map['19C']}">${map['19']}</td>
				<td class="${map['20C']}">${map['20']}</td>
				<td class="${map['21C']}">${map['21']}</td>
				<td class="${map['22C']}">${map['22']}</td>
				<td class="${map['23C']}">${map['23']}</td>
				<td class="${map['24C']}">${map['24']}</td>
				<td class="${map['25C']}">${map['25']}</td>
				<td class="${map['26C']}">${map['26']}</td>
				<td class="${map['27C']}">${map['27']}</td>
				<td class="${map['28C']}">${map['28']}</td>
				<td class="${map['29C']}">${map['29']}</td>
				<td class="${map['30C']}">${map['30']}</td>
				<td class="${map['31C']}">${map['31']}</td>
				<td class="${map['32C']}">${map['32']}</td>
				<td class="${map['33C']}">${map['33']}</td>
				<td class="${map['34C']}">${map['34']}</td>
				
				
				<td class="${map['35C']}">${map['35']}</td>
				
				<td class="${map['56C']}">${map['56']}</td>
				
				
				<td class="${map['36C']}">${map['36']}</td>
				
				<td class="${map['57C']}">${map['57']}</td>
				
				<td class="${map['37C']}">${map['37']}</td>
				<td class="${map['38C']}">${map['38']}</td>
				<td class="${map['39C']}">${map['39']}</td>
				<td class="${map['40C']}">${map['40']}</td>
				<td class="${map['41C']}">${map['41']}</td>
				<td class="${map['42C']}">${map['42']}</td>
				<td class="${map['43C']}">${map['43']}</td>
				<td class="${map['44C']}">${map['44']}</td>
				<td class="${map['45C']}">${map['45']}</td>
				<td class="${map['46C']}">${map['46']}</td>
				<td class="${map['47C']}">${map['47']}</td>
				<td class="${map['48C']}">${map['48']}</td>
				<%-- <td>${map['53']}</td>
				<td>${map['54']}</td> --%>

			</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
		
	</tbody>
	
</table>
</c:if>
</div>
		</div>

</div>
	
</body>
</html>
