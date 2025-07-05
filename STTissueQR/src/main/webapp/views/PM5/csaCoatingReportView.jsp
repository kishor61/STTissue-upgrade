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

<link type="text/css" rel="stylesheet" media="all" href="<spring:url value="/resources/css/printReport.css"/>" >

<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>



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
<span class="header-report">SCA Coating Report PM5</span>
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
						<th>Crepe Ratio</th>
						
						<th>Strech / Crepe %</th>
						<th>Bulk / BW</th>
						<th>GMT/BW</th>
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
							<td  class="trobjrow">${map['5']}</td>
							<td  class="trobjrow">${map['6']}</td>
							<td  class="trobjrow"><fmt:formatNumber value="${map['7'] - 0.0000}" maxFractionDigits="0"/></td>
							<td  class="trobjrow"><fmt:formatNumber value="${map['8'] - 0.0000}" maxFractionDigits="0"/></td>
							<td class="trobjrow"><fmt:formatNumber value="${map['9'] - 0.0000}" maxFractionDigits="0"/></td>
							<td class="trobjrow">${map['10']}</td>
							<td  class="trobjrow">${map['11']}</td>
							<td  class="trobjrow">${map['21']}</td>
							
							<td  class="trobjrow"></td>
							<td  class="trobjrow"></td>
							<td  class="trobjrow"></td>
							<td  class="trobjrow">${map['26']}</td>
							
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td>${map['1']}</td>
							<td>${map['2']}</td>
							<td><div style="width: 80px;">${map['3']}</div> </td>
							<td>${map['4']}</td>
							<td>${map['5']}</td>
							<td class="${map['6C']}">${map['6']}</td>
							<td class="${map['7C']}">${map['7']}</td>
							<td class="${map['8C']}">${map['8']}</td>
							<td class="${map['9C']}">${map['9']}</td>
							<td class="${map['10C']}">${map['10']}</td>
							<td class="${map['11C']}">${map['11']}</td>
							<td>${map['21']}</td>
								<c:set value="${map['10']/map['21']}" var="totalgradeweight"/>
							<td><fmt:formatNumber value="${totalgradeweight*100}" maxFractionDigits="2"/>%</td>
								<c:set value="${map['7']/map['6']}" var="data1"/>
							<td><fmt:formatNumber value="${data1*100}" maxFractionDigits="2"/>%</td>
							<td class="${map['11C']}">${map['27']}</td>
							<td>${map['26']}</td>	
							
						</tr>
						</c:otherwise>
					</c:choose>
					
				
			</c:forEach>	
			</tbody>

		</table>
</div>


</body>
</html>
