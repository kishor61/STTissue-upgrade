<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<div style="padding: 5px;">
	<spring:url value="/grade/view" var="viewGradeUrl" />

	<c:if test="${fn:length(result) > 0 }">
		<table class="table" style="font-size: 14px;">
			<thead>
				<tr>
					<td style="width: 80px">S.No.</td>
					<td style="width: 80px">Grade</td>
					<td style="width: 80px;">Actual Basis wt <br> lbs /3000ft
					</td>
					<td style="width: 80px;">Bulk <br> mils/8 ply
					</td>
					<td style="width: 80px;">MD Tensile <br> g/inch
					</td>
					<td style="width: 80px;">CD Tensile <br> g/inch
					</td>
					<td style="width: 80px;">MD % <br> Stretch
					</td>
					<td style="width: 80px;">MD Wet Tensile<br> g/inch
					</td>
					<td style="width: 80px;">CD Wet Tensile<br> g/inch
					</td>
					<td style="width: 80px;">Bright<br> ness %
					</td>


				</tr>
			</thead>
			<c:forEach items="${result}" var="map" varStatus="index">

				<tbody>
					<tr>

						<td>${index.index+1}</td>
						<td>
						<a href="${viewGradeUrl}/${map['1']}" target="_blank">${map['1']}</a>
						</td>
						<td>${map['2']}</td>
						<td>${map['4']}</td>
						<td>${map['5']}</td>
						<td>${map['7']}</td>
						<td>${map['9']}</td>
						<td>${map['6']}</td>
						<td>${map['8']}</td>
						<td>${map['3']}</td>

					</tr>
				</tbody>
			</c:forEach>
		</table>

	</c:if>
	<c:if test="${fn:length(result) eq 0 }">
		<h5>Record did not match.</h5>
	</c:if>
</div>