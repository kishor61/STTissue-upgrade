<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

</head>
<body style="overflow: auto;">
<button onclick="history.back();">Back</button>
<table class="table" style="width: 800px;margin: auto;">
	<thead>
		<tr>
			<th style="width: 20px;"><input type="checkbox" id="checkFlag"> </th>
			<th>Reel#</th>
			<!-- <th>Date Time</th> -->
			<th>Grade Code</th>
			<!-- <th>Customer Grade Code</th> -->
			<th>Customer</th>

		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(rewdinders) gt 0 }">
			<c:forEach items="${rewdinders}" var="rw">
				<tr>
					<td align="center"><input type="checkbox" name="reel" value="${rw.reel}"> </td>
					<td style="text-align: center;">${rw.reel}</td>
					<%-- <td style="text-align: center;"><fmt:formatDate value="${rw.date}" pattern="MM-dd-yyyy"/></td> --%>
					<td style="text-align: center;">${rw.grade}</td>
					<%-- <td style="text-align: center;">${rw.custCode}</td> --%>
					<td style="text-align: center;">${rw.customer}</td>
					<%-- <td style="text-align: center;"><a href='<spring:url value="/certificateanalysis/pdf/certificate?reel=${rw.reel}&custCode=${rw.custCode}&customer=${rw.customer}&grade=${rw.grade}"/>' target="_blank">PDF</a></td> --%>
				</tr>	
			</c:forEach>
		</c:if>
		
		<c:if test="${fn:length(rewdinders) eq 0 }">
			<tr>
				<td colspan="8">Data not available for this selection.</td>
			</tr>
		</c:if>
	</tbody>
</table>
<script type="text/javascript">
$(function(){
	$('#checkFlag').click(function(){
		$('table input[name=reel]').prop('checked',$(this).prop('checked'));
	});
});

function getSelectedReel(){
	 var reels = $("input[name=reel]:checkbox:checked").map(function(){
	      return $(this).val();
	 }).get();
	 
	 return reels;
}

</script>

</body>
</html>
