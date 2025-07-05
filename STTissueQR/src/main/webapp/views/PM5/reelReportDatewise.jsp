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
<title><spring:message code="app.name" /> Reel Report View PM5</title>

<link type="text/css" rel="stylesheet" media="all" href="<spring:url value="/dist/css/old/printReport.css"/>" >
<style>
    .table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        font-size: 12px;
    }
    
    .table th {
        background-color: #f2f2f2;
        color: #333;
        font-weight: bold;
        padding: 8px;
        text-align: center;
        border: 1px solid #ddd;
    }
    
    .table td {
        padding: 6px;
        border: 1px solid #ddd;
        text-align: center;
    }
    
    .header-report {
        font-size: 18px;
        font-weight: bold;
        color: #333;
        margin-bottom: 20px;
        display: block;
        text-align: center;
    }
    
    .trobjrow {
        background-color: #e6f3ff;
        font-weight: bold;
    }
    
    /* Color coding for different measurement categories */
    .table th:nth-child(1), .table td:nth-child(1) { /* Date */
        background-color: #f9f9f9;
    }
    
    .table th:nth-child(2), .table td:nth-child(2) { /* Time */
        background-color: #f9f9f9;
    }
    
    .table th:nth-child(3), .table td:nth-child(3) { /* Grade Code */
        background-color: #f9f9f9;
    }
    
    .table th:nth-child(4), .table td:nth-child(4) { /* Reel # */
        background-color: #f9f9f9;
    }
    
    /* Weight measurements */
    .table th:nth-child(5), .table td:nth-child(5),
    .table th:nth-child(6), .table td:nth-child(6) {
        background-color: #fff3e6;
    }
    
    /* Tensile measurements */
    .table th:nth-child(7), .table td:nth-child(7),
    .table th:nth-child(8), .table td:nth-child(8),
    .table th:nth-child(9), .table td:nth-child(9),
    .table th:nth-child(10), .table td:nth-child(10),
    .table th:nth-child(11), .table td:nth-child(11),
    .table th:nth-child(12), .table td:nth-child(12),
    .table th:nth-child(13), .table td:nth-child(13),
    .table th:nth-child(14), .table td:nth-child(14),
    .table th:nth-child(15), .table td:nth-child(15) {
        background-color: #e6ffe6;
    }
    
    /* Quality measurements */
    .table th:nth-child(16), .table td:nth-child(16),
    .table th:nth-child(17), .table td:nth-child(17),
    .table th:nth-child(18), .table td:nth-child(18),
    .table th:nth-child(19), .table td:nth-child(19),
    .table th:nth-child(20), .table td:nth-child(20),
    .table th:nth-child(21), .table td:nth-child(21),
    .table th:nth-child(22), .table td:nth-child(22),
    .table th:nth-child(23), .table td:nth-child(23),
    .table th:nth-child(24), .table td:nth-child(24),
    .table th:nth-child(25), .table td:nth-child(25),
    .table th:nth-child(26), .table td:nth-child(26),
    .table th:nth-child(27), .table td:nth-child(27),
    .table th:nth-child(28), .table td:nth-child(28),
    .table th:nth-child(29), .table td:nth-child(29),
    .table th:nth-child(30), .table td:nth-child(30),
    .table th:nth-child(31), .table td:nth-child(31),
    .table th:nth-child(32), .table td:nth-child(32),
    .table th:nth-child(33), .table td:nth-child(33),
    .table th:nth-child(34), .table td:nth-child(34),
    .table th:nth-child(35), .table td:nth-child(35),
    .table th:nth-child(36), .table td:nth-child(36),
    .table th:nth-child(37), .table td:nth-child(37),
    .table th:nth-child(38), .table td:nth-child(38),
    .table th:nth-child(39), .table td:nth-child(39),
    .table th:nth-child(40), .table td:nth-child(40) {
        background-color: #ffe6e6;
    }
    
    /* Customer and Remarks */
    .table th:nth-child(41), .table td:nth-child(41),
    .table th:nth-child(42), .table td:nth-child(42),
    .table th:nth-child(43), .table td:nth-child(43),
    .table th:nth-child(44), .table td:nth-child(44) {
        background-color: #f0f0f0;
    }
</style>

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
						<th>Bulk <br> mils/8 ply
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
						<th>Finch Cup<br> g/inch
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
						
						<th>2 Sigma Moisture CDs</th>
						<!-- <th>FWA Dosage<br> lb/Ton --><!-- Firstly it was FWA Dosage After Then Changed It To  Moisture %-->
						<th>Moisture %</th>
						<th>TPH</th>
						<th>Trim</th>
						<th>Crepe Ratio</th>
						<th style="width:80px;">Front Roll<br> Diameter</th>
						<th style="width:80px;">Back Roll<br> Diameter</th>
						<th>L Value</th>
						<th>A Value</th>
						<th>B Value</th>
						<th>Delta E</th>
<!-- 						Code Ends Here Done By Roshan Tailor -->
						<th>Customer</th>
						<th>Customer1</th>
						<th>Customer2</th>
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
							<td  class="trobjrow" style="text-align: right;"><fmt:formatNumber value="${map['34'] - 0.0000}" maxFractionDigits="0"/></td>
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
							<td  class="trobjrow" style="text-align: right;">${map['35']}</td>
							<td  class="trobjrow" style="text-align: right;">${map['36']}</td>
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
							<td class="${map['34C']}" style="text-align: right;"><fmt:formatNumber value="${map['34']}" minFractionDigits="2" maxFractionDigits="2"/></td>
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
							<td style="text-align: right;"><fmt:formatNumber value="${map['35']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"><fmt:formatNumber value="${map['36']}" minFractionDigits="2" maxFractionDigits="2"/></td>

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
						</tr>
						</c:otherwise>
					</c:choose>
					
				
			</c:forEach>	
			</tbody>

		</table>
</div>


</body>
</html>
