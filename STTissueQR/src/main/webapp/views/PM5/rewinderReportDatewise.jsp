<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Rewinder Report View PM5</title>
<meta charset="utf-8" />
<!-- 
<http-equiv="X-UA-Compatible" content="IE=edge"/>
 -->
<link type="text/css" rel="stylesheet" media="all" href="<spring:url value="/dist/css/old/printReport.css"/>" >

<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/jquery.PrintArea.js"/>'></script>



<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
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
<div id="printDiv">
<span class="header-report">Quality Report-Rewinder Testing</span>
		<table class="table">
			<thead style="font-size: 12px;">


				
					<tr>
						<th style="width: 200px;">Date</th>
						<th style="width: 80px;">Time</th>
						<th style="width: 200px;">Grade Code</th>
						<th style="width: 80px;">Reel #</th>
						<th style="width: 80px;">Set #</th>
						<th style="width: 80px;">Actual Basis wt <br> lbs
							/3000ft
						</th>
						<th style="width: 80px;">Bulk <br> mils/8 ply
						</th>
						<th style="width: 80px;">MD Tensile <br> g/inch
						</th>
						<th style="width: 80px;">CD Tensile <br> g/inch
						</th>
						<th style="width: 80px;">MD % <br> Stretch
						</th>
						<th style="width: 80px;">MD/CD Tensile Ratio</th>
						<th style="width: 80px;">MD Wet Tensile<br> g/inch
						</th>
						<th style="width: 80px;">CD Wet Tensile<br> g/inch
						</th>
						<th style="width: 80px;">CD Tensile Ratio<br> Wet/Dry
						</th>
						<th style="width: 80px;">Bright<br> ness %
						</th>
						<th style="width: 80px;">Dirt Count<br> ppm
						</th>
						<th style="width: 80px;">Absor-<br> bency Sec</th>
<!-- 						Code Starts From Here Done By Roshan Tailor Date ;- 03/074/2015 -->
						<th style="width: 100px;">L Value</th>
						<th style="width: 100px;">A Value</th>
						<th style="width: 100px;">B Value</th>
<!-- 						Code Ends Here Done By Roshan Tailor -->
						<th style="width: 100px;">Customer</th>
						<th>Remarks</th>
					</tr>

			</thead>
			<tbody>
			<c:forEach items="${datas}" var="map">
				
					<c:choose>
						<c:when test="${map['1'] eq 'OBJECTIVES'}">
						<tr>
							<td class="trobjrow">${map['1']}</td>
							<td class="trobjrow">N/A</td>
							<td  class="trobjrow">${map['2']}</td>
							<td  class="trobjrow">${map['3']}</td>
							<td  class="trobjrow">${map['4']}</td>
							<td  style="text-align: right;" class="trobjrow">${map['5']}</td>
							<td  style="text-align: right;" class="trobjrow"><fmt:formatNumber value="${map['6'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;" class="trobjrow"><fmt:formatNumber value="${map['7'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;"v class="trobjrow"><fmt:formatNumber value="${map['8'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;" class="trobjrow">${map['9']}</td>
							<td  style="text-align: right;" class="trobjrow">${map['10']}</td>
							<td  style="text-align: right;" class="trobjrow"><fmt:formatNumber value="${map['11'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;" class="trobjrow"><fmt:formatNumber value="${map['12'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;"class="trobjrow">${map['13']}</td>
							<td  style="text-align: right;" class="trobjrow"><fmt:formatNumber value="${map['14'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;" class="trobjrow"><fmt:formatNumber value="${map['15'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  style="text-align: right;" class="trobjrow">${map['16']}</td>
<!-- 						Code Starts From Here Done By Roshan Tailor Date ;- 03/074/2015 -->
							<td  style="text-align: right;" class="trobjrow">${map['17']} </td><!-- This Is Related To The RewindServiceImp.java -->
							<td  style="text-align: right;"class="trobjrow">${map['18']} </td><!-- This Is Related To The RewindServiceImp.java -->
							<td  style="text-align: right;"class="trobjrow">${map['19']} </td><!-- This Is Related To The RewindServiceImp.java -->
<!-- 						Code Ends Here Done By Roshan Tailor -->
							<td  class="trobjrow">N/A</td> <!-- Customer Name Will  Come Here  -->
							<td  class="trobjrow">N/A</td> <!-- Remark Name Will  Come Here  -->
							
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td>${map['1']}</td>
							<td>${map['19']}</td>
							<td>${map['2']}</td>
							<td>${map['3']}</td>
							<td>${map['4']}</td>
							<td style="text-align: right;" class="${map['5C']}"><fmt:formatNumber value="${map['5']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['6C']}"><fmt:formatNumber value="${map['6']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;"class="${map['7C']}"><fmt:formatNumber value="${map['7']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['8C']}"><fmt:formatNumber value="${map['8']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['9C']}"><fmt:formatNumber value="${map['9']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['10C']}"><fmt:formatNumber value="${map['10']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['11C']}"><fmt:formatNumber value="${map['11']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['12C']}"><fmt:formatNumber value="${map['12']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['13C']}"><fmt:formatNumber value="${map['13']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['14C']}"><fmt:formatNumber value="${map['14']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['15C']}"><fmt:formatNumber value="${map['15']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td style="text-align: right;" class="${map['16C']}"><fmt:formatNumber value="${map['16']}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<!-- 						Code Starts From Here Done By Roshan Tailor Date ;- 03/074/2015 -->
							
<!-- 							Note That The Below Mapped Value Like  ${map['23']},${map['24']},${map['25']} Are Just Columns Number Which Are Related To The 
								Columns Of The Table Only,Not To The Database Table.These Are Mapped To The ColumnsOfTable.java
 -->
							<td style="text-align: right;"><fmt:formatNumber value="${map['23']}" minFractionDigits="2" maxFractionDigits="2"/></td><!--Mapped With  ColumnsOfTable.java -->
							<td style="text-align: right;"><fmt:formatNumber value="${map['24']}" minFractionDigits="2" maxFractionDigits="2"/></td><!--Mapped With  ColumnsOfTable.java -->
							<td style="text-align: right;"><fmt:formatNumber value="${map['25']}" minFractionDigits="2" maxFractionDigits="2"/></td><!--Mapped With  ColumnsOfTable.java -->
<!-- 						Code Ends Here Done By Roshan Tailor -->
							<td>${map['26']}</td>
							<td>${map['27']}</td>
						</tr>
						</c:otherwise>
					</c:choose>
					
				
			</c:forEach>	
			</tbody>

		</table>
</div>


</body>
</html>
