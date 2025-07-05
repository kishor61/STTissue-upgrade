<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<!-- 
<http-equiv="X-UA-Compatible" content="IE=edge"/>
 -->
<title><spring:message code="app.name" /> Reel Report View</title>

<link type="text/css" rel="stylesheet" media="all" href="<spring:url value="/dist/css/old/style.css"/>" >

<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.PrintArea.js"/>'></script>



<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea({
				retainAttr:['class','style']
			});
		});
	});
</script>

</head>
<body>
<div>
	
	&nbsp;&nbsp; <button id="printBtn">Print</button>
	&nbsp;&nbsp; <button onclick="window.close();">Close</button>
</div>
<hr>
<div id="printDiv" style="display: block;">
<span class="header-report">Quality Report-Reel Testing</span>
		<table class="table">
			<thead style="font-size: 12px;">
					<tr>
						<th>Date</th>
						<th>Time</th>
						<th>Grade Code</th>
						<th>Reel #</th>
						<th>Scanner Basis wt <br> lbs
							/3000ft
						</th>
						<th>Actual Basis wt <br> lbs
							/3000ft
						</th>
						<th>Bulk  At Reel<br> mils/8 ply
						</th>
						<th>MD Tensile <br> g/inch
						</th>
						<th>CD Tensile <br> g/inch
						</th>
						<th>MD % <br> Stretch
						</th>
						<th>MD/CD Tensile Ratio</th>
						<th>MD Wet Tensile<br> g/inch
						</th>
						<th>CD Wet Tensile<br> g/inch
						</th>
						<th>CD Tensile Ratio<br> Wet/Dry
						</th>
						<th>Bright<br> ness %
						</th>
						<th>FWA Flow<br> (ml/min)</th>
						
						<th>AKD<br>(gpm)</th>
						<th>Wet Strength<br>(gpm)</th>
						<th>2 Sigma BW CD</th>
						
						<th>2 Sigma Moisture CD</th>
						<!-- <th>FWA Dosage<br> lb/Ton --><!-- Firstly it was FWA Dosage After Then Changed It To  Moisture %-->
						<th>Moisture %</th>
						<th>TPH</th>
						<th>Trim</th>
						<th>Crepe Ratio</th>
<!-- 						Code Starts From Here Done By Roshan Tailor -->
						<th>L Value</th>
						<th>A Value</th>
						<th>B Value</th>
						<th>Delta E</th>
<!-- 						Code Ends Here Done By Roshan Tailor -->
						<th>Customer1</th>
					   <th>Customer2</th>
					     <th>Customer3</th>
						<th>Remarks</th>
					</tr>

			</thead>
			<tbody>
			<c:forEach items="${datas}" var="map">
				
					<c:choose>
						<c:when test="${map['1'] eq 'OBJECTIVES'}">
						<tr>
							<td class="trobjrow">${map['1']}</td>
							<td  class="trobjrow">${map['2']}</td>
							<td  class="trobjrow">${map['3']}</td>
							<td  class="trobjrow">${map['4']}</td>
							<td  class="trobjrow"style="text-align: right;">${map['5']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['6']}</td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['7'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['8'] - 0.0000}" maxFractionDigits="0"/></td>
							<td class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['9'] - 0.0000}" maxFractionDigits="0"/></td>
							<td class="trobjrow" style="text-align: right;">${map['10']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['11']}</td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['12'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['13'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow" style="text-align: right;">${map['14']}</td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['15'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow" style="text-align: right;">${map['16']}</td>
							<td  class="trobjrow">N/A</td>
							<td  class="trobjrow">N/A</td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['31'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['17'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow" style="text-align: right;">${map['18']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['19']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['20']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['21']}</td>
<!-- 							Code Starts From Here Done BY Roshan Tailor Date :-03/07/02015 MM/DD/2015 -->
							<td  class="trobjrow" style="text-align: right;">${map['22']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['23']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['24']}</td>
							
							<td  class="trobjrow" style="text-align: right;">${map['28']}</td>
<!-- 							Code Ends Here Done By Roshan Tailor	 -->
							<td  class="trobjrow">${map['25']}</td>
							 <td  class="trobjrow">${map['32']}</td>
							<td  class="trobjrow">${map['33']}</td> 
							<td  class="trobjrow" style="text-align: right;">${map['26']}</td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td>${map['1']}</td>
							<td>${map['2']}</td>
							<td><div style="width: 80px;">${map['3']}</div> </td>
							<td><fmt:formatNumber value="${map['4']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['5']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['6C']}" style="text-align: right;"><fmt:formatNumber value="${map['6']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['7C']}" style="text-align: right;"><fmt:formatNumber value="${map['7']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['8C']}" style="text-align: right;"><fmt:formatNumber value="${map['8']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['9C']}" style="text-align: right;"><fmt:formatNumber value="${map['9']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['10C']}" style="text-align: right;"><fmt:formatNumber value="${map['10']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['11C']}" style="text-align: right;"><fmt:formatNumber value="${map['11']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['12C']}" style="text-align: right;"><fmt:formatNumber value="${map['12']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['13C']}" style="text-align: right;"><fmt:formatNumber value="${map['13']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['14C']}" style="text-align: right;"><fmt:formatNumber value="${map['14']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['15C']}" style="text-align: right;"><fmt:formatNumber value="${map['15']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['16']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							
							<td style="text-align: right;"><fmt:formatNumber value="${map['29']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['30']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td class="${map['31C']}" style="text-align: right;"><fmt:formatNumber value="${map['31']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							
							<td class="${map['17C']}" style="text-align: right;"><fmt:formatNumber value="${map['17']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['18']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['19']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['20']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['21']}" minFractionDigits="2" maxFractionDigits="2"/></td>
<!-- 							Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015 MM/DD/YYYY  -->
							<td style="text-align: right;"><fmt:formatNumber value="${map['22']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['23']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['24']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['28']}" minFractionDigits="2" maxFractionDigits="2"/></td>
<!-- 							Code Ends Here Done By Roshan Tailor  -->
                               <td>${map['25']}</td>
                               <td>${map['32']}</td>
							<td>${map['33']}</td>
                               <td style="text-align: right;">${map['26']}</td>
							<%-- <td>${map['25']}</td>
							<td>${map['32']}</td>
							<td>${map['33']}</td>
							
							<td style="text-align: right;">${map['26']}</td> --%>
						</tr>
						</c:otherwise>
					</c:choose>
					
				
			</c:forEach>	
			</tbody>

		</table>
</div>


</body>
</html>
